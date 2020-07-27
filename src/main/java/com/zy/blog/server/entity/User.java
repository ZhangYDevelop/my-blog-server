package com.zy.blog.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

public class User {
    @Id
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "user_nickname")
    private String userNickname;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_url")
    private String userUrl;

    @Column(name = "user_avatar")
    private String userAvatar;

    @Column(name = "user_last_login_ip")
    private String userLastLoginIp;

    @Column(name = "user_register_time")
    private Date userRegisterTime;

    @Column(name = "user_last_login_time")
    private Date userLastLoginTime;

    @Column(name = "user_status")
    private Integer userStatus;

    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    private String roles;


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * 文章数量（不是数据库字段）
     */
    @Transient
    private Integer articleCount;

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return user_nickname
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * @param userNickname
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return user_url
     */
    public String getUserUrl() {
        return userUrl;
    }

    /**
     * @param userUrl
     */
    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    /**
     * @return user_avatar
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * @param userAvatar
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    /**
     * @return user_last_login_ip
     */
    public String getUserLastLoginIp() {
        return userLastLoginIp;
    }

    /**
     * @param userLastLoginIp
     */
    public void setUserLastLoginIp(String userLastLoginIp) {
        this.userLastLoginIp = userLastLoginIp;
    }

    /**
     * @return user_register_time
     */
    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    /**
     * @param userRegisterTime
     */
    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    /**
     * @return user_last_login_time
     */
    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    /**
     * @param userLastLoginTime
     */
    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    /**
     * @return user_status
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
}
