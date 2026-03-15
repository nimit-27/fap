<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

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

<html:form  action="MediReimbursDtlsAllBase" name="frmMediReimbursDtlsAll" type="FCIPAY.Payroll.WEBTIER.Form.MediReimbursDtlsAllForm" scope="session">
<bean:define id="ParentForm" name="frmMediReimbursDtlsAll" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerDataChanged"  />
<html:hidden property="headerFields" value="false" />

<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>BULK REIMBURSEMENTS DETAILS </TD>
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
         <TD class=subHeader colspan=6>Reimbursement Detail Header</TD>
        </TR>
        <TR>
          <TD colspan=4 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
        </TR>
        
		<tr>
		<td width="100%">
			<table width="100%" cellSpacing=3 cellPadding=0 border="0">  
			<tr id='11'>
				
					<td class=labelText width="10%"  >
					<bean:message key="Payroll.MediClaim.code"/>
					</TD>
					<td width="15%">
						<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
							<html:select property="txtPayCode" name="frmMediReimbursDtlsAll"  titleKey="Payroll.MediClaim.code" styleClass="required"  style="WIDTH:80%" onchange="clrPayType();">
							<html:option value=" " >---Please Select---</html:option>
							<html:option value="200" >Reim of Medical Exp</html:option>
							<html:option value="138" >Conyence Reimburse</html:option>
							
                            <html:option value="132" >Ex-Gratia</html:option>
							</html:select>
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
							<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="Q">
								<html:select property="txtPayCode" name="frmMediReimbursDtlsAll"  titleKey="Payroll.MediClaim.code" styleClass="required"  style="WIDTH:80%" onchange="clrPayType();">
								<html:option value=" " >---Please Select---</html:option>
								<html:option value="200" >Reim of Medical Exp</html:option>
								<html:option value="138" >Conyence Reimburse</html:option>
								
                                  <html:option value="132" >Ex-Gratia</html:option>

								</html:select>
							</logic:equal>
							<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="Q">
								<html:select property="txtPayCode" name="frmMediReimbursDtlsAll"  titleKey="Payroll.MediClaim.code" styleClass="locked" disabled="true" style="WIDTH:80%" onchange="clrPayType();">
								<html:option value=" " >---Please Select---</html:option>
								<html:option value="200" >Reim of Medical Exp</html:option>
								<html:option value="138" >Conyence Reimburse</html:option>
								
                                <html:option value="132" >Ex-Gratia</html:option>
							</html:select>
							</logic:notEqual>
						</logic:notEqual>
					</td>
			</tr>
			<TR id="1" style="display:none">
				
				<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
					<td class=labelText>
						<bean:message key="Payroll.MediReim.Amount" />
					</td>
					<td align="left">
						<html:text  property="medicalAmt" altKey="Payroll.MediReim.Amount" style="text-align:right" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  maxlength="6" size="23" styleClass="required" />  
					</td>
				</logic:equal>
				<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
					<td class=labelText>
						<bean:message key="Payroll.MediReim.Amount" />
					</td>
					<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="Q">
						<td align="left">
							<html:text property="medicalAmt" altKey="Payroll.MediReim.Amount" style="text-align:right" maxlength="6" size="23" styleClass="optional" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" />  
						</td>
					</logic:equal>
					<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="Q">
						<td align="left">
							<html:text property="medicalAmt" altKey="Payroll.MediReim.Amount" style="text-align:right" maxlength="6" size="23" styleClass="locked" readonly="true" />  
						</td>
					</logic:notEqual>
				</logic:notEqual>
		   </tr>
			<tr id="ym" style="display:none">			
				<td  class="labelText"  width="10%" >
				<bean:message key="payment.yearmonth" />
				</td>
				<td>                  
					<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
						<html:text property="yearMonth" styleClass="required" size="16" maxlength="6" 
            onchange="                                                  
                    if(!(chk_YearMonth()))
                    {
                    }                                            
                    " 
                    
                    
            onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" />(YYYYMM)
					</logic:equal>
					<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
						<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="U">
							<html:text property="yearMonth" styleClass="required"  size="16" maxlength="6"
              onchange="                                                  
                    if(!(chk_YearMonth()))
                    {
                    }                                            
                    " 
                    
                     />(YYYYMM)
						</logic:notEqual>
						<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="U">
						<html:text property="yearMonth" styleClass="locked" readonly="true" titleKey="pay.MaintainAnnualIncome.FinYYMM" size="16" maxlength="6" />(YYYYMM)
					</logic:equal>
					</logic:notEqual>
				</td>
				
			</tr>
			<tr id="2"  style="display:none" >
			    
				<td class="labelText"  width="15%"  >
					<bean:message key="Payroll.MediReim.Quarter" />
				</td>
				<td>
					<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="U">
						<html:select property="quarter" name="frmMediReimbursDtlsAll"  titleKey="Payroll.MediReim.quarter" styleClass="locked"  style="WIDTH:30%" disabled="true" >
						<html:option value=" " >---Please Select---</html:option>
							<html:option value="Q1" >Q1</html:option>
							<html:option value="Q2" >Q2</html:option>
							<html:option value="Q3" >Q3</html:option>
							<html:option value="Q4" >Q4</html:option>
						</html:select>
					</logic:equal> 
					<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="U">
						<html:select property="quarter" name="frmMediReimbursDtlsAll"  titleKey="Payroll.MediReim.quarter" styleClass="required"  style="WIDTH:40%"   >
							<html:option value=" " > ---Please Select--- </html:option>
							<html:option value="Q1" >Q1</html:option>
							<html:option value="Q2" >Q2</html:option>
							<html:option value="Q3" >Q3</html:option>
							<html:option value="Q4" >Q4</html:option>
						</html:select>
					</logic:notEqual>
				</td>
			
				<td class="labelText"  width="10%" >
						<bean:message key="pay.MaintainAnnualIncome.FinYYMM" />
				</td>
				 <td width="15%" >                  
					<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
						<html:text property="finYear" styleClass="required" size="18" maxlength="6" titleKey="pay.MaintainAnnualIncome.FinYYMM" 
            
           
                   
                    onblur="                                                  
                    if(!(chk_FinYear1()))
                    {
                    }                                            
                    "
            />(YYYYYY)
					</logic:equal>
					<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
						<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="U">
							<html:text property="finYear" styleClass="required" titleKey="pay.MaintainAnnualIncome.FinYYMM" size="18" maxlength="6"
                   
                    onblur="                                                  
                    if(!(chk_FinYear1()))
                    {
                    }                                            
                    "
              />(YYYYYY)
						</logic:notEqual>
						<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="U">
						<html:text property="finYear" styleClass="locked" readonly="true"  style="text-align:left" titleKey="pay.MaintainAnnualIncome.FinYYMM" size="18" maxlength="6" />(YYYYYY)
					</logic:equal>
					</logic:notEqual>
				</td>
			</tr>
			<tr id="3"  style="display:none">
				<td class="labelText"  width="10%"  >
					<bean:message key="Payroll.MediReim.TaxIndicator" />
				</td>
				<td>
					<html:select  property="taxIndicator" styleClass = "locked" style="width:41%" >
						 <html:option value="N" >---Please Select---</html:option>
						<html:option value="Y"> <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
            <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>
					</html:select>
					
				</td>
				<td class="labelText"  width="10%"  >
					<bean:message key="Payroll.MediReim.Date" />
				</td>
				<td align="left">
				<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
					<html:text property="medicalDate" styleClass="required"  style="text-align:left" size="23" maxlength="50" readonly="true"/>&nbsp;
					<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butSanctionDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>" onclick="showCalendar('medicalDate',this)">
				</logic:equal>
				<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
					<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="Q">
						<html:text property="medicalDate" styleClass="optional"  style="text-align:left" size="23" maxlength="50"  readonly="true"/>
    					<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butSanctionDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>" onclick="showCalendar('medicalDate',this)">
					</logic:equal>
					<logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="Q">
						<html:text property="medicalDate" styleClass="locked"  style="text-align:left" size="23" maxlength="50" readonly="true"/>
					</logic:notEqual>
				</logic:notEqual>
				</td>
			
			</tr>
			<tr>
				<logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
                <TD class=labelText width="10%">
					<bean:message key="Payroll.EmpLoan.ExcEmp" />
				</TD>
                <td align="left" width="10%" nowrap>                  
					<html:textarea property="txtEmpList" cols="" rows="2" name="frmMediReimbursDtlsAll" altKey="Payroll.EmpLoan.ExcEmp" styleClass="optional" readonly="true" style="width: 300px; text-align:left" />
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return showAllLOVEmp();">
                </td>  
                </logic:equal>
                <logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
					<html:hidden property="txtEmpList" />
                </logic:notEqual>
				</td> 
			</tr>
              </table>
		</td>
	</tr>
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
                    <logic:equal property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
                    <td bgcolor="#4682B4" nowrap class=actTabText > Excluded Employees <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    </logic:equal>
                    <logic:notEqual property= "screenMode" name= "frmMediReimbursDtlsAll" value="N">
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
                            
                          <logic:iterate id="LoanDtlsAll" name="frmMediReimbursDtlsAll" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.LoanDtlsAllDetailBean" indexId="idx">
                            <% ++i; %>
                            <logic:notEqual name="LoanDtlsAll" property="status" value="D" >                            
                             <logic:equal name="LoanDtlsAll" property="status" value="N" >                                                        
                            <tr><% ++j; %>                              
                              <td align = "center"><html:checkbox property="checked"  onclick="checkRecord();" value="false" name="frmMediReimbursDtlsAll" /></td>
                              <td width="10%" ><html:text property="txtEmpNo" name="LoanDtlsAll" styleClass="required" readonly="true" style="width:75%;text-align:left"  alt="<%=String.valueOf(i) %>" />&nbsp;<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpLOV" alt="<%=idx%>" name="buttxtEmpLOV" onclick="showAllLOVEmp(this.alt);"></td>                                                         
                              <td width="27%" ><html:text property="txtEmpName" name="LoanDtlsAll" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" readonly="true" /></td>                                                         
                              <td width="23%" ><html:text property="txtDsgn" name="LoanDtlsAll" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" readonly="true" /></td>                                                         
                              <td width="10%" ><html:text property="txtCateg" name="LoanDtlsAll" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" readonly="true" /></td>                                                         
                              <td width="25%" ><html:text property="txtPresentPOP" name="LoanDtlsAll" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" readonly="true" /></td>                                                         
                               
                              <html:hidden property="itemChecked" name="LoanDtlsAll" />
                              <html:hidden property="status" name="LoanDtlsAll" />    
                              <html:hidden property="detailId" name="LoanDtlsAll" value="Default"/>
                              
                            </tr>
                        </logic:equal>
                        <logic:notEqual name="LoanDtlsAll" property="status" value="N" >                                                        
                            <tr><% ++j; %>                              
                              <td align = "center"></td>
                              <td width="10%" ><html:text property="txtEmpNo" name="LoanDtlsAll" styleClass="locked" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="" /></td>                                                         
                              <td width="27%" ><html:text property="txtEmpName" name="LoanDtlsAll" styleClass="locked" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="" /></td>                                                         
                              <td width="23%" ><html:text property="txtDsgn" name="LoanDtlsAll" styleClass="locked" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="" /></td>                                                         
                              <td width="10%" ><html:text property="txtCateg" name="LoanDtlsAll" styleClass="locked" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="" /></td>                                                         
                              <td width="25%" ><html:text property="txtPresentPOP" name="LoanDtlsAll" styleClass="locked" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="lfnChange(alt); " /></td>                                                         
                                                          
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
           <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />

           <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
            <% if(smode.equals(new String("U"))) {%> 
            Update Mode
           <%} else if(smode.equals(new String("N"))) {  %>
            New Mode
           <%} else if(smode.equals(new String("Q"))) {  %>
            Query Mode
           <%}  %>
           </td> 
    
           <td align=center bgcolor=#4682b4 width="30%"></td>
           <td  bgcolor=#4682b4>
		   <logic:equal name="frmMediReimbursDtlsAll" property="screenMode" value="N">
			   <html:button value='Send Invoice' disabled="true" property="butSendInv" styleClass="bottomBarText" />
		   </logic:equal>
		   <logic:notEqual name="frmMediReimbursDtlsAll" property="screenMode" value="N">
			   <logic:equal name="frmMediReimbursDtlsAll" property="screenMode" value="Q">
					<html:button value='Send Invoice' disabled="true" property="butSendInv" styleClass="bottomBarText" />
			   </logic:equal>
			   <logic:notEqual name="frmMediReimbursDtlsAll" property="screenMode" value="Q">
					<html:button value='Send Invoice' onclick="sendInv()" property="butSendInv" styleClass="bottomBarText" />
			   </logic:notEqual>
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

<!-- Container Table Ends -->
<!-- These four hidden fields must be present in pages where there is a detail part -->
<html:hidden name="frmMediReimbursDtlsAll"  property="screenName" value="MediReimbursAllScreen" />
<html:hidden property="totalDetailRecord" name="frmMediReimbursDtlsAll" />
<html:hidden name="frmMediReimbursDtlsAll"  property="forwardedPage" />
<html:hidden name="frmMediReimbursDtlsAll"  property="hdnAction" />    
<html:hidden property="screenMode" name="frmMediReimbursDtlsAll"  />
<html:hidden property="screenModeFlag" name="frmMediReimbursDtlsAll"  />
<html:hidden name="frmMediReimbursDtlsAll"  property="lovKey"  />
<html:hidden name="frmMediReimbursDtlsAll"  property="txtFields" />   
<html:hidden name="frmMediReimbursDtlsAll"  property="txtSearchFields" />
<html:hidden name="frmMediReimbursDtlsAll"  property="txtDisplayFields"  />
<html:hidden name="frmMediReimbursDtlsAll"  property="txtIndex"  />
<html:hidden property="buttonFlag" name="frmMediReimbursDtlsAll"  />
<html:hidden property="userPageRequested" name="frmMediReimbursDtlsAll"  />
<html:hidden property="pageRequested" name="frmMediReimbursDtlsAll"  />
<html:hidden property="positionRequested" name="frmMediReimbursDtlsAll" />
<html:hidden property="userPositionRequested" name="frmMediReimbursDtlsAll" />
<html:hidden property="payYYMM" name="frmMediReimbursDtlsAll" />
<html:hidden name="frmMediReimbursDtlsAll"  property="txtEmpNo"  />
<html:hidden property="loginLocCode" name="frmMediReimbursDtlsAll" />


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
   //alert('inside lfnLoad function')
	var mode  = frmMediReimbursDtlsAll.screenMode.value;
	//alert('inside lfnLoad function , mode is :::'+mode)
    if(mode == "")
    {
        doQueryMode();
    }    
    
    menuHandling(mode); 

    if(mode == 'N')
	{
		clrPayType();
		document.all.butInsert.disabled="disabled";
		document.all.butGetDetail.disabled="disabled";
		document.all.butSendInv.disabled="disabled";
	}
      
    if(mode == 'U')
	{
      clrPayTypeOnload()
      document.all.butInsert.disabled="disabled";
	  document.all.butSave.disabled="disabled";
	  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
	} 
    if(mode == 'Q')
	{
		document.all.butGetDetail.disabled="disabled";  
		document.all.butInsert.disabled="disabled";  
		document.all.butSave.disabled="disabled";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
	}
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";       
}

function sendInv()
{
    if(!mandatory_Check("frmMediReimbursDtlsAll"))
    {
      return false;
    }
    document.all.butSendInv.disabled="true";
	document.all.txtPayCode.disabled="";
    frmMediReimbursDtlsAll.action="../../../EmpMediBillsAllSendInv.do"
    frmMediReimbursDtlsAll.submit();
}

function showAllLOVEmp()
{   
   

  
   frmMediReimbursDtlsAll.lovKey.value = "MediReimBulk" + frmMediReimbursDtlsAll.screenName.value + frmMediReimbursDtlsAll.screenMode.value;
   frmMediReimbursDtlsAll.txtDisplayFields.value = "txtEmpList";
   frmMediReimbursDtlsAll.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";  
   
   if(document.all.txtPayCode.value=='138')
   {
		if(frmMediReimbursDtlsAll.yearMonth.value=="")
		{
			alert("Please enter YYMM.");
			frmMediReimbursDtlsAll.yearMonth.focus();
		    return false;
		}         
         frmMediReimbursDtlsAll.queryParam.value = "txtSiteID="+frmMediReimbursDtlsAll.loginLocCode.value+",hdnEmpLbrFlag="+document.all.hdnEmpLbrFlag.value+",txtPayCode="+document.all.txtPayCode.value+",yearMonth="+frmMediReimbursDtlsAll.yearMonth.value+",quarter="+0+",finYear="+0+",medicalDate=04-Feb-2014";
   }
   
   else if (document.all.txtPayCode.value=='132')
   {
       if (frmMediReimbursDtlsAll.finYear.value=="") 
       {
           alert("Please enter Financial Year");
           return false;
       }
       		frmMediReimbursDtlsAll.queryParam.value = "txtSiteID="+frmMediReimbursDtlsAll.loginLocCode.value+",hdnEmpLbrFlag="+document.all.hdnEmpLbrFlag.value+",txtPayCode="+document.all.txtPayCode.value+",yearMonth="+0+",quarter="+0+",finYear="+frmMediReimbursDtlsAll.finYear.value+",medicalDate=04-Feb-2014";

       
   }
   else if(document.all.txtPayCode.value=='195')
   {
		if(frmMediReimbursDtlsAll.finYear.value=="")
		{
			alert("Please enter Financial Year.");
			return false;
		} 
		frmMediReimbursDtlsAll.queryParam.value = "txtSiteID="+frmMediReimbursDtlsAll.loginLocCode.value+",hdnEmpLbrFlag="+document.all.hdnEmpLbrFlag.value+",txtPayCode="+document.all.txtPayCode.value+",yearMonth="+0+",quarter="+0+",finYear="+frmMediReimbursDtlsAll.finYear.value+",medicalDate=04-Feb-2014";
   }

   else
   {
	   	if(frmMediReimbursDtlsAll.quarter.value==" ")
		{
			alert("Please enter Quarter.");
			frmMediReimbursDtlsAll.quarter.focus();
		    return false;
		} 
		if(frmMediReimbursDtlsAll.finYear.value=="")
		{
			alert("Please enter Financial Year.");
			frmMediReimbursDtlsAll.finYear.focus();
		    return false;
		} 
		if(frmMediReimbursDtlsAll.medicalDate.value=="")
		{
			alert("Please enter Medical Date.");
			frmMediReimbursDtlsAll.medicalDate.focus();
		    return false;
		} 

         
         frmMediReimbursDtlsAll.queryParam.value = "txtSiteID="+frmMediReimbursDtlsAll.loginLocCode.value+",hdnEmpLbrFlag="+document.all.hdnEmpLbrFlag.value+",txtPayCode="+document.all.txtPayCode.value+",quarter="+frmMediReimbursDtlsAll.quarter.value+",finYear="+frmMediReimbursDtlsAll.finYear.value+",yearMonth="+0+",medicalDate="+frmMediReimbursDtlsAll.medicalDate.value;
   }
   
   
   frmMediReimbursDtlsAll.multipleFlag.value = "true";
   frmMediReimbursDtlsAll.txtIndex.value =""; 
   frmMediReimbursDtlsAll.txtInputField.value=""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMediReimbursDtlsAll');
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
  frmMediReimbursDtlsAll.txtEmpList.value = arrEmpNo;
  //document.getElementsByName("txtEmpList").value=arrEmpNo;
  //document.getElementsByName("txtEmpNameList").value=arrEmpName;
}

function doRefresh()
{  
  frmMediReimbursDtlsAll.action="../../../MediReimbursDtlsAllRefresh.do";
  frmMediReimbursDtlsAll.submit();                      
}

function doBaseAddRow()
{
   if(mandatory_Check("frmMediReimbursDtlsAll"))
   {
      document.all.buttonFlag.value='';
      //frmMediReimbursDtlsAll.screenMode.value = "U";  
      document.forms[0].action = "../../../MediReimbursDtlsAllAddRowAction.do";      
      document.forms[0].submit();
   }
    else
    {
        return false;
    }   
}

function doBaseDelRow()
{ 
  if(frmMediReimbursDtlsAll.screenMode.value !='N')
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
      frmMediReimbursDtlsAll.detailDataChanged.value = "true";
    }
  }
  document.forms[0].action = "../../../MediReimbursDtlsAllDeleteRowAction.do";
  document.forms[0].submit();  
}

function doQueryMode()
{    
    //alert('inside doQueryMode')
	document.all.screenMode.value = "Q";
    frmMediReimbursDtlsAll.action="../../../MediReimbursDtlsAllQueryMode.do"
    frmMediReimbursDtlsAll.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmMediReimbursDtlsAll"))
    {        
        document.all.txtEmpNo.disabled = ""; 
	    document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
        frmMediReimbursDtlsAll.action="../../../MediReimbursDtlsAllGetHeaderAction.do"
        frmMediReimbursDtlsAll.submit();
   } 
} 

function doGetNextHeader()
{
    document.all.buttonFlag.value='';     
    //frmMediReimbursDtlsAll.flag.value = "false";    
    frmMediReimbursDtlsAll.userPositionRequested.value = 1*frmMediReimbursDtlsAll.positionRequested.value + 1;    
    frmMediReimbursDtlsAll.action="../../../MediReimbursDtlsAllGetNextHeader.do";
    frmMediReimbursDtlsAll.submit();
}

function PrevHeader()
{
  document.all.buttonFlag.value='';
  //frmMediReimbursDtlsAll.flag.value = "false";
  frmMediReimbursDtlsAll.userPositionRequested.value = 1*frmMediReimbursDtlsAll.positionRequested.value - 1;
  frmMediReimbursDtlsAll.action = "../../../MediReimbursDtlsAllGetNextHeader.do";
  frmMediReimbursDtlsAll.submit();
}

function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmMediReimbursDtlsAll.flag.value = "false";
  frmMediReimbursDtlsAll.userPositionRequested.value = 1*frmMediReimbursDtlsAll.newPositionRequested.value;
  frmMediReimbursDtlsAll.action = "../../../MediReimbursDtlsAllGetNextHeader.do";
  frmMediReimbursDtlsAll.submit();
}

function GetDetail()
{
    document.all.buttonFlag.value='';      
    //document.getElementById("headerPrimaryKey").disabled="";
    //frmMediReimbursDtlsAll.loanType.value=frmMediReimbursDtlsAll.headerPrimaryKey.value;              
    frmMediReimbursDtlsAll.action="../../../MediReimbursDtlsAllDetailAction.do";    
    frmMediReimbursDtlsAll.submit();
 
}

function doInsertMode()
{
    document.all.buttonFlag.value='';        
    frmMediReimbursDtlsAll.action="../../../MediReimbursDtlsAllNewMode.do"
    frmMediReimbursDtlsAll.submit();
}

function doBasePrevDetail()
{
    frmMediReimbursDtlsAll.userPageRequested.value = 1*frmMediReimbursDtlsAll.pageRequested.value - 1;
    frmMediReimbursDtlsAll.action = "../../../MediReimbursDtlsAllNextDetailAction.do";
    frmMediReimbursDtlsAll.submit();
}

function doBaseNextDetail()
{
    frmMediReimbursDtlsAll.userPageRequested.value = 1*frmMediReimbursDtlsAll.pageRequested.value + 1;
    frmMediReimbursDtlsAll.action = "../../../MediReimbursDtlsAllNextDetailAction.do";
    frmMediReimbursDtlsAll.submit();
}

function JumpDetail()
{
    frmMediReimbursDtlsAll.userPageRequested.value = 1*frmMediReimbursDtlsAll.newPageRequested.value ;    
    frmMediReimbursDtlsAll.action = "../../../MediReimbursDtlsAllNextDetailAction.do";
    frmMediReimbursDtlsAll.submit();
}

function SaveRecord()
{
  document.all.buttonFlag.value=''; 
  if(mandatory_Check("frmMediReimbursDtlsAll"))
  {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;     
      var i = 0;  
      if(document.all.hdnEmpLbrFlag.value=="D")
	  {
		  if(frmMediReimbursDtlsAll.txtPayCode.value==200 || frmMediReimbursDtlsAll.txtPayCode.value==138)
		  {
			  alert("This payment is not applicable for DPS labours.");
			  return false;
		  }
	  }
          if((document.all.hdnEmpLbrFlag.value=="L") || (document.all.hdnEmpLbrFlag.value=="E"))
	  {
		  if(frmMediReimbursDtlsAll.txtPayCode.value==132)
		  {
			  alert("This payment is not applicable for Departmental labours and Employees");
			  return false;
		  }
	  }
      frmMediReimbursDtlsAll.headerDataChanged.value = "true";   
      frmMediReimbursDtlsAll.headerFields.value="true";          
      if(iTr2 <= 1)
      {
          frmMediReimbursDtlsAll.headerFields.value="true";          
      }      
      
      frmMediReimbursDtlsAll.totalDetailRecord.value = parseInt(iTr2,10) - 1;      
      document.all.screenModeFlag.value=false;       
      enableAll();
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMediReimbursDtlsAll.action = "../../../MediReimbursDtlsAllSaveAction.do";
      frmMediReimbursDtlsAll.submit();
	  document.all.butSendInv.disabled="true";
	  
	  
  }
  else
  {
    return false;
  }
}

function lfnChange(ind)
{        
    frmMediReimbursDtlsAll.detailDataChanged.value = "true";      
    if (document.getElementsByName("status")[ind-1].value == 'Q')
       document.getElementsByName("status")[ind-1].value = 'U';
  
}

function AllEmpClick() 
{
    document.frmMediReimbursDtlsAll.hdnAction.value = "";  
    document.all.buttonFlag.value='';   
    
    document.frmMediReimbursDtlsAll.action="../../../PLIOptionClickAction.do";
    document.frmMediReimbursDtlsAll.optVal.value="1";
    document.frmMediReimbursDtlsAll.submit(); 
}

function EmpNoClick() 
{
    document.frmMediReimbursDtlsAll.hdnAction.value = "";  
    document.all.buttonFlag.value='';   
    
    document.frmMediReimbursDtlsAll.action="../../../PLIOptionClickAction.do";
    document.frmMediReimbursDtlsAll.optVal.value="2";
    document.frmMediReimbursDtlsAll.submit(); 
}

function chk_FinYear()
{
    var  yearM = document.getElementById("finYear").value;              
    var Year1;
    var Year2;    
    if ( yearM != "") 
    {
        if (num_Check(yearM,1))
        {                                   
            if (yearM.length != 6)
            {
                alert(" Financial Year should be a Six digit Number");
                document.getElementById("finYear").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                            
                return false;    
            }        
            Year1 =  yearM.substring(2,4);
            Year2 =  yearM.substring(4,6);           
            var TempYr1 = parseInt(Year1,10)+1;             
            var TempYr2 = parseInt(Year2,10);   
            var d =new Date();
            var curYr=parseInt(d.getFullYear(),10);
            if((2000+(TempYr1-1)) > curYr)
            {
                alert("Financial Year's Start Year Should Not be greater than Current Year");
                document.getElementById("finYear").focus();   
                document.getElementById("finYear").value="";
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                   
                return false;       

            }
            
           
           if (TempYr1 != TempYr2)
           {
               alert("Year Range Should be in the format of a Financial Period Eg. 200809");
               document.getElementById("finYear").focus(); 
               document.getElementById("finYear").value="";
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
//added by priyanka
function chk_FinYear1()
{


      var finyr=getFinyr(document.getElementById("payYYMM").value);
      var fin_year = document.getElementById("finYear").value;
      var y1 = fin_year.substring(2,4);
      var y2 = fin_year.substring(4,6);
 
	if(fin_year!=""){
		if (num_Check(fin_year,1))
		 {                                   
			if (fin_year.length != 6)
			{
			    alert("Year Month should be a Six digit Number");
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;            
			    return false;
			}
			if ((eval(y1)+1) != eval(y2) )
			{
			    alert("Wrong Financial Year format");
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;            
			    return false;
			}
		    if (eval(finyr) < eval(fin_year))
			{
			    alert("Financial Year can not Exceed Current Financial Year : "+finyr);
			 	event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;            
			    return false;
			}
			return true;
		 }
		 else
		 {
			  document.getElementById("finYear").select();
			  return false;
		 }
    }
}

function chk_YearMonth()
{      
   //alert('inside chk_YearMonth')
	var  yearM = document.getElementById("yearMonth").value;          
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
  //document.all.headerPrimaryKey.disabled="";
  //document.all.loanDesc.disabled="";
  //document.all.noofIntInstall.disabled="";
  //document.all.noofPrnInstall.disabled="";
  //document.all.recStartDate.disabled="";
 
}

function clrPayType()
{
	var vpaycode = document.getElementById("txtPayCode").value ;
	var mode  = frmMediReimbursDtlsAll.screenMode.value;
	if (vpaycode=='138')
	{
		document.getElementById("1").style.display = '';
		document.getElementById("ym").style.display = '';
		document.getElementById("2").style.display = 'none';
		document.getElementById("3").style.display = 'none';
		document.all.taxIndicator.value="FIXED";
		document.all.taxIndicator.disabled="true";    
		document.getElementById("taxIndicator").style.background="#f0e0e0";
		document.all.quarter.value="FIXED";
		document.all.quarter.disabled="true";    
		document.getElementById("quarter").style.background="#f0e0e0";
		document.all.medicalDate.value=" ";
		document.all.medicalDate.disabled="true";    
		document.getElementById("medicalDate").style.background="#f0e0e0";
		document.all.finYear.value="";
		document.all.finYear.disabled="true";    
		document.getElementById("finYear").style.background="#f0e0e0";
		document.all.yearMonth.value="";
		document.all.yearMonth.disabled="";    
		document.getElementById("yearMonth").style.background="#ffffd3";
		document.getElementById("txtEmpList").value="";
		document.all.medicalAmt.value=" ";
		document.all.medicalAmt.readonly="";    
		if(mode=='N')
		{
			document.getElementById("medicalAmt").styleclass="required";
			document.getElementById("medicalAmt").style.background="#ffffd3";
		}
		else
		{
			document.getElementById("medicalAmt").styleclass="optional";
    	}
	}
        else if (vpaycode=='132')
        {
           document.getElementById("1").style.display = '';
		document.getElementById("ym").style.display = 'none';
		document.getElementById("2").style.display = '';
		document.getElementById("3").style.display = 'none';
		document.all.taxIndicator.value="FIXED";
		document.all.taxIndicator.disabled="true";    
		document.getElementById("taxIndicator").style.background="#f0e0e0";
		document.all.quarter.value="FIXED";
		document.all.quarter.disabled="true";   
		document.getElementById("quarter").className="locked";
		document.getElementById("quarter").style.background="#e0e0e0";
		document.all.medicalDate.value=" ";
		document.all.medicalDate.disabled="true";    
		document.getElementById("medicalDate").style.background="#f0e0e0";
		document.all.finYear.value="";
		document.all.finYear.disabled="";    
		document.getElementById("finYear").style.background="#ffffd3";   
		//document.getElementById("finYear").styleclass="locked";
		//document.getElementById("finYear").style.background="#e0e0e0";
		document.all.yearMonth.value="";
		document.getElementById("yearMonth").className="locked";
		document.getElementById("txtEmpList").value="";
		document.all.medicalAmt.value="";
                document.all.medicalAmt.disabled="true"; 
		document.all.medicalAmt.readonly="true";    
		/*if(mode=='N')
		{
			document.getElementById("medicalAmt").styleclass="required";
			document.getElementById("medicalAmt").style.background="#ffffd3";
		}
		else
		{
			document.getElementById("medicalAmt").styleclass="optional";
    	}*/
	} 
        
        
        
	else if (vpaycode=='195')
	{

		document.getElementById("1").style.display = '';
		document.getElementById("ym").style.display = 'none';
		document.getElementById("2").style.display = '';
		document.getElementById("3").style.display = 'none';
		document.all.taxIndicator.value="FIXED";
		document.all.taxIndicator.disabled="true";    
		document.getElementById("taxIndicator").style.background="#f0e0e0";
		document.all.quarter.value="FIXED";
		document.all.quarter.disabled="true";   
		document.getElementById("quarter").className="locked";
		document.getElementById("quarter").style.background="#e0e0e0";
		document.all.medicalDate.value=" ";
		document.all.medicalDate.disabled="true";    
		document.getElementById("medicalDate").style.background="#f0e0e0";
		document.all.finYear.value="201011";
		document.all.finYear.disabled=""; 
		document.all.finYear.readOnly="true";    
		document.getElementById("finYear").styleclass="locked";
		document.getElementById("finYear").style.background="#e0e0e0";
		document.all.yearMonth.value="";
		document.getElementById("yearMonth").className="locked";
		document.getElementById("txtEmpList").value="";
		document.all.medicalAmt.value=" ";
		document.all.medicalAmt.readonly="";    
		if(mode=='N')
		{
			document.getElementById("medicalAmt").styleclass="required";
			document.getElementById("medicalAmt").style.background="#ffffd3";
		}
		else
		{
			document.getElementById("medicalAmt").styleclass="optional";
    	}
	}
	else if (vpaycode=='200')
	{
		// alert('inside alert 1');
		document.getElementById("2").style.display = '';
		document.getElementById("3").style.display = '';
		document.getElementById("1").style.display = '';
		document.getElementById("ym").style.display = 'none';
		document.all.taxIndicator.value="N";
		document.all.taxIndicator.disabled="";    
		document.getElementById("taxIndicator").style.background="#ffffff";
		document.all.quarter.value=" ";
		document.all.quarter.disabled="";    
		document.getElementById("quarter").style.background="#ffffd3";
		document.all.medicalDate.value="";
		document.all.medicalDate.disabled="";    
		document.getElementById("medicalDate").style.background="#ffffd3";
		document.all.finYear.value="";
		document.all.finYear.disabled="";    
		document.getElementById("finYear").style.background="#ffffd3";
		document.all.yearMonth.value=" ";
		document.all.yearMonth.disabled="true";    
		document.getElementById("yearMonth").style.background="#f0e0e0";
		document.getElementById("txtEmpList").value="";
		document.all.medicalAmt.value="";
		document.all.medicalAmt.readonly="";
		if(mode=='N')
		{
			document.getElementById("medicalAmt").styleclass="required";
			document.getElementById("medicalAmt").style.background="#ffffd3";
		}
		else
		{
			document.getElementById("medicalAmt").styleclass="optional";
    	}
	}
	else
	{
		//added to hide the code
		document.getElementById("1").style.display = 'none';
		document.getElementById("ym").style.display = 'none';
		document.getElementById("2").style.display = 'none';
		document.getElementById("3").style.display = 'none';
		document.getElementById("11").style.display = 'block';
		//alert('inside alert');
		document.all.taxIndicator.value="FIXED";
		document.all.taxIndicator.disabled="true";    
		document.getElementById("taxIndicator").style.background="#f0e0e0";
		document.all.quarter.value="FIXED";
		document.all.quarter.disabled="true";    
		document.getElementById("quarter").style.background="#f0e0e0";
		document.all.medicalDate.value=" ";
		document.all.medicalDate.disabled="true";    
		document.getElementById("medicalDate").style.background="#f0e0e0";
		document.all.finYear.value="";
		document.all.finYear.disabled="true";    
		document.getElementById("finYear").style.background="#f0e0e0";
		document.all.yearMonth.value=" ";
		document.all.yearMonth.disabled="true";    
		document.getElementById("yearMonth").style.background="#f0e0e0";
		document.all.medicalAmt.value=" ";
		document.all.medicalAmt.readonly="true";    
		document.getElementById("medicalAmt").style.background="#f0e0e0";
		document.getElementById("txtEmpList").value="";
    }
}

function clrPayTypeOnload()
{
	var vpaycode = document.getElementById("txtPayCode").value ;
	if (vpaycode=='138')
	{
		document.getElementById("1").style.display = '';
		document.getElementById("ym").style.display = '';
		document.getElementById("2").style.display = 'none';
		document.getElementById("3").style.display = 'none';
	}
	else if (vpaycode=='200')
	{
		// alert('inside alert 1');
		document.getElementById("2").style.display = '';
		document.getElementById("3").style.display = '';
		document.getElementById("1").style.display = '';
		document.getElementById("ym").style.display = 'none';
	}
	else
	{
		//added to hide the code
		document.getElementById("1").style.display = 'none';
		document.getElementById("ym").style.display = 'none';
		document.getElementById("2").style.display = 'none';
		document.getElementById("3").style.display = 'none';
		document.getElementById("11").style.display = 'block';
    }
}
</script>

