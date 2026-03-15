<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.ArrayList,FCIPAY.Payroll.UTILITY.EmpFinVldnBean" %>
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

        <TABLE cellSpacing=0 cellPadding=0 border =0 >
              <TR>  
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('payDet')" > Payroll Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
              
               
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('flgDet')"> Payroll Flag Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
               
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('otrDet')"> Other Flag Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText onclick="doGetTab('hrDet')"> HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                
               
                <td background="../INCLUDES/IMAGES/line_t.gif" width="60%">&nbsp;</td>
                
            </tr> 
            <tr height="10"><td class=userText colspan="17"></td></tr>    
            <TR height=180 >
              <TD colspan="17" valign="top">
  			<!-- Detail table starts -->
                     <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>                            
                          <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.dob" /> </td>            
                          <td width="18%">
                          <html:text  property="txtDOB" maxlength="10" size="23" titleKey="Payroll.EmpInfo.dob" styleClass="required" readonly="true" onchange="cmpDOBSysDate(this.value,0); lfnChanged(this.value);" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtDOB" alt="<%=(i-1) %>" onclick="showCalendar('txtDOB',this)" />
                          </td>

                          <td  width="16%" class=labelText><bean:message key="Payroll.EmpInfo.Gender" /></td>
                          <td width="18%" colspan="1" ><html:select  property="txtGender" titleKey="Payroll.EmpInfo.Gender" styleClass = "required" style="width:81%" onchange="checkGenPrefix(this.value);" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="M" > <bean:message key="Payroll.EmpInfo.Male" /></html:option>
                          <html:option value="F" > <bean:message key="Payroll.EmpInfo.Female" /></html:option>                               
                          </html:select>
                          </td>
                          
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.MariSta" /></td>
                          <td colspan="1" ><html:select  property="txtMarStat" titleKey="Payroll.EmpInfo.MariSta" styleClass = "optional" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="M" > <bean:message key="Payroll.EmpInfo.Married" /></html:option>
                          <html:option value="S" > <bean:message key="Payroll.EmpInfo.Single" /></html:option>                               
                          </html:select>
                          </td>
                    </tr> 

                    <tr>
                     <td  width="15%" class="labelText" >
                         <logic:equal property= "txtFathHusflag" name= "frmEmpFinInfoForm" value="H">
					                <input type="radio" name="radioFathHus" value="F" onclick="FathHusFlag(this.value)"  > FATHER NAME
                         <input type="radio" name="radioFathHus" value="H" onclick="FathHusFlag(this.value)" checked="checked"  >HUSBAND NAME
					          </logic:equal>
                    
                        <logic:notEqual property= "txtFathHusflag" name= "frmEmpFinInfoForm" value="H">
					                <input type="radio" name="radioFathHus" value="F" onclick="FathHusFlag(this.value)" checked="checked"  > FATHER NAME
                         <input type="radio" name="radioFathHus" value="H" onclick="FathHusFlag(this.value)"  >HUSBAND NAME
					          </logic:notEqual>
                    
                         </td>
                         
                        <td ><html:text  property="txtFatherNam" alt="<%=String.valueOf(i) %>" maxlength="100" size="23" titleKey="Payroll.EmpInfo.FatherNam" styleClass="optional" onkeypress="                            
                        if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                          {}
                          else
                          {
                              //alert('Invalid Input' );               
                              //this.select();                                 
                              return false;                            
                          };                             
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="upper(this);" /></td>                                                                                                                        
                        
                        <td width="13%" class=labelText><bean:message key="Payroll.EmpInfo.HomTwn" /></td>
                        <td ><html:text  property="txtHomTwn" styleClass = "optional" alt="<%=String.valueOf(i) %>" maxlength="100" size="23" onkeypress="
                        if((event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122) || (event.keyCode == 44) || (event.keyCode == 32))
                          {}
                          else
                          {
                              //alert('Invalid Input' );               
                              //this.select();                                 
                              return false;                            
                          };                             
                          lfnChanged(this.value);"  style="text-align:left"  /></td>                              
                       
                        <td  width="13%" class=labelText><bean:message key="Payroll.EmpInfo.handi" /></td>
                        <td colspan="1" ><html:select  property="txtHandi" styleClass = "optional" style="width:80%" onchange="comboChange(); checkHandicap();" >                           
                        <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>                               
                        <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                        </html:select>
                        </td>
                    </tr>

                    <TR>
                        <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.handiEffDate" /> </td>            
                        <td>
                        <html:text  property="txtHandiEffDate"  maxlength="10" size="23" styleClass="Optional" onchange="checkHandicapDate(this.value); lfnChanged(this.value);" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtHandiEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtHandiEffDate',this)" />
                        </td>
                        
                        <td width="13%" class=labelText  ><bean:message key="Payroll.EmpInfo.PrvPromdate" /> </td>            
                        <td>
                        <html:text  property="txtPrvPromDate"  maxlength="10" size="23" styleClass="optional" onchange="checkPrevPromDate(this.value); lfnChanged(this.value);" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtPrvPromDate" alt="<%=(i-1) %>" onclick="showCalendar('txtPrvPromDate',this)" />
                        </td>
                        
                        <td width="13%" class=labelText  ><bean:message key="Payroll.EmpInfo.Retdate" /> </td>            
                        <td>
                        <html:text  property="txtRetireDate"  maxlength="10" size="22" styleClass="optional" onchange="lfnChanged(this.value);" readonly="true"/>
                        </td>                                         
                    </tr>                                 
                    <TR>
                        <html:hidden  property="txtHRAStat" />
                   <!--     <td width="13%" class=labelText  ><bean:message key="Payroll.EmpInfo.Hra.EffDate" /> </td>            
                        <td>
                        <html:text  property="txtHRAEffDate"  maxlength="10" size="23" styleClass="required" onchange="checkHRAEffDate(this.value); lfnChanged(this.value);" readonly="true" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtHRAEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtHRAEffDate',this)" />
                        </td>
                        <td width="13%" class=labelText  ><bean:message key="Payroll.EmpInfo.Hra.EndDate" /> </td>            
                        <td>
                        <html:text  property="txtHRAEndDate"  maxlength="10" size="23" styleClass="optional" onchange="checkHRAEndDate(this.value); lfnChanged(this.value);" readonly="true" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="txtHRAEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtHRAEffDate',this)" />
                        </td> -->
                         
                       <html:hidden  property="txtHRAEffDate" />
                       <html:hidden  property="txtHRAEndDate" />
                    </tr>   
                    <!-- addition By swati -->
                    <logic:equal property="screenName" value="MaintainEmpFinDetailScreen"  name="frmEmpFinInfoForm">
                           <TR>                            
                         <td  width="16%" class=labelText><bean:message key="Payroll.EmpInfo.casteCateg" /></td>
                          <td width="18%" colspan="1" >
                           <logic:equal property= "txtCasteCateg" name= "frmEmpFinInfoForm" value="">
                          <html:select  property="txtCasteCateg" titleKey="Payroll.EmpInfo.casteCateg" styleClass = "required" style="width:81%"onchange="comboChange(); " >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                           <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="valueCasteCategList" name="Categories"/>
                              </logic:present>
                          </html:select>
                          </logic:equal>
                          
                          <logic:notEqual property= "txtCasteCateg" name= "frmEmpFinInfoForm" value="">
                          <html:select  property="txtCasteCateg" titleKey="Payroll.EmpInfo.casteCateg" styleClass = "locked" disabled="true" style="width:81%"onchange="comboChange(); " >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                           <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="valueCasteCategList" name="Categories"/>
                              </logic:present>
                          </html:select>
                          </logic:notEqual>
                          
                          </td>
                          
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.phtype" /></td>
                          <td colspan="1" >
                          <logic:equal property= "txtHandi" name= "frmEmpFinInfoForm" value="Y">
                          
                          <logic:equal property= "txtHandiType" name= "frmEmpFinInfoForm" value="">
                            <html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                            <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>    
                               <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="Categories"/>
                              </logic:present>
                          </html:select>
                        </logic:equal>
                           
                         <logic:notEqual property= "txtHandiType" name= "frmEmpFinInfoForm" value="">
                         
                          <html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "locked" disabled="true" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>    
                           <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="Categories"/>
                              </logic:present>
                          

                          </html:select>
                           </logic:notEqual>
                           
                            </logic:equal>
                            
                             <logic:notEqual property= "txtHandi" name= "frmEmpFinInfoForm" value="Y">
                          <html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "locked" disabled="true" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                        
                          <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="Categories"/>
                              </logic:present>

                          </html:select>
                          </logic:notEqual>
                         
                            
                          </td>
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.rel" /></td>
                          <td colspan="1" >
                           <logic:equal property= "txtReligion" name= "frmEmpFinInfoForm" value="">
                          <html:select  property="txtReligion" titleKey="Payroll.EmpInfo.rel" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>                                 
                            <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="valueReligionList" name="Categories"/>
                              </logic:present>
                          </html:select>
                          </logic:equal>
                          
                         <logic:notEqual property= "txtReligion" name= "frmEmpFinInfoForm" value="">
                          <html:select  property="txtReligion" titleKey="Payroll.EmpInfo.rel" styleClass = "locked" disabled="true" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>                                 
                            <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="valueReligionList" name="Categories"/>
                              </logic:present>
                          </html:select>
                          </logic:notEqual>
                           
                          
                    </tr>
                    
                     <TR>                            
                         
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.exsrvc" /></td>
                          <td colspan="1" >
                           <logic:equal property= "txtExsrvcman" name= "frmEmpFinInfoForm" value="">
                          <html:select  property="txtExsrvcman" titleKey="Payroll.EmpInfo.exsrvc" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                          <html:option value="N" > <bean:message key="Payroll.EmpInfo.No" /></html:option>   
                                                      
                          </html:select>
                          </logic:equal>
                          
                          <logic:notEqual property= "txtExsrvcman" name= "frmEmpFinInfoForm" value="">
                          <html:select  property="txtExsrvcman" titleKey="Payroll.EmpInfo.exsrvc" styleClass = "locked" disabled="true" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                          <html:option value="N" > <bean:message key="Payroll.EmpInfo.No" /></html:option>   
                                                      
                          </html:select>
                          </logic:notEqual>
                          </td>
                          
                        <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.aadhar" /></td>
                        <td >
                        <logic:equal property= "txtAadharNum" name= "frmEmpFinInfoForm" value="">
                        <html:text  property="txtAadharNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.aadhar" styleClass="optional" onkeypress="                            
                             if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                       
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="chkAadharNum(this.value);lfnChanged(this.value);" />
                     </logic:equal>
                     
                     <logic:notEqual property= "txtAadharNum" name= "frmEmpFinInfoForm" value="">
                        <html:text  property="txtAadharNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.aadhar" styleClass="locked" readonly="true" style="text-align:left"   />
                     </logic:notEqual>
                     </td>   
                     <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.uan" /></td>
                        <td >
                         <logic:equal property= "txtUanNum" name= "frmEmpFinInfoForm" value="">
                        <html:text  property="txtUanNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.uan" styleClass="optional" onkeypress="                            
                             if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                        
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="chkUANum(this.value);lfnChanged(this.value);" />
                      </logic:equal>
                      
                      <logic:notEqual property= "txtUanNum" name= "frmEmpFinInfoForm" value="">
                        <html:text  property="txtUanNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.uan" styleClass="locked" readonly="true"  style="text-align:left"   />
                      </logic:notEqual>
                      
                     </td>   
                     </tr>
                     <tr>
                
                     <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pension" /></td>
                        <td >
                         <logic:equal property= "txtPenNum" name= "frmEmpFinInfoForm" value="">
                        <html:text  property="txtPenNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.pension" styleClass="optional" onkeypress="                            
                             if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                        
                          lfnChanged(this.value);
                     "  style="text-align:left" onchange="lfnChanged(this.value);" />
                      </logic:equal>
                      
                      <logic:notEqual property= "txtPenNum" name= "frmEmpFinInfoForm" value="">
                        <html:text  property="txtPenNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.pension" styleClass="locked" readonly="true"  style="text-align:left"   />
                      </logic:notEqual>
                     </td>   
                       <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.txtPenFlag" /> </td>                            
                        <td ><html:select property="txtPenFlag" name="frmEmpFinInfoForm"  styleClass="locked" disabled="true" alt="<%=String.valueOf(i)%>"  onchange="return lfnChanged(this.value)" style="WIDTH: 80%"  >
                        <html:option value="" >-----------Please Select-----------</html:option>      
                        <logic:present name="Categories">
                        <html:optionsCollection label="label" value="value" property="valuePenFlagArrayList" name="Categories"/>
                        </logic:present>
                        </html:select>
                        </td>
                    </tr> 

                    </logic:equal>
                  
                   <logic:notEqual property="screenName" value="MaintainEmpFinDetailScreen"  name="frmEmpFinInfoForm">
                           <TR>                            
                         <td  width="16%" class=labelText><bean:message key="Payroll.EmpInfo.casteCateg" /></td>
                          <td width="18%" colspan="1" ><html:select  property="txtCasteCateg" titleKey="Payroll.EmpInfo.casteCateg" styleClass = "required" style="width:81%"onchange="comboChange(); " >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                           <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="valueCasteCategList" name="Categories"/>
                              </logic:present>
                          </html:select>
                          </td>
                          
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.phtype" /></td>
                          <td colspan="1" >
                       
                          
                          <html:select  property="txtHandiType" titleKey="Payroll.EmpInfo.phtype" styleClass = "optional" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>    
                           <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="valueHandiTypeList" name="Categories"/>
                          </logic:present>
                        
                          </html:select>
                                      
                          </td>
                          
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.rel" /></td>
                          <td colspan="1" ><html:select  property="txtReligion" titleKey="Payroll.EmpInfo.rel" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>                                 
                            <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="valueReligionList" name="Categories"/>
                              </logic:present>
                          </html:select>
                         </ 
                          
                    </tr>
                    
                     <TR>                            
                         
                          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.exsrvc" /></td>
                          <td colspan="1" ><html:select  property="txtExsrvcman" titleKey="Payroll.EmpInfo.exsrvc" styleClass = "required" style="width:80%" onchange="comboChange();" >                             
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
                          <html:option value="N" > <bean:message key="Payroll.EmpInfo.No" /></html:option>   
                                                      
                          </html:select>
                          </td>
                          
                        <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.aadhar" /></td>
                        <td ><html:text  property="txtAadharNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.aadhar" styleClass="optional" onkeypress="                            
                             if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                       
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="chkAadharNum(this.value);" /></td>   
                     <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.uan" /></td>
                        <td ><html:text  property="txtUanNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.uan" styleClass="optional" onkeypress="                            
                             if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                        
                          lfnChanged(this.value);
                     "  style="text-align:left"  onchange="chkUANum(this.value);" /></td>   
                     
                     
                    </tr>
                    <tr>
                       <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pension" /></td>
                        <td ><html:text  property="txtPenNum" alt="<%=String.valueOf(i) %>" maxlength="12" size="23" titleKey="Payroll.EmpInfo.pension" styleClass="optional" onkeypress="                            
                             if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                        
                          lfnChanged(this.value);
                     "  style="text-align:left"  />
                       </td>
                       
                             <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.txtPenFlag" /> </td>                            
                        <td ><html:select property="txtPenFlag" name="frmEmpFinInfoForm"  styleClass="locked" disabled="true" alt="<%=String.valueOf(i)%>"  onchange="return lfnChanged(this.value)" style="WIDTH: 80%"  >
                        <html:option value="" >-----------Please Select-----------</html:option>      
                        <logic:present name="Categories">
                        <html:optionsCollection label="label" value="value" property="valuePenFlagArrayList" name="Categories"/>
                        </logic:present>
                        </html:select>
                        </td>
                       
                    </TR>
                  
                    </logic:notEqual>

                    
                  
                  
                    <tr height = 3><td></td></tr>                    
                  </TBODY>
                </TABLE>
</TD>
            </TR>
<!-- Tab table Row 3 starts -->
      </TABLE>