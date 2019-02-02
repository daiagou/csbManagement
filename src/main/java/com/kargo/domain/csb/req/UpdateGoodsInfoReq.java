package com.kargo.domain.csb.req;

import com.kargo.common.annotations.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by abner.zhang on 2019/1/16.
 */
@Getter
@Setter
public class UpdateGoodsInfoReq {

    @NotNull
    private Integer id;

    private String goodsName;

    private BigDecimal price;

    private String picUrl;

    private String goodsType;

    private String detailPicUrl1;

    private String detailPicUrl2;

    private String detailPicUrl3;

    private String detailPicUrl4;

    private String detailPicUrl5;

}
