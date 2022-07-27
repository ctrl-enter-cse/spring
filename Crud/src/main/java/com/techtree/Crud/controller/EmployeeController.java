package com.techtree.Crud.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techtree.Crud.model.Employee;
import com.techtree.Crud.response.Response;
import com.techtree.Crud.service.Employeeservice;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private  Employeeservice  employeeservice;

	//build create emplye restapi
	@PostMapping("/saveemployee")
	public  ResponseEntity<Response<Employee>> saveEmployee( @RequestBody Employee employee){
		System.out.println(employee);
		return employeeservice.saveEmployee(employee);
		
	}
	
	@GetMapping( path="/getemployeelist")
	public ResponseEntity<Response<List<Employee>>> getemployeelist(){
		return employeeservice.getemployeelist() ;		
	}
	@GetMapping("/byid/{id}")
	public  ResponseEntity<Response<Employee>> getEmployeebyid(@PathVariable("id") long id){	
		return employeeservice.getemployeebyid(id);	

	}
 
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Response<Employee>>  updateEmployee( @PathVariable ("id") long id,@RequestBody Employee employee){	
		return employeeservice.updateemployee(employee, id) ;	
	} 

	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteEmployee (@PathVariable("id") long id){
		employeeservice.deleteEmployee(id);
		return new ResponseEntity<String>("Deleted ",HttpStatus.OK) ;
	}
	
	@GetMapping("/searchdata")
	public ResponseEntity<List<Employee> > searchdata(@RequestParam("data") String data){
		return new ResponseEntity<List<Employee>>(employeeservice.Searchdata(data),HttpStatus.OK );
	}
//	@PostMapping("/newlist")
//	public  List<Employee> saveEmployee1( @RequestBody  List<Employee> employee){
//		
//		return employeeservice.saveEmployee1( employee);	
//	}
 	
	@PutMapping("/updatefname/{id}")
	public  ResponseEntity<Response<Employee>> updatename(@RequestBody Employee name ,@PathVariable("id") long id) {
		return employeeservice.updateemp(name, id) ;		
	}
	
	@GetMapping("/searchby")
	public List<Employee> findByTitleContaining( @RequestParam("title") String title){
		return employeeservice.findByfnameContaining(title);
	}
	@GetMapping("/searchbyexact")
	public List<Employee> findByTitleLike( @RequestParam("title") String title){
		return employeeservice.findByfnameexactContaining(title);
	}
	
}
