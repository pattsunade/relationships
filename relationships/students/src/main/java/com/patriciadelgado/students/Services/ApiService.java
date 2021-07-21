package com.patriciadelgado.students.Services;

import java.util.List;
import java.util.Optional;

import com.patriciadelgado.students.Models.Contact;
import com.patriciadelgado.students.Models.Dormitorio;
import com.patriciadelgado.students.Models.Students;
import com.patriciadelgado.students.Repositories.ContactRepository;
import com.patriciadelgado.students.Repositories.DormitorioRepository;
import com.patriciadelgado.students.Repositories.StudentsRepository;

import org.springframework.stereotype.Service;

@Service
public class ApiService {
    private final StudentsRepository studentsRepository;
    private final ContactRepository contactRepository;
    private final DormitorioRepository dormitorioRepository;



    public ApiService(StudentsRepository studentsRepository, ContactRepository contactRepository,
            DormitorioRepository dormitorioRepository) {
        this.studentsRepository = studentsRepository;
        this.contactRepository = contactRepository;
        this.dormitorioRepository = dormitorioRepository;
    }
    public List<Students> allStudent() {
        return studentsRepository.findAll();
    }
    public Students createStudent(Students students) {
        return studentsRepository.save(students);
    }

    public Students findStudent(Long id) {
        Optional<Students> optionalStudent = studentsRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }

    public List<Contact> allContact() {
        return contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact findContact(Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            return optionalContact.get();
        } else {
            return null;
        }
    }
     public List<Dormitorio> allDormitorio() {
         return dormitorioRepository.findAll();
    }

    public Dormitorio createDormitorio(Dormitorio dormitorio) {
        return dormitorioRepository.save(dormitorio);
    }

    public Dormitorio findDormitorio(Long id) {
        Optional<Dormitorio> optionalDormitorio = dormitorioRepository.findById(id);
        if (optionalDormitorio.isPresent()) {
            return optionalDormitorio.get();
        } else {
            return null;
        }
    }
    
 
}
