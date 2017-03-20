package com.main.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author jogish
 */
@Controller
@Configuration
public class LoginController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
