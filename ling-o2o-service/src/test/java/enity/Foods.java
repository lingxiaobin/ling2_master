package enity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 商品信息表
 */
public class Foods {

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

    private List<Ratings> ratings;//文章列表

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

    public List<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(List<Ratings> ratings) {
        this.ratings = ratings;
    }
}
