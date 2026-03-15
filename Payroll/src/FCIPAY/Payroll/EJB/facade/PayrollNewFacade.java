package FCIPAY.Payroll.EJB.facade;
import javax.ejb.EJBObject;
//Allowance and Reimbursement
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpNewspaperAllowanceQueryVO;
import FCIPAY.Payroll.EJB.business.EmpNewspaperAllowanceBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLocalTravelAllowanceQueryVO;
import FCIPAY.Payroll.EJB.business.EmpLocalTravelAllowanceBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTravelReimbursementQueryVO;
import FCIPAY.Payroll.EJB.business.EmpTravelReimbursementBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMobileReimbursementQueryVO;
import FCIPAY.Payroll.EJB.business.EmpMobileReimbursementBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLaptopReimbursementQueryVO;
import FCIPAY.Payroll.EJB.business.EmpLaptopReimbursementBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTelephoneDataReimbursementQueryVO;
import FCIPAY.Payroll.EJB.business.EmpTelephoneDataReimbursementBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpBriefcaseReimbursementQueryVO;
import FCIPAY.Payroll.EJB.business.EmpBriefcaseReimbursementBusinessObject;

//import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLiveriesAndTailoringAllowanceQueryVO;
//import FCIPAY.Payroll.EJB.business.EmpLiveriesAndTailoringAllowanceBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLaptopAMCQueryVO;
import FCIPAY.Payroll.EJB.business.EmpLaptopAMCBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLtcHomeReimbursementQueryVO;
import FCIPAY.Payroll.EJB.business.EmpLtcHomeReimbursementBusinessObject;


import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpAttanLeaveDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.EJB.business.AnnIncBusinessObject;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintAdhocPayBean;
import FCIPAY.Payroll.UTILITY.MaintDetIncHeaderBean; //added by yogesh
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintAnnIncQueryVO;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.WEBTIER.Form.MaintEmpPromotionForm6Pay;
import FCIPAY.Payroll.UTILITY.MaintEmpPromotionBean6Pay;    // added by yogesh on 13 sep 2010
import FCIPAY.Payroll.common.vo.LovQueryVO;   // added by yogesh on 15 sep 2010
import FCIPAY.Payroll.common.vo.LovVO;                // added by yogesh on 15 sep 2010
import FCIPAY.Payroll.DATAACCESSTIER.VO.SupplPayQueryVO;  //added by swapnendu Dt 29 -Sep 2010
import FCIPAY.Payroll.DATAACCESSTIER.VO.SupplPayDetailInfo; //added by swapnendu Dt 05 -Oct 2010
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.UTILITY.SupplimentaryPayHeaderBean;
import FCIPAY.Payroll.UTILITY.EmpDpndntNomHeaderBean;  // ADDED by dushyant on 13-10-2010
import FCIPAY.Payroll.UTILITY.OnlineDummyHeaderBean;
import FCIPAY.Payroll.UTILITY.CPFStopHeaderBean; //added by swapnendu Dt 27 -Oct 2010
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFStopQueryVO; //added by swapnendu Dt 27 -Oct 2010
import FCIPAY.Payroll.UTILITY.MaintSixPayCodesHeaderBean;  // added by sonia
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPaySixQueryVO;
import FCIPAY.Payroll.UTILITY.EmpPaySixHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPfDtlComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPFDetailQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SpclCmpnstryComboVOSixPay; //added by swapnendu Dt 07-Dec 2010.
import FCIPAY.Payroll.DATAACCESSTIER.VO.SpclCmpnstryAllowSixPayQueryVO; //added by swapnendu Dt 07-Dec 2010.
import FCIPAY.Payroll.UTILITY.SpclCmpnstryAllowSixPayHeaderBean; //added by swapnendu Dt 07-Dec 2010.
import FCIPAY.Payroll.DATAACCESSTIER.VO.MiscAllowanceComboVOSixPay; //added by swapnendu Dt 30-Mar 2011.
import FCIPAY.Payroll.DATAACCESSTIER.VO.MiscAllowanceSixPayQueryVO; //added by swapnendu Dt 11-Apr 2011.
import FCIPAY.Payroll.UTILITY.MiscAllowanceSixPayHeaderBean;
import FCIPAY.Payroll.UTILITY.GenDAArrearHeaderBean;
import FCIPAY.Payroll.UTILITY.OverNAboveArrearHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveEncashQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OTAPymntQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayOverAboveQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LTCEncashQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspensionQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspInvDtlsComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrInvDtlsComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintTransportSubsideQueryVO;
import FCIPAY.Payroll.UTILITY.MaintTransportSubsideHeaderBean;
import FCIPAY.Payroll.UTILITY.EmpTrnsfrHeaderBean; //added by swapnendu Dt 20-06-2012.
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPenalityComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPenalityQueryVO;
import FCIPAY.Payroll.UTILITY.MaintEmpPenalityBean;
import FCIPAY.Payroll.UTILITY.CPFApprHeaderBean;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ZoneSurrComboVO;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ScreenComboVO; //added by nand on 26 Jun 2013
import FCIPAY.Payroll.DATAACCESSTIER.VO.RespcreateQueryVO; //added by nand on 26 Jun 2013
import FCIPAY.Payroll.UTILITY.ResponsibilityCreationHeaderBean; //added by nand on 26 Jun 2013
import FCIPAY.Payroll.DATAACCESSTIER.VO.GenDAArrearQueryVO;
import FCIPAY.Payroll.EJB.business.PayImageBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ScreenComboVO;
import FCIPAY.Payroll.UTILITY.CatVsPayCodeHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ClassificationComboVO;
import FCIPAY.Payroll.UTILITY.CatVsPayCodeHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanAdjustmentVO;
import FCIPAY.Payroll.UTILITY.LoanAdjustmentHeaderBean;
//added by geetika 18/12/13
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentQueryVO;
import FCIPAY.Payroll.UTILITY.CPFFinalPaymentBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPayComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentBaseDetailInfo;
//added by abdul 21/01/2015
import FCIPAY.Payroll.DATAACCESSTIER.VO.ChangeZoneVO;
import FCIPAY.Payroll.UTILITY.ChangeZoneHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveTravelConcessionQueryVO;
import FCIPAY.Payroll.EJB.business.EmpMediBillsBusinessObject;
////////////////////Added By Avtar on 03-Jun-2015//////////////////////////////////////////
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIForeclosureVO;
import FCIPAY.Payroll.UTILITY.PLIForeclosureBean;
////////////////////Ended By Avtar on 03-Jun-2015//////////////////////////////////////////
import FCIPAY.Payroll.EJB.business.MaintPensionDtlBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPCDetailQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPcDtlComboVO;
import FCIPAY.Payroll.UTILITY.MaintPCDetailHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIActCancelQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIPayCanDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIReportAdjustmentQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PensionFinalSettQueryVO;
import FCIPAY.Payroll.UTILITY.PLIPaymentHeaderBean;
import FCIPAY.Payroll.UTILITY.PensionFinalSettBean;
//Added By amresh For PRMS
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsMediBillsQueryVO;
import FCIPAY.Payroll.EJB.business.EmpPrmsMediBillsBusinessObject;


public interface PayrollNewFacade extends EJBObject 
{
    public String saveDetInc(MaintDetIncHeaderBean oMaintDetIncHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;// added by yogesh on 26 th august 2010
    public RecordMetaInfo getDetIncHeaderMetaInfo(MaintAnnIncQueryVO oMaintAnnIncQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getDetIncHeader(MaintAnnIncQueryVO oMaintAnnIncQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveEmpPromotion6Pay(MaintEmpPromotionBean6Pay oEmpPromotionHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;// added by yogesh
    public LovVO getQueryEmpPromotionLOVData6Pay(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  // added by yogesh on 15 th of sep 2010
    public LovVO getEmpPromotionDsgnLOVData6Pay(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;    // added by yogesh on 15 th of sep 2010
    public LovVO getEmpPromotionLOVData6Pay(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;// added by yogesh
    public LovVO getEmpLastPayCertifReportLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;

//======================================================MASTER (START)===========================================================================
/*
 * Special Compensatory allowance
 * Added by Swapnendu Bastia
 * Dt 07 -Dec 2010.
 * */
    public SpclCmpnstryComboVOSixPay getCmpnstryComboDetailsSixPay() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getSpclCompstryAllowHeaderMetaInfo(SpclCmpnstryAllowSixPayQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getSpclCompstryAllowHeader(SpclCmpnstryAllowSixPayQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getSpclCompAllowDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getSpclCompAllowDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveSpclCompAllow(SpclCmpnstryAllowSixPayHeaderBean oBaseHeaderBean , Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray, boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getSpclCompAllowGradePay(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;    // added by yogesh on 15 th of sep 2010
    public LovVO getSpclCompAllowPayBand(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;// added by yogesh
/*
 * Miscellaneous allowance according to Six Pay
 * Added by Swapnendu Bastia
 * Dt 30 -Mar 2011.
 * */
    public MiscAllowanceComboVOSixPay getMiscComboDetailsSixPay() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getMiscAllowHeaderMetaInfo(MiscAllowanceSixPayQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getMiscAllowHeader(MiscAllowanceSixPayQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getMiscAllowPayCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;    // added by yogesh on 15 th of sep 2010
    public RecordMetaInfo getMiscAllowDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getMiscAllowDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getMiscAllowGradePay(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;    // added by yogesh on 15 th of sep 2010
    public LovVO getMiscAllowPayBand(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;// added by yogesh
    public String saveMiscAllow(MiscAllowanceSixPayHeaderBean oBaseHeaderBean , Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray, boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   
//======================================================MASTER (END)===========================================================================

   public LovVO getMedClaimAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public LovVO getMedClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;



//======================================================OTHER PAYMENT===========================================================================
/*
 * Supplementary payment
 * Added by Swapnendu Bastia
 * Dt 29 -Sep 2010.
 * */

    public LovVO getSupPayEmpDtlLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
    public LovVO getSupPayEmpDtlLOVDataQuery(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
    
    public RecordMetaInfo getSupPayHeaderMetaInfo(SupplPayQueryVO oSupplPayQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getSupPayHeader(SupplPayQueryVO oSupplPayQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getSupplPayDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getSupplPayDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveSupplPayDetail(SupplimentaryPayHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String populateData(SupplimentaryPayHeaderBean oDummyHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String sendSupplPayInvoice(SupplPayQueryVO oSupplPayQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO  getPaycodeAgencycodePayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    
//=============================================================Supplementary payment End ====================================================================================
//======================================================OTHER PAYMENT===========================================================================
/*
 * PLI Adjustment
 * Added by Vikash SIngh
 * Dt 17 -jan- 2019.
 * */
    public LovVO getPLIReportEmpDtlLOVDataQuery(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
    public RecordMetaInfo getPLIReportHeaderMetaInfo(PLIReportAdjustmentQueryVO oPLIReportAdjustmentQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getPLIReportHeader(PLIReportAdjustmentQueryVO oPLIReportAdjustmentQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getPLIReportDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getPLIReportDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String savePLIReportDetail(PLIPaymentHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String populateData1(PLIPaymentHeaderBean oDummyHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO  getPaycodeAgencycodePayCodeLOVData1(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getPLIReportEmpDtlLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;

//=============================================================PLI Adjustment End ====================================================================================

// added by dushyant for Gratuity Tab on 13-10-2010
    public RecordMetaInfo getEmpGratuityDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getEmpGratuityDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 
    public String saveGratuityDetail(EmpDpndntNomHeaderBean oHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
// added by dushyant for miscllaneous jsp 0n 20-10-2010
    public LovVO getPayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  
    
//====================================================== MISCILLANEOUS TRANSACTION ===========================================================================
/*
 * CPF STOP
 * Added by Swapnendu Bastia
 * Dt 26 -Oct 2010.
 * */

    public LovVO getCPFStopEmpLOVData(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

    public String saveCPFRecv(CPFStopHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    
    public RecordMetaInfo getCpfRcvrHeaderMetaInfo(CPFStopQueryVO oCPFStopQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getCpfRcvrHeader(CPFStopQueryVO oCPFStopQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getMediReimAllEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;   
    //send invoice for Medi Reimbursement Bulk
    public String sendInv(String empLbr, String quarter, String finYear, String medicalDate, long lUserID, long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String sendInvBulk(String empLbr,String finYear,String txtPayCode, long lUserID, long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
/*
 * Transport Subside Payment
 * Added by Swapnendu Bastia
 * Dt 16 -May 2012.
 * */

    public LovVO getTransportSubsideLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;   
    public LovVO getTransportSubsideLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;   
    public RecordMetaInfo getTransportRebateHeaderMetaInfo(MaintTransportSubsideQueryVO oMaintTransportSubsideQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getTransportRebateHeader(MaintTransportSubsideQueryVO oMaintTransportSubsideQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getTransportRebateDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getTransportRebateDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveTransportRebateDetail(MaintTransportSubsideHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String getMaxPayYear(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
//=============================================================Transport Subside payment End ====================================================================================
//====================================================== Six Pay Maintain ===========================================================================
/*
 * 
 * Added by Sonia
 * Dt 01 -Nov 2010.
 * */

    public LovVO getSixCommPayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;//added by sonia on 11-11-2010
    public RecordMetaInfo getSixPayDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;// added by sonia
    public ArrayList getSixPayCodesDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;//added by sonia
    public String saveSixPayCode(MaintSixPayCodesHeaderBean oMaintSixPayCodesHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;//added by sonia
    public LovVO getSixPayDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;// added by sonia on 11-11-2010
    public ArrayList getPayCodes() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getDepuPayCodes() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; //added by sonia on 07-07-2011
    public ArrayList getInternalsavingPayCodes() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String validateUser(String txtEmpNo,String txtCPFDDYYMM,String yymm,String siteCode,String empType) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public LovVO getSalaryInvoicePayLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    //public LovVO getQueryEmpInfoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String deleteLeaveEncash(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	  public String deleteLTCEncash(LTCEncashQueryVO oLTCEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	  public String deleteOTAPymnt(OTAPymntQueryVO oOTAPymntQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	  public String deletePayOverAbovePymnt(PayOverAboveQueryVO oPayOverAboveQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public EmpSuspInvDtlsComboVO getEmpSuspInvDtlsComboDetails(EmpSuspensionQueryVO oEmpSuspensionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	  public EmpTrnsfrInvDtlsComboVO getEmpTrnsfrInvDtlsComboDetails(EmpTrnsfrQueryVO oEmpTrnsfrQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String cancelLeaveEncashInv(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

     public String cancelLTCEncashInv(LTCEncashQueryVO oLTCEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public String EmpMediBillsCancelInv(EmpMediBillsQueryVO oEmpMediBillsQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public String CancelSuppPaymentInv(SupplPayQueryVO oSupplPayQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//====================================================== EMPLOYEE INFORMATION ===========================================================================
/*
 * Employee Payment Six Pay.
 * Added by Swapnendu Bastia
 * Dt 03 -Nov 2010.
 * */

    public LovVO getEmpPaymentLOVData_Q(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getEmpPaymentLOVData_Super(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getEmpPaymentLOVData_N(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getEmpSixPayCodeLOVData(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getEmpSixPayHeaderMetaInfo(EmpPaySixQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getEmpSixPayHeader(EmpPaySixQueryVO oQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getEmpSixPayDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getEmpSixPayDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveEmpSixPayDetail(EmpPaySixHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    //public String populateEmpSixPayTran(EmpPaySixHeaderBean oDummyHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String computeITPayAdv(BaseDetailInfo oBaseDetailInfo, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;    //added by swapnendu Dt. 25 Apr 2011
    public String sendInvLoanAdv(BaseDetailInfo oBaseDetailInfo, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;    //added by swapnendu Dt. 25 Apr 2011
    //=================================added by dushyant for maintain direct payroll Audit on 30-11-2010=========================
    public LovVO getMainDirectPyrlAuditLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getMedicalRegLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getMedicalRegEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    //releaseIncentive() added by swapnendu Dt 20-06-2012 for releasing incentive of transffered labours.
    public String releaseIncentive(EmpTrnsfrHeaderBean oEmpTrnsfrHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
/*
 * CPF Approval
 * Added by Swapnendu Bastia
 * Dt 16 May 2013.
 * */
    public LovVO getCPFApprovalLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
    public LovVO getCPFApprovalUnitLOVQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
    public RecordMetaInfo getCPFApprHeaderMetaInfo(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getCPFApprHeader(BaseQueryVO oQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getCPFApprDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getCPFApprDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public void approveRecord(CPFApprHeaderBean oDummyHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public void rejectRecord(CPFApprHeaderBean oDummyHeaderBean, ArrayList oDetailBeanArray) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    
/*
 * Zone Surrender
 * Added by Swapnendu Bastia
 * Dt 21 May 2013.
 * */
    public LovVO getZoneSurrLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
    public LovVO getZoneSurrLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
    public RecordMetaInfo getZoneSurrHeaderMetaInfo(BaseQueryVO oQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getZoneSurrHeader(BaseQueryVO oQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ZoneSurrComboVO getZoneSurrCombo()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveZoneSurrender(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;// added by yogesh
    
//====================================================== MONTH END ===========================================================================
/* changes in month end update screen to get the no. of employees waitting to join.
 * Added by Swapnendu Bastia
 * Dt 15 Feb 2011
 * */
    public String getEmpWaitingToJoin(long lUserId, long lSiteId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String getPostYrEndRemitMaxPayYear(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String PostOthrPayments(long lUserID,long lSiteID,String hdnEmpLbrFlag,String invoice_date) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String PostRemitSalary(long lUserID,long lSiteID,String hdnEmpLbrFlag,String invoice_date) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
/* added by jatin */
    public String singleMonthEndUpdate(long lUserID,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getEmpNamePaySlip(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
//====================================================== CPF MODULE ===========================================================================
/*
 * Added by Swapnendu Bastia
 * Dt 16 Mar 2010.
 * */
    public MaintPfDtlComboVO getPfDetailCombo() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getPfAdjustHistoryHdr(MaintPFDetailQueryVO oMaintPFDetailQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getPfAdjustHistoryDtl(MaintPFDetailQueryVO oMaintPFDetailQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public LovVO getCDAEmpPromotionDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; // added by sonia
    public String genOverNAboveArrear(OverNAboveArrearHeaderBean oOverNAboveArrearHeaderBean,long loginUserId ,long lLoginSiteId ,String payYYMM) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public ArrayList getSeparationEmpDetail(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;// added by sonia on 18-07-2011
	public LovVO getDailyAttSummLstLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;// added by sonia on 19-03-2012 
	public LovVO getGangDtls(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;// added by sonia on 19-03-2012 
    public String saveEmpLeaveDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
        public String saveEmpAttanLeaveDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

    public String cancelLeaveDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String convertLeaveDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

	//////////////////////////////////////////////EMP PENALITY FACADE////////////////////////////////////////////////
	
  public RecordMetaInfo getPenalityHeaderMetaInfo(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPenalityHeader(EmpPenalityQueryVO oEmpPenalityQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpPenality(MaintEmpPenalityBean oEmpPenalityHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public EmpPenalityComboVO getEmpPenalityComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpPenalityLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryEmpPenalityLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
  public String getEmpPenalityMaxPayYear(long siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String penaltyWaiver(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String incrementStop(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String incrementReinstate(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpPenaltyList(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getPenaltyDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; // added by sonia
  public RecordMetaInfo getHdrRcdWaveOffMetaImpl(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHdrRcdWaveOffImpl(EmpPenalityQueryVO oEmpPenalityQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getHdrRcdIncrWaveMetaImpl(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHdrRcdIncrWaveImpl(EmpPenalityQueryVO oEmpPenalityQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryEmpDismissLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
  public LovVO getQueryEmpDismissLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
  public String reinstateDismissed(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getHdrRcdDissReinstateMetaImpl(EmpPenalityQueryVO oEmpPenalityQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHdrRcdDissReinstateImpl(EmpPenalityQueryVO oEmpPenalityQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	////////////////////////////////////////////////////END//////////////////////////////////////////////////////////	
	public RecordMetaInfo getEmpAttanLeaveDetailMetaInfo(String sPrimaryKey,EmpAttanLeaveDetailInfo oEmpLeaveDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public ArrayList getEmpAttanLeaveDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,EmpAttanLeaveDetailInfo oEmpAttanLeaveDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public ArrayList getEmpTobeSeparateList(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public ArrayList getOvrAbvArrearHeader(GenDAArrearQueryVO oGenDAArrearQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
	public RecordMetaInfo getOvrAbvArrearHeaderMetaInfo(GenDAArrearQueryVO oGenDAArrearQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
	public String undoOvernAboveArrear(OverNAboveArrearHeaderBean oOverNAboveArrearHeaderBean,long loginUserId ,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
	public String sGetEmpNumchk(String  sEmpNum,long  lSiteId,String  sEmplbr) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public LovVO getQueryEmpRetdPromotionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public LovVO getEmpRetdPromotionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 

	public RecordMetaInfo getRespCreatUpdMetaInfo(RespcreateQueryVO oRespcreateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getRespCreatHeader(RespcreateQueryVO oRespcreateQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getRespCreatUpdDtlMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getRespCreatDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveRespCreaUpdDetail(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ScreenComboVO getRespCreatComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  public RecordMetaInfo getHdrRcdPayImgInctMetaImpl(EnqPayImageQueryVO oEnqPayImageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException, RemoteException;
  public ArrayList getHdrRcdPayImgInctImpl(EnqPayImageQueryVO oEnqPayImageQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getEnqPayImageInctDetailMetaInfo(String sPrimaryKey,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEnqPayImageInctDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public ClassificationComboVO getClassificationCombo()throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public RecordMetaInfo getCatVsPayCodeMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public ArrayList getCatVsPayCodeDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public String SaveClassificationMapping(CatVsPayCodeHeaderBean oCatVsPayCodeHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
	public LovVO  getCatVSPayCodeLOVPayCodeDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanAdjustmentLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 
  public LovVO getLoanAdjustDtlLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 
  public BaseHeaderBean getAdjustmentDtls(LoanAdjustmentVO oLoanAdjustmentVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getLoanAdjustHeaderMetaInfo(LoanAdjustmentVO oLoanAdjustmentVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLoanAdjustHeader(LoanAdjustmentVO oLoanAdjustmentVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveAdjustmentDetails(LoanAdjustmentHeaderBean oLoanAdjustmentHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  
  ///////////////////////////////////////////////CPF New Payment FACADE added by geetika(10/12/2013)/////////////////////////////////////////////////////////////
   public RecordMetaInfo getCPFNewPayHeaderMetaInfo(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public LovVO getEmpCPFNewPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
   public LovVO getQueryEmpCPFNewPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
   public RecordMetaInfo getCPFNewPayDetailMetaInfo(String sPrimarykey,CPFFinalPaymentBaseDetailInfo oCPFFinalPaymentBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public ArrayList getCPFNewPayDetail(String sPrimarykey,long lStartPosition, long lLastPosition, CPFFinalPaymentBaseDetailInfo oCPFFinalPaymentBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public String saveEmpCPFNewPay(CPFFinalPaymentBean oCPFFinalPaymentBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public ArrayList getCPFNewPayHeader(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public String realeaseCPFNewPay(BaseHeaderBean oBaseHeaderBean)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
   public BaseHeaderBean getCPFNewDtls(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
   public String revokeCPFNewPay(BaseHeaderBean oBaseHeaderBean)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
   public CPFFinalPayComboVO getCPFFinalPayComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   //added by himanshu on 9-july-2014
   public String calcCpfYrInt(BaseHeaderBean oBaseHeaderBean)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
   public String freezeCpfYrInt(BaseHeaderBean oBaseHeaderBean)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
   //end of addition by himanshu on 9-july-2014
   
   //added by himanshu on 10-jan-2015
    public String cancelCPFNewPay(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
	
	//======================================================Change Parrent Zone===========================================================================
/*
 * Change Parrent Zone
 * Added by Abdul
 * Dt 22 -Jan 2015.
 * */
    //public RecordMetaInfo getChngZoneHeaderMetaInfo(ChangeZoneVO oChangeZoneQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getAllEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getChngZoneDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getChngZoneDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveChangeZoneDetail(ChangeZoneHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 //--added by abdul on 23-july-18
 public RecordMetaInfo getbasicHistDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getBasicHistDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getEmpBasicHistLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  ///////////////////////// added by Avtar on 03-Jun-2015 start/////////////////////////////////////////////////
 public RecordMetaInfo getPLIForeclosureHeaderMetaInfo(PLIForeclosureVO oPLIForeclosureVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPLIForeclosureHeader(PLIForeclosureVO oPLIForeclosureVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getPLIDtlLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String  savePLIForeclosureDetails(PLIForeclosureBean oPLIForeclosureBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getPLIDtlLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public BaseHeaderBean getPLIForeclosureDtls(PLIForeclosureVO oPLIForeclosureVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
//final settlement CR by manish
public String deleteComFinalEntry(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException, RemoteException ;
  //public String editComFinalEntry(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException, RemoteException ;
  public String deleteSepDtls(BaseHeaderBean oBaseHeaderBean,String buttonType) throws EnrgiseSystemException,EnrgiseApplicationException, RemoteException ;
//  public RecordMetaInfo getPaycodeAgencycodeDetailMetaInfo(String sPrimaryKey,String sScreenName) throws EnrgiseSystemException, EnrgiseApplicationException;

///////////////////////// added by Avtar on 03-Jun-2015 start///////////////////////////////////////////////// 
// ADDED by manish dt- 28-feb-2017


 public RecordMetaInfo getPensionEmpShareUploadDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getPensionEmpShareUploadDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String  savePensionEmpShareUploadDetails(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO  getPensionEmpShareUploadEmployeeNoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    //added By Priyanka Aggarwal on 10-April-2017 
//public MaintPcDtlComboVO getPcDetailCombo() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getPcAdjustHistoryDtl(MaintPCDetailQueryVO oMaintPCDetailQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String savePCDetail(MaintPCDetailHeaderBean oMaintPCDetailHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getPensionHeaderMetaInfo(MaintPCDetailQueryVO oMaintPCDetailQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getPensionHeader(MaintPCDetailQueryVO oMaintPCDetailQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getPensionFromYrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;;
public LovVO getPensionDetailLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getQueryPensionDetailLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public MaintPcDtlComboVO getPensionDetailCombo() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getPcAdjustHistoryHdr(MaintPCDetailQueryVO oMaintPCDetailQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getPensionDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; //added by swapnendu
public ArrayList getPensionDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; //added by swapnendu

public LovVO getPLIPayEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public LovVO getEmpLocationLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
    public RecordMetaInfo getPLIPaymentCancelHeaderMetaInfo(PLIActCancelQueryVO oPLIActCancelQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getPLIPaymentHeader1(PLIActCancelQueryVO oPLIActCancelQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getPLIPayDetailMetaInfo(String sPrimaryKey,PLIPayCanDetailInfo oPLIPayCanDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getPLIPaymentDetail1(String sPrimaryKey,long lStartPosition,long lLastPosition,PLIPayCanDetailInfo oPLIPayCanDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String CancelPLIPaymentInv(PLIActCancelQueryVO oPLIActCancelQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 //added by arvind on 26/7/2017
 public String CancelCPFPartFinalInv(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryV0)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 
 //added by Arvind
 public String freezePenYrInt(MaintPCDetailQueryVO oMaintPCDetailQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
//Added By Amresh For PRMS
     public String EmpPrmsMediBillsCancelInv(EmpPrmsMediBillsQueryVO oEmpPrmsMediBillsQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public LovVO getPrmsMedClaimAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
     public LovVO getPrmsMedClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
public LovVO getPensionEmpLovQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getPensionEmpLovN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getPensionFinSettHeaderMetaInfo(PensionFinalSettQueryVO oPensionFinalSettQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getPensionFinSettHeader(PensionFinalSettQueryVO oPensionFinalSettQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getPensionFinalDtls(PensionFinalSettQueryVO oPensionFinalSettQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String savePensionFinSett(PensionFinalSettBean oPensionFinalSettBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//added by dhiraj  
public String deleteLeaveTravelConcession(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String cancelLeaveTravelConcessionInv(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//Allowance and Reimbursement
public String EmpNewspaperAllowanceCancelInv(EmpNewspaperAllowanceQueryVO oEmpNewspaperAllowanceQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpNewspaperAllowanceAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getNewspaperAllowanceClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;

public String EmpLocalTravelAllowanceCancelInv(EmpLocalTravelAllowanceQueryVO oEmpLocalTravelAllowanceQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLocalTravelAllowanceAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLocalTravelAllowanceClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;

public String EmpTravelReimbursementCancelInv(EmpTravelReimbursementQueryVO oEmpTravelReimbursementQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpTravelReimbursementAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpTravelReimbursementClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;

public String EmpMobileReimbursementCancelInv(EmpMobileReimbursementQueryVO oEmpMobileReimbursementQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpMobileReimbursementAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpMobileReimbursementClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;

public String EmpLaptopReimbursementCancelInv(EmpLaptopReimbursementQueryVO oEmpLaptopReimbursementQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLaptopReimbursementAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLaptopReimbursementClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;

public String EmpTelephoneDataReimbursementCancelInv(EmpTelephoneDataReimbursementQueryVO oEmpTelephoneDataReimbursementQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpTelephoneDataReimbursementAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpTelephoneDataReimbursementClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;

public String EmpBriefcaseReimbursementCancelInv(EmpBriefcaseReimbursementQueryVO oEmpBriefcaseReimbursementQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpBriefcaseReimbursementAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpBriefcaseReimbursementClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;

/*public String EmpLiveriesAndTailoringAllowanceCancelInv(EmpLiveriesAndTailoringAllowanceQueryVO oEmpLiveriesAndTailoringAllowanceQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLiveriesAndTailoringAllowanceAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLiveriesAndTailoringAllowanceClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
*/
public String EmpLaptopAMCCancelInv(EmpLaptopAMCQueryVO oEmpLaptopAMCQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLaptopAMCAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLaptopAMCClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
 
public String EmpLtcHomeReimbursementCancelInv(EmpLtcHomeReimbursementQueryVO oEMPLtcHomeReimbursementQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLtcHomeReimbursementAgencyCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLtcHomeReimbursementClaimAgencySiteCodelov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;


}



  