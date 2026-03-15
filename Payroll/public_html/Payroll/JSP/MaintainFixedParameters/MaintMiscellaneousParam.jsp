<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
 	<HEAD>
    <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
     
  </head>
  
  <BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
    <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

    <html:form  action="MaintMiscellaneousParam" name="frmMaintMiscellaneousParam" type="FCIPAY.Payroll.WEBTIER.Form.MaintMiscellaneousParamForm" scope="session">
      <bean:define id="ParentForm" name="frmMaintMiscellaneousParam" toScope="request" />
      <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
      <html:errors/>

      <html:hidden property="detailDataChanged" value="false" />
      <html:hidden property="headerFields" value="false" />
      <%! int i=0,j=0;
          boolean dispFlg=false;
      %>
      <% i = 0;j=0; %>

      <table>
        <TR height=30>
          <TD  colSpan=11 class=mainHeader height=10>MAINTAIN OTHER PARAMETERS</TD>
        </TR>
        <tr height="10">
          <td class=userText colspan="11"></td>
        </tr>
      </TABLE>
      
<!--container table starts -->
      <TABLE cellSpacing=0 cellPadding=0 border=0 >
        <TBODY>
          <TR>
            <TD>
              <TABLE cellSpacing=0 cellPadding=0 >
       <!--General Information Row Starts -->
                <TR>
                  <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>
                <tr height="15" >
                  <td colspan="6"></td>
                </tr>
              </table>
    
              <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
                <TR height="200">
                  <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
                    <TABLE cellSpacing=0 cellPadding=0 >           
                      <TR>
                        <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#4682B4" nowrap class=actTabText > Miscellaneous Parameters <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                        <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('mhs')" > Medical Health Scheme Deduction<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0" ></td>
                        <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>

                        <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                        <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                      </tr>
                      
                      <TR height=10>
                  <!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                          <TBODY>
                            <TR height=20>
                              <TD  class=subHeader  align = "center" height=5>Deputation Allowance</TD>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >    
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                    
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="Deputation Allowance" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="I" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>                       
                                        <td  width="10%" class=labelText>Effective From</td>
                                        <td  width="15%"> <html:text  property="txtStartDt" name="othrinfo" readonly="true" style="width=80%;text-align:center;" alt="<%=String.valueOf(i-1)%>" styleClass="required" onchange="chkFromDt(this.alt); popCal('txtStartDt',this);" maxlength="10" size="23"   />
                                          <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                        </td>
                                      </TR>                                
                                      <TR>
                                        <td  width="20%" class=labelText align="left"><bean:message key="pay.MaintMiscellaneousParam.txtWSameSt" /></td>
                                        <td  width="30%"> <html:text  property="txtAllow" name="othrinfo"  style="text-align:right" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" alt="<%=String.valueOf(i-1)%>" maxlength="10" size="23" />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.basic" /></td> 
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden  property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg)
                                  {
                                    ++i;
                                %>                                   
                                  <td  width="10%" class=labelText>Effective From</td>
                                  <td  width="15%"> <html:text  property="txtStartDt" value="" readonly="true" style="width=80%;text-align:center;" alt="<%=String.valueOf(i-1)%>" styleClass="required" maxlength="10" size="23" onchange=" chkFromDt(this.alt); popCal('txtStartDt',this);"  />
                                    <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                  </td>
                                </TR>                                
                                <TR>
                                  <td  width="20%" class=labelText align="left"><bean:message key="pay.MaintMiscellaneousParam.txtWSameSt" /></td>
                                  <td  width="30%"> <html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" maxlength="10" size="23" />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.basic" /></td> 
                                  <html:hidden property="hdnAllowTyp" value="Deputation Allowance" />
                                  <html:hidden  property="hdnAllowDtl" value="I" />
                                  <html:hidden property="status" value="N" />
                                  <html:hidden property="detailId" value="" />
                                  <html:hidden  property="txtPayCode" value="108" />
                                  <html:hidden property="itemChecked" value="N" />
                                <%
                                  }
                                  dispFlg=false;
                                %>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                   
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="Deputation Allowance" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="O" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <td  width="20%" class=labelText align="left"><bean:message key="pay.MaintMiscellaneousParam.txtOutSt" /></td>
                                        <td  width="30%"><html:text  property="txtAllow" name="othrinfo" style="text-align:right;" alt="<%=String.valueOf(i-1)%>" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)"  styleClass = "required" maxlength="10" size="23"  />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.basic" /></td>                              
                                        <html:hidden  property="txtStartDt" name="othrinfo" alt="<%=String.valueOf(i-1)%>" />
                                        <html:hidden  property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg){
                                    ++i;
                                %>
                                    
                                    <td  width="20%" class=labelText align="left"><bean:message key="pay.MaintMiscellaneousParam.txtOutSt" /></td>
                                    <td  width="30%"><html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" style="text-align:right;" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)"  styleClass = "required" maxlength="10" size="23" />&nbsp;&nbsp;<bean:message key="pay.MaintMiscellaneousParam.basic" /></td>                              
                                    <html:hidden  property="txtStartDt" value="" alt="<%=String.valueOf(i-1)%>" />
                                    <html:hidden  property="hdnAllowDtl" value="O" />
                                    <html:hidden property="hdnAllowTyp" value="Deputation Allowance" />
                                    <html:hidden  property="txtPayCode" value="108" />
                                    <html:hidden property="status" value="N" />
                                    <html:hidden property="detailId" value="" />
                                    <html:hidden property="itemChecked" value="N" />
                                <%
                                  }
                                  dispFlg=false;
                                %>    
                            </tr>
                            <tr height = 10><td></td></tr>
                            <tr height = 10><td></td></tr>                                                   
                            <TR>
                              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                            </TR> 



                              <TD  class=subHeader  align = "center" height=5>Deputation Ceiling Amount</TD>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >    
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                    
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="DA Cieling" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="I" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>                       
                                        <td  width="10%" class=labelText>Effective From</td>
                                        <td  width="15%"> <html:text  property="txtStartDt" name="othrinfo" readonly="true" style="width=80%;text-align:center;" alt="<%=String.valueOf(i-1)%>" styleClass="required" onchange="chkFromDt(this.alt); popCal('txtStartDt',this);" maxlength="10" size="23"   />
                                          <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                        </td>
                                      </TR>                                
                                      <TR>
                                        <td  width="20%" class=labelText align="left"><bean:message key="pay.MaintMiscellaneousParam.txtWSameSt" /></td>
                                        <td  width="30%"> <html:text  property="txtAllow" name="othrinfo"  style="text-align:right" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" alt="<%=String.valueOf(i-1)%>" maxlength="10" size="23" /></td> 
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden  property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg)
                                  {
                                    ++i;
                                %>                                   
                                  <td  width="10%" class=labelText>Effective From</td>
                                  <td  width="15%"> <html:text  property="txtStartDt" value="" readonly="true" style="width=80%;text-align:center;" alt="<%=String.valueOf(i-1)%>" styleClass="required" maxlength="10" size="23" onchange=" chkFromDt(this.alt); popCal('txtStartDt',this);"  />
                                    <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                  </td>
                                </TR>                                
                                <TR>
                                  <td  width="20%" class=labelText align="left"><bean:message key="pay.MaintMiscellaneousParam.txtWSameSt" /></td>
                                  <td  width="30%"> <html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" maxlength="10" size="23" /></td> 
                                  <html:hidden property="hdnAllowTyp" value="DA Cieling" />
                                  <html:hidden  property="hdnAllowDtl" value="I" />
                                  <html:hidden property="status" value="N" />
                                  <html:hidden property="detailId" value="" />
                                  <html:hidden  property="txtPayCode" value="" />
                                  <html:hidden property="itemChecked" value="N" />
                                <%
                                  }
                                  dispFlg=false;
                                %>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                   
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="DA Cieling" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="O" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <td  width="20%" class=labelText align="left"><bean:message key="pay.MaintMiscellaneousParam.txtOutSt" /></td>
                                        <td  width="30%"><html:text  property="txtAllow" name="othrinfo" style="text-align:right;" alt="<%=String.valueOf(i-1)%>" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)"  styleClass = "required" maxlength="10" size="23"  /></td>                              
                                        <html:hidden  property="txtStartDt" name="othrinfo" alt="<%=String.valueOf(i-1)%>" />
                                        <html:hidden  property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg){
                                    ++i;
                                %>
                                    
                                    <td  width="20%" class=labelText align="left"><bean:message key="pay.MaintMiscellaneousParam.txtOutSt" /></td>
                                    <td  width="30%"><html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" style="text-align:right;" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)"  styleClass = "required" maxlength="10" size="23" /></td>                              
                                    <html:hidden  property="txtStartDt" value="" alt="<%=String.valueOf(i-1)%>" />
                                    <html:hidden  property="hdnAllowDtl" value="O" />
                                    <html:hidden property="hdnAllowTyp" value="DA Cieling" />
                                    <html:hidden  property="txtPayCode" value="" />
                                    <html:hidden property="status" value="N" />
                                    <html:hidden property="detailId" value="" />
                                    <html:hidden property="itemChecked" value="N" />
                                <%
                                  }
                                  dispFlg=false;
                                %>    
                            </tr>
                            <tr height = 10><td></td></tr>
                            <tr height = 10><td></td></tr>                                                   
                            <TR>
                              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                            </TR> 




  
                            <TR height=20>
                              <TD  class=subHeader colSpan=6  align = "center" height=5></TD>
                            </TR>                                
                            <TR height=20>
                              <TD  class=subHeader  align = "center" height=5>Night Shift Allowance</TD>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="Night Shift Allowance" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="12 to 8" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <td  width="10%" class=labelText>Effective From</td>
                                        <td width="15%"> <html:text  property="txtStartDt" name="othrinfo" alt="<%=String.valueOf(i-1)%>" readonly="true" style="width=80%;text-align:center;" onchange="chkFromDt(this.alt); popCal('txtStartDt',this);" styleClass="required" maxlength="10" size="23"  />
                                          <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                        </td>
                                      </TR>                                
                                      <TR>
                                        <td  width="20%" class=labelText align="left">Shift duty from 12.00 Mid-night to 8.00 AM (Rs.)</td>
                                        <td  width="30%"> <html:text  property="txtAllow" name="othrinfo" alt="<%=String.valueOf(i-1)%>" style="text-align:right;" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" maxlength="10" size="23"  />
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden  property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg){
                                    ++i;
                                %>  
                                    <td  width="10%" class=labelText>Effective From</td>
                                    <td width="15%"> <html:text  property="txtStartDt" value="" alt="<%=String.valueOf(i-1)%>" readonly="true" style="width=80%;text-align:center;" onchange="chkFromDt(this.alt); popCal('txtStartDt',this);" styleClass="required" maxlength="10" size="23"  />
                                      <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                    </td>
                                  </TR>                                
                                  <TR>                            
                                    <td  width="20%" class=labelText align="left">Shift duty from 12.00 Mid-night to 8.00 AM (Rs.)</td>
                                    <td  width="30%"> <html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" style="text-align:right;" styleClass="required" maxlength="10" size="23"  />
                                    <html:hidden property="hdnAllowTyp" value="Night Shift Allowance" />
                                    <html:hidden  property="hdnAllowDtl" value="12 to 8" />
                                    <html:hidden  property="txtPayCode" value="140" />
                                    <html:hidden property="status" value="N" />
                                    <html:hidden property="detailId" value="" />
                                    <html:hidden property="itemChecked" value="N" />
                                <%
                                  }
                                  dispFlg=false;
                                %>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="Night Shift Allowance" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="4 to 12" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        
                                        <td  width="20%" class=labelText align="left" >Shift duty from 4.00 PM to 12.00 Mid-night (Rs.)</td>
                                        <td  width="30%"><html:text  property="txtAllow" name="othrinfo" alt="<%=String.valueOf(i-1)%>" style="text-align:right;" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)"  styleClass = "required" maxlength="10" size="23"  /></td>                              
                                        <html:hidden  property="txtStartDt" value="" name="othrinfo" alt="<%=String.valueOf(i-1)%>" />
                                        <html:hidden  property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg){
                                    ++i;
                                %>
                                    
                                    <td  width="20%" class=labelText align="left" >Shift duty from 4.00 PM to 12.00 Mid-night (Rs.)</td>
                                    <td  width="30%"><html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" style="text-align:right;" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)"  styleClass = "required" maxlength="10" size="23"  /></td>                              
                                    <html:hidden  property="txtStartDt" alt="<%=String.valueOf(i-1)%>" />
                                    <html:hidden  property="hdnAllowDtl" value="4 to 12" />
                                    <html:hidden property="hdnAllowTyp" value="Night Shift Allowance" />
                                    <html:hidden  property="txtPayCode" value="140" />
                                    <html:hidden property="status" value="N" />
                                    <html:hidden property="detailId" value="" />
                                    <html:hidden property="itemChecked" value="N" />
                                <%
                                  }
                                  dispFlg=false;
                                %> 
                            </tr>
                            <tr height = 10><td></td></tr>
                            <tr height = 10><td></td></tr> 
                            
                            <TR>
                              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                            </TR>
                            <TR height=20>
                              <TD  class=subHeader colSpan=6  align = "center" height=5></TD>
                            </TR>                                
                            <TR height=20>
                              <TD  class=subHeader colSpan=6  align = "center" height=5>Other</TD>
                            </TR>                                
                            <TR>
                              <td colspan=6 >
                                <table>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                   <logic:equal name="othrinfo" property="hdnAllowTyp" value="NPA" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >NPA %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" name="othrinfo" alt="<%=String.valueOf(i-1)%>" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" style="text-align:right" styleClass = "required" maxlength="10" size="23" /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" name="othrinfo" alt="<%=String.valueOf(i-1)%>"  readonly="true" style="width=80%;text-align:center;" onchange="chkFromDt(this.alt);" styleClass="required" maxlength="10" size="23"  />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg){
                                    ++i;
                                %>
                                        <TR>                          
                                          <td  width="20%" class=labelText align="left" >NPA %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" style="text-align:right" styleClass = "required" maxlength="10" size="23" /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" value="" alt="<%=String.valueOf(i-1)%>" readonly="true"  style="width=80%;text-align:center;" onchange="chkFromDt(this.alt);" styleClass="required" maxlength="10" size="23"  />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                        <html:hidden property="hdnAllowTyp" value="NPA" />
                                        <html:hidden property="hdnAllowDtl" value="" />
                                        <html:hidden  property="txtPayCode" value="122" />
                                        <html:hidden property="status" value="N" />
                                        <html:hidden property="detailId" value="" />
                                        <html:hidden property="itemChecked" value="N" />
                                <%
                                  }
                                  dispFlg=false;
                                %>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                   <logic:equal name="othrinfo" property="hdnAllowTyp" value="NPA Ceiling" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >NPA Ceiling Amount (Rs.)</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" name="othrinfo" alt="<%=String.valueOf(i-1)%>" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" style="text-align:right" styleClass = "required" maxlength="10" size="23"  /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" name="othrinfo" alt="<%=String.valueOf(i-1)%>" readonly="true" onchange="chkFromDt(this.alt);"  style="width=80%;text-align:center;" styleClass="required" maxlength="10" size="23"  />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg){
                                    ++i;
                                %>
                                        <TR>                          
                                          <html:hidden property="hdnAllowTyp" value="NPA Ceiling" />
                                          <html:hidden property="hdnAllowDtl" value="" />
                                          <html:hidden  property="txtPayCode" value="" />
                                          <html:hidden property="status" value="N" />
                                          <html:hidden property="detailId" value="" />
                                          <html:hidden property="itemChecked" value="N" />
                                          <td  width="20%" class=labelText align="left" >NPA Ceiling Amount (Rs.)</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" style="text-align:right" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" styleClass = "required" maxlength="10" size="23"  /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" value="" alt="<%=String.valueOf(i-1)%>" readonly="true" onchange="chkFromDt(this.alt);" style="width=80%;text-align:center;" styleClass="required" maxlength="10" size="23"  />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                <%
                                  }
                                  dispFlg=false;
                                %>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="PLI Ceiling" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >PLI Ceiling Amount (Rs.)</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" name="othrinfo" alt="<%=String.valueOf(i-1)%>" style="text-align:right" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" styleClass = "required" maxlength="10" size="23"  /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" name="othrinfo" alt="<%=String.valueOf(i-1)%>" readonly="true" onchange="chkFromDt(this.alt);" style="width=80%;text-align:center;" styleClass="required" maxlength="10" size="23" />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg){
                                    ++i;
                                %>
                                        <TR>                          
                                          <html:hidden property="hdnAllowTyp" value="PLI Ceiling" />
                                          <html:hidden property="hdnAllowDtl" value="" />
                                          <html:hidden  property="txtPayCode" value="" />
                                          <html:hidden property="status" value="N" />
                                          <html:hidden property="detailId" value="" />
                                          <html:hidden property="itemChecked" value="N" />
                                          <td  width="20%" class=labelText align="left" >PLI Ceiling Amount (Rs.)</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" style="text-align:right" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" styleClass = "required" maxlength="10" size="23" /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" value="" alt="<%=String.valueOf(i-1)%>" readonly="true" onchange="chkFromDt(this.alt);" style="width=80%;text-align:center;" styleClass="required" maxlength="10" size="23" />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                <%
                                  }
                                  dispFlg=false;
                                %> 
                              </table>
                            </td>
                          </tr>
                          <tr height = 10><td></td></tr>
                          <tr height = 10><td></td></tr>                                                   
                          <TR>
                            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                          </TR>
                          <tr height = 10><TD  class=subHeader colSpan=6  align = "center" height=5>Deductions</TD></tr>  
                          <TR>
                            <td colspan=6 >
                              <table>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="BF Deduction" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >BF Deduction (Rs.)</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" alt="<%=String.valueOf(i-1)%>" name="othrinfo" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)"  style="text-align:right" styleClass = "required" maxlength="10" size="23" /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" name="othrinfo" alt="<%=String.valueOf(i-1)%>" readonly="true" onchange="chkFromDt(this.alt);" style="width=80%;text-align:center;" styleClass="required" maxlength="10" size="23" />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg){
                                    ++i;
                                %>
                                        <TR>                          
                                          <html:hidden property="hdnAllowTyp" value="BF Deduction" />
                                          <html:hidden property="hdnAllowDtl" value="" />
                                          <html:hidden  property="txtPayCode" value="346" />
                                          <html:hidden property="status" value="N" />
                                          <html:hidden property="detailId" value="" />
                                          <html:hidden property="itemChecked" value="N" />
                                          <td  width="20%" class=labelText align="left" >BF Deduction (Rs.)</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" style="text-align:right" styleClass = "required" maxlength="10" size="23" /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" value="" alt="<%=String.valueOf(i-1)%>" readonly="true" onchange="chkFromDt(this.alt);" style="width=80%;text-align:center;" styleClass="required" maxlength="10" size="23"  />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                <%
                                  }
                                  dispFlg=false;
                                %>
                                
                                
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="HRR Salary %" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >HRR Salary %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" alt="<%=String.valueOf(i-1)%>" name="othrinfo" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)"  style="text-align:right" styleClass = "required" maxlength="10" size="23" /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" name="othrinfo" alt="<%=String.valueOf(i-1)%>" readonly="true" onchange="chkFromDt(this.alt);" style="width=80%;text-align:center;" styleClass="required" maxlength="10" size="23" />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                        <html:hidden property="hdnAllowTyp" name="othrinfo" />
                                        <html:hidden property="hdnAllowDtl" name="othrinfo" />
                                        <html:hidden  property="txtPayCode" name="othrinfo" />
                                        <html:hidden property="status" name="othrinfo" />
                                        <html:hidden property="detailId" name="othrinfo" />
                                        <html:hidden property="itemChecked" name="othrinfo" />
                                      </logic:equal>
                                    </logic:equal>
                                  </logic:iterate>
                                </logic:present>
                                <%
                                  if(!dispFlg){
                                    ++i;
                                %>
                                        <TR>                          
                                          <html:hidden property="hdnAllowTyp" value="HRR Salary %" />
                                          <html:hidden property="hdnAllowDtl" value="" />
                                          <html:hidden  property="txtPayCode" value="" />
                                          <html:hidden property="status" value="N" />
                                          <html:hidden property="detailId" value="" />
                                          <html:hidden property="itemChecked" value="N" />
                                          <td  width="20%" class=labelText align="left" >HRR Salary %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1)%>" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" style="text-align:right" styleClass = "required" maxlength="10" size="23" /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" value="" alt="<%=String.valueOf(i-1)%>" readonly="true" onchange="chkFromDt(this.alt);" style="width=80%;text-align:center;" styleClass="required" maxlength="10" size="23"  />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                <%
                                  }
                                  dispFlg=false;
                                %>
                                
                               </table>
                              </td>
                            </tr>
                            <tr height = 10><td></td></tr>                                                   
                          </TBODY>
                        </TABLE>
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

<!-- Container Table Ends -->
      <html:hidden name="frmMaintMiscellaneousParam"  property="screenName" value="MiscOtherParamScreen" />
      <html:hidden name="frmMaintMiscellaneousParam"  property="forwardedPage" />
      <html:hidden property="headerPrimaryKey" name="frmMaintMiscellaneousParam" />
      <html:hidden property="screenMode" name="frmMaintMiscellaneousParam" />
      <html:hidden property="positionRequested" name="frmMaintMiscellaneousParam" />
      <html:hidden property="buttonFlag" name="frmMaintMiscellaneousParam"  />
      <html:hidden property="flagOther" name="frmMaintMiscellaneousParam" />
      <html:hidden property="thisPageDetailCount" name="frmMaintMiscellaneousParam" value="<%=String.valueOf(i)%>" />
    </html:form>
  </body>
</html:html>      


<script language="javascript">

function lfnLoad()
{
  mode = document.all.screenMode.value;
  tot = document.all.flagOther.value;
  if(mode=='' )
  {
      doQueryMode();
  }

  if(tot=='true')
  {
      hedMenuHandling('U');
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      
  }
  else
  {
      hedMenuHandling('Q');
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
  }

  if(mode=='Q')
  {
      for(i=0;i<frmMaintMiscellaneousParam.txtAllow.length;i++)
      {
          frmMaintMiscellaneousParam.txtAllow[i].disabled="true";
      }
  }
  
  if(document.all.hdnEmpLbrFlag.value=='V')
    {
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
    }
}

 function changed(val)
{
   frmMaintMiscellaneousParam.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[val].value == 'Q')
     document.getElementsByName("status")[val].value = 'U';
}


function diffChange(val)
{
  if(num_Check(val,1))
  {
//    frmMaintMiscellaneousParam.txtOldCant.value = frmMaintMiscellaneousParam.tempOldCant.value;
    frmMaintMiscellaneousParam.headerDataChanged.value = "true";
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}

 function percentCheck(val)
{
   if(!percent_Check(val))
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
      return false;
    }
   else
   return true;
}


function doInsertMode()
{
  frmMaintMiscellaneousParam.action="../../../miscNewMode.do"
  frmMaintMiscellaneousParam.submit();
}

function doQueryMode()
{
  frmMaintMiscellaneousParam.action="../../../miscQueryMode.do"
  frmMaintMiscellaneousParam.submit();
}


function doRefresh()
{
  frmMaintMiscellaneousParam.action="../../../miscRefresh.do"
  frmMaintMiscellaneousParam.submit();
}

function getHeaderRecord()
{
  frmMaintMiscellaneousParam.screenMode.value ='U';
  frmMaintMiscellaneousParam.flagOther.value="true";
  document.all.butExecute.disabled="true";
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
  frmMaintMiscellaneousParam.action="../../../miscGetOtherDtlAction.do"
  frmMaintMiscellaneousParam.submit();
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintMiscellaneousParam"))
  {
   //   frmMaintMiscellaneousParam.headerPrimaryKey.value = "##";  
      if(frmMaintMiscellaneousParam.screenMode.value == "N")
        frmMaintMiscellaneousParam.headerDataChanged.value = "true";  
  
   //   frmMaintMiscellaneousParam.headerFields.value = "true";
   
 //  var length=document.getElementsByName("txtStartDt").length;
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintMiscellaneousParam.action = "../../../miscSaveAction.do";
      frmMaintMiscellaneousParam.submit();
  }
  else
  {
    return false;
  }
}


function doGetTab(arg)
 {
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../miscTabAction.do";
    document.forms[0].submit();
 }
function popCal(inputField,buttonId)
{
  var ind=buttonId.alt;
  //alert("index is "+ind);
  var dtVal=document.all.txtStartDt[ind].value;
  changed(ind);
  ind=parseInt(ind)+1;
  document.all.txtStartDt[ind].value=dtVal;
  changed(ind);
}

 function chkFromDt(i)
{
  var fromDt=document.getElementsByName("txtStartDt")[i].value;
  if(!cmpSysDate(fromDt,0))
    { 
      document.getElementsByName("txtStartDt")[i].value="";
      return false;
    }
}
</script>
