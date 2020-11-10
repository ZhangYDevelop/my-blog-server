package com.zy.blog.server.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zy.blog.server.entity.Article;
import com.zy.blog.server.entity.Comment;
import com.zy.blog.server.entity.User;
import com.zy.blog.server.enums.ArticleStatus;
import com.zy.blog.server.service.ArticleService;
import com.zy.blog.server.service.CommentService;
import com.zy.blog.server.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import static com.zy.blog.server.util.MyUtils.getIpAddr;

/**
 * @author zhangyu
 */
@RestController
@SuppressWarnings("all")
public class AdminController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RestTemplate restTemplate;



    @ApiOperation("首页获取所有文章")
    @RequestMapping(value = "/admin/index")
    public ResponseEntity<PageInfo<Article>> index(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                                   @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        HashMap<String, Object> criteria = new HashMap<>(1);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        //文章列表
        PageInfo<Article> articleList = articleService.pageArticle(pageIndex, pageSize, criteria);
        return ResponseEntity.ok(articleList);
    }


    /**
     * 登录验证
     *
     * @return
     */
    @PostMapping(value = "/user/login")
    public ResponseEntity loginVerify(@RequestBody Map<String, String> map, HttpServletRequest req)  {
        String username = map.get("username");
        String password = map.get("password");

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        param.add("grant_type", "password");
        param.add("scope", "web");
        param.add("username", username);
        param.add("password", password);
        param.add("client_id", "client1");
        param.add("client_secret", "admin");
        HttpMethod httpMethod = HttpMethod.POST;
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity entity = new HttpEntity(param, httpHeaders);
        ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/server/oauth/token", httpMethod,entity, Object.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/admin/logout")
    public String logout(HttpSession session)  {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }


}
