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

<html:form  action="ReportLinkerAction" name="InvoiceReportForm" type="FCIPAY.Payroll.WEBTIER.Form.InvReportForm" scope="session" >
<bean:define id="ParentForm" name="InvoiceReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>INVOICE REPORT</TD>
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
          <TD class=subHeader colspan=6> Invoice Report</TD>
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
           <TABLE cellspacing="0" cellPadding="0" >
          
             
              <table border=0 cellpadding=0>
              <center>
              <TR height=30>
         
		<!-- Detail table Container starts -->
              <td class="labelText"  width="45%" align="center">Invoice No.</td><td colspan=2>
              <html:text  property="txtInvNum"  maxlength="12" size="23" styleClass="optional"  
                
              />
              </td>
      

</tr>
<tr height=30  >

<td align="center" colspan=50>
From Date
<html:text property="txtStartDate" size="9" styleClass="optional" readonly="true" disabled="true"    />
<img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate"  onclick="showCalendar('txtStartDate',this)"  />

To Date
<html:text property="txtEndDate"  size="9"   styleClass="optional" disabled="true" readonly="true" onchange="chkToDt()"  />
<img src="..\INCLUDES\IMAGES\cal.gif" name="imgtxtEndDate"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate"  onclick="showCalendar('txtEndDate',this)" />
</td>






              </tr>
              </center>
              </table>


              <table border=0 cellpadding=0>
              <TR height=30>
                <td width=25% >
                <TD class=labelText width="20%" >                
                <bean:message key="Payroll.PaySlip.EmpNumber"  />  
                <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  
				onchange=
					"if(!(checkEmployee(InvoiceReportForm.txtEmp.value,InvoiceReportForm.loginLocCode.value)))
					{
						InvoiceReportForm.txtEmp.value='';
					}"
				/>
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovEmpNo();" >
                <html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" /></td>
                </td>
                </tr>           
           
               
              </table>
			  <table border=0 cellpadding=0>
            <TR>
         
		     <td class="labelText"  width="45%" align="center"><bean:message key="pr.PayCode.code" /></td>
                                    <td ><html:text property="txtPayCode"     styleClass="optional"  readonly="true"/>
                                                                          
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center"  property="buttxtPayCode"   onclick="ShowLovPayCode();" >
                                                                                                       
                                                                           
                                      <html:text property="txtDescription"  styleClass="locked" readonly="true"    /></td>

              </tr>
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
               <td  bgcolor=#4682b4><html:button value=' GENERATE INVOICE REPORT'  onclick="return doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
               <td width="45%" bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	


                   
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
if(mandatory_Check('InvoiceReportForm'))
{
	var lbr_flag = InvoiceReportForm.hdnEmpLbrFlag.value;
    var winurl="INVOICE_REPORT.rdf&P_EMP_NUM="+InvoiceReportForm.txtEmp.value+"&P_FROM_DATE="+InvoiceReportForm.txtStartDate.value+"&P_TO_DATE="+InvoiceReportForm.txtEndDate.value+"&P_EMP_FLG="+InvoiceReportForm.hdnEmpLbrFlag.value+"&P_INV_NUM="+InvoiceReportForm.txtInvNum.value+"&P_LOC_ID="+InvoiceReportForm.loginLocCode.value+"&P_PAY_CODE="+InvoiceReportForm.txtPayCode.value;
    document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.InvoiceReportForm.submit();
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="InvoiceReportForm"  property="screenMode"/>
    <html:hidden name="InvoiceReportForm"  property="screenName" value="InvoiceReport" />
    <html:hidden property="buttonFlag" name="InvoiceReportForm"  />
     
    <html:hidden property="txtCpfCode" name="InvoiceReportForm"  />
    <html:hidden property="lovKey" name="InvoiceReportForm"  />
    <html:hidden property="txtFields" name="InvoiceReportForm"  />   
    <html:hidden property="txtSearchFields" name="InvoiceReportForm"  />
    <html:hidden property="txtDisplayFields" name="InvoiceReportForm"  />
    <html:hidden property="txtIndex" name="InvoiceReportForm"  />

    <html:hidden property="loginLocCode" name="InvoiceReportForm"  />

	<html:hidden property="hdnLoginUserId" name="InvoiceReportForm"  />    
    <html:hidden property="hdnPayUser" name="InvoiceReportForm"  />        
    <html:hidden property="hdnLoginUserName" name="InvoiceReportForm"  />
	<html:hidden property="txtAllEmpFlag" name="InvoiceReportForm"  /> 
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
    InvoiceReportForm.action="../../../InvoiceReportGetAccess.do"
    InvoiceReportForm.submit();  
  }
}

function ShowLovEmpNo()
{
        InvoiceReportForm.lovKey.value = "ReportGeneratePaySlipEmp" + InvoiceReportForm.screenName.value + "U";
        InvoiceReportForm.queryParam.value="txtSiteID="+ InvoiceReportForm.loginLocCode.value +",hdnEmpLbrFlag="+InvoiceReportForm.hdnEmpLbrFlag.value ; 
        InvoiceReportForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
        InvoiceReportForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','InvoiceReportForm');
        return true;
}

function ShowLovPayCode()
{
   
   InvoiceReportForm.lovKey.value = "MaintDirectPayrollPayCode" + InvoiceReportForm.screenName.value + InvoiceReportForm.screenMode.value;
   InvoiceReportForm.txtDisplayFields.value = "txtPayCode,txtDescription";
   InvoiceReportForm.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'InvoiceReportForm');
   return true;
}






function chkToDt()
{
  var fromDt=document.getElementById("txtEndDate").value;
  if(!cmpSysDate(fromDt,0))
	{
	  document.getElementById("txtEndDate").value="";
	  return false;
	}

	comprDate();
}

function comprDate(){
	var frmDt = document.getElementById("txtStartDate").value;
	if(frmDt != ""){
		var toDt = document.getElementById("txtEndDate").value;
		if (!cmpDate(frmDt,toDt,0)){
			alert("End Date must be greater than Start Date.");
			document.getElementById("txtEndDate").value="";
			return false;
		}
	}else{
		alert("Enter Start Date First");
		document.getElementById("txtEndDate").value="";
		document.getElementById("txtStartDate").focus();
		return false;
	}
}



</script>
