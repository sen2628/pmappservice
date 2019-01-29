package com.learn.pmapp.business;

import java.util.List;

import com.learn.pmapp.dto.ProjectDto;
import com.learn.pmapp.model.Project;

public interface ProjectBusiness {
	
public Project save(Project project);
	
	public List<Project> findAll();
	
	public void deleteProject(Project project);

	public Project findById(int id);

	public List<ProjectDto> viewProjects();

}
