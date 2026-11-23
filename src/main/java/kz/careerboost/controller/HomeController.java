package kz.careerboost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projectName", "CareerBoost");
        model.addAttribute("description", "Өз болашағыңды CareerBoost арқылы құр!");
        return "index";
    }
}
