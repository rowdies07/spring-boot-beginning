package com.rowdies.springbootbeginning.controller;

import com.rowdies.springbootbeginning.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String getHome() {
        return "<h1>Hello World<h1>";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("Ravindra");
        user.setEmailId("ravindra@gmail.com");

        return user;
    }

    @GetMapping("/{id1}/{id2}")
    public String pathVariable(@PathVariable String id1, @PathVariable("id2") String name) {
        return "Path Variables are : " + id1 + " , "+ name;
    }

    @GetMapping("/request")
    public String requestParam(@RequestParam String name,
                               @RequestParam(name="email", required = false, defaultValue = "no email provided") String emailId){
        return "Request Params are : " + name + "," +emailId;
    }
}
