package com.ling.controller;

import com.ling.controller.service.SellerServiceRef;
import com.ling.controller.vo.SellerSupportsVo;
import com.ling.controller.vo.SellerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerServiceRef sellerServiceRef;

    @RequestMapping("/findSellerById")
    @ResponseBody
    public SellerVo findSellerById(Long id) {
         id = 1L;
        return sellerServiceRef.findSellerById(id);
    }
}
