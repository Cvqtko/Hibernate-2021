package com.hibernate.DemoHibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="student")
public class Student {
	
	@Id
	private int id;
	private String name;
	private String course;

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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
}
