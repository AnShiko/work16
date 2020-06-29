package com.geekbrains.work16.controllers;

import com.geekbrains.work16.entities.User;
import com.geekbrains.work16.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/products")
    public String showLoginForm() {
        return "Login-form";
    }

    @PostMapping("/products")
    public String Username(@RequestParam("login") String username, HttpSession session) {
        User user = userService.findByUsername(username);
        if (user != null) {
            session.setAttribute("userId", user.getId());
            return "redirect:/";
        } else {
            return "Login-form";
        }
    }

    @GetMapping("/products")
    public String logout(@NotNull HttpSession session){
        session.invalidate();
        return ("redirect:/");
    }
}
