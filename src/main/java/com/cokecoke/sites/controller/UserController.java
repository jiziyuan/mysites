package com.cokecoke.sites.controller;

import com.cokecoke.sites.domain.User;
import com.cokecoke.sites.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 1、查询所有的符合条件的用户信息，并分页给界面
* 2、编辑方法从数据库中查询需要的数据
* 3、存储方法吧新增的用户或编辑后用户信息存储到数据库
* 4、删除用户
* 5、锁定用户，有效状态*/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*
    * 根据条件查询用户信息*/
    @RequestMapping("listusers")
    public String list(String kw, Model model, Pageable pageable){
        Page<User> ppu = userService.findAll(kw,pageable);//默认分页从 0 页（第一页），每页去 20 条数据
        model.addAttribute("pages",ppu);
        return "listusers";
    }

    /*
    * 新增&修改
    * @PathVariable 绑定路径变量
    * required = false 可以为空
    * */
    @GetMapping({"editusers","editusers/{uid}"})
    public String edit(@PathVariable(name = "uid",required = false)Integer uid,Model model){
        User u = new User();
        if (uid !=null && uid>0){
            u = userService.findById(uid);
        }
        model.addAttribute("user",u);
        return "edituser";
    }


    /*
    * 新增
    * @Validated 校验数据（有些数据不能为空）
    * BindingResult  处理用户信息的校验结果
    * */
    @PostMapping("/saveuser")
    public String save(@Validated User user, BindingResult result){
        if (result.hasErrors()){
            return "redirectr:/edituser";
        }
        userService.save(user);
        return "redirect:/listusers";
    }


    /*
    * 删除
    * @PathVariable 默认不为空
    * */
    @GetMapping("/delete/{uid}")
    public String delete(@PathVariable("uid")Integer uid){
        userService.deleteById(uid);
        return "redirect:/listusers";
    }















}
