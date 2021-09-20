package com.codel.jpa.controller;

import com.codel.jpa.mapper.UserRepository;
import com.codel.jpa.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("findName")
    public String findName(int id, Model model) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            String name = user.getName();
            String email = user.getEmail();
            model.addAttribute("name", name);
            model.addAttribute("email", email);
        }
        return "getName";
    }
}
