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
  <html:form  action="ReportLinkerAction" name="DPSWageRepForm" type="FCIPAY.Payroll.WEBTIER.Form.DPSWageRepForm" scope="session" >
  <bean:define id="ParentForm" name="DPSWageRepForm" toScope="request" />  
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
 <!--     <TD  colSpan=12 class=mainHeader height=10>MONTHLY INCENTIVE REPORT</TD>   -->
   <% String strEmpLbrFlg=(String)session.getAttribute("hdnEmpLbrFlag");
      if (strEmpLbrFlg.equals("L")){
    %>      
      <TD  colSpan=11 class=mainHeader height=10>MONTHLY INCENTIVE REPORT </td>
    <% }else{%>       
      <TD  colSpan=11 class=mainHeader height=10>MONTHLY ACTUAL WORK DONE REPORT </td>
    <%}%>  
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
            <!--  <TD class=subHeader colspan=6>Monthly Incentive Report</TD>  -->
            <% if (strEmpLbrFlg.equals("L")){
             %>      
      <TD  class=subHeader colspan=6>Monthly Incentive Report </td>
    <% }else{%>       
      <TD  class=subHeader colspan=6>Monthly Actual Work Done Report </td>
    <%}%>
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
                  <tr height="10">
                    <td width="100%" colspan=2>
                      <TABLE cellspacing="5" cellPadding="0" border=0 >
                        <tr width="100%">
                          <td width="40%" class="radioTextRight" align="right" ><input type="radio" name="radioEmp" id="radioEmp" value="E" CHECKED onclick="EmpWiseClick()" >Employee Wise</td>         
                          <td width="10%">&nbsp;</td>                          
                          <td width="10%" class="radioTextCenter" align="left"><input type="radio" name="radioGang" id="radioGang" value="G" onclick="GangWiseClick()" >Gang Wise</td>            
                          <td width="40%">&nbsp;</td>
                        </tr>                      
                      </table>
                    </td>               
                  </TR>                  
                  
                  <TR height=25 id="EmpInfoRow">         
                    <!-- Detail table Container starts -->                    
                    <TD class=labelText width="40%" ><bean:message key="Payroll.PaySlip.EmpNumber" /></td>
                    <td  align="left" ><html:text  property="txtEmp" maxlength="10" size="16" styleClass="optional"  readonly="true" />
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
                    onclick="return ShowLovEmpNo();" >                       
                    <html:text property="txtEmpName"  size="40" value="" styleClass="locked" readonly="true" /></td>
                    </td>                           
                                      
                  </tr>  
                  
                  <TR height=25 id="GangInfoRow" >         
                    <!-- Detail table Container starts -->                    
                    <td class="labelText">Gang Name</td>
                    <td>
                    <html:text  property="txtGangName" maxlength="10" size="26" styleClass="optional" readonly="true" />                    
                    <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
                    <html:hidden property="hdnGangId" />
                    <html:hidden property="hdnMou" />
                    </td>                         
                                      
                  </tr>
                  
                  <TR height=25>         
                    <!-- Detail table Container starts -->
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.PaySlip.Year" /></td><td >
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
              <td  bgcolor=#4682b4><html:button value='GENERATE REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
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
  
if(mandatory_Check('DPSWageRepForm'))
{
    var winurl="incentives.rdf&P_pay_YYMM="+DPSWageRepForm.txtYYMM.value+"&P_EMP_NUM="+DPSWageRepForm.txtEmp.value+"&P_GANG_ID="+DPSWageRepForm.hdnGangId.value+"&P_LBR_TYPE="+DPSWageRepForm.txtLbrType.value+"&P_SITE_ID="+DPSWageRepForm.loginLocCode.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.DPSWageRepForm.submit();
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="DPSWageRepForm"  property="screenMode"/>
    <html:hidden name="DPSWageRepForm"  property="screenName" value="DPSWageReport" />
    <html:hidden property="buttonFlag" name="DPSWageRepForm"  />       
    <html:hidden property="lovKey" name="DPSWageRepForm"  />
    <html:hidden property="txtFields" name="DPSWageRepForm"  />   
    <html:hidden property="txtSearchFields" name="DPSWageRepForm"  />
    <html:hidden property="txtDisplayFields" name="DPSWageRepForm"  />
    <html:hidden property="txtIndex" name="DPSWageRepForm"  />
    <html:hidden property="txtLbrType" name="DPSWageRepForm"  />
    <html:hidden property="txtCpfCode" name="DPSWageRepForm"  />             <!-- added by dushyant 0n 17-02-2011 -->
    <html:hidden property="loginLocCode" name="DPSWageRepForm"  />
    <input type="hidden" name="queryParam" />    
	<input type="hidden" id="submitParam" name="submitParam" />     
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(DPSWageRepForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;  
  disableMenu();
  if(document.getElementById("radioEmp").checked)
  {
    document.getElementById("EmpInfoRow").style.display="";
    document.getElementById("GangInfoRow").style.display="none";
  }else
  {
    document.getElementById("EmpInfoRow").style.display="none";
    document.getElementById("GangInfoRow").style.display="";
  }
  if(DPSWageRepForm.hdnEmpLbrFlag.value=='D')
    DPSWageRepForm.txtLbrType.value='DPS';
  else
    DPSWageRepForm.txtLbrType.value='DEP';
  if(mode != 'Q' )
  {
    DPSWageRepForm.action="../../../DPSWageRepGetAccess.do"
    DPSWageRepForm.submit();  
  }
}

function ShowLovYYMM()
{
        DPSWageRepForm.queryParam.value="hdnMaxYYMM="+ DPSWageRepForm.hdnMaxYYMM.value +" " ;    
        DPSWageRepForm.lovKey.value = "ReportGeneratePaySlipYear" + DPSWageRepForm.screenName.value + "U";
        DPSWageRepForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        DPSWageRepForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','DPSWageRepForm');

        
        return true;
}

function ShowLovEmpNo()
{
        DPSWageRepForm.lovKey.value = "DPSWageRepEmp" + DPSWageRepForm.screenName.value + "U";
        DPSWageRepForm.queryParam.value="txtSiteID="+ DPSWageRepForm.loginLocCode.value +",hdnEmpLbrFlag="+DPSWageRepForm.hdnEmpLbrFlag.value ; 
        DPSWageRepForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
        DPSWageRepForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','DPSWageRepForm');
        return true;
}

function ShowLovGang()
{
       DPSWageRepForm.lovKey.value = "LbrGangList" + DPSWageRepForm.screenName.value + "Q";
       DPSWageRepForm.queryParam.value="txtSiteID="+ DPSWageRepForm.loginLocCode.value +",hdnEmpLbrFlag="+DPSWageRepForm.txtLbrType.value ;           
       DPSWageRepForm.txtDisplayFields.value = "hdnGangId,txtGangName,hdnMou";
       DPSWageRepForm.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
       DPSWageRepForm.txtIndex.value="";              
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'DPSWageRepForm');
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

function GangWiseClick() 
{
    document.getElementById("radioGang").checked=true;
    document.getElementById("radioEmp").checked=false;
    document.getElementById("EmpInfoRow").style.display="none";
    document.getElementById("GangInfoRow").style.display="";
}

function EmpWiseClick() 
{
    document.getElementById("radioGang").checked=false;
    document.getElementById("radioEmp").checked=true;
    document.getElementById("EmpInfoRow").style.display="";
    document.getElementById("GangInfoRow").style.display="none";
    
}

</script>
