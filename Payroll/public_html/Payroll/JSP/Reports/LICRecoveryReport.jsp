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
  <html:form  action="ReportLinkerAction" name="LICRecoveryRepForm" type="FCIPAY.Payroll.WEBTIER.Form.LICRecoveryRepForm" scope="session" >
  <bean:define id="ParentForm" name="LICRecoveryRepForm" toScope="request" />  
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
      <TD  colSpan=12 class=mainHeader height=10>LIC RECOVERY REPORT</TD>
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
              <TD class=subHeader colspan=6> LIC Recovery Report</TD>
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
					"if(!(checkEmployee(LICRecoveryRepForm.txtEmp.value,LICRecoveryRepForm.loginLocCode.value)))
					{
						LICRecoveryRepForm.txtEmp.value='';
					}"
					/>
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                    onclick="return ShowLovEmpNo();" >                       
                    <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                    </td>                           
                                      
                  </tr>    
                  
                  <TR height=25>         
                    <!-- Detail table Container starts -->
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.MHSRep.FrYYMM" /></td><td >
                    <html:text  property="txtFrYYMM"  maxlength="6" size="16" styleClass="required"  
                    onchange="                                                  
                    if(!(chk_FrYearMonth()))
                    {
                    }                                            
                    " 
                    />
                    </td>              
                  </tr>
                  
                  <tr height=25>
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.MHSRep.ToYYMM" /></td><td >
                    <html:text  property="txtToYYMM"  maxlength="6" size="16" styleClass="required"  
                    onchange="                                                  
                    if(!(chk_ToYearMonth()))
                    {
                    }                                            
                    " 
                    />
                    </td>      
                  </tr>

	 <!-- for Agency code   --> 
              <tr>
               <TD class=labelText >  Supplier No. </TD>
               <td  align="left"> <html:text  property="txtAgency" name="LICRecoveryRepForm" maxlength="10" size="23" />
               <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovAgencyCode();" >
               <html:text property="txtAgencyName" size="30" value="" styleClass="locked" readonly="true" /></td>   
              </tr>
  <!-- for Agency code   --> 
  
  <!-- for Agency Site code   --> 
              <tr>
               <TD class=labelText >  Supplier Site  </TD>
               <td  align="left"> <html:text  property="txtAgencySiteCode" name="LICRecoveryRepForm" maxlength="10" size="23" />
               <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovAgencySiteCode();" >
               <html:text property="txtAgencySite" size="30" value="" styleClass="locked" readonly="true" /></td>   
              </tr>
  <!-- for Agency Site code   -->


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
              <td  bgcolor=#4682b4><html:button value=' GENERATE LIC RECOVERY REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
	var check_valid_1=chk_FrYearMonth();
	var check_valid_2=chk_ToYearMonth();
	var check_valid_3=diffYearmth();
    
    if(check_valid_1 == false)
    {
        document.getElementById("txtFrYYMM").focus();   
        return false;
    }
	else if(check_valid_2 == false)
    {
        document.getElementById("txtToYYMM").focus();   
        return false;
    }
	else if(check_valid_3 == false)
    {
        document.getElementById("txtToYYMM").focus();   
        return false;
    }
	else
	{
		if(mandatory_Check('LICRecoveryRepForm'))
		{
			var winurl="LIC_recovery.rdf&P_STARTYR="+LICRecoveryRepForm.txtFrYYMM.value+"&P_ENDYR="+LICRecoveryRepForm.txtToYYMM.value+"&P_EMP_NUM="+LICRecoveryRepForm.txtEmp.value+"&P_LOCATION="+LICRecoveryRepForm.loginLocCode.value+"&P_EMP_TYPE="+LICRecoveryRepForm.hdnEmpLbrFlag.value+"&P_AGENCY_CODE="+LICRecoveryRepForm.txtAgency.value+"&P_AGENCY_S_CODE="+LICRecoveryRepForm.txtAgencySiteCode.value;
			document.getElementById('butInsert').value="Please wait. File is being downloaded..";
			document.getElementById('butInsert').disabled="true";
			document.getElementById('submitParam').value = winurl;
			document.LICRecoveryRepForm.submit();
		}
		else{
			return false;
		}
	}
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="LICRecoveryRepForm"  property="screenMode"/>
    <html:hidden name="LICRecoveryRepForm"  property="screenName" value="LICRecoveryReport" />
    <html:hidden property="buttonFlag" name="LICRecoveryRepForm"  />       

    
    <html:hidden property="lovKey" name="LICRecoveryRepForm"  />
    <html:hidden property="txtFields" name="LICRecoveryRepForm"  />   
    <html:hidden property="txtSearchFields" name="LICRecoveryRepForm"  />
    <html:hidden property="txtDisplayFields" name="LICRecoveryRepForm"  />
    <html:hidden property="txtIndex" name="LICRecoveryRepForm"  />
    <html:hidden property="txtCpfCode" name="LICRecoveryRepForm"  />                        <!--added by dushyant 0n 19-aug-2010-->
    
    
    <html:hidden property="loginLocCode" name="LICRecoveryRepForm"  />
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(LICRecoveryRepForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    LICRecoveryRepForm.action="../../../LICRecoveryGetAccess.do"
    LICRecoveryRepForm.submit();  
  }
}

function ShowLovYYMM()
{
        LICRecoveryRepForm.queryParam.value="hdnMaxYYMM="+ LICRecoveryRepForm.hdnMaxYYMM.value +" " ;    
        LICRecoveryRepForm.lovKey.value = "ReportGeneratePaySlipYear" + LICRecoveryRepForm.screenName.value + "U";
        LICRecoveryRepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        LICRecoveryRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LICRecoveryRepForm');

        
        return true;
}

function ShowLovEmpNo()
{
        LICRecoveryRepForm.lovKey.value = "LICRecoveryEmp" + LICRecoveryRepForm.screenName.value + "U";
        LICRecoveryRepForm.queryParam.value="txtSiteID="+ LICRecoveryRepForm.loginLocCode.value +",hdnEmpLbrFlag="+LICRecoveryRepForm.hdnEmpLbrFlag.value ;
        LICRecoveryRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
        LICRecoveryRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','LICRecoveryRepForm');
        return true;
}

 function ShowLovAgencyCode()
{ 
     LICRecoveryRepForm.lovKey.value = "MaintDirectPayrollAgencyCode" + LICRecoveryRepForm.screenName.value + "U";
     LICRecoveryRepForm.txtDisplayFields.value = "txtAgency,txtAgencyName";
     LICRecoveryRepForm.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Agency,Payroll.Common.Desc";
     LICRecoveryRepForm.queryParam.value="";
 //    LICRecoveryRepForm.txtInputField.value ="";
   <!--  //LICRecoveryRepForm.txtInputField.value ="txtAgencyName";    -->
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'LICRecoveryRepForm');
     return true;  
}

function ShowLovAgencySiteCode()
{
     if(document.all.txtAgency.value=="" )
     {
        alert("Please select Supplier No. first!!!");
        return false;
     }
     LICRecoveryRepForm.lovKey.value = "MaintDirectPayrollAgencySiteCode" + LICRecoveryRepForm.screenName.value + "U";
     LICRecoveryRepForm.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySite";   
     LICRecoveryRepForm.queryParam.value = "txtAgency="+document.all.txtAgency.value;
     LICRecoveryRepForm.txtSearchFields.value = "";      
 //    LICRecoveryRepForm.txtInputField.value ="";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'LICRecoveryRepForm');
     return true;  
}

function chk_ToYearMonth()
{      
    var  yearM = document.getElementById("txtToYYMM").value;          
    var month =  yearM.substring(4,6);    
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" To Year Month should be a Six digit Number");
            document.getElementById("txtToYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert(" To Month should be Within 1 to 12");
            document.getElementById("txtToYYMM").focus();                     
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


function chk_FrYearMonth()
{      
    var  yearM = document.getElementById("txtFrYYMM").value;          
    var month =  yearM.substring(4,6);    
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" From Year Month should be a Six digit Number");
            document.getElementById("txtFrYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert(" From Month should be Within 1 to 12");
            document.getElementById("txtFrYYMM").focus();                     
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

function diffYearmth()
{

   var1= document.getElementById("txtFrYYMM").value;
   var2= document.getElementById("txtToYYMM").value;
   var3=parseInt(var2)-parseInt(var1);
   if (var3<0) 
	{
		alert("To Year Month can not be less than From Year Month");
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
</script>
