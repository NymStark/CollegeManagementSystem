package net.hau.collegemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Registration.java
 * This is a model class represents a Registration entity
 */

@Entity
@Table(name="registration")
public class Registration {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	 
	 @Column(name="id")
	 protected int id;
	 
	 @Column(name="student_id")
	 protected String student_id;
	 
	 @Column(name="courseAbbreviation")
	 protected String courseAbbreviation;
	 
	 @Column(name="semester")
	 protected String semester;
	 
	 
public Registration() {
	}

public Registration( String student_id, String courseAbbreviation, String semester) {
	super();
	this.student_id = student_id;
	this.courseAbbreviation = courseAbbreviation;
	this.semester = semester;	

}

public Registration(int id, String student_id,String courseAbbreviation,  String semester) {
	super();
	
	this.id = id;
	this.student_id = student_id;
	this.courseAbbreviation = courseAbbreviation;
	this.semester = semester;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getStudent_id() {
	return student_id;
}

public void setStudent_id(String student_id) {
	this.student_id = student_id;
}

public String getSemester() {
	return semester;
}

public void setSemester(String semester) {
	this.semester = semester;
}

public String getCourseAbbreviation() {
	return courseAbbreviation;
}

public void setCourseAbbreviation(String courseAbbreviation) {
	this.courseAbbreviation = courseAbbreviation;
}

}
