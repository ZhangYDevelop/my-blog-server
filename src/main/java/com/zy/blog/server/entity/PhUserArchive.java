package com.zy.blog.server.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "ph_user_archive")
public class PhUserArchive {
    /**
     * 主键ID
     */
    @Id
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户档案唯一索引
     */
    @Column(name = "key_no")
    private String keyNo;

    /**
     * 用户动态档案索引
     */
    @Column(name = "busi_no")
    private String busiNo;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户档案唯一索引
     *
     * @return key_no - 用户档案唯一索引
     */
    public String getKeyNo() {
        return keyNo;
    }

    /**
     * 设置用户档案唯一索引
     *
     * @param keyNo 用户档案唯一索引
     */
    public void setKeyNo(String keyNo) {
        this.keyNo = keyNo;
    }

    /**
     * 获取用户动态档案索引
     *
     * @return busi_no - 用户动态档案索引
     */
    public String getBusiNo() {
        return busiNo;
    }

    /**
     * 设置用户动态档案索引
     *
     * @param busiNo 用户动态档案索引
     */
    public void setBusiNo(String busiNo) {
        this.busiNo = busiNo;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}