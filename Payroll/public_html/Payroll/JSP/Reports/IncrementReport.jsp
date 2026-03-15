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

<html:form  action="ReportLinkerAction" name="IncrReportForm" type="FCIPAY.Payroll.WEBTIER.Form.IncrReportForm" 

scope="session" >
<bean:define id="ParentForm" name="IncrReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>INCREMENT REPORT</TD>
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
          <TD class=subHeader colspan=6> Increment Report</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
           
   	 </table>

 <table cellspacing=0 cellpadding=0 border=0 >
         <!-- Detail Information Row starts -->

 	 <TR height="100">
	 
            <TD colspan=11 >

            <!-- Account Config Detail Table Starts -->
			 <TABLE cellspacing="0" cellPadding="0">
             
              
              <table border=0 cellpadding=0>
			  <center>
              
            <logic:notEqual name="IncrReportForm" property="hdnEmpLbrFlag" value='E' > 
		 
          <tr height=30>
					
					<td class="labelText"  align="center" width="45%">Location/Depot Name</td>
					<td colspan=2><html:text property="txtLocId" styleClass="optional"  

readonly="true"/>
					<logic:equal name="IncrReportForm" property="screenMode" value="U" >            
							<IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" 

name="buttxtSite" >
							</logic:equal>            
							<logic:notEqual name="IncrReportForm" property="screenMode" 

value="U" >
							<IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" 

name="buttxtSite" onclick="return ShowSite();" >
							</logic:notEqual>            
							<html:text  property="txtLocation" maxlength="10" 

styleClass="locked" readonly="true" />
						
					</td>
                 
                </tr>    
       </logic:notEqual>
	   
	   



 
<tr height=30  >

<td class="labelText" align="center" width="45%">
From Date</td>
<td colspan=2>
<html:text property="txtStartDate" size="9" styleClass="required" readonly="true" disabled="true"    />
<img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate"  

onclick="showCalendar('txtStartDate',this)"  />

</td>

  </tr>
  <tr height=30  >

<td class="labelText" align="center" width="45%">


To Date
</td>
<td colspan=2>
<html:text property="txtEndDate"  size="9"   styleClass="required" disabled="true" readonly="true" onchange="comprDate()"  />
<img src="..\INCLUDES\IMAGES\cal.gif" name="imgtxtEndDate"  width=15 height=19 align="top" styleClass="lov" 

property="buttxtEffDate"  onclick="showCalendar('txtEndDate',this)" />
</td>

  </tr>
	</center>		  
</table>

<table border=0 cellpadding=0>  
                      
           <TR height=30>
                <td width=25% >
                <TD class=labelText width="20%" >
				<bean:message key="Payroll.PaySlip.EmpNumber"  />     

        
                 
                <td  align="left"><html:text  property="txtEmp"  styleClass="optional"  readonly="true" />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
               onclick="return ShowLovEmpNo();" />
                <html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" />
				</td>
                </td>   
				
           </tr>  
<tr height=12><td width="15%" ></td></tr>		   
               
    </table>          
	
</td>

</tr>

<!-- Tab table Row 3 starts -->

  <TR>
     <TD colspan="16" align=right bgColor=#4682b4 ><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
    </TR>
         <tr height="15" >
            <td colspan="16"></td>
         </tr>

      <TR>
               <td align=center bgcolor=#4682b4 width="47%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE INCREMENT REPORT'  onclick="return doGetReport()" 

property="butInsert" styleClass="bottomBarText" /></td>
               <td width="45%" bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	


                   
              
          
        

</TABLE>
 </TD>
 </TR>  </TBODY>   </TABLE  >

  
   
                <!-- Tab Table Ends -->

 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript">
function doGetReport()
{  
if(mandatory_Check('IncrReportForm'))
{
	var lbr_flag = IncrReportForm.hdnEmpLbrFlag.value;
	var winurl="IncrementDetailReport.rdf&p_emp_num="+IncrReportForm.txtEmp.value+"&p_start_date="+IncrReportForm.txtStartDate.value+"&p_end_date="+IncrReportForm.txtEndDate.value+"&p_emp_type="+IncrReportForm.hdnEmpLbrFlag.value+"&p_site="+IncrReportForm.loginLocCode.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.IncrReportForm.submit();
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

    <html:hidden name="IncrReportForm"  property="screenMode"/>
    <html:hidden name="IncrReportForm"  property="screenName" value="IncrementDetailReport" />
    <html:hidden property="buttonFlag" name="IncrReportForm"  />
	<html:hidden property="txtCpfCode" name="IncrReportForm"  />
    <html:hidden property="lovKey" name="IncrReportForm"  />
    <html:hidden property="txtFields" name="IncrReportForm"  />   
    <html:hidden property="txtSearchFields" name="IncrReportForm"  />
    <html:hidden property="txtDisplayFields" name="IncrReportForm"  />
    <html:hidden property="txtIndex" name="IncrReportForm"  />
    <html:hidden property="loginLocCode" name="IncrReportForm"  />
	<html:hidden property="hdnLoginUserId" name="IncrReportForm"  />    
    <html:hidden property="hdnPayUser" name="IncrReportForm"  />        
    <html:hidden property="hdnLoginUserName" name="IncrReportForm"  />
	<html:hidden property="txtAllEmpFlag" name="IncrReportForm"  /> 
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
    IncrReportForm.action="../../../IncrReportGetAccess.do"
    IncrReportForm.submit();  
  }
}

function ShowLovEmpNo()
{
        IncrReportForm.lovKey.value = "ReportGeneratePaySlipEmp" + IncrReportForm.screenName.value + "U";
        IncrReportForm.queryParam.value="txtSiteID="+ IncrReportForm.loginLocCode.value 

+",hdnEmpLbrFlag="+IncrReportForm.hdnEmpLbrFlag.value ; 
        IncrReportForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
        IncrReportForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','IncrReportForm');
        return true;
}

function ShowSite()
{
  
   IncrReportForm.lovKey.value = "GangDepot" + IncrReportForm.screenName.value + IncrReportForm.screenMode.value;
  
   IncrReportForm.queryParam.value="txtSiteID="+IncrReportForm.loginLocCode.value;
   
   IncrReportForm.txtDisplayFields.value = "txtLocId,txtLocation";
    
   IncrReportForm.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   
   IncrReportForm.txtIndex.value=""; 

 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'IncrReportForm');
  
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
