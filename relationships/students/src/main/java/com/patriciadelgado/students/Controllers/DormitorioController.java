package com.patriciadelgado.students.Controllers;

import javax.validation.Valid;

import com.patriciadelgado.students.Models.Dormitorio;
import com.patriciadelgado.students.Services.ApiService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DormitorioController {
    private final ApiService apiService;

    public DormitorioController(ApiService apiService) {
        this.apiService = apiService;
    }
    @GetMapping("/dormitorio/create")
    public String newDormitorio(@ModelAttribute("dormitorio") Dormitorio dormitorio) {
        return "/createDormitorio.jsp";
    }
    @PostMapping("/dormitorio/create")
    public String create(@Valid @ModelAttribute("dormitorio") Dormitorio dormitorio, BindingResult result) {
        if (result.hasErrors()) {
            return "/createStudent.jsp";
        } else {
            apiService.createDormitorio(dormitorio);
            return "redirect:/student/create";
        }
    }
}
