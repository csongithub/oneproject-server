/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.Machine;
import com.oneproject.repository.MachineRepository;

/**
 * @author chandan
 *
 */
@Component
public class MachinePersistence extends AbstractPersistence {
	
	private static final String GET_MACHINES_BY_CLIENT_ID = "select m from Machine m where m.clientId = ?1";
	
	@Autowired
	private MachineRepository repository;
	
	
	
	public void addMachine(Machine machine) {
		repository.save(machine);
	}
	
	
	
	public List<Machine> getClientMachines(Long clientId){
		try {
			TypedQuery<Machine> query = em.createQuery(GET_MACHINES_BY_CLIENT_ID, Machine.class);
			query.setParameter(1, clientId);
			return query.getResultList();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	
	
	public Machine getMachineById(Long machineId) {
		try {
			Machine machine = repository.getOne(machineId);
			return machine;
		}catch(NoResultException e) {
			return null;
		}
	}

}
