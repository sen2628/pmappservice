/**
 * 
 */
package com.learn.pmapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.dao.ParentTaskDao;
import com.learn.pmapp.repository.ParentTaskRepository;

/**
 * @author 137499
 *
 */
@Component
public class ParentTaskDaoImpl implements ParentTaskDao {
	
	@Autowired
	public ParentTaskRepository parentTaskRepository;

}
