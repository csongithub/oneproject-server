/**
 * 
 */
package com.oneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneproject.model.Machine;
import com.oneproject.service.MachineService;

/**
 * @author a698219
 *
 */
@RestController
@RequestMapping(value = "MachineEndPoint")
public class MachineEndPoint {
	
	@Autowired
	private MachineService service;
	
	
	public void addMachine(Machine machine) {
		service.addMachine(machine);
	}
	
	
	
	public List<Machine> getClientMachines(Long clientId){
		return service.getClientMachines(clientId);
	}
	
	
	
	public Machine getMachineById(Long machineId) {
		return service.getMachineById(machineId);
	}

}
