/**
 * 
 */
package com.oneproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneproject.model.AdminEnumerationsPreferences;
import com.oneproject.service.AdminEnumerationsPreferencesService;

/**
 * @author chandan
 *
 */
@RestController
@RequestMapping(value = "AdminEnumerationsPreferencesEndPoint")
public class AdminEnumerationsPreferencesEndPoint {
	
	@Autowired
	private AdminEnumerationsPreferencesService service;

	@GetMapping(value = "getPreferences")
	public AdminEnumerationsPreferences getPreferences(){
		return service.getPreferences();
	}
	
	@PutMapping(value = "addOrUpdatePreferences")
	public AdminEnumerationsPreferences addOrUpdatePreferences(@RequestBody AdminEnumerationsPreferences preferences){
		return service.addOrUpdatePreferences(preferences);
	}
}
