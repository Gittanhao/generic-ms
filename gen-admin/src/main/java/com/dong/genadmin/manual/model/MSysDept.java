package com.dong.genadmin.manual.model;

import java.util.Date;
import java.util.List;

/**
 * 需要自定义的实体类，
 * 在数据库字段的基础上添加了非数据库字段，
 * 根据非数据库字段构建机构树
 */
public class MSysDept {
    private Long id;

    private String name;

    private Long parentId;

    private Integer orderNum;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Byte delFlag;

    // 非数据库字段
    private List<MSysDept> children;
    // 非数据库字段
    private String parentName;
    // 非数据库字段
    private Integer level;

    public List<MSysDept> getChildren() {
        return children;
    }

    public void setChildren(List<MSysDept> children) {
        this.children = children;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public MSysDept(Long id, String name, Long parentId, Integer orderNum, String createBy, Date createTime, String lastUpdateBy, Date lastUpdateTime, Byte delFlag) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.orderNum = orderNum;
        this.createBy = createBy;
        this.createTime = createTime;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateTime = lastUpdateTime;
        this.delFlag = delFlag;
    }

    public MSysDept() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}