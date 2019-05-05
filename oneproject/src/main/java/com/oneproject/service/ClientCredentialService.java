/**
 * 
 */
package com.oneproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.oneproject.model.ClientCredential;
import com.oneproject.persistence.ClientCredentialPersistence;
import com.oneproject.wrapper.AuthToken;

/**
 * @author a698219
 *
 */
@Service
public class ClientCredentialService {
	
	@Autowired
	private ClientCredentialPersistence persistence;
	
	
	
	public AuthToken authenticateUser(@RequestBody ClientCredential credential) {
		AuthToken token = new AuthToken();
		ClientCredential cred =  persistence.getCredentialForUserId(credential.getUsername());
		if(cred == null || (!credential.getPassword().equals(cred.getPassword()))) {
			token.setAuthenticated(false);
		}else {
			token.setClientId(cred.getClientId());
			token.setClientName(cred.getClientName());
			token.setAuthenticated(true);
		}
		return token;
	}

}
