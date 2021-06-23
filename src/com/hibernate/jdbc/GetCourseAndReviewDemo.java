package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.demo.entity.Course;
import com.hibernate.jdbc.demo.entity.Instructor;
import com.hibernate.jdbc.demo.entity.InstructorDetail;
import com.hibernate.jdbc.demo.entity.Review;

public class GetCourseAndReviewDemo {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
		
			int id = 10;
			
			System.out.println("Get courses and Review");
			
			session.beginTransaction();
			
			Course course = session.get(Course.class, id);
			
			System.out.println(course);
			
			System.out.println(course.getReview());
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
			
			
		}
		finally {
			factory.close();
		}
		
	}

}
