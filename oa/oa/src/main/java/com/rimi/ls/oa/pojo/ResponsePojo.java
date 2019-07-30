package com.rimi.ls.oa.pojo;

import java.util.List;

/**
 * @Auther: Jerry
 * @Date: 2018/6/7/007 10:49
 * @Description:
 *  用来响应数据的对象
 */
public class ResponsePojo {

    //状态码
    private int code;
    // 消息
    private String msg;
    //数据的总条数
    private int   count;
    // 数据的集合
    private List data;

    public ResponsePojo() {
    }

    public ResponsePojo(List data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
