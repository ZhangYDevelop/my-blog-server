package com.zy.blog.server.dto;


import java.io.Serializable;

/**
 * @author zhangyu
 * @date 2017/11/30 下午7:41
 */

public class UploadFileVO  implements Serializable {

    private String src;

    private String title;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
