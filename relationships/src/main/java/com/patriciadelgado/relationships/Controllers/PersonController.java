package com.patriciadelgado.relationships.Controllers;

import javax.validation.Valid;

import com.patriciadelgado.relationships.Models.Person;
import com.patriciadelgado.relationships.Services.PersonService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
        
    }
    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/newPerson.jsp";
    }

   @PostMapping("/persons/new")
    public String addperson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "/newLicense.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/licenses/new";
        }
    }
    @RequestMapping("persons/{id}")
    public String show(@PathVariable Long id, Model model) {
        Person person = personService.findPerson(id);
        if (person == null) {
            return "/persons/new";
        } else {
            model.addAttribute("person", person);
            return "/show.jsp";
        }
        
    }
}
