/**
 * 
 */
package com.oneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneproject.model.Machine;
import com.oneproject.service.MachineService;
import com.oneproject.wrapper.MachinePricingWrapper;

/**
 * @author a698219
 *
 */
@RestController
@RequestMapping(value = "MachineEndPoint")
public class MachineEndPoint {
	
	@Autowired
	private MachineService service;
	
	
	@PostMapping(value = "addMachine")
	public void addMachine(@RequestBody Machine machine) {
		service.addMachine(machine);
	}
	
	
	
	@GetMapping(value = "getClientMachines/{clientId}")
	public List<Machine> getClientMachines(@PathVariable("clientId")Long clientId){
		return service.getClientMachines(clientId);
	}
	
	
	
	@GetMapping(value = "getMachineById/{machineId}")
	public Machine getMachineById(@PathVariable("machineId") Long machineId) {
		return service.getMachineById(machineId);
	}
}
