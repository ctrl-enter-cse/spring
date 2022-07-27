package com.techtree.Crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.techtree.Crud.model.Employee;
import com.techtree.Crud.response.Response;

public interface Employeeservice {
//	public ResponseEntity<ResponseStructure<Stock>> saveService(Stock stock,String userId,int supplierId);
	
	public ResponseEntity<Response<Employee>> saveEmployee(Employee employee);
	
//	Employee updateEmployee(Employee employee);
	
	//getting list of emp
	public ResponseEntity<Response<List<Employee>>> getemployeelist();
	
	//getting by id
	 public ResponseEntity<Response<Employee>> getemployeebyid(long id);
	
	//updating by id and data
	 public ResponseEntity<Response<Employee>> updateemployee(Employee employee,long id);
	
	//deleting by id
	public ResponseEntity<Response<Employee>>  deleteEmployee(long id);
	
	//serch the records by data 
	List<Employee> Searchdata(String data);

//	List<Employee> saveEmployee1(List<Employee> employee);

	
	//update fname the table  records by id  
	ResponseEntity<Response<Employee>> updateemp(Employee name,long id);
	
	
	// like from with jpa onlu
	List<Employee> findByfnameContaining(String fname);
	
	//exact search
	List<Employee> findByfnameexactContaining(String fname);

	
//	search by feild 
	public ResponseEntity<Response<List<Employee>>>  findEmployeeWithSorting(String field);
		
	
	// seach by pageniation
	public  ResponseEntity<Response<Page<Employee>>> findEmpByPagination(int offset,int pagesize);
}
