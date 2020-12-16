package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Supplier;

import java.util.Map;

public interface SupplierService {
    Map<String, Object> getSupplierList(Integer damageListId, Integer rows, String supplierName);

    ServiceVO saveAndUpdateSupplier(Supplier supplier);
}
