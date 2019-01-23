package com.kargo.dao;

import com.kargo.model.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> selectPage(@Param("record") Orders record, @Param("pageable") Pageable pageable);

    int selectCount(@Param("record") Orders record);

    List<Orders> queryOrdersLike(@Param("record") Orders record, @Param("pageable") Pageable pageable);
}