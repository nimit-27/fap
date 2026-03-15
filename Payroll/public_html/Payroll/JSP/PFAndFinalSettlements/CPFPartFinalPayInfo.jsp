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
<html:form  action="CPFPartFinalPay" name="frmCPFFinalPayForm" type="FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm">
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
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE CPF PART FINAL SANCTION</TD>
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
            </table>
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
	<!-- added by gagan on 26-10-2013-->
				  <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
				  <td width="23%" class=labelText  >System Sanction number </td>                            
                  <td ><html:text  property="txtSysSantionNum" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td> 
				  </logic:notEqual> 
				  <!-- ended by gagan on 03-07-2013-->			
			
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
                <td bgcolor="#4682B4" nowrap class=actTabText>CPF Part Final Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                          <html:text  property="empContri" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                          </td>                                                   
                          
                          <td width="23%" class=labelText><bean:message key="Payroll.EmpInfo.EmplyrContri" /></td>
                          <td >
                          <html:text  property="emplyrContri" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                          </td>
                        </tr>
                          <tr>
                          
                           <td width="23%" class=labelText><bean:message key="Payroll.EmpInfo.VpfContri" /></td>
                          <td >
                          <html:text  property="vpfContri" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                          </td>
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.InvNum" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="txtInvID" altKey="Payroll.EmpInfo.TDSIntIntervngPd" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
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
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.ReasonPart" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:select property="txtReason" styleClass="required" onchange="calcMaxAmt()" >
                          <html:option value="" >---------Please Select---------</html:option>      
                              <logic:present name="CPFFinalPayComboVO">
                                <html:optionsCollection label="label" value="value" property="partReasonList" name="CPFFinalPayComboVO"/>
                              </logic:present>
                          </html:select>                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:select property="txtReason" styleClass="locked" disabled="true">
                          <html:option value="" >---------Please Select---------</html:option>      
                              <logic:present name="CPFFinalPayComboVO">
                                <html:optionsCollection label="label" value="value" property="partReasonList" name="CPFFinalPayComboVO"/>
                              </logic:present>
                          </html:select>
                          </logic:notEqual>
                          </td>
                          
                           <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.ApplAmt" /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="txtApplAmt" altKey="Payroll.EmpInfo.sancOrderNo" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
                        </tr> 
                         
                        <tr>                          
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.SancAmnt" /></TD>
                          <td align="left" colspan="1">
                          <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">  
                          <html:text  property="sancAmount" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="required" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){return false;};"  onchange="return checkSancAmt()" />                                         
                          </logic:equal> 
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <html:text  property="sancAmount" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </logic:notEqual>
                          </td>

                           <TD width="23%" class=labelText  >Withdrawl from Employee Subs</TD>
						  <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <td align="left" colspan="1">
                          <html:text  property="withdrEmpContri" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="required" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){return false;};"/>                                         
                          </td> 
						  </logic:equal>
						  <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <td align="left" colspan="1">
                          <html:text  property="withdrEmpContri" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td> 
						  </logic:notEqual>
                          </tr> 
                        
                          <tr>
                          <TD width="23%" class=labelText  >Withdrawl from Employer Subs</TD>
						  <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <td align="left" colspan="1">
                          <html:text  property="withdrEmplyrContri" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="required" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){return false;};" />
                          </td>
						  </logic:equal>
						  <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <td align="left" colspan="1">
                          <html:text  property="withdrEmplyrContri" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
                          </td>
						  </logic:notEqual>

                          <TD width="23%" class=labelText  >Withdrawl from Vpf Subs</TD>
						  <logic:equal property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <td align="left" colspan="1">
                          <html:text  property="withdrVpfContri" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="required" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){return false;};"  onchange="checkWithDrwnAmt()"/>
						  </td>
						  </logic:equal>
						  <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N">
                          <td align="left" colspan="1">
                          <html:text  property="withdrVpfContri" altKey="Payroll.EmpInfo.SancAmnt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
						  </td>
						  </logic:notEqual>
                      </tr>
                      <!--<tr id="possessionRow" style="display:none">-->
                      
                      <tr >
                      <logic:notEqual property= "txtReason" name= "frmCPFFinalPayForm" value="BFRRETR">
                      <logic:notEqual property= "txtReason" name= "frmCPFFinalPayForm" value="COVID-19">
                      <logic:notEqual property= "txtReason" name= "frmCPFFinalPayForm" value="">
                     <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.PossDate"  /></TD>
                          <td align="left" colspan="1">
                          <html:text  property="possDate" altKey="Payroll.EmpInfo.PossDate" maxlength="25" size="23" styleClass="optional" readonly="true" onchange=("compareDates(this.value)")/>
                          <logic:equal property= "possDate" name= "frmCPFFinalPayForm" value="">
                          <img id="cal_id" src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="possDate" alt="<%=(i-1) %>" onclick="showCalendar('possDate',this)" />
                          <logic:notEqual property= "screenMode" name= "frmCPFFinalPayForm" value="N"> 
                          <html:button property="butUpdatePossDate" value="Update Possession Date" onclick="updatePossDate();doRefresh();" />&nbsp;&nbsp;&nbsp;&nbsp;
                          </logic:notEqual>
                          </logic:equal>
                          </td>

                    </logic:notEqual>
                    </logic:notEqual>
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
                      
                    
                    </tr>
                    <logic:notEqual property= "txtReason" name= "frmCPFFinalPayForm" value="BFRRETR">
                      <logic:notEqual property= "txtReason" name= "frmCPFFinalPayForm" value="COVID-19">
                      <logic:notEqual property= "txtReason" name= "frmCPFFinalPayForm" value="">
                    </logic:notEqual>
                    </logic:notEqual>
                    </logic:notEqual>
                   
                    
                        <tr >
                          <logic:notEqual property="cancelStatus" name="frmCPFFinalPayForm" value="">
                          <td width="23%" class=labelText>Cancel Status</td>
                          <td >
                            <html:text  property="cancelStatus" styleClass = "locked" alt="<%=String.valueOf(i)%>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
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
        <html:button property="butCancelInv" value="Cancel Part-final Invoice" onclick="doCancelInv()" />&nbsp;&nbsp;&nbsp;&nbsp;
</logic:notEqual>
        </logic:equal>
      
       <logic:notEqual property= "txtSysSantionNum" name= "frmCPFFinalPayForm" value="">
          <logic:equal property= "txtInvID" name= "frmCPFFinalPayForm" value="">
		  <logic:equal property="cancelStatus" name="frmCPFFinalPayForm" value="">
              <html:button property="releaseButton" value="Release Payment" onclick="doRelease()"  />&nbsp;&nbsp;&nbsp;&nbsp;
           </logic:equal> 
		   </logic:equal> 
        </logic:notEqual>
        
        <logic:notEqual property= "txtSysSantionNum" name= "frmCPFFinalPayForm" value="">
		<logic:equal property="cancelStatus" name="frmCPFFinalPayForm" value="">
            <html:button property="reportButton" value="Generate Report" onclick="doGetReport()"  />&nbsp;&nbsp;&nbsp;&nbsp;
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
<html:hidden name="frmCPFFinalPayForm"  property="screenName" value="CPFPartFinalPayScreen" />
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
<html:hidden property="txtEmpNo" name="frmCPFFinalPayForm"  />
<html:hidden property="hdnSancType" name="frmCPFFinalPayForm" value="P" />
<html:hidden property="noInstallAmt" name="frmCPFFinalPayForm"  />
<html:hidden property="installAmt" name="frmCPFFinalPayForm"  />
<html:hidden property="noIntInstall" name="frmCPFFinalPayForm"  />
<html:hidden property="intInstall" name="frmCPFFinalPayForm"  />
<html:hidden property="firstInstall" name="frmCPFFinalPayForm"  />
<html:hidden property="recoveryYYMM" name="frmCPFFinalPayForm"  />
<html:hidden  property="hdnAction" name="frmCPFFinalPayForm" />
<html:hidden property="txtSysSantionNum" name="frmCPFFinalPayForm"  />  <!-- added by gagan for new sanction number-->
<html:hidden property="headerPrimaryKey" name="frmCPFFinalPayForm"  />
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
    document.all.butCancelSanc.disabled="true";
    document.all.releaseButton.disabled="true";
  document.all.hdnAction.value="relCPFPay";
  frmCPFFinalPayForm.action="../../../CPFReleasePayment.do";
  frmCPFFinalPayForm.submit();
}

function doGetReport()
{  
    var winurl="cpf_part_final.rdf&sanc_num="+frmCPFFinalPayForm.headerPrimaryKey.value;
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
//alert(document.all.headerPrimaryKey.value);
    mode = document.all.screenMode.value;    
    if(mode == '')
    {
        doQueryMode();
    }    
    if(mode=='U')
    {        
        document.all.txtCateg.disabled = "true";s          
    } 
    document.all.butSave.disabled="true";    
    document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    hedMenuHandling(mode);  
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.action="../../../CPFPartFinalQueryMode.do"
    frmCPFFinalPayForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmCPFFinalPayForm.action="../../../CPFPartFinalRefresh.do"
    frmCPFFinalPayForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.action="../../../CPFPartFinalNewMode.do"
    frmCPFFinalPayForm.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmCPFFinalPayForm.action="../../../CPFPartFinalGetHeaderAction.do"
    frmCPFFinalPayForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.userPositionRequested.value = 1*frmCPFFinalPayForm.positionRequested.value + 1;
    frmCPFFinalPayForm.action="../../../CPFPartFinalGetNextHeader.do";
    frmCPFFinalPayForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.userPositionRequested.value = 1*frmCPFFinalPayForm.positionRequested.value - 1;
    frmCPFFinalPayForm.action = "../../../CPFPartFinalGetPrevHeader.do";
    frmCPFFinalPayForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmCPFFinalPayForm.userPositionRequested.value = 1*frmCPFFinalPayForm.newPositionRequested.value;
    frmCPFFinalPayForm.action = "../../../CPFPartFinalGetNextHeader.do";
    frmCPFFinalPayForm.submit();
}

function doGetSanc()
{
  if(checkWithDrwnAmt())
  {
	  if(mandatory_Check("frmCPFFinalPayForm"))
	  {
        document.all.butSanc.disabled="true";
		frmCPFFinalPayForm.headerDataChanged.value="true";
		frmCPFFinalPayForm.action = "../../../CPFPartFinalSaveAction.do";
		frmCPFFinalPayForm.submit();
	  }
  }
}

function doCancelSanc()
{
  if(mandatory_Check("frmCPFFinalPayForm"))
  {
    document.all.butCancelSanc.disabled="true";
    document.all.releaseButton.disabled="true";
    frmCPFFinalPayForm.headerDataChanged.value="true";
    frmCPFFinalPayForm.action = "../../../CPFPartFinalSaveAction.do";
    frmCPFFinalPayForm.submit();
  }
}

function checkSancAmt()
{
  var sancAmt=document.all.sancAmount.value==""?0:parseInt(document.all.sancAmount.value,10);
  var empContr=document.all.empContri.value==""?0:parseInt(document.all.empContri.value,10);
  var emplyrContri=document.all.emplyrContri.value==""?0:parseInt(document.all.emplyrContri.value,10);
  var vpfContri=document.all.vpfContri.value==""?0:parseInt(document.all.vpfContri.value,10);
  var maxAmt=document.all.txtApplAmt.value==""?0:parseInt(document.all.txtApplAmt.value,10);
  if(maxAmt<sancAmt)
  {
      alert("Sanction Amount cannot be greater than the Maximum Applicable Amount");
      document.all.sancAmount.value="";
      document.all.withdrVpfContri.value="";
      document.all.withdrEmpContri.value="";
      document.all.withdrEmplyrContri.value="";
      return false;
  }
  if(sancAmt>=vpfContri)
  {
    if(vpfContri!=0)
    {
      withdrVpfContri=vpfContri-1;
      sancAmt=sancAmt-withdrVpfContri;
    }else
    {
      withdrVpfContri=vpfContri;
      sancAmt=sancAmt-vpfContri;
    }
    if(sancAmt>=empContr)
    {
      if(empContr!=0)
      {
        withdrEmpContri=empContr-1;
        sancAmt=sancAmt-withdrEmpContri;
        withdrEmplyrContri=sancAmt;
      }else
      {
        withdrEmpContri=empContr;
        sancAmt=sancAmt-empContr;
        withdrEmplyrContri=sancAmt;
      }
    }else
    {
      withdrEmpContri=sancAmt;
      withdrEmplyrContri=0;
    }
  }else
  {
    withdrVpfContri=sancAmt;
    withdrEmpContri=0;
    withdrEmplyrContri=0;
  }
}

// added by varalika
function checkWithDrwnAmt()
{
var sancAmt=document.all.sancAmount.value==""?0:parseInt(document.all.sancAmount.value,10);
var empContr=document.all.empContri.value==""?0:parseInt(document.all.empContri.value,10);
var emplyrContri=document.all.emplyrContri.value==""?0:parseInt(document.all.emplyrContri.value,10);
var vpfContri=document.all.vpfContri.value==""?0:parseInt(document.all.vpfContri.value,10);
 
var empEntrvpfContri = document.all.withdrVpfContri.value==""?0:parseInt(document.all.withdrVpfContri.value,10);
var empEntrEmpContri = document.all.withdrEmpContri.value==""?0:parseInt(document.all.withdrEmpContri.value,10)
var empEntrEmplyrContri = document.all.withdrEmplyrContri.value==""?0:parseInt(document.all.withdrEmplyrContri.value,10);
  
var totalEntrAmt = empEntrvpfContri+empEntrEmpContri+empEntrEmplyrContri;

    if(totalEntrAmt != 0)
	{
		if(empEntrvpfContri > (0.90* vpfContri))
		{
			alert("The vpf amount to be withdrawn cannot be greater than 90% of the VPF Amount Contributed");
			document.getElementById("withdrVpfContri").select();
			return false;
		}
		else if ( empEntrEmpContri > (0.90* empContr))
		{
			alert("The Employee Contribution amount to be withdrawn cannot be greater than 90% of the Employee Contribution amount Contributed");
			document.getElementById("withdrEmpContri").select();
			return false;
		}
		else if ( empEntrEmplyrContri > (0.90* emplyrContri))
		{
			alert("The Employer Contribution amount to be withdrawn cannot be greater than 90% of the Employer Contribution amount Contributed");
			document.getElementById("withdrEmplyrContri").select();
			return false;
		}
		else if(totalEntrAmt != sancAmt)
		{
			alert("The amount to be withdrawn is not equal to the sanction amount");
			document.all.withdrVpfContri.value = "";
			document.all.withdrEmpContri.value = "";
			document.all.withdrEmplyrContri.value = "";
			return false;
		}
	}
	else
	{
		alert("Please enter a valid amount to withdraw.");
		document.all.withdrVpfContri.value = "";
		document.all.withdrEmpContri.value = "";
		document.all.withdrEmplyrContri.value = "";
		return false;
	}

return true;
}
// ended by varalika
function calcMaxAmt()
{
  if(document.all.txtEmpNo.value=='')
  {
    alert("Please Select an Employee First");
    document.all.txtReason.value='';
    return false;
  }
  if(document.all.sancDate.value=='')
  {
    alert("Please Enter Sanction Date First");
    document.all.txtReason.value='';
    return false;
  }
  
  frmCPFFinalPayForm.hdnAction.value="getAdvAmt";
  frmCPFFinalPayForm.action = "../../../CPFPartFinalGetAmtAction.do";
  frmCPFFinalPayForm.submit();
 // handleReasonChange();
}
//added by arvind
function doCancelInv() 
{
  if(mandatory_Check("frmCPFFinalPayForm"))
  { 
   // document.all.butCancelInv.disabled="true";
   // document.all.releaseButton.disabled="true";
    frmCPFFinalPayForm.headerDataChanged.value="true";
    frmCPFFinalPayForm.action = "../../../CPFPartFinalCancelInvAction.do";
    frmCPFFinalPayForm.submit();
  }  
}
function ShowLovClaimReqId()
{
var screenname=frmCPFFinalPayForm.screenName.value;
    if (frmCPFFinalPayForm.emplyrContri.value=='' || frmCPFFinalPayForm.emplyrContri.value==null)  {
        alert("Please Select Employee number !! ");
        return false;
    }
    else{
   frmCPFFinalPayForm.lovKey.value = "cpfClaimReqId" + frmCPFFinalPayForm.screenName.value + frmCPFFinalPayForm.screenMode.value;    
  frmCPFFinalPayForm.txtDisplayFields.value = "claimReqId";
       frmCPFFinalPayForm.queryParam.value = "txtEmpNo="+ document.getElementById("txtEmpNo").value +",hdnEmpLbrFlag="+ frmCPFFinalPayForm.hdnEmpLbrFlag.value ;             
  frmCPFFinalPayForm.txtSearchFields.value = "Payroll.LoanDtls.claimReqId";
    frmCPFFinalPayForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmCPFFinalPayForm');
   return true;
    }
}

function parseDdMonYyyy(dateStr) {
    var months = {
        jan: 0, feb: 1, mar: 2, apr: 3, may: 4, jun: 5,
        jul: 6, aug: 7, sep: 8, oct: 9, nov: 10, dec: 11
    };

    var parts = dateStr.split('-');
    if (parts.length !== 3) return new Date("Invalid");

    var day = parseInt(parts[0], 10);
    var monthStr = parts[1].toLowerCase();
    var year = parseInt(parts[2], 10);

    var month = months[monthStr];
    if (isNaN(day) || isNaN(year) || month === undefined) {
        return new Date("Invalid");
    }

    return new Date(year, month, day);
}
function compareDatesPossVsSanc() {
    var possStr = document.frmCPFFinalPayForm.possDate.value;
    var sancStr = document.frmCPFFinalPayForm.sancDate.value;

    var possDate = parseDdMonYyyy(possStr);
    var sancDate = parseDdMonYyyy(sancStr);
    var today = new Date();

    possDate.setHours(0, 0, 0, 0);
    sancDate.setHours(0, 0, 0, 0);
    today.setHours(0, 0, 0, 0);

    if (isNaN(possDate.getTime()) || isNaN(sancDate.getTime())) {
        alert("Invalid date format. Expected format: dd-mon-yyyy (e.g., 18-Apr-2025)");
        return false;
    }

  /*  if (possDate < sancDate) {
        alert("Possession Date cannot be earlier than Sanction Date.");
        document.frmCPFFinalPayForm.possDate.value="";
        return false;
    }*/

    if (possDate > today) {
        alert("Possession Date cannot be greater than current Date.");
        document.frmCPFFinalPayForm.possDate.value="";
        return false;
    }

    //alert("Possession Date is valid.");
    return true;
}


function compareDates(dateStr1) {
compareDatesPossVsSanc();
}
function updatePossDate(){
if (frmCPFFinalPayForm.possDate.value==""){
    alert("Please Enter Possession Date first");
    return false;
}
       
    url="../../../empDtlUpdateZone.do";
    prm="mode=2&txtEmpNo="+document.getElementById("txtEmpNo").value+
    "&screenName="+frmCPFFinalPayForm.screenName.value+
    "&processName=UpdatePossessionDate" +
    "&primaryKey="+frmCPFFinalPayForm.headerPrimaryKey.value+
    "&possession_date="+frmCPFFinalPayForm.possDate.value;
    //alert(prm);
    xml=getXML(url,prm);
    Tags=xml.getElementsByTagName("record");
        if(Tags.length > 0)
        { 
        
            var msg=Tags[0].childNodes[0].nodeValue;
      //      alert(msg);
            if (msg=="SUCCESS"){
            alert("Possession Date Updated Successfully");
            return true;
            }
            else{
                alert("Error Occured Please Contact Administrator");
                return false;
            }
        }
        else
        {
            alert("Error Occured Please Contact Administrator");
            return false;
        }
  }
</script>