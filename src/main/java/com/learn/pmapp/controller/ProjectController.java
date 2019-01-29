package com.learn.pmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.pmapp.business.ProjectBusiness;
import com.learn.pmapp.dto.ProjectDto;
import com.learn.pmapp.model.Project;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	public ProjectBusiness projectBusiness;
	

	@PostMapping("/add")
	public Project addProject(@RequestBody Project Project) {
		//todo - need to check unnique employee id
		return projectBusiness.save(Project);
	}
	
	@GetMapping("/")
	public List<Project> fetchAllProjects() {
		
		return projectBusiness.findAll(); 
	}
	
	@GetMapping("/view")
	public List<ProjectDto> viewProjects() {
		return projectBusiness.viewProjects();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable(value="id") int id, @RequestBody Project project) {
		Project proj = projectBusiness.findById(id);
		if (proj == null) {
			return ResponseEntity.notFound().build();
		}
		
		proj.setProjectDesc(project.getProjectDesc());
		proj.setProjectUser(project.getProjectUser());
		proj.setStartDate(project.getStartDate());
		proj.setEndDate(project.getEndDate());
		proj.setPriorityId(project.getPriorityId());
		
		
		Project empUpdated = projectBusiness.save(proj);
		
		return ResponseEntity.ok().body(empUpdated);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Project> deleteProject(@PathVariable(value="id") int id) {
		
		Project emp = projectBusiness.findById(id);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		projectBusiness.deleteProject(emp);
		return ResponseEntity.ok().build();
		
	}
	

}
