/**
 * 
 */
package com.oneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneproject.model.Supplier;
import com.oneproject.service.SupplierService;

/**
 * @author a698219
 *
 */
@RestController
@RequestMapping(value = "SupplierEndPoint")
public class SupplierEndPoint {
	
	@Autowired
	private SupplierService service;
	
	
	@GetMapping(value = "getAppSuppliers")
	public List<Supplier> getAppSuppliers(){
		return service.getAppSuppliers();
	}
	
	
	
	@GetMapping(value = "getSupplierById/{supplierId}")
	public Supplier getSupplierById(@PathVariable("supplierId")Long supplierId) {
		return service.getSupplierById(supplierId);
	}
	
	
	
	@PutMapping(value = "addOrUpdateSupplier")
	public List<Supplier> addOrUpdateSupplier(@RequestBody Supplier supplier){
		return service.addOrUpdateSupplier(supplier);
	}

}
