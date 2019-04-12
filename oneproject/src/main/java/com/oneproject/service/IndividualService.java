/**
 * 
 */
package com.oneproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.Address;
import com.oneproject.model.Individual;
import com.oneproject.model.IndividualKYC;
import com.oneproject.model.Salary;
import com.oneproject.persistence.IndividualPersistence;
import com.oneproject.persistence.SalaryPersistence;
import com.oneproject.wrapper.IndividualAddressWrapper;
import com.oneproject.wrapper.KYCDataWrapper;
import com.oneproject.wrapper.SummarizedIndividual;

/**
 * @author chandan
 *
 */
@Service
public class IndividualService{

	@Autowired
	private IndividualPersistence persistence;
	
	@Autowired
	private SalaryPersistence salPersistence;
	
	
	
	public List<Individual> getAllIndividuals() {
		return persistence.getAllIndividuals();
	}
	
	
	
	public List<Individual> addOrUpdateIndividual(Individual individual) {
		if(individual.getFirstName() == null) {
			throw new RuntimeException("First Name Not Found");
		}else if(individual.getGender() == null) {
			throw new RuntimeException("Gender Not Found");
		}else if(individual.getPosition() == null) {
			throw new RuntimeException("Position Not Found");
		}else if(individual.getJoiningDate() == null) {
			throw new RuntimeException("Joining Date Not Found");
		}
		if(individual.getMiddleName() == null) {
			individual.setMiddleName("");
		}
		if(individual.getLastName() == null) {	
			individual.setLastName("");
		}
		return persistence.addOrUpdateIndividual(individual);
	}

	
	
	public List<Individual> deleteIndividualById(Long individualId) {
		return persistence.deleteIndividualById(individualId); 
	}
	
	
	
	public List<KYCDataWrapper> getKYCData(){
		List<KYCDataWrapper> kycDetails = new ArrayList<KYCDataWrapper>();
		List<Individual> individuals = persistence.getAllIndividuals();
		for(Individual individual : individuals) {
			KYCDataWrapper kyc= new KYCDataWrapper();
			String fullName = individual.getFirstName() + " " +individual.getMiddleName() +" " +individual.getLastName();
			kyc.setIndividualId(individual.getIndividualId());
			kyc.setFullName(fullName);
			IndividualKYC individualKYC = individual.getKyc();
			if(individualKYC != null) {
				kyc.setDocument(individualKYC.getDocumentType());
				kyc.setDocumentId(individualKYC.getDocumentId());
				kyc.setStatus(individualKYC.getStatus());
				kyc.setConfirmationDate(individualKYC.getConfirmationDate());
			}else {
				kyc.setStatus("Not Confirmed");
				kyc.setConfirmationDate(null);
			}
			kycDetails.add(kyc);
		}
		return kycDetails;
	}
	
	
	
	public List<KYCDataWrapper> confirmKYC(KYCDataWrapper kycData){
		Individual individual = persistence.getIndividualById(kycData.getIndividualId());
		if(individual != null){
			IndividualKYC existingKYC = individual.getKyc();
			if(existingKYC == null)
				existingKYC = new IndividualKYC();
			existingKYC.setDocumentType(kycData.getDocument());
			existingKYC.setDocumentId(kycData.getDocumentId());
			existingKYC.setConfirmationDate(new Date());
			existingKYC.setStatus(kycData.getStatus());
			individual.setKyc(existingKYC);
			persistence.addOrUpdateIndividual(individual);
		}
		return this.getKYCData();
	}
	
	
	
	@Deprecated
	public List<IndividualAddressWrapper> getIndividualsAddress(){
		List<IndividualAddressWrapper> individualsAddress = new ArrayList<>();
		List<Individual> individulas = persistence.getAllIndividuals();
		for(Individual individual : individulas) {
			IndividualAddressWrapper wrapper = new IndividualAddressWrapper();
			wrapper.setIndividualId(individual.getIndividualId());
			wrapper.setFullName(individual.getFirstName() + " " + individual.getMiddleName() + " " + individual.getLastName());
			Address address = individual.getAddress();
			if(address != null) {
				wrapper.setHouseNumber(address.getHouseNumber());
				wrapper.setVillage(address.getVillage());
				wrapper.setArea(address.getArea());
				wrapper.setStreet(address.getStreet());
				wrapper.setPostOffice(address.getPostOffice());
				wrapper.setPoliceStation(address.getPoliceStation());
				if(address.getLineOne() != null) {
					String line  = address.getLineOne();
					if(address.getLineTwo() != null) {
						line = line + "\n" + address.getLineTwo();
					}
					wrapper.setLine(line);
				}
				wrapper.setDistrict(address.getDistrict());
				wrapper.setCity(address.getCity());
				wrapper.setState(address.getState());
				wrapper.setCountry(address.getCountry());
				wrapper.setZip(address.getZip());
				if(address.getPhoneOne() != null) {
					String phones = address.getPhoneOne();
					if(address.getPhoneTwo() != null) {
						phones = phones + "\n" + address.getPhoneTwo();
					}
					wrapper.setPhones(phones);
				}
				wrapper.setEmail(address.getEmail());
			}
			individualsAddress.add(wrapper);
		}
		return individualsAddress;
	}
	
	
	
	public List<SummarizedIndividual> getSummarizedIndividuals(){
		List<SummarizedIndividual> individuals = persistence.getSummarizedIndividuals();
		for(SummarizedIndividual individual : individuals) {
			individual.setFullName(individual.getFirstName() + " " + individual.getMiddleName() + " " + individual.getLastName());
		}
		return individuals;
		
	}
	
	
	
	public Salary getIndividualActiveSalary(Long individualId){
		Salary salary = null;
		try {
			salary = salPersistence.getIndividualActiveSalary(individualId);
		}catch(NoResultException e) {
			
		}
		return salary;
	}
}
