package com.ling.enity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
/**
 * 商家信息表
 */
@Entity
@Table(name = "seller")
public class Seller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //店铺名称
    private String name;
    //店铺图片
    private String avatar;
    //店铺配送方式描述
    private String description;
    //多少分钟送达(平均配送时间)
    @Column(length = 32)
    private Integer deliveryTime;
    //评分
    @Column(columnDefinition = "float(10,2)")
    private float score;

    @Column(columnDefinition = "float(10,2) default '1.00'")
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
    @Lob @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text")
    private String pics;
    //商家具体信息
    @Lob @Basic(fetch = FetchType.LAZY) @Column(columnDefinition = "text")
    private String infos;

    //1、关系维护端，负责多对多关系的绑定和解除
    //2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
    //3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Authority)
    //4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
    //即表名为user_authority
    //关联到主表的外键名：主表名+下划线+主表中的主键列名,即user_id
    //关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即authority_id
    //主表就是关系维护端对应的表，从表就是关系被维护端对应的表
    //商家支持的服务信息
    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "seller_seller_supports", joinColumns = @JoinColumn(name = "seller_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "seller_supports_id", referencedColumnName = "id"))
    private List<SellerSupports> sellerSupportsList;

    //旗下的商品
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="author"中的author是Article中的author属性
    private List<Foods> foodsList;


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
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public List<SellerSupports> getSellerSupportsList() {
        return sellerSupportsList;
    }

    public void setSellerSupportsList(List<SellerSupports> sellerSupportsList) {
        this.sellerSupportsList = sellerSupportsList;
    }

    public List<Foods> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(List<Foods> foodsList) {
        this.foodsList = foodsList;
    }
}
