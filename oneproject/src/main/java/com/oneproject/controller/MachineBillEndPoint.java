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
import com.oneproject.model.MachineBill;
import com.oneproject.service.MachineBillService;
import com.oneproject.wrapper.MachineBillingSummary;
import com.oneproject.wrapper.MachinePricingWrapper;

/**
 * @author a698219
 *
 */
@RestController
@RequestMapping(value = "MachineBillEndPoint")
public class MachineBillEndPoint {

	@Autowired
	private MachineBillService service;
	
	
	
	@PostMapping(value = "addBill")
	public void addBill(@RequestBody MachineBill bill) {
		service.addBill(bill);
	}
	
	
	
	@GetMapping(value = "getProjectBills/{projectid}")
	public List<MachineBill> getProjectBills(@PathVariable("projectid") Long projectid){
		return service.getProjectBills(projectid);
	}
	
	
	
	@GetMapping(value = "getMachineBills/{machineId}")
	public List<MachineBill> getMachineBills(@PathVariable("machineId") Long machineId){
		return service.getMachineBills(machineId);
	}
	
	
	
	@GetMapping(value = "getMachineBillsForProject/{machineId}/{projectId}")
	public List<MachineBill> getMachineBillsForProject(@PathVariable("machineId") Long machineId, @PathVariable("projectId") Long projectId){
		return service.getMachineBillsForProject(machineId, projectId);
	}
	
	
	
	@PostMapping(value = "generateBillByPeriod")
	public MachinePricingWrapper generateBillByPeriod(@RequestBody MachinePricingWrapper wrapper) {
		return service.generateBillByPeriod(wrapper);
	}
	
	
	
	@GetMapping(value = "getMachineBillingSummaryForProject/{machineId}/{projectId}")
	public MachineBillingSummary getMachineBillingSummaryForProject(@PathVariable("machineId") Long machineId, @PathVariable("projectId") Long projectId){
		return service.getMachineBillingSummaryForProject(machineId, projectId);
	}
}
