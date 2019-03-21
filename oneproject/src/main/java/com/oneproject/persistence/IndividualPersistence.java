/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.Individual;
import com.oneproject.repository.IndividualRepository;

/**
 * @author a698219
 *
 */
@Component
public class IndividualPersistence extends AbstractPersistence {
	
	@Autowired
	private IndividualRepository repository;
	
	
	
	public List<Individual> getAllIndividuals() {
		return repository.findAll();
	}
	
	
	
	public Individual getIndividualById(Long individualId) {
		return repository.findOne(individualId);
	}
	
	
	
	public List<Individual> addOrUpdateIndividual(Individual individual){
		repository.save(individual);
		return repository.findAll();
	}
	
	
	
	public List<Individual> deleteIndividualById(Long individualId) {
		Individual obj = repository.findOne(individualId);
		if(obj != null) {
			repository.delete(individualId);
		}
		return repository.findAll(); 
	}

}
