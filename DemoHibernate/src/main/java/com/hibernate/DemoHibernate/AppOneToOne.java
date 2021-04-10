package com.hibernate.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.SessionFactoryServiceRegistryBuilderImpl;

public class AppOneToOne {
	public static void main(String[] args) {

		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");

		Student student = new Student();

		student.setName("Navin");
		student.setId(1);
		student.setCourse("Java");
		student.setLaptop(laptop);
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

	
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(laptop);
		session.save(student);
		tx.commit();

		

		System.out.println();
	}
}
