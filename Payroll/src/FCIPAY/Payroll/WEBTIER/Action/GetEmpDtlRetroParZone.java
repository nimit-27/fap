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

public class GetEmpDtlRetroParZone extends Action 
{
	StringBuffer xml;
    String txtEmpNo=null,txtEmpName=null,txtCpfCode=null,txtSiteID=null,finYear=null,
        screenName=null,txtClaimAmt=null,txtPayCode=null,txtEmpNum=null,txtFinYear=null,txtAdjType=null,
        txtPayMode=null;
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    throws Exception
    {
        try
        {
            String mode=(String)request.getParameter("mode");
            txtEmpNo=(String)request.getParameter("txtEmpNo");
            txtEmpName=(String)request.getParameter("txtEmpName");
            txtCpfCode=(String)request.getParameter("txtCpfCode");
            txtSiteID=(String)request.getParameter("txtSiteID");
            screenName=(String)request.getParameter("screenName");
			finYear = (String)request.getParameter("finYear");
            txtClaimAmt = (String)request.getParameter("txtClaimAmt");
            txtPayCode = (String)request.getParameter("txtPayCode");
            txtEmpNum   = (String)request.getParameter("txtEmpNum");
            txtFinYear  = (String)request.getParameter("txtFinYear");
            txtAdjType  = (String)request.getParameter("txtAdjType");
            txtPayMode =   (String)request.getParameter("txtPayMode");
            xml=new StringBuffer();
            xml.setLength(0);
            xml.append("<Table>");
            if(mode.equals("1"))
            {
                xml.append("<status>");
                getData(request);
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
    private void getData(HttpServletRequest req) throws EnrgiseSystemException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters    
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;    
        ArrayList oOutArray; 
    if(screenName.equals("ChangeZoneScreen"))
    {
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(txtEmpNo)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(txtEmpName)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(txtCpfCode)));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_getempfinlov_All(?,?,?,?,?)");
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());
        int count = 0;
        QueryRow oRow = null;
        Iterator oIt = oList.iterator();
        while(oIt.hasNext())
        {
            oRow = (QueryRow)oIt.next();
            xml.append("<record>"+ oRow.get("emp_num").getString() +"</record>");
            xml.append("<record>"+ oRow.get("emp_name").getString() +"</record>");
            xml.append("<record>"+ oRow.get("cpf_code").getString() +"</record>");
            xml.append("<record>"+ oRow.get("pres_location_code").getString() +"</record>");
            xml.append("<record>"+ oRow.get("loc_desc").getString() +"</record>");
            xml.append("<record>"+ oRow.get("dsgn_desc").getString() +"</record>");
            xml.append("<record>"+ EnrgiseUtil.convertToString(oRow.get("emp_birth_date").getDate()) +"</record>");
            xml.append("<record>"+ oRow.get("parent_zone_desc").getString() +"</record>");
            xml.append("<record>"+ oRow.get("staff_code").getString() +"</record>");
        } 
     }
    if(screenName.equals("CPFNewPaymentScreen"))
    {
           oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(txtEmpNo)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(txtCpfCode)));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(txtEmpName)));
         oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(txtSiteID)));
        oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"PKG_CPF_FCI.proc_cpf_supp_lovq(?,?,?,?,?,?)");
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());
        int count = 0;
        QueryRow oRow = null;
        Iterator oIt = oList.iterator();
        while(oIt.hasNext())
        {
            oRow = (QueryRow)oIt.next();
            xml.append("<record>"+ oRow.get("emp_num").getString() +"</record>");
            xml.append("<record>"+ oRow.get("emp_name").getString() +"</record>");
            
        }    
    }
        if(screenName.equals("LeaseAccomScreen"))
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(txtEmpNo)));
            oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"payroll_pkg_ext.proc_getleaseaccomamtcal(?,?,?)");
            DBObject oOutObject = (DBObject)oOutArray.get(0);
            oList = (ArrayList)(oOutObject.getObject());
            int count = 0;
            QueryRow oRow = null;
            Iterator oIt = oList.iterator();
            while(oIt.hasNext())
            {
                oRow = (QueryRow)oIt.next();
               xml.append("<record>"+ oRow.get("CEMP_BASIC").getString() +"</record>");
               
            }    
        }
        if(screenName.equals("MaintNWNPLbrSORDtlScreen"))
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(txtSiteID)));
            oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_getnwnpregionid(?,?,?)");
            DBObject oOutObject = (DBObject)oOutArray.get(0);
            oList = (ArrayList)(oOutObject.getObject());
            int count = 0;
            QueryRow oRow = null;
            Iterator oIt = oList.iterator();
            while(oIt.hasNext())
            {
                oRow = (QueryRow)oIt.next();
                xml.append("<record>"+ oRow.get("loc_id").getString() +"</record>");
                xml.append("<record>"+ oRow.get("Region_name").getString() +"</record>");
               
            }    
        }
        if(screenName.equals("MaintNWNPLbrASORDtlScreen"))
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(txtSiteID)));
            oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"pkg_pay_labour.proc_getnwnpregionid(?,?,?)");
            DBObject oOutObject = (DBObject)oOutArray.get(0);
            oList = (ArrayList)(oOutObject.getObject());
            int count = 0;
            QueryRow oRow = null;
            Iterator oIt = oList.iterator();
            while(oIt.hasNext())
            {
                oRow = (QueryRow)oIt.next();
                xml.append("<record>"+ oRow.get("loc_id").getString() +"</record>");
                xml.append("<record>"+ oRow.get("Region_name").getString() +"</record>");
               
            }    
        }
		if(screenName.equals("EmpPrmsMediBillsScreen"))
        {
            
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(txtEmpNo)));
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(finYear)));
            //oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(txtClaimAmt)));
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(txtPayCode)));
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
            oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
            //oOutArray = oBean.callProc(oParameters,"PKG_PRMS.Proc_get_Ceil_details(?,?,?,?,?,?)");
            oOutArray = oBean.callProc(oParameters,"PKG_PRMS.Proc_get_Ceil_details(?,?,?,?,?)");
            DBObject oOutObject = (DBObject)oOutArray.get(0);
            oList = (ArrayList)(oOutObject.getObject());
            int count = 0;
            QueryRow oRow = null;
            Iterator oIt = oList.iterator();
            while(oIt.hasNext())
            {
                oRow = (QueryRow)oIt.next();
                xml.append("<record>"+ oRow.get("OPENING_BALANCE").getString() +"</record>");
                xml.append("<record>"+ oRow.get("CLOSE_BALANCE").getString() +"</record>");

               
            }    
        }
        if(screenName.equals("EmpPrmsCeilAdjScreen"))
        {
            long lStartPosition=1;
            long lLastPosition=2;
                        String Finyr=new String(txtFinYear);
                        if (Finyr==""||Finyr==null)
                        {
                                oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(lStartPosition)));
                                oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(lLastPosition)));
                                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(txtEmpNum)));
                                oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.CURSOR));
                                oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
                                oOutArray = oBean.callProc(oParameters,"PKG_PRMS.proc_getPrmsCeilAdjhdr(?,?,?,?,?)");
                                DBObject oOutObject = (DBObject)oOutArray.get(0);
                                oList = (ArrayList)(oOutObject.getObject());
                                int count = 0;
                                QueryRow oRow = null;
                                Iterator oIt = oList.iterator();
                                while(oIt.hasNext())
                                {
                                        oRow = (QueryRow)oIt.next();
                                        
                                        xml.append("<record>"+ oRow.get("err_msg").getString() +"</record>");
                                        xml.append("<record>"+ oRow.get("empname").getString() +"</record>");
                                        xml.append("<record>"+ oRow.get("emp_category").getString() +"</record>");
                                        xml.append("<record>"+ oRow.get("cpf_code").getString() +"</record>");
                                        xml.append("<record>"+ oRow.get("retirement_date").getString() +"</record>");
                                        xml.append("<record>"+ oRow.get("emp_status").getString() +"</record>");
                                        xml.append("<record>"+ oRow.get("dsgn_desc").getString() +"</record>");
        
                                
                                }
                        }
                        else
                        {
                            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(txtEmpNum)));
                            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String(txtFinYear)));
                            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,new String(txtClaimAmt)));
                            oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,new String(txtAdjType)));
                            oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR,new String(txtPayMode)));
                            oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.CURSOR));
                            oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.INTEGER));
                            oOutArray = oBean.callProc(oParameters,"PKG_PRMS.PROC_CEIL_ADJ_OBCB(?,?,?,?,?,?,?)");
                            DBObject oOutObject = (DBObject)oOutArray.get(0);
                            oList = (ArrayList)(oOutObject.getObject());
                            int count = 0;
                            QueryRow oRow = null;
                            Iterator oIt = oList.iterator();
                            while(oIt.hasNext())
                            {
                                    oRow = (QueryRow)oIt.next();
                                    xml.append("<record>"+ oRow.get("OPENING_BALANCE").getString() +"</record>");
                                    xml.append("<record>"+ oRow.get("CLOSE_BALANCE").getString() +"</record>");
                            
                            
                            }
                        }
        }
        if(screenName.equals("loginScreen"))
        {
            oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.INTEGER));
            oOutArray = oBean.callProc(oParameters,"fcipayroll.pkg_pay_l2_datafix.check_maintain_status(?)");
            DBObject oOutObject = (DBObject)oOutArray.get(0);
            oList = (ArrayList)(oOutObject.getObject());
            int count = 0;
            QueryRow oRow = null;
            Iterator oIt = oList.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();
                    xml.append("<record>"+ oRow.get("STATUS").getString() +"</record>");
                    
            
            
            }
        
        }
    }
    
}   