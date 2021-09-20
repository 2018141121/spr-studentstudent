package com.codel.mybatis_plus.mybatis_plus.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.codel.mybatis_plus.mybatis_plus.entity.RespBean;
import com.codel.mybatis_plus.mybatis_plus.entity.User;
import com.codel.mybatis_plus.mybatis_plus.mapper.UserMapper;
import com.codel.mybatis_plus.mybatis_plus.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author codel
 * @since 2021-09-19
 */
@CrossOrigin
@RestController
@RequestMapping("/mybatis_plus/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userService;

    //对象解析为Json
    public String jacksonM(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);

    }

    //登录
    @PostMapping("/getUser")
    public String testUser(@RequestBody User user) throws JsonProcessingException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        QueryWrapper<User> userQueryWrapper = wrapper.eq("name", user.getName()).eq("password", user.getPassword());
        User one = userService.getOne(userQueryWrapper);
        String s = jacksonM(one);
        String not = jacksonM("fail");
        System.out.println(one);
        if (one != null) {
            return s;
        }
        return not;
    }

    //注册
    @PostMapping("/setUser")
//  @RequestBody  是在请求体里面拿到数据
    public String setUser(@RequestBody User user) {
        boolean save = userService.save(user);
        if (save) {
            return "success";
        }
        return "fail";
    }

    @CrossOrigin
    @GetMapping("/allUser")
    public String allUsers() throws JsonProcessingException {
        List<User> list = userService.list();
        return jacksonM(list);
    }

    @GetMapping("/User")
    public String getUser1() throws JsonProcessingException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        QueryWrapper<User> userQueryWrapper = wrapper.eq("name", "codel").eq("password", "codel");
        User one = userService.getOne(userQueryWrapper);
        return jacksonM(one);
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

    //*查询全部
    @GetMapping("/list")
    public Object list() {
        System.out.println("查询成功");
        List<User> getlist = userMapper.getlist();
        System.out.println(getlist);
        return getlist;
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public boolean delete(Integer id) {
        System.out.println("删除成功");
        return userService.removeById(id);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/byid")
    public Object byid(Integer id) {
        System.out.println("查询成功");
        return userService.getById(id);
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @PostMapping("/update")
    public boolean update(@RequestBody User user) {
        System.out.println("修改成功");
        return userService.updateById(user);
    }

    /**
     * 添加
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    public boolean add(@RequestBody User user) {
        System.out.println("添加成功");
        return userService.save(user);
    }

    //
    @PostMapping("/post1")
    public int getpost(@RequestBody JSONObject req) {
        Integer num1 = req.getInteger("num1");
        Integer num2 = req.getInteger("num2");
        System.out.println(req);
        return num1 + num2;
    }

    @PostMapping("/login1")
    public String testUser1(@RequestBody JSONObject user) throws JsonProcessingException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        QueryWrapper<User> userQueryWrapper = wrapper.eq("name", user.getString("name"))
                .eq("password", user.getString("password"));
        User one = userService.getOne(userQueryWrapper);
        if (one != null) {
            return "success";
        }

        return "fail";
    }

    //注册
    @PostMapping("/setUser1")
//  @RequestBody  是在请求体里面拿到数据
    public String setUser1(@RequestBody JSONObject user) {

        JSONObject jsonObject = JSONObject.parseObject(String.valueOf(user));
        User user2 = JSON.toJavaObject(jsonObject, User.class);
        System.out.println(user2);
        boolean save = userService.save(user2);
        if (save) {
            return "success";
        }
        return "fail";
    }


    @GetMapping("/getBean")
    public RespBean getRespBean() {
        List<User> getlist = userService.getlist();
        return RespBean.ok("成功", getlist);
    }
}
