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
//			createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("umakant","mishra","umakant@gmail.com");

		//save the student
		System.out.println("Saving the student object");
		studentDAO.save(tempStudent);


		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+ theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving the student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + myStudent);

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
