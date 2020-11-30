package com.ziqi.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录主界面
 */
@Controller
public class IndexController {

    /**
     *
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
