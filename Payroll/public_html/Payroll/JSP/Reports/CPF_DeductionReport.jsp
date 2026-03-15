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

<html:form  action="ReportLinkerAction" name="CPFDednRepForm" type="FCIPAY.Payroll.WEBTIER.Form.CPFDednRepForm" scope="session" >
<bean:define id="ParentForm" name="CPFDednRepForm" toScope="request" />

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
  <TD  colSpan=12 class=mainHeader height=10>CPF DEDUCTION REPORT</TD>
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
          <TD class=subHeader colspan=6>CPF Deduction Report</TD>
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
             
<tr height=30  >

<td align="center" colspan=50>
From YYYYMM
<html:text  property="txtFrYYMM"  maxlength="6" size="10" styleClass="required"  
                    onchange="                                                  
                    if(!(chk_FrYearMonth()))
                    {
                    }                                            
                    " 
                    
                    />

To YYYYMM
<html:text  property="txtToYYMM"  maxlength="6" size="10" styleClass="required"  
                    onchange="                                                  
                    if(!(chk_ToYearMonth()))
                    {
                    }                                            
                    " 
                    
                    /><bean:message key="Payroll.Report.YyyyMm" />
</td>  </tr>
              </center>
              </table>


              <table border=0 cellpadding=0>
              <TR height=30>
                <td width=25% >
                <TD class=labelText width="20%" >                
                <bean:message key="Payroll.PaySlip.EmpNumber"  />  
                <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional" 
				onchange=
					"if(!(checkEmployee(CPFDednRepForm.txtEmp.value,CPFDednRepForm.loginLocCode.value)))
					{
						CPFDednRepForm.txtEmp.value='';
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
         
		  <td class="labelText"  width="45%" align="center">Category</td>
			  <td>
			  <select name="txtCategory">
			  <option value="0">All</option>
			  <option value="1">Category 1</option>
			  <option value="2">Category 2</option>
			  <option value="3">Category 3</option>
			  <option value="4">Category 4</option>
        <option value="5">DPS Labour</option>
			  <option value="6">Dept Labour</option>
			  </select>
			  </td>

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
               <td  bgcolor=#4682b4><html:button value=' GENERATE CPF DEDUCTION REPORT'  onclick="return doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
		if(mandatory_Check('CPFDednRepForm'))
		{
			var lbr_flag = CPFDednRepForm.hdnEmpLbrFlag.value;
			var winurl="FCI_CPF_ALL.rdf&P_EMP_NUM="+CPFDednRepForm.txtEmp.value+"&P_FRMYYMM="+CPFDednRepForm.txtFrYYMM.value+"&P_TOYYMM="+CPFDednRepForm.txtToYYMM.value+"&P_EMP_FLG="+CPFDednRepForm.hdnEmpLbrFlag.value+"&P_LOCATION="+CPFDednRepForm.loginLocCode.value+"&P_CATEGORY="+document.getElementById("txtCategory").value;
			document.getElementById('butInsert').value="Please wait. File is being downloaded..";
			document.getElementById('butInsert').disabled="true";
			document.getElementById('submitParam').value = winurl;
			document.CPFDednRepForm.submit();
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

    <html:hidden name="CPFDednRepForm"  property="screenMode"/>
    <html:hidden name="CPFDednRepForm"  property="screenName" value="CpfDednReport" />
    <html:hidden property="buttonFlag" name="CPFDednRepForm"  />       

    
    <html:hidden property="lovKey" name="CPFDednRepForm"  />
    <html:hidden property="txtFields" name="CPFDednRepForm"  />   
    <html:hidden property="txtSearchFields" name="CPFDednRepForm"  />
    <html:hidden property="txtDisplayFields" name="CPFDednRepForm"  />
    <html:hidden property="txtIndex" name="CPFDednRepForm"  />
    
    
    <html:hidden property="loginLocCode" name="CPFDednRepForm"  />
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
    CPFDednRepForm.action="../../../CPFDednGetAccess.do"
    CPFDednRepForm.submit();  
  }
}

function ShowLovEmpNo()
{
        CPFDednRepForm.lovKey.value = "ReportGeneratePaySlipEmp" + CPFDednRepForm.screenName.value + "U";
        CPFDednRepForm.queryParam.value="txtSiteID="+ CPFDednRepForm.loginLocCode.value +",hdnEmpLbrFlag="+CPFDednRepForm.hdnEmpLbrFlag.value ; 
        CPFDednRepForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
        CPFDednRepForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','CPFDednRepForm');
        return true;
}

function ShowLovYYMM()
{
        CPFDednRepForm.queryParam.value="hdnMaxYYMM="+ CPFDednRepForm.hdnMaxYYMM.value +" " ;    
        CPFDednRepForm.lovKey.value = "ReportGeneratePaySlipYear" + CPFDednRepForm.screenName.value + "U";
        CPFDednRepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        CPFDednRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','CPFDednRepForm');

        
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
function ShowLovEmpNo()
{
        CPFDednRepForm.lovKey.value = "ReportGeneratePaySlipEmp" + CPFDednRepForm.screenName.value + "U";
        CPFDednRepForm.queryParam.value="txtSiteID="+ CPFDednRepForm.loginLocCode.value +",hdnEmpLbrFlag="+CPFDednRepForm.hdnEmpLbrFlag.value ; 
        CPFDednRepForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
        CPFDednRepForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','CPFDednRepForm');
        return true;
}

</script>
