package FCIPAY.Payroll.EJB.facade;

import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;

import javax.ejb.EJBObject;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import java.sql.Timestamp;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;

import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import java.rmi.RemoteException;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.vo.BaseQueryVO;

import FCIPAY.Payroll.Labour.Utility.MaintGangHeaderBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.GangComboVO;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipComboVO;
import FCIPAY.Payroll.Labour.Utility.MaintWrkSlipHeaderBean;
import FCIPAY.Payroll.Labour.Utility.MaintKotWrkSlipHeaderBean;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.HndlingNormComboVO;
import FCIPAY.Payroll.Labour.Utility.MaintHandlingNormHeaderBean;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NormComboVO;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSInfoComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSInfoQueryVO;
import FCIPAY.Payroll.Labour.Utility.DPSInfoHeaderBean;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DeptLabourComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DeptLabourQueryVO;
import FCIPAY.Payroll.Labour.Utility.DeptLabourInfoHeaderBean;
import FCIPAY.Payroll.Labour.EJB.business.DeptLabourBusinessObject;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrHndlngAttndQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrHndlngAttndDetailInfo;
import FCIPAY.Payroll.Labour.Utility.LbrHndlngAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.LbrHndlngAttndBean;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrAncllryAttndQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.LbrAncllryAttndDetailInfo;
import FCIPAY.Payroll.Labour.Utility.LbrAncllryAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.LbrAncllryAttndBean;

import FCIPAY.Payroll.Labour.Utility.DpsLabourASORHeaderBean;
import FCIPAY.Payroll.Labour.Utility.DpsLabourMinWageHeaderBean;   // added by dushyant on 26 April 2011
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourASORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourMinWageQueryVO;  // added by dushyant on 26 April 2011

import FCIPAY.Payroll.Labour.Utility.DpsLabourSORHeaderBean;
import FCIPAY.Payroll.Labour.Utility.DpsLabourSORDtlBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORComboVO;

import FCIPAY.Payroll.Labour.Utility.DpsLabourSORViewBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DpsLabourSORViewQryVO;

import FCIPAY.Payroll.Labour.Utility.CalcDeptIncentiveHeaderBean;
import FCIPAY.Payroll.Labour.Utility.CalcDeptOTIncentiveHeaderBean;
import FCIPAY.Payroll.Labour.Utility.CalcDeptOTAHeaderBean;
import FCIPAY.Payroll.Labour.Utility.CalcDpsWrkDoneHeaderBean;
import FCIPAY.Payroll.Labour.Utility.CalcDpsMgwIRHeaderBean;

import FCIPAY.Payroll.Labour.Utility.MaintIncentiveOperationsKotBean;
import FCIPAY.Payroll.Labour.EJB.business.IncentiveOperationsBusinessObject;
import FCIPAY.Payroll.Labour.EJB.business.IncentiveOperationsKotDtBusinessObjectl;
import FCIPAY.Payroll.Labour.Utility.IncentiveOperationsDtlKotBean;
import FCIPAY.Payroll.Labour.Utility.IncentiveOperationsHdrKotBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.KotLbrOprDetailsVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.KotwalLbrMasterDetailsVO;

import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSOTARatesDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.DPSOTARatesQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPAreaClassiFicationMappingQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPAreaMappingComboVO;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourSORHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourSORDtlBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPInfoComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPInfoQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourASORDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourASORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourMinWageQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourOprtnQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourOprtnDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourSORDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourSORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrHndlngAttndDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrHndlngAttndQueryVO;
import FCIPAY.Payroll.Labour.Utility.DPSOTARateHeaderBean;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.WrkSlipOprationComboVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourSORDtlInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLabourSORQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrAncllryAttndDetailInfo;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPLbrAncllryAttndQueryVO;
import FCIPAY.Payroll.Labour.DATAACCESSTIER.VO.NWNPWrkSlipComboVO;
import FCIPAY.Payroll.Labour.Utility.NWNPAreaClassiFicationMappingHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPInfoHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourASORHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourOprtnHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLabourMinWageHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLbrAncllryAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPLbrHndlngAttndHeaderBean;
import FCIPAY.Payroll.Labour.Utility.NWNPMaintWrkSlipHeaderBean;
import FCIPAY.Payroll.UTILITY.DeptPayFixBean;
import FCIPAY.Payroll.UTILITY.MaintCityLocMapHeaderBean;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;;

public interface LabourFacade extends EJBObject
{
   ////////////////////// MAINTAIN GANG DETAILS//////////////////////////////////////////////////////
    public ArrayList getGangDetail(String primaryKey,long absStart,long absEnd)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
    public RecordMetaInfo getGangDetailMetaInfo(String sPrimaryKey)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
    public String saveGang(MaintGangHeaderBean oBaseHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
    public LovVO getGangLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public GangComboVO getGangComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getGangDepotLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getGangLbrLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public String updateGangDate(PayrollBaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException,RemoteException;

    ////////////////////// MAINTAIN OTHER NORM DETAILS//////////////////////////////////////////////////////
    public ArrayList getNormDetail(String primaryKey,long absStart,long absEnd,BaseDetailInfo oBaseDetailInfo)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
    public RecordMetaInfo getNormDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
    public String saveNormDetail(BaseHeaderBean oDummyHeaderBean,Timestamp time,String s,String s2,boolean b,ArrayList a,boolean b2,Timestamp t)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
    public NormComboVO getNormComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getNormHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getNormHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

	 ////////////////Labour Handling Norm

	public RecordMetaInfo getHandlingNormDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public ArrayList getHandlingNormDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public String saveHandlingNormDetail(MaintHandlingNormHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public HndlingNormComboVO getHndlingNormComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getHandlingNormHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHandlingNormHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

	 ////////////////WorkSlip Details
  public WrkSlipComboVO getWrkSlipComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public WrkSlipOprationComboVO getWrkSlipOprationCombo(MaintWrkSlipHeaderBean oBaseHeaderBean)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getWrkSlipHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getWrkSlipHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getWrkSlipDetailMetaInfo(String sPrimaryKey,String sLbrTyp) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getWrkSlipDetail(String sPrimaryKey,String sLbrTyp,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveWrkSlip(MaintWrkSlipHeaderBean oBaseHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  public void deleteWrkSlipHeaderRecord(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getWrkSlipGangLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getWrkSlipNormSlabLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getWrkSlipHndlingNormLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getWrkSlipSORLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getWrkSlipEmpLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

	 ////////////////DPS Labour Info/////////////////
  public RecordMetaInfo getDPSInfoHeaderMetaInfo(DPSInfoQueryVO oDPSInfoQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDPSInfoHeader(DPSInfoQueryVO oDPSInfoQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveDPSInfo(DPSInfoHeaderBean oDPSInfoHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public DPSInfoComboVO getDPSInfoComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDPSLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryDPSLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDPSLabDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  //////////////////////////////////////////////DEPT LABOUR FACADE////////////////////////////////////////////////

  public RecordMetaInfo getDeptLabHeaderMetaInfo(DeptLabourQueryVO oDeptLabourQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDeptLabourHeader(DeptLabourQueryVO oDeptLabourQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveDeptLabourInfo(DeptLabourInfoHeaderBean oDeptLabourHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public DeptLabourComboVO getDeptLabourComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDeptLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryDeptLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDeptLabDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDeptLabDsgnQryLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDeptLabSectionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDeptLabStatecodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public int checkKotLabourCode(String sKotCode, long locId )throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  //public LovVO getDAArrearLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  public LovVO getDeptLabBankCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDeptLabBranchCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public LovVO getEmpTypeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public LovVO getDeptLabLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDeptLabourVldnDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLbrLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  //////////////////////////////////////////////LABOUR HANDLING ATTENDANCE FACADE////////////////////////////////////////////////

  public RecordMetaInfo getHndlngAttndHeaderMetaInfo(LbrHndlngAttndQueryVO oLbrHndlngAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHndlngAttndHeader(LbrHndlngAttndQueryVO oLbrHndlngAttndQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public ArrayList getDARateDetail(String sYear, String sDAType, String sPayScaleType ,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 // public RecordMetaInfo getDARateDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveHndlngAttnd(LbrHndlngAttndHeaderBean oLbrHndlngAttndHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getHndlngAttndLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getGangLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHndlngAttndDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getHndlngAttndDetailMetaInfo(String sPrimaryKey,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  /*public ArrayList getLabourDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getLabourDetailMetaInfo(String sPrimaryKey,LbrHndlngAttndDetailInfo oLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;*/


 //////////////////////////////////////////////LABOUR ANCILLARY ATTENDANCE FACADE////////////////////////////////////////////////

  public RecordMetaInfo getAncllryAttndHeaderMetaInfo(LbrAncllryAttndQueryVO oLbrAncllryAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getAncllryAttndHeader(LbrAncllryAttndQueryVO oLbrAncllryAttndQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public ArrayList getDARateDetail(String sYear, String sDAType, String sPayScaleType ,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 // public RecordMetaInfo getDARateDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveAncllryAttnd(LbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getAncllryAttndLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getAncllryLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getAncllryAttndDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getAncllryAttndDetailMetaInfo(String sPrimaryKey,LbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  //////////////////////////////////////////////DPS LABOUR ASOR FACADE////////////////////////////////////////////////

  public RecordMetaInfo getDpsLbrASORHeaderMetaInfo(DpsLabourASORQueryVO oDpsLabourASORQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDpsLbrASORHeader(DpsLabourASORQueryVO oDpsLabourASORQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveDpsLbrASORInfo(DpsLabourASORHeaderBean oDpsLabourASORHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public DeptLabourComboVO getDeptLabourComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 //////////////////////////////////////////////DPS LABOUR MINIMUM WAGE FACADE////////////////////////////////////////////////
// added by dushyant on 26 April 2011
  public RecordMetaInfo getDpsLbrMinWageHeaderMetaInfo(DpsLabourMinWageQueryVO oDpsLabourMinWageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDpsLbrMinWageHeader(DpsLabourMinWageQueryVO oDpsLabourMinWageQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveDpsLbrMinWageInfo(DpsLabourMinWageHeaderBean oDpsLabourMinWageHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 //////////////////////////////////////////////DPS LABOUR SOR FACADE////////////////////////////////////////////////
  public RecordMetaInfo getDpsLbrSORHeaderMetaInfo(DpsLabourSORQueryVO oDpsLabourSORQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDpsLbrSORHeader(DpsLabourSORQueryVO oDpsLabourSORQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getDpsLbrSORDetailMetaInfo(String sPrimaryKey,String ScreenName,DpsLabourSORDtlInfo oDpsLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDpsLbrSORDetail(String sPrimaryKey,long lStartPosition, long lLastPosition, DpsLabourSORDtlInfo oDpsLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveDpsLbrSORInfo(DpsLabourSORHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
//  public DpsLabourSORComboVO getDpsLbrSORComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  //////////////////////////////////////////////DPS LABOUR SOR VIEW FACADE////////////////////////////////////////////////

  public RecordMetaInfo getSORViewHeaderMetaInfo(DpsLabourSORViewQryVO oDpsLabourSORViewQryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getSORViewHeader(DpsLabourSORViewQryVO oDpsLabourSORViewQryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public String saveDpsLbrSORInfo(DpsLabourASORHeaderBean oDpsLabourASORHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getDpsLbrSORViewMetaInfo(String sPrimaryKey,String ScreenName) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDpsLbrSORViewDetail(String sPrimaryKey,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


 //////////////////////////////////////////////CALCULATE DEPT INCENTIVES////////////////////////////////////////////////
  public String calcDeptIncentive(long lUserID,long lSiteID,CalcDeptIncentiveHeaderBean oCalcDeptIncentiveHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCalcIncentiveGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCalcIncentiveDepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getCalcDeptIncentivePayYear(long locCode,String hdnEmpLbrFlag)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 //////////////////////////////////////////////CALCULATE DEPT OT INCENTIVES////////////////////////////////////////////////
  public String calcDeptOTIncentive(long lUserID,long lSiteID,CalcDeptOTIncentiveHeaderBean oCalcDeptOTIncentiveHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCalcOTIncentiveGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCalcOTIncentiveDepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 //////////////////////////////////////////////CALCULATE DEPT OTA////////////////////////////////////////////////
  public String calcDeptOTA(long lUserID,long lSiteID,CalcDeptOTAHeaderBean oCalcDeptOTAHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCalcOTAGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCalcOTADepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 //////////////////////////////////////////////CALCULATE DPS ACTUAL WORK DONE////////////////////////////////////////////////
  public String calcDpsWrkDone(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCalcDpsWrkDoneGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCalcDpsWrkDoneDepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String undoDpsWrkDone(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String PostInvToAP(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String monthEnd(long lUserID,long lSiteID,CalcDpsWrkDoneHeaderBean oCalcDpsWrkDoneHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getCalcDpsWrkDonePayYear(long locCode,String hdnEmpLbrFlag)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 //////////////////////////////////////////////CALCULATE DPS MGW & IR////////////////////////////////////////////////
  public String calcDpsMgwIR(long lUserID,long lSiteID,CalcDpsMgwIRHeaderBean oCalcDpsMgwIRHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCalcDpsMgwIRGangLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCalcDpsMgwIRDepotLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getCalcDpsMgwMaxPayYear(long locCode,String hdnEmpLbrFlag)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

	 //////////////// KOT WorkSlip Details
  public WrkSlipComboVO getKotWrkSlipComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getKotWrkSlipHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getKotWrkSlipHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getKotWrkSlipDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getKotWrkSlipDetail(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

    public RecordMetaInfo getKotWrkSlipLbrDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getKotWrkSlipLbrDetail(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

    public String saveKotWrkSlip(MaintKotWrkSlipHeaderBean oBaseHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
    public void deleteKotWrkSlipHeaderRecord(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getKotWrkSlipGangLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getKotWrkslipOperLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList wrkslipCalcIncentive(MaintKotWrkSlipHeaderBean oBaseHeaderBean,String sScreenName,ArrayList oDetailBeanArray)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
    public LovVO getLbrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getKotLabourDetail(String sKotId, String fldName,long loginLocId, String depotId)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
    
    ///////////////KOTWAL LABOUR OPERATIONS///////////////////////
   public RecordMetaInfo getLabourOperationsDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLabourOperationsDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public String saveLabourOperationsDetails(BaseHeaderBean oDummyHeaderBean,Timestamp time,String s,String s2,boolean b,ArrayList a,boolean b2,Timestamp t)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;

  ///////////////KOTWAL LABOUR OPERATIONS DETAILS///////////////////////
   public RecordMetaInfo getLabourOperationsDtlsDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public ArrayList getLabourOperationsDtlsDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public String saveLabourOperationsDtlsDetails(IncentiveOperationsHdrKotBean oDummyHeaderBean,Timestamp time,String s,String s2,boolean b,ArrayList a,boolean b2,Timestamp t)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
   public LovVO getKotLbrOperationsDtlsLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public ArrayList getKotLbrOperationsDtlsHeader(KotLbrOprDetailsVO oKotLbrOprDetailsVO,long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public RecordMetaInfo getKotLbrOperationsDtlsMetaInfo(KotLbrOprDetailsVO oKotLbrOprDetailsVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 //  public void chkKotLbrOprEffDate(BaseHeaderBean oBaseHeaderBean,String sScreenMode,ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
 /*Code For DPS OTA Rates */
  //public boolean saveDPSOTARateHeader(PayScaleHeaderBean oPayScaleHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getDPSOTARateHeaderMetaInfo(DPSOTARatesQueryVO oDPSOTARatesQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDPSOTARateHeader(DPSOTARatesQueryVO oDPSOTARatesQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getDPSOTARateDetailMetaInfo(String sPrimaryKey,DPSOTARatesDetailInfo oDPSOTADetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDPSOTARateDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,DPSOTARatesDetailInfo oDPSOTADetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
  public String saveDPSOTARate(DPSOTARateHeaderBean oDPSOTARateHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  //public LovVO getPayScaleLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public LovVO getPayScaleCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
  //////////////////////////////////////////////PAY FIXATION FACADE////////////////////////////////////////////////

    public RecordMetaInfo getPayFixHeaderMetaInfo(DummyQueryVO oDummyQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getPayFixHeader(DummyQueryVO oDummyQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getDeptPayFixLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getQueryDeptPayFixLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 
    public String saveDeptPayFix(DeptPayFixBean oDeptPayFixBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

    ////////////////////////////////////////NWNP Labour info//////////////////////////////////////////////////////////
     public RecordMetaInfo getNWNPInfoHeaderMetaInfo(NWNPInfoQueryVO oNWNPInfoQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public ArrayList getNWNPInfoHeader(NWNPInfoQueryVO oNWNPInfoQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public String saveNWNPInfo(NWNPInfoHeaderBean oNWNPInfoHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public NWNPInfoComboVO getNWNPInfoComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public LovVO getNWNPLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public LovVO getQueryNWNPLabourLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public LovVO getNWNPLabDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

    //////////////////////////////////////////////NWNP Handling Labour Attendance////////////////////////////////////////////////
    public RecordMetaInfo getNWNPHndlngAttndHeaderMetaInfo(NWNPLbrHndlngAttndQueryVO oNWNPLbrHndlngAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getNWNPHndlngAttndHeader(NWNPLbrHndlngAttndQueryVO oNWNPLbrHndlngAttndQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getNWNPHndlngAttndDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,NWNPLbrHndlngAttndDetailInfo oNWNPLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getNWNPHndlngAttndDetailMetaInfo(String sPrimaryKey,NWNPLbrHndlngAttndDetailInfo oNWNPLbrHndlngAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveNWNPHndlngAttnd(NWNPLbrHndlngAttndHeaderBean oNWNPLbrHndlngAttndHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    
    //////////////////////////////////////////////NWNP Ancillary Labour Attendance////////////////////////////////////////////////
    
    public RecordMetaInfo getNWNPAncllryAttndHeaderMetaInfo(NWNPLbrAncllryAttndQueryVO oLbrAncllryAttndQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getNWNPAncllryAttndHeader(NWNPLbrAncllryAttndQueryVO oLbrAncllryAttndQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    //public ArrayList getDARateDetail(String sYear, String sDAType, String sPayScaleType ,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    // public RecordMetaInfo getDARateDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveNWNPAncllryAttnd(NWNPLbrAncllryAttndHeaderBean oLbrAncllryAttndHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getNWNPAncllryAttndLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getNWNPAncllryLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getNWNPAncllryAttndDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,NWNPLbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getNWNPAncllryAttndDetailMetaInfo(String sPrimaryKey,NWNPLbrAncllryAttndDetailInfo oLbrAncllryAttndDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
        
    //////////////////////////////////////////////NWNP LABOUR WORK SLIP////////////////////////////////////////////////
    public LovVO getNWNPWrkSlipLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getNWNPWrkSlipEmpLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public NWNPWrkSlipComboVO getNwnpWrkSlipComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveNwnpWrkSlip(NWNPMaintWrkSlipHeaderBean oBaseHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
    public RecordMetaInfo getNwnpWrkSlipHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getNwnpWrkSlipHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getNwnpWrkSlipDetailMetaInfo(String sPrimaryKey,String sLbrTyp) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getNwnpWrkSlipDetail(String sPrimaryKey,String sLbrTyp,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public void deleteNwnpWrkSlipHeaderRecord(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    
    //////////////////////////////////////////////NWNP AREA CLASSIFICATION MAPPING FACADE////////////////////////////////////////////////
    public ArrayList getAreaClassiFicationMapping(String sPrimaryKey,long lStartPosition, long lLastPosition, NWNPAreaClassiFicationMappingQueryVO oNWNPAreaClassiFicationMappingQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getNwnpCityMapLocLovData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    //public NWNPAreaMappingComboVO getNwnpLocationComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getNwnpCityLocMapDetailMetaInfo(BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getNwnpCityLocMapHeaderMetaInfo(NWNPAreaClassiFicationMappingQueryVO oNWNPAreaClassiFicationMappingQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getNwnpCityLocMapHeader(NWNPAreaClassiFicationMappingQueryVO oNWNPAreaClassiFicationMappingQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getNwnpCityLocMapDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveNwnpCityLocMapDetail(NWNPAreaClassiFicationMappingHeaderBean oAreaClassiFicationHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    
    //////////////////////////////////////////////NWNP LABOUR SOR FACADE////////////////////////////////////////////////
     public RecordMetaInfo getNWNPLbrSORHeaderMetaInfo(NWNPLabourSORQueryVO oNWNPLabourSORQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public ArrayList getNWNPLbrSORHeader(NWNPLabourSORQueryVO oNWNPLabourSORQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public RecordMetaInfo getNWNPLbrSORDetailMetaInfo(String sPrimaryKey,String ScreenName,NWNPLabourSORDtlInfo oNWNPLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public ArrayList getNWNPLbrSORDetail(String sPrimaryKey,long lStartPosition, long lLastPosition, NWNPLabourSORDtlInfo oNWNPLabourSORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public String saveNWNPLbrSORInfo(NWNPLabourSORHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public LovVO getNWNPLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public LovVO getNWNPOprLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
    //////////////////////////////////////////////NWNP LABOUR MINIMUM WAGE FACADE////////////////////////////////////////////////
    // added by Shivani on 11 December 2019
     public RecordMetaInfo getNWNPLbrMinWageHeaderMetaInfo(NWNPLabourMinWageQueryVO oNWNPLabourMinWageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public ArrayList getNWNPLbrMinWageHeader(NWNPLabourMinWageQueryVO oNWNPLabourMinWageQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public String saveNWNPLbrMinWageInfo(NWNPLabourMinWageHeaderBean oNWNPLabourMinWageHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    
    //////////////////////////////////////////////NWNP LABOUR OPERATION FACADE////////////////////////////////////////////////
	// added by Shivani on 31 December 2019
     public RecordMetaInfo getNWNPLbrOprtnHeaderMetaInfo(NWNPLabourOprtnQueryVO oNWNPLabourOprtnQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public ArrayList getNWNPLbrOprtnHeader(NWNPLabourOprtnQueryVO oNWNPLabourOprtnQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public RecordMetaInfo getNWNPLbrOprtnDetailMetaInfo(String sPrimaryKey,String ScreenName,NWNPLabourOprtnDtlInfo oNWNPLabourOprtnDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public ArrayList getNWNPLbrOprtnDetail(String sPrimaryKey,long lStartPosition, long lLastPosition, NWNPLabourOprtnDtlInfo oNWNPLabourOprtnDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public String saveNWNPLbrOprtnInfo(NWNPLabourOprtnHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    // public LovVO getNWNPWrkSlipLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    // public LovVO getNWNPWrkSlipEmpLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


    //////////////////////////////////////////////NWNP AreaClassiFicationMapping FACADE////////////////////////////////////////////////
        // added by Ravindra on 06 JANUARY 2020
     



     
    //////////////////////////////////////////////NWNP LABOUR ASOR FACADE////////////////////////////////////////////////
           public RecordMetaInfo getNWNPLbrASORHeaderMetaInfo(NWNPLabourASORQueryVO oNWNPLabourASORQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
           public ArrayList getNWNPLbrASORHeader(NWNPLabourASORQueryVO oNWNPLabourASORQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
           public RecordMetaInfo getNWNPLbrASORDetailMetaInfo(String sPrimaryKey,String ScreenName,NWNPLabourASORDtlInfo oNWNPLabourASORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
           public ArrayList getNWNPLbrASORDetail(String sPrimaryKey,long lStartPosition, long lLastPosition, NWNPLabourASORDtlInfo oNWNPLabourASORDtlInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
           public String saveNWNPLbrASORInfo(NWNPLabourASORHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
          // public LovVO getNWNPLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
          // public LovVO getNWNPOprLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;   


}
