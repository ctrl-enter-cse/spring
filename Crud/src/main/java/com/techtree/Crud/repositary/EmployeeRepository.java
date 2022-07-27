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


	@Query(value="SELECT * FROM employee_details WHERE first_name  LIKE %?1% ",nativeQuery=true)
	List<Employee>  searchData ( @Param("data") String data);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE  employee_details SET fname=%?1%  WHERE id=%?2%",nativeQuery=true)
	Employee updateemp(String newfname, long id);
	
	
//	List<Employee> findByTitleContaining(String title);
	List<Employee> findByEmployeeNameContainingIgnoreCase(@Param("name")String name);
}
