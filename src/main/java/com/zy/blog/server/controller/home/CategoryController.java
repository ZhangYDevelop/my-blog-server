package com.zy.blog.server.controller.home;


import com.github.pagehelper.PageInfo;
import com.zy.blog.server.entity.Article;
import com.zy.blog.server.entity.Category;
import com.zy.blog.server.entity.Tag;
import com.zy.blog.server.enums.ArticleStatus;
import com.zy.blog.server.service.ArticleService;
import com.zy.blog.server.service.CategoryService;
import com.zy.blog.server.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * 文章分类目录的controller
 *
 * @author zhangyu
 * @date 2017/8/24
 */
@RestController
@RequestMapping("/home")
@Api(value = "/home", tags = "文章分类目录API")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;


    /**
     * 根据分类查询文章
     *
     * @param cateId 分类ID
     * @return 模板
     */
    @ApiOperation("根据分类查询文章")
    @RequestMapping("/category/{cateId}")
    public ResponseEntity<PageInfo<Article>> getArticleListByCategory(@PathVariable("cateId") Integer cateId,
                                                   @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                                   @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        //该分类信息
        Category category = categoryService.getCategoryById(cateId);
        if (category == null) {
            return ResponseEntity.ok(null);
        }

        //文章列表
        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("categoryId", cateId);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        return ResponseEntity.ok(articlePageInfo);
    }

    @ApiOperation("查询所文章分类")
    @RequestMapping(value = "/category/map")
    public ResponseEntity< List<Category>> siteMap() {
        List<Category> categoryList = categoryService.listCategory();
        return ResponseEntity.ok(categoryList);
    }

}
