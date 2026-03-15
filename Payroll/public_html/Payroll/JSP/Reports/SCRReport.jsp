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

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form action="ReportLinkerAction" name="SCRRepForm" type="FCIPAY.Payroll.WEBTIER.Form.SCRRepForm" scope="session" >
<bean:define id="ParentForm" name="SCRRepForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>Salary Control Register</TD>
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
          <TD class=subHeader colspan=6> SALARY CONTROL REGISTER</TD>
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
              <TR>
         
		<!-- Detail table Container starts -->
              <td class="labelText"  width="25%" align="center">From Year Month</td>
              <td>
              <html:text  property="txtFromYYMM"  maxlength="6" size="23" styleClass="required"  
                onblur="                                                  
                       if(!(chk_YearMonth('txtFromYYMM')))
                          {
                          }                                            
              " 
              /><bean:message key="Payroll.MaintDARates.yymm" />
              </td>

              <td class="labelText"  width="25%" align="center">To Year Month</td><td >
              <html:text  property="txtToYYMM"  maxlength="6" size="23" styleClass="required"  
                onblur="                                                  
                       if(!(chk_YearMonth('txtToYYMM')))
                          {
                          }                                            
              " 
              /><bean:message key="Payroll.MaintDARates.yymm" />
              </td>

      
              </tr>
              
               <TR >
                <TD class=labelText width="25%" >                
                <bean:message key="Payroll.PaySlip.EmpNumber"  />  
                <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  
				onchange=
					"if(!(checkEmployee(SCRRepForm.txtEmp.value,SCRRepForm.loginLocCode.value)))
					{
						SCRRepForm.txtEmp.value='';
					}"
				/>
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovEmpNo();" >
                <html:text property="txtEmpName"  size="23" value="" styleClass="locked" readonly="true" />
                <!--html:text property="txtCpfCode"  size="35" value="" styleClass="locked" readonly="true" /-->
                </td>
                </td>
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
               <td  bgcolor=#4682b4><html:button value=' Salary Control Register'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
   
<script language="javascript" type="text/javascript">
function doGetReport()
{  
	if(mandatory_Check('SCRRepForm'))
	{
		var fromdt= document.getElementById("txtFromYYMM").value;
		var todt= document.getElementById("txtToYYMM").value;
		if(fromdt>todt)
		{
			alert("To Year Month can not be less than From Year Month");
			return false;
		}     
		if (!diff(fromdt,todt))
		{
			document.SCRRepForm.txtFromYYMM.value="";
			document.SCRRepForm.txtToYYMM.value="";
			return false;   
		}
		var winurl= "SCR.rdf&P_EMP_NUM="+SCRRepForm.txtEmp.value+"&P_YYMM_FRM="+SCRRepForm.txtFromYYMM.value+"&P_YYMM_TO="+SCRRepForm.txtToYYMM.value+"&P_LOCATION_CODE="+SCRRepForm.loginLocCode.value+"&P_EMP_FLG="+SCRRepForm.hdnEmpLbrFlag.value;
		document.getElementById('butInsert').value="Please wait. File is being downloaded..";
		document.getElementById('butInsert').disabled="true";
		document.getElementById('submitParam').value = winurl;
		document.SCRRepForm.submit();
	}
	else{
		return false;
	}
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="SCRRepForm"  property="screenMode"/>
    <html:hidden name="SCRRepForm"  property="screenName" value="SCRRep" />
    <html:hidden property="buttonFlag" name="SCRRepForm"  />
<!--    <html:hidden property="txtEmp" name="SCRRepForm"  />    -->     
    <html:hidden property="txtCpfCode" name="SCRRepForm"  />
    <html:hidden property="lovKey" name="SCRRepForm"  />
    <html:hidden property="txtFields" name="SCRRepForm"  />   
    <html:hidden property="txtSearchFields" name="SCRRepForm"  />
    <html:hidden property="txtDisplayFields" name="SCRRepForm"  />
    <html:hidden property="txtIndex" name="SCRRepForm"  />
    <html:hidden property="loginLocCode" name="SCRRepForm"  />
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
    SCRRepForm.action="../../../SCRRepGetAccess.do";
    SCRRepForm.submit();  
  }
}

function ShowLovEmpNo()
{
        SCRRepForm.lovKey.value = "ReportSCREmp" + SCRRepForm.screenName.value + "U";
        SCRRepForm.queryParam.value="txtSiteID="+ SCRRepForm.loginLocCode.value +",hdnEmpLbrFlag="+SCRRepForm.hdnEmpLbrFlag.value +",screenname="+SCRRepForm.screenName.value ;
        SCRRepForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
        SCRRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','SCRRepForm');
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
     //       event.srcElement.select();
      //      event.srcElement.focus();
     //       event.returnValue=false;     
    return false;
     }
    }
}
function diff(var1,var2)
{
var fdt = var1;
var tdt = var2;
var t1,t2,t3,t4,temp;
 t1 = fdt.substring(0,4);
 t2 = tdt.substring(0,4);
 t3 = fdt.substring(4,6);
 t4 = tdt.substring(4,6);
 if (parseInt(t2)-parseInt(t1)==1)
  {    
 t3 = (12-t3)+1;
 temp=parseInt(t3)+parseInt(t4);
 if (temp>12)
 {
   alert("Year Month difference can not exceed 12");
   
   return false;
}
else
  {
  return true;
  }  
}
if (parseInt(t2)-parseInt(t1)>1)
{
alert("Year Month difference can not exceed 12");

return false;
}
return true;
}
</script>
