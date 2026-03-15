<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%! int i=0,j=0; %>
 
 <TABLE cellspacing="0" cellPadding="0" >
  <TR>
    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
    <td bgcolor="#4682B4" nowrap class=actTabText onclick="doGetTab('AnnuProSel')">Annuity Provider Selection<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></img></td>
    
    <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="N">  
    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
    <td bgcolor="#76A2C7" nowrap class=actTabText>Annuity Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></img></td>
    </logic:equal>  
    <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="N">
    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
    <td bgcolor="#76A2C7" nowrap class=actTabText onclick="doGetTab('AnnuDel')">Annuity Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></img></td>
    </logic:notEqual>
    
    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
</TR>

<tr height="10"><td class=userText colspan="14"></td></tr>            
<TR height=10>
<!-- Detail table Container starts -->
<TD colspan=14>
  <TABLE cellSpacing=0 cellPadding=0 border=0>
    <TBODY>
      <TR>
        <TD >
            <!-- Detail table starts -->
         <TABLE cellSpacing=0 cellPadding=0 border=0>
          <TBODY>
           <tr>
             <td width="23%" class=labelText></td>
             <td width="23%" class=labelText></td>
             <td width="23%" class=labelText></td>
             <td align="left">
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="N">
              <html:button style="width:142px" value="Get Payment Details " property="butGetDetail" onclick="getFinalDetails()" />
              </logic:equal> 
             </td>
           </tr>
           
           <tr>
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.AnnuitySubDt" /></TD>
              <td align="left" colspan="1">
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="N">  
              <html:text  property="txtAnnuSubDt" altKey="Payroll.PensionFinal.AnnuitySubDt" maxlength="25" size="23" styleClass="required" readonly="true" />
              <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="txtAnnuSubDt" alt="<%=(i-1) %>" onclick="showCalendar('txtAnnuSubDt',this)" />                                         
              </logic:equal> 
              <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="N">
              <html:text  property="txtAnnuSubDt" altKey="Payroll.PensionFinal.AnnuitySubDt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </logic:notEqual>
              </td>
              
              <td width="27%" class=labelText><bean:message key="Payroll.PensionFinal.EmployeeCon" /></td>
              <td><html:text  property="empContri" styleClass = "locked" alt="" maxlength="50" size="23" style="text-align:left" readonly="true"/>
              </td>  
            </tr>
            
            <tr>
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.SanctionOrderNo" /></TD>
              <td align="left" colspan="1">
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="N">  
              <html:text  property="sancOrderNo" altKey="Payroll.PensionFinal.SanctionOrderNo" maxlength="25" size="23" styleClass="required" />                                         
              </logic:equal> 
              <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="N">
              <html:text  property="sancOrderNo" altKey="Payroll.PensionFinal.SanctionOrderNo" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </logic:notEqual>
              </td>
              <!--<TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.InvNum" /></TD>
              <td align="left" colspan="1">
              <html:text  property="txtInvID" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </td>-->
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.EmployerCon" /></TD>
              <td align="left" colspan="1">
              <html:text  property="emplyrContri" altKey="Payroll.PensionFinal.EmployerCon" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </td>
            </tr>
            
            <TR>                          
              <td width="20%" class=labelText><bean:message key="Payroll.PensionFinal.AnnuityProv" /></td>
              <td >
              <logic:equal name="frmPensionFinalSett" property="screenMode" value="N">
                  <html:select style="width:145px" property="txtAnnuityProv" alt="" titleKey="" styleClass="required" >
                    <html:option value="" >&nbsp;&nbsp;---Select Annutiy---</html:option>
                    <html:option value="LIC">Life Insurance Corporation Co. Ltd.</html:option>
                    <html:option value="SBI">SBI Life Insurance Co. Ltd.</html:option>
                    <html:option value="HDFC">HDFC Standard Life Insurance Corporation Co. Ltd.</html:option>
                    <html:option value="ICICI">ICICI Prudential Life Insurance Co. Ltd.</html:option>
                    <html:option value="BAJAJ">Bajaj Allianz Life Insurance Co. Ltd.</html:option>
                    <html:option value="BIRLA">Birla Sun Life Insurance Co. Ltd.</html:option>
                    <html:option value="STARUNION">Star Union Dai-ichi Life Insurance Co. Ltd.</html:option>
                    <html:option value="RELIANCE">Reliance Life Insurance Co. Ltd.</html:option>
                  </html:select>
              </logic:equal>
              <logic:notEqual name="frmPensionFinalSett" property="screenMode" value="N">
                  <html:text style="width:145px" property="txtAnnuityProv" alt="" titleKey="" styleClass="locked" readonly="true"/>
              </logic:notEqual>
              </td>                                                   
              
              <td width="23%" class=labelText><bean:message key="Payroll.PensionFinal.VPFCon" /></td>
              <td >
              <html:text  property="txtVPFCont" styleClass = "locked" alt="" maxlength="50" size="23" style="text-align:left" readonly="true" />                                                        
              </td>
            </tr>
            <tr>                      
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.PensionType" /></TD>
              <td align="left" colspan="1">
              <logic:equal name="frmPensionFinalSett" property="screenMode" value="N">
                  <html:select style="width:145px" property="txtPensionType" alt="Payroll.PensionFinal.PensionType" titleKey="" styleClass="required" >
                    <html:option value="" >&nbsp;&nbsp;---Select---</html:option>
                    <html:option value="AFL">Annuity for life</html:option>
                    <html:option value="ROC">Annuity for life with return of Capital</html:option>
                    <html:option value="AFL5Y">Annuity for 5 years certain & Life thereafter</html:option>
                    <html:option value="AFL10Y">Annuity for 10 years certain & Life thereafter</html:option>
                    <html:option value="AFL15Y">Annuity for 15 years certain & Life thereafter</html:option>
                    <html:option value="AFL20Y">Annuity for 20 years certain & Life thereafter</html:option>
                    <html:option value="AFL3P">Annuity for life increasing at a simplest rate of 3% p. a.</html:option>
                    <html:option value="AFL50AP">Annuity for life with a provision for 50% of the annuity payable to the spouse on death of the annuitant</html:option>
                    <html:option value="AFL100AP">Annuity for life with a provision for 100% of the annuity payable to the spouse on death of the annuitant</html:option>
                    <html:option value="AFL100APWRP">Annuity for life with a provision for 100% of the annuity payable to the spouse on death of the annuitant with return of purchase price on death of last annuitant</html:option>                    
                  </html:select>
              </logic:equal>
              <logic:notEqual name="frmPensionFinalSett" property="screenMode" value="N">
                  <html:text style="width:145px" property="txtPensionType" alt="Payroll.PensionFinal.PensionType" titleKey="" styleClass="locked" readonly="true"/>
                  <%--<html:select style="width:145px" property="txtPensionType" alt="Payroll.PensionFinal.PensionType" titleKey="" styleClass="locked" disabled="true"  readonly="true">
                    <html:option value="" >&nbsp;&nbsp;---Select---</html:option>
                    <html:option value="AFL">Annuity for life</html:option>
                    <html:option value="ROC">Annuity for life with return of Capital</html:option>
                    <html:option value="AFL5Y">Annuity for 5 years certain & Life thereafter</html:option>
                    <html:option value="AFL10Y">Annuity for 10 years certain & Life thereafter</html:option>
                    <html:option value="AFL15Y">Annuity for 15 years certain & Life thereafter</html:option>
                    <html:option value="AFL20Y">Annuity for 20 years certain & Life thereafter</html:option>
                    <html:option value="AFL3P">Annuity for life increasing at a simplest rate of 3% p. a.</html:option>
                    <html:option value="AFL50AP">Annuity for life with a provision for 50% of the annuity payable to the spouse on death of the annuitant</html:option>
                    <html:option value="AFL100AP">Annuity for life with a provision for 100% of the annuity payable to the spouse on death of the annuitant</html:option>
                    <html:option value="AFL100APWRP">Annuity for life with a provision for 100% of the annuity payable to the spouse on death of the annuitant with return of purchase price on death of last annuitant</html:option>                    
                  </html:select>--%>
              
              </logic:notEqual>
              </td>
          
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.TotalInterest" /></TD>
              <td align="left" colspan="1">
              <html:text  property="txtTotalInt" altKey="Payroll.PensionFinal.TotalInterest" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </td>
            </tr>
            <tr>                      
              <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
                <TD width="23%" class=labelText></TD>
                <td align="left" colspan="1"></td>
              </logic:equal>
              <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
              <td width="23%" class=labelText>Cancel Status</td>
              <td >
                <html:textarea  property="cancelStatus" styleClass = "locked" alt="<%=String.valueOf(i)%>" cols="25" style="text-align:left" readonly="true" />                              
              </td> 
              </logic:notEqual>
          
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.SanctionAmount" /></TD>
              <td align="left" colspan="1">
              <html:text  property="sancAmount" altKey="Payroll.PensionFinal.SanctionAmount" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </td>
            </tr>
        
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