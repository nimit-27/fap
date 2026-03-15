<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

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
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintEmpCPFSearchBase" name="frmEmpCPFSearchForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpCPFSearchForm">
<bean:define id="ParentForm" name="frmEmpCPFSearchForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE INFORMATION</TD>
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
                  <td align="left" >                  
				  <logic:equal property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <!--img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();"-->
	                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23"  />                  
				  </logic:equal>
				  <logic:notEqual property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
	                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" />                  
				  </logic:notEqual>
                  </td>  
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.StaffCode" /> </td>
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">                              
                  <html:text  property="txtStaffCode" altKey="Payroll.EmpInfo.StaffCode" maxlength="10" size="23" styleClass="locked" />                 
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">                              
                  <html:text  property="txtStaffCode" altKey="pay.MaintainAnnualIncome.StaffCode" maxlength="10" size="23" styleClass="locked" readonly="true" />                 
                  </logic:notEqual>
                  </td>
                  
                  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.prefix" /></td>
                  <td ><html:text  property="prefix" altKey="Payroll.EmpInfo.prefix" maxlength="10" size="23" styleClass="locked" readonly="true" />                  
                  </td>
              </TR> 
            
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.FirstName" /> </td>
                  <td>
                  <logic:equal property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <html:text  property="txtEmpFirstName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="optional" readonly="" />                                                                    
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <html:text  property="txtEmpFirstName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="locked" readonly="true" />
                  </logic:notEqual>
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.MiddleName" /> </td>                  
                  <td>                     
                  <html:text  property="txtEmpMiddleName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="locked" readonly="true" />                                   
                  </td>
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.LastName" /> </td>
                  <td> 
                  <logic:equal property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <html:text property="txtEmpLastName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="optional" readonly="" />                                  
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <html:text property="txtEmpLastName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="locked" readonly="true" />                                  
                  </logic:notEqual>
                  </td>          
              </tr>
              
              <TR>              
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <logic:equal property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <html:text  property="txtDsgnDesc" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="" styleClass="optional" readonly="true" />                   
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" onclick="return ShowLovDsgn();">
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <html:text  property="txtDsgnDesc" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="" styleClass="locked" readonly="true" />                   
                  </logic:notEqual>
                  <html:hidden  property="txtDsgn" altKey="Payroll.EmpInfo.txtDesig"  />
                  </td>
                  
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /></TD>
                  <td align="left">                                    
                  <html:text property="txtCateg" name="frmEmpCPFSearchForm" titleKey="Payroll.EmpInfo.lstCateg" styleClass="locked" size="23" />                  
                  </td> 
                                    
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.txtCadre" /> </td>   
                  <logic:equal property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <td ><html:select property="txtCadre" name="frmEmpCPFSearchForm"  styleClass="optional" alt="<%=String.valueOf(i)%>"  style="WIDTH: 80%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="CPFSearch">
                  <html:optionsCollection label="label" value="value" property="valueCadreArrayList" name="CPFSearch"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <td ><html:select property="txtCadre" name="frmEmpCPFSearchForm"  styleClass="locked" disabled="true" style="WIDTH: 80%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="CPFSearch">
                  <html:optionsCollection label="label" value="value" property="valueCadreArrayList" name="CPFSearch"/>
                  </logic:present>
                  </html:select> 
                  </logic:notEqual>
                  </td>
              </tr>
              
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Section" /> </td>
                  <td>                                    
                  <html:text  property="txtSectionDesc" maxlength="20" size="23" titleKey="Payroll.EmpInfo.Section" styleClass="locked" readonly="true" />                  
                  
                  </td> 
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <logic:equal property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="optional" readonly="true" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpType"  onclick="return ShowLovEmpType();">
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </logic:notEqual>
                  <html:hidden  property="txtEmpTypeId" altKey="Payroll.EmpInfo.Emptype"  />
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.parentZone" /> </td>                            
                  <td>                 
                  <html:text property="parentZone" name="frmEmpCPFSearchForm" titleKey="Payroll.EmpInfo.parentZone" styleClass="locked" onchange=""  size="23" />                  
                  </td>
              </tr>
                      
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.PF" /> </td>                            
                  <td >                  
                  <html:text property="txtPFType" name="frmEmpCPFSearchForm"  titleKey="Payroll.EmpInfo.PF" styleClass="locked" onchange=""  size="23" />                  
                  </td>
                  
                  <td id="cpf" class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /></td>
                  <td id="gpf"  class=labelText  ><bean:message key="Payroll.EmpInfo.GpfCode" /></td>
                  <td>
                  <logic:equal property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="20" size="23" styleClass="optional" style="text-align:right" onchange="checkCPFLength(this.value);" />
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpCPFSearchForm" value="Q">
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="20" size="23" styleClass="locked" style="text-align:right" onchange="" />
                  </logic:notEqual>
                  </td>  
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /></td>                
                  <td>
                  <logic:equal property= "screenMode" name= "frmEmpCPFSearchForm" value="U">                                                
                  <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" readonly="true" styleClass="required" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtPresentPOP" onclick="return ShowLovEmpLoc();">
                  </logic:equal>                                                                                                 
                  <logic:notEqual property= "screenMode" name= "frmEmpCPFSearchForm" value="U">
                  <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" readonly="true" styleClass="optional" />                  
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtPresentPOP" onclick="return ShowLovEmpLoc();">
                  </logic:notEqual>
                  <html:hidden  property="txtPresentPOP" altKey="Payroll.EmpInfo.txtPresentPOP"  />
                  </td>
              </tr>                   
              
              <tr>
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.dojFCI" /> </td>            
                  <td>
                  <html:text  property="txtDojFCI" altKey="Payroll.EmpInfo.dojFCI" titleKey="Payroll.EmpInfo.dojFCI" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked" />                  
                  </td>
                                    
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" titleKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" readonly="true" styleClass="locked" />
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td >                  
                  <html:text property="txtEmpStatus" name="frmEmpCPFSearchForm"  titleKey="Payroll.EmpInfo.EmpStat" styleClass="locked" size="23" />
                  </td>
              </tr>   
              
              <tr>
                  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.depuType" /></td>
                  <td >
                  <html:select  property="txtDepuType" name="frmEmpCPFSearchForm" styleClass = "locked" alt="txtDepuType" style="width:80%" disabled="true" onchange=""  >
                  <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                  <html:option value="I" ><bean:message key="Payroll.EmpInfo.inStation" /></html:option>
                  <html:option value="O" ><bean:message key="Payroll.EmpInfo.outStation" /></html:option>                              
                  <html:option value="N" ><bean:message key="Payroll.EmpInfo.notApplicable" /></html:option>                              
                  </html:select></td>                 
                 
                 <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.ptype" /></td>
                  <td colspan="1" >                  
                  <html:text property="txtPayType" name= "frmEmpCPFSearchForm"  styleClass = "locked" alt="txtPayType" titleKey="Payroll.EmpInfo.ptype" size="23" onchange="" />                  
                  </td> 
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.dob" /> </td>            
                  <td >
                  <html:text  property="txtDOB" maxlength="10" size="23" titleKey="Payroll.EmpInfo.dob" styleClass="locked" readonly="true" />
                  </td>                  
              </tr>
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Retdate" /> </td>            
                  <td>
                  <html:text  property="txtRetireDate"  maxlength="10" size="22" styleClass="locked"  readonly="true"/>
                  </td> 
              
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
            <td bgcolor="#4682B4" nowrap class=actTabText>Pay Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
            <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
              
            <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
            <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
          </TR>
           
          <tr height="10"><td class=userText colspan="17"></td></tr>    
            <TR height=100 >
              <TD colspan="17" >
                <TABLE cellSpacing=0 cellPadding=0 border=0 >
                  <TBODY>
                    <TR>
                      <TD>
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0 border=0>
                          <TBODY>        
                            <TR>                                    
                              <td class=labelText width="15%" id="old" ><bean:message key="Payroll.EmpInfo.pcode" /> </td> 
                              <td class=labelText width="15%" id="new" >Pay Band </td>
                              <td><html:text  property="txtPayScaleCode" name= "frmEmpCPFSearchForm"  altKey="Payroll.EmpInfo.pcode" maxlength="10" size="23" styleClass="locked" onchange="" />                                               
                              </td>    
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.curbas" /></td>
                              <td >                              
                              <html:text  property="txtCurtBasic" name= "frmEmpCPFSearchForm"  altKey="Payroll.EmpInfo.curbas" maxlength="6" size="23" styleClass="locked" onchange=""  style="text-align:right" readonly="true" />
                              </td>                                                                                                                                                      
                              
                              <td width="15%" class=labelText>Grade Pay</td>
                              <td >
                              <html:text  property="txtGradePay" name= "frmEmpCPFSearchForm"  altKey="Payroll.EmpInfo.curbas" maxlength="6" size="23" styleClass="locked" onchange=""  style="text-align:right" readonly="true" />
                              </td>                                                                                                                   
                              
                          </tr>                
                          
                          <TR>       
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.psatat" /></td>
                              <td colspan="1" ><html:select property="txtPayStatus" name= "frmEmpCPFSearchForm"  alt="txtPayStatus" titleKey="Payroll.EmpInfo.psatat" disabled="true" styleClass="locked" style="width:80%" onchange="" >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                              <html:option value="A" > <bean:message key="Payroll.EmpInfo.act" /></html:option>
                              <html:option value="I" > <bean:message key="Payroll.EmpInfo.inact" /></html:option>                              
                              </html:select>
                              </td>             
                              
                              <td  width="16%" class=labelText><bean:message key="Payroll.EmpInfo.pmode" /></td>
                              <td colspan="1" ><html:select property="txtPayMode" name= "frmEmpCPFSearchForm"  alt="txtPayMode" titleKey="Payroll.EmpInfo.pmode" disabled="true" styleClass="locked" style="width:80%" onchange="" >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>                                    
                              <html:option value="C" > <bean:message key="Payroll.EmpInfo.cash" /></html:option>
                              <html:option value="B" > <bean:message key="Payroll.EmpInfo.bank" /></html:option>
                              <html:option value="O" > <bean:message key="Payroll.EmpInfo.oth" /></html:option>                                                               
                              </html:select>
                              </td>
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pmodeType"/>
                              <td colspan="1" ><html:select property="txtPayModeType" name= "frmEmpCPFSearchForm"  alt="txtPayModeType" titleKey="Payroll.EmpInfo.pmodeType" disabled="true" styleClass="locked" style="width:79%" onchange="" >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                              <html:option value="ECS" > <bean:message key="Payroll.EmpInfo.ECS" /></html:option>
                              <html:option value="CTI" > <bean:message key="Payroll.EmpInfo.CTI" /></html:option>                              
                              </html:select>
                              </td>
                          </tr> 
                          
                          <tr>
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.BankName" /></td>
                              <td width = "18%">
                              <html:text  property="txtBankDesc" name= "frmEmpCPFSearchForm"  altKey="pay.EmpInfo.BankCode" size="23" styleClass="locked" onchange="" />                       
                              </td>
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.BranchName" /></td>
                              <td width = "18%">
                              <html:text  property="txtBranchDesc" name= "frmEmpCPFSearchForm"  altKey="pay.EmpInfo.BranchCode" size="23" styleClass="locked"  onchange="" maxlength="4" />                              
                              </td>
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.acno" /></td>
                              <td ><html:text  property="txtBankAccNo" name= "frmEmpCPFSearchForm"  styleClass="locked" altKey="Payroll.EmpInfo.acno" maxlength="20" size="23" onchange="" /></td>                    
                          </tr>                                                              
                         
                          <TR>                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pstchdate" /></td>
                              <td ><html:text  property="txtPayStsChnDate" name= "frmEmpCPFSearchForm"  styleClass = "locked" altKey="Payroll.EmpInfo.pstchdate" maxlength="15" size="23" onchange="" /></td>                            
                              
                               <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.StrInc" /></td>
                               <td ><html:text  property="txtStagInc" name= "frmEmpCPFSearchForm"  styleClass = "locked" altKey="Payroll.EmpInfo.StrInc" maxlength="10" style="text-align:right"   size="23" onchange="" /></td>                                                                                                                        
                               
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.StagIncEffDate" /></td>
                              <td ><html:text  property="txtStagEffDate" name= "frmEmpCPFSearchForm"  styleClass = "locked" altKey="Payroll.EmpInfo.StagIncEffDate" maxlength="10"  size="23" onchange="" /></td>                                                                                                                                                                                                                                               
                          </tr>
                          
                          <tr>                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.inrstat" /></td>
                              <td colspan="1" >                              
                              <html:select property="txtInrSt" alt="txtInrSt" name= "frmEmpCPFSearchForm"  titleKey="Payroll.EmpInfo.inrstat" styleClass="locked" disabled="true"  style="width:79%">
                              <html:option value="" > <bean:message key="Payroll.pleaseSelect" /></html:option>
                              <html:option value="R" > <bean:message key="Payroll.EmpInfo.rls" /></html:option>
                              <html:option value="S" > <bean:message key="Payroll.EmpInfo.stp" /></html:option>
                              </html:select>                              
                              </td>
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.txtPanNo" /></td>
                              <td ><html:text  property="txtPanNo" name= "frmEmpCPFSearchForm"  styleClass = "locked" altKey="Payroll.EmpInfo.txtPanNo" maxlength="10" onchange="" style="text-align:Left" size="23" />
                              </td>                            
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.Hra.city" /></td>
                              <td colspan="1">       
                              <html:text  property="txtCityTypeHra" name= "frmEmpCPFSearchForm"  altKey="pay.EmpInfo.Hra.city" maxlength="10" size="23" styleClass="locked" readonly="true" onchange=""  />                                                                                                                                       
                              </td>
                                                            
                          </tr> 
                          
                          <tr>
                            <td width="15%" class=labelText>MHS Member</td>
                            <td colspan="1">                                                           
                            <html:text property="txtMHSTyp" name= "frmEmpCPFSearchForm"  alt="txtMHSTyp" styleClass="locked" size="23"  onchange="" />                                                            
                            </td>
                              
                            <td class=labelText  ><bean:message key="Payroll.EmpInfo.FpsNo" /> </td>                
                            <td>
                            <html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="10" size="23" styleClass="locked" style="text-align:right" />
                            </td> 
                     
                            <td width="15%" class=labelText>EPS Payment</td>
                            <td colspan="1">                                                                 
                            <html:select property="txtEpsFlag" name= "frmEmpCPFSearchForm"  alt="txtEpsFlag" styleClass="locked" disabled="true" style="width:79%" onchange=""  >
                            <html:option value="N" >No</html:option>
                            <html:option value="Y" >Yes</html:option>
                            </html:select>                              
                            </td> 
                          </tr>
              
                          <tr>
                            <td class=labelText  >Entitlement Date </td>                
                            <td>
                            <html:text  property="txtEpsEntDt" styleClass = "locked" maxlength="10"  size="23" onchange="" readonly="true"/>
                            </td> 
                            
                            <td width="15%" class=labelText>EPS Separation Reason</td>
                            <td colspan="1">                                                                 
                            <html:text property="txtEpsSepRsn" name= "frmEmpCPFSearchForm"  alt="txtMHSTyp" styleClass="locked" size="23" onchange="" />                            
                            </td>
                            
                            <td class=labelText  >EPS Separation Date </td>                
                            <td>
                            <html:text  property="txtEpsSepDt" styleClass = "locked" maxlength="10"  size="23" onchange="" readonly="true"/>
                            </td>                             
                          </tr>
                          <!--tr>              
                            <td class=labelText  >Pay Revision flag </td>                
                            <td>
                            <html:text  property="txtPayRevFlag" styleClass = "locked" maxlength="10"  size="23" onchange="" readonly="true"/>
                            </td>                             
                          </tr-->
                          <tr height = 3><td>&nbsp;</td></tr>                    
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

</div>

<!-- Container Table Ends -->
<html:hidden name="frmEmpCPFSearchForm"  property="screenName" value="EmpCPFSearchScreen" />
<html:hidden name="frmEmpCPFSearchForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpCPFSearchForm" />
<html:hidden property="loginLocCode" name="frmEmpCPFSearchForm" />
<html:hidden property="positionRequested" name="frmEmpCPFSearchForm" />
<html:hidden property="userPositionRequested" name="frmEmpCPFSearchForm" />
<html:hidden property="buttonFlag" name="frmEmpCPFSearchForm"  />
<html:hidden property="lovKey" name="frmEmpCPFSearchForm"  />
<html:hidden property="txtFields" name="frmEmpCPFSearchForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpCPFSearchForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpCPFSearchForm"  />
<html:hidden property="txtIndex" name="frmEmpCPFSearchForm"  />
<html:hidden property="txtInputField" name="frmEmpCPFSearchForm"  />
<html:hidden property="txtPayRevFlag" name="frmEmpCPFSearchForm"    />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

/*function ShowEmpNum()
{
    frmEmpCPFSearchForm.lovKey.value = "EmpPromo" + frmEmpCPFSearchForm.screenName.value + frmEmpCPFSearchForm.screenMode.value;    
    frmEmpCPFSearchForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtDsgn,txtCateg,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtDOJSite,txtCurtBasic,txtPrvPromDate,txtPayType,txtPersPaySFNAmt,txtPerPayHighQual,txtPerPayAdvIncr,txtStagInc,txtDsgnDesc";
    frmEmpCPFSearchForm.queryParam.value = "txtSiteID="+frmEmpCPFSearchForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpCPFSearchForm.hdnEmpLbrFlag.value;
    frmEmpCPFSearchForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName";
    frmEmpCPFSearchForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpCPFSearchForm');
    return true;
}*/

function ShowEmpNum()
{
  // alert(frmEmpCPFSearchForm.screenMode.value+","+frmEmpCPFSearchForm.hdnEmpLbrFlag.value);
	var frstName = frmEmpCPFSearchForm.txtEmpFirstName.value;
	var lstName = frmEmpCPFSearchForm.txtEmpLastName.value;
	var dsgn = frmEmpCPFSearchForm.txtDsgn.value;
	var cadre = frmEmpCPFSearchForm.txtCadre.value;
	var empType = frmEmpCPFSearchForm.txtEmpType.value;
	var cpfCode = frmEmpCPFSearchForm.txtCpfCode.value;
	var presPOP = frmEmpCPFSearchForm.txtPresentPOPDesc.value;   

	if(frstName =='' && lstName == '' && dsgn == '' && cadre == '' && empType == '' && cpfCode =='' && presPOP == '')
	{
		alert("Please Enter atleast one search criteria ");
		return false;
	}   

   frmEmpCPFSearchForm.lovKey.value = "EmpFinInfo" + frmEmpCPFSearchForm.screenName.value + frmEmpCPFSearchForm.screenMode.value;
   var txtPresentPOP, txtEmpTypeId, txtDsgn, txtCadre
   if(frmEmpCPFSearchForm.txtPresentPOP.value=="")
		txtPresentPOP=1;
   else
		txtPresentPOP = frmEmpCPFSearchForm.txtPresentPOP.value;
   if(frmEmpCPFSearchForm.txtEmpTypeId.value=="")
		txtEmpTypeId=1;
   else
		txtEmpTypeId = frmEmpCPFSearchForm.txtEmpTypeId.value;
   if(frmEmpCPFSearchForm.txtDsgn.value=="")
		txtDsgn=1;
   else
	    txtDsgn = frmEmpCPFSearchForm.txtDsgn.value;
   if(frmEmpCPFSearchForm.txtCadre.value=="")
		txtCadre=1;
   else 
		txtCadre = frmEmpCPFSearchForm.txtCadre.value;

   frmEmpCPFSearchForm.queryParam.value = "txtPresentPOP="+txtPresentPOP+",txtEmpTypeId="+txtEmpTypeId+",txtDsgn="+txtDsgn+",txtCadre="+txtCadre;
   if(frmEmpCPFSearchForm.screenMode.value == 'N')
   {
		frmEmpCPFSearchForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpFirstName,txtEmpMiddleName,txtEmpLastName";
		frmEmpCPFSearchForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName";
		frmEmpCPFSearchForm.txtIndex.value ="";      
   }
   if(frmEmpCPFSearchForm.screenMode.value == 'Q')
   {
		frmEmpCPFSearchForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpFirstName,txtEmpMiddleName,txtEmpLastName,txtCpfCode";
		frmEmpCPFSearchForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName,Payroll.Common.cpfCode";
		frmEmpCPFSearchForm.txtIndex.value ="";      
   }
   frmEmpCPFSearchForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpCPFSearchForm');
   return true;
}    

function ShowLovDsgn()
{ 
    frmEmpCPFSearchForm.lovKey.value = "EmpCPFDsgn" + frmEmpCPFSearchForm.screenName.value + frmEmpCPFSearchForm.screenMode.value;       
    frmEmpCPFSearchForm.txtDisplayFields.value = "txtDsgn,txtDsgnDesc";
    frmEmpCPFSearchForm.txtSearchFields.value = "pay.EnqPayImg.txtDesig,pay.MaintMiscellaneousParam.category,pay.MaintPayScaleIDA.payscalecode";    
    frmEmpCPFSearchForm.txtIndex.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpCPFSearchForm');       
    return true;    
}

function ShowLovEmpType()
{
   frmEmpCPFSearchForm.lovKey.value = "EmpInfoEmpType" + frmEmpCPFSearchForm.screenName.value + frmEmpCPFSearchForm.screenMode.value;
   frmEmpCPFSearchForm.txtDisplayFields.value = "txtEmpTypeId,txtEmpType";
   frmEmpCPFSearchForm.txtSearchFields.value = "";   
   frmEmpCPFSearchForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpCPFSearchForm');   
   return true;
}

function ShowLovEmpLoc()
{
if(document.frmEmpCPFSearchForm.txtPayRevFlag.value!='Y')
{
   frmEmpCPFSearchForm.lovKey.value = "EmpCPFSearchLoc" + frmEmpCPFSearchForm.screenName.value + frmEmpCPFSearchForm.screenMode.value;   
   frmEmpCPFSearchForm.txtDisplayFields.value = "txtPresentPOP,txtPresentPOPDesc,txtCityTypeHra";   
   frmEmpCPFSearchForm.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   frmEmpCPFSearchForm.txtInputField.value =""; 
   frmEmpCPFSearchForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpCPFSearchForm');
   if(document.all.screenMode.value!='Q')
      lfnChanged(1);
   return true;
}
else{

  alert("This employee is under revised payscale. Please use the transfer functionality for this activity.");
}
}

function lfnLoad()
{
    mode = document.all.screenMode.value;    
    if(mode == '')
    {
        doQueryMode();
    } 
    checkPFType();
    if(document.all.txtPayType.value=='CDA1')
    {
      document.all.txtStagInc.disabled="true";
      //document.all.butTxtStagIncEffDate.disabled="true";
      document.getElementById("old").style.display='none';
      document.getElementById("new").style.display='';
    }
    else
    {
      document.all.txtStagInc.disabled="";
      //document.all.butTxtStagIncEffDate.disabled="";
      document.getElementById("old").style.display='';
      document.getElementById("new").style.display='none';
    }    
    hedMenuHandling(mode);    
    document.all.butInsertMode.disabled="true";    
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpCPFSearchForm.action="../../../EmpCPFScreenQueryMode.do"
    frmEmpCPFSearchForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpCPFSearchForm.action="../../../EmpCPFScreenRefresh.do"
    frmEmpCPFSearchForm.submit();
}

function getHeaderRecord()
{
    var frstName = frmEmpCPFSearchForm.txtEmpFirstName.value;
    var lstName = frmEmpCPFSearchForm.txtEmpLastName.value;
    var dsgn = frmEmpCPFSearchForm.txtDsgn.value;
    var cadre = frmEmpCPFSearchForm.txtCadre.value;
    var empType = frmEmpCPFSearchForm.txtEmpType.value;
    var cpfCode = frmEmpCPFSearchForm.txtCpfCode.value;
    var presPOP = frmEmpCPFSearchForm.txtPresentPOPDesc.value;
	var empNum = frmEmpCPFSearchForm.headerPrimaryKey.value;

     if(frstName =='' && lstName == '' && dsgn == '' && cadre == '' && empType == '' && cpfCode =='' && presPOP == '' && empNum == '')
     {
        alert("Please Enter atleast one search criteria ");
          return false;
      }    
    document.all.buttonFlag.value='';   
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		
    frmEmpCPFSearchForm.action="../../../EmpCPFScreenGetHeaderAction.do"
    frmEmpCPFSearchForm.submit();
}

function doGetNextHeader()
{
    document.all.buttonFlag.value='';    
    frmEmpCPFSearchForm.userPositionRequested.value = 1*frmEmpCPFSearchForm.positionRequested.value + 1;
    frmEmpCPFSearchForm.action="../../../EmpCPFScreenNextHeader.do";
    frmEmpCPFSearchForm.submit();
}

function PrevHeader()
{
  document.all.buttonFlag.value='';  
  frmEmpCPFSearchForm.userPositionRequested.value = 1*frmEmpCPFSearchForm.positionRequested.value - 1;
  frmEmpCPFSearchForm.action = "../../../EmpCPFScreenNextHeader.do";
  frmEmpCPFSearchForm.submit();
}

function JumpHeader()
{
  document.all.buttonFlag.value='';  
  frmEmpCPFSearchForm.userPositionRequested.value = 1*frmEmpCPFSearchForm.newPositionRequested.value;
  frmEmpCPFSearchForm.action = "../../../EmpCPFScreenNextHeader.do";
  frmEmpCPFSearchForm.submit();
}

function SaveRecord()
{
    if(mandatory_Check("frmEmpCPFSearchForm"))
    {        
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
		frmEmpCPFSearchForm.action = "../../../EmpCPFScreenSaveAction.do";                      
        frmEmpCPFSearchForm.submit();
    }
    
    else
    {
        return false;
    }
}

function checkPFType()
{
    if (document.all.txtPFType.value=='CPF' || document.all.txtPFType.value=='PFTYPE$CPF' || document.all.txtPFType.value=='')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';        
    }
    if (document.all.txtPFType.value=="GPF" || document.all.txtPFType.value=='PFTYPE$GPF')
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';                   
    }    
}  

function checkCPFLength(val)
{  
    if(val.length >7)
    {
        alert("Only 7 Digits Numeric Code is Allowed");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }      
}

function lfnChanged(val)
{
    frmEmpCPFSearchForm.headerDataChanged.value = "true";
}
    
</script>