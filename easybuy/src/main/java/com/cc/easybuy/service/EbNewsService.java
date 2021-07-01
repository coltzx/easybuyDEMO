package com.cc.easybuy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.easybuy.mapper.EbNewsMapper;
import com.cc.easybuy.mapper.EbProductMapper;
import com.cc.easybuy.model.EbNews;
import com.cc.easybuy.model.EbProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EbNewsService {
    @Autowired
    private EbNewsMapper ebNewsMapper;

    public Page<EbNews> list(int psize, int limit){
        Page<EbNews> page = new Page<>(psize,limit);
        page.addOrder(OrderItem.desc("en_create_time"));//根据时间排序
        return ebNewsMapper.selectPage(page,null);
    }
}
