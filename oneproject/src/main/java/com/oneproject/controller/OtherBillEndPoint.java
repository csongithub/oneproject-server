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

import com.oneproject.model.OtherBill;
import com.oneproject.service.OtherBillService;
import com.oneproject.wrapper.OtherBillingSummary;
import com.oneproject.wrapper.SearchCriteriaDataWrapper;

/**
 * @author chandan
 *
 */

@RestController
@RequestMapping(value = "OtherBillEndPoint")
public class OtherBillEndPoint {
	
	@Autowired
	private OtherBillService service;
	
	
	
	@PostMapping(value = "addBill")
	private void addBill(@RequestBody OtherBill bill) {
		service.addBill(bill);
	}
	
	
	
	@GetMapping(value = "getBillsForProjectId/{projectId}")
	public List<OtherBill> getBillsForProjectId(@PathVariable("projectId") Long  projectId) {
		return service.getBillsForProjectId(projectId);
	}
	
	
	
	
	@PostMapping(value = "getBillsBySearchCriteria")
	public List<OtherBill> getBillsBySearchCriteria(@RequestBody SearchCriteriaDataWrapper wrapper){
		return service.getBillsBySearchCriteria(wrapper);
	}
	
	
	
	
	@GetMapping(value = "getProjectBillingSummary/{projectId}")
	public OtherBillingSummary getProjectBillingSummary(@PathVariable("projectId")Long projectId) {
		return service.getProjectBillingSummary(projectId);
	}
}
