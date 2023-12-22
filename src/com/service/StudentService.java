package com.service;

import java.util.List;

import com.model.Student;
import com.repository.StudentRepository;

public class StudentService {
StudentRepository studentRepository=new StudentRepository();
public void TestDB() {
	studentRepository.dbConnect();
	studentRepository.dbClose();
}
public void insert(int id, String name, String city, String subject) {
	// TODO Auto-generated method stub
	studentRepository.insert(id,name,city,subject);
}
public List<Student> getAll() {
	// TODO Auto-generated method stub
	List<Student> students=studentRepository.getAll();
	return students;
}
public void deleteById(int id) {
	// TODO Auto-generated method stub
	studentRepository.deleteById(id);
}
public void update(int id, String name, String city, String subject) {
	// TODO Auto-generated method stub
	
	studentRepository.update(id,name,city,subject);
}
public int checkId(int id) {
	// TODO Auto-generated method stub
	return studentRepository.checkId(id);
}
}
