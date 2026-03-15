package FCIPAY.Payroll.WEBTIER.Action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.PrintWriter;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;

public class GetEmpTransferStatus extends Action 
{
    StringBuffer xml;
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    throws Exception
    {
        try
        {
            String mode=(String)request.getParameter("mode");
            String emp_num=request.getParameter("p_emp_num");
            String effective_to_date=(String)request.getParameter("p_eff_to_date");
            //System.out.println("mode"+mode+",loc_code="+loc_code+",yymm="+yymm+" emp_type="+emp_type);
            xml=new StringBuffer();
            xml.setLength(0);
            xml.append("<Table>");
            if(mode.equals("1"))
            {
                xml.append("<status>");
                getData(emp_num,effective_to_date);
                xml.append("</status>");
            }
            xml.append("</Table>");
            System.out.println(xml);
            response.setContentType("text/xml");
            PrintWriter wr=response.getWriter();
            wr.write(xml.toString());
            wr.close();
            wr.flush();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return mapping.findForward(null);                                
    }
    private void getData(String emp_num, String effective_to_date) throws EnrgiseSystemException
    {
       
        ArrayList oParameters = new ArrayList(); //Input Parameters    
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;    
        int count=0;
        ArrayList oOutArray; 

        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new Long(emp_num)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.TIMESTAMP,EnrgiseUtil.convertToSqlDate(effective_to_date)));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
                 
        oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_check_trnsfr_employee(?,?,?)",true,true);
    
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        count = (Integer)oOutObject.getObject();
        
        xml.append("<record>"+ count +"</record>");
    }
}   