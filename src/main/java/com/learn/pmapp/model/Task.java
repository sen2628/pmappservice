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
 * The persistent class for the tasks database table.
 * 
 */
@Entity
@Table(name="tasks")
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="task_id")
	private int taskId;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="priority_id")
	private int priorityId;

	@Temporal(TemporalType.DATE)
	@Column(name="start_dare")
	private Date startDare;

	@Column(name="task_desc")
	private String taskDesc;

	//bi-directional many-to-one association to ParentTask
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private ParentTask parentTask;

	//bi-directional many-to-one association to Project
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project;

	//bi-directional many-to-one association to Status
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status_id")
	private Status status;

	//bi-directional many-to-one association to UserProjectTask
	@OneToMany(mappedBy="task")
	private Set<UserProjectTask> userProjectTasks;

	public Task() {
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
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

	public Date getStartDare() {
		return this.startDare;
	}

	public void setStartDare(Date startDare) {
		this.startDare = startDare;
	}

	public String getTaskDesc() {
		return this.taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public ParentTask getParentTask() {
		return this.parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<UserProjectTask> getUserProjectTasks() {
		return this.userProjectTasks;
	}

	public void setUserProjectTasks(Set<UserProjectTask> userProjectTasks) {
		this.userProjectTasks = userProjectTasks;
	}

	public UserProjectTask addUserProjectTask(UserProjectTask userProjectTask) {
		getUserProjectTasks().add(userProjectTask);
		userProjectTask.setTask(this);

		return userProjectTask;
	}

	public UserProjectTask removeUserProjectTask(UserProjectTask userProjectTask) {
		getUserProjectTasks().remove(userProjectTask);
		userProjectTask.setTask(null);

		return userProjectTask;
	}

}