package com.hibernate.main;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		UserAccount userAccount = new UserAccount();

		EmployeeAccount employee = new EmployeeAccount();

		EmployeeDepartment department = new EmployeeDepartment();

		OfficeAddress officeAddress = new OfficeAddress();

		userAccount.setUserName("lettertoromans");
		userAccount.setAuthority("ROLE_ADMIN");
		userAccount.setEnabled(true);
		userAccount.setPassword("Bill2010");
		userAccount.setDateCreated(new Timestamp(new Date().getTime()));

		employee.setEmployeeName("William Zhou");
		employee.setEmployeeType("CONTRACTOR");
		employee.setJobTitle("Senior Software Developer");
		employee.setEmploymentStatus("EMPLOYED");
		employee.setGlobalIdentifier("C221860");
		employee.setJoinedDate(new Date());
		employee.setWorkEmail("williamkzhou@hotmail.com");
		employee.setWorkTelephone("07464322535");
		employee.setDepartment(department);

		department.setCostCenterCode("CC5533");
		department.setDepartmentManager("Eddie Cue");
		department.setDepartmentDirector("Bill Gates");
		department.setDepartmentName("Internet Sofware and Service");
		department.getEmployee().add(employee);

		officeAddress.setDeskNumber("2C-LH14");
		officeAddress.setBuildingNumber("26");
		officeAddress.setStreetName("The Oval");
		officeAddress.setCity("London");
		officeAddress.setCounty("Greater London");
		officeAddress.setCountry("United Kingdom");
		officeAddress.setPostCode("GI2 7TS");

		employee.setUserAccount(userAccount);
		employee.setOfficeAddress(officeAddress);
		userAccount.setEmployee(employee);
		officeAddress.setEmployee(employee);
		
		TechAsset techAsset = new TechAsset();
		
		techAsset.setAddedOn(new Date());
		techAsset.setAssetCategory("MOBILE DEVICE");
		techAsset.setAssetBarCode("TA0044");
		techAsset.setAssetCondition("NEW");
		techAsset.setAssetStatus("AVAILABLE");
		techAsset.setAssetBarCode("BB000333333");
		techAsset.setAssignedOffice("London");
		techAsset.setAssetModel("iPhone 7");
		techAsset.setCostCenterPrice(500);
		techAsset.setAssetManufacturer("Apple");
		techAsset.setMaintenanceDate(new Date());
		techAsset.setProductName("Apple Iphone 7");
		techAsset.setPurchaseDate(new Date());
		techAsset.setSerialNumber("123456789");
		techAsset.setUnitsAvailable(5);
		techAsset.setWarrantyExpirationDate(new Date());
		
		EmployeeOrder employeeOrder = new EmployeeOrder();
		
		OrderInformation orderInformation = new OrderInformation();
		
		orderInformation.setEmployeeOrder(employeeOrder);
		orderInformation.setOrderAmount(1000.00);
		orderInformation.setQuantity(2);
		orderInformation.setPrice(500);
		orderInformation.setTechAsset(techAsset);
		
		employeeOrder.setUserAccount(userAccount);
		employeeOrder.setOfficeAddress(officeAddress);
		employeeOrder.setOrderAmount(100.00);
		employeeOrder.setOrderNumber("ON" + new Timestamp(new Date().getTime()));
		employeeOrder.setOrderDate(new Date());
		employeeOrder.setOrderStatus(OrderStatus.APPROVED);
		employeeOrder.getOrderInformation().add(orderInformation);

		try {
			// create a session factory for creating sessions
			SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
					.buildSessionFactory();

			// create a session from the SessionFactory
			Session session = sessionFactory.openSession();

			session.clear();

			session.beginTransaction();

			session.persist(userAccount);
			session.persist(employee);
			session.persist(officeAddress);
			session.persist(department);
			session.persist(orderInformation);
			session.persist(employeeOrder);
			session.persist(techAsset);

			session.getTransaction().commit();

			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("A hibernate exception has been triggered");
		}
	}

}
