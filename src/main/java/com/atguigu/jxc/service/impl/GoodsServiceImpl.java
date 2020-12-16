package com.atguigu.jxc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.jxc.dao.GoodsDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Goods;
//import com.atguigu.jxc.service.GoodsMapper;
import com.atguigu.jxc.service.GoodsMapper;
import com.atguigu.jxc.service.GoodsService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;
//    @Autowired
//    private GoodsMapper goodsMapper;

    @Override
    public ServiceVO getCode() {

        // 获取当前商品最大编码
        String code = goodsDao.getMaxCode();

        // 在现有编码上加1
        Integer intCode = Integer.parseInt(code) + 1;

        // 将编码重新格式化为4位数字符串形式
        String unitCode = intCode.toString();

        for (int i = 4; i > intCode.toString().length(); i--) {

            unitCode = "0" + unitCode;

        }
        return new ServiceVO<>(SuccessCode.SUCCESS_CODE, SuccessCode.SUCCESS_MESS, unitCode);
    }

    @Override
    public Map<String, Object> getListInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId) {
        Map<String, Object> map = new HashMap<>();
        List<Goods> goodsList = goodsDao.getListInventory(codeOrName,goodsTypeId);
//        QueryWrapper<Goods> queryWrapper = new QueryWrapper();
//        queryWrapper.eq("goods_code", codeOrName);
//        queryWrapper.or();
//        queryWrapper.eq("goods_name", codeOrName);
//        queryWrapper.or();
//        List<Goods> goodsList = goodsMapper.selectList(queryWrapper);
        map.put("rows", goodsList);
        map.put("total", goodsList.size());
//        JSONObject jsonObject = new JSONObject(map);
        return map;
    }

    @Override
    public Map<String, Object> list(Integer page, Integer rows, String goodsName, Integer goodsTypeId) {
        List<Goods> list = goodsDao.list(goodsName, goodsTypeId);
        return null;
    }


}
