package net.imad.hopital_spring_mvc.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController  {


    @GetMapping("/noteAuthorized")
    public String noteAuthorized(){
        return "noteAuthorized";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
