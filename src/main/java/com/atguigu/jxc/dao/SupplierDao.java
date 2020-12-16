package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Supplier;

import java.util.List;

public interface SupplierDao {
    List<Supplier> getSupplierList(Integer page, Integer rows, String supplierName);

    Boolean saveAndUpdateSupplier(Supplier supplier);


    Boolean updateById(Supplier supplier);
}
