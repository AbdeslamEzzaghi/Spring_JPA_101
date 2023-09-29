package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();

    void update(Student student);
    void updateEmailByLastName(String lastName);
}
