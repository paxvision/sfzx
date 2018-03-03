package com.geek.action;

import com.geek.util.MysqlDatabaseBackup;
import com.geek.util.Result;
import com.geek.util.ResultUtil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DatabaseAction {

    @Autowired
    private MysqlDatabaseBackup mysqlDatabaseBackup;

    @ResponseBody
    @RequestMapping(value = "/database/backup",method = RequestMethod.GET)
    public Result backup(HttpServletRequest request){
        String savePath = mysqlDatabaseBackup.backup();

        String message = "您成功将数据库备份在" + mysqlDatabaseBackup.getSavePath() + "目录下";
        Map<String,String> map = new HashMap<>();
        map.put("savePath",savePath);
        map.put("massage",message);
        return ResultUtil.successResult(map);
    }

    @ResponseBody
    @RequestMapping(value = "/database/restore",method = RequestMethod.POST)
    public Result restore(@RequestParam("sqlFile") MultipartFile sqlFile){
        System.out.println("multipartFile:" + sqlFile);
        mysqlDatabaseBackup.restore(sqlFile);
        String message = "您成功将备份" + sqlFile.getOriginalFilename() + "还原";
        return ResultUtil.successResult(message);
    }

}
