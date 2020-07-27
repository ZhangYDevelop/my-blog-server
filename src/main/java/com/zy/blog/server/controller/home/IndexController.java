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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam("keywords") String keywords,
            @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize, Model model) {
        //文章列表
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        criteria.put("keywords", keywords);
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo", articlePageInfo);
        return  ResponseEntity.ok(articlePageInfo);
    }

}




