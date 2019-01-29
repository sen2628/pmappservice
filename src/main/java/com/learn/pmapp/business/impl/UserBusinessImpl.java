/**
 * 
 */
package com.learn.pmapp.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.business.UserBusiness;
import com.learn.pmapp.dao.UserDao;
import com.learn.pmapp.model.User;

/**
 * @author 137499
 *
 */
@Component
public class UserBusinessImpl implements UserBusiness {
	
	@Autowired
	public UserDao userDao;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public void deleteUser(User emp) {
		userDao.deleteUser(emp);
		
	}

	
}
