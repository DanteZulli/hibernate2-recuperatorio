package com.grupo25.test;

import org.hibernate.Session;
import com.grupo25.dao.HibernateUtil;

public class TestHBM {

	public static void main(String[] args) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    session.close();
	    System.out.println("OK Hola");
	}
}
