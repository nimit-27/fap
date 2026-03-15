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
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0; %>
<% i = 0; j=0; %>

<html:form  action="MaintDirectPayBulkBase" name="frmDirectPayrollBulk" type="FCIPAY.Payroll.WEBTIER.Form.DirectPayrollBulkForm" scope="session">
<bean:define id="ParentForm" name="frmDirectPayrollBulk" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="optVal" />
<html:hidden property="lovKey" name="frmDirectPayrollBulk"  />
<html:hidden property="txtFields" name="frmDirectPayrollBulk"  />   
<html:hidden property="txtSearchFields" name="frmDirectPayrollBulk"  />
<html:hidden property="txtDisplayFields" name="frmDirectPayrollBulk"  />
<html:hidden property="txtIndex" name="frmDirectPayrollBulk"  />
<html:hidden property="txtInputField" name="frmDirectPayrollBulk"  />


<table border = 0>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10><bean:message key="Payroll.MaintDirect.headbulk" /></TD>
</TR>
</TABLE>
<html:errors/>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       <!--<div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6><bean:message key="Payroll.MaintDirect.hd" /></TD>
        </TR>
        <TR>
            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>

         <tr height="10">
         <td width="100%">
         <table width="100%" cellSpacing=0 cellPadding=0 border="0">   
              <TR>
                  <TD class=labelText><bean:message key="Payroll.MaintDirect.code" /></TD>
                  <td align="left" colspan="2" >                        
				  <logic:equal property="screenMode" name="frmDirectPayrollBulk" value="Q">
					  <html:text  property="headerPrimaryKey" altKey="Payroll.MaintDirect.code" maxlength="10" size="15" styleClass="required"  onblur="lfnGetPayCodeName(this.value)" readonly="true" />
	     			  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayCode1" onclick="ShowLovPayCode();" >&nbsp;&nbsp;
	                  <html:text  property="txtPayCodeName"  maxlength="10" size="50" styleClass="locked" readonly="true" /></td>
				  </logic:equal>


				  <logic:notEqual property="screenMode" name="frmDirectPayrollBulk" value="Q">
					 <logic:equal property="screenMode" name="frmDirectPayrollBulk" value="N">
					  <html:select property="headerPrimaryKey" name="frmDirectPayrollBulk"  styleClass="required" alt="" style="width:55%" onchange="clrPayType();"   >
					  <html:option value="307">Professional Tax</html:option>
					  <html:option value="348">Labour Welfare Fund</html:option>
					  <html:option value="345">Contributory Scheme</html:option>
					  <html:option value="346">Benevolent Fund</html:option>
					  <html:option value="507">ESI Deduction</html:option>
                                          <html:option value="229">Liveries And Tailoring Allowance</html:option>
					  </html:select>
					 </logic:equal>
					
					 <logic:notEqual property="screenMode" name="frmDirectPayrollBulk" value="N">
					  <html:select property="headerPrimaryKey" name="frmDirectPayrollBulk"  styleClass="locked" disabled="true" alt="" style="width:17%" onchange="clrPayType();"   >
					  <html:option value="307">Professional Tax</html:option>
					  <html:option value="348">Labour Welfare Fund</html:option>
					  <html:option value="345">Contributory Scheme</html:option>
					  <html:option value="346">Benevolent Fund</html:option>
					  <html:option value="507">ESI Deduction</html:option>
                                          <html:option value="229">Liveries And Tailoring Allowance</html:option>
					  </html:select>
					  </logic:notEqual>
				  </logic:notEqual>
           </TR> 
		   
		   <TR>
                 <TD class=labelText><bean:message key="Payroll.MaintDirect.depo" /></TD>
                 <td align="left" colspan="1"> 
					  <html:text  property="txtDepoCode" altKey="Payroll.MaintDirect.depo" maxlength="7" size="10" styleClass="optional"  readonly="true" />
	     			  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayCode1" onclick="ShowDepoCode()" >;   
	                  <html:text  property="txtDepoName"  maxlength="10" size="28" styleClass="locked" readonly="true" /></td>

                <%
                  if(lbrType.equals("E")){
                 %>
                          <html:hidden property="txtGangId" /> 
                <%}else{%>
                     <TD class=labelText><bean:message key="Payroll.MaintDirect.gang" /></TD>
                 <td align="left" colspan="2"> 
					  <html:text  property="txtGangId" altKey="Payroll.MaintDirect.gang" maxlength="10" size="15" styleClass="optional"   readonly="true" />
	     			  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayCode1" onclick="ShowLovGang();" >;
	                  <html:text  property="txtGangName"  maxlength="10" size="40" styleClass="locked" readonly="true" />
					  </td>
                 <%}%>


				  <!--
				  <html:text  property="headerPrimaryKey" altKey="Payroll.MaintDirect.code" maxlength="10" size="15" styleClass="required"  onblur="lfnGetPayCodeName(this.value)" readonly="true" />
				  <logic:equal property="screenMode" name="frmDirectPayrollBulk" value="Q">
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayCode1" onclick="ShowLovPayCode();" >&nbsp;&nbsp;
				  </logic:equal>
				  <logic:notEqual property="screenMode" name="frmDirectPayrollBulk" value="Q">
					<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayCode1"  >&nbsp;&nbsp;
				  </logic:notEqual>
                  <html:text  property="txtPayCodeName"  maxlength="10" size="40" styleClass="locked" readonly="true" /></td>
                  </td>
				  -->
              </TR>             
            
              <tr>              
                <td class=labelText width="16%" ><bean:message key="Payroll.MaintDirect.paym" /></td>
                <td colspan="1" width="17%" >
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">
                <html:select property="txtPayMode" name="frmDirectPayrollBulk"  styleClass="required" alt="" style="width:83%" onchange=""   >
                <html:option value=" ">------Please select------</html:option>
                <html:option value="1">1 - Current Payment</html:option>
                <html:option value="2">2 - Current Recovery</html:option>
                <html:option value="4">4 - Arrear Payment</html:option>
                <html:option value="5">5 - Arrear Recovery</html:option>
                </html:select>
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">
                <html:select property="txtPayMode" name="frmDirectPayrollBulk"  styleClass="required" style="width:83%" alt="" onchange=""   >
                <html:option value=" ">------Please select------</html:option>
                <html:option value="1">1 - Current Payment</html:option>
                <html:option value="2">2 - Current Recovery</html:option>
                <html:option value="4">4 - Arrear Payment</html:option>
                <html:option value="5">5 - Arrear Recovery</html:option>
                </html:select>
                </logic:notEqual>
                </td>                  
              
                <td class="labelText"  width="16%"  ><bean:message key="Payroll.MaintDirect.fm" /> </td>
                <td width="17%" >                  
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtValidFrom" styleClass="required"  style="text-align:left" size="23" maxlength="6" readonly="" onblur="if(!(chk_YearMonth()))
				         {
                          } "  onkeypress="if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };"  />&nbsp;
                
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtValidFrom" styleClass="required"  style="text-align:left" size="23" maxlength="6" readonly="" onchange=""  />&nbsp;
                
                </logic:notEqual>
                </td>
                
                <td class=labelText width="16%" ><bean:message key="Payroll.MaintDirect.payTyp" /></td>
                <td colspan="1" width="17%" >
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">
                <html:select property="txtPayType" name="frmDirectPayrollBulk"  styleClass="required" alt="" style="width:83%" onchange="onChangePayTyp(this.value);"   >
                <html:option value=" ">------Please select------</html:option>
                <html:option value="FIXED">Fixed Amount</html:option>
                <html:option value="SALRY">Salary</html:option>                        
                </html:select>
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">
                <html:select property="txtPayType" name="frmDirectPayrollBulk"  styleClass="optional" alt="" style="width:83%" onchange=""   >
                <html:option value=" ">------Please select------</html:option>
                <html:option value="FIXED">Fixed Amount</html:option>
                <html:option value="SALRY">Salary</html:option>                
                </html:select>
                </logic:notEqual>
                </td>              
                            
              </tr>
              
              <tr>    
              
                <td class="labelText"  width="16%"  ><bean:message key="Payroll.MaintDirect.NfDays" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtNoofDays" styleClass="optional"  style="text-align:right" size="23" maxlength="5" onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }                                    
                    " onchange="" />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtNoofDays" styleClass="optional"  style="text-align:right" size="23" maxlength="5"  onchange=""  />
                </logic:notEqual>
                </td>
                
                <td class="labelText"  width="16%"  ><bean:message key="Payroll.MaintDirect.amt" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtAmount" styleClass="required"  style="text-align:right" size="23" maxlength="8" onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }                                    
                    " onchange="checkInstAmt();"  />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtAmount" styleClass="optional"  style="text-align:right" size="23" maxlength="8"  onchange=""  />
                </logic:notEqual>
                </td>
                
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.MaintDirect.instAmt" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtInstAmount" styleClass="required"  style="text-align:right" size="23" maxlength="5" onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }                                    
                    " onchange="checkInstAmt();" /> 
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtInstAmount" styleClass="optional"  style="text-align:right" size="23" maxlength="5"  onchange=""  />
                </logic:notEqual>
                </td>                 
              </tr>
              
              <tr>
              
                <td class="labelText"  width="16%"  ><bean:message key="Payroll.MaintDirect.noInst" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtNoInst" styleClass="locked"  style="text-align:right" size="23"  readonly="true" maxlength="5" onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }                                    
                    " onchange="" />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtNoInst" styleClass="optional"  style="text-align:right" size="23" maxlength="5" onchange=""  />
                </logic:notEqual>
                </td>   
                
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.MaintDirect.advBal" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtAdvBalance" styleClass="optional"  style="text-align:right" size="23" readonly="true" maxlength="8" onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }                                    
                    " onchange=""  />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtAdvBalance" styleClass="optional"  style="text-align:right" size="23" maxlength="8" onchange=""  />
                </logic:notEqual>
                </td>
              
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.MaintDirect.agencycod" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtAgencyName" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange="checkSite();" />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtAgncyCode" onclick="ShowLovAgencyCode();" >
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtAgencyName" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50"  onchange="checkSite();" />
                </logic:notEqual>
                </td>                               
                
              </tr> 
              <tr>
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.MaintDirect.agencysite" /> </td>
                <td >                  
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtAgencySite" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtAgncySite" onclick="ShowLovAgencySiteCode();" >
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">                              
                <html:text property="txtAgencySite" styleClass="optional"  style="text-align:left" size="23" readonly="true" maxlength="50" onchange=""  />
                </logic:notEqual>
                </td> 
              </tr>
                         
            </table>
        <TD colspan="6" > </TD>
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
                <logic:equal property= "screenMode" name= "frmDirectPayrollBulk" value="N">
                <td bgcolor="#4682B4" nowrap class=actTabText > Employees to be Excluded<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                </logic:equal>
                <logic:notEqual property= "screenMode" name= "frmDirectPayrollBulk" value="N">
                <td bgcolor="#4682B4" nowrap class=actTabText > Excluded Employees <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                </logic:notEqual>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="11">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD > 
                      
                        <DIV id=divDtlTable style="height:280px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail">
                          <TBODY>
                                  <TR>
                                    <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                    <td class=tableHeader width="6%"><bean:message key="Payroll.MaintDirect.srno" /></td>
                                    <td class=tableHeader width="6%"><bean:message key="Payroll.MaintDirect.emp"  /></td>
                                    <td class=tableHeader width="20%"><bean:message key="Payroll.MaintDirect.name" /></td>                                               
                                    <TD class=tableHeader width="20%"><bean:message  key="Payroll.EmpInfo.Desig" /></td>
                                    <TD class=tableHeader width="12%"><bean:message  key="Payroll.EmpInfo.lstCateg" /></td>
                                    <TD class=tableHeader width="12%"><bean:message  key="Payroll.EmpInfo.PresentPOP" /></td>
                                    </TR>
                           
                                <logic:iterate id="DirectPayrollInfo" name="frmDirectPayrollBulk" property="lstInstrDtls"  type="FCIPAY.Payroll.UTILITY.DirectPayrollBulkBean"   indexId="idx">          
                                <% ++i; %>
                                <logic:notEqual name="DirectPayrollInfo" property="status" value="D" >  
                                <tr>
                                <logic:notEqual name="DirectPayrollInfo" property="status" value="U">
                                <td ><html:checkbox property="checked" onclick="checkRecord();" name="frmDirectPayrollBulk" /></td>
                                </logic:notEqual>
                                <logic:equal name="DirectPayrollInfo" property="status" value="U">
                                <td >&nbsp;</td>
                                </logic:equal>
                                <logic:notEqual name="DirectPayrollInfo" property="status" value="Q" >                                                           
                                  <% ++j; %>
                                       <td ><html:text property="txtSrNo" name="DirectPayrollInfo" size="3"   value="<%=String.valueOf(i) %>" styleClass="locked" style="width:100%" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt);"  /></td>
                                       <td ><html:text property="txtEmpNo" name="DirectPayrollInfo" readonly="true"  styleClass="required" size="6" style="width:70%" alt="<%=String.valueOf(i) %>" onchange="
                                       checkDuplicacy(this,this.alt)"   onblur=""   />
                                      <logic:equal name="DirectPayrollInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  onclick="ShowLovEmpNo1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowLovEmpNo1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowLovEmpNo1(this.alt);" >
                                       </logic:equal>
                                       </td>
                                       
                                       <td ><html:text property="txtName" name="DirectPayrollInfo" size="18" style="width:100%" styleClass="locked" readonly="true" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt);" /></td>
                                       <td  width="20%" ><html:text property="txtDsgn" name="DirectPayrollInfo" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="9" readonly="true" /></td>                                                         
                                       <td  width="12%" ><html:text property="txtCateg" name="DirectPayrollInfo" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="9" readonly="true" /></td>                                                         
                                       <td  width="12%" ><html:text property="txtPresentPOP" name="DirectPayrollInfo" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i) %>" maxlength="9" readonly="true" /></td>                                                   
                                       
                                       <html:hidden property="txtSrlNo" name="DirectPayrollInfo" />
                                       
                                       <html:hidden property="itemChecked" name="DirectPayrollInfo" />
                                       <html:hidden property="status" name="DirectPayrollInfo" />
                                       <html:hidden property="detailId" name="DirectPayrollInfo" value="Default"/>
                                    
                                  </logic:notEqual>
                                  <logic:equal name="DirectPayrollInfo" property="status" value="Q" >
                                      <% ++j; %>
                                       <td ><html:text property="txtSrNo" name="DirectPayrollInfo" size="3"   value="<%=String.valueOf(i) %>" styleClass="locked" style="width:100%" alt="<%=String.valueOf(i) %>" readonly="true"  /></td>
                                       <td ><html:text property="txtEmpNo" name="DirectPayrollInfo"  styleClass="locked" size="6" style="width:70%" alt="<%=String.valueOf(i) %>" readonly="true" />
                                      <logic:equal name="DirectPayrollInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=String.valueOf(idx)%>" property="buttxtEmpNo"   >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=String.valueOf(idx)%>" property="buttxtEmpNo"  disabled onclick="ShowLovEmpNo1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowLovEmpNo1(this.alt);" >
                                       </logic:equal>
                                       </td>                                       
                                       <td ><html:text property="txtName" name="DirectPayrollInfo" size="18" style="width:100%" styleClass="locked" readonly="true" alt="<%=String.valueOf(i) %>" /></td>
                                       
                                       <td ><html:text property="txtDsgn" name="DirectPayrollInfo" size="6" styleClass="locked" readonly="true" style="width:100%" alt="<%=String.valueOf(i) %>" /></td>
                                       <td ><html:text property="txtCateg" name="DirectPayrollInfo" size="6" styleClass="locked" readonly="true" style="width:100%" alt="<%=String.valueOf(i) %>" /></td>                                       
                                       <td ><html:text property="txtPresentPOP" name="DirectPayrollInfo"  styleClass="locked" size="6" style="width:70%" alt="<%=String.valueOf(i) %>" readonly="true" />
                                       
                                       <html:hidden property="txtSrlNo" name="DirectPayrollInfo" />                                                                                                                      
                                       <html:hidden property="itemChecked" name="DirectPayrollInfo" />
                                       <html:hidden property="status" name="DirectPayrollInfo" />
                                       <html:hidden property="detailId" name="DirectPayrollInfo" value="Default"/>
                                    
                                  </logic:equal>
                                  </tr>
                                  </logic:notEqual>
                                  <logic:equal name="DirectPayrollInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmDirectPayrollBulk" value="notchecked" /></td>
                                       <td ><html:hidden property="txtSrNo" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtEmpNo" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtName" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtDsgn" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtCateg" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtPresentPOP" name="DirectPayrollInfo" /></td>
                                       
                                       <html:hidden property="txtSrlNo" name="DirectPayrollInfo" />                                                                                                                        
                                       <html:hidden property="itemChecked" name="DirectPayrollInfo" />
                                       <html:hidden property="status" name="DirectPayrollInfo" />
                                       <html:hidden property="detailId" name="DirectPayrollInfo" value="Default"/>
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
                  <TABLE border=0>
                    <TBODY>
                    <TR>
                      <TD>
                      <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                      </td>		         </TR>
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
	<TR>
	   <td align=center bgcolor=#4682b4 width="40%"></td>
	   <td bgColor=#4682b4></td>
	   <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	</TR>
	<table>
		<TR><td><b>Note:</b> Professional Tax and Labour Welfare Fund (pay code-307,348) can only be paid using this User Interface. To pay select the Pay Code from the drop down box in Insert Mode.</td></TR>
	</table>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->

<html:hidden property="hdnCurYYMM" name="frmDirectPayrollBulk"  />
<html:hidden property="hdnAction" name="frmDirectPayrollBulk"  />
<html:hidden property="hdnRowVal" name="frmDirectPayrollBulk"  />
<html:hidden property="hdnEmpNo" name="frmDirectPayrollBulk"  />
<html:hidden property="hdnEmpName" name="frmDirectPayrollBulk"  />
<html:hidden property="hdnPayCode" name="frmDirectPayrollBulk"  />
<html:hidden property="hdnPayCodeName" name="frmDirectPayrollBulk"  />
<html:hidden property="hdnPayStatus" name="frmDirectPayrollBulk"  />
<html:hidden property="headerPrimaryKey" name="frmDirectPayrollBulk"  />
<html:hidden property="screenMode" name="frmDirectPayrollBulk"  />
<html:hidden property="screenModeDir" name="frmDirectPayrollBulk"  />
<html:hidden name="frmDirectPayrollBulk"  property="screenName" value="DirPayrollBulkScreen" />
<html:hidden name="frmDirectPayrollBulk"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmDirectPayrollBulk"  />
<html:hidden property="userPageRequested" name="frmDirectPayrollBulk" />
<html:hidden property="pageRequested" name="frmDirectPayrollBulk" />
<html:hidden property="buttonFlag" name="frmDirectPayrollBulk"  />

<html:hidden property="txtTxnCateg" name="frmDirectPayrollBulk" />
<html:hidden property="txtPayrollFlag" name="frmDirectPayrollBulk"  />

<html:hidden property="txtAgency" name="frmDirectPayrollBulk" />
<html:hidden property="txtAgencySiteCode" name="frmDirectPayrollBulk"  />

<html:hidden property="positionRequested" name="frmDirectPayrollBulk" />
<html:hidden property="userPositionRequested" name="frmDirectPayrollBulk" />

<html:hidden property="loginLocCode" name="frmDirectPayrollBulk"  />
<html:hidden property="payTxnHdrId" name="frmDirectPayrollBulk"  />
<input type="hidden" name="queryParam" />
</html:form>
</body>
</html:html>
         

<script language="javascript">

var chkMes = 0;

function lfnLoad()
{
  mode = document.all.screenMode.value;  
 // alert("screenMode---->"+mode);
  if(mode=='')
  {
      doQueryMode();
  }
   
  if (document.all.screenModeDir.value == "")
  {
     document.all.screenModeDir.value = "Q";
     document.all.screenMode.value = "Q";    
  }
  
  if(mode=='U')
  {
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";      
   
  }    
  mode = document.all.screenModeDir.value;  
  //alert("screenModeDir----"+mode);
  if(mode=='')
  {
     document.all.butGetDetail.disabled="";   
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
  }

  if(mode=='Q')
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
	  //document.getElementById("headerPrimaryKey").value=307;
	  //document.getElementById("txtPayCodeName").value="Professional Tax";
  }

  if(mode=='UG')
  {
      document.all.butGetDetail.disabled="disabled";    
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";
  }  
   if(mode=='U1')
  {
      document.all.butGetDetail.disabled="";    
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";
  }    
  
  document.all.butDelete.disabled="true";
  mode1 = frmDirectPayrollBulk.screenMode.value;  
  //alert("screenMode----"+mode1);
  if(mode=='N' && mode1=='U')
  {      
      document.all.butInsert.disabled="disabled";      
  }
  
 clrPayType();   // removed by dushyant
  menuHandling(mode1);  
  onLoadPayTyp();
}

function changed(val)
{
  frmDirectPayrollBulk.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
  document.getElementsByName("status")[val-1].value = 'U';
}

function agChanged(val)
{
  document.getElementsByName("txtAgencySite")[val-1].value="";
  document.getElementsByName("txtAgencySiteCode")[val-1].value="";
  frmDirectPayrollBulk.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
  document.getElementsByName("status")[val-1].value = 'U';
}


function doBaseAddRow()
{
  document.all.buttonFlag.value='D';
  if(!mandatory_Check("frmDirectPayrollBulk"))
        return false;   
 //frmDirectPayrollBulk.screenMode.value = "U";  
 frmDirectPayrollBulk.action = "../../../DirPayrollBulkAddRowAction.do";
 //enable(); 
 frmDirectPayrollBulk.submit();
}

function doBaseDelRow()
{
  document.all.buttonFlag.value='D';
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

   var flag = 0;
   for(i=0; i < iTr2 -1; i++)
    {
        if(document.getElementsByName("status")[i].value=='N')
        {
            flag=flag+1;
        }
    } 
    for(i=0; i < iTr2 -1; i++)
    {    
      if(document.getElementsByName("checked")[i].checked)
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
        frmDirectPayrollBulk.detailDataChanged.value = "true"; 
      }
    }
     if ( flag != 0)
     {
        //enable();
        document.forms[0].action = "../../../DirPayrollBulkdeleteRowAction.do";
        document.forms[0].submit();  
    }
    else
    {
      alert("Records Cannot be deleted!")
    }
}

function GetDetail()
{ 
 document.all.buttonFlag.value='';
 document.all.screenModeDir.value = 'UG';

  frmDirectPayrollBulk.screenMode.value='U';
  frmDirectPayrollBulk.headerDataChanged.value = "false";

   if(!mandatory_Check("frmDirectPayrollBulk"))
        return false;    
        
  frmDirectPayrollBulk.action="../../../DirPayrollBulkGetDetailAction.do"  
  frmDirectPayrollBulk.submit();
}


function SaveRecord()
{
 document.all.buttonFlag.value='';
 checkSite();           
 if(!mandatory_Check("frmDirectPayrollBulk"))
        return false;    
      
  //if(!checkInstAmt())
     //return; 

   var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
        document.getElementsByName("txtEmpNo")[i].disabled="";        

      if (document.getElementsByName("status")[i].value == 'D')
        frmDirectPayrollBulk.detailDataChanged.value = "true";
  }

  //frmDirectPayrollBulk.screenMode.value='U';  
  
  frmDirectPayrollBulk.totalDetailRecord.value = parseInt(iTr2,10) - 1;
  
  frmDirectPayrollBulk.detailDataChanged.value = "true";   
  frmDirectPayrollBulk.headerFields.value="true"; 
  enable();
  if (document.all.screenMode.value == "N")
  {
     document.all.screenModeDir.value = "UG";     
  }
	document.all("txtInstAmount").disabled="";
	document.all("txtAdvBalance").disabled="";
	document.all("headerPrimaryKey").disabled="";
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	frmDirectPayrollBulk.action = "../../../DirPayrollBulkSaveAction.do";  
	frmDirectPayrollBulk.submit();
}


function chk_FromAmount(fieldval, rowval)
{
      if(num_Check(fieldval,0))  
      {
        
          if (chk_FromToAmount(rowval)) 
          {
          changed(rowval);
            chkMes = 0;
            return true;            
          }
          else
          {
            chkMes = 1;
            return false;
          }
        
      }
      else
      {
        chkMes = 1;      
        return false;
      }
}


function chk_ToAmount(fieldval, rowval)
{      
      if (chkMes == 0)
      {
          if(num_Check(fieldval,0))  
          {
            if (chk_ToFromAmount(rowval)) 
            {
              changed(rowval);
                return true;
            }
            else
            {
              return false;        
            }
          }
          else
          {
            return false;
          }
          return true;
      }
      return true;
}


function chk_FromToAmount(i)
   {     
         
          var from = parseInt(document.getElementsByName("txtValidFrom")[i-1].value);          
          var to = parseInt(document.getElementsByName("txtValidUpto")[i-1].value);
         
          if(to < from )
          {
     //       alert("Valid Upto Should be greater than or Equal To Valid From ");
            document.getElementsByName("txtValidUpto")[i-1].focus(); 

/*            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            */
            
            return false;                        
          }
          else
          return true;
   }

  function chk_ToFromAmount(i)
   {              
          var from = parseInt(document.getElementsByName("txtValidFrom")[i-1].value);          
          var to = parseInt(document.getElementsByName("txtValidUpto")[i-1].value);
         
          if(to < from )
          {
           //  alert("Valid Upto Should be greater than or Equal To Valid From ");
            document.getElementsByName("txtValidUpto")[i-1].focus();             
            return false;                        
          }
          else
          return true;
   }





function doSetFlag(flag)
{
  document.all.criteria.value=flag;
  alert('criteria in jsp='+document.all.criteria.value);  
  doExecute();  
}

	function EmpClick()
  {
    document.all.buttonFlag.value='';
    document.frmDirectPayrollBulk.hdnAction.value = "";    
 
    if (  document.all.screenModeDir.value == 'UG')
          document.all.screenModeDir.value = 'U';
    document.frmDirectPayrollBulk.action="../../../DirectPayOptionClickAction.do";
    document.frmDirectPayrollBulk.optVal.value="1";     
    document.frmDirectPayrollBulk.submit();
	}

	function PayClick() 
  {
  document.frmDirectPayrollBulk.hdnAction.value = "";  
    document.all.buttonFlag.value='';
 
    if (  document.all.screenModeDir.value == 'UG')
          document.all.screenModeDir.value = 'U';
  

    document.frmDirectPayrollBulk.action="../../../DirectPayOptionClickAction.do";
    document.frmDirectPayrollBulk.optVal.value="2";
    document.frmDirectPayrollBulk.submit(); 
	}
  
	function MiscClick() 
  {
   document.all.buttonFlag.value='';
        document.frmDirectPayrollBulk.hdnAction.value = "";   
 
    if (  document.all.screenModeDir.value == 'UG')
          document.all.screenModeDir.value = 'U';

    document.frmDirectPayrollBulk.action="../../../DirectPayOptionClickAction.do";
    document.frmDirectPayrollBulk.optVal.value="3";        
    document.frmDirectPayrollBulk.submit(); 
	}

function doInsertMode()
{
    document.frmDirectPayrollBulk.hdnAction.value = "";
    document.all.buttonFlag.value='';
    document.all.screenModeDir.value = 'N';
    frmDirectPayrollBulk.headerDataChanged.value = "false";
    
    frmDirectPayrollBulk.action="../../../DirPayrollBulkNewMode.do"
    frmDirectPayrollBulk.submit();
}

function doQueryMode()
{  
    document.all.buttonFlag.value='';
    document.frmDirectPayrollBulk.hdnAction.value = "";  
    document.all.screenModeDir.value = 'Q';

    frmDirectPayrollBulk.action="../../../DirPayrollBulkQueryMode.do"
    frmDirectPayrollBulk.submit();
}

function enable()
{
  if (document.all.txtPayType.value=='FIXED')
  {    
	document.getElementById("txtNoofDays").disabled = ""; 
	document.getElementById("txtNoofDays").disabled = "";
	document.getElementById("txtInstAmount").disabled = "";
	document.getElementById("txtNoInst").disabled = "";
	document.getElementById("txtNoInst").disabled = "";
	document.getElementById("txtAdvBalance").disabled = "";
	document.getElementById("txtPayType").disabled = ""; 
  }
  
  if (document.all.txtPayType.value=='SALRY')
  {
    document.all.txtAmount.disabled="";      
    document.all.txtInstAmount.disabled="";
    document.all.txtAdvBalance.disabled="";  
    
  } 
  
}


function ShowLovEmpNo1(i)
{
	//alert("queryParam-->"+frmDirectPayrollBulk.queryParam.value);
   frmDirectPayrollBulk.lovKey.value = "MaintDirectPayrollEmp" + frmDirectPayrollBulk.screenName.value + "N";
   frmDirectPayrollBulk.txtDisplayFields.value = "txtEmpNo,txtName,txtCateg,txtDsgn,txtPresentPOP";
   frmDirectPayrollBulk.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
   frmDirectPayrollBulk.queryParam.value="txtSiteID="+frmDirectPayrollBulk.loginLocCode.value+",hdnEmpLbrFlag="+frmDirectPayrollBulk.hdnEmpLbrFlag.value+",txtDepoCode= "+frmDirectPayrollBulk.txtDepoCode.value+",txtGangId= "+frmDirectPayrollBulk.txtGangId.value;  
  // alert("queryParam-->"+frmDirectPayrollBulk.queryParam.value);
   frmDirectPayrollBulk.txtIndex.value=i;  
   frmDirectPayrollBulk.txtInputField.value="txtEmpNo";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDirectPayrollBulk');
   return true;
}


function ShowLovPayCode()
{
   
   frmDirectPayrollBulk.lovKey.value = "MaintDirectPayrollPayCode" + frmDirectPayrollBulk.screenName.value + frmDirectPayrollBulk.screenMode.value;
   frmDirectPayrollBulk.queryParam.value = "hdnEmpLbrFlag="+frmDirectPayrollBulk.hdnEmpLbrFlag.value+",screenName="+frmDirectPayrollBulk.screenName.value+",screenMode="+frmDirectPayrollBulk.screenMode.value+",txtSiteID="+frmDirectPayrollBulk.loginLocCode.value;   // added by swapnendu Dt 07 Sep 2012.
   frmDirectPayrollBulk.txtDisplayFields.value = "headerPrimaryKey,txtPayCodeName";
   frmDirectPayrollBulk.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";
   frmDirectPayrollBulk.txtIndex.value="";  
   frmDirectPayrollBulk.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDirectPayrollBulk');
   return true;
}

function ShowLovAgencyCode()
{
     frmDirectPayrollBulk.lovKey.value = "MaintDirectPayrollAgencyCode" + frmDirectPayrollBulk.screenName.value +"N";
     frmDirectPayrollBulk.txtDisplayFields.value = "txtAgency,txtAgencyName";
     frmDirectPayrollBulk.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Agency,Payroll.Common.Desc,Payroll.Common.SupNo";
   
     frmDirectPayrollBulk.queryParam.value="txtSiteID="+frmDirectPayrollBulk.loginLocCode.value+",txtEmpNo=1"+",txtPayCode="+document.getElementById("headerPrimaryKey").value;

     frmDirectPayrollBulk.txtIndex.value="";  
     frmDirectPayrollBulk.txtInputField.value ="txtAgencyName";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDirectPayrollBulk');
     return true;
 }

function ShowLovAgencySiteCode()
{
   if(document.all.txtAgency.value=="")
   {
      alert("Please select Agency Code first!!!");
      return false;
   }
   frmDirectPayrollBulk.lovKey.value = "MaintDirectPayrollAgencySiteCode" + frmDirectPayrollBulk.screenName.value + "N";
   frmDirectPayrollBulk.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySite";
   
   frmDirectPayrollBulk.queryParam.value = "txtSiteID="+frmDirectPayrollBulk.loginLocCode.value+",txtAgency="+document.all.txtAgency.value;
   frmDirectPayrollBulk.txtSearchFields.value = "";
   frmDirectPayrollBulk.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDirectPayrollBulk');
   return true;
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmDirectPayrollBulk"))
    {
        //document.all.headerMode.value = "U";
        //document.all.headerMode1.value = "U";       
          
        //document.all.screenModeFlag.value='UG';  
        document.all.screenModeDir.value = "U1";
        //document.all.txtEmpNo.disabled = "";        
        
        frmDirectPayrollBulk.action="../../../DirPayrollBulkGetHeaderAction.do"
        frmDirectPayrollBulk.submit();
   }
 
} 

function doGetNextHeader()
{
    document.all.buttonFlag.value='';     
    //frmDirectPayrollBulk.flag.value = "false";    
    document.all.screenModeDir.value = "U1";
    frmDirectPayrollBulk.userPositionRequested.value = 1*frmDirectPayrollBulk.positionRequested.value + 1;    
    
    frmDirectPayrollBulk.action="../../../DirPayrollBulkGetNextHeader.do";
    frmDirectPayrollBulk.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  //frmDirectPayrollBulk.flag.value = "false";
  document.all.screenModeDir.value = "U1";
  frmDirectPayrollBulk.userPositionRequested.value = 1*frmDirectPayrollBulk.positionRequested.value - 1;
  frmDirectPayrollBulk.action = "../../../DirPayrollBulkGetNextHeader.do";
  frmDirectPayrollBulk.submit();
}


function JumpHeader()
{
  document.all.buttonFlag.value='';
  //frmDirectPayrollBulk.flag.value = "false";
  document.all.screenModeDir.value = "U1";
  frmDirectPayrollBulk.userPositionRequested.value = 1*frmDirectPayrollBulk.newPositionRequested.value;
  frmDirectPayrollBulk.action = "../../../DirPayrollBulkGetNextHeader.do";
  frmDirectPayrollBulk.submit();
}


function doBasePrevDetail()
{
    document.all.buttonFlag.value='';  
    frmDirectPayrollBulk.userPageRequested.value = 1*frmDirectPayrollBulk.pageRequested.value - 1;
    frmDirectPayrollBulk.action = "../../../DirPayrollBulkPrevDetailAction.do";
    frmDirectPayrollBulk.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value='';  
    frmDirectPayrollBulk.userPageRequested.value = 1*frmDirectPayrollBulk.pageRequested.value + 1;
    frmDirectPayrollBulk.action = "../../../DirPayrollBulkNextDetailAction.do";
    frmDirectPayrollBulk.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';  
    frmDirectPayrollBulk.userPageRequested.value = 1*frmDirectPayrollBulk.newPageRequested.value ;
    frmDirectPayrollBulk.action = "../../../DirPayrollBulkNextDetailAction.do";
    frmDirectPayrollBulk.submit();
}


function menuHandling(mode1)
{
  if(mode1=='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butExecute.disabled="";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute.jpg"; 
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
/*      document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg"; */   
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";   
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
  if(mode1=='N')
  {
  
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
//      document.all.butRefresh.disabled="true";    
//      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";  
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
  if(mode1=='U')
  {      
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";  
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg"; 
  }
 
if(document.all.buttonFlag.value=='D')
  {
/*      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  */
  
  }
}

function doRefresh()
{
    document.frmDirectPayrollBulk.hdnAction.value = "";
    frmDirectPayrollBulk.action = "../../../DirPayrollBulkRefresh.do";
    frmDirectPayrollBulk.submit();
}


function lfnGetEmpName(val) 
{
    if (val != "")
    {
         frmDirectPayrollBulk.hdnAction.value="GetEmpName";
         frmDirectPayrollBulk.action="../../../DirSavGetEmpName.do"     
         frmDirectPayrollBulk.submit();
   }
}

function lfnGetEmpNameDtl(val, value) 
{
    if (value != "")
    {
      if(frmDirectPayrollBulk.screenModeDir.value="N") 
      {
         EnableField();      
         frmDirectPayrollBulk.hdnAction.value="GetEmpNameDtl";
         frmDirectPayrollBulk.hdnRowVal.value=val;
         frmDirectPayrollBulk.hdnEmpNo.value=value;     
         frmDirectPayrollBulk.action="../../../DirSavGetEmpName.do"     
         frmDirectPayrollBulk.submit();
      }
    }
}


function lfnGetPayCodeName(val) 
{
    if (val != "")
    {
         frmDirectPayrollBulk.hdnAction.value="GetPayCodeName";
         frmDirectPayrollBulk.action="../../../DirSavGetEmpName.do"     
         frmDirectPayrollBulk.submit();
    }
}

function lfnGetPayCodeNameDtl(val, value) 
{
    if (value != "")
    {
        if(frmDirectPayrollBulk.screenModeDir.value="N") 
        {
           EnableField();        
           frmDirectPayrollBulk.hdnAction.value="GetPayCodeNameDtl";
           frmDirectPayrollBulk.hdnRowVal.value=val;
           frmDirectPayrollBulk.hdnPayCode.value=value;     
           frmDirectPayrollBulk.action="../../../DirSavGetEmpName.do"     
           frmDirectPayrollBulk.submit();
        }
   }
}

function EnableField()
{
  var oTable = document.getElementById("Detail");
  var iTr2 = oTable.rows.length;
  var i = 0;
  
  for(i=0; i < iTr2 -1; i++)
  {
        document.getElementsByName("txtEmpNo")[i].disabled="";
        document.getElementsByName("txtPayCode")[i].disabled="";
        

      if (document.getElementsByName("status")[i].value == 'D')
        frmDirectPayrollBulk.detailDataChanged.value = "true";
  }

}


function chk_YearMonth()
{      
    var  yearM = document.getElementById("txtValidFrom").value;  
	var  yea = yearM.substring(0,4);
    var month =  yearM.substring(4,6);  
	//alert("yea"+yea);
    if(yearM!=""){
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementById("txtValidFrom").focus(); 
			document.getElementById("txtValidFrom").value="";
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(yea <2009)
        {
            alert("  Year Cannot Be Less Than 2009.Please enter a Valid Year");
            document.getElementById("txtValidFrom").focus(); 
			document.getElementById("txtValidFrom").value="";
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;
        }
		 else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("txtValidFrom").focus(); 
			document.getElementById("txtValidFrom").value="";
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
}


function clrPayType()
{

/*	if(document.all.screenMode.value=='N')
	{
		document.getElementById("txtAmount").value="";
		document.getElementById("txtInstAmount").value="";
		document.getElementById("txtAdvBalance").value="";
	}   */  // removed  by dushyant
	 var payCodeVal = document.getElementById("headerPrimaryKey").value;

	 if (payCodeVal=='345' || payCodeVal=='346')
			{
				document.all.txtNoofDays.disabled="true";    
				document.getElementById("txtNoofDays").style.background="#e0e0e0";         
				document.getElementById("txtNoofDays").value="";
				document.all.txtInstAmount.disabled="true";    
				document.getElementById("txtInstAmount").style.background="#e0e0e0"; 
				if(document.all.screenMode.value=='N')
				{
					document.getElementById("txtInstAmount").value="";
				}    
				document.all.txtNoInst.disabled="true";    
				document.getElementById("txtNoInst").style.background="#e0e0e0";         
				if(document.all.screenMode.value=='N')
				{
					document.getElementById("txtNoInst").value="";
				}
				document.all.txtAdvBalance.disabled="true";    
				document.getElementById("txtAdvBalance").style.background="#e0e0e0";         
				if(document.all.screenMode.value=='N')
				{
					document.getElementById("txtAdvBalance").value="";
				}
				document.getElementById("txtAmount").disabled = "";
				document.getElementById("txtAmount").style.background="#ffffd3";
				document.getElementById("txtAmount").style.className="required"; 
				document.all.txtPayType.value="FIXED";
				document.all.txtPayType.disabled="true";    
				document.getElementById("txtPayType").style.background="#e0e0e0";  

			}
	 else
	{
			//document.all.txtPayType.value=" ";  dushyant
			document.all.txtPayType.disabled="";    
			document.getElementById("txtPayType").style.background="#ffffd3";
		    document.all.txtNoofDays.disabled="true";    
			document.getElementById("txtNoofDays").style.background="#e0e0e0";         
			document.getElementById("txtNoofDays").value="";
			document.getElementById("txtAmount").disabled = "";
			document.getElementById("txtAmount").style.background="#ffffd3";
			document.getElementById("txtAmount").style.className="required";  
			document.all.txtInstAmount.disabled="";  
			document.getElementById("txtInstAmount").style.background="#ffffd3";    
			document.all.txtAdvBalance.disabled="";  
			document.getElementById("txtAdvBalance").style.background="#ffffd3";
			//document.all.txtNoInst.value="";   dushyant
	 
	 }
}
function onChangePayTyp(val)
{
 
  if (val=='FIXED')
  {
				  
			document.all.txtNoofDays.disabled="true";    
			document.getElementById("txtNoofDays").style.background="#e0e0e0";         
			document.getElementById("txtNoofDays").value="";
			document.getElementById("txtAmount").disabled = "";
			document.getElementById("txtAmount").style.background="#ffffd3";
			document.getElementById("txtAmount").style.className="required";  
			document.all.txtInstAmount.disabled="";  
			document.getElementById("txtInstAmount").style.background="#ffffd3";    
			document.all.txtAdvBalance.disabled="";  
			document.getElementById("txtAdvBalance").style.background="#ffffd3";
			document.all.txtNoInst.value="";  
	  
  }

 if (val=='SALRY')
  {
    document.all.txtAmount.disabled="true";  
    document.getElementById("txtAmount").style.background="#e0e0e0";    
    document.getElementById("txtAmount").value="";
    document.all.txtInstAmount.disabled="true";  
    document.getElementById("txtInstAmount").style.background="#e0e0e0";  
    document.getElementById("txtInstAmount").value="";
    document.all.txtAdvBalance.disabled="true";  
    document.getElementById("txtAdvBalance").style.background="#e0e0e0";   
    document.getElementById("txtAdvBalance").value="";
    document.all.txtNoInst.value=1;  
    
    document.getElementById("txtNoofDays").disabled = "";
    document.getElementById("txtNoofDays").style.background="#ffffd3";
    document.getElementById("txtNoofDays").style.className="required";     
  }
  
}

function onLoadPayTyp()
{
	var payCodeVal = document.getElementById("headerPrimaryKey").value;
  if (document.all.txtPayType.value=='FIXED')
  {
    document.all.txtNoofDays.disabled="true";    
    document.getElementById("txtNoofDays").style.background="#e0e0e0";         
    document.getElementById("txtAmount").disabled = "";
    document.getElementById("txtAmount").style.background="#ffffd3";
    document.getElementById("txtAmount").style.className="required";  
	if (payCodeVal=='345' || payCodeVal=='346')
	{
		document.getElementById("txtInstAmount").style.background="#e0e0e0"; 
		document.getElementById("txtInstAmount").className="locked"; 
		document.all.txtInstAmount.disabled="true";  
	}
	else
	{
	    document.all.txtInstAmount.disabled="";
		document.getElementById("txtInstAmount").style.background="#ffffd3"; 
	}
       
	if (payCodeVal=='345' || payCodeVal=='346')
	{
		document.getElementById("txtAdvBalance").style.background="#e0e0e0"; 
		document.getElementById("txtAdvBalance").className="locked"; 
		document.all.txtAdvBalance.disabled="true";  
	}
	else
	{
		document.all.txtAdvBalance.disabled="";
		document.getElementById("txtAdvBalance").style.background="#ffffd3";
	}
    
         
    
  }
  if (document.all.txtPayType.value=='SALRY')
  {
    document.all.txtAmount.disabled="true";  
    document.getElementById("txtAmount").style.background="#e0e0e0";    
    document.all.txtInstAmount.disabled="true";  
    document.getElementById("txtInstAmount").style.background="#e0e0e0";    
    document.all.txtAdvBalance.disabled="true";  
    document.getElementById("txtAdvBalance").style.background="#e0e0e0";        
    
    document.getElementById("txtNoofDays").disabled = "";
    document.getElementById("txtNoofDays").style.background="#ffffd3";
    document.getElementById("txtNoofDays").style.className="required";     
  }

}

function checkInstAmt()
{
	  
	var payCodeVal = document.getElementById("headerPrimaryKey").value;

	 if (payCodeVal=='346')
			{	
				var totAmt = document.getElementById("txtAmount").value;
				if (totAmt >40)
				{
					alert ("Please check your Amount,It cannot exceed 40/-");
					document.getElementById("txtAmount").value="";
					document.getElementById("txtAmount").focus();
					return false;
				}
				 document.all("txtInstAmount").value=document.all("txtAmount").value;
			}
     if (payCodeVal=='345')
			{	
				var totAmt = document.getElementById("txtAmount").value;
				if (totAmt >140)
				{
					alert ("Please check your Amount,It cannot exceed 140/-");
					document.getElementById("txtAmount").value="";
					document.getElementById("txtAmount").focus();
					return false;
				}
				 document.all("txtInstAmount").value=document.all("txtAmount").value;
			}
      var tempTotalAmt = parseInt(document.all("txtAmount").value,10); 
      var tempInstAmt = parseInt(document.all("txtInstAmount").value,10);      
      document.all("txtAdvBalance").value=document.all("txtAmount").value;
		if(tempTotalAmt <= 0)
		{
		  alert("Please enter valid total amount");
		  document.getElementById("txtAmount").value="";
		  document.getElementById("txtAmount").focus();
		  return false;
		}
		if(tempInstAmt <= 0)
		{
		  alert("Please enter valid installment amount");
		  document.getElementById("txtInstAmount").value="";
		  document.getElementById("txtInstAmount").focus();
		  return false;
		}      
	  if (isNaN(tempTotalAmt))
	  {
		  document.all("txtNoInst").value= "";
		  return false;
	  }
	  
	  if (isNaN(tempInstAmt))
	  {
		  document.all("txtNoInst").value= "";
		  return false;
	  }

	  var x=tempTotalAmt/tempInstAmt;      
	  var y=tempTotalAmt%tempInstAmt;
	  var diff = x - Math.floor(x);
	  diff = Math.ceil(diff);
	  if (parseInt(diff)  > 0)
	  {
		document.all("txtNoInst").value=parseInt(Math.floor(x)) + 1;                                             
	  }
	  else
	  {
		document.all("txtNoInst").value=Math.floor(x);  
	  }
  return true;

}

function checkDuplicacy(that,rInd)
{
    lengthOfTable = document.getElementById("Detail").rows.length;
    newComb = document.getElementsByName("txtEmpNo")[rInd-1].value;
    
    for(ind = lengthOfTable - 1; ind > 0; ind --)
    {
        if(ind != rInd)
        {
            oldComb = document.getElementsByName("txtEmpNo")[ind-1].value;
            
            if(oldComb == newComb)
            {
                alert("You can\'t enter duplicate employee");
                document.getElementsByName("txtEmpNo")[rInd-1].value="";                
                document.getElementsByName("txtName")[rInd-1].value="";                
                document.getElementsByName("txtDsgn")[rInd-1].value="";                
                document.getElementsByName("txtCateg")[rInd-1].value="";                
                document.getElementsByName("txtPresentPOP")[rInd-1].value="";                
                return; 
            }
        }
    }    
}

function checkSite()
{

if(document.getElementById("txtAgencyName").value!="" && document.getElementById("txtAgencySite").value=="")
{
document.getElementById('txtAgencyName').className = 'required';
document.getElementById('txtAgencySite').className = 'required';
}
}

function ShowDepoCode()
{
   var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      if(iTr2 > 1)
      {
        alert("You are not allowed to change the Location/Depo Code after Excluding atleast one Employee.");
        return false;
      }
      else
	{
	   frmDirectPayrollBulk.lovKey.value = "GangDepot" + frmDirectPayrollBulk.screenName.value + frmDirectPayrollBulk.screenMode.value;
		
	   frmDirectPayrollBulk.queryParam.value="txtSiteID="+frmDirectPayrollBulk.loginLocCode.value;
	   frmDirectPayrollBulk.txtDisplayFields.value = "txtDepoCode,txtDepoName";
		
	   frmDirectPayrollBulk.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
	   frmDirectPayrollBulk.txtIndex.value=""; 
	   frmDirectPayrollBulk.txtInputField.value="";
	   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDirectPayrollBulk');
	   return true;
	}
}

function ShowLovGang()
{
   var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      if(iTr2 > 1)
      {
        alert("You are not allowed to change the Gang Name after Excluding atleast one Employee.");
        return false;
      }
      else
    {
		  var txtType;
		   if(document.all.hdnEmpLbrFlag.value =='D')
			  txtType="DPS";
		   else if(document.all.hdnEmpLbrFlag.value =='L')
			   txtType="DEP";
		   frmDirectPayrollBulk.queryParam.value="txtLocId= "+ frmDirectPayrollBulk.txtDepoCode.value +",txtSiteID="+frmDirectPayrollBulk.loginLocCode.value+",txtType="+txtType; 
		  
		   frmDirectPayrollBulk.lovKey.value = "GangName" + frmDirectPayrollBulk.screenName.value + frmDirectPayrollBulk.screenMode.value;
		   frmDirectPayrollBulk.txtDisplayFields.value = "txtGangId,txtGangName";
		   
		   frmDirectPayrollBulk.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
		   frmDirectPayrollBulk.txtIndex.value="";
		   frmDirectPayrollBulk.txtInputField.value="";
		   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDirectPayrollBulk');
		   return true;
	}
} 

function depochangecheck()
{
	 alert("inside depochangecheck");
      var oTable = document.getElementById("Detail"); 
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      if(iTr2 > 1)
      {
		//document.all.txtDepoCode.disabled="true";  
        alert("You are not allowed to change the LOV after Excluding atleast one Employee.");
        return false;
      }
      else
	  {
		return true; 
	  }
}


</script>
