package com.model;

public class Student {
private int id;
private String name;
private String city;
private String subject;
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public String getCity() {
	return city;
}
public String getSubject() {
	return subject;
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setCity(String city) {
	this.city = city;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public Student(int id, String name, String city, String subject) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.subject = subject;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", city=" + city + ", subject=" + subject + "]";
}

}
