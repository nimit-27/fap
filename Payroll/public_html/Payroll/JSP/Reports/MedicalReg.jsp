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

  <BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />  
  <html:form  action="ReportLinkerAction" name="MedicalRegReportForm" type="FCIPAY.Payroll.WEBTIER.Form.MedicalRegReportForm" scope="session" >
  <bean:define id="ParentForm" name="MedicalRegReportForm" toScope="request" />  
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
  
  <enrgise:errors/>
  <logic:messagesPresent message="true">
  <Table>
    <html:messages id="message" message="true">
      <TR>
        <TD>
          <bean:write name="message"/>
        </TD>
      </TR>
    </html:messages>
  </Table>
  </logic:messagesPresent>
  <html:hidden property="detailDataChanged"  />
  <html:hidden property="headerFields" value="false" />

  <table>
    <TR height=30>
      <TD  colSpan=12 class=mainHeader height=10>MEDICAL REGISTER REPORT</TD>
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
              <TD class=subHeader colspan=6> Medical Register Report</TD>
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
						<TD class=labelText width=40% >
							<bean:message key="Payroll.DirectPayrollAudit.EmpNumber" />	
						</td>

						<td  align="left">
							<html:text  property="txtEmp" maxlength="10" size="16" styleClass="optional" 
							onchange=
							"if(!(checkEmployee(MedicalRegReportForm.txtEmp.value,MedicalRegReportForm.loginLocCode.value)))
							{
								MedicalRegReportForm.txtEmp.value='';
							}"
							/>
							<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
							 onclick="return ShowLovEmpNo();" >                       
							<html:text property="txtEmpName"  size="30" value="" styleClass="locked" readonly="true" />
						</td>
                    </tr>    
                  
                    <TR height=25>         
                    <!-- Detail table Container starts -->                    
						<TD class=labelText width=40% >
							<bean:message key="Payroll.MedicalReg.Medcode" />	
						</td>

						<td  align="left">
							<html:text  property="txtPayCode" maxlength="10" size="16" styleClass="optional"  readonly="true" />
							<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
							 onclick="return ShowMedicalCode();" >                       
							<html:text property="txtPayDesc"  size="20" value="" styleClass="locked" readonly="true" />
						</td>
                    </tr>    

                  <TR height=25>         
                    <!-- Detail table Container starts -->
						<td class="labelText"  align="left">
							<bean:message key="Payroll.DirectPayrollAudit.FromDate" />
						</td>

						<td   >
							<html:text property="txtFromDate" styleClass="required"  style="width:15%;text-align:left"  maxlength="50" readonly="true"   />&nbsp;
							<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="buttxtfrDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtFromDate',this)"   >
						</td>  
                  </tr>
                  
                  <tr height=25>
						<td class="labelText"   align="center">
							<bean:message key="Payroll.DirectPayrollAudit.ToDate" />
						</td>

						<td   >
							<html:text property="txtToDate" styleClass="required"  style="width:15%;text-align:left"  maxlength="50" readonly="true"   onchange=" if(!chk_DateRange())
                                   {
                                     this.focus();
                                     return false;                         
                                    }" />&nbsp;
							<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="buttxttoDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtToDate',this)" >
						</td> 
                  </tr>

                  </center>
                </table>
              </td>
            </tr>
            <!-- Tab table Row 3 starts -->          
            <TR>
              <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
            </TR>
            <tr height="15" >
              <td colspan="16"></td>
            </tr>            
            <TR>
              <td align=center bgcolor=#4682b4 width="37%"></td>
              <td  bgcolor=#4682b4><html:button value=' GENERATE MEDICAL REGISTER REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
              <td width="45%" bgColor=#4682b4></td>
              <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
            </TR>   
          </table>
        </td>
      </tr>
    </TABLE>
    <!-- Tab Table Ends -->

 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript">
function doGetReport()
{  
if(mandatory_Check('MedicalRegReportForm'))
{
    var winurl="MedicalReg.rdf&P_EMP_NUM="+MedicalRegReportForm.txtEmp.value+"&P_MED_CODE="+MedicalRegReportForm.txtPayCode.value+"&P_FROM_DATE="+MedicalRegReportForm.txtFromDate.value+"&P_TO_DATE="+MedicalRegReportForm.txtToDate.value+"&P_LOC_ID="+MedicalRegReportForm.loginLocCode.value+"&P_EMP_TYPE="+MedicalRegReportForm.hdnEmpLbrFlag.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.MedicalRegReportForm.submit();
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="MedicalRegReportForm"  property="screenMode"/>
    <html:hidden name="MedicalRegReportForm"  property="screenName" value="MedicalRegReport" />
    <html:hidden property="buttonFlag" name="MedicalRegReportForm"  />
    <html:hidden property="lovKey" name="MedicalRegReportForm"  />
    <html:hidden property="txtFields" name="MedicalRegReportForm"  />   
    <html:hidden property="txtSearchFields" name="MedicalRegReportForm"  />
    <html:hidden property="txtDisplayFields" name="MedicalRegReportForm"  />
    <html:hidden property="txtIndex" name="MedicalRegReportForm"  />
    <html:hidden property="txtCpfCode" name="MedicalRegReportForm"  />
    <html:hidden property="loginLocCode" name="MedicalRegReportForm"  />

    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(MedicalRegReportForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    MedicalRegReportForm.action="../../../MedicalRegGetAccess.do"
    MedicalRegReportForm.submit();  
  }
}

function ShowMedicalCode()
{
        MedicalRegReportForm.lovKey.value = "MedicalCode" + MedicalRegReportForm.screenName.value + "U";
	    MedicalRegReportForm.queryParam.value = "hdnEmpLbrFlag="+MedicalRegReportForm.hdnEmpLbrFlag.value+",screenName="+MedicalRegReportForm.screenName.value+",screenMode="+MedicalRegReportForm.screenMode.value+",txtSiteID="+MedicalRegReportForm.loginLocCode.value;   // added by swapnendu Dt 07 Sep 2012.
        MedicalRegReportForm.txtSearchFields.value = "";
        MedicalRegReportForm.txtDisplayFields.value = "txtPayCode,txtPayDesc";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','MedicalRegReportForm');
        return true;
}

function ShowLovYYMM()
{
        MedicalRegReportForm.queryParam.value="hdnMaxYYMM="+ MedicalRegReportForm.hdnMaxYYMM.value +" " ;    
        MedicalRegReportForm.lovKey.value = "ReportGeneratePaySlipYear" + MedicalRegReportForm.screenName.value + "U";
        MedicalRegReportForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        MedicalRegReportForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','MedicalRegReportForm');
        return true;
}

function ShowLovEmpNo()
{
        MedicalRegReportForm.lovKey.value = "MedicalRegEmp" + MedicalRegReportForm.screenName.value + "U";
        MedicalRegReportForm.queryParam.value="txtSiteID="+ MedicalRegReportForm.loginLocCode.value+",hdnEmpLbrFlag=" +MedicalRegReportForm.hdnEmpLbrFlag.value; 
        MedicalRegReportForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
        MedicalRegReportForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','MedicalRegReportForm');
        return true;
}

function chk_DateRange()
{
	var frmDt = document.getElementById("txtFromDate").value;
	if(frmDt != "")
	 {
		var toDt = document.getElementById("txtToDate").value;
		if (!cmpDate(frmDt,toDt,0))
			{
			alert("To Date must be greater than From Date");
			document.getElementById("txtToDate").value="";
			return false;
		    }
	}
}

function chk_YearMonth(input)
{      
    var  yearM = document.getElementById(input).value;          
    var month =  yearM.substring(4,6);    
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementById(input).focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById(input).focus();                     
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

