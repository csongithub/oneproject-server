/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
	
	private static final String GET_SUMMARIZED_INDIVIDUALS = "SELECT new com.oneproject.wrapper.SummarizedIndividual(ind.individualId, ind.firstName, ind.middleName, ind.lastName, ind.position, ind.joiningDate) FROM Individual ind";
	
	private static final String GET_SUMMARIZED_INDIVIDUALS_FOR_CLIENT = "SELECT new com.oneproject.wrapper.SummarizedIndividual(ind.individualId, ind.firstName, ind.middleName, ind.lastName, ind.position, ind.joiningDate) FROM Individual ind where ind.clientId = ?1";
	
	private static final String GET_CLIENT_INDIVIDUALS = "select i from Individual i where i.clientId = ?1";
	
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
		return this.getClientIndividuals(individual.getClientId());
	}
	
	
	
	public List<Individual> deleteIndividualById(Long individualId) {
		Individual obj = repository.findOne(individualId);
		if(obj != null) {
			repository.delete(individualId);
		}
		return repository.findAll(); 
	}
	
	
	
	public List<Individual> getClientIndividuals(Long clientId){
		try {
			TypedQuery<Individual> query = em.createQuery(GET_CLIENT_INDIVIDUALS, Individual.class);
			query.setParameter(1, clientId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
		
	}
	
	
	
	public List<SummarizedIndividual> getSummarizedIndividuals() {
		List<SummarizedIndividual> bookPublisherValues = em.createQuery(GET_SUMMARIZED_INDIVIDUALS,SummarizedIndividual.class).getResultList();
		return bookPublisherValues;
	}
	
	
	
	public List<SummarizedIndividual> getSummarizedIndividualsForClient(Long clientId) {
		try {
			TypedQuery<SummarizedIndividual> query = em.createQuery(GET_SUMMARIZED_INDIVIDUALS_FOR_CLIENT, SummarizedIndividual.class);
			query.setParameter(1, clientId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}

}
