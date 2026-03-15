<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
        <TABLE cellSpacing=0 cellPadding=0 border =0 >
              <TR>  
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('payDet')" > Payroll Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
              
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText onclick="doGetTab('flgDet')"> Payroll Flag Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
               
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('otrDet')"> Other Flag Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('hrDet')"> HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td background="../INCLUDES/IMAGES/line_t.gif" width="60%">&nbsp;</td>
                
            </tr> 
            <tr height="10"><td class=userText colspan="17"></td></tr>    
            <TR height=10 >
              <TD colspan="17">
                    <!-- Detail table starts -->
                    <TABLE cellSpacing=0 cellPadding=0 border=0 >
                      <TR>
                        <TD class=subHeader colspan=17> Eligibility</TD>
                      </TR>   
                      <TR>
                        <TD colspan=17 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
                      </tr> 
                    
                        <TR>
                            <TD width = 15% class=labelText>Washing Allowance</td>
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnWashFlag" value = "Y" > 
                                <td width = 5%><input type="checkbox" Id="selectWash" onclick="onclickCheck('selectWash',document.all.hdnWashFlag);" /></TD>                                              
                            </logic:notEqual>    
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnWashFlag" value = "Y" > 
                                <td width = 5%><input type="checkbox" Id="selectWash" checked = "true" onclick="onclickCheck('selectWash',document.all.hdnWashFlag);" /></TD>
                            </logic:equal> 
                            <td width = 3%></td>
                            <TD width = 15% class=labelText>NPA</td>
                                <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnNpaFlag" value = "Y"  > 
                                <td width = 5%><input type="checkbox" Id="selectNpa" onclick="lfnChange('1');" /></TD>                                                               
                                </logic:notEqual>                            
                                <logic:equal name= "frmEmpFinInfoForm"  property = "hdnNpaFlag" value = "Y" > 
                                <td width = 5%><input type="checkbox" Id="selectNpa" checked = "true" onclick="lfnChange('1');" /></TD>                                                               
                                </logic:equal>    
                            <td width = 3%></td>
                            <TD width = 15% class=labelText>Lunch Subsidy</td>
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnCantFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectCant" onclick="lfnChange('1');" /></TD>                                                               
                            </logic:notEqual>                          
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnCantFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectCant" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                            </logic:equal>             
                            <td width = 3%></td>
                            <TD width = 15% class=labelText><bean:message  key="Payroll.EmpInfo.Cca" /></td>                
                                <td width = 5%>
                                    <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnCCAFlag" value = "Y" > 
                                            <input type="checkbox" Id="selectCCAFlag" onclick="onclickCheck('selectCCAFlag',document.all.hdnCCAFlag);"  />
                                    </logic:notEqual>                            
                                    <logic:equal name= "frmEmpFinInfoForm"  property = "hdnCCAFlag" value = "Y" >     
                                            <!--input type="checkbox" Id="selectCCAFlag" checked = "true" /--> <!--commented by devendra on 17th aug 2010-->
                                            <input type="checkbox" Id="selectCCAFlag" /> <!--added by devendra on 17th aug 2010-->
                                    </logic:equal>   
                                </td>
                            <td width = 3%>   </td>      
                        </TR>    
                        <TR>
                            <TD width = 15% class=labelText>Station Compensatory Allowance</td> 
                                                        <td width = 5%>
                                                                <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnStationCompFlag" value = "Y" > 
                                                                        <input type="checkbox" Id="selectStationComp" onclick="lfnChange('1');" />											   
                                                                </logic:notEqual>
                                                                <logic:equal name= "frmEmpFinInfoForm"  property = "hdnStationCompFlag" value = "Y" > 
                                                                        <input type="checkbox" Id="selectStationComp" />
                                                                </logic:equal>
                                                        </TD>
                            <td width = 3%></td>
    
                            <TD width = 15% class=labelText>Dusting Operator Allowance</td>
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnDustOpAllowFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectDustOpAllow" onclick="lfnChange('1');" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnDustOpAllowFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectDustOpAllow" checked = "true" onclick="lfnChange('1');"  /></TD>                                                               
                            </logic:equal>          
                            
                            <td width = 3%></td>
                            
                            <TD width = 15% class=labelText>Productivity Link Incentive</td>                             
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPLIFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectPLI" onclick="lfnChange('1');" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPLIFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectPLI" checked = "true"  onclick="lfnChange('1');" /></TD>                                                               
                            </logic:equal>    
                            
                            <td width = 3%>   </td>
                            
                            <TD width = 15% class=labelText><bean:message  key="Payroll.EmpInfo.ConvFlg" /></td>
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnConvFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectConvFlag" onclick="onclickCheck('selectConvFlag',document.all.hdnConvFlag);" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnConvFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectConvFlag" checked = "true" onclick="onclickCheck('selectConvFlag',document.all.hdnConvFlag);"  /></TD                                                               
                            </logic:equal>    
                        </TR>
                        <TR>
                            <TD width = 15% class=labelText>Operational Allowance</td>
                            <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnOpAllowFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectOpAllowFlag" onclick="onclickCheck('selectOpAllowFlag',document.all.hdnOpAllowFlag);" /></TD>                                                               
                            </logic:notEqual>                            
                            <logic:equal name= "frmEmpFinInfoForm"  property = "hdnOpAllowFlag" value = "Y" > 
                            <td width = 5%><input type="checkbox" Id="selectOpAllowFlag" checked = "true" onclick="onclickCheck('selectOpAllowFlag',document.all.hdnOpAllowFlag);"  /></TD>                                                               
                            </logic:equal>    
                            
                            <td width = 3%>
    
                            <TD width = 15% class=labelText></td>
                            <td width = 5%></TD>                                                               
                            
                            <td width = 3%>
                            
                            <TD width = 15% class=labelText></td>                             
                            <td width = 5%></TD> 
                            
                            <td width = 3%>   
                            
                            <TD width = 15% class=labelText></td>
                            <td width = 5%></TD>    
                            
                            <td width = 3%>
                        </TR>          
                        <TR>   
                                  <TD  class=labelText >Double HRA&nbsp;</td>
                                  <td >
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <input type="checkbox" name="selectDblHraFlag" disabled="disabled" onclick="cmnFlagTxtDisab('selectDblHraFlag','txtDblHraCity,buttxtDblHraCity,txtDblHraEffFrom,txtDblHraEffTill,butTxtDblHraEffFrom,butTxtDblHraEffTill'); " />                                                               
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <input type="checkbox" name="selectDblHraFlag" checked = "true" onclick="cmnFlagTxtDisab('selectDblHraFlag','txtDblHraCity,buttxtDblHraCity,txtDblHraEffFrom,txtDblHraEffTill,butTxtDblHraEffFrom,butTxtDblHraEffTill');"  />                                                             
                                  </logic:equal>    
                                  </td>
                                  
                                  <td class=labelText colspan="3">Double HRA City
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <html:text  property="txtDblHraCity" styleClass = "locked" readonly="true" size="15"  onchange="lfnChange(this.value)"  />
                                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDblHraCity" id="buttxtDblHraCity" onclick="return ShowLovDblHraCityCode();">                                
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <html:text  property="txtDblHraCity" styleClass = "required" readonly="true"  size="15"  onchange="lfnChange(this.value)"  />                                                           
                                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDblHraCity" id="buttxtDblHraCity" onclick="return ShowLovDblHraCityCode();">                                
                                  </logic:equal>   
                                  </td>
                       
                                 <td class=labelText colspan="3" >Effective From
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <html:text  property="txtDblHraEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtDblHraEffFrom','txtDblHraEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtDblHraEffFrom" disabled="true" onclick="showCalendar('txtDblHraEffFrom',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <html:text  property="txtDblHraEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="chkDate('txtDblHraEffFrom','txtDblHraEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtDblHraEffFrom" onclick="showCalendar('txtDblHraEffFrom',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                                  <td class=labelText colspan="3" >Effective Till
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <html:text  property="txtDblHraEffTill" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtDblHraEffFrom','txtDblHraEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtDblHraEffTill" disabled="true" onclick="showCalendar('txtDblHraEffTill',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnDblHraFlag" value = "Y" > 
                                  <html:text  property="txtDblHraEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="chkDate('txtDblHraEffFrom','txtDblHraEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtDblHraEffTill" onclick="showCalendar('txtDblHraEffTill',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                            </TR>
                        <TR>         
                              <TD  class=labelText  >Spl. Comp. Allow. &nbsp;</td>
                              <td>
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplCmpAllow" onclick="cmnFlagTxtDisab('selectSplCmpAllow','txtSplCmpAllowAmt,txtSplCmpAllowEffFrom,txtSplCmpAllowEffTill,butTxtSplCmpAllowEffFrom,butTxtSplCmpAllowEffTill'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplCmpAllow" checked = "true" onclick="cmnFlagTxtDisab('selectSplCmpAllow','txtSplCmpAllowAmt,txtSplCmpAllowEffFrom,txtSplCmpAllowEffTill,butTxtSplCmpAllowEffFrom,butTxtSplCmpAllowEffTill'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                              </td> 
                              
                              <td class=labelText colspan="3" >Allow. Type &nbsp; 
                                   <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                      <html:select property="txtSplCmpAllowAmt" alt="txtSplCmpAllowAmt" styleClass="optional" style='width:60%' disabled="true" onchange="comboChange();"  >
                                      <html:option value="" >------Please Select------</html:option>      
                                      <logic:present name="Categories">
                                        <html:optionsCollection label="label" value="value" property="valueSplCompArrayList" name="Categories"/>
                                      </logic:present>
                                      </html:select>
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                                      <html:select property="txtSplCmpAllowAmt" alt="txtSplCmpAllowAmt" styleClass="required" style='width:60%'  onchange="comboChange();"  >
                                      <html:option value="" >------Please Select------</html:option>      
                                      <logic:present name="Categories">
                                          <html:optionsCollection label="label" value="value" property="valueSplCompArrayList" name="Categories"/>
                                      </logic:present>
                                      </html:select>
                                  </logic:equal>
                              </td>
                            
                              <td class=labelText colspan="3">Effective From
                              <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                              <html:text  property="txtSplCmpAllowEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtSplCmpAllowEffFrom','txtSplCmpAllowEffTill');lfnChanged(this.value)"  />
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplCmpAllowEffFrom" disabled="true" onclick="showCalendar('txtSplCmpAllowEffFrom',this)" alt="-1" />
                              </logic:notEqual> 
                              <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                              <html:text  property="txtSplCmpAllowEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="chkDate('txtSplCmpAllowEffFrom','txtSplCmpAllowEffTill');lfnChanged(this.value)"  />                                                           
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplCmpAllowEffFrom" onclick="showCalendar('txtSplCmpAllowEffFrom',this)" alt="-1" />
                              </logic:equal>   
                              </td>
                              <td class=labelText colspan="3" >Effective Till
                              <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                              <html:text  property="txtSplCmpAllowEffTill" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtSplCmpAllowEffFrom','txtSplCmpAllowEffTill');lfnChanged(this.value)"  />
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplCmpAllowEffTill" disabled="true" onclick="showCalendar('txtSplCmpAllowEffTill',this)" alt="-1" />
                              </logic:notEqual> 
                              <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplCmpAllowFlag" value = "Y" > 
                              <html:text  property="txtSplCmpAllowEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="chkDate('txtSplCmpAllowEffFrom','txtSplCmpAllowEffTill');lfnChanged(this.value)"  />                                                           
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplCmpAllowEffTill" onclick="showCalendar('txtSplCmpAllowEffTill',this)" alt="-1" />
                              </logic:equal>   
                              </td>      
                        </TR>
                        <TR>         
                              <TD  class=labelText  >Spl. Duty. Allow. &nbsp;</td>
                              <td>
                                <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                              <input type="checkbox" name="selectSplDtyAllow" onclick="cmnFlagTxtDisab('selectSplDtyAllow','txtSplDtyAllowArea,txtSplDtyAllowEffFrom,txtSplDtyAllowEffTill,butTxtSplDtyAllowEffFrom,butTxtSplDtyAllowEffTill'); lfnChange('1');" />                                                              
                              </logic:notEqual>                            
                                <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                <input type="checkbox" name="selectSplDtyAllow" checked = "true" onclick="cmnFlagTxtDisab('selectSplDtyAllow','txtSplDtyAllowArea,txtSplDtyAllowEffFrom,txtSplDtyAllowEffTill,butTxtSplDtyAllowEffFrom,butTxtSplDtyAllowEffTill'); lfnChange('1');" />                                                           
                              </logic:equal>   
                              </td> 
                              
                              <td class=labelText colspan="3" >Area Type &nbsp; 
                              <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:select property="txtSplDtyAllowArea" alt="txtSplDtyAllowArea" styleClass="optional" style='width:60%' disabled="true" onchange="comboChange();"  >
                                  <html:option value="" >------Please Select------</html:option>      
                                  <logic:present name="Categories">
                                    <html:optionsCollection label="label" value="value" property="splDtyAreaList" name="Categories"/>
                                  </logic:present>
                                  </html:select>
                              </logic:notEqual> 
                              <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:select property="txtSplDtyAllowArea" alt="txtSplDtyAllowArea" styleClass="required" style='width:60%'  onchange="comboChange();"  >
                                  <html:option value="" >------Please Select------</html:option>      
                                  <logic:present name="Categories">
                                  <html:optionsCollection label="label" value="value" property="splDtyAreaList" name="Categories"/>
                                  </logic:present>
                                  </html:select>
                              </logic:equal>
                              </td>
                              <td class=labelText colspan="3">Effective From
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplDtyAllowEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtSplDtyAllowEffFrom','txtSplDtyAllowEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplDtyAllowEffFrom" disabled="true" onclick="showCalendar('txtSplDtyAllowEffFrom',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplDtyAllowEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="chkDate('txtSplDtyAllowEffFrom','txtSplDtyAllowEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplDtyAllowEffFrom" onclick="showCalendar('txtSplDtyAllowEffFrom',this)" alt="-1" />
                                  </logic:equal>   
                              </td>
                              <td class=labelText colspan="3" >Effective Till
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplDtyAllowEffTill" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtSplDtyAllowEffFrom','txtSplDtyAllowEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplDtyAllowEffTill" disabled="true" onclick="showCalendar('txtSplDtyAllowEffTill',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplDtyAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplDtyAllowEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="chkDate('txtSplDtyAllowEffFrom','txtSplDtyAllowEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplDtyAllowEffTill" onclick="showCalendar('txtSplDtyAllowEffTill',this)" alt="-1" />
                                  </logic:equal>   
                              </td>      
                         </TR>
                    </TABLE>
              </TD>
            </TR>
<!-- Tab table Row 3 starts -->
      </TABLE>
    
 