<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<%@ page import="java.lang.String" %>
<%@ page import="FCIPAY.Payroll.common.utility.EnrgiseUtil" %>

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
  <html:form  action="ReportLinkerAction" name="NWNPLabourOTACompRepForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.NWNPLabourOTACompRepForm" scope="session" >
  <bean:define id="ParentForm" name="NWNPLabourOTACompRepForm" toScope="request" />  
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
        
      <TD  colSpan=11 class=mainHeader height=10>ACTUAL WORK DONE COMPUTATION DETAIL REPORT(Anchillary labour) </td>
   
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
                   
                <TD  class=subHeader colspan=6>Actual Work Done Report (Anchillary labour) </td>
              
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
                <TABLE cellspacing="0" cellPadding="0" border="0" >
                  <center>   
						<tr height=25>
		                    <TD class=labelText width="35%" ><bean:message key="Payroll.PaySlip.EmpNumber" /></td>
							<td align="left" width="13%"><html:text  property="txtEmp" maxlength="10" size="16" styleClass="required" readonly="true" />
								<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovEmpNo();" >
							</td>
							<td width="20%" >
								<html:text property="txtEmpName"  size="50" value="" styleClass="locked" readonly="true" />
							</td>
							<td></td>
						</tr>

						  <TR height=25>         
							<!-- Detail table Container starts -->
							<td class="labelText" align="center">WorkSlip From Date</td>
							<td>
								<html:text  property="txtWrkSlipDt"  maxlength="6" size="16" styleClass="required" readonly="true" />
								<img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" onclick="showCalendar('txtWrkSlipDt',this)" />
							</td>              
							<td class="labelText" align="center">WorkSlip To Date</td><td >
								<html:text  property="txtWrkSlipDtTo"  maxlength="6" size="16" styleClass="required" readonly="true" />
								<img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" onclick="showCalendar('txtWrkSlipDtTo',this)" />
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
              <td bgcolor=#4682b4><html:button value='GENERATE REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
    if(mandatory_Check('NWNPLabourOTACompRepForm'))
    {
    /*
    
      if(NWNPLabourOTACompRepForm.hdnEmpLbrFlag.value =='L')
        var winurl="LABOUR_INCENTIVE_DEPT_DETAIL.rdf&P_EMP_NUM="+NWNPLabourOTACompRepForm.txtEmp.value+"&P_WORK_DATE_FROM="+NWNPLabourOTACompRepForm.txtWrkSlipDt.value+"&P_WORK_DATE_TO="+NWNPLabourOTACompRepForm.txtWrkSlipDtTo.value+"&P_LOCATION="+NWNPLabourOTACompRepForm.loginLocCode.value;
      
      else if(NWNPLabourOTACompRepForm.hdnEmpLbrFlag.value =='N')
      
      var winurl="LABOUR_INCENTIVE_NWNP_DETAIL.rdf&P_EMP_NUM="+NWNPLabourOTACompRepForm.txtEmp.value+"&P_WORK_DATE_FROM="+NWNPLabourOTACompRepForm.txtWrkSlipDt.value+"&P_WORK_DATE_TO="+NWNPLabourOTACompRepForm.txtWrkSlipDtTo.value+"&P_LOCATION="+NWNPLabourOTACompRepForm.loginLocCode.value;
      
      
      else
      */
        var winurl="LABOUR_ANCHILLARY_OTA_DETAIL.rdf&P_EMP_NUM="+NWNPLabourOTACompRepForm.txtEmp.value+"&P_WORK_DATE_FROM="+NWNPLabourOTACompRepForm.txtWrkSlipDt.value+"&P_WORK_DATE_TO="+NWNPLabourOTACompRepForm.txtWrkSlipDtTo.value+"&P_LOCATION="+NWNPLabourOTACompRepForm.loginLocCode.value;

		document.getElementById('butInsert').value="Please wait. File is being downloaded..";
		document.getElementById('butInsert').disabled="true";
		document.getElementById('submitParam').value = winurl;
		document.NWNPLabourOTACompRepForm.submit();    
	}
    else{
      return false;
    }
}
</script>
	 
</TBODY>
</TABLE>

    <!-- Container Table Ends -->
    <html:hidden name="NWNPLabourOTACompRepForm"  property="screenMode"/>
    <html:hidden name="NWNPLabourOTACompRepForm"  property="screenName" value="NWNPLbrOTACompReport"/>
    <html:hidden property="buttonFlag" name="NWNPLabourOTACompRepForm"  />   
    <html:hidden property="lovKey" name="NWNPLabourOTACompRepForm"  />
    <html:hidden property="txtFields" name="NWNPLabourOTACompRepForm"  />   
    <html:hidden property="txtSearchFields" name="NWNPLabourOTACompRepForm"  />
    <html:hidden property="txtDisplayFields" name="NWNPLabourOTACompRepForm"  />
    <html:hidden property="txtIndex" name="NWNPLabourOTACompRepForm"  />  
	<html:hidden property="txtCpfCode" name="NWNPLabourOTACompRepForm"  />
    <html:hidden property="loginLocCode" name="NWNPLabourOTACompRepForm"  />
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
    NWNPLabourOTACompRepForm.action="../../../NWNPLabourOTACompGetAccess.do"
    NWNPLabourOTACompRepForm.submit();  
  }
}

function ShowLovEmpNo()
{
    NWNPLabourOTACompRepForm.lovKey.value = "LabourIncentiveEmp" + NWNPLabourOTACompRepForm.screenName.value + "U";
    NWNPLabourOTACompRepForm.queryParam.value="txtSiteID="+ NWNPLabourOTACompRepForm.loginLocCode.value +",hdnEmpLbrFlag="+NWNPLabourOTACompRepForm.hdnEmpLbrFlag.value ; 
    NWNPLabourOTACompRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
    NWNPLabourOTACompRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','NWNPLabourOTACompRepForm');
    return true;
}

</script>
