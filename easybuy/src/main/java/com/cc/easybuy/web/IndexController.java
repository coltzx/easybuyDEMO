package com.cc.easybuy.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.easybuy.model.EbNews;
import com.cc.easybuy.model.EbProduct;
import com.cc.easybuy.service.EbNewsService;
import com.cc.easybuy.service.EbProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private EbProductService ebProductService;
    @Autowired
    private EbNewsService ebNewsService;
    @RequestMapping("/front")
    public String index(@RequestParam(defaultValue = "1") int psize,
                        @RequestParam(defaultValue = "8") int pageSize,
                        @RequestParam(defaultValue = "1") int newspsize,
                        @RequestParam(defaultValue = "10") int newspageSize,
                        Model model) {

        Page<EbProduct> productPage = ebProductService.list(psize,pageSize);
        Page<EbNews> newsPage = ebNewsService.list(newspsize,newspageSize);

        model.addAttribute("productPage",productPage);
        model.addAttribute("newsPage",newsPage);

        return "index";
    }
}

