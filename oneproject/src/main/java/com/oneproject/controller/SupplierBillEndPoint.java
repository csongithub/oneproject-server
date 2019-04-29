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
import com.oneproject.model.SupplierBill;
import com.oneproject.service.SupplierBillService;

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
	
	
	
	@GetMapping(value = "getBillsForSupplierAndProject/{supplierId}/{projectid}")
	public List<SupplierBill> getBillsForSupplierAndProject(@PathVariable("supplierId") Long supplierId, @PathVariable("projectid") Long projectid){
		return service.getBillsForSupplierAndProject(supplierId, projectid);
	}
	
	
	
	@GetMapping(value = "getSupplierBills/{supplierId}")
	public List<SupplierBill> getSupplierBills(@PathVariable("supplierId") Long supplierId){
		return service.getSupplierBills(supplierId);
	}
	
	
	
	@GetMapping(value = "getProjectBills/{projectid}")
	public List<SupplierBill> getProjectBills(Long projectid){
		return service.getProjectBills(projectid);
	}

}
