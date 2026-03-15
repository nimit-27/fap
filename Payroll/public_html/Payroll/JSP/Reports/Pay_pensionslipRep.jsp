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
  <html:form  action="ReportLinkerAction" name="PensionDetailRepForm" type="FCIPAY.Payroll.WEBTIER.Form.PensionDetailRepForm" scope="session" >
  <bean:define id="ParentForm" name="PensionDetailRepForm" toScope="request" />  
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
   <html:errors/>
  <enrgise:errors/>
  <html:hidden property="headerDataChanged" value="false" />
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
      <TD  colSpan=12 class=mainHeader height=10>PENSION SLIP REPORT </TD>
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
              <TD class=subHeader colspan=6>Pension Slip Report </TD>
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
                    <td  align="left" ><html:text  property="txtEmp" maxlength="10" size="16" styleClass="required"  />
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                    onclick="return ShowLovEmpNo();" >                       
                    <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                    </td>                           
                                      
                  </tr>   
                  
                  <TR height=25>         
                    <!-- Detail table Container starts -->
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.MaintPensionDetail.FromYr" /></td><td >
                    <html:text  property="txtFrYYYY"  maxlength="4" size="16" styleClass="required"  
                    onchange="                                                  
                    if(!(chk_YearMonth('txtFrYYYY')))
                    {
                    }                                            
                    " 
                    
                    onblur="                                                  
                    if(!(chk_YearMonth('txtFrYYYY')))
                    {
                    }                                            
                    " 

					onkeypress="
                    if(event.keyCode < 48 || event.keyCode > 57)
                    {                     
                      return false;
                    }"                    
                    />
                    </td>              
                  </tr>
                  
                  <tr height=25>
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.MaintPensionDetail.ToYr" /></td><td >
                    <html:text  property="txtToYYYY"  maxlength="4" size="16" styleClass="required"  
                    onchange="                                                  
                    if(!(chk_YearMonth('txtToYYYY')))
                    {
                    }                                            
                    " 
                    
                    onblur="                                                  
                    if(!(chk_YearMonth('txtToYYYY')))
                    {
                    }                                            
                    " 
					onkeypress="
                    if(event.keyCode < 48 || event.keyCode > 57)
                    {                     
                      return false;
                    }"                    
                    />
                    </td>      
                  </tr>
                  
                   <tr height=25>
       <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.PaySlip.AccessKey" /></td>
       <td colspan=2>
           <html:password  property="txtCPFDDYYMM" maxlength="20"  name="PensionDetailRepForm" size="23"  styleClass="required" onchange="return chk_CPFYearMonth();"  onfocus="disableBtn();" />     
              <bean:message key="Payroll.MaintDARates.cpf@ddmmyyyy" />
         
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
              <td id="payslipbtnclm"  bgcolor=#4682b4><html:button value=' GENERATE PENSION SLIP REPORT'  onclick="doGetReport()"  property="butInsert" styleClass="bottomBarText" /></td>
              <td width="45%" bgColor=#4682b4></td>
              <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
            </TR>   
          </table>
       </tr>
    </TABLE>
    <!-- Tab Table Ends -->

 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript">
function doGetReport()
{  
	if(mandatory_Check('PensionDetailRepForm'))
	{
		var winurl="pay_pension_slip.rdf&I_FRM_YR="+PensionDetailRepForm.txtFrYYYY.value+"&I_TO_YR="+PensionDetailRepForm.txtToYYYY.value+"&P_EMP_NUM="+PensionDetailRepForm.txtEmp.value+"&P_LOCATION="+PensionDetailRepForm.loginLocCode.value;
                document.getElementById('butInsert').value="Please wait. File is being downloaded..";
                document.getElementById('butInsert').disabled="true";
                document.getElementById('submitParam').value = winurl;
		document.PensionDetailRepForm.submit();
              
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


    <html:hidden name="PensionDetailRepForm"  property="screenMode"/>
    <html:hidden name="PensionDetailRepForm"  property="screenName" value="PensionDetailReport" />
    <html:hidden property="buttonFlag" name="PensionDetailRepForm"  />       
    <html:hidden property="lovKey" name="PensionDetailRepForm"  />
    <html:hidden property="txtFields" name="PensionDetailRepForm"  />   
    <html:hidden property="txtSearchFields" name="PensionDetailRepForm"  />
    <html:hidden property="txtDisplayFields" name="PensionDetailRepForm"  />
    <html:hidden property="txtIndex" name="PensionDetailRepForm"  />
    <html:hidden property="loginLocCode" name="PensionDetailRepForm"  />
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
    <html:hidden property="txtCpfCode" name="PensionDetailRepForm"  />
    <html:hidden property="txtSiteID" name="PensionDetailRepForm"/>
    <html:hidden property="txtSiteDesc" name="PensionDetailRepForm"  />
   <html:hidden property="txtUserFlag" name="PensionDetailRepForm"  />
   <html:hidden property="txtEmpType" name="PensionDetailRepForm"  />
   <html:hidden property="txtReport" name="PensionDetailRepForm"  />
   <html:hidden property="txtResult" name="PensionDetailRepForm"  />
    
</html:form>
</body>
</html:html>



<script language="javascript">
var res="";
function lfnLoad()
{   

/*  if(PFDetailRepForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    PensionDetailRepForm.action="../../../PensionDetailGetAccess.do"
    PensionDetailRepForm.submit();  


  }
  else
  {
    var location_id= document.getElementById("loginLocCode").value;
    if(location_id == 243 || location_id == 182 || location_id == 188 || location_id == 244 || location_id == 245 || location_id == 246)
    {
		document.getElementById("txtEmp").style.background="white";
		document.getElementById("txtEmp").className="optional";
	}
  }
}

function ShowLovYYMM()
{
        
        PensionDetailRepForm.queryParam.value="hdnMaxYYMM="+ PensionDetailRepForm.hdnMaxYYMM.value +" " ;    
        PensionDetailRepForm.lovKey.value = "ReportGeneratePaySlipYear" + PensionDetailRepForm.screenName.value + "U";
        PensionDetailRepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        PensionDetailRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PensionDetailRepForm');

        
        return true;
}

//function ShowLovEmpNo()
//{
//   
//   document.getElementById("txtCPFDDYYMM").value="";
//   OnlinePaySlipReportForm.lovKey.value = "EmpFinInfo" + OnlinePaySlipReportForm.screenName.value + OnlinePaySlipReportForm.screenMode.value;   
//   OnlinePaySlipReportForm.queryParam.value="txtSiteCode="+ OnlinePaySlipReportForm.loginLocCode.value +",hdnEmpLbrFlag=X";
//   OnlinePaySlipReportForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.EmpName,Payroll.Common.cpfCode,Payroll.common.SiteCode,Payroll.common.SiteDesc,Payroll.common.UserFlag";
//   OnlinePaySlipReportForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode,txtSiteCode,txtSiteDesc,txtUserFlag,txtEmpType";    
//   OnlinePaySlipReportForm.txtIndex.value = 0;
//   OnlinePaySlipReportForm.txtInputField.value =""; 
//   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/OnlineSearchScreen.jsp" />', 'OnlinePaySlipReportForm');
//   return true;
//}
//
//function ShowLovEmpNo()
//{
//       // PensionDetailRepForm.screenName.value="PensionDetailReport";
//       document.getElementById("txtCPFDDYYMM").value="";
//        PensionDetailRepForm.lovKey.value = "PnsnDetailEmp" + PensionDetailRepForm.screenName.value + "U";
//        PensionDetailRepForm.queryParam.value="txtSiteCode="+ PensionDetailRepForm.loginLocCode.value +" " ; 
//        PensionDetailRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName,Payroll.common.SiteCode,Payroll.common.SiteDesc,Payroll.common.UserFlag";
//        PensionDetailRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode,txtSiteCode,txtSiteDesc,txtUserFlag,txtEmpType";
//        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PensionDetailRepForm');
//        return true;
//}
function ShowLovEmpNo()
{
       // PensionDetailRepForm.screenName.value="PensionDetailReport";
        PensionDetailRepForm.lovKey.value = "PnsnDetailEmp" + PensionDetailRepForm.screenName.value + "U";
        PensionDetailRepForm.queryParam.value="txtSiteID="+ PensionDetailRepForm.loginLocCode.value +" " ; 
        PensionDetailRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
        PensionDetailRepForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PensionDetailRepForm');
        return true;
}
function chk_YearMonth(input)
{      
    var  yearM = document.getElementById(input).value;
	if(yearM == "") return true;
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 4)
        {        
            alert(" Year should be a four digit Number");
            document.getElementById(input).focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
     /*   else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById(input).focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;
        } */
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

function chk_CPFYearMonth()
{
      PensionDetailRepForm.butInsert.disabled="true";
      var  EmpYYM = document.getElementById("txtCPFDDYYMM").value; 
      var searchIndex = parseInt(EmpYYM.indexOf("@"),10);
      var cpfNo=EmpYYM.substring(0,searchIndex);
      var dob=EmpYYM.substring(searchIndex+1,EmpYYM.length);
      
     if (searchIndex < 0)
        {
            alert("Invalid AccessKey!!!!!");
      document.getElementById("txtCPFDDYYMM").value=""; 
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
            return false;
    
        }
        
         if (dob.length != 8)
        {  
            alert("DOB should be a Eight digit Number");    
      document.getElementById("txtCPFDDYYMM").value=""; 
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }
      validateUser();
   return true;
}
function validateUser()
{

  PensionDetailRepForm.headerDataChanged.value="true";
  PensionDetailRepForm.screenMode.value="N";
  PensionDetailRepForm.action = "../../../ValidateUserSaveActionPension.do";
  PensionDetailRepForm.submit();
 res=document.getElementById("txtResult").value;

if(res==""||res=="Invalid")
{
document.getElementById("payslipbtnclm").disabled="true";
}
else if(res=="correct"){
document.getElementById("payslipbtnclm").disabled="false";
}
else
{
}
}

function disableBtn()
{
document.getElementById("payslipbtnclm").disabled="true";
}
</script>
