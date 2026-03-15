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

    <html:form  action="MaintPFParam" name="frmMaintMiscellaneousParam" type="FCIPAY.Payroll.WEBTIER.Form.MaintMiscellaneousParamForm" scope="session">
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
          <TD  colSpan=11 class=mainHeader height=10>MAINTAIN PF PARAMETERS</TD>
        </TR>
      </TABLE>
      
<!--container table starts -->
      <TABLE cellSpacing=0 cellPadding=0 border=0 >
        <TBODY>
          <TR>
            <TD>
            
              <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
                <TR height="100">
                  <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
                    <TABLE cellSpacing=0 cellPadding=0 >           
                      <TR>
                        <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#4682B4" nowrap class=actTabText > PF Parameters <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                        
                        <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                        <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                      </tr>
                      
                      <TR height=10>
                  <!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                          <TBODY>
                            <TR height=20>
                            
                            <td colspan=6 >
                              <table>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="CPF Deduction" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >CPF Deduction %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" name="othrinfo" alt="<%=String.valueOf(i-1) %>" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" style="text-align:right" styleClass = "required" maxlength="5" size="23" /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" name="othrinfo" alt="<%=String.valueOf(i-1) %>" onchange="chkFromDt(this.alt);" readonly="true" style="width=80%;text-align:center;" styleClass="required" maxlength="10" size="23"  />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1) %>" onclick="showCalendar('txtStartDt',this)" />
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
                                          <html:hidden property="hdnAllowTyp" value="CPF Deduction" />
                                          <html:hidden property="hdnAllowDtl" value="" />
                                          <html:hidden  property="txtPayCode" value="516" />
                                          <html:hidden property="status" value="N" />
                                          <html:hidden property="detailId" value="" />
                                           <html:hidden property="itemChecked" value="N" />
                                          <td  width="20%" class=labelText align="left" >CPF Deduction %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" alt="<%=String.valueOf(i-1) %>" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" style="text-align:right" styleClass = "required" maxlength="5" size="23" /></td>
                                          <td  width="10%" class=labelText>Effective From</td>
                                          <td  width="15%"> <html:text  property="txtStartDt" value="" readonly="true" alt="<%=String.valueOf(i-1) %>" onchange="chkFromDt(this.alt);" style="width=80%;text-align:center;" styleClass="required" maxlength="10" size="23"  />
                                            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=String.valueOf(i-1)%>" onclick="showCalendar('txtStartDt',this)" />
                                          </td>
                                        </tr>
                                <%
                                  }
                                  dispFlg=false;
                                %>
                                <logic:present name="frmMaintMiscellaneousParam" property="lstOtherDtls" >
                                  <logic:iterate id="othrinfo" name="frmMaintMiscellaneousParam" property="lstOtherDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlOtherBean" >
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="TDS %" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >TDS on Intervening Interest %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" name="othrinfo" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" alt="<%=String.valueOf(i-1) %>" style="text-align:right" styleClass = "required" maxlength="5" size="23" /></td>
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
                                          <html:hidden property="hdnAllowTyp" value="TDS %" />
                                          <html:hidden property="hdnAllowDtl" value="" />
                                          <html:hidden  property="txtPayCode" value="" />
                                          <html:hidden property="status" value="N" />
                                          <html:hidden property="detailId" value="" />
                                          <html:hidden property="itemChecked" value="N" />
                                          <td  width="20%" class=labelText align="left" >TDS on Intervening Interest %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass = "required" maxlength="5" size="23" /></td>
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
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="EPS %" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >EPS %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" name="othrinfo" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass = "required" maxlength="5" size="23" /></td>
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
                                          <html:hidden property="hdnAllowTyp" value="EPS %" />
                                          <html:hidden property="hdnAllowDtl" value="" />
                                          <html:hidden  property="txtPayCode" value="902" />
                                          <html:hidden property="status" value="N" />
                                          <html:hidden property="detailId" value="" />
                                          <html:hidden property="itemChecked" value="N" />
                                          <td  width="20%" class=labelText align="left" >EPS %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass = "required" maxlength="5" size="23" /></td>
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
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="EPS Limit" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >EPS Wage Limit</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" name="othrinfo" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass = "required" maxlength="10" size="23" /></td>
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
                                          <html:hidden property="hdnAllowTyp" value="EPS Limit" />
                                          <html:hidden property="hdnAllowDtl" value="" />
                                          <html:hidden  property="txtPayCode" value="" />
                                          <html:hidden property="status" value="N" />
                                          <html:hidden property="detailId" value="" />
                                          <html:hidden property="itemChecked" value="N" />
                                          <td  width="20%" class=labelText align="left" >EPS Wage Limit</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="return changed(this.alt)" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass = "required" maxlength="10" size="23" /></td>
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
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="FPS %" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >FPS %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" name="othrinfo" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass = "required" maxlength="5" size="23" /></td>
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
                                          <html:hidden property="hdnAllowTyp" value="FPS %" />
                                          <html:hidden property="hdnAllowDtl" value="" />
                                          <html:hidden  property="txtPayCode" value="" />
                                          <html:hidden property="status" value="N" />
                                          <html:hidden property="detailId" value="" />
                                          <html:hidden property="itemChecked" value="N" />
                                          <td  width="20%" class=labelText align="left" >FPS %</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass = "required" maxlength="5" size="23" /></td>
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
                                    <logic:equal name="othrinfo" property="hdnAllowTyp" value="PF Loan Int" >
                                      <logic:equal name="othrinfo" property="hdnAllowDtl" value="" >
                                        <% dispFlg=true;%>
                                        <% ++i; %>
                                        <TR>
                                          <td  width="20%" class=labelText align="left" >PF Loan Interest Rate</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" name="othrinfo" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass = "required" maxlength="5" size="23" /></td>
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
                                          <html:hidden property="hdnAllowTyp" value="PF Loan Int" />
                                          <html:hidden property="hdnAllowDtl" value="" />
                                          <html:hidden  property="txtPayCode" value="87" />
                                          <html:hidden property="status" value="N" />
                                          <html:hidden property="detailId" value="" />
                                          <html:hidden property="itemChecked" value="N" />
                                          <td  width="20%" class=labelText align="left" >PF Loan Interest Rate</td>
                                          <td align="left" width="30%" ><html:text  property="txtAllow" value="" onkeypress="if((event.keyCode < 48 && event.keyCode != 46 || event.keyCode > 57))return false;" onchange="percentCheck(this.value); changed(this.alt)" alt="<%=String.valueOf(i-1)%>" style="text-align:right" styleClass = "required" maxlength="5" size="23" /></td>
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
  frmMaintMiscellaneousParam.action="../../../miscPFNewMode.do"
  frmMaintMiscellaneousParam.submit();
}

function doQueryMode()
{
  frmMaintMiscellaneousParam.action="../../../miscPFQueryMode.do"
  frmMaintMiscellaneousParam.submit();
}


function doRefresh()
{
  frmMaintMiscellaneousParam.action="../../../miscPFRefresh.do"
  frmMaintMiscellaneousParam.submit();
}

function getHeaderRecord()
{
  frmMaintMiscellaneousParam.screenMode.value = 'U';
  frmMaintMiscellaneousParam.flagOther.value="true";
  document.all.butExecute.disabled="true";
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
  frmMaintMiscellaneousParam.action="../../../miscPFGetOtherDtlAction.do"
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
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintMiscellaneousParam.action = "../../../miscPFSaveAction.do";
      frmMaintMiscellaneousParam.submit();
  }
  else
  {
    return false;
  }
}

function popCal(inputField,buttonId)
{
  var ind=buttonId.alt;
  var dtVal=document.all.txtStartDt[ind].value;
  ind=parseInt(ind)+1;
  document.all.txtStartDt[ind].value=dtVal;
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
