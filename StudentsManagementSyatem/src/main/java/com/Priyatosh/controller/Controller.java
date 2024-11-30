package com.Priyatosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Priyatosh.entity.Student;
import com.Priyatosh.service.StudentService;

import org.springframework.ui.Model;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/home")
	public String home() {
		
		return "home"; //view page html file -> home.html
	}
	
	
    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // View page: students.html
    }
    
    @GetMapping("students/new")
    public String createStudentForm(Model model) {
        Student student = new Student(); // To hold the student object
        model.addAttribute("students", student); // Attribute name should be 'student', not 'students'
        return "create-student"; // Thymeleaf view page
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
    	studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getById(id));
        return "edit_student"; // View page: edit_student.html
    }

    @PostMapping("/students/update/{id}") // Changed from GET to POST and updated the URL
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
        Student existingStudent = studentService.getById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }
    @GetMapping("/students/{id}")
    public String deleteById(@PathVariable int id) {
    	studentService.deleteById(id);
    	 return "redirect:/students";
    	
    }
}
