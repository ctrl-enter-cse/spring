package com.techtree.Crud.repositary;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techtree.Crud.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long >  {


	@Query(value="SELECT * FROM employee_details emp WHERE  emp.first_name LIKE %?1% OR emp.last_name LIKE %?1% OR emp.email LIKE %?1%",nativeQuery=true)
	List<Employee>  searchData ( @Param("data") String data);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE  employee_details SET fname=%?1%  WHERE id=%?2%",nativeQuery=true)
	Employee updateemp(String newfname, long id);
	
	
	List<Employee>findByfnameContaining(String fname);
//	List<Employee> findByEmployeeNameContainingIgnoreCase(@Param("name")String name);
	List<Employee>findByfnameLike(String fname);
	
	
	// 
	List<Employee> findAllEmployee(String name);

}