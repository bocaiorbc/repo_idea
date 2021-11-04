package com.lagou.service.impl;

import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    //回显广告位名称
    @Override
    public List<PromotionSpace> findAllPromotionSpace() {

        List<PromotionSpace> list = promotionSpaceMapper.findAllPromotionSpace();

        return list;
    }

    /*
        新增广告位信息
     */
    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {

        //1.封装数据
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());

        Date date = new Date();

        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);

        //2.调用mapper方法
        promotionSpaceMapper.savePromotionSpace(promotionSpace);

    }

    /*
        回显广告位名称
     */
    @Override
    public PromotionSpace findPromotionSpaceById(Integer id) {

        PromotionSpace space = promotionSpaceMapper.findPromotionSpaceById(id);

        return space;
    }

    /*
        修改广告位信息
     */
    @Override
    public void updatePromotionSpace(@RequestBody PromotionSpace promotionSpace) {
        //1.补全信息
        promotionSpace.setUpdateTime(new Date());

        //2.调用mapper方法
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }
}
