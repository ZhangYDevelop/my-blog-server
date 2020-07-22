package com.zy.blog.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Link {
    @Id
    @Column(name = "link_id")
    private Integer linkId;

    @Column(name = "link_url")
    private String linkUrl;

    @Column(name = "link_name")
    private String linkName;

    @Column(name = "link_image")
    private String linkImage;

    @Column(name = "link_description")
    private String linkDescription;

    @Column(name = "link_owner_nickname")
    private String linkOwnerNickname;

    @Column(name = "link_owner_contact")
    private String linkOwnerContact;

    @Column(name = "link_update_time")
    private Date linkUpdateTime;

    @Column(name = "link_create_time")
    private Date linkCreateTime;

    @Column(name = "link_order")
    private Integer linkOrder;

    @Column(name = "link_status")
    private Integer linkStatus;

    /**
     * @return link_id
     */
    public Integer getLinkId() {
        return linkId;
    }

    /**
     * @param linkId
     */
    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    /**
     * @return link_url
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * @param linkUrl
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * @return link_name
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * @param linkName
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    /**
     * @return link_image
     */
    public String getLinkImage() {
        return linkImage;
    }

    /**
     * @param linkImage
     */
    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    /**
     * @return link_description
     */
    public String getLinkDescription() {
        return linkDescription;
    }

    /**
     * @param linkDescription
     */
    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    /**
     * @return link_owner_nickname
     */
    public String getLinkOwnerNickname() {
        return linkOwnerNickname;
    }

    /**
     * @param linkOwnerNickname
     */
    public void setLinkOwnerNickname(String linkOwnerNickname) {
        this.linkOwnerNickname = linkOwnerNickname;
    }

    /**
     * @return link_owner_contact
     */
    public String getLinkOwnerContact() {
        return linkOwnerContact;
    }

    /**
     * @param linkOwnerContact
     */
    public void setLinkOwnerContact(String linkOwnerContact) {
        this.linkOwnerContact = linkOwnerContact;
    }

    /**
     * @return link_update_time
     */
    public Date getLinkUpdateTime() {
        return linkUpdateTime;
    }

    /**
     * @param linkUpdateTime
     */
    public void setLinkUpdateTime(Date linkUpdateTime) {
        this.linkUpdateTime = linkUpdateTime;
    }

    /**
     * @return link_create_time
     */
    public Date getLinkCreateTime() {
        return linkCreateTime;
    }

    /**
     * @param linkCreateTime
     */
    public void setLinkCreateTime(Date linkCreateTime) {
        this.linkCreateTime = linkCreateTime;
    }

    /**
     * @return link_order
     */
    public Integer getLinkOrder() {
        return linkOrder;
    }

    /**
     * @param linkOrder
     */
    public void setLinkOrder(Integer linkOrder) {
        this.linkOrder = linkOrder;
    }

    /**
     * @return link_status
     */
    public Integer getLinkStatus() {
        return linkStatus;
    }

    /**
     * @param linkStatus
     */
    public void setLinkStatus(Integer linkStatus) {
        this.linkStatus = linkStatus;
    }
}