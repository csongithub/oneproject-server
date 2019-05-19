/**
 * 
 */
package com.oneproject.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.Machine;
import com.oneproject.model.ProjectMachineLinkage;
import com.oneproject.persistence.IndividualPersistence;
import com.oneproject.persistence.MachinePersistence;
import com.oneproject.persistence.ProjectMachineLinkagePersistence;
import com.oneproject.wrapper.MachinePricingWrapper;
import com.oneproject.wrapper.SummarizedIndividual;

/**
 * @author chandan
 *
 */
@Service
public class MachineService {

	@Autowired
	private MachinePersistence persistence;
	
	@Autowired
	private IndividualPersistence individualPersistence;
	
	
	
	public void addMachine(Machine machine) {
		persistence.addMachine(machine);
	}
	
	
	
	public List<Machine> getClientMachines(Long clientId){
		List<Machine> machines = persistence.getClientMachines(clientId);
		for(Machine machine: machines) {
			SummarizedIndividual individual = individualPersistence.getSummarizedIndividualById(machine.getOwnerId());
			if(individual != null) {
				String ownerName = individual.getFirstName() + " " +individual.getMiddleName() +" " +individual.getLastName();
				machine.setOwnerName(ownerName);
			}
		}
		return machines;
	}
	
	
	
	public Machine getMachineById(Long machineId) {
		return persistence.getMachineById(machineId);
	}
}
