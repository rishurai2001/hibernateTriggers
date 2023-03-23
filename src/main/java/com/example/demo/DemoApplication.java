package com.example.demo;

import config.HibernateUtil;
import model.Customer;
import model.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

//	public void listCustomers( ){
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//		Session session = sessionFactory.openSession( new MyInterceptor() );
//		Transaction tx = null;
//
//		try {
//			tx = session.beginTransaction();
//			List customers = session.createQuery("FROM customer").list();
//			for (Iterator iterator = customers.iterator(); iterator.hasNext();){
//				Customer customer = (Customer) iterator.next();
////				System.out.print("First Name: " + customer.getFirstName());
////				System.out.print("  Last Name: " + customer.getLastName());
////				System.out.println("  Salary: " + customer.getSalary());
//			}
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx!=null) tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);


		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


		// Create a new Customer object
		Customer customer = new Customer();
		customer.setFirstName("Rishu");
		customer.setLastName("Rai");
		customer.setEmail("rishurai@example.com");
		customer.setTotalOrders(0);


		// Get the Hibernate Session object
		Session session = sessionFactory.openSession();



		// Begin a transaction
		Transaction transaction = session.beginTransaction();

		// Save the customer object to the database
		session.save(customer);

		// Commit the transaction
		transaction.commit();

		// Close the session
		session.close();




//		 Create a new Order object
		Order order = new Order();

		order.setTotalAmount(new BigDecimal(200.00));
		order.setCustomer(customer);




		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
//		String triggerSql = "CREATE TRIGGER after_insert_order " +
//				"AFTER INSERT ON orders " +
//				"FOR EACH ROW " +
//				"UPDATE customers " +
//				"SET total_orders = total_orders + 2 " +
//				"WHERE id = NEW.customer_id;";
//		session.createNativeQuery(triggerSql).executeUpdate();
 		session.save(order);



		// Commit the transaction
		transaction.commit();

		// Close the session
		session.close();


		System.out.println("hello");
	}

}
