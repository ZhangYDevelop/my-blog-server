package com.zy.blog.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "article_tag_ref")
public class ArticleTagRef {
    @Id
    @Column(name = "article_id")
    private Integer articleId;

    @Id
    @Column(name = "tag_id")
    private Integer tagId;

    public ArticleTagRef() {
    }

    public ArticleTagRef(Integer articleId, Integer tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
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
     * @return tag_id
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * @param tagId
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}