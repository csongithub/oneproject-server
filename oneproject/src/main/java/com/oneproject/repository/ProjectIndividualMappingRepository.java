/**
 * 
 */
package com.oneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneproject.model.ProjectIndividualMappingKey;
import com.oneproject.model.ProjectIndividualMapping;

/**
 * @author chandan
 *
 */
public interface ProjectIndividualMappingRepository extends JpaRepository<ProjectIndividualMapping, ProjectIndividualMappingKey> {

}
