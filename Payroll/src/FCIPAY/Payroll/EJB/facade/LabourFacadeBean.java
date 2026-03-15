package FCIPAY.Payroll.EJB.facade;

import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.EJB.business.CityLocMapBusinessObject;
import FCIPAY.Payroll.EJB.business.DeptPayFixBusinessObject;
import FCIPAY.Payroll.EJB.business.EmpHighAchieversBusinessObject;
import FCIPAY.Payroll.EJB.business.EmpPayFixBusinessObject;

import FCIPAY.Payroll.EJB.business.GetCityMapLocLovBussinessObject;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.ArrayList;
import FCIPAY.Payroll.Labour.Utility.MaintGangHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.sql.Timestamp;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

import FCIPAY.Payroll.Labour.EJB.business.GangBusinessObject;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.GangComboVO;

import FCIPAY.Payroll.Labour.EJB.business.NormBusinessObject;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NormComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.MaintNormQueryVO;

import FCIPAY.Payroll.Labour.EJB.business.HandlingNormBusinessObject;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.HndlingNormComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.MaintHandlingNormQueryVO;
import FCIPAY.Payroll.Labour.Utility.MaintHandlingNormHeaderBean;

import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import java.rmi.RemoteException;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.common.vo.BaseQueryVO;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.MaintWrkSlipQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.MaintKotWrkSlipQueryVO;
import FCIPAY.Payroll.Labour.EJB.business.WrkSlipBusinessObject;
import FCIPAY.Payroll.Labour.EJB.business.KotWrkSlipBusinessObject;
import FCIPAY.Payroll.Labour.Utility.MaintWrkSlipHeaderBean;
import FCIPAY.Payroll.Labour.Utility.MaintKotWrkSlipHeaderBean;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSInfoComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSInfoQueryVO;
import FCIPAY.Payroll.Labour.Utility.DPSInfoHeaderBean;
import FCIPAY.Payroll.Labour.EJB.business.DPSInfoBusinessObject;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DeptLabourComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DeptLabourQueryVO;
import FCIPAY.Payroll.Labour.Utility.DeptLabourInfoHeaderBean;
import FCIPAY.Payroll.Labour.EJB.business.DeptLabourBusinessObject;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrHndlngAttndQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrHndlngAttndDetailInfo;
import FCIPAY.Payroll.Labour.Utility.LbrHndlngAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.LbrHndlngAttndBean;
import FCIPAY.Payroll.Labour.EJB.business.LbrHndlngAttndBusinessObject;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrAncllryAttndQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrAncllryAttndDetailInfo;
import FCIPAY.Payroll.Labour.Utility.LbrAncllryAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.LbrAncllryAttndBean;
import FCIPAY.Payroll.Labour.EJB.business.LbrAncllryAttndBusinessObject;

import FCIPAY.Payroll.Labour.Utility.DpsLabourASORHeaderBean;
import FCIPAY.Payroll.Labour.Utility.DpsLabourMinWageHeaderBean;  // added by dushyant on 26 April 2011 for DPS minimum wages
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourASORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourMinWageQueryVO;   // added by dushyant on 26 April 2011 for DPS minimum wages
import FCIPAY.Payroll.Labour.EJB.business.DpsLbrASORBusinessObject;
import FCIPAY.Payroll.Labour.EJB.business.DpsLbrMinWageBusinessObject;   // added by dushyant on 26 April 2011 for DPS minimum wages

import FCIPAY.Payroll.Labour.Utility.DpsLabourSORHeaderBean;
import FCIPAY.Payroll.Labour.Utility.DpsLabourSORDtlBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourSORDtlBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORComboVO;
import FCIPAY.Payroll.Labour.EJB.business.DpsLbrSORBusinessObject;

import FCIPAY.Payroll.Labour.Utility.CalcDeptIncentiveHeaderBean;
import FCIPAY.Payroll.Labour.EJB.business.CalcDeptIncentiveBusinessObject;

import FCIPAY.Payroll.Labour.Utility.CalcDeptOTIncentiveHeaderBean;
import FCIPAY.Payroll.Labour.EJB.business.CalcDeptOTIncentiveBusinessObject;

import FCIPAY.Payroll.Labour.Utility.CalcDeptOTAHeaderBean;
import FCIPAY.Payroll.Labour.EJB.business.CalcDeptOTABusinessObject;

import FCIPAY.Payroll.Labour.Utility.DpsLabourSORViewBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORViewQryVO;
import FCIPAY.Payroll.Labour.EJB.business.DpsLbrSORViewBusiObject;

import FCIPAY.Payroll.Labour.Utility.CalcDpsWrkDoneHeaderBean;
import FCIPAY.Payroll.Labour.EJB.business.CalcDpsWrkDoneBusinessObject;

import FCIPAY.Payroll.Labour.Utility.CalcDpsMgwIRHeaderBean;
import FCIPAY.Payroll.Labour.EJB.business.CalcDpsMgwIRBusinessObject;

import FCIPAY.Payroll.Labour.EJB.business.IncentiveOperationsBusinessObject;
import FCIPAY.Payroll.Labour.Utility.MaintIncentiveOperationsKotBean;
import FCIPAY.Payroll.Labour.Utility.IncentiveOperationsDtlKotBean;
import FCIPAY.Payroll.Labour.Utility.IncentiveOperationsHdrKotBean;
import FCIPAY.Payroll.Labour.EJB.business.IncentiveOperationsKotDtBusinessObjectl;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.KotLbrOprDetailsVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.KotwalLbrMasterDetailsVO;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSOTARatesDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSOTARatesQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPAreaClassiFicationMappingQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPAreaMappingComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPInfoComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPInfoQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourASORDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourASORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourMinWageQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourOprtnDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourOprtnQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrHndlngAttndDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrHndlngAttndQueryVO;
import FCIPAY.Payroll.Labour.Utility.DPSOTARateHeaderBean;
import FCIPAY.Payroll.Labour.EJB.business.DPSOTARatesBusinessObject;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipOprationComboVO;
import FCIPAY.Payroll.Labour.EJB.business.NWNPInfoBusinessObject;
import FCIPAY.Payroll.Labour.EJB.business.NWNPLbrHndlngBusinessObject;
import FCIPAY.Payroll.Labour.EJB.business.NWNPLbrMinWageBusinessObject;
import FCIPAY.Payroll.Labour.EJB.business.NWNPLbrOprtnBusinessObject;
import FCIPAY.Payroll.Labour.EJB.business.NWNPLbrSORBusinessObject;
import FCIPAY.Payroll.Labour.Utility.NWNPInfoHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourMinWageHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourOprtnHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLbrHndlngAttndHeaderBean;
import FCIPAY.Payroll.UTILITY.DeptPayFixBean;
import FCIPAY.Payroll.UTILITY.EmpPayFixBean;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;
import FCIPAY.Payroll.Labour.EJB.business.NWNPWrkSlipBusinessObject;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourSORHeaderBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourSORDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourSORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrAncllryAttndDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrAncllryAttndQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPMaintWrkSlipQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPWrkSlipComboVO;
import FCIPAY.Payroll.Labour.EJB.business.NWNPAreaClassiFicationMappingBusinessObject;
import FCIPAY.Payroll.Labour.EJB.business.NWNPLbrASORBusinessObject;
import FCIPAY.Payroll.Labour.EJB.business.NWNPLbrAncllryAttndBusinessObject;
import FCIPAY.Payroll.Labour.Utility.NWNPAreaClassiFicationMappingHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourASORHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLbrAncllryAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPMaintWrkSlipHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintCityLocMapHeaderBean;

public class LabourFacadeBean implements SessionBean
{
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
  }

/*
 * Created By Balpreet Kaur
 * Dated
 *
 *  To Get Gang Details.
 */
  public ArrayList getGangDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
       GangBusinessObject oGang = new GangBusinessObject();
       return oGang.getGangDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }

 /*
 * Created By Balpreet Kaur
 * Dated
 *
 *  To Get the Gang Meta Info.
 */
  public RecordMetaInfo getGangDetailMetaInfo(String sPrimaryKey)throws EnrgiseSystemException, EnrgiseApplicationException
  {
        GangBusinessObject oGang = new GangBusinessObject();
        return oGang.getGangDetailMetaInfo(sPrimaryKey);
  }

/*
 * Created By Balpreet Kaur
 * Dated
 *
 *  To Save Gang Details.
 */
  public String saveGang(MaintGangHeaderBean oDummyHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException
  {
        GangBusinessObject oGang = new GangBusinessObject();
        return oGang.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

 /*
 * Created By Balpreet Kaur
 * Dated
 *
 *  To Get the LOV for Gang.
 */
   public LovVO getGangLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    GangBusinessObject oGang = new GangBusinessObject();
    LovVO oLovVO=oGang.getGangLOVDataQ(oLovQueryVO);
     return oLovVO;
  }

  /*
   * Created By Balpreet Kaur
   * Dated 11 March 2008
   *
   *  To Get Gang Combo Details.
   */
  public GangComboVO getGangComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException
  {
    GangBusinessObject oGangBusinessObject=new GangBusinessObject();
    return oGangBusinessObject.getGangComboDetails();
  }
 /*
 * Created By Balpreet Kaur
 * Dated
 *
 *  To Get the LOV for Gang.
 */

  public LovVO getGangDepotLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    GangBusinessObject oGang = new GangBusinessObject();
    LovVO oLovVO=oGang.getGangDepotLOVDataQ(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated
 *
 *  To Get the LOV for Labours in Gang Screen.
 */

  public LovVO getGangLbrLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    GangBusinessObject oGang = new GangBusinessObject();
    LovVO oLovVO=oGang.getGangLbrLOVDataN(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 8 Aug 2007
 *
 *  To Get Other Norm Details.
 */
  public ArrayList getNormDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
       NormBusinessObject oGang = new NormBusinessObject();
       return oGang.getNormDetail(sPrimaryKey,lStartPosition,lLastPosition,oBaseDetailInfo);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 8 Aug 2007
 *
 *  To Get the Other Norm Detail Meta Info.
 */
  public RecordMetaInfo getNormDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo)throws EnrgiseSystemException, EnrgiseApplicationException
  {
       NormBusinessObject oGang = new NormBusinessObject();
       return oGang.getNormDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);
  }

/*
 * Created By Balpreet Kaur
 * Dated 8 Aug 2007
 *
 *  To Save Other Norm Details.
 */
  public String saveNormDetail(BaseHeaderBean oDummyHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException
  {
        NormBusinessObject oGang = new NormBusinessObject();
        return oGang.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }


  /*
   * Created By Balpreet Kaur
   * Dated 08 April 2008
   *
   *  To Get Norm Combo Details.
   */
  public NormComboVO getNormComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException
  {
    NormBusinessObject oNormBusinessObject=new NormBusinessObject();
    return oNormBusinessObject.getNormComboDetails();
  }

  /*
   * Created By Balpreet Kaur
   * Dated 25 March 2008
   *
   *  To Get Norm Header Meta Details.
   */
  public RecordMetaInfo getNormHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
   NormBusinessObject oNorm = new NormBusinessObject();
   MaintNormQueryVO oMaintNormQueryVO=(MaintNormQueryVO)oBaseQueryVO;
    return oNorm.getNormHeaderMetaImpl(oMaintNormQueryVO);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 25 March 2008
   *
   *  To Get Norm Header Details.
   */
  public ArrayList getNormHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    NormBusinessObject oNormBusinessObject=new NormBusinessObject();
    return oNormBusinessObject.getNormHeaderRecord((MaintNormQueryVO)oQueryVO,lStartPosition,lLastPosition);

  }


////////////////Labour Handling Norm


  public RecordMetaInfo getHandlingNormDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HandlingNormBusinessObject oHandlingNorm = new HandlingNormBusinessObject();
    return oHandlingNorm.getHandlingNormDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);
  }


  public ArrayList getHandlingNormDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HandlingNormBusinessObject oHandlingNorm = new HandlingNormBusinessObject();
    return oHandlingNorm.getHandlingNormDetails(sPrimaryKey,lStartPosition,lLastPosition,oBaseDetailInfo);
  }

  public String saveHandlingNormDetail(MaintHandlingNormHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HandlingNormBusinessObject oHandlingNorm = new HandlingNormBusinessObject();
    return oHandlingNorm.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);

  }

  /*
   * Created By Balpreet Kaur
   * Dated 25 March 2008
   *
   *  To Get Handling Norm Header Meta Details.
   */
  public RecordMetaInfo getHandlingNormHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
   HandlingNormBusinessObject oHandlingNorm = new HandlingNormBusinessObject();
   MaintHandlingNormQueryVO oMaintHandlingNormQueryVO=(MaintHandlingNormQueryVO)oBaseQueryVO;
    return oHandlingNorm.getHandlingNormHeaderMetaImpl(oMaintHandlingNormQueryVO);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 25 March 2008
   *
   *  To Get Handling Norm Header Details.
   */
  public ArrayList getHandlingNormHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HandlingNormBusinessObject oHandlingNormBusinessObject=new HandlingNormBusinessObject();
    return oHandlingNormBusinessObject.getHandlingNormHeaderRecord((MaintHandlingNormQueryVO)oQueryVO,lStartPosition,lLastPosition);

  }

  /*
   * Created By Balpreet Kaur
   * Dated 24 March 2008
   *
   *  To Get Gang Combo Details.
   */
  public HndlingNormComboVO getHndlingNormComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HandlingNormBusinessObject oHandlingNormBusinessObject=new HandlingNormBusinessObject();
    return oHandlingNormBusinessObject.getHndlingNormComboDetails();
  }

  /*
   * Created By Balpreet Kaur
   * Dated 24 Aug 2007
   *
   *  To Get WorkSlip Combo Details.
   */
  public WrkSlipComboVO getWrkSlipComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject=new WrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getWrkSlipComboDetails();
  }

  public WrkSlipOprationComboVO getWrkSlipOprationCombo(MaintWrkSlipHeaderBean oBaseHeaderBean)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject = new WrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getWrkSlipOprationCombo(oBaseHeaderBean);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 27 Aug 2007
   *
   *  To Get WorkSlip Header Meta Details.
   */
  public RecordMetaInfo getWrkSlipHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject=new WrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getWrkSlipHeaderMetaImpl((MaintWrkSlipQueryVO)oBaseQueryVO);
 //  return null;
  }

  /*
   * Created By Balpreet Kaur
   * Dated 29 Aug 2007
   *
   *  To Get WorkSlip Header Details.
   */
  public ArrayList getWrkSlipHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject=new WrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getWrkSlipHeaderRecord((MaintWrkSlipQueryVO)oQueryVO,lStartPosition,lLastPosition);

  }

  /*
   * Created By Balpreet Kaur
   * Dated 31 Aug 2007
   *
   *  To Get WorkSlip Details Meta Info.
   */
  public RecordMetaInfo getWrkSlipDetailMetaInfo(String sPrimaryKey,String sLbrTyp) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject=new WrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getWrkSlipDetailMetaInfo(sPrimaryKey,sLbrTyp);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 31 Aug 2007
   *
   *  To Get WorkSlip Details.
   */
  public ArrayList getWrkSlipDetail(String sPrimaryKey,String sLbrTyp,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject=new WrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getWrkSlipDetail(sPrimaryKey,sLbrTyp,lStartPosition,lLastPosition);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 31 Aug 2007
   *
   *  To Save WorkSlip .
   */
  public String saveWrkSlip(MaintWrkSlipHeaderBean oBaseHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject=new WrkSlipBusinessObject();
    return oWrkSlipBusinessObject.saveData((BaseHeaderBean)oBaseHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 7 September 2007
   *
   *  To Delete WorkSlip .
   */
  public void deleteWrkSlipHeaderRecord(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject=new WrkSlipBusinessObject();
    oWrkSlipBusinessObject.deleteHeaderImpl(sPrimaryKey);
  }

 /*
 * Created By Balpreet Kaur
 * Dated
 *
 *  To Get the LOV for Gang In WorkSlip Screen.
 */
   public LovVO getWrkSlipGangLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject = new WrkSlipBusinessObject();
    LovVO oLovVO=oWrkSlipBusinessObject.getWrkSlipGangLOVDataQ(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 19 March 2008
 *
 *  To Get the LOV for Norm Slabs In WorkSlip Screen.
 */
   public LovVO getWrkSlipNormSlabLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject = new WrkSlipBusinessObject();
    LovVO oLovVO=oWrkSlipBusinessObject.getWrkSlipNormSlabLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 19 March 2008
 *
 *  To Get the LOV for Hndling Norm In WorkSlip Screen.
 */
   public LovVO getWrkSlipHndlingNormLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject = new WrkSlipBusinessObject();
    LovVO oLovVO=oWrkSlipBusinessObject.getWrkSlipHndlingNormLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 21 May 2008
 *
 *  To Get the LOV for SOR Rates In WorkSlip Screen.
 */
   public LovVO getWrkSlipSORLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject = new WrkSlipBusinessObject();
    LovVO oLovVO=oWrkSlipBusinessObject.getWrkSlipSORLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 2 July 2008
 *
 *  To Get the LOV for Labours In WorkSlip Screen.
 */
   public LovVO getWrkSlipEmpLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    WrkSlipBusinessObject oWrkSlipBusinessObject = new WrkSlipBusinessObject();
    LovVO oLovVO=oWrkSlipBusinessObject.getWrkSlipEmpLOV(oLovQueryVO);
     return oLovVO;
  }


  /*
   * Created By Balpreet Kaur
   * Dated 11 Feb 2008
   *
   *  To Delete WorkSlip .
   */
  public RecordMetaInfo getDPSInfoHeaderMetaInfo(DPSInfoQueryVO oDPSInfoQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DPSInfoBusinessObject oDPSInfoBusinessObject = new DPSInfoBusinessObject();
    return oDPSInfoBusinessObject.getDPSInfoHeaderMetaInfo(oDPSInfoQueryVO);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 11 Feb 2008
   *
   *  To Delete WorkSlip .
   */
  public ArrayList getDPSInfoHeader(DPSInfoQueryVO oDPSInfoQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DPSInfoBusinessObject oDPSInfoBusinessObject = new DPSInfoBusinessObject();
    return oDPSInfoBusinessObject.getDPSInfoHeader(oDPSInfoQueryVO,lStartPosition,lLastPosition);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 11 Feb 2008
   *
   *  To Delete WorkSlip .
   */
  public String saveDPSInfo(DPSInfoHeaderBean oDPSInfoHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DPSInfoBusinessObject oDPSInfoBusinessObject = new DPSInfoBusinessObject();
    return oDPSInfoBusinessObject.saveData((BaseHeaderBean)oDPSInfoHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 11 Feb 2008
   *
   *  To Delete WorkSlip .
   */
  public DPSInfoComboVO getDPSInfoComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DPSInfoBusinessObject oDPSInfoBusinessObject = new DPSInfoBusinessObject();
    return oDPSInfoBusinessObject.getDPSInfoComboDetails();
  }

/*
 * Created By Balpreet
 * Dated 11 Feb 2008
 *
 *  To Get Dept Labour(Employee) LOV Details(new mode).
 */

  public LovVO getDPSLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DPSInfoBusinessObject oDPSInfoBusinessObject = new DPSInfoBusinessObject();
    LovVO oLovVO=oDPSInfoBusinessObject.getDPSLabourLOVData(oLovQueryVO);
    return oLovVO;
  }

 /*
 * Created By Balpreet
 * Dated 11 Feb 2008
 *
 *  To Get Dept Labour(Employee) LOV Details(Query Detail).
 */

  public LovVO getQueryDPSLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DPSInfoBusinessObject oDPSInfoBusinessObject = new DPSInfoBusinessObject();
    LovVO oLovVO=oDPSInfoBusinessObject.getQueryDPSLabourLOVData(oLovQueryVO);
    return oLovVO;
  }

 /*
 * Created By Balpreet
 * Dated 11 Feb 2008
 *
 *  To Get Dept Labour(Employee) Designation LOV Details(New Mode).
 */

  public LovVO getDPSLabDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DPSInfoBusinessObject oDPSInfoBusinessObject = new DPSInfoBusinessObject();
    LovVO oLovVO=oDPSInfoBusinessObject.getDPSInfoDsgnLOVData(oLovQueryVO);
    return oLovVO;
  }

  ///////////////////////////////////////////////DEPT LABOUR BEAN///////////////

/*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Details Count.
 */
  public RecordMetaInfo getDeptLabHeaderMetaInfo(DeptLabourQueryVO oDeptLabourQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabour = new DeptLabourBusinessObject();
    return oDeptLabour.getDeptLabHeaderMetaInfo(oDeptLabourQueryVO);
  }

/*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Details.
 */
  public ArrayList getDeptLabourHeader(DeptLabourQueryVO oDeptLabourQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabour = new DeptLabourBusinessObject();
    return oDeptLabour.getDeptLabourHeader(oDeptLabourQueryVO,lStartPosition,lLastPosition);
  }

  /*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Save Dept Labour(Employee) Details.
 */

  public String saveDeptLabourInfo(DeptLabourInfoHeaderBean oDeptLabourHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabour = new DeptLabourBusinessObject();
    return oDeptLabour.saveData((BaseHeaderBean)oDeptLabourHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }
  /*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Combo Details.
 */
  public DeptLabourComboVO getDeptLabourComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabour = new DeptLabourBusinessObject();
    return oDeptLabour.getDeptLabourComboDetails();
  }

/*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) LOV Details(new mode).
 */

  public LovVO getDeptLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabour = new DeptLabourBusinessObject();
    LovVO oLovVO=oDeptLabour.getDeptLabourLOVData(oLovQueryVO);
    return oLovVO;
  }

 /*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) LOV Details(Query Detail).
 */

  public LovVO getQueryDeptLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabour = new DeptLabourBusinessObject();
    LovVO oLovVO=oDeptLabour.getQueryDeptLabourLOVData(oLovQueryVO);
    return oLovVO;
  }

 /*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Designation LOV Details(New Mode).
 */

  public LovVO getDeptLabDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabourBusinessObject = new DeptLabourBusinessObject();
    LovVO oLovVO=oDeptLabourBusinessObject.getDeptLabDsgnLOVData(oLovQueryVO);
    return oLovVO;
  }

 /*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Designation LOV Details(Query Mode).
 */
  public LovVO getDeptLabDsgnQryLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabourBusinessObject = new DeptLabourBusinessObject();
    LovVO oLovVO=oDeptLabourBusinessObject.getDeptLabDsgnQryLOVData(oLovQueryVO);
    return oLovVO;
  }

 /*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Section LOV Details(New Mode).
 */
  public LovVO getDeptLabSectionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabourBusinessObject = new DeptLabourBusinessObject();
    LovVO oLovVO=oDeptLabourBusinessObject.getDeptLabSectionLOVData(oLovQueryVO);
    return oLovVO;
  }

 /*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) States LOV Details.
 */
  public LovVO getDeptLabStatecodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabourBusinessObject = new DeptLabourBusinessObject();
    LovVO oLovVO=oDeptLabourBusinessObject.getDeptLabStatecodeLOVData(oLovQueryVO);
    return oLovVO;
  }

 /*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Bank LOV Details.
 */
  public LovVO getDeptLabBankCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabourBusinessObject = new DeptLabourBusinessObject();
    LovVO oLovVO=oDeptLabourBusinessObject.getDeptLabBankCodeLOVData(oLovQueryVO);
    return oLovVO;
  }

/*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Branch LOV Details.
 */
  public LovVO getDeptLabBranchCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabourBusinessObject = new DeptLabourBusinessObject();
    LovVO oLovVO=oDeptLabourBusinessObject.getDeptLabBranchCodeLOVData(oLovQueryVO);
    return oLovVO;
  }

  /*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Pay Code Deyails.
 */
  public ArrayList getDeptLabourVldnDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabourBusinessObject=new DeptLabourBusinessObject();
    return oDeptLabourBusinessObject.getDeptLabourVldnDetails();
  }

  /*
 * Created By Balpreet Kaur
 * Dated 9 Aug 2008
 *
 *  To Get Dept Labour(Employee) Location LOV.
 */
  public LovVO getLbrLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DeptLabourBusinessObject oDeptLabourBusinessObject = new DeptLabourBusinessObject();
    LovVO oLovVO=oDeptLabourBusinessObject.getDeptLabLocLOVData(oLovQueryVO);
    return oLovVO;
  }
  
  public int checkKotLabourCode(String sKotCode, long locId)throws EnrgiseSystemException, EnrgiseApplicationException
    {
      DeptLabourBusinessObject oDeptLabourBO=new DeptLabourBusinessObject();
      return oDeptLabourBO.checkKotLabourCode(sKotCode,locId);
    }
  /*
 * Created By Aqeel Ahmed
 * Dated 12 Feb 2008
 *
 *  To Get Labour(Employee) Haqndling Attendance.
 */

   public RecordMetaInfo getHndlngAttndHeaderMetaInfo(LbrHndlngAttndQueryVO oLbrHndlngAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();
    return oHndlngAttnd.getHndlngAttndHeaderMetaInfo(oLbrHndlngAttndQueryVO);

  }

  public ArrayList getHndlngAttndHeader(LbrHndlngAttndQueryVO oLbrHndlngAttndQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();
    return oHndlngAttnd.getHndlngAttndHeader(oLbrHndlngAttndQueryVO,lStartPosition,lLastPosition);
  }

 public ArrayList getHndlngAttndDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();

    return oHndlngAttnd.getHndlngAttndDetail(sPrimaryKey,lStartPosition,lLastPosition,oLbrHndlngAttndDetailInfo);
  }

  
    

  /*public ArrayList getDARateDetail(String sYear, String sDAType, String sPayScaleType ,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();
    return oHndlngAttnd.getHndlngAttndDetail(sYear,sDAType, sPayScaleType, lStartPosition,lLastPosition);
  }
  public RecordMetaInfo getDARateDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();
    return oHndlngAttnd.getHndlngAttndDetailMetaInfo(sYear, sDAType, sPayScaleType);

  }*/
  public RecordMetaInfo getHndlngAttndDetailMetaInfo(String sPrimaryKey,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();
    return oHndlngAttnd.getHndlngAttndDetailMetaInfo(sPrimaryKey,oLbrHndlngAttndDetailInfo);
  }

  public String saveHndlngAttnd(LbrHndlngAttndHeaderBean oLbrHndlngAttndHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();
    return oHndlngAttnd.saveData((BaseHeaderBean)oLbrHndlngAttndHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);

  }

  public LovVO getHndlngAttndLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();
    LovVO oLovVO=oHndlngAttnd.getHndlngAttndLOVData(oLovQueryVO);
     return oLovVO;
  }

   public LovVO getGangLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();
    LovVO oLovVO=oHndlngAttnd.getGangLOVData(oLovQueryVO);
     return oLovVO;
  }

 /* public RecordMetaInfo getLabourDetailMetaInfo(String sPrimaryKey,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();
    return oHndlngAttnd.getLabourDetailMetaInfo(oLbrHndlngAttndDetailInfo);
  }

  public ArrayList getLabourDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    LbrHndlngAttndBusinessObject oHndlngAttnd = new LbrHndlngAttndBusinessObject();
    return oHndlngAttnd.getLabourDetail(sPrimaryKey,lStartPosition,lLastPosition,oLbrHndlngAttndDetailInfo);
  }*/


    /*
 * Created By Aqeel Ahmed
 * Dated 19 Feb 2008
 *
 *  To Get Labour(Employee) Ancillary Attendance.
 */

   public RecordMetaInfo getAncllryAttndHeaderMetaInfo(LbrAncllryAttndQueryVO oLbrAncllryAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
    return oAncllryAttnd.getAncllryAttndHeaderMetaInfo(oLbrAncllryAttndQueryVO);

  }

  public ArrayList getAncllryAttndHeader(LbrAncllryAttndQueryVO oLbrAncllryAttndQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
    return oAncllryAttnd.getAncllryAttndHeader(oLbrAncllryAttndQueryVO,lStartPosition,lLastPosition);
  }

 public ArrayList getAncllryAttndDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();

    return oAncllryAttnd.getAncllryAttndDetail(sPrimaryKey,lStartPosition,lLastPosition,oLbrAncllryAttndDetailInfo);
  }



  /*public ArrayList getDARateDetail(String sYear, String sDAType, String sPayScaleType ,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
    return oAncllryAttnd.getAncllryAttndDetail(sYear,sDAType, sPayScaleType, lStartPosition,lLastPosition);
  }
  public RecordMetaInfo getDARateDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
    return oAncllryAttnd.getAncllryAttndDetailMetaInfo(sYear, sDAType, sPayScaleType);

  }*/
  public RecordMetaInfo getAncllryAttndDetailMetaInfo(String sPrimaryKey,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
    return oAncllryAttnd.getAncllryAttndDetailMetaInfo(sPrimaryKey,oLbrAncllryAttndDetailInfo);
  }

  public String saveAncllryAttnd(LbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
    return oAncllryAttnd.saveData((BaseHeaderBean)oLbrAncllryAttndHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);

  }

  public LovVO getAncllryAttndLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
    LovVO oLovVO=oAncllryAttnd.getAncllryAttndLOVData(oLovQueryVO);
     return oLovVO;
  }

  public LovVO getAncllryLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
    LovVO oLovVO=oAncllryAttnd.getAncllryLocLOVData(oLovQueryVO);
     return oLovVO;
  }

 /* public RecordMetaInfo getLabourDetailMetaInfo(String sPrimaryKey,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
    return oAncllryAttnd.getLabourDetailMetaInfo(oLbrAncllryAttndDetailInfo);
  }

  public ArrayList getLabourDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
    return oAncllryAttnd.getLabourDetail(sPrimaryKey,lStartPosition,lLastPosition,oLbrAncllryAttndDetailInfo);
  }*/

  ///////////////////////////////////////////////DPS LABOUR ASOR BEAN///////////////

/*
 * Created By Aqeel Ahmed
 * Dated 20 Feb 2008
 *
 *  To Get Dps Labour(ASOR) Details Count.
 */
  public RecordMetaInfo getDpsLbrASORHeaderMetaInfo(DpsLabourASORQueryVO oDpsLabourASORQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrASORBusinessObject oDpsLbrASOR = new DpsLbrASORBusinessObject();
    return oDpsLbrASOR.getDpsLbrASORHeaderMetaInfo(oDpsLabourASORQueryVO);
  }

/*
 * Created By Aqeel Ahmed
 * Dated 20 Feb 2008
 *
 *  To Dps Labour(ASOR) Details.
 */
  public ArrayList getDpsLbrASORHeader(DpsLabourASORQueryVO oDpsLabourASORQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrASORBusinessObject oDpsLbrASOR = new DpsLbrASORBusinessObject();
    return oDpsLbrASOR.getDpsLbrASORHeader(oDpsLabourASORQueryVO,lStartPosition,lLastPosition);
  }

  /*
 * Created By Aqeel Ahmed
 * Dated 20 Feb 2008
 *
 *  To Save Dps Labour(ASOR) Details.
 */

  public String saveDpsLbrASORInfo(DpsLabourASORHeaderBean oDpsLabourASORHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrASORBusinessObject oDpsLbrASOR = new DpsLbrASORBusinessObject();
    return oDpsLbrASOR.saveData((BaseHeaderBean)oDpsLabourASORHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

/*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Details Count.
 */
  public RecordMetaInfo getDpsLbrSORHeaderMetaInfo(DpsLabourSORQueryVO oDpsLabourSORQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrSORBusinessObject oDpsLbrSOR = new DpsLbrSORBusinessObject();
    return oDpsLbrSOR.getDpsLbrSORHeaderMetaInfo(oDpsLabourSORQueryVO);
  }

/*
 * Created By Aqeel Ahmed
 * Dated 28 Jan 2008
 *
 *  To Get Dept Labour(Employee) Details.
 */
  public ArrayList getDpsLbrSORHeader(DpsLabourSORQueryVO oDpsLabourSORQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrSORBusinessObject oDpsLbrSOR = new DpsLbrSORBusinessObject();
    return oDpsLbrSOR.getDpsLbrSORHeader(oDpsLabourSORQueryVO,lStartPosition,lLastPosition);
  }


/*
 * Created By Aqeel Ahmed
 * Dated 27 Feb 2008
 *
 *  To Get Dps Labour(SOR) Details Count.
 */
  public RecordMetaInfo getDpsLbrSORDetailMetaInfo(String sPrimaryKey, String ScreenName, DpsLabourSORDtlInfo oDpsLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrSORBusinessObject oDpsLbrSOR = new DpsLbrSORBusinessObject();
    return oDpsLbrSOR.getDpsLbrSORDetailMetaInfo(sPrimaryKey,ScreenName,oDpsLabourSORDtlInfo);
  }

/*
 * Created By Aqeel Ahmed
 * Dated 27 Feb 2008
 *
 *  To Dps Labour(SOR) Details.
 */
  public ArrayList getDpsLbrSORDetail(String sPrimaryKey,long lStartPosition, long lLastPosition,DpsLabourSORDtlInfo oDpsLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrSORBusinessObject oDpsLbrSOR = new DpsLbrSORBusinessObject();
    return oDpsLbrSOR.getDpsLbrSORDetail(sPrimaryKey,lStartPosition,lLastPosition,oDpsLabourSORDtlInfo);
  }

  /*
 * Created By Aqeel Ahmed
 * Dated 27 Feb 2008
 *
 *  To Save Dps Labour(SOR) Details.
 */


  public String saveDpsLbrSORInfo(DpsLabourSORHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrSORBusinessObject oDpsLbrSOR = new DpsLbrSORBusinessObject();
    return oDpsLbrSOR.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }
  /*
 * Created By Aqeel Ahmed
 * Dated 27 Feb 2008
 *
 *  To Save Dps Labour(SOR) Details.
 */
 /*
  public DpsLabourSORComboVO getDpsLbrSORComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    DpsLbrSORBusinessObject oDpsLbrSOR = new DpsLbrSORBusinessObject();
    return oDpsLbrSOR.getDpsLbrSORComboDetails();
  }
*/
  ///////////////////////////////////////////////DPS LABOUR SOR View BEAN///////////////

/*
 * Created By Aqeel Ahmed
 * Dated 04 March 2008
 *
 *  To Get Dps Labour(SOR) Details Count.
 */
  public RecordMetaInfo getSORViewHeaderMetaInfo(DpsLabourSORViewQryVO oDpsLabourSORViewQryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrSORViewBusiObject oDpsLbrASOR = new DpsLbrSORViewBusiObject();
    return oDpsLbrASOR.getSORViewHeaderMetaInfo(oDpsLabourSORViewQryVO);
  }

/*
 * Created By Aqeel Ahmed
 * Dated 04 March 2008
 *
 *  To Dps Labour(SOR) Details.
 */
  public ArrayList getSORViewHeader(DpsLabourSORViewQryVO oDpsLabourSORViewQryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrSORViewBusiObject oDpsLbrASOR = new DpsLbrSORViewBusiObject();
    return oDpsLbrASOR.getSORViewHeader(oDpsLabourSORViewQryVO,lStartPosition,lLastPosition);
  }

  /*
 * Created By Aqeel Ahmed
 * Dated 04 March 2008
 *
 *  To Get Dps Labour(SOR) Details Count.
 */
  public RecordMetaInfo getDpsLbrSORViewMetaInfo(String sPrimaryKey, String ScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrSORViewBusiObject oDpsLbrSOR = new DpsLbrSORViewBusiObject();
    return oDpsLbrSOR.getDpsLbrSORViewMetaInfo(sPrimaryKey,ScreenName);
  }

/*
 * Created By Aqeel Ahmed
 * Dated 04 March 2008
 *
 *  To Dps Labour(SOR) Details.
 */
  public ArrayList getDpsLbrSORViewDetail(String sPrimaryKey,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrSORViewBusiObject oDpsLbrSOR = new DpsLbrSORViewBusiObject();
    return oDpsLbrSOR.getDpsLbrSORViewDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 3 Mar 2008
 *
 *  To Calculate Dept Labour Incentive
 */
  public String calcDeptIncentive(long lUserID,long lSiteID,CalcDeptIncentiveHeaderBean oCalcDeptIncentiveHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDeptIncentiveBusinessObject oCalcDeptIncentiveBusinessObject=new CalcDeptIncentiveBusinessObject();
    return oCalcDeptIncentiveBusinessObject.calcDeptIncentive(lUserID,lSiteID,oCalcDeptIncentiveHeaderBean);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 14 Oct 2008
 *
 *  To Get Max Pay Year for Dept Incentives
 */
 public String getCalcDeptIncentivePayYear(long locCode,String hdnEmpLbrFlag)throws EnrgiseSystemException, EnrgiseApplicationException
 {
   CalcDeptIncentiveBusinessObject oCalcDeptIncentiveBusinessObject=new CalcDeptIncentiveBusinessObject();
   return oCalcDeptIncentiveBusinessObject.getMaxPayYear(locCode,hdnEmpLbrFlag);
 }


 /*
 * Created By Balpreet Kaur
 * Dated 10 Mar 2008
 *
 *  To Get LOV For Gangs
 */
  public LovVO getCalcIncentiveGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDeptIncentiveBusinessObject oCalcDeptIncentiveBusinessObject=new CalcDeptIncentiveBusinessObject();
    LovVO oLovVO=oCalcDeptIncentiveBusinessObject.getCalcIncentiveGangLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 10 Mar 2008
 *
 *  To Get LOV for Depots of login Loc
 */
  public LovVO getCalcIncentiveDepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDeptIncentiveBusinessObject oCalcDeptIncentiveBusinessObject=new CalcDeptIncentiveBusinessObject();
    LovVO oLovVO=oCalcDeptIncentiveBusinessObject.getCalcIncentiveDepotLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 10 Mar 2008
 *
 *  To Calculate Dept Labour OT Incentive
 */
  public String calcDeptOTIncentive(long lUserID,long lSiteID,CalcDeptOTIncentiveHeaderBean oCalcDeptOTIncentiveHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDeptOTIncentiveBusinessObject oCalcDeptOTIncentiveBusinessObject=new CalcDeptOTIncentiveBusinessObject();
    return oCalcDeptOTIncentiveBusinessObject.calcDeptOTIncentive(lUserID,lSiteID,oCalcDeptOTIncentiveHeaderBean);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 10 Mar 2008
 *
 *  To Get LOV For Gangs for OT Incentive
 */
  public LovVO getCalcOTIncentiveGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDeptOTIncentiveBusinessObject oCalcDeptOTIncentiveBusinessObject=new CalcDeptOTIncentiveBusinessObject();
    LovVO oLovVO=oCalcDeptOTIncentiveBusinessObject.getCalcOTIncentiveGangLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 10 Mar 2008
 *
 *  To Get LOV for Depots of login Loc for OT Incentive
 */
  public LovVO getCalcOTIncentiveDepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDeptOTIncentiveBusinessObject oCalcDeptOTIncentiveBusinessObject=new CalcDeptOTIncentiveBusinessObject();
    LovVO oLovVO=oCalcDeptOTIncentiveBusinessObject.getCalcOTIncentiveDepotLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 10 Mar 2008
 *
 *  To Calculate Dept Labour OTA
 */
  public String calcDeptOTA(long lUserID,long lSiteID,CalcDeptOTAHeaderBean oCalcDeptOTAHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDeptOTABusinessObject oCalcDeptOTABusinessObject=new CalcDeptOTABusinessObject();
    return oCalcDeptOTABusinessObject.calcDeptOTA(lUserID,lSiteID,oCalcDeptOTAHeaderBean);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 10 Mar 2008
 *
 *  To Get LOV For Gangs for OTA
 */
  public LovVO getCalcOTAGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDeptOTABusinessObject oCalcDeptOTABusinessObject=new CalcDeptOTABusinessObject();
    LovVO oLovVO=oCalcDeptOTABusinessObject.getCalcOTAGangLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 10 Mar 2008
 *
 *  To Get LOV for Depots of login Loc for OTA
 */
  public LovVO getCalcOTADepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDeptOTABusinessObject oCalcDeptOTABusinessObject=new CalcDeptOTABusinessObject();
    LovVO oLovVO=oCalcDeptOTABusinessObject.getCalcOTADepotLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 23 May 2008
 *
 *  To Calculate DPS Labour Actual Wok DOne
 */
  public String calcDpsWrkDone(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDpsWrkDoneBusinessObject oCalcDpsWrkDoneBusinessObject=new CalcDpsWrkDoneBusinessObject();
    return oCalcDpsWrkDoneBusinessObject.calcDpsWrkDone(lUserID,lSiteID,oCalcDpsWrkDoneHeaderBean);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 8 July 2008
 *
 *  To Undo DPS Labour Actual Wok DOne
 */
  public String undoDpsWrkDone(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDpsWrkDoneBusinessObject oCalcDpsWrkDoneBusinessObject=new CalcDpsWrkDoneBusinessObject();
    return oCalcDpsWrkDoneBusinessObject.undoDpsWrkDone(lUserID,lSiteID,oCalcDpsWrkDoneHeaderBean);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 8 July 2008
 *
 *  To Post Inv for DPS Labour Actual Wok DOne
 */
  public String PostInvToAP(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDpsWrkDoneBusinessObject oCalcDpsWrkDoneBusinessObject=new CalcDpsWrkDoneBusinessObject();
    return oCalcDpsWrkDoneBusinessObject.PostInvToAP(lUserID,lSiteID,oCalcDpsWrkDoneHeaderBean);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 8 July 2008
 *
 *  To Post Inv for DPS Labour Actual Wok DOne
 */
  public String monthEnd(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDpsWrkDoneBusinessObject oCalcDpsWrkDoneBusinessObject=new CalcDpsWrkDoneBusinessObject();
    return oCalcDpsWrkDoneBusinessObject.monthEnd(lUserID,lSiteID,oCalcDpsWrkDoneHeaderBean);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 23 May 2008
 *
 *  To Get LOV For Gangs for DPS Work Done
 */
  public LovVO getCalcDpsWrkDoneGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDpsWrkDoneBusinessObject oCalcDpsWrkDoneBusinessObject=new CalcDpsWrkDoneBusinessObject();
    LovVO oLovVO=oCalcDpsWrkDoneBusinessObject.getCalcWrkDoneGangLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 23 May 2008
 *
 *  To Get LOV for Depots of login Loc for DPS Work Done
 */
  public LovVO getCalcDpsWrkDoneDepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDpsWrkDoneBusinessObject oCalcDpsWrkDoneBusinessObject=new CalcDpsWrkDoneBusinessObject();
    LovVO oLovVO=oCalcDpsWrkDoneBusinessObject.getCalcWrkDoneDepotLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 23 May 2008
 *
 *  To Calculate DPS Labour Actual Wok DOne
 */
  public String calcDpsMgwIR(long lUserID,long lSiteID,CalcDpsMgwIRHeaderBean oCalcDpsMgwIRHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDpsMgwIRBusinessObject oCalcDpsMgwIRBusinessObject=new CalcDpsMgwIRBusinessObject();
    return oCalcDpsMgwIRBusinessObject.calcDpsMgwIR(lUserID,lSiteID,oCalcDpsMgwIRHeaderBean);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 23 May 2008
 *
 *  To Get LOV For Gangs for DPS Work Done
 */
  public LovVO getCalcDpsMgwIRGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDpsMgwIRBusinessObject oCalcDpsMgwIRBusinessObject=new CalcDpsMgwIRBusinessObject();
    LovVO oLovVO=oCalcDpsMgwIRBusinessObject.getCalcMgwIRGangLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 23 May 2008
 *
 *  To Get LOV for Depots of login Loc for DPS MGW & IR
 */
  public LovVO getCalcDpsMgwIRDepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CalcDpsMgwIRBusinessObject oCalcDpsMgwIRBusinessObject=new CalcDpsMgwIRBusinessObject();
    LovVO oLovVO=oCalcDpsMgwIRBusinessObject.getCalcMgwIRDepotLOV(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated 14 Oct 2008
 *
 *  To Get Max Pay Year for DPS MGW
 */
 public String getCalcDpsMgwMaxPayYear(long locCode,String hdnEmpLbrFlag)throws EnrgiseSystemException, EnrgiseApplicationException
 {
   CalcDpsMgwIRBusinessObject oCalcDpsMgwIRBusinessObject=new CalcDpsMgwIRBusinessObject();
   return oCalcDpsMgwIRBusinessObject.getMaxPayYear(locCode,hdnEmpLbrFlag);
 }

 /*
 * Created By Balpreet Kaur
 * Dated 14 Oct 2008
 *
 *  To Get Max Pay Year for DPS MGW
 */
 public String getCalcDpsWrkDonePayYear(long locCode,String hdnEmpLbrFlag)throws EnrgiseSystemException, EnrgiseApplicationException
 {
   CalcDpsWrkDoneBusinessObject oCalcDpsWrkDoneBusinessObject=new CalcDpsWrkDoneBusinessObject();
   return oCalcDpsWrkDoneBusinessObject.getMaxPayYear(locCode,hdnEmpLbrFlag);
 }

  /*
   * Created By Balpreet Kaur
   * Dated 16 Dec 2008
   *
   *  To Get KOT WorkSlip Combo Details.
   */
    public WrkSlipComboVO getKotWrkSlipComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getWrkSlipComboDetails();
  }

  /*
   * Created By Balpreet Kaur
   * Dated 16 Dec 2008
   *
   *  To Get KOT WorkSlip Header Meta Details.
   */
  public RecordMetaInfo getKotWrkSlipHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getWrkSlipHeaderMetaImpl((MaintKotWrkSlipQueryVO)oBaseQueryVO);
 //  return null;
  }

  /*
   * Created By Balpreet Kaur
   * Dated 16 Dec 2008
   *
   *  To Get  KOT WorkSlip Header Details.
   */
  public ArrayList getKotWrkSlipHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getWrkSlipHeaderRecord((MaintKotWrkSlipQueryVO)oQueryVO,lStartPosition,lLastPosition);

  }

  /*
   * Created By Balpreet Kaur
   * Dated 16 Dec 2008
   *
   *  To Get KOT WorkSlip Details Meta Info.
   */
  public RecordMetaInfo getKotWrkSlipDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getKotWrkSlipDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 16 Dec 2008
   *
   *  To Get KOT WorkSlip Details.
   */
  public ArrayList getKotWrkSlipDetail(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getKotWrkSlipDetail(sPrimaryKey,oBaseDetailInfo,lStartPosition,lLastPosition);
  }

  /*
   * Created By Aqeel
   * Dated 22 Aprl 2009
   *
   *  To Get KOT WorkSlip Details meta count.
   */

  public RecordMetaInfo getKotWrkSlipLbrDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getKotWrkSlipLbrDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);
  }

  /*
   * Created By Aqeel
   * Dated 22 Aprl 2009
   *
   *  To Get KOT WorkSlip Details.
   */
  public ArrayList getKotWrkSlipLbrDetail(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
    return oWrkSlipBusinessObject.getKotWrkSlipLbrDetail(sPrimaryKey,oBaseDetailInfo,lStartPosition,lLastPosition);
  }


  /*
   * Created By Balpreet Kaur
   * Dated 16 Dec 2008
   *
   *  To Save KOT WorkSlip .
   */
  public String saveKotWrkSlip(MaintKotWrkSlipHeaderBean oBaseHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
    return oWrkSlipBusinessObject.saveData((BaseHeaderBean)oBaseHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  /*
   * Created By Balpreet Kaur
   * Dated 16 Dec 2008
   *
   *  To Delete KOT WorkSlip .
   */
  public void deleteKotWrkSlipHeaderRecord(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
    oWrkSlipBusinessObject.deleteHeaderImpl(sPrimaryKey);
  }

 /*
 * Created By Balpreet Kaur
 * Dated
 *
 *  To Get the LOV for Gang In WorkSlip Screen.
 */
   public LovVO getKotWrkSlipGangLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject = new KotWrkSlipBusinessObject();
    LovVO oLovVO=oWrkSlipBusinessObject.getWrkSlipGangLOVDataQ(oLovQueryVO);
     return oLovVO;
  }

 /*
 * Created By Balpreet Kaur
 * Dated
 *
 *  To Get the LOV for Operations In WorkSlip Screen.
 */
   public LovVO getKotWrkslipOperLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject = new KotWrkSlipBusinessObject();
    LovVO oLovVO=oWrkSlipBusinessObject.getKotWrkslipOperLOV(oLovQueryVO);
     return oLovVO;
  }

  /*
   * Created By Balpreet Kaur
   * Dated 16 Dec 2008
   *
   *  To Save KOT WorkSlip .
   */
  public ArrayList wrkslipCalcIncentive(MaintKotWrkSlipHeaderBean oBaseHeaderBean,String sScreenName,ArrayList oDetailBeanArray)throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
    return oWrkSlipBusinessObject.wrkslipCalcIncentive(oBaseHeaderBean,sScreenName,oDetailBeanArray);
  }

  public ArrayList getKotLabourDetail(String sKotId, String fldName, long loginLocId, String depotId)throws EnrgiseSystemException, EnrgiseApplicationException
    {
      KotWrkSlipBusinessObject oWrkSlipBusinessObject=new KotWrkSlipBusinessObject();
      return oWrkSlipBusinessObject.getKotLabourDetail(sKotId, fldName, loginLocId, depotId);
    }
  
  // Kotwal Workslip Labour LOV

  public LovVO getLbrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    KotWrkSlipBusinessObject oWrkSlipBusinessObject = new KotWrkSlipBusinessObject();
    LovVO oLovVO=oWrkSlipBusinessObject.getLbrLOVData(oLovQueryVO);
     return oLovVO;
  }



////// Kotwal Labour Operations by Gagan 9/08/08

 public RecordMetaInfo getLabourOperationsDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IncentiveOperationsBusinessObject oDpsLbrSOR = new IncentiveOperationsBusinessObject();
    return oDpsLbrSOR.getLabourOperationsDetailMetaInfo(sPrimaryKey);
  }

  public ArrayList getLabourOperationsDetail(String sPrimaryKey,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IncentiveOperationsBusinessObject oDpsLbrSOR = new IncentiveOperationsBusinessObject();
    return oDpsLbrSOR.getLabourOperationsDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }

    public String saveLabourOperationsDetails(BaseHeaderBean oDummyHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException
  {
        IncentiveOperationsBusinessObject oGang = new IncentiveOperationsBusinessObject();
        return oGang.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

////Kotwal Labour Operations Details by Gagan 11/08/08
public RecordMetaInfo getLabourOperationsDtlsDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IncentiveOperationsKotDtBusinessObjectl  oDpsLbrSOR = new IncentiveOperationsKotDtBusinessObjectl ();
    return oDpsLbrSOR.getLabourOperationsDtlsDetailMetaInfo(sPrimaryKey, oBaseDetailInfo);
  }

  public ArrayList getLabourOperationsDtlsDetail(String sPrimaryKey,long lStartPosition, long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IncentiveOperationsKotDtBusinessObjectl  oDpsLbrSOR = new IncentiveOperationsKotDtBusinessObjectl ();
    return oDpsLbrSOR.getLabourOperationsDtlsDetail(sPrimaryKey,lStartPosition,lLastPosition, oBaseDetailInfo);
  }

    public String saveLabourOperationsDtlsDetails(IncentiveOperationsHdrKotBean oDummyHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException
  {
        IncentiveOperationsKotDtBusinessObjectl  oGang = new IncentiveOperationsKotDtBusinessObjectl ();
        return oGang.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  public LovVO getKotLbrOperationsDtlsLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IncentiveOperationsKotDtBusinessObjectl oCalcDpsMgwIRBusinessObject=new IncentiveOperationsKotDtBusinessObjectl();
    LovVO oLovVO=oCalcDpsMgwIRBusinessObject.getKotLbrOperationsDtlsLOVData(oLovQueryVO);
     return oLovVO;
  }

public ArrayList getKotLbrOperationsDtlsHeader(KotLbrOprDetailsVO oKotLbrOprDetailsVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
{
    IncentiveOperationsKotDtBusinessObjectl oCalcDpsMgwIRBusinessObject=new IncentiveOperationsKotDtBusinessObjectl();
    return oCalcDpsMgwIRBusinessObject.getKotLbrOperationsDtlsHeader(oKotLbrOprDetailsVO,lStartPosition,lLastPosition);
}

public RecordMetaInfo getKotLbrOperationsDtlsMetaInfo(KotLbrOprDetailsVO oKotLbrOprDetailsVO) throws EnrgiseSystemException, EnrgiseApplicationException
{
    IncentiveOperationsKotDtBusinessObjectl oCalcDpsMgwIRBusinessObject=new IncentiveOperationsKotDtBusinessObjectl();
    return oCalcDpsMgwIRBusinessObject.getKotLbrOperationsDtlsMetaInfo(oKotLbrOprDetailsVO);
}
 /*
 private void chkKotLbrOprEffDate(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
 {
    IncentiveOperationsKotDtBusinessObjectl oCalcDpsMgwIRBusinessObject=new IncentiveOperationsKotDtBusinessObjectl();
     oCalcDpsMgwIRBusinessObject.chkKotLbrOprEffDate(oBaseHeaderBean,sScreenMode,oList);
 }


public boolean savePayScaleHeader(PayScaleHeaderBean oPayScaleHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
{
  DPSOTARatesBusinessObject oDPSOTARateBO = new DPSOTARatesBusinessObject();
  return oDPSOTARateBO.savePayScaleHeader(oPayScaleHeaderBean);
}*/

public RecordMetaInfo getDPSOTARateHeaderMetaInfo(DPSOTARatesQueryVO oDPSOTARatesQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
{
  DPSOTARatesBusinessObject oDPSOTARateBO = new DPSOTARatesBusinessObject();
  return oDPSOTARateBO.getDPSOTARateHeaderMetaInfo(oDPSOTARatesQueryVO);
}

public ArrayList getDPSOTARateHeader(DPSOTARatesQueryVO oDPSOTARatesQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
{
  DPSOTARatesBusinessObject oDPSOTARateBO = new DPSOTARatesBusinessObject();
  return oDPSOTARateBO.getDPSOTARateHeader(oDPSOTARatesQueryVO,lStartPosition,lLastPosition);
}

public RecordMetaInfo getDPSOTARateDetailMetaInfo(String sPrimaryKey,DPSOTARatesDetailInfo oDPSOTADetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
{
  DPSOTARatesBusinessObject oDPSOTARateBO = new DPSOTARatesBusinessObject();
  return oDPSOTARateBO.getDPSOTARateDetailMetaInfo(sPrimaryKey,oDPSOTADetailInfo);
}

public ArrayList getDPSOTARateDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,DPSOTARatesDetailInfo oDPSOTADetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
{
  DPSOTARatesBusinessObject oDPSOTARateBO = new DPSOTARatesBusinessObject();
  return oDPSOTARateBO.getDPSOTARateDetail(sPrimaryKey,lStartPosition,lLastPosition,oDPSOTADetailInfo);
}

public String saveDPSOTARate(DPSOTARateHeaderBean oDPSOTARateHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
{
  DPSOTARatesBusinessObject oDPSOTARateBO = new DPSOTARatesBusinessObject();
  return oDPSOTARateBO.saveData((BaseHeaderBean)oDPSOTARateHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderChanged, oDetailBeanArray, bDetailChanged, oDetailPicked);
}

/*public LovVO getPayScaleLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
{
  DPSOTARatesBusinessObject oPayScale = new DPSOTARatesBusinessObject();
  LovVO oLovVO=oPayScale.getPayScaleLOVData(oLovQueryVO);
  return oLovVO;
}

public LovVO getPayScaleCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
{
  DPSOTARatesBusinessObject oPayScale = new DPSOTARatesBusinessObject();
  LovVO oLovVO=oPayScale.getPayScaleCodeLOVData(oLovQueryVO);
  return oLovVO;
}
*/

//========== DPS LABOUR MINIMUM WAGE =========================================================================================
/* ADDED BY DUSHYANT ON 26 APRIL 2011
 * */
   public String saveDpsLbrMinWageInfo(DpsLabourMinWageHeaderBean oDpsLabourMinWageHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrMinWageBusinessObject oDpsLbrASOR = new DpsLbrMinWageBusinessObject();
    return oDpsLbrASOR.saveData((BaseHeaderBean)oDpsLabourMinWageHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

 public RecordMetaInfo getDpsLbrMinWageHeaderMetaInfo(DpsLabourMinWageQueryVO oDpsLabourMinWageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrMinWageBusinessObject oDpsLbrASOR = new DpsLbrMinWageBusinessObject();
    return oDpsLbrASOR.getDpsLbrMinWageHeaderMetaInfo(oDpsLabourMinWageQueryVO);
  }
  
  public ArrayList getDpsLbrMinWageHeader(DpsLabourMinWageQueryVO oDpsLabourMinWageQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DpsLbrMinWageBusinessObject oDpsLbrASOR = new DpsLbrMinWageBusinessObject();
    return oDpsLbrASOR.getDpsLbrMinWageHeader(oDpsLabourMinWageQueryVO,lStartPosition,lLastPosition);
  }  
    public String updateGangDate(PayrollBaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
    {
        GangBusinessObject oGangDate =new GangBusinessObject();
        return oGangDate.updateGangDate(oBaseHeaderBean,oDetailBeanArray);
    }
 
    ///////////////////////////////////////////////DEPT PAY FIX FACADE BEAN///////////////
 
    public String saveDeptPayFix(DeptPayFixBean oDeptPayFixBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      DeptPayFixBusinessObject oDeptPromotion = new DeptPayFixBusinessObject();
      return oDeptPromotion.saveData((BaseHeaderBean)oDeptPayFixBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    }
    
    public RecordMetaInfo getPayFixHeaderMetaInfo(DummyQueryVO oDeptPromotionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DeptPayFixBusinessObject oDeptPromotion = new DeptPayFixBusinessObject();
      return oDeptPromotion.getPayFixHeaderMetaInfo(oDeptPromotionQueryVO);
    }
    
    public ArrayList getPayFixHeader(DummyQueryVO oDeptPromotionQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        DeptPayFixBusinessObject oDeptPromotion = new DeptPayFixBusinessObject();
      return oDeptPromotion.getPayFixHeader(oDeptPromotionQueryVO,lStartPosition,lLastPosition);
    }
    
  
      public LovVO getDeptPayFixLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        DeptPayFixBusinessObject oDeptPromotion = new DeptPayFixBusinessObject();
        LovVO oLovVO=oDeptPromotion.getDeptPayFixLOVData(oLovQueryVO);
        return oLovVO;
      }

      public LovVO getQueryDeptPayFixLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        DeptPayFixBusinessObject oDeptPromotion = new DeptPayFixBusinessObject();
        LovVO oLovVO=oDeptPromotion.getQueryDeptPayFixLOVData(oLovQueryVO);
        return oLovVO;
      }
    /////////////////////////////////////////NWNP HRMS Info/////////////////////////////////////////////////////////// 
    /*
     *  Created By Shivani
     * Dated 22 Nov 2019
     *
     *  To get Header information of labour .
     */
    public RecordMetaInfo getNWNPInfoHeaderMetaInfo(NWNPInfoQueryVO oNWNPInfoQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPInfoBusinessObject oNWNPInfoBusinessObject = new NWNPInfoBusinessObject();
      return oNWNPInfoBusinessObject.getNWNPInfoHeaderMetaInfo(oNWNPInfoQueryVO);
    }

    /*
     *  Created By Shivani
     * Dated 22 Nov 2019
     *
     *  To get Header information of labour .
     */
    public ArrayList getNWNPInfoHeader(NWNPInfoQueryVO oNWNPInfoQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPInfoBusinessObject oNWNPInfoBusinessObject = new NWNPInfoBusinessObject();
      return oNWNPInfoBusinessObject.getNWNPInfoHeader(oNWNPInfoQueryVO,lStartPosition,lLastPosition);
    }

    /*
     *  Created By Shivani
     * Dated 22 Nov 2019
     *
     * To save labour info.
     */
    public String saveNWNPInfo(NWNPInfoHeaderBean oNWNPInfoHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPInfoBusinessObject oNWNPInfoBusinessObject = new NWNPInfoBusinessObject();
      return oNWNPInfoBusinessObject.saveData((BaseHeaderBean)oNWNPInfoHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    }

    /*
     *  Created By Shivani
     * Dated 22 Nov 2019
     *
     *   .
     */
    public NWNPInfoComboVO getNWNPInfoComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPInfoBusinessObject oNWNPInfoBusinessObject = new NWNPInfoBusinessObject();
      return oNWNPInfoBusinessObject.getNWNPInfoComboDetails();
    }

    /*
    * Created By Shivani
    * Dated 22 Nov 2019
    *
    *  To Get NWNP Labour(Employee) LOV Details(new mode).
    */

    public LovVO getNWNPLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPInfoBusinessObject oNWNPInfoBusinessObject = new NWNPInfoBusinessObject();
      LovVO oLovVO=oNWNPInfoBusinessObject.getNWNPLabourLOVData(oLovQueryVO);
      return oLovVO;
    }

    /*
    * Created By Shivani
    * Dated 22 Nov 2019
    *
    *  To Get NWNP Labour(Employee) LOV Details(Query Detail).
    */

    public LovVO getQueryNWNPLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPInfoBusinessObject oNWNPInfoBusinessObject = new NWNPInfoBusinessObject();
      LovVO oLovVO=oNWNPInfoBusinessObject.getQueryNWNPLabourLOVData(oLovQueryVO);
      return oLovVO;
    }

    /*
    * Created By Shivani
    * Dated 22 Nov 2019
    *
    *  To Get NWNP Labour(Employee) Designation LOV Details(New Mode).
    */

    public LovVO getNWNPLabDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPInfoBusinessObject oNWNPInfoBusinessObject = new NWNPInfoBusinessObject();
      LovVO oLovVO=oNWNPInfoBusinessObject.getNWNPInfoDsgnLOVData(oLovQueryVO);
      return oLovVO;
    }
////////////////////////////////////NWNP SOR Details///////////////////////////////
    /*
 * Created By Shivani Bhardwaj
 * Dated 3 Jan 2019
    */
  public RecordMetaInfo getNWNPLbrSORHeaderMetaInfo(NWNPLabourSORQueryVO oNWNPLabourSORQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    NWNPLbrSORBusinessObject oNWNPLbrSOR = new NWNPLbrSORBusinessObject();
    return oNWNPLbrSOR.getNWNPLbrSORHeaderMetaInfo(oNWNPLabourSORQueryVO);
  }

  public ArrayList getNWNPLbrSORHeader(NWNPLabourSORQueryVO oNWNPLabourSORQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    NWNPLbrSORBusinessObject oNWNPLbrSOR = new NWNPLbrSORBusinessObject();
    return oNWNPLbrSOR.getNWNPLbrSORHeader(oNWNPLabourSORQueryVO,lStartPosition,lLastPosition);
  }

  public RecordMetaInfo getNWNPLbrSORDetailMetaInfo(String sPrimaryKey, String ScreenName, NWNPLabourSORDtlInfo oNWNPLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    NWNPLbrSORBusinessObject oNWNPLbrSOR = new NWNPLbrSORBusinessObject();
    return oNWNPLbrSOR.getNWNPLbrSORDetailMetaInfo(sPrimaryKey,ScreenName,oNWNPLabourSORDtlInfo);

  }

  public ArrayList getNWNPLbrSORDetail(String sPrimaryKey,long lStartPosition, long lLastPosition,NWNPLabourSORDtlInfo oNWNPLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    NWNPLbrSORBusinessObject oNWNPLbrSOR = new NWNPLbrSORBusinessObject();
    return oNWNPLbrSOR.getNWNPLbrSORDetail(sPrimaryKey,lStartPosition,lLastPosition,oNWNPLabourSORDtlInfo);
  }

  public String saveNWNPLbrSORInfo(NWNPLabourSORHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    NWNPLbrSORBusinessObject oNWNPLbrSOR = new NWNPLbrSORBusinessObject();
    return oNWNPLbrSOR.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }
 
    public LovVO getNWNPLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPLbrSORBusinessObject oNWNPLbrSOR = new NWNPLbrSORBusinessObject();
      LovVO oLovVO=oNWNPLbrSOR.getNWNPLocLOVData(oLovQueryVO);
       return oLovVO;
    }
    public LovVO getNWNPOprLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPLbrSORBusinessObject oNWNPLbrSOR = new NWNPLbrSORBusinessObject();
      LovVO oLovVO=oNWNPLbrSOR.getNWNPOprLOVData(oLovQueryVO);
       return oLovVO;
    }

    //========== NWNP LABOUR MINIMUM WAGE =========================================================================================
    /* ADDED BY SHIVANI ON 11 DECEMBER 2019
     * */
       public String saveNWNPLbrMinWageInfo(NWNPLabourMinWageHeaderBean oNWNPLabourMinWageHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        NWNPLbrMinWageBusinessObject oNWNPLbrASOR = new NWNPLbrMinWageBusinessObject();
        return oNWNPLbrASOR.saveData((BaseHeaderBean)oNWNPLabourMinWageHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
      }

     public RecordMetaInfo getNWNPLbrMinWageHeaderMetaInfo(NWNPLabourMinWageQueryVO oNWNPLabourMinWageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        NWNPLbrMinWageBusinessObject oNWNPLbrASOR = new NWNPLbrMinWageBusinessObject();
        return oNWNPLbrASOR.getNWNPLbrMinWageHeaderMetaInfo(oNWNPLabourMinWageQueryVO);
      }
      
      public ArrayList getNWNPLbrMinWageHeader(NWNPLabourMinWageQueryVO oNWNPLabourMinWageQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        NWNPLbrMinWageBusinessObject oNWNPLbrASOR = new NWNPLbrMinWageBusinessObject();
        return oNWNPLbrASOR.getNWNPLbrMinWageHeader(oNWNPLabourMinWageQueryVO,lStartPosition,lLastPosition);
      }
	  
    ////////////////////////////////////NWNP Handling Labour Attendance///////////////////////////////
    /*
     * Created By Dhiraj Kumar
     * Dated 01 Dec 2019
     */          
    public RecordMetaInfo getNWNPHndlngAttndHeaderMetaInfo(NWNPLbrHndlngAttndQueryVO oNWNPLbrHndlngAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        NWNPLbrHndlngBusinessObject oNWNPInfoBusinessObject = new NWNPLbrHndlngBusinessObject();
        return oNWNPInfoBusinessObject.getNWNPHndlngAttndHeaderMetaInfo(oNWNPLbrHndlngAttndQueryVO);

    }
    
    public ArrayList getNWNPHndlngAttndHeader(NWNPLbrHndlngAttndQueryVO oNWNPLbrHndlngAttndQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPLbrHndlngBusinessObject oNWNPHndlngAttnd = new NWNPLbrHndlngBusinessObject();
      return oNWNPHndlngAttnd.getNWNPHndlngAttndHeader(oNWNPLbrHndlngAttndQueryVO,lStartPosition,lLastPosition);
    }
    
    public ArrayList getNWNPHndlngAttndDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,NWNPLbrHndlngAttndDetailInfo oNWNPLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
     {
       NWNPLbrHndlngBusinessObject oNWNPHndlngAttndDetail = new NWNPLbrHndlngBusinessObject();

       return oNWNPHndlngAttndDetail.getNWNPHndlngAttndDetail(sPrimaryKey,lStartPosition,lLastPosition,oNWNPLbrHndlngAttndDetailInfo);
     }
    
    public RecordMetaInfo getNWNPHndlngAttndDetailMetaInfo(String sPrimaryKey,NWNPLbrHndlngAttndDetailInfo oNWNPLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPLbrHndlngBusinessObject oNWNPHndlngAttndMetaInfo = new NWNPLbrHndlngBusinessObject();
      return oNWNPHndlngAttndMetaInfo.getNWNPHndlngAttndDetailMetaInfo(sPrimaryKey,oNWNPLbrHndlngAttndDetailInfo);
    }
    
    public String saveNWNPHndlngAttnd(NWNPLbrHndlngAttndHeaderBean oNWNPLbrHndlngAttndHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPLbrHndlngBusinessObject oNWNPHndlngAttnd = new NWNPLbrHndlngBusinessObject();
      return oNWNPHndlngAttnd.saveData((BaseHeaderBean)oNWNPLbrHndlngAttndHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    }
    
    ////////////////////////////////////NWNP Ancillary Labour Attendance///////////////////////////////
    /*
     * Created By Dhiraj Kumar
     * Dated 14 March 2020
     */
    public RecordMetaInfo getNWNPAncllryAttndHeaderMetaInfo(NWNPLbrAncllryAttndQueryVO oLbrAncllryAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrAncllryAttndBusinessObject oAncllryAttnd = new NWNPLbrAncllryAttndBusinessObject();
     return oAncllryAttnd.getNWNPAncllryAttndHeaderMetaInfo(oLbrAncllryAttndQueryVO);

    }

    public ArrayList getNWNPAncllryAttndHeader(NWNPLbrAncllryAttndQueryVO oLbrAncllryAttndQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrAncllryAttndBusinessObject oAncllryAttnd = new NWNPLbrAncllryAttndBusinessObject();
     return oAncllryAttnd.getNWNPAncllryAttndHeader(oLbrAncllryAttndQueryVO,lStartPosition,lLastPosition);
    }

    public ArrayList getNWNPAncllryAttndDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,NWNPLbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrAncllryAttndBusinessObject oAncllryAttnd = new NWNPLbrAncllryAttndBusinessObject();

     return oAncllryAttnd.getNWNPAncllryAttndDetail(sPrimaryKey,lStartPosition,lLastPosition,oLbrAncllryAttndDetailInfo);
    }



    /*public ArrayList getDARateDetail(String sYear, String sDAType, String sPayScaleType ,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
     return oAncllryAttnd.getAncllryAttndDetail(sYear,sDAType, sPayScaleType, lStartPosition,lLastPosition);
    }
    public RecordMetaInfo getDARateDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
     return oAncllryAttnd.getAncllryAttndDetailMetaInfo(sYear, sDAType, sPayScaleType);

    }*/
    public RecordMetaInfo getNWNPAncllryAttndDetailMetaInfo(String sPrimaryKey,NWNPLbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrAncllryAttndBusinessObject oAncllryAttnd = new NWNPLbrAncllryAttndBusinessObject();
     return oAncllryAttnd.getNWNPAncllryAttndDetailMetaInfo(sPrimaryKey,oLbrAncllryAttndDetailInfo);
    }

    public String saveNWNPAncllryAttnd(NWNPLbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrAncllryAttndBusinessObject oAncllryAttnd = new NWNPLbrAncllryAttndBusinessObject();
     return oAncllryAttnd.saveData((BaseHeaderBean)oLbrAncllryAttndHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);

    }

    public LovVO getNWNPAncllryAttndLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrAncllryAttndBusinessObject oAncllryAttnd = new NWNPLbrAncllryAttndBusinessObject();
     LovVO oLovVO=oAncllryAttnd.getAncllryAttndLOVData(oLovQueryVO);
      return oLovVO;
    }

    public LovVO getNWNPAncllryLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrAncllryAttndBusinessObject oAncllryAttnd = new NWNPLbrAncllryAttndBusinessObject();
     LovVO oLovVO=oAncllryAttnd.getAncllryLocLOVData(oLovQueryVO);
      return oLovVO;
    }

    /* public RecordMetaInfo getLabourDetailMetaInfo(String sPrimaryKey,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
     return oAncllryAttnd.getLabourDetailMetaInfo(oLbrAncllryAttndDetailInfo);
    }

    public ArrayList getLabourDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
     LbrAncllryAttndBusinessObject oAncllryAttnd = new LbrAncllryAttndBusinessObject();
     return oAncllryAttnd.getLabourDetail(sPrimaryKey,lStartPosition,lLastPosition,oLbrAncllryAttndDetailInfo);
    }*/
   

    
    ////////////////////////////////////NWNP Work Slip///////////////////////////////
    /*
     * Created By Dhiraj Kumar
     * Dated 25 Dec 2019
     */ 
    
    public LovVO getNWNPWrkSlipLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
    NWNPWrkSlipBusinessObject oNWNPWrkSlipBusinessObject = new NWNPWrkSlipBusinessObject();
    LovVO oLovVO=oNWNPWrkSlipBusinessObject.getNWNPWrkSlipLOVDataQ(oLovQueryVO);
    return oLovVO;
    }
    
    public LovVO getNWNPWrkSlipEmpLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
    NWNPWrkSlipBusinessObject oNWNPWrkSlipBusinessObject = new NWNPWrkSlipBusinessObject();
    LovVO oLovVO=oNWNPWrkSlipBusinessObject.getNWNPWrkSlipEmpLOV(oLovQueryVO);
    return oLovVO;
    }
   
    public NWNPWrkSlipComboVO getNwnpWrkSlipComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPWrkSlipBusinessObject oNWNPWrkSlipBusinessObject=new NWNPWrkSlipBusinessObject();
      return oNWNPWrkSlipBusinessObject.getNwnpWrkSlipComboDetails();
    }  
    
    public String saveNwnpWrkSlip(NWNPMaintWrkSlipHeaderBean oBaseHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPWrkSlipBusinessObject oNwnpWrkSlipBusinessObject=new NWNPWrkSlipBusinessObject();
      return oNwnpWrkSlipBusinessObject.saveData((BaseHeaderBean)oBaseHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    }
    
    public RecordMetaInfo getNwnpWrkSlipHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPWrkSlipBusinessObject oNwnpWrkSlipBusinessObject=new NWNPWrkSlipBusinessObject();
      return oNwnpWrkSlipBusinessObject.getNwnpWrkSlipHeaderMetaImpl((NWNPMaintWrkSlipQueryVO)oBaseQueryVO);
    }
    
    public ArrayList getNwnpWrkSlipHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPWrkSlipBusinessObject oNwnpWrkSlipBusinessObject=new NWNPWrkSlipBusinessObject();
      return oNwnpWrkSlipBusinessObject.getNwnpWrkSlipHeaderRecord((NWNPMaintWrkSlipQueryVO)oQueryVO,lStartPosition,lLastPosition);
    }
    
    public RecordMetaInfo getNwnpWrkSlipDetailMetaInfo(String sPrimaryKey,String sLbrTyp) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPWrkSlipBusinessObject oNwnpWrkSlipBusinessObject=new NWNPWrkSlipBusinessObject();
      return oNwnpWrkSlipBusinessObject.getNwnpWrkSlipDetailMetaInfo(sPrimaryKey,sLbrTyp);
    }
    
    public ArrayList getNwnpWrkSlipDetail(String sPrimaryKey,String sLbrTyp,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPWrkSlipBusinessObject oNwnpWrkSlipBusinessObject=new NWNPWrkSlipBusinessObject();
      return oNwnpWrkSlipBusinessObject.getNwnpWrkSlipDetail(sPrimaryKey,sLbrTyp,lStartPosition,lLastPosition);
    }
    
    public void deleteNwnpWrkSlipHeaderRecord(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPWrkSlipBusinessObject oNwnpWrkSlipBusinessObject=new NWNPWrkSlipBusinessObject();
      oNwnpWrkSlipBusinessObject.deleteNwnpHeaderImpl(sPrimaryKey);
    }
    
    ////////////////////////////////////NWNP AREA CLASSIFICATION MAPPING FACADE///////////////////////////////
    /*
     * Created By Dhiraj Kumar
     * Dated 20 Feb 2020
     */ 
        
    public LovVO getNwnpCityMapLocLovData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPAreaClassiFicationMappingBusinessObject oCityMapLoc = new NWNPAreaClassiFicationMappingBusinessObject();
      LovVO oLovVO=oCityMapLoc.getNwnpCityMapLocLovData(oLovQueryVO);
      return oLovVO;
    }
    
    public RecordMetaInfo getNwnpCityLocMapDetailMetaInfo(BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPAreaClassiFicationMappingBusinessObject oCityLocMap=new NWNPAreaClassiFicationMappingBusinessObject();
      return oCityLocMap.getNWNPCityLocMapDetailMetaInfo(oBaseDetailInfo);
    }
    
    public ArrayList getNwnpCityLocMapDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPAreaClassiFicationMappingBusinessObject oCityLocMap=new NWNPAreaClassiFicationMappingBusinessObject();
      return oCityLocMap.getNWNPCityLocMapDetails(sPrimaryKey,lStartPosition,lLastPosition,oBaseDetailInfo);
    }
    
    public RecordMetaInfo getNwnpCityLocMapHeaderMetaInfo(NWNPAreaClassiFicationMappingQueryVO oNWNPAreaClassiFicationMappingQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPAreaClassiFicationMappingBusinessObject oCityLocMap=new NWNPAreaClassiFicationMappingBusinessObject();
      return oCityLocMap.getNWNPCityLocMapHeaderMetaInfo(oNWNPAreaClassiFicationMappingQueryVO);
    }
    public ArrayList getNwnpCityLocMapHeader(NWNPAreaClassiFicationMappingQueryVO oNWNPAreaClassiFicationMappingQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPAreaClassiFicationMappingBusinessObject oCityLocMap=new NWNPAreaClassiFicationMappingBusinessObject();
      return oCityLocMap.getNWNPCityLocMapHeader(oNWNPAreaClassiFicationMappingQueryVO,lStartPosition,lLastPosition);
    }
    public String saveNwnpCityLocMapDetail(NWNPAreaClassiFicationMappingHeaderBean oAreaClassiFicationHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      NWNPAreaClassiFicationMappingBusinessObject oCityLocMap=new NWNPAreaClassiFicationMappingBusinessObject();
      return oCityLocMap.saveData(oAreaClassiFicationHeaderBean,oWhenPicked,sScreenName,sScreenMode,bHeaderDataChanged,oDetailBeanArray,bDetailDataChanged,oDetailPicked);
    }
    
    
    
//    public NWNPAreaMappingComboVO getNwnpLocationComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException
//    {
//      NWNPAreaClassiFicationMappingBusinessObject oNWNPAreaMappBusinessObject=new NWNPAreaClassiFicationMappingBusinessObject();
//      return oNWNPAreaMappBusinessObject.getNwnpAreaMappComboDetails();
//    }  
    
    ////////////////////////////////////NWNP Operations Details///////////////////////////////
    /*
     * Created By Shivani Bhardwaj
     * Dated 27 Dec 2019
     */
      public RecordMetaInfo getNWNPLbrOprtnHeaderMetaInfo(NWNPLabourOprtnQueryVO oNWNPLabourOprtnQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        NWNPLbrOprtnBusinessObject oNWNPLbrOprtn = new NWNPLbrOprtnBusinessObject();
        return oNWNPLbrOprtn.getNWNPLbrOprtnHeaderMetaInfo(oNWNPLabourOprtnQueryVO);
      }

      public ArrayList getNWNPLbrOprtnHeader(NWNPLabourOprtnQueryVO oNWNPLabourOprtnQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        NWNPLbrOprtnBusinessObject oNWNPLbrOprtn = new NWNPLbrOprtnBusinessObject();
        return oNWNPLbrOprtn.getNWNPLbrOprtnHeader(oNWNPLabourOprtnQueryVO,lStartPosition,lLastPosition);
      }

      public RecordMetaInfo getNWNPLbrOprtnDetailMetaInfo(String sPrimaryKey, String ScreenName, NWNPLabourOprtnDtlInfo oNWNPLabourOprtnDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        NWNPLbrOprtnBusinessObject oNWNPLbrOprtn = new NWNPLbrOprtnBusinessObject();
        return oNWNPLbrOprtn.getNWNPLbrOprtnDetailMetaInfo(sPrimaryKey,ScreenName,oNWNPLabourOprtnDtlInfo);

      }

      public ArrayList getNWNPLbrOprtnDetail(String sPrimaryKey,long lStartPosition, long lLastPosition,NWNPLabourOprtnDtlInfo oNWNPLabourOprtnDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        NWNPLbrOprtnBusinessObject oNWNPLbrOprtn = new NWNPLbrOprtnBusinessObject();
        return oNWNPLbrOprtn.getNWNPLbrOprtnDetail(sPrimaryKey,lStartPosition,lLastPosition,oNWNPLabourOprtnDtlInfo);
      }

      public String saveNWNPLbrOprtnInfo(NWNPLabourOprtnHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
      {
        NWNPLbrOprtnBusinessObject oNWNPLbrOprtn = new NWNPLbrOprtnBusinessObject();
        return oNWNPLbrOprtn.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
      }
      
//      public LovVO getNWNPWrkSlipLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
//    {
//     NWNPWrkSlipBusinessObject oNWNPWrkSlipBusinessObject = new NWNPWrkSlipBusinessObject();
//     LovVO oLovVO=oNWNPWrkSlipBusinessObject.getNWNPWrkSlipLOVDataQ(oLovQueryVO);
//      return oLovVO;
//    }
//    
//    public LovVO getNWNPWrkSlipEmpLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
//    {
//     NWNPWrkSlipBusinessObject oNWNPWrkSlipBusinessObject = new NWNPWrkSlipBusinessObject();
//     LovVO oLovVO=oNWNPWrkSlipBusinessObject.getNWNPWrkSlipEmpLOV(oLovQueryVO);
//     return oLovVO;
//    }
    
    //////////////////////////////////////////////NWNP AreaClassiFicationMapping FACADE BEAN////////////////////////////////////////////////
        // added by Ravindra on 06 JANUARY 2020
     
    public ArrayList getAreaClassiFicationMapping(String sPrimaryKey,long lStartPosition, long lLastPosition, NWNPAreaClassiFicationMappingQueryVO oNWNPAreaClassiFicationMappingQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException{
        
            NWNPAreaClassiFicationMappingBusinessObject oNWNPMapping = new NWNPAreaClassiFicationMappingBusinessObject();
            return oNWNPMapping.getNWNPAreaClassiFicationMappingDetail(sPrimaryKey,lStartPosition,lLastPosition,oNWNPAreaClassiFicationMappingQueryVO);
        }

    
    ////////////////////////////////////NWNP ASOR Details///////////////////////////////
     /*
    * Created By Ravindra Singh
    * Dated 9 Jan 2020
     */
    public RecordMetaInfo getNWNPLbrASORHeaderMetaInfo(NWNPLabourASORQueryVO oNWNPLabourASORQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrASORBusinessObject oNWNPLbrASOR = new NWNPLbrASORBusinessObject();
     return oNWNPLbrASOR.getNWNPLbrASORHeaderMetaInfo(oNWNPLabourASORQueryVO);
    }

    public ArrayList getNWNPLbrASORHeader(NWNPLabourASORQueryVO oNWNPLabourASORQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrASORBusinessObject oNWNPLbrASOR = new NWNPLbrASORBusinessObject();
     return oNWNPLbrASOR.getNWNPLbrASORHeader(oNWNPLabourASORQueryVO,lStartPosition,lLastPosition);
    }

    public RecordMetaInfo getNWNPLbrASORDetailMetaInfo(String sPrimaryKey, String ScreenName, NWNPLabourASORDtlInfo oNWNPLabourASORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrASORBusinessObject oNWNPLbrASOR = new NWNPLbrASORBusinessObject();
     return oNWNPLbrASOR.getNWNPLbrASORDetailMetaInfo(sPrimaryKey,ScreenName,oNWNPLabourASORDtlInfo);

    }

    public ArrayList getNWNPLbrASORDetail(String sPrimaryKey,long lStartPosition, long lLastPosition,NWNPLabourASORDtlInfo oNWNPLabourASORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrASORBusinessObject oNWNPLbrASOR = new NWNPLbrASORBusinessObject();
     return oNWNPLbrASOR.getNWNPLbrASORDetail(sPrimaryKey,lStartPosition,lLastPosition,oNWNPLabourASORDtlInfo);
    }

    public String saveNWNPLbrASORInfo(NWNPLabourASORHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
     NWNPLbrASORBusinessObject oNWNPLbrASOR = new NWNPLbrASORBusinessObject();
     return oNWNPLbrASOR.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    }
    
//     public LovVO getNWNPLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
//     {
//       NWNPLbrASORBusinessObject oNWNPLbrASOR = new NWNPLbrASORBusinessObject();
//       LovVO oLovVO=oNWNPLbrASOR.getNWNPLocLOVData(oLovQueryVO);
//        return oLovVO;
//     }
//     public LovVO getNWNPOprLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
//     {
//       NWNPLbrASORBusinessObject oNWNPLbrASOR = new NWNPLbrASORBusinessObject();
//       LovVO oLovVO=oNWNPLbrASOR.getNWNPOprLOVData(oLovQueryVO);
//        return oLovVO;
//     }

    
}
