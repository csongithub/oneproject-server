/**
 * 
 */
package com.oneproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oneproject.model.ClientCredential;
import com.oneproject.service.ClientCredentialService;
import com.oneproject.wrapper.AuthToken;

/**
 * @author chandan
 *
 */
@RestController
@RequestMapping(value = "ClientCredentialEndPoint")
public class ClientCredentialEndPoint {
	
	@Autowired
	private ClientCredentialService service;
	
	
	
	@PostMapping(value = "authenticateUser")
	public AuthToken authenticateUser(@RequestBody ClientCredential credential) {
		return service.authenticateUser(credential);
	}
}
