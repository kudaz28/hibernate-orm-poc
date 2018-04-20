package com.hibernate.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		try {
			// TRANSIENT OBJECT - HIBERNATE DOES NOT KNOW ABOUT THIS OBJECT
			UserAccount userAccount = new UserAccount();
			userAccount.setUserName("MasterWill");

			// create a session factory for creating sessions
			SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
					.buildSessionFactory();

			// create a session from the SessionFactory
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			// PERSISTENT OBJECT - HIBERNATE KNOWS AND KEEPS TRACK OF THE OBJECT
			// STATES
			session.save(userAccount);
			userAccount = session.get(UserAccount.class, 1);

			session.getTransaction().commit();

			// RETRIEVING A LIST OF OBJECTS
			Query query = (Query) session.createQuery("FROM UserAccount WHERE userId > 5");
			
			List<UserAccount> users = (List<UserAccount>)query.list();
			
			for(UserAccount user : users)
			{
				System.out.println(user.getUserName());
			}

			// List users = query.list();

			// Object oneObject = session.createQuery("FROM
			// Admin").getResultList();

			// After session is closed, we lose handle to the object
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("A hibernate exception has been triggered");
		}
	}
}
