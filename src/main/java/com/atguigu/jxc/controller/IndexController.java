package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.GoodsService;
import com.atguigu.jxc.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @description 系统首页请求控制器
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
@CrossOrigin
@RequestMapping
public class IndexController {

    /**
     * 进入登录页面
     *
     * @return 重定向至登录页面
     */

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/")
    public String toIndex() {
        return "redirect:login.html";
    }

    @ResponseBody
    @PostMapping("/goods/listInventory")
    public Map<String, Object> getListInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId) {

        return goodsService.getListInventory(page, rows, codeOrName, goodsTypeId);

    }

    @ResponseBody
    @PostMapping("/supplier/list")
    public Map<String, Object> getSupplierList(Integer page,Integer rows,String supplierName) {
        return supplierService.getSupplierList(page, rows, supplierName);

    }

    @PostMapping("/supplier/save")
    public ServiceVO saveAndUpdateSupplier(Supplier supplier) {
        return supplierService.saveAndUpdateSupplier(supplier);
    }


}
