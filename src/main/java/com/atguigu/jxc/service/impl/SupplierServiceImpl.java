package com.atguigu.jxc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.jxc.dao.SupplierDao;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.SupplierService;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: SupplierServiceImpl
 * @Author LiuXianKun
 * @Date: 2020/12/15 23:00
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;

    @Override
    public Map<String, Object> getSupplierList(Integer page, Integer rows, String supplierName) {
        List<Supplier> list = supplierDao.getSupplierList(page, rows, supplierName);
        Map<String, Object> map = new HashMap<>();
        map.put("total", list.size());
        map.put("rows", list);

        return map;
    }

    @Override
    public ServiceVO saveAndUpdateSupplier(Supplier supplier) {
        if (null != supplier.getSupplierId()) {
            Boolean b = supplierDao.updateById(supplier);
            if (b) {
                return new ServiceVO(100, "请求成功", null);
            }
        } else {
            Boolean b = supplierDao.saveAndUpdateSupplier(supplier);
            if (b) {
                return new ServiceVO(100, "请求成功", null);
            }
        }

        return null;
    }
}
