package com.zy.blog.server.service;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR zhangy
 * 2020-08-27  21:33
 * 文章浏览记录
 */
public interface ArticleViewService {

    /**
     * 增加文章浏览记录
     * @param articleView
     * @return
     */
    Integer addArticleView(Integer articleView);

    List<Map> getArticleTongji();
}
