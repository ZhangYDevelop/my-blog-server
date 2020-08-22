package com.zy.blog.server.controller.home;


import com.alibaba.fastjson.JSON;
import com.zy.blog.server.entity.Article;
import com.zy.blog.server.entity.Comment;
import com.zy.blog.server.entity.Tag;
import com.zy.blog.server.entity.User;
import com.zy.blog.server.enums.ArticleStatus;
import com.zy.blog.server.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章的controller
 *
 * @author zhangyu
 * @date 2017/8/24
 */
@RestController
@RequestMapping("/home")
@Api(value = "/home", tags = "文章API")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    /**
     * 获得热评文章
     */
    @GetMapping(value = "/article/mostCommentArticleList")
    @ApiOperation("获得热评文章")
    public ResponseEntity< List<Article>> mostCommentArticleList() {
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
        return  ResponseEntity.ok(mostCommentArticleList);
    }

    /**
     * 获得随机文章
     */
    @ApiOperation("获得随机文章")
    @GetMapping(value = "/article/randomArticleList")
    public ResponseEntity< List<Article>> randomArticleList() {
        List<Article> randomArticleList = articleService.listRandomArticle(8);
        return  ResponseEntity.ok(randomArticleList);
    }



    /**
     * 获取下一篇文章
     * @param articleId 文章ID
     */
    @ApiOperation("获取下一篇文章")
    @GetMapping(value = "/article/getPreArticle/{articleId}")
    public ResponseEntity<Article> getPreArticle(@PathVariable("articleId") Integer articleId) {
        //获取下一篇文章
        Article afterArticle = articleService.getAfterArticle(articleId);
        return  ResponseEntity.ok(afterArticle);
    }

    /**
     * 获取上一篇文章
     * @param articleId 文章ID
     */
    @ApiOperation("获取上一篇文章")
    @GetMapping(value = "/article/getAfterArticle/{articleId}")
    public ResponseEntity<Article> getAfterArticle(@PathVariable("articleId") Integer articleId) {
        Article preArticle = articleService.getPreArticle(articleId);
        return  ResponseEntity.ok(preArticle);
    }

    /**
     * 文章详情页相关文章
     * @param articleId 文章ID
     */
    @ApiOperation("文章详情页相关文章")
    @GetMapping(value = "/article/similarArticleList/{articleId}")
    public ResponseEntity<List<Article>> getArticleSimilarArticleList(@PathVariable("articleId") Integer articleId) {
        //相关文章
        List<Integer> categoryIds = articleService.listCategoryIdByArticleId(articleId);
        List<Article> similarArticleList = articleService.listArticleByCategoryIds(categoryIds, 5);
        return  ResponseEntity.ok(similarArticleList);
    }



    /**
     * 文章详情页显示
     * @param articleId 文章ID
     */
    @ApiOperation("文章详情页显示")
    @GetMapping(value = "/article/detail/{articleId}")
    public ResponseEntity<Article> getArticleDetail(@PathVariable("articleId") Integer articleId) {

        //文章信息，分类，标签，作者，评论
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), articleId);
        //用户信息
//        User user = userService.getUserById(article.getArticleUserId());
//        article.setUser(user);
        return  ResponseEntity.ok(article);
    }

    /**
     * 点赞增加
     *
     * @param id 文章ID
     * @return 点赞量数量
     */
    @ApiOperation("点赞量数量")
    @GetMapping(value = "/article/like/{id}/{type}")
    public ResponseEntity<String> increaseLikeCount(@PathVariable("id") Integer id, @PathVariable("type") Integer type) {
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
        int articleCount = 0;
        if (1 == type.intValue()) {
             articleCount = article.getArticleLikeCount() + 1;
             article.setArticleLikeCount(articleCount);
        }
        if (0 == type.intValue()) {
            articleCount = article.getArticleLikeCount() - 1;
            article.setArticleLikeCount(articleCount);
        }
        articleService.updateArticle(article);
        return ResponseEntity.ok(JSON.toJSONString(articleCount));
    }

    /**
     * 文章访问量数增加
     *
     * @param id 文章ID
     * @return 访问量数量
     */
    @ApiOperation("文章访问量数增加")
    @GetMapping(value = "/article/view/{id}")
    public ResponseEntity<String> increaseViewCount(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
        Integer articleCount = article.getArticleViewCount() + 1;
        article.setArticleViewCount(articleCount);
        articleService.updateArticle(article);
        return ResponseEntity.ok(JSON.toJSONString(articleCount));
    }


    /**
     * 文章归档页面显示和站点地图显示
     *
     * @return
     */
    @ApiOperation("文章归档页面显示")
    @RequestMapping(value = "/article/articleFileOrMap")
    public ResponseEntity<  List<Article>> articleFile(Model model) {
        List<Article> articleList = articleService.listAllNotWithContent();
        model.addAttribute("articleList", articleList);
        return ResponseEntity.ok(articleList);
    }



}
