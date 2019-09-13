package com.ling.controller.vo;

import java.util.List;

/**
 * 店铺下商品分类信息表
 */
public class Goods {
    //分类名称
    private String name;
    //分类类型
    private Integer type;

    private List<Foods> foods;//文章列表

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

    public List<Foods> getFoods() {
        return foods;
    }

    public void setFoods(List<Foods> foods) {
        this.foods = foods;
    }
}
