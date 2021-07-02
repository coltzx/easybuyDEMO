package com.cc.easybuy.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.easybuy.model.EbComment;
import com.cc.easybuy.service.EbCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comment")
public class EbCommentController {
    @Autowired
    private EbCommentService ebCommentService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(defaultValue = "1") int psize,
                       @RequestParam(defaultValue = "3") int pageSize) {
        Page<EbComment> commentPage = ebCommentService.list(psize, pageSize);
        model.addAttribute("cpage", commentPage);
        return "guestbook";
    }

    @RequestMapping("/add")
    public String add(EbComment ebComment) {
        System.out.printf("添加留言...... 留言内容为：" + ebComment);
        boolean result = ebCommentService.save(ebComment);
        if (result) {
            return "redirect:list";
        } else {
            return "error";
        }
    }
}
