package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class SecurityController {

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }


    @GetMapping("/login")
    public String login( Model model){

        return "login";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }


//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response, @PageableDefault(value = 3) Pageable pageable){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//            Cookie cookie = new Cookie("remember-me", "");
//            cookie.setMaxAge(0);
//            response.addCookie(cookie);
//        }
//
//        return "redirect:/";
//    }
}
