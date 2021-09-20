package com.codel.bolg.controller;

import com.codel.bolg.pojo.User;
import com.codel.bolg.service.impl.UserServiceImpl;
import com.codel.bolg.util.PageRequest;
import com.codel.bolg.util.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.selectPage();
    }


    @PostMapping("/getPage")
    public String getPage(@RequestBody PageRequest pageRequest, Model model) {

        PageResult page = userService.findPage(pageRequest);
        model.addAttribute("page", page);
        return "UserPage";
    }

    @GetMapping("/getpage2/{pageNum}")
    public String getpageTest(@PathVariable("pageNum") Integer pageNum, Model model) {

        Page<Object> objects = PageHelper.startPage(pageNum, 2);
        List<User> users = userService.selectPage();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        List<User> list = userPageInfo.getList();
        model.addAttribute("userPageInfo", userPageInfo);
        model.addAttribute("page", list);
        return "UserPage";

    }

}
