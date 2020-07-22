package com.zy.blog.server.controller.home;

import com.github.pagehelper.PageInfo;
import com.zy.blog.server.entity.Article;
import com.zy.blog.server.entity.Tag;
import com.zy.blog.server.enums.ArticleStatus;
import com.zy.blog.server.service.ArticleService;
import com.zy.blog.server.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhangyu
 * @date 2017/9/2
 */
@RestController
@RequestMapping("/home")
@Api(value = "/home", tags = "标签API")
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleService articleService;

    /**
     * 根据标签查询文章
     *
     * @param tagId 标签ID
     * @return 模板
     */
    @ApiOperation("根据标签查询文章")
    @RequestMapping("/tag/{tagId}")
    public ResponseEntity<PageInfo<Article>> getArticleListByTag(@PathVariable("tagId") Integer tagId,
                                      @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                      Model model) {
        //该标签信息
        Tag tag = tagService.getTagById(tagId);
        if (tag == null) {
            ResponseEntity.ok(null);
        }
        model.addAttribute("tag", tag);

        //文章列表
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("tagId", tagId);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo", articlePageInfo);

        return ResponseEntity.ok(articlePageInfo);
    }


    /**
     * 标签列表显示
     */
    @ApiOperation("标签列表显示")
    @GetMapping(value = "/tag/allTagList")
    public ResponseEntity<List<Tag>> getPreArticle() {
        List<Tag> allTagList = tagService.listTag();
        return  ResponseEntity.ok(allTagList);
    }
}
