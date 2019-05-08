/**
 * 
 */
package com.oneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oneproject.model.Machine;
import com.oneproject.persistence.MachinePersistence;

/**
 * @author chandan
 *
 */
@Service
public class MachineService {

	@Autowired
	private MachinePersistence persistence;
	
	
	
	public void addMachine(Machine machine) {
		persistence.addMachine(machine);
	}
	
	
	
	public List<Machine> getClientMachines(Long clientId){
		return persistence.getClientMachines(clientId);
	}
	
	
	
	public Machine getMachineById(Long machineId) {
		return persistence.getMachineById(machineId);
	}
}
