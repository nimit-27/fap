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

  <BODY onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false" >
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />  
  <html:form  action="ReportLinkerAction" name="PLIRepForm" type="FCIPAY.Payroll.WEBTIER.Form.PLIPayRepForm" scope="session" >
  <bean:define id="ParentForm" name="PLIRepForm" toScope="request" />  
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
      <TD  colSpan=12 class=mainHeader height=10>PLI PAYMENT DETAIL REPORT</TD>
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
              <TD class=subHeader colspan=6>PLI Pay Report</TD>
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
                    <td  align="left" ><html:text  property="txtEmp" maxlength="10" size="16" styleClass="optional"  readonly="true" />
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                    onclick="return ShowLovEmpNo();" >                       
                    <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                    </td>                           
                                      
                  </tr>
                  <tr>
                    <td class="labelText"  width="8%" >Employee Category</td>
                    <td >
                    <html:select property="txtCtgry" titleKey="Payroll.EmpInfo.lstCateg" styleClass="optional"  style="WIDTH: 25%">
                    <html:option value="" >----Please Select----</html:option>      
                    <logic:present name="PayReportCombo">
                    <html:optionsCollection label="label" value="value" property="categList" name="PayReportCombo"/>
                    </logic:present>
                    </html:select> 
                    </td>
                  </tr>
                  
                  <tr>
                    <td class=labelText width="8%" ><bean:message key="Payroll.PLI.PLIType" /></td>
                    <td >                    
                    <html:select property="txtPLIType" alt="txtPLIType" titleKey="Payroll.PLI.PLIType" styleClass="required" style="WIDTH: 25%" >
                    <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                    <html:option value="PLIADV" > <bean:message key="Payroll.PLI.PLIAdv" /></html:option>
                    <html:option value="PLIPAY" > <bean:message key="Payroll.PLI.PLIFinPay" /></html:option>
                    </html:select>                                                                            
                    </td>    
                  </tr>
                  
                  <TR height=25>         
                    <!-- Detail table Container starts -->
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.Report.FinYear" /></td><td >
                    <html:text  property="txtYYMM"  maxlength="6" size="16" styleClass="required"  
                    onchange="                                                  
                    if(!(chk_YearMonth()))
                    {
                    }                                            
                    " 
                    
                    onblur="                                                  
                    if(!(chk_YearMonth()))
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
              <td  bgcolor=#4682b4><html:button value='GENERATE PLI REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
  if(mandatory_Check('PLIRepForm'))
  {         
      if(PLIRepForm.txtPLIType.value == 'PLIADV')
      {
        var winurl="PLI_Adv.rdf&P_FYEAR="+PLIRepForm.txtYYMM.value+"&P_EMP_NUM="+PLIRepForm.txtEmp.value+"&P_LOCATION="+PLIRepForm.loginLocCode.value+"&P_EMP_LBR="+PLIRepForm.hdnEmpLbrFlag.value+"&P_EMP_CATEGORY="+PLIRepForm.txtCtgry.value;
      }
      else
      {
        var winurl="PLI_ACT.rdf&P_FYEAR="+PLIRepForm.txtYYMM.value+"&P_EMP_NUM="+PLIRepForm.txtEmp.value+"&P_LOCATION="+PLIRepForm.loginLocCode.value+"&P_EMP_LBR="+PLIRepForm.hdnEmpLbrFlag.value+"&P_EMP_CATEGORY="+PLIRepForm.txtCtgry.value;
      }
		document.getElementById('butInsert').value="Please wait. File is being downloaded..";
		document.getElementById('butInsert').disabled="true";
		document.getElementById('submitParam').value = winurl;
		document.PLIRepForm.submit();
   }
   else{
    return false;
   }
}
</script>	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="PLIRepForm"  property="screenMode"/>
<html:hidden name="PLIRepForm"  property="screenName" value="PLIReportScreen" />
<html:hidden property="buttonFlag" name="PLIRepForm"  />        
<html:hidden property="lovKey" name="PLIRepForm"  />
<html:hidden property="txtFields" name="PLIRepForm"  />   
<html:hidden property="txtSearchFields" name="PLIRepForm"  />
<html:hidden property="txtDisplayFields" name="PLIRepForm"  />
<html:hidden property="txtIndex" name="PLIRepForm"  />  

<html:hidden property="loginLocCode" name="PLIRepForm"  />
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
    PLIRepForm.action="../../../PLIGetAccess.do"
    PLIRepForm.submit();  
  }
}

function ShowLovEmpNo()
{
  PLIRepForm.lovKey.value = "Form16Emp" + PLIRepForm.screenName.value + "U";
  PLIRepForm.queryParam.value="txtSiteID="+ PLIRepForm.loginLocCode.value +" " ; 
  PLIRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
  PLIRepForm.txtDisplayFields.value = "txtEmp,txtEmpName";
  showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PLIRepForm');
  return true;
}

function chk_YearMonth()
{      
  var  yearM = document.getElementById("txtYYMM").value;          
  var month =  yearM.substring(4,6);    
  if (num_Check(yearM,1))
  {                                     
    if (yearM.length != 6)
    {        
        alert(" Year Month should be a Six digit Number");
        document.getElementById("txtYYMM").focus();                     
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

</script>
