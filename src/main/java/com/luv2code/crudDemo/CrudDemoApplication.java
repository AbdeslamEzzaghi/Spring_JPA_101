package com.luv2code.crudDemo;

import com.luv2code.crudDemo.dao.StudentDAO;
import com.luv2code.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		Integer id = 2;
		Student student = studentDAO.findById(id);
		System.out.println("Retrieving student with id: "+id+" ...");
		System.out.println(student);

	}

	private void createStudent(StudentDAO studentDAO) {
		Student newStudent = new Student("Ayoub","Lkaabi","KaabiNueve@luv2code.com");

		System.out.println("Saving the student .........");
		studentDAO.save(newStudent);

		System.out.println("Saved student. Generated ID :"+newStudent.getId());
	}
}
