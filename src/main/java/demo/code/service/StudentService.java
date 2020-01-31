package demo.code.service;

import java.util.List;

import demo.code.entity.Student;

public interface StudentService {

	public List<Student> getStudents();
	public void saveStudent(Student student);
	public Student getStudentById(int studentId);
	public void deleteStudent(int studentId);
}
