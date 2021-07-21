package com.patriciadelgado.students.Controllers;



import java.util.List;

import javax.validation.Valid;

import com.patriciadelgado.students.Models.Students;
import com.patriciadelgado.students.Services.ApiService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class StudentsController {
    private final ApiService apiService;

    public StudentsController(ApiService apiService) {
        this.apiService = apiService;
    }
    
    @GetMapping("/student/create")
    public String newStudent(
            @ModelAttribute("student") Students students) {
        return "/createStudent.jsp";
        }
    @PostMapping("/student/create")
    public String create(@Valid @ModelAttribute("student") Students students, BindingResult result) {
        if (result.hasErrors()) {
            return "/createContact.jsp";
        } else {
            apiService.createStudent(students);
            return "redirect:/contact/create";
        }
    }

    @GetMapping("/students")
    public String show(@Valid @ModelAttribute("student") Students students, Model model) {
        List<Students> studentss = apiService.allStudent();
        model.addAttribute("students", studentss);
        return "/students.jsp";
    }
    // @GetMapping("/students/{id}")
    // public String mostrarEstudiante(@PathVariable("id") Long id, Model model) {
    //     Students student = apiService.findStudent(id);
    //     model.addAttribute("student", student);
    //     return "students.jsp";
    // }
    
}
