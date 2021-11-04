package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

import java.util.List;

public interface PromotionAdService {

    /*
       分页查询广告信息
    */
    public PageInfo<PromotionAd> findAllPromotionAdMapperByPage(PromotionAdVO promotionAdVO);

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
    public void updatePromotionAdStatus(int id,int status);
}
