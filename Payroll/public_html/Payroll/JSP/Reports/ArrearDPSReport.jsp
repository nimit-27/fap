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

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="ReportLinkerAction" name="ArrearReportForm" type="FCIPAY.Payroll.WEBTIER.Form.ArrearReportForm" scope="session" >
<bean:define id="ParentForm" name="ArrearReportForm" toScope="request" />

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
<%
if(lbrType.equals("L")){
%>
  <TD  colSpan=12 class=mainHeader height=10>ARREAR REPORT (DEPARTMENTAL LABOURS)</TD>
  <%}else{%>
  <TD  colSpan=12 class=mainHeader height=10>ARREAR REPORT (DPS LABOURS)</TD>
  <%}%>
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
          <TD class=subHeader colspan=6> Arrear Report</TD>
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
            <TD colspan=5>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
          
             
              <table border=0 cellpadding=0>
              <center>
              <TR height=30>
         
		<!-- Detail table Container starts -->
             <td class="labelText"  width="25%" align="right">Start Month</td>
              <td>
              <input type="text" name="txtFromYYMM" maxlength="6" size="23" value="" onblur="                                                  
                       if(!(chk_YearMonth('txtFromYYMM')))
                          {
                          }                                            
              " class="required">(YYYYMM)
              </td>

              <td class="labelText"  width="10%" align="left" >End Month</td><td>
              <input type="text" name="txtToYYMM" maxlength="6" size="23" value="" onblur="                                                  
                       if(!(chk1_YearMonth('txtToYYMM')))
                          {
                          }                                            
              " class="required">(YYYYMM)
              </td>

      
              </tr>
			  <tr height=30>

						<td class="labelText">Location/Depot Name</td>
						<td><html:text  property="txtLocId" maxlength="10" styleClass="optional" readonly="true" />            
							<logic:equal name="ArrearReportForm" property="screenMode" value="U" >            
							<IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" >
							</logic:equal>            
							<logic:notEqual name="ArrearReportForm" property="screenMode" value="U" >
							<IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" onclick="return ShowSite();" >
							</logic:notEqual>            
							<html:text  property="txtLoc" maxlength="10" styleClass="locked" readonly="true" />
						</td>
			</tr>
			<tr height=30>
						<td class="labelText">Gang No</td>
						
						
			<td><html:text  property="txtGangId" maxlength="15" styleClass="optional" readonly="true" />            
							<logic:equal name="ArrearReportForm" property="screenMode" value="U" >            
							<IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" >
							</logic:equal>            
							<logic:notEqual name="ArrearReportForm" property="screenMode" value="U" >
							 <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
							</logic:notEqual>         
						</td>
			  </tr>
			  <html:hidden property="headerPrimaryKey" />
              </center>
              </table>


              <table border=0 cellpadding=0>
			  <center>
              <TR height=30>
                <td>
                <TD class=labelText width="24%" align='centre'>                
                <bean:message key="Payroll.PaySlip.EmpNumber"  />  
                <td align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  readonly="true" />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovEmpNo();" >
                <html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" /></td>
                </td>
                </tr>           
           
                <tr height="15" >
            <td colspan="4"></td>
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
               <td  bgcolor=#4682b4><html:button value=' GENERATE REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
	if(mandatory_Check('ArrearReportForm'))
	{
		var lbr_flag = ArrearReportForm.hdnEmpLbrFlag.value;
		if (lbr_flag == 'D')
		{
			var winurl="DpsArrearReport.rdf&P_EMP_NUM="+ArrearReportForm.txtEmp.value+"&P_FROM_YYMM="+ArrearReportForm.txtToYYMM.value+"&P_TO_YYMM="+ArrearReportForm.txtFromYYMM.value+"&P_LOCATION="+ArrearReportForm.loginLocCode.value+"&P_GANG_ID="+ArrearReportForm.txtGangId.value+"&P_EMP_FLG=D&P_DEPOT="+ArrearReportForm.txtLocId.value;
		}
		if (lbr_flag == 'L')
		{
			var winurl="dept_arrear_report.rdf&V_emp_num="+ArrearReportForm.txtEmp.value+"&Start_Yymm="+ArrearReportForm.txtFromYYMM.value+"&End_Yymm="+ArrearReportForm.txtToYYMM.value+"&Vloc_Id="+ArrearReportForm.loginLocCode.value+"&Vgang_Id="+ArrearReportForm.txtGangId.value+"&EMP_TYPE="+ArrearReportForm.hdnEmpLbrFlag.value+"&VDEPOT_Id="+ArrearReportForm.txtLocId.value;
		}
		document.getElementById('butInsert').value="Please wait. File is being downloaded..";
		document.getElementById('butInsert').disabled="true";
		document.getElementById('submitParam').value = winurl;
		document.ArrearReportForm.submit();
	}
	else
	{
		return false;
	}
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="ArrearReportForm"  property="screenMode"/>
    <html:hidden name="ArrearReportForm"  property="screenName" value="ArrearDPSReport" />
    <html:hidden property="buttonFlag" name="ArrearReportForm"  />
    <html:hidden property="txtAllEmpFlag" name="ArrearReportForm"  />  
    <html:hidden property="txtEmpName" name="ArrearReportForm"  />          
	<html:hidden property="txtCpfCode" name="ArrearReportForm"  />
    <html:hidden property="hdnMaxYYMM" name="ArrearReportForm"  />    
    <html:hidden property="lovKey" name="ArrearReportForm"  />
    <html:hidden property="txtFields" name="ArrearReportForm"  />   
    <html:hidden property="txtSearchFields" name="ArrearReportForm"  />
    <html:hidden property="txtDisplayFields" name="ArrearReportForm"  />
    <html:hidden property="txtIndex" name="ArrearReportForm"  />
	<html:hidden property="txtSiteID" name="ArrearReportForm"  />
    <html:hidden property="txtInputField" name="ArrearReportForm"  />
    <html:hidden property="hdnLoginUserId" name="ArrearReportForm"  />    
    <html:hidden property="hdnPayUser" name="ArrearReportForm"  />        
    <html:hidden property="hdnLoginUserName" name="ArrearReportForm"  />
    <html:hidden property="loginLocCode" name="ArrearReportForm"  />
    <html:hidden property="txtType" name="ArrearReportForm" />
    <html:hidden property="txtMou" name="ArrearReportForm" />
 
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
    ArrearReportForm.action="../../../ArrearReportDPSGetAccess.do";
    ArrearReportForm.submit();  
  }
}

function ShowSite()
{
   ArrearReportForm.lovKey.value = "GangDepot" + ArrearReportForm.screenName.value + "Q";
   ArrearReportForm.queryParam.value="txtSiteID="+ArrearReportForm.loginLocCode.value;
   ArrearReportForm.txtDisplayFields.value = "txtLocId,txtLoc";
   ArrearReportForm.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   ArrearReportForm.txtIndex.value=""; 
   ArrearReportForm.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'ArrearReportForm');
   return true;
}

function ShowLovGang1()
{
   document.all.txtType.value="DPS";
   ArrearReportForm.queryParam.value="txtSiteID="+ArrearReportForm.loginLocCode.value+",txtLbrTyp="+ArrearReportForm.txtType.value;    
   ArrearReportForm.lovKey.value = "GangName" + ArrearReportForm.screenName.value + "Q";
   ArrearReportForm.txtDisplayFields.value = "txtGangId,txtType,txtMou";
   ArrearReportForm.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName,Payroll.Labour.Loc";
   ArrearReportForm.txtIndex.value="";
  // ArrearReportForm.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'ArrearReportForm');
   return true;  
} 

function ShowLovGang()
{

document.all.txtType.value="DPS";
   ArrearReportForm.queryParam.value="txtLocId= "+ ArrearReportForm.txtLocId.value +",txtSiteID="+ArrearReportForm.loginLocCode.value+",txtType="+ArrearReportForm.txtType.value;    
   ArrearReportForm.lovKey.value = "GangName" + ArrearReportForm.screenName.value + "Q";
   ArrearReportForm.txtDisplayFields.value = "txtGangId";
   ArrearReportForm.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
   ArrearReportForm.txtIndex.value="";
   ArrearReportForm.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'ArrearReportForm');
   return true;
}  
 

function ShowLovEmpNo()
{
		var gng= ArrearReportForm.txtLocId.value;
		var dpt=ArrearReportForm.headerPrimaryKey.value;
		
		if (gng == '')
			gng=0;
		if (dpt == '')
			dpt=0;

        ArrearReportForm.lovKey.value = "ReportGeneratePaySlipEmp" + ArrearReportForm.screenName.value + "U";
        ArrearReportForm.queryParam.value="txtSiteID="+ ArrearReportForm.loginLocCode.value +",hdnEmpLbrFlag="+ArrearReportForm.hdnEmpLbrFlag.value +",txtLocId="+dpt+",headerPrimaryKey="+gng;
        ArrearReportForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
        ArrearReportForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','ArrearReportForm');
        return true;
}


function chk_YearMonth(input)
{
       var  yearM = document.getElementById(input).value;          
    if(yearM!=""){
       var month =  parseInt(yearM.substring(4,6),10);
      
      
    if (num_Check(yearM,1))
     {                                   
           
        if (yearM.length != 6)
        {
        alert("Year Month should be a Six digit Number");
                document.getElementById(input).select();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

       if(month < 1 || month > 12)
       {
       alert("Month should be Within 1 to 12");
            document.getElementById(input).select();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                    
          return false;
       }
        return true;
     }
     else
     {
            document.getElementById(input).select();
    return false;
     }
    }
}

function chk1_YearMonth(input)
{

	var  yearM = document.getElementById(input).value;          
	if(ArrearReportForm.txtFromYYMM.value!='') 
	{
	if(yearM!="")
	{
    var month =  parseInt(yearM.substring(4,6),10);	
			if (num_Check(yearM,1))
			 {                                   
						if (yearM.length != 6)
						{
							alert("Year Month should be a Six digit Number");
							document.getElementById(input).select();                     
							event.srcElement.select();
							event.srcElement.focus();
							event.returnValue=false;            
							return false;
					
						}

						if(month < 1 || month > 12)
					   {
							alert("Month should be Within 1 to 12");
							document.getElementById(input).select();                     
							event.srcElement.select();
							event.srcElement.focus();
							event.returnValue=false;                    
						    return false;
					   }
					  if(ArrearReportForm.txtToYYMM.value<ArrearReportForm.txtFromYYMM.value)
					  {
							alert('Start Month should be less equals to End month');
							ArrearReportForm.txtToYYMM.value='';
							ArrearReportForm.txtFromYYMM.value='';
							ArrearReportForm.txtFromYYMM.focus();
							return false;
					  }
							return true;
			 }
			 else
					 {
							document.getElementById(input).select();
							return false;
					 }
		}
		}
		else
		{
		alert("Fill 'Start Year' text field 1st.");
		ArrearReportForm.txtFromYYMM.focus();
		document.getElementById(input).value='';
		return false;
		}
}


</script>
