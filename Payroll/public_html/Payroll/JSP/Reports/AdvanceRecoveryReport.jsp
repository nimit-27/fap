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

<html:form  action="ReportLinkerAction" name="AdvRecoveryRepForm" type="FCIPAY.Payroll.WEBTIER.Form.AdvRecoveryRepForm" scope="session" >
<bean:define id="ParentForm" name="AdvRecoveryRepForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>ADVANCE SANCTIONS REPORT</TD>
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
          <TD class=subHeader colspan=6> Advance Sanction Report</TD>
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
              <td class="labelText"  align="left">From Year Month </td><td>
              <html:text  property="txtFromYYMM"  maxlength="6" size="23" styleClass="required"  
                onchange="                                                  
                    if(!(chk_FrYearMonth()))
                          {
                          }                                            
              "
              />
              </td>

              <td class="labelText"  align="left">To Year Month</td><td >
              <html:text  property="txtToYYMM"  maxlength="6" size="23" styleClass="required"  
                onchange="                                                  
                    if(!(chk_ToYearMonth()))
                          {
                          }                                            
              "
              />
              </td>

      
              </tr>

              <TR >
                <TD class=labelText  > Employee Number</TD>
                <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  
				onchange=
							"if(!(checkEmployee(AdvRecoveryRepForm.txtEmp.value,AdvRecoveryRepForm.loginLocCode.value)))
							{
								AdvRecoveryRepForm.txtEmp.value='';
							}"
				/>
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovEmpNo();" >
                <html:text property="txtEmpName"  value="" styleClass="locked" readonly="true" /></td>
                </td>
                <TD class=labelText >                
                Advance Type</TD>
                <td  align="left"><html:text  property="txtPayCode" maxlength="10" size="20" styleClass="required" />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovAdvType();" >
                <html:text property="txtPayCodeDesc"  value="" styleClass="locked" readonly="true" /></td>
                </td>
                </tr>           
           
           
                <tr height="15" >
            <td colspan="4"></td>
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
               <td  bgcolor=#4682b4><html:button value='ADVANCE SANCTIONS REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
	var check_valid_1=chk_FrYearMonth();
	var check_valid_2=chk_ToYearMonth();
    var check_valid_3=diffYearmth();
    
    if(check_valid_1 == false)
    {
        document.getElementById("txtFromYYMM").focus();   
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
		if(mandatory_Check('AdvRecoveryRepForm'))
		{
			if(document.all.advFlag.value=='A' || document.all.advFlag.value=='P')
				var winurl= "Advance_Repayment.rdf&P_EMP_NUM="+AdvRecoveryRepForm.txtEmp.value+"&P_STARTYR="+AdvRecoveryRepForm.txtFromYYMM.value+"&P_ENDYR="+AdvRecoveryRepForm.txtToYYMM.value+"&P_LOCATION="+AdvRecoveryRepForm.loginLocCode.value+"&P_ADV_TYPE="+AdvRecoveryRepForm.txtPayCode.value+"&P_EMP_TYPE="+AdvRecoveryRepForm.hdnEmpLbrFlag.value;
			else
				var winurl= "Loan_Rerpayment.rdf&P_EMP_NUM="+AdvRecoveryRepForm.txtEmp.value+"&P_STARTYR="+AdvRecoveryRepForm.txtFromYYMM.value+"&P_ENDYR="+AdvRecoveryRepForm.txtToYYMM.value+"&P_LOCATION="+AdvRecoveryRepForm.loginLocCode.value+"&P_LOAN_TYPE="+AdvRecoveryRepForm.txtPayCode.value+"&P_EMP_TYPE="+AdvRecoveryRepForm.hdnEmpLbrFlag.value;
			document.getElementById('butInsert').value="Please wait. File is being downloaded..";
			document.getElementById('butInsert').disabled="true";
			document.getElementById('submitParam').value = winurl;
			document.AdvRecoveryRepForm.submit();

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

    <html:hidden name="AdvRecoveryRepForm"  property="screenMode"/>
    <html:hidden name="AdvRecoveryRepForm"  property="screenName" value="AdvRecoveryRep" />
    <html:hidden property="buttonFlag" name="AdvRecoveryRepForm"  />
<!--    <html:hidden property="txtEmp" name="AdvRecoveryRepForm"  />    -->     
  
    <html:hidden property="lovKey" name="AdvRecoveryRepForm"  />
    <html:hidden property="txtFields" name="AdvRecoveryRepForm"  />   
    <html:hidden property="txtSearchFields" name="AdvRecoveryRepForm"  />
    <html:hidden property="txtDisplayFields" name="AdvRecoveryRepForm"  />
    <html:hidden property="txtIndex" name="AdvRecoveryRepForm"  />
    <html:hidden property="txtCpfCode" name="AdvRecoveryRepForm"  />                <!--added by dushyant on 20-08-2010-->
    <html:hidden property="loginLocCode" name="AdvRecoveryRepForm"  />
    <input type="hidden" name="queryParam" />      
    <input type="hidden" name="advFlag" />  
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
    AdvRecoveryRepForm.action="../../../AdvRecoveryRepGetAccess.do";
    AdvRecoveryRepForm.submit();  
  }
}

function ShowLovEmpNo()
{
        AdvRecoveryRepForm.lovKey.value = "ReportAdvRecoveryEmp" + AdvRecoveryRepForm.screenName.value + "U";
        AdvRecoveryRepForm.queryParam.value="txtSiteID="+ AdvRecoveryRepForm.loginLocCode.value +" " ; 
        AdvRecoveryRepForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
        AdvRecoveryRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','AdvRecoveryRepForm');
        return true;
}

function ShowLovAdvType()
{
        AdvRecoveryRepForm.lovKey.value = "ReportAdvRecoveryType" + AdvRecoveryRepForm.screenName.value + "U";
        AdvRecoveryRepForm.queryParam.value = "hdnEmpLbrFlag="+AdvRecoveryRepForm.hdnEmpLbrFlag.value+",screenName="+AdvRecoveryRepForm.screenName.value+",screenMode="+AdvRecoveryRepForm.screenMode.value+",txtSiteID="+AdvRecoveryRepForm.loginLocCode.value; 

        AdvRecoveryRepForm.txtSearchFields.value = "Payroll.Report.PayCode,Payroll.Report.PayCodeDesc";
        AdvRecoveryRepForm.txtDisplayFields.value = "txtPayCode,txtPayCodeDesc,advFlag";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','AdvRecoveryRepForm');
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
    var  yearM = document.getElementById("txtFromYYMM").value;          
    var month =  yearM.substring(4,6);    
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" From Year Month should be a Six digit Number");
            document.getElementById("txtFromYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert(" From Month should be Within 1 to 12");
            document.getElementById("txtFromYYMM").focus();                     
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

   var1= document.getElementById("txtFromYYMM").value;
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