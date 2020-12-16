package com.atguigu.jxc.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface GoodsTypeService {

    String getGoodsType();

    Map<String, List> list();
}
