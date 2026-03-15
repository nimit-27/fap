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
  <html:form  action="ReportLinkerAction" name="MedHealthSchmDedRepForm" type="FCIPAY.Payroll.WEBTIER.Form.MedHealthSchmDedRepForm" scope="session" >
  <bean:define id="ParentForm" name="MedHealthSchmDedRepForm" toScope="request" />  
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
      <TD  colSpan=12 class=mainHeader height=10>MDICAL HEAILTH SCHEME DEDUCTION REPORT</TD>
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
              <TD class=subHeader colspan=6> Medical Health Scheme Deduction Report</TD>
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
					"if(!(checkEmployee(MedHealthSchmDedRepForm.txtEmp.value,MedHealthSchmDedRepForm.loginLocCode.value)))
					{
						MedHealthSchmDedRepForm.txtEmp.value='';
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
              <td  bgcolor=#4682b4><html:button value=' GENERATE MED HEALTH SCHEME DEDUCTION REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
		if(mandatory_Check('MedHealthSchmDedRepForm'))
		{
			var winurl="Medical_Health_Scheme_Deduction.rdf&P_STARTYR="+MedHealthSchmDedRepForm.txtFrYYMM.value+"&P_ENDYR="+MedHealthSchmDedRepForm.txtToYYMM.value+"&P_EMP_NUM="+MedHealthSchmDedRepForm.txtEmp.value+"&P_LOCATION="+MedHealthSchmDedRepForm.loginLocCode.value+"&P_EMP_TYPE="+MedHealthSchmDedRepForm.hdnEmpLbrFlag.value;
			document.getElementById('butInsert').value="Please wait. File is being downloaded..";
			document.getElementById('butInsert').disabled="true";
			document.getElementById('submitParam').value = winurl;
			document.MedHealthSchmDedRepForm.submit();
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

    <html:hidden name="MedHealthSchmDedRepForm"  property="screenMode"/>
    <html:hidden name="MedHealthSchmDedRepForm"  property="screenName" value="MedHealthSchmReport" />
    <html:hidden property="buttonFlag" name="MedHealthSchmDedRepForm"  />       

    
    <html:hidden property="lovKey" name="MedHealthSchmDedRepForm"  />
    <html:hidden property="txtFields" name="MedHealthSchmDedRepForm"  />   
    <html:hidden property="txtSearchFields" name="MedHealthSchmDedRepForm"  />
    <html:hidden property="txtDisplayFields" name="MedHealthSchmDedRepForm"  />
    <html:hidden property="txtIndex" name="MedHealthSchmDedRepForm"  />
    <html:hidden property="txtCpfCode" name="MedHealthSchmDedRepForm"  />
    
    
    <html:hidden property="loginLocCode" name="MedHealthSchmDedRepForm"  />
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(MedHealthSchmDedRepForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    MedHealthSchmDedRepForm.action="../../../HealthSchmDedGetAccess.do"
    MedHealthSchmDedRepForm.submit();  
  }
}

function ShowLovYYMM()
{
        MedHealthSchmDedRepForm.queryParam.value="hdnMaxYYMM="+ MedHealthSchmDedRepForm.hdnMaxYYMM.value +" " ;    
        MedHealthSchmDedRepForm.lovKey.value = "ReportGeneratePaySlipYear" + MedHealthSchmDedRepForm.screenName.value + "U";
        MedHealthSchmDedRepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        MedHealthSchmDedRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','MedHealthSchmDedRepForm');

        
        return true;
}

function ShowLovEmpNo()
{
        MedHealthSchmDedRepForm.lovKey.value = "MedHealthSchmDedEmp" + MedHealthSchmDedRepForm.screenName.value + "U";
        MedHealthSchmDedRepForm.queryParam.value="txtSiteID="+ MedHealthSchmDedRepForm.loginLocCode.value +",hdnEmpLbrFlag="+MedHealthSchmDedRepForm.hdnEmpLbrFlag.value ;  
        MedHealthSchmDedRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
        MedHealthSchmDedRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','MedHealthSchmDedRepForm');
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
