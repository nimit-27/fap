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
              
               
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('flgDet')"> Payroll Flag Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
               
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText onclick="doGetTab('otrDet')"> Other Flag Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('hrDet')"> HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
               
                <td background="../INCLUDES/IMAGES/line_t.gif" width="60%">&nbsp;</td>
                
            </tr> 
            <tr height="10"><td class=userText colspan="17"></td></tr>    
            <TR height=10 >
              <TD colspan="17">
    <!-- Purchase Requisition Info Table Starts -->
                            <TABLE width="100%" cellpadding=0 cellspacing=0 border=0>
                              <TR>
                                <TD class=subHeader colspan=11> Eligibility</TD>
                              </TR>   
                              <TR>
                                <TD colspan=11 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
                              </tr>
                                  <tr>                                
                                  
                                  <TD  class=labelText  >Special Pay for Sportsmanship&nbsp; </td>
                                  <td>
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplPaySprt" onclick="cmnFlagTxtDisab('selectSplPaySprt','txtSplPaySprtAmt,txtSplPaySprtEffFrom,txtSplPaySprtEffTill,butTxtSplPaySprtEffFrom,butTxtSplPaySprtEffTill'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplPaySprt" checked = "true" onclick="cmnFlagTxtDisab('selectSplPaySprt','txtSplPaySprtAmt,txtSplPaySprtEffFrom,txtSplPaySprtEffTill,butTxtSplPaySprtEffFrom,butTxtSplPaySprtEffTill'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText colspan="2" >Sportsmanship Amount(Rs.)&nbsp;</td>
                                  <td colspan="2">
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <html:text  property="txtSplPaySprtAmt" styleClass = "locked" size="15" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <html:text  property="txtSplPaySprtAmt" styleClass ="required" maxlength="8" size="6"  onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
                                  </logic:equal>   
                                  </td>  
                                  
                                  <td class=labelText >Effective From
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <html:text  property="txtSplPaySprtEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtSplPaySprtEffFrom','txtSplPaySprtEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplPaySprtEffFrom" alt="-1" disabled="true" onclick="showCalendar('txtSplPaySprtEffFrom',this)" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <html:text  property="txtSplPaySprtEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="chkDate('txtSplPaySprtEffFrom','txtSplPaySprtEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplPaySprtEffFrom" alt="-1" onclick="showCalendar('txtSplPaySprtEffFrom',this)" />
                                  </logic:equal>   
                                  </td>
                                  <td class=labelText >Effective Till
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <html:text  property="txtSplPaySprtEffTill" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtSplPaySprtEffFrom','txtSplPaySprtEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplPaySprtEffTill" alt="-1" disabled="true" onclick="showCalendar('txtSplPaySprtEffTill',this)" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPaySprtFlag" value = "Y" > 
                                  <html:text  property="txtSplPaySprtEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="chkDate('txtSplPaySprtEffFrom','txtSplPaySprtEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplPaySprtEffTill" alt="-1" onclick="showCalendar('txtSplPaySprtEffTill',this)" />
                                  </logic:equal>   
                                  </td>
                              </tr>
                              <tr>         
                                  
                                  <TD  class=labelText  >Special Pay As Cash Allow. &nbsp;</td>
                                  <td>
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplPayCshAllow" onclick="cmnFlagTxtDisab('selectSplPayCshAllow','txtSplPayCshAllowAmt,txtSplPayCshAllowEffFrom,txtSplPayCshAllowEffTill,butTxtSplPayCshAllowEffFrom,butTxtSplPayCshAllowEffTill'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <input type="checkbox" name="selectSplPayCshAllow" checked = "true" onclick="cmnFlagTxtDisab('selectSplPayCshAllow','txtSplPayCshAllowAmt,txtSplPayCshAllowEffFrom,txtSplPayCshAllowEffTill,butTxtSplPayCshAllowEffFrom,butTxtSplPayCshAllowEffTill'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText colspan="2" >&nbsp;&nbsp;Cash Allow. Amount(Rs.)&nbsp;</td>
                                  <td colspan="2">
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplPayCshAllowAmt" styleClass = "locked"  size="15" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplPayCshAllowAmt" styleClass = "required" size="15"  maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
                                  </logic:equal>   
                                  </td>       
                                  
                                  <td class=labelText >Effective From
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplPayCshAllowEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtSplPayCshAllowEffFrom','txtSplPayCshAllowEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplPayCshAllowEffFrom" disabled="true" onclick="showCalendar('txtSplPayCshAllowEffFrom',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplPayCshAllowEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="chkDate('txtSplPayCshAllowEffFrom','txtSplPayCshAllowEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplPayCshAllowEffFrom" onclick="showCalendar('txtSplPayCshAllowEffFrom',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                                  <td class=labelText >Effective Till
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplPayCshAllowEffTill" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtSplPayCshAllowEffFrom','txtSplPayCshAllowEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplPayCshAllowEffTill" disabled="true" onclick="showCalendar('txtSplPayCshAllowEffTill',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnSplPayCshAllowFlag" value = "Y" > 
                                  <html:text  property="txtSplPayCshAllowEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="chkDate('txtSplPayCshAllowEffFrom','txtSplPayCshAllowEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtSplPayCshAllowEffTill" onclick="showCalendar('txtSplPayCshAllowEffTill',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                                  </tr>
                                  <tr>
                                  
                                  <TD  class=labelText  >Personal Pay For SFN &nbsp; </td>
                                  <td>
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <input type="checkbox" name="selectPersPaySFN" onclick="cmnFlagTxtDisab('selectPersPaySFN','txtPersPaySFNAmt,txtPersPaySFNEffFrom,txtPersPaySFNEffTill,butTxtPersPaySFNEffFrom,butTxtPersPaySFNEffTill'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <input type="checkbox" name="selectPersPaySFN" checked = "true" onclick="cmnFlagTxtDisab('selectPersPaySFN','txtPersPaySFNAmt,txtPersPaySFNEffFrom,txtPersPaySFNEffTill,butTxtPersPaySFNEffFrom,butTxtPersPaySFNEffTill'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText colspan="2" >Personal Pay Amount(Rs.)&nbsp;   </td>
                                  <td colspan="2">                         
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNAmt" styleClass = "locked" size="15" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNAmt" styleClass = "required" size="15" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText >Effective From
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtPersPaySFNEffFrom','txtPersPaySFNEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPaySFNEffFrom" disabled="true" onclick="showCalendar('txtPersPaySFNEffFrom',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="chkDate('txtPersPaySFNEffFrom','txtPersPaySFNEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPaySFNEffFrom" onclick="showCalendar('txtPersPaySFNEffFrom',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                                  <td class=labelText >Effective Till
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNEffTill" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtPersPaySFNEffFrom','txtPersPaySFNEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPaySFNEffTill" disabled="true" onclick="showCalendar('txtPersPaySFNEffTill',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPaySFNFlag" value = "Y" > 
                                  <html:text  property="txtPersPaySFNEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="chkDate('txtPersPaySFNEffFrom','txtPersPaySFNEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPaySFNEffTill" onclick="showCalendar('txtPersPaySFNEffTill',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                              </tr>     
                                  <tr> 
                                  
                                  <TD  class=labelText  >Personal Pay For Higher Qual. &nbsp;</td>
                                  <td>
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <input type="checkbox" name="selectPersPayHQua" onclick="cmnFlagTxtDisab('selectPersPayHQua','txtPersPayHQuaAmt,txtPersPayHQuaEffFrom,txtPersPayHQuaEffTill,butTxtPersPayHQuaEffFrom,butTxtPersPayHQuaEffTill'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <input type="checkbox" name="selectPersPayHQua" checked = "true" onclick="cmnFlagTxtDisab('selectPersPayHQua','txtPersPayHQuaAmt,txtPersPayHQuaEffFrom,txtPersPayHQuaEffTill,butTxtPersPayHQuaEffFrom,butTxtPersPayHQuaEffTill'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText colspan="2" >Higher Qual. Amount(Rs.)&nbsp;</td>
                                  <td colspan="2">
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHQuaAmt" styleClass = "locked" size="15" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHQuaAmt" styleClass = "required" size="15" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
                                  </logic:equal>   
                                  </td> 
                                  
                                  <td class=labelText >Effective From
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHQuaEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtPersPayHQuaEffFrom','txtPersPayHQuaEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPayHQuaEffFrom" disabled="true" onclick="showCalendar('txtPersPayHQuaEffFrom',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHQuaEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="chkDate('txtPersPayHQuaEffFrom','txtPersPayHQuaEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPayHQuaEffFrom" onclick="showCalendar('txtPersPayHQuaEffFrom',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                                  <td class=labelText >Effective Till
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHQuaEffTill" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtPersPayHQuaEffFrom','txtPersPayHQuaEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPayHQuaEffTill" disabled="true" onclick="showCalendar('txtPersPayHQuaEffTill',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHQuaEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="chkDate('txtPersPayHQuaEffFrom','txtPersPayHQuaEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPayHQuaEffTill" onclick="showCalendar('txtPersPayHQuaEffTill',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                              </tr> 
                              
                              <tr>
                                  
                                  <TD  class=labelText  >Personal Pay For Hindi Qual. &nbsp; </td> 
                                  <td>
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHndQuaFlag" value = "Y" > 
                                  <input type="checkbox" name="selectPersPayHndQua" onclick="cmnFlagTxtDisab('selectPersPayHndQua','txtPersPayHndQuaNoIncr,txtPersPayHndQuaAmt,txtPersPayHndQuaEffFrom,txtPersPayHndQuaEffTill,butTxtPersPayHndQuaEffFrom,butTxtPersPayHndQuaEffTill'); lfnChange('1');" />                                                              
                                  </logic:notEqual>                            
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHndQuaFlag" value = "Y" > 
                                  <input type="checkbox" name="selectPersPayHndQua" checked = "true" onclick="cmnFlagTxtDisab('selectPersPayHndQua','txtPersPayHndQuaNoIncr,txtPersPayHndQuaAmt,txtPersPayHndQuaEffFrom,txtPersPayHndQuaEffTill,butTxtPersPayHndQuaEffFrom,butTxtPersPayHndQuaEffTill'); lfnChange('1');" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText width="8%">No of Increment</td>
                                  <td width="7%">
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHndQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHndQuaNoIncr" styleClass = "locked" size="6" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHndQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHndQuaNoIncr" styleClass = "required" size="6" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
                                  </logic:equal>   
                                  </td>
                                  <td class=labelText width="7%">Amount(Rs.)&nbsp;</td>
                                  <td>
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHndQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHndQuaAmt" styleClass = "locked" size="6" disabled="true" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHndQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHndQuaAmt" styleClass = "required" size="6" maxlength="8" onkeypress="
                                   if((event.keyCode < 48 || event.keyCode > 57))
                                    {
                                      return false;
                                    };                            
                                          lfnChanged(this.value);
                                     "  style="text-align:right" />                                                           
                                  </logic:equal>   
                                  </td>
                                  
                                  <td class=labelText >Effective From
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHndQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHndQuaEffFrom" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtPersPayHndQuaEffFrom','txtPersPayHndQuaEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPayHndQuaEffFrom" disabled="true" onclick="showCalendar('txtPersPayHndQuaEffFrom',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHndQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHndQuaEffFrom" styleClass = "required" readonly="true"  size="18"  onchange="chkDate('txtPersPayHndQuaEffFrom','txtPersPayHndQuaEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPayHndQuaEffFrom" onclick="showCalendar('txtPersPayHndQuaEffFrom',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                                  <td class=labelText >Effective Till
                                  <logic:notEqual name= "frmEmpFinInfoForm"  property = "hdnPersPayHndQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHndQuaEffTill" styleClass = "locked" readonly="true" size="18"  onchange="chkDate('txtPersPayHndQuaEffFrom','txtPersPayHndQuaEffTill');lfnChanged(this.value)"  />
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPayHndQuaEffTill" disabled="true" onclick="showCalendar('txtPersPayHndQuaEffTill',this)" alt="-1" />
                                  </logic:notEqual> 
                                  <logic:equal name= "frmEmpFinInfoForm"  property = "hdnPersPayHndQuaFlag" value = "Y" > 
                                  <html:text  property="txtPersPayHndQuaEffTill" styleClass = "optional" readonly="true"  size="18"  onchange="chkDate('txtPersPayHndQuaEffFrom','txtPersPayHndQuaEffTill');lfnChanged(this.value)"  />                                                           
                                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butTxtPersPayHndQuaEffTill" onclick="showCalendar('txtPersPayHndQuaEffTill',this)" alt="-1" />
                                  </logic:equal>   
                                  </td>
                              </tr>
                            </TABLE>
                            
                      </TD>
            </TR>
<!-- Tab table Row 3 starts -->
      </TABLE>      
                <!-- Tab Table Ends -->
<!-- Bottom Blue Bar -->
 