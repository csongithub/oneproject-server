/**
 * 
 */
package com.oneproject.wrapper;

import java.io.Serializable;

/**
 * @author chandan
 *
 */
public class SearchCriteriaDataWrapper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long projectId;
	private int forMonth;
	private int forYear;
	/**
	 * @return the forMonth
	 */
	public int getForMonth() {
		return forMonth;
	}
	/**
	 * @param forMonth the forMonth to set
	 */
	public void setForMonth(int forMonth) {
		this.forMonth = forMonth;
	}
	/**
	 * @return the forYear
	 */
	public int getForYear() {
		return forYear;
	}
	/**
	 * @param forYear the forYear to set
	 */
	public void setForYear(int forYear) {
		this.forYear = forYear;
	}
	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
}
