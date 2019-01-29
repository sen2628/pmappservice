package com.learn.pmapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Table(name="project")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_id")
	private int projectId;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="priority_id")
	private int priorityId;

	@Column(name="project_desc")
	private String projectDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager_id")
	private User projectUser;
	
	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status_id")
	private Status status;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="project")
	private Set<Task> tasks;

	//bi-directional many-to-one association to UserProjectTask
	@OneToMany(mappedBy="project")
	private Set<UserProjectTask> userProjectTasks;

	public Project() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriorityId() {
		return this.priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}

	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public User getProjectUser() {
		return this.projectUser;
	}

	public void setProjectUser(User projectUser) {
		this.projectUser = projectUser;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setProject(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setProject(null);

		return task;
	}

	public Set<UserProjectTask> getUserProjectTasks() {
		return this.userProjectTasks;
	}

	public void setUserProjectTasks(Set<UserProjectTask> userProjectTasks) {
		this.userProjectTasks = userProjectTasks;
	}

	public UserProjectTask addUserProjectTask(UserProjectTask userProjectTask) {
		getUserProjectTasks().add(userProjectTask);
		userProjectTask.setProject(this);

		return userProjectTask;
	}

	public UserProjectTask removeUserProjectTask(UserProjectTask userProjectTask) {
		getUserProjectTasks().remove(userProjectTask);
		userProjectTask.setProject(null);

		return userProjectTask;
	}

}