/*
    * Module:        TEVBPVDAO.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Data Access Object Class for TEV Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * 01/09/2006  Changed By Jayendu 
    *             Added finally clause in the following methods:
    *             1.getAcctDtls()
    *             2.getTRAcctId()
    *             3.getEmpCCnChCode()
    *             4.getTotPenalty()
*/

package FCIPAY.HRMS.DATAACCESSTIER.DAO;
import FCIPAY.HRMS.DATAACCESSTIER.VO.TEVBPVVO;
import FCIPAY.HRMS.DATAACCESSTIER.SQLQueries.TEVBPVQueries;
import FCIPAY.COMMON.UTILITY.*;
import java.util.*;
import java.sql.*;
import FCIPAY.HRMS.UTILITY.TEVDtlBean;
//added by bhavna
import FCIPAY.HRMS.DATAACCESSTIER.DAO.CommonVoucherDAO;

public class TEVBPVDAO 
{
    Connection con=null;
    PreparedStatement pStmt=null;
    PreparedStatement pStmt2=null;
    ResultSet rs=null;
    ResultSet rs2=null;
    
    TEVBPVQueries oTBQueries = new TEVBPVQueries();
    DSConnect dsConn = null;

/**
     * This method retrieves LOC_DESC from COM_LOC_MST Table 
     * @param long lLocCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return String (Location Description)
*/ 
    public String getDocLoc(long lLocCode) throws IBAException,IBAFatalException,IBABusinessException
    {
        String sLocDesc = "";
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return sLocDesc;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_LOC_DESC);            
            pStmt.setLong(1,lLocCode);
            rs=pStmt.executeQuery();
            while(rs.next()) 
            {
               sLocDesc = rs.getString("LOC_DESC");
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
        List lstClaimsNos = new ArrayList();
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lstClaims;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_CLM_IDS);            
            pStmt.setLong(1,lLocCode);
            rs=pStmt.executeQuery();
            while(rs.next()) 
            {
                lstClaimsIds.add(rs.getString("CLM_ID"));
                lstClaimsNos.add(rs.getString("CLM_NO"));          
            }
            lstClaims.add(lstClaimsIds);
            lstClaims.add(lstClaimsNos);
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
        return lstClaims;
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
            pStmt=con.prepareStatement(oTBQueries.GET_CURR_PRD);            
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
     * This method retrieves A.TR_ID,B.TR_DESC, A.EMP_NO, C.EMP_FST_NAME + C.EMP_MDL_NAME + C.EMP_LST_NAME AS EMP_NAME
     *        FROM FIN_TR_CLM_HDR A, FIN_TR_TYPE B, HRM_EMPLOYEE C from FIN_TR_HDS Table for selected Claim No
     * @param String sClaimId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public TEVBPVVO getClaimDtls(String sClaimId,TEVBPVVO oTBVO) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstClaimDtls = new ArrayList();
        List lstPmtModeValues=new ArrayList();
        List lstPmtModeLabels=new ArrayList();

        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return oTBVO;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_CLM_DTLS);            
            pStmt.setObject(1,sClaimId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if(rs.next()) 
            {
                        lstClaimDtls.add(rs.getString("TR_ID"));
                        lstClaimDtls.add(rs.getString("TR_DESC"));
                        lstClaimDtls.add(rs.getString("EMP_NO"));     
                        lstClaimDtls.add(rs.getString("EMP_NAME"));
                       pStmt2=con.prepareStatement("select trunc((datediff('hh',sysdate,a.emp_norm_ret_dt))/24) from hrm_employee a where a.emp_no=?");
                        pStmt2.setString(1,rs.getString("EMP_NO"));
                        rs2=pStmt2.executeQuery();
                        rs2.next();
                        int dateDiff=rs2.getInt(1);
                        if(dateDiff<30)
                          {

                             if(rs.getString("REC_MODE_GBL").equals("SETLMODE$VOUCHER"))
                             {
                               lstPmtModeValues.add(rs.getString("REC_MODE_GBL"));
                               lstPmtModeLabels.add(rs.getString("CODE_DESC"));
                             }
                            
                          }
                          else
                          {
                               lstPmtModeValues.add(rs.getString("REC_MODE_GBL"));
                               lstPmtModeLabels.add(rs.getString("CODE_DESC"));
                          }
                          rs2.close();
                          pStmt2.close();
                
            }            
            rs.close();
            if(pStmt != null)
            pStmt.close(); 
            pStmt=con.prepareStatement(oTBQueries.GET_PMT_DTLS);            
            pStmt.setObject(1,sClaimId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if(rs.next()) 
            {
                        lstPmtModeValues.add(rs.getString("GBL_CODE"));
                        lstPmtModeLabels.add(rs.getString("CODE_DESC"));
            }            
            rs.close();
            if(pStmt != null)
            pStmt.close(); 
            oTBVO.setLstPmtModeValues(lstPmtModeValues);   
            oTBVO.setLstPmtModeLabels(lstPmtModeLabels);
            oTBVO.setLstClaimDtls(lstClaimDtls);
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
        return oTBVO;
    }    

/**
     * This method retrieves TR_TYPE_GBL from FIN_TR_TYPE Table 
     * @param String sClaimId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return String (Travel Request Type)
*/ 
    public String getTRType(String sClaimId) throws IBAException,IBAFatalException,IBABusinessException
    {
        String sTRType = "";
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return sTRType;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_TR_TYPE_GBL);            
            pStmt.setObject(1,sClaimId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if(rs.next()) 
            {
                sTRType = rs.getString("TR_TYPE_GBL");
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
        return sTRType;
    }    


/**
     * This method retrieves ACCT_STATUS,CTRL_ACCT,CHG_FLG,CC_FLG from FIN_ACCT_MST Table 
     * @param String sAcctId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List(ACCT_STATUS,CTRL_ACCT,CHG_FLG,CC_FLG)
*/ 
    public List getAcctDtls(String sAcctId) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstAcctDtls = new ArrayList();
        DSConnect dsConn=null;
        try
        {      
            dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lstAcctDtls;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_ACCT_DTL);            
            pStmt.setObject(1,sAcctId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if(rs.next()) 
            {
                lstAcctDtls.add(rs.getString("ACCT_STATUS"));
                lstAcctDtls.add(rs.getString("CTRL_ACCT"));
                lstAcctDtls.add(rs.getString("CHG_FLG"));
                lstAcctDtls.add(rs.getString("CC_FLG"));                
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
                 
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
        finally
        {
           dsConn.closeConn(con);     
        }
        return lstAcctDtls;
    }        


/**
     * This method retrieves ADV_ACCT_ID FROM FIN_TR_TYPE
     * @param String sTRId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return String (Advance Account Id)
*/ 
    public String getAdvAcctId(String sTRId) throws IBAException,IBAFatalException,IBABusinessException
    {
        String sAcctId = "";
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return sAcctId;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_ADV_ACCT_ID);            
            pStmt.setObject(1,sTRId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if(rs.next()) 
            {
                sAcctId = rs.getString("ADV_ACCT_ID");
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
        return sAcctId;
    }    

/**
     * This method retrieves Travel Account Id from FIN_TR_TYPE Table 
     * @param String sTRId
     * @param String sAcctType
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return String
*/ 
    public String getTRAcctId(String sTRId, String sAcctType) throws IBAException,IBAFatalException,IBABusinessException
    {
        String sAcctId = "";
        String sQuery = "";
        DSConnect dsConn=null;
        try
        {      
            dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return sAcctId;
            }
            sQuery = "SELECT " +sAcctType+ oTBQueries.GET_TR_ACCT_ID;
            pStmt=con.prepareStatement(sQuery);            
//            pStmt.setObject(1,sAcctType,Types.VARCHAR);
            pStmt.setObject(1,sTRId,Types.VARCHAR);
            System.out.println("Query is:"+sQuery);
            rs=pStmt.executeQuery();
            if(rs.next()) 
            {
                sAcctId = rs.getString(1);
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
                       
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
        finally
        {
          dsConn.closeConn(con);
        }
        return sAcctId;
    }        

/**
     * This method retrieves EMP_CC_CODE,EMP_CH_CODE FROM HRM_EMPLOYEE Table 
     * @param String sEmpNo
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List (Charge Code,Cost Centre Sub Group Code)
*/ 
    public List getEmpCCnChCode(String sEmpNo) throws IBAException,IBAFatalException,IBABusinessException
    {
        List lstEmpCCnChCode = new ArrayList();
        DSConnect dsConn=null;
        try
        {      
             dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lstEmpCCnChCode;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_EMP_CH_CC_CODE);            
            pStmt.setObject(1,sEmpNo,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if(rs.next()) 
            {
                lstEmpCCnChCode.add(rs.getString("CHG_CODE"));
                lstEmpCCnChCode.add(rs.getString("CCSGRP_CODE"));
            }            
           
           if(pStmt != null)
                pStmt.close();
           rs.close();                 
                    
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

        finally
        {
              
           
           dsConn.closeConn(con);   
        }
        return lstEmpCCnChCode;
    }     

        

/**
     * This method retrieves SUM(SANC_AMT) FROM FIN_TR_ADV_HDR
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return long
*/ 
    public long getTotAdvance(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        long lTotAdvance = 0;
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lTotAdvance;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_SUM_ADVS);            
            pStmt.setObject(1,sClmId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if (rs.next()) 
            {
                lTotAdvance = rs.getLong("TOT_ADV");
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
        return lTotAdvance;
    }    

/**
     * This method retrieves SUM(RECEIPT_AMT) FROM FIN_TR_RECEIPT
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return long
*/ 
    public long getTotRefunds(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        long lTotRefunds = 0;
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lTotRefunds;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_SUM_RECEIPT_AMT);            
            pStmt.setObject(1,sClmId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if (rs.next()) 
            {
                lTotRefunds = rs.getLong("TOT_REFUNDS");
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
        return lTotRefunds;
    }    

/**
     * This method retrieves SUM(PENALTY_AMT) FROM FIN_TR_CLM_PENALTY
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return long
*/ 
    public long getTotPenalty(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        long lTotPenalty = 0;
        DSConnect dsConn=null;
        try
        {      
            dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lTotPenalty;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_SUM_PENALTY);            
            pStmt.setObject(1,sClmId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if (rs.next()) 
            {
                lTotPenalty = rs.getLong("PENALTY_AMT");
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
                                  
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
        finally
        {
           dsConn.closeConn(con);
        }
        return lTotPenalty;
    }        

/**
     * This method retrieves EXP_ACCT_ID,SUM(SANC_AMT) from FIN_TR_CLM_CLASS, FIN_TR_CLM_RATE, FIN_TR_CLM_PRD
     *        FIN_TR_CLM_PCT, FIN_TR_CLM_LS, FIN_TR_CLM_DA, FIN_TR_HDS
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getClaimSanctAmt(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        List lstClaims = new ArrayList();
        List lstExpAcctIds = new ArrayList();
        List lstSancAmt = new ArrayList();
        int i=0;
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lstClaims;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_CLM_SANC_AMTS);            
            for(i=1;i<7;i++)
                pStmt.setObject(i,sClmId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            while (rs.next()) 
            {
                lstExpAcctIds.add(rs.getString("EXP_ACCT_ID"));
                lstSancAmt.add(rs.getString("SANC_AMT"));
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
            lstClaims.add(lstExpAcctIds);
            lstClaims.add(lstSancAmt);
            dsConn.closeConn(con);                       
        }       
        catch(SQLException e)
        {
            dsConn.closeConn(con);
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");                          
        }
        catch(Exception e)
        {
            dsConn.closeConn(con);
            e.printStackTrace();
            throw new IBABusinessException("Finance.DB.Administrator");
        }
        return lstClaims;
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
        int i=0;
        int iCount = 0;
        String sVouchType="VOUCHTYPE$TEV";
        String sVouchNo = "";
        
        String sVouchId = "";
        long lParamVouchNo = 0;
        List lstVouchDtls = new ArrayList();
        String sTXNAmt = "";
        String sDbCrFlg ="";
        TEVDtlBean oTBBean;        
        String sRecType ="";
        String Vouch="TEV";
          long VoucherNo=0;
          String VOUCHER_NO="";
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
            //getting the voucher no
            /*pStmt=con.prepareStatement(oTBQueries.GET_VOUCHER_NO);  
            pStmt.setObject(1,sVouchType,Types.VARCHAR);
            pStmt.setObject(2,sVouchType,Types.VARCHAR);
            pStmt.setLong(3,oTBVO.getLLocationCode());
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
                pStmt.close(); */
            // getting the voucher no
            //added by bhavna 04/05/2005

                        CommonVoucherDAO oCommonVoucherDAO=new CommonVoucherDAO();
                        VoucherNo=oCommonVoucherDAO.getNewVoucherNo_DAO( sVouchType,oTBVO.getLLocationCode());
                        if(VoucherNo==0)
                        throw new IBABusinessException("Finance.Voucher.NoVoucherNum");
                        //      strVoucherNo=Long.toString(oCommonVoucherVo.gettxtHidLocId())+Integer.toString(Year).substring(2)+oCommonVoucherVo.gettxtVouchType()+VoucherNo;
                        String FinYear=null;
                        FinYear=oCommonVoucherDAO.getCurrentFinYear_DAO(oTBVO.getLLocationCode());
                        if(FinYear==null)
                        throw new IBABusinessException("Finance.Voucher.NoVoucherNum");
                        VOUCHER_NO=Long.toString(oTBVO.getLLocationCode())+FinYear+Vouch+VoucherNo;



            //added  by bhavna 04/05/2005
            pStmt= con.prepareStatement(oTBQueries.INSERT_INTO_VOUCHHDR);
            pStmt.setLong(1,oTBVO.getLLocationCode());
            pStmt.setLong(2,oTBVO.getLLocationCode());
            pStmt.setObject(3,VOUCHER_NO,Types.VARCHAR);
            pStmt.setObject(4,oTBVO.getLstPeriod(),Types.VARCHAR);
            pStmt.setObject(5,oTBVO.getTxtClaimDate(),Types.VARCHAR);            
            pStmt.setObject(6,sVouchType,Types.VARCHAR);
            pStmt.setObject(7,oTBVO.getTxtDocRef(),Types.VARCHAR);
            pStmt.setObject(8,oTBVO.getTxtDocRem(),Types.VARCHAR);
            pStmt.setLong(9,oTBVO.getLEmployeeNo());
            pStmt.setLong(10,oTBVO.getLLocationCode());
            pStmt.setLong(11,oTBVO.getLEmployeeNo());
            pStmt.setString(12,oTBVO.getTxtDesg());


            iCount = pStmt.executeUpdate();
            if(iCount > 0)
            {
                if(pStmt != null)
                    pStmt.close();
                pStmt = con.prepareStatement(oTBQueries.GET_VOUCH_ID);
                pStmt.setObject(1,VOUCHER_NO,Types.VARCHAR);
                rs = pStmt.executeQuery();
                if(rs.next())
                {
                    sVouchId = rs.getString("VOUCHER_ID");
                    rs.close();
                    if(pStmt != null)
                        pStmt.close();
                        
                    lstVouchDtls = oTBVO.getVoucherDtls();
                    if(!lstVouchDtls.isEmpty())
                    {                    
                        pStmt = con.prepareStatement(oTBQueries.INSERT_INTO_VOUCHDTL);
                        for(i=0;i<lstVouchDtls.size();i++)
                        {
                            iCount = 0;
                            oTBBean =(TEVDtlBean)lstVouchDtls.get(i);
                            if(!oTBBean.getTxtCrAmt().equals(""))
                            {
                                sTXNAmt = removeComma(oTBBean.getTxtCrAmt());
                                sDbCrFlg = "C";
                            }                           
                            
                            else if(!oTBBean.getTxtDrAmt().equals(""))
                            {
                                sTXNAmt = removeComma(oTBBean.getTxtDrAmt());
                                sDbCrFlg = "D";
                            }
                 
                            pStmt.setLong(1,oTBVO.getLLocationCode());
                            pStmt.setLong(2,oTBBean.getTxtSNo());
                            pStmt.setObject(3,oTBBean.getTxtParticulars(),Types.VARCHAR);
                            pStmt.setObject(4,oTBBean.getTxtEmpNo(),Types.VARCHAR);
                            pStmt.setObject(5,oTBBean.getTxtChId(),Types.VARCHAR);
                            pStmt.setObject(6,oTBBean.getTxtCCSgrpId(),Types.VARCHAR);
                            pStmt.setObject(7,oTBBean.getTxtLinkRef(),Types.VARCHAR);
                            pStmt.setObject(8,sTXNAmt,Types.VARCHAR);
                            pStmt.setObject(9,sDbCrFlg,Types.VARCHAR);
                            pStmt.setObject(10,sVouchId,Types.VARCHAR);
                            pStmt.setObject(11,oTBBean.getTxtAcctId(),Types.VARCHAR);
                            pStmt.setLong(12,oTBVO.getLEmployeeNo());
                            pStmt.setLong(13,oTBVO.getLLocationCode());
                            System.out.println("Query is"+oTBQueries.INSERT_INTO_VOUCHDTL);
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

                        pStmt = con.prepareStatement(oTBQueries.INSERT_INTO_PAYROLLINTERFACE);
                        for(i=0;i<lstVouchDtls.size();i++)
                        {
                            iCount = 0;
                            oTBBean =(TEVDtlBean)lstVouchDtls.get(i);
                            if(oTBBean.getDtlType().equals("Payment") || oTBBean.getDtlType().equals("Recovery"))
                            {
                                    if(oTBBean.getDtlType().equals("Payment"))
                                        sRecType = "P";
                                    if(oTBBean.getDtlType().equals("Recovery"))
                                        sRecType = "R";
                                    if(!oTBBean.getTxtCrAmt().equals(""))
                                    {
                                        sTXNAmt = removeComma(oTBBean.getTxtCrAmt());
                                        sDbCrFlg = "D";
                                    }                           
                                    else if(!oTBBean.getTxtDrAmt().equals(""))
                                    {
                                        sTXNAmt = removeComma(oTBBean.getTxtDrAmt());
                                        sDbCrFlg = "C";
                                    }
                                    pStmt.setLong(1,oTBVO.getLLocationCode());
                                    pStmt.setObject(2,sVouchId,Types.VARCHAR);
                                    pStmt.setObject(3,sRecType,Types.VARCHAR);                                
                                    pStmt.setObject(4,oTBBean.getTxtEmpNo(),Types.VARCHAR);
                                    pStmt.setObject(5,sTXNAmt,Types.VARCHAR);
                                    pStmt.setObject(6,oTBBean.getTxtAcctId(),Types.VARCHAR);
                                    pStmt.setObject(7,sDbCrFlg,Types.VARCHAR);
                                    pStmt.setObject(8,oTBVO.getLstPmtMode());
                                    pStmt.setLong(9,oTBVO.getLEmployeeNo());
                                    pStmt.setLong(10,oTBVO.getLLocationCode());
                                    pStmt.setLong(11,oTBVO.getLLocationCode());
                                    iCount = pStmt.executeUpdate();
                                    if(iCount < 1)
                                    {
                                        if(pStmt != null)
                                            pStmt.close();
                                        con.rollback();
                                        dsConn.closeConn(con);
                                        return false;    
                                    }                                
                            }                           
                            
                        }
                        if(pStmt != null)
                            pStmt.close();
                       /* pStmt = con.prepareStatement(oTBQueries.UPDATE_VOUCHERPARAMNO);
                        pStmt.setLong(1,lParamVouchNo+1);
                        pStmt.setLong(2,oTBVO.getLEmployeeNo());
                        pStmt.setLong(3,oTBVO.getLLocationCode());
                        pStmt.setLong(4,oTBVO.getLLocationCode());
                        pStmt.setObject(5,sVouchType,Types.VARCHAR);
                        pStmt.setLong(6,lParamVouchNo);
                        iCount = 0;
                        iCount = pStmt.executeUpdate();
                        if(iCount < 1)
                        {
                            if(pStmt !=null)
                                pStmt.close();
                            con.rollback();
                            dsConn.closeConn(con);
                            throw new IBABusinessException("Finance.VouchNo.AlreadyUsed");
                        }
                        if(pStmt !=null)
                            pStmt.close();*/

                        pStmt = con.prepareStatement(oTBQueries.UPDATE_CLMHDR);
                        pStmt.setObject(1,sVouchId,Types.VARCHAR);
                        pStmt.setLong(2,oTBVO.getLEmployeeNo());
                        pStmt.setLong(3,oTBVO.getLLocationCode());
                        pStmt.setString(4,oTBVO.getLstPmtMode());
                        pStmt.setObject(5,oTBVO.getLstClaimNo(),Types.VARCHAR);
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
                        oTBVO.setTxtVouchNo(VOUCHER_NO);
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



/**
    * This method validates the date whether it falls in the selected period
    * @param String sPeriod, String sCurDate
    * @exception IBAFatalException,IBABusinessException
    * @return boolean(true/false)
*/
    public boolean chkDate(String sPeriod, String sCurDate, Connection con) throws IBAFatalException,IBABusinessException
    {
        String sValue = null;
        try
        {
//            dsConn=new DSConnect();
//            con=dsConn.getDBConnection();
            // Get the connection
            if (con == null)
            {
                throw new IBAFatalException("Finance.DB.Administrator");
            }        
        
           
            pStmt = con.prepareStatement(oTBQueries.CHK_DATE);
            pStmt.setObject(1, sPeriod, Types.VARCHAR);
            pStmt.setObject(2, sCurDate, Types.VARCHAR);            
            rs = pStmt.executeQuery();
          
            if (!rs.next())
            {
                throw new IBABusinessException("Finance.DateError");
            }

            if(rs != null)
                rs.close();                
            if(pStmt != null)
              pStmt.close();                  

            // Close the con
//            dsConn.closeConn(con);                            
        }
        catch(IBAFatalException fe)
        {
            // Close the con
            dsConn.closeConn(con);              
        
            System.out.println("An Exception has occurred " + fe.getMessage());
            throw new IBAFatalException(fe.getErrorKey());
        }                                
        catch(IBABusinessException be)
        {
            // Close the con
            dsConn.closeConn(con);              

            be.setiErrCode(-90);
        
            be.setsMessage("Date does n't fall within the selected period!");
            System.out.println("An Exception has occurred " + be.getMessage());
            throw new IBABusinessException(be.getErrorKey());
        }        
        catch(SQLException e)
        {
            // Close the con
            dsConn.closeConn(con);              
        
            System.out.println("An Exception has occurred"+ e.getMessage());
            System.out.println("error code is"+e.getErrorCode());
            IBAFatalException iba = new IBAFatalException("Finance.DB.Administrator");
            iba.setiErrCode(e.getErrorCode());
            iba.setsMessage(e.getMessage());
            e.printStackTrace();
            throw iba;                          
        }
        return true;    
    }  


/**
    * This method validates the voucher date if the selected period belongs to a past - open calendar
    * @param String sPeriodId, String sDate, String sLocId
    * @exception IBAFatalException, IBABusinessException
    * @return void
*/
    public void validateDatePeriod(String sPeriodId, String sDate, long lLocId) throws IBAFatalException, IBABusinessException
    {       
        try
        {
            dsConn=new DSConnect();
            con=dsConn.getDBConnection();            
            if (con == null)
            {
                throw new IBAFatalException("Finance.DB.Administrator");
            }                        
            
            pStmt = con.prepareStatement(oTBQueries.IS_CLNDR_PAST);
            pStmt.setObject(1, sPeriodId, Types.VARCHAR);
            rs = pStmt.executeQuery();

            // Is the Calendar Past-Open
            if (!rs.next())
            {
                // Check if the date falls in the selected period
                this.chkDate(sPeriodId, sDate, con);
                this.validateVoucherDate(lLocId,sDate, con);
            
                // No
                if(rs != null)
                    rs.close();
                if(pStmt != null)
                  pStmt.close();

                // Close the con
                dsConn.closeConn(con);                                              

                // Exit
                return;                
            }     
            
            if(rs != null)
                rs.close();                
            if(pStmt != null)
              pStmt.close();                  

            pStmt = con.prepareStatement(oTBQueries.VALIDATE_DATE_OF_PAST_PRD);
            pStmt.setObject(1,sPeriodId,Types.VARCHAR);            
            pStmt.setObject(2, sDate, Types.VARCHAR);
            rs = pStmt.executeQuery();

            if (rs.next())
            {
                throw new IBABusinessException("Finance.Date.PastCalendar.Error");
            }

            if(rs != null)
                rs.close();
            if(pStmt != null)
              pStmt.close();

            // Close the con
            dsConn.closeConn(con);                            
        }
        catch(IBAFatalException fe)
        {                
            // Close the con
            dsConn.closeConn(con);              

            fe.printStackTrace();
            throw fe;
        }
        catch(IBABusinessException be)
        {                
            // Close the con
            dsConn.closeConn(con);              

            throw be;
        }
        catch(Exception e)
        {                
            // Close the con
            dsConn.closeConn(con);              
        
            IBAFatalException iba = new IBAFatalException("Finance.DB.Administrator");
            e.printStackTrace();
            throw iba;                          
        }        
    }        

/**
    * This method validates the date against the max date of the posted vouchers in the same location
    * @param String sLocId, String sDate
    * @exception IBAFatalException, IBABusinessException
    * @return void
*/
    public void validateVoucherDate(long lLocId, String sDate, Connection con) throws IBAFatalException, IBABusinessException
    {          
//        DSConnect dsConn = null;
        try
        {
//            dsConn=new DSConnect();
//            con=dsConn.getDBConnection();            
            if (con == null)
            {
                throw new IBAFatalException("Finance.DB.Administrator");
            }        

            // Pls add this query in ur sql queries
            pStmt = con.prepareStatement(oTBQueries.VALIDATE_VH_DATE);
            pStmt.setObject(1, sDate, Types.VARCHAR);            
            pStmt.setLong(2, lLocId);           
            rs = pStmt.executeQuery();
            
            if (!rs.next())
            {
                // Pls define the following error key in the ApplicationResources file 
                // before you use this function
                //Finance.Voucher.DateError=Invalid Voucher Date! Vouchers for this date have already been posted!
                throw new IBABusinessException("Finance.Voucher.DateError");
            }                              

            if(rs != null)
                rs.close();                
            if(pStmt != null)
                pStmt.close();                             
              
            // Close the con
//            dsConn.closeConn(con);
        }
        catch(IBABusinessException be)
        {
            // Close the con
            dsConn.closeConn(con);
            
            // To track the businness exception in the action class
            be.setiErrCode(-90);
            
            System.out.println("An Exception has occurred " + be.getMessage());
            throw be;
        }                        
        catch(IBAFatalException fe)
        {
            // Close the con
            dsConn.closeConn(con);
        
            System.out.println("An Exception has occurred " + fe.getMessage());
            throw fe;
        }                
        catch(SQLException e)
        {
            // Close the con
            dsConn.closeConn(con);              
        
            System.out.println("An Exception has occurred"+ e.getMessage());
            System.out.println("error code is"+e.getErrorCode());
            IBAFatalException iba = new IBAFatalException("Finance.DB.Administrator");
            iba.setiErrCode(e.getErrorCode());
            iba.setsMessage(e.getMessage());
            e.printStackTrace();
            throw iba;                          
        }
        return;
    }      

/**
    * This method validates the date against the max date of the posted vouchers in the same location
    * @param String sLocId, String sDate
    * @exception IBAFatalException, IBABusinessException
    * @return void
*/
    public boolean updateOnSendBack(TEVBPVVO oTBVO) throws IBAFatalException, IBABusinessException
    {       
        int iCount = 0;
        try
        {
            dsConn = new DSConnect();
            con=dsConn.getDBConnection();            
            if (con == null)
            {
                throw new IBAFatalException("Finance.DB.Administrator");
            }        

            // Pls add this query in ur sql queries
            pStmt = con.prepareStatement(oTBQueries.UPDATE_CLMHDR_ONSENDBACK);

            pStmt.setLong(1,oTBVO.getLEmployeeNo());
            pStmt.setLong(2,oTBVO.getLLocationCode());
            pStmt.setObject(3, oTBVO.getLstClaimNo(), Types.VARCHAR); 
                        
            iCount = pStmt.executeUpdate();
            con.setAutoCommit(false);
            if (iCount < 1)
            {
                if(pStmt != null)
                    pStmt.close();
                con.rollback();                                                
                throw new IBABusinessException("Finance.ReAssignCheque.Voucher.AlreadyProcess");
            }              
            if(pStmt != null)
                pStmt.close();                                           
            // Close the con
            pStmt = con.prepareStatement(oTBQueries.INSERT_SENDBACK_CMNTS);

            pStmt.setLong(1,oTBVO.getLLocationCode());
            pStmt.setObject(2,oTBVO.getLstClaimNo(),Types.VARCHAR);
            pStmt.setLong(3,oTBVO.getLEmployeeNo());
            pStmt.setObject(4,oTBVO.getHidSBComments(),Types.VARCHAR);
            iCount = 0;
            iCount = pStmt.executeUpdate();
            if (iCount < 1)
            {
                if(pStmt != null)
                    pStmt.close();
                con.rollback();                                                
                dsConn.closeConn(con);
                return false;
            }
            dsConn.closeConn(con);
            return true;
        }
        catch(IBABusinessException be)
        {
            // Close the con
            dsConn.closeConn(con);
            
            // To track the businness exception in the action class
            be.setiErrCode(-90);
            
            System.out.println("An Exception has occurred " + be.getMessage());
            throw be;
        }                        
        catch(IBAFatalException fe)
        {
            // Close the con
            fe.printStackTrace();
            dsConn.closeConn(con);
        
            System.out.println("An Exception has occurred " + fe.getMessage());
            throw fe;
        }                
        catch(SQLException e)
        {
            // Close the con
            dsConn.closeConn(con);              
        
            System.out.println("An Exception has occurred"+ e.getMessage());
            System.out.println("error code is"+e.getErrorCode());
            IBAFatalException iba = new IBAFatalException("Finance.DB.Administrator");
            iba.setiErrCode(e.getErrorCode());
            iba.setsMessage(e.getMessage());
            e.printStackTrace();
            throw iba;                          
        }
    }          

/**
     * This method retrieves sum of local receipts amount SUM(RECEIPT_AMT) FROM FIN_TR_RECEIPT
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return long
*/ 
    public long getFRLocTotRefunds(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        long lTotRefunds = 0;
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lTotRefunds;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_SUM_FRLOC_RECEIPT_AMT);            
            pStmt.setObject(1,sClmId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if (rs.next()) 
            {
                lTotRefunds = rs.getLong("TOT_REFUNDS");
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
        return lTotRefunds;
    }    

/**
     * This method retrieves sum of foreign currency refund amount SUM(RECEIPT_AMT) FROM FIN_TR_RECEIPT
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return long
*/ 
    public long getFRRefundDtls(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        long lFRCurrRefunds = 0;
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                throw new IBAFatalException("Finance.DB.Administrator");
            }
            pStmt=con.prepareStatement(oTBQueries.GET_SUM_FRCURR_RECEIPT_AMT);            
            pStmt.setObject(1,sClmId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if (rs.next()) 
            {
                lFRCurrRefunds = rs.getLong("FR_REFUNDS");
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
        return lFRCurrRefunds;
    }        

/**
     * This method retrieves EXP_ACCT_ID,SUM(SANC_AMT) from FIN_TR_CLM_CLASS, FIN_TR_CLM_RATE, FIN_TR_CLM_PRD
     *        FIN_TR_CLM_PCT, FIN_TR_CLM_LS, FIN_TR_CLM_DA, FIN_TR_HDS
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getFRLocClaimSanctAmt(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        List lstClaims = new ArrayList();
        List lstExpAcctIds = new ArrayList();
        List lstSancAmt = new ArrayList();
        int i=0;
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lstClaims;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_SUM_FRLOC_CLMSANCT);            
            for(i=1;i<7;i++)
                pStmt.setObject(i,sClmId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            while (rs.next()) 
            {
                lstExpAcctIds.add(rs.getString("EXP_ACCT_ID"));
                lstSancAmt.add(rs.getString("SANC_AMT"));
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
            lstClaims.add(lstExpAcctIds);
            lstClaims.add(lstSancAmt);
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
        return lstClaims;
    }            

/**
     * This method retrieves EXP_ACCT_ID,SUM(SANC_AMT) from FIN_TR_CLM_CLASS, FIN_TR_CLM_RATE, FIN_TR_CLM_PRD
     *        FIN_TR_CLM_PCT, FIN_TR_CLM_LS, FIN_TR_CLM_DA, FIN_TR_HDS
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getFRClaimSanctAmt(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        List lstClaims = new ArrayList();
        List lstExpAcctIds = new ArrayList();
        List lstSancAmt = new ArrayList();
        int i=0;
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                return lstClaims;
            }
            pStmt=con.prepareStatement(oTBQueries.GET_SUM_FR_CLMSANCT);            
            for(i=1;i<7;i++)
                pStmt.setObject(i,sClmId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            while (rs.next()) 
            {
                lstExpAcctIds.add(rs.getString("EXP_ACCT_ID"));
                lstSancAmt.add(rs.getString("SANC_AMT"));
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
            lstClaims.add(lstExpAcctIds);
            lstClaims.add(lstSancAmt);
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
        return lstClaims;
    }           

/**
     * This method retrieves FE_CONV_RATE,FE_AMT FROM FIN_TR_CLM_HDR,FIN_DEPORDER_HDR,FIN_DEPORDER_DTL
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getFRDepOrderDtls(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        List lstDepOrderDtls = new ArrayList();
        List lstConvRate = new ArrayList();
        List lstFEAmt = new ArrayList();
        String sVouchStatus = "";
        int i=0;
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                throw new IBABusinessException("Finance.DB.Administrator");
            }
            pStmt=con.prepareStatement(oTBQueries.GET_DEPORDER_JVVOUCHSTATUS);
            pStmt.setObject(1,sClmId,Types.VARCHAR);
            rs = pStmt.executeQuery();
            if(rs.next())
            {
                sVouchStatus = rs.getString("TXN_STATUS_GBL");
                if(!sVouchStatus.equals("VHSTAT$6"))
                    throw new IBABusinessException("Finace.TEVBPV.InvalidVouchStat");
            }
            else
            {
                rs.close();
                if(pStmt != null)
                    pStmt.close();
                dsConn.closeConn(con);
                throw new IBABusinessException("Finance.DB.Administrator");
            }
            rs.close();
            if(pStmt != null)
                pStmt.close();
            pStmt=con.prepareStatement(oTBQueries.GET_DEPORDER_DTLS);            
            pStmt.setObject(1,sClmId,Types.VARCHAR);
            rs = pStmt.executeQuery();
            while (rs.next()) 
            {
                lstFEAmt.add(rs.getString("FE_AMT"));
                lstConvRate.add(rs.getString("FE_CONV_RATE"));
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
            lstDepOrderDtls.add(lstFEAmt);
            lstDepOrderDtls.add(lstConvRate);
            dsConn.closeConn(con);                       
        }       
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");                          
        }
        catch(IBABusinessException ibe)
        {
            ibe.printStackTrace();
            throw ibe;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBABusinessException("Finance.DB.Administrator");
        }        
        return lstDepOrderDtls;
    }    

/**
     * This method retrieves CONVR_RATE,FC_AMOUNT FROM FIN_TR_RECEIPT, FIN_TR_CLM_RCPTDTL, FIN_TR_CLM_HDR
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
*/ 
    public List getFRReceiptDtls(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        List lstFrReceiptDtls = new ArrayList();
        List lstConvRate = new ArrayList();
        List lstFrAmt = new ArrayList();

        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                throw new IBABusinessException("Finance.DB.Administrator");
            }
            pStmt=con.prepareStatement(oTBQueries.GET_FC_RCPT_DTL);
            pStmt.setObject(1,sClmId,Types.VARCHAR);
            rs = pStmt.executeQuery();
            while (rs.next()) 
            {
                lstFrAmt.add(rs.getString("FC_AMOUNT"));
                lstConvRate.add(rs.getString("CONVR_RATE"));
            }            
            rs.close();
            if(pStmt != null)
                pStmt.close(); 
            lstFrReceiptDtls.add(lstFrAmt);
            lstFrReceiptDtls.add(lstConvRate);
            dsConn.closeConn(con);                       
        }       
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");                          
        }
        catch(IBABusinessException ibe)
        {
            ibe.printStackTrace();
            throw ibe;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBABusinessException("Finance.DB.Administrator");
        }        
        return lstFrReceiptDtls;
    }            

/**
     * This method retrieves SUM(FE_CONV_RATE*FE_AMT) (Deputation Order Amount) FROM FIN_TR_CLM_HDR, FIN_DEPORDER_HDR, FIN_DEPORDER_DTL 
     * @param String sClmId
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return long deputation order amount
*/ 
    public long getTotDepOrderAmt(String sClmId) throws IBAException,IBAFatalException,IBABusinessException
    {        
        long lTotDepOrderAmt = 0;
        try
        {      
            DSConnect dsConn=new DSConnect();
            con=dsConn.getDBConnection();
            if(con == null)
            {
                System.out.println("Connection Failed");
                throw new IBAFatalException("Finance.DB.Administrator");
            }
            pStmt=con.prepareStatement(oTBQueries.GET_DEPORDER_AMT);            
            pStmt.setObject(1,sClmId,Types.VARCHAR);
            rs=pStmt.executeQuery();
            if (rs.next()) 
            {
                lTotDepOrderAmt = rs.getLong("DEPUTATION_AMT");
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
        return lTotDepOrderAmt;
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
}