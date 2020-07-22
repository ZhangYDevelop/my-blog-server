package com.zy.blog.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Options {
    @Id
    @Column(name = "option_id")
    private Integer optionId;

    @Column(name = "option_site_title")
    private String optionSiteTitle;

    @Column(name = "option_site_descrption")
    private String optionSiteDescrption;

    @Column(name = "option_meta_descrption")
    private String optionMetaDescrption;

    @Column(name = "option_meta_keyword")
    private String optionMetaKeyword;

    @Column(name = "option_aboutsite_avatar")
    private String optionAboutsiteAvatar;

    @Column(name = "option_aboutsite_title")
    private String optionAboutsiteTitle;

    @Column(name = "option_aboutsite_content")
    private String optionAboutsiteContent;

    @Column(name = "option_aboutsite_wechat")
    private String optionAboutsiteWechat;

    @Column(name = "option_aboutsite_qq")
    private String optionAboutsiteQq;

    @Column(name = "option_aboutsite_github")
    private String optionAboutsiteGithub;

    @Column(name = "option_aboutsite_weibo")
    private String optionAboutsiteWeibo;

    @Column(name = "option_tongji")
    private String optionTongji;

    @Column(name = "option_status")
    private Integer optionStatus;

    /**
     * @return option_id
     */
    public Integer getOptionId() {
        return optionId;
    }

    /**
     * @param optionId
     */
    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    /**
     * @return option_site_title
     */
    public String getOptionSiteTitle() {
        return optionSiteTitle;
    }

    /**
     * @param optionSiteTitle
     */
    public void setOptionSiteTitle(String optionSiteTitle) {
        this.optionSiteTitle = optionSiteTitle;
    }

    /**
     * @return option_site_descrption
     */
    public String getOptionSiteDescrption() {
        return optionSiteDescrption;
    }

    /**
     * @param optionSiteDescrption
     */
    public void setOptionSiteDescrption(String optionSiteDescrption) {
        this.optionSiteDescrption = optionSiteDescrption;
    }

    /**
     * @return option_meta_descrption
     */
    public String getOptionMetaDescrption() {
        return optionMetaDescrption;
    }

    /**
     * @param optionMetaDescrption
     */
    public void setOptionMetaDescrption(String optionMetaDescrption) {
        this.optionMetaDescrption = optionMetaDescrption;
    }

    /**
     * @return option_meta_keyword
     */
    public String getOptionMetaKeyword() {
        return optionMetaKeyword;
    }

    /**
     * @param optionMetaKeyword
     */
    public void setOptionMetaKeyword(String optionMetaKeyword) {
        this.optionMetaKeyword = optionMetaKeyword;
    }

    /**
     * @return option_aboutsite_avatar
     */
    public String getOptionAboutsiteAvatar() {
        return optionAboutsiteAvatar;
    }

    /**
     * @param optionAboutsiteAvatar
     */
    public void setOptionAboutsiteAvatar(String optionAboutsiteAvatar) {
        this.optionAboutsiteAvatar = optionAboutsiteAvatar;
    }

    /**
     * @return option_aboutsite_title
     */
    public String getOptionAboutsiteTitle() {
        return optionAboutsiteTitle;
    }

    /**
     * @param optionAboutsiteTitle
     */
    public void setOptionAboutsiteTitle(String optionAboutsiteTitle) {
        this.optionAboutsiteTitle = optionAboutsiteTitle;
    }

    /**
     * @return option_aboutsite_content
     */
    public String getOptionAboutsiteContent() {
        return optionAboutsiteContent;
    }

    /**
     * @param optionAboutsiteContent
     */
    public void setOptionAboutsiteContent(String optionAboutsiteContent) {
        this.optionAboutsiteContent = optionAboutsiteContent;
    }

    /**
     * @return option_aboutsite_wechat
     */
    public String getOptionAboutsiteWechat() {
        return optionAboutsiteWechat;
    }

    /**
     * @param optionAboutsiteWechat
     */
    public void setOptionAboutsiteWechat(String optionAboutsiteWechat) {
        this.optionAboutsiteWechat = optionAboutsiteWechat;
    }

    /**
     * @return option_aboutsite_qq
     */
    public String getOptionAboutsiteQq() {
        return optionAboutsiteQq;
    }

    /**
     * @param optionAboutsiteQq
     */
    public void setOptionAboutsiteQq(String optionAboutsiteQq) {
        this.optionAboutsiteQq = optionAboutsiteQq;
    }

    /**
     * @return option_aboutsite_github
     */
    public String getOptionAboutsiteGithub() {
        return optionAboutsiteGithub;
    }

    /**
     * @param optionAboutsiteGithub
     */
    public void setOptionAboutsiteGithub(String optionAboutsiteGithub) {
        this.optionAboutsiteGithub = optionAboutsiteGithub;
    }

    /**
     * @return option_aboutsite_weibo
     */
    public String getOptionAboutsiteWeibo() {
        return optionAboutsiteWeibo;
    }

    /**
     * @param optionAboutsiteWeibo
     */
    public void setOptionAboutsiteWeibo(String optionAboutsiteWeibo) {
        this.optionAboutsiteWeibo = optionAboutsiteWeibo;
    }

    /**
     * @return option_tongji
     */
    public String getOptionTongji() {
        return optionTongji;
    }

    /**
     * @param optionTongji
     */
    public void setOptionTongji(String optionTongji) {
        this.optionTongji = optionTongji;
    }

    /**
     * @return option_status
     */
    public Integer getOptionStatus() {
        return optionStatus;
    }

    /**
     * @param optionStatus
     */
    public void setOptionStatus(Integer optionStatus) {
        this.optionStatus = optionStatus;
    }
}