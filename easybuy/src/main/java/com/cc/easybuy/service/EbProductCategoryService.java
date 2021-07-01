package com.cc.easybuy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.easybuy.mapper.EbProductCategoryMapper;
import com.cc.easybuy.mapper.EbProductMapper;
import com.cc.easybuy.model.EbProduct;
import com.cc.easybuy.model.EbProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EbProductCategoryService {
    @Autowired
    private EbProductCategoryMapper ebProductCategoryMapper;

    @Autowired
    private EbProductMapper ebProductMapper;

    public Page<EbProduct> findProductBycate(int psize,int pageSize,int epcId){
        Page<EbProduct> page = new Page(psize,pageSize);

        return ebProductMapper.selectPage(page,new QueryWrapper<EbProduct>()
        .eq("epc_child_id",epcId));
    }

    public Map<String, List<EbProductCategory>> selectBigAndSmallCate(){
        List<EbProductCategory> bigCates = ebProductCategoryMapper.selectBigCate();
        List<EbProductCategory> smallCates = ebProductCategoryMapper.selectSmallCate();

        Map<String,List<EbProductCategory>> cateMap = new HashMap<>();
        cateMap.put("bigs",bigCates);
        cateMap.put("smalls",smallCates);
        return cateMap;
    }
}
