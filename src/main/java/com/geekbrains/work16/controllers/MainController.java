package com.geekbrains.work16.controllers;

import com.geekbrains.work16.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/form")
    public String showForm() {
        return "simple-form";
    }

    @PostMapping("/form")
    public String saveForm(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
        System.out.println(name);
        System.out.println(email);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String doSomething() {
        return "index";
    }

    @GetMapping("/hello")
    public String helloRequest(Model model, @RequestParam(value = "name") String name) {
        model.addAttribute("name", name);

        return "hello";
    }

    @GetMapping("/adduser")
    public String showAddUserForm(Model model) {
        User user = new User(1L, null, null);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/addcat")
    public String showAddUserForm(@ModelAttribute(value = "user") User user) {
        System.out.println(user.getId() + " " + user.getName() + " " + user.getRoles());
        return "redirect:/index";
    }
}
