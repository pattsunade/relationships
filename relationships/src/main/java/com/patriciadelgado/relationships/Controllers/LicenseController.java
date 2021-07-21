package com.patriciadelgado.relationships.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.patriciadelgado.relationships.Models.License;
import com.patriciadelgado.relationships.Models.Person;
import com.patriciadelgado.relationships.Services.LicenseService;
import com.patriciadelgado.relationships.Services.PersonService;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LicenseController {
    private final LicenseService licenseService;
    private final PersonService personService;

    public LicenseController(LicenseService licenseService, PersonService personService) {
        this.licenseService = licenseService;
        this.personService = personService;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @GetMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license, Model model) {
        List<Person> persons = personService.allPerson();
        model.addAttribute("persons", persons);
        model.addAttribute("license", license);
        return "/newLicense.jsp";
    }
    
    @PostMapping("/licenses/new")
    public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
        for (ObjectError error : result.getAllErrors()) {
            System.out.println(error);
                System.out.println(result.hasErrors());
            }
            System.out.println("error");
            System.out.println(result.getErrorCount());
        if (result.hasErrors()) {
            return "newLicense.jsp";
        } else {
            licenseService.createLicense(license);
            return "redirect:/persons/" + license.getPerson().getId();
        }
    }
    
}
