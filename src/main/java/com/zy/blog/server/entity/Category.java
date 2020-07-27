package com.zy.blog.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

public class Category {

    public Category() {
    }

    public Category(Integer categoryId, Integer categoryPid, String categoryName, String categoryDescription, Integer categoryOrder, String categoryIcon, Integer articleCount) {
        this.categoryId = categoryId;
        this.categoryPid = categoryPid;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryOrder = categoryOrder;
        this.categoryIcon = categoryIcon;
        this.articleCount = articleCount;
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(Integer categoryId) {
        this.categoryId = categoryId;
    }
    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_pid")
    private Integer categoryPid;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_description")
    private String categoryDescription;

    @Column(name = "category_order")
    private Integer categoryOrder;

    @Column(name = "category_icon")
    private String categoryIcon;


    /**
     * 文章数量(非数据库字段)
     */
    @Transient
    private Integer articleCount;

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    /**
     * @return category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return category_pid
     */
    public Integer getCategoryPid() {
        return categoryPid;
    }

    /**
     * @param categoryPid
     */
    public void setCategoryPid(Integer categoryPid) {
        this.categoryPid = categoryPid;
    }

    /**
     * @return category_name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return category_description
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * @param categoryDescription
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    /**
     * @return category_order
     */
    public Integer getCategoryOrder() {
        return categoryOrder;
    }

    /**
     * @param categoryOrder
     */
    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    /**
     * @return category_icon
     */
    public String getCategoryIcon() {
        return categoryIcon;
    }

    /**
     * @param categoryIcon
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    /**
     * 未分类
     *
     * @return 分类
     */
    public static Category Default() {
        return new Category(100000000, "未分类");
    }
}
