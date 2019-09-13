package com.ling.enity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 * 商家支持的服务信息表
 */
@Entity
@Table(name = "seller_supports")
public class SellerSupports implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "id", nullable = false)
    private Long id;

    //    @Column(columnDefinition = "COMMENT '支持服务的类型' 1,折扣 2,服务'")
    private Integer supportsType;

    //    @Column(columnDefinition = "COMMENT '折扣类型'")
    private Integer discountsType;

    //活动具体描述
//    @Column(columnDefinition = "COMMENT '具体描述'")
    private String description;

    @ManyToMany(mappedBy = "sellerSupportsList")
    private List<Seller> SellerList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSupportsType() {
        return supportsType;
    }

    public void setSupportsType(Integer supportsType) {
        this.supportsType = supportsType;
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

    public List<Seller> getSellerList() {
        return SellerList;
    }

    public void setSellerList(List<Seller> sellerList) {
        SellerList = sellerList;
    }
}
