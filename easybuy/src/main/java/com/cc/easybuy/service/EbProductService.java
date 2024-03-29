package com.cc.easybuy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.easybuy.mapper.EbProductMapper;
import com.cc.easybuy.model.EbProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<EbProduct> set = null;
        set = (Set<EbProduct>)session.getAttribute("car");
        if (set==null){
            set = new HashSet<>();
        }
        boolean flag = false;
        for(EbProduct oldEbProduct :set){
            if(newProduct.getEpId().equals(oldEbProduct.getEpId())){
                oldEbProduct.setCount(oldEbProduct.getCount()+1);
                flag = true;
                break;
            }
        }
        if(!flag){
            set.add(newProduct);
        }
        session.setAttribute("car",set);
    }



}
