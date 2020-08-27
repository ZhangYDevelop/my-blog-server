package com.zy.blog.server.service.impl;

import com.zy.blog.server.entity.ArticleView;
import com.zy.blog.server.mapper.ArticleViewMapper;
import com.zy.blog.server.service.ArticleViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR zhangy
 * 2020-08-27  21:34
 */
@Service
public class ArticleViewServiceImpl implements ArticleViewService {

    @Autowired
    private ArticleViewMapper articleViewMapper;

    @Transactional
    @Override
    public Integer addArticleView(Integer articleId) {
        ArticleView view = new ArticleView();
        view.setArticleId(articleId);
        view.setCreateTime(new Date());
        Integer integer =  articleViewMapper.insert(view);
        return integer;
    }

    @Override
    public List<Map> getArticleTongji() {

        return articleViewMapper.getArticleTongji();
    }
}
