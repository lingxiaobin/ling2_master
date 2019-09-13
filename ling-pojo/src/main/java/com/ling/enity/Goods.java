package com.ling.enity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 * 店铺下商品分类信息表
 */
@Entity
@Table(name = "goods")
public class Goods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    //分类名称
    private String name;
    //分类类型
    private Integer type;
//fetch= FetchType.LAZY
    @OneToMany(mappedBy = "goods",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Foods> foodsList=new ArrayList<>();//文章列表

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Foods> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(List<Foods> foodsList) {
        this.foodsList = foodsList;
    }
}
