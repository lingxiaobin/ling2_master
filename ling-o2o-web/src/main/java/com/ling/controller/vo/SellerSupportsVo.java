package com.ling.controller.vo;

import javax.persistence.*;
import java.util.List;

/**
 * 商家支持的服务信息表
 */

public class SellerSupportsVo {

    private Integer id;

    //    @Column(columnDefinition = "COMMENT '支持服务的类型' 1,折扣 2,服务'")
    private Integer type;

    //    @Column(columnDefinition = "COMMENT '折扣类型'")
    private Integer discountsType;

    //活动具体描述
//    @Column(columnDefinition = "COMMENT '具体描述'")
    private String description;

    private List<SellerVo> SellerList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDiscountsType() {
        return discountsType;
    }

    public void setDiscountsType(Integer discountsType) {
        this.discountsType = discountsType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SellerVo> getSellerList() {
        return SellerList;
    }

    public void setSellerList(List<SellerVo> sellerList) {
        SellerList = sellerList;
    }
}
