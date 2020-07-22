package com.zy.blog.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Article  implements Serializable {
    @Id
    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "article_user_id")
    private Integer articleUserId;

    @Column(name = "article_title")
    private String articleTitle;

    @Column(name = "article_view_count")
    private Integer articleViewCount;

    @Column(name = "article_comment_count")
    private Integer articleCommentCount;

    @Column(name = "article_like_count")
    private Integer articleLikeCount;

    @Column(name = "article_is_comment")
    private Integer articleIsComment;

    @Column(name = "article_status")
    private Integer articleStatus;

    @Column(name = "article_order")
    private Integer articleOrder;

    @Column(name = "article_update_time")
    private Date articleUpdateTime;

    @Column(name = "article_create_time")
    private Date articleCreateTime;

    @Column(name = "article_content")
    private String articleContent;

    @Column(name = "article_summary")
    private String articleSummary;

    @Transient
    private User user;

    @Transient
    private List<Tag> tagList;

    @Transient
    private List<Category> categoryList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * @return article_id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * @return article_user_id
     */
    public Integer getArticleUserId() {
        return articleUserId;
    }

    /**
     * @param articleUserId
     */
    public void setArticleUserId(Integer articleUserId) {
        this.articleUserId = articleUserId;
    }

    /**
     * @return article_title
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * @param articleTitle
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * @return article_view_count
     */
    public Integer getArticleViewCount() {
        return articleViewCount;
    }

    /**
     * @param articleViewCount
     */
    public void setArticleViewCount(Integer articleViewCount) {
        this.articleViewCount = articleViewCount;
    }

    /**
     * @return article_comment_count
     */
    public Integer getArticleCommentCount() {
        return articleCommentCount;
    }

    /**
     * @param articleCommentCount
     */
    public void setArticleCommentCount(Integer articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    /**
     * @return article_like_count
     */
    public Integer getArticleLikeCount() {
        return articleLikeCount;
    }

    /**
     * @param articleLikeCount
     */
    public void setArticleLikeCount(Integer articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    /**
     * @return article_is_comment
     */
    public Integer getArticleIsComment() {
        return articleIsComment;
    }

    /**
     * @param articleIsComment
     */
    public void setArticleIsComment(Integer articleIsComment) {
        this.articleIsComment = articleIsComment;
    }

    /**
     * @return article_status
     */
    public Integer getArticleStatus() {
        return articleStatus;
    }

    /**
     * @param articleStatus
     */
    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    /**
     * @return article_order
     */
    public Integer getArticleOrder() {
        return articleOrder;
    }

    /**
     * @param articleOrder
     */
    public void setArticleOrder(Integer articleOrder) {
        this.articleOrder = articleOrder;
    }

    /**
     * @return article_update_time
     */
    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    /**
     * @param articleUpdateTime
     */
    public void setArticleUpdateTime(Date articleUpdateTime) {
        this.articleUpdateTime = articleUpdateTime;
    }

    /**
     * @return article_create_time
     */
    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    /**
     * @param articleCreateTime
     */
    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    /**
     * @return article_content
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * @param articleContent
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    /**
     * @return article_summary
     */
    public String getArticleSummary() {
        return articleSummary;
    }

    /**
     * @param articleSummary
     */
    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }
}