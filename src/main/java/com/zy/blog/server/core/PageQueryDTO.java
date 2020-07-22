package com.zy.blog.server.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/***
 * @Description：分页查询参数
 * @Date 2020/5/8
 * @Author zuojie
 */
@ApiModel(description="分页查询参数")
public class PageQueryDTO implements Serializable {
    private static final long serialVersionUID = 356347073843818851L;

    @ApiModelProperty(value="页码")
    private Integer page;

    @ApiModelProperty(value="每页记录数")
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
