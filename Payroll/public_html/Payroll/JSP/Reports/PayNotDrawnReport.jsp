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

  <BODY  onload="lfnLoad();"  scroll=no  onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />  
  <html:form  action="ReportLinkerAction" name="PayNotDrawnRepForm" type="FCIPAY.Payroll.WEBTIER.Form.PayNotDrawnRepForm" scope="session" >
  <bean:define id="ParentForm" name="PayNotDrawnRepForm" toScope="request" />  
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
      <TD  colSpan=12 class=mainHeader height=10>PAY NOT DRAWN DETAIL REPORT</TD>
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
              <TD class=subHeader colspan=6>Pay Not Drwan Report</TD>
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
					"if(!(checkEmployee(PayNotDrawnRepForm.txtEmp.value,PayNotDrawnRepForm.loginLocCode.value)))
					{
						PayNotDrawnRepForm.txtEmp.value='';
					}"
					/>
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                    onclick="return ShowLovEmpNo();" >                       
                    <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                    </td>                           
                                      
                  </tr>    
                  
                  <TR height=25>         
                    <!-- Detail table Container starts -->
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.PaySlip.Year" /></td><td >
                    <html:text  property="txtYYMM"  maxlength="6" size="16" styleClass="optional"  
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
              <td  bgcolor=#4682b4><html:button value='GENERATE PAY NOT DRAWN REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
    var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=no,location=no,directories=no,status=no,menubar=0,titlebar=no,"+"scrollbars=yes,resizable=yes";
    var winurl="pay_not_drawn.rdf&P_YYMM="+PayNotDrawnRepForm.txtYYMM.value+"&P_EMP_NUM="+PayNotDrawnRepForm.txtEmp.value+"&P_LOCATION="+PayNotDrawnRepForm.loginLocCode.value+"&P_EMP_FLG="+PayNotDrawnRepForm.hdnEmpLbrFlag.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.PayNotDrawnRepForm.submit();
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="PayNotDrawnRepForm"  property="screenMode"/>
    <html:hidden name="PayNotDrawnRepForm"  property="screenName" value="PayNotDrawnReport" />
    <html:hidden property="buttonFlag" name="PayNotDrawnRepForm"  />       
    <html:hidden property="lovKey" name="PayNotDrawnRepForm"  />
    <html:hidden property="txtFields" name="PayNotDrawnRepForm"  />   
    <html:hidden property="txtSearchFields" name="PayNotDrawnRepForm"  />
    <html:hidden property="txtDisplayFields" name="PayNotDrawnRepForm"  />
    <html:hidden property="txtIndex" name="PayNotDrawnRepForm"  />
    <html:hidden property="txtCpfCode" name="PayNotDrawnRepForm"  />     
    <html:hidden property="loginLocCode" name="PayNotDrawnRepForm"  />
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(PayNotDrawnRepForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();
  if(mode != 'Q' )
  {
    PayNotDrawnRepForm.action="../../../PayNotDrawnGetAccess.do"
    PayNotDrawnRepForm.submit();  
  }
}

function ShowLovYYMM()
{
        PayNotDrawnRepForm.queryParam.value="hdnMaxYYMM="+ PayNotDrawnRepForm.hdnMaxYYMM.value +" " ;    
        PayNotDrawnRepForm.lovKey.value = "ReportGeneratePaySlipYear" + PayNotDrawnRepForm.screenName.value + "U";
        PayNotDrawnRepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        PayNotDrawnRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PayNotDrawnRepForm');

        
        return true;
}

function ShowLovEmpNo()
{
        PayNotDrawnRepForm.lovKey.value = "PayNotDrawnEmp" + PayNotDrawnRepForm.screenName.value + "U";
        PayNotDrawnRepForm.queryParam.value="txtSiteID="+ PayNotDrawnRepForm.loginLocCode.value +" " ; 
        PayNotDrawnRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
        PayNotDrawnRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PayNotDrawnRepForm');
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
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
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
