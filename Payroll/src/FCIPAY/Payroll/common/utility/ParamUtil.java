package FCIPAY.Payroll.common.utility;
import java.util.ArrayList;
import FCIPAY.Payroll.common.xml.vo.*;
import FCIPAY.Payroll.common.xml.vo.SingleForm;
import FCIPAY.Payroll.common.xml.vo.ReportInfo;
import FCIPAY.Payroll.common.xml.vo.DetailScreens;
import FCIPAY.Payroll.common.xml.vo.HashedEnrgiseForms;
import FCIPAY.Payroll.common.xml.vo.DetailScreen;
public class ParamUtil 
{
  public ParamUtil()
  {
  
  }
  
  public static String getQueryVO(String sFormName)
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    System.out.println(oHashedEnrgiseForms.getSingleForm().get_EnrgiseQueryVO());
    return oHashedEnrgiseForms.getSingleForm().get_EnrgiseQueryVO();
  }
  
  
  public static String getHeaderBD(String sFormName) 
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    return oHashedEnrgiseForms.getSingleForm().get_HeaderBD();
  }

  public static String getDetailBD(String sFormName, String sScreenName)
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    DetailScreen oDetailScreen =  (DetailScreen)oHashedEnrgiseForms.getDetailMap().get(sScreenName);
    return oDetailScreen.get_DetailBD();
  }
  
  public static String getDetailBaseInfo(String sFormName, String sScreenName)
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    DetailScreen oDetailScreen =  (DetailScreen)oHashedEnrgiseForms.getDetailMap().get(sScreenName);
    return oDetailScreen.get_BaseDetailInfo();
  }

  
  public static String getDetailArrayName(String sFormName, String sScreenName)
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    DetailScreen oDetailScreen =  (DetailScreen)oHashedEnrgiseForms.getDetailMap().get(sScreenName);
    return oDetailScreen.get_DetailArrayName();
  }
  
  public static String getDetailBeanName(String sFormName, String sScreenName)
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    DetailScreen oDetailScreen =  (DetailScreen)oHashedEnrgiseForms.getDetailMap().get(sScreenName);
    return oDetailScreen.get_DetailBean();
  }
  
  public static String getSessionBeanName()
  {
    return "UserSession";
  }
  
  public static String getHeaderBean(String sFormName)
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    return oHashedEnrgiseForms.getSingleForm().get_HeaderBean();
  }
  
  public static int getHeaderSize(String sFormName)
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    return Integer.parseInt(oHashedEnrgiseForms.getSingleForm().get_HeaderSize());
  }
  
  public static int getDetailRecordPerPage(String sFormName, String sScreenName)
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    DetailScreen oDetailScreen =  (DetailScreen)oHashedEnrgiseForms.getDetailMap().get(sScreenName);
    return Integer.parseInt(oDetailScreen.get_DetailRecordPerPage());
  }
  
  public static int getMaxDetailPages(String sFormName, String sScreenName)
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    DetailScreen oDetailScreen =  (DetailScreen)oHashedEnrgiseForms.getDetailMap().get(sScreenName);
    return Integer.parseInt(oDetailScreen.get_DetailPagesPerSlot());
  }
  
  public static ArrayList getDetailList(String sFormName)
  {
    HashedEnrgiseForms oHashedEnrgiseForms = EnrgiseManager.getInstance().getCachedObject(sFormName);
    SingleForm oSingleForm = oHashedEnrgiseForms.getSingleForm();
    DetailScreens oDetailScreens = oSingleForm.get_DetailScreens();
    return oDetailScreens.get_DetailScreen();
  }

  public static String getKeyinfo(String sMODULEname,String sJSPname,String sReportkey)
  {
   ReportInfo oReportInfo=  ReportManager.getInstance().getCachedObject(sMODULEname+sJSPname+sReportkey);
  return oReportInfo.getReportKey();
  }
  
}