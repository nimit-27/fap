/*
 * Created on Mar 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package FCIPAY.Payroll.com.Parser.util.dan.cache.populator;

import java.io.Serializable;
import java.util.ArrayList;

import FCIPAY.Payroll.com.Parser.util.common.CachePopulator;

/**
 * @author sroy
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DANExampleCachePopulator extends CachePopulator {

	/* (non-Javadoc)
	 * @see com.aig.pul.util.common.CachePopulator#populate()
	 */
	public Serializable populate() throws Throwable {
		//Actually go to DB and get the data from here
		//For the time HardCoding it
		ArrayList aList = new ArrayList();
		aList.add("Mr");
		aList.add("Mrs");
		aList.add("Dr");
		aList.add("Ms");
		 
		return aList;
	}

}
