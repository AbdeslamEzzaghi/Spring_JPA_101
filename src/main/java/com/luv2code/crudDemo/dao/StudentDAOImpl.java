package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        String firstName = "Chad";
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName=:firstName OR lasName=:lastName",Student.class);
        theQuery.setParameter("firstName",firstName);
        theQuery.setParameter("lastName","Lkaabi");
        return theQuery.getResultList();
    }
}
