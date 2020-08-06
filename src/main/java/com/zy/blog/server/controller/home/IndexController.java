package com.zy.blog.server.controller.home;

import com.github.pagehelper.PageInfo;
import com.zy.blog.server.entity.*;
import com.zy.blog.server.enums.ArticleStatus;
import com.zy.blog.server.enums.LinkStatus;
import com.zy.blog.server.enums.NoticeStatus;
import com.zy.blog.server.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用户的controller
 *
 * @author zhangyu
 * @date 2017/8/24
 */
@RestController
@Api(value = "/home", tags = "博客首页API")
@RequestMapping("/home")
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private OptionsService optionsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;



    @ApiOperation("首页获取所有文章")
    @RequestMapping(value = "/index")
    public ResponseEntity< PageInfo<Article>> index(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        HashMap<String, Object> criteria = new HashMap<>(1);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        //文章列表
        PageInfo<Article> articleList = articleService.pageArticle(pageIndex, pageSize, criteria);

        return ResponseEntity.ok(articleList);
    }

    @ApiOperation("根据关键字搜索文章")
    @RequestMapping(value = "/index/search")
    public ResponseEntity< PageInfo<Article>> search(
            @RequestParam("keywords") String keywords, @RequestParam("categoryId") String categoryId,
            @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        //文章列表
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        if (!StringUtils.isEmpty(keywords)) {
            criteria.put("keywords", keywords);
        }
        if (!StringUtils.isEmpty(categoryId)) {
            criteria.put("categoryId", categoryId);
        }
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        return  ResponseEntity.ok(articlePageInfo);
    }

    @ApiOperation("获取网站基本信息")
    @RequestMapping(value = "/options")
    public  ResponseEntity<Options> getOptions() {
        Options options =  optionsService.getOptions();

        return ResponseEntity.ok(options);
    }

    @ApiOperation("获取网站概况")
    @RequestMapping(value = "/siteGk")
    public ResponseEntity<List<Object>> getSiteGaiKuang() {
        //获得网站概况
        List<Object> siteBasicStatistics = new ArrayList<>();
        siteBasicStatistics.add(articleService.countArticle(ArticleStatus.PUBLISH.getValue()) );
        siteBasicStatistics.add(articleService.countArticleComment() );
        siteBasicStatistics.add(categoryService.countCategory() );
        siteBasicStatistics.add(tagService.countTag() );
        siteBasicStatistics.add(articleService.countArticleView() );

        //最后更新的文章
        siteBasicStatistics.add(articleService.getLastUpdateArticle().getArticleUpdateTime());
        return ResponseEntity.ok(siteBasicStatistics);
    }

}




