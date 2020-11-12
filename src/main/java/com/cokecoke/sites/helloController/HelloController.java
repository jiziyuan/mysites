package com.cokecoke.sites.helloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "index";
    }

   /* @RequestMapping("/hi")
    public ModelAndView sayHallo(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("key",123456);
        return mv;
    }*/
}
