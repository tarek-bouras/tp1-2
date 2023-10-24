package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CalculatorService;

@RestController
@RequestMapping("/")
public class controller {
	// Exo 01
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/bonjour")
    public String sayBonjour() {
        return "Bonjour";
    }
    // Exo 02
    @GetMapping("/add")
    public int add(@RequestParam int num1, @RequestParam int num2) {
        return num1 + num2;
    }
    
    // Exo 03
    @PostMapping("/calculate")
    public String calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String operation) {
        double result = 0.0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    return "Erreur : Division par zéro n'est pas autorisée.";
                }
                break;
            default:
                return "Erreur : Opération arithmétique non valide.";
        }

        return "Résultat : " + result;
    }
    
    //Exo 04 : check Package : com.example.demo.service
    @Autowired
    private CalculatorService<Double> calculatorService;

}