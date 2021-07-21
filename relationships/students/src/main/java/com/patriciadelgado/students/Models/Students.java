package com.patriciadelgado.students.Models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name="students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(mappedBy = "students", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contact contact;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dormitorio_id")
    private Dormitorio dormitorio;

    public Students() {

    }



    public Students(Long id, String firstName, String lastName, Integer age, Contact contact, Dormitorio dormitorio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.contact = contact;
        this.dormitorio = dormitorio;
    }
    public Students(String firstName, String lastName, Integer age, Contact contact, Dormitorio dormitorio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.contact = contact;
        this.dormitorio = dormitorio;
    }



    public Students(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getFirstName() {
        return firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public Integer getAge() {
        return age;
    }



    public void setAge(Integer age) {
        this.age = age;
    }



    public Date getCreatedAt() {
        return createdAt;
    }



    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



    public Date getUpdatedAt() {
        return updatedAt;
    }



    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }



    public Contact getContact() {
        return contact;
    }



    public void setContact(Contact contact) {
        this.contact = contact;
    }



    public Dormitorio getDormitorio() {
        return dormitorio;
    }



    public void setDormitorio(Dormitorio dormitorio) {
        this.dormitorio = dormitorio;
    }



    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
