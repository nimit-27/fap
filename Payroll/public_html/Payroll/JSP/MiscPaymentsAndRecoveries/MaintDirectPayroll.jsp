<%@ page import="java.util.*"%>
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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0; %>
<% i = 0; j=0; %>

<html:form  action="MaintainDirectPayrollBase" name="frmMaintainDirectPayroll" type="FCIPAY.Payroll.WEBTIER.Form.MaintainDirectPayrollForm" scope="session">
<bean:define id="ParentForm" name="frmMaintainDirectPayroll" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="optVal" />
<html:hidden property="lovKey" name="frmMaintainDirectPayroll"  />
<html:hidden property="txtFields" name="frmMaintainDirectPayroll"  />   
<html:hidden property="txtSearchFields" name="frmMaintainDirectPayroll"  />
<html:hidden property="txtDisplayFields" name="frmMaintainDirectPayroll"  />
<html:hidden property="txtIndex" name="frmMaintainDirectPayroll"  />
<html:hidden property="txtInputField" name="frmMaintainDirectPayroll"  />


<table border = 0>
<TR height=30>
  <TD  colSpan=15 class=mainHeader height=10><bean:message key="Payroll.MaintDirect.head" /></TD>
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


            <TR>                            
                <td width="45%" class="radioText" ><input type="radio" name="radioEmp" value="1" onclick="EmpClick()"   ><bean:message  key="Payroll.MaintDirect.empw" />
                
                <td width="30%" class="radioText" ><input type="radio" name="radioPay" value="2" onclick="PayClick()" ><bean:message key="Payroll.MaintDirect.pay"  />
                
                <td width="25%" class="radioText"><input type="radio" name="radioMisc" value="3" onclick="MiscClick()" ><bean:message  key="Payroll.MaintDirect.mis" />
                <td colspan="3" ></td>          
            </TR>



         <tr height="10">	
         <tr>
            <tr height="10">	
             <td></td>
            </tr>

        
                 <logic:lessThan property= "optVal" name= "frmMaintainDirectPayroll" value="1">
                  <tr>
                  <td class="labelText"  width="40%" ><bean:message key="Payroll.MaintDirect.emp" /></td>
                  <td><html:text  property="txtEmpNo1" altKey="Payroll.MaintDirect.emp" maxlength="10" size="16" styleClass="required" readonly="true" onblur="lfnGetEmpName(this.value)"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo1" onclick="ShowLovEmpNo();" >&nbsp;&nbsp;<html:text  property="txtName1"  maxlength="10" size="26" styleClass="locked" readonly="true" /></td>
				  <!--// start added by sonia on 02-02-2011 -->
                 <td><html:hidden  property="txtCPF1"  /></td>
				 <td><html:hidden  property="txtCategory1"  /></td>
				 <td><html:hidden  property="txtPattern1"  /></td>
				 <td><html:hidden  property="txtEmpStatus1"  /></td>
				 <!--// end added by sonia on 02-02-2011 -->
				 </tr>
                 </logic:lessThan>

                 <logic:equal property= "optVal" name= "frmMaintainDirectPayroll" value="1">
                     <tr>
                      <td class="labelText"  width="40%" ><bean:message key="Payroll.MaintDirect.emp" /></td>
                      <td><html:text  property="txtEmpNo1" altKey="Payroll.MaintDirect.emp" maxlength="10" size="23" styleClass="required" readonly="true" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo1" onclick="ShowLovEmpNo();" >&nbsp;&nbsp;<html:text  property="txtName1"  maxlength="10" size="26" styleClass="locked"  /></td>
					  <!--// start added by sonia on 02-02-2011 -->
					  <td><html:hidden  property="txtCPF1"  /></td>
                     <td><html:hidden  property="txtCategory1"  /></td>
					 <td><html:hidden  property="txtPattern1"  /></td>
					 <td><html:hidden  property="txtEmpStatus1"  /></td>
					 <!--// end added by sonia on 02-02-2011 -->
					 </tr>
                  </logic:equal>
        
               <logic:equal property= "optVal" name= "frmMaintainDirectPayroll" value="2">
                     <tr>
                      <td class="labelText"  width="40%" ><bean:message key="Payroll.MaintDirect.code" /></td>
                      <td>
						  <html:text  property="txtPayCode1" altKey="Payroll.MaintDirect.code" maxlength="10" size="23" styleClass="required"  onblur="lfnGetPayCodeName(this.value)" readonly="true" />
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayCode1" onclick="ShowLovPayCode();" >&nbsp;&nbsp;
						  <html:text  property="txtPayCodeName"  maxlength="10" size="26" styleClass="locked" readonly="true" />
					  </td>
                     </tr>
                  </logic:equal>

               <logic:equal property= "optVal" name= "frmMaintainDirectPayroll" value="3">
                 <tr height = 15><td>&nbsp;</td>    
                 </tr>
              </logic:equal>
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
                <td bgcolor="#4682B4" nowrap class=actTabText><bean:message key="Payroll.MaintDirect.detail" /><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                    <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();disableHistory();"  /></td>
                                    <td class=tableHeader width="1%"><bean:message key="Payroll.MaintDirect.srno" /></td>
                                    <td class=tableHeader width="7%"><bean:message key="Payroll.MaintDirect.emp"  /></td>
                                    <td class=tableHeader width="8%"><bean:message key="Payroll.MaintDirect.name" /></td>  
                                    <td class=tableHeader width="6%"><bean:message key="Payroll.MaintDirect.code" /></td>
                                    <td class=tableHeader width="8%"><bean:message key="Payroll.MaintDirect.desc" /></td>                                               
                                    <td class=tableHeader width="6%"><bean:message key="Payroll.MaintDirect.paym" /></td>                                               
                                    <td class=tableHeader width="5%"><bean:message key="Payroll.MaintDirect.fm" /></td>                                                                                            
                                    <td class=tableHeader width="4%"><bean:message key="Payroll.MaintDirect.amt" /></td>
                                    <td class=tableHeader width="4%"><bean:message key="Payroll.MaintDirect.instAmt" /></td>  
                                    <td class=tableHeader width="2%"><bean:message key="Payroll.MaintDirect.noInst" /></td>                                                                                            
                                    <td class=tableHeader width="4%"><bean:message key="Payroll.MaintDirect.advBal" /></td>   
									<td class=tableHeader width="4%"><bean:message key="Payroll.MaintDirect.savno" /></td>   
                                    <td class=tableHeader width="7%"><bean:message key="Payroll.MaintDirect.agencycod" /></td>       
                                    <td class=tableHeader width="2%"><bean:message key="Payroll.MaintDirect.agencyName" /></td>                                               
                                    <td class=tableHeader width="6%"><bean:message key="Payroll.MaintDirect.agencysite" /></td>                                                                                   
                                    </TR>
                           
                                  <logic:iterate id="DirectPayrollInfo" name="frmMaintainDirectPayroll" property="lstInstrDtls"  type="FCIPAY.Payroll.UTILITY.MaintainDirectPayrollBean"   indexId="idx">          
                                <% ++i; %>
                                <logic:notEqual name="DirectPayrollInfo" property="status" value="D" >  
                                 <tr>
                                <td ><html:checkbox property="checked" onclick="checkRecord();disableHistory();" name="frmMaintainDirectPayroll" /></td>
                                <logic:notEqual name="DirectPayrollInfo" property="status" value="Q" >                                                           
                                  <% ++j; %>
                                       <td ><html:text property="txtSrNo" name="DirectPayrollInfo" size="3"   value="" styleClass="locked" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);"  /></td>
                                       <td ><html:text property="txtEmpNo" name="DirectPayrollInfo" maxlength="6" styleClass="required" size="6" style="width:70%" alt="<%=String.valueOf(i)%>" onchange="
                                       if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);"   
									   onblur="lfnGetEmpNameDtl(this.alt, this.value)" 
									   onkeypress="if((event.keyCode < 48 || event.keyCode > 57))
														{                     
														  return false;
														};"/>
                                      <logic:equal name="DirectPayrollInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo" onclick="ShowLovEmpNo1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowLovEmpNo1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowLovEmpNo1(this.alt);" >
                                       </logic:equal>
                                       </td>
                                       
                                       <td ><html:text property="txtName" name="DirectPayrollInfo" size="18" style="width:100%" styleClass="locked" readonly="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>
                                       <!--html:hidden property="txtCPFCode" name="DirectPayrollInfo" /-->
                                       <td ><html:text property="txtPayCode" name="DirectPayrollInfo" size="5"  readonly="true"  styleClass="required" style="width:70%" alt="<%=String.valueOf(i)%>" onchange="
                                       if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
									   {
											mandateSavNo(this.alt);
											return changed(this.alt);
										}
                                       "   />

                                       <logic:equal name="DirectPayrollInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  onclick="ShowLovPayCode1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayCode1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayCode1(this.alt);" >
                                       </logic:equal>
                                       </td>
                                     
                                       <td ><html:text property="txtDescription" name="DirectPayrollInfo"  styleClass="locked" readonly="true" size="20" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>
                                       <td ><html:select property="txtPayMode" name="DirectPayrollInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"   >
                                        <html:option value=" ">------Please select------</html:option>
                                        <html:option value="1">1 - Current Payment</html:option>
                                        <html:option value="2">2 - Current Recovery</html:option>
                                        <html:option value="4">4 - Arrear Payment</html:option>
                                        <html:option value="5">5 - Arrear Recovery</html:option>
                                       </html:select></td>                                       
                                       <!--start changed by sonia on 19 -10-2010 -->
									   <td ><html:text property="txtValidFrom" name="DirectPayrollInfo" size="6"  styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="

                                        if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }    

                                       if(!(chk_YearMonth()))
                                          {
                                          }
                                       else
                                          {
                                            return changed(this.alt);
                                          } 
                                      " onblur=""/></td>
									  <!--end changed by sonia on 19 -10-2010 -->
                                     
                                       <td ><html:text property="txtAmount" name="DirectPayrollInfo" size="6" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                      if(!(checkInstAmt(this.alt)))
                                          {
                                          }
                                       else
                                          {
                                            return changed(this.alt);
                                          }                                         
                                       " /></td>
                                       <td ><html:text property="txtInstAmount" name="DirectPayrollInfo" size="6" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                      if(!(checkInstAmt(this.alt)))
                                          {
                                          }
                                       else
                                          {
                                            return changed(this.alt);
                                          } 

                                       " /></td>
<!--                                     <td ><html:text property="txtNoInst" name="DirectPayrollInfo" size="6" styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                       " /></td>  -->
                                       <td ><html:text property="txtNoInst" name="DirectPayrollInfo" size="6" styleClass="required" readonly="true" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>
                                       <td ><html:text property="txtAdvBalance" name="DirectPayrollInfo" size="6" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        }                                         
                                       " /></td>



<!--added by swapnendu Dt 04 Feb 04 Feb 2013 start-->


									   <td ><html:text property="txtSavNo" name="DirectPayrollInfo" size="6" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" 
											onkeypress="
											if((event.keyCode < 48 || event.keyCode > 57))
											{
												return false;
											};"
											onchange="return changed(this.alt);" />
										</td>
<!--added by swapnendu Dt 04 Feb 04 Feb 2013 end-->

                                      <html:hidden property="txtAgency" name="DirectPayrollInfo" alt="<%=String.valueOf(i)%>"/>
									   <td ><html:text property="txtAgencyNo" name="DirectPayrollInfo" size="5"  readonly="true"  styleClass="optional" style="width:70%" alt="<%=String.valueOf(i)%>"  />

                                       <logic:equal name="DirectPayrollInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  onclick="ShowLovAgencyCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  disabled onclick="ShowLovAgencyCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  disabled onclick="ShowLovAgencyCode(this.alt);" >
                                       </logic:equal>
                                       </td>

                                       <td  width="6%"><html:text property="txtAgencyName" name="DirectPayrollInfo" styleClass="optional" size="6" style="width:200" alt="<%=String.valueOf(i)%>" onchange="return agChanged(this.alt);" readonly="true"  /></td>
                                       <html:hidden property="txtAgencySiteCode" name="DirectPayrollInfo"   alt="<%=String.valueOf(i)%>"/>
									     <td ><html:text property="txtAgencySite" name="DirectPayrollInfo" size="6"  readonly="true"  styleClass="optional" style="width:70%"  alt="<%=String.valueOf(i)%>"  />
										
                                       <logic:equal name="DirectPayrollInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  onclick="ShowLovAgencySiteCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovAgencySiteCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovAgencySiteCode(this.alt);" >
                                       </logic:equal>
                                       </td>

									   <!--//  added by sonia on 02-02-2011 
									   <html:hidden property="txtPattern" name="DirectPayrollInfo" />
									  <html:hidden property="txtCategory" name="DirectPayrollInfo" /><!--// start added by sonia on 02-02-2011 -->

									  <!-- start added by sonia on 02-02-2011 -->
										 <html:hidden  property="txtCPF"   name="DirectPayrollInfo"/>
										 <html:hidden  property="txtCategory"   name="DirectPayrollInfo" />
										 <html:hidden  property="txtPattern"  name="DirectPayrollInfo" />
										 <html:hidden  property="txtEmpStatus"  name="DirectPayrollInfo" />
										 <!-- end added by sonia on 02-02-2011 -->
									   <html:hidden property="txtUpdatedSite"  name="DirectPayrollInfo" />             <html:hidden property="txtCreationDate" name="DirectPayrollInfo" />
                                       <html:hidden property="txtCreatedBy"    name="DirectPayrollInfo" />
                                       <html:hidden property="txtCreatedSite"  name="DirectPayrollInfo" />
                                       <html:hidden property="txtUpdationDate" name="DirectPayrollInfo" />
                                       <html:hidden property="txtUpdatedBy"    name="DirectPayrollInfo" />

                                       <html:hidden property="txtTxnCateg" name="DirectPayrollInfo" />
                                       <html:hidden property="txtSrlNo" name="DirectPayrollInfo" />
                                       <html:hidden property="txtPayrollFlag" name="DirectPayrollInfo" />
                                       <html:hidden property="itemChecked" name="DirectPayrollInfo" />
                                       <html:hidden property="status" name="DirectPayrollInfo" />
									   <html:hidden property="detailId" name="DirectPayrollInfo" value="Default"/>
                                    
                                  </logic:notEqual>
                                  <logic:equal name="DirectPayrollInfo" property="status" value="Q" >
                                      <% ++j; %>
                                       <td ><html:text property="txtSrNo" name="DirectPayrollInfo" size="3"   value="" styleClass="locked" style="width:100%" alt="<%=String.valueOf(i)%>" readonly="true"  /></td>
                                       <td ><html:text property="txtEmpNo" name="DirectPayrollInfo"  styleClass="locked" size="6" style="width:70%" alt="<%=String.valueOf(i)%>" readonly="true" />
                                      <logic:equal name="DirectPayrollInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"   >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowLovEmpNo1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowLovEmpNo1(this.alt);" >
                                       </logic:equal>
                                       </td>
                                       
                                       <td ><html:text property="txtName" name="DirectPayrollInfo" size="18" style="width:100%" styleClass="locked" readonly="true" alt="<%=String.valueOf(i)%>" /></td>
                                       <td ><html:text property="txtPayCode" name="DirectPayrollInfo" size="6"    styleClass="locked" style="width:70%" alt="<%=String.valueOf(i)%>" readonly="true"/>

                                       <logic:equal name="DirectPayrollInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"   >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayCode1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="DirectPayrollInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayCode1(this.alt);"  >
                                       </logic:equal>
                                       </td>
                                     
                                       <td ><html:text property="txtDescription" name="DirectPayrollInfo"  styleClass="locked" readonly="true" size="20" style="width:100%" alt="<%=String.valueOf(i)%>"  /></td>
                                       <td ><html:select property="txtPayMode" name="DirectPayrollInfo"  styleClass="locked" disabled="true" alt="<%=String.valueOf(i)%>"   >
                                        <html:option value=" ">------Please select------</html:option>
                                        <html:option value="1">1 - Current Payment</html:option>
                                        <html:option value="2">2 - Current Recovery</html:option>
                                        <html:option value="4">4 - Arrear Payment</html:option>
                                        <html:option value="5">5 - Arrear Recovery</html:option>
                                       </html:select></td>                                       
                                      
                                     
									   <!--start changed by sonia on 19 -10-2010 -->
                                       <td ><html:text property="txtValidFrom" name="DirectPayrollInfo" size="6"  styleClass="locked" style="width:100%" alt="<%=String.valueOf(i)%>" readonly="true" onblur="" /></td>
                                     <!--end changed by sonia on 19 -10-2010 -->
                                       <td ><html:text property="txtAmount" name="DirectPayrollInfo" size="6" styleClass="locked" style="width:100%" alt="<%=String.valueOf(i)%>" readonly="true" /></td>
                                       <td ><html:text property="txtInstAmount" name="DirectPayrollInfo" size="6" styleClass="locked" style="width:100%" alt="<%=String.valueOf(i)%>" readonly="true" /></td>
<!--                                     <td ><html:text property="txtNoInst" name="DirectPayrollInfo" size="6" styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                       " /></td>  -->
                                       <td ><html:text property="txtNoInst" name="DirectPayrollInfo" size="6" styleClass="locked" readonly="true" style="width:100%" alt="<%=String.valueOf(i)%>" /></td>
                                       <td ><html:text property="txtAdvBalance" name="DirectPayrollInfo" size="6" styleClass="locked" readonly="true" style="width:100%" alt="<%=String.valueOf(i)%>" /></td>                                       


<!--added by swapnendu Dt 04 Feb 04 Feb 2013 start-->
									   <td ><html:text property="txtSavNo" name="DirectPayrollInfo" size="6" styleClass="locked" readonly="true" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" 
											onkeypress="
											if((event.keyCode < 48 || event.keyCode > 57))
											{
												return false;
											};"
											onchange="return changed(this.alt);" /></td>
<!--added by swapnendu Dt 04 Feb 04 Feb 2013 end-->

                                       <html:hidden property="txtAgency" name="DirectPayrollInfo" alt="<%=String.valueOf(i)%>"  />
                                       <td ><html:text property="txtAgencyNo" name="DirectPayrollInfo"  styleClass="locked" size="6" style="width:70%" alt="<%=String.valueOf(i)%>" readonly="true" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  ></td>
                                       <td width="6%"><html:text property="txtAgencyName" name="DirectPayrollInfo" styleClass="locked" style="width:200" size="6" alt="<%=String.valueOf(i)%>" readonly="true"/></td>
                                       <td ><html:text property="txtAgencySite" name="DirectPayrollInfo"  styleClass="locked" size="6" style="width:70%" alt="<%=String.valueOf(i)%>" readonly="true" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  >
									   <html:hidden property="txtAgencySiteCode" name="DirectPayrollInfo" alt="<%=String.valueOf(i)%>"/>
										<!--// start added by sonia on 02-02-2011
										 <html:hidden property="txtPattern" name="DirectPayrollInfo" />
										<html:hidden property="txtCategory" name="DirectPayrollInfo" /><!--// start added by sonia on 02-02-2011 -->

                                       <!-- start added by sonia on 02-02-2011 -->
										 <html:hidden  property="txtCPF"   name="DirectPayrollInfo"/>
										 <html:hidden  property="txtCategory"   name="DirectPayrollInfo" />
										 <html:hidden  property="txtPattern"  name="DirectPayrollInfo" />
										 <html:hidden  property="txtEmpStatus"   name="DirectPayrollInfo" />
										 <!-- end added by sonia on 02-02-2011 -->


                                       
									   <html:hidden property="txtCreationDate" name="DirectPayrollInfo" />
                                          <html:hidden property="txtCreatedBy"    name="DirectPayrollInfo" />
                                          <html:hidden property="txtCreatedSite"  name="DirectPayrollInfo" />
                                          <html:hidden property="txtUpdationDate" name="DirectPayrollInfo" />
                                          <html:hidden property="txtUpdatedBy"    name="DirectPayrollInfo" />
                                          <html:hidden property="txtUpdatedSite"  name="DirectPayrollInfo" />
										 
                                       <html:hidden property="txtTxnCateg" name="DirectPayrollInfo" />
                                       <html:hidden property="txtSrlNo" name="DirectPayrollInfo" />   
                                       <html:hidden property="txtPayrollFlag" name="DirectPayrollInfo" />
                                       <html:hidden property="itemChecked" name="DirectPayrollInfo" />
                                       <html:hidden property="status" name="DirectPayrollInfo" />
                                       <html:hidden property="detailId" name="DirectPayrollInfo" value="Default"/>

                                    
                                  </logic:equal>
                                  </tr>
                                  </logic:notEqual>
                                  <logic:equal name="DirectPayrollInfo" property="status" value="D" >
                                  <tr>
                                       <td ><html:hidden property="checked" name="frmMaintainDirectPayroll" value="notchecked" /></td>
                                       <td ><html:hidden property="txtSrNo" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtEmpNo" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtName" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtPayCode" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtDescription" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtPayMode" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtValidFrom" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtAmount" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtInstAmount" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtNoInst" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtAdvBalance" name="DirectPayrollInfo" /></td>   
									   <td ><html:hidden property="txtSavNo" name="DirectPayrollInfo" /></td> 
                                       <td ><html:hidden property="txtAgency" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtAgencyNo" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtAgencyName" name="DirectPayrollInfo" /></td>                                       
                                       <td ><html:hidden property="txtAgencySite" name="DirectPayrollInfo" /></td>
                                       <td ><html:hidden property="txtAgencySiteCode" name="DirectPayrollInfo" /></td>
									    <!--// start added by sonia on 02-02-2011 
									   <html:hidden property="txtPattern" name="DirectPayrollInfo" />
									   <html:hidden property="txtCategory" name="DirectPayrollInfo" /><!--// start added by sonia on 02-02-2011 -->

                                      <!-- start added by sonia on 02-02-2011 -->
										 <html:hidden  property="txtCPF"   name="DirectPayrollInfo"/>
										 <html:hidden  property="txtCategory"   name="DirectPayrollInfo" />
										 <html:hidden  property="txtPattern"  name="DirectPayrollInfo" />
										 <html:hidden  property="txtEmpStatus"   name="DirectPayrollInfo" />
										 <!-- end added by sonia on 02-02-2011 -->

                                      <html:hidden property="txtCreationDate" name="DirectPayrollInfo" />
                                      <html:hidden property="txtCreatedBy"    name="DirectPayrollInfo" />
                                      <html:hidden property="txtCreatedSite"  name="DirectPayrollInfo" />
                                      <html:hidden property="txtUpdationDate" name="DirectPayrollInfo" />
                                      <html:hidden property="txtUpdatedBy"    name="DirectPayrollInfo" />
                                      <html:hidden property="txtUpdatedSite"  name="DirectPayrollInfo" />
                                      <html:hidden property="txtTxnCateg" name="DirectPayrollInfo" />
                                      <html:hidden property="txtSrlNo" name="DirectPayrollInfo" />   
                                      <html:hidden property="txtPayrollFlag" name="DirectPayrollInfo" />
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
                      <jsp:include  page = "../INCLUDES/GenDetailRecHistMenu.jsp" flush="true" />
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
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
               <td align=center bgcolor=#4682b4 width="40%"></td>
<!--               <td  bgcolor=#4682b4><html:button value='Approve'  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Reject '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Revise '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /></td>  -->
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
<html:hidden property="hdnCurYYMM" name="frmMaintainDirectPayroll"  />
<html:hidden property="hdnAction" name="frmMaintainDirectPayroll"  />
<html:hidden property="hdnRowVal" name="frmMaintainDirectPayroll"  />
<html:hidden property="hdnEmpNo" name="frmMaintainDirectPayroll"  />
<html:hidden property="hdnEmpName" name="frmMaintainDirectPayroll"  />
<html:hidden property="hdnPayCode" name="frmMaintainDirectPayroll"  />
<html:hidden property="hdnPayCodeName" name="frmMaintainDirectPayroll"  />
<html:hidden property="hdnPayStatus" name="frmMaintainDirectPayroll"  />
<html:hidden property="headerPrimaryKey" name="frmMaintainDirectPayroll"  />
<html:hidden property="screenMode" name="frmMaintainDirectPayroll"  />
<html:hidden property="screenModeDir" name="frmMaintainDirectPayroll"  />
<html:hidden name="frmMaintainDirectPayroll"  property="screenName" value="DirectPayrollScreen" />
<html:hidden name="frmMaintainDirectPayroll"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintainDirectPayroll"  />
<html:hidden property="userPageRequested" name="frmMaintainDirectPayroll" />
<html:hidden property="pageRequested" name="frmMaintainDirectPayroll" />
<html:hidden property="buttonFlag" name="frmMaintainDirectPayroll"  />
<html:hidden property="txtAgency" name="frmMaintainDirectPayroll"  />
<html:hidden property="txtAgencyNo" name="frmMaintainDirectPayroll"  />
<html:hidden property="txtAgencyName" name="frmMaintainDirectPayroll"  />
<html:hidden property="txtAgencySite" name="frmMaintainDirectPayroll"  />
<html:hidden property="txtAgencySiteCode" name="frmMaintainDirectPayroll"  />
<html:hidden property="txtCategory" name="frmMaintainDirectPayroll"  /><!-- added by sonia on 02-02-2011-->



<html:hidden property="loginLocCode" name="frmMaintainDirectPayroll"  />
<input type="hidden" name="queryParam" />
<!--input type="hidden" name="txtCPFCode"-->                                 


</html:form>
</body>
</html:html>
         

<script language="javascript">

var chkMes = 0;

function changed(val)
{
  frmMaintainDirectPayroll.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
  document.getElementsByName("status")[val-1].value = 'U';
}

function agChanged(val)
{
  document.getElementsByName("txtAgencySite")[val-1].value="";
  document.getElementsByName("txtAgencySiteCode")[val-1].value="";
  frmMaintainDirectPayroll.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
  document.getElementsByName("status")[val-1].value = 'U';
}


////////////////start changed by sonia on 19 -10-2010 ////////////////
function doBaseAddRow()
{

 document.all.buttonFlag.value='D';
 
    
	if(!chk_DeputationPayCodes()) /////////////////added  by sonia on 11-07-2011 ////////////////
		return false; /////////////////added  by sonia on 11-07-2011 ////////////////

 	if(!checkSupplierSites()) /////////////////added  by sonia on 10 -03-2011 ////////////////
		return false; /////////////////added  by sonia on 10 -03-2011 ////////////////
    
  if(!mandatory_Check("frmMaintainDirectPayroll"))
        return false;   


var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;  
  for(i=0; i < iTr2 -1; i++)
    {
	 
	 
		//alert("Site Value"+document.getElementsByName("txtAgencySite")[i].value);
			if(document.getElementsByName("txtAgencyNo")[i].style.className == "required" &&  document.getElementsByName("txtAgencyNo")[i].value == "" && document.getElementsByName("txtAgencySite")[i].value == "" ){	

				//alert("Inside if");
		        alert("Mandatory field is empty!");
			return false;
		}
		if(document.getElementsByName("txtAgencySite")[i].style.className == "required" &&   document.getElementsByName("txtAgencySite")[i].value == "" ){	

				//alert("Inside  2 if");
		        alert("Mandatory field is empty!");
			return false;
		}
    }
  /////////////////end changed by sonia on 19 -10-2010 ////////////////

 //frmMaintainDirectPayroll.screenMode.value = "U";  
 frmMaintainDirectPayroll.action = "../../../DirectPayrollAddRowAction.do";
 enable(); 
 frmMaintainDirectPayroll.submit();
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
        if(document.getElementsByName("checked")[i].checked)
        {
            flag=flag+1;
        }
    }  
    if ( flag == 0)
    {
        alert("Please check the rows to be deleted");
        return false;
    }


  for(i=0; i < iTr2 -1; i++)
  {

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintainDirectPayroll.detailDataChanged.value = "true"; 
    }
  }

  enable();
  document.forms[0].action = "../../../DirectPayrolldeleteRowAction.do";
  document.forms[0].submit();  
}
//Added By Neeraj On 22 Oct 2010
function doBaseShowHistory()
{
//alert("checkbox clicked");
 //alert("frmMaintainDirectpayroll--->" + frmMaintainDirectPayroll.txtCreationDate.value);   
      var oTable = document.getElementById("Detail");
    
      if(oTable == null)
      {
       document.all.butHistory.disabled="true";
       return;
      }
    
      var iTr2 = oTable.rows.length;
      var i = 0;
      var f2=0;
    
    //alert("No. of  rows--->"+iTr2);

      for(i=0; i < iTr2 - 1; i++)
      {
           if(document.getElementsByName("checked")[i].checked)
          {          
              f2=f2+1;
              //alert(i);
              if(iTr2==2)
              {
              if(!(frmMaintainDirectPayroll.txtCreationDate.value&&frmMaintainDirectPayroll.txtCreatedBy.value&&frmMaintainDirectPayroll.txtCreatedSite.value))
              {
              alert("No history exists for the selected record");
              }
              else
              {
              alert("Record History"+"\n"
              +"Creation Date :  "+ frmMaintainDirectPayroll.txtCreationDate.value+"\n"
              +"Created By      :  "+frmMaintainDirectPayroll.txtCreatedBy.value
              +"\n"
              +"Created Site    :  "+frmMaintainDirectPayroll.txtCreatedSite.value
              +"\n"
              +"Updation Date:  "+frmMaintainDirectPayroll.txtUpdationDate.value
              +"\n"
              +"Updated By     :  "+frmMaintainDirectPayroll.txtUpdatedBy.value
              +"\n"
              +"Updated Site   :  "+frmMaintainDirectPayroll.txtUpdatedSite.value
              );
            }
              }
              else
              {
              if(!(frmMaintainDirectPayroll.txtCreationDate[i].value&&frmMaintainDirectPayroll.txtCreatedBy[i].value&&frmMaintainDirectPayroll.txtCreatedSite[i].value))
              {
              alert("No history exists for the selected record");
              }
              else
              {
              alert("Record History"+"\n"
              +"Creation Date :  "+ frmMaintainDirectPayroll.txtCreationDate[i].value+"\n"
              +"Created By      :  "+frmMaintainDirectPayroll.txtCreatedBy[i].value
              +"\n"
              +"Created Site    :  "+frmMaintainDirectPayroll.txtCreatedSite[i].value
              +"\n"
              +"Updation Date:  "+frmMaintainDirectPayroll.txtUpdationDate[i].value
              +"\n"
              +"Updated By     :  "+frmMaintainDirectPayroll.txtUpdatedBy[i].value
              +"\n"
              +"Updated Site   :  "+frmMaintainDirectPayroll.txtUpdatedSite[i].value
              );
            }
           }
          }
      }
    
     if(f2>1)
        {
           alert("Select only one row for history !");
           document.all.butHistory.disabled="true";
           return false;
        }
        
    if(f2 == 1)
      {
          document.all.butHistory.disabled="";
        //  showHistWin('<html:rewrite page="/Payroll/JSP/COMMON/JSP/ShowHistory.jsp" />', 'frmMaintainDirectPayroll');
          return true;
      }
    
    if(f2 == 0)
      {
		   document.all.butHistory.disabled="true";
       return false;
      }
}
//Added By Neeraj Ends here


function GetDetail()
{ 
 document.all.buttonFlag.value='';
 document.all.screenModeDir.value = 'UG';

  frmMaintainDirectPayroll.screenMode.value='U';
  frmMaintainDirectPayroll.headerDataChanged.value = "false";

   if(!mandatory_Check("frmMaintainDirectPayroll"))
        return false;    

  if(document.frmMaintainDirectPayroll.optVal.value == "1") 
      frmMaintainDirectPayroll.headerPrimaryKey.value = frmMaintainDirectPayroll.txtEmpNo1.value ;  

  if(document.frmMaintainDirectPayroll.optVal.value == "2")  
      frmMaintainDirectPayroll.headerPrimaryKey.value = frmMaintainDirectPayroll.txtPayCode1.value ;  
   else 
      frmMaintainDirectPayroll.headerPrimaryKey.value = "";  
        
  frmMaintainDirectPayroll.action="../../../DirectPayrollFirstGetDetailAction.do"  
  frmMaintainDirectPayroll.submit();
}


function SaveRecord()
{
 document.all.buttonFlag.value='';
 var answer = confirm("Have you verified all the data.Press OK to save the record!!!!")
	if (!answer){
		return false;
	}
    if(!chk_DeputationPayCodes()) /////////////////added  by sonia on 11-07-2011 ////////////////
		return false; /////////////////added  by sonia on 11-07-2011 ////////////////

	if(!checkSupplierSites()) /////////////////added  by sonia on 10 -03-2011 ////////////////
		return false;/////////////////added  by sonia on 10 -03-2011 ////////////////

 if(!chk_YearMonth())
 return false;

 if(!mandatory_Check("frmMaintainDirectPayroll"))
        return false;    

/////////////////start changed by sonia on 19 -10-2010 ////////////////
//chk_PayCodes()
var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;  
  for(i=0; i < iTr2 -1; i++)
    {
	 
		//alert("Site Value"+document.getElementsByName("txtAgencyNo")[i].value);
			if(document.getElementsByName("txtAgencyNo")[i].style.className == "required" &&  document.getElementsByName("txtAgencyNo")[i].value == ""  ){
			alert("Mandatory Field is empty.");   
			return false;
		}
		if(document.getElementsByName("txtAgencySite")[i].style.className == "required" &&   document.getElementsByName("txtAgencySite")[i].value == "" ){					
			alert("Mandatory Field is empty.");
			return false;
		}
    }
  /////////////////end changed by sonia on 19 -10-2010 ////////////////


/* if(!checkPayCode())
      return false;*/

/* if(!AmtCheck())
      return false;*/
      
/*  if(!checkInstAmt())
      return false; 
*/
    enable();

   var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

for(i=0; i < iTr2 -1; i++)
  {
 var tempPayCode = document.getElementsByName("txtAgencyNo")[i].value;
 var tempSiteCode = document.getElementsByName("txtAgencySite")[i].value;

                 if ((tempPayCode != "") &&(tempSiteCode == ""))
                {
                  // alert("Mandatory Field is blank.");            
                  // document.getElementsByName("txtAgencySite")[i].focus(); 
                   //return false;
                }    
 }
  for(i=0; i < iTr2 -1; i++)
  {
        //alert(document.getElementsByName("txtEmpNo")[i].value);
        document.getElementsByName("txtEmpNo")[i].disabled="";
        document.getElementsByName("txtPayCode")[i].disabled="";

       if(document.getElementsByName("status")[i].value == 'D')
        frmMaintainDirectPayroll.detailDataChanged.value = "true";
  }

//  frmMaintainDirectPayroll.screenMode.value='U';  
  frmMaintainDirectPayroll.headerFields.value = "false";
  frmMaintainDirectPayroll.totalDetailRecord.value = parseInt(iTr2,10) - 1;
  document.all.butSave.disabled="true";        

 
      if (document.all.screenMode.value == "N")
      {
         document.all.screenModeDir.value = "UG";
         document.all.screenMode.value = "U";    
      }
  
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintainDirectPayroll.action = "../../../DirectPayrollSaveAction.do";
  frmMaintainDirectPayroll.submit();
}


function checkPayCode()
{
            var oTable = document.getElementById("Detail");
            var iTr2 = oTable.rows.length;
            var flag =0;
            var i = 0;
         
            for(i=0;i<iTr2-1;i++)
            {   
              if (document.getElementsByName("status")[i].value != 'D')
              {            
                var tempPayCode = document.getElementsByName("txtPayCode")[i].value;
                 if ((parseInt(tempPayCode,10) < 100) ||  (parseInt(tempPayCode,10) > 999))
                {
                   alert("Pay Code should always be a 3 digit no.");            
                   document.getElementsByName("txtPayCode")[i].focus(); 
                   return false;
                }                             

                else if((parseInt(tempPayCode.substring(0,1),10) > 5) && (parseInt(tempPayCode.substring(0,1),10) < 9)) 
                {
                    alert("Pay Code should always start with 1,2,3,4,5 or 9");            
                    document.getElementsByName("txtPayCode")[i].focus(); 
                   return false;       
                }       
              }                   
            }             
 
        return true;
}

function checkSupplier()
{
            var oTable = document.getElementById("Detail");
            var iTr2 = oTable.rows.length;
            var flag =0;
            var i = 0;
         
            for(i=0;i<iTr2-1;i++)
            {   
              if (document.getElementsByName("status")[i].value != 'D')
              {            
                var tempPayCode = document.getElementsByName("txtAgencyNo")[i].value;
                 if ((parseInt(tempPayCode,10) < 100) ||  (parseInt(tempPayCode,10) > 999))
                {
                   alert("Pay Code should always be a 3 digit no.");            
                   document.getElementsByName("txtPayCode")[i].focus(); 
                   return false;
                }                             

                else if((parseInt(tempPayCode.substring(0,1),10) > 5) && (parseInt(tempPayCode.substring(0,1),10) < 9)) 
                {
                    alert("Pay Code should always start with 1,2,3,4,5 or 9");            
                    document.getElementsByName("txtPayCode")[i].focus(); 
                   return false;       
                }       
              }                   
            }             
 
        return true;
}


function checkInstAmt()
{           
            var oTable = document.getElementById("Detail");
            var iTr2 = oTable.rows.length;
            var flag =0;
            var i = 0;         
            for(i=0;i<iTr2-1;i++)
            {

            if (document.getElementsByName("status")[i].value != 'D')
            {
                var tempTotalAmt = parseInt(document.getElementsByName("txtAmount")[i].value,10);
                var tempInstAmt = parseInt(document.getElementsByName("txtInstAmount")[i].value,10);
                  // alert("tempInstAmt" + tempInstAmt);
                
                document.getElementsByName("txtAdvBalance")[i].value=document.getElementsByName("txtAmount")[i].value;


                if (isNaN(tempTotalAmt))
                {
                    document.getElementsByName("txtNoInst")[i].value= "";
                    return false;
                }

                if (isNaN(tempInstAmt))
                {
                    document.getElementsByName("txtNoInst")[i].value= "";
                    return false;
                }
                    

                var x=tempTotalAmt/tempInstAmt;
                var y=tempTotalAmt%tempInstAmt;
               // var z=(int)(tempTotalAmt/tempInstAmt);
//               alert(Math.floor(44.84));

                  var diff = x - Math.floor(x);
                  diff = Math.ceil(diff);
               if (parseInt(diff)  > 0)
               {
                 document.getElementsByName("txtNoInst")[i].value=parseInt(Math.floor(x)) + 1;                                             
                }
                else
                {
                  document.getElementsByName("txtNoInst")[i].value=Math.floor(x);  
                 }

/*                if (y != 0)
                {
                   document.getElementsByName("txtNoInst")[i].focus();
                   document.getElementsByName("txtNoInst")[i].value= x + 1;
                }                             
                else
                {
                  document.getElementsByName("txtNoInst")[i].focus();
                   document.getElementsByName("txtNoInst")[i].value=x;
                }   */
              }

 if(tempInstAmt == 0){
                //alert("inside if")
                document.getElementsByName("txtNoInst")[i].value=1;    
                //alert("txtNoInst" +   document.getElementsByName("txtNoInst")[i].value);
                //return false;
                }

            }                   
        return true;
}

function checkInstAmt(indx)
{          
	
	var oTable = document.getElementById("Detail");
	var iTr2 = oTable.rows.length;
	var flag =0;
	var i = 0;         
	var tempTotalAmt = parseInt(document.getElementsByName("txtAmount")[indx-1].value,10);
	var tempInstAmt = parseInt(document.getElementsByName("txtInstAmount")[indx-1].value,10);
	//alert("tempInstAmt" + tempInstAmt);

	document.getElementsByName("txtAdvBalance")[indx-1].value=document.getElementsByName("txtAmount")[indx-1].value;


	if (isNaN(tempTotalAmt))
	{
		document.getElementsByName("txtNoInst")[indx-1].value= "";
		return false;
	}

	if (isNaN(tempInstAmt))
	{
		document.getElementsByName("txtNoInst")[indx-1].value= "";
		return false;
	}


	var x=tempTotalAmt/tempInstAmt;
	var y=tempTotalAmt%tempInstAmt;

	var diff = x - Math.floor(x);
	diff = Math.ceil(diff);
	if (parseInt(diff)  > 0)
	{
		document.getElementsByName("txtNoInst")[indx-1].value=parseInt(Math.floor(x)) + 1;                                             
	}
	else
	{
		document.getElementsByName("txtNoInst")[indx-1].value=Math.floor(x);  
	}

	if(tempInstAmt == 0)
	{
		document.getElementsByName("txtNoInst")[indx-1].value=1;    
	}

	if(document.getElementsByName("txtNoInst")[indx-1].value>=100)
  	{
    		var r=confirm("No of Installments is greater than or equals to "+document.getElementsByName("txtNoInst")[indx-1].value+". Please click OK to proceed and 			CANCEL to change Total Amt. and Install. Amt.!!!");
    		if (r==true)
    		{
      			return true;
    		}
    		else
    		{ 
       			document.getElementsByName("txtAmount")[indx-1].value= "";
       			document.getElementsByName("txtInstAmount")[indx-1].value= "";
       			document.getElementsByName("txtNoInst")[indx-1].value= "";
       			document.getElementsByName("txtAmount")[indx-1].focus();
       			return false;
    		}
  	}
  


	return true;
}


/*function AmtCheck()
{
            var oTable = document.getElementById("Detail");
            var iTR = oTable.rows.length;
            var flag =0;

            for(i=0;i<iTR-1;i++)
            {   
                var m = parseInt(document.getElementsByName("txtValidFrom")[i].value);
                var n= parseInt(document.getElementsByName("txtValidUpto")[i].value);               

                if (m > n)
                {
                   alert("Valid Upto Should Be Greater Than or Equal To ValidFrom");
                   document.getElementsByName("txtValidUpto")[i].focus(); 
                   return false;
                }                             

                                                  
            }             
 
        return true;
}
*/



function chk_YearMonth()
{
            var oTable = document.getElementById("Detail");
            var iTR = oTable.rows.length;
            var flag =0;
            var i ;
       
                               
     for(i=0;i<iTR-1;i++)
     {                                                                                             
      if (document.getElementsByName("status")[i].value != 'D')
      {
       var  yearM = document.getElementsByName("txtValidFrom")[i].value;  
       var month =yearM.substring(4,6);

        if (yearM.length != 6)
        {
      
        alert("From Year should be a Six digit Number");
        document.getElementsByName("txtValidFrom")[i].focus();                     
        document.getElementsByName("txtValidFrom")[i].select();
            //event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

  
       if(month < 1 || month > 12)
       {
       alert("Month should be Within 1 to 12");
       document.getElementsByName("txtValidFrom")[i].focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
          return false;
       }
      }      
  }
    return true;
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
  //alert('criteria in jsp='+document.all.criteria.value);  
  doExecute();  
}

	function EmpClick()
  {
    document.all.buttonFlag.value='';
    document.frmMaintainDirectPayroll.hdnAction.value = "";    
 
    if (  document.all.screenModeDir.value == 'UG')
          document.all.screenModeDir.value = 'U';
    document.frmMaintainDirectPayroll.action="../../../DirectPayOptionClickAction.do";
    document.frmMaintainDirectPayroll.optVal.value="1";     
    document.frmMaintainDirectPayroll.submit();
	}

	function PayClick() 
  {
  document.frmMaintainDirectPayroll.hdnAction.value = "";  
    document.all.buttonFlag.value='';
 
    if (  document.all.screenModeDir.value == 'UG')
          document.all.screenModeDir.value = 'U';
  

    document.frmMaintainDirectPayroll.action="../../../DirectPayOptionClickAction.do";
    document.frmMaintainDirectPayroll.optVal.value="2";
    document.frmMaintainDirectPayroll.submit(); 
	}
  
	function MiscClick() 
  {
   document.all.buttonFlag.value='';
        document.frmMaintainDirectPayroll.hdnAction.value = "";   
 
    if (  document.all.screenModeDir.value == 'UG')
          document.all.screenModeDir.value = 'U';

    document.frmMaintainDirectPayroll.action="../../../DirectPayOptionClickAction.do";
    document.frmMaintainDirectPayroll.optVal.value="3";        
    document.frmMaintainDirectPayroll.submit(); 
	}

function doInsertMode()
{
//  alert("new");
  document.frmMaintainDirectPayroll.hdnAction.value = "";
  document.all.buttonFlag.value='';
  document.all.screenModeDir.value = 'N';
  frmMaintainDirectPayroll.headerDataChanged.value = "false";
  frmMaintainDirectPayroll.action="../../../DirectPayrollNewMode.do"
 frmMaintainDirectPayroll.submit();
}

function doQueryMode()
{  
  document.all.buttonFlag.value='';
  document.frmMaintainDirectPayroll.hdnAction.value = "";  
  document.all.screenModeDir.value = 'Q';
  frmMaintainDirectPayroll.headerDataChanged.value = "false";
  frmMaintainDirectPayroll.action="../../../DirectPayrollQueryMode.do"
  frmMaintainDirectPayroll.submit();
}


function lfnLoad()
{
  mode = document.all.screenMode.value;
//alert(mode);
setEmpCategory();<!--// start added by sonia on 02-02-2011 -->
  if(mode=='')
  {
      doQueryMode();
  }

   
  if (document.all.screenModeDir.value == "")
  {
     document.all.screenModeDir.value = "Q";
     document.all.screenMode.value = "Q";    
  }

  mode = document.all.screenModeDir.value;

  if(mode=='')
  {
     document.all.butGetDetail.disabled="";   
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
	      //Added by Neeraj Starts
      document.all.butHistory.disabled="disabled";
     //Added By Neeraj Ends
  }

  if(mode=='Q')
  {
	  //setEmpCategory();
     document.all.butGetDetail.disabled="";
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";     
	      //Added by Neeraj Starts
      document.all.butHistory.disabled="disabled";
     //Added By Neeraj Ends
  }

  if(mode=='U')
  {
	  //alert("modeU");
	 // setEmpCategory();
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";
	  //Added by Neeraj Starts
      document.all.butHistory.disabled="disabled";
     //Added By Neeraj Ends

      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
  }

  if(mode=='N' )
  {
      document.all.butHistory.disabled="disabled";
	  
var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;  
  for(i=0; i < iTr2 -1; i++)
    {
		if(document.getElementsByName("txtAgencyName")[i].value != "")
		{	 
			document.getElementsByName("txtAgencyNo")[i].style.className="required";
			document.getElementsByName("txtAgencyName")[i].style.className="required";
			document.getElementsByName("txtAgencySite")[i].style.className="required";
			document.getElementsByName("txtAgency")[i].style.className="required";
			document.getElementsByName("txtAgencySiteCode")[i].style.className="required";

			document.getElementsByName("txtAgencyNo")[i].style.background="#ffffd3";
			document.getElementsByName("txtAgencyName")[i].style.background="#e0e0e0";
			document.getElementsByName("txtAgencySite")[i].style.background="#ffffd3";
			document.getElementsByName("txtAgency")[i].style.className="#ffffd3";
			document.getElementsByName("txtAgencySiteCode")[i].style.background="#ffffd3";
		}
    }

      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";      
  }

  if(mode=='UG')
  {
		document.all.butHistory.disabled="disabled";
		document.all.butGetDetail.disabled="disabled";
		document.all.butInsert.disabled="";
		document.all.butDelete.disabled="";
  }  

  if(document.frmMaintainDirectPayroll.hdnAction.value == "GetEmpNameDtl")
  {
      var iRowVal = document.frmMaintainDirectPayroll.hdnRowVal.value; 
      if (document.frmMaintainDirectPayroll.hdnEmpName.value != "") 
      {
        document.getElementsByName("txtName")[iRowVal-1].value = document.frmMaintainDirectPayroll.hdnEmpName.value;
        document.frmMaintainDirectPayroll.hdnAction.value = "";
        document.getElementsByName("txtPayCode")[iRowVal-1].focus();      
      }
      else
      {
          alert("Invalid Employee Number");
		  document.getElementsByName("txtEmpNo")[iRowVal-1].value = ""; 
          document.getElementsByName("txtName")[iRowVal-1].value = "";                          
      }
  }

  if(document.frmMaintainDirectPayroll.hdnAction.value == "GetEmpName")
  {
      if (document.frmMaintainDirectPayroll.txtName1.value == "")   
      {
          alert("Invalid Employee Number"); 
          //document.frmMaintainDirectPayroll.txtEmpNo1.focus();commented by sonia on 21-10-2010  
      }
  }  

  
  if(document.frmMaintainDirectPayroll.hdnAction.value == "GetPayCodeName")
  {
      if (document.frmMaintainDirectPayroll.txtPayCodeName.value == "")   
      {
          alert("Invalid Savings Code"); 
          document.frmMaintainDirectPayroll.txtPayCode1.focus(); 
      }
  }    

  if(document.frmMaintainDirectPayroll.hdnAction.value == "GetPayCodeNameDtl")
  {
      var iRowVal = document.frmMaintainDirectPayroll.hdnRowVal.value;   
      if (document.frmMaintainDirectPayroll.hdnPayCodeName.value != "") 
      {  
      var iRowVal = document.frmMaintainDirectPayroll.hdnRowVal.value; 
      document.getElementsByName("txtDescription")[iRowVal-1].value = document.frmMaintainDirectPayroll.hdnPayCodeName.value; 
      document.frmMaintainDirectPayroll.hdnAction.value = "";
      document.getElementsByName("txtPayMode")[iRowVal-1].focus();            
      }
      else
      {
          alert("Invalid Pay Code"); 
          document.getElementsByName("txtDescription")[iRowVal-1].value = "";                                    
          document.getElementsByName("txtPayCode")[iRowVal-1].focus();                
      }      
  }
  
  

  if((document.frmMaintainDirectPayroll.optVal.value == '')||(document.frmMaintainDirectPayroll.optVal.value == '1'))
  {
     document.all.radioEmp.checked="true";
     if(document.frmMaintainDirectPayroll.optVal.value == '')
      EmpClick();
  }
  else if(document.frmMaintainDirectPayroll.optVal.value == '2')
  {
    document.all.radioPay.checked="true";
//    return true;
  }
  else if(document.frmMaintainDirectPayroll.optVal.value == '3')
  {
    document.all.radioMisc.checked="true";
//    return true;
  }

  var oTable = document.getElementById("Detail");
/*  if(oTable == null)
  {
    return;
  } */
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
     if (document.getElementsByName("status")[i].value == 'Q')
      {                
        document.getElementsByName("txtPayCode")[i].disabled="disabled";
        document.getElementsByName("txtEmpNo")[i].disabled="disabled";            
      }
  }


  document.all.butDelete.disabled="true";
  mode1 = frmMaintainDirectPayroll.screenMode.value;  
  menuHandling(mode1);
   //added by sonia on 07-07-2011/////////
  <%ArrayList DepuPayCodesList=(ArrayList)request.getSession().getAttribute("DepuPayCodesList");
	if(DepuPayCodesList==null)
	{%>
		
       chk_DepuSupplier();
	<%}%>
   //added by sonia on 07-07-2011/////////

  //added by sonia on 19-10-2010/////////
  <%ArrayList payCodesList=(ArrayList)request.getSession().getAttribute("payCodesList");
	if(payCodesList==null)
	{%>
		
       chk_Supplier();
	<%}%>
   //added by sonia on 19-10-2010/////////
	disable_PayCodes();/////////////////added  by sonia on 26 -04-2011 ////////////////
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;  
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value != 'D')
		{
			mandateSavNo(i+1);
		}
	}

serialNumber();
	
 }


function enable()
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
	 
     if (document.getElementsByName("status")[i].value == 'Q')
      {                
        document.getElementsByName("txtPayCode")[i].disabled="";
        document.getElementsByName("txtEmpNo")[i].disabled="";
        document.getElementsByName("txtPayMode")[i].disabled="";
		document.getElementsByName("txtSavNo")[i].disabled="";
      }
	  document.getElementsByName("txtPayMode")[i].disabled="";
  }
}

function ShowLovEmpNo()
{
    var site = frmMaintainDirectPayroll.loginLocCode.value;
	if (site == 0)
	{
		alert("Page is not yet loaded fully. Please wait or refresh to reload");
	}
	else
	{
	   frmMaintainDirectPayroll.lovKey.value = "MaintDirectPayrollEmp" + frmMaintainDirectPayroll.screenName.value + frmMaintainDirectPayroll.screenMode.value;
	   frmMaintainDirectPayroll.txtDisplayFields.value = "txtEmpNo1,txtName1,txtCPF1,txtCategory1,txtPattern1,txtEmpStatus1";<!--//  added by sonia on 02-02-2011 -->
	   frmMaintainDirectPayroll.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
	   frmMaintainDirectPayroll.queryParam.value="txtSiteID="+frmMaintainDirectPayroll.loginLocCode.value+",hdnEmpLbrFlag="+frmMaintainDirectPayroll.hdnEmpLbrFlag.value;   // added by yogesh
	   frmMaintainDirectPayroll.txtIndex.value=""; 
	   frmMaintainDirectPayroll.txtInputField.value="";
	   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainDirectPayroll');
	   return true;
	}
}

function ShowLovEmpNo1(i)
{
    var site = frmMaintainDirectPayroll.loginLocCode.value;
	if (site == 0)
	{
		alert("Page is not yet loaded fully. Please wait or refresh to reload");
	}
	else
	{
		if(document.getElementById("txtPayCode").value == 516)
		{
			frmMaintainDirectPayroll.lovKey.value = "MaintDirectPayrollRetireEmp" + frmMaintainDirectPayroll.screenName.value + frmMaintainDirectPayroll.screenMode.value;
			////frmMaintainDirectPayroll.txtDisplayFields.value = "txtEmpNo,txtName,txtCPF1,txtCategory1,txtPattern1";<!--//  commented  by sonia on 02-02-2011 -->
			frmMaintainDirectPayroll.txtDisplayFields.value = "txtEmpNo,txtName,txtCPF,txtCategory,txtPattern,txtEmpStatus";<!--//  added by sonia on 02-02-2011 -->
			frmMaintainDirectPayroll.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
			frmMaintainDirectPayroll.queryParam.value="txtSiteID="+frmMaintainDirectPayroll.loginLocCode.value+",hdnEmpLbrFlag="+frmMaintainDirectPayroll.hdnEmpLbrFlag.value;  
			frmMaintainDirectPayroll.txtIndex.value=i;  
			frmMaintainDirectPayroll.txtInputField.value="";
			showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainDirectPayroll');
			return true;

		}
		else
		{
		   frmMaintainDirectPayroll.lovKey.value = "MaintDirectPayrollEmp" + frmMaintainDirectPayroll.screenName.value + frmMaintainDirectPayroll.screenMode.value;
		   ////frmMaintainDirectPayroll.txtDisplayFields.value = "txtEmpNo,txtName,txtCPF1,txtCategory1,txtPattern1";<!--//  commented  by sonia on 02-02-2011 -->
		   frmMaintainDirectPayroll.txtDisplayFields.value = "txtEmpNo,txtName,txtCPF,txtCategory,txtPattern,txtEmpStatus";<!--//  added by sonia on 02-02-2011 -->
		   frmMaintainDirectPayroll.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
		   frmMaintainDirectPayroll.queryParam.value="txtSiteID="+frmMaintainDirectPayroll.loginLocCode.value+",hdnEmpLbrFlag="+frmMaintainDirectPayroll.hdnEmpLbrFlag.value;  
		   frmMaintainDirectPayroll.txtIndex.value=i;  
		   frmMaintainDirectPayroll.txtInputField.value="";
		   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainDirectPayroll');
		   return true;
		}
	}
}

function ShowLovPayCode()
{
   frmMaintainDirectPayroll.lovKey.value = "MaintDirectPayrollPayCode" + frmMaintainDirectPayroll.screenName.value + frmMaintainDirectPayroll.screenMode.value;
   frmMaintainDirectPayroll.queryParam.value = "hdnEmpLbrFlag="+frmMaintainDirectPayroll.hdnEmpLbrFlag.value+",screenName="+frmMaintainDirectPayroll.screenName.value+",screenMode="+frmMaintainDirectPayroll.screenMode.value+",txtSiteID="+frmMaintainDirectPayroll.loginLocCode.value;   // added by swapnendu Dt 07 Sep 2012.
   frmMaintainDirectPayroll.txtDisplayFields.value = "txtPayCode1,txtPayCodeName";
   frmMaintainDirectPayroll.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";
   frmMaintainDirectPayroll.txtIndex.value="";  
   frmMaintainDirectPayroll.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainDirectPayroll');
   return true;
}

function ShowLovPayCode1(i)
{
   frmMaintainDirectPayroll.lovKey.value = "MaintDirectPayrollPayCode" + frmMaintainDirectPayroll.screenName.value + "N";
   frmMaintainDirectPayroll.queryParam.value = "hdnEmpLbrFlag="+frmMaintainDirectPayroll.hdnEmpLbrFlag.value+",screenName="+frmMaintainDirectPayroll.screenName.value+",screenMode="+frmMaintainDirectPayroll.screenMode.value+",txtSiteID="+frmMaintainDirectPayroll.loginLocCode.value;   // added by swapnendu Dt 07 Sep 2012.
   frmMaintainDirectPayroll.txtDisplayFields.value = "txtPayCode,txtDescription";
   frmMaintainDirectPayroll.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";
   frmMaintainDirectPayroll.txtIndex.value=i;  
   frmMaintainDirectPayroll.txtInputField.value="txtPayCode";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainDirectPayroll');
   
   return true;
}
//added by yogesh
function ShowLovAgencyCode(i)
{
if(document.getElementsByName("txtEmpNo")[i].value=="")
   {
      alert("Please select emp number first!!!");
      return false;
   }
   if(document.getElementsByName("txtPayCode")[i].value=="")
   {
      alert("Please select Pay Code first!!!");
      return false;
   }
	//alert("LOV index---" + i)
	if(!chk_DisablePayCodes(i)) /////////////////added  by sonia on 25-04-2011 ////////////////
		return false; /////////////////added  by sonia on 25-04-2011 ////////////////
     frmMaintainDirectPayroll.lovKey.value = "MaintDirectPayrollAgencyCode" + frmMaintainDirectPayroll.screenName.value +"N";
     frmMaintainDirectPayroll.txtDisplayFields.value = "txtAgency,txtAgencyName,txtAgencyNo";
     frmMaintainDirectPayroll.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Agency,Payroll.Common.Desc,Payroll.Common.SupNo"; // added by yogesh on 23 sep 2010
     frmMaintainDirectPayroll.queryParam.value="txtSiteID="+frmMaintainDirectPayroll.loginLocCode.value+",txtEmpNo="+document.getElementsByName("txtEmpNo")[i].value+",txtPayCode="+document.getElementsByName("txtPayCode")[i].value;
     frmMaintainDirectPayroll.txtIndex.value=i;  
     frmMaintainDirectPayroll.txtInputField.value ="";
     if(!(document.getElementsByName("status")[i].value == "N"))
     document.getElementsByName("status")[i].value = "U";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainDirectPayroll');
     return true;
 }

function ShowLovAgencySiteCode()
{
   if(document.getElementsByName("txtAgency")[i].value=="")
   {
      alert("Please select Agency Code first!!!");
      return false;
   }
     if(document.all.txtAgency.value=="" )
     {
        alert("Please select Agency Code first!!!");
        return false;
     }
     frmMaintainDirectPayroll.lovKey.value = "MaintDirectPayrollAgencySiteCode" + frmMaintainDirectPayroll.screenName.value + "N";
     frmMaintainDirectPayroll.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySite";   
 /*  frmMaintainDirectPayroll.queryParam.value = "txtAgency="+document.all.txtAgency.value;*/
     frmMaintainDirectPayroll.queryParam.value = "txtAgency="+document.getElementsByName("txtAgency")[i].value;
/*   frmEmpMediBillsForm.txtSearchFields.value = "";      */
     frmMaintainDirectPayroll.txtSearchFields.value = "";
     frmMaintainDirectPayroll.txtIndex.value=i;  
     frmEmpMediBillsForm.txtInputField.value ="";
     if(!(document.getElementsByName("status")[i].value == "N"))
     document.getElementsByName("status")[i].value = "U";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainDirectPayroll');
     return true;
}

function ShowLovAgencySiteCode(i)
{
   if(document.getElementsByName("txtAgency")[i].value=="")
   {
      alert("Please select Agency Code first!!!");
      return false;
   }
   frmMaintainDirectPayroll.lovKey.value = "MaintDirectPayrollAgencySiteCode" + frmMaintainDirectPayroll.screenName.value + "N";
   frmMaintainDirectPayroll.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySite";
   frmMaintainDirectPayroll.queryParam.value = "txtSiteID="+frmMaintainDirectPayroll.loginLocCode.value+",txtAgency="+document.getElementsByName("txtAgency")[i].value;

   frmMaintainDirectPayroll.txtSearchFields.value = "";
   frmMaintainDirectPayroll.txtIndex.value=i;  
   frmMaintainDirectPayroll.txtInputField.value="";
   if(!(document.getElementsByName("status")[i].value == "N"))
   document.getElementsByName("status")[i].value = "U";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainDirectPayroll');
   return true;
}

//added by yogesh

/*
function ShowLovAgencyCode(i)
{
if(document.getElementsByName("txtEmpNo")[i].value=="")
   {
      alert("Please select emp number first!!!");
      return false;
   }
   if(document.getElementsByName("txtPayCode")[i].value=="")
   {
      alert("Please select Pay Code first!!!");
      return false;
   }
   frmMaintainDirectPayroll.lovKey.value = "MaintDirectPayrollAgencyCode" + frmMaintainDirectPayroll.screenName.value + "N";
   frmMaintainDirectPayroll.txtDisplayFields.value = "txtAgency,txtAgencyName";
   frmMaintainDirectPayroll.txtSearchFields.value = "";
   frmMaintainDirectPayroll.queryParam.value="txtSiteID="+frmMaintainDirectPayroll.loginLocCode.value+",txtEmpNo="+document.getElementsByName("txtEmpNo")[i].value+",txtPayCode="+document.getElementsByName("txtPayCode")[i].value;
   frmMaintainDirectPayroll.txtIndex.value=i;  
   frmMaintainDirectPayroll.txtInputField.value="txtAgency";  
   if(!(document.getElementsByName("status")[i].value == "N"))
   document.getElementsByName("status")[i].value = "U";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainDirectPayroll');
   return true;
}

function ShowLovAgencySiteCode(i)
{
   if(document.getElementsByName("txtAgency")[i].value=="")
   {
      alert("Please select Agency Code first!!!");
      return false;
   }
   frmMaintainDirectPayroll.lovKey.value = "MaintDirectPayrollAgencySiteCode" + frmMaintainDirectPayroll.screenName.value + "N";
   frmMaintainDirectPayroll.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySite";
   frmMaintainDirectPayroll.queryParam.value = "txtAgency="+document.getElementsByName("txtAgency")[i].value+",txtSiteID="+frmMaintainDirectPayroll.loginLocCode.value;
   frmMaintainDirectPayroll.txtSearchFields.value = "";
   frmMaintainDirectPayroll.txtIndex.value=i;  
   frmMaintainDirectPayroll.txtInputField.value="";
   if(!(document.getElementsByName("status")[i].value == "N"))
   document.getElementsByName("status")[i].value = "U";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainDirectPayroll');
   return true;
}
*/
function doBasePrevDetail()
{
    document.all.buttonFlag.value='';  
    frmMaintainDirectPayroll.userPageRequested.value = 1*frmMaintainDirectPayroll.pageRequested.value - 1;
    frmMaintainDirectPayroll.action = "../../../DirectPayrollPrevDetailAction.do";
    frmMaintainDirectPayroll.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value='';  
    frmMaintainDirectPayroll.userPageRequested.value = 1*frmMaintainDirectPayroll.pageRequested.value + 1;
    frmMaintainDirectPayroll.action = "../../../DirectPayrollNextDetailAction.do";
    frmMaintainDirectPayroll.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';  
    frmMaintainDirectPayroll.userPageRequested.value = 1*frmMaintainDirectPayroll.newPageRequested.value ;
    frmMaintainDirectPayroll.action = "../../../DirectPayrollNextDetailAction.do";
    frmMaintainDirectPayroll.submit();
}


function menuHandling(mode1)
{
  if(mode1=='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg"; 
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
/*     document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  */
  
  }
}

  function doRefresh()
    {
           document.frmMaintainDirectPayroll.hdnAction.value = "";
        frmMaintainDirectPayroll.action = "../../../DirectPayrollRefresh.do";
        frmMaintainDirectPayroll.submit();
    }


function lfnGetEmpName(val) 
{
    if (val != "")
    {
          frmMaintainDirectPayroll.hdnAction.value="GetEmpName";
         //frmMaintainDirectPayroll.action="../../../DirSavGetEmpName.do"  commented by Sonia on 21-10-2010
         frmMaintainDirectPayroll.action="../../../DirSavGetEmpNameNormal.do";
         frmMaintainDirectPayroll.submit();
   }
}

function lfnGetEmpNameDtl(val, value) 
{
    if (value != "")
    {
      if(frmMaintainDirectPayroll.screenModeDir.value="N") 
      {
        //EnableField();      
         enable();
         frmMaintainDirectPayroll.hdnAction.value="GetEmpNameDtl";
         frmMaintainDirectPayroll.hdnRowVal.value=val;
         frmMaintainDirectPayroll.hdnEmpNo.value=value;     
        //frmMaintainDirectPayroll.action="../../../DirSavGetEmpName.do"  commented by Sonia on 21-10-2010
         frmMaintainDirectPayroll.action="../../../DirSavGetEmpNameNormal.do";
         frmMaintainDirectPayroll.submit();
      }
    }
}


function lfnGetPayCodeName(val) 
{
    if (val != "")
    {
         frmMaintainDirectPayroll.hdnAction.value="GetPayCodeName";
        //frmMaintainDirectPayroll.action="../../../DirSavGetEmpName.do"  commented by Sonia on 21-10-2010
         frmMaintainDirectPayroll.action="../../../DirSavGetEmpNameNormal.do";
         frmMaintainDirectPayroll.submit();
    }
}

function lfnGetPayCodeNameDtl(val, value) 
{
    if (value != "")
    {
        if(frmMaintainDirectPayroll.screenModeDir.value="N") 
        {
           enable();
           frmMaintainDirectPayroll.hdnAction.value="GetPayCodeNameDtl";
           frmMaintainDirectPayroll.hdnRowVal.value=val;
           frmMaintainDirectPayroll.hdnPayCode.value=value;     
           //frmMaintainDirectPayroll.action="../../../DirSavGetEmpName.do"  commented by Sonia on 21-10-2010
           frmMaintainDirectPayroll.action="../../../DirSavGetEmpNameNormal.do";
           frmMaintainDirectPayroll.submit();
        }
   }
}

function chk_Supplier()
{	
//alert('chk_Supplier');
	//frmMaintainDirectPayroll.headerDataChanged.value="true";
	//frmMaintainDirectPayroll.screenMode.value="N";
	frmMaintainDirectPayroll.action = "../../../CheckPayCodeSaveAction.do";
	frmMaintainDirectPayroll.submit();
}  

/////added by soni on 07-07-2011

function chk_DepuSupplier()
{	

	frmMaintainDirectPayroll.action = "../../../CheckDepuPayCodeSaveAction.do";
	frmMaintainDirectPayroll.submit();
}  


/*function chk_PayCodes(){
//alert('chkPaycode');
 var payCodeListArr = new Array();
<%
	
	ArrayList payCodesList2=(ArrayList)request.getSession().getAttribute("payCodesList");
	if(payCodesList2!=null)
	{
		for(int i=0;i<payCodesList2.size();i++)
		{
		String payCode=payCodesList2.get(i).toString();
		%>
		var payCodeJS="<%=payCode%>";
		//alert('pushing....'+payCodeJS);
		payCodeListArr.push(payCodeJS);
		<%
		}
	}
%>



var oTable = document.getElementById("Detail");
var iTr2 = oTable.rows.length;
//alert(iTr2);
var i = 0;  
  for(i=0; i < iTr2 -1 ; i++)
  {
   var paycode=document.getElementsByName("txtPayCode")[i].value;   
   //alert(paycode);
   //alert("ArraySize" +payCodeListArr.length);
   for(var m=0;m<payCodeListArr.length;m++)
		{


if(paycode == payCodeListArr[m])
		{
			//alert('inside....')
					
					//alert("disable value"  + document.getElementsByName("txtPayCode")[i].disabled);
			if(!document.getElementsByName("txtPayCode")[i].disabled){
						//alert("value");
			document.getElementsByName("txtAgencyNo")[i].style.className="required";
			document.getElementsByName("txtAgencyName")[i].style.className="required";
			document.getElementsByName("txtAgencySite")[i].style.className="required";
			document.getElementsByName("txtAgency")[i].style.className="required";
			document.getElementsByName("txtAgencySiteCode")[i].style.className="required";

			document.getElementsByName("txtAgencyNo")[i].style.background="#ffffd3";
			document.getElementsByName("txtAgencyName")[i].style.background="#e0e0e0";
			document.getElementsByName("txtAgencySite")[i].style.background="#ffffd3";
			document.getElementsByName("txtAgency")[i].style.className="#ffffd3";
			document.getElementsByName("txtAgencySiteCode")[i].style.background="#ffffd3";
			//alert(document.getElementsByName("txtAgencyNo")[i].style.className);
					}
		}
	}
  } 
}
///////////////end added by sonia on 19 -10-2010 /////////////////
*/

<!--// start added by sonia on 02-02-2011 -->
function setEmpCategory() {
	var oTable = document.getElementById("Detail");
	var oPtVal=document.getElementById("optVal").value;
	//alert("oPtVal" +oPtVal);
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	if(iTr2>1) {
		var i=<%=i%>;
	    if(document.frmMaintainDirectPayroll.optVal.value == "1"){
		var category=document.getElementById("txtCategory1").value;		
		document.getElementsByName("txtCategory")[i-1].value=category;
		var txtPattern=document.getElementById("txtPattern1").value;		
		document.getElementsByName("txtPattern")[i-1].value=txtPattern;
		}
		
		//alert(document.getElementsByName("txtCategory")[i-1].value);
	}
}
<!--// end added by sonia on 02-02-2011 -->
<!--// start added by sonia on 10-03-2011 -->
function checkSupplierSites(){
var flag = 0;
var oTable = document.getElementById("Detail");
var iTr2 = oTable.rows.length;
//alert(iTr2);
var i = 0;  
  for(i=0; i < iTr2 -1 ; i++)
  {if(document.getElementsByName("status")[i].value != "D" )
  {
  	if((document.getElementsByName("txtAgencyNo")[i].value != "" &&  document.getElementsByName("txtAgencySite")[i].value == "") ||  (document.getElementsByName("txtAgencyNo")[i].value == ""  &&  document.getElementsByName("txtAgencySite")[i].value != "" )){	

			document.getElementsByName("txtAgencyNo")[i].style.className="required";
			document.getElementsByName("txtAgencyName")[i].style.className="required";
			document.getElementsByName("txtAgencySite")[i].style.className="required";
			document.getElementsByName("txtAgency")[i].style.className="required";
			document.getElementsByName("txtAgencySiteCode")[i].style.className="required";

			document.getElementsByName("txtAgencyNo")[i].style.background="#ffffd3";
			document.getElementsByName("txtAgencyName")[i].style.background="#e0e0e0";
			document.getElementsByName("txtAgencySite")[i].style.background="#ffffd3";
			document.getElementsByName("txtAgency")[i].style.className="#ffffd3";
			document.getElementsByName("txtAgencySiteCode")[i].style.background="#ffffd3";			
		  alert("Mandatory field is empty!");
			      flag=flag+1;
            return false;
		}
		}
  }
 if(flag > 0){			
			alert("flag" +flag)
			return false;
			}			
			return true;

}
<!--// end added by sonia on 10-03-2011 -->

function disable_PayCodes(){
//alert('chkPaycode');


 var payCodeListArr = new Array();
<%
	
	ArrayList payCodesLst=(ArrayList)request.getSession().getAttribute("payCodesList");
	if(payCodesLst!=null)
	{
		for(int i=0;i<payCodesLst.size();i++)
		{
		String payCode=payCodesLst.get(i).toString();
		%>
		var payCodeJS="<%=payCode%>";
		//alert('pushing....'+payCodeJS);
		payCodeListArr.push(payCodeJS);
		<%
		}
	}
%>



var oTable = document.getElementById("Detail");
var iTr2 = oTable.rows.length;
//alert(iTr2);
var i = 0;  
  for(i=0; i < iTr2 -1 ; i++)
  {
   var paycode=document.getElementsByName("txtPayCode")[i].value;   
   //alert(paycode);
   //alert("ArraySize" +payCodeListArr.length);
   for(var m=0;m<payCodeListArr.length;m++)
		{


if(paycode == payCodeListArr[m])
		{
			//alert('inside....')
					
					//alert("disable value"  + document.getElementsByName("txtPayCode")[i].disabled);
			if(!document.getElementsByName("txtPayCode")[i].disabled){
						//alert("value");
			document.getElementsByName("txtAgencyNo")[i].style.className="locked";
			document.getElementsByName("txtAgencyName")[i].style.className="locked";
			document.getElementsByName("txtAgencySite")[i].style.className="locked";
			document.getElementsByName("txtAgency")[i].style.className="locked";
			document.getElementsByName("txtAgencySiteCode")[i].style.className="locked";
			document.getElementsByName("txtAgencyNo")[i].style.background="#e0e0e0";
			document.getElementsByName("txtAgencyName")[i].style.background="#e0e0e0";
			document.getElementsByName("txtAgencySite")[i].style.background="#e0e0e0";
			document.getElementsByName("txtAgency")[i].style.className="#e0e0e0";
			document.getElementsByName("txtAgencySiteCode")[i].style.background="#e0e0e0";			
			
		  }
		}
	}
  }  
}
///////////////end added by sonia on 25 -04-2011 /////////////////




function chk_DisablePayCodes(val){
//alert('chkPaycode');
var flag = 0;

 var payCodeListArr = new Array();
<%
	
	ArrayList payCodesLst1=(ArrayList)request.getSession().getAttribute("payCodesList");
	if(payCodesLst1!=null)
	{
		for(int i=0;i<payCodesLst1.size();i++)
		{
		String payCode=payCodesLst1.get(i).toString();
		%>
		var payCodeJS="<%=payCode%>";
		//alert('pushing....'+payCodeJS);
		payCodeListArr.push(payCodeJS);
		<%
		}
	}
%>



var oTable = document.getElementById("Detail");
var iTr2 = oTable.rows.length;
//alert(iTr2);
var i = 0;  
  for(i=0; i < iTr2 -1 ; i++)
  {
if(document.getElementsByName("txtAgencyNo")[val].style.className != "required" ){

  
   var paycode=document.getElementsByName("txtPayCode")[val].value;   
   //alert(paycode);
   //alert("ArraySize" +payCodeListArr.length);
   for(var m=0;m<payCodeListArr.length;m++)
		{


if(paycode == payCodeListArr[m])
		{
		//	alert('inside....')
			//alert("disable value"  + document.getElementsByName("txtPayCode")[i].disabled);
			if(!document.getElementsByName("txtPayCode")[val].disabled){
						//alert("value");
			document.getElementsByName("txtAgencyNo")[val].style.className="locked";
			document.getElementsByName("txtAgencyName")[val].style.className="locked";
			document.getElementsByName("txtAgencySite")[val].style.className="locked";
			document.getElementsByName("txtAgency")[val].style.className="locked";
			document.getElementsByName("txtAgencySiteCode")[val].style.className="locked";
			document.getElementsByName("txtAgencyNo")[val].style.background="#e0e0e0";
			document.getElementsByName("txtAgencyName")[val].style.background="#e0e0e0";
			document.getElementsByName("txtAgencySite")[val].style.background="#e0e0e0";
			document.getElementsByName("txtAgency")[val].style.className="#e0e0e0";
			document.getElementsByName("txtAgencySiteCode")[val].style.background="#e0e0e0";
			flag=flag+1;
			
		  }
		}
	}
  }
  }  

  if(flag > 0){			
			//alert("flag" +flag)
			return false;
			}			
			return true;
}
///////////////end added by sonia on 25 -04-2011 /////////////////

function chk_DeputationPayCodes(){
//alert('inside....');

 var payCodeListArr1 = new Array();
<%
	
	ArrayList payCodesLst3=(ArrayList)request.getSession().getAttribute("DepuPayCodesList");
	if(payCodesLst3 != null)
	{
		for(int i=0;i<payCodesLst3.size();i++)
		{
		String payCode=payCodesLst3.get(i).toString();
		%>
		var payCodeJS="<%=payCode%>";
		//alert('pushing....'+payCodeJS);
		payCodeListArr1.push(payCodeJS);
		<%
		}
	}
%>

var flag = 0;
var oTable = document.getElementById("Detail");
var iTr2 = oTable.rows.length;
//alert(iTr2);
var i = 0;  
  for(i=0; i < iTr2 -1 ; i++)
  {
	
 var paycode=document.getElementsByName("txtPayCode")[i].value;   
  
 for(var s=0;s<payCodeListArr1.length;s++)
{
if(paycode == payCodeListArr1[s]  && document.getElementsByName("txtEmpStatus")[i].value == 'EMPSTATUS$DEPU' &&( document.getElementsByName("status")[i].value == 'N' || document.getElementsByName("status")[i].value == 'U'))

{
       if((document.getElementsByName("txtAgencyNo")[i].value == "" &&  document.getElementsByName("txtAgencySite")[i].value == "") ||  (document.getElementsByName("txtAgencyNo")[i].value == ""  &&                 document.getElementsByName("txtAgencySite")[i].value == "" )){

				document.getElementsByName("txtAgencyNo")[i].style.className="required";
				document.getElementsByName("txtAgencyName")[i].style.className="required";
				document.getElementsByName("txtAgencySite")[i].style.className="required";
				document.getElementsByName("txtAgency")[i].style.className="required";
				document.getElementsByName("txtAgencySiteCode")[i].style.className="required";

				document.getElementsByName("txtAgencyNo")[i].style.background="#ffffd3";
				document.getElementsByName("txtAgencyName")[i].style.background="#e0e0e0";
				document.getElementsByName("txtAgencySite")[i].style.background="#ffffd3";
				document.getElementsByName("txtAgency")[i].style.className="#ffffd3";
				document.getElementsByName("txtAgencySiteCode")[i].style.background="#ffffd3";			
				
				flag=flag+1;
            
		}
}
  else if(paycode == payCodeListArr1[s]  && document.getElementsByName("txtEmpStatus")[i].value != 'EMPSTATUS$DEPU' &&( document.getElementsByName("status")[i].value == 'N' || document.getElementsByName("status")[i].value == 'U'))
	  { 
            //document.all.buttxtAgency.disabled="true";
            document.getElementsByName("txtAgencyNo")[i].style.className="locked";
			document.getElementsByName("txtAgencyName")[i].style.className="locked";
			document.getElementsByName("txtAgencySite")[i].style.className="locked";
			document.getElementsByName("txtAgency")[i].style.className="locked";
			document.getElementsByName("txtAgencySiteCode")[i].style.className="locked";

			document.getElementsByName("txtAgencyNo")[i].style.background="#e0e0e0";
			document.getElementsByName("txtAgencyName")[i].style.background="#e0e0e0";
			document.getElementsByName("txtAgencySite")[i].style.background="#e0e0e0";
			document.getElementsByName("txtAgency")[i].style.className="#e0e0e0";
			document.getElementsByName("txtAgencySiteCode")[i].style.background="#e0e0e0";		
  
     }

		}
  }//ends for loop
 if(flag > 0){			
			  //alert("flag" +flag)
			  alert("Mandatory field is empty!");
			  return false;
			 }			
			return true;




}

function mandateSavNo(indx)
{
	var objPayCode = document.getElementsByName("txtPayCode")[indx-1];
	var objSavNo = document.getElementsByName("txtSavNo")[indx-1];
	if(objPayCode.value == "396" || objPayCode.value == "397")
	{
		if(objSavNo.value=="")
		{
			if(document.all.screenMode.value=='U' || document.all.screenMode.value=='N')
			{
				objSavNo.readOnly = "";
				objSavNo.className = "required";
				objSavNo.style.background = "#ffffd3";
			}
		}
	}
	else
	{
		document.getElementsByName("txtSavNo")[indx-1].value="";
		objSavNo.readOnly = "true";
		objSavNo.className = "locked";
		objSavNo.style.background = "#e0e0e0";
	}
}


function serialNumber()
{
var oTable = document.getElementById("Detail");
var iTr2 = oTable.rows.length;
var sr_no=0;
var i=0;
  for(i=0; i < iTr2 -1 ; i++)
  {
if(document.getElementsByName("status")[i].value != 'D')
  {
++sr_no;
document.getElementsByName("txtSrNo")[i].value=sr_no;
  }
  
	
}

}


</script>