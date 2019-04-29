/**
 * 
 */
package com.oneproject.constant;

/**
 * @author chandan
 *
 */
public interface NamedQueryConstant {
	public static final String GET_PROJECT_SUPPLIERS = "GET_PROJECT_SUPPLIERS";
	public static final String GET_PROJECT_SUPPLIERS_QUERY = "select p.suppliers from Project p where p.projectId = :projectId";
}
