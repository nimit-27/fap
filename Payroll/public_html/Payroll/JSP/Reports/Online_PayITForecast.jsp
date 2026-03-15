<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
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

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form action="ReportLinkerAction" name="OnlinePaySlipReportForm" type="FCIPAY.Payroll.WEBTIER.Form.OnlinePaySlipReportForm" scope="session" >
<bean:define id="ParentForm" name="OnlinePaySlipReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>ONLINE IT FORECAST REPORT</TD>
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
                    <td  align="left" ><html:text  property="txtEmpNo" maxlength="10" size="16" styleClass="optional"  readonly="true" />
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
                    
                    onblur="                                                  
                    if(!(chk_YearMonth()))
                    {
                    }                                            
                    " 
                    /><bean:message key="Payroll.MaintDARates.yymm" />
                    </td>              
                  </tr>                 
    			  <tr id="rowaccesskey">
					<td class="labelText"  width="45%" align="center"><bean:message key="Payroll.PaySlip.AccessKey" /></td><td colspan=2>
					<html:password  property="txtCPFDDYYMM" maxlength="20"  name="OnlinePaySlipReportForm" size="23"  styleClass="required" onchange="return chk_CPFYearMonth();"  />
					<bean:message key="Payroll.MaintDARates.cpf@ddmmyyyy" />
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
          <td  bgcolor=#4682b4><html:button value=' GENERATE IT FORECAST REPORT'  onclick="doGetReport()" property="butInsert" disabled="true" styleClass="bottomBarText" /></td>
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
   
<script language="javascript">
function doGetReport()
{ 
    var winurl="IT_FORECAST_DETAIL_new.rdf&P_EMP_NUM="+OnlinePaySlipReportForm.txtEmpNo.value+"&P_YYMM="+OnlinePaySlipReportForm.txtYYMM.value+"&P_LOCATION_CODE="+OnlinePaySlipReportForm.txtSiteCode.value+"&P_EMP_LBR="+OnlinePaySlipReportForm.txtEmpType.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.OnlinePaySlipReportForm.submit();
}
</script>	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

<html:hidden name="OnlinePaySlipReportForm"  property="screenMode"/>
<html:hidden name="OnlinePaySlipReportForm"  property="screenName" value="OnlinePaySlipReport"/>
<html:hidden property="buttonFlag" name="OnlinePaySlipReportForm"  />
<html:hidden property="txtAllEmpFlag" name="OnlinePaySlipReportForm"  />  
<html:hidden property="lovKey" name="OnlinePaySlipReportForm"  />
<html:hidden property="txtFields" name="OnlinePaySlipReportForm"  />   
<html:hidden property="txtSearchFields" name="OnlinePaySlipReportForm"  />
<html:hidden property="txtDisplayFields" name="OnlinePaySlipReportForm"  />
<html:hidden property="txtIndex" name="OnlinePaySlipReportForm"  />
<html:hidden property="loginLocCode" name="OnlinePaySlipReportForm"  />
<html:hidden property="txtInputField" name="OnlinePaySlipReportForm"  />

<html:hidden property="txtCpfCode" name="OnlinePaySlipReportForm"  />
<html:hidden property="txtSiteCode" name="OnlinePaySlipReportForm"/>
<html:hidden property="txtSiteDesc" name="OnlinePaySlipReportForm"  />
<html:hidden property="txtUserFlag" name="OnlinePaySlipReportForm"  />
<html:hidden property="txtEmpType" name="OnlinePaySlipReportForm"  />

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
  if(mode == 'N' )
  {
     OnlinePaySlipReportForm.butInsert.disabled="";
  }
  else if(mode != 'N' && mode != 'Q' )
  {
     OnlinePaySlipReportForm.action="../../../OnlineITForeCastAction.do"
     OnlinePaySlipReportForm.submit();  
  }

}

function ShowLovEmpNo()
{
   OnlinePaySlipReportForm.butInsert.disabled="true";
   document.getElementById("txtCPFDDYYMM").value="";
   OnlinePaySlipReportForm.lovKey.value = "EmpFinInfo" + OnlinePaySlipReportForm.screenName.value + OnlinePaySlipReportForm.screenMode.value;   
   OnlinePaySlipReportForm.queryParam.value="txtSiteID="+ OnlinePaySlipReportForm.loginLocCode.value +",hdnEmpLbrFlag=X";
   OnlinePaySlipReportForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.EmpName,Payroll.Common.cpfCode,Payroll.common.SiteCode,Payroll.common.SiteDesc,Payroll.common.UserFlag";
   OnlinePaySlipReportForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode,txtSiteCode,txtSiteDesc,txtUserFlag,txtEmpType";    
   OnlinePaySlipReportForm.txtIndex.value = 0;
   OnlinePaySlipReportForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/OnlineSearchScreen.jsp" />', 'OnlinePaySlipReportForm');
   return true;
}
function showLov(pageName, formName) {
    var oLovWin=window.open(pageName,formName, "height=500,width=900,resizable=yes,menubar=no,toolbar=none,statusbar=none");
    oLovWin.moveTo(200,200);
    //oLovWin.document.all.hdnLOVFlag.value = '0';
}

function chk_YearMonth()
{      
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6);    
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
        else if(month < 1 || month > 12)
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
function chk_CPFYearMonth()
{
	OnlinePaySlipReportForm.butInsert.disabled="true";
	var  EmpYYM = document.getElementById("txtCPFDDYYMM").value; 
	var searchIndex = parseInt(EmpYYM.indexOf("@"),10);
	var cpfNo=EmpYYM.substring(0,searchIndex);
	var dob=EmpYYM.substring(searchIndex+1,EmpYYM.length);
	if (searchIndex < 0)
	{
		alert("Invalid AccessKey!!!!!");
		document.getElementById("txtCPFDDYYMM").value=""; 
		event.srcElement.select();
		event.srcElement.focus();
		event.returnValue=false;            
		return false;

	}
	if (dob.length != 8)
	{
		alert("DOB should be a Eight digit Number");    
		document.getElementById("txtCPFDDYYMM").value=""; 
		event.srcElement.select();
		event.srcElement.focus();
		event.returnValue=false;            
		return false;
	}
	 validateUser();
	return true;
}
function validateUser()
{
	OnlinePaySlipReportForm.screenMode.value="N";
	OnlinePaySlipReportForm.action = "../../../ValidateITFORecastAction.do";
	OnlinePaySlipReportForm.submit();
}


</script>