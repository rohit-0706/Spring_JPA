package com.rohit.cruddemo;

import com.rohit.cruddemo.dao.StudentDAO;
import com.rohit.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			createMultipleStudents(studentDAO);
		};
	}


	private void createMultipleStudents(StudentDAO studentDAO){

		//create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("rohit","verma","rohit@gmail.com");
		Student tempStudent2 = new Student("kartik","kashyup","kartik@gmail.com");
		Student tempStudent3 = new Student("aayush","roy","aayush@gmail.com");

		//save the student object
		System.out.println("Saving the  3 student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul","Doe","abc@gmail.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. generated id: " + tempStudent.getId());


	}

}
