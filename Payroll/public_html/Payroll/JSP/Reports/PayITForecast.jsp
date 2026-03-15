<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<%@ page import="java.lang.String" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form action="ReportLinkerAction" name="PayITForecastForm" type="FCIPAY.Payroll.WEBTIER.Form.PayITForecastForm" scope="session" >
<bean:define id="ParentForm" name="PayITForecastForm" toScope="request" />

<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />


<enrgise:errors/>
<logic:messagesPresent message="true">
<Table>
    <html:messages id="message" message="true">
    <TR><TD>
      <bean:write name="message"/>
    </TD></TR>
    </html:messages>
</Table>
</logic:messagesPresent>
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>IT FORECAST REPORT</TD>
</TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>       
      <!-- Body table Starts -->
      <TABLE cellSpacing=0 cellPadding=0 >
      <!--Account  Header Row Starts -->
      <TR>
        <TD class=subHeader colspan=6> IT Forecast Report</TD>
      </TR>
      <TR>
        <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
      </TR>
      
      <tr height="15" >
        <td colspan="2"></td>
      </tr>       
           
   	 </table>
        <table cellspacing=0 cellpadding=0 border=0>
          <!-- Detail Information Row starts -->          
            <TR height="100">
              <TD colspan=11>          
                <!-- Account Config Detail Table Starts -->
                <TABLE cellspacing="5" cellPadding="0" border=0 >                      
                  <center>
                  <TR height=25>         
                    <!-- Detail table Container starts -->                    
                    <TD class=labelText width="40%" ><bean:message key="Payroll.PaySlip.EmpNumber" /></td>
                    <td  align="left" ><html:text  property="txtEmp" maxlength="10" size="16" styleClass="optional"
					onchange=
					"if(!(checkEmployee(PayITForecastForm.txtEmp.value,PayITForecastForm.loginLocCode.value)))
					{
						PayITForecastForm.txtEmp.value='';
					}"
					/>
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                    onclick="return ShowLovEmpNo();" >                       
                    <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                    </td>                           
                                      
                  </tr>    
                  
                  <TR height=25>         
                    <!-- Detail table Container starts -->
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.PaySlip.Year" /></td><td >
                    <html:text  property="txtYYMM"  maxlength="6" size="16" styleClass="required"   
                    onchange="                                                  
                    if(!(chk_YearMonth()))
                    {
                    }                                            
                    " 
                   
                    /><bean:message key="Payroll.MaintDARates.yymm" />
                    </td>              
                  </tr>                 
                  
                </center>
              </table>
                                
          <!-- Tab table Row 3 starts -->          
          <TR>
              <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
          </TR>
          <tr height="15" >
              <td colspan="16"></td>
          </tr>
        <TR>
          <td align=center bgcolor=#4682b4 width="37%"></td>
          <td  bgcolor=#4682b4><html:button value=' GENERATE IT FORECAST REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
          <td width="45%" bgColor=#4682b4></td>
          <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>	
		<table cellSpacing=0 cellPadding=3 border=0>
			<tr height=50><td>&nbsp;</tr>
			<tr height=20>
				<td style="font-size:12px;font-weight:bold"> Note:</td>
			</tr>
			<tr>
				<td style="font-size:12px">Please compute Income Tax, before the generation of IT Forecast Report, through Monthly Payroll option to consider the latest change of records (if any)</td>
			</tr>
		</tr>
		</table>
      </table>
     </td>
    </tr>       
  
  </TABLE>
  </td>
	</tr>
    <!-- Tab Table Ends -->
    <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript" type="text/javascript">
function doGetReport()
{
  var check_valid=chk_YearMonth();
  if(check_valid == false)
  {
      document.getElementById("txtYYMM").focus();   
      return false;
  }
  else	
  {
	url="../../../GetPilotLocStatus.do";
    prm="mode=1&p_yymm="+PayITForecastForm.txtYYMM.value+"&p_location="+PayITForecastForm.loginLocCode.value+"&p_emp_num="+PayITForecastForm.txtEmp.value+"&hdnEmpLbrFlag="+PayITForecastForm.hdnEmpLbrFlag.value;
	xml=getXML(url,prm);
	Tags=xml.getElementsByTagName("record");
	var if_pilot="";
	if(Tags.length>0)
	{
		if_pilot=Tags[0].childNodes[0].nodeValue;
	}
	if(if_pilot==0)
	{
		var winurl="IT_FORECAST_DETAIL.rdf&P_YYMM="+PayITForecastForm.txtYYMM.value+"&P_EMP_NUM="+PayITForecastForm.txtEmp.value+"&P_LOCATION="+PayITForecastForm.loginLocCode.value+"&P_EMP_LBR="+PayITForecastForm.hdnEmpLbrFlag.value;
	}
	else
	{
		var winurl="IT_FORECAST_DETAIL_new.rdf&P_YYMM="+PayITForecastForm.txtYYMM.value+"&P_EMP_NUM="+PayITForecastForm.txtEmp.value+"&P_LOCATION="+PayITForecastForm.loginLocCode.value+"&P_EMP_LBR="+PayITForecastForm.hdnEmpLbrFlag.value;
	}
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.PayITForecastForm.submit();
  }
}

</script>	 

</TBODY>
</TABLE>

<!-- Container Table Ends -->

<html:hidden name="PayITForecastForm"  property="screenMode"/>
<html:hidden name="PayITForecastForm"  property="screenName" value="PayITForecastReport"/>
<html:hidden property="buttonFlag" name="PayITForecastForm"  />
<html:hidden property="txtAllEmpFlag" name="PayITForecastForm"  />  
<html:hidden property="lovKey" name="PayITForecastForm"  />
<html:hidden property="txtFields" name="PayITForecastForm"  />   
<html:hidden property="txtSearchFields" name="PayITForecastForm"  />
<html:hidden property="txtDisplayFields" name="PayITForecastForm"  />
<html:hidden property="txtIndex" name="PayITForecastForm"  />
<html:hidden property="loginLocCode" name="PayITForecastForm"  />
<html:hidden property="hdnLoginUserId" name="PayITForecastForm"  />    
<html:hidden property="hdnLocation" name="PayITForecastForm"    />        
<html:hidden property="hdnPayUser" name="PayITForecastForm"  />        
<html:hidden property="hdnLoginUserName" name="PayITForecastForm"  />
<html:hidden property="txtCpfCode" name="PayITForecastForm"  />                       <!--added by dushyant on 20-08-2010-->
<input type="hidden" name="queryParam" /> 
<input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>
<script language="javascript">

function lfnLoad()
{  
  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    PayITForecastForm.action="../../../PayITFGetAccess.do"
    PayITForecastForm.submit();  
  }
}

function ShowLovEmpNo()
{       
    PayITForecastForm.lovKey.value = "ReportGeneratePayITForecastEmp" + PayITForecastForm.screenName.value + "U";
	PayITForecastForm.queryParam.value="txtSiteID="+ PayITForecastForm.loginLocCode.value +",hdnEmpLbrFlag="+PayITForecastForm.hdnEmpLbrFlag.value ;
    //PayITForecastForm.queryParam.value="txtSiteID="+ PayITForecastForm.loginLocCode.value +" " ; 
    PayITForecastForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
    PayITForecastForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PayITForecastForm');
    return true;
}

function chk_YearMonth()
{      
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6); 
    var month1 = yearM.substring(2,4); 
    var  month2=parseInt(month1)+1;
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        } 
     
        else if ((month < 1 || month > 12) && (month2!=month)) 
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;
        }
        else
        {
            return true;
        }
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;     
        return false;
    }
}

</script>	