package com.kargo.domain.csb.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kargo.common.exception.BusinessException;
import com.kargo.common.util.BaseResponse;
import com.kargo.common.util.CheckArgsUtil;
import com.kargo.common.util.MyBeanUtil;
import com.kargo.common.util.UtilLocalDate;
import com.kargo.dao.CustomerMapper;
import com.kargo.dao.GoodsInfoMapper;
import com.kargo.dao.OrderGoodsInfoMapper;
import com.kargo.dao.OrdersMapper;
import com.kargo.domain.csb.req.*;
import com.kargo.domain.csb.service.CsbService;
import com.kargo.model.GoodsInfo;
import com.kargo.model.OrderGoodsInfo;
import com.kargo.model.Orders;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class CsbServiceImpl implements CsbService {

    private static final Logger logger = LoggerFactory.getLogger(CsbServiceImpl.class);

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private OrderGoodsInfoMapper orderGoodsInfoMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Value("${file.out.path}")
    private String fileOutPath;
    @Value("${pic.url.first}")
    private String picUrlFirst;
    @Value("${pic.url.second}")
    private String picUrlSecond;




    @Override
    public BaseResponse deleteGoods(Integer id){
        logger.info("deleteGoods id:[{}]", id);
        BaseResponse baseResponse = new BaseResponse();
        if(id==null){
            return baseResponse.genFail("param error");
        }
        goodsInfoMapper.deleteByPrimaryKey(id);
        return baseResponse.genSuccessResp();
    }


    @Override
    public BaseResponse saveOrUpdateGoods(GoodsInfo req){
        logger.info("saveGoods req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        if(req.getId()==null){
            SaveGoodsInfoReq saveGoodsInfoReq = new SaveGoodsInfoReq();
            BeanUtils.copyProperties(req,saveGoodsInfoReq);
           return saveGoods(saveGoodsInfoReq);
        }else{
            UpdateGoodsInfoReq updateGoodsInfoReq = new UpdateGoodsInfoReq();
            BeanUtils.copyProperties(req,updateGoodsInfoReq);
            return updateGoods(updateGoodsInfoReq);
        }

    }


    @Override
    public BaseResponse saveGoods(SaveGoodsInfoReq req){
        logger.info("saveGoods req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();

        Map<String ,String> map= CheckArgsUtil.checkArgsMap(req);
        if (map!=null) {
            return baseResponse.genFail(map.values().iterator().next());
        }

        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(req,goodsInfo);
        goodsInfoMapper.insertSelective(goodsInfo);
        return baseResponse.genSuccessResp();
    }

    @Override
    public BaseResponse updateGoods(UpdateGoodsInfoReq req){
        logger.info("updateGoods req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        if(req.getId()==null){
            return baseResponse.genFail("参数错误");
        }
        MyBeanUtil.convertEmptyToNull(req);

        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(req,goodsInfo);
        goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
        return baseResponse.genSuccessResp();
    }


    @Override
    public BaseResponse uploadImg(CommonsMultipartFile file) {
        BaseResponse baseResponse = new BaseResponse();

        if(file.isEmpty()){
            return baseResponse.genFail("请上传图片");
        }
        String fileName = saveFile(file, Arrays.asList(new String[]{"gif","bmp","jpg","jpeg","png"}));
        if (org.apache.commons.lang.StringUtils.isBlank(fileName)) {
            return baseResponse.genFail("上传失败!");
        }
        return baseResponse.genSuccessResp(picUrlFirst+picUrlSecond+fileName);
    }


    @Override
    public BaseResponse queryGoodsInfo(QueryGoodsInfoReq req){
        logger.info("queryGoods req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        MyBeanUtil.convertEmptyToNull(req);

        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(req,goodsInfo);
        List<GoodsInfo> goodsInfos = goodsInfoMapper.selectPage(goodsInfo, null);
        return baseResponse.genSuccessResp(goodsInfos);
    }


    @Override
    public BaseResponse queryGoodsInfosLike(QueryGoodsInfosLikeReq req){
        logger.info("queryGoodsInfosLike req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        MyBeanUtil.convertEmptyToNull(req);

        GoodsInfo goodsInfo = new GoodsInfo();
        BeanUtils.copyProperties(req,goodsInfo);
        List<GoodsInfo> goodsInfos = goodsInfoMapper.queryGoodsInfosLike(goodsInfo, null);
        return baseResponse.genSuccessResp(goodsInfos);
    }



    @Override
    public BaseResponse updateOrder(Orders req){
        logger.info("updateOrder req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        MyBeanUtil.convertEmptyToNull(req);

        Orders orders = new Orders();
        BeanUtils.copyProperties(req,orders);
        int i = ordersMapper.updateByPrimaryKeySelective(orders);
        return baseResponse.genSuccessResp(i);
    }


    @Override
    public BaseResponse queryOrdersLike(Orders req){
        logger.info("queryOrdersLike req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        MyBeanUtil.convertEmptyToNull(req);
        List<Orders> orderss = ordersMapper.queryOrdersLike(req, null);
        return baseResponse.genSuccessResp(orderss);
    }
    @Override
    public BaseResponse queryOrders(Orders req){
        logger.info("queryOrders req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        MyBeanUtil.convertEmptyToNull(req);

        Orders orders = new Orders();
        BeanUtils.copyProperties(req,orders);
        List<Orders> orderss = ordersMapper.selectPage(orders, null);
        return baseResponse.genSuccessResp(orderss);
    }


    @Override
    public BaseResponse queryOrderAndInfosByOrderNo(String orderNo){
        logger.info("queryOrderAndInfosByOrderNo req:[{}]", orderNo);
        BaseResponse baseResponse = new BaseResponse();
        if(StringUtils.isBlank(orderNo)){
            return baseResponse.genFail("param error");
        }

        Orders orders = new Orders();
        orders.setOrderNo(orderNo);
        List<Orders> orderss = ordersMapper.selectPage(orders, PageRequest.of(0, 1));

        OrderGoodsInfo orderGoodsInfo = new OrderGoodsInfo();
        orderGoodsInfo.setOrderNo(orderNo);
        List<OrderGoodsInfo> orderGoodsInfos = orderGoodsInfoMapper.selectPage(orderGoodsInfo, null);

        Map<String,Object> map = new HashedMap();
        map.put("order",orderss.get(0));
        map.put("orderGoodsInfo",orderGoodsInfos);
        return baseResponse.genSuccessResp(map);
    }


    @Override
    public BaseResponse queryOrderInfos(QueryOrderInfosReq req){
        logger.info("queryOrderInfos req:[{}]", JSONObject.toJSONString(req));
        BaseResponse baseResponse = new BaseResponse();
        MyBeanUtil.convertEmptyToNull(req);

        OrderGoodsInfo orderGoodsInfo = new OrderGoodsInfo();
        BeanUtils.copyProperties(req,orderGoodsInfo);
        List<OrderGoodsInfo> orderss = orderGoodsInfoMapper.selectPage(orderGoodsInfo, null);
        return baseResponse.genSuccessResp(orderss);
    }






    public String saveFile(CommonsMultipartFile partFile, List<String> allowExtensions) {
        logger.info("saveFile req:[{}]", JSONObject.toJSONString(allowExtensions));

        //保存文件
        String orderNo = UtilLocalDate.getOrderNo("", 6);
//        String outPutPath = fileOutPath + File.separator + UtilLocalDate.format(Calendar.getInstance().getTime(), UtilLocalDate.yyyyMMdd_dateFormat) + File.separator + orderNo + File.separator;
        String outPutPath = fileOutPath + File.separator;
        File dir = new File(outPutPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (partFile.isEmpty()) {
            return null;
        }
        //校验后缀名
        String extension = "";
        int i = partFile.getOriginalFilename().lastIndexOf('.');
        if (i > 0) {
            extension = partFile.getOriginalFilename().substring(i + 1);
        }
        if (!CollectionUtils.isEmpty(allowExtensions)) {
            if (org.apache.commons.lang3.StringUtils.isBlank(extension) || !allowExtensions.contains(extension)) {
                return null;
            }
        }

        String fileName=System.currentTimeMillis()+"."+extension;
        String filePath = outPutPath + fileName;
        File file = new File(filePath);


        //保存文件到本地
        try {
            partFile.transferTo(file);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException("文件上传失败");
        }

        //上传文件到微信：
        return fileName;
    }



}
