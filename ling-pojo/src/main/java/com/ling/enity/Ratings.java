package com.ling.enity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
/**
 * 评论
 */
@Entity
@Table(name = "ratings")
public class Ratings implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    //用户名称
    private String username;
    //用户头像
    private String avatar;

    //评论时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date rateTime;

    //到货时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryTime;
    //具体的评分
    private String score;
    //评论展示的类型
    private String rateType;
    //评论的内容
    private String text;
    //存的评论的相关商品
    private String recommend;

    /**
     * 商品分类信息
     */
    @ManyToMany(mappedBy = "ratingsList")
    private List<Foods> foodsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getRateTime() {
        return rateTime;
    }

    public void setRateTime(Date rateTime) {
        this.rateTime = rateTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public List<Foods> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(List<Foods> foodsList) {
        this.foodsList = foodsList;
    }
}
