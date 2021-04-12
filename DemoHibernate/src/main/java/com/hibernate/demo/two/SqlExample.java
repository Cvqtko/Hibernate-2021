package com.hibernate.demo.two;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SqlExample {
	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Student.class);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT id, name, course FROM student");

		List<Object[]> students = query.list();

		for (Object[] student : students) {
			Student s = new Student();
			s.setId((Integer)student[0]);
			s.setName(student[1].toString());
			s.setCourse(student[2].toString());
			System.out.println(s);
		}
		transaction.commit();
		session.close();
	}

}