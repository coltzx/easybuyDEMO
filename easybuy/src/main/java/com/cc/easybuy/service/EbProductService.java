package com.cc.easybuy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.easybuy.mapper.EbProductMapper;
import com.cc.easybuy.model.EbProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    public void addCar(int epId, HttpServletRequest request){
        EbProduct newProduct = ebProductMapper.selectById(epId);
        HttpSession session = request.getSession();
        List<EbProduct> list = null;
        list = (List<EbProduct>)session.getAttribute("car");
        if (list==null){
            list = new ArrayList<>();
        }
        list.add(newProduct);
        session.setAttribute("car",list);
    }
}
