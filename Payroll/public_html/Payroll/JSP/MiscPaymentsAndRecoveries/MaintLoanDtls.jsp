<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD> 
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
   
</head>
<BODY scroll=yes onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintLoanDtlsBase" name="frmMaintLoanDtls" type="FCIPAY.Payroll.WEBTIER.Form.MaintLoanDtlsForm" scope="session">
<bean:define id="ParentForm" name="frmMaintLoanDtls" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN LOAN DETAILS</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0  border = 0>
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>Header For Employee Details</TD>
        </TR>
        <TR>
            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="6"></td>
         </tr>         
                            
            
         <tr></tr>
         </tr>
         
              <table  cellSpacing=0 cellPadding=0 border=0>     
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" colspan="5" >
                  <logic:equal property= "screenMode" name= "frmMaintLoanDtls" value="N">                   
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();" readonly="true">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmMaintLoanDtls" value="N">
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required"  readonly="true"/>
                  </logic:notEqual> 
                  <logic:equal property= "screenMode" name= "frmMaintLoanDtls" value="U">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" >
                  </logic:equal>                                                                    
                  <logic:equal property= "screenMode" name= "frmMaintLoanDtls" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();" readonly="true">
                  </logic:equal>                   
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td>                  
                  
               </TR> 
               
               <tr>
                    <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /> </td>                            
                    <td ><html:text property="txtDsgn" styleClass="locked" readonly="true" size="23"/></td>                  
                    
                    <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                    <td ><html:text property="txtCateg" styleClass="locked" readonly="true" size="23"/></td> 
                    
                    <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                    <td><html:text  property="txtPresentPOP" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" styleClass="locked" readonly="true"/></td>                      
                    
                    </tr>  
                </table>     
          </tr>    
       
       <tr height="10">		    
        <TD > </TD>
      </tr>
   	 </table>
    
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=2 >

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>Loan Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="11">
                  <TABLE cellSpacing="0" cellPadding="0" >
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail" border="0">
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"    /></td>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.IntRates.loanType" /></TD>
                            <TD class=tableHeader width="12%"><bean:message  key="Payroll.LoanDtls.loanDesc" /></td>
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.LoanDtls.loanAmnt" /></TD>                            
                            <TD class=tableHeader width="10%"><bean:message  key="Payroll.LoanDtls.sanctionDate" /></td>
                            <TD class=tableHeader width="10%"><bean:message  key="Payroll.LoanDtls.sanctionNo" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.LoanDtls.recStartDate" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.LoanDtls.noofPrincInstall" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.LoanDtls.noofIntInstall" /></td>                                    
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.LoanDtls.installAmnt" /></td>                                    
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.LoanDtls.firstLoanAmnt" /></td>                                    
                            <TD class=tableHeader width="6%"><bean:message  key="Payroll.LoanDtls.intInstallAmnt" /></td>
							<TD class=tableHeader width="8%"><bean:message  key="Payroll.LoanDtls.invoiceno" /></td>
							<TD class=tableHeader width="6%"><bean:message  key="Payroll.LoanDtls.ITamt" /></td>
                          </TR>
                       
                          <logic:iterate id="LoanDtls" name="frmMaintLoanDtls" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.LoanDtlsDetailBean" >
                              <% ++i; %>
                                <logic:notEqual name="LoanDtls" property="status" value="D" >                                                        
                          
                             <tr>  <% ++j; %>
                              <td  width="1%" align="center"><html:checkbox property="checked" onclick="checkRecordCustm(this.alt);" value="false" name="frmMaintLoanDtls" alt="<%=String.valueOf(i-1)%>"  /></td>
                              <logic:equal name="LoanDtls" property="status" value="N">
								  <td  width="6%" ><html:text property="loanType" name="LoanDtls" styleClass="required"  alt="<%=String.valueOf(i)%>" style="width:70%;text-align:left" onchange="setMandatory(this.alt)" maxlength="5" readonly="true" />
								   <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=String.valueOf(i) %>" property="buttxtEmpNo"  onclick="ShowLovLoan(this.alt);" >
								  </td> 
								  <td  width="12%" ><html:text property="loanDesc" styleClass="locked"  name="LoanDtls" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>"  maxlength="50" readonly="true"/></td>
								  <td  width="6%" ><html:text property="loanAmnt" styleClass="required"  name="LoanDtls" style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>
								  <td  width="10%" ><html:text property="sanctionDate" name="LoanDtls" styleClass="required"  style="width:80%;text-align:left"  alt="<%=String.valueOf(i) %>"  maxlength="50" readonly="true" onchange="changed(this.alt);clearrecoverymnth();"  />&nbsp;<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butSanctionDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>"  id=calSwitch<%=(i-1)%> onclick="showCalendar('sanctionDate',this)"  ></td>
								  <td  width="10%" ><html:text property="sanctionNo" name="LoanDtls" styleClass="required"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>"  maxlength="50"  onchange="changed(this.alt);"  />
								  <td  width="5%" ><html:text property="recStartDate" name="LoanDtls" styleClass="required"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="6" onchange="dateValidationCheck(this.value,this.alt);"   /></td>
								  <td  width="5%" ><html:text property="noofPrnInstall" name="LoanDtls" styleClass="required"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>
								  <td  width="5%" ><html:text property="noofIntInstall" name="LoanDtls" styleClass="optional"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>"  maxlength="50" onchange="checkIntInstallNo(this.alt);lfnChange(this.value,this.alt);"  /></td>                                       
								  <td  width="6%" ><html:text property="installAmnt" name="LoanDtls" styleClass="required"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>                                       
								  <td  width="6%" ><html:text property="firstInstallAmnt" name="LoanDtls" styleClass="required"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>                                       
								  <td  width="6%" ><html:text property="intInstallAmnt" name="LoanDtls" styleClass="locked" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>"  maxlength="50" onchange="lfnChange(this.value,this.alt);"  /></td>
								  <td  width="5%" ><html:text property="invoiceNo" styleClass="locked" readonly="true" name="LoanDtls" style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>"  maxlength="50"  /></td>
								  <td  width="6%" ><html:text property="txtITAmt" name="LoanDtls" style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>" onchange="lfnChange(this.value,this.alt);" /></td>
                              </logic:equal>
                              
                              <logic:notEqual name="LoanDtls" property="status" value="N">
								  <td  width="6%" ><html:text property="loanType" name="LoanDtls" styleClass="locked"  alt="<%=String.valueOf(i) %>" style="width:70%;text-align:left" onchange="setMandatory(this.alt)" maxlength="5" readonly="true" />
								   <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=String.valueOf(i) %>" property="buttxtEmpNo" >
								  </td> 
								  <td  width="12%" ><html:text property="loanDesc" styleClass="locked"  name="LoanDtls" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>"  maxlength="50" readonly="true"/></td>
								  <td  width="6%" ><html:text property="loanAmnt" styleClass="locked"  name="LoanDtls" style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>"  maxlength="50" readonly="true" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>
								  <td  width="10%" ><html:text property="sanctionDate" name="LoanDtls" styleClass="locked"  style="width:80%;text-align:left"  alt="<%=String.valueOf(i) %>"  maxlength="50" readonly="true" onchange="changed(this.alt);"  />&nbsp;<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butSanctionDate" id=calSwitch<%=(i-1)%> onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>"  ></td>
								  <td  width="10%" ><html:text property="sanctionNo" name="LoanDtls" styleClass="locked"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>"  maxlength="50" readonly="true"  onchange="changed(this.alt);"  />
								  <td  width="5%" ><html:text property="recStartDate" name="LoanDtls" styleClass="locked"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="6" readonly="true"  onchange="if(chk_YearMonth(this.value,this.alt)) changed(this.alt);"   /></td>
								  <td  width="5%" ><html:text property="noofPrnInstall" name="LoanDtls" styleClass="locked"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" readonly="true"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>
								  <td  width="5%" ><html:text property="noofIntInstall" name="LoanDtls" styleClass="locked"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" readonly="true"  maxlength="50" onchange="lfnChange(this.value,this.alt);"  /></td>                                       
								  <td  width="6%" ><html:text property="installAmnt" name="LoanDtls" styleClass="locked"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>" readonly="true"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>                                       
								  <td  width="6%" ><html:text property="firstInstallAmnt" name="LoanDtls" styleClass="locked"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>" readonly="true"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>                                       
								  <td  width="6%" ><html:text property="intInstallAmnt" name="LoanDtls" styleClass="locked" style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>" readonly="true" maxlength="50" onchange="lfnChange(this.value,this.alt);"  /></td> 
								  <td  width="5%" ><html:text property="invoiceNo" styleClass="locked" readonly="true" name="LoanDtls" style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>"  maxlength="50"  /></td>
								  <td  width="6%" ><html:text property="txtITAmt" name="LoanDtls" readonly="true" styleClass="locked" style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>" onchange="lfnChange(this.value,this.alt);" /></td>
                              </logic:notEqual>
                              
                              <html:hidden property="itemChecked" name="LoanDtls" />
                              <html:hidden property="loanFlag" name="LoanDtls" />
                              <html:hidden property="status" alt="<%=String.valueOf(i) %>" name="LoanDtls"/>
                              <html:hidden property="transMastId" alt="<%=String.valueOf(i) %>" name="LoanDtls" />
                              
                              <html:hidden property="balInstall" name="LoanDtls"  />
                              <html:hidden property="paidInstall" name="LoanDtls"  />
                              <html:hidden property="paidAmt" name="LoanDtls"  />
                              <html:hidden property="balPrnAmt" name="LoanDtls"  />
                              <html:hidden property="intAmnt" name="LoanDtls"  />
                              <html:hidden property="balIntAmt" name="LoanDtls"  />
                              
                              <html:hidden property="detailId" name="LoanDtls" />
							   <!--Added by Varalika on 03-Oct-2011-->     
							   <html:hidden property="txtUpdatedSite"  name="LoanDtls" />         
							   <html:hidden property="txtCreationDate" name="LoanDtls" />
							   <html:hidden property="txtCreatedBy"    name="LoanDtls" />
							   <html:hidden property="txtCreatedSite"  name="LoanDtls" />
							   <html:hidden property="txtUpdationDate" name="LoanDtls" />
							   <html:hidden property="txtUpdatedBy"    name="LoanDtls" />
							   <!--ended by varalika -->
                          </tr>  
                        </logic:notEqual>
                        <logic:equal name="LoanDtls" property="status" value="D" >
                           <tr>
                              <td  width="1%" ><html:hidden property="checked" value="notchecked" /></td>
                              <td  width="8%" ><html:hidden property="loanType" name="LoanDtls" /></td>
                              <td  width="20%" ><html:hidden property="loanDesc" name="LoanDtls"  /></td>
                              <td  width="8%" ><html:hidden property="loanAmnt" name="LoanDtls"  /></td>                              
                              <td  width="12%" ><html:hidden property="sanctionDate" name="LoanDtls"  /></td>
                              <td  width="10%" ><html:hidden property="sanctionNo" name="LoanDtls"  /></td>
                              <td  width="8%" ><html:hidden property="recStartDate" name="LoanDtls"  /></td>
                              <td  width="5%" ><html:hidden property="noofPrnInstall" name="LoanDtls"  /></td>
                              <td  width="5%" ><html:hidden property="noofIntInstall" name="LoanDtls"  /></td>                                                    
                              <td  width="8%" ><html:hidden property="installAmnt" name="LoanDtls"  /></td>                                                    
                              <td  width="8%" ><html:hidden property="firstInstallAmnt" name="LoanDtls"  /></td>                                                 
                              <td  width="8%" ><html:hidden property="intInstallAmnt" name="LoanDtls"  /></td>
                                  <td  width="8%" ><html:hidden property="itemChecked" name="LoanDtls"  /></td>
                                 
							  <td  width="8%" ><html:hidden property="invoiceNo" name="LoanDtls"  /></td>
							  <td  width="8%" ><html:hidden property="txtITAmt" name="LoanDtls"  /></td>
                              <html:hidden property="itemChecked" name="LoanDtls" />
                              <html:hidden property="loanFlag" name="LoanDtls" />
                              <html:hidden property="status" alt="<%=String.valueOf(i) %>"  name="LoanDtls"/>
                              <html:hidden property="transMastId" name="LoanDtls" />
                              
                              <html:hidden property="balInstall" name="LoanDtls"  />
                              <html:hidden property="paidInstall" name="LoanDtls"  />
                              <html:hidden property="paidAmt" name="LoanDtls"  />
                              <html:hidden property="balPrnAmt" name="LoanDtls"  />
                              <html:hidden property="intAmnt" name="LoanDtls"  />
                              <html:hidden property="balIntAmt" name="LoanDtls"  />                              
                              <html:hidden property="detailId" name="LoanDtls" />
							   <!--Added by Varalika on 03-Oct-2011-->     
						      <html:hidden property="txtUpdatedSite"  name="LoanDtls" />
							  <html:hidden property="txtCreationDate" name="LoanDtls" />
							  <html:hidden property="txtCreatedBy"    name="LoanDtls" />
							  <html:hidden property="txtCreatedSite"  name="LoanDtls" />
							  <html:hidden property="txtUpdationDate" name="LoanDtls" />
							  <html:hidden property="txtUpdatedBy"    name="LoanDtls" />
							   <!--ended by varalika -->
                          </tr>  
                        </logic:equal>                                                              
                       </logic:iterate>       
                       </TBODY>
                     </TABLE>
                    </DIV>
                   </TD>
                  </TR>                                       
              <!-- Get details starts -->
              <tr>
                <td colspan=11>	
                  <jsp:include  page = "../INCLUDES/GenDetailITMenu.jsp" flush="true" />
				  <!-- changed GenDetailMenu by swapnendu on 28-Feb-2012 -->
                </TD>               
              </tr>
            </TBODY>
          </TABLE>
        </td>
      </tr>

<!-- Tab table Row 3 starts -->
      <tr>
    		<TD background="../INCLUDES/IMAGES/line_r.gif"><IMG src="../INCLUDES/IMAGES/pixel.gif" border=0></TD>
      </TR>
      <TR>
        <TD align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
      </TR>
    </TABLE>
  </td>
</tr>
<!-- Tab Table Ends -->
<!-- Bottom Blue Bar -->
    <TR>
      <td>
      <jsp:include  page = "../INCLUDES/BottomBlueBar.jsp" flush="true" />
      </td>
    </TR>	
  </TABLE> 
<!-- Container Table Ending Columns Starts-->
    </TD>    
  </TR>
</TBODY>
</TABLE>


<!-- Container Table Ends -->
<html:hidden property="totalDetailRecord" name="frmMaintLoanDtls" />
<html:hidden property="headerPrimaryKey" name="frmMaintLoanDtls" />
<html:hidden property="screenMode" name="frmMaintLoanDtls" />
<html:hidden name="frmMaintLoanDtls"  property="screenName" value="LoanDtlsScreen" />
<html:hidden name="frmMaintLoanDtls"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmMaintLoanDtls" />
<html:hidden property="userPositionRequested" name="frmMaintLoanDtls" />
<html:hidden property="pageRequested" name="frmMaintLoanDtls" />
<html:hidden property="userPageRequested" name="frmMaintLoanDtls" />
<html:hidden property="flag" name="frmMaintLoanDtls" />
<html:hidden property="loginLocCode" name="frmMaintLoanDtls" />
<input type=hidden name=queryParam>
<html:hidden property="lovKey" name="frmMaintLoanDtls"  />
<html:hidden property="txtFields" name="frmMaintLoanDtls"  />   
<html:hidden property="txtSearchFields" name="frmMaintLoanDtls"  />
<html:hidden property="txtDisplayFields" name="frmMaintLoanDtls"  />
<html:hidden property="txtInputField" name="frmMaintLoanDtls"  />
<html:hidden property="txtIndex" name="frmMaintLoanDtls"  />
<html:hidden property="buttonFlag" name="frmMaintLoanDtls"  />
 <!--Added by Varalika on 03-Oct-2011-->     
<html:hidden property="txtUpdatedSite"  name="frmMaintLoanDtls" />
<html:hidden property="txtCreationDate" name="frmMaintLoanDtls" />
<html:hidden property="txtCreatedBy"    name="frmMaintLoanDtls" />
<html:hidden property="txtCreatedSite"  name="frmMaintLoanDtls" />
<html:hidden property="txtUpdationDate" name="frmMaintLoanDtls" />
<html:hidden property="txtUpdatedBy"    name="frmMaintLoanDtls" />
<html:hidden property="txtButAction"    name="frmMaintLoanDtls" />
<!--ended by varalika -->
</html:form>
</body>
</html:html>

<script language="javascript">

function dateValidationCheck(val,alt)
{
      if(chk_YearMonth(val,alt))
      {
          recovrymonth=val;
          sanctiondt=getyrmm(document.getElementById("sanctionDate").value);
           MM=sanctiondt.substring(4,6);
          if(MM==12)
          {
              if(!((recovrymonth-sanctiondt)==89 ||(recovrymonth-sanctiondt)==0))
              {
                  alert("Recovery month can'nt more than one month from Sanction date");
                  document.all.recStartDate.value='';
                  return false;
              }
          }
          else
          {
              if(!((recovrymonth-sanctiondt)==1 ||(recovrymonth-sanctiondt)==0))
              {
                  alert("Recovery month can'nt more than one month from Sanction date");
                  document.all.recStartDate.value='';
                  return false;
              }
          }
          if(document.all.screenMode.value != 'N')changed(alt);
      }
}  

function clearrecoverymnth()
{
document.all.recStartDate.value='';
}
function ShowEmpNum()
{
   frmMaintLoanDtls.lovKey.value = "LoanDtls" + frmMaintLoanDtls.screenName.value + frmMaintLoanDtls.screenMode.value; 
   frmMaintLoanDtls.queryParam.value = "txtSiteID="+frmMaintLoanDtls.loginLocCode.value+",hdnEmpLbrFlag="+frmMaintLoanDtls.hdnEmpLbrFlag.value;
   frmMaintLoanDtls.txtInputField.value="";
   if(frmMaintLoanDtls.screenMode.value == 'N')
   {
       frmMaintLoanDtls.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCateg,txtDsgn,txtPresentPOP";      
       frmMaintLoanDtls.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
       frmMaintLoanDtls.txtIndex.value ="";      
   }
   if(frmMaintLoanDtls.screenMode.value == 'Q')
   {
     frmMaintLoanDtls.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCateg,txtDsgn,txtPresentPOP";
     frmMaintLoanDtls.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
     frmMaintLoanDtls.txtIndex.value ="";      
   }
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintLoanDtls');
   return true;
}

function ShowLovLoan(i)
{
    frmMaintLoanDtls.lovKey.value = "LoanDtlsLoanType" + frmMaintLoanDtls.screenName.value + frmMaintLoanDtls.screenMode.value; 
	
	frmMaintLoanDtls.queryParam.value = "hdnEmpLbrFlag="+frmMaintLoanDtls.hdnEmpLbrFlag.value+",screenName="+frmMaintLoanDtls.screenName.value+",screenMode="+frmMaintLoanDtls.screenMode.value+",txtSiteID="+frmMaintLoanDtls.loginLocCode.value; 
    frmMaintLoanDtls.txtDisplayFields.value = "loanType,loanDesc,loanFlag,noofPrnInstall";
    frmMaintLoanDtls.txtSearchFields.value = "";
    frmMaintLoanDtls.txtInputField.value="loanType";
    frmMaintLoanDtls.txtIndex.value =i-1;      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintLoanDtls');
    return true;
}

function lfnLoad()
{
      mode = document.all.screenMode.value;      
      var  mode1;
      mode1 = mode;
   //alert('mode '+mode);  
      if (mode == 'UG')
       mode1 = 'U';
      
      if(mode == '')
      {
          doQueryMode();
      }
      flag = document.all.flag.value;
      if(mode=='U')
      {
		  enableDisable();
		  document.all.butIncmTax.disabled="true";
		  document.all.butSendInv.disabled="true";
		  
          if(flag == 'true')
          {
            document.all.butGetDetail.disabled="true";
            document.all.butInsert.disabled="true";
            document.all.butDelete.disabled="";
          }
          else
          {
            document.all.butGetDetail.disabled="";
            document.all.butInsert.disabled="true";
            document.all.butDelete.disabled="true";
          }
      }          
      if(mode=='N')
      {
		  document.all.butIncmTax.disabled="true";
		  document.all.butSendInv.disabled="true";
          document.all.butGetDetail.disabled="true";
          document.all.butInsert.disabled="";
      }
      if(mode=='Q')
      {
		  document.all.butIncmTax.disabled="true";
		  document.all.butSendInv.disabled="true";
          document.all.butGetDetail.disabled="true";          
          document.all.butDelete.disabled="true";
          document.all.butInsert.disabled="true";
      }     
    
      menuHandling(mode);   
      //Disabling INsert Mode  and Delete Mode 
  if (frmMaintLoanDtls.hdnEmpLbrFlag.value=="E"){
//    document.all.butInsertMode.disabled="true";
//    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";' +

    disableInsert();
    }
}

function disableInsert(){
    //Disabling INsert Mode  and Delete Mode 
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butDel.disabled="true";
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
    

}

function enableDisable()
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;

	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("invoiceNo")[i].value != "")
		{
			document.getElementsByName("txtITAmt")[i].readOnly = "true";
			document.getElementsByName("txtITAmt")[i].style.background="#e0e0e0";
			document.getElementsByName("txtITAmt")[i].style.className="locked";
		}
	} 

}

function doBaseComputeIT()
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;
	
	for(i=0; i < iTr2 -1; i++)
	{
		document.getElementsByName("checked")[i].disabled = "";
		if(document.getElementsByName("checked")[i].checked)
		{
			if(document.getElementsByName("transMastId")[i].value != '')
			{
				document.getElementsByName("itemChecked")[i].value = "Y";
				frmMaintLoanDtls.txtButAction.value="IT";
				frmMaintLoanDtls.action="../../../ComputeTaxLoanAdv.do"
				frmMaintLoanDtls.submit();
			}
		}
	}
}

function doBaseSendInvoice()
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;
	
	for(i=0; i < iTr2 -1; i++)
	{
		document.getElementsByName("checked")[i].disabled = "";
		if(document.getElementsByName("checked")[i].checked)
		{
			if(document.getElementsByName("transMastId")[i].value != '')
			{
				document.getElementsByName("itemChecked")[i].value = "Y";
				frmMaintLoanDtls.txtButAction.value="SENDINVOICE";
				frmMaintLoanDtls.action="../../../ComputeTaxLoanAdv.do"
        document.all.butSendInv.disabled="true";
				frmMaintLoanDtls.submit();
			}
		}
	}
}

function checkRecordCustm(index)
{
mode = document.all.screenMode.value;  
var calSwitch = "calSwitch"+index;
var oTable = document.getElementById("Detail");
var flag=0;
 if(mode=='N')
  {
      document.all.butIncmTax.disabled="true";
      document.all.butSendInv.disabled="true";
      document.all.butGetDetail.disabled="true";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
  }
 else 
  {
      var iTr2 = oTable.rows.length;
      var i = 0;
      var fl = 0;
        
      for(i=0; i < iTr2 - 1; i++)
          {
             if(document.getElementsByName("checked")[i].checked)
             flag++;
          }
      document.all.butIncmTax.disabled="";
      document.all.butSendInv.disabled="";
      if(flag > 1)   
          {    
   
            alert("More than one record cannot be selected");
            document.getElementsByName("checked")[index].checked=false; 
             if(document.getElementsByName("invoiceNo")[index].value)
                {
                  document.all.butSendInv.disabled="true";
                  document.all.butIncmTax.disabled="true";
                  document.all.butDelete.disabled="";
                }
              else
                {
                  document.all.butSendInv.disabled="";
                  document.all.butIncmTax.disabled="";
                  document.all.butDelete.disabled="";
                }
            return false;
          }
        
    if(document.getElementsByName("invoiceNo")[index].value)
     {
        
          document.all.butSendInv.disabled="true";
          document.all.butIncmTax.disabled="true";
          document.all.butDelete.disabled="";
           if(flag==0)
          {
            document.all.butDelete.disabled="true";
          }
          
      }
    if(!document.getElementsByName("invoiceNo")[index].value)
      {
      var loantype=document.getElementsByName("loanType")[index].value;
     
          document.all.butIncmTax.disabled="";
          document.all.butDelete.disabled="";
          document.getElementsByName("loanAmnt")[index].className="required";
          document.getElementsByName("sanctionDate")[index].className="required";
          document.getElementsByName("sanctionNo")[index].className="required";
          document.getElementsByName("recStartDate")[index].className="required";
          document.getElementsByName("noofPrnInstall")[index].className="required";
          document.getElementsByName("noofIntInstall")[index].className="required";
          document.getElementsByName("firstInstallAmnt")[index].className="required";
          document.getElementsByName("intInstallAmnt")[index].className="required";
          document.getElementsByName("txtITAmt")[index].className="required";
          document.getElementsByName("installAmnt")[index].className="required";
          document.getElementsByName("loanAmnt")[index].readOnly =""; 
          document.getElementsByName("sanctionNo")[index].readOnly =""; 
          document.getElementsByName("recStartDate")[index].readOnly =""; 
          document.getElementsByName("noofPrnInstall")[index].readOnly =""; 
          document.getElementsByName("noofIntInstall")[index].readOnly =""; 
          document.getElementsByName("firstInstallAmnt")[index].readOnly =""; 
          document.getElementsByName("intInstallAmnt")[index].readOnly =""; 
          document.getElementsByName("txtITAmt")[index].readOnly =""; 
          document.getElementsByName("installAmnt")[index].readOnly =""; 
          document.getElementById(calSwitch).onclick=showCalender;
            if(loantype==60 || loantype==62 || loantype==67)
            {
               document.getElementsByName("noofIntInstall")[index].className="locked";
               document.getElementsByName("intInstallAmnt")[index].className="locked";
               document.getElementsByName("intInstallAmnt")[index].readOnly ="true"; 
               document.getElementsByName("noofIntInstall")[index].readOnly ="true"; 
            } 
         if(flag==0)
          {
            document.all.butIncmTax.disabled="true";
            document.all.butSendInv.disabled="true";
            document.all.butGetDetail.disabled="true";
            document.all.butDelete.disabled="true";
            document.getElementsByName("loanAmnt")[index].className="locked";
            document.getElementsByName("sanctionDate")[index].className="locked";
            document.getElementsByName("sanctionNo")[index].className="locked";
            document.getElementsByName("recStartDate")[index].className="locked";
            document.getElementsByName("noofPrnInstall")[index].className="locked";
            document.getElementsByName("noofIntInstall")[index].className="locked";
            document.getElementsByName("firstInstallAmnt")[index].className="locked";
            document.getElementsByName("intInstallAmnt")[index].className="locked";
            document.getElementsByName("txtITAmt")[index].className="locked";
            document.getElementsByName("installAmnt")[index].className="locked";
            document.getElementsByName("loanAmnt")[index].readOnly ="true"; 
            document.getElementsByName("sanctionNo")[index].readOnly ="true"; 
            document.getElementsByName("recStartDate")[index].readOnly ="true"; 
            document.getElementsByName("noofPrnInstall")[index].readOnly ="true"; 
            document.getElementsByName("noofIntInstall")[index].readOnly ="true"; 
            document.getElementsByName("firstInstallAmnt")[index].readOnly ="true"; 
            document.getElementsByName("intInstallAmnt")[index].readOnly ="true"; 
            document.getElementsByName("txtITAmt")[index].readOnly ="true"; 
            document.getElementsByName("installAmnt")[index].readOnly ="true"; 
           }
      }  
  }
	
	if(oTable == null)
	{
	return;
	}
	
}

function showCalender()
{

    showCalendar('sanctionDate',this);
}
function doRefresh()
{
  frmMaintLoanDtls.action="../../../LoanDtlsRefresh.do"
  frmMaintLoanDtls.submit();
}

function lfnChange(val,ind)
{     
    if (num_Check(val,1))
    {
        frmMaintLoanDtls.detailDataChanged.value = "true";      
        if ((ind) > 0)
        {
            if (document.getElementsByName("status")[ind-1].value == "Q")
                document.getElementsByName("status")[ind-1].value = "U";
        }
    }  
}

function chk_YearMonth(recVal,Ind)
{       
    var  yearM = recVal;      
    var month =  yearM.substring(4,6);      
    if (num_Check(yearM,1))
    {                                       
        if (yearM.length != 6)
        {         
            alert(" Year Month should be a Six digit Number");
            document.getElementById("recStartDate").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                    
            return false;        
        }    
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("recStartDate").focus();                     
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

function getHeaderRecord()
{
  document.all.buttonFlag.value='';
  frmMaintLoanDtls.flag.value = "false";
  document.all.butExecute.disabled="true";
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
  frmMaintLoanDtls.action="../../../LoanDtlsFirstGetHeaderAction.do"
  frmMaintLoanDtls.submit();
}

function doGetNextHeader()
{
    document.all.buttonFlag.value='';
    frmMaintLoanDtls.flag.value = "false";
    frmMaintLoanDtls.userPositionRequested.value = 1*frmMaintLoanDtls.positionRequested.value + 1;
    frmMaintLoanDtls.action="../../../LoanDtlsGetNextHeader.do";
    frmMaintLoanDtls.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmMaintLoanDtls.flag.value = "false";
  frmMaintLoanDtls.userPositionRequested.value = 1*frmMaintLoanDtls.positionRequested.value - 1;
  frmMaintLoanDtls.action = "../../../LoanDtlsGetNextHeader.do";
  frmMaintLoanDtls.submit();
}


function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmMaintLoanDtls.flag.value = "false";
  frmMaintLoanDtls.userPositionRequested.value = 1*frmMaintLoanDtls.newPositionRequested.value;
  frmMaintLoanDtls.action = "../../../LoanDtlsGetNextHeader.do";
  frmMaintLoanDtls.submit();
}

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmMaintLoanDtls.userPageRequested.value = 1*frmMaintLoanDtls.pageRequested.value - 1;
    frmMaintLoanDtls.action = "../../../LoanDtlNextDetailAction.do";
    frmMaintLoanDtls.submit();
}

function doBaseNextDetail()
{ 
    document.all.buttonFlag.value='';
    frmMaintLoanDtls.userPageRequested.value = 1*frmMaintLoanDtls.pageRequested.value + 1;
    frmMaintLoanDtls.action = "../../../LoanDtlNextDetailAction.do";
    frmMaintLoanDtls.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmMaintLoanDtls.userPageRequested.value = 1*frmMaintLoanDtls.newPageRequested.value ;
    frmMaintLoanDtls.action = "../../../LoanDtlNextDetailAction.do";
    frmMaintLoanDtls.submit();
}

function doBaseAddRow()
{  
   if(mandatory_Check("frmMaintLoanDtls") && checkIntField())
    {
        document.all.buttonFlag.value='';
        //frmMaintLoanDtls.screenMode.value = "U";  
        document.forms[0].action = "../../../LoanDtlsAddRowAction.do";     
        enableAll();      
        document.forms[0].submit();
    }
    else
    {
        return false;
    }
}


// Added by varalika on 03-Oct-2011
function doBaseShowHistory()
{

      var oTable = document.getElementById("Detail");
    
      if(oTable == null)
      {
       document.all.butHistory.disabled="true";
       return;
      }
    
      var iTr2 = oTable.rows.length;
      var i = 0;
      var f2=0;
	   var noRowSel=0;

      for(i=0; i < iTr2 - 1; i++)
      {
		   if(document.getElementsByName("checked")[i].checked)
          { 
		noRowSel =noRowSel + 1;
		  }
	  }

      for(i=0; i < iTr2 - 1; i++)
      {
           if(document.getElementsByName("checked")[i].checked)
          {          
              f2=f2+1;
		if(noRowSel == 1)
        {
              if(iTr2 <= 2)
              {
				  if(!(frmMaintLoanDtls.txtCreationDate[i].value&&frmMaintLoanDtls.txtCreatedBy[i].value&&frmMaintLoanDtls.txtCreatedSite[i].value))
				  {
				  alert("No history exists for the selected record");
				  }
				  else
				  {
				
				  alert("Record History "+"\n"
				  +"Creation Date :  "+ frmMaintLoanDtls.txtCreationDate[i].value
				  +"\n"
				  +"Created By      :  "+frmMaintLoanDtls.txtCreatedBy[i].value
				  +"\n"
				  +"Created Site    :  "+frmMaintLoanDtls.txtCreatedSite[i].value
				  +"\n"
				  +"Updation Date:  "+frmMaintLoanDtls.txtUpdationDate[i].value
				  +"\n"
				  +"Updated By     :  "+frmMaintLoanDtls.txtUpdatedBy[i].value
				  +"\n"
				  +"Updated Site   :  "+frmMaintLoanDtls.txtUpdatedSite[i].value
				  );
				}
              }
              else
              {
              if(!(frmMaintLoanDtls.txtCreationDate[i].value&&frmMaintLoanDtls.txtCreatedBy[i].value&&frmMaintLoanDtls.txtCreatedSite[i].value))
              {
              alert("No history exists for the selected record");
              }
              else
              {
              alert("Record History"+"\n"
              +"Creation Date :  "+ frmMaintLoanDtls.txtCreationDate[i].value+"\n"
              +"Created By      :  "+frmMaintLoanDtls.txtCreatedBy[i].value
              +"\n"
              +"Created Site    :  "+frmMaintLoanDtls.txtCreatedSite[i].value
              +"\n"
              +"Updation Date:  "+frmMaintLoanDtls.txtUpdationDate[i].value
              +"\n"
              +"Updated By     :  "+frmMaintLoanDtls.txtUpdatedBy[i].value
              +"\n"
              +"Updated Site   :  "+frmMaintLoanDtls.txtUpdatedSite[i].value
              );
            }
           }
          }
		  }
      }

	if(noRowSel == 0 )
	{
	       alert("Select atleast one row for history !");
           document.all.butHistory.disabled="";
           return false;
	}
    
     if(noRowSel > 1)
        {
           alert("Select only one row for history !");
           document.all.butHistory.disabled="";
           return false;
        }
        
    if(f2 == 1)
      {
          document.all.butHistory.disabled="";
        //  showHistWin('<html:rewrite page="/Payroll/JSP/COMMON/JSP/ShowHistory.jsp" />', 'frmMaintLoanDtls');
          return true;
      }
    
    if(f2 == 0)
      {
		   document.all.butHistory.disabled="";
       return false;
      }
}
//Added By Varalika Ends here

function enableAll()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
      document.getElementsByName("loanType")[i].disabled="";
      document.getElementsByName("loanDesc")[i].disabled="";
      document.getElementsByName("noofIntInstall")[i].disabled="";
      document.getElementsByName("noofPrnInstall")[i].disabled="";
      document.getElementsByName("recStartDate")[i].disabled="";
      document.getElementsByName("installAmnt")[i].disabled="";
      document.getElementsByName("firstInstallAmnt")[i].disabled="";
  }
}

function doBaseDelRow()
{/*
   var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    var strRecList='';
    for(i=0; i < iTr2 -1; i++)
    {
      document.getElementsByName("checked")[i].disabled = "";
      if(document.getElementsByName("checked")[i].checked)
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
      }
    }
  
  enableAll(); 
  document.forms[0].action = "../../../LoanDtlsDeleteRowAction.do";
  document.forms[0].submit();  */
  if (frmMaintLoanDtls.hdnEmpLbrFlag.value=="E"){
  window.alert("Record deletion is disabled as this process is integrated with HRMS. Please initiate the cancellation through HRMS.");
  }
}

function SaveRecord()
{

  if(mandatory_Check("frmMaintLoanDtls") && checkIntField())
    {
    
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
          return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;
        var strRecList='';
        for(i=0; i < iTr2 -1; i++)
        {
          document.getElementsByName("checked")[i].disabled = "";
          if(document.getElementsByName("status")[i].value=="D")
          {
            frmMaintLoanDtls.detailDataChanged.value="true";
          }
        }
        frmMaintLoanDtls.buttonFlag.value='';
        enableAll();
        document.all.butSave.disabled="true";
        document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmMaintLoanDtls.action = "../../../LoanDtlsSaveAction.do";
        frmMaintLoanDtls.submit();
    }
    else
    {
      return false;
    }
}

function GetDetail()
{
  document.all.buttonFlag.value='';
  frmMaintLoanDtls.headerPrimaryKey.value = "##";
  frmMaintLoanDtls.flag.value = "true";
  frmMaintLoanDtls.action="../../../LoanDtlsFirstGetDetailAction.do"
  frmMaintLoanDtls.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value='';
  //frmMaintLoanDtls.screenModePay1.value='N';  
  frmMaintLoanDtls.action="../../../LoanDtlsNewMode.do"
  frmMaintLoanDtls.submit();
}


function doQueryMode()
{
  document.all.buttonFlag.value='';
  frmMaintLoanDtls.action="../../../LoanDtlsQueryMode.do"  
  frmMaintLoanDtls.submit();
}

function showBankLov()
{
   frmMaintLoanDtls.lovKey.value = "BankMast" + frmMaintLoanDtls.screenName.value + frmMaintLoanDtls.screenMode.value;
   frmMaintLoanDtls.txtDisplayFields.value = "txtBankCode,hdnBankDesc";
   frmMaintLoanDtls.txtSearchFields.value = "Payroll.EmpInfo.BranchCode,Payroll.Common.desc";     
   frmMaintLoanDtls.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintLoanDtls');
   return true;
}

function changed(Ind)
{
  frmMaintLoanDtls.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[Ind-1].value == 'Q')
     document.getElementsByName("status")[Ind-1].value = 'U';
  
}

function upper(val)
{
   val.value=val.value.toUpperCase();
}

function checkIntField()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
      var payCode=parseInt(document.getElementsByName("loanType")[i].value,10);
      var intInstall=trim(document.getElementsByName("noofIntInstall")[i].value);
      if(payCode >80 && intInstall=='' )
      {
        alert("Mandatory Field No of Interest Install. Empty");
        return false;
      }
  }
  return true;
}

function setMandatory(i)
{  
   
   //added by geetika on 06-08-2014 to reset the values(start)
   document.getElementsByName("loanAmnt")[i-1].value="";
   document.getElementsByName("sanctionDate")[i-1].value="";
   document.getElementsByName("sanctionNo")[i-1].value="";
   document.getElementsByName("recStartDate")[i-1].value="";
   document.getElementsByName("noofPrnInstall")[i-1].value="";
   document.getElementsByName("noofIntInstall")[i-1].value="";
   document.getElementsByName("installAmnt")[i-1].value="";
   document.getElementsByName("firstInstallAmnt")[i-1].value="";
   document.getElementsByName("intInstallAmnt")[i-1].value="";
   //addition end
   
   document.getElementsByName("noofIntInstall")[i-1].value="";
   if(document.getElementsByName("loanFlag")[i-1].value=='L')
  {
    document.getElementsByName("noofIntInstall")[i-1].disabled="";
    document.getElementsByName("noofIntInstall")[i-1].style.background="#ffffd3";
    document.getElementsByName("noofIntInstall")[i-1].style.className="required";    
  }
  else
  {
    document.getElementsByName("noofIntInstall")[i-1].disabled="true";
    document.getElementsByName("noofIntInstall")[i-1].style.background="#e0e0e0";
    document.getElementsByName("noofIntInstall")[i-1].style.className="locked";        
  }
  if(document.getElementsByName("loanFlag")[i-1].value=='P')
  {
    document.getElementsByName("noofPrnInstall")[i-1].disabled="";
    document.getElementsByName("noofPrnInstall")[i-1].style.background="#ffffd3";
    document.getElementsByName("noofPrnInstall")[i-1].style.className="required";
    
    document.getElementsByName("installAmnt")[i-1].disabled="";
    document.getElementsByName("installAmnt")[i-1].style.background="#ffffd3";
    document.getElementsByName("installAmnt")[i-1].style.className="required";
    
    document.getElementsByName("firstInstallAmnt")[i-1].disabled="";
    document.getElementsByName("firstInstallAmnt")[i-1].style.background="#ffffd3";
    document.getElementsByName("firstInstallAmnt")[i-1].style.className="required";
    
    document.getElementsByName("recStartDate")[i-1].disabled="";
    document.getElementsByName("recStartDate")[i-1].style.background="#ffffd3";
    document.getElementsByName("recStartDate")[i-1].style.className="required";
  }
  else
  {
    document.getElementsByName("noofPrnInstall")[i-1].disabled="";
    document.getElementsByName("noofPrnInstall")[i-1].style.background="#ffffd3";
    document.getElementsByName("noofPrnInstall")[i-1].style.className="required";
    
    document.getElementsByName("installAmnt")[i-1].disabled="";
    document.getElementsByName("installAmnt")[i-1].style.background="#ffffd3";
    document.getElementsByName("installAmnt")[i-1].style.className="required";
    
    document.getElementsByName("firstInstallAmnt")[i-1].disabled="";
    document.getElementsByName("firstInstallAmnt")[i-1].style.background="#ffffd3";
    document.getElementsByName("firstInstallAmnt")[i-1].style.className="required";
    
    document.getElementsByName("recStartDate")[i-1].disabled="";
    document.getElementsByName("recStartDate")[i-1].style.background="#ffffd3";
    document.getElementsByName("recStartDate")[i-1].style.className="required";
  }
}

function checkInstallAmt(i)
{
    if(document.getElementsByName("loanFlag")[i-1].value=="P")
    { 
        var indx=i-1;
        var loanAmnt=document.getElementsByName("loanAmnt")[i-1].value==""?0:parseInt(document.getElementsByName("loanAmnt")[i-1].value,10);
        var noofPrnInstall=document.getElementsByName("noofPrnInstall")[i-1].value==""?0:parseInt(document.getElementsByName("noofPrnInstall")[i-1].value,10);
        //enableAll(); 
//added by priyanka
        if(document.getElementsByName("loanAmnt")[i-1].value=="" || document.getElementsByName("noofPrnInstall")[i-1].value=="")
        {
            return true;
        }
        var hdnEmpLbrFlag=frmMaintLoanDtls.hdnEmpLbrFlag.value;
        retrieveURL("../../../LoanPayAdvAction.do?loanAmnt="+escape(loanAmnt)+"&empLbrFlag="+escape(hdnEmpLbrFlag)+"&prnInstlNo="+escape(noofPrnInstall),indx,'P');
        //frmMaintLoanDtls.submit();
    }
    else
    {
        if(document.getElementsByName("loanFlag")[i-1].value=="B")
            document.getElementsByName("noofIntInstall")[i-1].value=document.getElementsByName("noofPrnInstall")[i-1].value;
        if(document.getElementsByName("loanAmnt")[i-1].value=="" || document.getElementsByName("noofPrnInstall")[i-1].value=="" || document.getElementsByName("installAmnt")[i-1].value==""|| document.getElementsByName("firstInstallAmnt")[i-1].value=="")
        {
            return true;
        }
        var loanTyp=document.getElementsByName("loanType")[i-1].value==""?0:parseInt(document.getElementsByName("loanType")[i-1].value,10);
        var loanAmnt=document.getElementsByName("loanAmnt")[i-1].value==""?0:parseInt(document.getElementsByName("loanAmnt")[i-1].value,10);
        var noofPrnInstall=document.getElementsByName("noofPrnInstall")[i-1].value==""?0:parseInt(document.getElementsByName("noofPrnInstall")[i-1].value,10);
        var installAmnt=document.getElementsByName("installAmnt")[i-1].value==""?0:parseInt(document.getElementsByName("installAmnt")[i-1].value,10);
        var firstInstallAmnt=document.getElementsByName("firstInstallAmnt")[i-1].value==""?0:parseInt(document.getElementsByName("firstInstallAmnt")[i-1].value,10);
        var calcAmt=firstInstallAmnt+(noofPrnInstall-1)*installAmnt;
        var sancDate = document.getElementsByName("sanctionDate")[i-1].value;
        if(noofPrnInstall==1)
        {
            if(loanAmnt!=firstInstallAmnt || loanAmnt!=installAmnt)
            {
                alert("Please Enter the correct installment Amount");
                document.getElementsByName("installAmnt")[i-1].value='';
                document.getElementsByName("firstInstallAmnt")[i-1].value='';
                return false;
            }
        }
        else if(noofPrnInstall>1)
        {
            if(installAmnt==0)
            {
                alert("Installment amount cannot be 0");
                document.getElementsByName("installAmnt")[i-1].value='';
            }
        }
        if(loanAmnt!=calcAmt)
        {
            alert("Please Enter the correct installment Amount");
            document.getElementsByName("installAmnt")[i-1].value='';
            return false;
        }
        if(document.getElementsByName("loanFlag")[i-1].value=="B")
        {          
            var indx=i-1;            
            retrieveURL("../../../LoanIntAction.do?loanTyp="+escape(loanTyp)+"&loanAmnt="+escape(loanAmnt)+"&fstInstlAmnt="+escape(firstInstallAmnt)+"&prnInstlNo="+escape(noofPrnInstall)+"&sancDate="+escape(sancDate), indx,'B');                                  
        }
    }
}

function retrieveURL(url,indx,loanFlg) {
  var idx=indx;    
    if (window.XMLHttpRequest) { // Non-IE browsers
      req = new XMLHttpRequest();      
      req.onreadystatechange = function () { 
                                    processStateChange(idx,loanFlg);
                                    }

      try {
        req.open("GET", url, true);
      } catch (e) {
        alert(e);
      }
      req.send(null);
    } else if (window.ActiveXObject) { // IE
      req = new ActiveXObject("Microsoft.XMLHTTP");      
      if (req) {               
        req.open("GET", url, true);        
        req.onreadystatechange = function () { 
                                    processStateChange(idx,loanFlg);
                                    }
        req.send(null);
        
      }
    }
  }

function processStateChange(indx,loanFlg) {
    if (req.readyState == 4) { // Complete
      if (req.status == 200) { // OK response        
         var kotResponse = req.responseText;            
         var kotInfo = kotResponse.split("|");         
        if(kotInfo[0] == ''){
          alert("Error in Calculating Interest Installment Amount"); 
          if(loanFlg =='B'){
            document.getElementsByName("intInstallAmnt")[indx].value = '';
            document.getElementsByName("intAmnt")[indx].value = '';
            }if(loanFlg =='P'){
            document.getElementsByName("recStartDate")[indx].value = '';
            document.getElementsByName("installAmnt")[indx].value = '';
            document.getElementsByName("firstInstallAmnt")[indx].value = '';
          }
          }else{
            if(loanFlg =='B'){
              document.getElementsByName("intInstallAmnt")[indx].value = kotInfo[0];
              document.getElementsByName("intAmnt")[indx].value = kotInfo[1];
              }if(loanFlg =='P'){
                document.getElementsByName("recStartDate")[indx].value = kotInfo[0];
                document.getElementsByName("installAmnt")[indx].value = kotInfo[1];
                document.getElementsByName("firstInstallAmnt")[indx].value = kotInfo[2];
              }
          }
        } else {
        alert("Problem: " + req.statusText);
      }
    }
  }
  //added by geetika on 06/08/2014 to check that Interest Installment for loan other than Benevolent Funds should not be 0
function checkIntInstallNo(i)
{
    
    if(document.getElementsByName("loanFlag")[i-1].value=="L")
    { 
        var indx=i-1;
        var intInstallNo=parseInt(document.getElementsByName("noofIntInstall")[indx].value,10);
        if(intInstallNo == '' || intInstallNo == 0)
        {
           alert("Please enter correct Interest Installment Number");
           document.getElementsByName("noofIntInstall")[indx].value='';
           return false;
        }
        
    }
    
}
</script> 