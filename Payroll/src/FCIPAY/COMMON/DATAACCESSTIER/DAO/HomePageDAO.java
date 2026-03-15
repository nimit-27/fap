package FCIPAY.COMMON.DATAACCESSTIER.DAO;
import java.sql.*;

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import java.util.ArrayList;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.util.Iterator;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;
import FCIPAY.COMMON.UTILITY.BaseDAO;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;



public class HomePageDAO extends BaseDAO
{
    public HomePageDAO() 
    {
        super("Common");
    }

    public String getReportURL(String tempRepNo,String tempPageName) throws EnrgiseSystemException, EnrgiseApplicationException
    //throws IBAFatalException,SQLException
    {
        ResultSet res=null;
        String reportUrl="";
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        ArrayList oParameters, oOutArray;
        
            oParameters = new ArrayList();
            oParameters.add(new InputDBObject(1,ParameterTypes.VARCHAR,new String(tempPageName)));
            oParameters.add(new InputDBObject(2,ParameterTypes.VARCHAR,new String(tempRepNo)));            
///           oOutArray = oBean.callProc(oParameters,"PAYROLL_PKG.proc_GetConvAllowHeaderCount(?,?,?,?,?)");

        
            oOutArray = oBean.executeQuery(oParameters, FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_GETREPORT_URL); 
            Iterator oIt;
             QueryRow oRow = null;      

            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();
                    reportUrl =  (oRow.get("REPORT_URL").getString());
            }
                            
            
//            reportUrl = ((QueryRow)oOutArray.get(0));
//             reportUrl  =  oOutArray.toString(); 
//            reportUrl = ((String)oRepURl.getObject()).toString();
            
//            doPrepareStatement(ScreenAcessQueries.SQL_GETREPORT_URL);
//            setSTRING(tempPageName);
//            setVARCHAR(tempRepNo);
//            res=doExecuteQuery(false);
/*            while(res.next())
                reportUrl=res.getString("report_url");
            res.close();
            closePreparedStatement();
            closeConnection(); */
            return reportUrl;
    }
}