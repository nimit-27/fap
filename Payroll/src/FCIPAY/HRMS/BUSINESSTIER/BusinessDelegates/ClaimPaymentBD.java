/*
    * Module:        ClaimPaymentBD.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Business Delegate Class for Claim Payment through Voucher Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates;

import java.util.*;
import FCIPAY.HRMS.DATAACCESSTIER.VO.ClaimPaymentVO;
import FCIPAY.HRMS.DATAACCESSTIER.DAO.ClaimPaymentDAO;
import FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates.TEVBPVBD;
import FCIPAY.HRMS.DATAACCESSTIER.DAO.TEVBPVDAO; 
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.HRMS.UTILITY.ClaimPaymentBean;

public class ClaimPaymentBD 
{
   ClaimPaymentDAO oCPDAO = new ClaimPaymentDAO();
   TEVBPVBD oTBBD = new TEVBPVBD();
   TEVBPVDAO oTBDAO = new TEVBPVDAO();

/**
     * This method retrieves active PRD_ID from FIN_CLNDR_PRD Table 
     * @param long lLocCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getBPVCPVCurrPrd(long lLocCode) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstPrd = new ArrayList();    
        lstPrd = oCPDAO.getBPVCPVCurrPrd(lLocCode);
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
     * This method retrieves EMP_NO from FIN_PAYROLL_INTERFACE Table 
     * @param long lLocCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
   public List getEmpNos(long lLocCode,String sModuleId) throws IBABusinessException,IBAException,IBAFatalException
   {
       List lstEmpNos = new ArrayList();
       lstEmpNos = oCPDAO.getEmpNos(lLocCode,sModuleId);
       if(!lstEmpNos.isEmpty())
       {
           return lstEmpNos;
       }
       else
       {
           throw new IBABusinessException("Finance.ClaimPay.NoEmpFound");
       }       
   }
   
/**
     * This method retrieves C.EMP_FST_NAME + C.EMP_MDL_NAME + C.EMP_LST_NAME AS EMP_NAME FROM HRM_EMPLOYEE
     * @param String sEmpNo
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return String
*/ 
   public String getEmpDtls(String sEmpNo) throws IBABusinessException,IBAException,IBAFatalException
   {
       String sEmpName = "";
       sEmpName = oCPDAO.getEmpDtls(sEmpNo);
       return sEmpName;
   }

/**
     * This method retrieves A.RECORD_ID,A.RECORD_SOURCE,A.ACCT_ID,A.TXN_AMT 
     *                       FROM FIN_PAYROLL_INTERFACE A, FIN_VOUCHER_HDR B
     * @param ClaimPaymentVO oCPVO
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getVouchDetails(ClaimPaymentVO oCPVO) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstOldVouchDtls = new ArrayList();
        List lstVouchDtls = new ArrayList();
        List lstAcctDtls = new ArrayList(); 
        String sExpAcctFlg = "Y";
        ClaimPaymentBean oCPBean;
       
        String sAcctId = "";
        int i = 0;        

        lstOldVouchDtls = oCPDAO.getVouchDtls(oCPVO);
        if(!lstOldVouchDtls.isEmpty())
        {
            for(i=0;i<lstOldVouchDtls.size();i++)
            {
                oCPBean =(ClaimPaymentBean)lstOldVouchDtls.get(i);
                sAcctId = oCPBean.getTxtAcctId();
                lstAcctDtls = oTBBD.getAcctDtls(sAcctId,oCPVO.getLstEmpNo(),sExpAcctFlg);
                lstVouchDtls.add(new ClaimPaymentBean(oCPBean.getRecordId(),oCPBean.getTxtSNo(),oCPBean.getTxtParticulars(),sAcctId,oCPVO.getLstEmpNo(),(String) lstAcctDtls.get(0), (String) lstAcctDtls.get(1),oCPBean.getTxtDrAmt()));
            }
            
        }
        return lstVouchDtls;                  
            
    }    

/**
     * This method inserts record in FIN_VOUCHER_HDR, FIN_VOUCHER_DTL and
     *             updates record in FIN_VOUCHER_PARAMS_VHNO, FIN_PAYROLL_INTERFACE 
     * @param ClaimPaymentVO oCPVO
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return true, false
*/ 
    public boolean saveDetails(ClaimPaymentVO oCPVO) throws IBAException,IBAFatalException,IBABusinessException
    {
        oTBDAO.validateDatePeriod(oCPVO.getLstPeriod(),oCPVO.getTxtVouchDate(),oCPVO.getLLocationCode());
        if(oCPDAO.saveDetails(oCPVO))
        {
           return true;
        }
        else
        {
            return false;
        }
    }    
}