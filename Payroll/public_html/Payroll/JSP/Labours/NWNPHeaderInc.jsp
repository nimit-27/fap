<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>NWNP LABOUR INFORMATION</TD>
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
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="Q">                                                
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </logic:notEqual>                                                                    
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="Q">                              
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required"  />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>               
                  </td>  
                  
                  <td class=labelText  ><bean:message key="Payroll.Labour.LabourCode" /> </td>
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="Q">                              
                  <html:text  property="txtStaffCode" altKey="Payroll.Labour.LabourCode" maxlength="10" size="23" styleClass="required" />                 
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="Q">                              
                  <html:text  property="txtStaffCode" altKey="Payroll.Labour.LabourCode" maxlength="10" size="23" styleClass="locked" readonly="true"/>                 
                  </logic:notEqual>
                  </td>
                  
                  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.prefix" /></td>
                  <td ><html:select  property="prefix" name="frmNWNPInfoForm" titleKey="Payroll.EmpInfo.prefix" styleClass = "optional" alt="prefix" style="width:80%" onchange="checkPrefix(this.value);"  >
                  <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                  <html:option value="MR" ><bean:message key="Payroll.EmpInfo.Mr" /></html:option>
                  <html:option value="MS" ><bean:message key="Payroll.EmpInfo.Ms" /></html:option>                              
                  <html:option value="MISS" ><bean:message key="Payroll.EmpInfo.Miss" /></html:option>                              
                  <html:option value="MRS" ><bean:message key="Payroll.EmpInfo.Mrs" /></html:option>                              
                  <html:option value="DR" ><bean:message key="Payroll.EmpInfo.Dr" /></html:option>                              
                  <html:option value="COL" ><bean:message key="Payroll.EmpInfo.Col" /></html:option>                              
                  <html:option value="CAPT" ><bean:message key="Payroll.EmpInfo.Capt" /></html:option>                              
                  </html:select></td>
              </TR> 
            
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.FirstName" /> </td>
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="U">                              
                  <html:text  property="txtEmpFirstName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="locked" readonly="true"/>                 
                  </logic:equal>
                  
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="U">                              
                  <html:text  property="txtEmpFirstName" altKey="pay.MaintainAnnualIncome.txtEmpName" titleKey="Payroll.EmpInfo.FirstName" maxlength="50" size="23" styleClass="required" onkeypress="                            
                    if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                      {}
                      else
                      {                                                          
                          return false;                            
                      };
                 "  style="text-align:left"  onchange="upper(this);" />
                  </logic:notEqual>
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.MiddleName" /> </td>
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="U">                              
                  <html:text  property="txtEmpMiddleName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="locked" readonly="true"/>                 
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="U">                              
                  <html:text  property="txtEmpMiddleName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="optional" onkeypress="                            
                    if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                      {}
                      else
                      {                                                         
                          return false;                            
                      };
                 "  style="text-align:left"  onchange="upper(this);" />                 
                  </logic:notEqual>
                  </td>
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.LastName" /> </td>
                  <td> 
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="U">                              
                  <html:text  property="txtEmpLastName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="locked" readonly="true" />                 
                  </logic:equal>                  
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="U">                              
                  <html:text  property="txtEmpLastName" altKey="pay.MaintainAnnualIncome.txtEmpName" titleKey="Payroll.EmpInfo.LastName" maxlength="50" size="23" styleClass="optional" onkeypress="                            
                    if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                      {}
                      else
                      {                                                          
                          return false;                            
                      };
                 "  style="text-align:left"  onchange="upper(this);" />                 
                  </logic:notEqual>
                  </td>              
              </tr>
              
              <TR>                 
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left"> 
                  
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="U">                                                
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();" styleClass="locked" readonly="true"/>
                  </logic:equal>                                                                                                 
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="Q">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" onclick="return ShowLovDsgn();">
                  </logic:equal>
                  
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="N">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" onchange="lfnChanged(this.value);" onclick="return ShowLovDsgn();">
                  </logic:equal>
                  
                <html:hidden  property="txtDsgnDesc" altKey="Payroll.EmpInfo.txtDesig"  />                                 
                  </td>
           <!--Added by dushyant on 18-May-2013-->
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.OldCpfCode" /> </td>                     
                  <td>
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="Q">
                  <html:text property="txtOldCpfCode" name="frmNWNPInfoForm" titleKey="Payroll.EmpInfo.OldCpfCode" styleClass="locked" readonly="true" style="WIDTH: 49%"  />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="U">
                  <html:text property="txtOldCpfCode" name="frmNWNPInfoForm" titleKey="Payroll.EmpInfo.OldCpfCode" styleClass="locked" readonly="true" style="WIDTH: 49%"  />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="N">
                  <html:text property="txtOldCpfCode" name="frmNWNPInfoForm" titleKey="Payroll.EmpInfo.OldCpfCode" styleClass="locked" readonly="true" style="WIDTH: 49%"  />
                  </logic:equal>
                  </td>                  
           <!--Added by dushyant on 18-May-2013-->
                  <td id="cpf" class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>                  
                  <td>
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="Q">                     
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="6" size="23" readonly="true" styleClass="locked"   style="text-align:right" onchange="checkCPFLength(this.value);"/>
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="Q"> 
				    <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="N">
						  <html:text  property="txtCpfCode" value='TEMP' altKey="pay.EmpInfo.CpfCode" maxlength="6" size="23" readonly="true" styleClass="locked" style="text-align:right" onkeypress="
						   if(document.all.txtPFType.value!='PFTYPE$GPF'){
						   if((event.keyCode < 48 || event.keyCode > 57))
							{                     
							  return false;
							}                 
							};"                            
							onchange="checkCPFLength(this.value); lfnChanged(this.value);" />  
					</logic:equal>
                      <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="N">
						  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="6" size="23" readonly="false" styleClass="required" style="text-align:right" onkeypress="
						   if(document.all.txtPFType.value!='PFTYPE$GPF'){
						   if((event.keyCode < 48 || event.keyCode > 57))
							{                     
							  return false;
							}                 
							};"                            
							onchange="checkCPFLength(this.value); lfnChanged(this.value);" />  
					</logic:notEqual>
                  </logic:notEqual>
                  </td> 
              </tr>
              
              <tr>             
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.parentZone" /> </td>                            
                  <td >
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="U"> 
                  <html:select property="parentZone" name="frmNWNPInfoForm" titleKey="Payroll.EmpInfo.parentZone" disabled="true" styleClass="required" alt="<%=String.valueOf(i)%>"  onchange="if(document.all.screenMode.value!='Q'){lfnChanged(this.value);}"  style="WIDTH: 80%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="NWNPLabourList">
                  <html:optionsCollection label="label" value="value" property="valueParentZoneArrayList" name="NWNPLabourList"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="U"> 
                  <html:select property="parentZone" name="frmNWNPInfoForm" titleKey="Payroll.EmpInfo.parentZone" styleClass="required" alt="<%=String.valueOf(i)%>"  onchange="if(document.all.screenMode.value!='Q'){lfnChanged(this.value);}"  style="WIDTH: 80%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="NWNPLabourList">
                  <html:optionsCollection label="label" value="value" property="valueParentZoneArrayList" name="NWNPLabourList"/>
                  </logic:present>
                  </html:select>
                  </logic:notEqual>
                  </td>
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="U">                                                
                  <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" readonly="true" styleClass="optional" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtPresentPOP">
                  </logic:equal>                                                                                                 
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="U">
                  <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" readonly="true" styleClass="required" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtPresentPOP" onclick="return ShowLovEmpLoc();">
                  </logic:notEqual><html:hidden  property="txtPresentPOP" altKey="Payroll.EmpInfo.txtPresentPOP"  />                                      
                  </td>
                  
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.dojFCI" /> </td>            
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="Q">
                  <html:text  property="txtDojFCI" altKey="Payroll.EmpInfo.dojFCI" titleKey="Payroll.EmpInfo.dojFCI" maxlength="15" size="23" onchange="fillDOJPP(this.value);" readonly="true" styleClass="optional" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDojFCI" alt="<%=(i-1) %>" />
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="Q">                              
                  <html:text  property="txtDojFCI" altKey="Payroll.EmpInfo.dojFCI" titleKey="Payroll.EmpInfo.dojFCI" maxlength="15" size="23" onchange="fillDOJPP(this.value);" readonly="true" styleClass="required"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDojFCI" alt="<%=(i-1) %>" onclick="showCalendar('txtDojFCI',this)" />
                  </logic:notEqual>
                  </td>
              </tr>    
              
              <tr>       
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="Q">
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" titleKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" readonly="true" styleClass="optional" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDojFCI" alt="<%=(i-1) %>" />
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="Q">                              
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" titleKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" onchange="checkPostDate(this.value)" readonly="true" styleClass="required"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtDOJSite" title="Calender" onclick="showCalendar('txtDOJSite',this)" />
                  </logic:notEqual>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td >
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="Q">
                  <html:select property="txtEmpStatus" name="frmNWNPInfoForm"  titleKey="Payroll.EmpInfo.EmpStat" styleClass="required"style="WIDTH: 78%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="NWNPLabourList">
                  <html:optionsCollection label="label" value="value" property="valueEmpStatAllArrayList" name="NWNPLabourList"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="U">
                  <html:select property="txtEmpStatus" name="frmNWNPInfoForm"  titleKey="Payroll.EmpInfo.EmpStat" styleClass="required" alt="<%=String.valueOf(i)%>"  disabled="true" onchange="if(document.all.screenMode.value!='Q'){lfnChanged(this.value);}"  style="WIDTH: 78%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="NWNPLabourList">
                  <html:optionsCollection label="label" value="value" property="valueEmpStatAllArrayList" name="NWNPLabourList"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="N">
                  <html:select property="txtEmpStatus" name="frmNWNPInfoForm"  titleKey="Payroll.EmpInfo.EmpStat" styleClass="required" alt="<%=String.valueOf(i)%>"  onchange="if(document.all.screenMode.value!='Q'){lfnChanged(this.value);}"  style="WIDTH: 78%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="NWNPLabourList">
                  <html:optionsCollection label="label" value="value" property="valueEmpStatArrayList" name="NWNPLabourList"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  </td>
                  <!--
				  <td width="15%" class=labelText  ><bean:message key="Labours.txtGangName" /> </td>                            
                  <td>
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="Q">
                  <html:text property="txtGangName" name="frmNWNPInfoForm" titleKey="Labours.txtGangName" styleClass="locked" readonly="true" style="WIDTH: 78%"  />
                  <html:hidden property="txtGangId" name="frmNWNPInfoForm" />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="U">
                  <html:text property="txtGangName" name="frmNWNPInfoForm" titleKey="Labours.txtGangName" styleClass="locked" readonly="true" style="WIDTH: 78%"  />
                  <html:hidden property="txtGangId" name="frmNWNPInfoForm" />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="N">
                  <html:text property="txtGangName" name="frmNWNPInfoForm" titleKey="Labours.txtGangName" styleClass="locked" readonly="true" style="WIDTH: 78%"  />
                  <html:hidden property="txtGangId" name="frmNWNPInfoForm" />
                  </logic:equal>
                  </td>  
                  -->
             
       <!--Added by dushyant on 18-May-2013  -->
			 
                 <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.PF" /> </td>                            
                  <td ><logic:equal property= "screenMode" name= "frmNWNPInfoForm" value="N">                              
                  <html:select  property="txtPFType" name="frmNWNPInfoForm" titleKey="Payroll.EmpInfo.PF" styleClass = "required" style="width:80%" disabled="true" >                  
                  <!--<html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>-->      
                  <html:option value="PFTYPE$CPF" ><bean:message key="Payroll.DeptLbr.CPF" /></html:option>                                                
                  </html:select>
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmNWNPInfoForm" value="N">                              
                  <html:select  property="txtPFType" name="frmNWNPInfoForm" titleKey="Payroll.EmpInfo.PF" styleClass = "locked" style="width:80%" disabled="true"  >
                  <!--<html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>-->      
                  <html:option value="PFTYPE$CPF" ><bean:message key="Payroll.DeptLbr.CPF" /></html:option>                                                
                  </html:select>
                  </logic:notEqual>
                  </td>
			  </tr>
       <!--Added by dushyant on 18-May-2013  -->
              
            </table>     
          </tr>
            <%! int i=0,j=0; %>
            <% i = 0;j=0; %>     
      <tr height="15" >
      <td colspan="6"></td>
    </tr>                                 
  </table> 
<script language="javascript">
function ShowEmpNum()
{
   frmNWNPInfoForm.lovKey.value = "NWNPLabourInfo" + frmNWNPInfoForm.screenName.value + frmNWNPInfoForm.screenMode.value;
   frmNWNPInfoForm.queryParam.value = "txtSiteID="+frmNWNPInfoForm.loginLocCode.value+" ";
   if(frmNWNPInfoForm.screenMode.value == 'N')
   {
       //frmDeptLabourInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,lstCateg,txtDsgn";
       frmNWNPInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpFirstName,txtEmpLastName,txtCpfCode";
     //  frmNWNPInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName";         commented by dushyant on 15-11-2010

	 frmNWNPInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName,Payroll.Common.cpfCode";
       frmNWNPInfoForm.txtIndex.value ="";      
   }
   if(frmNWNPInfoForm.screenMode.value == 'Q')
   {
     frmNWNPInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpFirstName,txtEmpLastName,txtCpfCode";
    // frmNWNPInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName";       commented by dushyant on 15-11-2010
     
      frmNWNPInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName,Payroll.Common.cpfCode";

     frmNWNPInfoForm.txtIndex.value ="";      
   }
   frmNWNPInfoForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmNWNPInfoForm');
   return true;
}    

function ShowLovEmpLoc()
{
  //alert("Inside emp location"+frmNWNPInfoForm.screenMode.value+" "+frmNWNPInfoForm.screenName.value);
   frmNWNPInfoForm.lovKey.value = "NWNPLbrEmpLoc" + frmNWNPInfoForm.screenName.value + frmNWNPInfoForm.screenMode.value;   
   frmNWNPInfoForm.txtDisplayFields.value = "txtPresentPOP,txtPresentPOPDesc";
   frmNWNPInfoForm.queryParam.value = "txtSiteID="+frmNWNPInfoForm.loginLocCode.value+" ";
   frmNWNPInfoForm.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   frmNWNPInfoForm.txtInputField.value =""; 
   frmNWNPInfoForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmNWNPInfoForm');
   if(document.all.screenMode.value!='Q')
        lfnChanged(1);
   return true;
}


function ShowLovDsgn()
{   //alert("HIII"+ frmDPSInfoForm.loginLocCode.value);
   if(document.all.forwardedPage.value == 'FlagDet' || document.all.forwardedPage.value == 'HrDet' || document.all.forwardedPage.value == 'AddressDet')
   {
      return false; 
   }
   else 
   {
   //alert("HIII" +frmNWNPInfoForm.loginLocCode.value+" "+frmNWNPInfoForm.hdnEmpLbrFlag.value );
       frmNWNPInfoForm.lovKey.value = "NWNPLabourDsgn" + frmNWNPInfoForm.screenName.value + frmNWNPInfoForm.screenMode.value;       
       frmNWNPInfoForm.txtDisplayFields.value = "txtDsgnDesc,txtDsgn,txtCateg";
       frmNWNPInfoForm.txtSearchFields.value = "";
       frmNWNPInfoForm.txtInputField.value =""; 
       frmNWNPInfoForm.txtIndex.value =""; 
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmNWNPInfoForm');
       if(document.all.screenMode.value!='Q')
        lfnChanged(1);
       return true;
   }      
}


function upper(val)
{
   val.value=val.value.toUpperCase();
}

function fillDOJPP(val)
{    
    //document.all.txtDOJSite.value=val; commented by swapnendu Dt 11 Mar 2013
	//below code added on 08 Apr 2013 start
    var systDate = getSysDate();
    if(!cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
      document.all.txtDojFCI.value="";
      return false;
    }
    document.all.txtDOJSite.value=val;
	document.all.txtEpsEntDt.value=val;
	//end
}

function checkCPFLength(val)
{
   //if(document.all.txtPFType.value!='PFTYPE$GPF') //
   //{
	  var cpfgpf = document.all.txtPFType.value;
	  var str='';	
	  if (cpfgpf=='CPF') str='CPF';
	  else 	str='GPF';
      if(val.length >7)
      {
          alert("Only 7 Digits Numeric Code is Allowed");
          event.srcElement.select();
          event.srcElement.focus();
          event.returnValue=false;
      }
	  else //added by swpnendu Dt 13 Nov 2011
	  {
		  if(val.length == 1)
		  {
			  if(val==0)
			  {
				  alert(str + " Code can not start with '0'");
			      document.all.txtCpfCode.value="";
				  event.srcElement.focus();
			  }
		  }
		  else
		  {
			  var val = val.substr(0,1);
			  if(val==0){
				  alert(str + " Code can not start with '0'");
			      document.all.txtCpfCode.value="";
				  event.srcElement.focus();
			  }
		  }
	  }
   //}
}

function checkPrefix(val)
{
    if(document.all.txtGender.value!="")
    {
        if(document.all.txtGender.value=="M")
        {
            if(val=='MISS' || val=='MRS' || val=='MS')
            {
                alert("Gender is Male, Please Choose appropriate Prefix")
                document.all.prefix.value="";
                document.all.prefix.focus();
            }
        }
        if(document.all.txtGender.value=="F")
        {
            if(val=='MR')
            {
                alert("Gender is Female, Please Choose appropriate Prefix")
                document.all.prefix.value="";
                document.all.prefix.focus();
            }
        }    
    }
    comboChange();
}

</script>