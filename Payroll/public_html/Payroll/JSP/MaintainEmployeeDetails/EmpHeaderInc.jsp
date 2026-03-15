<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE INFORMATION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:600px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
            <!--General Information Row Starts -->
			<TR>
             <!--Neeraj added on 27 dec 2010 start -->
              <td  align="right" colspan=6> 
              <button Alt="Record History"  onclick="doShowHistory()" name="butHistory" class="bottomBarText" >&nbsp;<u>R</u>ecord History</button> 
              </td>
              <!--Neeraj added on 27 dec 2010 end -->
            </TR>
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
				<!--added by devendra start-->
				<tr>
					<td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.ptype" /></td>
                  <td colspan="1" >
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
						<html:select  property="txtPayType" name= "frmEmpFinInfoForm"  styleClass = "required" alt="txtPayType" titleKey="Payroll.EmpInfo.ptype" style="width:80%" onchange="chkVldn(); comboChange();  unchkNDsbleCCAnSCA();"   >
						<html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>    
						<logic:present name="Categories">
							<html:optionsCollection label="label" value="value" property="valuePayScale" name="Categories"/>
						</logic:present>                             
						</html:select>
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">
						<html:select  property="txtPayType" name= "frmEmpFinInfoForm"  styleClass = "required" alt="txtPayType" titleKey="Payroll.EmpInfo.ptype" style="width:80%" onchange="chkVldn(); comboChange(); fnClearFields(); unchkNDsbleCCAnSCA(); fillPayStatusChdDate();"   >
						<html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>    
						<logic:present name="Categories">
							<html:optionsCollection label="label" value="value" property="valuePayScale" name="Categories"/>
						</logic:present>                             
						</html:select>
                  </logic:equal>
                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
						<html:select  property="txtPayType" name= "frmEmpFinInfoForm"  styleClass = "required" alt="txtPayType" titleKey="Payroll.EmpInfo.ptype" style="width:80%" onchange="chkVldn(); unchkNDsbleCCAnSCA();"   >
						<html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>    
						<logic:present name="Categories">
							<html:optionsCollection label="label" value="value" property="valuePayScale" name="Categories"/>
						</logic:present>                             
						</html:select>
                  </logic:equal>
                  </td> 
                     
					<logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
					<td width="15%" class=labelText>
						<bean:message key="Payroll.EmpInfo.payRevFlag" />
					</td>
					<td>
						<html:select  property="payRevFlag" name= "frmEmpFinInfoForm"  styleClass = "locked" readonly="true" alt="payRevFlag" titleKey="Payroll.EmpInfo.payRevFlag" style="width:80%" >
							<html:option value="" >-----------Please Select-----------</html:option>
                                                        <html:option value="3" ><bean:message   key="Payroll.3Pay" /></html:option> 
							<html:option value="2"  ><bean:message   key="Payroll.2Pay" /></html:option> 
						</html:select>	
					</td>
					</logic:equal>

					<logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
					<td width="15%" class=labelText>
						<bean:message key="Payroll.EmpInfo.payRevFlag" />
					</td>
					<td>
						<html:select  property="payRevFlag" name= "frmEmpFinInfoForm"  styleClass = "locked" disabled="true" alt="payRevFlag" titleKey="Payroll.EmpInfo.payRevFlag" style="width:80%" >
							<html:option value="" >-----------Please Select-----------</html:option>
                                                        <html:option value="3" ><bean:message   key="Payroll.3Pay" /></html:option> 
							<html:option value="2"  ><bean:message   key="Payroll.2Pay" /></html:option> 
						</html:select>	
					</td>
					</logic:equal>

					<logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">
					<td width="15%" class=labelText>
						<bean:message key="Payroll.EmpInfo.payRevFlag" />
					</td>
					<td>
						<html:select  property="payRevFlag" name= "frmEmpFinInfoForm"  styleClass = "locked"  readonly="true" alt="payRevFlag" titleKey="Payroll.EmpInfo.payRevFlag" style="width:80%" >
							<html:option value="" >-----------Please Select-----------</html:option>
                                                        <html:option value="3" ><bean:message   key="Payroll.3Pay" /></html:option> 
                                                        <html:option value="2"  ><bean:message   key="Payroll.2Pay" /></html:option>
						</html:select>	
					</td>
					</logic:equal>
		<!--added by dushaynt on 20-May-2013 start-->
                     <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.prefix" /></td>
                  <td ><html:select  property="prefix" name="frmEmpFinInfoForm" titleKey="Payroll.EmpInfo.prefix" styleClass = "optional" alt="prefix" style="width:80%" onchange="checkPrefix(this.value);"  >
                  <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                  <html:option value="MR" ><bean:message key="Payroll.EmpInfo.Mr" /></html:option>
                  <html:option value="MS" ><bean:message key="Payroll.EmpInfo.Ms" /></html:option>                              
                  <html:option value="MISS" ><bean:message key="Payroll.EmpInfo.Miss" /></html:option>                              
                  <html:option value="MRS" ><bean:message key="Payroll.EmpInfo.Mrs" /></html:option>                              
                  <html:option value="DR" ><bean:message key="Payroll.EmpInfo.Dr" /></html:option>                              
                  <html:option value="COL" ><bean:message key="Payroll.EmpInfo.Col" /></html:option>                              
                  <html:option value="CAPT" ><bean:message key="Payroll.EmpInfo.Capt" /></html:option>                              
                  </html:select></td>
		<!--added by dushaynt on 20-May-2013 end-->
				</tr>
				<!--added by devendra end-->
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                                                
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" />
                  </logic:notEqual>                                                                    
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required"  />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>               
                  </td>  
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.StaffCode" /> </td>
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                  <html:text  property="txtStaffCode" altKey="Payroll.EmpInfo.StaffCode" maxlength="10" size="23" styleClass="required" />                 
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                  <html:text  property="txtStaffCode" altKey="pay.MaintainAnnualIncome.StaffCode" maxlength="10" size="23" styleClass="locked" readonly="true"/>                 
                  </logic:notEqual>
                  </td>
		  <!--Added by dushyant on 18-May-2013-->
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.OldCpfCode" /> </td>                     
                  <td>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <html:text property="txtOldCpfCode" name="frmEmpFinInfoForm" titleKey="Payroll.EmpInfo.OldCpfCode" styleClass="locked" readonly="true" style="WIDTH: 49%"  />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
                  <html:text property="txtOldCpfCode" name="frmEmpFinInfoForm" titleKey="Payroll.EmpInfo.OldCpfCode" styleClass="locked" readonly="true" style="WIDTH: 49%"  />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">
                  <html:text property="txtOldCpfCode" name="frmEmpFinInfoForm" titleKey="Payroll.EmpInfo.OldCpfCode" styleClass="locked" readonly="true" style="WIDTH: 49%"  />
                  </logic:equal>
                  </td>                  
           <!--Added by dushyant on 18-May-2013-->
              </TR> 
            
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.FirstName" /> </td>
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">                              
                  <html:text  property="txtEmpFirstName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="locked" readonly="true"/>                 
                  </logic:equal>
                  
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="U">                              
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
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">                              
                  <html:text  property="txtEmpMiddleName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="locked" readonly="true"/>                 
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="U">                              
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
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">                              
                  <html:text  property="txtEmpLastName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="50" size="23" styleClass="locked" readonly="true"/>                 
                  </logic:equal>                  
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="U">                              
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
                                                                
                  <!--commented by devendra--
				  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">  
				  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();" styleClass="locked" readonly="true"/>
                  </logic:equal>   

                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" onclick=" return ShowQryLovDsgn();">
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();checkEmpType();setPayRevChange();" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" onchange="lfnChanged(this.value);" onclick="return ShowLovDsgn();"> 
					</logic:equal>   -->


					<!--added by devendra start-->  
					<logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">  
				  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();"  onclick="return fnChkPayTYpe();" styleClass="locked" readonly="true"/>
                  </logic:equal>   
				  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" onclick=" return  ShowQryLovDsgn();">
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" titleKey="Payroll.EmpInfo.Desig" maxlength="25" size="23" onchange="chkVldn();checkEmpType();setPayRevChange();fillPayStatusChdDate(); setPayRev();" styleClass="required" readonly="true" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" onchange="lfnChanged(this.value);" onclick="return ShowLovDsgn();"> 
				  </logic:equal>
                 <!--added by devendra end-->  
                 
				  <html:hidden  property="txtDsgnDesc" altKey="Payroll.EmpInfo.txtDesig"  />                                      
                  </td>
                  
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /></TD>
                  <td align="left">                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                                                
                  <html:select property="txtCateg" name="frmEmpFinInfoForm"  titleKey="Payroll.EmpInfo.lstCateg" styleClass="required" style="WIDTH: 79%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valueCategArrayList" name="Categories"/>
                  </logic:present>
                  </html:select>              
                  </logic:equal>                                                                                                 
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <html:text  property="txtCategDesc" altKey="Payroll.EmpInfo.lstCateg" titleKey="Payroll.EmpInfo.lstCateg" maxlength="25" size="23" styleClass="locked"  readonly="true"/>                  
                  </logic:notEqual><html:hidden property="txtCateg" styleClass="locked" />
                  </td> 
                                    
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.txtCadre" /> </td>   
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <td ><html:select property="txtCadre" name="frmEmpFinInfoForm"  styleClass="optional" alt="<%=String.valueOf(i)%>"  style="WIDTH: 80%" onblur="return validateCadr()" >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valueCadreArrayList" name="Categories"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <td ><html:select property="txtCadre" name="frmEmpFinInfoForm"  styleClass="optional" alt="<%=String.valueOf(i)%>"  onchange="setWashFlag(this.value); lfnChanged(this.value)" onblur="return validateCadr()"  style="WIDTH: 80%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valueCadreArrayList" name="Categories"/>
                  </logic:present>
                  </html:select> 
                  </logic:notEqual>
                  </td>
              </tr>
              
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Section" /> </td>
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                  <html:text  property="txtSectionDesc" maxlength="20" size="23" titleKey="Payroll.EmpInfo.Section" styleClass="optional" readonly="true"/>                  
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtSection"  onclick="return ShowLovSection();">
                  </logic:equal>                                                                                                 
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                  <html:text  property="txtSectionDesc" maxlength="20" size="23" titleKey="Payroll.EmpInfo.Section" styleClass="optional"  onchange="lfnChanged(this.value)" readonly="true"/>                  
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtSection" onclick="return ShowLovSection();" readonly="true">
                  </logic:notEqual><html:hidden  property="txtSection" altKey="Payroll.EmpInfo.Section"  />
                  </td> 
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="required" onchange="checkDepuType();" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpType"  onclick="return ShowLovEmpType();">
                  </logic:equal> 
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="required" onchange="checkEmpType();checkDepuType();lfnChanged(this.value);fillPayStatusChdDate();" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" titleKey="Payroll.EmpInfo.Emptype"  name="buttxtEmpType" onclick="return ShowLovEmpType();" readonly="true">
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" onchange="lfnChanged(this.value);" readonly="true"/>
                  </logic:equal>
                  <html:hidden  property="txtEmpTypeId" altKey="Payroll.EmpInfo.Emptype"  />                  
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.parentZone" /> </td>                            
                  <td >
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
                  <html:select property="parentZone" name="frmEmpFinInfoForm" titleKey="Payroll.EmpInfo.parentZone" styleClass="optional" disabled="true"  onchange="checkParentZone(this.value);"  style="WIDTH: 80%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valueParentZoneArrayList" name="Categories"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="U">
                  <html:select property="parentZone" name="frmEmpFinInfoForm" titleKey="Payroll.EmpInfo.parentZone" styleClass="optional" alt="<%=String.valueOf(i)%>"  onchange="checkParentZone(this.value);"  style="WIDTH: 80%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valueParentZoneArrayList" name="Categories"/>
                  </logic:present>
                  </html:select>
                  </logic:notEqual>
                  </td>
              </tr>
                      
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.PF" /> </td>                            
                  <td >
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">                              
                  <html:select property="txtPFType" name="frmEmpFinInfoForm"  titleKey="Payroll.EmpInfo.PF" styleClass="required" alt="<%=String.valueOf(i)%>"  onchange="onChangePFType(this.value); lfnChanged(this.value);"  style="WIDTH:78%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valuePFTypeArrayList" name="Categories"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="N">                              
                  <html:select property="txtPFType" name="frmEmpFinInfoForm"  titleKey="Payroll.EmpInfo.PF" styleClass="optional" alt="<%=String.valueOf(i)%>"  onchange="" disabled="true" style="WIDTH:78%" >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valuePFTypeArrayList" name="Categories"/>
                  </logic:present>
                  </html:select>
                  </logic:notEqual>
                  </td>
                  
                  <td id="cpf" class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td id="gpf"  class=labelText  ><bean:message key="Payroll.EmpInfo.GpfCode" /> </td>
            <!--Added by dushyant on 15-May-2013 for cpf code TEMP-->
                  <td>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                     
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="6" size="23" readonly="true" styleClass="required" style="text-align:right" onchange="checkCPFLength(this.value);"/>
                  </logic:equal>
				   <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="Q"> 
				     <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">
					     <html:text  property="txtCpfCode" value='TEMP' altKey="pay.EmpInfo.CpfCode" maxlength="6" size="23" readonly="true" styleClass="locked" style="text-align:right" onkeypress="
					   if(document.all.txtPFType.value!='PFTYPE$GPF'){
					   if((event.keyCode < 48 || event.keyCode > 57))
						{                     
						  return false;
						}                 
						};"                            
						onchange="checkCPFLength(this.value); lfnChanged(this.value);" /> 
					  </logic:equal>
                   <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="N">
					  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="6" size="23" readonly="true" styleClass="required" style="text-align:right" onkeypress="
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
            <!--Added by dushyant on 15-May-2013 for cpf code TEMP-->

                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">                                                
                  <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" readonly="true" styleClass="optional" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtPresentPOP" >
                  </logic:equal>                                                                                                 
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="U">
                  <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" readonly="true" styleClass="required" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtPresentPOP" onclick="return ShowLovEmpLoc();">
                  </logic:notEqual><html:hidden  property="txtPresentPOP" altKey="Payroll.EmpInfo.txtPresentPOP"  />                                      
                  </td>
              </tr>                   
              
              <tr>
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.dojFCI" /> </td>            
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <html:text  property="txtDojFCI" altKey="Payroll.EmpInfo.dojFCI" titleKey="Payroll.EmpInfo.dojFCI" maxlength="15" size="23" onchange="fillDOJPP(this.value);" readonly="true" styleClass="optional" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDojFCI" alt="<%=(i-1) %>" />
                  </logic:equal>
                   <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
                  <html:text  property="txtDojFCI" altKey="Payroll.EmpInfo.dojFCI" titleKey="Payroll.EmpInfo.dojFCI" maxlength="15" size="23" onchange="fillDOJPP(this.value);" readonly="true" styleClass="optional" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDojFCI" alt="<%=(i-1) %>" />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">                              
                  <html:text  property="txtDojFCI" altKey="Payroll.EmpInfo.dojFCI" titleKey="Payroll.EmpInfo.dojFCI" maxlength="15" size="23" onchange="fillDOJPP(this.value);" readonly="true" styleClass="required"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDojFCI" alt="<%=(i-1) %>" onclick="showCalendar('txtDojFCI',this)" />
                  </logic:equal>
                  </td>
                                    
                  <td class=labelText ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" titleKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" readonly="true" styleClass="optional" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDojFCI" alt="<%=(i-1) %>" />
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                              
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" titleKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" onchange="checkPostDate(this.value)" readonly="true" styleClass="required"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtDOJSite" title="Calender" onclick="showCalendar('txtDOJSite',this)" />
                  </logic:notEqual>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td >
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <html:select property="txtEmpStatus" name="frmEmpFinInfoForm"  titleKey="Payroll.EmpInfo.EmpStat" styleClass="optional" style="WIDTH: 78%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valueEmpStatAllArrayList" name="Categories"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
                  <html:select property="txtEmpStatus" name="frmEmpFinInfoForm"  titleKey="Payroll.EmpInfo.EmpStat" styleClass="optional" disabled="true" style="WIDTH: 78%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valueEmpStatAllArrayList" name="Categories"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">
                  <html:select property="txtEmpStatus" name="frmEmpFinInfoForm"  titleKey="Payroll.EmpInfo.EmpStat" styleClass="required" alt="<%=String.valueOf(i)%>"  onchange="chkVldn(); enableDepuType(this.value); if(document.all.screenMode.value!='Q'){lfnChanged(this.value);}"  style="WIDTH: 78%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valueEmpStatArrayList" name="Categories"/>
                  </logic:present>
                  </html:select>
                  </logic:equal>
                  </td>
              </tr>   
              
              <tr>
                  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.depuType" /></td>
                  <td ><html:select  property="txtDepuType" name="frmEmpFinInfoForm" styleClass = "optional" alt="txtDepuType" style="width:80%" disabled="true" onchange="comboChange();"  >
                  <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                  <html:option value="I" ><bean:message key="Payroll.EmpInfo.inStation" /></html:option>
                  <html:option value="O" ><bean:message key="Payroll.EmpInfo.outStation" /></html:option>                              
                  <html:option value="N" ><bean:message key="Payroll.EmpInfo.notApplicable" /></html:option>                              
                  </html:select></td>
                 
                 <!--commented by devendra start-->
                 <!--td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.ptype" /></td>
                  <td colspan="1" >
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
                  <html:select  property="txtPayType" name= "frmEmpFinInfoForm"  styleClass = "required" alt="txtPayType" titleKey="Payroll.EmpInfo.ptype" style="width:80%" onchange="chkVldn(); comboChange();"  >
                  <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>    
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valuePayScale" name="Categories"/>
                  </logic:present>                             
                  </html:select>
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">
                  <html:select  property="txtPayType" name= "frmEmpFinInfoForm"  styleClass = "required" alt="txtPayType" titleKey="Payroll.EmpInfo.ptype" style="width:80%" onchange="chkVldn(); comboChange();"  >
                  <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>    
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valuePayScale" name="Categories"/>
                  </logic:present>                             
                  </html:select>
                  </logic:equal>
                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <html:select  property="txtPayType" name= "frmEmpFinInfoForm"  styleClass = "required" alt="txtPayType" titleKey="Payroll.EmpInfo.ptype" style="width:80%" onchange="chkVldn();"   >
                  <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>    
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="valuePayScale" name="Categories"/>
                  </logic:present>                             
                  </html:select>
                  </logic:equal>
                  </td--> 
                   <!--commented by devendra end-->
              </tr>
            </table>     
          </tr>
            <%! int i=0,j=0; %>
            <% i = 0;j=0; %>     
      <tr height="15" >
      <td colspan="6"></td>
    </tr>                                 
  </table> 

<script language="javascript">

//added by devendra start
function fnClearFields()
{
	document.forms[0].txtDsgn.value='';
	//document.forms[0].txtPayScaleCode.value='';
	//document.forms[0].txtGradePay.value='';
	return;
}
// added by devendra end

function ShowEmpNum()
{
   frmEmpFinInfoForm.lovKey.value = "EmpFinInfo" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;
   frmEmpFinInfoForm.queryParam.value = "txtSiteID="+frmEmpFinInfoForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpFinInfoForm.hdnEmpLbrFlag.value;
   if(frmEmpFinInfoForm.screenMode.value == 'N')
   {
       //frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,lstCateg,txtDsgn";
       frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpFirstName,txtEmpMiddleName,txtEmpLastName";
       frmEmpFinInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName";
       frmEmpFinInfoForm.txtIndex.value ="";      
   }
   if(frmEmpFinInfoForm.screenMode.value == 'Q')
   {
     //frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpFirstName,txtEmpMiddleName,txtEmpLastName"; commented by devendra
     //frmEmpFinInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName"; commented by devendra
     frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpFirstName,txtEmpMiddleName,txtEmpLastName,txtCpfCode"; //added by devendra
     frmEmpFinInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName,Payroll.EmpInfo.LastName,Payroll.Common.cpfCode"; //added by devendra
	 frmEmpFinInfoForm.txtIndex.value ="";      
   }
   frmEmpFinInfoForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   return true;
}    

function ShowLovEmpLoc()
{

   frmEmpFinInfoForm.lovKey.value = "EmpInfoEmpLoc" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;   
   frmEmpFinInfoForm.txtDisplayFields.value = "txtPresentPOP,txtPresentPOPDesc,txtCityTypeHra";
   frmEmpFinInfoForm.queryParam.value = "txtSiteID="+frmEmpFinInfoForm.loginLocCode.value+" ";
   frmEmpFinInfoForm.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   frmEmpFinInfoForm.txtInputField.value =""; 
   frmEmpFinInfoForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   if(document.all.screenMode.value!='Q')
      lfnChanged(1);
   return true;
}

function ShowLovDsgn()
{   
 //  document.all.parentZone.disabled="";
 //added by devendra start
   var payScaleType = document.forms[0].txtPayType.value;
	//alert('inside ShowLovDsgn , screen mode ::::'+document.forms[0].screenMode.value);
	if(payScaleType ==null || payScaleType=="")
	{
		alert("Please select Pay Scale Type First !!!");
		return false;
	}
	

   //added by devendra end
   if(document.all.forwardedPage.value == 'FlagDet' || document.all.forwardedPage.value == 'HrDet' || document.all.forwardedPage.value == 'AddressDet')
   {
      return false; 
   }
   else 
   {
	  // alert('inside else part.....');
	   if(payScaleType=='IDA')
	   {  
			frmEmpFinInfoForm.lovKey.value = "EmpInfoDsgnIDA" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;      
	   }
		if(payScaleType=='CDA')
	   {  
			frmEmpFinInfoForm.lovKey.value = "EmpInfoDsgnCDA" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;      
	   } 
	   //frmEmpFinInfoForm.lovKey.value = "EmpInfoDsgn" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;     commented by devendra  
       frmEmpFinInfoForm.txtDisplayFields.value = "txtDsgnDesc,txtDsgn,txtCateg,txtCategDesc,tmpPayScaleCode,hdnBoardFlag,tmpPayBand,tmpGradePay";
       frmEmpFinInfoForm.txtSearchFields.value = "pay.EnqPayImg.txtDesig,pay.MaintMiscellaneousParam.category,pay.MaintPayScaleIDA.payscalecode";
	   frmEmpFinInfoForm.txtInputField.value ="txtDsgn"; 
       frmEmpFinInfoForm.txtIndex.value =""; 
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
       lfnChanged(1);
    //   chkParentZone();
       return true;
    }    
}
function setPayRev()  //added by vansh goel trainee
{
    var rCtgry = document.all.txtCateg.value;
    var rpayRevFlag;
     if((rCtgry=="EMPCTGRY$I") || (rCtgry=="EMPCTGRY$II"))
    {
       rpayRevFlag = '3';
       //document.getElementById("payRevFlag").value='3';
    }
    else
    {
       rpayRevFlag = '2';
       //document.getElementById("payRevFlag").value='2';
    }
    //alert(rpayRevFlag);
   
   //alert("payrev in js");
    //alert(document.all.payRevFlag.value);
    frmEmpFinInfoForm.payRevFlag.value = rpayRevFlag;
    document.all.txtDisplayFields.value = "payRevFlag";
   
}
// added by devendra start
function unchkNDsbleCCAnSCA()
{
	//alert('inside')
	//alert(document.all.selectCCAFlag.value+','+document.all.selectStationComp.value);
	document.all.selectCCAFlag.checked=false;
	document.all.selectStationComp.checked=false;
}
// added by devendra end

function chkParentZone()
{
  alert('h');
}

function ShowQryLovDsgn()
{
   /*//added by devendra start
   var payScaleType = document.forms[0].txtPayType.value;
	//alert('inside ShowQryLovDsgn , screen mode ::::'+document.forms[0].screenMode.value);
	if(payScaleType ==null || payScaleType=="")
	{
		alert("Please select Pay Scale Type First !!!");
		return false;
	}
   //added by devendra end
   */
   if(document.all.forwardedPage.value == 'FlagDet' || document.all.forwardedPage.value == 'HrDet' || document.all.forwardedPage.value == 'AddressDet')
   {
      return false; 
   }
   else 
   {
       frmEmpFinInfoForm.lovKey.value = "EmpInfoDsgn" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;       
       frmEmpFinInfoForm.txtDisplayFields.value = "txtDsgnDesc,txtDsgn";
       frmEmpFinInfoForm.txtSearchFields.value = "pay.EnqPayImg.txtDesig,pay.MaintMiscellaneousParam.category,pay.MaintPayScaleIDA.payscalecode";
       frmEmpFinInfoForm.txtInputField.value ="txtDsgn"; 
       frmEmpFinInfoForm.txtIndex.value =""; 
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');       
       return true;
   }      
}

function ShowLovEmpType()
{
   frmEmpFinInfoForm.lovKey.value = "EmpInfoEmpType" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;
   frmEmpFinInfoForm.txtDisplayFields.value = "txtEmpTypeId,txtEmpType";
   frmEmpFinInfoForm.txtSearchFields.value = "";
   frmEmpFinInfoForm.txtInputField.value ="txtEmpType"; 
   frmEmpFinInfoForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   if(document.all.screenMode.value!='Q')
      lfnChanged(1);
   return true;
}

function ShowLovSection()
{
   frmEmpFinInfoForm.lovKey.value = "EmpInfoSection" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;
   frmEmpFinInfoForm.txtDisplayFields.value = "txtSection,txtSectionDesc,txtDivision";   
   frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.Division";
   frmEmpFinInfoForm.txtIndex.value =""; 
   frmEmpFinInfoForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   if(document.all.screenMode.value!='Q')
      lfnChanged(1);
   return true;
}

function upper(val)
{
   val.value=val.value.toUpperCase();
}

function fillDOJPP(val)
{    
    var systDate = getSysDate();
    if(!cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
      document.all.txtDojFCI.value="";
      return false;
    }
    document.all.txtDOJSite.value=val;
	document.all.txtEpsEntDt.value=val; //added by swapnendu Dt. 20 Jan 2011
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

function checkParentZone(val)
{
 
    if(frmEmpFinInfoForm.txtCateg.value!='EMPCTGRY$I')
    {
 
        if(val==0)
        {
            alert("Parent Zone is not valid");
            document.all.parentZone.value="";
            document.all.parentZone.focus();
            return false;
        }
    }
    if(frmEmpFinInfoForm.txtCateg.value=='EMPCTGRY$I')
    { 
        if(val!=0)
        {
            alert("Parent Zone is not valid");
            document.all.parentZone.value="";
            document.all.parentZone.focus();
            return false;
        }
    }        
    if(document.all.screenMode.value!='Q')
    {
        lfnChanged(val);
    }
}

function setWashFlag(val)
{  
    if(document.all.txtCateg.value == 'EMPCTGRY$II')
    { 
      if(val == 'EMPCADR$ENGG')
      {        
        document.getElementById("hdnWashFlag").value='N';            
        document.getElementById("selectWash").checked="";
        document.getElementById("selectWash").disabled="";
      }
      else{
          document.getElementById("hdnWashFlag").value='N';            
          document.getElementById("selectWash").checked="";
          document.getElementById("selectWash").disabled="true";
      }
    }
}

function checkCadre(val)
{
    if(document.all.txtCateg.value =='EMPCTGRY$II' && val =='EMPCADR$ENGG')
    {
      document.getElementById("hdnWashFlag").value='N';            
      document.getElementById("selectWash").checked="";
      document.getElementById("selectWash").disabled="";      
    }  
    else
    {
      document.getElementById("hdnWashFlag").value='N';            
      document.getElementById("selectWash").checked="";
      document.getElementById("selectWash").disabled="true";
    }
}

//added by Swapnendu on 20 Jan 2011 Start
function validateCadr()
{
	var category = document.getElementById("txtCateg").value;
	var val = document.getElementById("txtCadre").value;
	if (category != "")
	{
		if (category == 'EMPCTGRY$I' || category == 'EMPCTGRY$II')
		{
			if (val == "" || val == 'EMPCADR$MISC')
			{
				alert("Cadre can not be selected as Miscellaneous or left Blank for Category-I & II employees");
				document.getElementById("txtCadre").focus();
				return false;
			}
		}
		if (category == 'EMPCTGRY$IV')
		{
			if (val != 'EMPCADR$MISC' && val != "" )
			{
				alert("Please select a different Cadre for Category-IV employee. ");
				document.getElementById("txtCadre").focus();
				return false;
			}
		}
	}
	else
	{
		alert("Please select Category before selecting Cadre");
		document.getElementById("txtCadre").selectedIndex=0;
		document.getElementById("txtCateg").focus();
		return false;
	}

	return true;
}
//added by Swapnendu on 20 Jan 2011 End.20-01-2011

function checkFPSLength(val)
{
   var str='';
		  if(val.length == 1)
		  {
			  if(val==0)
			  {
				  alert(str + " FPS Number can not start with '0'");
			      document.all.txtFpsNo.value="";
				  event.srcElement.focus();
			  }
		  }
		  else
		  {
			  var val = val.substr(0,1);
			  if(val==0){
				  alert(str + " FPS Number can not start with '0'");
			      document.all.txtFpsNo.value="";
				  event.srcElement.focus();
			  }
		  }
 }


</script>