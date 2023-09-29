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
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName=:firstName OR lastName=:lastName",Student.class);
        // order by lastName (asc by default)
        theQuery.setParameter("firstName",firstName);
        theQuery.setParameter("lastName","Lkaabi");
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateEmailByLastName(String lastName) {
        String JPQL = "UPDATE Student s SET s.email = CONCAT(SUBSTRING(s.email, 1, POSITION('@' IN s.email)-1),'@luv2score.com') WHERE s.lastName= :lastName";
        int updateId = entityManager.createQuery(JPQL).setParameter("lastName",lastName).executeUpdate();
        System.out.println(updateId+" row(s) has been updated");
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
        System.out.println("student deleted :"+student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE From Student").executeUpdate();
    }
}
