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
public class COMExampleCategoryPopulator extends CachePopulator {

	/* (non-Javadoc)
	 * @see com.aig.pul.util.common.CachePopulator#populate()
	 */
	public Serializable populate() throws Throwable {
		//Auto-generated method stub
		
		ArrayList aList = new ArrayList();
		aList.add("Catagory 1\n");
		aList.add("Catagory 2\n");
		aList.add("Catagory 3\n");		
		aList.add("Catagory 4\n");		
		aList.add("Catagory n\n");		

		return aList;
	}

}
