package FCIPAY.Payroll.common.utility;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.common.xml.vo.*;
import FCIPAY.Payroll.common.xml.vo.ScreenModes;
import FCIPAY.Payroll.common.xml.vo.Screens;
import FCIPAY.Payroll.common.xml.vo.LOVClass;
import FCIPAY.Payroll.common.xml.vo.LOVInfo;
import FCIPAY.Payroll.common.xml.vo.ScreenMode;
import FCIPAY.Payroll.common.xml.vo.Screen;
import FCIPAY.Payroll.common.xml.vo.LOV;

public class LOVManager 
{
	private static LOVManager me = null;
	private HashMap oMap = new HashMap();
	private LOVManager(){} 


	public static LOVManager getInstance()
  {
		if ( me == null )
    {
			me = new LOVManager();      
    }
		return me;    

  }

	public LOVInfo getCachedObject(String name_)
  {
		
		if ( name_ == null || name_.trim().length() <= 0 )
    {
			return null;
		}
		else {
			return (LOVInfo)oMap.get(name_);
		}
	
	}

  public void init(LOVClass oLOVClass)
  {
    if(oLOVClass == null)
    {
      return;
    }
    
    ArrayList oList = oLOVClass.get_LOV();
    Iterator oIt = oList.iterator();
    String sLOVName;
    String sScreenName;
    String sMode;
    String sFacadeHome;
    String sFunctionName;
    
    while(oIt.hasNext())
    {
      LOV oLOV = (LOV)oIt.next();
      sLOVName = oLOV.get_LovKey();
      Screens oScreens = oLOV.get_Screens();
      Iterator oScreenIt = oScreens.get_Screen().iterator();
      while(oScreenIt.hasNext())
      {
        Screen oScreen = (Screen)oScreenIt.next();
        sScreenName = oScreen.get_ScreenName();
        ScreenModes oScreenModes = oScreen.get_ScreenModes();
        Iterator oScreenModeIt = oScreenModes.get_ScreenMode().iterator();
        while(oScreenModeIt.hasNext())
        {
          ScreenMode oScreenMode = (ScreenMode)oScreenModeIt.next();
          sMode = oScreenMode.get_ModeName();
          LOVInfo oLOVInfo = new LOVInfo();
          oLOVInfo.setFacadeName(oScreenMode.get_FacadeName());
          oLOVInfo.setFunctionName(oScreenMode.get_FunctionName());
          oLOVInfo.setInsertFlag(oScreenMode.get_InsertFlag());
          String sCombinedKey = sLOVName + sScreenName + sMode;
          if(!oMap.containsKey(sCombinedKey))
          {
            oMap.put(sCombinedKey,oLOVInfo);
          }
          
          
        }
      }
    }
    
  }

}