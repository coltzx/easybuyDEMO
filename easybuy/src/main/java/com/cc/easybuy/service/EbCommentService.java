package com.cc.easybuy.service;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.easybuy.mapper.EbCommentMapper;
import com.cc.easybuy.model.EbComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EbCommentService {
    @Autowired
    private EbCommentMapper ebCommentMapper;

    public Page<EbComment> list(int psize,int pageSize){
        Page<EbComment> page = new Page<>(psize,pageSize);
        page.addOrder(OrderItem.desc("ec_create_time"));
        return ebCommentMapper.selectPage(page,null);
    }

    public boolean save(EbComment ebComment){
        String createTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        ebComment.setEcCreateTime(createTime);
        return ebCommentMapper.insert(ebComment)>0?true:false;
    }
}
