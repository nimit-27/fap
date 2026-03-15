/*
    * Module:        ClaimPaymentDAO.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Data Access Object Class for Claim Payment through Voucher Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.HRMS.DATAACCESSTIER.DAO;

import java.util.*;
import java.sql.*;
import FCIPAY.HRMS.DATAACCESSTIER.VO.ClaimPaymentVO;
import FCIPAY.HRMS.DATAACCESSTIER.SQLQueries.ClaimPaymentQueries;
import FCIPAY.HRMS.UTILITY.ClaimPaymentBean;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class ClaimPaymentDAO extends BaseDAO
{
    ClaimPaymentQueries oCPQueries = new ClaimPaymentQueries();
    ResultSet rs = null;
    PreparedStatement pStmt = null;
    Connection con = null;

public ClaimPaymentDAO()
    {
        super("Common");
    }

/**
     * This method retrieves active PRD_ID from FIN_CLNDR_PRD Table 
     * @param long lLocCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getBPVCPVCurrPrd(long lLocCode) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstPrd = new ArrayList();
        List lstPrdId = new ArrayList();
        List lstPrdDesc = new ArrayList();
        String sCurrDate = "";
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lstPrd;
            }
            pStmt=con.prepareStatement(oCPQueries.GET_CURR_PRD_BPVCPV);            
            pStmt.setLong(1,lLocCode);
            rs=pStmt.executeQuery();
            while (rs.next()) 
            {
                lstPrdId.add(rs.getString("PRD_ID"));
                lstPrdDesc.add(rs.getString("PRD_DESC"));     
                sCurrDate = rs.getString("CURR_DATE");
                
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
            dsConn.closeConn(con);           
            lstPrd.add(lstPrdId);
            lstPrd.add(lstPrdDesc);
            lstPrd.add(sCurrDate);
        }       
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");                          
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBABusinessException("Finance.DB.Administrator");
        }
        return lstPrd;
    }    

/**
     * This method retrieves EMP_NO from FIN_PAYROLL_INTERFACE Table 
     * @param long lLocCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getEmpNos(long lLocCode,String sModuleId) throws IBAException,IBAFatalException,IBABusinessException
    {
      /*  List lstEmpNos = new ArrayList();
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lstEmpNos;
            }
            pStmt=con.prepareStatement(oCPQueries.GET_EMP_NOS);            
            pStmt.setObject(1,sModuleId,Types.VARCHAR);
            pStmt.setLong(2,lLocCode);
            pStmt.setObject(3,sModuleId,Types.VARCHAR);
            pStmt.setLong(4,lLocCode);
            
            rs=pStmt.executeQuery();
            while(rs.next()) 
            {
                lstEmpNos.add(rs.getString("EMP_NO"));
            }
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
            dsConn.closeConn(con);           
        }       
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");                          
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBABusinessException("Finance.DB.Administrator");
        }*/
        
        List lstEmpNos = new ArrayList();
        ArrayList tempList=new ArrayList();
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {      
           oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sModuleId));
           oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(lLocCode)));
           oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sModuleId));
           oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(lLocCode)));
           oOutArray = oBean.executeQuery(oParameters,oCPQueries.GET_EMP_NOS);
           oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();
                    lstEmpNos.add(oRow.get("EMP_NO").getString());                
            }
                     
        } 
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBABusinessException("Finance.DB.Administrator");
        }
        
        
        return lstEmpNos;
    }    

/**
     * This method retrieves C.EMP_FST_NAME + C.EMP_MDL_NAME + C.EMP_LST_NAME AS EMP_NAME FROM HRM_EMPLOYEE
     * @param String sEmpNo
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return String
*/ 
    public String getEmpDtls(String sEmpNo) throws IBAException,IBAFatalException,IBABusinessException
    {
        String sEmpName = "";
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return sEmpName;
            }
            pStmt=con.prepareStatement(oCPQueries.GET_EMP_DTLS);            
            pStmt.setObject(1,sEmpNo,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if(rs.next()) 
            {
                sEmpName = rs.getString("EMP_NAME");
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
            dsConn.closeConn(con);           
        }       
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");                          
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBABusinessException("Finance.DB.Administrator");
        }
        return sEmpName;
    }    

/**
     * This method retrieves A.RECORD_ID,A.RECORD_SOURCE,A.ACCT_ID,A.TXN_AMT 
     *                       FROM FIN_PAYROLL_INTERFACE A, FIN_VOUCHER_HDR B
     * @param ClaimPaymentVO oCPVO
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getVouchDtls(ClaimPaymentVO oCPVO) throws IBAException,IBAFatalException,IBABusinessException
    {
        ClaimPaymentBean oCPBean;
        List lstVouchDtls = new ArrayList();
        int i = 0;
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lstVouchDtls;
            }
            pStmt=con.prepareStatement(oCPQueries.GET_VOUCH_DTLS);            
            pStmt.setObject(1,oCPVO.getLstEmpNo(),Types.VARCHAR);
            pStmt.setLong(2,oCPVO.getLLocationCode());
            pStmt.setObject(3,oCPVO.getHidMIdforRetreival(),Types.VARCHAR);
            pStmt.setObject(4,oCPVO.getLstEmpNo(),Types.VARCHAR);
            pStmt.setObject(5,oCPVO.getHidMIdforRetreival(),Types.VARCHAR);
            pStmt.setLong(6,oCPVO.getLLocationCode());  
            rs=pStmt.executeQuery();
            while (rs.next()) 
            {                
                lstVouchDtls.add(new ClaimPaymentBean(rs.getString("RECORD_ID"),++i,rs.getString("RECORD_SOURCE"),rs.getString("ACCT_ID"),oCPVO.getLstEmpNo(),"","",rs.getString("TXN_AMT")));
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
            dsConn.closeConn(con);           
        }       
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");                          
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBABusinessException("Finance.DB.Administrator");
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
        int i=0;
        int iCount = 0;        
        String sVouchNo = "";
        String sVouchId = "";
        long lParamVouchNo = 0;
        List lstVouchDtls = new ArrayList();
        String sTXNAmt = "";
        String sDbCrFlg ="D";
        ClaimPaymentBean oCPBean;
        DSConnect dsConn = null;
        String sRecType ="";
        String sVHFOR = "VHFOR$GEN";
        try
        {      
            dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            
            if(con == null)
            {
                System.out.println("Connection Failed");
                return false;
            }
            con.setAutoCommit(false);
            pStmt=con.prepareStatement(oCPQueries.GET_VOUCHER_NO);  
            pStmt.setObject(1,oCPVO.getLstVoucherType(),Types.VARCHAR);
            pStmt.setObject(2,oCPVO.getLstVoucherType(),Types.VARCHAR);
            pStmt.setLong(3,oCPVO.getLLocationCode());
            rs=pStmt.executeQuery();
            if (rs.next()) 
            {
                sVouchNo= rs.getString("VOUCHER_NO");
                lParamVouchNo = rs.getLong("PARAM_VOUCHER_NO");                
            }
            else
            {
                rs.close();
                if(pStmt !=null)
                    pStmt.close();
                dsConn.closeConn(con);
                throw new IBABusinessException("Finance.Voucher.NoVoucherNum");
            }
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
            pStmt= con.prepareStatement(oCPQueries.INSERT_INTO_VOUCHHDR);
            pStmt.setLong(1,oCPVO.getLLocationCode());
            pStmt.setLong(2,oCPVO.getLLocationCode());
            pStmt.setObject(3,sVouchNo,Types.VARCHAR);
            pStmt.setObject(4,oCPVO.getLstPeriod(),Types.VARCHAR);
            pStmt.setObject(5,oCPVO.getTxtVouchDate(),Types.VARCHAR);            
            pStmt.setObject(6,oCPVO.getLstVoucherType(),Types.VARCHAR);
            pStmt.setObject(7,oCPVO.getTxtModuleId(),Types.VARCHAR);
            pStmt.setObject(8,oCPVO.getTxtDocRef(),Types.VARCHAR);
            pStmt.setObject(9,oCPVO.getTxtRemarks(),Types.VARCHAR);
            pStmt.setLong(10,oCPVO.getLEmployeeNo());
            pStmt.setLong(11,oCPVO.getLLocationCode());
            pStmt.setObject(12,sVHFOR,Types.VARCHAR);
            pStmt.setLong(13,oCPVO.getLEmployeeNo());

            iCount = pStmt.executeUpdate();
            if(iCount > 0)
            {
                if(pStmt != null)
                    pStmt.close();
                pStmt = con.prepareStatement(oCPQueries.GET_VOUCH_ID);
                pStmt.setObject(1,sVouchNo,Types.VARCHAR);
                rs = pStmt.executeQuery();
                if(rs.next())
                {
                    sVouchId = rs.getString("VOUCHER_ID");
                    oCPVO.setTxtHidVoucherId(sVouchId);
                    rs.close();
                    if(pStmt != null)
                        pStmt.close();
                        
                    lstVouchDtls = oCPVO.getVoucherDtls();
                    if(!lstVouchDtls.isEmpty())
                    {                    
                        pStmt = con.prepareStatement(oCPQueries.INSERT_INTO_VOUCHDTL);
                        for(i=0;i<lstVouchDtls.size();i++)
                        {
                            iCount = 0;
                            oCPBean =(ClaimPaymentBean)lstVouchDtls.get(i);
                            
                            pStmt.setLong(1,oCPVO.getLLocationCode());
                            pStmt.setLong(2,oCPBean.getTxtSNo());
                            pStmt.setObject(3,oCPBean.getTxtParticulars(),Types.VARCHAR);
                            pStmt.setObject(4,oCPVO.getLstEmpNo(),Types.VARCHAR);
                            pStmt.setObject(5,oCPBean.getTxtChId(),Types.VARCHAR);
                            pStmt.setObject(6,oCPBean.getTxtCCSgrpId(),Types.VARCHAR);                            
                            pStmt.setObject(7,oCPBean.getTxtDrAmt(),Types.VARCHAR);
                            pStmt.setObject(8,sDbCrFlg,Types.VARCHAR);
                            pStmt.setObject(9,sVouchId,Types.VARCHAR);
                            pStmt.setObject(10,oCPBean.getTxtAcctId(),Types.VARCHAR);
                            pStmt.setLong(11,oCPVO.getLEmployeeNo());
                            pStmt.setLong(12,oCPVO.getLLocationCode());                        

                            iCount = pStmt.executeUpdate();
                            if(iCount < 1)
                            {
                                if(pStmt !=null)
                                    pStmt.close();
                                con.rollback();
                                dsConn.closeConn(con);
                                return false;
                            }                        
                        }
                        if(pStmt != null)
                            pStmt.close();

                        pStmt = con.prepareStatement(oCPQueries.UPDATE_PAYROLL_INTERFACE);
                        for(i=0;i<lstVouchDtls.size();i++)
                        {
                            oCPBean =(ClaimPaymentBean)lstVouchDtls.get(i);
                            pStmt.setObject(1,sVouchId,Types.VARCHAR);
                            pStmt.setLong(2,oCPVO.getLEmployeeNo());
                            pStmt.setLong(3,oCPVO.getLLocationCode());
                            pStmt.setObject(4,oCPBean.getRecordId(),Types.VARCHAR);
                            iCount = 0;
                            iCount = pStmt.executeUpdate();
                            if(iCount < 1)
                            {
                                if(pStmt != null)
                                    pStmt.close();
                                con.rollback();
                                dsConn.closeConn(con);
                                throw new IBABusinessException("Finance.ReAssignCheque.Voucher.AlreadyProcess");
                            }                            
                        }
                        
                        if(pStmt != null)
                            pStmt.close();
                        pStmt = con.prepareStatement(oCPQueries.UPDATE_VOUCHERPARAMNO);
                        pStmt.setLong(1,lParamVouchNo+1);
                        pStmt.setLong(2,oCPVO.getLEmployeeNo());
                        pStmt.setLong(3,oCPVO.getLLocationCode());
                        pStmt.setLong(4,oCPVO.getLLocationCode());
                        pStmt.setObject(5,oCPVO.getLstVoucherType(),Types.VARCHAR);
                        pStmt.setLong(6,lParamVouchNo);
                        iCount = 0;
                        iCount = pStmt.executeUpdate();
                        if(iCount < 1)
                        {
                            if(pStmt !=null)
                                pStmt.close();
                            con.rollback();
                            dsConn.closeConn(con);
                            throw new IBABusinessException("Finance.ReAssignCheque.Voucher.AlreadyProcess");
                        }
                        if(pStmt !=null)
                            pStmt.close();

                        oCPVO.setTxtVouchNo(sVouchNo);
                        con.commit();
                        dsConn.closeConn(con);
                        return true;
                    }  
                    else
                    {
                        if(pStmt != null)
                            pStmt.close();
                        con.rollback();
                        dsConn.closeConn(con);
                        return false;
                    }
                    
                }
                else
                {
                    rs.close();
                    if(pStmt != null)
                        pStmt.close();
                    con.rollback();
                    dsConn.closeConn(con);
                    return false;
                }

            }
            else
            {
                if(pStmt != null)
                    pStmt.close();
                dsConn.closeConn(con);                       
                return false;
            }    
            
        }       
        catch(SQLException e)
        {
            try
            {
                if(pStmt !=null)
                    pStmt.close();
                con.rollback();
                dsConn.closeConn(con);                
            }
            catch(Exception fe)
            {
                fe.printStackTrace();
                throw new IBABusinessException("Finance.DB.Administrator");
            }
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");                          
        }
        catch(IBABusinessException ibe)
        {
            ibe.printStackTrace();
            throw new IBABusinessException(ibe.getErrorKey());
        }
        catch(Exception e)
        {
            try
            {
                if(pStmt !=null)
                    pStmt.close();
                con.rollback();
                dsConn.closeConn(con);                
            }
            catch(Exception fe)
            {
                fe.printStackTrace();
                throw new IBABusinessException("Finance.DB.Administrator");
            }
            e.printStackTrace();
            throw new IBABusinessException("Finance.DB.Administrator");
        }        
    }       
}