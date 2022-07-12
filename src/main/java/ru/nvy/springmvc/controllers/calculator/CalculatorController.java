package ru.nvy.springmvc.controllers.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "first", required = false) int first,
                            @RequestParam(value = "second", required = false) int second,
                            @RequestParam(value = "operation", required = false) int operation,
                            Model model){
        int result = 0;
        if(operation == 1){
            result = first + second;
        } else if (operation == 2) {
            result = first * second;
        }
        model.addAttribute("message", "Result: " + result);
        return "calculator/calculator";
    }
}
