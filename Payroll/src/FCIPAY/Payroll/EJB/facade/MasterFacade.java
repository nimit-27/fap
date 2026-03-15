package FCIPAY.Payroll.EJB.facade;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BasicArrDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DummyQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.InrRateDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DARatesDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntRateDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintDaRatesQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.IntRateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCAComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCARatesQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CCARatesDetailInfo;
import FCIPAY.Payroll.UTILITY.CCARatesHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowDetailInfo;
import FCIPAY.Payroll.UTILITY.ConvAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ConvAllowComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.GISComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintInterestRateQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintPayScaleQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProfTaxDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProfTaxQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.StdDednQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TaxParamOtherQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.TaxParamQueryVO;
import FCIPAY.Payroll.EJB.business.CCARateBusinessObject;
import FCIPAY.Payroll.EJB.business.ConvAllowBusinessObject;
import FCIPAY.Payroll.EJB.business.DARatesBusinessObject;
import FCIPAY.Payroll.EJB.business.GISRatesBusinessObject;
import FCIPAY.Payroll.EJB.business.HraBusinessObject;
import FCIPAY.Payroll.EJB.business.InrRateBusinessObject;
import FCIPAY.Payroll.EJB.business.IntSavBusinessObject;
import FCIPAY.Payroll.EJB.business.MiscParamBusinessObject;
import FCIPAY.Payroll.EJB.business.PayAcctBusinessObject;
import FCIPAY.Payroll.EJB.business.PayCodeBusinessObject;
import FCIPAY.Payroll.EJB.business.PayScaleBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamIncomeBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamOtherBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamProfTaxBusinessObject;
import FCIPAY.Payroll.EJB.business.TaxParamStdDedBusinessObject;
import FCIPAY.Payroll.EJB.business.BadClmtAllowBusinessObject;
import FCIPAY.Payroll.EJB.business.CityLocMapBusinessObject;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.UTILITY.IntRateHeaderBean;
import FCIPAY.Payroll.UTILITY.IntRateDetailBean;
import FCIPAY.Payroll.UTILITY.MaintDARatesHeaderBean;
import FCIPAY.Payroll.UTILITY.MaintInrRateHeaderBean;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean;
import FCIPAY.Payroll.UTILITY.PayScaleHeaderBean;
import FCIPAY.Payroll.UTILITY.ProfTaxHeaderBean;
import FCIPAY.Payroll.UTILITY.StdDednHeaderBean;
import FCIPAY.Payroll.UTILITY.TaxParamHeaderBean;
import FCIPAY.Payroll.UTILITY.TaxParamOtherHeaderBean;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MiscComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.HraComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SiteTypeComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.DsgnComboVO;
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

import FCIPAY.Payroll.DATAACCESSTIER.VO.BadClmtComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BadClmtQueryVO;
import FCIPAY.Payroll.UTILITY.MaintBadClmtAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintBadClmtAllowDetailInfo;

import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintMiscAllowComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.SCAComboVO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.CityLocMapQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProjectComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ProjectQueryVO;
import FCIPAY.Payroll.UTILITY.MaintProjectAllowHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintProjectAllowDetailInfo;

import FCIPAY.Payroll.EJB.business.CategoryLocationBusinessObject;
import FCIPAY.Payroll.UTILITY.MaintCategoryLocationBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MaintLoanMstQueryVO;
import FCIPAY.Payroll.UTILITY.MaintLoanMasterHdrBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EnqPayImageQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EditPayImgComboVO;
import FCIPAY.Payroll.EJB.business.EditPayImgBusinessObject;
import FCIPAY.Payroll.UTILITY.EnqPayImageHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.OTAPymntQueryVO;
import FCIPAY.Payroll.UTILITY.OTAPymntHeaderBean;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpCPFSearchQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.EmpCPFSearchComboVO;
import FCIPAY.Payroll.UTILITY.EmpCPFSearchBean;
import java.rmi.RemoteException;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayScaleVO;//added by sakshi 26.12.2008
import FCIPAY.Payroll.UTILITY.MaintCityLocMapHeaderBean;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ejb.EJBObject;
import FCIPAY.Payroll.DATAACCESSTIER.VO.BadClmtComboVOSixPay;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UsrRespComboVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UserRespQueryVO;

public interface MasterFacade extends EJBObject
{

//Pay Code

  public RecordMetaInfo getPayCodeDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPayCodeDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String savePayCode(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//Pay Scale

  public boolean savePayScaleHeader(PayScaleHeaderBean oPayScaleHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getPayScaleHeaderMetaInfo(MaintPayScaleQueryVO oMaintPayScaleQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPayScaleHeader(MaintPayScaleQueryVO oMaintPayScaleQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getPayScaleDetailMetaInfo(String sPrimaryKey,PayScaleDetailInfo oPayScaleDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPayScaleDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,PayScaleDetailInfo oPayScaleDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String savePayScale(PayScaleHeaderBean oPayScaleHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderChanged,ArrayList oDetailBeanArray,boolean bDetailChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getPayScaleLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getPayScaleCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/**
 *    These are the codes for MAINTAIN DA RATES
 *    In this screen we have both header & details part
 */

  public RecordMetaInfo getDARateHeaderMetaInfo(MaintDaRatesQueryVO oMaintDaRatesQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDARateHeader(MaintDaRatesQueryVO oMaintDaRatesQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public ArrayList getDARateDetail(String sYear, String sDAType, String sPayScaleType ,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 // public RecordMetaInfo getDARateDetailMetaInfo(String sYear, String sDAType, String sPayScaleType) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveDARate(MaintDARatesHeaderBean oMaintDARatesHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDARateLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDARateDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,DARatesDetailInfo oDARatesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getDARateDetailMetaInfo(String sPrimaryKey,DARatesDetailInfo oDARatesDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

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


 //////////// For CCA Rates              ///////////////////////////////////////
 public RecordMetaInfo getCCARateAllDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getCCARateAllDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveCCARate(CCARatesHeaderBean oCCARatesHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public CCAComboVO getCCARateComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getCCARateHeaderMetaInfo(CCARatesQueryVO oCCARatesQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getCCARateHeader(CCARatesQueryVO oCCARatesQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

/////HRARATE
 public RecordMetaInfo getHraDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getHraDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveHraDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

//For ConvAllow
 public RecordMetaInfo getCovnAllowHeaderMetaInfo(ConvAllowQueryVO oConvAllowQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getStdDednHeader(ConvAllowQueryVO oConvAllowQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getConvAllowAllDetailMetaInfo(String sPrimaryKey, ConvAllowDetailInfo oConvAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getConvAllowAllDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, ConvAllowDetailInfo oConvAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String saveConvAllow(ConvAllowHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ConvAllowComboVO getConvAllowComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public RecordMetaInfo getConvAllowHeaderMetaInfo(ConvAllowQueryVO oConvAllowQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getConvAllowHeader(ConvAllowQueryVO oConvAllowQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

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

 public HraComboVO getHRARateComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  ////////// Maintain BankMaster
  public RecordMetaInfo getBankHeaderMetaInfo(MaintBankMastQueryVO oMaintBankMastQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getBankMasterHeader(MaintBankMastQueryVO oMaintBankMastQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getBankMasterDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BankMastDetailInfo oBankMastDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getBankMasterDetailMetaInfo(String sPrimaryKey,BankMastDetailInfo oBankMastDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveBankDetail(MaintBankMastHeaderBean oMaintBankMastHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getBankCodeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

			/////////////////////////////////LOAN MASTER//////////////////
 public RecordMetaInfo getLoanMstHeaderMetaInfo(MaintLoanMstQueryVO oMaintLoanMstQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getLoanMstHeader(MaintLoanMstQueryVO oMaintLoanMstQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveLoanMaster(MaintLoanMasterHdrBean oMaintLoanMasterHdrBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


////////////////SITE DETAIL

  public RecordMetaInfo getSiteDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getSiteDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveSiteDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getSiteLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  public SiteTypeComboVO getLocTypesComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLocTypLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  public LovVO getStateLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
////////////////////////////////////// DESIGNATION DETAILS////////////////////////////////////////////////////////
  public DsgnComboVO getDsgnComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getDsgnDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getDsgnDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
   
  
  public String saveDsgnDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDsgnPayScaleCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;

  ////////////////////added by devendra start/////////////////////////////////////////////////////////////////////////
  public ArrayList get6PayDsgnDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public LovVO getDsgn6PayEmpCtgryLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  public String save6PayDsgnDetail(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public DsgnComboVO get6PayEmpCtgryDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public DsgnComboVO get6PayDsgnComboPayScaleDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  //public DsgnComboVO get6PayDsgnComboPayBandDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getDsgn6PayScaleCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  public LovVO getDsgn6PayBandCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  ////////////////// added by devendra end///////////////////////////////////////////////////////////////////////////

   ///////////////////////////////////////HILL COMPENSATORY ALLOWANCE///////////////////////////////////////
  public RecordMetaInfo getHillCmpnstryDetailMetaInfo(String sPrimaryKey,MaintHillCmpnstryAllowDetailInfo oMaintHillCmpnstryAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHillCmpnstryDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintHillCmpnstryAllowDetailInfo oMaintHillCmpnstryAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveHillCmpnstryDetail(HillCmpnstryAllowHeaderBean oHillCmpnstryAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public HillCmpnstryComboVO getHillCmpnstryComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getHillCmpnstryHeaderMetaImpl(HillCmpnstryAllowQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getHillCmpnstryHeaderRecord(HillCmpnstryAllowQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

   ///////////////////////////////////////BAD CLIMATE ALLOWANCE///////////////////////////////////////
  public RecordMetaInfo getBadClmtDetailMetaInfo(String sPrimaryKey,MaintBadClmtAllowDetailInfo oMaintBadClmtAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getBadClmtDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintBadClmtAllowDetailInfo oMaintBadClmtAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveBadClmtDetail(MaintBadClmtAllowHeaderBean oMaintBadClmtAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public BadClmtComboVO getBadClmtComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getBadClmtHeaderMetaImpl(BadClmtQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getBadClmtHeaderRecord(BadClmtQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

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

////////////////////////////////////// CITY TYPE LOCATION MAPPING DETAILS////////////////////////////////////////////////////////
  public CityLocMapComboVO getCityLocMapComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getCityLocMapDetailMetaInfo(BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getCityLocMapHeaderMetaInfo(CityLocMapQueryVO oCityLocMapQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getCityLocMapHeader(CityLocMapQueryVO oCityLocMapQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getCityLocMapDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveCityLocMapDetail(MaintCityLocMapHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getCityMapLocLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

  /*////////// Maintain Interest Rate
  public RecordMetaInfo getIntRateHeaderMetaInfo(IntRateQueryVO oIntRateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getIntRateHeader(IntRateQueryVO oIntRateQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getIntRateDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getIntRateDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveIntRate(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanTypeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanTypeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  */
  ////////// Maintain Interest Rate
  public RecordMetaInfo getIntRateHeaderMetaInfo(IntRateQueryVO oIntRateQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getIntRateHeader(IntRateQueryVO oIntRateQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getIntRateDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getIntRateDetailMetaInfo(String sPrimaryKey,BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveIntRate(IntRateHeaderBean oIntRateHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanTypeLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getLoanTypeLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

   ///////////////////////////////////////PROJECT ALLOWANCE///////////////////////////////////////
  public RecordMetaInfo getProjectDetailMetaInfo(String sPrimaryKey,MaintProjectAllowDetailInfo oMaintProjecttAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getProjectDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,MaintProjectAllowDetailInfo oMaintProjectAllowDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveProjectDetail(MaintProjectAllowHeaderBean oMaintProjectAllowHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ProjectComboVO getProjectComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getProjectHeaderMetaImpl(ProjectQueryVO oBaseQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getProjectHeaderRecord(ProjectQueryVO oBaseQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

// ADDED by Gagan dt- 18 June 08

 public RecordMetaInfo getPaycodeAgencycodeDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getPaycodeAgencycodeDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String  saveAgencyDetails(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO  getPaycodeAgencycodePayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO  getPaycodeAgencycodeEmployeeNoLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO  getPaycodeAgencycodeLocationLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO  getPaycodeAgencycodeAgencySiteLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getPaycodeAgencycodeAgencyLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;


// Category Location Mapping by Gagan dt- 4 Aug 08
 public RecordMetaInfo getCategoryLocationDetailMetaInfo (String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public ArrayList getCategoryLocationDetail(String sPrimaryKey,long lDetailFirstPosition,long lDetailLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public String  saveCategoryDetails(DummyHeaderBean oDummyHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public CtgrySchemeComboVO getCtgrySchemeComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getCategorySchemeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
 public LovVO getCategorySchemeLocationLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 
 public LovVO getCategorySchemeDepotLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException; 

//added by sakshi starts 26.12.2008
public PayScaleVO getPayScaleComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
//added by sakshi ends 26.12.2008

/*Code For Edit Pay Image*/
  public RecordMetaInfo getEnqPayImageHeaderMetaInfo(EnqPayImageQueryVO oEnqPayImageQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException, RemoteException;
  public ArrayList getEnqPayImageHeader(EnqPayImageQueryVO oEnqPayImageQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public RecordMetaInfo getEnqPayImageDetailMetaInfo(String sPrimaryKey,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEnqPayImageDetail(String sPrimaryKey,long lStartPosition,long lLastPosition,EnqPayImageDetailInfo oEnqPayImageDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveEditPayImg(EnqPayImageHeaderBean oEnqPayImageHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public EditPayImgComboVO getEnqPayImageComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEnqYmtLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEditEmpNoLOVDataQ(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEditEmpNoLOVDataN(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEditPayImgPayCodeLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getMaxPayYear(long locCode,String hdnEmpLbrFlag)throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getPayCodeDetail(String sPayCode) throws EnrgiseSystemException, EnrgiseApplicationException,RemoteException;
  
  /////////////////////////////////////////OTA Payment//////////////////////////
  public RecordMetaInfo getOTAPymntHeaderMetaInfo(OTAPymntQueryVO oOTAPymntQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getOTAPymntHeader(OTAPymntQueryVO oOTAPymntQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveOTAPymntInfo(OTAPymntHeaderBean oOTAPymntHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpOTAPymntLOV(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpOTAPymntLOVQ(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String getEmpHrlyWage(String sEmpNo,String sYYYYMM,String hdnEmpLbrFlag)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  public RecordMetaInfo getOTAPymntDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getOTAPymntDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  public String sendInv(String otaId,String hdnEmpLbrFlag,long lUserID,long lSiteID)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getOTAPymntITDed(OTAPymntQueryVO oOTAPymntQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  public RecordMetaInfo getOTAPymntDedDetailMetaInfo(String sPrimaryKey) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getOTAPymntDedDetail(String sPrimaryKey,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getOTAPaymentPayCode(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  /////////////////////////////////////////CPF Search Screen//////////////////////////
  public RecordMetaInfo getEmpCPFSearchHeaderMetaInfo(EmpCPFSearchQueryVO oEmpCPFSearchQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public ArrayList getEmpCPFSearchHeader(EmpCPFSearchQueryVO oEmpCPFSearchQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public String saveoEmpCPFSearch(EmpCPFSearchBean oEmpCPFSearchBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getEmpCPFSearchLocLOVData(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public EmpCPFSearchComboVO getCPFSearchComboDetails() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
  
    //////////////////////////////// Six Pay implemented Special Allowances added by Anwar on 5th July, 2010 ///////////////////////////////////
  public BadClmtComboVOSixPay getBadClmtComboDetailsSixPay() throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  public LovVO getScreenListLOVDataN(LovQueryVO oLovQueryVO)  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public UsrRespComboVO getUsrRespComboVO()  throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;

    public RecordMetaInfo getUsrRespHeaderMetaInfo(UserRespQueryVO oUserRespQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getUsrRespHeader(UserRespQueryVO oUserRespQueryVO,long lStartPosition, long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public RecordMetaInfo getUserRespDetailMetaInfo(String sPrimaryKey, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public ArrayList getUserRespDetail(String sPrimaryKey,long lStartPosition,long lLastPosition, BaseDetailInfo oBaseDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
    public String saveUserRespMapping(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged,ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException, RemoteException;
  
 
}