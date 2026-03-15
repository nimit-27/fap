package FCIPAY.COMMON.BUSINESSTIER.BusinessDelegates;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import oracle.sql.*;
import oracle.jdbc.pool.*;
import oracle.jdbc.driver.*;

import FCIPAY.COMMON.DATAACCESSTIER.DAO.LoginDAO;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;


public class LoginBD 
{  
    LoginDAO oLogInDAO = new LoginDAO();

  /**
   * This method brings the location codes
   * @param String sEmpNo
   * @exception IBAFatalException,IBABusinessException, IBAException
   * @return ArrayList
   */
//  public ArrayList getLocationCodes(String sEmpNo,String sEmpPwd) throws IBAFatalException,IBAException
    public ArrayList getLocationCodes(String sEmpNo,String sEmpPwd) throws EnrgiseSystemException, EnrgiseApplicationException  
    {
        //System.out.println("Inside LogIn BD");
        return (oLogInDAO.getLocationCodes(sEmpNo,sEmpPwd));
    }    

   /**
   * This method brings the emp details for user info bean
   * @param String sEmpNo
   * @exception IBAFatalException,IBABusinessException, IBAException
   * @return ArrayList
   */
//    public ArrayList getEmpDetails(String sEmpNo) throws IBAFatalException,IBABusinessException, IBAException
    public ArrayList getEmpDetails(String sEmpNo) throws EnrgiseSystemException, EnrgiseApplicationException  
    {
        return (oLogInDAO.getEmpDetails(sEmpNo));
    }

    /**
   * This method brings the emp details for user info bean
   * @param String sEmpNo
   * @exception IBAFatalException,IBABusinessException, IBAException
   * @return ArrayList
   */
//    public ArrayList getEmpDetails(String sEmpNo,String sEmpPwd) throws IBAFatalException,IBABusinessException, IBAException
      public ArrayList getEmpDetails(String sEmpNo,String sEmpPwd,String locCode)  throws EnrgiseSystemException, EnrgiseApplicationException  
    {
        return (oLogInDAO.getEmpDetails(sEmpNo,sEmpPwd,locCode));
    }
    
    public void updateLoginAttempts(String sEmpNo,int val) throws EnrgiseSystemException, EnrgiseApplicationException  
    {
        //System.out.println("Inside LogIn BD");
        oLogInDAO.updateLoginAttempts(sEmpNo,val);
    }    
 
}