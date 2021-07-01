package com.cc.easybuy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.easybuy.mapper.EbProductMapper;
import com.cc.easybuy.model.EbProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EbProductService {

    @Autowired
    private EbProductMapper ebProductMapper;

    public Page<EbProduct> list(int psize,int limit){
        Page<EbProduct> page = new Page<>(psize,limit);
        return ebProductMapper.selectPage(page,null);
    }
    public EbProduct detail(int epId){
        return ebProductMapper.selectById(epId);
    }
}
