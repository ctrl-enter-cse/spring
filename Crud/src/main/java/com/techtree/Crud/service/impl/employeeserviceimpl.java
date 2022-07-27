package com.techtree.Crud.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techtree.Crud.model.Employee;
import com.techtree.Crud.repositary.EmployeeRepository;
import com.techtree.Crud.response.Response;
import com.techtree.Crud.service.Employeeservice;

@Service
public class employeeserviceimpl implements Employeeservice {

	@Autowired
	private EmployeeRepository employeeRepository;
	
//	@PostConstruct
//	public void initDB() {
//		List<Employee> emp = IntStream.range(1, 50)
//				.mapToObj(i->new Employee(i, "empl"+i ,"lastname"+i, "mail@gmail.com"+new Random().nextInt(100))).collect(Collectors.toList());
//		employeeRepository.saveAll(emp);
//	}
//	@Override
//	public List<Employee> saveEmployee1(List<Employee> employee) {	
//			
//					List<Employee> input=employeeRepository.saveAll(employee);
////					.save(employee);	
//					return input;
//	}

	@Override
	public ResponseEntity<Response<List<Employee>>> getemployeelist() {
		ResponseEntity<Response<List<Employee>>> re = null;
		try {
			Response<List<Employee>> res = new Response<List<Employee>>();
			if (employeeRepository.findAll() != null) {
				res.setMessage("data found");
				res.setData(employeeRepository.findAll());
				re = new ResponseEntity<Response<List<Employee>>>(res, HttpStatus.OK);
			} else {
				res.setMessage("data  not found");
				res.setData(null);
				re = new ResponseEntity<Response<List<Employee>>>(res, HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;

	}

	@Override
	public ResponseEntity<Response<Employee>> getemployeebyid(long id) {

		Response<Employee> res = new Response<Employee>();
		if (employeeRepository.findById(id) != null) {
			res.setMessage("data found");
			res.setOpData(employeeRepository.findById(id));
			return new ResponseEntity<Response<Employee>>(res, HttpStatus.FOUND);
		} else {
			res.setMessage("data  not found");
			res.setData(null);
			return new ResponseEntity<Response<Employee>>(res, HttpStatus.FOUND);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public ResponseEntity<Response<Employee>> updateemployee(Employee employee, long id) {
		Response<Employee> res = new Response<Employee>();
	
		if (employeeRepository.findById(id) != null) {
			Employee empexist = employeeRepository.getById(id);
			empexist.setFname(employee.getFname());
			empexist.setLname(employee.getLname());
			empexist.setEmail(employee.getEmail());
			res.setMessage("updated");;
			res.setData(employeeRepository.save(empexist));
			return new ResponseEntity<Response<Employee>>(res, HttpStatus.OK);
		}else {
			res.setMessage("not found");
			res.setData(null);
			return new ResponseEntity<Response<Employee>>(res, HttpStatus.NOT_FOUND);
		}
		
	}


	@Override
	public ResponseEntity<Response<Employee>> deleteEmployee(long id) {

		if (employeeRepository.findById(id) != null) {
			Response<Employee> res = new Response<Employee>();
			res.setMessage("the data is deleted");
			employeeRepository.deleteById(id);
			res.setData(null);
			return new ResponseEntity<Response<Employee>>(res, HttpStatus.OK);
		} else {
			Response<Employee> res = new Response<Employee>();
			res.setMessage("data not found");
			res.setData(null);
			return new ResponseEntity<Response<Employee>>(res, HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public List<Employee> Searchdata(String data) {

		return employeeRepository.searchData(data);
	}

	@Override
	public ResponseEntity<Response<Employee>> saveEmployee(Employee employee) {

		Response<Employee> res = new Response<Employee>();
		if (employee.getLname() != null) {

			res.setMessage("saved data");
			res.setData(employeeRepository.save(employee));
			return new  ResponseEntity<Response<Employee>>(res, HttpStatus.OK);
		} else {
			res.setMessage("error missing the data");
			res.setData(null);
			return new ResponseEntity<Response<Employee>>(res, HttpStatus.EXPECTATION_FAILED);

		}
	}

	@Override
	public ResponseEntity<Response<Employee>> updateemp(Employee name, long id) {
		Response<Employee> res = new Response<Employee>();
		
		if (employeeRepository.findById(id) != null) {
			Employee empexist = employeeRepository.getById(id);
			empexist.setFname(name.getFname());
			res.setMessage("updated");
			res.setData(employeeRepository.save(empexist));
			return new ResponseEntity<Response<Employee>>(res, HttpStatus.OK);
		}else {
			res.setMessage("not found");
			res.setData(null);
			return new ResponseEntity<Response<Employee>>(res, HttpStatus.NOT_FOUND);
		}
		
		
	}
	

	@Override
	public  List<Employee> findByfnameContaining(String fname) {
//		List<Employee> results = employeeRepository.findByEmployeeNameContainingIgnoreCase(title);
//		Response<List<Employee>> res = new Response<List<Employee>>();
//		res.setMessage("got data");
//		res.setData(results);
//		assertEquals(3, results.size());	 
//				new ResponseEntity<Response<List<Employee>>>(res, HttpStatus.OK);
				return employeeRepository.findByfnameContaining(fname);
	}

	@Override
	public List<Employee> findByfnameexactContaining(String fname) {
		
		return employeeRepository.findByfnameLike(fname);
	}

	@Override
	public ResponseEntity<Response<List<Employee>>>  findEmployeeWithSorting(String field) {
		Response<List<Employee>> res = new Response<List<Employee>>();
		res.setMessage("list foound by asc order");
		res.setData(employeeRepository.findAll(Sort.by(Sort.Direction.ASC,field)));
		return new ResponseEntity<Response<List<Employee>>>(res,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Response<Page<Employee>>> findEmpByPagination(int offset, int pagesize) {
		Response<Page<Employee>> res = new Response<Page<Employee>>();
		res.setMessage("offset of"+offset+"size"+pagesize);
		res.setData(employeeRepository.findAll(PageRequest.of(offset, pagesize)));
		return new ResponseEntity<Response<Page<Employee>>>(res,HttpStatus.OK);
	}
}
