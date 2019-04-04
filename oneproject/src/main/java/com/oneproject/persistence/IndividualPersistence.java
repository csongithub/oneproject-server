/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.Individual;
import com.oneproject.repository.IndividualRepository;
import com.oneproject.wrapper.SummarizedIndividual;

/**
 * @author a698219
 *
 */
@Component
public class IndividualPersistence extends AbstractPersistence {
	
	private static final String GET_SUMMARIZED_INDIVIDUALS = "SELECT new com.oneproject.wrapper.SummarizedIndividual(ind.individualId, ind.firstName, ind.middleName, ind.lastName) FROM Individual ind";
	
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
	
	
	
	public List<SummarizedIndividual> getSummarizedIndividuals() {
		List<SummarizedIndividual> bookPublisherValues = em.createQuery(GET_SUMMARIZED_INDIVIDUALS,SummarizedIndividual.class).getResultList();
		return bookPublisherValues;
	}

}
