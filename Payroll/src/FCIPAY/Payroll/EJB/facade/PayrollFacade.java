package FCIPAY.Payroll.EJB.facade;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DirPayrollDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayHistDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BasicArrDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ExtSavDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.InrRateDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntSavDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntRateDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintAnnIncQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GISComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintInterestRateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GenBasicArrearQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProfTaxDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProfTaxQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.StdDednQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TaxParamOtherQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TaxParamQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetQueryVO;
import FCIPAY.Payroll.EJB.business.AnnIncBusinessObject;
import FCIPAY.Payroll.EJB.business.CCARateBusinessObject;
import FCIPAY.Payroll.EJB.business.DirectPayrollBusinessObject;
import FCIPAY.Payroll.EJB.business.ExtSavBusinessObject;
import FCIPAY.Payroll.EJB.business.GISRatesBusinessObject;
import FCIPAY.Payroll.EJB.business.GenBasicArrearBusinessObject;
import FCIPAY.Payroll.EJB.business.HraBusinessObject;
import FCIPAY.Payroll.EJB.business.InrRateBusinessObject;
import FCIPAY.Payroll.EJB.business.IntSavBusinessObject;
import FCIPAY.Payroll.EJB.business.MiscParamBusinessObject;
import FCIPAY.Payroll.EJB.business.PayAcctBusinessObject;
import FCIPAY.Payroll.EJB.business.PayImageBusinessObject;
import FCIPAY.Payroll.EJB.business.PfDudnMstBusinessObject;
import FCIPAY.Payroll.EJB.business.PfTranCodeBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamIncomeBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamOtherBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamProfTaxBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamStdDedBusinessObject;
import FCIPAY.Payroll.EJB.business.CreatePayTransBusinessObject;
import FCIPAY.Payroll.EJB.business.AdhocPayBusinessObject;
//import IBA.Payroll.UTILITY.BasicArrearHeaderBean;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintAdhocPayBean;
import FCIPAY.Payroll.UTILITY.ComFinalHeaderBean;
import FCIPAY.Payroll.UTILITY.ComFinalDetailBean;
import FCIPAY.Payroll.UTILITY.AdhocPayHeaderBean;
import FCIPAY.Payroll.UTILITY.ExtSavHeaderBean;
import FCIPAY.Payroll.UTILITY.IntSavHeaderBean;
import FCIPAY.Payroll.UTILITY.IntRateHeaderBean;
import FCIPAY.Payroll.UTILITY.IntRateDetailBean;
import FCIPAY.Payroll.UTILITY.MaintAnnIncHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintDetIncHeaderBean; //added by yogesh
import FCIPAY.Payroll.UTILITY.MaintDirectPayrollHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintInrRateHeaderBean;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean;
import FCIPAY.Payroll.UTILITY.BasicArrearHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintPFDetailHeaderBean;
import FCIPAY.Payroll.UTILITY.ProfTaxHeaderBean;
import FCIPAY.Payroll.UTILITY.StdDednHeaderBean;
import FCIPAY.Payroll.UTILITY.TaxParamHeaderBean;
import FCIPAY.Payroll.UTILITY.TaxParamOtherHeaderBean;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlWashBean;
import FCIPAY.Payroll.UTILITY.ComputeTaxHeaderBean;
import FCIPAY.Payroll.UTILITY.ComBonusAwardsHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPFDetailQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPFDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MiscComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HraComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SiteTypeComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLeaveComboVO;
import FCIPAY.Payroll.UTILITY.EmpDpndntNomHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CtgrySchemeComboVO;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLeaveDetailInfo;

import  FCIPAY.Payroll.DATAACCESSTIER.VO.HistoryEntryQueryVO;
import  FCIPAY.Payroll.DATAACCESSTIER.VO.HistoryEntryDetailInfo;
import  FCIPAY.Payroll.EJB.business.HistoryEntryBusinessObject;
import FCIPAY.Payroll.UTILITY.HistoryEntryHeaderBean;

import FCIPAY.Payroll.EJB.business.PayReportBusinessObject;
import FCIPAY.Payroll.EJB.business.PayReportBO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayReportComboVO;


import FCIPAY.Payroll.UTILITY.GenDAArrearHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GenDAArrearQueryVO;
import FCIPAY.Payroll.EJB.business.DAArrearBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayYearStatusVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpFinanceQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpFinanceComboVO;
import FCIPAY.Payroll.EJB.business.EmpFinanceBusinessObject;
import FCIPAY.Payroll.UTILITY.EmpFinInfoHeaderBean;
import FCIPAY.Payroll.UTILITY.ECSDataFileHdrBean;

import FCIPAY.Payroll.EJB.business.BankMastBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintBankMastQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BankMastDetailInfo;
import FCIPAY.Payroll.UTILITY.MaintBankMastHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.HillCmpnstryComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HillCmpnstryAllowQueryVO;
import FCIPAY.Payroll.UTILITY.HillCmpnstryAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintHillCmpnstryAllowDetailInfo;


import FCIPAY.Payroll.DATAACCESSTIER.VO.TrblAreaComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TrblAreaAllowQueryVO;
import FCIPAY.Payroll.UTILITY.TrblAreaAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintTrblAreaAllowDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.RmtAreaComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.RmtAreaAllowQueryVO;
import FCIPAY.Payroll.UTILITY.RmtAreaAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintRmtAreaAllowDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.SplDutyComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SplDutyAllowQueryVO;
import FCIPAY.Payroll.UTILITY.SplDutyAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SplDutyAllowDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintHouseRentRcptVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HouseRentRcptDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintLoanMstQueryVO;
import FCIPAY.Payroll.UTILITY.MaintLoanMasterHdrBean;
import FCIPAY.Payroll.UTILITY.HouseRentRcptHdrBean;

import FCIPAY.Payroll.UTILITY.LeaseAccomHeaderBean;
import FCIPAY.Payroll.UTILITY.LeaseAccomBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaseAccomQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaseAccomDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaseAccomComboVO;

import FCIPAY.Payroll.EJB.business.CompIncomeTaxProjBusinessObject;
import FCIPAY.Payroll.UTILITY.ComputeTaxProjHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintMiscAllowComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SCAComboVO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrSalRlsComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrQueryVO;
import FCIPAY.Payroll.UTILITY.EmpTrnsfrHeaderBean;

import FCIPAY.Payroll.UTILITY.LoanDtlsHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPromotionQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPromotionComboVO;
import FCIPAY.Payroll.EJB.business.EmpPromotionBusinessObject;
import FCIPAY.Payroll.UTILITY.MaintEmpPromotionBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspensionQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspensionComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspSlryRlsComboVO;
import FCIPAY.Payroll.EJB.business.EmpSuspensionBusinessObject;
import FCIPAY.Payroll.UTILITY.MaintEmpSuspensionBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsDetailInfo;
import FCIPAY.Payroll.UTILITY.LoanDtlsDetailBean;

import FCIPAY.Payroll.EJB.business.EmpIncrBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpIncrQueryVO;
import FCIPAY.Payroll.UTILITY.MaintEmpIncrBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveEncashQueryVO;
import FCIPAY.Payroll.UTILITY.LeaveEncashHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.LTCEncashQueryVO;
import FCIPAY.Payroll.UTILITY.LTCEncashHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.OTATypeComboVO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.GenRevrRecoveriesQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.RevrRecoveriesDetailInfo;
import FCIPAY.Payroll.UTILITY.RevrRecoveriesHeaderBean;
import FCIPAY.Payroll.UTILITY.GenRevrRecoveriesBean;

import FCIPAY.Payroll.UTILITY.PLIPaymentHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIPaymentQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIPaymentDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentQueryVO;
import FCIPAY.Payroll.UTILITY.CPFFinalPaymentBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPayComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentBaseDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.ProjectComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProjectQueryVO;
import FCIPAY.Payroll.UTILITY.MaintProjectAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintProjectAllowDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.OverAbvArrearComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OverAbvArrearQueryVO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.PayOverAboveQueryVO;
import FCIPAY.Payroll.UTILITY.PayOverAboveHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpReinstateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpReinstateComboVO;
import FCIPAY.Payroll.UTILITY.MaintEmpReinstateBean;

import FCIPAY.Payroll.UTILITY.EmpAddressHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpAddressQueryVO;

import FCIPAY.Payroll.UTILITY.EmplyrTaxHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmplyrTaxQueryVO;
import FCIPAY.Payroll.EJB.business.CategoryLocationBusinessObject;
import FCIPAY.Payroll.UTILITY.MaintCategoryLocationBean;
import FCIPAY.Payroll.EJB.business.LoanForeclosureBusinessObject;
import FCIPAY.Payroll.UTILITY.LoanForeclosureBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanForeclosureVO;
import FCIPAY.Payroll.EJB.business.LoanRescheduleBusinessObject;
import FCIPAY.Payroll.UTILITY.LoanRescheduleBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanRescheduleVO;

//Added by Aqeel Ahmed on 17 Dec 08
import FCIPAY.Payroll.UTILITY.LoanDtlsAllHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsAllQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsAllDetailInfo;

//Added by Aqeel Ahmed on 17 Dec 08
import FCIPAY.Payroll.UTILITY.DirPayrollBulkHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DirPayrollBulkQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DirPayrollBulkDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsQueryVO;
//LTC
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveTravelConcessionQueryVO;
import FCIPAY.Payroll.UTILITY.LeaveTravelConcessionHeaderBean;
import FCIPAY.Payroll.UTILITY.EmpMediBillsHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.MediReimbursDtlsAllQueryVO;

import FCIPAY.Payroll.UTILITY.MediReimbursDtlsAllHeaderBean; // added by devendra on 25th aug 2010
import FCIPAY.Payroll.DATAACCESSTIER.VO.MediReimbDtlsAllDetailInfo; // added by devendra on 3rd sept 2010
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPfDtlComboVO;
import FCIPAY.Payroll.UTILITY.EmpPayFixBean;

import FCIPAY.Payroll.UTILITY.IncomeTaxRegimeHeaderBean;
import FCIPAY.Payroll.common.vo.BaseQueryVO;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.ejb.EJBObject;
//added By Amresh FOR PRMS 
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsCeilAdjHistoryDetailParm;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsCeilAdjQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsMediBillsComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPrmsMediBillsQueryVO;
import FCIPAY.Payroll.UTILITY.EmpPrmsMediBillsHeaderBean;
import FCIPAY.Payroll.UTILITY.EmpPrmsCeilAdjHeaderBean;
//Added for basic event screen
import FCIPAY.Payroll.UTILITY.BasicHistoryEventHeaderBean;

//Added By amresh For Allowance and Reim. START
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpNewspaperAllowanceComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpNewspaperAllowanceQueryVO;
import FCIPAY.Payroll.UTILITY.EmpNewspaperAllowanceHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLocalTravelAllowanceComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLocalTravelAllowanceQueryVO;
import FCIPAY.Payroll.UTILITY.EmpLocalTravelAllowanceHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTravelReimbursementComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTravelReimbursementQueryVO;
import FCIPAY.Payroll.UTILITY.EmpTravelReimbursementHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMobileReimbursementComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMobileReimbursementQueryVO;
import FCIPAY.Payroll.UTILITY.EmpMobileReimbursementHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLaptopReimbursementComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLaptopReimbursementQueryVO;
import FCIPAY.Payroll.UTILITY.EmpLaptopReimbursementHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTelephoneDataReimbursementComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTelephoneDataReimbursementQueryVO;
import FCIPAY.Payroll.UTILITY.EmpTelephoneDataReimbursementHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpBriefcaseReimbursementComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpBriefcaseReimbursementQueryVO;
import FCIPAY.Payroll.UTILITY.EmpBriefcaseReimbursementHeaderBean;

//import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLiveriesAndTailoringAllowanceComboVO;
//import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLiveriesAndTailoringAllowanceQueryVO;
//import FCIPAY.Payroll.UTILITY.EmpLiveriesAndTailoringAllowanceHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLaptopAMCComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLaptopAMCQueryVO;
import FCIPAY.Payroll.UTILITY.EmpLaptopAMCHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLtcHomeReimbursementComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLtcHomeReimbursementQueryVO;
import FCIPAY.Payroll.UTILITY.EmpLtcHomeReimbursementHeaderBean;
//Added By amresh For Allowance and Reim. START

public interface PayrollFacade extends EJBObject
{

//Added By Swapnendu Dt 20-Aug 2010
 public LovVO getCityMapLocLovData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  
  
  
//For Paycodesvsacct codes
 public RecordMetaInfo getPayAcctDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getPayAcctDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String savePayAcct(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getPayacctPayCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getPayacctPayCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getPayAcctAgencyLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getPayAcctAgencyLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getPayacctAcctCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getPayacctAcctCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


/////HRARATE
 public RecordMetaInfo getHraDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getHraDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveHraDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getHRAPayScalesLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getHRACityTypesLOVData(LovQueryVO oLovQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//For GIS Rates
 public RecordMetaInfo getGISRatesDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getGISRatesDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveGISRates(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public GISComboVO getDetailGISComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;



//For Misc Allow Rates
 public RecordMetaInfo getMiscAllowRatesDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getMiscAllowRatesDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveMiscAllowRates(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getMiscAllowPayLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public MaintMiscAllowComboVO getMiscAllowComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getMiscAllowPayScaleLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/**
 * Codes For Miscelleneous Parameters
 */

  public MiscComboVO getMiscComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//  For Medical Health Scheme Deduction Tab
  public ArrayList getMHSDedDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getMHSDedDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveMHSDed(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//    For Other Parameter
  public RecordMetaInfo getOtherDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getOtherDetail(String sPrimaryKey,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveOther(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/**
 * END Codes For Miscelleneous Parameters
 */

//TaxParamIncome
  public boolean saveTaxParamIncomeHeader(TaxParamHeaderBean oTaxParamHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getTaxParamIncomeHeaderMetaInfo(TaxParamQueryVO oTaxParamQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getTaxParamIncomeHeader(TaxParamQueryVO oTaxParamQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getTaxParamIncomeDetailMetaInfo(String sRevyear) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getTaxParamIncomeDetail(String sRevYear, long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveTaxParamIncome(TaxParamHeaderBean oTaxParamHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//TaxParamStdDedn
  public boolean saveStdDednHeader(StdDednHeaderBean oStdDednHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getStdDednHeaderMetaInfo(StdDednQueryVO oStdDednQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getStdDednHeader(StdDednQueryVO oStdDednQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getStdDednDetailMetaInfo(String sRevyear) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getStdDednDetail(String sRevYear, long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveStdDedn(StdDednHeaderBean oStdDednHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//TaxParamProfTax
  public boolean saveProfTaxHeader(ProfTaxHeaderBean oProfTaxHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getProfTaxHeaderMetaInfo(ProfTaxQueryVO oProfTaxQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getProfTaxHeader(ProfTaxQueryVO oProfTaxQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getProfTaxDetailMetaInfo(String sPrimaryKey, ProfTaxDetailInfo oProfTaxDetailInfo ) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getProfTaxDetail(String sPrimaryKey, long lStartPosition,long lLastPosition, ProfTaxDetailInfo oProfTaxDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveProfTax(ProfTaxHeaderBean oProfTaxHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

// Tax Parameter Other Information
  public RecordMetaInfo getOtherTaxHeaderMetaInfo(TaxParamOtherQueryVO oTaxParamOtherQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getOtherTaxHeader(TaxParamOtherQueryVO oTaxParamOtherQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveTaxParamOther(TaxParamOtherHeaderBean oTaxParamOtherHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  public LovVO getIncTaxLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getProfTaxLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getStdDednLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getProfTaxStatecodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getOtherYYMMLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//For direct Payroll
  public RecordMetaInfo getDirectPayrollDetailMetaInfo(String sPrimaryKey,DirPayrollDetailInfo oDirPayrollDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDirectPayrollDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,DirPayrollDetailInfo oDirPayrollDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveDirectPayroll(MaintDirectPayrollHeaderBean oMaintDirectPayrollHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDirectPayEmpLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDirectPayEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDirectPayrollPayLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDirectPayrollPayLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDirectPayAgencyLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDirectPayAgencyLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDirectPayAgencySiteLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


  /**
   *  Codes for Annual Income & Tax Paramrters
   */

  public RecordMetaInfo getAnnIncHeaderMetaInfo(MaintAnnIncQueryVO oMaintAnnIncQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getAnnIncHeader(MaintAnnIncQueryVO oMaintAnnIncQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveAnnInc(MaintAnnIncHeaderBean oMaintAnnIncHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  public LovVO getAnnIncLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryAnnIncLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getAnnIncFinYYMMLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


//////////////////Internal Savings

  public RecordMetaInfo getIntSavDetailMetaInfo(String sPrimaryKey,IntSavDetailInfo oIntSavDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getIntSavDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,IntSavDetailInfo oIntSavDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveIntSav(IntSavHeaderBean oIntSavHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getIntSavLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getIntSavQLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getIntSavCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getIntSavCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


////////////////External Savings

  public RecordMetaInfo getExtSavDetailMetaInfo(String sPrimaryKey,ExtSavDetailInfo oExtSavDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getExtSavDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,ExtSavDetailInfo oExtSavDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveExtSav(ExtSavHeaderBean oExtSavHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getExtSavLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getExtSavQLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getExtSavCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getExtSavCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getExtSavFinYYMMLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;




/*Code For Pay Image*/
  public RecordMetaInfo getEnqPayImageHeaderMetaInfo(EnqPayImageQueryVO oEnqPayImageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException, RemoteException;
  public ArrayList getEnqPayImageHeader(EnqPayImageQueryVO oEnqPayImageQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getEnqPayImageDetailMetaInfo(String sPrimaryKey,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEnqPayImageDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public EnqPayImageQueryVO getEnqPayImageComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEnqYmtLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEnqEpmNoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getPayImgGangLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEnqDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;



/**
 * Codes For PF Deduction Master
 */

  public RecordMetaInfo getPfDudnDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPfDudnDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String savePFdudn(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/**
 * Codes For PF Transaction Master
 */

  public RecordMetaInfo getPfTranDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPfTranDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String savePFtran(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 ////////// PFInterestRate
  public RecordMetaInfo getInterestRateHeaderMetaInfo(MaintInterestRateQueryVO oMaintInterestRateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getInterestRateHeader(MaintInterestRateQueryVO oMaintInterestRateQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getInterestRateDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,InrRateDetailInfo oInrRateDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getInterestRateDetailMetaInfo(String sPrimaryKey,InrRateDetailInfo oInrRateDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveInterestRate(MaintInrRateHeaderBean oMaintInrRateHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/////////FOR GEN BASIC ARREAR

  public boolean saveBasicArrearHeader(BasicArrearHeaderBean oBasicArrearHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getBasicArrearHeaderMetaInfo(GenBasicArrearQueryVO oGenBasicArrearQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getBasicArrearHeader(GenBasicArrearQueryVO oGenBasicArrearQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 
  public RecordMetaInfo getBasicArrearDetailMetaInfo(String sPrimaryKey,BasicArrDetailInfo oBasicArrDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 
  public ArrayList getBasicArrearDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BasicArrDetailInfo oBasicArrDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveBasicArrear(BasicArrearHeaderBean oBasicArrearHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 
  public LovVO getBasicArrLOVDataPayYYMM(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;;
  public LovVO getBasicArrLOVDataEmpNo(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public PayYearStatusVO getMaxPayYear() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String GenBasicArr(BaseHeaderBean oBaseHeaderBean, long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String UndoBasicArr(BaseHeaderBean oBaseHeaderBean, long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getBasicArrMaxPayYear(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
//End of Basic Arrear



  public RecordMetaInfo getDAArrearHeaderMetaInfo(GenDAArrearQueryVO oGenDAArrearQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDAArrearHeader(GenDAArrearQueryVO oGenDAArrearQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveDAArrear(GenDAArrearHeaderBean oGenDAArrearHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String genDAArrear(GenDAArrearHeaderBean oGenDAArrearHeaderBean,long loginUserId ,long lLoginSiteId ) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String undoDAArrear(GenDAArrearHeaderBean oGenDAArrearHeaderBean,long loginUserId ,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getDAArrearMaxPayYear(long lLoginSiteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;



  ////////////////////////CREATE PAYROLL TRANSACTION//////////////////
  public String createPayTransaction(String procs, String empNo,long lUserID,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getCreatePayMaxPayYear(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  /////////////////////////ADHOC///////////////////////////////////
  public RecordMetaInfo getAdhocPayHeaderMetaInfo(AdhocPayQueryVO oAdhocPayQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getAdhocPayHeader(AdhocPayQueryVO oAdhocPayQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getAdhocPayDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,AdhocPayDetailInfo oAdhocPayDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getAdhocPayDetailMetaInfo(String sPrimaryKey,AdhocPayDetailInfo oAdhocPayDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveAdhocPay(AdhocPayHeaderBean oAdhocPayHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public AdhocPayComboVO getAdhocPayComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  public LovVO getAdhocPayCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getAdhocPayCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getAdhocYearLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getAdhocDesgLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/* Added by Mrinmay on 12 th july */

  public String computeActualTax(ComputeTaxHeaderBean oComputeTaxHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String computeProjectedTax(ComputeTaxHeaderBean oComputeTaxHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getITaxMaxPayYear(long lLoginSiteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/* Added by Mrinmay on 12 th july */

  public LovVO getEmpIncTaxLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  public String undoPayrollTran(String dflag,String empNum,long loginUserId,long lLoginSiteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getUndoMaxPayYear(long lLoginSiteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  public LovVO getEmpUndoPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


  ////////////////////////MONTH END UPDATE//////////////////
  public String monthEndUpdate(long lUserID,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getMonthEndMaxPayYear(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  ////////////////////////COMPUTE MONTHLY PAYROLL TRANSACTION//////////////////
  public void compMonthlyPayroll(String empNo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public void getMthlyPayrollLovEmp(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  ////////// Compute Final Settlement ////////////////////////////////////////
  public RecordMetaInfo getComFinalHeaderMetaInfo(ComFinalSetQueryVO oComFinalSetQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getComFinalHeader(ComFinalSetQueryVO oComFinalSetQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getComFinalDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,ComFinalSetDetailInfo oComFinalSetDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getComFinalDetailMetaInfo(String sPrimaryKey,ComFinalSetDetailInfo oComFinalSetDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveComFinal(ComFinalHeaderBean oComFinalHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
  public LovVO getComFinalSetEmpNoQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getComFinalSetEmpNoN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getComFinalSetPayCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String compute(String procs, ComFinalSetQueryVO oComFinalSetQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String computeITDetails(ComFinalSetQueryVO oComFinalSetQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//Added by Balpreet for fetching Combo details
  public ComFinalSetComboVO getComFinalSetComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


/////////Maintain PF Detail


  public RecordMetaInfo getPFDetailHeaderMetaInfo(MaintPFDetailQueryVO oMaintPFDetailQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPFDetailHeader(MaintPFDetailQueryVO oMaintPFDetailQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String savePFDetail(MaintPFDetailHeaderBean oMaintPFDetailHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  public LovVO getPFDetailLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryPFDetailLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

    public RecordMetaInfo getPFDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; //added by swapnendu
    public ArrayList getPFDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; //added by swapnendu
   public LovVO getPFFromYrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;;

//////////////////////////////////////////////EMPFACADE////////////////////////////////////////////////

  public RecordMetaInfo getEmpFinHeaderMetaInfo(EmpFinanceQueryVO oEmpFinanceQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpFinHeader(EmpFinanceQueryVO oEmpFinanceQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpFinInfo(EmpFinInfoHeaderBean oEmpFinInfoHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public EmpFinanceComboVO getEmpFinComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpFinInfoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryEmpFinInfoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpInfoDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  // added by devendra start
   public LovVO getEmpInfoDsgnLOVDataIDA(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public LovVO getEmpInfoDsgnLOVDataCDA(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  // added by devendra end
  
  
  public LovVO getEmpInfoDsgnQryLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpInfoSectionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpMastStatecodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDAArrearLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  public LovVO getEmpMastBankCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpMastBranchCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpTypeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpFinVldnDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

///////////////////////////////////////////MONTHLYPAYROLL//////////////////////////

public String MonthlyPayTransaction( String empNo,String all, long lUserID,long lSiteID,String hdnEmpLbrFlag,String hdnMaxRebFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String getMonthlyPayMaxPayYear(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

///////////////////////////////////////////SALJV/////////////////////////////
public String GenSal(long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/////////////////////POST SAL JV TO GL////////////////////////////
public String PostSal(long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
///////////////////////////////////BPV AND CPV////////////////////////
public String GenBPV(long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String GenCPV(long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  ////////// PaymentHistory ////////////////////////////////////////
  public ArrayList getPayHistDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,PayHistDetailInfo oPayHistDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getPayHistDetailMetaInfo(String sPrimaryKey,PayHistDetailInfo oPayHistDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String savePayHist(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 ////////// PaymentHistory ////////////////////////////////////////
  public HraComboVO getHRARateComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/////////////////////////////INITIAL PAYROLL DATA////////////////////////////
public String InitPayData(long lUserID,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String getInitMaxPayYear(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
// Added by dushyanton 20-Oct-2011
public String InitDpsIncentiveData(long lUserID,long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


///////////Adhoc transaction////////////////////////////////////
public String adhocPayTrans(String procs, String payCode, String payMode, String payYYMM,long loginUserId ,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;



//////////////////Reports////////////////////////////////////////////////////
public LovVO getLicenceFeeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;


public LovVO getEOLHPLLOVYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
public LovVO getEmpNameGenerateFormSixteenLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
public LovVO getEmpCPFLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
//added for pnsn slip report
public LovVO getEmpPnsnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
public LovVO getYrBonusAwardYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;

public LovVO getPayGenRecEarningsYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;

public LovVO getPayGenRecEarningsAgencyCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;

public LovVO getMonthlyLeaveDetailsYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;

public LovVO getSalStatementYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;

public LovVO getPaySlipYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;

public LovVO getPFSlipYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;


public LovVO getECSDataFileYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;

public String GenerateECSDataFile(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String GenerateSBIDataFile(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

public LovVO getITForecastYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
public LovVO getITForecastEmp(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
public String sGetMaxITForecastProjYYMM(long  sLoginUserId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

public LovVO getRecEarnPayCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
public LovVO getBankStatementYear(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
public LovVO getLoanCodeData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
public PayReportComboVO  getPayReportComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
//Added By Balpreet Kaur Dt 14 March 2008
public LovVO getAdvCodeData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;
public String sGetEmpName(String  sEmpNum) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String sGetPayCodeName(String  sPayCode) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String sGetIntPayCodeName(String  sPayCode) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String sGetExtPayCodeName(String  sPayCode) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String sGetFinYear(long lLocCode,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getEcsHeaderMetaInfo() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getECSHeader(long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String saveEcsData(ECSDataFileHdrBean oECSDataFileHdrBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String sGetExtSavEmpName(String  sEmpNum, long lUserId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String sGetPaySlipAcc(long  sLoginUserId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sGetPaySlipMaxYYMM(long  sLoginUserId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String sGetITForecastAcc(long  sLoginUserId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String sGetExtSavAcc(long  sLoginUserId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String sGetCurYYMM() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getRecEarnPayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getCityCodeLovData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getMiscPayCodeData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, CreateException, RemoteException;

public RecordMetaInfo getHistoryEntHeaderMetaInfo(HistoryEntryQueryVO oHistoryEntryQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHistoryEntHeader(HistoryEntryQueryVO oHistoryEntryQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHistoryEntDetail(String sPrimaryKey,long
lStartPosition,long lLastPosition,HistoryEntryDetailInfo oHistoryEntryDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getHistoryEntDetailMetaInfo(String
sPrimaryKey,HistoryEntryDetailInfo oHistoryEntryDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveHistoryEnt(HistoryEntryHeaderBean oHistoryEntryHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode,
boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean
bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


			/////////////////////HouseRent/////////////////////////////////////////

  public RecordMetaInfo getHouseRentHeaderMetaInfo(MaintHouseRentRcptVO oMaintHouseRentRcptVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHouseRentHeader(MaintHouseRentRcptVO oMaintHouseRentRcptVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  public RecordMetaInfo getHouseRentDetailMetaInfo(String sPrimaryKey,HouseRentRcptDetailInfo oHouseRentRcptDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHouseRentDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,HouseRentRcptDetailInfo oHouseRentRcptDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  public String saveHouseRent(HouseRentRcptHdrBean oHouseRentRcptHdrBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryHouseRentLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;;
  public LovVO getNewHouseRentLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;;


			/////////////////////////////////LOAN MASTER//////////////////
 public RecordMetaInfo getLoanMstHeaderMetaInfo(MaintLoanMstQueryVO oMaintLoanMstQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLoanMstHeader(MaintLoanMstQueryVO oMaintLoanMstQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveLoanMaster(MaintLoanMasterHdrBean oMaintLoanMasterHdrBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


  public LovVO getQueryEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanMasterLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getBpvPayCodeLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

public boolean saveLeaseAccomHeader(LeaseAccomHeaderBean oLeaseAccomHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getLeaseAccomHeaderMetaInfo(LeaseAccomQueryVO oLeaseAccomQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getLeaseAccomHeader(LeaseAccomQueryVO oLeaseAccomQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getLeaseAccomDetailMetaInfo(String sPrimaryKey,LeaseAccomDetailInfo oBasicArrDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getLeaseAccomDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LeaseAccomDetailInfo oLeaseAccomDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String saveLeaseAccomDetail(LeaseAccomHeaderBean oLeaseAccomHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getLeaseAccomEmpLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getLeaseAccomEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LeaseAccomComboVO getLeaseAccomComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getLeaseAccArrInst(String sEmpNo, String sEmpFlg, String startDate, String endDate,long siteId, long userId) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;


public String computeTaxProject(ComputeTaxProjHeaderBean oComputeTaxHeaderBean,long loginUserId,long lLoginSiteId, String sRunYYMM) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getQueryHistEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getQueryHistYYMMLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getNewHistEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

////////////////SITE DETAIL

  public RecordMetaInfo getSiteDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getSiteDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveSiteDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getSiteLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  public SiteTypeComboVO getLocTypesComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLocTypLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  public LovVO getStateLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;


////////////////////////////////////// EMP LEAVE DETAILS////////////////////////////////////////////////////////
  public EmpLeaveComboVO getEmpLeaveComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getEmpLeaveDetailMetaInfo(String sPrimaryKey,EmpLeaveDetailInfo oEmpLeaveDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpLeaveDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,EmpLeaveDetailInfo oEmpLeaveDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpLeaveDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpLeaveLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  public String cancelLeaveDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

   /////////////////////////////////////////EMPLOYEE DEPENDENT/NOMINEE//////////////////////////

  public RecordMetaInfo getEmpDepndntDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpDepndntDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getEmpNomineeDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpNomineeDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpDependentDetail(EmpDpndntNomHeaderBean oHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpNomineeDetail(EmpDpndntNomHeaderBean oHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryNomieeEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getDpndntNomineeHeaderMetaInfo(DummyQueryVO oDummyQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDpndntNomineeHeader(DummyQueryVO oDummyQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


   ///////////////////////////////////////HILL COMPENSATORY ALLOWANCE///////////////////////////////////////
  public RecordMetaInfo getHillCmpnstryDetailMetaInfo(String sPrimaryKey,MaintHillCmpnstryAllowDetailInfo oMaintHillCmpnstryAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHillCmpnstryDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintHillCmpnstryAllowDetailInfo oMaintHillCmpnstryAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveHillCmpnstryDetail(HillCmpnstryAllowHeaderBean oHillCmpnstryAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public HillCmpnstryComboVO getHillCmpnstryComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getHillCmpnstryHeaderMetaImpl(HillCmpnstryAllowQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHillCmpnstryHeaderRecord(HillCmpnstryAllowQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

   ///////////////////////////////////////TRIBAL AREA ALLOWANCE///////////////////////////////////////
  public RecordMetaInfo getTrblAreaDetailMetaInfo(String sPrimaryKey,MaintTrblAreaAllowDetailInfo oMaintTrblAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getTrblAreaDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintTrblAreaAllowDetailInfo oMaintTrblAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveTrblAreaDetail(TrblAreaAllowHeaderBean oTrblAreaAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public TrblAreaComboVO getTrblAreaComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getTrblAreaHeaderMetaImpl(TrblAreaAllowQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getTrblAreaHeaderRecord(TrblAreaAllowQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

   ///////////////////////////////////////REMOTE AREA ALLOWANCE///////////////////////////////////////
  public RecordMetaInfo getRmtAreaDetailMetaInfo(String sPrimaryKey,MaintRmtAreaAllowDetailInfo oMaintRmtAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getRmtAreaDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintRmtAreaAllowDetailInfo oMaintRmtAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveRmtAreaDetail(RmtAreaAllowHeaderBean oRmtAreaAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RmtAreaComboVO getRmtAreaComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getRmtAreaHeaderMetaImpl(RmtAreaAllowQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getRmtAreaHeaderRecord(RmtAreaAllowQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

   ///////////////////////////////////////SPECIAL DUTY ALLOWANCE///////////////////////////////////////
  public RecordMetaInfo getSplDutyDetailMetaInfo(String sPrimaryKey,SplDutyAllowDetailInfo oSplDutyAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getSplDutyDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,SplDutyAllowDetailInfo oSplDutyAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveSplDutyDetail(SplDutyAllowHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public SplDutyComboVO getSplDutyComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getSCADsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getSCAPayScaleLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getSplDutyHeaderMetaImpl(SplDutyAllowQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getSplDutyHeaderRecord(SplDutyAllowQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/////SCA- Station Compensatory Allowance
  public RecordMetaInfo getScaDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getScaDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveScaDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public SCAComboVO getScaComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/////Employee Transfer Screen
  public RecordMetaInfo getEmpTrnsfrHeaderMetaInfo(EmpTrnsfrQueryVO oEmpTrnsfrQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpTrnsfrHeader(EmpTrnsfrQueryVO oEmpTrnsfrQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpTrnsfrInfo(EmpTrnsfrHeaderBean oEmpFinInfoHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public EmpTrnsfrComboVO getEmpTrnsfrComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getTrnsfrEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getTrnsfrEmpLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getTrnsfrEmpLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getTrnsfrInEmpLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String cancelEmpTrnsfr(EmpTrnsfrHeaderBean oEmpFinInfoHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String empTrnsfrReleaseSalary(EmpTrnsfrHeaderBean oEmpTrnsfrHeaderBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getTrnsfrRlsSalEmpLOVData(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public EmpTrnsfrSalRlsComboVO getSlryRlsComboDetails(String sEmpNo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

////////// Maintain Loan Details
  public RecordMetaInfo getLoanDtlsHeaderMetaInfo(LoanDtlsQueryVO oLoanDtlsQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLoanDtlsHeader(LoanDtlsQueryVO oLoanDtlsQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLoanDtlsDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LoanDtlsDetailInfo oLoanDtlsDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLoanAdminDtlsDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LoanDtlsDetailInfo oLoanDtlsDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getLoanDtlsDetailMetaInfo(String sPrimaryKey,LoanDtlsDetailInfo oLoanDtlsDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveLoanDtls(LoanDtlsHeaderBean oLoanDtlsHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryLoanDtlsLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanDtlsTypeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
  public ArrayList computeIntRate(String loanTyp,String loanAmnt,String fstInstlAmnt,String prnInstlNo,String sancDate) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList computePayAdvIntRate(String loanAmnt,String empLbrFlag,String prnInstlNo, long siteId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getNewLoanDtlsLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanDtlsTypeAdminLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  

//////////////////////////////////////////////EMP PROMOTION FACADE////////////////////////////////////////////////

  public RecordMetaInfo getPromotionHeaderMetaInfo(EmpPromotionQueryVO oEmpPromotionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPromotionHeader(EmpPromotionQueryVO oEmpPromotionQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpPromotion(MaintEmpPromotionBean oEmpPromotionHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public EmpPromotionComboVO getEmpPromComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpPromotionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryEmpPromotionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpPromotionDsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getPromPayScaleCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryEmpSelectGrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
  public LovVO getEmpSelectGrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getEmpPromMaxPayYear(long siteId,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
//////////////////////////////////////////////EMP SUSPENSION FACADE////////////////////////////////////////////////

  public RecordMetaInfo getSuspensionHeaderMetaInfo(EmpSuspensionQueryVO oEmpSuspensionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getSuspensionHeader(EmpSuspensionQueryVO oEmpSuspensionQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpSuspension(MaintEmpSuspensionBean oEmpSuspensionHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  

  public EmpSuspensionComboVO getEmpSuspComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpSuspensionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryEmpSuspensionLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String empSuspReleaseSalary(MaintEmpSuspensionBean oMaintEmpSuspensionBean,long loginUserId,long lLoginSiteId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String revokEmp(MaintEmpSuspensionBean oEmpSuspensionBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public EmpSuspSlryRlsComboVO getEmpSuspSalRlsComboDetails(EmpSuspensionQueryVO oEmpSuspensionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

   /////////////////////////////////////////EMPLOYEE INCREMENT//////////////////////////

  public RecordMetaInfo getEmpAdvIncrHeaderMetaInfo(EmpIncrQueryVO oEmpIncrQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpAdvIncrHeader(EmpIncrQueryVO oEmpIncrQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getEmpIncrHeaderMetaInfo(EmpIncrQueryVO oEmpIncrQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpIncrHeader(EmpIncrQueryVO oEmpIncrQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpAdvIncr(MaintEmpIncrBean oEmpIncrHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpIncr(MaintEmpIncrBean oEmpIncrHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  public LovVO getEmpIncrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpIncrLOVDataNew(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
  public LovVO getEmpAdvIncrLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 /////////////////////////////////////////LEAVE ENCASHMENT//////////////////////////
  public RecordMetaInfo getLeaveEncashHeaderMetaInfo(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLeaveEncashHeader(LeaveEncashQueryVO oLeaveEncashQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveLeaveEncashInfo(LeaveEncashHeaderBean oLeaveEncashHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpLeaveEncashLOV(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpLeaveEncashLOVQ(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLeaveEncashPayInfo(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLeaveEncashITDed(LeaveEncashQueryVO oLeaveEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String sendLeaveEncashInv(String sPrimaryKey,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 /////////////////////////////////////////LTC ENCASHMENT//////////////////////////
  public RecordMetaInfo getLTCEncashHeaderMetaInfo(LTCEncashQueryVO oLTCEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLTCEncashHeader(LTCEncashQueryVO oLTCEncashQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveLTCEncashInfo(LTCEncashHeaderBean oLTCEncashHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpLTCEncashLOV(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpLTCEncashLOVQ(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLTCEncashITDed(LTCEncashQueryVO oLTCEncashQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String sendLTCEncashInv(String sPrimaryKey,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 
/////////FOR REVERSAL RECOVERIES

  public boolean saveRevrRecoveriesHeader(RevrRecoveriesHeaderBean oRevrRecoveriesHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getRevrRecoveriesHeaderMetaInfo(GenRevrRecoveriesQueryVO oGenRevrRecoveriesQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getRevrRecoveriesHeader(GenRevrRecoveriesQueryVO oGenRevrRecoveriesQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
  public RecordMetaInfo getRevrRecoveriesDetailMetaInfo(String sPrimaryKey,RevrRecoveriesDetailInfo oRevrRecoveriesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
  public ArrayList getRevrRecoveriesDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,RevrRecoveriesDetailInfo oRevrRecoveriesInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveRevrRecoveries(RevrRecoveriesHeaderBean oRevrRecoveriesHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
  public LovVO getRevrRecoveriesLOVDataPayYYMM(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;;
  public LovVO getRevrRecoveriesLOVDataEmpNo(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String GenRevrRecoveries(BaseHeaderBean oBaseHeaderBean, long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String UndoRevrRecoveries(BaseHeaderBean oBaseHeaderBean, long lUserID,long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/////////////////////POST SAL INVOICES TO AP////////////////////////////
//added by neeraj starts
public String PostSalAP(long lUserID,long lSiteID,String hdnEmpLbrFlag,String invoice_date) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
//added by neraj ends
public String getPostSalMaxPayYear(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/////////////////////POST REMITTANCES TO AP////////////////////////////
//modified by neeraj starts
public String PostRemitToAP(long lUserID,long lSiteID,String hdnEmpLbrFlag,String invoice_date) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
//modified by neeraj ends
public String getPostRemitMaxPayYear(long lSiteID,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  //////////////////////////////////////////////PLI Payment FACADE////////////////////////////////////////////////

  public RecordMetaInfo getPLIPaymentHeaderMetaInfo(PLIPaymentQueryVO oPLIPaymentQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPLIPaymentHeader(PLIPaymentQueryVO oPLIPaymentQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String savePLIPayment(PLIPaymentHeaderBean oPLIPaymentHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getPLIPayEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  public RecordMetaInfo getPLIPaymentDetailMetaInfo(String sPrimaryKey,PLIPaymentDetailInfo oPLIPaymentDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPLIPaymentDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,PLIPaymentDetailInfo oPLIPaymentDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 //////////////////////////////////////////////CPF Final Payment FACADE////////////////////////////////////////////////

  public RecordMetaInfo getCPFFinPayHeaderMetaInfo(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getCPFFinPayHeader(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpCPFFinPay(CPFFinalPaymentBean oCPFFinalPaymentBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpCPFFinPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpCPFAdvPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryEmpCPFFinPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public CPFFinalPayComboVO getCPFFinalPayComboDetails()throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getCPFFinPayDetailMetaInfo(String sPrimarykey,CPFFinalPaymentBaseDetailInfo oCPFFinalPaymentBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getCPFFinPayDetail(String sPrimarykey,long lStartPosition, long lLastPosition, CPFFinalPaymentBaseDetailInfo oCPFFinalPaymentBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryEmpCPFReleasePayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
  public String realeaseCPFPay(BaseHeaderBean oBaseHeaderBean)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
  public LovVO getEmpCPFFinalPayLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
  public BaseHeaderBean getCPFFinalDtls(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
  public BaseHeaderBean getCPFMaxApplAmt(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
  public BaseHeaderBean getCPFIntInst(CPFFinalPaymentQueryVO oCPFFinalPaymentQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
  //public String calcCpfYrInt(BaseHeaderBean oBaseHeaderBean)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;
  public String revokeCPFPay(BaseHeaderBean oBaseHeaderBean)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException ;

   ///////////////////////////////////////PROJECT ALLOWANCE///////////////////////////////////////
  public RecordMetaInfo getProjectDetailMetaInfo(String sPrimaryKey,MaintProjectAllowDetailInfo oMaintProjecttAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getProjectDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintProjectAllowDetailInfo oMaintProjectAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveProjectDetail(MaintProjectAllowHeaderBean oMaintProjectAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ProjectComboVO getProjectComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getProjectHeaderMetaImpl(ProjectQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getProjectHeaderRecord(ProjectQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

   ///////////////////////////////////////OVER ABOVE ARREAR///////////////////////////////////////
  public OverAbvArrearComboVO getOverAbvArrearComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getOverAbvArrearHeaderMetaInfo(OverAbvArrearQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getOverAbvArrearHeader(OverAbvArrearQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpOverAbvArrearLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String sendOverAbvArrearInv(OverAbvArrearQueryVO oOverAbvArrearQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  /////////////////////////////////////////OVER ABOVE PAYMENT////////////////Added by Aqeel Dt 10 July 08//////////
  public RecordMetaInfo getPayOverAbvHeaderMetaInfo(PayOverAboveQueryVO oPayOverAboveQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPayOverAbvHeader(PayOverAboveQueryVO oPayOverAboveQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String savePayOverAbvInfo(PayOverAboveHeaderBean oPayOverAboveHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpPayOverAbvLOV(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getPayCodeOvrAbvLOV(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getAgencyCodeOvrAbvLOV(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getAgencySiteCodeOvrAbvLOV(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpPayOverAbvLOVQ(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String sendPayOvrAbvInv(String oPayOverAboveId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPayOverAboveITDed(PayOverAboveQueryVO oPayOverAboveQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

// ADDED by Gagan dt- 18 June 08


 public RecordMetaInfo getPaycodeAgencycodeDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getPaycodeAgencycodeDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String  saveAgencyDetails(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO  getPaycodeAgencycodePayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO  getPaycodeAgencycodeEmployeeNoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO  getPaycodeAgencycodeLocationLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO  getPaycodeAgencycodeAgencySiteLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getPaycodeAgencycodeAgencyLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


//////////////////////////////////////////////EMP REINSTATE FACADE///////////Added by Aqeel Dt 22 July 08/////

  public RecordMetaInfo getEmpReinstHeaderMetaInfo(EmpReinstateQueryVO oEmpReinstateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpReinstHeader(EmpReinstateQueryVO oEmpReinstateQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpReinst(MaintEmpReinstateBean oMaintEmpReinstateBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public EmpReinstateComboVO getEmpReinstComboDet()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpReinstLOVN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpReinstLOVQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 //Added by Aqeel on 24july08///////////////////////////////

  public LovVO getLbrGangLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//////////////////////////////////////////////EMP ADDRESS////////////////////////////////////////////////

  public RecordMetaInfo getEmpAddressHeaderMetaInfo(EmpAddressQueryVO oEmpAddressQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpAddressHeader(EmpAddressQueryVO oEmpAddressQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpAddress(EmpAddressHeaderBean oEmpAddressHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


//////////////////////////////////////////////EMPLOYER TAX////////////////////////////////////////////////

  public RecordMetaInfo getEmplyrTaxHeaderMetaInfo(EmplyrTaxQueryVO oEmplyrTaxQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmplyrTaxHeader(EmplyrTaxQueryVO oEmplyrTaxQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmplyrTax(EmplyrTaxHeaderBean oEmplyrTaxHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmplyrTaxEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmplyrTaxEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

// Category Location Mapping by Gagan dt- 4 Aug 08
 public RecordMetaInfo getCategoryLocationDetailMetaInfo (String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getCategoryLocationDetail(String sPrimaryKey,long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String  saveCategoryDetails(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public CtgrySchemeComboVO getCtgrySchemeComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getCategorySchemeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getCategorySchemeLocationLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getCategorySchemeDepotLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

// Loan fore closure by GAGAN 18 sept 08

  public RecordMetaInfo getLoanForeclosureHeaderMetaInfo(LoanForeclosureVO oLoanForeclosureVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLoanForeclosureHeader(LoanForeclosureVO oLoanForeclosureVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanDtlLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String  saveLoanForeclosureDetails(LoanForeclosureBean oLoanForeclosureBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanDtlLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
 public BaseHeaderBean getLoanForeclosureDtls(LoanForeclosureVO oLoanForeclosureVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public BaseHeaderBean getForecloseInterestDtls(LoanForeclosureVO oLoanForeclosureVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

// Loan Reschedule by GAGAN dt 30 sept

 public RecordMetaInfo getLoanRescheduleHeaderMetaInfo(LoanRescheduleVO oLoanRescheduleVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLoanRescheduleHeader(LoanRescheduleVO oLoanRescheduleVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanRescheduleDtlLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String  saveLoanRescheduleDetails(LoanRescheduleBean oLoanRescheduleBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanRescheduleDtlLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public BaseHeaderBean getLoanRescheduleDtls(LoanRescheduleVO oLoanRescheduleVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public BaseHeaderBean getInterestDtls(LoanRescheduleVO oLoanRescheduleVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getLoanRescheduleEmpLOVQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//////////////////////////////////////////////PAY FIXATION FACADE////////////////////////////////////////////////

  public RecordMetaInfo getPayFixHeaderMetaInfo(DummyQueryVO oDummyQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPayFixHeader(DummyQueryVO oDummyQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpPayFix(EmpPayFixBean oEmpPayFixBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpPayFixLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getQueryEmpPayFixLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 
// High Achievers by Gagan dt- 22 Dec 08
 public RecordMetaInfo getHighAchieversDetailMetaInfo (String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getHighAchieversDetail(String sPrimaryKey,long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String  saveHighAchieversDetails(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 public LovVO getHighAchieversEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

 //////////////////////////////////////////////Loan Details for Bulk FACADE Added by Aqeel on 17 Dec08///////////////////////////////////////////////

   public RecordMetaInfo getLoanDtlsAllHeaderMetaInfo(LoanDtlsAllQueryVO oLoanDtlsAllQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public ArrayList getLoanDtlsAllHeader(LoanDtlsAllQueryVO oLoanDtlsAllQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public String saveLoanDtlsAll(LoanDtlsAllHeaderBean oLoanDtlsAllHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   //public LovVO getLoanDtlAllEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;   
   public RecordMetaInfo getLoanDtlsAllDetailMetaInfo(String sPrimaryKey,LoanDtlsAllDetailInfo oLoanDtlsAllDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public ArrayList getLoanDtlsAllDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,LoanDtlsAllDetailInfo oLoanDtlsAllDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public LoanDtlsAllHeaderBean computeAllIntRate(LoanDtlsAllHeaderBean oLoanDtlsAllHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public LovVO getLoanDtlAllDepotEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;   
   
  //////////////////////////////////////////////Direct Payroll for Bulk FACADE Added by Aqeel on 24 Dec08////////////////////////////////////////////////

   public RecordMetaInfo getDirPayrollBulkHeaderMetaInfo(DirPayrollBulkQueryVO oDirPayrollBulkQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public ArrayList getDirPayrollBulkHeader(DirPayrollBulkQueryVO oDirPayrollBulkQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public String saveDirPayrollBulk(DirPayrollBulkHeaderBean oDirPayrollBulkHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public LovVO getDirPayBulkEmpLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public RecordMetaInfo getDirPayrollBulkDetailMetaInfo(String sPrimaryKey,DirPayrollBulkDetailInfo oDirPayrollBulkDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
   public ArrayList getDirPayrollBulkDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,DirPayrollBulkDetailInfo oDirPayrollBulkDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  ///////////////////////////////////////Medical Claim Added by Aqeel on 23 Feb09///////////////////////////////////////
  
  public EmpMediBillsComboVO getEmpMediBillsComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getEmpMediBillsHeaderMetaInfo(EmpMediBillsQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpMediBillsHeader(EmpMediBillsQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEmpMediBillsInfo(EmpMediBillsHeaderBean oEmpMediBillsHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpMediBillsLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpMediBillsLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpDependentLov(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
  public String sendEmpMediBillsInv(String oEmpMediBillsId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


///////////////////////// added by devendra on 23 aug 2010 start/////////////////////////////////////////////////
public RecordMetaInfo getMediReimbursDtlsAllHeaderMetaInfo(MediReimbursDtlsAllQueryVO mediReimbursDtlsAllQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getMediReimbursDtlsAllHeader(MediReimbursDtlsAllQueryVO mediReimbursDtlsAllQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getMediReimbursDtlsAllDetailMetaInfo(String sPrimaryKey,MediReimbDtlsAllDetailInfo mediReimbDtlsAllDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getMediReimbursDtlsAllDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MediReimbDtlsAllDetailInfo mediReimbDtlsAllDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String saveMediReimbursDtlsAll(MediReimbursDtlsAllHeaderBean mediReimbursDtlsAllHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
///////////////////////// added by devendra on 23 aug 2010 end///////////////////////////////////////////////// 
//Added By amresh For Prms.
 public EmpPrmsMediBillsComboVO getEmpPrmsMediBillsComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpPrmsMediBillsHeaderMetaInfo(EmpPrmsMediBillsQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpPrmsMediBillsHeader(EmpPrmsMediBillsQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpPrmsMediBillsInfo(EmpPrmsMediBillsHeaderBean oEmpPrmsMediBillsHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpPrmsMediBillsLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpPrmsMediBillsLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpPrmsMediBillsInv(String oEmpPrmsMediBillsId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 //CeilAdj
 public RecordMetaInfo getEmpPrmsCeilAdjHeaderMetaInfo(EmpPrmsCeilAdjQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpPrmsCeilAdjHeader(EmpPrmsCeilAdjQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpPrmsCeilAdjInfo(EmpPrmsCeilAdjHeaderBean oEmpPrmsCeilAdjHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpPrmsCeilAdjLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpPrmsCeilAdjLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
 public RecordMetaInfo getEmpPrmsCeilAdjDetailMetaInfo(String sPrimaryKey, EmpPrmsCeilAdjHistoryDetailParm oEmpPrmsCeilAdjHistoryDetailParm ) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpPrmsCeilAdjDetail(String sPrimaryKey, EmpPrmsCeilAdjHistoryDetailParm oEmpPrmsCeilAdjHistoryDetailParm, long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

///////////////////////// added by dhiraj on 20 may 2020 start/////////////////////////////////////////////////
public LovVO getIncomeTaxRegimeEmpLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getIncomeTaxRegimeHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getIncomeTaxRegimeHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getIncomeTaxRegimeDetail(String sPrimaryKey,String sLocId,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getIncomeTaxRegimeDetailMetaInfo(String sPrimaryKey,String sLocId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String saveIncomeTaxRegime(IncomeTaxRegimeHeaderBean oBaseHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
///////////////////////// added by dhiraj on 20 may 2020 start/////////////////////////////////////////////////
//added by amresh for cpf claim id////
public LovVO getCpfClaimReqIdLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
public LovVO getCpfPartFinalClaimReqIdLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
public LovVO getCpfFinalClaimReqIdLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;  
//LTC

public LovVO getEmpLTCReimbLOVQ(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public LovVO getEmpLTCReimbLOVN(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getLeaveTravelConcessionHeaderMetaInfo(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getLeaveTravelConcessionHeader(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String saveLeaveTravelConcessionInfo(LeaveTravelConcessionHeaderBean oLeaveTravelConcessionHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getLeaveTravelConcessionITDed(LeaveTravelConcessionQueryVO oLeaveTravelConcessionQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String sendLeaveTravelConcessionInv(String sPrimaryKey,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

///////////////////////// added by dhiraj on 28 June 2021 start/////////////////////////////////////////////////
public LovVO getBasicHistoryEventEmpLOV(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getBasicHistoryEventHeaderMetaImpl(BaseQueryVO oBaseQueryVO)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getBasicHistoryEventHeaderRecord(BaseQueryVO oQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public RecordMetaInfo getBasicHistoryEventDetailMetaInfo(String sPrimaryKey,String sLocId) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public ArrayList getBasicHistoryEventDetail(String sPrimaryKey,String sLocId,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
public String saveBasicHistoryEvent(BasicHistoryEventHeaderBean oBaseHeaderBean,Timestamp oWhenPicked,String sScreenName,String sScreenMode,boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged,Timestamp oDetailPicked)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
///////////////////////// added by dhiraj on 28 June 2021 end/////////////////////////////////////////////////
//Added By amresh For NewspaperAllowance.
 public EmpNewspaperAllowanceComboVO getEmpNewspaperAllowanceComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpNewspaperAllowanceHeaderMetaInfo(EmpNewspaperAllowanceQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpNewspaperAllowanceHeader(EmpNewspaperAllowanceQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpNewspaperAllowanceInfo(EmpNewspaperAllowanceHeaderBean oEmpNewspaperAllowanceHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpNewspaperAllowanceLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpNewspaperAllowanceLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpNewspaperAllowanceInv(String oEmpNewspaperAllowanceId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 

 public EmpLocalTravelAllowanceComboVO getEmpLocalTravelAllowanceComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpLocalTravelAllowanceHeaderMetaInfo(EmpLocalTravelAllowanceQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpLocalTravelAllowanceHeader(EmpLocalTravelAllowanceQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpLocalTravelAllowanceInfo(EmpLocalTravelAllowanceHeaderBean oEmpLocalTravelAllowanceHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpLocalTravelAllowanceLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpLocalTravelAllowanceLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpLocalTravelAllowanceInv(String oEmpLocalTravelAllowanceId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
 public EmpTravelReimbursementComboVO getEmpTravelReimbursementComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpTravelReimbursementHeaderMetaInfo(EmpTravelReimbursementQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpTravelReimbursementHeader(EmpTravelReimbursementQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpTravelReimbursementInfo(EmpTravelReimbursementHeaderBean oEmpTravelReimbursementHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpTravelReimbursementLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpTravelReimbursementLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpTravelReimbursementInv(String oEmpTravelReimbursementId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
 public EmpMobileReimbursementComboVO getEmpMobileReimbursementComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpMobileReimbursementHeaderMetaInfo(EmpMobileReimbursementQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpMobileReimbursementHeader(EmpMobileReimbursementQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpMobileReimbursementInfo(EmpMobileReimbursementHeaderBean oEmpMobileReimbursementHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpMobileReimbursementLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpMobileReimbursementLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpMobileReimbursementInv(String oEmpMobileReimbursementId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
 public EmpLaptopReimbursementComboVO getEmpLaptopReimbursementComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpLaptopReimbursementHeaderMetaInfo(EmpLaptopReimbursementQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpLaptopReimbursementHeader(EmpLaptopReimbursementQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpLaptopReimbursementInfo(EmpLaptopReimbursementHeaderBean oEmpLaptopReimbursementHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpLaptopReimbursementLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpLaptopReimbursementLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpLaptopReimbursementInv(String oEmpLaptopReimbursementId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
 public EmpTelephoneDataReimbursementComboVO getEmpTelephoneDataReimbursementComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpTelephoneDataReimbursementHeaderMetaInfo(EmpTelephoneDataReimbursementQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpTelephoneDataReimbursementHeader(EmpTelephoneDataReimbursementQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpTelephoneDataReimbursementInfo(EmpTelephoneDataReimbursementHeaderBean oEmpTelephoneDataReimbursementHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpTelephoneDataReimbursementLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpTelephoneDataReimbursementLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpTelephoneDataReimbursementInv(String oEmpTelephoneDataReimbursementId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
 public EmpBriefcaseReimbursementComboVO getEmpBriefcaseReimbursementComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpBriefcaseReimbursementHeaderMetaInfo(EmpBriefcaseReimbursementQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpBriefcaseReimbursementHeader(EmpBriefcaseReimbursementQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpBriefcaseReimbursementInfo(EmpBriefcaseReimbursementHeaderBean oEmpBriefcaseReimbursementHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpBriefcaseReimbursementLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpBriefcaseReimbursementLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpBriefcaseReimbursementInv(String oEmpBriefcaseReimbursementId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
/* 
 public EmpLiveriesAndTailoringAllowanceComboVO getEmpLiveriesAndTailoringAllowanceComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpLiveriesAndTailoringAllowanceHeaderMetaInfo(EmpLiveriesAndTailoringAllowanceQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpLiveriesAndTailoringAllowanceHeader(EmpLiveriesAndTailoringAllowanceQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpLiveriesAndTailoringAllowanceInfo(EmpLiveriesAndTailoringAllowanceHeaderBean oEmpLiveriesAndTailoringAllowanceHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpLiveriesAndTailoringAllowanceLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpLiveriesAndTailoringAllowanceLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpLiveriesAndTailoringAllowanceInv(String oEmpLiveriesAndTailoringAllowanceId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 */
 public EmpLaptopAMCComboVO getEmpLaptopAMCComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpLaptopAMCHeaderMetaInfo(EmpLaptopAMCQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpLaptopAMCHeader(EmpLaptopAMCQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpLaptopAMCInfo(EmpLaptopAMCHeaderBean oEmpLaptopAMCHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpLaptopAMCLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpLaptopAMCLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpLaptopAMCInv(String oEmpLaptopAMCId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 
 public EmpLtcHomeReimbursementComboVO getEmpLtcHomeReimbursementComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getEmpLtcHomeReimbursementHeaderMetaInfo(EmpLtcHomeReimbursementQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getEmpLtcHomeReimbursementHeader(EmpLtcHomeReimbursementQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveEmpLtcHomeReimbursementInfo(EmpLtcHomeReimbursementHeaderBean oEmpLtcHomeReimbursementHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpLtcHomeReimbursementLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getEmpLtcHomeReimbursementLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String sendEmpLtcHomeReimbursementInv(String oEmpLtcHomeReimbursementId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 

}