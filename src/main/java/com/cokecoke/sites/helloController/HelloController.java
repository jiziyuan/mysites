package com.cokecoke.sites.helloController;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
>>>>>>> b55abfca9f9a3335ebeeb6b40b4ac5d09daff8fe
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
<<<<<<< HEAD
        return "index";
    }

   /* @RequestMapping("/hi")
    public ModelAndView sayHallo(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("key",123456);
        return mv;
    }*/
=======
        return "hello World!";
    }
>>>>>>> b55abfca9f9a3335ebeeb6b40b4ac5d09daff8fe
}
