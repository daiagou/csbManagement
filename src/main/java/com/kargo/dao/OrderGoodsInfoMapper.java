package com.kargo.dao;

import com.kargo.model.OrderGoodsInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

public interface OrderGoodsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderGoodsInfo record);

    int insertSelective(OrderGoodsInfo record);

    OrderGoodsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderGoodsInfo record);

    int updateByPrimaryKey(OrderGoodsInfo record);

    List<OrderGoodsInfo> selectPage(@Param("record") OrderGoodsInfo record, @Param("pageable") Pageable pageable);

    int selectCount(@Param("record") OrderGoodsInfo record);
}