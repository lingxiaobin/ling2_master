package com.ling.enity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品信息表
 */
@Entity
@Table(name = "foods")
public class Foods implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    //名称
    private String name;
    //价格
    private BigDecimal price;
    //原价
    private BigDecimal oldPrice;
    //商品描述
    private String description;
    //月售总数
    private String sellCount;
    //好评率??
    private String rating;
    //商品信息
    private String info;
    //商品图片
    private String icon;
    //商品详情页图片
    private String image;

    /**
     * 商家信息
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//可选属性optional=false,表示seller不能为空。删除foods，不影响seller
// CascadeType.PERSIST    -- 触发级联创建(create)
//     //CascadeType.MERGE      -- 触发级联合并(update)
    @JoinColumn(name = "seller_id")//设置在foods表中的关联字段(外键)
    private Seller seller;

    /**
     * 商品分类信息  , optional = false
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "goods_id")
    private Goods goods;

    /**
     * 评论
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "foods_ratings", joinColumns = @JoinColumn(name = "foods_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ratings_id", referencedColumnName = "id"))
    private List<Ratings> ratingsList=new ArrayList<>();//文章列表

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellCount() {
        return sellCount;
    }

    public void setSellCount(String sellCount) {
        this.sellCount = sellCount;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<Ratings> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(List<Ratings> ratingsList) {
        this.ratingsList = ratingsList;
    }
}
