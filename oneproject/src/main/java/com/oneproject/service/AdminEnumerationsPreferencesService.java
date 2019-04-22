/**
 * 
 */
package com.oneproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oneproject.model.AdminEnumerationsPreferences;
import com.oneproject.persistence.AdminEnumerationsPreferencesPersistence;

/**
 * @author chandan
 *
 */
@Service
public class AdminEnumerationsPreferencesService{

	@Autowired
	private AdminEnumerationsPreferencesPersistence persistence;
	
	public AdminEnumerationsPreferences getClientPreferences(Long clientId) {
		AdminEnumerationsPreferences enums = persistence.getClientEnumerations(clientId);
		AdminEnumerationsPreferences result =  enums != null ?enums : null;
		if(result != null) {
			try {
				result.setGenderJson(result.getGender() != null ? new String(result.getGender(), "US-ASCII") : null);
				result.setPositionJson(result.getPosition() != null ? new String(result.getPosition(), "US-ASCII") : null);
				result.setProjectTypeJson(result.getProjectType() != null ? new String(result.getProjectType(), "US-ASCII") : null);
				result.setKycSupportedDocsJson(result.getKycSupportedDocs() != null ? new String(result.getKycSupportedDocs(), "US-ASCII") : null);
				result.setMaterialTypeJson(result.getMaterialType() != null ? new String(result.getMaterialType(), "US-ASCII") : null);
				result.setSalaryIntervalJson(result.getSalaryInterval() != null ? new String(result.getSalaryInterval(), "US-ASCII") : null);
			} catch (Throwable e) {
				throw new RuntimeException("erroe occuerd in system");
			}
			result.setGender(null);
			result.setPosition(null);
			result.setProjectType(null);
			result.setKycSupportedDocs(null);
			result.setMaterialType(null);
			result.setSalaryInterval(null);
		}else {
			result = new AdminEnumerationsPreferences();
		}
		return result;
	}
	
	
	
	public AdminEnumerationsPreferences addOrUpdatePreferences(AdminEnumerationsPreferences preferences){
		AdminEnumerationsPreferences oldEnums = persistence.getClientEnumerations(preferences.getClientId());
		if(oldEnums == null) {
			convertToByte(preferences);
			persistence.addOrUpdateEnumeration(preferences);
			return getClientPreferences(preferences.getClientId());
		}else {
			switch(preferences.getPreferencesType()) {
			case "GENDER":
				oldEnums.setGender(getBytes(preferences.getValue()));
				break;
			case "POSITION":
				oldEnums.setPosition(getBytes(preferences.getValue()));
				break;
			case "PROJECT_TYPE":
				oldEnums.setProjectType(getBytes(preferences.getValue()));
				break;
			case "KYC_DOCS":
				oldEnums.setKycSupportedDocs(getBytes(preferences.getValue()));
				break;
			case "MATERIAL_TYPE":
				oldEnums.setMaterialType(getBytes(preferences.getValue()));
			case "SAL_INTERVAL":
				oldEnums.setSalaryInterval(getBytes(preferences.getValue()));
			}
			persistence.addOrUpdateEnumeration(oldEnums);
			return getClientPreferences(preferences.getClientId());
		}
	}
	
	
	
	private byte[] getBytes(String jsonData) {
		try {
			return jsonData.getBytes("UTF-8");
		} catch (Throwable e) {
			throw new RuntimeException("Invalid Data");
		}
	}
	
	
	private AdminEnumerationsPreferences convertToByte(AdminEnumerationsPreferences preferences) {
		try {
			if("GENDER".equalsIgnoreCase(preferences.getPreferencesType().trim())) {
				preferences.setGender(getBytes(preferences.getValue()));
			}else if("POSITION".equalsIgnoreCase(preferences.getPreferencesType().trim())){
				preferences.setPosition(getBytes(preferences.getValue()));
			}else if("PROJECT_TYPE".equalsIgnoreCase(preferences.getPreferencesType().trim())) {
				preferences.setProjectType(getBytes(preferences.getValue()));
			}else if("KYC_DOCS".equalsIgnoreCase(preferences.getPreferencesType().trim())) {
				preferences.setKycSupportedDocs(getBytes(preferences.getValue()));
			}else if("MATERIAL_TYPE".equalsIgnoreCase(preferences.getPreferencesType().trim())) {
				preferences.setMaterialType(getBytes(preferences.getValue()));
			}
			else if("SAL_INTERVAL".equalsIgnoreCase(preferences.getPreferencesType().trim())) {
				preferences.setSalaryInterval(getBytes(preferences.getValue()));
			}
		}catch(Throwable e) {
			throw new RuntimeException("Invalid Data");
		}
		return preferences;
	}
	
	
}
