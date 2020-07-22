package com.zy.blog.server.controller.home;




import com.zy.blog.server.entity.Article;
import com.zy.blog.server.entity.Category;
import com.zy.blog.server.entity.Page;
import com.zy.blog.server.entity.Tag;
import com.zy.blog.server.service.ArticleService;
import com.zy.blog.server.service.CategoryService;
import com.zy.blog.server.service.PageService;
import com.zy.blog.server.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangyu
 * @date 2017/9/7
 */
@RestController
@RequestMapping("/home")
@Api(value = "/home", tags = "页面API")
public class PageController {

    /**
     * 留言板
     *
     * @return
     */
    @ApiOperation("留言板")
    @RequestMapping(value = "/message")
    public ResponseEntity message() {
        return ResponseEntity.ok(null);
    }
}
