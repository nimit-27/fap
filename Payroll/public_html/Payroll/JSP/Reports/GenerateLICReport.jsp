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

<BODY  onkeydown="hotKeys(event);"; scroll=no  onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="LICReportBaseAction" name="LICReportForm" type="FCIPAY.Payroll.WEBTIER.Form.GenerateLICReportForm" scope="session" >
<bean:define id="ParentForm" name="LICReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>LIC REPORT</TD>
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
          <TD class=subHeader colspan=6>LIC Information of Employee</TD>
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
              
              <TR height=60>
         
		<!-- Detail table Container starts -->
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.CanteenSubsidy.YYMM" /></td><td colspan=2><html:text  property="txtYYMM"  maxlength="10" size="23" styleClass="required" readonly="false" onchange="chk_YearMonth(); " /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" >
              </td>
      
              </tr>
              
              </table>


              <table border=0 cellpadding=0>
               <TD colspan=10>
             <!-- <TR height=40>
              

             
              <td  colspan="2" class="labelText"  width="45%" align="center"  ><bean:message key="Payroll.CanteenSubsidy.Emp" />&nbsp;&nbsp;<html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional" readonly="true" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtEmpNo" onclick="ShowLovEmpNo();">&nbsp;&nbsp;<html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
              
              </tr>-->

              <TR height=40>
              <td width=25% >
               <td width="6%" align="right" value="checked" class="radioText" ><input type="radio" name="optSelect"   onclick="doSetFlag('A');" /><bean:message key="Payroll.PaySlip.All"  />
              <td width="12%" align="right" class="radioText" ><html:radio  property="optSelect" value="B" onclick="doSetFlag('B');" /><bean:message key="Payroll.LICReport.Emp"  />  
              <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtEmpNo" onclick="ShowLovEmpNo();">&nbsp;&nbsp;<html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" /></td>
              </td>
              </tr>

                <tr height="15" >
            
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
               <td  bgcolor=#4682b4><html:button value=' GENERATE LIC REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
               <td width="37%" bgColor=#4682b4></td>
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
  if(LICReportForm.txtAllEmpFlag.value=='B')
    {
      var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
      window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateLICReport","GenerateLICReportkey").trim()%>&emp_number="+LICReportForm.txtEmp.value+"&yearmonth="+LICReportForm.txtYYMM.value,'',win_option);
    }
  if(LICReportForm.txtAllEmpFlag.value=='A')
    {
      var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
      window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateLICReport","GenerateLICReportForAllkey").trim()%>&yearmonth="+LICReportForm.txtYYMM.value,'',win_option);
    }
}
</script>

	 


</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="LICReportForm"  property="screenName" value="GenerateLICReport" />
  
<html:hidden property="screenMode" name="LICReportForm" value="U" />
<html:hidden property="positionRequested" name="LICReportForm" />
<html:hidden property="userPageRequested" name="LICReportForm" />
<html:hidden property="userPositionRequested" name="LICReportForm" />
<html:hidden property="pageRequested" name="LICReportForm" />
<html:hidden property="headerDataChanged" name="LICReportForm" />
<html:hidden property="detailDataChanged" name="LICReportForm" />
<html:hidden property="lovKey" name="LICReportForm"  />
<html:hidden property="txtSearchFields" name="LICReportForm"  />
<html:hidden property="txtDisplayFields" name="LICReportForm"  />
<html:hidden property="txtIndex" name="LICReportForm"  />
<html:hidden property="headerPrimaryKey" name="LICReportForm"  />
<html:hidden property="txtAllEmpFlag" name="LICReportForm"  />


</html:form>
</body>
</html:html>



<script language="javascript">

function doSetFlag(val)
{ 
  LICReportForm.txtAllEmpFlag.value=val;   
     
  if(val=='B')
  {
    document.all.txtEmp.style.background = "#ffffd3";
    document.all.butTxtEmpNo.disabled="";
    document.all.butTxtEmpNo.className="required";
  }
  else
  {
    document.all.txtEmp.value="";
    document.all.txtEmpName.value="";
    document.all.txtEmp.style.background = "#e0e0e0";   
    document.all.butTxtEmpNo.disabled="";    
//    document.all.butTxtEmpNo.disabled="true";
    document.all.txtEmp.className="optional";
  }
     
}


function ShowLovYYMM()
{
        LICReportForm.lovKey.value = "ReportGenerateLICYYMM" + LICReportForm.screenName.value + "U";
        LICReportForm.txtSearchFields.value = "Payroll.CanteenSubsidy.YYMM";
        LICReportForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LICReportForm');
        return true;
}

function ShowLovEmpNo()
{
        LICReportForm.lovKey.value = "ReportGenerateLICEmpNo" + LICReportForm.screenName.value + "U";
        LICReportForm.txtSearchFields.value = "Payroll.LICReport.Emp";
        LICReportForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LICReportForm');
        return true;
}
</script>