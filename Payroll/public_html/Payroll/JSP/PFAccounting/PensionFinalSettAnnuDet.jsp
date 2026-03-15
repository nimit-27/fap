<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%! int i=0,j=0; %>

<TABLE cellspacing="0" cellPadding="0" >
  <TR>
    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
    <td bgcolor="#76A2C7" nowrap class=actTabText onclick="doGetTab('AnnuProSel')">Annuity Provider Selection<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></img></td>
    
    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
    <td bgcolor="#4682B4" nowrap class=actTabText onclick="doGetTab('AnnuDel')">Annuity Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></img></td>
    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></img></td>
                    
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
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.AnnuityStartDt" /></TD>
              <td align="left" colspan="1">
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="U">
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="N">
                <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
                    <html:text  property="txtAnnuityStartDt" altKey="Payroll.PensionFinal.AnnuityStartDt" maxlength="25" size="23" styleClass="required" readonly="true" />
                    <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="txtAnnuityStartDt" alt="<%=(i-1) %>" onclick="showCalendar('txtAnnuityStartDt',this)" />
                </logic:equal>
                <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
                    <html:text  property="txtAnnuityStartDt" altKey="Payroll.PensionFinal.AnnuityStartDt" maxlength="25" size="23" styleClass="locked" readonly="true"/>
                </logic:notEqual>
              </logic:equal>
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="F">
                <html:text  property="txtAnnuityStartDt" altKey="Payroll.PensionFinal.AnnuityStartDt" maxlength="25" size="23" styleClass="locked" readonly="true"/>
              </logic:equal>
              </logic:equal> 
              <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="U">
              <html:text  property="txtAnnuityStartDt" altKey="Payroll.PensionFinal.AnnuityStartDt" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </logic:notEqual>
              </td>
              
              <td width="20%" class=labelText><bean:message key="Payroll.PensionFinal.AnnuityNum" /></td>
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="U">
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="N">
                <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
                    <td><html:text  property="txtAnnuityNum" styleClass="required" alt="Payroll.PensionFinal.AnnuityNum" maxlength="50" size="23" style="text-align:left" /></td>                                                   
                </logic:equal>
                <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
                    <td><html:text  property="txtAnnuityNum" styleClass = "locked" alt="Payroll.PensionFinal.AnnuityNum" maxlength="50" size="23" style="text-align:left" readonly="true" /></td>
                </logic:notEqual>
              </logic:equal>
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="F">
                <td><html:text  property="txtAnnuityNum" styleClass = "locked" alt="Payroll.PensionFinal.AnnuityNum" maxlength="50" size="23" style="text-align:left" readonly="true" /></td>
              </logic:equal>
              </logic:equal>
              <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="U">
                <td><html:text  property="txtAnnuityNum" styleClass = "locked" alt="Payroll.PensionFinal.AnnuityNum" maxlength="50" size="23" style="text-align:left" readonly="true" /></td>                                                   
              </logic:notEqual>
            </tr>
            <tr>
              <td width="20%" class=labelText><bean:message key="Payroll.PensionFinal.PurchagePrice" /></td>
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="U">
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="N">
                <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
                    <td><html:text  property="txtPurchagePric" styleClass="required" alt="" maxlength="50" size="23" style="text-align:left"/></td>                                                   
                </logic:equal>
                <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
                    <td><html:text  property="txtPurchagePric" styleClass = "locked" alt="" maxlength="50" size="23" style="text-align:left" readonly="true"/></td>
                </logic:notEqual>
              </logic:equal>
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="F">
                <td><html:text  property="txtPurchagePric" styleClass = "locked" alt="" maxlength="50" size="23" style="text-align:left" readonly="true"/></td>
              </logic:equal>
              </logic:equal>
              <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="U">
              <td><html:text  property="txtPurchagePric" styleClass = "locked" alt="" maxlength="50" size="23" style="text-align:left" readonly="true"/></td>                                                   
              </logic:notEqual>
              
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.SettlementAmount" /></TD>
              <td align="left" colspan="1">
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="U">
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="N">
                <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
                    <html:text  property="txtSettlAmount" maxlength="25" size="23" styleClass="required"/>
                </logic:equal>
                <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
                    <html:text  property="txtSettlAmount" maxlength="25" size="23" styleClass="locked" readonly="true"/>
                </logic:notEqual>
              </logic:equal>
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="F">
                <html:text  property="txtSettlAmount" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </logic:equal>
              </logic:equal>
              <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="U">
                <html:text  property="txtSettlAmount" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </logic:notEqual>
              </td>
            </tr>
            
            <TR>                          
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.AnnuityFr" /></TD>
              <td align="left" colspan="1">
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="U">  
                <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="N">
                <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
                  <html:select style="width:145px" property="txtAnnuityFreq" alt="Payroll.PensionFinal.AnnuityFr" titleKey="" styleClass="required" >
                    <html:option value="" >&nbsp;&nbsp;---Select---</html:option>
                    <html:option value="MONTHLY">Monthly</html:option>
                    <html:option value="QUARTERLY">Quarterly</html:option>
                    <html:option value="HALFYEARLY">Half Yearly</html:option>
                    <html:option value="YEARLY">Yearly</html:option>
                  </html:select>
                </logic:equal>
                <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
                    <html:text  property="txtAnnuityFreq" altKey="Payroll.PensionFinal.AnnuityFr" maxlength="25" size="23" styleClass="locked" readonly="true"/>
                </logic:notEqual>
                </logic:equal>
                <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="F">
                    <html:text  property="txtAnnuityFreq" altKey="Payroll.PensionFinal.AnnuityFr" maxlength="25" size="23" styleClass="locked" readonly="true"/>
                </logic:equal>
              </logic:equal>
              <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="U">
                <html:text  property="txtAnnuityFreq" altKey="Payroll.PensionFinal.AnnuityFr" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </logic:notEqual>
              </td>
              
              <td width="23%" class=labelText><bean:message key="Payroll.PensionFinal.GST" /></td>
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="U">
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="N">
                <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
                    <td><html:text  property="txtFM" styleClass="required" alt="" maxlength="50" size="23" style="text-align:left"/></td>
                </logic:equal>
                <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
                    <td><html:text  property="txtFM" styleClass = "locked" alt="" maxlength="50" size="23" style="text-align:left" readonly="true"/></td>
                </logic:notEqual>
              </logic:equal>
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="F">
                <td><html:text  property="txtFM" styleClass = "locked" alt="" maxlength="50" size="23" style="text-align:left" readonly="true"/></td>
              </logic:equal>
              </logic:equal>
              <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="U">
                <td><html:text  property="txtFM" styleClass = "locked" alt="" maxlength="50" size="23" style="text-align:left" readonly="true"/></td>
              </logic:notEqual>
            </tr>
            <tr>                      
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.DateOfExit" /></TD>
              <td align="left" colspan="1">
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="U">
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="N">
                <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
                    <html:text  property="txtDateOfExit" altKey="Payroll.PensionFinal.DateOfExit" maxlength="25" size="23" styleClass="required"/>
                    <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="txtDateOfExit" alt="<%=(i-1) %>" onclick="showCalendar('txtDateOfExit',this)" />
                </logic:equal>
                <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
                    <html:text  property="txtDateOfExit" altKey="Payroll.PensionFinal.DateOfExit" maxlength="25" size="23" styleClass="locked" readonly="true"/>
                </logic:notEqual>
              </logic:equal>
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="F">
                <html:text  property="txtDateOfExit" altKey="Payroll.PensionFinal.DateOfExit" maxlength="25" size="23" styleClass="locked" readonly="true"/>
              </logic:equal>
              </logic:equal>
              <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="U">
                <html:text  property="txtDateOfExit" altKey="Payroll.PensionFinal.DateOfExit" maxlength="25" size="23" styleClass="locked" readonly="true"/>
              </logic:notEqual>
              </td>
          
              <TD width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.AnnuityAmount" /></TD>
              <td align="left" colspan="1">
              <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="U">
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="N">
                <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
                    <html:text  property="txtAnnuityAmount" altKey="Payroll.PensionFinal.AnnuityAmount" maxlength="25" size="23" styleClass="required"/>
                </logic:equal>
                <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
                    <html:text  property="txtAnnuityAmount" altKey="Payroll.PensionFinal.AnnuityAmount" maxlength="25" size="23" styleClass="locked" readonly="true"/>
                </logic:notEqual>
              </logic:equal>
              <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="F">
                <html:text  property="txtAnnuityAmount" altKey="Payroll.PensionFinal.AnnuityAmount" maxlength="25" size="23" styleClass="locked" readonly="true"/>
              </logic:equal>
              </logic:equal>
              <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="U">
                <html:text  property="txtAnnuityAmount" altKey="Payroll.PensionFinal.AnnuityAmount" maxlength="25" size="23" styleClass="locked" readonly="true"/>                                         
              </logic:notEqual>
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