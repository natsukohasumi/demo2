package com.example.demo2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo2.form.User;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/ex-16")
public class Ex16Controller {
    
    @Autowired
    private ServletContext application;

    @RequestMapping("")
    public String index(){
        List<User> allPosts = (List<User>) application.getAttribute("posts");
        if (allPosts == null) {
            allPosts = new ArrayList<>();
            application.setAttribute("posts", allPosts);
        }

        application.setAttribute("allPosts", allPosts);

        return "ex-16";

    }

    @RequestMapping("/post")
    public String post(String name, String remarks){
        User user = new User();
        user.setName(name);
        user.setRemarks(remarks);

    List<User> allPosts = (List<User>) application.getAttribute("posts");

        allPosts.add(user);

        application.setAttribute("posts", allPosts);  
        

        return "ex-16";

    }

}
