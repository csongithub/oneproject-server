/**
 * 
 */
package com.oneproject.utils;

/**
 * @author a698219
 *
 */
public class Strings {
	private static final String EMPTY = "";
	
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0 || s.trim().length() == 0;
	}
	
	
	public static boolean isNotNullOrEmpty(String s) {
		return !isNullOrEmpty(s);
	}

}
