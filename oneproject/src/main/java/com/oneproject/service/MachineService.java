/**
 * 
 */
package com.oneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneproject.model.Machine;
import com.oneproject.model.ProjectMachineLinkage;
import com.oneproject.persistence.MachinePersistence;
import com.oneproject.persistence.ProjectMachineLinkagePersistence;
import com.oneproject.wrapper.MachinePricingWrapper;

/**
 * @author chandan
 *
 */
@Service
public class MachineService {

	@Autowired
	private MachinePersistence persistence;
	
	@Autowired
	private ProjectMachineLinkagePersistence linkagePersistence;
	
	
	
	public void addMachine(Machine machine) {
		persistence.addMachine(machine);
	}
	
	
	
	public List<Machine> getClientMachines(Long clientId){
		return persistence.getClientMachines(clientId);
	}
	
	
	
	public Machine getMachineById(Long machineId) {
		return persistence.getMachineById(machineId);
	}
	
	
	
	public MachinePricingWrapper generateBillByPeriod(MachinePricingWrapper wrapper) {
		try {
			ProjectMachineLinkage linkage = linkagePersistence.getMachineLinkageById(wrapper.getLinkageID());
			if(linkage != null) {
				String pricingUnit = linkage.getPricingUnit();
				if("HOUR".equalsIgnoreCase(pricingUnit)) {
					int hours = wrapper.getHours();
					int minutes = wrapper.getMinutes();
					int totalMinutes = (hours * 60) + minutes;
					float pricePerMinute = (linkage.getPrice() / 60);
					double billAmount = (totalMinutes * pricePerMinute);
					wrapper.setBillAmount(billAmount);
				}
//				else if("MONTH".equalsIgnoreCase(pricingUnit)) {
//					int months = wrapper.getMonths();
//					int days = wrapper.getDays();
//					int totalDays = (months * 30) + days;
//				}
			}
		}catch(Exception e) {
			throw new RuntimeException("Error in generating bill");
		}
		return wrapper;
	}
}
