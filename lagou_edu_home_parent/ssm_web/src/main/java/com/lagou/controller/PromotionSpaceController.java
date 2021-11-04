package com.lagou.controller;

import com.lagou.domain.PromotionSpace;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){

        List<PromotionSpace> list = promotionSpaceService.findAllPromotionSpace();

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", list);

        return responseResult;
    }

    //添加&修改广告位信息
    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace){

        //判断是否携带广告位id
        if(promotionSpace.getId() == null){

            promotionSpaceService.savePromotionSpace(promotionSpace);

            return new ResponseResult(true, 200, "添加广告位信息成功", null);
        }else {
            promotionSpaceService.updatePromotionSpace(promotionSpace);

            return new ResponseResult(true, 200, "修改广告位信息成功", null);
        }

    }

    //根据id回显广告位名称
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(Integer id){

        PromotionSpace space = promotionSpaceService.findPromotionSpaceById(id);

        ResponseResult responseResult = new ResponseResult(true, 200, "回显广告位名称成功", space);

        return responseResult;


    }
}
