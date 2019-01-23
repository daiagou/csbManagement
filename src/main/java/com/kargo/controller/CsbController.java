package com.kargo.controller;

import com.alibaba.fastjson.JSONObject;
import com.kargo.common.annotations.LoginPermission;
import com.kargo.common.exception.BusinessException;
import com.kargo.common.util.BaseResponse;
import com.kargo.controller.base.BaseControl;
import com.kargo.domain.csb.req.QueryGoodsInfoReq;
import com.kargo.domain.csb.req.QueryGoodsInfosLikeReq;
import com.kargo.domain.csb.req.QueryOrderInfosReq;
import com.kargo.domain.csb.service.CsbService;
import com.kargo.model.GoodsInfo;
import com.kargo.model.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by abner.zhang on 2018/8/30.
 */
@RestController
@RequestMapping("csb")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class CsbController extends BaseControl {

    private Logger logger = LoggerFactory.getLogger(CsbController.class);

    @Autowired
    private CsbService csbService;



    @RequestMapping(value = "/uploadImg", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String uploadImg( @RequestParam("file") CommonsMultipartFile file) {
        logger.info("uploadImg req");
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = csbService.uploadImg(file);
        } catch (BusinessException e) {
            baseResponse.genFail(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        logger.info("uploadImg respStr:[{}]", respStr);
        return respStr;
    }

    @RequestMapping(value = "/saveOrUpdateGoods", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @LoginPermission
    public String saveOrUpdateGoods(@RequestBody GoodsInfo req) {
        logger.info("saveOrUpdateGoods req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = csbService.saveOrUpdateGoods(req);
        } catch (BusinessException e) {
            baseResponse.genFail(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        logger.info("saveOrUpdateGoods respStr:[{}]", respStr);
        return respStr;
    }

    @RequestMapping(value = "/deleteGoods", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @LoginPermission
    public String deleteGoods(Integer id) {
        logger.info("deleteGoods req:[{}]", id);
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = csbService.deleteGoods(id);
        } catch (BusinessException e) {
            baseResponse.genFail(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        logger.info("deleteGoods respStr:[{}]", respStr);
        return respStr;
    }

    @RequestMapping(value = "/queryGoodsInfo", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @LoginPermission
    public String queryGoodsInfo(QueryGoodsInfoReq req) {
        logger.info("updateGoods req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = csbService.queryGoodsInfo(req);
        } catch (BusinessException e) {
            baseResponse.genFail(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        logger.info("updateGoods respStr:[{}]", respStr);
        return respStr;
    }
    @RequestMapping(value = "/queryGoodsInfosLike", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @LoginPermission
    public String queryGoodsInfosLike(QueryGoodsInfosLikeReq req) {
        logger.info("queryGoodsInfosLike req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = csbService.queryGoodsInfosLike(req);
        } catch (BusinessException e) {
            baseResponse.genFail(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        logger.info("queryGoodsInfosLike respStr:[{}]", respStr);
        return respStr;
    }

    @RequestMapping(value = "/updateOrder", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @LoginPermission
    public String updateOrder(@RequestBody Orders req) {
        logger.info("updateOrder req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = csbService.updateOrder(req);
        } catch (BusinessException e) {
            baseResponse.genFail(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        logger.info("updateOrder respStr:[{}]", respStr);
        return respStr;
    }

    @RequestMapping(value = "/queryOrders", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @LoginPermission
    public String queryOrders(Orders req) {
        logger.info("queryOrders req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = csbService.queryOrders(req);
        } catch (BusinessException e) {
            baseResponse.genFail(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        logger.info("queryOrders respStr:[{}]", respStr);
        return respStr;
    }

    @RequestMapping(value = "/queryOrdersLike", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @LoginPermission
    public String queryOrdersLike(Orders req) {
        logger.info("queryOrdersLike req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = csbService.queryOrdersLike(req);
        } catch (BusinessException e) {
            baseResponse.genFail(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        logger.info("queryOrdersLike respStr:[{}]", respStr);
        return respStr;
    }

    @RequestMapping(value = "/queryOrderAndInfosByOrderNo", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @LoginPermission
    public String queryOrderAndInfosByOrderNo(String orderNo) {
        logger.info("queryOrderAndInfosByOrderNo req:[{}]", orderNo);
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = csbService.queryOrderAndInfosByOrderNo(orderNo);
        } catch (BusinessException e) {
            baseResponse.genFail(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        logger.info("queryOrderAndInfosByOrderNo respStr:[{}]", respStr);
        return respStr;
    }
    @RequestMapping(value = "/queryOrderInfos", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @LoginPermission
    public String queryOrderInfos(QueryOrderInfosReq req) {
        logger.info("queryOrderInfos req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = csbService.queryOrderInfos(req);
        } catch (BusinessException e) {
            baseResponse.genFail(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String respStr = JSONObject.toJSONString(baseResponse);
        logger.info("queryOrderInfos respStr:[{}]", respStr);
        return respStr;
    }


}
