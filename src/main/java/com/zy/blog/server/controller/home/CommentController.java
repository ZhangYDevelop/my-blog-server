package com.zy.blog.server.controller.home;

import cn.hutool.http.HtmlUtil;
import com.zy.blog.server.dto.JsonResult;
import com.zy.blog.server.entity.Article;
import com.zy.blog.server.entity.Comment;
import com.zy.blog.server.enums.ArticleStatus;
import com.zy.blog.server.enums.Role;
import com.zy.blog.server.service.ArticleService;
import com.zy.blog.server.service.CommentService;
import com.zy.blog.server.util.MyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author zhangyu
 * @date 2017/9/10
 */

@RestController
@RequestMapping("/home")
@Api(value = "/home", tags = "文章评论API")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    /**
     * '添加评论
     *
     * @param request
     * @param comment
     */
    @ApiOperation("添加评论")
    @RequestMapping(value = "/comment", method = {RequestMethod.POST})
    public ResponseEntity insertComment(HttpServletRequest request, Comment comment) {
        //添加评论
        comment.setCommentCreateTime(new Date());
        comment.setCommentIp(MyUtils.getIpAddr(request));
        if (request.getSession().getAttribute("user") != null) {
            comment.setCommentRole(Role.ADMIN.getValue());
        } else {
            comment.setCommentRole(Role.VISITOR.getValue());
        }
        comment.setCommentAuthorAvatar(MyUtils.getGravatar(comment.getCommentAuthorEmail()));

        //过滤字符，防止XSS攻击
        comment.setCommentContent(HtmlUtil.escape(comment.getCommentContent()));
        comment.setCommentAuthorName(HtmlUtil.escape(comment.getCommentAuthorName()));
        comment.setCommentAuthorEmail(HtmlUtil.escape(comment.getCommentAuthorEmail()));
        comment.setCommentAuthorUrl(HtmlUtil.escape(comment.getCommentAuthorUrl()));
        try {
            commentService.insertComment(comment);
            //更新文章的评论数
            Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), comment.getCommentArticleId());
            articleService.updateCommentCount(article.getArticleId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("添加失败");
        }
        return ResponseEntity.ok("添加成功");
    }

    /**
     * 文章详情页评论
     * @param articleId 文章ID
     */
    @ApiOperation("文章详情页评论")
    @GetMapping(value = "/comment/{articleId}")
    public ResponseEntity<List<Comment>> getArticleCommentList(@PathVariable("articleId") Integer articleId) {
        //评论列表
        List<Comment> commentList = commentService.listCommentByArticleId(articleId);
        return  ResponseEntity.ok(commentList);
    }


    /**
     * 最近评论
     */
    @ApiOperation("最近评论")
    @GetMapping(value = "/comment/recentComment")
    public ResponseEntity< List<Comment>> listRecentComment() {
        //评论列表
        List<Comment> recentCommentList = commentService.listRecentComment(10);
        return  ResponseEntity.ok(recentCommentList);
    }


}
