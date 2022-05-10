package net.hau.collegemanagement.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student.java
 * This is a model class represents a Student entity
 * Attributes: id, first_name, last_name, email, department, year, semester
 */

@Entity
@Table(name="student")
public class Student {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	 protected int id;
	 
	 @Column(name="first_name")
	 protected String first_name;
	 
	 @Column(name="last_name")
	 protected String last_name;
	 
	 @Column(name="email")
	 protected String email;
	 
	 @Column(name="department")
	 protected String department;
	 
	 @Column(name="year")
	 protected int year;
	 
	 @Column(name="semester")
	 protected String semester;
	 
	 public Student(){
		 
	 }
	 
	 public Student( String first_name, String last_name, String email, String department, int year, String semester) {
		 super();
		 this.first_name = first_name;
		 this.last_name = last_name;
		 this.email = email;
		 this.department = department;
		 this.year = year;
		 this.semester = semester;
	 }
	 
	 public Student(int id, String first_name, String last_name, String email, String department, int year, String semester) {
		 super();
		 this.id = id;
		 this.first_name = first_name;
		 this.last_name = last_name;
		 this.email = email;
		 this.department = department;
		 this.year = year;
		 this.semester = semester;
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	 
	 
}
