package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SampleController  {

	
	@Autowired
	MyRepository repo;
//    pivate static final String RESOURCE_URL = "http://localhost:8082/spring-rest";
    
    @Autowired
    private RestTemplate restTemplate;

     @Autowired
    public SampleController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }
    
     
    @GetMapping(value="/studentd")
    public Student[] getMethodName(Student student) {
    	
    	 ResponseEntity<Student[]> responseEntity=restTemplate.getForEntity("http://localhost:8080/students",Student[].class);
        return responseEntity.getBody();
    } 
    
   
    	
   @PostMapping(value="/student")
    	public ResponseEntity<Student> postMethodName(@RequestBody Student student) {
	   HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Student> requestEntity = new HttpEntity<Student>(student, headers);
	      ResponseEntity<Student> responseEntity=restTemplate.postForEntity("http://localhost:8080/students",student,Student.class);
	      responseEntity.getBody();
	      Student save = repo.save(student);
    
    		return new ResponseEntity<Student>(HttpStatus.OK);
    	}
   @PutMapping("/student/{Rollno}")
   public ResponseEntity<Student> putMethodName(@PathVariable Long Rollno, @RequestBody  Student student) {
 
	   HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Student> requestEntity = new HttpEntity<Student>(student, headers);
	      restTemplate.put("http://localhost:8080/students/"+Rollno,student,Student.class);
       return new ResponseEntity<Student>(HttpStatus.OK);
   }
   @DeleteMapping("student/{rollno}")
   public void delete(@PathVariable Long Rollno) {
	   HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      restTemplate.delete("http://localhost:8080//students/"+Rollno);
   }

}
