package com.ling.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ling.enity.UserInfo;
import com.ling.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ss")
public class ContentController {
    @Reference
    private ContentService contentService;

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(){
        return contentService.findAll();
//        return "contentService.findAll()";
    }


}
