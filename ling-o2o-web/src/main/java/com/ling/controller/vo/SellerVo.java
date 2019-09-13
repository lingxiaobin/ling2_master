package com.ling.controller.vo;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商家信息表
 */
public class SellerVo {
    //店铺名称
    private String name;
    //店铺图片
    private String avatar;
    //店铺配送方式描述
    private String description;
    //多少分钟送达(平均配送时间)
    private Integer deliveryTime;
    //评分
    private float score;

    //服务态度评分
    private float serviceScore;
    //商品评分
    private float foodScore;
    //高于周边商家?%
    private float rankRate;
    //起送价
    private BigDecimal minPrice;
    //商家配送价格
    private BigDecimal deliveryPrice;
    //评论数
    private Integer ratingCount;
    //月售
    private Integer sellCount;
    //公告
    private String bulletin;
    //商家实景
    private List<String> pics;
    //商家具体信息
    private List<String> infos;


    private List<SellerSupportsVo> supports;
    private List<Object> goods;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(float serviceScore) {
        this.serviceScore = serviceScore;
    }

    public float getFoodScore() {
        return foodScore;
    }

    public void setFoodScore(float foodScore) {
        this.foodScore = foodScore;
    }

    public float getRankRate() {
        return rankRate;
    }

    public void setRankRate(float rankRate) {
        this.rankRate = rankRate;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }

    public String getPics() {
        return JSON.toJSONString(pics);
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public String getInfos() {
        return JSON.toJSONString(infos);
    }

    public void setInfos(List<String> infos) {
        this.infos = infos;
    }

    public List<SellerSupportsVo> getSupports() {
        return supports;
    }

    public void setSupports(List<SellerSupportsVo> supports) {
        this.supports = supports;
    }

    public List<Object> getGoods() {
        return goods;
    }

    public void setGoods(List<Object> goods) {
        this.goods = goods;
    }
}
