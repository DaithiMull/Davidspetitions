package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyController {
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index"); // Set the view name (template file)
        return modelAndView;
    }

    @PostMapping("/submitData")
    public String submitData(@RequestParam String name, @RequestParam String email, @RequestParam String message) {
        // Process the form data here (e.g., save it to database)
        return "Data submitted successfully!";
    }

    // @GetMapping("/")
    // public String index() {
    //    return "Greetings from Spring Boot!"; // Change this to return your desired content
}

