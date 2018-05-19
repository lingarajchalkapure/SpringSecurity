package com.tvd.security.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SecDaoImp {

	@Autowired
	private SessionFactory sf;

	@Transactional
	public Integer getUserId(String username, String password) {
		return (Integer) sf.getCurrentSession().createSQLQuery("SELECT id "
				+ "FROM Register WHERE username='"+username+"' AND PASSWORD='"+password+"'").uniqueResult();
	}
	
	
	
	
}
