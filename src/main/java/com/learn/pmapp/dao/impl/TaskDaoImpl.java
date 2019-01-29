/**
 * 
 */
package com.learn.pmapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.dao.TaskDao;
import com.learn.pmapp.repository.TaskRepository;

/**
 * @author 137499
 *
 */
@Component
public class TaskDaoImpl implements TaskDao {
	
	@Autowired
	public TaskRepository taskRepository;

}
