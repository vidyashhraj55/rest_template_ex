package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@Autowired
	StudentRepository studRepo;
	
	
	@GetMapping("/students")
	  public List<Student> retrieveAllStudents() {
	    return studRepo.findAll();
	 
	}
	@GetMapping("/students/{id}")
	public Optional<Student> retivestudent(@PathVariable long id) {
		return studRepo.findById(id);
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent( @Valid @RequestBody Student student) {
		Student savedStudent = studRepo.save(student);
		System.out.println(student.getName()+"  "+student.getRollNo()+" "+student.getCreateOn()+" "+student.getStandard());
		return ResponseEntity.ok(student) ;		
	}
	
	@PutMapping("/students/{Rollno}")
	public ResponseEntity<Student> UpdateStudent(@Valid @RequestBody Student student, @PathVariable Long Rollno){
	    Optional<Student> studentOptional = studRepo.findById(Rollno);
	    if (!studentOptional.isPresent())
	      return ResponseEntity.notFound().build();
	    student.setRollNo(Rollno);
	    studRepo.save(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
		
	}
	@DeleteMapping("/students/{id}")
	  public void deleteStudent(@PathVariable long id) {
	    studRepo.deleteById(id);
	  }
	}

	


