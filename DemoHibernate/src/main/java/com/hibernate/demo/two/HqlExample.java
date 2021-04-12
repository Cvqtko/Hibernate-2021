package com.hibernate.demo.two;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HqlExample {
	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Student.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Student where course=:course");
		query.setString("course", "Eclipse");
		List<Student> students = query.list();

		for (Student student : students)
			System.out.println(student);

		transaction.commit();
		session.close();
	}

}
