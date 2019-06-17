/**
 * 
 */
package com.oneproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oneproject.model.SupplierBill;
import com.oneproject.service.SupplierBillService;
import com.oneproject.wrapper.SupplierBillingSummary;

/**
 * @author chandan
 *
 */
@RestController
@RequestMapping(value = "SupplierBillEndPoint")
public class SupplierBillEndPoint {
	
	@Autowired
	private SupplierBillService service;
	
	
	@PostMapping(value = "addBill")
	public void addBill(@RequestBody SupplierBill bill) {
		service.addBill(bill);
	}
	
	
	
	@DeleteMapping(value = "deleteBill/{billId}")
	public void deleteBill(@PathVariable Long billId) {
		service.deleteBill(billId);
	}
	 
	
	
	@GetMapping(value = "getBillsForProjectAndSupplier/{projectid}/{supplierId}")
	public List<SupplierBill> getBillsForProjectAndSupplier(@PathVariable("projectid") Long projectid, @PathVariable("supplierId") Long supplierId){
		return service.getBillsForProjectAndSupplier(projectid, supplierId);
	}
	
	
	
	@GetMapping(value = "getSupplierBills/{supplierId}")
	public List<SupplierBill> getSupplierBills(@PathVariable("supplierId") Long supplierId){
		return service.getSupplierBills(supplierId);
	}
	
	
	
	@GetMapping(value = "getProjectBills/{projectId}")
	public List<SupplierBill> getProjectBills(Long projectId){
		return service.getProjectBills(projectId);
	}
	
	
	
	@GetMapping(value = "getSupplierBillingSummaryForProject/{projectId}/{supplierId}")
	public SupplierBillingSummary getSupplierBillingSummaryForProject(@PathVariable("projectId") Long projectId, @PathVariable("supplierId") Long supplierId) {
		return service.getSupplierBillingSummaryForProject(projectId, supplierId);
	}
	
	
	
	@GetMapping(value = "getAllSuppliersBillingSummaryForProject/{projectId}")
	public List<SupplierBillingSummary> getAllSuppliersBillingSummaryForProject(@PathVariable("projectId") Long projectId){
		return service.getAllSuppliersBillingSummaryForProject(projectId);
	}

}
