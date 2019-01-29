/**
 * 
 */
package com.learn.pmapp.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.business.TaskBusiness;
import com.learn.pmapp.dao.ParentTaskDao;
import com.learn.pmapp.dao.TaskDao;

/**
 * @author 137499
 *
 */
@Component
public class TaskBusinessImpl implements TaskBusiness {
	
	@Autowired
	public TaskDao taskDao;
	
	@Autowired
	public ParentTaskDao parentTaskDao;

}
