//package com.kargo.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.kargo.common.annotations.LoginPermission;
//import com.kargo.common.exception.BusinessException;
//import com.kargo.common.util.BaseResponse;
//import com.kargo.controller.base.BaseControl;
//import com.kargo.domain.ad.req.InvalidCampaignReq;
//import com.kargo.domain.ad.req.SaveOrUpdateCampaignReq;
//import com.kargo.domain.ad.service.AdvService;
//import com.kargo.model.AdsAgency;
//import com.kargo.model.AdsBrand;
//import com.kargo.model.AdsCampaign;
//import com.kargo.model.AdsChannel;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
///**
// * Created by abner.zhang on 2018/8/30.
// */
//@RestController
//@RequestMapping("ads")
////@CrossOrigin
//@CrossOrigin(origins="*",allowCredentials ="true" )
//public class AdvController  extends BaseControl {
//
//    private Logger logger = LoggerFactory.getLogger(AdvController.class);
//
//    @Autowired
//    private AdvService advService;
//
//
//    @RequestMapping(value = "/uploadImg", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
////    @LoginPermission
//    public String uploadImg( @RequestParam("file") CommonsMultipartFile file) {
//        logger.info("uploadImg req");
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.uploadImg(file);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("uploadImg respStr:[{}]", respStr);
//        return respStr;
//    }
//
//
//    @RequestMapping(value = "/getImgUrl", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String getImgUrl(String url) {
//        logger.info("getImgUrl req:[{}]", url);
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.getImgUrl(url);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("getImgUrl respStr:[{}]", respStr);
//        return respStr;
//    }
//
//
//    @RequestMapping(value = "/saveOrUpdateCampaign", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String saveOrUpdateCampaign(@RequestBody SaveOrUpdateCampaignReq req) {
//        logger.info("saveOrUpdateCampaign req:[{}]", JSONObject.toJSONString(req));
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.saveOrUpdateCampaign(req);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("saveOrUpdateCampaign respStr:[{}]", respStr);
//        return respStr;
//    }
//
//    @RequestMapping(value = "/invalidCampaign", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String invalidCampaign(@RequestBody InvalidCampaignReq invalidCampaignReq) {
//        logger.info("invalidCampaign req:[{}]", JSONObject.toJSONString(invalidCampaignReq));
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.invalidCampaign(invalidCampaignReq);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("invalidCampaign respStr:[{}]", respStr);
//        return respStr;
//    }
//
//    @RequestMapping(value = "/queryCampaign", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String queryCampaign(AdsCampaign adsCampaign) {
//        logger.info("queryCampaign req:[{}]", JSONObject.toJSONString(adsCampaign));
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.queryCampaign(adsCampaign);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("queryCampaign respStr:[{}]", respStr);
//        return respStr;
//    }
//
//
//
////    @RequestMapping(value = "/queryExpCampsResp", method = {RequestMethod.GET, RequestMethod.POST})
////    @ResponseBody
////    public String queryExpCampsResp( QueryExpCampsResp req) {
////        logger.info("queryExpCampsResp req:[{}]", JSONObject.toJSONString(req));
////        BaseResponse baseResponse = new BaseResponse();
////        try {
////            baseResponse = advService.queryExpCampsResp(req);
////        } catch (BusinessException e) {
////            baseResponse.genFail(e.getMessage());
////        } catch (Exception e) {
////            logger.error(e.getMessage(), e);
////        }
////        String respStr = JSONObject.toJSONString(baseResponse);
////        logger.info("queryExpCampsResp respStr:[{}]", respStr);
////        return respStr;
////    }
////
//
//
//    @RequestMapping(value = "/queryActOrExpCampsResp", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String queryActOrExpCampsResp( AdsCampaign req) {
//        logger.info("queryActCampsResp req:[{}]", JSONObject.toJSONString(req));
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.queryActOrExpCampsResp(req);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("queryActOrExpCampsResp respStr:[{}]", respStr);
//        return respStr;
//    }
//
//    @RequestMapping(value = "/saveOrUpdateAdsChannel", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String saveOrUpdateAdsChannel(@RequestBody AdsChannel adsChannel) {
//        logger.info("saveOrUpdateAdsChannel req:[{}]", JSONObject.toJSONString(adsChannel));
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.saveOrUpdateAdsChannel(adsChannel);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("saveOrUpdateAdsChannel respStr:[{}]", respStr);
//        return respStr;
//    }
//    @RequestMapping(value = "/queryAdsChannel", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String queryAdsChannel( AdsChannel adsChannel) {
//        logger.info("queryAdsChannel req:[{}]", JSONObject.toJSONString(adsChannel));
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.queryAdsChannel(adsChannel);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("queryAdsChannel respStr:[{}]", respStr);
//        return respStr;
//    }
//
//
//    @RequestMapping(value = "/saveOrUpdateAdsBrand", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String saveOrUpdateAdsBrand(@RequestBody AdsBrand adsBrand) {
//        logger.info("saveOrUpdateAdsBrand req:[{}]", JSONObject.toJSONString(adsBrand));
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.saveOrUpdateAdsBrand(adsBrand);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("saveOrUpdateAdsBrand respStr:[{}]", respStr);
//        return respStr;
//    }
//    @RequestMapping(value = "/queryAdsBrand", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String queryAdsBrand( AdsBrand adsBrand) {
//        logger.info("queryAdsBrand req:[{}]", JSONObject.toJSONString(adsBrand));
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.queryAdsBrand(adsBrand);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("queryAdsBrand respStr:[{}]", respStr);
//        return respStr;
//    }
//
//
//
//    @RequestMapping(value = "/saveOrUpdateAgency", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String saveOrUpdateAgency(@RequestBody AdsAgency adsAgency) {
//        logger.info("saveOrUpdateAgency req:[{}]", JSONObject.toJSONString(adsAgency));
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.saveOrUpdateAgency(adsAgency);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("saveOrUpdateAgency respStr:[{}]", respStr);
//        return respStr;
//    }
//    @RequestMapping(value = "/queryAdsAgency", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String queryAdsAgency( AdsAgency adsAgency) {
//        logger.info("queryAdsAgency req:[{}]", JSONObject.toJSONString(adsAgency));
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.queryAdsAgency(adsAgency);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("queryAdsAgency respStr:[{}]", respStr);
//        return respStr;
//    }
//
//
//    @RequestMapping(value = "/queryRealTimeStatus", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String queryRealTimeStatus( ) {
////        logger.info("queryRealTimeStatus req");
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.queryRealTimeStatus();
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
////        logger.info("queryRealTimeStatus respStr:[{}]", respStr);
//        return respStr;
//    }
//    @RequestMapping(value = "/querySevenDayPerformance", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String querySevenDayPerformance(Long campaignId ,String mid) {
////        logger.info("querySevenDayPerformance campaignId:[{}], mid:[{}]",campaignId,mid);
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.querySevenDayPerformance(campaignId,mid);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
////        logger.info("querySevenDayPerformance respStr:[{}]", respStr);
//        return respStr;
//    }
//
//
//    @RequestMapping(value = "/queryCampaignByMid", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    @LoginPermission
//    public String queryCampaignByMid(String mid ) {
//        logger.info("queryCampaignByMid req:[{}]",mid);
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse = advService.queryCampaignByMid(mid);
//        } catch (BusinessException e) {
//            baseResponse.genFail(e.getMessage());
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        String respStr = JSONObject.toJSONString(baseResponse);
//        logger.info("queryCampaignByMid respStr:[{}]", respStr);
//        return respStr;
//    }
//
//
//}
