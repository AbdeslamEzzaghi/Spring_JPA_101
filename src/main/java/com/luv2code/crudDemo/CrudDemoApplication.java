package com.luv2code.crudDemo;

import com.luv2code.crudDemo.dao.StudentDAO;
import com.luv2code.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		// Java Lambda Expression
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			queryForStudents(studentDAO);
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentsList = studentDAO.findAll();
		for(Student tempStudent:studentsList){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Integer id = 2;
		Student student = studentDAO.findById(id);
		System.out.println("Retrieving student with id: "+id+" ...");
		System.out.println(student);

	}

	private void createStudent(StudentDAO studentDAO) {
		Student newStudent = new Student("Ray","Pin","RP@junior.com");

		System.out.println("Saving the student .........");
		studentDAO.save(newStudent);

		System.out.println("Saved student. Generated ID :"+newStudent.getId());
	}
}
