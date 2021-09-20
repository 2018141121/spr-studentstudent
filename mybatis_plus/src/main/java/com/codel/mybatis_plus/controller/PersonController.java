package com.codel.mybatis_plus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codel.mybatis_plus.pojo.Person;
import com.codel.mybatis_plus.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {
    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/getperson")
    @ResponseBody
    public String getPerson(Model model) {
        List<Person> personAll = personService.getPersonAll();
        System.out.println(personAll);
//        model.addAttribute("persons", personAll);
        return "ok";
    }

    //    分页
    @GetMapping("/testPage")
    public String page(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //构造分页参数
        Page<Person> page = new Page<>(pn, 2);
        //调用page进行分页 获得分页信息
        Page<Person> personPage = personService.page(page, null);
//        userPage.getRecords()
//        userPage.getCurrent()
//        userPage.getPages()
//        获得所有对象信息
        List<Person> records = personPage.getRecords();

        model.addAttribute("page", personPage);
        model.addAttribute("persons", records);
        return "person/List";

    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model,
                             @RequestParam(value = "pn", defaultValue = "1") int pn,
                             RedirectAttributes redirectAttributes) {

        boolean b = personService.removeById(id);
        redirectAttributes.addAttribute("pn", pn);
        return "redirect:/testPage";
    }


    //    测试小程序
    @PostMapping("/doLogin")
    public Map doLogin(String phone, String password) {
        Map map = new HashMap();
        if ((phone.equals("10086") && password.equals("123456"))) {
            map.put("code", 200);
            map.put("result", "登录成功");
            System.out.println("登录成功");
        } else {
            map.put("result", "no");
        }
        return map;

    }



}