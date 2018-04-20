package com.hibernate.main;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main 
{
	public static void main(String[] args) 
	{

		Employee employee = new Employee();
		Employee employee2 = new Employee();

		EmployeeDepartment department = new EmployeeDepartment();

		employee.setEmployeeName("William Zhou");
		employee.setEmployeeType("CONTRACTOR");
		employee.setJobTitle("Senior Software Developer");
		employee.setEmploymentStatus("EMPLOYED");
		employee.setGlobalIdentifier("C221860");
		employee.setJoinedDate(new Date());
		employee.setWorkEmail("williamkzhou@hotmail.com");
		employee.setWorkTelephone("07464322535");
		employee.setDepartment(department);
		
		employee2.setEmployeeName("Bill Gates");
		employee2.setEmployeeType("CONTRACTOR");
		employee2.setJobTitle("Senior Software Developer");
		employee2.setEmploymentStatus("EMPLOYED");
		employee2.setGlobalIdentifier("C266558");
		employee2.setJoinedDate(new Date());
		employee2.setWorkEmail("billgates@microsoft.com");
		employee2.setWorkTelephone("07584565359");
		employee2.setDepartment(department);
		
		department.setCostCenterCode("CC5533");
		department.setDepartmentManager("Eddie Cue");
		department.setDepartmentDirector("Bill Gates"); 
		department.setDepartmentName("Internet Sofware and Service");
		department.getEmployee().add(employee);
		department.getEmployee().add(employee2);

		try {
			// create a session factory for creating sessions
			SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
					.buildSessionFactory();

			// create a session from the SessionFactory
			Session session = sessionFactory.openSession();

			session.clear();

			session.beginTransaction();

			session.persist(employee);
			session.persist(employee2);
			session.persist(department);

			session.getTransaction().commit();

			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("A hibernate exception has been triggered");
		}
	}
}
