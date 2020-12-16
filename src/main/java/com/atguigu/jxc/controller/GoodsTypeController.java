package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @title: GoodsTypeController
 * @Author LiuXianKun
 * @Date: 2020/12/16 09:31
 */
@RestController
@RequestMapping()
public class GoodsTypeController {

    @Resource
    private GoodsTypeService goodsTypeService;

    @RequestMapping("goodsType/loadGoodsType")
    public String loadGoodsType() {

        return goodsTypeService.getGoodsType();
    }

    @PostMapping("/unit/list")
    public Map<String, List> list() {
        return goodsTypeService.list();
    }


}
