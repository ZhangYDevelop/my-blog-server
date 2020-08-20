package com.zy.blog.server.dto;


import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author zhangyu
 * @date 2017/11/30 下午7:04
 */

public class ResultVO<T>  implements Serializable {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;


    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResultVO<T> success(T data){
        return new ResultVO<T>(HttpStatus.OK.value(),"操作成功",data);
    }

    public static <T> ResultVO<T> error(int code, String msg){
        return new ResultVO<T>(code,msg, null);
    }
}
