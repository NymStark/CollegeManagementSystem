package net.hau.collegemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Department.java
 * This is a model class represents a Student entity
 */

@Entity
@Table(name="department")
public class Department {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	 
	 @Column(name="id")
	 protected int id;
	 
	 @Column(name="name")
	 protected String name;
	 
	 @Column(name="abbreviation")
	 protected String abbreviation;
	 
	 
public Department() {
	}

public Department( String name, String abbreviation) {
	super();
	this.name = name;
	this.abbreviation = abbreviation;	

}

public Department(int id, String name, String abbreviation) {
	super();
	
	this.id = id;
	this.name = name;
	this.abbreviation = abbreviation;
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

public String getAbbreviation() {
	return abbreviation;
}

public void setAbbreviation(String abbreviation) {
	this.abbreviation = abbreviation;
}


}
