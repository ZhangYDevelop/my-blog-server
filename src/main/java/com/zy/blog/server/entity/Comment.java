package com.zy.blog.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

public class Comment {
    @Id
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "comment_pid")
    private Integer commentPid;

    @Column(name = "comment_pname")
    private String commentPname;

    @Column(name = "comment_article_id")
    private Integer commentArticleId;

    @Column(name = "comment_author_name")
    private String commentAuthorName;

    @Column(name = "comment_author_email")
    private String commentAuthorEmail;

    @Column(name = "comment_author_url")
    private String commentAuthorUrl;

    @Column(name = "comment_author_avatar")
    private String commentAuthorAvatar;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_agent")
    private String commentAgent;

    @Column(name = "comment_ip")
    private String commentIp;

    @Column(name = "comment_create_time")
    private Date commentCreateTime;

    @Column(name = "comment_role")
    private Integer commentRole;


    /**
     * 非数据库字段
     */
    @Transient
    private Article article;


    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     * @return comment_id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * @return comment_pid
     */
    public Integer getCommentPid() {
        return commentPid;
    }

    /**
     * @param commentPid
     */
    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }

    /**
     * @return comment_pname
     */
    public String getCommentPname() {
        return commentPname;
    }

    /**
     * @param commentPname
     */
    public void setCommentPname(String commentPname) {
        this.commentPname = commentPname;
    }

    /**
     * @return comment_article_id
     */
    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    /**
     * @param commentArticleId
     */
    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    /**
     * @return comment_author_name
     */
    public String getCommentAuthorName() {
        return commentAuthorName;
    }

    /**
     * @param commentAuthorName
     */
    public void setCommentAuthorName(String commentAuthorName) {
        this.commentAuthorName = commentAuthorName;
    }

    /**
     * @return comment_author_email
     */
    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    /**
     * @param commentAuthorEmail
     */
    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    /**
     * @return comment_author_url
     */
    public String getCommentAuthorUrl() {
        return commentAuthorUrl;
    }

    /**
     * @param commentAuthorUrl
     */
    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl;
    }

    /**
     * @return comment_author_avatar
     */
    public String getCommentAuthorAvatar() {
        return commentAuthorAvatar;
    }

    /**
     * @param commentAuthorAvatar
     */
    public void setCommentAuthorAvatar(String commentAuthorAvatar) {
        this.commentAuthorAvatar = commentAuthorAvatar;
    }

    /**
     * @return comment_content
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * @param commentContent
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * @return comment_agent
     */
    public String getCommentAgent() {
        return commentAgent;
    }

    /**
     * @param commentAgent
     */
    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    /**
     * @return comment_ip
     */
    public String getCommentIp() {
        return commentIp;
    }

    /**
     * @param commentIp
     */
    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }

    /**
     * @return comment_create_time
     */
    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    /**
     * @param commentCreateTime
     */
    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    /**
     * @return comment_role
     */
    public Integer getCommentRole() {
        return commentRole;
    }

    /**
     * @param commentRole
     */
    public void setCommentRole(Integer commentRole) {
        this.commentRole = commentRole;
    }
}