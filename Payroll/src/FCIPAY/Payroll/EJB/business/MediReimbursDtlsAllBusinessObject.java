package FCIPAY.Payroll.EJB.business;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.ComboVO;
import FCIPAY.Payroll.common.vo.LovVO;
import FCIPAY.Payroll.common.bean.LOVBean;
import java.sql.SQLException;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.UTILITY.DummyHeaderBean;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.business.BaseBO;
import FCIPAY.Payroll.EJB.common.utility.PositionResolver;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.common.utility.EnrgiseUtil;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.DATAACCESSTIER.VO.MediReimbursDtlsAllQueryVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.LoanDtlsAllDetailInfo;
import FCIPAY.Payroll.UTILITY.MediReimbursDtlsAllHeaderBean;

import FCIPAY.Payroll.DATAACCESSTIER.VO.MediReimbDtlsAllDetailInfo; // added by devendra on 3rd sept 2010
import FCIPAY.Payroll.UTILITY.LoanDtlsAllDetailBean;


public class MediReimbursDtlsAllBusinessObject extends BaseBO
{
      public MediReimbursDtlsAllBusinessObject()
  {
  }
  
  public void updateHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
      oParameters = new ArrayList();
  }


  public String saveNewHeaderImpl(BaseHeaderBean oBaseHeaderBean) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = null; //Input Parameters
    //DBUtilitiesBean oBean = new DBUtilitiesBean();
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBean1 = null;
    DBUtilitiesBean oBean2 = null;
    ArrayList oList;    
    int count = 0;
    int i=0;
    MediReimbursDtlsAllHeaderBean mediReimbursDtlsAllHeaderBean = (MediReimbursDtlsAllHeaderBean)oBaseHeaderBean;
    ArrayList oOutArray; //Output   
    //extract the employee numbers from the txtEmpNo which has to be excluded start
    ArrayList excludedEmpList = new ArrayList();
    String empList = mediReimbursDtlsAllHeaderBean.getTxtEmpList();
    String [] empListArr = empList.split(",");
    if(!empListArr.equals("") && !empList.equalsIgnoreCase(""))
    {
        for(int q=0;q<empListArr.length;q++)
        {
            excludedEmpList.add(empListArr[q]);
        }
    }
    // getting all the eligible employees which do not have reimbursment requests for the given quater of given fin year.
    
      ArrayList oOutArray1=null;   // used for  getting the eligible employees for reimbursment
      ArrayList oParameters1 = null;
      ArrayList empListArrList = null;
      oBean1 = new DBUtilitiesBean();
      oParameters1 = new ArrayList();  
      if (mediReimbursDtlsAllHeaderBean.getTxtPayCode().equals("138"))
      {
          oParameters1.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getHdnEmpLbrFlag())));
          oParameters1.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtPayCode())));
          oParameters1.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getyearMonth())));
          oParameters1.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID()))); 
          oParameters1.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
          oOutArray1 = oBean1.callProc(oParameters1,"pkg_payroll_misc.proc_geteligempsforconyreim(?,?,?,?,?)",true,true);      
    
      }
      
     else if (mediReimbursDtlsAllHeaderBean.getTxtPayCode().equals("132"))
          {
              oParameters1.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getHdnEmpLbrFlag())));
              oParameters1.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtPayCode())));
              oParameters1.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getFinYear())));
              oParameters1.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID()))); 
              oParameters1.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
              oOutArray1 = oBean1.callProc(oParameters1,"pkg_payroll_misc_ext.proc_getElgEmpsForExGratia(?,?,?,?,?)",true,true); 
          }
      else if (mediReimbursDtlsAllHeaderBean.getTxtPayCode().equals("195"))
      {
          oParameters1.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getHdnEmpLbrFlag())));
          oParameters1.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtPayCode())));
          oParameters1.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getFinYear())));
          oParameters1.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID()))); 
          oParameters1.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
          oOutArray1 = oBean1.callProc(oParameters1,"pkg_payroll_misc_ext.proc_getElgEmpsForPLI(?,?,?,?,?)",true,true);      
      }
      else
      {
          oParameters1.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getHdnEmpLbrFlag())));
          oParameters1.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtPayCode())));
          oParameters1.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getQuarter())));   
          oParameters1.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getFinYear())));
          oParameters1.add(new DBObject(5,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(mediReimbursDtlsAllHeaderBean.getMedicalDate())));
          oParameters1.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID()))); 
          oParameters1.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
          oOutArray1 = oBean1.callProc(oParameters1,"pkg_payroll_misc.proc_GetEligEmpsForMediReim(?,?,?,?,?,?,?)",true,true);      
      }
      DBObject oOutObject = (DBObject)oOutArray1.get(0);
      empListArrList = (ArrayList)(oOutObject.getObject());
      
      ArrayList finalEmpList = new ArrayList();
      QueryRow oRow = null;
      Iterator oIt = null;
      oIt = empListArrList.iterator();
      while(oIt.hasNext())
      {
        oRow = (QueryRow)oIt.next();
        finalEmpList.add(oRow.get("EMP_NO").getString());
      }

    
    
    int empNoEx,empNoEli;
    // now removing the employees which have been excluded in the front screen
    for(int n=0;n<excludedEmpList.size();n++)
    {
        empNoEx = Integer.parseInt(excludedEmpList.get(n).toString());
        for(int p=0;p<finalEmpList.size();p++)
        {
            empNoEli = Integer.parseInt(finalEmpList.get(p).toString());
            if(empNoEx==empNoEli)
            {
                finalEmpList.remove(p);
                break;
            }
        }
    }
     
     if(finalEmpList.size() == 0)
      {   
        ArrayList oList1 = new ArrayList();
        ArrayList oArguments = new ArrayList();
        if (mediReimbursDtlsAllHeaderBean.getTxtPayCode().equals("138"))
        {
          throw new EnrgiseApplicationException("Payroll.Emp.Conye",oArguments);
        }
        else
        {
          throw new EnrgiseApplicationException("Payroll.Emp.Medical",oArguments);
        }
      }
    ///////// we will insert records of the excluded employees only if there is atleast one employee which is eligible for reimbursement
    //////// otherwise there is no point in saving these records.
    if(finalEmpList.size()>0)
    {
       //  insert the extracted employee numbers in the pay_emp_medical_claim_excl table start
        if (mediReimbursDtlsAllHeaderBean.getTxtPayCode().equals("138"))
        {
            for(int m=0;m<excludedEmpList.size();m++)
            {
                oBean = new DBUtilitiesBean();
                oBean.createBatch("payroll_pkg_ext.proc_insexcludempsforconvey(?,?,?,?)");            
                oParameters = new ArrayList();
                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(excludedEmpList.get(m).toString())));
                oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtUserID())));
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID()))); 
                oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getyearMonth()))); 
                oBean.addToBatch(oParameters);
                try
                {
                  oBean.executeBatch();
                }
                catch (Exception e)
                {
                   System.out.println(e.getMessage());
                } 
             }
          }
        else if (mediReimbursDtlsAllHeaderBean.getTxtPayCode().equals("195"))
        {
            for(int m=0;m<excludedEmpList.size();m++)
            {
                oBean = new DBUtilitiesBean();
                oBean.createBatch("pkg_payroll_misc_ext.proc_insexcludempsforpli(?,?,?,?)");            
                oParameters = new ArrayList();
                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(excludedEmpList.get(m).toString())));
                oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtUserID())));
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID()))); 
                oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getFinYear()))); 
                oBean.addToBatch(oParameters);
                try
                {
                  oBean.executeBatch();
                }
                catch (Exception e)
                {
                   System.out.println(e.getMessage());
                } 
             }
          }
        
        else if (mediReimbursDtlsAllHeaderBean.getTxtPayCode().equals("132"))
        {
            for(int m=0;m<excludedEmpList.size();m++)
            {
                oBean = new DBUtilitiesBean();
                oBean.createBatch("pkg_payroll_misc_ext.proc_insexcludempsforexgrat(?,?,?,?)");            
                oParameters = new ArrayList();
                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(excludedEmpList.get(m).toString())));
                oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtUserID())));
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID()))); 
                oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getFinYear()))); 
                oBean.addToBatch(oParameters);
                try
                {
                  oBean.executeBatch();
                }
                catch (Exception e)
                {
                   System.out.println(e.getMessage());
                } 
             }
          }
          else
          {
             for(int m=0;m<excludedEmpList.size();m++)
             {
                oBean = new DBUtilitiesBean();
                oBean.createBatch("pkg_payroll_misc.proc_InsExcludEmpsForMediClaim(?,?,?,?,?,?)");            
                oParameters = new ArrayList();
                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(excludedEmpList.get(m).toString())));
                oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getQuarter())));
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(mediReimbursDtlsAllHeaderBean.getMedicalDate())));
                oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtUserID())));
                oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID()))); 
                oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getFinYear()))); 
                oBean.addToBatch(oParameters);
                try
                {
                  oBean.executeBatch();
                }
                catch (Exception e)
                {
                   System.out.println(e.getMessage());
                }  
             }
          }
    }
    //if final list size is 0 then there is no eligible employee left whose payment needs to be done for that Financial Year Month.added by geetika on 3/2/2014
    else
    {
        ArrayList oArguments = new ArrayList();
        throw new EnrgiseApplicationException("Payroll.Emp.Eligible",oArguments);
    }
    // insert the medical reimbursment details for all other employees except for the employees which has already been
    // processed for this quarter and which have been excluded above
    // ArrayList oOutArray2=null; 
    Integer errCode;
    if (mediReimbursDtlsAllHeaderBean.getTxtPayCode().equals("138"))
    {
        for(int k=0;k<finalEmpList.size();k++)
        {
            oParameters = new ArrayList();     
            oBean2 = new DBUtilitiesBean();
            ArrayList oOutArray2 = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String((String)finalEmpList.get(k))));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtPayCode())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getMedicalAmt())));   
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getyearMonth()))); 
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray2 = oBean2.callProc(oParameters,"PAYROLL_PKG_EXT.proc_insertempconyrembulk(?,?,?,?,?,?,?,?)",true,true);        
            oOutObject = (DBObject)oOutArray2.get(0);
            errCode = (Integer)((DBObject)oOutArray2.get(1)).getObject();
            if( ! errCode.equals(new Integer(0)))
            {
              ArrayList oArguments = new ArrayList();
              oArguments.add(new String((String)oOutObject.getObject()));
              throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
            }  
            oParameters = null;
            oOutArray2 = null;
            oOutObject = null;
        }
    }
    else if (mediReimbursDtlsAllHeaderBean.getTxtPayCode().equals("195"))
    {
        for(int k=0;k<finalEmpList.size();k++)
        {
            oParameters = new ArrayList();     
            oBean2 = new DBUtilitiesBean();
            ArrayList oOutArray2 = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String((String)finalEmpList.get(k))));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtPayCode())));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getMedicalAmt()))); 
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getFinYear()))); 
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray2 = oBean2.callProc(oParameters,"pkg_payroll_misc_ext.proc_insert_pay_pli_bulk(?,?,?,?,?,?,?,?,?)",true,true);        
            oOutObject = (DBObject)oOutArray2.get(0);
            errCode = (Integer)((DBObject)oOutArray2.get(2)).getObject();
            if( ! errCode.equals(new Integer(0)))
            {
              ArrayList oArguments = new ArrayList();
              oArguments.add(new String((String)oOutObject.getObject()));
              throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
            }  
            oParameters = null;
            oOutArray2 = null;
            oOutObject = null;
        }
    }
   
      else if (mediReimbursDtlsAllHeaderBean.getTxtPayCode().equals("132"))
      {
          for(int k=0;k<finalEmpList.size();k++)
          {
              oParameters = new ArrayList();     
              oBean2 = new DBUtilitiesBean();
              ArrayList oOutArray2 = new ArrayList();
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String((String)finalEmpList.get(k))));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtPayCode())));
              //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getMedicalAmt()))); 
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtUserID())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID())));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getFinYear()))); 
              oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
              oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));
              oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
              oOutArray2 = oBean2.callProc(oParameters,"pkg_payroll_misc_ext.proc_insert_pay_exgrat_bulk(?,?,?,?,?,?,?,?)",true,true);        
              oOutObject = (DBObject)oOutArray2.get(0);
              errCode = (Integer)((DBObject)oOutArray2.get(2)).getObject();
              if( ! errCode.equals(new Integer(0)))
              {
                ArrayList oArguments = new ArrayList();
                oArguments.add(new String((String)oOutObject.getObject()));
                throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
              }  
              oParameters = null;
              oOutArray2 = null;
              oOutObject = null;
          }
      }
      
   
    else
    {
        for(int k=0;k<finalEmpList.size();k++)
        {
            oParameters = new ArrayList();     
            oBean2 = new DBUtilitiesBean();
            ArrayList oOutArray2 = new ArrayList();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String((String)finalEmpList.get(k))));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String("SELF")));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtPayCode())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getMedicalAmt())));   
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTaxIndicator())));  
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String("")));    
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String("")));    
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(mediReimbursDtlsAllHeaderBean.getMedicalDate())));
            oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate("")));            
            oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String("")));           
            oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String("0")));
            oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String("")));
            oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtUserID())));
            oParameters.add(new DBObject(15,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getTxtSiteID())));
            oParameters.add(new DBObject(16,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getQuarter()))); 
            oParameters.add(new DBObject(17,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllHeaderBean.getFinYear()))); 
            oParameters.add(new DBObject(18,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(19,DBObject.OUT,ParameterTypes.VARCHAR));
            oParameters.add(new DBObject(20,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray2 = oBean2.callProc(oParameters,"PAYROLL_PKG_EXT.proc_InsertEmpMedicalClaimBulk(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);      //added by swapnendu Dt 10 Jan 2012 
            oOutObject = (DBObject)oOutArray2.get(0);
            errCode = (Integer)((DBObject)oOutArray2.get(2)).getObject();
            if( ! errCode.equals(new Integer(0)))
            {
               ArrayList oArguments = new ArrayList();
              oArguments.add(new String((String)oOutObject.getObject()));
              throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
            }  
            oParameters = null;
            oOutArray2 = null;
            oOutObject = null;
        }
    }
      return "";
  }
  
  public RecordMetaInfo getMediReimbursDtlsAllHeaderMetaInfo(MediReimbursDtlsAllQueryVO mediReimbursDtlsAllQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    Timestamp oWhenPicked = null;
    int count = 0;
    BaseHeaderVO oBaseHeaderVO = new BaseHeaderVO();
    String locCode = mediReimbursDtlsAllQueryVO.getLoginLocCode()+"";
    ArrayList oOutArray; //Output 
         if (mediReimbursDtlsAllQueryVO.getTxtPayCode().equals("138"))
         {
               
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getyearMonth())));   
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getTxtPayCode())));   
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getHdnEmpLbrFlag())));   
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
            oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
            //oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDtlsAllHeaderCount(?,?,?,?,?,?,?,?)");      
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyreimballhdrcnt(?,?,?,?,?,?,?)");
            
         }
         else if (mediReimbursDtlsAllQueryVO.getTxtPayCode().equals("195"))
         {
               
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getFinYear())));   
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getTxtPayCode())));   
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getHdnEmpLbrFlag())));   
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
            oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
            //oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDtlsAllHeaderCount(?,?,?,?,?,?,?,?)");      
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyreimballhdrcnt(?,?,?,?,?,?,?)");
            
         }
         else if (mediReimbursDtlsAllQueryVO.getTxtPayCode().equals("132"))
             {
                   
                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getFinYear())));   
                oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getTxtPayCode())));   
                oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getHdnEmpLbrFlag())));   
                oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
                oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
                oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
                //oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDtlsAllHeaderCount(?,?,?,?,?,?,?,?)");      
                oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyreimballhdrcnt(?,?,?,?,?,?,?)");
                
             }
        else
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getMedicalDate())));      
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getQuarter())));      
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getFinYear())));   
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getTxtPayCode())));   
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getHdnEmpLbrFlag())));   
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.BIGINT));
            oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.TIMESTAMP));
            oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.INTEGER));
            //oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDtlsAllHeaderCount(?,?,?,?,?,?,?,?)");      
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetMediReimbAllHdrCnt(?,?,?,?,?,?,?,?,?)");
                   
        }
            RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();     
            DBObject oTimeObject = (DBObject)oOutArray.get(1);
            oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());
            DBObject oTotalRecord = (DBObject)oOutArray.get(0);
            oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
    oParameters = null;
    oOutArray = null;
    return oRecordMetaInfo;

  }
  public ArrayList getMediReimbursDtlsAllHeader(MediReimbursDtlsAllQueryVO mediReimbursDtlsAllQueryVO,long lStartPosition,long lLastPosition) throws EnrgiseSystemException, EnrgiseApplicationException
  {
      
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList;
    int count = 0;

    if(mediReimbursDtlsAllQueryVO == null)
    {
      mediReimbursDtlsAllQueryVO = new MediReimbursDtlsAllQueryVO();
    }
    // commented by devendra for compilation on 25th aug 2010 start 
    ArrayList oOutArray; //Output 
    ArrayList oHeaderList = null;
    DBObject oOutObject=null;
    MediReimbursDtlsAllHeaderBean mediReimbursDtlsAllHeaderBean;
    String locCode = mediReimbursDtlsAllQueryVO.getLoginLocCode()+"";
     QueryRow oRow = null;
     HashMap oColumns = null;
     Iterator oIt=null;
               
    if (mediReimbursDtlsAllQueryVO.getTxtPayCode().equals("138"))
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));         
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getyearMonth())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getTxtPayCode())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));          
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyereimballhdr(?,?,?,?,?,?,?,?)");
            oOutObject = (DBObject)oOutArray.get(0);
             oList = (ArrayList)(oOutObject.getObject());
            if(oList.size() == 0)
            {        
              throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
            }
      
                
                count = 0;      
                oIt = oList.iterator();
                while(oIt.hasNext())
                {
                  if(count == 0)
                  {
                     oHeaderList = new ArrayList();
                  }
                  count++;
                  oRow = (QueryRow)oIt.next();
                  mediReimbursDtlsAllHeaderBean = new MediReimbursDtlsAllHeaderBean();          
                  mediReimbursDtlsAllHeaderBean.setMedicalAmt(oRow.get("amount").getString());                
                  mediReimbursDtlsAllHeaderBean.setyearMonth(oRow.get("yyyymm").getString());                 
                  mediReimbursDtlsAllHeaderBean.setTxtPayCode(oRow.get("pay_code").getString());
                  oHeaderList.add(mediReimbursDtlsAllHeaderBean);
                  mediReimbursDtlsAllHeaderBean = null;
                }           
         }
    else if (mediReimbursDtlsAllQueryVO.getTxtPayCode().equals("195"))
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));         
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getFinYear())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getTxtPayCode())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));          
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyereimballhdr(?,?,?,?,?,?,?,?)");
            oOutObject = (DBObject)oOutArray.get(0);
             oList = (ArrayList)(oOutObject.getObject());
            if(oList.size() == 0)
            {        
              throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
            }
      
                
                count = 0;      
                oIt = oList.iterator();
                while(oIt.hasNext())
                {
                  if(count == 0)
                  {
                     oHeaderList = new ArrayList();
                  }
                  count++;
                  oRow = (QueryRow)oIt.next();
                  mediReimbursDtlsAllHeaderBean = new MediReimbursDtlsAllHeaderBean();          
                  mediReimbursDtlsAllHeaderBean.setMedicalAmt(oRow.get("amount").getString());                
                  mediReimbursDtlsAllHeaderBean.setFinYear(oRow.get("fin_year").getString());                 
                  mediReimbursDtlsAllHeaderBean.setTxtPayCode(oRow.get("pay_code").getString());
                  oHeaderList.add(mediReimbursDtlsAllHeaderBean);
                  mediReimbursDtlsAllHeaderBean = null;
                }           
         }
    
      else if (mediReimbursDtlsAllQueryVO.getTxtPayCode().equals("132"))
          {
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));         
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getFinYear())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getTxtPayCode())));
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getHdnEmpLbrFlag())));
              oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
              oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));          
              oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyereimballhdr(?,?,?,?,?,?,?,?)");
              oOutObject = (DBObject)oOutArray.get(0);
               oList = (ArrayList)(oOutObject.getObject());
              if(oList.size() == 0)
              {        
                throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
              }
        
                  
                  count = 0;      
                  oIt = oList.iterator();
                  while(oIt.hasNext())
                  {
                    if(count == 0)
                    {
                       oHeaderList = new ArrayList();
                    }
                    count++;
                    oRow = (QueryRow)oIt.next();
                    mediReimbursDtlsAllHeaderBean = new MediReimbursDtlsAllHeaderBean();          
                  /*  mediReimbursDtlsAllHeaderBean.setMedicalAmt(oRow.get("amount").getString()); */               
                    mediReimbursDtlsAllHeaderBean.setFinYear(oRow.get("fin_yymm").getString());                 
                    mediReimbursDtlsAllHeaderBean.setTxtPayCode(oRow.get("pay_code").getString());
                    oHeaderList.add(mediReimbursDtlsAllHeaderBean);
                    mediReimbursDtlsAllHeaderBean = null;
                  }           
           }
    else
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getMedicalDate())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getQuarter())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getFinYear())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getTxtPayCode())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbursDtlsAllQueryVO.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));        
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetMediReimbAllHdr(?,?,?,?,?,?,?,?,?,?)"); 
             oOutObject = (DBObject)oOutArray.get(0);
             oList = (ArrayList)(oOutObject.getObject());
            if(oList.size() == 0)
            {        
              throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
            }
      
                
                count = 0;
                 oIt = oList.iterator();
                while(oIt.hasNext())
                {
                  if(count == 0)
                  {
                     oHeaderList = new ArrayList();
                  }
                  count++;
                  oRow = (QueryRow)oIt.next();
                  mediReimbursDtlsAllHeaderBean = new MediReimbursDtlsAllHeaderBean();          
                  mediReimbursDtlsAllHeaderBean.setMedicalAmt(oRow.get("medical_amnt").getString());
                  mediReimbursDtlsAllHeaderBean.setMedicalDate(oRow.get("bill_date").getString());            
                  mediReimbursDtlsAllHeaderBean.setQuarter(oRow.get("quarter").getString());
                  mediReimbursDtlsAllHeaderBean.setFinYear(oRow.get("fin_yr").getString());
                  mediReimbursDtlsAllHeaderBean.setTaxIndicator(oRow.get("taxable").getString());
                  mediReimbursDtlsAllHeaderBean.setTxtPayCode(oRow.get("pay_code").getString());
                  oHeaderList.add(mediReimbursDtlsAllHeaderBean);
                  mediReimbursDtlsAllHeaderBean = null;
                }              
            
        }
       
    return oHeaderList;
    // commented by devendra for compilation on 25th aug 2010 end*/
  }

  public RecordMetaInfo getMediReimbursDtlsAllDetailMetaInfo(String sPrimaryKey,MediReimbDtlsAllDetailInfo mediReimbDtlsAllDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException 
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
     String locCode = mediReimbDtlsAllDetailInfo.getLoginLocCode()+"";
     if (mediReimbDtlsAllDetailInfo.getTxtPayCode().equals("138"))
        {
          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getTxtPayCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getyearMonth())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getHdnEmpLbrFlag())));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
          oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));     
      
          oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyereimsalldtlcount(?,?,?,?,?,?,?)");    
        }
    else if (mediReimbDtlsAllDetailInfo.getTxtPayCode().equals("195"))
        {
          
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getTxtPayCode())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));          
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getFinYear())));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getHdnEmpLbrFlag())));
          oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
          oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
          oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));     
      
          oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyereimsalldtlcount(?,?,?,?,?,?,?)");    
        }
      else if (mediReimbDtlsAllDetailInfo.getTxtPayCode().equals("132"))
          {
            
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getTxtPayCode())));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));          
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getFinYear())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.BIGINT));
            oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.TIMESTAMP));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));     
        
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyereimsalldtlcount(?,?,?,?,?,?,?)");    
          }
        else
        {
          oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getMedicalDate())));
          oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getTxtPayCode())));
          oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
          oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String("SELF")));
          oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getQuarter())));
          oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getFinYear())));
          oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getHdnEmpLbrFlag())));
          oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.BIGINT));
          oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.TIMESTAMP));
          oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));     
      
          oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetMediReimsAllDtlCount(?,?,?,?,?,?,?,?,?,?)");     
        
        }
          RecordMetaInfo oRecordMetaInfo = new RecordMetaInfo();
          DBObject oTotalRecord = (DBObject)oOutArray.get(0);
          oRecordMetaInfo.setRecordCount(((Long)oTotalRecord.getObject()).longValue());
          DBObject oTimeObject = (DBObject)oOutArray.get(1);
          oRecordMetaInfo.setOWhenPicked((Timestamp)oTimeObject.getObject());      
          return oRecordMetaInfo;  
  }

 public ArrayList getMediReimbursDtlsAllDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,MediReimbDtlsAllDetailInfo mediReimbDtlsAllDetailInfo) throws EnrgiseSystemException, EnrgiseApplicationException  
// public ArrayList getMediReimbursDtlsAllDetail(String sPrimaryKey, long lDetailFirstPosition,long lDetailLastPosition,MediReimbursDtlsAllQueryVO mediReimbursDtlsAllQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException  
  {  
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    // commented by devendra for compilation on 25th aug 2010 start
    LoanDtlsAllDetailBean oLoanDtlsAllDetailBean;
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oList = null;
    Iterator oIt = null;
    ArrayList oLoanDtls = null;
    String locCode = mediReimbDtlsAllDetailInfo.getLoginLocCode()+"";
    if (mediReimbDtlsAllDetailInfo.getTxtPayCode().equals("138"))
        { 
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getTxtPayCode())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getyearMonth())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyereimballdtl(?,?,?,?,?,?,?,?)");
            oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oList.size() == 0)
            {        
              throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
            }
    
            count = 0;
            oIt = oList.iterator();
            while(oIt.hasNext())
            {
              if(count == 0)
              {
                oLoanDtls = new ArrayList();
              }
              count++;
              oRow = (QueryRow)oIt.next();
              oLoanDtlsAllDetailBean = new LoanDtlsAllDetailBean();
              oLoanDtlsAllDetailBean.setTxtEmpNo((oRow.get("emp_num").getString()));          
              oLoanDtlsAllDetailBean.setTxtEmpName((oRow.get("empName").getString()));
              oLoanDtlsAllDetailBean.setTxtDsgn((oRow.get("dsgn_desc").getString()));
              oLoanDtlsAllDetailBean.setTxtCateg((oRow.get("category").getString()));
              oLoanDtlsAllDetailBean.setTxtPresentPOP((oRow.get("LOC_DESC").getString()));
              oLoanDtls.add(oLoanDtlsAllDetailBean);
              oLoanDtlsAllDetailBean = null;
            }      
        }
    else if (mediReimbDtlsAllDetailInfo.getTxtPayCode().equals("195"))
        { 
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getTxtPayCode())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getFinYear())));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyereimballdtl(?,?,?,?,?,?,?,?)");
            oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oList.size() == 0)
            {        
              throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
            }
    
            count = 0;
            oIt = oList.iterator();
            while(oIt.hasNext())
            {
              if(count == 0)
              {
                oLoanDtls = new ArrayList();
              }
              count++;
              oRow = (QueryRow)oIt.next();
              oLoanDtlsAllDetailBean = new LoanDtlsAllDetailBean();
              oLoanDtlsAllDetailBean.setTxtEmpNo((oRow.get("emp_num").getString()));          
              oLoanDtlsAllDetailBean.setTxtEmpName((oRow.get("empName").getString()));
              oLoanDtlsAllDetailBean.setTxtDsgn((oRow.get("dsgn_desc").getString()));
              oLoanDtlsAllDetailBean.setTxtCateg((oRow.get("category").getString()));
              oLoanDtlsAllDetailBean.setTxtPresentPOP((oRow.get("LOC_DESC").getString()));
              oLoanDtls.add(oLoanDtlsAllDetailBean);
              oLoanDtlsAllDetailBean = null;
            }      
        }
    
      else if (mediReimbDtlsAllDetailInfo.getTxtPayCode().equals("132"))
          { 
              oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
              oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
              oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getTxtPayCode())));
              oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
              oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getFinYear())));
              oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getHdnEmpLbrFlag())));
              oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.CURSOR));
              oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));
              oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_getconyereimballdtl(?,?,?,?,?,?,?,?)");
              oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
              if(oList.size() == 0)
              {        
                throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
              }
      
              count = 0;
              oIt = oList.iterator();
              while(oIt.hasNext())
              {
                if(count == 0)
                {
                  oLoanDtls = new ArrayList();
                }
                count++;
                oRow = (QueryRow)oIt.next();
                oLoanDtlsAllDetailBean = new LoanDtlsAllDetailBean();
                oLoanDtlsAllDetailBean.setTxtEmpNo((oRow.get("emp_num").getString()));          
                oLoanDtlsAllDetailBean.setTxtEmpName((oRow.get("empName").getString()));
                oLoanDtlsAllDetailBean.setTxtDsgn((oRow.get("dsgn_desc").getString()));
                oLoanDtlsAllDetailBean.setTxtCateg((oRow.get("category").getString()));
                oLoanDtlsAllDetailBean.setTxtPresentPOP((oRow.get("LOC_DESC").getString()));
                oLoanDtls.add(oLoanDtlsAllDetailBean);
                oLoanDtlsAllDetailBean = null;
              }      
          }
        else
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailFirstPosition)));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lDetailLastPosition)));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getMedicalDate())));
            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getTxtPayCode())));
            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(locCode)));
            oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String("SELF")));
            oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getQuarter())));
            oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getFinYear())));
            oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(mediReimbDtlsAllDetailInfo.getHdnEmpLbrFlag())));
            oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_GetMediReimbAllDtl(?,?,?,?,?,?,?,?,?,?,?)");
            oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
            if(oList.size() == 0)
            {        
              throw new EnrgiseApplicationException("IBA.Payroll.common.norecordfound",EnrgiseConstants.MESSAGE);
            }
    
            count = 0;
            oIt = oList.iterator();
            while(oIt.hasNext())
            {
              if(count == 0)
              {
                oLoanDtls = new ArrayList();
              }
              count++;
              oRow = (QueryRow)oIt.next();
              oLoanDtlsAllDetailBean = new LoanDtlsAllDetailBean();
              oLoanDtlsAllDetailBean.setTxtEmpNo((oRow.get("emp_num").getString()));          
              oLoanDtlsAllDetailBean.setTxtEmpName((oRow.get("empName").getString()));
              oLoanDtlsAllDetailBean.setTxtDsgn((oRow.get("dsgn_desc").getString()));
              oLoanDtlsAllDetailBean.setTxtCateg((oRow.get("category").getString()));
              oLoanDtlsAllDetailBean.setTxtPresentPOP((oRow.get("LOC_DESC").getString()));
              oLoanDtls.add(oLoanDtlsAllDetailBean);
              oLoanDtlsAllDetailBean = null;
            }      
        
        }
                   
    return oLoanDtls; 
    // commented by devendra for compilation on 25th aug 2010 start*/
         
  }  
  public void saveDetailImpl(String sHeaderPrimaryKey,BaseHeaderBean oBaseHeaderBean,String sScreenName, ArrayList oDetailBeanArray) throws EnrgiseSystemException,EnrgiseApplicationException
  {
      saveMediReimbursDtlsAll(sHeaderPrimaryKey,oDetailBeanArray,(MediReimbursDtlsAllHeaderBean)oBaseHeaderBean);   
  }   
  
  private void saveMediReimbursDtlsAll(String sHeaderPrimaryKey, ArrayList oDetailBeanArray,MediReimbursDtlsAllHeaderBean mediReimbursDtlsAllHeaderBean) throws EnrgiseSystemException,EnrgiseApplicationException
  {
    boolean bInsert = false;
    boolean bUpdate = false;
    boolean bDelete = false;
    
    ArrayList oParameters = new ArrayList(); //Input Parameters    
    ArrayList oOutArray=new ArrayList();
    DBUtilitiesBean oBean = null;
    DBUtilitiesBean oBeanInsert = null;
    DBUtilitiesBean oBeanDelete = null;
    
    
    Iterator oIt = oDetailBeanArray.iterator();
    StringBuffer empNolist = new StringBuffer("");
    String sEmpType="E";
      /* commented by devendra for compilation on 25th aug 2010 start
      while(oIt.hasNext())
      {
        LoanDtlsAllDetailBean oLoanDtlsAllDetailBean = (LoanDtlsAllDetailBean)oIt.next();
        if(oLoanDtlsAllDetailBean.getStatus().equals(EnrgiseConstants.NEW_MODE))
        {
          if (empNolist.length()==0)				
            empNolist.append(new String(oLoanDtlsAllDetailBean.getTxtEmpNo())); 			
          else
          {
            empNolist.append(",");
            empNolist.append(new String(oLoanDtlsAllDetailBean.getTxtEmpNo())); 			
          }                  
        }      
      }    
      /*if(!bInsert)
        {
          oBeanInsert = new DBUtilitiesBean();
          oBeanInsert.createBatch("PKG_LOAN.proc_InsertLoanDetailBulk(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          bInsert = true;
        }*
        if (empNolist.length()==0)				
          empNolist.append(0);
          
        oParameters = new ArrayList();                    
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empNolist)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getHeaderPrimaryKey())));          
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getLoanAmnt())));          
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(oLoanDtlsAllHeaderBean.getSanctionDate())));          
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getSanctionNo())));          
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getRecStartDate())));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getNoofPrnInstall())));
        oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getNoofIntInstall())));
        oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getIntInstallAmnt())));
        oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getInstallAmnt())));
        oParameters.add(new DBObject(11,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getFirstInstallAmnt())));
        
        oParameters.add(new DBObject(12,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(13,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getTxtSiteID())));         
        oParameters.add(new DBObject(14,DBObject.IN,ParameterTypes.VARCHAR,new String(oLoanDtlsAllHeaderBean.getHdnEmpLbrFlag())));  
        oParameters.add(new DBObject(15,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(16,DBObject.OUT,ParameterTypes.INTEGER));
        //oBeanInsert.addToBatch(oParameters);
        
        oBeanInsert = new DBUtilitiesBean();
          oOutArray = oBeanInsert.callProc(oParameters,"PKG_LOAN.proc_InsertLoanDetailBulk(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",true,true);
          
          DBObject oOutObject = (DBObject)oOutArray.get(0);
          Integer errCode = (Integer)((DBObject)oOutArray.get(1)).getObject();
          System.out.println("Error!!! while inserting Loan Details ::"+errCode);
          if( ! errCode.equals(new Integer(0)))
          {
             ArrayList oArguments = new ArrayList();
             oArguments.add(new String((String)oOutObject.getObject()));
             throw new EnrgiseApplicationException("Pay.Payroll_ERROR",oArguments); 
          }         

      try
      {
          if(bInsert)
          {
            oBeanInsert.executeBatch();
          }
      
          if(bUpdate)
          {
            oBean.executeBatch();    
          }

          if(bDelete)
          {
            oBeanDelete.executeBatch();
          }   
      }
      catch (Exception e)
      {
          System.out.println(e.getMessage());
      }
      /* commented by devendra for compilation on 25th aug 2010 start*/
  }
   
  public void initializeBOImpl(String sScreenName)
  {
    String sDetailTable = null;
    if(sScreenName.equals("DARatesCDAScreen"))
    {
      sDetailTable = "lstPayScaleDtl";
    }
    initializeBO("DARateCDAScreen",sDetailTable);
  }  

  
  public LovVO getLoanDtlAllEmpLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");            
    arylstHeaderNames.add("Designation");        
    arylstHeaderNames.add("Category");        
    arylstHeaderNames.add("Present Place of Posting");
    arylstHeaderNames.add("CPF Code");        
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN); 
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;    
/*     DateUtility d=new DateUtility();
       String str=d.getSysDate();
       String monOfSysDate=str.substring(3,5);
       String yearOfSysDate=str.substring(6,10);
       String yyyymm=yearOfSysDate+monOfSysDate;
       System.out.println(yyyymm);  */
    
      ArrayList oParameters = new ArrayList(); //Input Parameters
      ArrayList oList;

      DBUtilitiesBean oBean = new DBUtilitiesBean();
      ArrayList oOutArray; //Output 
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));      
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
      oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
      oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));      
      oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));      
      oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PKG_LOAN.proc_GetLoanDtlsExclEmpLOV(?,?,?,?,?,?,?)");
      DBObject oOutObject=(DBObject)oOutArray.get(0);
      oList=(ArrayList)(oOutObject.getObject());
      
      QueryRow oRow=null; 
      Iterator iter = oList.iterator();
      while(iter.hasNext())
      {
        if(count == 0)
        {
           oList = new ArrayList();
        }
        count++;
        oRow = (QueryRow)iter.next();
        oLOVBean = new LOVBean();
        
        oLOVBean.setDetailField1(oRow.get("EMP_NO").getString());            
        oLOVBean.setDetailField2(oRow.get("Name").getString());                            
        oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());               
        oLOVBean.setDetailField4(oRow.get("category").getString());                    
        oLOVBean.setDetailField5(oRow.get("LOC_DESC").getString());                     
        oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
        oList.add(oLOVBean);
        oLOVBean = null;
      }
       
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

public void additionalFieldValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oList = new ArrayList();
    checkYrEndRemittance(oBaseHeaderBean,oList);
    reportError(oList);
    if(bHeaderDataChanged)
    {
        checkMandatoryDetail(oBaseHeaderBean,oDetailBeanArray,sScreenMode);
    }
  }

    private void checkYrEndRemittance(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oOutArray; //Output
        ArrayList oRetList;
        QueryRow oRow = null;
        Iterator oIt = null;
        MediReimbursDtlsAllHeaderBean oMediReimbursDtlsAllHeaderBean = (MediReimbursDtlsAllHeaderBean)oBaseHeaderBean;
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(oMediReimbursDtlsAllHeaderBean.getHdnEmpLbrFlag())));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(oMediReimbursDtlsAllHeaderBean.getTxtUserID())));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(oMediReimbursDtlsAllHeaderBean.getTxtSiteID())));
        oParameters.add(new DBObject(4, DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(5, DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_payroll_misc.proc_othrPaymnt_YrEndcheck(?,?,?,?,?)",true,true);
        Integer errCode = (Integer)(((DBObject)(oOutArray.get(1))).getObject());
        String errMsg = (String)(((DBObject)(oOutArray.get(0))).getObject());
        if(errCode.intValue() != 0)
        {
            ArrayList oArguments = new ArrayList();
            oArguments.add(new String(errMsg));
            oList.add(new EnrgiseApplicationException("Payroll.OverAbove.YrEndRemit",oArguments));
        }
    }

  public void additionalTimestampValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {

  }
  public void additionalBusinessValidationImpl(BaseHeaderBean oBaseHeaderBean, Timestamp oWhenPicked, String sScreenName, String sScreenMode, boolean bHeaderDataChanged, ArrayList oDetailBeanArray,boolean bDetailDataChanged, Timestamp oDetailPicked) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    
  }
  
  private void checkMandatoryDetail(BaseHeaderBean oBaseHeaderBean, ArrayList oDetailBeanArray, String sScreenMode) throws EnrgiseSystemException, EnrgiseApplicationException
  {
  
    ArrayList oList = new ArrayList();  
    //checkYYMM(oBaseHeaderBean,oList);
    //validateFestivalAdvDtls(oBaseHeaderBean, oDetailBeanArray ,oList,sScreenMode);
    //reportError(oList);     
    
  }
  
  private void checkYYMM(BaseHeaderBean oBaseHeaderBean, ArrayList oList) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oParameters = new ArrayList(); //Input Parameters
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    int count = 0;
    ArrayList oOutArray; //Output 
    QueryRow oRow = null;
    QueryValue oValue = null;
    ArrayList oRetList = null;
    Iterator oIt = null;
    /* commented by devendra for compilation on 25th aug 2010 start
    LoanDtlsAllHeaderBean oLoanDtlsAllHeaderBean=(LoanDtlsAllHeaderBean)oBaseHeaderBean;
      oParameters = new ArrayList();
      oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, oLoanDtlsAllHeaderBean.getTxtSiteID()));
      oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,oLoanDtlsAllHeaderBean.getHdnEmpLbrFlag()));  
      oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
      oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
      oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetMaxPayYear(?,?,?,?)");                 
      oRetList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();

      String sRevYear = "";
      String status = "";   
      String arcFlag="";
      
      oIt = oRetList.iterator();
      while(oIt.hasNext())
      {
        oRow = (QueryRow)oIt.next();
        sRevYear = oRow.get("yymm").getString(); 
        status = oRow.get("status").getString(); 
        arcFlag = oRow.get("arc_flag").getString(); 
      }

    if(arcFlag!=null && arcFlag.equals("Y"))
    {
      throw new EnrgiseApplicationException("payroll.Common.PayrollCheck");
    }

        int iFromYear = Integer.parseInt(oLoanDtlsAllHeaderBean.getRecStartDate());      
        if((Integer.parseInt(sRevYear) == iFromYear  && (Integer.parseInt(status) == 2 ))  ) 
        {        
          ArrayList oArguments = new ArrayList();
          oArguments.add(new Integer(count));
          oArguments.add(new String(sRevYear));
          oList.add(new EnrgiseApplicationException("Payroll.MaintDirectPay.MonthlyPayrollRun",oArguments));
        }
        else if ((Integer.parseInt(sRevYear)  > iFromYear ))
        {        
          ArrayList oArguments = new ArrayList();
          oArguments.add(new Integer(count));
          oArguments.add(new String(sRevYear));              
          oList.add(new EnrgiseApplicationException("Payroll.MaintLoanDtlBulk.YYYYMMNotValid",oArguments));
        }
        /* commented by devendra for compilation on 25th aug 2010 start*/
  }

  public LovVO getMediReimBulkLOVData(LovQueryVO oLovQueryVO) throws EnrgiseSystemException, EnrgiseApplicationException
  {
    LovVO oLovVO=new LovVO();  
    ArrayList arylstHeaderNames=new ArrayList();
    arylstHeaderNames.add("Employee No");    
    arylstHeaderNames.add("Employee Name");            
    arylstHeaderNames.add("Designation");        
    arylstHeaderNames.add("Category");        
    arylstHeaderNames.add("Present Place of Posting");
    arylstHeaderNames.add("CPF Code");        
    oLovVO.setHeaderList(arylstHeaderNames);
    
    ArrayList arylstVisibility=new ArrayList();
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    arylstVisibility.add(EnrgiseConstants.VISIBLE);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN);    
    arylstVisibility.add(EnrgiseConstants.HIDDEN); 
    arylstVisibility.add(EnrgiseConstants.VISIBLE);
    oLovVO.setVisibilityList(arylstVisibility);    
    //Set the detail fields
    LOVBean oLOVBean;
    int count;
    count = 0;
    int paycode;
    paycode=Integer.parseInt(oLovQueryVO.getProperty("txtPayCode").trim().toString());
    ArrayList oParameters = new ArrayList(); //Input Parameters
    ArrayList oList;
    
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oOutArray; //Output 
    //oParameters = new ArrayList();
    oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtSiteID").trim())));   
    oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("txtPayCode").trim())));
    if(paycode==138)
    {
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("yearMonth").trim())));
    }
    else
    {
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("finYear").trim())));
    }
    oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("quarter").trim())));
    oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("medicalDate").trim())));
    oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField1())));
    oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField2()))); 
    oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getSearchField3())));      
    oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String(oLovQueryVO.getProperty("hdnEmpLbrFlag").trim())));      
    oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.CURSOR));
    oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));
    oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.proc_GetMediReimBulkExclEmpLOV(?,?,?,?,?,?,?,?,?,?,?)",true,true);
    DBObject oOutObject=(DBObject)oOutArray.get(0);
    oList=(ArrayList)(oOutObject.getObject());
    
    QueryRow oRow=null; 
    Iterator iter = oList.iterator();
    while(iter.hasNext())
    {
    if(count == 0)
    {
       oList = new ArrayList();
    }
    count++;
    oRow = (QueryRow)iter.next();
    oLOVBean = new LOVBean();
    
    oLOVBean.setDetailField1(oRow.get("EMP_NO").getString());            
    oLOVBean.setDetailField2(oRow.get("Name").getString());                            
    oLOVBean.setDetailField3(oRow.get("dsgn_desc").getString());               
    oLOVBean.setDetailField4(oRow.get("category").getString());                    
    oLOVBean.setDetailField5(oRow.get("LOC_DESC").getString());                     
    oLOVBean.setDetailField6(oRow.get("CPF_CODE").getString());
    oList.add(oLOVBean);
    oLOVBean = null;
   }
    oLovVO.setDetailList(oList);
    return oLovVO;
  }

    public String sendInv(String empLbr, String quarter, String finYear, String medicalDate, long lUserID, long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
    
        ArrayList oOutArray; //Output  
        
        //oParameters = new ArrayList();
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(empLbr)));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(quarter)));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(finYear)));
        oParameters.add(new DBObject(4, DBObject.IN, ParameterTypes.VARCHAR, new String(medicalDate)));
        oParameters.add(new DBObject(5, DBObject.IN, ParameterTypes.BIGINT, new Long(lUserID)));
        oParameters.add(new DBObject(6, DBObject.IN, ParameterTypes.BIGINT, new Long(lSiteID)));
        oParameters.add(new DBObject(7, DBObject.OUT, ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(8, DBObject.OUT, ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_PAYROLL_MISC.PROC_SEND_INVOICE_MEDI_BULK(?,?,?,?,?,?,?,?)",true,true);
        
        DBObject oOutObject = (DBObject)oOutArray.get(1);
        Integer errCode = (Integer)(oOutObject.getObject());
        String sRetMsg="";
        if(errCode.intValue() != 0)
        {
            oOutObject = (DBObject)oOutArray.get(0);
            String errMsg = (String)(oOutObject.getObject());    
            sRetMsg=errCode.toString()+","+errMsg;   
        }
        else
        {
            sRetMsg = "Invoice(s) sent successfully. Please check Medical register report for invoice details.";
        }
        oParameters = null;
        oOutArray = null;
        oOutObject = null;
        return sRetMsg;
    }
      public String sendInvBulk(String empLbr,String finYear,String txtPayCode,long lUserID, long lSiteID) throws EnrgiseSystemException, EnrgiseApplicationException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
    
        ArrayList oOutArray; //Output  
        
        //oParameters = new ArrayList();
        
       
        oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, new String(empLbr)));
        oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, new String(finYear)));
        oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.VARCHAR, new String(txtPayCode)));
        oParameters.add(new DBObject(4, DBObject.IN, ParameterTypes.BIGINT, new Long(lUserID)));
        oParameters.add(new DBObject(5, DBObject.IN, ParameterTypes.BIGINT, new Long(lSiteID)));
        oParameters.add(new DBObject(6, DBObject.OUT, ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(7, DBObject.OUT, ParameterTypes.INTEGER));
        if (txtPayCode.equals("138"))
        {
          oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.Proc_SendConyeBulkInvoice(?,?,?,?,?,?,?)",true,true);
        }
       else if (txtPayCode.equals("195"))
        {
          oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_sendPLIbulkinvoice_Temp(?,?,?,?,?,?,?)",true,true);
        }
        else
        {
           oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_SendExgratInvoiceBulk(?,?,?,?,?,?,?)",true,true); 
        }
        DBObject oOutObject = (DBObject)oOutArray.get(1);
        Integer errCode = (Integer)(oOutObject.getObject());
        String sRetMsg="";
        if(errCode.intValue() != 0)
        {
            oOutObject = (DBObject)oOutArray.get(0);
            String errMsg = (String)(oOutObject.getObject());    
            sRetMsg=errCode.toString()+","+errMsg;   
        }
        else
        {
            sRetMsg = "Invoice(s) sent successfully.";
        }
        oParameters = null;
        oOutArray = null;
        oOutObject = null;
        return sRetMsg;
    }
}