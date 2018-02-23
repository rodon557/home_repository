package com.lemon.auto.day1122;

import java.util.ArrayList;
import java.util.List;

public class StudentDairly {
	
	public static void showStudentDairly(List<Student> students){
		for (Student student : students) {
			student.dairly();
		}
	}
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		Student student1 = new PrimaryStudent("小学生", 4);
		students.add(student1);
		Student student2 = new JuniorStudent("初中生", 6);
		students.add(student2);
		Student student3 = new SuperStudent("高中生", 8);
		students.add(student3);
		showStudentDairly(students);
	}
}
