package com.ling.service;

import com.ling.enity.Foods;
import com.ling.enity.Goods;

import java.util.List;

public interface GoodsService {
    Goods save(Goods goods);
    String save(String goods);
    String save(List<Foods> list);
}
