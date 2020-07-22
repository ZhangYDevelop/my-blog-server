package com.zy.blog.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Notice {
    @Id
    @Column(name = "notice_id")
    private Integer noticeId;

    @Column(name = "notice_title")
    private String noticeTitle;

    @Column(name = "notice_content")
    private String noticeContent;

    @Column(name = "notice_create_time")
    private Date noticeCreateTime;

    @Column(name = "notice_update_time")
    private Date noticeUpdateTime;

    @Column(name = "notice_status")
    private Integer noticeStatus;

    @Column(name = "notice_order")
    private Integer noticeOrder;

    /**
     * @return notice_id
     */
    public Integer getNoticeId() {
        return noticeId;
    }

    /**
     * @param noticeId
     */
    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * @return notice_title
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * @param noticeTitle
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    /**
     * @return notice_content
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * @param noticeContent
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    /**
     * @return notice_create_time
     */
    public Date getNoticeCreateTime() {
        return noticeCreateTime;
    }

    /**
     * @param noticeCreateTime
     */
    public void setNoticeCreateTime(Date noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    /**
     * @return notice_update_time
     */
    public Date getNoticeUpdateTime() {
        return noticeUpdateTime;
    }

    /**
     * @param noticeUpdateTime
     */
    public void setNoticeUpdateTime(Date noticeUpdateTime) {
        this.noticeUpdateTime = noticeUpdateTime;
    }

    /**
     * @return notice_status
     */
    public Integer getNoticeStatus() {
        return noticeStatus;
    }

    /**
     * @param noticeStatus
     */
    public void setNoticeStatus(Integer noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    /**
     * @return notice_order
     */
    public Integer getNoticeOrder() {
        return noticeOrder;
    }

    /**
     * @param noticeOrder
     */
    public void setNoticeOrder(Integer noticeOrder) {
        this.noticeOrder = noticeOrder;
    }
}