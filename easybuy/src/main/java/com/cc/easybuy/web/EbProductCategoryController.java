package com.cc.easybuy.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.easybuy.model.EbProduct;
import com.cc.easybuy.service.EbProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product_category")
public class EbProductCategoryController {


    @Autowired
    private EbProductCategoryService ebProductCategoryService;
    @RequestMapping("/detail")
    public String detail(int epcId, Model model,
                        @RequestParam(defaultValue = "1") int psize,
                        @RequestParam(defaultValue = "8") int pageSize){
        Page<EbProduct> productPage = ebProductCategoryService.findProductBycate(psize,pageSize,epcId);
        model.addAttribute("productPage",productPage);
        return "product-list";

    }
}