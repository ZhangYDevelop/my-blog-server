package com.zy.blog.server.controller.home;

import com.zy.blog.server.entity.Article;
import com.zy.blog.server.entity.Notice;
import com.zy.blog.server.enums.NoticeStatus;
import com.zy.blog.server.service.ArticleService;
import com.zy.blog.server.service.NoticeService;
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
 */
@RestController
@Api(value = "/home", tags = "博客公告API")
@RequestMapping("/home")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    /**
     * 公告详情页显示
     *
     * @param noticeId
     * @return
     */
    @ApiOperation("公告详情页显示")
    @RequestMapping(value = "/notice/{noticeId}")
    public ResponseEntity<Notice> NoticeDetailView(@PathVariable("noticeId") Integer noticeId) {
        //公告内容和信息显示
        Notice notice  = noticeService.getNoticeById(noticeId);

        return ResponseEntity.ok(notice);
    }


    /**
     * 所有公告
     * @return
     */
    @ApiOperation("所有公告")
    @RequestMapping(value = "/notice/listNotice")
    public ResponseEntity<List<Notice>> listNotice() {
        //公告
        List<Notice> noticeList = noticeService.listNotice(NoticeStatus.NORMAL.getValue());
        return ResponseEntity.ok(noticeList);
    }

}
