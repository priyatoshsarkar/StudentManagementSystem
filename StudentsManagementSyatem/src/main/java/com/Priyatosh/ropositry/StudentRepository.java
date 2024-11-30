package com.Priyatosh.ropositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Priyatosh.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
