package com.hibernate.demo.two;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateRetrieveARecord {
	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Student.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Student student = session.get(Student.class, 1);
		
		System.out.println(student);
		
		transaction.commit();
		session.close();
	}

}


