package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Goods;

import java.util.Map;

public interface GoodsService {


    ServiceVO getCode();


    Map<String, Object> getListInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId);

    Map<String, Object> list(Integer page, Integer rows, String goodsName, Integer goodsTypeId);
}
