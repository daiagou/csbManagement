package com.kargo.domain.csb.req;

import com.kargo.common.annotations.NotBlank;
import com.kargo.common.annotations.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by abner.zhang on 2019/1/16.
 */
@Getter
@Setter
public class SaveGoodsInfoReq {


    @NotBlank
    private String goodsName;

    @NotNull
    private BigDecimal price;

    @NotBlank
    private String goodsType;

    @NotBlank
    private String picUrl;


    private String detailPicUrl1;

    private String detailPicUrl2;

    private String detailPicUrl3;

    private String detailPicUrl4;

    private String detailPicUrl5;

}
