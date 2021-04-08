package com.hibernate.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Student cvqtko = new Student();
		cvqtko.setId(1);
		cvqtko.setName("Cvqtko");
		cvqtko.setCourse("Hibernate");

		Configuration con = new Configuration();

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		session.save(cvqtko);
	}
}
