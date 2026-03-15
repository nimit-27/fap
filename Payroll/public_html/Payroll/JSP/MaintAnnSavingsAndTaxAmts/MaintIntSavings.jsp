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
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0; %>
<% i = 0; j=0; %>

<html:form  action="MaintainInternalSavingsBase" name="frmMaintainInternalSavings" type="FCIPAY.Payroll.WEBTIER.Form.MaintainInternalSavingsForm" scope="session">

<bean:define id="ParentForm" name="frmMaintainInternalSavings" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" />
<html:hidden property="headerDataChanged" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="optVal" />

<table>
  <TR height=30>
    <TD  colSpan=12 class=mainHeader height=10><bean:message key="Payroll.MaintIntSavings.head" /></TD>
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
            <TD class=subHeader colspan=6><bean:message key="Payroll.MaintIntSavings.hd" /></TD>
          </TR>
          <TR>
            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
          </TR>

          <tr height="15" >
            <td colspan="2"></td>
          </tr>
       
          <TR>                            
            <td width="30%" class="radioText" ><input type="radio" name="radioSave" value="S" onclick="SavCodeClick()"   ><bean:message key="Payroll.MaintIntSavings.sav"  />
            
            <td width="45%" class="radioText" ><input type="radio" name="radioEmp" value="E" onclick="EmpNoClick()" ><bean:message  key="Payroll.MaintIntSavings.empw" />
            
            <td width="25%" class="radioText"><input type="radio" name="radioMisc" value="M" onclick="MiscelClick()" ><bean:message  key="Payroll.MaintIntSavings.mis" />
          <td colspan="3" ></td>          
          </TR>
          
          <tr height="10">	
            <td></td>
          </tr>         
        
          <logic:equal property= "optVal" name= "frmMaintainInternalSavings" value="1">
          <tr>
          <td class="labelText"  width="40%" ><bean:message key="Payroll.MaintIntSavings.code" /></td>
          <td><html:text  property="txtSavCode1" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="10" size="23" readonly="true" styleClass="required"  onblur="lfnGetPayCodeName(this.value)"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtSavCode1" onclick="return ShowSavCode();" >&nbsp;&nbsp;<html:text  property="txtSavCodeName"  maxlength="10" size="26" styleClass="locked" readonly="true" /></td>
          </tr>
          </logic:equal>
          
          <logic:equal property= "optVal" name= "frmMaintainInternalSavings" value="2">
          <tr>
          <td class="labelText"  width="40%" ><bean:message key="Payroll.MaintElecMtrRdg.empno" /></td>
          <td><html:text  property="txtEmpNo1" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="10" size="23"  readonly="true" styleClass="required"  onblur="lfnGetEmpName(this.value)"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo1"  onclick="return ShowEmpNum();" >&nbsp;&nbsp;<html:text  property="txtEmpName1"  maxlength="10" size="26" styleClass="locked" readonly="true" /></td>
          </tr>
          </logic:equal>
          
          <logic:equal property= "optVal" name= "frmMaintainInternalSavings" value="3">
          <tr height = 30><td width="40%" >&nbsp;</td>    <td>&nbsp; </td>
          </tr>
          </logic:equal>
        </tr>  
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
                <td bgcolor="#4682B4" nowrap class=actTabText><bean:message key="Payroll.MaintIntSavings.detail" /><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <TD class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();" /></TD>
                              <td class=tableHeader><bean:message key="Payroll.MaintIntSavings.srno" /></td>
                              <td class=tableHeader><bean:message key="Payroll.MaintIntSavings.emp"  /></td>
                              <td class=tableHeader><bean:message key="Payroll.MaintIntSavings.name" /></td>                                               
                              <td class=tableHeader><bean:message key="Payroll.MaintIntSavings.code" /></td>
                              <td class=tableHeader><bean:message key="Payroll.MaintIntSavings.desc" /></td>                                               
                              <td class=tableHeader><bean:message key="Payroll.MaintIntSavings.num" /></td>   
                               <td class=tableHeader><bean:message key="Payroll.MaintIntSavings.date" /></td>  
                              <td class=tableHeader><bean:message key="Payroll.MaintIntSavings.val" /></td> 
                              <td class=tableHeader><bean:message key="Payroll.MaintIntSavings.amt" /></td>  
                              <td class=tableHeader width="8%"><bean:message key="Payroll.MaintDirect.agencycod" /></td>       
                              <td class=tableHeader width="12%"><bean:message key="Payroll.MaintDirect.agencyName" /></td>                                               
                              <td class=tableHeader width="6%"><bean:message key="Payroll.MaintDirect.agencysite" /></td>  
                            </TR>
                            
                            <logic:iterate id="intInfo" name="frmMaintainInternalSavings" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintainInternalSavingsBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="intInfo" property="status" value="D" >                              
                   
                                   <tr>   
                                       <td ><html:checkbox property="checked" name="frmMaintainInternalSavings" onclick="checkRecord();" /></td>
<logic:notEqual name="intInfo" property="status" value="Q" >   
                                       <% ++j; %>
                                       <td ><html:text property="txtSrlNo" name="intInfo" size="1"  value="<%=String.valueOf(j)%>"  styleClass="optional" style="width:93%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>         

                                        <td ><html:text property="txtEmpNo" name="intInfo" styleClass="required" size="8"  alt="<%=String.valueOf(i)%>" readonly="true" onchange="
                                        if (!num_Check(this.value,1)) 
                                        { 
                                          this.focus();
                                          return false;
                                        }                                      
                                        else
                                          return changed(this.alt);
                                        "  />
                                        <logic:equal name="intInfo" property="status" value="N">                                       
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  onclick="ShowDetEmpNum(this.alt);" >
                                        </logic:equal>                                      
                                      
                                       <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowDetEmpNum(this.alt);" >                                     
                                      </logic:equal>                                      
                                       
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"   onclick="ShowDetEmpNum(this.alt);" >                                       
                                      </logic:equal>
                                       
                                      </td>
 
                                       <td ><html:text property="txtEmpName" name="intInfo" size="20"    styleClass="locked" alt="<%=String.valueOf(i)%>" readonly="true" onchange="return changed(this.alt);" /></td>         
                                       <td ><html:text property="txtSavCode" name="intInfo" size="5"    styleClass="required" alt="<%=String.valueOf(i)%>" readonly="true" onchange="
                                       if (!num_Check(this.value,1))
                                       {
                                          this.focus();
                                          return false;
                                       }                                      
                                        else
                                          return changed(this.alt);
                                        " />
                                        
                                        <logic:equal name="intInfo" property="status" value="N">                                        
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode" onclick="ShowDetSavCode(this.alt);" >                                       
                                        </logic:equal>                                      
                                       
                                        <logic:equal name="intInfo" property="status" value="Q">                                        
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode"  disabled onclick="ShowDetSavCode(this.alt);" >                                       
                                        </logic:equal>                                      
                                       
                                        <logic:equal name="intInfo" property="status" value="U">                                        
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode"   onclick="ShowDetSavCode(this.alt);" >                                       
                                        </logic:equal>
                                       </td>

                                       <td ><html:text property="txtDescription" name="intInfo" size="19"   styleClass="locked" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" readonly="true" /></td>         
                                       <td ><html:text property="txtSavingsNumber" name="intInfo" size="8"    styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>         
                                       
                                        <td class=tabletext ><html:text property="txtSavingsDate" alt="<%=String.valueOf(i)%>" 
                                        name="intInfo" size="10"  onchange="return changed(this.alt)"
                                        styleClass="required" />   </td>  
                                       <td ><html:text property="txtValUpto" name="intInfo" size="5"    styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="if(chk_YearMonth(this.alt)) changed(this.alt);" /></td>         
                                      
                                    
                                     
 
                                       <!-- <img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" property="butTxtSavingsDate" 
                                        alt="<%=(i-1) %>" onclick="showCalendar('txtSavingsDate',this)"  >-->
                                         


                                         <td ><html:text property="txtAmount" name="intInfo" size="8"    styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                         if (!num_Check(this.value,1)) 
                                         {
                                              this.focus();
                                              return false;
                                        }
                                        if(!chk_Amount(this.alt))
                                        {
                                              this.focus();
                                              return false;
                                        }
                                        changed(this.alt);                                    
                                         "  /></td> 
                                         
                                         
                                   <!--Added by sonia on 09-02-2011-->      
                                        
                                       
									 
									  <html:hidden property="txtAgency" name="intInfo" alt="<%=String.valueOf(i)%>"/> 
                                      <td ><html:text property="txtAgencyNo" name="intInfo" size="5"  readonly="true"  styleClass="optional" style="width:70%" alt="<%=String.valueOf(i)%>"  />

                                       <logic:equal name="intInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  onclick="ShowLovAgencyCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="intInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  disabled onclick="ShowLovAgencyCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="intInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  disabled  onclick="ShowLovAgencyCode(this.alt);" >
                                       </logic:equal>
                                       </td>

                                       <td ><html:text property="txtAgencyName" name="intInfo" styleClass="optional" size="6" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return agChanged(this.alt);" readonly="true"  /></td>

                                       <html:hidden property="txtAgencySiteCode"  name="intInfo" alt="<%=String.valueOf(i)%>" />

                                       <td ><html:text property="txtAgencySite" name="intInfo" size="5"  readonly="true"  styleClass="optional" style="width:70%" alt="<%=String.valueOf(i)%>"  />
										          
                                       <logic:equal name="intInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  onclick="ShowLovAgencySiteCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="intInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled  onclick="ShowLovAgencySiteCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="intInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode" disabled  onclick="ShowLovAgencySiteCode(this.alt);" >
                                       </logic:equal>
                                       </td>
                                      
                                       <html:hidden property="hdnSavCodeSrlNo" name="intInfo" />
                                       <html:hidden property="txtLastYYMM" name="intInfo" />
                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo" value="Default"/>
                                       <html:hidden property="txtUpdatedSite"  name="intInfo" />             
									   <html:hidden property="txtCreationDate" name="intInfo" />
                                       <html:hidden property="txtCreatedBy"    name="intInfo" />
                                       <html:hidden property="txtCreatedSite"  name="intInfo" />
                                       <html:hidden property="txtUpdationDate" name="intInfo" />
                                       <html:hidden property="txtUpdatedBy"    name="intInfo" />
									   <!--ended by varalika -->
                                    </tr>
</logic:notEqual>
                            
                            
                            
<logic:equal name="intInfo" property="status" value="Q" >
                                      <% ++j; %>                                      
                                      <td ><html:text property="txtSrlNo" name="intInfo" size="1"  value="<%=String.valueOf(j)%>"  styleClass="locked" style="width:93%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>         

                                        <td ><html:text property="txtEmpNo" name="intInfo" styleClass="locked" size="8"  alt="<%=String.valueOf(i)%>" readonly="true" onchange="
                                        if (!num_Check(this.value,1)) 
                                        { 
                                          this.focus();
                                          return false;
                                        }                                      
                                        else
                                          return changed(this.alt);
                                        "  />
                                        <logic:equal name="intInfo" property="status" value="N">                                       
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  onclick="ShowDetEmpNum(this.alt);" >
                                        </logic:equal>                                      
                                      
                                       <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowDetEmpNum(this.alt);" >                                     
                                      </logic:equal>                                      
                                       
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"   onclick="ShowDetEmpNum(this.alt);" >                                       
                                      </logic:equal>
                                       
                                      </td>
 
                                       <td ><html:text property="txtEmpName" name="intInfo" size="20"    styleClass="locked" alt="<%=String.valueOf(i)%>" readonly="true" onchange="return changed(this.alt);" /></td>         
                                       <td ><html:text property="txtSavCode" name="intInfo" size="5"    styleClass="locked" alt="<%=String.valueOf(i)%>" readonly="true" onchange="
                                       if (!num_Check(this.value,1))
                                       {
                                          this.focus();
                                          return false;
                                       }                                      
                                        else
                                          return changed(this.alt);
                                        " />
                                        
                                        <logic:equal name="intInfo" property="status" value="N">                                        
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode" onclick="ShowDetSavCode(this.alt);" >                                       
                                        </logic:equal>                                      
                                       
                                        <logic:equal name="intInfo" property="status" value="Q">                                        
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode"  disabled onclick="ShowDetSavCode(this.alt);" >                                       
                                        </logic:equal>                                      
                                       
                                        <logic:equal name="intInfo" property="status" value="U">                                        
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode"   onclick="ShowDetSavCode(this.alt);" >                                       
                                        </logic:equal>
                                       </td>

                                       <td ><html:text property="txtDescription" name="intInfo" size="19"   styleClass="locked" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" readonly="true" /></td>         
                                       <td ><html:text property="txtSavingsNumber" name="intInfo" size="8"    styleClass="locked" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" readonly="true" /></td>         
                                       
                                       <td class=tabletext ><html:text property="txtSavingsDate" alt="<%=String.valueOf(i)%>" 
                                        name="intInfo" size="10"  onchange="return changed(this.alt)"
                                        styleClass="locked" readonly="true" /> </td>
                                       
                                       <td class=tabletext ><html:text property="txtValUpto" name="intInfo" size="5"    styleClass="locked" readonly="true" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="if(chk_YearMonth(this.alt)) changed(this.alt);" /></td>         
                                      
                                    
                                       
 
                                        <!--<img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" property="butTxtSavingsDate" 
                                        alt="<%=(i-1) %>" onclick="showCalendar('txtSavingsDate',this)"  >  -->     


                                         <td ><html:text property="txtAmount" name="intInfo" size="8"    styleClass="locked"  readonly="true"style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                         if (!num_Check(this.value,1)) 
                                        {
                                              this.focus();
                                              return false;
                                        }
                                        if(!chk_Amount(this.alt))
                                        {
                                              this.focus();
                                              return false;
                                        }
                                        changed(this.alt);                                    
                                         "  /></td> 
                                         
                                         
                                   <!--Added by sonia on 09-02-2011-->      
                                        <html:hidden property="txtAgency" name="intInfo" alt="<%=String.valueOf(i)%>"/>
									   <td ><html:text property="txtAgencyNo" name="intInfo" size="5"  readonly="true"  styleClass="locked" style="width:70%" alt="<%=String.valueOf(i)%>"  />

                                       <logic:equal name="intInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  disabled onclick="ShowLovAgencyCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="intInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  disabled onclick="ShowLovAgencyCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="intInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  disabled  onclick="ShowLovAgencyCode(this.alt);" >
                                       </logic:equal>
                                       </td>

                                       <td ><html:text property="txtAgencyName" name="intInfo" styleClass="locked" size="6" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return agChanged(this.alt);" readonly="true"  /></td>
                                       
										 <html:hidden property="txtAgencySiteCode" name="intInfo"   alt="<%=String.valueOf(i)%>"/>
									     <td ><html:text property="txtAgencySite" name="intInfo" size="5"  readonly="true"  styleClass="locked" style="width:70%" alt="<%=String.valueOf(i)%>"  />
										
                                       <logic:equal name="intInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovAgencySiteCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="intInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled  onclick="ShowLovAgencySiteCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="intInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode" disabled  onclick="ShowLovAgencySiteCode(this.alt);" >
                                       </logic:equal>
                                       </td>
 
                                       
                                       <html:hidden property="hdnSavCodeSrlNo" name="intInfo" />
                                       <html:hidden property="txtLastYYMM" name="intInfo" />
                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo" value="Default"/>
 									   <html:hidden property="txtUpdatedSite"  name="intInfo" />             
									   <html:hidden property="txtCreationDate" name="intInfo" />
                                       <html:hidden property="txtCreatedBy"    name="intInfo" />
                                       <html:hidden property="txtCreatedSite"  name="intInfo" />
                                       <html:hidden property="txtUpdationDate" name="intInfo" />
                                       <html:hidden property="txtUpdatedBy"    name="intInfo" />
										

                                       
                                          
									  
</logic:equal>
</tr>
                                  </logic:notEqual>

                                  <logic:equal name="intInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintainInternalSavings" value="notchecked" /></td>
                                       <td ><html:hidden property="txtSrlNo" name="intInfo" /></td>
                                       <td ><html:hidden property="txtEmpNo" name="intInfo" /></td>
                                       <td ><html:hidden property="txtEmpName" name="intInfo" /></td>
                                       <td ><html:hidden property="txtSavCode" name="intInfo" /></td>
                                       <td ><html:hidden property="txtDescription" name="intInfo" /></td>
                                      <td ><html:hidden property="txtSavingsNumber" name="intInfo" /></td>
                                       <td ><html:hidden property="txtValUpto" name="intInfo" /></td>
                                       <!--added by sonia 0n 09-02-2011-->
                                       <td ><html:hidden property="txtAgency" name="intInfo" /></td>
                                       <td ><html:hidden property="txtAgencyNo" name="intInfo" /></td>
                                       <td ><html:hidden property="txtAgencyName" name="intInfo" /></td>                                       
                                       <td ><html:hidden property="txtAgencySite" name="intInfo" /></td>
                                       <td ><html:hidden property="txtAgencySiteCode" name="intInfo" /></td>
                                        <!--end added by sonia 0n 09-02-2011-->
                                       <td ><html:hidden property="txtSavingsDate" name="intInfo" /></td>
                                       <td ><html:hidden property="txtAmount" name="intInfo" /></td>

										<!--Added by Varalika on 30-Sep-2011-->     
									    <td ><html:hidden property="txtUpdatedSite"  name="intInfo" /></td >             
									   <td ><html:hidden property="txtCreationDate" name="intInfo" /></td >
                                       <td ><html:hidden property="txtCreatedBy"    name="intInfo" /></td >
                                       <td ><html:hidden property="txtCreatedSite"  name="intInfo" /></td >
                                       <td ><html:hidden property="txtUpdationDate" name="intInfo" /></td >
                                       <td ><html:hidden property="txtUpdatedBy"    name="intInfo" /></td >
									   <!--ended by varalika -->

                                       <html:hidden property="hdnSavCodeSrlNo" name="intInfo" />
                                       <html:hidden property="txtLastYYMM" name="intInfo" />
                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo" value="Default" />
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
								<!-- changed GenDetailMenu by varalika on 30-Sep-2011 -->
                              </td>
                            </TR>
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
        <!--<td  bgcolor=#4682b4><html:button value='Approve'  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Reject '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Revise '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /></td>  -->
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
<html:hidden property="headerPrimaryKey" name="frmMaintainInternalSavings"  />
<html:hidden property="hdnAction" name="frmMaintainInternalSavings"  />
<html:hidden property="hdnRowVal" name="frmMaintainInternalSavings"  />
<html:hidden property="hdnEmpNo" name="frmMaintainInternalSavings"  />
<html:hidden property="hdnEmpName" name="frmMaintainInternalSavings"  />
<html:hidden property="hdnPayCode" name="frmMaintainInternalSavings"  />
<html:hidden property="hdnPayCodeName" name="frmMaintainInternalSavings"  />
<html:hidden property="screenMode" name="frmMaintainInternalSavings"  />
<html:hidden name="frmMaintainInternalSavings"  property="screenName" value="InternalScreen" />
<html:hidden name="frmMaintainInternalSavings"  property="forwardedPage" />
<!--<html:hidden name="frmMaintainInternalSavings"  property="headerFields" />-->
<!--<html:hidden name="frmMaintainInternalSavings"  property="totalDetailRecord" />-->
<html:hidden property="screenInt" name="frmMaintainInternalSavings"  />
<html:hidden property="lovKey" name="frmMaintainInternalSavings"  />
<html:hidden property="txtFields" name="frmMaintainInternalSavings"  />   
<html:hidden property="txtSearchFields" name="frmMaintainInternalSavings"  />
<html:hidden property="txtDisplayFields" name="frmMaintainInternalSavings"  />
<html:hidden property="txtIndex" name="frmMaintainInternalSavings"  />
<html:hidden property="txtInputField" name="frmMaintainInternalSavings"  /><!--added by sonia on 09-02-2011-->
<html:hidden property="buttonFlag" name="frmMaintainInternalSavings"  />
<html:hidden property="userPageRequested" name="frmMaintainInternalSavings" />
<html:hidden property="pageRequested" name="frmMaintainInternalSavings" />
<html:hidden property="loginLocCode" name="frmMaintainInternalSavings" />
 <!--start added by sonia 0n 09-02-2011-->
<html:hidden property="txtAgency" name="frmMaintainInternalSavings"  />
<html:hidden property="txtAgencyNo" name="frmMaintainInternalSavings"  />
<html:hidden property="txtAgencyName" name="frmMaintainInternalSavings"  />
<html:hidden property="txtAgencySite" name="frmMaintainInternalSavings"  />
<html:hidden property="txtAgencySiteCode" name="frmMaintainInternalSavings"  />
 <!--end added by sonia 0n 09-02-2011-->

 <!--Added by Varalika on 30-Sep-2011-->     
<html:hidden property="txtUpdatedSite"  name="frmMaintainInternalSavings" />             
<html:hidden property="txtCreationDate" name="frmMaintainInternalSavings" />
<html:hidden property="txtCreatedBy"    name="frmMaintainInternalSavings" />
<html:hidden property="txtCreatedSite"  name="frmMaintainInternalSavings" />
<html:hidden property="txtUpdationDate" name="frmMaintainInternalSavings" />
<html:hidden property="txtUpdatedBy"    name="frmMaintainInternalSavings" />
<!--ended by varalika -->

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>        

<script language="javascript">

function ShowEmpNum()
{
    frmMaintainInternalSavings.lovKey.value = "IntSav" + frmMaintainInternalSavings.screenName.value + frmMaintainInternalSavings.screenMode.value;
    frmMaintainInternalSavings.txtDisplayFields.value = "txtEmpNo1,txtEmpName1";
    frmMaintainInternalSavings.queryParam.value = "txtSiteID="+frmMaintainInternalSavings.loginLocCode.value+",hdnEmpLbrFlag="+frmMaintainInternalSavings.hdnEmpLbrFlag.value;
    frmMaintainInternalSavings.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";   
    frmMaintainInternalSavings.txtIndex.value ="";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainInternalSavings');
    return true;
}

function ShowSavCode()
{
    frmMaintainInternalSavings.lovKey.value = "IntSavCode" + frmMaintainInternalSavings.screenName.value + frmMaintainInternalSavings.screenMode.value;
    frmMaintainInternalSavings.queryParam.value = "screenName="+frmMaintainInternalSavings.screenName.value+",txtSiteID="+frmMaintainInternalSavings.loginLocCode.value+",screenMode="+frmMaintainInternalSavings.screenMode.value+",hdnEmpLbrFlag="+frmMaintainInternalSavings.hdnEmpLbrFlag.value;   // added by swapnendu Dt 07 Sep 2012.
    frmMaintainInternalSavings.txtDisplayFields.value = "txtSavCode1,txtSavCodeName";
    frmMaintainInternalSavings.txtSearchFields.value = "Payroll.MaintIntSavings.code,Payroll.MaintIntSavings.desc";      <!--// added by dushyant on 16-09-2010 for desc -->
    frmMaintainInternalSavings.txtIndex.value ="";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainInternalSavings');
    return true;
}

function ShowDetEmpNum(i)
{
    if(!(document.all.radioEmp.checked) || (document.all.radioSave.checked))
    {
        frmMaintainInternalSavings.lovKey.value = "IntSav" + frmMaintainInternalSavings.screenName.value + frmMaintainInternalSavings.screenMode.value;
        frmMaintainInternalSavings.txtDisplayFields.value = "txtEmpNo,txtEmpName";
        frmMaintainInternalSavings.queryParam.value = "txtSiteID="+frmMaintainInternalSavings.loginLocCode.value+",hdnEmpLbrFlag="+frmMaintainInternalSavings.hdnEmpLbrFlag.value;
        frmMaintainInternalSavings.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";   
        frmMaintainInternalSavings.txtIndex.value =i;      
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainInternalSavings');
        return true;
    }
    else
   {
       return false;
   }
}

function ShowDetSavCode(i)
{   
   if(!(document.all.radioSave.checked) || (document.all.radioEmp.checked))
   {
       frmMaintainInternalSavings.lovKey.value = "IntSavCode" + frmMaintainInternalSavings.screenName.value + frmMaintainInternalSavings.screenMode.value;
       frmMaintainInternalSavings.queryParam.value = "screenName="+frmMaintainInternalSavings.screenName.value+",txtSiteID="+frmMaintainInternalSavings.loginLocCode.value+",screenMode="+frmMaintainInternalSavings.screenMode.value+",hdnEmpLbrFlag="+frmMaintainInternalSavings.hdnEmpLbrFlag.value;   // added by swapnendu Dt 07 Sep 2012.
       frmMaintainInternalSavings.txtDisplayFields.value = "txtSavCode,txtDescription";
       frmMaintainInternalSavings.txtSearchFields.value = "Payroll.MaintIntSavings.code,Payroll.MaintIntSavings.desc";
       frmMaintainInternalSavings.txtIndex.value =i;      
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainInternalSavings');
       return true;
   }
   else
   {
       return false;
   }
}

function changed(val)
{
  frmMaintainInternalSavings.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
  
}
    
function doBaseAddRow()
{
	if(!checkSupplierSites()) /////////////////added  by sonia on 10 -03-2011 ////////////////
		return false; /////////////////added  by sonia on 10 -03-2011 ////////////////

	if(!chk_PayCodes()) 
		return false;
    if(mandatory_Check("frmMaintainInternalSavings"))
    {
        document.all.buttonFlag.value='';
        frmMaintainInternalSavings.screenMode.value = "U";  
        document.forms[0].action = "../../../IntSavAddRowAction.do";
        enableAll(); 
        document.forms[0].submit();
    }
    else
    {
        return false;
    }
	
}

function doBaseDelRow()
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
        if(document.getElementsByName("checked")[i].checked)
        {
            document.getElementsByName("itemChecked")[i].value = "Y";
            frmMaintainInternalSavings.detailDataChanged.value = "true";     
            document.all.buttonFlag.value='';
        }    
    }    
    enableAll(); 
    document.forms[0].action = "../../../IntSavDeleteRowAction.do";
    document.forms[0].submit();  
}


// Added by varalika on 19-Apr-2010
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
              { if(!(frmMaintainInternalSavings.txtCreationDate[i].value&&frmMaintainInternalSavings.txtCreatedBy[i].value&&frmMaintainInternalSavings.txtCreatedSite[i].value))
				  {
				  alert("No history exists for the selected record");
				  }
				  else
				  {
				
				  alert("Record History "+"\n"
				  +"Creation Date :  "+ frmMaintainInternalSavings.txtCreationDate[i].value
				  +"\n"
				  +"Created By      :  "+frmMaintainInternalSavings.txtCreatedBy[i].value
				  +"\n"
				  +"Created Site    :  "+frmMaintainInternalSavings.txtCreatedSite[i].value
				  +"\n"
				  +"Updation Date:  "+frmMaintainInternalSavings.txtUpdationDate[i].value
				  +"\n"
				  +"Updated By     :  "+frmMaintainInternalSavings.txtUpdatedBy[i].value
				  +"\n"
				  +"Updated Site   :  "+frmMaintainInternalSavings.txtUpdatedSite[i].value
				  );
				 
				}
              }
              else
              {
              if(!(frmMaintainInternalSavings.txtCreationDate[i].value&&frmMaintainInternalSavings.txtCreatedBy[i].value&&frmMaintainInternalSavings.txtCreatedSite[i].value))
              {
              alert("No history exists for the selected record");
              }
              else
              {
              alert("Record History"+"\n"
              +"Creation Date :  "+ frmMaintainInternalSavings.txtCreationDate[i].value+"\n"
              +"Created By      :  "+frmMaintainInternalSavings.txtCreatedBy[i].value
              +"\n"
              +"Created Site    :  "+frmMaintainInternalSavings.txtCreatedSite[i].value
              +"\n"
              +"Updation Date:  "+frmMaintainInternalSavings.txtUpdationDate[i].value
              +"\n"
              +"Updated By     :  "+frmMaintainInternalSavings.txtUpdatedBy[i].value
              +"\n"
              +"Updated Site   :  "+frmMaintainInternalSavings.txtUpdatedSite[i].value
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
        //  showHistWin('<html:rewrite page="/Payroll/JSP/COMMON/JSP/ShowHistory.jsp" />', 'frmMaintainInternalSavings');
          return true;
      }
    
    if(f2 == 0)
      {
		document.all.butHistory.disabled="";
       return false;
      }
}
//Added By Varalika Ends here

function SaveRecord()
{ 
   if(!checkSupplierSites()) /////////////////added  by sonia on 10 -03-2011 ////////////////
		return false; /////////////////added  by sonia on 10 -03-2011 ////////////////

	 if(!chk_PayCodes())
      return false;
	
    if(mandatory_Check("frmMaintainInternalSavings"))
    {
        enableAll(); 
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;       
        for(i=0; i < iTr2 -1; i++)
        {
            if (document.getElementsByName("status")[i].value == 'D')
                frmMaintainInternalSavings.detailDataChanged.value = "true";
        }    
        document.all.buttonFlag.value='';
        frmMaintainInternalSavings.headerFields.value = "false";
        document.all.butSave.disabled="true";        
        if(document.frmMaintainInternalSavings.optVal.value == "2") 
        {
            if (document.all.screenMode.value == "N")
            {
                document.all.screenInt.value = "UG";
                document.all.screenMode.value = "U";    
            }
        }  
        document.all.butSave.disabled="true";        
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmMaintainInternalSavings.action = "../../../IntSavSaveAction.do";
        frmMaintainInternalSavings.submit();
    }
    else
    {
        return false;
    }
}


function GetDetail()
{
    document.all.screenInt.value = 'UG';
    document.all.buttonFlag.value='';
    
    frmMaintainInternalSavings.screenMode.value='U';
    frmMaintainInternalSavings.headerDataChanged.value = "false";
    
    if(!mandatory_Check("frmMaintainInternalSavings"))
        return false;    
    
    if(document.frmMaintainInternalSavings.optVal.value == "1") 
        frmMaintainInternalSavings.headerPrimaryKey.value = frmMaintainInternalSavings.txtSavCode1.value ;  
    
    if(document.frmMaintainInternalSavings.optVal.value == "2")  
        frmMaintainInternalSavings.headerPrimaryKey.value = frmMaintainInternalSavings.txtEmpNo1.value ;  
    else 
        frmMaintainInternalSavings.headerPrimaryKey.value = "";      
    
    frmMaintainInternalSavings.action="../../../IntSavGetDetailAction.do"
    frmMaintainInternalSavings.submit();
}

function SavCodeClick()
{
    document.frmMaintainInternalSavings.hdnAction.value = "";
    if(document.all.screenInt.value == 'UG')
        document.all.screenInt.value = 'U';
    document.all.buttonFlag.value='';
    document.frmMaintainInternalSavings.action="../../../IntSavOptionClickAction.do";
    document.frmMaintainInternalSavings.optVal.value="1";     
    document.frmMaintainInternalSavings.submit();
}

function EmpNoClick() 
{
    document.frmMaintainInternalSavings.hdnAction.value = "";
    if(document.all.screenInt.value == 'UG')
        document.all.screenInt.value = 'U';
    document.all.buttonFlag.value='';
    document.frmMaintainInternalSavings.action="../../../IntSavOptionClickAction.do";
    document.frmMaintainInternalSavings.optVal.value="2";
    document.frmMaintainInternalSavings.submit(); 
}
  
function MiscelClick() 
{
    document.frmMaintainInternalSavings.hdnAction.value = "";
    if(document.all.screenInt.value == 'UG')
        document.all.screenInt.value = 'U';      
    document.all.buttonFlag.value='';
    document.frmMaintainInternalSavings.action="../../../IntSavOptionClickAction.do";
    document.frmMaintainInternalSavings.optVal.value="3";        
    document.frmMaintainInternalSavings.submit(); 
}

function doInsertMode()
{
    document.frmMaintainInternalSavings.hdnAction.value = "";
    document.all.screenInt.value = 'N';
    document.all.buttonFlag.value='';
    frmMaintainInternalSavings.headerDataChanged.value = "false";
 
    frmMaintainInternalSavings.action="../../../IntSavNewMode.do"
    frmMaintainInternalSavings.submit();
}

function doQueryMode()
{
    document.frmMaintainInternalSavings.hdnAction.value = "";
    document.all.screenInt.value = 'Q';
    document.all.buttonFlag.value='';
    frmMaintainInternalSavings.headerDataChanged.value = "false";
    
    frmMaintainInternalSavings.action="../../../IntSavQueryMode.do"
    frmMaintainInternalSavings.submit();
}

function chk_Amount(rowval)
{
 /*   var amt = parseInt(document.getElementsByName("txtAmount")[rowval-1].value);
    if(amt>100000)          
    {
        alert(" Monthly Savings Amount Cannot be more than 100000");
        return false;
    }    
    if((amt>10000) && (amt<100000))          
    {
        var Val =confirm("Entered Amount Is Greater Than 10000. Do You Want To Continue?")
        if (!Val)
        return false;
        else                                                   
        return true;                        
    }        
    */
    return true;
}

function lfnLoad()
{
    mode = document.all.screenMode.value;
    //alert("mode------"+mode); 
 
    if(mode=='')
    {
        doQueryMode();
    }    
    if (document.all.screenInt.value == "")
    {
        document.all.screenInt.value = "Q";
        document.all.screenMode.value = "Q";    
    }    
    mode = document.all.screenInt.value;    
    if(mode=='')
    {
        document.all.butGetDetail.disabled="";   
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";
    }
    if(mode=='Q')
    {
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";     
    }
    if(mode=='U')
    {
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";        
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
    }
    if(mode=='N')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";      
    }
    if(mode=='UG')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";
    }
    if(document.frmMaintainInternalSavings.hdnAction.value == "GetEmpNameDtl")
    {
        var iRowVal = document.frmMaintainInternalSavings.hdnRowVal.value;       
        if (document.frmMaintainInternalSavings.hdnEmpName.value != "") 
        {
            document.getElementsByName("txtEmpName")[iRowVal-1].value = document.frmMaintainInternalSavings.hdnEmpName.value; 
            document.frmMaintainInternalSavings.hdnAction.value = "";
            document.getElementsByName("txtSavCode")[iRowVal-1].focus();      
        }
        else
        {
            alert("Invalid Employee Number"); 
            document.getElementsByName("txtEmpName")[iRowVal-1].value = "";                     
            document.getElementsByName("txtEmpNo")[iRowVal-1].focus();                
        }
    }

    if(document.frmMaintainInternalSavings.hdnAction.value == "GetEmpName")
    {
        if (document.frmMaintainInternalSavings.txtEmpName1.value == "")   
        {
            alert("Invalid Employee Number"); 
            document.frmMaintainInternalSavings.txtEmpNo1.focus(); 
        }
    }  
  
    if(document.frmMaintainInternalSavings.hdnAction.value == "GetPayCodeName")
    {
        if (document.frmMaintainInternalSavings.txtSavCodeName.value == "")   
        {
            alert("Invalid Savings Code"); 
            document.frmMaintainInternalSavings.txtSavCode1.focus(); 
        }
    }    

    if(document.frmMaintainInternalSavings.hdnAction.value == "GetPayCodeNameDtl")
    {
        var iRowVal = document.frmMaintainInternalSavings.hdnRowVal.value;   
        if (document.frmMaintainInternalSavings.hdnPayCodeName.value != "") 
        {  
            var iRowVal = document.frmMaintainInternalSavings.hdnRowVal.value; 
            document.getElementsByName("txtDescription")[iRowVal-1].value = document.frmMaintainInternalSavings.hdnPayCodeName.value; 
            document.frmMaintainInternalSavings.hdnAction.value = "";
            document.getElementsByName("txtSavingsNumber")[iRowVal-1].focus();            
        }
        else
        {
            alert("Invalid Savings Code"); 
            document.getElementsByName("txtDescription")[iRowVal-1].value = "";                               
            document.getElementsByName("txtSavCode")[iRowVal-1].focus();                
        }      
    }
    
    if(mode == 'UG' || mode == 'UNG')
    {  menuHandling('U');}
    else
    {  menuHandling(mode);}
    
    document.all.butExecute.disabled="true";    
    document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg"; 
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
    
    if((document.frmMaintainInternalSavings.optVal.value == '')||(document.frmMaintainInternalSavings.optVal.value == '1'))
    {
        document.all.radioSave.checked="true";
        if(document.frmMaintainInternalSavings.optVal.value == '')
        SavCodeClick();
    }
    else if(document.frmMaintainInternalSavings.optVal.value == '2')
    {
        document.all.radioEmp.checked="true";
        return true;
    }
    else if(document.frmMaintainInternalSavings.optVal.value == '3')
    {
        document.all.radioMisc.checked="true";
        return true;
    }
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
            document.getElementsByName("txtSavCode")[i].disabled="disabled";
            document.getElementsByName("txtEmpNo")[i].disabled="disabled";            
        }
    }

	     //added by sonia on 19-10-2010/////////
  <%ArrayList payCodesList=(ArrayList)request.getSession().getAttribute("payCodesList");
	if(payCodesList==null)
	{%>
		//alert("Supplier");
       chk_Supplier();
	<%}%>
   //added by sonia on 19-10-2010/////////
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
            document.getElementsByName("txtSavCode")[i].disabled="";
            document.getElementsByName("txtEmpNo")[i].disabled="";
        }
    }
}

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
        document.getElementsByName("txtSavCode")[i].disabled="";
        document.getElementsByName("txtEmpNo")[i].disabled="";
    }
}

function showCalendar(inputId, butId) 
{
   if(butId.alt)
   {
       iIndex=butId.alt;
   }
   else
   {
       iIndex="-1";
   }
   Calendar.setup({inputField	: inputId,
		   ifFormat	: "%d-%b-%Y",
		   button	: butId,
       position: iIndex
  		  });
   return false;
}

function chk_YearMonth(val)
{      
    var  yearM = document.getElementsByName("txtValUpto")[val-1].value;          
    var month =  parseInt(yearM.substring(4,6),10);
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementsByName("txtValUpto")[val-1].focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementsByName("txtValUpto")[val-1].focus();                     
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

function doRefresh()
{
    document.frmMaintainInternalSavings.hdnAction.value = "";
    frmMaintainInternalSavings.action="../../../InternalRefresh.do"
    frmMaintainInternalSavings.submit();
}

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';  
    frmMaintainInternalSavings.userPageRequested.value = 1*frmMaintainInternalSavings.pageRequested.value - 1;
    frmMaintainInternalSavings.action = "../../../IntSavNextDetailAction.do";
    frmMaintainInternalSavings.submit();
}

function doBaseNextDetail()
{
    document.all.buttonFlag.value='';  
    frmMaintainInternalSavings.userPageRequested.value = 1*frmMaintainInternalSavings.pageRequested.value + 1;
    frmMaintainInternalSavings.action = "../../../IntSavNextDetailAction.do";
    frmMaintainInternalSavings.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';  
    frmMaintainInternalSavings.userPageRequested.value = 1*frmMaintainInternalSavings.newPageRequested.value ;
    frmMaintainInternalSavings.action = "../../../IntSavNextDetailAction.do";
    frmMaintainInternalSavings.submit();
}

function lfnGetEmpName(val) 
{
    if (val != "")
    {
        frmMaintainInternalSavings.hdnAction.value="GetEmpName";
        frmMaintainInternalSavings.action="../../../IntSavGetEmpName.do"     
        frmMaintainInternalSavings.submit();
    }
}

function lfnGetEmpNameDtl(val, value) 
{
    if (value != "")
    {
        if(frmMaintainInternalSavings.screenInt.value="N") 
        {
            frmMaintainInternalSavings.hdnAction.value="GetEmpNameDtl";
            frmMaintainInternalSavings.hdnRowVal.value=val;
            frmMaintainInternalSavings.hdnEmpNo.value=value;     
            frmMaintainInternalSavings.action="../../../IntSavGetEmpName.do"     
            frmMaintainInternalSavings.submit();
        }
    }
}

function lfnGetPayCodeName(val) 
{
    if (val != "")
    {
         frmMaintainInternalSavings.hdnAction.value="GetPayCodeName";
         frmMaintainInternalSavings.action="../../../IntSavGetEmpName.do"     
         frmMaintainInternalSavings.submit();
    }
}

function lfnGetPayCodeNameDtl(val, value) 
{
    if (value != "")
    {
        if(frmMaintainInternalSavings.screenInt.value="N") 
        {
           frmMaintainInternalSavings.hdnAction.value="GetPayCodeNameDtl";
           frmMaintainInternalSavings.hdnRowVal.value=val;
           frmMaintainInternalSavings.hdnPayCode.value=value;     
           frmMaintainInternalSavings.action="../../../IntSavGetEmpName.do"     
           frmMaintainInternalSavings.submit();
        }
   }
}

//start added by Sonia on 09-02-2011
function ShowLovAgencyCode(i)
{
if((document.getElementsByName("txtEmpNo")[i].value)=="")
{
 alert('please select employee number first.');
 return false;
 
}
     frmMaintainInternalSavings.lovKey.value = "MaintDirectPayrollAgencyCode" + frmMaintainInternalSavings.screenName.value +"N";
     frmMaintainInternalSavings.txtDisplayFields.value = "txtAgency,txtAgencyName,txtAgencyNo";
     frmMaintainInternalSavings.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Agency,Payroll.Common.Desc,Payroll.Common.SupNo"; 
     frmMaintainInternalSavings.queryParam.value="txtSiteID="+frmMaintainInternalSavings.loginLocCode.value+",txtEmpNo="+document.getElementsByName("txtEmpNo")[i].value+",txtPayCode="+document.getElementsByName("txtSavCode")[i].value;
     frmMaintainInternalSavings.txtIndex.value=i;  
     frmMaintainInternalSavings.txtInputField.value ="";  
    
     if(!(document.getElementsByName("status")[i].value == "N"))
     document.getElementsByName("status")[i].value = "U";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainInternalSavings');
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
     frmMaintainInternalSavings.lovKey.value = "MaintDirectPayrollAgencySiteCode" + frmMaintainInternalSavings.screenName.value + "N";
     frmMaintainInternalSavings.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySite";   
 /*  frmMaintainInternalSavings.queryParam.value = "txtAgency="+document.all.txtAgency.value;*/
     frmMaintainInternalSavings.queryParam.value = "txtSiteID="+frmMaintainInternalSavings.loginLocCode.value+",txtAgency="+document.getElementsByName("txtAgency")[i].value;

     frmMaintainInternalSavings.txtSearchFields.value = "";
    frmMaintainInternalSavings.txtIndex.value=i;  
    frmMaintainInternalSavings.txtInputField.value="";
     if(!(document.getElementsByName("status")[i].value == "N"))
     document.getElementsByName("status")[i].value = "U";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainInternalSavings');
     return true;
}

function ShowLovAgencySiteCode(i)
{

   if(document.getElementsByName("txtAgency")[i].value=="")
   {
      alert("Please select Agency Code first!!!");
      return false;
   }
   frmMaintainInternalSavings.lovKey.value = "MaintDirectPayrollAgencySiteCode" + frmMaintainInternalSavings.screenName.value + "N";  
   frmMaintainInternalSavings.txtDisplayFields.value = "txtAgencySiteCode,txtAgencySite";   
   frmMaintainInternalSavings.queryParam.value = "txtSiteID="+frmMaintainInternalSavings.loginLocCode.value+",txtAgency="+document.getElementsByName("txtAgency")[i].value;  
   frmMaintainInternalSavings.txtSearchFields.value = "";
   frmMaintainInternalSavings.txtIndex.value=i;  
   frmMaintainInternalSavings.txtInputField.value ="";  
   
 
   if(!(document.getElementsByName("status")[i].value == "N"))
   document.getElementsByName("status")[i].value = "U";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainInternalSavings');
   return true;
}

function chk_Supplier()
{	

	frmMaintainInternalSavings.action = "../../../CheckPayIntSavCodeSaveAction.do";
	frmMaintainInternalSavings.submit();
}  

function chk_PayCodes(){
var flag = 0;
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
var paycode=document.getElementsByName("txtSavCode")[i].value;   
   //alert(paycode);
   //alert("ArraySize" +payCodeListArr.length);
   for(var m=0;m<payCodeListArr.length;m++)
		{

//alert("paycode-----" +paycode);
		if(paycode == payCodeListArr[m])
			{
			

	//alert("status" +document.getElementsByName("status")[i].value)		
			if((document.getElementsByName("status")[i].value == "U" || document.getElementsByName("status")[i].value == "N") && document.getElementsByName("txtSavingsNumber")[i].value == "")
				  {

								
								document.getElementsByName("txtSavingsNumber")[i].style.className="required";
								document.getElementsByName("txtSavingsNumber")[i].style.background="#ffffd3";
								alert("Mandatory Field is empty!!!");
								
								flag=flag+1;
								return false;
				  }
//return true;
			}
		}
  }
 if(flag > 0){			
			//alert("flag" +flag)
			return false;
			}			
			return true;

}

// end added by Sonia on 09-02-2011//


<!--// start added by sonia on 10-03-2011 -->
function checkSupplierSites(){

	if(!checkRecoveryDate()) /////////////////added  by sonia on 10 -03-2011 ////////////////
		return false; /////////////////added  by sonia on 10 -03-2011 ////////////////

//checkRecoveryDate();
var flag = 0;
var oTable = document.getElementById("Detail");
var iTr2 = oTable.rows.length;
//alert(iTr2);
var i = 0;  
  for(i=0; i < iTr2 -1 ; i++)
  {
  	if((document.getElementsByName("txtAgencyNo")[i].value != "" &&  document.getElementsByName("txtAgencySite")[i].value == "") ||  (document.getElementsByName("txtAgencyNo")[i].value == ""  &&  document.getElementsByName("txtAgencySite")[i].value != "" )){	
              if(document.getElementsByName("status")[i].value == "U" || document.getElementsByName("status")[i].value == "N"){
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

function checkRecoveryDate(){
var flag = 0;
var oTable = document.getElementById("Detail");
var iTr2 = oTable.rows.length;
//alert(iTr2);
var today=new Date();
//alert(today.getFullYear()+"0"+today.getMonth());
var curDate=today.getFullYear()+"0"+today.getMonth();
var i = 0;  
  //for(i=0; i < iTr2 -1 ; i++)
  //{
 // var recoveryDate=document.getElementsByName("txtSavingsDate")[i].value; 
 //   if((document.getElementsByName("status")[i].value == "U" || document.getElementsByName("status")[i].value == "N") //&& document.getElementsByName("txtSavingsDate")[i].value != ""){
          //if(recoveryDate<curDate){
          //alert("Recovery Start Date cannot be lesser than Current YYYYMM!!!");     
          //  flag=flag+1;
          //  return false;
         //}
   // }
  //}
  

for(i=0; i < iTr2 -1 ; i++)
  {
   var validDate=document.getElementsByName("txtValUpto")[i].value; 
   var recoveryDate=document.getElementsByName("txtSavingsDate")[i].value; 
    if((document.getElementsByName("status")[i].value == "U" || document.getElementsByName("status")[i].value == "N")
    && document.getElementsByName("txtValUpto")[i].value != ""){
          
          if(validDate<recoveryDate){
          alert("Valid Upto Date cannot be lesser than Recovery Start YYYYMM!!!");
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



</script>