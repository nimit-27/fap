<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN LABOUR INFORMATION(Super User)</TD>
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
            <!--General Information Row Starts hdnEmpLbrFlag -->       
                        
            <TR>
             <% String empLbr = (String)(request.getSession().getAttribute("hdnEmpLbrFlag"));
             if(empLbr.equals(new String("K"))) {%> 
              <TD class=subHeader colspan=6> Detail Information  Of kotwal Employee</TD>
            <%} else {  %>           
               
             <TD class=subHeader colspan=6> Detail Information Of Employee</TD>
              <%}  %>
              
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="6"></td>
            </tr>         
                            
            
            <tr></tr>
              <table  cellSpacing=0 cellPadding=0 border=0>             
			  <!--added by devendra on 27th Sept 2010 start-->
			<tr>
			<td width="15%" class=labelText>
				<bean:message key="Payroll.EmpInfo.ptype" />
			</td>
			<td colspan="1" >
				<logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
				<html:select  property="txtPayType" styleClass = "optional" alt="txtPayType" style="width:80%" > 
				<html:option value="IDA" > <bean:message key="Payroll.EmpInfo.ida" /></html:option>
				</html:select>
				</logic:equal>
				<logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
				<html:select  property="txtPayType" styleClass = "required" alt="txtPayType" titleKey="Payroll.EmpInfo.ptype" style="width:80%" >
				<html:option value="IDA" > <bean:message key="Payroll.EmpInfo.ida" /></html:option>
				</html:select>
				</logic:notEqual>
			</td>          
			<td width="15%" class=labelText>
				<bean:message key="Payroll.EmpInfo.payRevFlag" />
			</td>
			<td>
				<logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
				<html:select  property="payRevFlag" name= "frmDeptLabourInfoForm"  styleClass = "required" alt="payRevFlag" titleKey="Payroll.EmpInfo.payRevFlag" style="width:80%" onchange="fnClearDsgnNPayCode();">
					<html:option value="2"  ><bean:message   key="Payroll.2Pay" /></html:option> 
                                        <html:option value="3" ><bean:message   key="Payroll.3Pay" /></html:option> 
                                </html:select>	
				</logic:equal>
				<logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
				<html:select  property="payRevFlag" name= "frmDeptLabourInfoForm"  styleClass = "required" alt="payRevFlag" titleKey="Payroll.EmpInfo.payRevFlag" style="width:80%" >
					<html:option value="2"  ><bean:message   key="Payroll.2Pay" /></html:option> 
                                        <html:option value="3" ><bean:message   key="Payroll.3Pay" /></html:option> 
                                </html:select>	
				</logic:notEqual>
       <!--added by dushaynt on 20 may 2013 start-->
				  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.prefix" /></td>
                  <td ><html:select  property="prefix" name="frmDeptLabourInfoForm" titleKey="Payroll.EmpInfo.prefix" styleClass = "optional" alt="prefix" style="width:80%" onchange="checkPrefix(this.value);"  >
                  <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                  <html:option value="MR" ><bean:message key="Payroll.EmpInfo.Mr" /></html:option>
                  <html:option value="MS" ><bean:message key="Payroll.EmpInfo.Ms" /></html:option>                              
                  <html:option value="MISS" ><bean:message key="Payroll.EmpInfo.Miss" /></html:option>                              
                  <html:option value="MRS" ><bean:message key="Payroll.EmpInfo.Mrs" /></html:option>                              
                  <html:option value="DR" ><bean:message key="Payroll.EmpInfo.Dr" /></html:option>                              
                  <html:option value="COL" ><bean:message key="Payroll.EmpInfo.Col" /></html:option>                              
                  <html:option value="CAPT" ><bean:message key="Payroll.EmpInfo.Capt" /></html:option>                          
                  </html:select></td>
     <!--added by dushaynt on 20 may 2013 end-->
			</td>
			</tr>
			<!--added by devendra on 27th sept 2010 end-->
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">                                                
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </logic:notEqual>                                                                    
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">                              
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required"  />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>               
                  </td>  
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.StaffCode" /> </td>
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">                              
                  <html:text  property="txtStaffCode" altKey="Payroll.EmpInfo.StaffCode" maxlength="10" size="23" styleClass="required" />                 
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">                              
                  <html:text  property="txtStaffCode" altKey="pay.MaintainAnnualIncome.StaffCode" maxlength="10" size="23" styleClass="locked" readonly="true"/>                 
                  </logic:notEqual>
                  </td>
             <!--Added by dushyant on 20-May-2013-->
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.OldCpfCode" /> </td>                     
                  <td>
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">
                  <html:text property="txtOldCpfCode" name="frmDeptLabourInfoForm" titleKey="Payroll.EmpInfo.OldCpfCode" styleClass="locked" readonly="true" style="WIDTH: 49%"  />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                  <html:text property="txtOldCpfCode" name="frmDeptLabourInfoForm" titleKey="Payroll.EmpInfo.OldCpfCode" styleClass="locked" readonly="true" style="WIDTH: 49%"  />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="N">
                  <html:text property="txtOldCpfCode" name="frmDeptLabourInfoForm" titleKey="Payroll.EmpInfo.OldCpfCode" styleClass="locked" readonly="true" style="WIDTH: 49%"  />
                  </logic:equal>
                  </td>                  
           <!--Added by dushyant on 20-May-2013-->
                
              </TR> 
            
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.FirstName" /> </td>
                  <td>               
                  <html:text  property="txtEmpFirstName" altKey="pay.MaintainAnnualIncome.txtEmpName" titleKey="Payroll.EmpInfo.FirstName" maxlength="50" size="23" styleClass="required" onkeypress="                            
                    if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                      {}
                      else
                      {                                                          
                          return false;                            
                      };
                 "  style="text-align:left"  onchange="upper(this); lfnChanged(this.value)" />                  
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.MiddleName" /> </td>
                  <td>                                       
                  <html:text  property="txtEmpMiddleName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="optional" onkeypress="                            
                    if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                      {}
                      else
                      {                                                         
                          return false;                            
                      };
                 "  style="text-align:left"  onchange="upper(this); lfnChanged(this.value)" />                                   
                  </td>
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.LastName" /> </td>
                  <td>                      
                  <html:text  property="txtEmpLastName" altKey="pay.MaintainAnnualIncome.txtEmpName" titleKey="Payroll.EmpInfo.LastName" maxlength="50" size="23" styleClass="optional" onkeypress="                            
                    if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                      {}
                      else
                      {                                                          
                          return false;                            
                      };
                 "  style="text-align:left"  onchange="upper(this); lfnChanged(this.value)" />                                   
                  </td>              
              </tr>
              
              <TR>                 
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">                  
                  
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" onclick="return ShowQryLovDsgn();">
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" onchange="lfnChanged(this.value);" onclick="return ShowLovDsgn();">
                  </logic:notEqual>
                  <html:hidden  property="txtDsgnDesc" altKey="Payroll.EmpInfo.txtDesig"  />                                      
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.PF" /> </td>                            
                  <td ><logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="N">                              
                  <html:select  property="txtPFType" name="frmDeptLabourInfoForm" titleKey="Payroll.EmpInfo.PF" styleClass = "required" style="width:80%" disabled="true" >                                   
                  <html:option value="PFTYPE$CPF" ><bean:message key="Payroll.DeptLbr.CPF" /></html:option>                                                
                  </html:select>
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="N">                              
                  <html:select  property="txtPFType" name="frmDeptLabourInfoForm" titleKey="Payroll.EmpInfo.PF" styleClass = "optional" style="width:80%" disabled="true"  >                  
                  <html:option value="PFTYPE$CPF" ><bean:message key="Payroll.DeptLbr.CPF" /></html:option>                                                
                  </html:select>
                  </logic:notEqual>
                  </td>
                  
                  <td id="cpf" class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>                  
                  <td>
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">                     
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="6" size="23" styleClass="required"   style="text-align:right" onchange="checkCPFLength(this.value);"/>
                  </logic:equal>

                  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="Q"> 
				       <logic:equal property= "txtCpfCode" name= "frmDeptLabourInfoForm" value="TEMP">
							<html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="6" size="23"    
							 styleClass="locked" readonly="true" style="text-align:right" onkeypress="
							   if(document.all.txtPFType.value!='PFTYPE$GPF'){
							   if((event.keyCode < 48 || event.keyCode > 57))
								{                     
								  return false;
								}                 
								};"                            
                          onchange="checkCPFLength(this.value); lfnChanged(this.value);" />  	 
                        </logic:equal>
                        <logic:notEqual property= "txtCpfCode" name= "frmDeptLabourInfoForm" value="TEMP">
							<html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="6" size="23"    
							styleClass="required"  style="text-align:right" onkeypress="
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
                  <html:select property="parentZone" name="frmDeptLabourInfoForm" titleKey="Payroll.EmpInfo.parentZone" styleClass="required" alt="<%=String.valueOf(i)%>"  onchange="if(document.all.screenMode.value!='Q'){lfnChanged(this.value);}"  style="WIDTH: 80%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="DeptLabourList">
                  <html:optionsCollection label="label" value="value" property="valueParentZoneArrayList" name="DeptLabourList"/>
                  </logic:present>
                  </html:select>                  
                  </td>
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">                                                
                  <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" readonly="true" styleClass="optional" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtPresentPOP">
                  </logic:equal>                                                                                                 
                  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                  <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" readonly="true" styleClass="required" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtPresentPOP" onclick="return ShowLovEmpLoc();">
                  </logic:notEqual><html:hidden  property="txtPresentPOP" altKey="Payroll.EmpInfo.txtPresentPOP"  />                                      
                  </td>
                  
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.dojFCI" /> </td>            
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">
                  <html:text  property="txtDojFCI" altKey="Payroll.EmpInfo.dojFCI" titleKey="Payroll.EmpInfo.dojFCI" maxlength="15" size="23" onchange="fillDOJPP(this.value);" readonly="true" styleClass="required" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDojFCI" alt="<%=(i-1) %>" />
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">                              
                  <html:text  property="txtDojFCI" altKey="Payroll.EmpInfo.dojFCI" titleKey="Payroll.EmpInfo.dojFCI" maxlength="15" size="23" onchange="fillDOJPP(this.value);" readonly="true" styleClass="required"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDojFCI" alt="<%=(i-1) %>" onclick="showCalendar('txtDojFCI',this)" />
                  </logic:notEqual>
                  </td>
              </tr>    
              
              <tr>
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" titleKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" readonly="true" styleClass="required" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDojFCI" alt="<%=(i-1) %>" />
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">                              
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" titleKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" onchange="checkPostDate(this.value)" readonly="true" styleClass="required"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtDOJSite" title="Calender" onclick="showCalendar('txtDOJSite',this)" />
                  </logic:notEqual>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td >
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">
                  <html:select property="txtEmpStatus" name="frmDeptLabourInfoForm"  titleKey="Payroll.EmpInfo.EmpStat" styleClass="optional" style="WIDTH: 78%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="DeptLabourList">
                  <html:optionsCollection label="label" value="value" property="valueEmpStatAllArrayList" name="DeptLabourList"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                  <html:select property="txtEmpStatus" name="frmDeptLabourInfoForm"  titleKey="Payroll.EmpInfo.EmpStat" styleClass="optional" disabled="true" style="WIDTH: 78%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="DeptLabourList">
                  <html:optionsCollection label="label" value="value" property="valueEmpStatAllArrayList" name="DeptLabourList"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="N">
                  <html:select property="txtEmpStatus" name="frmDeptLabourInfoForm"  titleKey="Payroll.EmpInfo.EmpStat" styleClass="required" alt="<%=String.valueOf(i)%>"  onchange="chkVldn(); if(document.all.screenMode.value!='Q'){lfnChanged(this.value);}"  style="WIDTH: 78%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="DeptLabourList">
                  <html:optionsCollection label="label" value="value" property="valueEmpStatArrayList" name="DeptLabourList"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  </td>                  

				  <td width="15%" class=labelText  ><bean:message key="Labours.txtGangName" /> </td>                            
                  <td>
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">
                  <html:text property="txtGangName" name="frmDeptLabourInfoForm" titleKey="Labours.txtGangName" styleClass="locked" readonly="true" style="WIDTH: 78%"  />
                  <html:hidden property="txtGangId" name="frmDeptLabourInfoForm" />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                  <html:text property="txtGangName" name="frmDeptLabourInfoForm" titleKey="Labours.txtGangName" styleClass="locked" readonly="true" style="WIDTH: 78%"  />
                  <html:hidden property="txtGangId" name="frmDeptLabourInfoForm" />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="N">
                  <html:text property="txtGangName" name="frmDeptLabourInfoForm" titleKey="Labours.txtGangName" styleClass="locked" readonly="true" style="WIDTH: 78%"  />
                  <html:hidden property="txtGangId" name="frmDeptLabourInfoForm" />
                  </logic:equal>
                  </td>                  
				  
                  <% if(empLbr.equals(new String("K"))) {%> 
                  <td class=labelText ><bean:message key="Payroll.Labour.LabourCode" /> </td>   
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">                  
                  <html:text  property="txtLabourCode" altKey="Payroll.Labour.LabourCode" titleKey="Payroll.Labour.LabourCode" maxlength="10" size="23" readonly="true" styleClass="optional" />
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmDeptLabourInfoForm" value="Q">                              
                  <html:text  property="txtLabourCode" altKey="Payroll.Labour.LabourCode" titleKey="Payroll.Labour.LabourCode" maxlength="10" size="23" styleClass="required" onblur=" upper(this); lfnChanged(this.value); checkKotLbrCode(this.value);"/>
                  </logic:notEqual>
                  </td>
                  <%} else {  %>           
                  <td><html:hidden  property="txtLabourCode" altKey="Payroll.Labour.LabourCode"  /></td>  
                  <%}  %>              
                  
              </tr>           
              
            </table>     
          </tr>
            <%! int i=0,j=0; %>
            <% i = 0;j=0; %>     
      <tr height="15" >
      <td colspan="6"></td>
    </tr>                                 
  </table> 

<html:hidden property="txtCateg" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtCategDesc" name="frmDeptLabourInfoForm"  />

<script language="javascript">

// added by devendra on 1 oct 2010 start
function fnClearDsgnNPayCode()
{
	var payRevFlag=document.all.payRevFlag.value;
	if(payRevFlag=="6")
	{
		document.all.txtPayScaleCode.value='';
		document.all.txtCurtBasic.value='';
		document.all.txtDsgn.value='';
		return;
	}
}
// added by devendra on 1 oct 2010 end

function ShowEmpNum()
{
   frmDeptLabourInfoForm.lovKey.value = "DeptLabourInfo" + frmDeptLabourInfoForm.screenName.value + frmDeptLabourInfoForm.screenMode.value;
   frmDeptLabourInfoForm.queryParam.value = "txtSiteID="+frmDeptLabourInfoForm.loginLocCode.value+",hdnEmpLbrFlag="+frmDeptLabourInfoForm.hdnEmpLbrFlag.value;    
   if(frmDeptLabourInfoForm.screenMode.value == 'Q')
   {
     //frmDeptLabourInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpFirstName,txtEmpMiddleName,txtEmpLastName"; commented by devendra on 28th sept 2010
	 frmDeptLabourInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName"; //commented by devendra on 28th sept 2010
	 frmDeptLabourInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpFirstName,txtEmpMiddleName,txtEmpLastName,txtCpfCode"; //added by devendra on 28th sept 2010
     frmDeptLabourInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName,Payroll.Common.cpfCode";     //added by devendra on 28th sept 2010
     frmDeptLabourInfoForm.txtIndex.value ="";      
   }
   frmDeptLabourInfoForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
   return true;
}    

function ShowLovEmpLoc()
{
   frmDeptLabourInfoForm.lovKey.value = "DeptLbrEmpLoc" + frmDeptLabourInfoForm.screenName.value + frmDeptLabourInfoForm.screenMode.value;   
   frmDeptLabourInfoForm.txtDisplayFields.value = "txtPresentPOP,txtPresentPOPDesc,txtCityTypeHra";
   frmDeptLabourInfoForm.queryParam.value = "txtSiteID="+frmDeptLabourInfoForm.loginLocCode.value+" ";
   frmDeptLabourInfoForm.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   frmDeptLabourInfoForm.txtInputField.value =""; 
   frmDeptLabourInfoForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
   lfnChanged(1);
   return true;
}

function ShowLovDsgn()
{  
	var empNo = frmDeptLabourInfoForm.headerPrimaryKey.value; 
	if(empNo == "")
		empNo = 0;
   if(document.all.forwardedPage.value == 'FlagDet' || document.all.forwardedPage.value == 'HrDet' || document.all.forwardedPage.value == 'AddressDet')
   {
      return false; 
   }
   else 
   {
       frmDeptLabourInfoForm.lovKey.value = "DeptLabourDsgn" + frmDeptLabourInfoForm.screenName.value + frmDeptLabourInfoForm.screenMode.value;       
       frmDeptLabourInfoForm.txtDisplayFields.value = "txtDsgnDesc,txtDsgn,txtCateg,txtCategDesc,txtPayScaleCode,hdnBoardFlag";
       frmDeptLabourInfoForm.txtSearchFields.value = "";
       frmDeptLabourInfoForm.queryParam.value = "hdnEmpLbrFlag="+frmDeptLabourInfoForm.hdnEmpLbrFlag.value+",txtSiteID="+frmDeptLabourInfoForm.loginLocCode.value+",headerPrimaryKey="+empNo;
       frmDeptLabourInfoForm.txtInputField.value ="txtDsgn"; 
       frmDeptLabourInfoForm.txtIndex.value =""; 
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
       lfnChanged(1);
       return true;
   }      
}

function ShowQryLovDsgn()
{   
   if(document.all.forwardedPage.value == 'FlagDet' || document.all.forwardedPage.value == 'HrDet' || document.all.forwardedPage.value == 'AddressDet')
   {
      return false; 
   }
   else 
   {
       frmDeptLabourInfoForm.lovKey.value = "DeptLabourDsgn" + frmDeptLabourInfoForm.screenName.value + frmDeptLabourInfoForm.screenMode.value;       
       frmDeptLabourInfoForm.txtDisplayFields.value = "txtDsgnDesc,txtDsgn";
       frmDeptLabourInfoForm.txtSearchFields.value = "";
       frmDeptLabourInfoForm.queryParam.value = "hdnEmpLbrFlag="+frmDeptLabourInfoForm.hdnEmpLbrFlag.value+",txtSiteID="+frmDeptLabourInfoForm.loginLocCode.value;
       frmDeptLabourInfoForm.txtInputField.value ="txtDsgn"; 
       frmDeptLabourInfoForm.txtIndex.value =""; 
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');       
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
	  if (cpfgpf=='PFTYPE$CPF') str='CPF';
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

function checkKotLbrCode(val)
{   
    if(alpha_Check(val))
    {     
      retrieveURL("../../../CheckKOTLbrAdminCodeAction.do?kotVal="+escape(val));
    }  
}

function retrieveURL(url) {    
    if (window.XMLHttpRequest) { // Non-IE browsers
      req = new XMLHttpRequest();      
      req.onreadystatechange = function () { 
                                    processStateChange();
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
                                    processStateChange();
                                    }
        req.send(null);
        
      }
    }
  }

function processStateChange() { 
    if (req.readyState == 4) { // Complete
      if (req.status == 200) { // OK response        
         var kotResponse = req.responseText;                      
        if(kotResponse == 1){
          alert("Labour Code already Exist");                 
          document.all.txtLabourCode.value = '';          
          return false;
          }                    
        } else {
        alert("Problem: " + req.statusText);
      }
    }
  }

function upper(val)
{
   val.value=val.value.toUpperCase();
}

</script>