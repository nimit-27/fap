/*
 * Created on Mar 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package FCIPAY.Payroll.com.Parser.util.dan.cache.cacheobject;

import java.util.ArrayList;
import FCIPAY.Payroll.com.Parser.util.common.CachedObject;

/**
 * @author sroy
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DANExampleAllCachedObject extends CachedObject {

	public ArrayList getArrayListValue() {
		if ( this.value instanceof ArrayList ) {
			return (ArrayList)value;
		}
		else {
			return null;
		}
	}
}
