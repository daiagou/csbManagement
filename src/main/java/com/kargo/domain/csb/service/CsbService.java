package com.kargo.domain.csb.service;


import com.kargo.common.util.BaseResponse;
import com.kargo.domain.csb.req.*;
import com.kargo.model.GoodsInfo;
import com.kargo.model.Orders;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author abner.zhang
 *
 */
public interface CsbService {
    BaseResponse deleteGoods(Integer id);

    BaseResponse saveOrUpdateGoods(GoodsInfo req);

    BaseResponse saveGoods(SaveGoodsInfoReq req);

    BaseResponse updateGoods(UpdateGoodsInfoReq req);

    BaseResponse uploadImg(CommonsMultipartFile file);

    BaseResponse queryGoodsInfo(QueryGoodsInfoReq req);

    BaseResponse queryGoodsInfosLike(QueryGoodsInfosLikeReq req);

    BaseResponse updateOrder(Orders req);

    BaseResponse queryOrdersLike(Orders req);

    BaseResponse queryOrders(Orders req);

    BaseResponse queryOrderAndInfosByOrderNo(String orderNo);

    BaseResponse queryOrderInfos(QueryOrderInfosReq req);
}
