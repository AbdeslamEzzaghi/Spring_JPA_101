package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
}
