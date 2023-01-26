package dio.myfirstwebapi.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome(){
        return "Welcome to my Spring Boot Web API";
    }
    
}
