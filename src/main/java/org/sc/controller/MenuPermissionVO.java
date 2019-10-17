package org.sc.controller;

import java.util.LinkedList;
import java.util.List;

public class MenuPermissionVO {

    private Integer id;

    private Integer superId;

    private String name;

    private String url;

    private String icon;

    private Short type;

    private Short level;

    private Integer order;

    private Short status;

    private List<MenuPermissionVO> childPermission = new LinkedList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuperId() {
        return superId;
    }

    public void setSuperId(Integer superId) {
        this.superId = superId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public List<MenuPermissionVO> getChildPermission() {
        return childPermission;
    }

    public void setChildPermission(List<MenuPermissionVO> childPermission) {
        this.childPermission = childPermission;
    }
}
