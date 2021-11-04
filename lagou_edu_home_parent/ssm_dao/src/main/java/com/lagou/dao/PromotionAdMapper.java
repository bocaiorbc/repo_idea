package com.lagou.dao;

import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionSpace;

import java.util.List;

public interface PromotionAdMapper {

    /*
        分页查询广告信息
     */
    public List<PromotionAd> findAllPromotionAdMapperByPage();

    /*
         添加广告信息
     */
    public void savePromotionAd(PromotionAd promotionAd);

    /*
        回显广告名称
     */
    public PromotionAd findPromotionAdById(Integer id);

    /*
        修改广告信息
     */
    public void updatePromotionAd(PromotionAd promotionAd);

    /*
        广告动态上下线
     */
    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
