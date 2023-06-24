package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

// 在templates目录下的所有页面，只能通过controller来跳转
// 这个需要目标引擎的支持! thymeleaf; 导入对应的依赖就可以了。我们可以将html放在我们的templates目录下即可
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String index(Model model){
        model.addAttribute("msg","<h1>hello,springboot</h1>");

        model.addAttribute("users", Arrays.asList("qinjiang","kuangsheng"));
        return "test";
    }
}
