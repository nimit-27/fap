/*
    * Module:        TEVBPVBD.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Business Delegate Class for TEV Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates;

import FCIPAY.HRMS.DATAACCESSTIER.DAO.TEVBPVDAO;
import FCIPAY.HRMS.DATAACCESSTIER.VO.TEVBPVVO;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.HRMS.UTILITY.TEVDtlBean;
import java.util.*;

public class TEVBPVBD 
{
     TEVBPVDAO oTBDAO = new TEVBPVDAO();
     TEVDtlBean oTBBean;

/**
     * This method retrieves LOC_DESC from COM_LOC_MST Table 
     * @param long lLocCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return String
*/ 
    public String getDocLoc(long lLocCode) throws IBAException,IBAFatalException,IBABusinessException
    {
        String sLocDesc = "";
        sLocDesc = oTBDAO.getDocLoc(lLocCode);
        return sLocDesc;
    }

/**
     * This method retrieves CLM_ID,CLM_NO from FIN_TR_CLM_HDR Table 
     * @param long lLocCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getClaims(long lLocCode) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstClaims = new ArrayList();
        List lstClaimsIds = new ArrayList();
        lstClaims = oTBDAO.getClaims(lLocCode);
        if(!lstClaims.isEmpty())
        {
            lstClaimsIds =(List) lstClaims.get(0);
            if(! lstClaimsIds.isEmpty())
                return lstClaims;                       
            else
                throw new IBABusinessException("Finance.TEVBPV.NoClaimFound");
        }
        else
        {
            throw new IBABusinessException("Finance.TEVBPV.NoClaimFound");
        }
    }

/**
     * This method retrieves A.TR_ID,B.TR_DESC, A.EMP_NO, C.EMP_FST_NAME + C.EMP_MDL_NAME + C.EMP_LST_NAME AS EMP_NAME
     *        FROM FIN_TR_CLM_HDR A, FIN_TR_TYPE B, HRM_EMPLOYEE C from FIN_TR_HDS Table for selected Claim No
     * @param String sClaimId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public TEVBPVVO getClaimDtls(String sClaimId,TEVBPVVO oTBVO) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstClaimDtls = new ArrayList();
        oTBDAO.getClaimDtls(sClaimId,oTBVO);
        if(!oTBVO.getLstClaimDtls().isEmpty())
        {
                return oTBVO;
        }
        else
        {
            throw new IBABusinessException("Finance.TEVBPV.NoClaimDtlsFound");
        }
    }

/**
     * This method retrieves active PRD_ID from FIN_CLNDR_PRD Table 
     * @param long lLocCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getCurrPrd(long lLocCode) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstPrd = new ArrayList();    
        lstPrd = oTBDAO.getCurrPrd(lLocCode);
        if(!lstPrd.isEmpty())
        {
            if(!((List) lstPrd.get(0)).isEmpty())
                return lstPrd;
            else
                throw new IBABusinessException("Finance.TEVBPV.NoPrdFound");
        }
        else
        {
            throw new IBABusinessException("Finance.TEVBPV.NoPrdFound");
        }
    }


/**
     * This method retrieves voucher details for the selected Claim No on clicking GET DETAILS
     * @param TEVBPVVO oTBVO
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public TEVBPVVO getVouchDetails(TEVBPVVO oTBVO) throws IBAException,IBAFatalException,IBABusinessException,NullPointerException
    {
        List lstVouchDtls = new ArrayList();
        List lstAcctDtls = new ArrayList();
        long i = 1;
        
        String sAcctId = "";
        String sTRType = "";
        String sDrAmt = "";
        String sCrAmt = "";
        long lBalDrAmt = 0;
        long lBalCrAmt = 0;
        String sBalDrAmt = "";
        String sBalCrAmt = "";
        String sClmNo = "";
        String sNarration = "";
        String sDtlType = "";
        String sExpenseAcctFlag = "Y";
        int j = 0;
        int k = 0;

// code to get claim no        
        if(! oTBVO.getLstClaimNoValues().isEmpty())
        {
            for(j=0;j < oTBVO.getLstClaimNoValues().size();j++)
            {
                if(((String) oTBVO.getLstClaimNoValues().get(j)).equals(oTBVO.getLstClaimNo()))
                {
                    sClmNo = (String) oTBVO.getLstClaimNoLabels().get(j);
                    j=oTBVO.getLstClaimNoValues().size();
                }
            }
        }
        else
            throw new IBABusinessException("Finance.TEVBPV.NoClaimFound");

// code to get travel type (local/foreign)            
        sTRType = oTBDAO.getTRType(oTBVO.getTrId());
        if(! sTRType.equals("TRAVELTYPE$FOREIGN"))
        {
            lstVouchDtls = this.getLocalVouchDtls(oTBVO,sClmNo);
        }
        else if(sTRType.equals("TRAVELTYPE$FOREIGN"))
        {
            lstVouchDtls = this.getFrVouchDtls(oTBVO,sClmNo);                        
        }
        else
            throw new IBABusinessException("Finance.TEVBPV.InvalidTravelType");

        if(lstVouchDtls.isEmpty())
            throw new IBABusinessException("Finance.TEVBPV.NoDtls");
            
        for(k=0;k<lstVouchDtls.size();k++)
        {
            sDrAmt = removeComma(((TEVDtlBean)lstVouchDtls.get(k)).getTxtDrAmt());
            sCrAmt = removeComma(((TEVDtlBean)lstVouchDtls.get(k)).getTxtCrAmt());
            if(!sDrAmt.equals(""))
                lBalDrAmt = lBalDrAmt + (new Long(sDrAmt)).longValue();
            if(!sCrAmt.equals(""))
                lBalCrAmt = lBalCrAmt + (new Long(sCrAmt)).longValue();
        }        

        if(lBalDrAmt != lBalCrAmt)
        {
            i = lstVouchDtls.size()+1;
            if(lBalDrAmt < lBalCrAmt)
            {
                sAcctId = oTBDAO.getTRAcctId(oTBVO.getTrId(),"REC_ACCT_ID");
                if(sAcctId.equals(""))
                    throw new IBABusinessException("Finance.TEV.InvalidAcct");
                sExpenseAcctFlag = "Y";
                lstAcctDtls = this.getAcctDtls(sAcctId,oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
                if(lstAcctDtls.isEmpty())
                    throw new IBABusinessException("Finance.TEV.InvalidAcct");
                sNarration = "Amount to be Recovered";
                sDtlType = "Recovery";
                sCrAmt = "";
                sDrAmt = (new Long(lBalCrAmt - lBalDrAmt)).toString();
                lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,oTBVO.getTxtEmpNo(),(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,setCommaForAmt(sDrAmt),sCrAmt));                        
                oTBVO.setTxtTotCr(setCommaForAmt(new Long(lBalCrAmt).toString()));
                oTBVO.setTxtTotDr(setCommaForAmt(new Long(lBalCrAmt).toString()));
            }
            else
            {
                sAcctId = oTBDAO.getTRAcctId(oTBVO.getTrId(),"TR_ACCT_ID");
                if(sAcctId.equals(""))
                    throw new IBABusinessException("Finance.TEV.InvalidAcct");
                sExpenseAcctFlag = "Y";
                lstAcctDtls = this.getAcctDtls(sAcctId,oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
                if(lstAcctDtls.isEmpty())
                    throw new IBABusinessException("Finance.TEV.InvalidAcct");
                sNarration = "Amount for Payment";
                sDtlType ="Payment";
                sDrAmt = "";
                sCrAmt = (new Long(lBalDrAmt - lBalCrAmt)).toString();
                lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,oTBVO.getTxtEmpNo(),(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,sDrAmt,setCommaForAmt(sCrAmt)));                        
                oTBVO.setTxtTotCr(setCommaForAmt(new Long(lBalDrAmt).toString()));
                oTBVO.setTxtTotDr(setCommaForAmt(new Long(lBalDrAmt).toString()));                
            }                
        }       
            
        if(!lstVouchDtls.isEmpty())        
            oTBVO.setVoucherDtls(lstVouchDtls);
        else
            throw new IBABusinessException("Finance.TEVBPV.NoDtls");
        return oTBVO;
    }    

/**
     * This method retrieves ACCT_STATUS,CTRL_ACCT,CHG_FLG,CC_FLG from FIN_ACCT_MST Table 
     * @param String sAcctId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List(ACCT_STATUS,CTRL_ACCT,CHG_FLG,CC_FLG)
*/ 
    public List getAcctDtls(String sAcctId,String sEmpNo,String sExpAcctFlg) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstAcctDtls = new ArrayList();
        List lstEmpCCChCode = new ArrayList();

        lstAcctDtls = oTBDAO.getAcctDtls(sAcctId);
        if(! lstAcctDtls.isEmpty())
        {            
            if(!((String) lstAcctDtls.get(0)).equals("I"))
            {
                if(((String) lstAcctDtls.get(1)).equals(sExpAcctFlg))
                {                   
                        if(((String) lstAcctDtls.get(2)).equals("Y") || ((String) lstAcctDtls.get(3)).equals("Y"))
                        {
                            lstEmpCCChCode = oTBDAO.getEmpCCnChCode(sEmpNo); 
                            //lstEmpCCChCode List of (Charge Code, Cost Centre Sub Group Code)
                            if(lstEmpCCChCode.isEmpty())
                                throw new IBABusinessException("Finance.TEVBPV.EmpDtlNotFound");
                            if(((String) lstAcctDtls.get(2)).equals("Y") && ((String) lstAcctDtls.get(3)).equals("Y"))
                                return lstEmpCCChCode;
                            else if(((String) lstAcctDtls.get(2)).equals("Y"))
                                lstEmpCCChCode.set(1,"");
                            else if(((String) lstAcctDtls.get(3)).equals("Y"))
                                lstEmpCCChCode.set(0,"");
                            return lstEmpCCChCode;
                        }
                        else
                        {
                            lstEmpCCChCode.add("");
                            lstEmpCCChCode.add("");
                            return lstEmpCCChCode;
                        }                                                           
                }
                else
                    throw new IBABusinessException("Finance.TEV.InvalidAcct");
            }
            else
                throw new IBABusinessException("Finance.TEV.InvalidAcct");
        }
        else
            throw new IBABusinessException("Finance.TEV.InvalidAcct");
    }        

/**
     * This method inserts record in FIN_VOUCHER_HDR, FIN_VOUCHER_DTL, FIN_PAYROLL_INTERFACE and
     *             updates record in FIN_VOUCHER_PARAMS_VHNO, FIN_TR_CLM_HDR 
     * @param TEVBPVVO oTBVO
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return true, false
*/ 
    public boolean saveDetails(TEVBPVVO oTBVO) throws IBAException,IBAFatalException,IBABusinessException
    {
        oTBDAO.validateDatePeriod(oTBVO.getLstPeriod(),oTBVO.getTxtClaimDate(),oTBVO.getLLocationCode());
        if(oTBDAO.saveDetails(oTBVO))
        {
           return true;
        }
        else
        {
            return false;
        }
    }

/**
     * This method inserts record in FIN_VOUCHER_HDR, FIN_VOUCHER_DTL, FIN_PAYROLL_INTERFACE and
     *             updates record in FIN_VOUCHER_PARAMS_VHNO, FIN_TR_CLM_HDR 
     * @param TEVBPVVO oTBVO
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return true, false
*/ 
    public boolean updateOnSendBack(TEVBPVVO oTBVO) throws IBAException,IBAFatalException,IBABusinessException
    {
        if(oTBDAO.updateOnSendBack(oTBVO))
        {
           return true;
        }
        else
        {
            return false;
        }
    }    

/** This method is used to set comma for amounts
    * @param value
    * @return String
*/
    public String setCommaForAmt(String value)
    {
        if(value.length() > 3)
        {
            String newVal="";
            int j = 4;
            for(int count=value.length()-1; count>=0; count--)
            {
                char ch=value.charAt(count);
                if((count == (value.length() - j)) && ch != '-')
                {
                    newVal+=",";
                    newVal+=ch;
                    j = j+2;
                }
                else
                newVal+=ch;            
            }              
            value = "";
            for(int count=newVal.length()-1;count>=0;count--)
            {
                char ch=newVal.charAt(count);
                value+= ch;
            }        
            return value;
        }
        else
        return value;
    }

/**
    * This method removes comma from the amount field
    * @param String sAmt
    * @return String
*/ 
    public String removeComma(String sAmt)
    {
        String sNewAmt = "";
        for(int i = 0; i< sAmt.length(); i++)
        {
            char ch = sAmt.charAt(i);
            if( ch != ',')
            sNewAmt = sNewAmt + ch;
        }
        return sNewAmt;
    }    

/**
     * This method retrieves voucher details for the selected Claim No in case of foreign travel
     * @param TEVBPVVO oTBVO, String sClmNo
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getFrVouchDtls (TEVBPVVO oTBVO,String sClmNo) throws IBAException,IBAFatalException,IBABusinessException,NullPointerException
    {
        List lstVouchDtls = new ArrayList();
        List lstAcctDtls = new ArrayList();
        List lstClaims = new ArrayList();
        List lstExpenseAccts = new ArrayList();
        List lstSancAmt = new ArrayList();
        List lstDepOrderDtls = new ArrayList();
        List lstDepOrderAmt = new ArrayList();
        List lstDepOrderConvRate = new ArrayList();        
        List lstForeignRefunds = new ArrayList();
        List lstForeignRefundAmt = new ArrayList();
        List lstForeignRefundConvRate = new ArrayList();
        long lTotAdvance = 0;
        long lTotRefund = 0;
        long lFrCurrRefund = 0;
        long lTotPenalty = 0;
        long lTXNAmt = 0;
        long lTotFCClaim = 0;
        long lDepOrderAmt = 0;
        double dDepOrderConvRate = 0;
        long lFCClaimAmt = 0;
        long lFCForeignAmt = 0;
        long lFrReceiptAmt = 0;
        long lFrCurrencydiff = 0;
        double dFrReceiptCoveRate = 0;
        long i = 1;
        
        String sAcctId = "";
        String sTRType = "";
        String sDrAmt = "";
        String sCrAmt = "";
        long lBalDrAmt = 0;
        long lBalCrAmt = 0;
        String sBalDrAmt = "";
        String sBalCrAmt = "";
        String sNarration = "";
        String sDtlType = "";
        String sExpenseAcctFlag = "Y";
        int j = 0;
        int k = 0;
        int iDepCount = 0;

// code for local Advance and refund        
        lTotAdvance = oTBDAO.getTotAdvance(oTBVO.getLstClaimNo());
        lTotRefund = oTBDAO.getFRLocTotRefunds(oTBVO.getLstClaimNo());

        lTXNAmt = lTotAdvance - lTotRefund;
        sAcctId = oTBDAO.getAdvAcctId(oTBVO.getTrId());    
        if(!sAcctId.equals(""))
        {
            sExpenseAcctFlag = "Y";
            lstAcctDtls = this.getAcctDtls(sAcctId, oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
            if(lstAcctDtls.isEmpty())
                throw new IBABusinessException("Finance.TEV.InvalidAcct");
        }
        else
            throw new IBABusinessException("Finance.TEV.InvalidAcct");
        if(lTXNAmt != 0)
        {
//            sAcctId = oTBDAO.getAdvAcctId(oTBVO.getTrId());
            if(!sAcctId.equals(""))
            {
                if(lTXNAmt > 0)
                {
                    sCrAmt = new Long(lTXNAmt).toString();
                    sNarration = "Advance";
                    sDtlType = "Advance";
                }
                else
                {
                    sDrAmt = new Long(-1*lTXNAmt).toString();
                    sNarration = "Local Receipt";
                    sDtlType = "Refund";
                }
//                sExpenseAcctFlag = "Y";
//                lstAcctDtls = this.getAcctDtls(sAcctId, oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
                        
                lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,oTBVO.getTxtEmpNo(),(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,setCommaForAmt(sDrAmt),setCommaForAmt(sCrAmt)));                        
            }                    
        }

// code for deputation amount detail        
        lDepOrderAmt = oTBDAO.getTotDepOrderAmt(oTBVO.getLstClaimNo());
        if(lDepOrderAmt != 0)
        {
            sCrAmt = new Long(lDepOrderAmt).toString();
            sDrAmt = "";
            sNarration = "Deputation Order Amount";
            sDtlType = "DepOrder";
            lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,oTBVO.getTxtEmpNo(),(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,sDrAmt,setCommaForAmt(sCrAmt)));
            lDepOrderAmt = 0;
        }
        
// code for local travel claims        
        lstClaims = oTBDAO.getFRLocClaimSanctAmt(oTBVO.getLstClaimNo());
        if(!lstClaims.isEmpty())
        {                
            lstExpenseAccts =(List) lstClaims.get(0);
            lstSancAmt = (List) lstClaims.get(1);
            if(!lstExpenseAccts.isEmpty() && !lstSancAmt.isEmpty())
            {
                for(k=0;k<lstExpenseAccts.size();k++)
                {
                    sDtlType = "Claim";
                    sAcctId = (String) lstExpenseAccts.get(k);
                    if(sAcctId.equals(""))
                        throw new IBABusinessException("Finance.TEV.InvalidAcct");
                    sNarration = "Local Travel Expense";
                    lstAcctDtls.clear();
                    sExpenseAcctFlag = "N";                    
                    lstAcctDtls = this.getAcctDtls(sAcctId, oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
                    if(lstAcctDtls.isEmpty())
                        throw new IBABusinessException("Finance.TEV.InvalidAcct");
                    sDrAmt = (String) lstSancAmt.get(k);
                    sCrAmt = "";
                    lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,"",(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,setCommaForAmt(sDrAmt),sCrAmt));                        
                }
            }
        }

// code for foreign travel claim        
        lstClaims = new ArrayList();
        lstClaims = oTBDAO.getFRClaimSanctAmt(oTBVO.getLstClaimNo());
        if(!lstClaims.isEmpty())
        {                
            lstExpenseAccts =(List) lstClaims.get(0);
            lstSancAmt = (List) lstClaims.get(1);
            if(!lstExpenseAccts.isEmpty() && !lstSancAmt.isEmpty())
            {
                lstDepOrderDtls = oTBDAO.getFRDepOrderDtls(oTBVO.getLstClaimNo());
                if(((List) lstDepOrderDtls.get(0)).isEmpty())
                    throw new IBABusinessException("Finance.TEVBPV.NoDepOrderDtls");
                else
                {
                    lstDepOrderAmt = (List) lstDepOrderDtls.get(0);
                    lstDepOrderConvRate = (List) lstDepOrderDtls.get(1);
                }
                for(k=0;k<lstExpenseAccts.size();k++)
                {  
                    lFCClaimAmt = 0;
    //                        lstExpenseAccts =(List) lstClaims.get(k);
    //                        lstSancAmt = (List) lstClaims.get(k);                        
                        
                    sDtlType = "Claim";
                    sAcctId = (String) lstExpenseAccts.get(k);
                    if(sAcctId.equals(""))
                        throw new IBABusinessException("Finance.TEV.InvalidAcct");
                    sNarration = "Foreign Travel Expense";
                    lstAcctDtls.clear();
                    sExpenseAcctFlag = "N";
                    lstAcctDtls = this.getAcctDtls(sAcctId, oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
                    if(lstAcctDtls.isEmpty())
                        throw new IBABusinessException("Finance.TEV.InvalidAcct");
                    sDrAmt = (String) lstSancAmt.get(k);
                    sCrAmt = "";
                    lFCForeignAmt = new Long(sDrAmt).longValue();
                    if(!lstDepOrderAmt.isEmpty())
                    {                            
                        lDepOrderAmt = new Long((String) lstDepOrderAmt.get(0)).longValue();
                        dDepOrderConvRate = new Double((String) lstDepOrderConvRate.get(0)).doubleValue();
                        if(lFCForeignAmt > lDepOrderAmt) 
                        {
                            while(lFCForeignAmt > 0)
                            {
                                if(! lstDepOrderAmt.isEmpty())
                                {
                                    lDepOrderAmt = new Long((String) lstDepOrderAmt.get(0)).longValue();
                                    dDepOrderConvRate = new Double((String) lstDepOrderConvRate.get(0)).doubleValue();
                                    if(lFCForeignAmt > lDepOrderAmt)
                                    {
                                        lFCClaimAmt = lFCClaimAmt + Math.round(lDepOrderAmt * dDepOrderConvRate);     
                                        lFCForeignAmt = lFCForeignAmt - lDepOrderAmt;
                                        lstDepOrderAmt.remove(0);
                                        lstDepOrderConvRate.remove(0);
                                    }
                                    else
                                    {
                                        lFCClaimAmt = lFCClaimAmt + Math.round(lFCForeignAmt * dDepOrderConvRate);                                                                                        
                                        lDepOrderAmt = lDepOrderAmt - lFCForeignAmt;
                                        lFCForeignAmt = 0;
                                        lstDepOrderAmt.remove(0);
                                        lstDepOrderAmt.add(0,new Long(lDepOrderAmt).toString());
                                    }
                                }
                                else
                                {
                                    lFCClaimAmt = lFCClaimAmt + Math.round((lFCForeignAmt * dDepOrderConvRate));
                                    lFCForeignAmt = 0;
                                }
                            }
                        }
                        else
                        {
                            lDepOrderAmt = new Long((String) lstDepOrderAmt.get(0)).longValue();
                            dDepOrderConvRate = new Double((String) lstDepOrderConvRate.get(0)).doubleValue();
                            lFCClaimAmt = lFCClaimAmt + Math.round(lFCForeignAmt * dDepOrderConvRate);                                                                            
                            lDepOrderAmt = lDepOrderAmt - lFCForeignAmt;
                            lFCForeignAmt = 0;
                            lstDepOrderAmt.remove(0);
                            lstDepOrderAmt.add(0,new Long(lDepOrderAmt).toString());
                        }
                        sDrAmt = new Long(lFCClaimAmt).toString();
                        lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,"",(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,setCommaForAmt(sDrAmt),sCrAmt));                        
                        lTotFCClaim = lTotFCClaim + new Long(sDrAmt).longValue();
                    }
                    else
                        throw new IBABusinessException("Finance.TEVBPV.DepOrderDtlsNotFound");
                }
            }
        }            

// code for foreign currency refund             
        lFrCurrRefund = oTBDAO.getFRRefundDtls(oTBVO.getLstClaimNo());
        if(lFrCurrRefund != 0)
        {
            sDtlType = "Refund";
            sAcctId = oTBDAO.getAdvAcctId(oTBVO.getTrId());
            if(!sAcctId.equals(""))
            {
                sDrAmt = new Long(lFrCurrRefund).toString();
                sCrAmt = "";
                sNarration = "Foreign Travel Receipt";
                sExpenseAcctFlag = "Y";
                lstAcctDtls = this.getAcctDtls(sAcctId, oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
                if(!lstAcctDtls.isEmpty())                    
                    lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,oTBVO.getTxtEmpNo(),(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,setCommaForAmt(sDrAmt),sCrAmt));
                else
                    throw new IBABusinessException("Finance.TEV.InvalidAcct");                
            }
        }                   

// code for foreing currency loss or gain        
        lstForeignRefunds = oTBDAO.getFRReceiptDtls(oTBVO.getLstClaimNo());                            
        if(!lstForeignRefunds.isEmpty())
        {
            if(!((List) lstForeignRefunds.get(0)).isEmpty())
            {
                lstForeignRefundAmt = (List) lstForeignRefunds.get(0);
                lstForeignRefundConvRate = (List) lstForeignRefunds.get(1);
                for(k=0;k<lstForeignRefundAmt.size();k++)
                {
                    lFrReceiptAmt = new Long((String) lstForeignRefundAmt.get(k)).longValue();
                    dFrReceiptCoveRate = new Double((String) lstForeignRefundConvRate.get(k)).doubleValue();
                    if(!lstDepOrderAmt.isEmpty())
                    {                            
                        lDepOrderAmt = new Long((String) lstDepOrderAmt.get(0)).longValue();
                        dDepOrderConvRate = new Double((String) lstDepOrderConvRate.get(0)).doubleValue();
                        if(lFrReceiptAmt > lDepOrderAmt) 
                        {
                            while(lFrReceiptAmt > 0)
                            {
                                if(! lstDepOrderAmt.isEmpty())
                                {
                                    lDepOrderAmt = new Long((String) lstDepOrderAmt.get(0)).longValue();
                                    dDepOrderConvRate = new Double((String) lstDepOrderConvRate.get(0)).doubleValue();
                                    if(lFrReceiptAmt > lDepOrderAmt)
                                    {
                                        lFrCurrencydiff = lFrCurrencydiff + Math.round((dFrReceiptCoveRate - dDepOrderConvRate)*lDepOrderAmt);     
                                        lFrReceiptAmt = lFrReceiptAmt - lDepOrderAmt;
                                        lstDepOrderAmt.remove(0);
                                        lstDepOrderConvRate.remove(0);
                                    }
                                    else
                                    {
                                        lFrCurrencydiff = lFrCurrencydiff + Math.round((dFrReceiptCoveRate -  dDepOrderConvRate)*lFrReceiptAmt);                                                                                        
                                        lDepOrderAmt = lDepOrderAmt - lFrReceiptAmt;
                                        lFrReceiptAmt = 0;
                                        lstDepOrderAmt.remove(0);
                                        lstDepOrderAmt.add(0,new Long(lDepOrderAmt).toString());
                                    }
                                }                                    
                            }
                        }
                        else
                        {
                            lDepOrderAmt = new Long((String) lstDepOrderAmt.get(0)).longValue();
                            dDepOrderConvRate = new Double((String) lstDepOrderConvRate.get(0)).doubleValue();
                            lFrCurrencydiff = lFrCurrencydiff + Math.round((dFrReceiptCoveRate - dDepOrderConvRate)*lFrReceiptAmt);
                            lDepOrderAmt = lDepOrderAmt - lFrReceiptAmt;
                            lFrReceiptAmt = 0;
                            lstDepOrderAmt.remove(0);
                            lstDepOrderAmt.add(0,new Long(lDepOrderAmt).toString());
                        }                            
                    }
                }
                if(lFrCurrencydiff != 0)
                {
                    if(lFrCurrencydiff > 0)
                    {
                        sCrAmt = new Long(lFrCurrencydiff).toString();
                        sDrAmt = "";
                        sNarration = "Foreign Currency Gain";
                    }                            
                    else
                    {
                        sDrAmt = new Long(lFrCurrencydiff).toString();
                        sCrAmt = "";
                        sNarration = "Foreign Currency Loss";
                    }                            
                    sDtlType = "CurrLossGain";
                    sAcctId = oTBDAO.getTRAcctId(oTBVO.getTrId(),"FE_LOSS_GAIN_ACCT");
                    if(sAcctId.equals(""))
                        throw new IBABusinessException("Finance.TEV.InvalidAcct");
                    lstAcctDtls.clear();
                    sExpenseAcctFlag = "N";
                    lstAcctDtls = this.getAcctDtls(sAcctId, oTBVO.getTxtEmpNo(),sExpenseAcctFlag);                    
                    if(lstAcctDtls.isEmpty())
                        throw new IBABusinessException("Finance.TEV.InvalidAcct");
                    lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,"",(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,setCommaForAmt(sDrAmt),setCommaForAmt(sCrAmt)));
                        
                }
                    
            }
        }

// code for penalty on local component of travel        
        lTotPenalty = oTBDAO.getTotPenalty(oTBVO.getLstClaimNo());
        if(lTotPenalty > 0)
        {
            sAcctId = oTBDAO.getTRAcctId(oTBVO.getTrId(),"PENALTY_ACCT_ID");
            if(sAcctId.equals(""))
                throw new IBABusinessException("Finance.TEV.InvalidAcct");            
            sExpenseAcctFlag = "N";
            lstAcctDtls = this.getAcctDtls(sAcctId,oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
            if(lstAcctDtls.isEmpty())
                throw new IBABusinessException("Finance.TEV.InvalidAcct");
            sNarration = "Peanlty Revenue";
            sCrAmt =  (new Long(lTotPenalty)).toString();
            sDrAmt = "";
            sDtlType = "Penalty";
            lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,oTBVO.getTxtEmpNo(),(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,sDrAmt,setCommaForAmt(sCrAmt)));                        
            sAcctId = oTBDAO.getTRAcctId(oTBVO.getTrId(),"REC_ACCT_ID");
            if(sAcctId.equals(""))
                throw new IBABusinessException("Finance.TEV.InvalidAcct");
            sExpenseAcctFlag = "Y";
            lstAcctDtls = this.getAcctDtls(sAcctId,oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
            if(lstAcctDtls.isEmpty())
                throw new IBABusinessException("Finance.TEV.InvalidAcct");            
            sNarration = "Penalty to be Recovered";
            sDtlType = "Recovery";
            sDrAmt = (new Long(lTotPenalty)).toString();
            sCrAmt = "";
            lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,oTBVO.getTxtEmpNo(),(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,setCommaForAmt(sDrAmt),sCrAmt));                                        
        }                               
        return lstVouchDtls;
    }

/**
     * This method retrieves voucher details for the selected Claim No in case of Local travel
     * @param TEVBPVVO oTBVO, String sClmNo
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/     

    public List getLocalVouchDtls (TEVBPVVO oTBVO,String sClmNo) throws IBAException,IBAFatalException,IBABusinessException,NullPointerException
    {
        List lstVouchDtls = new ArrayList();
        List lstAcctDtls = new ArrayList();
        List lstClaims = new ArrayList();
        List lstExpenseAccts = new ArrayList();
        List lstSancAmt = new ArrayList();
        
        long lTotAdvance = 0;
        long lTotRefund = 0;
        long lTotPenalty = 0;
        long lTXNAmt = 0;

        long i = 1;
        
        String sAcctId = "";
        String sTRType = "";
        String sDrAmt = "";
        String sCrAmt = "";
        long lBalDrAmt = 0;
        long lBalCrAmt = 0;
        String sBalDrAmt = "";
        String sBalCrAmt = "";        
        String sNarration = "";
        String sDtlType = "";
        String sExpenseAcctFlag = "Y";
        int j = 0;
        int k = 0;

// code to get Advance/refund amount against selected claim no
        lTotAdvance = oTBDAO.getTotAdvance(oTBVO.getLstClaimNo());
        lTotRefund = oTBDAO.getTotRefunds(oTBVO.getLstClaimNo());

        lTXNAmt = lTotAdvance - lTotRefund;
            
        if(lTXNAmt != 0)
        {
            sAcctId = oTBDAO.getAdvAcctId(oTBVO.getTrId());
            if(!sAcctId.equals(""))
            {
                if(lTXNAmt > 0)
                {
                    sCrAmt = new Long(lTXNAmt).toString();
                    sNarration = "Advance";
                    sDtlType = "Advance";
                }
                else
                {
                    sDrAmt = new Long(-1*lTXNAmt).toString();
                    System.out.println("DR AMOUNT BD"+sDrAmt);
                    sNarration = "Receipt";
                    sDtlType = "Refund";
                }
                sExpenseAcctFlag = "Y";
                lstAcctDtls = this.getAcctDtls(sAcctId,oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
                if(lstAcctDtls.isEmpty())
                    throw new IBABusinessException("Finance.TEV.InvalidAcct");  
                    //added by bhavna 
                    

                    //added by bhavna
                lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,oTBVO.getTxtEmpNo(),(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,setCommaForAmt(sDrAmt),setCommaForAmt(sCrAmt)));                        
                System.out.println("lstVouchDTls size "+lstVouchDtls.size());
            }  
            else
                throw new IBABusinessException("Finance.TEV.InvalidAcct");
        }

// code to get claim amount account wise for selected claim no         
        lstClaims = oTBDAO.getClaimSanctAmt(oTBVO.getLstClaimNo());
        if(!lstClaims.isEmpty())
        {
            lstExpenseAccts =(List) lstClaims.get(0);
            lstSancAmt = (List) lstClaims.get(1);
            if(!lstExpenseAccts.isEmpty() && !lstSancAmt.isEmpty())
            {
                for(k=0;k<lstExpenseAccts.size();k++)
                {
                    sDtlType = "Claim";
                    sAcctId = (String) lstExpenseAccts.get(k);                    
                    if(sAcctId.equals(""))
                        throw new IBABusinessException("Finance.TEV.InvalidAcct");
                    sNarration = "Claim Expense";
                    lstAcctDtls.clear();
                    sExpenseAcctFlag = "N";                    
                    lstAcctDtls = this.getAcctDtls(sAcctId, oTBVO.getTxtEmpNo(), sExpenseAcctFlag);
                    if(lstAcctDtls.isEmpty())
                        throw new IBABusinessException("Finance.TEV.InvalidAcct");
                    sDrAmt = (String) lstSancAmt.get(k);
                    System.out.println("DR AMOUNT CLAIMS BD"+sDrAmt);
                    sCrAmt = "";
                    //added by bhavna 17/05/2005 for supressing 0 values 
                    if(!sDrAmt.equals("0"))
                    {
                            lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,"",(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,setCommaForAmt(sDrAmt),sCrAmt));                        
                    }
                }
                
            }
        } 

// code to calculate penalty for selected claim no
        lTotPenalty = oTBDAO.getTotPenalty(oTBVO.getLstClaimNo());
        if(lTotPenalty > 0)
        {
            sAcctId = oTBDAO.getTRAcctId(oTBVO.getTrId(),"PENALTY_ACCT_ID");
            if(sAcctId.equals(""))
                throw new IBABusinessException("Finance.TEV.InvalidAcct");
            sExpenseAcctFlag = "N";
            lstAcctDtls = this.getAcctDtls(sAcctId,oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
            if(lstAcctDtls.isEmpty())
                throw new IBABusinessException("Finance.TEV.InvalidAcct");
            sNarration = "Peanlty Revenue";
            sCrAmt =  (new Long(lTotPenalty)).toString();
            sDrAmt = "";
            sDtlType = "Penalty";
            lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,"",(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,sDrAmt,setCommaForAmt(sCrAmt)));                        
            sAcctId = oTBDAO.getTRAcctId(oTBVO.getTrId(),"REC_ACCT_ID");
            if(sAcctId.equals(""))
                throw new IBABusinessException("Finance.TEV.InvalidAcct");
            sExpenseAcctFlag = "Y";
            lstAcctDtls = this.getAcctDtls(sAcctId,oTBVO.getTxtEmpNo(),sExpenseAcctFlag);
            if(lstAcctDtls.isEmpty())
                throw new IBABusinessException("Finance.TEV.InvalidAcct");
            sNarration = "Penalty to be Recovered";
            sDtlType = "Recovery";
            sDrAmt = (new Long(lTotPenalty)).toString();
            sCrAmt = "";                
            lstVouchDtls.add(new TEVDtlBean(sDtlType,i++,sNarration,sAcctId,oTBVO.getTxtEmpNo(),(String) lstAcctDtls.get(0),(String) lstAcctDtls.get(1),sClmNo,setCommaForAmt(sDrAmt),sCrAmt));                                        
        }
        return lstVouchDtls;
    }
}