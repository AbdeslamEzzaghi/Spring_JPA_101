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
			//queryForStudents(studentDAO);
			//updateStudent(studentDAO);
			//updateStudentEmail(studentDAO);
			deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all rows from the Database ....");
		int numberOfRowsDeleted = studentDAO.deleteAll();
		System.out.println(numberOfRowsDeleted+" : of rows(s) has been deleted !!!");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//Student student = studentDAO.findById(3002);
		//System.out.println(student);
		studentDAO.delete(3002);
	}

	private void updateStudentEmail(StudentDAO studentDAO) {
		String theLastName = "Lkaabi";
		studentDAO.updateEmailByLastName(theLastName);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// first of all find the student that we'll update using his id
		Integer studentId = 3000;
		Student theStudent = studentDAO.findById(studentId);
		// update the student
		// Conner to Connor
		theStudent.setFirstName("Connor");
		// modify it in the dataBase
		studentDAO.update(theStudent);
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
