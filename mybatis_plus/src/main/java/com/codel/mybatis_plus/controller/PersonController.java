package com.codel.mybatis_plus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codel.mybatis_plus.pojo.Person;
import com.codel.mybatis_plus.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/getperson")
    public String getPerson(Model model) {
        List<Person> personAll = personService.getPersonAll();
        model.addAttribute("persons", personAll);
        return "person/List";
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

}
