/**
 * 
 */
package com.learn.pmapp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.business.ProjectBusiness;
import com.learn.pmapp.dao.ProjectDao;
import com.learn.pmapp.dao.TaskDao;
import com.learn.pmapp.dto.ProjectDto;
import com.learn.pmapp.model.Project;
import com.learn.pmapp.model.Task;

/**
 * @author 137499
 *
 */
@Component
public class ProjectBusinessImpl implements ProjectBusiness {
	
	@Autowired
	public ProjectDao projectDao;
	
	public TaskDao taskDao;

	@Override
	public Project save(Project project) {
		// TODO Auto-generated method stub
		return projectDao.save(project);
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return projectDao.findAll();
	}

	@Override
	public void deleteProject(Project project) {
		projectDao.deleteProject(project);
		
	}

	@Override
	public Project findById(int id) {
		// TODO Auto-generated method stub
		return projectDao.findById(id);
	}

	@Override
	public List<ProjectDto> viewProjects() {
		// TODO Auto-generated method stub
		List<Project> projects = projectDao.findAll();
		List<ProjectDto> projectDtos = new ArrayList<ProjectDto>();
		for (Project project : projects) {
			ProjectDto dto = new ProjectDto();
			dto.setProjectId(project.getProjectId());
			dto.setProjectStartDate(project.getStartDate());
			dto.setProjectEndDate(project.getEndDate());
			dto.setPriority(project.getPriorityId());
			dto.setStatus(project.getStatus().getStatusDesc());
			List<Task> completedTasks = project.getTasks().stream()
					.filter((task) -> task.getStatus().getStatusDesc().equals("Completed"))
					.collect(Collectors.toList());
			dto.setCompletedTasks(completedTasks.size());
			dto.setTotalTasks(project.getTasks().size());

			projectDtos.add(dto);
		}
		return projectDtos;
	}
	
}