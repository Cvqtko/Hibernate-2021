package com.hibernate.hibernateintro;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

	public static void main(String[] args) {

		// Create Hibernate config
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Student.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		// Create SessionFactory
		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		// Create Session
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student1 = new Student("Tsvyatko", "Eclipse");
		Student student2 = new Student("Georgi", "Eclipse");
		Student student3 = new Student("Vasil", "Eclipse");
	
		session.save(student1);
		session.save(student2);
		session.save(student3);
		transaction.commit();

		// Read entity by ID
		session.beginTransaction();
		Student result = session.get(Student.class, 10);
		transaction.commit();
		System.out.println(result.toString());

		// Read list of students
	
		List<Student> studentList = session.createQuery("From Student", Student.class).list();
		for (Student student : studentList) {
			System.out.println(student.toString());
		}
		transaction.commit();

		// Close session
		session.close();
	}

}
