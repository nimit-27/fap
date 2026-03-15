<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%
	String lbrType = (String)session.getAttribute("hdnEmpLbrFlag"); 

%>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    
    <link rel="STYLESHEET" type="text/css" href="../../CSS/PayrollMenucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintLoanDtlsAllBase" name="frmLoanDtlsAll" type="FCIPAY.Payroll.WEBTIER.Form.MaintLoanDtlsAllForm" scope="session">
<bean:define id="ParentForm" name="frmLoanDtlsAll" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerDataChanged"  />
<html:hidden property="headerFields" value="false" />

<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN LOAN DETAILS(BULK)</TD>
</TR>
</TABLE>
<!--container table starts -->

<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>	
       <!--<div id=divBody>-->
       <!-- Body table Starts -->
        <TABLE cellSpacing=3 cellPadding=0 border=0>
       <!--Account  Header Row Starts -->
        <TR>
         <TD class=subHeader colspan=6>Loan/Advance Detail Header</TD>
        </TR>
        <TR>
          <TD colspan=4 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
        </TR>
        
        <tr>   
          <td width="100%">
            <table width="100%" cellSpacing=3 cellPadding=0 border="0">   
               <!-- Added  by nand on 10 July 2013 -->
			   <tr>
					<td class="labelText">Location/Depot Name</td>
					<td><html:text  property="txtLocId" maxlength="10" size ="23" styleClass="optional" readonly="true" /> 
                        <img src="../INCLUDES/IMAGES/lov.jpg" align="center" height="16" name="buttxtSite"  onclick="return ShowSite(); ">
					    <html:hidden property="txtLoc" name="frmLoanDtlsAll" />				
					</td>
       
	                <td class="labelText">Gang Name</td> 
					<td><html:text  property="txtGangName" maxlength="50" size ="23" styleClass="optional" readonly="true" />
						<img src="../INCLUDES/IMAGES/lov.jpg" align="center" height="16" name="buttxtGang"  onclick="return ShowLovGang();" alt="">
						<html:hidden property="txtGangId" name="frmLoanDtlsAll" />
					</td> 
			  </tr>
			  <!-- End of addition  by nand on 10 July 2013 -->
              <TR>
                  <TD class=labelText><bean:message key="Payroll.IntRates.loanType" /></TD>
                  <td align="left" colspan="5" >      
                  
                  <html:text  property="headerPrimaryKey" altKey="Payroll.IntRates.loanType" maxlength="6" size="23" styleClass="required" onchange="setMandatory()" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowLovLoanType();" readonly="true">                                                      
                  
                  <html:text  property="loanDesc" altKey="" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td>                
                  
              </TR>             
            
              <tr>
              
                <td class=labelText width="17%" ><bean:message key="Payroll.LoanDtls.loanAmnt" /></td>
                <td colspan="1" width="15%" >
                <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">
                <html:text  property="loanAmnt" altKey="Payroll.LoanDtls.loanAmnt" style="text-align:right" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  maxlength="6" size="23" styleClass="required" onchange="checkInstallAmt()" />                            
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">
                <html:text  property="loanAmnt" altKey="Payroll.LoanDtls.loanAmnt" style="text-align:right" readonly="true" maxlength="6" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  styleClass="locked" onchange="checkInstallAmt()" />                            
                </logic:notEqual>
                </td>                 
              
                <td class="labelText"  width="17%"  ><bean:message key="Payroll.LoanDtls.sanctionDate" /> </td>
                <td width="15%" >                  
                <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="sanctionDate" styleClass="required"  style="text-align:left" size="23" maxlength="50" readonly="true" onchange=""  />&nbsp;<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butSanctionDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>" onclick="showCalendar('sanctionDate',this)"  >                            
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="sanctionDate" styleClass="required"  style="text-align:left" size="23" maxlength="50" readonly="true" onchange=""  />&nbsp;<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butSanctionDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>" onclick="showCalendar('sanctionDate',this)"  >
                </logic:notEqual>
                </td>
                
                <td class="labelText"  width="17%"  ><bean:message key="Payroll.LoanDtls.sanctionNo" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="sanctionNo" styleClass="required"  style="text-align:left" size="23" maxlength="50" onchange=""  />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="sanctionNo" styleClass="optional"  style="text-align:left" size="23" maxlength="50"  onchange=""  />
                </logic:notEqual>
                </td>                  
              </tr>
              
              <tr>    
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.LoanDtls.recStartDate" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="recStartDate" styleClass="required"  style="text-align:left" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  maxlength="50" onchange="chk_YearMonth('recStartDate')"  /> 
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="recStartDate" styleClass="locked" readonly="true" style="text-align:left" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  maxlength="50"  onchange=""  />
                </logic:notEqual>
                </td> 
                
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.LoanDtls.noofPrincInstall" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="noofPrnInstall" styleClass="required"  style="text-align:left" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  maxlength="50" onchange="checkInstallAmt()"  />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="noofPrnInstall" styleClass="locked" readonly="true" style="text-align:left" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  maxlength="50" onchange="checkInstallAmt()"  />
                </logic:notEqual>
                </td>   
                
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.LoanDtls.noofIntInstall" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="noofIntInstall" styleClass="optional"  style="text-align:left" size="23" maxlength="50" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  onchange="checkInstallAmt()"  />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="noofIntInstall" styleClass="locked" readonly="true" style="text-align:left" size="23" maxlength="50" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  onchange="checkInstallAmt()"  />
                </logic:notEqual>
                </td>
              </tr>
              
              <tr>                  
                
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.LoanDtls.installAmnt" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="installAmnt" styleClass="required"  style="text-align:right" size="23"  maxlength="50" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  onchange="checkInstallAmt()"  />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="installAmnt" styleClass="locked" readonly="true" style="text-align:right" size="23" maxlength="50" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  onchange="checkInstallAmt()"  />
                </logic:notEqual>
                </td> 
                
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.LoanDtls.firstLoanAmnt" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="firstInstallAmnt" styleClass="required"  style="text-align:right" size="23" maxlength="50" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  onchange="checkInstallAmt()"  />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="firstInstallAmnt" styleClass="locked" readonly="true" style="text-align:right" size="23" maxlength="50" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  onchange="checkInstallAmt()"  />
                </logic:notEqual>
                </td>     
                
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.LoanDtls.intInstallAmnt" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="intInstallAmnt" styleClass="locked" readonly="true" style="text-align:right" size="23" maxlength="50" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  onchange="checkInstallAmt()"  />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">                              
                <html:text property="intInstallAmnt" styleClass="locked" readonly="true" style="text-align:right" size="23" maxlength="50" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  onchange="checkInstallAmt()"  />
                </logic:notEqual>
                </td>  
              </tr>  
              
              <tr><td colspan="6"><table>
              <tr>
                <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">
                <TD class=labelText width="16%"><bean:message key="Payroll.EmpLoan.ExcEmp" /></TD>
                <td align="left" width="85%" >                  
                <html:textarea property="txtEmpList" cols="" rows="2" name="frmLoanDtlsAll" altKey="Payroll.EmpLoan.ExcEmp" styleClass="optional" readonly="true" style="width: 310px; text-align:left" />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return showAllLOVEmp();">
                </td>  
                </logic:equal>
                <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">
                <html:hidden property="txtEmpList" />
                </logic:notEqual>
              </tr>             
              
              </table></td></tr>
                         
            </table>
          </td>
          </tr>
          <tr height="10">		    
        <TD colspan="2" > </TD>
      </tr>
   	 </table>
    </div>
<table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
        <TD colspan=11>
            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>                    
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>                
                    <logic:equal property= "screenMode" name= "frmLoanDtlsAll" value="N">
                    <td bgcolor="#4682B4" nowrap class=actTabText > Excluded Employees <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    </logic:equal>
                    <logic:notEqual property= "screenMode" name= "frmLoanDtlsAll" value="N">
                    <td bgcolor="#4682B4" nowrap class=actTabText > Excluded Employees <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    </logic:notEqual>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>                    
                    
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="8">
                  <TABLE cellSpacing="0" cellPadding="0" border="0" >
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:250px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail" border=0>
                          <TBODY>                          
                          <TR height=20>
                            <td class=tableHeader width="1%"></td>
                            <TD class=tableHeader width="10%"><bean:message  key="Payroll.EmpInfo.Empno" /></td>
                            <TD class=tableHeader width="27%"><bean:message  key="Payroll.Common.empName" /></td>
                            <TD class=tableHeader width="23%"><bean:message  key="Payroll.EmpInfo.Desig" /></td>
                            <TD class=tableHeader width="10%"><bean:message  key="Payroll.EmpInfo.lstCateg" /></td>
                            <TD class=tableHeader width="25%"><bean:message  key="Payroll.EmpInfo.PresentPOP" /></td>
                                                         
                            </TR>            
                            
                          <logic:iterate id="LoanDtlsAll" name="frmLoanDtlsAll" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.LoanDtlsAllDetailBean" indexId="idx">
                            <% ++i; %>
                            <logic:notEqual name="LoanDtlsAll" property="status" value="D" >                            
                             <logic:equal name="LoanDtlsAll" property="status" value="N" >                                                        
                            <tr><% ++j; %>                              
                              <td align = "center"><html:checkbox property="checked"  onclick="checkRecord();" value="false" name="frmLoanDtlsAll" /></td>
                              <td width="10%" ><html:text property="txtEmpNo" name="LoanDtlsAll" styleClass="required" readonly="true" style="width:75%;text-align:left"  alt="<%=String.valueOf(i) %>" />&nbsp;
							    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpLOV" alt="<%=String.valueOf(idx)%>" name="buttxtEmpLOV" onclick="showAllLOVEmp(this.alt);"></td>                                                         
                              <td width="27%" ><html:text property="txtEmpName" name="LoanDtlsAll" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="9" readonly="true" /></td>                                                         
                              <td width="23%" ><html:text property="txtDsgn" name="LoanDtlsAll" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="9" readonly="true" /></td>                                                         
                              <td width="10%" ><html:text property="txtCateg" name="LoanDtlsAll" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="9" readonly="true" /></td>                                                         
                              <td width="25%" ><html:text property="txtPresentPOP" name="LoanDtlsAll" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="9" readonly="true" /></td>                                                         
                               
                              <html:hidden property="itemChecked" name="LoanDtlsAll" />
                              <html:hidden property="status" name="LoanDtlsAll" />    
                              <html:hidden property="detailId" name="LoanDtlsAll" value="Default"/>
                              
                            </tr>
                        </logic:equal>
                        <logic:notEqual name="LoanDtlsAll" property="status" value="N" >                                                        
                            <tr><% ++j; %>                              
                              <td align = "center"></td>
                              <td width="10%" ><html:text property="txtEmpNo" name="LoanDtlsAll" styleClass="locked" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="9" onchange="" /></td>                                                         
                              <td width="27%" ><html:text property="txtEmpName" name="LoanDtlsAll" styleClass="locked" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="9" onchange="" /></td>                                                         
                              <td width="23%" ><html:text property="txtDsgn" name="LoanDtlsAll" styleClass="locked" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="9" onchange="" /></td>                                                         
                              <td width="10%" ><html:text property="txtCateg" name="LoanDtlsAll" styleClass="locked" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>" maxlength="9" onchange="" /></td>                                                         
                              <td width="25%" ><html:text property="txtPresentPOP" name="LoanDtlsAll" styleClass="locked" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i) %>" maxlength="9" onchange="lfnChange(alt); " /></td>                                                         
                                                          
                              <html:hidden property="itemChecked" name="LoanDtlsAll" />
                              <html:hidden property="status" name="LoanDtlsAll" />    
                              <html:hidden property="detailId" name="LoanDtlsAll" value="Default"/>
                              
                            </tr>
                        </logic:notEqual>
                        </logic:notEqual>
                        <logic:equal name="LoanDtlsAll" property="status" value="D" >
                         <tr>
                            <td width="1%" ></td>
                            <td width="10%" ><html:hidden property="txtEmpNo" name="LoanDtlsAll" styleClass="locked"   /></td>                                                         
                            <td width="27%" ><html:hidden property="txtEmpName" name="LoanDtlsAll" styleClass="locked"  /></td>                                                         
                            <td width="23%" ><html:hidden property="txtDsgn" name="LoanDtlsAll" styleClass="locked" /></td>                                                         
                            <td width="10%" ><html:hidden property="txtCateg" name="LoanDtlsAll" styleClass="locked" /></td>                                                         
                            <td width="25%" ><html:hidden property="txtPresentPOP" name="LoanDtlsAll" styleClass="locked"  /></td>                                                         
                                                        
                           <html:hidden property="itemChecked" name="LoanDtlsAll" />
                           <html:hidden property="status" name="LoanDtlsAll" />
                           <html:hidden property="detailId" name="LoanDtlsAll" value="Default"/>
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
		          <td colspan=8>
                  <TABLE border=0>
                    <TBODY>
                        <TR><td><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                    </td></TR>
                  </TBODY>
                </TABLE>
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
    <td align=center bgcolor=#4682b4 width="40%"></td>
    <td bgColor=#4682b4></td>
    <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
  </TR>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<!-- These four hidden fields must be present in pages where there is a detail part -->
<html:hidden name="frmLoanDtlsAll"  property="screenName" value="LoanDtlsAllScreen" />
<html:hidden property="totalDetailRecord" name="frmLoanDtlsAll" />
<html:hidden name="frmLoanDtlsAll"  property="forwardedPage" />
<html:hidden name="frmLoanDtlsAll"  property="hdnAction" />    
<html:hidden property="screenMode" name="frmLoanDtlsAll"  />
<html:hidden property="screenModeFlag" name="frmLoanDtlsAll"  />
<html:hidden name="frmLoanDtlsAll"  property="lovKey"  />
<html:hidden name="frmLoanDtlsAll"  property="txtFields" />   
<html:hidden name="frmLoanDtlsAll"  property="txtSearchFields" />
<html:hidden name="frmLoanDtlsAll"  property="txtDisplayFields"  />
<html:hidden name="frmLoanDtlsAll"  property="txtIndex"  />
<html:hidden property="buttonFlag" name="frmLoanDtlsAll"  />
<html:hidden property="userPageRequested" name="frmLoanDtlsAll"  />
<html:hidden property="pageRequested" name="frmLoanDtlsAll"  />

<html:hidden property="positionRequested" name="frmLoanDtlsAll" />
<html:hidden property="userPositionRequested" name="frmLoanDtlsAll" />


<html:hidden property="flag" name="frmLoanDtlsAll" />

<html:hidden name="frmLoanDtlsAll"  property="screenModeloan"  />
<html:hidden name="frmLoanDtlsAll"  property="screenModeloan1"  />
<html:hidden name="frmLoanDtlsAll"  property="screenModeloan2"  />
<html:hidden name="frmLoanDtlsAll"  property="txtEmpNo"  />
<html:hidden name="frmLoanDtlsAll"  property="loanFlag"  />
<html:hidden name="frmLoanDtlsAll"  property="loanType"  />

<html:hidden property="loginLocCode" name="frmLoanDtlsAll" />
<html:hidden property="intAmnt" name="frmLoanDtlsAll" />
<html:hidden property="txtType" name="frmLoanDtlsAll" />
<html:hidden property="txtMou" name="frmLoanDtlsAll" />
<!-- <html:hidden property="txtLocId" name="frmLoanDtlsAll" />
<html:hidden property="txtGangId" name="frmLoanDtlsAll" />  -->


<input type="hidden" name="txtInputField" />
<input type="hidden" name="queryParam" />
<input type="hidden" name="multipleFlag" />

<!-- Hidden fields end -->

</html:form>
</body>
</html:html>

 
<script language="javascript">

function lfnLoad()
{  
    var sMode  = frmLoanDtlsAll.screenMode.value;
    if(sMode == "")
    {
        doQueryMode();
    }    
    mode = frmLoanDtlsAll.screenModeloan.value;    
    if(mode=='')
    {
        document.all.butGetDetail.disabled="disabled";   
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";
    }
    if(mode=='Q')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";     
		document.all.txtLocId.value="";
		//document.all.txtGangName.value="";
    }    
    if(mode=='U')
    {   
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";                
    } 
    if(mode=='N')
    {        
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled=""; 
		document.all.txtLocId.value="";
		//document.all.txtGangName.value="";
    }    
    if(mode=='UG')
    {
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";
    }
    
    mode = frmLoanDtlsAll.screenMode.value;      
    menuHandling(mode); 
    if(mode == 'N')
      document.all.butInsert.disabled="disabled";
      
    if(mode == 'U' && frmLoanDtlsAll.screenModeloan.value=='UG')
      document.all.butInsert.disabled="disabled";
      
    if(mode == 'Q' && frmLoanDtlsAll.screenModeloan.value=='U')
      document.all.butGetDetail.disabled="disabled";  
      
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";       

	  if(document.all.hdnEmpLbrFlag.value=='L')
	  {
		document.all.txtType.value="DEP";
	  }
	  else if(document.all.hdnEmpLbrFlag.value=='D')
	  {
		document.all.txtType.value="DPS";
	  }
	  else
	  {
		document.all.txtType.value="KOT";
	  }
   if(document.all.hdnEmpLbrFlag.value=='E')
	{
		document.all.buttxtGang.disabled='true';
		//document.all.txtGangName.disabled="disabled";
		document.all.txtGangName.style.background="#e0e0e0";
    }

}

function ShowLovLoanType()
{
    frmLoanDtlsAll.lovKey.value = "LoanDtlsAllLoanTyp" + frmLoanDtlsAll.screenName.value + frmLoanDtlsAll.screenMode.value;  
	
	frmLoanDtlsAll.queryParam.value = "hdnEmpLbrFlag="+frmLoanDtlsAll.hdnEmpLbrFlag.value+",screenName="+frmLoanDtlsAll.screenName.value+",screenMode="+frmLoanDtlsAll.screenMode.value+",txtSiteID="+frmLoanDtlsAll.loginLocCode.value; 
    if(document.all.screenMode.value=='Q')
    {
      frmLoanDtlsAll.txtDisplayFields.value = "headerPrimaryKey,loanDesc,loanFlag,noofPrnInstall";
      frmLoanDtlsAll.txtInputField.value=""; 
    }
    else
    {
      frmLoanDtlsAll.txtDisplayFields.value = "headerPrimaryKey,loanDesc,loanFlag";
      frmLoanDtlsAll.txtInputField.value="headerPrimaryKey"; 
    }
    frmLoanDtlsAll.txtSearchFields.value = "";
    frmLoanDtlsAll.txtInputField.value="headerPrimaryKey";   
    frmLoanDtlsAll.txtIndex.value ="";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLoanDtlsAll');
    return true;
}

function showAllLOVEmp()
{   
   frmLoanDtlsAll.lovKey.value = "LoanDtlsAll" + frmLoanDtlsAll.screenName.value + frmLoanDtlsAll.screenMode.value;
   frmLoanDtlsAll.txtDisplayFields.value = "txtEmpList";
   frmLoanDtlsAll.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName"; 
  // frmLoanDtlsAll.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";   
   frmLoanDtlsAll.queryParam.value = "txtSiteID="+frmLoanDtlsAll.loginLocCode.value+",hdnEmpLbrFlag="+document.all.hdnEmpLbrFlag.value+",txtLocId= "+frmLoanDtlsAll.txtLocId.value+",txtGangId= "+frmLoanDtlsAll.txtGangId.value;
   frmLoanDtlsAll.multipleFlag.value = "true";
   frmLoanDtlsAll.txtIndex.value =""; 
   frmLoanDtlsAll.txtInputField.value=""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLoanDtlsAll');
   return true;
}

function doSetFields(arrList,arrLength,arrCols)
{
  var arrEmpNo=new Array();
   var arrEmpName=new Array();
 // arr=arrList;
 
  for( i=0;i<arrList.length;i++)
  {
     arrEmpNo[i]=arrList[i][0];
     arrEmpName[i]=arrList[i][1];
  }
  //var indx=frmMaintWrkSlip.txtIndex.value;  
  frmLoanDtlsAll.txtEmpList.value = arrEmpNo;
  //document.getElementsByName("txtEmpList").value=arrEmpNo;
  //document.getElementsByName("txtEmpNameList").value=arrEmpName;
}

function doRefresh()
{  
  frmLoanDtlsAll.action="../../../LoanDtlsAllRefresh.do";
  frmLoanDtlsAll.submit();                      
}

function doBaseAddRow()
{
   if(mandatory_Check("frmLoanDtlsAll"))
   {
      document.all.buttonFlag.value='';
      //frmLoanDtlsAll.screenMode.value = "U";  
      document.forms[0].action = "../../../LoanDtlsAllAddRowAction.do";      
      document.forms[0].submit();
   }
    else
    {
        return false;
    }   
}

function doBaseDelRow()
{ 
  if(frmLoanDtlsAll.screenMode.value !='N')
  {
    alert("Deletion is not Allowed");
    return;
  }
  
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
    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmLoanDtlsAll.detailDataChanged.value = "true";
    }
  }
  document.forms[0].action = "../../../LoanDtlsAllDeleteRowAction.do";
  document.forms[0].submit();  
}

function doQueryMode()
{    
    document.all.screenModeloan.value  = "Q";
    document.all.screenMode.value = "Q";
    document.all.screenModeloan1.value = "Q";       
    
    frmLoanDtlsAll.action="../../../LoanDtlsAllQueryMode.do"
    frmLoanDtlsAll.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmLoanDtlsAll"))
    {   
        document.all.screenModeloan.value='UG';        
        document.all.txtEmpNo.disabled = "";  
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		
        frmLoanDtlsAll.action="../../../LoanDtlsAllGetHeaderAction.do"
        frmLoanDtlsAll.submit();
   } 
} 

function doGetNextHeader()
{
    document.all.buttonFlag.value='';   
    document.all.screenModeloan.value='UG';      
    frmLoanDtlsAll.flag.value = "false";    
    frmLoanDtlsAll.userPositionRequested.value = 1*frmLoanDtlsAll.positionRequested.value + 1;    
    frmLoanDtlsAll.action="../../../LoanDtlsAllGetNextHeader.do";
    frmLoanDtlsAll.submit();
}

function PrevHeader()
{
  document.all.buttonFlag.value='';
  document.all.screenModeloan.value='UG';  
  frmLoanDtlsAll.flag.value = "false";
  frmLoanDtlsAll.userPositionRequested.value = 1*frmLoanDtlsAll.positionRequested.value - 1;
  frmLoanDtlsAll.action = "../../../LoanDtlsAllGetNextHeader.do";
  frmLoanDtlsAll.submit();
}

function JumpHeader()
{
  document.all.buttonFlag.value='';
  document.all.screenModeloan.value='UG';
  frmLoanDtlsAll.flag.value = "false";
  frmLoanDtlsAll.userPositionRequested.value = 1*frmLoanDtlsAll.newPositionRequested.value;
  frmLoanDtlsAll.action = "../../../LoanDtlsAllGetNextHeader.do";
  frmLoanDtlsAll.submit();
}

function GetDetail()
{
    document.all.buttonFlag.value='';      
    document.getElementById("headerPrimaryKey").disabled="";
    frmLoanDtlsAll.loanType.value=frmLoanDtlsAll.headerPrimaryKey.value;           
    document.all.screenModeloan.value='U';
    
    frmLoanDtlsAll.action="../../../LoanDtlsAllDetailAction.do";    
    frmLoanDtlsAll.submit();
 
}

function doInsertMode()
{
    document.all.buttonFlag.value='';        
    document.all.screenModeloan.value = "N";   
    
    frmLoanDtlsAll.action="../../../LoanDtlsAllNewMode.do"
    frmLoanDtlsAll.submit();
}

function doBasePrevDetail()
{
    frmLoanDtlsAll.userPageRequested.value = 1*frmLoanDtlsAll.pageRequested.value - 1;
    frmLoanDtlsAll.action = "../../../LoanDtlsAllNextDetailAction.do";
    frmLoanDtlsAll.submit();
}

function doBaseNextDetail()
{
    frmLoanDtlsAll.userPageRequested.value = 1*frmLoanDtlsAll.pageRequested.value + 1;
    frmLoanDtlsAll.action = "../../../LoanDtlsAllNextDetailAction.do";
    frmLoanDtlsAll.submit();
}

function JumpDetail()
{
    frmLoanDtlsAll.userPageRequested.value = 1*frmLoanDtlsAll.newPageRequested.value ;    
    frmLoanDtlsAll.action = "../../../LoanDtlsAllNextDetailAction.do";
    frmLoanDtlsAll.submit();
}

function SaveRecord()
{
  document.all.buttonFlag.value=''; 
  if(mandatory_Check("frmLoanDtlsAll"))
  {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;     
      var i = 0;
      if((document.all.loanFlag.value=='B' || document.all.loanFlag.value=='L') && document.all.noofIntInstall.value =='')
      { 
        alert("No. of Interest Installment is Mendatory");
        return;
      }
      for(i=0; i < iTr2 -1; i++)
      {
        //if (document.getElementsByName("status")[i].value == 'D')
          //frmLoanDtlsAll.detailDataChanged.value = "true";
        //else
          //document.getElementsByName("txtCateg")[i].disabled = "";
      }         
            
      frmLoanDtlsAll.headerDataChanged.value = "true";   
      frmLoanDtlsAll.headerFields.value="true";          
      if(iTr2 <= 1)
      {
          //frmLoanDtlsAll.detailDataChanged.value = "true";   
          frmLoanDtlsAll.headerFields.value="true";          
      }      
      
      frmLoanDtlsAll.totalDetailRecord.value = parseInt(iTr2,10) - 1;      
      document.all.screenModeFlag.value=false;              
      document.all.screenModeloan.value  = "UG";     
      
      frmLoanDtlsAll.loanType.value = frmLoanDtlsAll.headerPrimaryKey.value;
      enableAll();
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmLoanDtlsAll.action = "../../../LoanDtlsAllSaveAction.do";
      frmLoanDtlsAll.submit();
  }
  else
  {
    return false;
  }
}

function lfnChange(ind)
{        
    frmLoanDtlsAll.detailDataChanged.value = "true";      
    if (document.getElementsByName("status")[ind-1].value == 'Q')
       document.getElementsByName("status")[ind-1].value = 'U';
  
}

function AllEmpClick() 
{
    document.frmLoanDtlsAll.hdnAction.value = "";  
    document.all.buttonFlag.value='';   
    
    document.frmLoanDtlsAll.action="../../../PLIOptionClickAction.do";
    document.frmLoanDtlsAll.optVal.value="1";
    document.frmLoanDtlsAll.submit(); 
}

function EmpNoClick() 
{
    document.frmLoanDtlsAll.hdnAction.value = "";  
    document.all.buttonFlag.value='';   
    
    document.frmLoanDtlsAll.action="../../../PLIOptionClickAction.do";
    document.frmLoanDtlsAll.optVal.value="2";
    document.frmLoanDtlsAll.submit(); 
}

function chk_FinYear(val)
{
    var  yearM = document.getElementById("headerPrimaryKey").value;              
    var Year1;
    var Year2;    
    if ( yearM != "") 
    {
        if (num_Check(yearM,1))
        {                                   
            if (yearM.length != 6)
            {
                alert(" Year Month should be a Six digit Number");
                document.getElementById("headerPrimaryKey").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                            
                return false;    
            }        
            Year1 =  yearM.substring(2,4);
            Year2 =  yearM.substring(4,6);           
            var TempYr1 = parseInt(Year1,10)+1;             
            var TempYr2 = parseInt(Year2,10);                          
            if (TempYr1 != TempYr2)
            {
                alert("Year Range Should be in the format of a Financial Period Eg. 200809");
                document.getElementById("headerPrimaryKey").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                   
                return false;       
            }
    
            return true;                                     
        }      
        else
        {
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;     
            return false;
        }
    }
}

function chk_YearMonth(input)
{      
    var  yearM = document.getElementById(input).value;          
    var month =  yearM.substring(4,6);    
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementById(input).focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById(input).focus();                     
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

function alphanum_Check_n(value) 
{
	if(value=="") 
		return true;
	value=trim(value);
	var alphaPattern = /^\d+$/;	
	if (alphaPattern.test(value))
		return(true);
	else 
	{
		alert("Invalid Entry!");    
    //alert(event.srcElement.value);
		event.srcElement.select();
		event.srcElement.focus();
		return(false);
	}
}

function checkInstallAmt()
{
    if(document.all.loanFlag.value=="P")
    {
      enableAll();     
      frmLoanDtlsAll.action="../../../LoanIntAllAction.do";  
      frmLoanDtlsAll.submit();
    }else
    {
    if(document.all.loanFlag.value=="B")
    document.all.noofIntInstall.value=document.all.noofPrnInstall.value;
    if(document.all.loanAmnt.value=="" || document.all.noofPrnInstall.value=="" || document.all.installAmnt.value==""|| document.all.firstInstallAmnt.value=="")
    {
      return true;
    }
    var loanAmnt=document.all.loanAmnt.value==""?0:parseInt(document.all.loanAmnt.value,10);
    var noofPrnInstall=document.all.noofPrnInstall.value==""?0:parseInt(document.all.noofPrnInstall.value,10);
    var installAmnt=document.all.installAmnt.value==""?0:parseInt(document.all.installAmnt.value,10);
    var firstInstallAmnt=document.all.firstInstallAmnt.value==""?0:parseInt(document.all.firstInstallAmnt.value,10);
    var calcAmt=firstInstallAmnt+(noofPrnInstall-1)*installAmnt;
    if(noofPrnInstall==1)
  {
    if(loanAmnt!=firstInstallAmnt || installAmnt!=0)
    {
      alert("Please Enter the correct installment Amount");
      document.all.installAmnt.value='';
      document.all.firstInstallAmnt.value='';
      return false;
    }
  }else if(noofPrnInstall>1)
  {
    if(installAmnt==0)
    {
      alert("Installment amount cannot be 0");
      document.all.installAmnt.value='';
    }
  }
  if(loanAmnt!=calcAmt)
  {
      alert("Please Enter the correct installment Amount");
      document.all.installAmnt.value='';
      return false;
  }
  if(document.all.loanFlag.value=="B")
  {
  //  var indx=i-1;
    enableAll(); 
    frmLoanDtlsAll.action="../../../LoanIntAllAction.do";  
    frmLoanDtlsAll.submit();
  }
  }
}

function setMandatory()
{
  if(document.all.screenMode.value=='N')
  {
    if(document.all.noofPrnInstall.value != '')
    {    
      document.all.noofPrnInstall.value = ''; 
      document.all.noofIntInstall.value = ''; 
      document.all.installAmnt.value = ''; 
      document.all.firstInstallAmnt.value = ''; 
    }  
  
    if(document.all.loanFlag.value=='L')
    {    
      document.all.noofIntInstall.disabled="";
      document.all.noofIntInstall.style.background="#ffffd3";
      document.all.noofIntInstall.style.className="required";
    }
    else
    {
      document.all.noofIntInstall.disabled="true";
      document.all.noofIntInstall.style.background="#e0e0e0";
      document.all.noofIntInstall.style.className="locked";           
    }    
  }
}

function enableAll()
{
  document.all.headerPrimaryKey.disabled="";
  document.all.loanDesc.disabled="";
  document.all.noofIntInstall.disabled="";
  document.all.noofPrnInstall.disabled="";
  document.all.recStartDate.disabled="";
  document.all.installAmnt.disabled="";
  document.all.firstInstallAmnt.disabled="";
}

//added by nand on 10 July 2013
function ShowSite()
{
   document.all.txtGangName.value="";
   
   frmLoanDtlsAll.lovKey.value = "GangDepot" + frmLoanDtlsAll.screenName.value + frmLoanDtlsAll.screenMode.value;
   frmLoanDtlsAll.queryParam.value="txtSiteID="+frmLoanDtlsAll.loginLocCode.value;
   frmLoanDtlsAll.txtDisplayFields.value = "txtLocId,txtLoc";
   frmLoanDtlsAll.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   frmLoanDtlsAll.txtIndex.value=""; 
   frmLoanDtlsAll.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLoanDtlsAll');
   return true;
}

function ShowLovGang()
{
	if(frmLoanDtlsAll.txtLocId.value == "")
	{
		alert("Please select the depot first.")  
        return; 
	}
	
   frmLoanDtlsAll.lovKey.value = "GangName" + frmLoanDtlsAll.screenName.value + frmLoanDtlsAll.screenMode.value;
   frmLoanDtlsAll.queryParam.value="txtLocId="+frmLoanDtlsAll.txtLocId.value +",txtSiteID="+frmLoanDtlsAll.loginLocCode.value+",txtType="+frmLoanDtlsAll.txtType.value;    
   frmLoanDtlsAll.txtDisplayFields.value = "txtGangId,txtGangName";
   frmLoanDtlsAll.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
   frmLoanDtlsAll.txtIndex.value="";
   frmLoanDtlsAll.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLoanDtlsAll');
   return true;
}    
</script>

