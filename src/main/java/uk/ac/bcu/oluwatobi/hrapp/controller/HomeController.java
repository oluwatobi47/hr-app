package uk.ac.bcu.oluwatobi.hrapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping()
    public String welcome() {
        return "Welcome to the app!!" +
                "\n API Docs available in path /api/v1/swagger-ui/index.html";
    }
}
