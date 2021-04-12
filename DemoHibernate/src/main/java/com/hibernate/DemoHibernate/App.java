package com.hibernate.DemoHibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Student cvqtko = new Student();
		cvqtko.setId(2);
		cvqtko.setName("Viktor");
		cvqtko.setCourse("Eclipse");

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(cvqtko);
		tx.commit();
		
		cvqtko = (Student)session.get(Student.class,1);
		
		System.out.println(cvqtko);
	}
}
