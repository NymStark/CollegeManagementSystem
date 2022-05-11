package net.hau.collegemanagement.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Faculty.java
 * This is a model class represents a Faculty entity
 * Attributes: id, first name, last name, email, department
 */

@Entity
@Table(name="faculty")
public class Faculty {

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
	  
	 public Faculty(){
		 
	 }
	 
	 public Faculty( String first_name, String last_name, String email, String department) {
		 super();
		 this.first_name = first_name;
		 this.last_name = last_name;
		 this.email = email;
		 this.department = department;
	 }
	 
	 public Faculty(int id, String first_name, String last_name, String email, String department) {
		 super();
		 this.id = id;
		 this.first_name = first_name;
		 this.last_name = last_name;
		 this.email = email;
		 this.department = department;
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
	 
}
