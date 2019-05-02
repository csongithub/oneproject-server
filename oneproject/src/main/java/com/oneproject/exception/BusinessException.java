/**
 * 
 */
package com.oneproject.exception;

/**
 * @author chandan
 *
 */
public class BusinessException extends RuntimeException {

	private String errorMessage;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
}
