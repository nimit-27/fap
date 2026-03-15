    /*
     * Module       :   UploadDAO.java
     * Author       :   V.Jegan
     * Date Written :   4st Oct 2004
     * Description  :   The DataAccess Object and here we will form the queries
     *                  and pass it to the connection class.
     * Revision Log :   (mm/dd/yy initials description)
     * -----------------------------------------------------------------
     * mm/dd/yy     xxxx    <comments on changes>
    */

package FCIPAY.COMMON.DATAACCESSTIER.DAO;
import java.util.StringTokenizer;
import java.io.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries;
import java.net.InetAddress;
//import FCIPAY.COMMON.WEBTIER.Action.ChangePwdAction;

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.Encryption;
import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.DSConnect;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.BaseDAO;

public class PwdUploadDAO extends BaseDAO
{
    public PwdUploadDAO()
    {
        super("CMM");
    }

    /**
     * This function is to replace the local file name with the host name
     * If the path is in Local drive then replace the local drive with the host name of the machine
     * @arg:  String tempPath - the path selected by the user
     * @returns: String which has the correced path along with hostname
     */

    public String replacePath(String tempPath)
    {
        String correctPath="";
        //System.out.println("In Function " + tempPath);
        StringTokenizer temp=new StringTokenizer(tempPath,":");
        int cnt=temp.countTokens();
        String firstString=temp.nextToken();
        if((cnt==2)&&(firstString.length()==1))
        {
            String hstName="";
            try
            {
                InetAddress lclHost;
                lclHost=InetAddress.getLocalHost();
                hstName=lclHost.getHostName();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            String testStr=temp.nextToken();
            correctPath="\\\\"+hstName+testStr;
        }
        else
            correctPath=tempPath;
        //System.out.println("The Corrected Path is " + correctPath);
        return correctPath;
    }

/**
    * This is the setValues() method for constructing the Query
    *   to access to the database.
   */
    public boolean setValues(String strFilePath,long empNo,long locid) throws IBAException,IBAFatalException,IBABusinessException,SQLException
    {
        String fpath="";
        ResultSet res=null;
        boolean retType=false;
        int noOfLines=0;
        int errLine=0;
        
        DSConnect dsc=new DSConnect();
        Connection conn=null;
        PreparedStatement pstmt=null;
        
        try
        {
            conn=dsc.getDBConnection();
            conn.setAutoCommit(false);
            
            //Start of changes
            //System.out.println("The File path is " + strFilePath);
            fpath=replacePath(strFilePath);
//            System.out.println("The Path to be browsed is : " + fpath);
            //End of changes

          
            //fpath=oUploadVO.getFile();
            FileReader fr=new FileReader(fpath);
            BufferedReader br=new BufferedReader(fr);
            String s;//for reading line by line from the input file
            String tempOrgPwd="";

            noOfLines=0;

            pstmt=conn.prepareStatement(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.PasswordQueries.sql_InsertPwdDetails);
            while((s=br.readLine())!=null)
            {
                noOfLines=noOfLines+1;
                if(s.length()!=0)
                {
                    StringTokenizer st=new StringTokenizer(s,",");
                    if(st.countTokens() <=0) 
                    {
                        continue;
                    }
                    int i=1;
                    tempOrgPwd="";
                    while(st.hasMoreTokens())
                    {
                        if(i==1)
                            pstmt.setLong(1,Long.parseLong(st.nextToken()));
                        else if(i==2)
                        {
                            tempOrgPwd=st.nextToken();
                            if(tempOrgPwd.length()<=8)
                                pstmt.setString(2,Encryption.encodePassword(tempOrgPwd,"MD5"));
                            else
                            {
                                throw new IBAFatalException();
                            }
                        }
                        i=i+1;
                    }
                    pstmt.setLong(3,empNo);
                    pstmt.setLong(4,locid);
                }
                pstmt.addBatch();
            }
            int[] success=pstmt.executeBatch();
            System.out.println(success.length);
            if(success.length==noOfLines)
            {
                conn.commit();
                retType=true;
            }
            pstmt.close();
            conn.close();
        }
        catch(SQLException  Sqlex)
        {
            
            conn.rollback();
            pstmt.close();
            conn.close();
//            It gives 1 if it is a Primary Key Error
//            System.out.println("Error Code is " + Sqlex.getErrorCode());
            throw new IBAFatalException(new Integer(Sqlex.getErrorCode()).toString());
        }
        catch(IBAFatalException e)
        {
//            System.out.println("The Error Line is " + noOfLines );
            
            conn.rollback();
            pstmt.close();
            conn.close();
            IBAFatalException ibafe=new IBAFatalException();
            ibafe.setiErrCode(noOfLines);
            ibafe.setsMessage("Length");
            throw ibafe;
        }
        catch(Exception e)
        {
            System.out.println("The Error Line is " + noOfLines );
            conn.rollback();
            pstmt.close();
            conn.close();
            throw new IBAFatalException("Finance.File.NotFound");
        }
        return retType;        
    }
}
