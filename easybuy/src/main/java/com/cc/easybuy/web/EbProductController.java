package com.cc.easybuy.web;

import com.cc.easybuy.model.EbProduct;
import com.cc.easybuy.service.EbProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class EbProductController {
    @Autowired
    private EbProductService ebProductService;
    @RequestMapping("/detail")
    public String detail(Model model, int epId){
        EbProduct ebProduct = ebProductService.detail(epId);

        model.addAttribute("product",ebProduct);
        return "product-view";

    }
}