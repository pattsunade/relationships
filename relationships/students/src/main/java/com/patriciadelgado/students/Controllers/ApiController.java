package com.patriciadelgado.students.Controllers;

import java.util.List;

import com.patriciadelgado.students.Models.Contact;
import com.patriciadelgado.students.Models.Dormitorio;
import com.patriciadelgado.students.Models.Students;
import com.patriciadelgado.students.Services.ApiService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final ApiService apiService;
    
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/students")
    public List<Students> index() {
        return apiService.allStudent();
    }
    @PostMapping("/api/students/create")
    public Students create(@RequestParam(value = "firstName") String firstName,
    @RequestParam(value ="lastName") String lastName,
            @RequestParam(value = "age") Integer age) {
        Students students = new Students(firstName, lastName, age);
        return apiService.createStudent(students);
    }
    @PostMapping("/api/contacts/create")
    public Contact createContact(@RequestParam(value = "student") Long id,
    @RequestParam(value ="address") String address,
     @RequestParam(value = "city") String city,
            @RequestParam(value = "state") String state) {
        Students student = apiService.findStudent(id);
        Contact contact = new Contact(address, city, state, student);
        return apiService.createContact(contact);
    }

    @RequestMapping("/api/dormitorio")
    public List<Dormitorio> inicio() {
        return apiService.allDormitorio();
    }
    @RequestMapping("/api/dormitorio/{id}")
    public List<Students> show() {
        return apiService.allStudent();
    }
    @PostMapping("/api/dormitorio/new")
    public Dormitorio newDormitorio(@RequestParam(value = "name") String name) {
        Dormitorio dormitorio = new Dormitorio(name);
        return apiService.createDormitorio(dormitorio);
    }
    @PostMapping("/api/dormitorio/{id}/create")
    public Students createStudents(@PathVariable("id") Long id,
            @RequestParam(value = "students") Long idStudent) {
        Dormitorio dormitorio = apiService.findDormitorio(id);
        Students students = apiService.findStudent(id);
        students.setDormitorio(dormitorio);
        return apiService.createStudent(students);
    }
    @PutMapping("/api/dormitorio/{id}/eliminar")
    public Students remove(@PathVariable("id") Long id, 
            @RequestParam(value = "student") Long idstudent) {
        Students students = apiService.findStudent(id);
        students.setDormitorio(null);
        return apiService.createStudent(students);
    }

    
}
