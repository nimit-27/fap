package FCIPAY.Payroll.common.utility;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.common.xml.vo.*;
import FCIPAY.Payroll.common.xml.vo.SingleForm;
import FCIPAY.Payroll.common.xml.vo.EnrgiseForms;
import FCIPAY.Payroll.common.xml.vo.DetailScreens;
import FCIPAY.Payroll.common.xml.vo.HashedEnrgiseForms;
import FCIPAY.Payroll.common.xml.vo.DetailScreen;
public class EnrgiseManager 
{
	private static EnrgiseManager me = null;
	private HashMap oEnrgiseMap = new HashMap();
	private EnrgiseManager(){} 

	public static EnrgiseManager getInstance() {
		if ( me == null ) {
			me = new EnrgiseManager();
		}
		return me;
	}

	public HashedEnrgiseForms getCachedObject(String name_) {
		
		if ( name_ == null || name_.trim().length() <= 0 ) {
			return null;
		}
		else {
			return (HashedEnrgiseForms)oEnrgiseMap.get(name_);
		}
	
	}
  
  public void init(EnrgiseForms oEnrgiseForms)
  {
    if(oEnrgiseForms == null)
    {
      return;
    }
    
    ArrayList oFormsList = oEnrgiseForms.get_SingleForm();
    Iterator oIt = oFormsList.iterator();
    
    while(oIt.hasNext())
    {
      SingleForm oSingleForm = (SingleForm)oIt.next();
      String sFormName = oSingleForm.get_FormName();
      HashedEnrgiseForms oHashedEnrgiseForms = new HashedEnrgiseForms();
      oHashedEnrgiseForms.setSingleForm(oSingleForm);
      DetailScreens oDetailScreens = oSingleForm.get_DetailScreens();
      ArrayList oDetailList = oDetailScreens.get_DetailScreen();
      Iterator oDetailIt = oDetailList.iterator();
      while(oDetailIt.hasNext())
      {
        DetailScreen oDetailScreen = (DetailScreen)oDetailIt.next();
        String sDetailName = oDetailScreen.get_DetailScreenName();
        if(!oHashedEnrgiseForms.getDetailMap().containsKey(sDetailName))
        {
//          System.out.println("The entry is " + sFormName + sDetailName);
          oHashedEnrgiseForms.getDetailMap().put(sDetailName,oDetailScreen);
        }
      }
      if(!oEnrgiseMap.containsKey(sFormName))
      {
        oEnrgiseMap.put(sFormName,oHashedEnrgiseForms);
      }
    }
    
  }
  
  
}