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
  <html:form  action="ReportLinkerAction" name="PFDetailRepForm" type="FCIPAY.Payroll.WEBTIER.Form.PFDetailRepForm" scope="session" >
  <bean:define id="ParentForm" name="PFDetailRepForm" toScope="request" />  
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
      <TD  colSpan=12 class=mainHeader height=10>ANNUAL PF DETAILS </TD>
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
              <TD class=subHeader colspan=6>Annual PF Details </TD>
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
                    <td  align="left" ><html:text  property="txtEmp" maxlength="10" size="16" styleClass="required"  readonly="true" />
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                    onclick="return ShowLovEmpNo();" >                       
                    <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                    </td>                           
                                      
                  </tr>    
                  
                  <TR height=25>         
                    <!-- Detail table Container starts -->
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.MaintPfDetail.FromYr" /></td><td >
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
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.MaintPfDetail.ToYr" /></td><td >
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
              <td  bgcolor=#4682b4><html:button value=' GENERATE ANNUAL PF DETAILS'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
	if(mandatory_Check('PFDetailRepForm'))
	{
		var winurl="online_pf_final.rdf&P_FYEAR="+PFDetailRepForm.txtFrYYYY.value+"&p_TYEAR="+PFDetailRepForm.txtToYYYY.value+"&P_EMP_NUM="+PFDetailRepForm.txtEmp.value+"&P_LOCATION="+PFDetailRepForm.loginLocCode.value;
		document.getElementById('butInsert').value="Please wait. File is being downloaded..";
		document.getElementById('butInsert').disabled="true";
		document.getElementById('submitParam').value = winurl;
		document.PFDetailRepForm.submit();
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

    <html:hidden name="PFDetailRepForm"  property="screenMode"/>
    <html:hidden name="PFDetailRepForm"  property="screenName" value="PFDetailReport" />
    <html:hidden property="buttonFlag" name="PFDetailRepForm"  />       
    <html:hidden property="lovKey" name="PFDetailRepForm"  />
    <html:hidden property="txtFields" name="PFDetailRepForm"  />   
    <html:hidden property="txtSearchFields" name="PFDetailRepForm"  />
    <html:hidden property="txtDisplayFields" name="PFDetailRepForm"  />
    <html:hidden property="txtIndex" name="PFDetailRepForm"  />
    <html:hidden property="loginLocCode" name="PFDetailRepForm"  />
    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

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
    PFDetailRepForm.action="../../../PFDetailGetAccess.do"
    PFDetailRepForm.submit();  


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
        PFDetailRepForm.queryParam.value="hdnMaxYYMM="+ PFDetailRepForm.hdnMaxYYMM.value +" " ;    
        PFDetailRepForm.lovKey.value = "ReportGeneratePaySlipYear" + PFDetailRepForm.screenName.value + "U";
        PFDetailRepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        PFDetailRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PFDetailRepForm');

        
        return true;
}

function ShowLovEmpNo()
{
        PFDetailRepForm.lovKey.value = "PFDetailEmp" + PFDetailRepForm.screenName.value + "U";
        PFDetailRepForm.queryParam.value="txtSiteID="+ PFDetailRepForm.loginLocCode.value +" " ; 
        PFDetailRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
        PFDetailRepForm.txtDisplayFields.value = "txtEmp,txtEmpName";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PFDetailRepForm');
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

</script>
