package com.geek.util;

/**
 * 处理结果,用于返回jackson
 * @author yuanyang
 * @version 1.0
 */
public class Result {

    private String status;  //成功失败标识,0为失败,1为成功
    private String message; //相关信息
    private int total; //存放数据库的总记录条数
    private Object data;    //相关数据


    //constructor
    public Result(){
        super();
    }

    public Result(String status,String message){
        this.status = status;
        this.message = message;
    }

    public Result(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Result(String status, String message, int total) {
        this.status = status;
        this.message = message;
        this.total = total;
    }

    //start getter and setter

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



    //end getter and setter
}
