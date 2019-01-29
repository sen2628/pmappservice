/**
 * 
 */
package com.learn.pmapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.learn.pmapp.business.TaskBusiness;

/**
 * @author 137499
 *
 */


@RestController
public class TaskController {
	
	@Autowired
	public TaskBusiness taskBusiness;

}
