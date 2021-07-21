package com.patriciadelgado.students.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.patriciadelgado.students.Models.Contact;
import com.patriciadelgado.students.Models.Students;
import com.patriciadelgado.students.Services.ApiService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ContactController {
    private final ApiService apiService;

    public ContactController(ApiService apiService) {
        this.apiService = apiService;
    }
    
    @GetMapping("/contact/create")
    public String newStudent(@ModelAttribute("contact") Contact contact, Model model) {
        List<Students> students = apiService.allStudent();
        model.addAttribute("students", students);
        model.addAttribute("contact", contact);
        return "/createContact.jsp";
        }
    @PostMapping("/contact/create")
    public String create(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "/createContact.jsp";
        } else{
            apiService.createContact(contact);
            return "redirect:/students/";
        }
    }
}
