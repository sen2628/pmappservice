/**
 * 
 */
package com.learn.pmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.pmapp.model.Project;

/**
 * @author 137499
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
