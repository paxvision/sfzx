package com.geek.util;

import com.geek.exception.ErrorException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 用于备份与还原数据库
 */
@Service
public class MysqlDatabaseBackup {

    //文件后缀
    private static final String EXTENSION = ".sql";
    //数据库资源文件
    private Properties properties;
    //备份目录
    private String savePath;
    //备份的文件名
    private String fileName;
    //ip地址
    private String host;
    //用户
    private String user;
    //密码
    private String password;
    //数据库
    private String database;

    public String getSavePath() {
        return savePath;
    }

    /**
     * 读取资源文件,以用于获得数据库的相关信息
     */
    public void initProperties(){
        //读取资源文件
        properties = new Properties();
        InputStream inputStream = MysqlDatabaseBackup.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 初始化文件路径,用于存放备份文件
     */
    public void initPath(){
        //创建文件夹
        savePath = "E:" + File.separator + "database" + File.separator + "backup";
        File file = new File(savePath);
        if (!file.exists()){
            file.mkdirs();
        }
    }

    /**
     * 初始化文件名,每次以备份的时间为名
     */
    public void initFile(){
        //初始化文件名
        fileName = String.valueOf(new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(new Date())) + EXTENSION;
    }

    /**
     * 初始化数据库信息,从已经生成的资源对象中获取相应的字段
     */
    public void initDatabase(){
        host = properties.getProperty("host");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        database = properties.getProperty("database");
    }

    /**
     * 执行命令行,
     * @param command
     * @return
     */
    public boolean execute(String command){
        try {
            Process process = Runtime.getRuntime().exec(command);
            //0即线程正常终止
            int i = process.waitFor();

            /*
            //用于打印错误信息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line = bufferedReader.readLine();
            while (line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }*/
            //销毁进程
            process.destroy();
            //当返回值为0时,表示进程正常结束,即备份成功
            if (i == 0){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 备份数据库
     * @return
     */
    public String backup(){
        //读取资源文件
        initProperties();
        //创建目录
        initPath();
        //初始化文件名
        initFile();
        //初始化数据库信息
        initDatabase();
        //生成执行命令
        StringBuffer command = new StringBuffer();
        command.append("mysqldump").append(" --opt").append(" -h").append(host)
                .append(" -u").append(user).append(" -p").append(password)
                .append(" --lock-all-tables=true").append(" --default-character-set=utf8")
                .append(" --result-file=").append(savePath + File.separator +  fileName)
                .append(" " + database);
        System.out.println(command.toString());
        if (!execute(command.toString())){
            throw new ErrorException("数据库备份失败");
        }
        return "/file" + File.separator +  fileName;
    }

    /**
     * 还原数据库
     * @param sqlFile 需要恢复的备份文件
     * @return
     */
    public boolean restore(MultipartFile sqlFile) {
        if (!sqlFile.getOriginalFilename().endsWith(".sql")){
            throw new ErrorException("请选择正确的数据库文件");
        }
        //读取资源文件
        initProperties();
        //初始化文件夹
        initPath();
        //初始化数据库信息
        initDatabase();
        StringBuffer command = new StringBuffer();
        command.append("mysql").append(" -h").append(host)
                .append(" -u").append(user).append(" -p").append(password)
                .append(" --default-character-set=utf8 ").append(database);

        try {
            Process process = Runtime.getRuntime().exec(command.toString());
            //选进程作为输出流
            OutputStream outputStream = process.getOutputStream();
            //读取备份文件
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sqlFile.getInputStream()));
            String line = bufferedReader.readLine();
            StringBuffer content = new StringBuffer();
            while (line != null){
                content.append(line + "\r\n");
                line = bufferedReader.readLine();
            }

            OutputStreamWriter writer = new OutputStreamWriter(outputStream,"utf-8");
            writer.write(content.toString());
            writer.flush();

            //关闭流
            outputStream.close();
            bufferedReader.close();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}