package com.Priyatosh.serviseImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Priyatosh.entity.Student;
import com.Priyatosh.ropositry.StudentRepository;
import com.Priyatosh.service.StudentService;

@Service
public class ServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepositry;

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = studentRepositry.findAll();
		return list;
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepositry.save(student);
		
		
	}

	@Override
	public Student getById(int id) {
		
		return studentRepositry.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		studentRepositry.deleteById(id);
	}

}

