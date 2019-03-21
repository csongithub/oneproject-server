/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.Project;

/**
 * @author chandan
 *
 */

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
