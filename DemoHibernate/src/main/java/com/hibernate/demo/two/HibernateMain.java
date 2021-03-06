package com.hibernate.demo.two;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Student.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student("Tsvyatko", "Eclipse");
		Student student2 = new Student("Georgi", "Eclipse");
		Student student3 = new Student("Vasil", "Eclipse");
		session.save(student);
		session.save(student2);
		session.save(student3);
		transaction.commit();
		session.close();
	}

}
