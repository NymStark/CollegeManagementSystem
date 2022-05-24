package net.hau.collegemanagement.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CourseAssignment.java
 * This is a model class represents a CourseAssignment entity
 * Attributes: id, course_id, faculty_id, semester	
 */

@Entity
@Table(name="courseAssignment")
public class CourseAssignment {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	 protected int id;
	 
	 @Column(name="course_id")
	 protected int course_id;
	 
	 @Column(name="faculty_id")
	 protected int faculty_id;
	 
	 @Column(name="semester")
	 protected String semester;
	  
	 public CourseAssignment(){
		 
	 }
	 
	 public CourseAssignment( int course_id, int faculty_id, String semester) {
		 super();
		 this.course_id = course_id;
		 this.faculty_id = faculty_id;
		 this.semester = semester;
	 }
	 
	 public CourseAssignment(int id, int course_id, int faculty_id, String semester) {
		 super();
		 this.id = id;
		 this.course_id = course_id;
		 this.faculty_id = faculty_id;
		 this.semester = semester;
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	 
}
