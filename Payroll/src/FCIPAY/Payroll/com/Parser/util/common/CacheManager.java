/*
 * Created on Mar 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package FCIPAY.Payroll.com.Parser.util.common;

import java.util.HashMap;
import java.util.ArrayList;
import FCIPAY.Payroll.com.Parser.util.common.vo.CacheObjects;
import FCIPAY.Payroll.com.Parser.util.common.vo.CacheObject;
import FCIPAY.Payroll.com.Parser.util.common.CachePopulator;
import FCIPAY.Payroll.com.Parser.util.common.CachedObject;
import FCIPAY.Payroll.common.xml.vo.EnrgiseForms;
import FCIPAY.Payroll.common.xml.vo.SingleForm;

/**
 * @author sroy
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CacheManager {

	private static CacheManager me = null;
	private HashMap aCachedMap = new HashMap();
	private CacheManager(){} 
	
	public static CacheManager getInstance() {
		if ( me == null ) {
			me = new CacheManager();
		}
		return me;
	}
	
	public CachedObject getCachedObject(String name_) {
		
		if ( name_ == null || name_.trim().length() <= 0 ) {
			return null;
		}
		else {
			return (CachedObject)aCachedMap.get(name_);
		}
	
	}
	public void init(CacheObjects aCacheObjects ) throws Exception {

		if ( aCacheObjects != null ) {
			ArrayList aList = aCacheObjects.get_CacheObject();
			if ( aList != null ) {
				for ( int i=0; i < aList.size(); i++ ) {
					
					CacheObject aCacheObject = (CacheObject)aList.get(i);
					String isEnabled = aCacheObject.get_isEnabled();
					String name = aCacheObject.get_name();
					if ( isEnabled != null && isEnabled.trim().equalsIgnoreCase("Y")) {
						
					
						
						if ( name != null && name.trim().length() > 0) {
							
							String sPopulatorClassName = aCacheObject.get_populatorClass();
							if ( sPopulatorClassName == null || sPopulatorClassName.trim().length() <= 0 ) {
								System.out.println("NULL OR BLANK POPULATOR CLASS NAME SPECIFIED FOR CACHED TAG: " + name );
								continue;
							}
							Class aPopulatorClass = Class.forName(sPopulatorClassName);
							Object objPopulatorClass = aPopulatorClass.newInstance();
							if ( objPopulatorClass instanceof CachePopulator ) {
	
								CachePopulator aCachePopulator = 
									(CachePopulator)objPopulatorClass;
									
								try {
								
									java.io.Serializable aSerializable =
										aCachePopulator.populate();
									
									String sCachedClassName = 
										aCacheObject.get_cachedObjectClass();
									
									if ( sCachedClassName == null || sCachedClassName.trim().length() <= 0 ) {
										sCachedClassName = "com.tcs.wenrgise.util.common.CachedObject";
									}
									
									Class aCachedObjectClass =
										Class.forName(sCachedClassName);
									Object objCachedObjectClass = aCachedObjectClass.newInstance();
									
									if ( objCachedObjectClass instanceof CachedObject ) {
										
										CachedObject aCachedObject = (CachedObject)objCachedObjectClass;
										aCachedObject.setValue(aSerializable);
										if ( aCachedMap.containsKey(name)) {
											System.out.println("DUPLICATE KEY FOUND IN CACHE...FIRST ENTRY WILL BE TAKEN");
										}
										else {
											aCachedMap.put(name, aCachedObject);
										}
										
									}
									else {
										System.out.println("CachedObjectClass MUST BE SUBCLASS OF CachedObject");	
										
									}
									
								}
								catch(Throwable t) {
									System.out.println("Population of Cache failed for: " + aCacheObject.get_populatorClass());
									t.printStackTrace();
								}
							}
							else {
								System.out.println("PopulatorClass MUST BE SUBCLASS OF CachePopulator");	
							
							}
	
							
						}
						
					}
					else {
						
						System.out.println("Caching disabled for entry: " + name);
					}
				}//end for
			}
		
		}
		else {
		
			System.out.println("CachedObject is null");	
		
		}		
		
	}
	
}
