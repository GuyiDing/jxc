package com.atguigu.jxc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.jxc.dao.GoodsTypeDao;
import com.atguigu.jxc.entity.Attributes;
import com.atguigu.jxc.entity.GoodsType;
import com.atguigu.jxc.entity.Unit;
import com.atguigu.jxc.service.GoodsTypeService;
import com.atguigu.jxc.service.UnitTypeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: GoodsTypeServiceImpl
 * @Author LiuXianKun
 * @Date: 2020/12/16 09:43
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Resource
    private GoodsTypeDao goodsTypeDao;
//    @Resource
//    private UnitTypeDao unitTypeDao;

/* {
                "id": 3,
                "text": "食品",
                "state": "closed",
                "iconCls": "goods-type",
                "attributes": {
                    "state": 1
                },
                "children": [
                    {
                        "id": 9,
                        "text": "进口食品",
                        "state": "open",
                        "iconCls": "goods-type",
                        "attributes": {
                            "state": 0
                        }
                    },
*/

    @Override
    public String getGoodsType() {
        List<GoodsType> list = getAllData();

        return JSONObject.toJSONString(list);
    }

    private List<GoodsType> getData(Integer Id) {
        return goodsTypeDao.getData(Id);
    }

    private List<GoodsType> getAllData() {
        List<GoodsType> list = goodsTypeDao.getGoodsType();
        list.forEach(goodsType -> {
            goodsType.setText(goodsType.getGoodsTypeName());
            goodsType.setGoodsTypeState(goodsType.getGoodsTypeState());

            goodsType.setChildren(getData(goodsType.getGoodsTypeId()));
            if (goodsType.getGoodsTypeState() == 0) {
                goodsType.setState("open");
                goodsType.setAttributes(new Attributes("0"));
            } else if (goodsType.getGoodsTypeState() == 1){
                goodsType.setState("closed");
                goodsType.setAttributes(new Attributes("1"));
            }
            goodsType.setIconCls("good-type");

        });
        return list;
    }



    @Override
    public Map<String, List> list() {
//        List<Unit> list = unitTypeDao.list();
        HashMap<String, List> map = new HashMap<>();
//        map.put("rows", list);
        return map;
    }
}
