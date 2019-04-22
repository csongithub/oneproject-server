package com.oneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneproject.model.Individual;
import com.oneproject.model.Salary;
import com.oneproject.service.IndividualService;
import com.oneproject.wrapper.IndividualAddressWrapper;
import com.oneproject.wrapper.KYCDataWrapper;
import com.oneproject.wrapper.SummarizedIndividual;

@RestController
@RequestMapping(value = "IndividualEndPoint")
public class IndividualEndPoint {
	
	@Autowired
	private IndividualService service;
	
	@GetMapping(value = "getAllIndividuals")
	public List<Individual> getAllIndividuals(){
		return service.getAllIndividuals();
	}
	
	
	
	
	@GetMapping(value = "getClientIndividuals/{clientId}")
	public List<Individual> getClientIndividuals(@PathVariable("clientId")Long clientId){
		return service.getClientIndividuals(clientId);
	}
	
	
	
	@PostMapping(value = "addOrUpdateIndividual")
	public List<Individual> addOrUpdateIndividual(@RequestBody Individual individual){
		return service.addOrUpdateIndividual(individual);
	}
	
	
	
	@DeleteMapping(value = "deleteIndividual/{individualId}")
	public List<Individual> deleteIndividual(@PathVariable("individualId") Long individualId){
		return service.deleteIndividualById(individualId);
	}
	
	
	
	@GetMapping(value = "getKYCData/{clientId}")
	public List<KYCDataWrapper> getKYCData(@PathVariable("clientId") Long clientId){
		return service.getKYCData(clientId);
	}
	
	
	
	@PutMapping(value = "confirmKYC")
	public List<KYCDataWrapper> confirmKYC(@RequestBody KYCDataWrapper kycData){
		return service.confirmKYC(kycData);
	}
	
	
	@Deprecated
	@GetMapping(value = "getIndividualsAddress")
	public List<IndividualAddressWrapper> getIndividualsAddress(){
		return service.getIndividualsAddress();
	}
	
	
	
	@GetMapping(value = "getSummarizedIndividuals")
	public List<SummarizedIndividual> getSummarizedIndividuals(){
		return service.getSummarizedIndividuals();
	}
	
	
	
	@GetMapping(value = "getSummarizedIndividualsForClient/{clientId}")
	public List<SummarizedIndividual> getSummarizedIndividualsForClient(@PathVariable("clientId")Long clientId){
		return service.getSummarizedIndividualsForClient(clientId);
	}
	
	
	
	@GetMapping(value = "getIndividualsSalary/{individualId}")
	public Salary getIndividualsSalary(@PathVariable("individualId") Long individualId){
		return service.getIndividualActiveSalary(individualId);
	}
}
