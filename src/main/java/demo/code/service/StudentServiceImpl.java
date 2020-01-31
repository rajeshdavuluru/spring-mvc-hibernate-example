package demo.code.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.code.entity.Student;
import demo.code.repository.StudentRepository;
import demo.code.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public List<Student> getStudents() {
		LOGGER.info("Enter StudentServiceImpl getStudents");
		return studentRepository.findAll();
	}

	@Transactional
	public void saveStudent(Student student) {
		studentRepository.save(student);
		
	}

	@Transactional
	public Student getStudentById(int studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Transactional
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
	}
}
