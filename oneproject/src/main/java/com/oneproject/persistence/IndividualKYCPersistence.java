/**
 * 
 */
package com.oneproject.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oneproject.model.IndividualKYC;
import com.oneproject.repository.IndividualKYCRepository;

/**
 * @author chandan
 *
 */
@Component
public class IndividualKYCPersistence extends AbstractPersistence {

	@Autowired
	private IndividualKYCRepository repository;
	
	
	public List<IndividualKYC> getAllKYCs(){
		return repository.findAll();
	}
	
	
	
	public IndividualKYC getKYCById(Long kycId) {
		return repository.findOne(kycId);
	}
	
	
	
	public void updateKYC(IndividualKYC kyc) {
		repository.save(kyc);
	}
	
	
	
}
