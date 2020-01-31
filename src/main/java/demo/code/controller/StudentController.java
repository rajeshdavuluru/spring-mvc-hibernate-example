package demo.code.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.code.entity.Student;
import demo.code.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/all")
	public String listStudents(Model model) {
		LOGGER.info("Entering listStudents");
		List<Student> studentList = studentService.getStudents();
		model.addAttribute("students", studentList);
		LOGGER.info("Exiting listStudents");
		return "studentsList";
	}
	
	@GetMapping("/form")
	public String studentForm(Model model) {
		LOGGER.debug("inside studentForm method");
		Student student = new Student();
		model.addAttribute("student", student);
		return "studentForm";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);	
		return "redirect:/student/all";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("studentId") int studentId,
									Model model){
		Student student = studentService.getStudentById(studentId);	
		model.addAttribute("student", student);
		return "studentForm";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int studentId){
		studentService.deleteStudent(studentId);
		return "redirect:/student/all";
	}
	
}
