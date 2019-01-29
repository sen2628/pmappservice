package com.learn.pmapp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the project_user database table.
 * 
 */
@Entity
@Table(name="project_user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;

	@Column(name="employee_id")
	private int employeeId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to UserProjectTask
	@OneToMany(mappedBy="projectUser")
	private Set<UserProjectTask> userProjectTasks;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<UserProjectTask> getUserProjectTasks() {
		return this.userProjectTasks;
	}

	public void setUserProjectTasks(Set<UserProjectTask> userProjectTasks) {
		this.userProjectTasks = userProjectTasks;
	}

	public UserProjectTask addUserProjectTask(UserProjectTask userProjectTask) {
		getUserProjectTasks().add(userProjectTask);
		userProjectTask.setProjectUser(this);

		return userProjectTask;
	}

	public UserProjectTask removeUserProjectTask(UserProjectTask userProjectTask) {
		getUserProjectTasks().remove(userProjectTask);
		userProjectTask.setProjectUser(null);

		return userProjectTask;
	}

}