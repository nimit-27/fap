package FCIPAY.Payroll.common.utility;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.common.xml.vo.*;
import FCIPAY.Payroll.common.xml.vo.EnrgiseApp;
import FCIPAY.Payroll.common.xml.vo.INFOClass;
import FCIPAY.Payroll.common.xml.vo.ReportInfo;
import FCIPAY.Payroll.common.xml.vo.Report;
import FCIPAY.Payroll.common.xml.vo.ScreenInfo;
import FCIPAY.Payroll.common.xml.vo.Module;
import FCIPAY.Payroll.common.xml.vo.Reports;

public class ReportManager 
{
	private static ReportManager  me = null;
 
	private HashMap oMap = new HashMap();
	private ReportManager (){} 


	public static ReportManager  getInstance()
  {
		if ( me == null )
    {
			me = new ReportManager ();      
    }
		return me;    

  }

	public ReportInfo getCachedObject(String name_)
  {
		
		if ( name_ == null || name_.trim().length() <= 0 )
    {
			return null;
		}
		else {
			return (ReportInfo)oMap.get(name_);
		}
	
	}

  public void init(INFOClass oINFOClass)
  {
    if(oINFOClass == null)
    {
      return;
    }
    
    
    ArrayList oList = oINFOClass.get_Module();
    Iterator oIt = oList.iterator();
    String sModuleName;
    String sScreenName;
    String sReportKey;
        
    while(oIt.hasNext())
    {
      Module oModule = (Module)oIt.next();
      sModuleName = oModule.get_ModuleName();
     // ScreenInfos oScreenInfos=oModule.get_ScreenInfos();
      ArrayList oScreenInfoList =oModule.get_ScreenInfo();
      Iterator oScreenInfoIt = oScreenInfoList.iterator();
      while(oScreenInfoIt.hasNext())
      {
        ScreenInfo oScreenInfo = (ScreenInfo)oScreenInfoIt.next();
        sScreenName=oScreenInfo.get_ScreenName();
        Reports oReports=oScreenInfo.get_Reports();
        ArrayList oReportList=oReports.get_Report();
        Iterator oReportIt=oReportList.iterator();
        while(oReportIt.hasNext())
        {
          Report oReport=(Report)oReportIt.next();
          ReportInfo oReportInfo=new ReportInfo();
          oReportInfo.setReportKey(oReport.get_ReportKey());
          String sCombinedKey = sModuleName + sScreenName + oReport.get_KeyInfo();
//          System.out.println("The key is " + sCombinedKey);
          if(!oMap.containsKey(sCombinedKey))
          {
            oMap.put(sCombinedKey,oReportInfo);
          }
        }
        
      }
    }
  }
}

