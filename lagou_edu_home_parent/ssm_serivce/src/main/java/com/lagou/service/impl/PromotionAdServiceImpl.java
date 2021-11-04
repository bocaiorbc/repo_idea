package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    /*
        分页查询
     */
    @Override
    public PageInfo<PromotionAd> findAllPromotionAdMapperByPage(PromotionAdVO promotionAdVO) {

        PageHelper.startPage(promotionAdVO.getCurrentPage(),promotionAdVO.getPageSize());

        List<PromotionAd> list = promotionAdMapper.findAllPromotionAdMapperByPage();

        PageInfo<PromotionAd> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    /*
        添加广告信息
     */
    @Override
    public void savePromotionAd(PromotionAd promotionAd) {

        //1.补全信息
        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);

        //2.调用方法
        promotionAdMapper.savePromotionAd(promotionAd);

    }

    @Override
    public PromotionAd findPromotionAdById(Integer id) {

        PromotionAd ad = promotionAdMapper.findPromotionAdById(id);


        return ad;
    }

    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {

        //1.补全信息
        promotionAd.setUpdateTime(new Date());

        //2.调用方法
        promotionAdMapper.updatePromotionAd(promotionAd);

    }

    @Override
    public void updatePromotionAdStatus(int id, int status) {

        //1.封装数据
        PromotionAd promotionAd = new PromotionAd();

        promotionAd.setId(id);
        promotionAd.setStatus(status);

        //2.补全信息
        promotionAd.setUpdateTime(new Date());

        //3.调用方法
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
