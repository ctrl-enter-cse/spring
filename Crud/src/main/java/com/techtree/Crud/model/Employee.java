package com.techtree.Crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_Details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name", nullable=false)
	private String fname=null;
	@Column(name="last_name", nullable=false)
	private String lname=null;
	@Column(name="email", nullable=false)
	private String email=null;
	@OneToOne
	private Laptop laptop;

//	public Employee(long id, String fname, String lname, String email) {
//		super();
//		this.id = id;
//		this.fname = fname;
//		this.lname = lname;
//		this.email = email;
//	}
	
	public long getId() {
		return id;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
		System.out.println(fname);
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
		System.out.println(lname);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", laptop="
				+ laptop + "]";
	}
	
	
	
}
