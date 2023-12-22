package com.controller;

import java.util.*;

import com.model.Student;
import com.service.StudentService;

public class StudentController {
	public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	StudentService studentService=new StudentService();
while(true) {
	System.out.println("********Student Options********");
	System.out.println("1.Insert");
	System.out.println("2.Update");
	System.out.println("3.Delete");
	System.out.println("4.Get all Students");
	System.out.println("0.exit");
	int input=sc.nextInt();
	if(input==0) {
		System.out.println("Exiting the menu");
		break;
	}
	switch(input) {
	case 1:{
		System.out.println("Insert Student");
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		sc.nextLine(); // Consume newline after nextInt()

		System.out.println("Enter name:");
		String name = sc.nextLine(); // Use trim() to remove leading/trailing spaces

		System.out.println("Enter city:");
		String city = sc.nextLine();

		System.out.println("Enter subject:");
		String subject = sc.nextLine();

		//System.out.println("Read input");

		studentService.insert(id, name, city, subject);
//		studentService.TestDB();
		break;
	}
	case 2:{
		System.out.println("Updating student");
		System.out.println("Enter id: ");
		int id=sc.nextInt();
		sc.nextLine();
		int status=studentService.checkId(id);
		if(status==1) {
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		System.out.println("Enter city: ");
		String city=sc.nextLine();
		System.out.println("Enter subject: ");
		String subject=sc.nextLine();
		System.out.println(name+" "+city+" "+subject);
		studentService.update(id,name,city,subject);
		}
		break;
	}
	case 3:{
		System.out.println("Deleting student");
		System.out.println("Enter id to check whether student is there or not");
		int id=sc.nextInt();
		studentService.deleteById(id);
		break;
	}
	case 4:{
		System.out.println("Getting all the students");
		List<Student> students= studentService.getAll();
		for(Student s: students) {
			System.out.println(s);
		}
		break;
	}
	default:{
		System.out.println("Invalid Input try again");
		break;
	}
	}
}
}
}