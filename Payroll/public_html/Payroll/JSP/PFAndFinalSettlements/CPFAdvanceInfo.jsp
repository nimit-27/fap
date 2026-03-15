<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />  
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>      
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>      
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="CPFAdvancePayment" name="frmCPFFinalPayForm" type="FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm">
<bean:define id="ParentForm" name="frmCPFFinalPayForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE CPF ADVANCE INFORMATION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
            <!--General Information Row Starts -->
            <TR>
              <TD class=subHeader colspan=6> Detail Information Of Employee</TD>
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="6"></td>
            </tr>           
            
            <tr></tr>
            <table  cellSpacing=0 cellPadding=0 border=0> 
            
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" colspan="5">
                  <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">                   
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual>                                                                                      
                  <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td> 
              </TR> 
                                
              <TR>              
                  <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>                  
                  </td>
                  
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCateg" styleClass="locked" readonly="true" size="23"/>
                  </td>                                                                        
              </tr>
                      
              <tr> 
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                    
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="7" size="23" styleClass="locked"  style="text-align:Left" readonly="true"  /></td>                                                                  
              </tr>
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td><html:text  property="txtPresentPOP" altKey="pay.EmpInfo.PresentPOP" maxlength="7" size="23" styleClass="locked"  style="text-align:left" readonly="true"  />                  
                  </td>                                                            
                  
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.StaffCode" /> </td>            
                  <td>
                  <html:text  property="txtStaffCode" altKey="Payroll.EmpInfo.StaffCode" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>    
      
              <tr>
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text  property="txtEmpStatus" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td> 
				  
				  <!-- added by gagan on 23-04-2013-->
				  <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
				  <td width="23%" class=labelText  >System Sanction number </td>                            
                  <td ><html:text  property="txtSysSantionNum" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td> 
				  </logic:notEqual> 
				  <!-- added by gagan on 23-04-2013-->
              </tr>
   
            </table>     
          </tr>            
      <tr height="15" >
      <td colspan="6"></td>
    </tr>                                 
  </table>
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	 <TR height="100">
      <TD colspan=6>
      <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>CPF Advance Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                  
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
           
          <tr height="10"><td class=userText colspan="14"></td></tr>            
          <TR height=10>
 <!-- Detail table Container starts -->
            <TD colspan=14>
              <TABLE cellSpacing=0 cellPadding=0 border=0>
                <TBODY>
                  <TR>
                    <TD >
  			<!-- Detail table starts -->
                     <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>                          
                          <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.EmpContri" /></td>
                          <td >
                          <html:text  property="empContri" styleClass = "locked" alt="<%=String.valueOf(i) %>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                          </td>                                                   
                          
                          <td width="23%" class=labelText><bean:message key="Payroll.EmpInfo.EmplyrContri" /></td>
                          <td >
                          <html:text  property="emplyrContri" styleClass = "locked" alt="<%=String.valueOf(i) %>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                          </td>
                        </tr>
                          <tr>
                          <td width="23%" class=labelText><bean:message key="Payroll.EmpInfo.VpfContri" /></td>
                          <td >
                          <html:text  property="vpfContri" styleClass = "locked" alt="<%=String.valueOf(i) %>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                          </td>
                          
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.InvNum" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="txtInvID" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                        </tr> 
                        
                        <tr>  
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.ReasonAdv" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:select property="txtReason" styleClass="required" onchange="calcMaxAmt()" >
                          <html:option value="" >---------Please Select---------</html:option>      
                              <logic:present name="CPFFinalPayComboVO">
                                <html:optionsCollection label="label" value="value" property="advReasonList" name="CPFFinalPayComboVO"/>
                              </logic:present>
                          </html:select>                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:select property="txtReason" styleClass="locked" disabled="true">
                          <html:option value="" >---------Please Select---------</html:option>      
                              <logic:present name="CPFFinalPayComboVO">
                                <html:optionsCollection label="label" value="value" property="advReasonList" name="CPFFinalPayComboVO"/>
                              </logic:present>
                          </html:select>
                          </logic:notEqual>
                          </td>
                           <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.ApplAmt" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="txtApplAmt" altKey="Payroll.EmpInfo.sancOrderNo" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </logic:equal> 
                           <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                            <html:text  property="txtApplAmt" altKey="Payroll.EmpInfo.sancOrderNo" maxlength="25" size="23" styleClass="locked" readonly="true"/> 
                             </logic:notEqual>
                          </td>
                        </tr> 
                        
                        <tr>  
                           <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.sancOrderNo" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="sancOrderNo" altKey="Payroll.EmpInfo.sancOrderNo" maxlength="25" size="23" styleClass="required" />                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:text  property="sancOrderNo" altKey="Payroll.EmpInfo.sancOrderNo" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </logic:notEqual>
                          </td>
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.SancDate" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="sancDate" altKey="Payroll.EmpInfo.SancDate" maxlength="25" size="23" styleClass="required" readonly="true" />
                          <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="sancDate" alt="<%=(i-1) %>" onclick="showCalendar('sancDate',this)" />                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:text  property="sancDate" altKey="Payroll.EmpInfo.SancDate" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </logic:notEqual>
                          </td>
                        </tr>
                        <tr>
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.SancAmnt" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="sancAmount" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode!=46 || event.keyCode > 57))return false;" onchange="checkSancAmt();calcIntInstall();" />                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:text  property="sancAmount" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </logic:notEqual>
                          </td>
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.LoanDtls.noofPrincInstall" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="noInstallAmt" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" onchange="checkInstallAmt();calcIntInstall();" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" styleClass="required" />                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:text  property="noInstallAmt" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </logic:notEqual>
                          </td>
                        </tr> 
                        
                         <tr>
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.LoanDtls.installAmnt" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="installAmt" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" onchange="checkInstallAmt()" onkeypress="if((event.keyCode < 48 && event.keyCode!=46 || event.keyCode > 57))return false;" styleClass="required" />                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:text  property="installAmt" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </logic:notEqual>
                          </td>
                          
                           <TD width="23%" class=labelText  ><bean:message key="Payroll.LoanDtls.firstLoanAmnt" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="firstInstall" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" onchange="checkInstallAmt()" onkeypress="if((event.keyCode < 48 && event.keyCode!=46 || event.keyCode > 57))return false;" styleClass="required" />                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:text  property="firstInstall" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </logic:notEqual>
                          </td>
                          
                      </tr>
                               
                        <tr>
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.LoanDtls.intInstallAmnt" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="intInstall" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                        
                          <td width="23%" class=labelText><bean:message key="Payroll.LoanDtls.noofIntInstall" /></td>
                          <td >
                          <html:text  property="noIntInstall" styleClass = "locked" alt="<%=String.valueOf(i) %>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                          </td>                       
                        </tr>
                        
                        <tr>                        
                          <td width="23%" class=labelText><bean:message key="Payroll.LoanDtls.recStartDate" /></td>
                          <td >
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="recoveryYYMM" styleClass = "locked" alt="<%=String.valueOf(i) %>" maxlength="6" size="23" style="text-align:left" readonly="true" onchange="return chk_YearMonth()" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  />                             
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:text  property="recoveryYYMM" styleClass = "locked" alt="<%=String.valueOf(i) %>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                          </logic:notEqual>                          
                          <td class=labelText  ><bean:message key="Payroll.LoanDtls.claimReqId"/></TD>
                            <td >                  
                            <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="Q">                              
                                <html:text property="claimReqId" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="butclaimReqId" onclick="ShowLovClaimReqId();" >
                            </logic:notEqual>                                                                                                 
                            <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="Q">                              
                                <html:text property="claimReqId" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                            </logic:equal>
                            </td>  
                          <logic:notEqual property="cancelStatus" name="frmCPFFinalPayForm" value="">
                          <td width="23%" class=labelText>Cancel Status</td>
                          <td >
                            <html:text  property="cancelStatus" styleClass = "locked" alt="<%=String.valueOf(i) %>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                          </td> 
                          </logic:notEqual>
                        </tr>
                        
                        <tr height = 3><td>&nbsp;</td></tr>                    
                      </TBODY>
                    </TABLE>
                  </TD>
                </TR>                     
             </TBODY>
            </TABLE>
          </td>
       </tr>       
    <!-- Tab table Row 3 starts -->
    </TABLE>
  </td>
	</tr>
<!-- Tab Table Ends -->
<!-- Bottom Blue Bar -->
      <TR>
        <td align=center bgcolor=#4682b4 width="40%"></td>
        <td  bgcolor=#4682b4>
        <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
          <html:button property="butSanc" value="Generate Sanction Order" onclick="doGetSanc()" />&nbsp;&nbsp;&nbsp;&nbsp;
        </logic:equal>
        <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="U">
        <logic:equal property= "txtInvID" name= "frmCPFFinalPayForm" value="">
          <logic:equal property="cancelStatus" name="frmCPFFinalPayForm" value="">
            <html:button property="butCancelSanc" value="Cancel Sanction Order" onclick="doCancelSanc()" />&nbsp;&nbsp;&nbsp;&nbsp;
          </logic:equal>
          <logic:notEqual property="cancelStatus" name="frmCPFFinalPayForm" value="">
            <html:button property="butCancelSanc" value="Cancel Sanction Order" onclick="doCancelSanc()" disabled="true" />&nbsp;&nbsp;&nbsp;&nbsp;
          </logic:notEqual>
        </logic:equal>
        <logic:notEqual property= "txtInvID" name= "frmCPFFinalPayForm" value=""> 
          <html:button property="butCancelSanc" value="Cancel Sanction Order" onclick="doCancelSanc()" disabled="true" />&nbsp;&nbsp;&nbsp;&nbsp;
        <html:button property="butCancelInv" value="Cancel Advance Invoice" onclick="doCancelInv()" />&nbsp;&nbsp;&nbsp;&nbsp;

        </logic:notEqual>
        </logic:equal>
        
         <logic:notEqual property= "txtSysSantionNum" name= "frmCPFFinalPayForm" value="">
            <html:button property="reportButton" value="Generate Report" onclick="doGetReport()"  />&nbsp;&nbsp;&nbsp;&nbsp;
        </logic:notEqual>
        
        <logic:notEqual property= "txtSysSantionNum" name= "frmCPFFinalPayForm" value="">
		<logic:equal property="cancelStatus" name= "frmCPFFinalPayForm" value="">
          <logic:equal property= "txtInvID" name= "frmCPFFinalPayForm" value="">
              <html:button property="releaseButton" value="Release Payment" onclick="doRelease()"  />&nbsp;&nbsp;&nbsp;&nbsp;
           </logic:equal> 
		 </logic:equal> 
        </logic:notEqual>    
        </td>

        <td bgColor=#4682b4></td>
        <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
      </TR>
	
  </TABLE> 
<!-- Container Table Ending Columns Starts-->
  </TD>
    
</TR>
</TBODY>
</TABLE>

</div>


<!-- Container Table Ends -->
<html:hidden name="frmCPFFinalPayForm"  property="screenName" value="CPFAdvanceScreen" />
<html:hidden name="frmCPFFinalPayForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmCPFFinalPayForm" />
<html:hidden property="loginLocCode" name="frmCPFFinalPayForm" />
<html:hidden property="positionRequested" name="frmCPFFinalPayForm" />
<html:hidden property="userPositionRequested" name="frmCPFFinalPayForm" />
<html:hidden property="buttonFlag" name="frmCPFFinalPayForm"  />
<html:hidden property="lovKey" name="frmCPFFinalPayForm"  />
<html:hidden property="txtFields" name="frmCPFFinalPayForm"  />   
<html:hidden property="txtSearchFields" name="frmCPFFinalPayForm"  />
<html:hidden property="txtDisplayFields" name="frmCPFFinalPayForm"  />
<html:hidden property="txtIndex" name="frmCPFFinalPayForm"  />
<html:hidden property="txtInputField" name="frmCPFFinalPayForm"  />
<html:hidden property="hdnSancType" name="frmCPFFinalPayForm" value="A" />
<html:hidden  property="withdrEmpContri" name="frmCPFFinalPayForm" />
<html:hidden  property="withdrEmplyrContri" name="frmCPFFinalPayForm" />
<html:hidden  property="withdrVpfContri" name="frmCPFFinalPayForm" />
<html:hidden  property="hdnAction" name="frmCPFFinalPayForm" />
<html:hidden property="txtSysSantionNum" name="frmCPFFinalPayForm"  />  <!-- added by gagan for new sanction number-->
<html:hidden property="headerPrimaryKey" name="frmCPFFinalPayForm"  />
<html:hidden property="txtApplAmt" name="frmCPFFinalPayForm" />
<input type="hidden" name="queryParam" />
<input type="hidden" id="submitParam" name="submitParam" /> 

</html:form>
</body>
</html:html>

<% ReportReader oReportReader=new ReportReader(); %> 
<% ParamUtil oParamUtil=new ParamUtil(); %> 

<script language="javascript">

function doRelease()
{
   document.all.releaseButton.disabled="true";
    document.all.butCancelSanc.disabled="true";
  //document.all.butRelease.disabled="true";
  //document.all.hdnRecYYMM.value = document.getElementsByName("txtRecYYYYMM").value;
  //alert('hdnRecYYMM '+document.all.hdnRecYYMM.value);
 // if(document.all.hdnSancType.value=='P')
  //alert(' dedIT '+document.getElementsByName("dedITDtl")[i-1].value)
// document.all.txtDedIT.value=document.getElementsByName("dedITDtl")[i-1].value;
  document.all.hdnAction.value="relCPFPay";
  frmCPFFinalPayForm.action="../../../CPFAdvReleasePayment.do";
  frmCPFFinalPayForm.submit();
}
function doGetReport()
{  
    var winurl="CPF_Advance_Sanction.rdf&sanc_num="+frmCPFFinalPayForm.headerPrimaryKey.value;
	document.getElementById('reportButton').value="Please wait. File is being downloaded..";
	document.getElementById('reportButton').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.frmCPFFinalPayForm.action="../../../ReportLinkerAction.do";
	document.frmCPFFinalPayForm.submit();
}
 
function ShowEmpNum()
{
    frmCPFFinalPayForm.lovKey.value = "EmpCpf" + frmCPFFinalPayForm.screenName.value + frmCPFFinalPayForm.screenMode.value;    
    if(document.all.screenMode.value=='N')
    {
      frmCPFFinalPayForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCateg,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtStaffCode,empContri,emplyrContri,vpfContri";
    }
    else
    {
      frmCPFFinalPayForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
    }
    frmCPFFinalPayForm.queryParam.value = "txtSiteID="+frmCPFFinalPayForm.loginLocCode.value+",hdnEmpLbrFlag="+frmCPFFinalPayForm.hdnEmpLbrFlag.value+",hdnSancType="+frmCPFFinalPayForm.hdnSancType.value;
    frmCPFFinalPayForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
    frmCPFFinalPayForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmCPFFinalPayForm');
    return true;
}

function lfnLoad()
{
    mode = document.all.screenMode.value;    
    if(mode == '')
    {
        doQueryMode();
    }    
    if(mode=='U')
    {        
        document.all.txtCateg.disabled = "true";
        //document.all.txtDsgn.disabled = "true";      
        //document.all.txtEmpNo.disabled = "true";          
    }
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    hedMenuHandling(mode);    
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.action="../../../CPFAdvanceQueryMode.do"
    frmCPFFinalPayForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmCPFFinalPayForm.action="../../../CPFAdvanceRefresh.do"
    frmCPFFinalPayForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.action="../../../CPFAdvanceNewMode.do"
    frmCPFFinalPayForm.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmCPFFinalPayForm.action="../../../CPFAdvanceGetHeaderAction.do"
    frmCPFFinalPayForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.userPositionRequested.value = 1*frmCPFFinalPayForm.positionRequested.value + 1;
    frmCPFFinalPayForm.action="../../../CPFAdvanceGetNextHeader.do";
    frmCPFFinalPayForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.userPositionRequested.value = 1*frmCPFFinalPayForm.positionRequested.value - 1;
    frmCPFFinalPayForm.action = "../../../CPFAdvanceGetPrevHeader.do";
    frmCPFFinalPayForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.userPositionRequested.value = 1*frmCPFFinalPayForm.newPositionRequested.value;
    frmCPFFinalPayForm.action = "../../../CPFAdvanceGetNextHeader.do";
    frmCPFFinalPayForm.submit();
}

function doGetSanc()
{
  if(mandatory_Check("frmCPFFinalPayForm"))
  {
    document.all.butSanc.disabled = "true";
    frmCPFFinalPayForm.headerDataChanged.value="true";
    frmCPFFinalPayForm.action = "../../../CPFAdvanceSaveAction.do";
    frmCPFFinalPayForm.submit();
  }
}

function doCancelSanc()
{
  if(mandatory_Check("frmCPFFinalPayForm"))
  {
    document.all.releaseButton.disabled="true";
    document.all.butCancelSanc.disabled="true";
    frmCPFFinalPayForm.headerDataChanged.value="true";
    frmCPFFinalPayForm.action = "../../../CPFAdvanceSaveAction.do";
    frmCPFFinalPayForm.submit();
  }
}

function checkSancAmt()
{
  var sancAmt=document.all.sancAmount.value==""?0:parseInt(document.all.sancAmount.value,10);
  var applAmt=document.all.txtApplAmt.value==""?0:parseInt(document.all.txtApplAmt.value,10);
    var noInstallAmt=document.all.noInstallAmt.value==""?0:parseInt(document.all.noInstallAmt.value,10);
  var installAmt=document.all.installAmt.value==""?0:parseInt(document.all.installAmt.value,10);
  var firstInstall=document.all.firstInstall.value==""?0:parseInt(document.all.firstInstall.value,10);
  var calcAmt=firstInstall+(noInstallAmt-1)*installAmt;

 // var empContr=document.all.empContri.value==""?0:parseInt(document.all.empContri.value,10);
//  var emplyrContri=document.all.emplyrContri.value==""?0:parseInt(document.all.emplyrContri.value,10);
//  var vpfContri=document.all.vpfContri.value==""?0:parseInt(document.all.vpfContri.value,10);
//  var totAmt=vpfContri+empContr+emplyrContri;
  if(applAmt<sancAmt)
  {
      alert("Sanction Amount cannot be grater than the Maximum Applicable Amount");
      document.all.sancAmount.value="";
      return false;
  }
  if(installAmt!=0&&firstInstall!=0&&calcAmt!=sancAmt)
  {
      alert("Please Enter the correct Sanction Amount");
      document.all.sancAmount.value='';
      document.all.installAmt.value='';
      document.all.firstInstall.value='';
      document.all.noInstallAmt.value='';
      document.all.intInstall.value='';
      document.all.noIntInstall.value='';
      document.all.recoveryYYMM.value='';

      return false;

  }
   
}

function checkInstallAmt()
{
  if(document.all.sancAmount.value=="" || document.all.noInstallAmt.value=="" || document.all.installAmt.value==""|| document.all.firstInstall.value=="")
  {
    return true;
  }
  var sancAmt=document.all.sancAmount.value==""?0:parseInt(document.all.sancAmount.value,10);
  var noInstallAmt=document.all.noInstallAmt.value==""?0:parseInt(document.all.noInstallAmt.value,10);
  var installAmt=document.all.installAmt.value==""?0:parseInt(document.all.installAmt.value,10);
  var firstInstall=document.all.firstInstall.value==""?0:parseInt(document.all.firstInstall.value,10);
  var calcAmt=firstInstall+(noInstallAmt-1)*installAmt;
  if(noInstallAmt==1)
  {

    if(sancAmt!=firstInstall || installAmt!=firstInstall)
    {
      alert("Please Enter the correct installment Amount");
      document.all.installAmt.value='';
      document.all.firstInstall.value='';
      return false;
    }
  }else if(noInstallAmt >1)
  {
    if(installAmt==0)
    {
      alert("Installment amount cannot be 0");
      document.all.installAmt.value='';
    }
  }
  if(sancAmt!=calcAmt)
  {
      alert("Please Enter the correct installment Amount");
      document.all.installAmt.value='';
      return false;
  }
}

function calcMaxAmt()
{
  if(document.all.txtEmpNo.value=='')
  {
    alert("Please Select an Employee First");
    document.all.noInstallAmt.value='';
    return false;
  }
  frmCPFFinalPayForm.hdnAction.value="getAdvAmt";
  frmCPFFinalPayForm.action = "../../../CPFAdvanceGetAmtAction.do";
  frmCPFFinalPayForm.submit();
}

function calcIntInstall()
{
   if(document.all.sancAmount.value=='' || document.all.noInstallAmt.value=='')
  {
    //alert("Please Enter Sanction Amount First");
    //document.all.txtReason.value='';
    return false;
  }
  frmCPFFinalPayForm.hdnAction.value="getIntInst";
  frmCPFFinalPayForm.action = "../../../CPFAdvanceGetAmtAction.do";
  frmCPFFinalPayForm.submit();
}

function chk_YearMonth()
{      
    var  yearM = document.getElementById("recoveryYYMM").value;          
    var month =  yearM.substring(4,6);    
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementById("recoveryYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("recoveryYYMM").focus();                     
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
//added by arvind
function doCancelInv() 
{
  if(mandatory_Check("frmCPFFinalPayForm"))
  { 
   // document.all.butCancelInv.disabled="true";
   // document.all.releaseButton.disabled="true";
    frmCPFFinalPayForm.headerDataChanged.value="true";
    frmCPFFinalPayForm.action = "../../../CPFAdvanceCancelInvAction.do";
    frmCPFFinalPayForm.submit();
  }  
}

function ShowLovClaimReqId()
{
if (frmCPFFinalPayForm.txtEmpNo.value=='' || frmCPFFinalPayForm.txtEmpNo.value==null) {
    alert("Please Select Employee number !! ");
    return false;
}
else{
var screenname=frmCPFFinalPayForm.screenName.value;
   frmCPFFinalPayForm.lovKey.value = "cpfClaimReqId" + frmCPFFinalPayForm.screenName.value + frmCPFFinalPayForm.screenMode.value;    
  frmCPFFinalPayForm.txtDisplayFields.value = "claimReqId";
       frmCPFFinalPayForm.queryParam.value = "txtEmpNo="+ frmCPFFinalPayForm.txtEmpNo.value +",hdnEmpLbrFlag="+ frmCPFFinalPayForm.hdnEmpLbrFlag.value ;             
  frmCPFFinalPayForm.txtSearchFields.value = "Payroll.LoanDtls.claimReqId";
    frmCPFFinalPayForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmCPFFinalPayForm');
   return true;
}
}
</script>