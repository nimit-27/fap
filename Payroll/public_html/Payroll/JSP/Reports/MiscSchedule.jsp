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

<html:form  action="ReportLinkerAction" name="MiscScheduleReportForm" type="FCIPAY.Payroll.WEBTIER.Form.MiscScheduleReportForm" scope="session" >
<bean:define id="ParentForm" name="MiscScheduleReportForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>MISCELLANEOUS SCHEDULE REPORT</TD>
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
          <TD class=subHeader colspan=6>Miscellaneous Schedule Report</TD>
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
			           <tr> <td width="100%" colspan=2 align="center">
                     
                       
                 <input type="radio" name="radioEmp" id="radioEmp" value="E" CHECKED onclick="miscReport()" ><b>Misc  Schedule Report </b>    
                                           
                       <input type="radio" name="radioEmp" id="radiobank" style ="margin-left:30" value="G" onclick="Bankreport()" ><b>Bank Loan / FCI Society Recovery </b>          
                        
                        
                      
                    </td> </tr>   
              <TR height=60>
         
		<!-- Detail table Container starts -->
		     <tr id="rowyymm">
              <td class="labelText"  width="45%" align="center">  <bean:message key="Payroll.PaySlip.Year" /></td><td colspan=2>
              <html:text  property="txtYYMM"  maxlength="6" size="23" styleClass="required"               
                onblur="                                                  
                       if(!(chk_YearMonth('txtYYMM')))
                          {
                          }                                            
              " 
              /><bean:message key="Payroll.MaintDARates.yymm" />
              </td>
			  </tr>
			   <tr id="reofrom" style="display:none" >
			   
              <td class="labelText"  width="45%" align="center" >  <bean:message key="Payroll.LPC.FrYYMM" /> </td><td colspan=2 align="left"> <html:text  property="txtFromYYMM" value="000000" onfocus="document.getElementById('txtToYYMM').value=''"  maxlength="6" size="23"  styleClass="required"  onblur="if(!(chk_YearMonth('txtFromYYMM'))){}" /><bean:message key="Payroll.MaintDARates.yymm" /></td>
			  </tr>
			  <tr id="reoto"  style="display:none">
			   
              <td class="labelText"  width="45%" align="center" >  <bean:message key="Payroll.LPC.ToYYMM" /> </td><td colspan=2 align="left"> <html:text  property="txtToYYMM"  value="000000" maxlength="6" size="23" styleClass="required"  onblur="if(!(chk_toYearMonth('txtToYYMM','txtFromYYMM'))){}" /><bean:message key="Payroll.MaintDARates.yymm" /></td>
			  </tr>
			  
  <!-- for Agency code   --> 
              <tr>
               <TD class=labelText id="suppliernomisc">  Supplier No. </TD>
               <td  align="left"> <html:text  property="txtAgency" name="MiscScheduleReportForm" maxlength="10" size="23" />
               <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovAgencyCode();" >
               <html:text property="txtAgencyName" size="30" value="" styleClass="locked" readonly="true" /></td>   
              </tr>
  <!-- for Agency code   --> 
  
  <!-- for Agency Site code   --> 
              <tr>
               <TD class=labelText id="suppliersitemisc" >  Supplier Site  </TD>
               <td  align="left"> <html:text  property="txtAgencySiteCode" name="MiscScheduleReportForm" maxlength="10" size="23" />
               <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovAgencySiteCode();" >
               <html:text property="txtAgencySite" size="30" value="" styleClass="locked" readonly="true" /></td>   
              </tr>
  <!-- for Agency Site code   --> 
  
  <!-- for Pay code   --> 
              <tr id="paycodemiscrow">
               <TD class=labelText >  Pay Code </TD>
               <td  align="left"> <html:text  property="txtPayCode1" name="MiscScheduleReportForm" maxlength="10" size="23" styleClass="required" />
               <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovPayCode();" >
               <html:text property="txtPayCodeName" size="30" value="" styleClass="locked" readonly="true" /></td>   
              </tr>
			  <tr id="paycodeloanrow" style="display:none">
               <TD class=labelText >  Pay Code </TD>
               <td  align="left"> <html:select  property="txtPayCode2"  name="MiscScheduleReportForm"   styleClass="required" onchange="if(this.value==''){alert('Please select a valid paycode');}" alt="txtPayType" style="width:21%; "  >                              
                             <html:option value="0"  >--Select Pay Code--</html:option>
							 <html:option value="396"  > 396-FCI Society Recoveries</html:option>
							<html:option value="397" > 397-Bank Loan Recoveries</html:option>                              
                              </html:select>
             
              </td>   
              </tr>
  <!-- for Pay code   --> 
        
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
               <td id ="miscbtnclm"  bgcolor=#4682b4><html:button value=' GENERATE MISCELLANEOUS SCHEDULE REPORT'  onclick="doGetReport('Misc Schedule Report')" property="butInsert" styleClass="bottomBarText" /></td>
<td id ="bankbtnclm" style ="display:none"  bgcolor=#4682b4><html:button value='BANK LOAN/ FCI SOC. REC. REPORT'  onclick="doGetReport('Loan recovery report')" property="butInsert1" styleClass="bottomBarText" /></td>
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
function doGetReport(obj)
{  
if(mandatory_Check('MiscScheduleReportForm'))
{
if(obj=='Misc Schedule Report')
{
    var winurl="miscschd.rdf&P_YYMM="+MiscScheduleReportForm.txtYYMM.value+"&P_LOCATION="+MiscScheduleReportForm.loginLocCode.value+"&P_LOC_TYPE="+MiscScheduleReportForm.locTyp.value+"&P_EMP_FLG="+MiscScheduleReportForm.hdnEmpLbrFlag.value+"&P_AGENCY_CODE="+MiscScheduleReportForm.txtAgency.value+"&P_AGENCY_S_CODE="+MiscScheduleReportForm.txtAgencySiteCode.value+"&P_PAY_CODE="+MiscScheduleReportForm.txtPayCode1.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.MiscScheduleReportForm.submit();
 }
 
 else if(obj=='Loan recovery report')
 {
	var winurl="loan_schedule_report.rdf&P_STARTYR="+MiscScheduleReportForm.txtFromYYMM.value+"&P_ENDYR="+MiscScheduleReportForm.txtToYYMM.value+"&P_LOCATION="+MiscScheduleReportForm.loginLocCode.value+"&P_EMP_TYPE="+MiscScheduleReportForm.hdnEmpLbrFlag.value+"&P_AGENCY_CODE="+MiscScheduleReportForm.txtAgency.value+"&P_AGENCY_S_CODE="+MiscScheduleReportForm.txtAgencySiteCode.value+"&P_PAY_CODE="+MiscScheduleReportForm.txtPayCode2.value;
	document.getElementById('butInsert1').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert1').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.MiscScheduleReportForm.submit();
 }
 
   }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="MiscScheduleReportForm"  property="screenMode"/>
    <html:hidden name="MiscScheduleReportForm"  property="screenName" value="MiscScheduleReport" />
    <html:hidden property="buttonFlag" name="MiscScheduleReportForm"  />     
    <html:hidden property="lovKey" name="MiscScheduleReportForm"  />
    <html:hidden property="txtFields" name="MiscScheduleReportForm"  />   
    <html:hidden property="txtSearchFields" name="MiscScheduleReportForm"  />
    <html:hidden property="txtDisplayFields" name="MiscScheduleReportForm"  />
    <html:hidden property="txtIndex" name="MiscScheduleReportForm"  />        
    <html:hidden property="loginLocCode" name="MiscScheduleReportForm"  />  
    <html:hidden property="locTyp" name="MiscScheduleReportForm"  />  
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  

/*  if(MiscScheduleReportForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    MiscScheduleReportForm.action="../../../MiscScheduleGetAccess.do"
    MiscScheduleReportForm.submit();  
  }
  
//  alert(document.getElementById("locTyp").value);
}

function ShowLovYYMM()
{
        MiscScheduleReportForm.queryParam.value="hdnMaxYYMM="+ MiscScheduleReportForm.hdnMaxYYMM.value +" " ;    
        MiscScheduleReportForm.lovKey.value = "ReportGeneratePaySlipYear" + MiscScheduleReportForm.screenName.value + "U";
        MiscScheduleReportForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        MiscScheduleReportForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','MiscScheduleReportForm');       
        return true;
}

function ShowLovPayCode()
{   
   MiscScheduleReportForm.lovKey.value = "PayCode" + MiscScheduleReportForm.screenName.value + "U";
   MiscScheduleReportForm.queryParam.value = "hdnEmpLbrFlag="+MiscScheduleReportForm.hdnEmpLbrFlag.value+",screenName="+MiscScheduleReportForm.screenName.value+",screenMode="+MiscScheduleReportForm.screenMode.value+",txtSiteID="+MiscScheduleReportForm.loginLocCode.value;   // added by swapnendu Dt 07 Sep 2012.
   MiscScheduleReportForm.txtDisplayFields.value = "txtPayCode1,txtPayCodeName";
   MiscScheduleReportForm.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";
   MiscScheduleReportForm.txtIndex.value="";  
  // MiscScheduleReportForm.txtInputField.value="";    
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'MiscScheduleReportForm');
   return true;
}

function ShowLovAgencyCode()
{ 
     MiscScheduleReportForm.lovKey.value = "MaintDirectPayrollAgencyCode" + MiscScheduleReportForm.screenName.value + "U";
     MiscScheduleReportForm.txtDisplayFields.value = "txtAgency,txtAgencyName";
     MiscScheduleReportForm.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Agency,Payroll.Common.Desc";
    
     if(document.getElementById('radiobank').checked)
     {
     if(document.getElementById("txtPayCode2").value=="")
     {
     alert('Please select pay code first');
     return false;
     }
     else
     {
     MiscScheduleReportForm.queryParam.value="txtSiteID="+MiscScheduleReportForm.loginLocCode.value+",txtEmpNo=1"+",txtPayCode="+document.getElementById("txtPayCode2").value;
        }
 }
 else
 {if(document.getElementById("txtPayCode1").value=="")
     {
     alert('Please select pay code first');
     return false;
     }
     else
     {
      MiscScheduleReportForm.queryParam.value="txtSiteID="+MiscScheduleReportForm.loginLocCode.value+",txtEmpNo=1"+",txtPayCode="+document.getElementById("txtPayCode1").value;
 }}
 //    MiscScheduleReportForm.txtInputField.value ="";
   <!--  //MiscScheduleReportForm.txtInputField.value ="txtAgencyName";    -->
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'MiscScheduleReportForm');
     return true;  
}

function ShowLovAgencySiteCode()
{
     if(document.all.txtAgency.value=="" )
     {
        alert("Please select Supplier No. first!!!");
        return false;
     }
     MiscScheduleReportForm.lovKey.value = "MaintDirectPayrollAgencySiteCode" + MiscScheduleReportForm.screenName.value + "U";
     MiscScheduleReportForm.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySite";   
     MiscScheduleReportForm.queryParam.value = "txtSiteID="+MiscScheduleReportForm.loginLocCode.value+",txtAgency="+document.all.txtAgency.value;
     MiscScheduleReportForm.txtSearchFields.value = "";      
 //    MiscScheduleReportForm.txtInputField.value ="";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'MiscScheduleReportForm');
     return true;  
}

function chk_YearMonth(obj)
{      
    var  yearM = document.getElementById(obj).value;          
    if(yearM!=""){
    var month =  yearM.substring(4,6);    
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementById(obj).focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById(obj).focus();                     
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
	document.getElementById(obj).value="";
        event.returnValue=false; 
		
        return false;
        }
    }
}

function miscReport()
{
   document.getElementById("reofrom").style.display="none";
   document.getElementById("reoto").style.display="none";
   document.getElementById("rowyymm").style.display="";
   document.getElementById("bankbtnclm").style.display="none";
   document.getElementById("miscbtnclm").style.display="";
   document.getElementById("paycodemiscrow").style.display="";
   document.getElementById("paycodeloanrow").style.display="none";
    document.getElementById("txtFromYYMM").value="000000";
	document.getElementById("txtToYYMM").value="000000";
	 document.getElementById("txtPayCode2").options[0].value ="0";
   document.getElementById("txtYYMM").value="";
	  document.getElementById("txtPayCode1").value="";
   
}
function Bankreport()
{

 document.getElementById("reofrom").style.display="";
   document.getElementById("reoto").style.display="";
   document.getElementById("rowyymm").style.display="none";
     document.getElementById("bankbtnclm").style.display="";
   document.getElementById("miscbtnclm").style.display="none";
   document.getElementById("paycodemiscrow").style.display="none";
   document.getElementById("paycodeloanrow").style.display="";
     document.getElementById("txtYYMM").value="000000";
	  document.getElementById("txtPayCode1").value="000";
	   document.getElementById("txtFromYYMM").value="";
	document.getElementById("txtToYYMM").value="";
	  document.getElementById("txtPayCode2").options[0].value="";
	 
 
   
}
function chk_toYearMonth(obj1,obj2)
{
if(chk_YearMonth(obj1))
{

if(parseInt(document.getElementById(obj1).value)<parseInt(document.getElementById(obj2).value))
{
alert("To Year Month must be greater or equal to From Year Month ");
document.getElementById(obj1).focus();
document.getElementById(obj1).value="";
}
}
}


</script>

