/**
 * 
 */
package com.oneproject.persistence;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.oneproject.model.MachineBill;

/**
 * @author a698219
 *
 */
abstract public class AbstractPersistence {
	
	@Autowired
	protected EntityManager em;

}
