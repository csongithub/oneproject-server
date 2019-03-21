/**
 * 
 */
package com.oneproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oneproject.model.Individual;
import com.oneproject.model.IndividualKYC;
import com.oneproject.persistence.IndividualPersistence;
import com.oneproject.wrapper.KYCDataWrapper;

/**
 * @author chandan
 *
 */
@Service
public class IndividualService{

	@Autowired
	private IndividualPersistence persistence; 
	
	
	
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
				//kyc.setDocument("NOT UPDATED");
				//kyc.setDocumentId("NOT UPDATED");
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
}
