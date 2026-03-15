<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<%@ page import="java.lang.String" %>
<%
    String lbrType = (String)session.getAttribute("hdnEmpLbrFlag"); 
%>
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

<html:form action="ReportLinkerAction" name="EarnDeductReportForm" type="FCIPAY.Payroll.WEBTIER.Form.EarnDeductReportForm" scope="session" >
<bean:define id="ParentForm" name="EarnDeductReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>EARNING DEDUCTION REPORT</TD>
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
          <TD class=subHeader colspan=6> Pay Slip Report</TD>
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
             <tr>
                <td class="labelText">Location/Depot Name</td>
                <td><html:text  property="txtLocId" maxlength="10" styleClass="optional" readonly="true" />            
                        <logic:equal name="EarnDeductReportForm" property="screenMode" value="U" >            
                        <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" >
                        </logic:equal>            
                        <logic:notEqual name="EarnDeductReportForm" property="screenMode" value="U" >
                        <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" onclick="return ShowSite();" >
                        </logic:notEqual>            
                        <html:text  property="txtLoc" maxlength="10" styleClass="locked" readonly="true" />
                </td>
                
                <%if(!lbrType.equals("N")){%>
                <td class="labelText">Gang Name</td>
                <td>
                        <logic:equal name="EarnDeductReportForm" property="screenMode" value="Q" >
                                <html:text  property="txtGangName" maxlength="50" styleClass="optional" readonly="true" />
                                <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
                        </logic:equal>
                        <logic:equal name="EarnDeductReportForm" property="screenMode" value="N" >
                                <html:text  property="txtGangName" maxlength="10" styleClass="required" />            
                        </logic:equal>
                        <logic:equal name="EarnDeductReportForm" property="screenMode" value="U" >
                                <html:text  property="txtGangName" maxlength="10" styleClass="required" readonly="true" />            
                        </logic:equal>
                </td>
                <%}%>
            </tr>
               <html:hidden property="headerPrimaryKey" />
             <tr>
                <td class="labelText">Year Month</td>
                <td align="left"><html:text  property="txtYYMM" maxlength="10" size="20" styleClass="required" /> (YYYYMM)
                </td>

            <td class="labelText">Report Type</td>
            <%if(!lbrType.equals("N")){%>
                <td colspan=2><html:select property="txtRptType" name= "EarnDeductReportForm" styleClass="required">
                  <html:option value="LSED" >LABOUR SALARY EARNING DETAIL</html:option>                                    
                  <html:option value="LSES" >LABOUR SALARY EARNING SUMMERY</html:option>
                  <html:option value="LSDD" >LABOUR SALARY DEDUCTION DETAIL</html:option>                                    
                  <html:option value="LSDS" >LABOUR SALARY DEDUCTION SUMMERY</html:option>
                  <html:option value="LIED" >ACTUAL WORK DONE/INCENTIVE EARNING DETAIL</html:option>
                  <html:option value="LIES" >ACTUAL WORK DONE/INCENTIVE EARNING SUMMERY </html:option>                                                               
                  <html:option value="LIDD" >ACTUAL WORK DONE/INCENTIVE DEDUCTION DETAIL</html:option>
                  <html:option value="LIDS" >ACTUAL WORK DONE/INCENTIVE DEDUCTION SUMMERY </html:option>                                                               
                  </html:select>
                </td>
            <%} else {%>
                <td colspan=2><html:select property="txtRptType" name= "EarnDeductReportForm" styleClass="required">
                  <html:option value="LSED" >LABOUR SALARY EARNING DETAIL</html:option>                                    
                  <html:option value="LSES" >LABOUR SALARY EARNING SUMMERY</html:option>
                  <html:option value="LSDD" >LABOUR SALARY DEDUCTION DETAIL</html:option>                                    
                  <html:option value="LSDS" >LABOUR SALARY DEDUCTION SUMMERY</html:option>
                  </html:select>
                </td>
            <%}%>
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
               <td  bgcolor=#4682b4><html:button value='GENERATE EARNING DEDUCTION REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
	var rpt_name="";
	
	if(mandatory_Check('EarnDeductReportForm'))
	{
		var rpt_type = document.getElementById("txtRptType").value;
		//alert(rpt_type);
		if(rpt_type == 'LSED') rpt_name="lbr_sal_earn_dtl.rdf";
		if(rpt_type == 'LSES') rpt_name="lbr_sal_earn_summ.rdf";
		if(rpt_type == 'LSDD') rpt_name="lbr_sal_ded_dtl.rdf";
		if(rpt_type == 'LSDS') rpt_name="lbr_sal_ded_summ.rdf";
		if(rpt_type == 'LIED') rpt_name="lbr_inc_earn_dtl.rdf";
		if(rpt_type == 'LIES') rpt_name="lbr_inc_earn_summ.rdf";
		if(rpt_type == 'LIDD') rpt_name="lbr_inc_ded_dtl.rdf";
		if(rpt_type == 'LIDS') rpt_name="lbr_inc_ded_summ.rdf";

		var winurl=""+rpt_name+"&P_GANG_ID="+EarnDeductReportForm.headerPrimaryKey.value+"&P_YYMM="+EarnDeductReportForm.txtYYMM.value+"&P_LOCATION="+EarnDeductReportForm.loginLocCode.value+"&P_EMP_FLG="+EarnDeductReportForm.hdnEmpLbrFlag.value;
		document.getElementById('butInsert').value="Please wait. File is being downloaded..";
		document.getElementById('butInsert').disabled="true";
		document.getElementById('submitParam').value = winurl;
		document.EarnDeductReportForm.submit();	 
	}
	 else{
		 return false;
	 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="EarnDeductReportForm"  property="screenMode"/>
    <html:hidden name="EarnDeductReportForm"  property="screenName" value="EarningDeductReport" />
    <html:hidden property="buttonFlag" name="EarnDeductReportForm"  />
    <html:hidden property="txtEmpName" name="EarnDeductReportForm"  />          
	<html:hidden property="txtCpfCode" name="EarnDeductReportForm"  />
    <html:hidden property="lovKey" name="EarnDeductReportForm"  />
    <html:hidden property="txtFields" name="EarnDeductReportForm"  />   
    <html:hidden property="txtSearchFields" name="EarnDeductReportForm"  />
    <html:hidden property="txtDisplayFields" name="EarnDeductReportForm"  />
    <html:hidden property="txtIndex" name="EarnDeductReportForm"  />
    <html:hidden property="loginLocCode" name="EarnDeductReportForm"  />
	<html:hidden property="txtInputField" name="EarnDeductReportForm"  />
    <html:hidden property="txtType" name="EarnDeductReportForm" />
    <html:hidden property="txtMou" name="EarnDeductReportForm" />
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
  if(document.all.hdnEmpLbrFlag.value=='L')
  {
    document.all.txtType.value="DEP";
  }
  else if(document.all.hdnEmpLbrFlag.value=='D')
  {
    document.all.txtType.value="DPS";
  }
  else
  {
    document.all.txtType.value="KOT";
  }

  if(mode != 'Q' )
  {
    EarnDeductReportForm.action="../../../EarnDeductRptAction.do"
    EarnDeductReportForm.submit();  
  }
}

function ShowSite()
{
   EarnDeductReportForm.lovKey.value = "GangDepot" + EarnDeductReportForm.screenName.value + EarnDeductReportForm.screenMode.value;
   EarnDeductReportForm.queryParam.value="txtSiteID="+EarnDeductReportForm.loginLocCode.value;
   EarnDeductReportForm.txtDisplayFields.value = "txtLocId,txtLoc";
   EarnDeductReportForm.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   EarnDeductReportForm.txtIndex.value=""; 
   EarnDeductReportForm.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'EarnDeductReportForm');
   return true;
}
function ShowLovGang()
{
   EarnDeductReportForm.queryParam.value="txtLocId= "+ EarnDeductReportForm.txtLocId.value +",txtSiteID="+EarnDeductReportForm.loginLocCode.value+",txtType="+EarnDeductReportForm.txtType.value;    
   EarnDeductReportForm.lovKey.value = "GangName" + EarnDeductReportForm.screenName.value + EarnDeductReportForm.screenMode.value;
   EarnDeductReportForm.txtDisplayFields.value = "headerPrimaryKey,txtGangName,txtLocId,txtLoc,txtType,txtMou";
   EarnDeductReportForm.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
   EarnDeductReportForm.txtIndex.value="";
   EarnDeductReportForm.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'EarnDeductReportForm');
   return true;
}    

function ShowLovEmpNo()
{
	EarnDeductReportForm.lovKey.value = "ReportGeneratePaySlipEmp" + EarnDeductReportForm.screenName.value + "U";
	EarnDeductReportForm.queryParam.value="txtSiteID="+ EarnDeductReportForm.loginLocCode.value +",hdnEmpLbrFlag=L" ; 
	EarnDeductReportForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
	EarnDeductReportForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','EarnDeductReportForm');
	return true;
}

function chk_YearMonth()
{
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  parseInt(yearM.substring(4,6),10);
      
    if (num_Check(yearM,1))
     {                                   
           
        if (yearM.length != 6)
        {
        alert("Year Month should be a Six digit Number");
//        document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

       if(month < 1 || month > 12)
       {
       alert("Month should be Within 1 to 12");
       document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                    
          return false;
       }
        return true;
     }
     else
     {
     //       event.srcElement.select();
      //      event.srcElement.focus();
     //       event.returnValue=false;     
    return false;
     }
}

</script>
