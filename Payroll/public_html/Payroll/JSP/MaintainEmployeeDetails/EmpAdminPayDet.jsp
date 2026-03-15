<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
 <%! int i=0,j=0; %>
 
 <TABLE cellSpacing=0 cellPadding=0 border =0 >
              <TR>  
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText onclick="doGetTab('payDet')" > Payroll Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
              
               
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('flgDet')"> Payroll Flag Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
               
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('otrDet')"> Other Flag Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('hrDet')"> HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
               
                <td background="../INCLUDES/IMAGES/line_t.gif" width="60%">&nbsp;</td>
                
            </tr> 
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
                              <td><html:text  property="txtPayScaleCode" name= "frmEmpFinInfoForm"  altKey="Payroll.EmpInfo.pcode" maxlength="10" size="23" styleClass="locked" onchange="lfnChanged(this.value);" readonly="true"/>                                               
                              </td>    
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.curbas" /></td>
                              <td >                       
                              
                              <html:text  property="txtCurtBasic" name= "frmEmpFinInfoForm"  altKey="Payroll.EmpInfo.curbas" maxlength="14" size="23" titleKey="Payroll.EmpInfo.curbas" styleClass="required" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "  style="text-align:right" />
                                </td>                                                                                                                        
                              
                              
                              <td width="15%" class=labelText>Grade Pay</td>
                              <td >
                              <html:text  property="txtGradePay" name= "frmEmpFinInfoForm"  altKey="Payroll.EmpInfo.curbas" maxlength="6" size="23" styleClass="locked" onchange="lfnChanged(this.value);"  style="text-align:right" readonly="true"/></td>                                                                                                                        
                              
                          </tr>                
                          
                          <TR>  
						 <!--Added by dushyant on 15-May-2013 for pay status-->

                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.psatat" /></td>
                              <td colspan="1" >
                              <logic:equal property= "txtCpfCode" name= "frmEmpFinInfoForm" value="TEMP">
									<html:select property="txtPayStatus" alt="txtPayStatus" titleKey="Payroll.EmpInfo.psatat" styleClass="required" disabled="true" style="width:80%" onchange="fillPayStatusChdDate(); comboChange();" > 
								    <html:option value="I" > <bean:message key="Payroll.EmpInfo.inact" /></html:option>   
								  </html:select>
                                 </logic:equal>

                                <logic:notEqual property= "txtCpfCode" name= "frmEmpFinInfoForm" value="TEMP">
                                     <html:select property="txtPayStatus" alt="txtPayStatus" titleKey="Payroll.EmpInfo.psatat" styleClass="required" style="width:80%" onchange="fillPayStatusChdDate(); comboChange();" >
								     <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>
									 <html:option value="A" > <bean:message key="Payroll.EmpInfo.act" /></html:option>
									 <html:option value="I" > <bean:message key="Payroll.EmpInfo.inact" /></html:option>     
									 </html:select>
								</logic:notEqual>
                              </td> 
					    <!--Added by dushyant on 15-May-2013 for pay status-->
                              
                              <td  width="16%" class=labelText><bean:message key="Payroll.EmpInfo.pmode" /></td>
                              <td colspan="1" ><html:select property="txtPayMode" name= "frmEmpFinInfoForm"  alt="txtPayMode" titleKey="Payroll.EmpInfo.pmode" styleClass="required" style="width:80%" onchange="comboChange(); " >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>                                    
                              <html:option value="C" > <bean:message key="Payroll.EmpInfo.cash" /></html:option>
                              <html:option value="B" > <bean:message key="Payroll.EmpInfo.bank" /></html:option>
                              <html:option value="O" > <bean:message key="Payroll.EmpInfo.oth" /></html:option>                                                               
                              </html:select>
                              </td>
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pmodeType"/>
                              <td colspan="1" ><html:select property="txtPayModeType" name= "frmEmpFinInfoForm"  alt="txtPayModeType" titleKey="Payroll.EmpInfo.pmodeType" styleClass="required" style="width:79%" >
                              <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                              <html:option value="ECS" > <bean:message key="Payroll.EmpInfo.ECS" /></html:option>
                              <html:option value="CTI" > <bean:message key="Payroll.EmpInfo.CTI" /></html:option>                              
                              </html:select>
                              </td>
                          </tr> 
                          
                          <tr>
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.BankName" /></td>
                              <td width = "18%">
                              <html:text  property="txtBankDesc" name= "frmEmpFinInfoForm"  altKey="pay.EmpInfo.BankCode"  size="23" styleClass="locked" maxlength="4" readonly="true" />
							  <html:hidden  property="txtBankCode" name= "frmEmpFinInfoForm"  altKey="Payroll.EmpInfo.BankCode"  />                                                                                                 
                              </td>
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.BranchName" /></td>
                              <td width = "18%">
                              <html:text  property="txtBranchDesc" name= "frmEmpFinInfoForm"  altKey="pay.EmpInfo.BranchCode" size="23" styleClass="locked"  maxlength="4" readonly="true" />
                              <html:hidden name= "frmEmpFinInfoForm"   property="txtBranchCode" altKey="Payroll.EmpInfo.BranchName"  />                                                                                                 
                              </td>
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.acno" /></td>
                              <td ><html:text  property="txtBankAccNo" name= "frmEmpFinInfoForm"  styleClass = "locked" altKey="Payroll.EmpInfo.acno" maxlength="20" size="23" readonly="true"  /></td>                    
                          </tr>                                                              
                         
                          <TR>                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.pstchdate" /></td>
                              <td ><html:text  property="txtPayStsChnDate" name= "frmEmpFinInfoForm"  styleClass = "required" altKey="Payroll.EmpInfo.pstchdate" maxlength="15" size="23" onchange="checkPayStatDate(this.value); lfnChanged(this.value)" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif" width=15 height=19 align="top" title="Calender" styleClass="lov" property="butTxtPayStsChnDate" alt="<%=(i-1) %>" onclick="showCalendar('txtPayStsChnDate',this)" /></td>                            
                              
                               
                                                                                                                                        
                               
                             
                                                                                                                                                                                                                                                             
                          </tr>
                          
                          <tr>                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.inrstat" /></td>
                              <td colspan="1" >
                              <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="U">
                              <html:select property="txtInrSt" alt="txtInrSt" name= "frmEmpFinInfoForm"  titleKey="Payroll.EmpInfo.inrstat" styleClass="optional" disabled=""  style="width:79%" onchange="comboChange();">
                              <html:option value="" > <bean:message key="Payroll.pleaseSelect" /></html:option>
                              <html:option value="R" > <bean:message key="Payroll.EmpInfo.rls" /></html:option>
                              <html:option value="S" > <bean:message key="Payroll.EmpInfo.stp" /></html:option>
                              </html:select>
                              </logic:equal>
                              <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="U">
                              <html:select property="txtInrSt" alt="txtInrSt" name= "frmEmpFinInfoForm"  titleKey="Payroll.EmpInfo.inrstat" styleClass="required" style="width:79%" onchange="comboChange();"  >
                              <html:option value="" > <bean:message key="Payroll.pleaseSelect" /></html:option>
                              <html:option value="R" > <bean:message key="Payroll.EmpInfo.rls" /></html:option>
                              <html:option value="S" > <bean:message key="Payroll.EmpInfo.stp" /></html:option>
                              </html:select>
                              </logic:notEqual>
                              </td>
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.txtPanNo" /></td>
                              <td><html:text  property="txtPanNo" name= "frmEmpFinInfoForm"  styleClass = "required" altKey="Payroll.EmpInfo.txtPanNo" maxlength="10" onkeypress="
                               if((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 65 && event.keyCode <= 90) ||(event.keyCode >= 97 && event.keyCode <= 122))
                               {}
                               else
                                {
                                  return false;
                                }; 
                                lfnChanged(this.value);" onchange="upper(this);" style="text-align:Left" size="23" /> If PAN not applicable,<html:button value='Click Here'  onclick="panNA()" property="butSendInv"  />
							   </td>
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.Hra.city" /></td>
                              <td colspan="1">       
                              <html:text  property="txtCityTypeHra" name= "frmEmpFinInfoForm"  altKey="pay.EmpInfo.Hra.city" maxlength="10" size="23" styleClass="locked" readonly="true" onchange="lfnChanged(this.value);"  />                                                                                                                                       
                              </td>
                                                            
                          </tr> 
                          
                          <tr>
                            <td width="15%" class=labelText>MHS Member</td>
                              <td colspan="1">                             
                              
                              <html:select property="txtMHSTyp" name= "frmEmpFinInfoForm"  alt="txtMHSTyp" styleClass="required" style="width:79%"  onchange="lfnChanged(this.value);"  >
                              <html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>      
                              <logic:present name="Categories">
                              <html:optionsCollection label="label" value="value" property="mhsTypList" name="Categories"/>
                              </logic:present>
                              </html:select> 
                              
                              </td>
                            <td class=labelText  ><bean:message key="Payroll.EmpInfo.FpsNo" /> </td>                
                            <td>
							<logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                            <html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="6" size="23" styleClass="optional" onchange="checkFPSLength(this.value);" onkeypress="
                             if((event.keyCode < 48 || event.keyCode > 57))
                              {
                                return false;
                              };                            
                                    lfnChanged(this.value);
                               "  style="text-align:right"   />
							</logic:equal>
							<logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
								<logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="N">
									<html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="6" size="23" styleClass="optional" onchange="checkFPSLength(this.value);" onkeypress="
									 if((event.keyCode < 48 || event.keyCode > 57))
									  {
										return false;
									  };                            
											lfnChanged(this.value);
									   "  style="text-align:right"   />
								</logic:equal>
								<logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="N">
									<html:text  property="txtFpsNo" altKey="Payroll.EmpInfo.FpsNo" maxlength="6" size="23" styleClass="optional" onchange="checkFPSLength(this.value);" onclick="updateFPSno(this.value)" onkeypress="
									 if((event.keyCode < 48 || event.keyCode > 57))
									  {
										return false;
									  };                            
											lfnChanged(this.value);
									   "  style="text-align:right"   />
								</logic:notEqual>
							</logic:notEqual>
                            </td> 
                     
                            <td width="15%" class=labelText>EPS Payment</td>
                              <td colspan="1">                                                                 
                              <html:select property="txtEpsFlag" name= "frmEmpFinInfoForm"  alt="txtEpsFlag" styleClass="optional" style="width:79%"  onchange="checkEpsFlag();lfnChanged(this.value);"  >
                              <html:option value="N" >No</html:option>
                              <html:option value="Y" >Yes</html:option>
                              <html:option value="P" >Previous</html:option>

                              </html:select>
                              </td> 
                        </tr>
                        
                        <tr>
                            <td class=labelText  >Entitlement Date </td>                
                            <td>
                            <html:text  property="txtEpsEntDt" styleClass = "optional" maxlength="10"  size="23" onchange="lfnChanged(this.value)" readonly="true"/>
                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butEpsEntDt" alt="<%=(i-1) %>" onclick="showCalendar('txtEpsEntDt',this)" />
                            </td> 
                                                 
                           <td width="15%" class=labelText>EPS Separation Reason</td>
                            <td colspan="1">                                                                 
                            <html:select property="txtEpsSepRsn" name= "frmEmpFinInfoForm"  alt="txtMHSTyp" styleClass="optional" style="width:79%" disabled="" onchange="lfnChanged(this.value);"  >
                            <html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>      
                            <logic:present name="Categories">
                            <html:optionsCollection label="label" value="value" property="epsSepTypList" name="Categories"/>
                            </logic:present>
                            </html:select>                              
                           </td>
                           <td class=labelText  >EPS Separation Date </td>                
                            <td>
                            <html:text  property="txtEpsSepDt" styleClass = "optional" maxlength="10"  size="23" onchange="lfnChanged(this.value)" readonly="true"/>
                            </td> 
                            </td> 
                        </tr>
                        	<tr>
						<td class=labelText >MHS Amount </td> 
						<td>
						  <html:text  property="txtMhsAmt" name= "frmEmpFinInfoForm"   maxlength="20" size="23" onkeypress=" 
                            if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "  style="text-align:right" />
						  </td>
                          
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.classification" /> </td>                            
                  <td >
                  <html:select property="txtCasual" name="frmEmpFinInfoForm" titleKey="Payroll.EmpInfo.classification" styleClass="optional" alt="<%=String.valueOf(i)%>" style="WIDTH: 80%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="classificationList" name="Categories"/>
                  </logic:present>
                  </html:select>
                  </td>
                  <td class=labelText  >CPF Int End Dt </td>                
                            <td>
                            <html:text  property="txtCPFIntEndDt" styleClass = "optional" maxlength="10"  size="23" onchange="lfnChanged(this.value)" readonly="true"/>
                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butEpsEntDt" alt="<%=(i-1) %>" onclick="showCalendar('txtCPFIntEndDt',this)" />
                            </td> 
                <!-- <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.classification" /></TD>
                  <td align="left">                  
                  <logic:equal property= "screenMode" name= "frmEmpFinInfoForm" value="Q">                                                
                  <html:select property="txtCateg" name="frmEmpFinInfoForm"  titleKey="Payroll.EmpInfo.classification" styleClass="optional" style="WIDTH: 79%"  >
                  <html:option value="" >-----------Please Select-----------</html:option>      
                  <logic:present name="Categories">
                  <html:optionsCollection label="label" value="value" property="classificationList" name="Categories"/>
                  </logic:present>
                  </html:select>

				  <html:hidden property="txtCategDesc" styleClass="locked" /><!--added by devendra -->

                 <!-- </logic:equal>                                                                                                 
                  <logic:notEqual property= "screenMode" name= "frmEmpFinInfoForm" value="Q">
                  <html:text  property="txtCategDesc" altKey="Payroll.EmpInfo.classification" titleKey="Payroll.EmpInfo.classification" maxlength="25" size="23" styleClass="locked" readonly="true"/>
                  </logic:notEqual>
				  <html:hidden property="txtCateg" styleClass="locked" />
                  </td> -->
						    </tr> 
                    <tr>
                        <td width="15%" class=labelText>NPS Payment</td>
                              <td colspan="1">                                                                 
                              <html:select property="txtNpsFlag" name= "frmEmpFinInfoForm"  alt="txtNpsFlag" styleClass="optional" style="width:79%"  onchange="lfnChanged(this.value);"  > <!--"PranFinLoad();-->
                              <html:option value="N" >No</html:option>
                              <html:option value="Y" >Yes</html:option>
                              </html:select>                              
                              </td> 
                              <td class=labelText >Pran No </td> 
						
                              <td>
                              <html:text  property="txtPranNo" name= "frmEmpFinInfoForm"  maxlength="12" styleClass="optional"  onkeypress=" lfnChanged(this.value);" style="text-align:right" />
                               </td>
                            <td class=labelText >Member Id(EPFO)</td> 
						
                              <td>
                              <html:text  property="txtMemberId" name= "frmEmpFinInfoForm"  maxlength="12" styleClass="optional"  onkeypress=" lfnChanged(this.value);" style="text-align:right" />
                               </td>                        
                    </tr>
                        <tr ><td></td></tr>
                        <tr height = 3><td></td></tr>                          
                      </TBODY>
                    </TABLE>
                  </TD>
                </TR>                       
              </TBODY>
            </TABLE>
            </TD>
          </TR>
<!-- Tab table Row 3 starts -->
</TABLE>