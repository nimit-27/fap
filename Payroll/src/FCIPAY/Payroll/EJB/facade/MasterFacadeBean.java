package FCIPAY.Payroll.EJB.facade;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DirPayrollDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayHistDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntRateDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BasicArrDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ExtSavDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.InrRateDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntSavDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintAnnIncQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntRateQueryVO;
import FCIPAY.Payroll.EJB.business.PayReportBusinessObject;
import FCIPAY.Payroll.EJB.business.PayReportBO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayReportComboVO;
import FCIPAY.Payroll.UTILITY.PayScaleHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GISComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintInterestRateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GenBasicArrearQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPFDetailQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPFDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProfTaxDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProfTaxQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.StdDednQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TaxParamOtherQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TaxParamQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ComFinalSetQueryVO;
import FCIPAY.Payroll.EJB.business.AnnIncBusinessObject;
import FCIPAY.Payroll.EJB.business.CityTypeBusinessObject;
import FCIPAY.Payroll.EJB.business.DirectPayrollBusinessObject;
import FCIPAY.Payroll.EJB.business.ExtSavBusinessObject;
import FCIPAY.Payroll.EJB.business.GISRatesBusinessObject;
import FCIPAY.Payroll.EJB.business.MiscAllowBusinessObject;
import FCIPAY.Payroll.EJB.business.MaintPFDtlBusinessObject;
import FCIPAY.Payroll.EJB.business.GenBasicArrearBusinessObject;
import FCIPAY.Payroll.EJB.business.HraBusinessObject;
import FCIPAY.Payroll.EJB.business.InrRateBusinessObject;
import FCIPAY.Payroll.EJB.business.IntSavBusinessObject;
import FCIPAY.Payroll.EJB.business.MiscParamBusinessObject;
import FCIPAY.Payroll.EJB.business.PayAcctBusinessObject;
import FCIPAY.Payroll.EJB.business.EditPayImgBusinessObject;
import FCIPAY.Payroll.UTILITY.EnqPayImageHeaderBean;
import FCIPAY.Payroll.EJB.business.PfDudnMstBusinessObject;
import FCIPAY.Payroll.EJB.business.PfTranCodeBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamIncomeBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamOtherBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamProfTaxBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamStdDedBusinessObject;
import FCIPAY.Payroll.EJB.business.CreatePayTransBusinessObject;
import FCIPAY.Payroll.EJB.business.AdhocPayBusinessObject;
import FCIPAY.Payroll.EJB.business.ComputeIncomeTaxBusinessObject;
import FCIPAY.Payroll.EJB.business.CompIncomeTaxProjBusinessObject;
import FCIPAY.Payroll.UTILITY.ComputeTaxProjHeaderBean;
import FCIPAY.Payroll.EJB.business.UndoPayTranBusinessObject;
import FCIPAY.Payroll.EJB.business.MonthEndUpdateBusinessObject;
import FCIPAY.Payroll.EJB.business.IntRateBusinessObject;
import FCIPAY.Payroll.EJB.business.CompPayrollBusinessObject;
import FCIPAY.Payroll.EJB.business.ComFinalBusinessObject;
import FCIPAY.Payroll.EJB.business.MonthlyPayrollBusinessObject;
import FCIPAY.Payroll.EJB.business.GenSalBusinessObject;
import FCIPAY.Payroll.EJB.business.PayHistBusinessObject;
import FCIPAY.Payroll.EJB.business.PostSalBusinessObject;
import FCIPAY.Payroll.EJB.business.PostRemitAPBusinessObject;
import FCIPAY.Payroll.EJB.business.InitPayBusinessObject;
import FCIPAY.Payroll.EJB.business.CPVBusinessObject;
import FCIPAY.Payroll.EJB.business.BPVBusinessObject;
import FCIPAY.Payroll.EJB.business.GetDescBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapQueryVO;
import FCIPAY.Payroll.UTILITY.MaintCityLocMapHeaderBean;

import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintAdhocPayBean;
import FCIPAY.Payroll.UTILITY.AdhocPayHeaderBean;
import FCIPAY.Payroll.UTILITY.ExtSavHeaderBean;
import FCIPAY.Payroll.UTILITY.IntSavHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintAnnIncHeaderBean;
import FCIPAY.Payroll.UTILITY.ECSDataFileHdrBean;
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
import FCIPAY.Payroll.UTILITY.IntRateHeaderBean;
import FCIPAY.Payroll.UTILITY.IntRateDetailBean;
import FCIPAY.Payroll.UTILITY.ComFinalHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MiscComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.AdhocPayComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CtgrySchemeComboVO;

import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.ServiceLocator;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;

import FCIPAY.Payroll.UTILITY.GenDAArrearHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GenDAArrearQueryVO;
import FCIPAY.Payroll.EJB.business.DAArrearBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayYearStatusVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HraComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BadClmtComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BadClmtQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpFinanceQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpFinanceComboVO;
import FCIPAY.Payroll.EJB.business.EmpFinanceBusinessObject;
import FCIPAY.Payroll.UTILITY.EmpFinInfoHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPayScaleQueryVO;
import FCIPAY.Payroll.EJB.business.BankMastBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintBankMastQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BankMastDetailInfo;
import FCIPAY.Payroll.UTILITY.MaintBankMastHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintBadClmtAllowDetailInfo;
import  FCIPAY.Payroll.DATAACCESSTIER.VO.HistoryEntryQueryVO;
import  FCIPAY.Payroll.DATAACCESSTIER.VO.HistoryEntryDetailInfo;
import  FCIPAY.Payroll.EJB.business.HistoryEntryBusinessObject;
import FCIPAY.Payroll.UTILITY.HistoryEntryHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintHouseRentRcptVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HouseRentRcptDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintLoanMstQueryVO;
import FCIPAY.Payroll.UTILITY.MaintLoanMasterHdrBean;
import FCIPAY.Payroll.UTILITY.LoanDtlsDetailBean;
import FCIPAY.Payroll.UTILITY.HouseRentRcptHdrBean;
import FCIPAY.Payroll.EJB.business.HouseRentRcptBusinessObject;
import FCIPAY.Payroll.EJB.business.LoanMasterBusinessObject;

import FCIPAY.Payroll.UTILITY.LeaseAccomHeaderBean;
import FCIPAY.Payroll.UTILITY.LeaseAccomBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaseAccomQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaseAccomDetailInfo;
import FCIPAY.Payroll.EJB.business.LeaseAccomBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaseAccomComboVO;
import FCIPAY.Payroll.EJB.business.CategoryLocationBusinessObject;
import FCIPAY.Payroll.UTILITY.MaintCategoryLocationBean;
import FCIPAY.Payroll.EJB.business.LoanForeclosureBusinessObject;
import FCIPAY.Payroll.UTILITY.LoanForeclosureBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanForeclosureVO;
import FCIPAY.Payroll.EJB.business.LoanRescheduleBusinessObject;
import FCIPAY.Payroll.UTILITY.LoanRescheduleBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanRescheduleVO;
import FCIPAY.Payroll.EJB.business.PayCodeBusinessObject;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import FCIPAY.Payroll.DATAACCESSTIER.VO.DsgnComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLeaveComboVO;
import FCIPAY.Payroll.EJB.business.MaintDsgnBusinessObject;
import FCIPAY.Payroll.EJB.business.Maint6PayDsgnBusinessObject;//addedbydevendra
import FCIPAY.Payroll.EJB.business.EmpLeaveBusinessObject;
import FCIPAY.Payroll.EJB.business.EmpNomineeDpndntBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpLeaveDetailInfo;

import FCIPAY.Payroll.EJB.business.SiteDetailBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SiteTypeComboVO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.HillCmpnstryComboVO;
import FCIPAY.Payroll.EJB.business.HillCmpnstryAllowBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HillCmpnstryAllowQueryVO;
import FCIPAY.Payroll.UTILITY.HillCmpnstryAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintHillCmpnstryAllowDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.TrblAreaComboVO;
import FCIPAY.Payroll.EJB.business.TrblAreaAllowBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TrblAreaAllowQueryVO;
import FCIPAY.Payroll.UTILITY.TrblAreaAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintTrblAreaAllowDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.RmtAreaComboVO;
import FCIPAY.Payroll.EJB.business.RmtAreaAllowBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.RmtAreaAllowQueryVO;
import FCIPAY.Payroll.UTILITY.RmtAreaAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintRmtAreaAllowDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.SplDutyComboVO;
import FCIPAY.Payroll.EJB.business.SplDutyAllowBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SplDutyAllowQueryVO;
import FCIPAY.Payroll.UTILITY.SplDutyAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SplDutyAllowDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.SCAComboVO;
import FCIPAY.Payroll.EJB.business.SCARateBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintMiscAllowComboVO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpTrnsfrQueryVO;
import FCIPAY.Payroll.UTILITY.EmpTrnsfrHeaderBean;
import FCIPAY.Payroll.EJB.business.EmpTrnsfrBusinessObject;

import FCIPAY.Payroll.EJB.business.EmpIncrBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpIncrQueryVO;
import FCIPAY.Payroll.UTILITY.MaintEmpIncrBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPromotionQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpPromotionComboVO;
import FCIPAY.Payroll.EJB.business.EmpPromotionBusinessObject;
import FCIPAY.Payroll.UTILITY.MaintEmpPromotionBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspensionQueryVO;
import FCIPAY.Payroll.EJB.business.EmpSuspensionBusinessObject;
import FCIPAY.Payroll.UTILITY.MaintEmpSuspensionBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpSuspensionComboVO;

import FCIPAY.Payroll.EJB.business.LoanDtlsBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsDetailInfo;
import FCIPAY.Payroll.UTILITY.LoanDtlsHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.LeaveEncashQueryVO;
import FCIPAY.Payroll.UTILITY.LeaveEncashHeaderBean;
import FCIPAY.Payroll.EJB.business.LeaveEncashBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.LTCEncashQueryVO;
import FCIPAY.Payroll.UTILITY.LTCEncashHeaderBean;
import FCIPAY.Payroll.EJB.business.LTCEncashBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.OTATypeComboVO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.GenRevrRecoveriesQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.RevrRecoveriesDetailInfo;
import FCIPAY.Payroll.UTILITY.RevrRecoveriesHeaderBean;
import FCIPAY.Payroll.UTILITY.GenRevrRecoveriesBean;
import FCIPAY.Payroll.EJB.business.GenRevrRecoveriesBusinessObject;

import FCIPAY.Payroll.EJB.business.PostSalAPBusinessObject;

import FCIPAY.Payroll.EJB.business.PLIPaymentBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIPaymentQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PLIPaymentDetailInfo;
import FCIPAY.Payroll.UTILITY.PLIPaymentHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentQueryVO;
import FCIPAY.Payroll.EJB.business.CPFFinalPymntBusinessObject;
import FCIPAY.Payroll.UTILITY.CPFFinalPaymentBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPaymentBaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CPFFinalPayComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DARatesDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintDaRatesQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProjectComboVO;
import FCIPAY.Payroll.EJB.business.ProjectAllowBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProjectQueryVO;
import FCIPAY.Payroll.UTILITY.MaintProjectAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintProjectAllowDetailInfo;
import FCIPAY.Payroll.UTILITY.MaintDARatesHeaderBean;
import FCIPAY.Payroll.UTILITY.CCARatesHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCAComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCARatesQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OverAbvArrearComboVO;
import FCIPAY.Payroll.EJB.business.OverAbvArrearBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.OverAbvArrearQueryVO;
import FCIPAY.Payroll.UTILITY.OverAbvArrearHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.PayOverAboveQueryVO;
import FCIPAY.Payroll.UTILITY.PayOverAboveHeaderBean;
import FCIPAY.Payroll.EJB.business.PayOverAboveBusinessObject;
import FCIPAY.Payroll.EJB.business.PayCodeAgencyCodeBusinessObject;
import FCIPAY.Payroll.EJB.business.PayScaleBusinessObject;
import FCIPAY.Payroll.EJB.business.DARatesBusinessObject;
import FCIPAY.Payroll.EJB.business.CCARateBusinessObject;
import FCIPAY.Payroll.EJB.business.ConvAllowBusinessObject;
import FCIPAY.Payroll.EJB.business.BadClmtAllowBusinessObject;
import FCIPAY.Payroll.EJB.business.CityLocMapBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpReinstateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpReinstateComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCARatesDetailInfo;
import FCIPAY.Payroll.UTILITY.MaintEmpReinstateBean;
import FCIPAY.Payroll.EJB.business.EmpReinstateBusinessObject;
import FCIPAY.Payroll.UTILITY.ConvAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowComboVO;
import FCIPAY.Payroll.UTILITY.EmpAddressHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpAddressQueryVO;
import FCIPAY.Payroll.EJB.business.EmpAddressBusinessObject;
import FCIPAY.Payroll.UTILITY.EmplyrTaxHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmplyrTaxQueryVO;
import FCIPAY.Payroll.EJB.business.EmplyrTaxBusinessObject;
import FCIPAY.Payroll.UTILITY.MaintBadClmtAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EditPayImgComboVO;
import FCIPAY.Payroll.EJB.business.EmpPayFixBusinessObject;
import FCIPAY.Payroll.UTILITY.EmpPayFixBean;

//Added by Aqeel Ahmed on 17 Dec 08
import FCIPAY.Payroll.UTILITY.LoanDtlsAllHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsAllQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsAllDetailInfo;
import FCIPAY.Payroll.EJB.business.LoanDtlsAllBusinessObject;

//Added by Aqeel Ahmed on 26 Dec 08
import FCIPAY.Payroll.UTILITY.DirPayrollBulkHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DirPayrollBulkQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DirPayrollBulkDetailInfo;
import FCIPAY.Payroll.EJB.business.DirPayrollBulkBusinessObject;

//Added by Aqeel Ahmed on 23 Feb 09
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsComboVO;
import FCIPAY.Payroll.EJB.business.EmpMediBillsBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpMediBillsQueryVO;
import FCIPAY.Payroll.UTILITY.EmpMediBillsHeaderBean;

import FCIPAY.Payroll.EJB.business.EmpHighAchieversBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleVO;//added by sakshi 26.12.2008

import FCIPAY.Payroll.DATAACCESSTIER.VO.OTAPymntQueryVO;
import FCIPAY.Payroll.UTILITY.OTAPymntHeaderBean;
import FCIPAY.Payroll.EJB.business.OTAPymntBusinessObject;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpCPFSearchQueryVO;
import FCIPAY.Payroll.EJB.business.EmpCPFSearchBusinessObject;
import FCIPAY.Payroll.UTILITY.EmpCPFSearchBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpCPFSearchComboVO;

//Added by anwar on 5th July
import FCIPAY.Payroll.DATAACCESSTIER.VO.BadClmtComboVOSixPay;
import FCIPAY.Payroll.EJB.business.BadClmtAllowBusinessObjectSixPay;
import FCIPAY.Payroll.EJB.business.ResponsibilityCreationBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UsrRespComboVO;
import FCIPAY.Payroll.EJB.business.UsrRespMapBusinessObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UserRespQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UserRespDetailInfo;

public class MasterFacadeBean implements SessionBean
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
 * MAINTAIN PAY CODES
 */
  public RecordMetaInfo getPayCodeDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayCodeBusinessObject oPayCode = new PayCodeBusinessObject();
    return oPayCode.getPayCodeDetailMetaInfo(sPrimaryKey,oBaseDetailInfo);
  }

  public ArrayList getPayCodeDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayCodeBusinessObject oPayCode = new PayCodeBusinessObject();
    return oPayCode.getPayCodesDetail(sPrimaryKey,lStartPosition,lLastPosition,oBaseDetailInfo);
  }

  public String savePayCode(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayCodeBusinessObject oPayCode = new PayCodeBusinessObject();
    return oPayCode.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

/*
 * MAINTAIN PAY SCALES
 */

  public boolean savePayScaleHeader(PayScaleHeaderBean oPayScaleHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayScaleBusinessObject oPayScaleBO = new PayScaleBusinessObject();
    return oPayScaleBO.savePayScaleHeader(oPayScaleHeaderBean);
  }

  public RecordMetaInfo getPayScaleHeaderMetaInfo(MaintPayScaleQueryVO oMaintPayScaleQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayScaleBusinessObject oPayScaleBO = new PayScaleBusinessObject();
    return oPayScaleBO.getPayScaleHeaderMetaInfo(oMaintPayScaleQueryVO);
  }

  public ArrayList getPayScaleHeader(MaintPayScaleQueryVO oMaintPayScaleQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayScaleBusinessObject oPayScaleBO = new PayScaleBusinessObject();
    return oPayScaleBO.getPayScaleHeader(oMaintPayScaleQueryVO,lStartPosition,lLastPosition);
  }

  public RecordMetaInfo getPayScaleDetailMetaInfo(String sPrimaryKey,PayScaleDetailInfo oPayScaleDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayScaleBusinessObject oPayScaleBO = new PayScaleBusinessObject();
    return oPayScaleBO.getPayScaleDetailMetaInfo(sPrimaryKey,oPayScaleDetailInfo);
  }

  public ArrayList getPayScaleDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,PayScaleDetailInfo oPayScaleDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayScaleBusinessObject oPayScaleBO = new PayScaleBusinessObject();
    return oPayScaleBO.getPayScaleDetail(sPrimaryKey,lStartPosition,lLastPosition,oPayScaleDetailInfo);
  }

  public String savePayScale(PayScaleHeaderBean oPayScaleHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayScaleBusinessObject oPayScaleBO = new PayScaleBusinessObject();
    return oPayScaleBO.saveData((BaseHeaderBean)oPayScaleHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderChanged, oDetailBeanArray, bDetailChanged, oDetailPicked);
  }

  public LovVO getPayScaleLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayScaleBusinessObject oPayScale = new PayScaleBusinessObject();
    LovVO oLovVO=oPayScale.getPayScaleLOVData(oLovQueryVO);
    return oLovVO;
  }
  
  public LovVO getPayScaleCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayScaleBusinessObject oPayScale = new PayScaleBusinessObject();
    LovVO oLovVO=oPayScale.getPayScaleCodeLOVData(oLovQueryVO);
    return oLovVO;
  }

/*
 * MAINTAIN DA RATES
 */

  public RecordMetaInfo getDARateHeaderMetaInfo(MaintDaRatesQueryVO oMaintDaRatesQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DARatesBusinessObject oDARates = new DARatesBusinessObject();
    return oDARates.getDARatesHeaderMetaInfo(oMaintDaRatesQueryVO);
  }

  public ArrayList getDARateHeader(MaintDaRatesQueryVO oMaintDaRatesQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DARatesBusinessObject oDARates = new DARatesBusinessObject();
    return oDARates.getDARatesHeader(oMaintDaRatesQueryVO,lStartPosition,lLastPosition);
  }

  public ArrayList getDARateDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,DARatesDetailInfo oDARatesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DARatesBusinessObject oDARates = new DARatesBusinessObject();
    return oDARates.getDARatesDetail(sPrimaryKey,lStartPosition,lLastPosition,oDARatesDetailInfo);
  }

  public RecordMetaInfo getDARateDetailMetaInfo(String sPrimaryKey,DARatesDetailInfo oDARatesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DARatesBusinessObject oDARates = new DARatesBusinessObject();
    return oDARates.getDARatesDetailMetaInfo(sPrimaryKey,oDARatesDetailInfo);
  }

  public String saveDARate(MaintDARatesHeaderBean oMaintDARatesHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DARatesBusinessObject oDARates = new DARatesBusinessObject();
    return oDARates.saveData((BaseHeaderBean)oMaintDARatesHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  public LovVO getDARateLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    DARatesBusinessObject oDARate = new DARatesBusinessObject();
    LovVO oLovVO=oDARate.getDARateLOVData(oLovQueryVO);
    return oLovVO;
  }

/*
 * MAINTAIN PAY CODES VS NATURAL ACCOUNT CODE
 */

 public RecordMetaInfo getPayAcctDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayAcctBusinessObject oPayAcct = new PayAcctBusinessObject();
    return oPayAcct.getPayAcctDetailMetaInfo(sPrimaryKey);
  }

  public ArrayList getPayAcctDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayAcctBusinessObject oPayAcct = new PayAcctBusinessObject();
    return oPayAcct.getPayAcctDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }

 public String savePayAcct(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayAcctBusinessObject oPayAcct = new PayAcctBusinessObject();
    return oPayAcct.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  public LovVO getPayacctPayCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayAcctBusinessObject oPayAcct = new PayAcctBusinessObject();
    LovVO oLovVO=oPayAcct.getPayacctPayCodeLOVDataQ(oLovQueryVO);
    return oLovVO;
  }

  public LovVO getPayacctPayCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayAcctBusinessObject oPayAcct = new PayAcctBusinessObject();
    LovVO oLovVO=oPayAcct.getPayacctPayCodeLOVDataN(oLovQueryVO);
    return oLovVO;
  }

  public LovVO getPayAcctAgencyLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayAcctBusinessObject oPayAcct = new PayAcctBusinessObject();
    LovVO oLovVO=oPayAcct.getPayAcctAgencyLOVDataQ(oLovQueryVO);
    return oLovVO;
  }

  public LovVO getPayAcctAgencyLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayAcctBusinessObject oPayAcct = new PayAcctBusinessObject();
    LovVO oLovVO=oPayAcct.getPayAcctAgencyLOVDataN(oLovQueryVO);
    return oLovVO;
  }
  
  public LovVO getPayacctAcctCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayAcctBusinessObject oPayAcct = new PayAcctBusinessObject();
    LovVO oLovVO=oPayAcct.getPayacctAcctCodeLOVDataQ(oLovQueryVO);
    return oLovVO;
  }

  public LovVO getPayacctAcctCodeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayAcctBusinessObject oPayAcct = new PayAcctBusinessObject();
    LovVO oLovVO=oPayAcct.getPayacctAcctCodeLOVDataN(oLovQueryVO);
    return oLovVO;
  }

/*
 * MAINTAIN CCA RATES
 */

  public RecordMetaInfo getCCARateAllDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CCARateBusinessObject oCCARate = new CCARateBusinessObject();
    return oCCARate.getCCARateAllDetailMetaInfo(sPrimaryKey,(CCARatesDetailInfo)oBaseDetailInfo);
  }

  public ArrayList getCCARateAllDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CCARateBusinessObject oCCARate = new CCARateBusinessObject();
    return oCCARate.getCCARateAllDetail(sPrimaryKey,lStartPosition,lLastPosition,(CCARatesDetailInfo)oBaseDetailInfo);
  }

  public String saveCCARate(CCARatesHeaderBean oCCARatesHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CCARateBusinessObject oCCARate = new CCARateBusinessObject();
    return oCCARate.saveData((BaseHeaderBean)oCCARatesHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  public CCAComboVO getCCARateComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CCARateBusinessObject oCCARateBusinessObject = new CCARateBusinessObject();
    return oCCARateBusinessObject.getCCARateComboDetails();
  }

  public RecordMetaInfo getCCARateHeaderMetaInfo(CCARatesQueryVO oCCARatesQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CCARateBusinessObject oCCARateBusinessObject = new CCARateBusinessObject();
    return oCCARateBusinessObject.getCCARateHeaderMetaInfo(oCCARatesQueryVO);
  }

  public ArrayList getCCARateHeader(CCARatesQueryVO oCCARatesQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CCARateBusinessObject oCCARateBusinessObject = new CCARateBusinessObject();
    return oCCARateBusinessObject.getCCARateHeader(oCCARatesQueryVO,lStartPosition,lLastPosition);
  }


/*
 * MAINTAIN HRA RATES
 */

 public RecordMetaInfo getHraDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HraBusinessObject oHraRate = new HraBusinessObject();
    return oHraRate.getHraDetailMetaInfo(sPrimaryKey);
  }

  public ArrayList getHraDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HraBusinessObject oHraRate = new HraBusinessObject();
    return oHraRate.getHraDetails(sPrimaryKey,lStartPosition,lLastPosition);
  }

  public String saveHraDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HraBusinessObject oHraRate = new HraBusinessObject();
    return oHraRate.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);

  }

 public HraComboVO getHRARateComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HraBusinessObject oHraBusinessObject = new HraBusinessObject();
    return oHraBusinessObject.getHRARateComboDetails();
  }
  

/*
 * MAINTAIN CONVEYANCE ALLOWANCE
 */

  public RecordMetaInfo getCovnAllowHeaderMetaInfo(ConvAllowQueryVO oConvAllowQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ConvAllowBusinessObject oConvAllowAll = new ConvAllowBusinessObject();
    return oConvAllowAll.getConvAllowHeaderMetaInfo(oConvAllowQueryVO);
  }

  public ArrayList getStdDednHeader(ConvAllowQueryVO oConvAllowQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ConvAllowBusinessObject oConvAllowAll = new ConvAllowBusinessObject();
    return oConvAllowAll.getConvAllowHeader(oConvAllowQueryVO,lStartPosition,lLastPosition);
  }

  public RecordMetaInfo getConvAllowAllDetailMetaInfo(String sPrimaryKey, ConvAllowDetailInfo oConvAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ConvAllowBusinessObject oConvAllowAll = new ConvAllowBusinessObject();
    return oConvAllowAll.getConvAllowAllDetailMetaInfo(sPrimaryKey, oConvAllowDetailInfo);
  }

  public ArrayList getConvAllowAllDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, ConvAllowDetailInfo oConvAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ConvAllowBusinessObject oConvAllowAll = new ConvAllowBusinessObject();
    return oConvAllowAll.getConvAllowAllDetail(sPrimaryKey,lStartPosition,lLastPosition, oConvAllowDetailInfo);
  }

  public String saveConvAllow(ConvAllowHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ConvAllowBusinessObject oConvAllowAll = new ConvAllowBusinessObject();
    return oConvAllowAll.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  public ConvAllowComboVO getConvAllowComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ConvAllowBusinessObject oConvAllowAll = new ConvAllowBusinessObject();
    return oConvAllowAll.getConvAllowComboDetails();
  }

  public RecordMetaInfo getConvAllowHeaderMetaInfo(ConvAllowQueryVO oConvAllowQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ConvAllowBusinessObject oConvAllowAll = new ConvAllowBusinessObject();
    return oConvAllowAll.getConvAllowHeaderMetaInfo(oConvAllowQueryVO);
  }

  public ArrayList getConvAllowHeader(ConvAllowQueryVO oConvAllowQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ConvAllowBusinessObject oConvAllowAll = new ConvAllowBusinessObject();
    return oConvAllowAll.getConvAllowHeader(oConvAllowQueryVO,lStartPosition,lLastPosition);
  }

/*
 * MAINTAIN GIS RATES
 */

 public RecordMetaInfo getGISRatesDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    GISRatesBusinessObject oGISRates = new GISRatesBusinessObject();
    return oGISRates.getGISRatesDetailMetaInfo(sPrimaryKey);
  }

  public ArrayList getGISRatesDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    GISRatesBusinessObject oGISRates = new GISRatesBusinessObject();
    return oGISRates.getGISRatesDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }

  public String saveGISRates(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    GISRatesBusinessObject oGISRates = new GISRatesBusinessObject();
    return oGISRates.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  public GISComboVO getDetailGISComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    GISRatesBusinessObject oGISRates = new GISRatesBusinessObject();
    return oGISRates.getDetailGISComboDetails();
  }

/*
 * MAINTAIN MISC ALLOWANCE
 */

  public RecordMetaInfo getMiscAllowRatesDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscAllowBusinessObject oMiscRates = new MiscAllowBusinessObject();
    return oMiscRates.getMiscAllowRatesDetailMetaInfo(sPrimaryKey);
  }

  public ArrayList getMiscAllowRatesDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscAllowBusinessObject oMiscRates = new MiscAllowBusinessObject();
    return oMiscRates.getMiscAllowRatesDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }

  public String saveMiscAllowRates(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscAllowBusinessObject oMiscRates = new MiscAllowBusinessObject();
    return oMiscRates.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  public LovVO getMiscAllowPayLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscAllowBusinessObject oMiscAllow = new MiscAllowBusinessObject();
    LovVO oLovVO=oMiscAllow.getMiscAllowPayLOVDataQ(oLovQueryVO);
    return oLovVO;
  }

  public LovVO getMiscAllowPayScaleLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscAllowBusinessObject oMiscAllow = new MiscAllowBusinessObject();
    LovVO oLovVO=oMiscAllow.getMiscAllowPayScaleLOVDataQ(oLovQueryVO);
    return oLovVO;
  }


/*
 * MAINTAIN MISC PARAMETERS
 */

  public MiscComboVO getMiscComboDetails()  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscParamBusinessObject oMiscParamBusinessObject = new MiscParamBusinessObject();
    return oMiscParamBusinessObject.getMiscComboDetails();
  }

//  For Medical Health Scheme Tab

  public ArrayList getMHSDedDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscParamBusinessObject oMHSDed = new MiscParamBusinessObject();
    return oMHSDed.getMHSDedDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }
  public RecordMetaInfo getMHSDedDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscParamBusinessObject oMHSDed = new MiscParamBusinessObject();
    return oMHSDed.getMHSDedDetailMetaInfo(sPrimaryKey);
  }
  public String saveMHSDed(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscParamBusinessObject oMHSDed = new MiscParamBusinessObject();
    return oMHSDed.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

//    For Other Parameter

  public RecordMetaInfo getOtherDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscParamBusinessObject oTher = new MiscParamBusinessObject();
    return oTher.getOtherDetailMetaInfo(sPrimaryKey);
  }

  public ArrayList getOtherDetail(String sPrimaryKey,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscParamBusinessObject oTher = new MiscParamBusinessObject();
    return oTher.getOtherDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }

  public String saveOther(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscParamBusinessObject oTher = new MiscParamBusinessObject();
    return oTher.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

/*
 * MAINTAIN TAX PARAM
 */

//TaxParamIncome
  public boolean saveTaxParamIncomeHeader(TaxParamHeaderBean oTaxParamHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamIncomeBusinessObject oTaxParamBO = new TaxParamIncomeBusinessObject();
    return oTaxParamBO.saveIncTaxHeader(oTaxParamHeaderBean);
  }

  public RecordMetaInfo getTaxParamIncomeHeaderMetaInfo(TaxParamQueryVO oTaxParamQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamIncomeBusinessObject oTaxParamBO = new TaxParamIncomeBusinessObject();
    return oTaxParamBO.getTaxParamHeaderMetaInfo(oTaxParamQueryVO);
  }

  public ArrayList getTaxParamIncomeHeader(TaxParamQueryVO oTaxParamQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamIncomeBusinessObject oTaxParamBO = new TaxParamIncomeBusinessObject();
    return oTaxParamBO.getTaxParamHeader(oTaxParamQueryVO,lStartPosition,lLastPosition);
  }

  public RecordMetaInfo getTaxParamIncomeDetailMetaInfo(String sRevyear) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamIncomeBusinessObject oTaxParamBO = new TaxParamIncomeBusinessObject();
    return oTaxParamBO.getIncTaxDetailMetaInfo(sRevyear);
  }

  public ArrayList getTaxParamIncomeDetail(String sRevYear, long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamIncomeBusinessObject oTaxParamBO = new TaxParamIncomeBusinessObject();
    return oTaxParamBO.getIncTaxDetail(sRevYear, lStartPosition,lLastPosition);
  }

  public String saveTaxParamIncome(TaxParamHeaderBean oTaxParamHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamIncomeBusinessObject oTaxParamBO = new TaxParamIncomeBusinessObject();
    return oTaxParamBO.saveData((BaseHeaderBean)oTaxParamHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderChanged, oDetailBeanArray, bDetailChanged, oDetailPicked);
  }

//TaxParamStdDedn
  public boolean saveStdDednHeader(StdDednHeaderBean oStdDednHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamStdDedBusinessObject oStdDednBO = new TaxParamStdDedBusinessObject();
    return oStdDednBO.saveStdDednHeader(oStdDednHeaderBean);
  }

  public RecordMetaInfo getStdDednHeaderMetaInfo(StdDednQueryVO oStdDednQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamStdDedBusinessObject oStdDednBO = new TaxParamStdDedBusinessObject();
    return oStdDednBO.getStdDednHeaderMetaInfo(oStdDednQueryVO);
  }

  public ArrayList getStdDednHeader(StdDednQueryVO oStdDednQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamStdDedBusinessObject oStdDednBO = new TaxParamStdDedBusinessObject();
    return oStdDednBO.getStdDednHeader(oStdDednQueryVO,lStartPosition,lLastPosition);
  }

  public RecordMetaInfo getStdDednDetailMetaInfo(String sRevyear) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamStdDedBusinessObject oStdDednBO = new TaxParamStdDedBusinessObject();
    return oStdDednBO.getStdDednDetailMetaInfo(sRevyear);
  }

  public ArrayList getStdDednDetail(String sRevYear, long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamStdDedBusinessObject oStdDednBO = new TaxParamStdDedBusinessObject();
    return oStdDednBO.getStdDednDetail(sRevYear, lStartPosition,lLastPosition);
  }

  public String saveStdDedn(StdDednHeaderBean oStdDednHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamStdDedBusinessObject oStdDednBO = new TaxParamStdDedBusinessObject();
    return oStdDednBO.saveData((BaseHeaderBean)oStdDednHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderChanged, oDetailBeanArray, bDetailChanged, oDetailPicked);
  }

//TaxParamProfTax
  public boolean saveProfTaxHeader(ProfTaxHeaderBean oProfTaxHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamProfTaxBusinessObject oProfTaxBO = new TaxParamProfTaxBusinessObject();
    return oProfTaxBO.saveProfTaxHeader(oProfTaxHeaderBean);
  }

  public RecordMetaInfo getProfTaxHeaderMetaInfo(ProfTaxQueryVO oProfTaxQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamProfTaxBusinessObject oProfTaxBO = new TaxParamProfTaxBusinessObject();
    return oProfTaxBO.getProfTaxHeaderMetaInfo(oProfTaxQueryVO);
  }

  public ArrayList getProfTaxHeader(ProfTaxQueryVO oProfTaxQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamProfTaxBusinessObject oProfTaxBO = new TaxParamProfTaxBusinessObject();
    return oProfTaxBO.getProfTaxHeader(oProfTaxQueryVO,lStartPosition,lLastPosition);
  }

  public RecordMetaInfo getProfTaxDetailMetaInfo(String sPrimaryKey, ProfTaxDetailInfo oProfTaxDetailInfo ) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamProfTaxBusinessObject oProfTaxBO = new TaxParamProfTaxBusinessObject();
    return oProfTaxBO.getProfTaxDetailMetaInfo(sPrimaryKey,oProfTaxDetailInfo );
  }

  public ArrayList getProfTaxDetail(String sPrimaryKey, long lStartPosition,long lLastPosition, ProfTaxDetailInfo oProfTaxDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamProfTaxBusinessObject oProfTaxBO = new TaxParamProfTaxBusinessObject();
    return oProfTaxBO.getProfTaxDetail(sPrimaryKey, lStartPosition,lLastPosition, oProfTaxDetailInfo );
  }

  public String saveProfTax(ProfTaxHeaderBean oProfTaxHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamProfTaxBusinessObject oProfTaxBO = new TaxParamProfTaxBusinessObject();
    return oProfTaxBO.saveData((BaseHeaderBean)oProfTaxHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderChanged, oDetailBeanArray, bDetailChanged, oDetailPicked);
  }

// Tax Parameter Other Information
  public RecordMetaInfo getOtherTaxHeaderMetaInfo(TaxParamOtherQueryVO oTaxParamOtherQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamOtherBusinessObject oTaxParamBO = new TaxParamOtherBusinessObject();
    return oTaxParamBO.getTaxParamOtherHeaderMetaInfo(oTaxParamOtherQueryVO);
  }

  public ArrayList getOtherTaxHeader(TaxParamOtherQueryVO oTaxParamOtherQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamOtherBusinessObject oTaxParamBO = new TaxParamOtherBusinessObject();
    return oTaxParamBO.getTaxParamHeader(oTaxParamOtherQueryVO,lStartPosition,lLastPosition);
  }

  public String saveTaxParamOther(TaxParamOtherHeaderBean oTaxParamOtherHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamOtherBusinessObject oTaxParamBO = new TaxParamOtherBusinessObject();
    return oTaxParamBO.saveData((BaseHeaderBean)oTaxParamOtherHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

 public LovVO getIncTaxLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamIncomeBusinessObject oTaxParamIncome = new TaxParamIncomeBusinessObject();
    LovVO oLovVO=oTaxParamIncome.getIncTaxLOVData(oLovQueryVO);
     return oLovVO;
  }

  public LovVO getProfTaxLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamProfTaxBusinessObject oTaxParamIncome = new TaxParamProfTaxBusinessObject();
    LovVO oLovVO=oTaxParamIncome.getProfTaxLOVData(oLovQueryVO);
     return oLovVO;
  }

  public LovVO getStdDednLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamStdDedBusinessObject oTaxParamIncome = new TaxParamStdDedBusinessObject();
    LovVO oLovVO=oTaxParamIncome.getStdDednLOVData(oLovQueryVO);
     return oLovVO;
  }

  public LovVO getProfTaxStatecodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamProfTaxBusinessObject oTaxParamProfTaxBusinessObject = new TaxParamProfTaxBusinessObject();
    LovVO oLovVO=oTaxParamProfTaxBusinessObject.getProfTaxStatecodeLOVData(oLovQueryVO);
    return oLovVO;
  }

  public LovVO getOtherYYMMLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TaxParamOtherBusinessObject oTaxParamOtherBusinessObject = new TaxParamOtherBusinessObject();
    LovVO oLovVO=oTaxParamOtherBusinessObject.getOtherYYMMLOVData(oLovQueryVO);
    return oLovVO;
  }

 ////////// PFInterestRate

  public RecordMetaInfo getInterestRateHeaderMetaInfo(MaintInterestRateQueryVO oMaintInterestRateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    InrRateBusinessObject oInrRate = new InrRateBusinessObject();
    return oInrRate.getInterestRateHeaderMetaInfo(oMaintInterestRateQueryVO);
  }

  public ArrayList getInterestRateHeader(MaintInterestRateQueryVO oMaintInterestRateQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    InrRateBusinessObject oInrRate = new InrRateBusinessObject();
    return oInrRate.getInterestRateHeader(oMaintInterestRateQueryVO,lStartPosition,lLastPosition);
  }

  public ArrayList getInterestRateDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,InrRateDetailInfo oInrRateDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    InrRateBusinessObject oInrRate = new InrRateBusinessObject();
    return oInrRate.getInterestRateDetails(sPrimaryKey,lStartPosition,lLastPosition,oInrRateDetailInfo);
  }

  public RecordMetaInfo getInterestRateDetailMetaInfo(String sPrimaryKey,InrRateDetailInfo oInrRateDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    InrRateBusinessObject oInrRate = new InrRateBusinessObject();
    return oInrRate.getInterestRateDetailMetaInfo(sPrimaryKey,oInrRateDetailInfo);
  }

  public String saveInterestRate(MaintInrRateHeaderBean oMaintInrRateHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    InrRateBusinessObject oInrRate = new InrRateBusinessObject();
    return oInrRate.saveData((BaseHeaderBean)oMaintInrRateHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  ////////// Maintain Interest Rate
  public RecordMetaInfo getIntRateHeaderMetaInfo(IntRateQueryVO oIntRateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IntRateBusinessObject oIntRateBusinessObject = new IntRateBusinessObject();
    return oIntRateBusinessObject.getIntRateHeaderMetaInfo(oIntRateQueryVO);
  }
  public ArrayList getIntRateHeader(IntRateQueryVO oIntRateQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IntRateBusinessObject oIntRateBusinessObject = new IntRateBusinessObject();
    return oIntRateBusinessObject.getIntRateHeader(oIntRateQueryVO, lStartPosition, lLastPosition);
  }
  public ArrayList getIntRateDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IntRateBusinessObject oIntRateBusinessObject = new IntRateBusinessObject();
    return oIntRateBusinessObject.getIntRateDetails(sPrimaryKey, lStartPosition, lLastPosition,(IntRateDetailInfo)oBaseDetailInfo);
  }
  public RecordMetaInfo getIntRateDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IntRateBusinessObject oIntRateBusinessObject = new IntRateBusinessObject();
    return oIntRateBusinessObject.getIntRateDetailMetaInfo(sPrimaryKey,(IntRateDetailInfo)oBaseDetailInfo);
  }
  public String saveIntRate(IntRateHeaderBean oIntRateHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IntRateBusinessObject oIntRateBusinessObject = new IntRateBusinessObject();
    return oIntRateBusinessObject.saveData(oIntRateHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged,oDetailBeanArray, bDetailDataChanged,  oDetailPicked);

  }
  public LovVO getLoanTypeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IntRateBusinessObject oIntRateBusinessObject = new IntRateBusinessObject();
    return oIntRateBusinessObject.getLoanTypeLOVDataQ(oLovQueryVO);
  }
  public LovVO getLoanTypeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    IntRateBusinessObject oIntRateBusinessObject = new IntRateBusinessObject();
    return oIntRateBusinessObject.getLoanTypeLOVDataN(oLovQueryVO);
  }
  
  ////////// Maintain BankMaster
  public RecordMetaInfo getBankHeaderMetaInfo(MaintBankMastQueryVO oMaintBankMastQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BankMastBusinessObject oBankMastBusinessObject = new BankMastBusinessObject();
    return oBankMastBusinessObject.getBankMastHeaderMetaInfo(oMaintBankMastQueryVO);
  }
  public ArrayList getBankMasterHeader(MaintBankMastQueryVO oMaintBankMastQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BankMastBusinessObject oBankMastBusinessObject = new BankMastBusinessObject();
    return oBankMastBusinessObject.getBankMastHeader(oMaintBankMastQueryVO, lStartPosition, lLastPosition);
  }
  public ArrayList getBankMasterDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BankMastDetailInfo oBankMastDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BankMastBusinessObject oBankMastBusinessObject = new BankMastBusinessObject();
    return oBankMastBusinessObject.getBankMasterDetails(sPrimaryKey, lStartPosition, lLastPosition, oBankMastDetailInfo);
  }
  public RecordMetaInfo getBankMasterDetailMetaInfo(String sPrimaryKey,BankMastDetailInfo oBankMastDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BankMastBusinessObject oBankMastBusinessObject = new BankMastBusinessObject();
    return oBankMastBusinessObject.getBankMasterDetailMetaInfo(sPrimaryKey, oBankMastDetailInfo);
  }
  public String saveBankDetail(MaintBankMastHeaderBean oMaintBankMastHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BankMastBusinessObject oBankMastBusinessObject = new BankMastBusinessObject();
    return oBankMastBusinessObject.saveData(oMaintBankMastHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged,oDetailBeanArray, bDetailDataChanged,  oDetailPicked);

  }
  public LovVO getBankCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BankMastBusinessObject oBankMastBusinessObject = new BankMastBusinessObject();
    return oBankMastBusinessObject.getBankCodeLOVDataQ(oLovQueryVO);
  }


  public RecordMetaInfo getLoanMstHeaderMetaInfo(MaintLoanMstQueryVO oMaintLoanMstQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LoanMasterBusinessObject oLoanMasterBusinessObject = new LoanMasterBusinessObject();
    return oLoanMasterBusinessObject.getLoanMstHeaderMetaInfo(oMaintLoanMstQueryVO);
  }

  public ArrayList getLoanMstHeader(MaintLoanMstQueryVO oMaintLoanMstQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LoanMasterBusinessObject oLoanMasterBusinessObject = new LoanMasterBusinessObject();
    return oLoanMasterBusinessObject.getLoanMstHeader(oMaintLoanMstQueryVO,lStartPosition,lLastPosition);
  }

  public String saveLoanMaster(MaintLoanMasterHdrBean oMaintLoanMasterHdrBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
     LoanMasterBusinessObject oLoanMasterBusinessObject = new LoanMasterBusinessObject();
    return oLoanMasterBusinessObject.saveData((BaseHeaderBean)oMaintLoanMasterHdrBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

 public LovVO getQueryEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
     LoanMasterBusinessObject oLoanMasterBusinessObject = new LoanMasterBusinessObject();
    LovVO oLovVO=oLoanMasterBusinessObject.getQueryEmpLOVData(oLovQueryVO);
    return oLovVO;
  }


  public LovVO getLoanMasterLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
     LoanMasterBusinessObject oLoanMasterBusinessObject = new LoanMasterBusinessObject();
    LovVO oLovVO=oLoanMasterBusinessObject.getLoanMasterLOVDataQ(oLovQueryVO);
    return oLovVO;
  }

//////////////////////////////////////////////SITE DETAIL///////////////////////////////////////////

/*
 * Created By Balpreet Kaur
 * Dated July 2007
 *
 *  To get the location Details Meta info for Location Master.
 */
  public RecordMetaInfo getSiteDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SiteDetailBusinessObject oSite = new SiteDetailBusinessObject();
    return oSite.getSiteDetailMetaInfo(sPrimaryKey);
  }

/*
 * Created By Balpreet Kaur
 * Dated July 2007
 *
 *  To get the Location Details in Location Master.
 */
  public ArrayList getSiteDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SiteDetailBusinessObject oSite = new SiteDetailBusinessObject();
    return oSite.getSiteDetails(sPrimaryKey,lStartPosition,lLastPosition);
  }

/*
 * Created By Balpreet Kaur
 * Dated July 2007
 *
 * To Save the location Details in Location Master.
 */
  public String saveSiteDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SiteDetailBusinessObject oSite = new SiteDetailBusinessObject();
    return oSite.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

/*
 * Created By Balpreet Kaur
 * Dated July 2007
 *
 * To Fetch the LOV Data for Location (used in Labour Screens).
 */
  public LovVO getSiteLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SiteDetailBusinessObject oSite = new SiteDetailBusinessObject();
    LovVO oLovVO=oSite.getSiteLOVDataQ(oLovQueryVO);
    return oLovVO;
  }

/*
 * Created By Balpreet Kaur
 * Dated July 2007
 *
 * To fetch the Combo details of Location Types in Location Master.
 */
  public SiteTypeComboVO getLocTypesComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SiteDetailBusinessObject oSite = new SiteDetailBusinessObject();
    SiteTypeComboVO oSiteTypeComboVO=oSite.getLocTypesComboDetails();
    return oSiteTypeComboVO;
  }

/*
 * Created By Balpreet Kaur
 * Dated July 2007
 *
 * To get the LOV data of Parent Locations in Location Master.
 */
  public LovVO getLocTypLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SiteDetailBusinessObject oSite = new SiteDetailBusinessObject();
    LovVO oLovVO=oSite.getLocTypLOVData(oLovQueryVO);
    return oLovVO;
  }

/*
 * Created By Balpreet Kaur
 * Dated 19 Nov 2007
 *
 * To get the LOV data of States Location Master.
 */
  public LovVO getStateLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SiteDetailBusinessObject oSite = new SiteDetailBusinessObject();
    LovVO oLovVO=oSite.getStateLOVData(oLovQueryVO);
    return oLovVO;
  }

////////////////////////////// DESIGNATION DETAILS////////////////////////
/*
 * Created By Balpreet Kaur
 * Dated 6 Aug 2007
 *
 *  To Get the combo details for Employee Category in Designation Master.
 */
  public DsgnComboVO getDsgnComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MaintDsgnBusinessObject oDsgn = new MaintDsgnBusinessObject();
    DsgnComboVO oDsgnComboVO=oDsgn.getDsgnComboDetails();
    return oDsgnComboVO;
  }



  
  
/*
 * Created By Balpreet Kaur
 * Dated 6 Aug 2007
 *
 *  To Get the designation detail meta info for Designation Master.
 */
  public RecordMetaInfo getDsgnDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MaintDsgnBusinessObject oDsgn = new MaintDsgnBusinessObject();
    return oDsgn.getDsgnDetailMetaInfo(sPrimaryKey);
  }

/*
 * Created By Balpreet Kaur
 * Dated 6 Aug 2007
 *
 *  To Get the designation details for Designation Master.
 */
  public ArrayList getDsgnDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MaintDsgnBusinessObject oDsgn = new MaintDsgnBusinessObject();
    return oDsgn.getDsgnDetails(sPrimaryKey,lStartPosition,lLastPosition);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 6 Aug 2007
 *
 *  To Save the designation details in Designation Master.
 */
  public String saveDsgnDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MaintDsgnBusinessObject oDsgn = new MaintDsgnBusinessObject();
    return oDsgn.saveData(oDummyHeaderBean,oWhenPicked,sScreenName,sScreenMode,bHeaderDataChanged,oDetailBeanArray,bDetailDataChanged,oDetailPicked);
  }

 /*
 * Created By Balpreet Kaur
 * Dated 7 Aug 2007
 *
 *  To Get the LOV for Pay Scale Code.
 */
  public LovVO getDsgnPayScaleCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MaintDsgnBusinessObject oDsgn = new MaintDsgnBusinessObject();
    LovVO oLovVO=oDsgn.getPayScaleCodeLOVData(oLovQueryVO);
    return oLovVO;
  }




// added by devendra start
public ArrayList get6PayDsgnDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    Maint6PayDsgnBusinessObject oDsgn = new Maint6PayDsgnBusinessObject();
    return oDsgn.get6PayDsgnDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }


  public String save6PayDsgnDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    Maint6PayDsgnBusinessObject oDsgn = new Maint6PayDsgnBusinessObject();
    return oDsgn.saveData(oDummyHeaderBean,oWhenPicked,sScreenName,sScreenMode,bHeaderDataChanged,oDetailBeanArray,bDetailDataChanged,oDetailPicked);
  }


  public LovVO getDsgn6PayScaleCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    Maint6PayDsgnBusinessObject oDsgn = new Maint6PayDsgnBusinessObject();
    LovVO oLovVO=oDsgn.getPayScaleCodeLOVData(oLovQueryVO);
    return oLovVO;
  }


public DsgnComboVO get6PayEmpCtgryDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    Maint6PayDsgnBusinessObject oDsgn = new Maint6PayDsgnBusinessObject();
    DsgnComboVO oDsgnComboVO=oDsgn.get6PayEmpCtgryDetails();
    return oDsgnComboVO;
  }
  
  public DsgnComboVO get6PayDsgnComboPayScaleDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    Maint6PayDsgnBusinessObject oDsgn = new Maint6PayDsgnBusinessObject();
    DsgnComboVO oDsgnComboVO=oDsgn.get6PayDsgnComboPayScaleDetails();
    return oDsgnComboVO;
  }
  
  public DsgnComboVO get6PayDsgnComboPayBandDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
    Maint6PayDsgnBusinessObject oDsgn = new Maint6PayDsgnBusinessObject();
    DsgnComboVO oDsgnComboVO=oDsgn.get6PayDsgnComboPayBandDetails();
    return oDsgnComboVO;
  }
  
  public LovVO getDsgn6PayBandCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    Maint6PayDsgnBusinessObject oDsgn = new Maint6PayDsgnBusinessObject();
    LovVO oLovVO=oDsgn.getDsgn6PayBandCodeLOVData(oLovQueryVO);
    return oLovVO;
  }
  
// added by devendra end




  /*
  * Created By Balpreet
  * Dated 26 Sep 2007
  *
  *  To Get Hill Compensatory Allowance Detail Meta Info
  */
  public RecordMetaInfo getHillCmpnstryDetailMetaInfo(String sPrimaryKey,MaintHillCmpnstryAllowDetailInfo oMaintHillCmpnstryAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HillCmpnstryAllowBusinessObject oHillCmpnstry = new HillCmpnstryAllowBusinessObject();
    return oHillCmpnstry.getHillCmnstryDetailMetaInfo(sPrimaryKey,oMaintHillCmpnstryAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 26 Sep 2007
  *
  *  To Get Hill Compensatory Allowance Detail.
  */
  public ArrayList getHillCmpnstryDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintHillCmpnstryAllowDetailInfo oMaintHillCmpnstryAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HillCmpnstryAllowBusinessObject oHillCmpnstry = new HillCmpnstryAllowBusinessObject();
    return oHillCmpnstry.getHillCmpnstryDetail(sPrimaryKey,lStartPosition,lLastPosition,oMaintHillCmpnstryAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 26 Sep 2007
  *
  *  To Save Hill Compensatory Allowance Detail.
  */
  public String saveHillCmpnstryDetail(HillCmpnstryAllowHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HillCmpnstryAllowBusinessObject oHillCmpnstry = new HillCmpnstryAllowBusinessObject();
    return oHillCmpnstry.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  /*
  * Created By Balpreet
  * Dated 26 Sep 2007
  *
  *  To Get Hill Compensatory Allowance Combo Detail.
  */
  public HillCmpnstryComboVO getHillCmpnstryComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HillCmpnstryAllowBusinessObject oHillCmpnstry = new HillCmpnstryAllowBusinessObject();
    return oHillCmpnstry.getHillCmpnstryComboDetails();
  }
  
  /*
  * Created By Balpreet
  * Dated 20 Dec 2007
  *
  *  To Get Hill compensatory Allowance Header Meta Info.
  */

  public RecordMetaInfo getHillCmpnstryHeaderMetaImpl(HillCmpnstryAllowQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HillCmpnstryAllowBusinessObject oHillCmpnstry = new HillCmpnstryAllowBusinessObject();
    return oHillCmpnstry.getHillCmpnstryAllowHeaderMetaInfo(oBaseQueryVO);
  }

  /*
  * Created By Balpreet
  * Dated 20 Dec 2007
  *
  *  To Get Hill Compensatory Allowance Header.
  */
  public ArrayList getHillCmpnstryHeaderRecord(HillCmpnstryAllowQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    HillCmpnstryAllowBusinessObject oHillCmpnstry = new HillCmpnstryAllowBusinessObject();
    return oHillCmpnstry.getHillCmpnstryAllowHeader(oBaseQueryVO,lStartPosition,lLastPosition);
  }


  /*
  * Created By Balpreet
  * Dated 1 Oct 2007
  *
  *  To Get Bad Climate Allowance Detail Meta Info
  */
  public RecordMetaInfo getBadClmtDetailMetaInfo(String sPrimaryKey,MaintBadClmtAllowDetailInfo oMaintBadClmtAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BadClmtAllowBusinessObject oBadClmt = new BadClmtAllowBusinessObject();
    return oBadClmt.getBadClmtDetailMetaInfo(sPrimaryKey,oMaintBadClmtAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 1 Oct 2007
  *
  *  To Get Bad Climate Allowance Detail.
  */
  public ArrayList getBadClmtDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintBadClmtAllowDetailInfo oMaintBadClmtAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BadClmtAllowBusinessObject oBadClmt = new BadClmtAllowBusinessObject();
    return oBadClmt.getBadClmtDetail(sPrimaryKey,lStartPosition,lLastPosition,oMaintBadClmtAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 1 Oct 2007
  *
  *  To Save Bad Climate Allowance Detail.
  */
  public String saveBadClmtDetail(MaintBadClmtAllowHeaderBean oMaintBadClmtAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BadClmtAllowBusinessObject oBadClmt = new BadClmtAllowBusinessObject();
    return oBadClmt.saveData((BaseHeaderBean)oMaintBadClmtAllowHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  /*
  * Created By Balpreet
  * Dated 1 Oct 2007
  *
  *  To Get Bad Climate Allowance Combo Detail.
  */
  public BadClmtComboVO getBadClmtComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BadClmtAllowBusinessObject oBadClmt = new BadClmtAllowBusinessObject();
    return oBadClmt.getBadClmtComboDetails();
  }

  /*
  * Created By Balpreet
  * Dated 12 Dec 2007
  *
  *  To Get Bad Climate Allowance Header Meta Info.
  */

  public RecordMetaInfo getBadClmtHeaderMetaImpl(BadClmtQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BadClmtAllowBusinessObject oBadClmt = new BadClmtAllowBusinessObject();
    return oBadClmt.getBadClmtAllowHeaderMetaInfo(oBaseQueryVO);
  }

  /*
  * Created By Balpreet
  * Dated 12 Dec 2007
  *
  *  To Get Bad Climate Allowance Header.
  */
  public ArrayList getBadClmtHeaderRecord(BadClmtQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BadClmtAllowBusinessObject oBadClmt = new BadClmtAllowBusinessObject();
    return oBadClmt.getBadClmtAllowHeader(oBaseQueryVO,lStartPosition,lLastPosition);
  }

  /*
  * Created By Balpreet
  * Dated 4 Oct 2007
  *
  *  To Get Tribal Area Allowance Detail Meta Info
  */
  public RecordMetaInfo getTrblAreaDetailMetaInfo(String sPrimaryKey,MaintTrblAreaAllowDetailInfo oMaintTrblAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TrblAreaAllowBusinessObject oTrblArea = new TrblAreaAllowBusinessObject();
    return oTrblArea.getTrblAreaDetailMetaInfo(sPrimaryKey,oMaintTrblAreaAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 4 Oct 2007
  *
  *  To Get Tribal Area Allowance Detail.
  */
  public ArrayList getTrblAreaDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintTrblAreaAllowDetailInfo oMaintTrblAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TrblAreaAllowBusinessObject oTrblArea = new TrblAreaAllowBusinessObject();
    return oTrblArea.getTrblAreaDetail(sPrimaryKey,lStartPosition,lLastPosition,oMaintTrblAreaAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 4 Oct 2007
  *
  *  To Save Tribal Area Allowance Detail.
  */
  public String saveTrblAreaDetail(TrblAreaAllowHeaderBean oTrblAreaAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TrblAreaAllowBusinessObject oTrblArea = new TrblAreaAllowBusinessObject();
    return oTrblArea.saveData((BaseHeaderBean)oTrblAreaAllowHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  /*
  * Created By Balpreet
  * Dated 4 Oct 2007
  *
  *  To Get Tribal Area Allowance Combo Detail.
  */
  public TrblAreaComboVO getTrblAreaComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TrblAreaAllowBusinessObject oTrblArea = new TrblAreaAllowBusinessObject();
    return oTrblArea.getTrblAreaComboDetails();
  }

  /*
  * Created By Balpreet
  * Dated 2 Jan 2008
  *
  *  To Get Tribal Area Allowance Header Meta Info.
  */
  public RecordMetaInfo getTrblAreaHeaderMetaImpl(TrblAreaAllowQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TrblAreaAllowBusinessObject oTrblArea = new TrblAreaAllowBusinessObject();
    return oTrblArea.getTrblAreaHeaderMetaImpl(oBaseQueryVO);
    
  }

  /*
  * Created By Balpreet
  * Dated 2 Jan 2008
  *
  *  To Get Tribal Area Allowance Header.
  */
  public ArrayList getTrblAreaHeaderRecord(TrblAreaAllowQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    TrblAreaAllowBusinessObject oTrblArea = new TrblAreaAllowBusinessObject();
    return oTrblArea.getTrblAreaHeader(oBaseQueryVO,lStartPosition,lLastPosition);
    
  }


  /*
  * Created By Balpreet
  * Dated 5 Oct 2007
  *
  *  To Get Remote Area Allowance Detail.
  */
  public ArrayList getRmtAreaDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintRmtAreaAllowDetailInfo oMaintRmtAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RmtAreaAllowBusinessObject oRmtArea = new RmtAreaAllowBusinessObject();
    return oRmtArea.getRmtAreaDetail(sPrimaryKey,lStartPosition,lLastPosition,oMaintRmtAreaAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 5 Oct 2007
  *
  *  To Save Remote Area Allowance Detail.
  */
  public String saveRmtAreaDetail(RmtAreaAllowHeaderBean oRmtAreaAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RmtAreaAllowBusinessObject oRmtArea = new RmtAreaAllowBusinessObject();
    return oRmtArea.saveData((BaseHeaderBean)oRmtAreaAllowHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  /*
  * Created By Balpreet
  * Dated 5 Oct 2007
  *
  *  To Get Remote Area Allowance Combo Detail.
  */
  public RmtAreaComboVO getRmtAreaComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RmtAreaAllowBusinessObject oRmtArea = new RmtAreaAllowBusinessObject();
    return oRmtArea.getRmtAreaComboDetails();
  }

  /*
  * Created By Balpreet
  * Dated 8 Oct 2007
  *
  *  To Get Remote Area Allowance Detail Meta Info
  */
  public RecordMetaInfo getRmtAreaDetailMetaInfo(String sPrimaryKey,MaintRmtAreaAllowDetailInfo oMaintRmtAreaAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RmtAreaAllowBusinessObject oRmtArea = new RmtAreaAllowBusinessObject();
    return oRmtArea.getRmtAreaDetailMetaInfo(sPrimaryKey,oMaintRmtAreaAllowDetailInfo);
  }

 /*
  * Created By Balpreet
  * Dated 2 Jan 2008
  *
  *  To Get Remote Area Allowance Header Meta Info.
  */
  public RecordMetaInfo getRmtAreaHeaderMetaImpl(RmtAreaAllowQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RmtAreaAllowBusinessObject oRmtArea = new RmtAreaAllowBusinessObject();
    return oRmtArea.getRmtAreaHeaderMetaImpl(oBaseQueryVO);
    
  }

  /*
  * Created By Balpreet
  * Dated 2 Jan 2008
  *
  *  To Get Remote Area Allowance Header.
  */
  public ArrayList getRmtAreaHeaderRecord(RmtAreaAllowQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    RmtAreaAllowBusinessObject oRmtArea = new RmtAreaAllowBusinessObject();
    return oRmtArea.getRmtAreaHeader(oBaseQueryVO,lStartPosition,lLastPosition);
    
  }

  /*
  * Created By Aqeel
  * Dated 11 Oct 2007
  *
  *  To Get Misc Allowance Combo
  */
  public MaintMiscAllowComboVO getMiscAllowComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    MiscAllowBusinessObject oMiscAllow = new MiscAllowBusinessObject();
    return oMiscAllow.getMiscAllowComboDetails();
  }

  /*
  * Created By Balpreet
  * Dated 19 Oct 2007
  *
  *  To Get Special Duty Allowance Detail.
  */
  public ArrayList getSplDutyDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,SplDutyAllowDetailInfo oSplDutyAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SplDutyAllowBusinessObject oSplDuty = new SplDutyAllowBusinessObject();
    return oSplDuty.getSplDutyDetail(sPrimaryKey,lStartPosition,lLastPosition,oSplDutyAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 19 Oct 2007
  *
  *  To Save Special Duty Allowance Detail.
  */
  public String saveSplDutyDetail(SplDutyAllowHeaderBean oSplDutyAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SplDutyAllowBusinessObject oSplDuty = new SplDutyAllowBusinessObject();
    return oSplDuty.saveData((BaseHeaderBean)oSplDutyAllowHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  /*
  * Created By Balpreet
  * Dated 19 Oct 2007
  *
  *  To Get Special Duty Allowance Combo Detail.
  */
  public SplDutyComboVO getSplDutyComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SplDutyAllowBusinessObject oSplDuty = new SplDutyAllowBusinessObject();
    return oSplDuty.getSplDutyComboDetails();
  }

  /*
  * Created By Balpreet
  * Dated 19 Oct 2007
  *
  *  To Get Special Duty Allowance Detail Meta Info
  */
  public RecordMetaInfo getSplDutyDetailMetaInfo(String sPrimaryKey,SplDutyAllowDetailInfo oSplDutyAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SplDutyAllowBusinessObject oSplDuty = new SplDutyAllowBusinessObject();
    return oSplDuty.getSplDutyDetailMetaInfo(sPrimaryKey,oSplDutyAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 19 Oct 2007
  *
  *  To Get Designation LOV
  */
  public LovVO getSCADsgnLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SplDutyAllowBusinessObject oSplDuty = new SplDutyAllowBusinessObject();
    LovVO oLovVO=oSplDuty.getSCADsgnLOVData(oLovQueryVO);
    return oLovVO;
  }

  /*
  * Created By Balpreet
  * Dated 19 Oct 2007
  *
  *  To Get Pay Scale LOV
  */
  public LovVO getSCAPayScaleLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SplDutyAllowBusinessObject oSplDuty = new SplDutyAllowBusinessObject();
    LovVO oLovVO=oSplDuty.getSCAPayScaleLOVData(oLovQueryVO);
    return oLovVO;
  }

 /*
  * Created By Balpreet
  * Dated 3 Jan 2008
  *
  *  To Get Special Duty Allowance Header Meta Info.
  */
  public RecordMetaInfo getSplDutyHeaderMetaImpl(SplDutyAllowQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SplDutyAllowBusinessObject oSplDuty = new SplDutyAllowBusinessObject();
    return oSplDuty.getSplDutyHeaderMetaImpl(oBaseQueryVO);
    
  }

  /*
  * Created By Balpreet
  * Dated 3 Jan 2008
  *
  *  To Get Special Duty Allowance Header.
  */
  public ArrayList getSplDutyHeaderRecord(SplDutyAllowQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SplDutyAllowBusinessObject oSplDuty = new SplDutyAllowBusinessObject();
    return oSplDuty.getSplDutyHeader(oBaseQueryVO,lStartPosition,lLastPosition);
  }


/////SCA RATE

  /*
  * Created By Balpreet
  * Dated 22 Oct 2007
  *
  *  To Get SCA Detail Meta Info
  */
  public RecordMetaInfo getScaDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SCARateBusinessObject oSCARateBusinessObject = new SCARateBusinessObject();
    return oSCARateBusinessObject.getScaDetailMetaInfo(sPrimaryKey);
  }

  /*
  * Created By Balpreet
  * Dated 22 Oct 2007
  *
  *  To Get SCA Detail
  */
  public ArrayList getScaDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SCARateBusinessObject oSCARateBusinessObject = new SCARateBusinessObject();
    return oSCARateBusinessObject.getScaDetails(sPrimaryKey,lStartPosition,lLastPosition);
  }

  /*
  * Created By Balpreet
  * Dated 22 Oct 2007
  *
  *  To Save SCA Detail
  */
  public String saveScaDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SCARateBusinessObject oSCARateBusinessObject = new SCARateBusinessObject();
    return oSCARateBusinessObject.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }
  /*
  * Created By Balpreet
  * Dated 2 Nov 2007
  *
  *  To Get SCA Combo Detail
  */
  public SCAComboVO getScaComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SCARateBusinessObject oSCARateBusinessObject = new SCARateBusinessObject();
    return oSCARateBusinessObject.getScaComboDetails();
  }

///////////////////////////////////////////////HOLIDAY CAL///////////////////////////////////////////

/*
 * Created By Balpreet Kaur
 * Dated 14 Nov 2007
 *
 *  To get the Holiday cal  Meta info.
 */
  public RecordMetaInfo getHolidayCalMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SiteDetailBusinessObject oSite = new SiteDetailBusinessObject();
    return oSite.getSiteDetailMetaInfo(sPrimaryKey);
  }

/*
 * Created By Balpreet Kaur
 * Dated 14 Nov 2007
 *
 *  To get the Holiday Cal
 */
  public ArrayList getHolidayCalDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SiteDetailBusinessObject oSite = new SiteDetailBusinessObject();
    return oSite.getSiteDetails(sPrimaryKey,lStartPosition,lLastPosition);
  }

/*
 * Created By Balpreet Kaur
 * Dated 14 Nov 2007
 *
 * To Save Holiday Cal
 */
  public String saveHolidayCal(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    SiteDetailBusinessObject oSite = new SiteDetailBusinessObject();
    return oSite.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

/*
 * Created By Balpreet Kaur
 * Dated 19 Nov 2007
 *
 * To Get City type & Area Type Combo
 */
  public CityLocMapComboVO getCityLocMapComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CityLocMapBusinessObject oCityLocMap=new CityLocMapBusinessObject();
    return oCityLocMap.getCityLocMapComboDetails();
  }

/*
 * Created By Balpreet Kaur
 * Dated 19 Nov 2007
 *
 * To Get City typeLoaction Map Meta Info
 */
  public RecordMetaInfo getCityLocMapDetailMetaInfo(BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CityLocMapBusinessObject oCityLocMap=new CityLocMapBusinessObject();
    return oCityLocMap.getCityLocMapDetailMetaInfo(oBaseDetailInfo);
  }

/*
 * Created By Balpreet Kaur
 * Dated 19 Nov 2007
 *
 * To Get City type Loc Map Details
 */
  public ArrayList getCityLocMapDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CityLocMapBusinessObject oCityLocMap=new CityLocMapBusinessObject();
    return oCityLocMap.getCityLocMapDetails(sPrimaryKey,lStartPosition,lLastPosition,oBaseDetailInfo);
  }

/*
 * Created By Balpreet Kaur
 * Dated 19 Nov 2007
 *
 * To Save City Type Loc Map Details
 */
  public String saveCityLocMapDetail(MaintCityLocMapHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CityLocMapBusinessObject oCityLocMap=new CityLocMapBusinessObject();
    return oCityLocMap.saveData(oDummyHeaderBean,oWhenPicked,sScreenName,sScreenMode,bHeaderDataChanged,oDetailBeanArray,bDetailDataChanged,oDetailPicked);
  }

/*
 * Created By Balpreet Kaur
 * Dated 19 Nov 2007
 *
 * To Save City Type Loc Map Details
 */
  public LovVO getCityMapLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CityLocMapBusinessObject oCityLocMap=new CityLocMapBusinessObject();
    return oCityLocMap.getCityMapLocLOVData(oLovQueryVO);
  }

//Added by Swapnendu Dt 15 -Sep 2010.
  public RecordMetaInfo getCityLocMapHeaderMetaInfo(CityLocMapQueryVO oCityLocMapQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CityLocMapBusinessObject oCityLocMap=new CityLocMapBusinessObject();
    return oCityLocMap.getCityLocMapHeaderMetaInfo(oCityLocMapQueryVO);
  }

//Added by Swapnendu Dt 16 -Sep 2010.
  public ArrayList getCityLocMapHeader(CityLocMapQueryVO oCityLocMapQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CityLocMapBusinessObject oCityLocMap=new CityLocMapBusinessObject();
    return oCityLocMap.getCityLocMapHeader(oCityLocMapQueryVO,lStartPosition,lLastPosition);
  }

  /*
  * Created By Balpreet
  * Dated 30 May 2008
  *
  *  To Get Project Allowance Detail Meta Info
  */
  public RecordMetaInfo getProjectDetailMetaInfo(String sPrimaryKey,MaintProjectAllowDetailInfo oMaintProjectAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ProjectAllowBusinessObject oProject = new ProjectAllowBusinessObject();
    return oProject.getProjectDetailMetaInfo(sPrimaryKey,oMaintProjectAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 30 May 2008
  *
  *  To Get Project Allowance Detail.
  */
  public ArrayList getProjectDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintProjectAllowDetailInfo oMaintProjectAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ProjectAllowBusinessObject oProject = new ProjectAllowBusinessObject();
    return oProject.getProjectDetail(sPrimaryKey,lStartPosition,lLastPosition,oMaintProjectAllowDetailInfo);
  }

  /*
  * Created By Balpreet
  * Dated 30 May 2008
  *
  *  To Save Project Allowance Detail.
  */
  public String saveProjectDetail(MaintProjectAllowHeaderBean oMaintProjectAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ProjectAllowBusinessObject oProject = new ProjectAllowBusinessObject();
    return oProject.saveData((BaseHeaderBean)oMaintProjectAllowHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }

  /*
  * Created By Balpreet
  * Dated 30 May 2008
  *
  *  To Get Project Allowance Combo Detail.
  */
  public ProjectComboVO getProjectComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ProjectAllowBusinessObject oProject = new ProjectAllowBusinessObject();
    return oProject.getProjectComboDetails();
  }

  /*
  * Created By Balpreet
  * Dated 30 May 2008
  *
  *  To Get Project Allowance Header Meta Info.
  */

  public RecordMetaInfo getProjectHeaderMetaImpl(ProjectQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ProjectAllowBusinessObject oProject = new ProjectAllowBusinessObject();
    return oProject.getProjectAllowHeaderMetaInfo(oBaseQueryVO);
  }

  /*
  * Created By Balpreet
  * Dated 30 May 2008
  *
  *  To Get Project Allowance Header.
  */
  public ArrayList getProjectHeaderRecord(ProjectQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ProjectAllowBusinessObject oProject = new ProjectAllowBusinessObject();
    return oProject.getProjectAllowHeader(oBaseQueryVO,lStartPosition,lLastPosition);
  }


            /* PAYCODE VS AGENCY CODE
             by Gagan dt 18 June 08 */

  public RecordMetaInfo getPaycodeAgencycodeDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   PayCodeAgencyCodeBusinessObject oPayAcct = new  PayCodeAgencyCodeBusinessObject();
    return oPayAcct.getPaycodeAgencycodeDetailMetaInfo(sPrimaryKey);
  }

  public ArrayList getPaycodeAgencycodeDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayCodeAgencyCodeBusinessObject oPayAcct = new  PayCodeAgencyCodeBusinessObject();
    return oPayAcct.getPaycodeAgencycodeDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }

  public String saveAgencyDetails(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayCodeAgencyCodeBusinessObject oPayAcct = new  PayCodeAgencyCodeBusinessObject();
    return oPayAcct.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  
  }

  public LovVO getPaycodeAgencycodeAgencyLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
   PayCodeAgencyCodeBusinessObject oAgencyData = new PayCodeAgencyCodeBusinessObject();
    LovVO oLovVO=oAgencyData.getPaycodeAgencycodeAgencyLOVData(oLovQueryVO);
    return oLovVO;
  }
    
  public LovVO  getPaycodeAgencycodeAgencySiteLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayCodeAgencyCodeBusinessObject oAgencySiteData = new PayCodeAgencyCodeBusinessObject();
    LovVO oLovVO=oAgencySiteData.getPaycodeAgencycodeAgencySiteLOVData(oLovQueryVO);
    return oLovVO;
  }
  
  public LovVO  getPaycodeAgencycodeLocationLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayCodeAgencyCodeBusinessObject oLocation = new PayCodeAgencyCodeBusinessObject();
    LovVO oLovVO=oLocation.getPaycodeAgencycodeLocationLOVData(oLovQueryVO);
    return oLovVO; 
  }
  
  public LovVO  getPaycodeAgencycodeEmployeeNoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayCodeAgencyCodeBusinessObject oEmployeeNo = new PayCodeAgencyCodeBusinessObject();
    LovVO oLovVO=oEmployeeNo.getPaycodeAgencycodeEmployeeNoLOVData(oLovQueryVO);
    return oLovVO;
  }
   public LovVO  getPaycodeAgencycodePayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    PayCodeAgencyCodeBusinessObject oPayCode = new PayCodeAgencyCodeBusinessObject();
    LovVO oLovVO=oPayCode.getPaycodeAgencycodePayCodeLOVData(oLovQueryVO);
    return oLovVO;
  }

// Category Location Mapping by Gagan 4 Aug 08


public RecordMetaInfo getCategoryLocationDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CategoryLocationBusinessObject oPayAcct = new CategoryLocationBusinessObject();
    return oPayAcct.getCategoryLocationDetailMetaInfo(sPrimaryKey);
  }

  public ArrayList getCategoryLocationDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
  {
    CategoryLocationBusinessObject oPayAcct = new CategoryLocationBusinessObject();
    return oPayAcct.getCategoryLocationDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }

 public String saveCategoryDetails(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CategoryLocationBusinessObject oPayAcct = new CategoryLocationBusinessObject();
   // return oPayAcct.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
    return oPayAcct.saveData((BaseHeaderBean)oDummyHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked); 
  }
 
  public CtgrySchemeComboVO getCtgrySchemeComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
{
   CategoryLocationBusinessObject oDsgn = new CategoryLocationBusinessObject();
   CtgrySchemeComboVO oDsgnComboVO=oDsgn.getCtgrySchemeComboDetails();
   return oDsgnComboVO;
}
public LovVO  getCategorySchemeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CategoryLocationBusinessObject oPayCode = new CategoryLocationBusinessObject();
    LovVO oLovVO=oPayCode.getCategorySchemeLOVData(oLovQueryVO);
    return oLovVO;
  }
 
public LovVO  getCategorySchemeLocationLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CategoryLocationBusinessObject oPayCode = new CategoryLocationBusinessObject();
    LovVO oLovVO=oPayCode.getCategorySchemeLocationLOVData(oLovQueryVO);
    return oLovVO;
  }


public LovVO  getCategorySchemeDepotLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    CategoryLocationBusinessObject oPayCode = new CategoryLocationBusinessObject();
    LovVO oLovVO=oPayCode.getCategorySchemeDepotLOVData(oLovQueryVO);
    return oLovVO;
  }


 //added by sakshi starts 26.12.2008
  public PayScaleVO getPayScaleComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
{
PayScaleBusinessObject oPayScale=new PayScaleBusinessObject();
return oPayScale.getPayScaleComboDetails();
}
  //added by sakshi ends 26.12.2008

/*Code For Edit Pay Image*/
  public RecordMetaInfo getEnqPayImageHeaderMetaInfo(EnqPayImageQueryVO oEnqPayImageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EditPayImgBusinessObject oPayImageBO = new EditPayImgBusinessObject();
    return oPayImageBO.getEnqPayImageHeaderMetaInfo(oEnqPayImageQueryVO);
  }

  public ArrayList getEnqPayImageHeader(EnqPayImageQueryVO oEnqPayImageQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EditPayImgBusinessObject oPayImageBO = new EditPayImgBusinessObject();
    return oPayImageBO.getEnqPayImageHeader(oEnqPayImageQueryVO,lStartPosition,lLastPosition);
  }

  public RecordMetaInfo getEnqPayImageDetailMetaInfo(String sPrimaryKey,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EditPayImgBusinessObject oPayImageBO = new EditPayImgBusinessObject();
    return oPayImageBO.getEnqPayImageDetailMetaInfo(sPrimaryKey, oEnqPayImageDetailInfo);
  }

  public ArrayList getEnqPayImageDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EditPayImgBusinessObject oPayImageBO = new EditPayImgBusinessObject();
    return oPayImageBO.getEnqPayImageDetail(sPrimaryKey,lStartPosition,lLastPosition,oEnqPayImageDetailInfo);
  }
  
  public String saveEditPayImg(EnqPayImageHeaderBean oEnqPayImageHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EditPayImgBusinessObject oPayImageBO = new EditPayImgBusinessObject();
    return oPayImageBO.saveData(oEnqPayImageHeaderBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged,oDetailBeanArray, bDetailDataChanged,  oDetailPicked);

  }

  public EditPayImgComboVO getEnqPayImageComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EditPayImgBusinessObject oPayImgBusinessObject = new EditPayImgBusinessObject();
    EditPayImgComboVO oEditPayImgComboVO=oPayImgBusinessObject.getEnqPayImageComboDetails();
    return oEditPayImgComboVO;
  }
  
  public String getMaxPayYear(long locCode,String hdnEmpLbrFlag)throws EnrgiseSystemException, EnrgiseApplicationException
 {
   EditPayImgBusinessObject oPayImgBusinessObject=new EditPayImgBusinessObject();
   return oPayImgBusinessObject.getMaxPayYear(locCode,hdnEmpLbrFlag);
 }

  public LovVO getEnqYmtLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EditPayImgBusinessObject oPayImgBusinessObject = new EditPayImgBusinessObject();
    LovVO oLovVO=oPayImgBusinessObject.getEnqYmtLOVData(oLovQueryVO);
    return oLovVO;
  }
  public LovVO getEditEmpNoLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EditPayImgBusinessObject oPayImgBusinessObject = new EditPayImgBusinessObject();
    LovVO oLovVO=oPayImgBusinessObject.getEditEmpNoLOVDataQ(oLovQueryVO);
    return oLovVO;
  }
  
  public LovVO getEditEmpNoLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EditPayImgBusinessObject oPayImgBusinessObject = new EditPayImgBusinessObject();
    LovVO oLovVO=oPayImgBusinessObject.getEditEmpNoLOVDataN(oLovQueryVO);
    return oLovVO;
  }

  public LovVO getEditPayImgPayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EditPayImgBusinessObject oPayImgBusinessObject = new EditPayImgBusinessObject();
    LovVO oLovVO=oPayImgBusinessObject.getEditPayImgPayCodeLOVData(oLovQueryVO);
    return oLovVO;
  }
  
  public ArrayList getPayCodeDetail(String sPayCode) throws EnrgiseSystemException, EnrgiseApplicationException
    {
      EditPayImgBusinessObject oPayImgBusinessObject = new EditPayImgBusinessObject();
      return oPayImgBusinessObject.getPayCodeDetail(sPayCode);
    }
    
    /*
  * Created By Balpreet
  * Dated 18 Feb 2008
  *
  *  To Get OTA Payment Header Meta Info
  */
  public RecordMetaInfo getOTAPymntHeaderMetaInfo(OTAPymntQueryVO oOTAPymntQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject =new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getOTAPymntHeaderMetaInfo(oOTAPymntQueryVO);
  }

  public ArrayList getOTAPymntHeader(OTAPymntQueryVO oOTAPymntQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject =new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getOTAPymntHeader(oOTAPymntQueryVO,lStartPosition,lLastPosition);
  }

  public String saveOTAPymntInfo(OTAPymntHeaderBean oOTAPymntHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject =new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.saveData(oOTAPymntHeaderBean,oWhenPicked,sScreenName,sScreenMode,bHeaderDataChanged,oDetailBeanArray,bDetailDataChanged,oDetailPicked);
  }

  public LovVO getEmpOTAPymntLOV(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject =new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getEmpOTAPymntLOV(oLovQueryVO);
  }

  public LovVO getEmpOTAPymntLOVQ(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject =new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getEmpOTAPymntLOVQ(oLovQueryVO);
  }
  
  public LovVO getOTAPaymentPayCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject = new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getOTAPaymentPayCode(oLovQueryVO);
  }

  /*
  * Created By Balpreet
  * Dated 29 March 2008
  *
  *  To get Employee Hourly Wages
  */
  public String getEmpHrlyWage(String sEmpNo, String sYYYYMM,String hdnEmpLbrFlag) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject = new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getEmpHrlyWage(sEmpNo,sYYYYMM,hdnEmpLbrFlag);

  }

  public String sendInv(String otaId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject = new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.sendInv(otaId,hdnEmpLbrFlag, lUserID, lSiteID);
  }

  public RecordMetaInfo getOTAPymntDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject =new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getOTAPymntDetailMetaInfo(sPrimaryKey);
  }
  
  public ArrayList getOTAPymntDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject =new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getOTAPymntDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }

  /*
  * Created By Balpreet
  * Dated 16 June 2008
  *
  *  To Get IT deduction in case of Fin year end
  */
  public ArrayList getOTAPymntITDed(OTAPymntQueryVO oOTAPymntQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject =new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getOTAPymntITDed(oOTAPymntQueryVO);
  }
  
  public RecordMetaInfo getOTAPymntDedDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject =new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getOTAPymntDedDetailMetaInfo(sPrimaryKey);
  }
  
  public ArrayList getOTAPymntDedDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    OTAPymntBusinessObject oOTAPymntBusinessObject =new OTAPymntBusinessObject();
    return oOTAPymntBusinessObject.getOTAPymntDedDetail(sPrimaryKey,lStartPosition,lLastPosition);
  }
  
  ///////////////////////////////////////////////EMP CPF Search ///////////////
  public RecordMetaInfo getEmpCPFSearchHeaderMetaInfo(EmpCPFSearchQueryVO oEmpCPFSearchQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EmpCPFSearchBusinessObject oEmpCPFSearch = new EmpCPFSearchBusinessObject();
    return oEmpCPFSearch.getEmpCPFSearchHeaderMetaInfo(oEmpCPFSearchQueryVO);
  }

  public ArrayList getEmpCPFSearchHeader(EmpCPFSearchQueryVO oEmpCPFSearchQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EmpCPFSearchBusinessObject oEmpCPFSearch = new EmpCPFSearchBusinessObject();
    return oEmpCPFSearch.getEmpCPFSearchHeader(oEmpCPFSearchQueryVO,lStartPosition,lLastPosition);
  }
  
  public String saveoEmpCPFSearch(EmpCPFSearchBean oEmpCPFSearchBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EmpCPFSearchBusinessObject oEmpCPFSearch = new EmpCPFSearchBusinessObject();
    return oEmpCPFSearch.saveData((BaseHeaderBean)oEmpCPFSearchBean,oWhenPicked, sScreenName, sScreenMode, bHeaderDataChanged, oDetailBeanArray, bDetailDataChanged, oDetailPicked);
  }
  
   public LovVO getEmpCPFSearchLocLOVData(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EmpCPFSearchBusinessObject oEmpCPFSearch =new EmpCPFSearchBusinessObject();
    return oEmpCPFSearch.getEmpCPFSearchLocLOVData(oLovQueryVO);
  }
  
  public EmpCPFSearchComboVO getCPFSearchComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    EmpCPFSearchBusinessObject oEmpCPFSearch = new EmpCPFSearchBusinessObject();
    return oEmpCPFSearch.getCPFSearchComboDetails();
  }
  
    
  /*
  * Created By Anwar
  * Dated 05 July 2010  
  *  To Get Six Pay implimented bad climate combo details.
  */
   public BadClmtComboVOSixPay getBadClmtComboDetailsSixPay() throws EnrgiseSystemException, EnrgiseApplicationException
  {
    BadClmtAllowBusinessObjectSixPay oBadClmtAllowSixPay = new BadClmtAllowBusinessObjectSixPay();
    return oBadClmtAllowSixPay.getBadClmtComboDetailsSixPay();
  } 
  public LovVO getScreenListLOVDataN(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ResponsibilityCreationBusinessObject oResponsibilityCreationBusinessObject = new ResponsibilityCreationBusinessObject();
    return oResponsibilityCreationBusinessObject.getScreenListLOVDataN(oLovQueryVO);
  }
    public UsrRespComboVO getUsrRespComboVO()  throws EnrgiseSystemException, EnrgiseApplicationException
    {
        UsrRespMapBusinessObject oUsrRespMapBusinessObject = new UsrRespMapBusinessObject();
        return oUsrRespMapBusinessObject.getUsrRespComboVO();
    }
    public RecordMetaInfo getUsrRespHeaderMetaInfo(UserRespQueryVO oUserRespQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        UsrRespMapBusinessObject oBusinessObject = new UsrRespMapBusinessObject();
        return oBusinessObject.getUsrRespHeaderMetaInfo(oUserRespQueryVO);
    }
    public ArrayList getUsrRespHeader(UserRespQueryVO oUserRespQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        UsrRespMapBusinessObject oBusinessObject = new UsrRespMapBusinessObject();
        return oBusinessObject.getUsrRespHeader(oUserRespQueryVO,lStartPosition,lLastPosition);
    }
    public RecordMetaInfo getUserRespDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
        UsrRespMapBusinessObject oBusinessObject = new UsrRespMapBusinessObject();
        return oBusinessObject.getUserRespDetailMetaInfo(sPrimaryKey, (UserRespDetailInfo)oBaseDetailInfo);
    }
    public ArrayList getUserRespDetail(String sPrimaryKey, long lStartPosition, long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException
    {
        UsrRespMapBusinessObject oBusinessObject = new UsrRespMapBusinessObject();
        return oBusinessObject.getUserRespDetail(sPrimaryKey, lStartPosition, lLastPosition, (UserRespDetailInfo)oBaseDetailInfo);
    }
    public String saveUserRespMapping(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        UsrRespMapBusinessObject oUsrRespMapBusinessObject = new UsrRespMapBusinessObject();
        return oUsrRespMapBusinessObject.saveData(oBaseHeaderBean,oWhenPicked,sScreenName,sScreenMode,bHeaderDataChanged,oDetailBeanArray,bDetailDataChanged,oDetailPicked);
    }

}