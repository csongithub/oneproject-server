/**
 * 
 */
package com.oneproject.comparator;

import java.util.Comparator;

import com.oneproject.model.OtherBill;

/**
 * @author chandan
 *
 */
public class DateComparator implements Comparator{
	
	public Class cl;
	
	public DateComparator() {}
	
	public DateComparator(Class cl) {
		this.cl = cl;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		if(OtherBill.class == cl) {
			OtherBill b1 = (OtherBill) o1;
			OtherBill b2 = (OtherBill) o2;
			return b1.getBillingDate().compareTo(b2.getBillingDate());
		} else {
			return 0;
		}
	}

}
