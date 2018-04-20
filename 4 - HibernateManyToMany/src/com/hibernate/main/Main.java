package com.hibernate.main;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) 
	{
		UserAccount userAccount = new UserAccount();

		userAccount.setUserName("MasterWill");
		userAccount.setAuthority("ROLE_ADMIN");
		userAccount.setEnabled(true);
		userAccount.setPassword("Bill2010");
		userAccount.setDateCreated(new Date());

		Employee employee = new Employee();

		employee.setDepartment("Internet Services");
		employee.setEmployeeName("William Zhou");
		employee.setEmployeeType("CONTRACTOR");
		employee.setJobTitle("Senior Software Developer");
		employee.setEmploymentStatus("Employed");
		employee.setGlobalIdentifier("C221860");
		employee.setJoinedDate(new Date());
		employee.setManager("Eddie Cue");
		employee.setWorkEmail("williamkzhou@hotmail.com");
		employee.setWorkTelephone("07464322535");

		Asset asset = new Asset();
		asset.setName("MOBILE DEVICE");
		asset.setAssetCondition("NEW");
		
		Asset asset2 = new Asset();
		asset2.setName("DESKTOP");
		asset2.setAssetCondition("NEW");
		
		OfficeAddress officeAddress = new OfficeAddress();
		
		officeAddress.setBuildingNumber(1);
		officeAddress.setDeskNumber("2C-LH14");
		officeAddress.setStreet("The Oval");
		officeAddress.setCity("London");
		officeAddress.setCounty("Greater London");
		officeAddress.setCountry("United Kingdom");
		officeAddress.setPostCode("GI2 7TS");
	
		employee.getAssets().add(asset);
		employee.getAssets().add(asset2);
		employee.setUserAccount(userAccount);
		employee.setOfficeAddress(officeAddress);
		
		asset.getEmployeeList().add(employee);

		try {
			// create a session factory for creating sessions
			SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
					.buildSessionFactory();

			// create a session from the SessionFactory
			Session session = sessionFactory.openSession();

			session.beginTransaction();
			session.save(userAccount);
			session.save(employee);
			session.save(asset);
			session.save(asset2);
			session.save(officeAddress);
			session.getTransaction().commit();

			session.close();

			userAccount = null;
			session = sessionFactory.openSession();

			userAccount = (UserAccount) session.get(UserAccount.class, 1);
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("A hibernate exception has been triggered");
		}
	}

}
