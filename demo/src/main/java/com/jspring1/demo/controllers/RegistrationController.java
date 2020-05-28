package com.jspring1.demo.controllers;

import com.jspring1.demo.model.Post;
import com.jspring1.demo.model.User;
import com.jspring1.demo.model.UserModel;
import com.jspring1.demo.repo.Role;
import com.jspring1.demo.repo.UserRepository;
//import com.jspring1.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
@Slf4j
public class RegistrationController extends BaseController{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "registration";
    }

    @GetMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute(LAYOUT_MAIN_CONTENT, "/registration.html");
        model.addAttribute("userModel", new UserModel());

        return "register";
    }
    @PostMapping(value = "/registration")
    public String register(@Valid UserModel userModel, BindingResult result, Model model) {
        System.out.println(userModel);
        User user = new User(userModel.getName(), userModel.getPassword());
        userRepository.save(user);
        /*
        if (!result.hasErrors()) {
            try {
                User user = userService.create(userModel);
                if (user != null) {
                    log.info("user info : {}", user);
                    return "redirect:/login";
                }
            } catch (Exception e) {
                log.error(e.getMessage());
                if (e.getMessage().contains("E11000 duplicate key")) {
                    result.rejectValue("user", null, "이미 존재하는 이메일 입니다.");
                } else {
                    throw e;
                }
            }
        }
        model.addAttribute("result", result);
        model.addAttribute("userModel", userModel);
        model.addAttribute(LAYOUT_MAIN_CONTENT, "/user/register.html");*/

        return "redirect:/login";
    }

}

