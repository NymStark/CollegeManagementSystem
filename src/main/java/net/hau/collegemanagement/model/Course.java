package net.hau.collegemanagement.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Course.java
 * This is a model class represents a Course entity
 * Attributes: id, name, department, semester, max_students
 */

@Entity
@Table(name="course")
public class Course {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	 protected int id;
	 
	 @Column(name="name")
	 protected String name;
	 
	 @Column(name="department")
	 protected String department;
	 
	 @Column(name="semester")
	 protected String semester;
	 
	 @Column(name="max_students")
	 protected int max_students;
	 
	 public Course(){
		 
	 }
	 
	 public Course( String name, String department, String semester, int max_students) {
		 super();
		 this.name = name;
		 this.department = department;
		 this.semester = semester;
		 this.max_students = max_students;
	 }
	 
	 public Course(int id, String name, String department, String semester, int max_students) {
		 super();
		 this.id = id;
		 this.name = name;
		 this.department = department;
		 this.semester = semester;
		 this.max_students = max_students;
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getMax_students() {
		return max_students;
	}

	public void setMax_students(int max_students) {
		this.max_students = max_students;
	}
	 
}
