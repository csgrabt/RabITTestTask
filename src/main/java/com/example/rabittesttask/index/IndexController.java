package com.example.rabittesttask.index;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/index")
@RestController
@AllArgsConstructor
public class IndexController {

    @GetMapping
    public String index() {
       return "Welcome";
    }
}
