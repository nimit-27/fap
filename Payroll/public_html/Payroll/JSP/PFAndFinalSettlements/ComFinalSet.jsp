<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>        
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="ComFinalSet" name="frmComFinalSet" type="FCIPAY.Payroll.WEBTIER.Form.ComFinalSetForm" scope="session">
  <bean:define id="ParentForm" name="frmComFinalSet" toScope="request" />
 <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<%
	String strEmpLbrFlag = (String)(request.getSession().getAttribute("hdnEmpLbrFlag"));
%>

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>COMPUTE FINAL SETTLEMENT</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
   <TR>
    <TD>

 <!-- <div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 border=0>
       <!--pay Scale Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Compute Final Settlement Detail</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="6"></td>
            </tr>
            
                <TR>
                  <TD class=labelText width="15%"><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" width="18%" >
                  <html:text  property="txtEmpNo" name="frmComFinalSet" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return doPopulateLov('txtEmpNo','');">
                  </td>  
                  
                  <td class=labelText width="15%" >Employee Name </td>
                  <td width="18%">                             
                  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  
                 <td class=labelText width="15%" ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td width="18%">
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" readonly="true" maxlength="7" size="23" styleClass="locked" onkeypress="
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {
                      return false;
                    };                            
                          lfnHeaderChange(this.value);
                     "  style="text-align:right"   /></td>  
              </TR> 
              
              <TR>              
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/></td>                  
                   
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                  
                  </td>                  
              </tr>
     
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td>
                
                <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text property="txtEmpStatus" name="frmComFinalSet" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23"  onchange="return lfnHeaderChange(this.alt)" />
                  </td>
              </tr>   
 
              <tr>
                  <td width="15%" class=labelText  >Separation Date </td>                            
                  <td ><html:text property="txtDate" name="frmComFinalSet" readonly="true" styleClass="required" alt="<%=String.valueOf(i)%>" size="23"  onchange="lfnHeaderChange(this.alt)" />
                  <logic:equal name="frmComFinalSet" property="screenMode" value="N">
                  <img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="buttxtdate" onclick="showCalendar('txtDate',this)"  >
                  </logic:equal>
                  <logic:equal name="frmComFinalSet" property="screenMode" value="U">
                  <img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="buttxtdate" id="manish" >
                  </logic:equal>
                  </td>
                  
                  <td width="15%" class=labelText  >Separation Type </td>                            
                  <td ><html:select property="txtSepTyp" name="frmComFinalSet" styleClass="required" alt="<%=String.valueOf(i)%>" disabled="true" onchange="chkSepTyp(); lfnHeaderChange(this.alt)" >
                    <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>  
                    <logic:present name="ComFinalSetCombo">
                    <html:optionsCollection label="label" value="value" property="sepTypList" name="ComFinalSetCombo"/>
                    </logic:present>
                    </html:select>
                  </td>
                  
                  <td width="15%" id="org" class=labelText  >Deputed Organization </td>
                  <td width="15%" id="lien" class=labelText  >Lien Period </td>
                  <td width="15%" id="none" class=labelText  >&nbsp; </td>
                  <td  id="txtbox">
                   <input type="text" name="txtValue" onchange="setTxtValue()" onkeypress="
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {
                      return false;
                    };" />
                  </td>     
                  </td>             

              </tr>   

                  <tr>
                  <td colspan = 4 align=center bgcolor=#4682b4 width="100%"></td> 
                   <td  >
                    <logic:equal name="frmComFinalSet" property="screenMode" value="U">
                      <button  alt="Adjust (Alt+D)"  onclick="doEdit('EDIT')" name="EditDetails" class="bottomBarText" property="butEdit" > Edit Details </button>
                      <button  alt="Adjust (Alt+D)"  onclick="doDelete('DEL')" name="DeleteEntry" class="bottomBarText" property="butDel" > Delete Entry </button>
                    </logic:equal>
                    <logic:notEqual name="frmComFinalSet" property="screenMode" value="U">
                      <button  alt="Adjust (Alt+D)"  onclick="doEdit('EDIT')" name="EditDetails" class="bottomBarText"  disabled="true" property="butEdit"> Edit Details </button>
                      <button  alt="Adjust (Alt+D)"  onclick="doDelete('DEL')" name="DeleteEntry" class="bottomBarText" disabled="true" property="butDel"> Delete Entry </button>
                    </logic:notEqual>
  </td>
  <td colspan = 4 align=right bgcolor=#4682b4 width="100%">
  </td>
  </tr>



              <tr>
                  <td width="15%" class=labelText  > </td>                            
                  <td ></td>

              </tr>   

       <tr height="15" >
            <td colspan="6"></td>
            </tr>
                                 
         </table>      

        </div> 
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=12>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0  border = 0>
 
              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > Final Settlement Parameters <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>                         

                    <td background="../INCLUDES/IMAGES/line_t.gif" width="93%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
                 <TR height=10>
                	<!-- Detail table Container starts -->
                <TD colspan="11">                
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TR >
                      <TD width =50% >
                      <table cellspacing=0 cellpadding=0 border=0 width = 100%>
                        <TR><TD class = SubHeader height="20" colspan="4">Leave Encashment</TD></TR>
                        <TR>
                        <td colspan="4">
                          <TABLE cellSpacing="0" cellPadding="0" border = 0 style="BORDER-LEFT: #4682b4 thin solid; BORDER-BOTTOM: #4682b4 thin solid;BORDER-top: #4682b4 thin solid;">
                             <TR>                     
                              <td  width="23%" class=labelText>Sanction No</td>
                              <td width = 27%><html:text onchange="lfnHeaderChange();"  property="txtLeaveEncaSancNo" styleClass="optional" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="30" size="30"  /></td>
                             
                              <td  width="23%" class=labelText>No of ELs</td>
                              <td width = 27%><html:text onchange="getData('EL');lfnHeaderChange(); " onfocus="chkElamt( 'txtNoAccELd','txtLeaveEncaSancAmt');"  property="txtNoAccELd" styleClass="optional" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="10" size="23"  /></td>
                             </tr>

                             <TR>                     
                              <td  width="23%" class=labelText>Sanction Date</td>
                              <td width = 27%><html:text onchange="lfnHeaderChange();"  property="txtLeaveEncaSancDt" styleClass="optional" readonly="true" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="10"  />
							  <logic:equal name="frmComFinalSet" property="txtLeaveEncInv" value="">
                              <img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="buttxtdate" id="txtdate1" onclick="showCalendar('txtLeaveEncaSancDt',this)"  >
							  </logic:equal>
                              </td>
                             
                              <td  width="23%" class=labelText><bean:message key="pay.ComFinalSet.leave" /></td>
                              <td width = 27%><html:text  property="txtLeaveEncaSancAmt" styleClass="locked" altKey="pay.ComFinalSet.leave" maxlength="10" size="23" onchange="lfnHeaderChange();" readonly="true"  /></td>
                             </tr>
                             
                             <TR>                     
                             
                              <td>
                               <logic:equal name="frmComFinalSet" property="screenMode" value="U">
                            <button  alt="Adjust (Alt+D)"  onclick="doDelete('L')" name="DeleteEntry" class="bottomBarText" property="butEl"> Delete Leave Entry </button>
                            </logic:equal>
                            <logic:notEqual name="frmComFinalSet" property="screenMode" value="U">
                   <button  alt="Adjust (Alt+D)"  onclick="doDelete('L')" name="DeleteEntry" class="bottomBarText" disabled="true" property="butEl"> Delete Leave Entry </button>

                            </logic:notEqual>
                            </td>
                            </tr>
                             
                          </table> 
                        </td>
                        </tr> 
                        
                    <!--- added by gagan -->
                    <TR><TD class = SubHeader height="20" colspan="4">HPL Encashment</TD></TR>
                        <TR>
                        <td colspan="4">
                          <TABLE cellSpacing="0" cellPadding="0" border = 0 style="BORDER-LEFT: #4682b4 thin solid; BORDER-BOTTOM: #4682b4 thin solid;BORDER-top: #4682b4 thin solid;">
                             <TR>                     
                              <td  width="23%" class=labelText>Sanction No</td>
                              <td width = 27%><html:text onchange="lfnHeaderChange();"  property="txtHPLEncaSancNo" styleClass="optional" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="30" size="30"  /></td>   
                             
                              <td  width="23%" class=labelText>No of HPLs</td>
                              <td width = 27%><html:text onchange="getData('HPL');lfnHeaderChange(); " onfocus="chkElamt( 'txtHPLNoAccEld','txtHPLEncaSancAmt');" property="txtHPLNoAccEld" styleClass="optional" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="10" size="23"  /></td>   
                             </tr>

                             <TR>                     
                              <td  width="23%" class=labelText>Sanction Date</td>
                              <td width = 27%><html:text onchange="lfnHeaderChange();"  property="txtHPLEncaSancDt" styleClass="optional" readonly="true" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="10"  />  
							  <logic:equal name="frmComFinalSet" property="txtHPLEncInv" value="">
                              <img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="buttxtdate" id="txtdate2" onclick="showCalendar('txtHPLEncaSancDt',this)"  >   
							  </logic:equal>
                              </td>
                             
                              <td  width="23%" class=labelText>HPL Encashment</td>
                              <td width = 27%><html:text  property="txtHPLEncaSancAmt" styleClass="locked" altKey="pay.ComFinalSet.leave" maxlength="10" size="23" onchange="lfnHeaderChange();" readonly="true"  /></td>   
                             </tr>
                             <TR>                     
                             
                              <td>
                              <logic:equal name="frmComFinalSet" property="screenMode" value="U">
                            <button  alt="Adjust (Alt+D)"  onclick="doDelete('H')" name="DeleteEntry" class="bottomBarText" property="butHpl"> Delete HPL Entry </button>
                            </logic:equal>
                            <logic:notEqual name="frmComFinalSet" property="screenMode" value="U">
                            <button  alt="Adjust (Alt+D)"  onclick="doDelete('H')" name="DeleteEntry" class="bottomBarText" property="butHpl"  disabled="true"> Delete HPL Entry </button>
                            </logic:notEqual>                        

                            </td>
                            </tr>
                             
                          </table> 
                        </td>
                        </tr> 
                        <!--  end by gagan -->
                        
                        <TR ><TD class = SubHeader height="20" colspan="4">Gratuity</TD></TR>
                        <TR>
                          <td colspan="4">
                          <TABLE cellSpacing="0" cellPadding="0" border = 0 style="BORDER-LEFT: #4682b4 thin solid; BORDER-BOTTOM: #4682b4 thin solid;BORDER-top: #4682b4 thin solid;">
                             <TR>                     
                              <td  width="23%" class=labelText>Sanction No</td>
                              <td width = 27%><html:text onchange="lfnHeaderChange();"  property="txtGraSancNo" styleClass="optional" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="30" size="30"  /></td>

                              <td  width="23%" class=labelText><bean:message key="pay.ComFinalSet.gratuity" /></td>
                              <td width = 27%>
                              <logic:equal name="frmComFinalSet" property="txtIfGratuityChng" value="">
                                <html:text  property="txtGraSancAmt" styleClass="optional" altKey="pay.ComFinalSet.gratuity" maxlength="10" size="23"  onchange="setGraAmt();lfnHeaderChange();" />
                              </logic:equal> 
                              <logic:notEqual name="frmComFinalSet" property="txtIfGratuityChng" value="">
                                  <logic:equal name="frmComFinalSet" property="txtIfGratuityChng" value="N">
                                    <html:text  property="txtGraSancAmt" styleClass="optional" altKey="pay.ComFinalSet.gratuity" maxlength="10" size="23"  onchange="setGraAmt();lfnHeaderChange();" />
                                  </logic:equal> 
                                  <logic:notEqual name="frmComFinalSet" property="txtIfGratuityChng" value="N">
                                    <html:text  property="txtGraSancAmt" styleClass="locked" readonly="true" altKey="pay.ComFinalSet.gratuity" maxlength="10" size="23"  onchange="setGraAmt();lfnHeaderChange();" />
                                  </logic:notEqual> 
                              </logic:notEqual> 
                                </td>
                             </tr>
                             <TR>                            
                              <td  width="23%" class=labelText>Sanction Date</td>
                              <td width = 27%><html:text onchange="lfnHeaderChange();"  property="txtGraSancDt" readonly="true" styleClass="optional" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="10"  />
							  <logic:equal name="frmComFinalSet" property="txtGratuityInv" value="">
                              <img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="buttxtdate" id="txtdate3" onclick="showCalendar('txtGraSancDt',this)"  >
							  </logic:equal>
                              </td>


                              <td  width="23%" class=labelText></td>
                              <td width = 27%></td>
                             </tr>
                             
                                <TR>                     
                             
                              <td>
                              <logic:equal name="frmComFinalSet" property="screenMode" value="U">
                                <button  alt="Adjust (Alt+D)"  onclick="doDelete('G')" class="bottomBarText" property="butGratEdit"> Delete Gratuity Entry </button>
                                <button  alt="Adjust (Alt+D)"  onclick="doDelete('A')" class="bottomBarText" property="butAllEdit"> Delete All Entries </button>
                              </logic:equal>
                              <logic:notEqual name="frmComFinalSet" property="screenMode" value="U">
                                <button  alt="Adjust (Alt+D)"  onclick="doDelete('G')" class="bottomBarText" property="butGratEdit" disabled="true"> Delete Gratuity Entry </button>
                                <button  alt="Adjust (Alt+D)"  onclick="doDelete('A')" class="bottomBarText" property="butAll" disabled="true"> Delete All enteries </button>
                              </logic:notEqual>
                            </td>
                            </tr>
    
                          </table> 
                        </td>
                       </tr> 
                      
                       <!--- added by swarnika -->
                       
                        
                            
                          
                       
                    <TR><TD class = SubHeader height="20" colspan="4">Voluntarily Retirement Scheme</TD></TR>
                        <TR>
                        <td colspan="4">
                          <TABLE cellSpacing="0" cellPadding="0" border = 0 style="BORDER-LEFT: #4682b4 thin solid; BORDER-BOTTOM: #4682b4 thin solid;BORDER-top: #4682b4 thin solid;">
                             <TR> 
                             <%
							if(strEmpLbrFlag!=null)
							{
								if(!strEmpLbrFlag.equals("E"))
								{
							%>
                              <td  width="23%" class=labelText>Sanction No</td>
                               <td width = 27%>
							<html:text onchange="lfnHeaderChange();"  property="txtVrsSancNo" styleClass="optional" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="30" size="30"  />
							<%}else{%>
							<html:hidden property="txtVrsSancNo" name="frmComFinalSet" />
							</td>  
							<%}
							}%>
                           
                             <!-- <td width = 27%><html:text onchange="lfnHeaderChange();"  property="txtVrsSancNo" styleClass="optional" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="30" size="30"  /></td>   -->
                              <%
							if(strEmpLbrFlag!=null)
							{
								if(!strEmpLbrFlag.equals("E"))
								{
							%>
                              
                              <td  width="23%" class=labelText>VRS Gross Amount</td>
                              <td width = 27%>
							<html:text  property="txtVrsGrossAmt" styleClass="optional" altKey="pay.ComFinalSet.vrs" maxlength="10" size="23"  onchange="setVrsAmt();lfnHeaderChange();"   />
							<%}else{%>
							<html:hidden property="txtVrsGrossAmt" name="frmComFinalSet" />
							</td>  
							<%}
							}%>
                           
                           <!--   <td width = 27%><html:text  property="txtVrsGrossAmt" styleClass="locked" altKey="pay.ComFinalSet.leave" maxlength="10" size="23" onchange="lfnHeaderChange();" readonly="true"  /></td>-->   
                             
                             </tr>

                             <TR> 
                             
                             <%
							if(strEmpLbrFlag!=null)
							{
								if(!strEmpLbrFlag.equals("E"))
								{
							%>
                              <td  width="23%" class=labelText>Sanction Date</td>
                              <td width = 27%>
							<html:text onchange="lfnHeaderChange();"  property="txtVrsSancDt" styleClass="optional" readonly="true" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="10"  />  
							  <logic:equal name="frmComFinalSet" property="txtVrsInv" value="">
                              <img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="buttxtdate" id="txtdate4" onclick="showCalendar('txtVrsSancDt',this)"  >   
							  </logic:equal>
							<%}else{%>
							<html:hidden property="txtVrsSancDt" name="frmComFinalSet" />
							</td>  
							<%}
							}%>
                             <!-- <td width = 27%><html:text onchange="lfnHeaderChange();"  property="txtVrsSancDt" styleClass="optional" readonly="true" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="10"  />  
							  <logic:equal name="frmComFinalSet" property="txtVrsInv" value="">
                              <img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="buttxtdate" id="txtdate2" onclick="showCalendar('txtVrsSancDt',this)"  >   
							  </logic:equal>
                              </td>-->
                             
                              
                             </tr>
                             <TR>                     
                             
                              <td>
                              <logic:equal name="frmComFinalSet" property="screenMode" value="U">
                            <button  alt="Adjust (Alt+D)"  onclick="doDelete('V')" name="DeleteEntry" class="bottomBarText" property="butVrs"> Delete VRS Entry </button>
                            </logic:equal>
                            <logic:notEqual name="frmComFinalSet" property="screenMode" value="U">
                            <button  alt="Adjust (Alt+D)"  onclick="doDelete('V')" name="DeleteEntry" class="bottomBarText" property="butVrs"  disabled="true"> Delete VRS Entry </button>
                            </logic:notEqual>                        

                            </td>
                            </tr>
                             
                          </table> 
                        </td>
                        </tr> 
                        <!--  end by swarnika -->
                      
                      
                       <tr>
                            <td width="23%" class=labelText>Net Earnings</td>
                            <td width = 27%><html:text  property="txtNetEarning" styleClass="locked" readonly="true" altKey="pay.ComFinalSet.gratuity" maxlength="10" size="23"  onchange="lfnHeaderChange();" /></td>
							<%
							if(strEmpLbrFlag!=null)
							{
								if(!strEmpLbrFlag.equals("E"))
								{
							%>
                            <td width="23%" class=labelText>Net Incentive</td>
                            <td width = 27%>
							<html:text property="txtIncentiveAmt" name="frmComFinalSet" styleClass="locked" readonly="true" altKey="pay.ComFinalSet.gratuity" maxlength="10" size="23"  onchange="lfnHeaderChange();" />
							<%}else{%>
							<html:hidden property="txtIncentiveAmt" name="frmComFinalSet" />
							</td>  
							<%}
							}%>
                      </tr>                            
                      <tr> 
                            <td width="23%" class=labelText>Net Encashment Amount Payable</td>
                            <td width = 27%><html:text onchange="lfnHeaderChange();"  property="txtLeave" readonly="true" styleClass="locked" altKey="pay.ComFinalSet.txtNoAccELd" maxlength="10" size="23"  /></td>
                            <td width="23%" class=labelText>Adjust from Gratuity?</td>
                            <td width = 27%><html:checkbox property="graFlag" onchange="lfnHeaderChange();" /></td>
                      </tr>
                      <tr>
                            <td width="23%" class=labelText>Net HPL Encashment Amount Payable</td>
                            <td width = 27%><html:text  property="txtHPLNetAmt" styleClass="locked" readonly="true" altKey="pay.ComFinalSet.gratuity" maxlength="10" size="23"  onchange="lfnHeaderChange();" /></td>  
                            <td width="23%" class=labelText>Net Gratuity Amount Payable</td>
                            <td width = 27%><html:text  property="txtGratuity" styleClass="locked" readonly="true" altKey="pay.ComFinalSet.gratuity" maxlength="10" size="23"  onchange="lfnHeaderChange();" /></td>
                      </tr>        
                      <tr>
                            <%
							if(strEmpLbrFlag!=null)
							{
								if(!strEmpLbrFlag.equals("E"))
								{
							%>
                            <td width="23%" class=labelText>Net VRS Amount Payable</td>
                            <td width = 27%>
							<html:text property="txtVrsNetAmt" name="frmComFinalSet" styleClass="locked" readonly="true" altKey="pay.ComFinalSet.gratuity" maxlength="10" size="23"  onchange="lfnHeaderChange();" />
							<%}else{%>
							<html:hidden property="txtVrsNetAmt" name="frmComFinalSet" />
							</td>  
							<%}
							}%>
                            
                            <td width="23%" class=labelText>Total Amount Payable</td>
                            <td width = 27%><html:text  property="txtTotalNetAmt" styleClass="locked" readonly="true" altKey="pay.ComFinalSet.gratuity" maxlength="10" size="23"  onchange="lfnHeaderChange();" /></td>
                     </tr>        
                     </TABLE>
                      </td>
                      
                      <td width = 38% valign="top">
                      <table cellspacing=0 cellpadding=0 border=0 width = 100%>
                        <TR><TD class = SubHeader height="20" > Deduction Details</TD></TR>
                      </table>
                        <TABLE cellSpacing="0" cellPadding="0" border = 0 style="BORDER-RIGHT: #4682b4 thin solid; BORDER-LEFT: #4682b4 thin solid; BORDER-BOTTOM: #4682b4 thin solid;BORDER-top: #4682b4 thin solid;">
                        <TBODY>
                        
                        <tr>
                          <td>
                          <DIV id=divDtlTable style="height:180px" >
                          <table id="Detail" border="0" >
                           <TR>
                              <td class=tableHeader width="4%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();" /><!--html:checkbox property="selectAll" value="" onclick="toggleCheckBox('selectAll');changeDelete();" /--></td>
                              <td class=tableHeader width="20%"><bean:message key="pay.ComFinalSet.txtPayCode" /></td>
                              <td class=tableHeader width="47%"><bean:message key="pay.ComFinalSet.txtDesc" /></td>
                              <td class=tableHeader width="25%"><bean:message key="pay.ComFinalSet.txtAmt" /> </td>
                           </tr> 

                            <logic:iterate id="Deduction" name="frmComFinalSet" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.ComFinalDetailBean" >
                              <% ++i; %>
                                <logic:notEqual name="Deduction" property="status" value="D" >                                                        
                                        <tr><% ++j; %>
                                        <html:hidden property="txtSerialNo" name="Deduction" />
                                       <logic:equal name="Deduction" property="txtDednAdjFlag" value="Y" >                                      
                                            <td width="1%" align="center">
                                                <html:checkbox property="checked" disabled="true" />
                                            </td>
                                            <td width="5%">
                                                <html:text property="txtPayCode" name="Deduction" styleClass="locked" readonly="true" style="width:70%"  alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);"  />
                                                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=String.valueOf(i)%>" name="butPayCode"  >
                                            </td>
                                            <td width="5%">
                                                <html:text property="txtDesc" name="Deduction" styleClass="locked" readonly="true" style="width:100%"  alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);" />
                                            </td>
                                            <td width="5%" >
                                                <html:text property="txtAmt" name="Deduction" styleClass="locked" readonly="true" style="width:100%;;text-align:right" alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);changeTotal();" />
                                            </td>                                         
                                        </logic:equal>
                                        <logic:notEqual name="Deduction" property="txtDednAdjFlag" value="Y">
                                        <logic:equal name="Deduction" property="chkManDednFlag" value="N">
                                            <td width="1%" align="center">
                                                <logic:equal name="Deduction" property="txtRecFlag" value="" >
                                                        <html:checkbox property="checked" onclick="changeDelete();" />
                                                </logic:equal>
                                                <logic:notEqual name="Deduction" property="txtRecFlag" value="" >
                                                        <html:checkbox property="checked" onclick="changeDelete();" />
                                                </logic:notEqual>
                                            </td>
                                            <td width="5%">
                                                <html:text property="txtPayCode" name="Deduction" styleClass="locked" readonly="true" style="width:70%" alt="<%=String.valueOf(i)%>" />
                                            </td>
                                            <td width="5%">
                                                <html:text property="txtDesc" name="Deduction" styleClass="locked" readonly="true" style="width:100%" alt="<%=String.valueOf(i)%>" />
                                            </td>
                                            <td width="5%" >
                                                <logic:equal name="Deduction" property="txtRecFlag" value="" >
                                                        <html:text property="txtAmt" name="Deduction" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);changeTotal();" />
                                                </logic:equal>
                                                <logic:notEqual name="Deduction" property="txtRecFlag" value="" >
                                                        <html:text property="txtAmt" name="Deduction" styleClass="locked" readonly="true" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);changeTotal();" />
                                                </logic:notEqual>
                                            </td>
                                             
                                        </logic:equal>
                                        <logic:notEqual name="Deduction" property="chkManDednFlag" value="N">
                                            <logic:equal name="Deduction" property="txtOldNewFlag" value="N">
                                                <td width="1%" align="center">
                                                     <html:checkbox property="checked" disabled="" onclick="changeDelete();" /> 
                                                </td>
                                                <td width="5%">
                                                    <html:text property="txtPayCode" name="Deduction" styleClass="locked" readonly="true" style="width:70%" alt="<%=String.valueOf(i)%>" />
                                                </td>
                                                <td width="5%">
                                                    <html:text property="txtDesc" name="Deduction" styleClass="locked" readonly="true" style="width:100%" alt="<%=String.valueOf(i)%>" />
                                                </td>
                                                <td width="5%" >
                                                    <logic:equal name="Deduction" property="txtRecFlag" value="" >
                                                            <html:text property="txtAmt" name="Deduction" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);changeTotal();" />
                                                    </logic:equal>
                                                    <logic:notEqual name="Deduction" property="txtRecFlag" value="" >
                                                            <html:text property="txtAmt" name="Deduction" styleClass="locked" readonly="true" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);changeTotal();" />
                                                    </logic:notEqual>
                                                </td>
                                            </logic:equal>
                                            <logic:notEqual name="Deduction" property="txtOldNewFlag" value="N">
                                                <td width="1%" align="center">
                                                    <logic:equal name="Deduction" property="txtRecFlag" value="" >
                                                            <html:checkbox property="checked" onclick="changeDelete();" />
                                                    </logic:equal>
                                                    <logic:notEqual name="Deduction" property="txtRecFlag" value="" >
                                                            <html:checkbox property="checked" onclick="changeDelete();" />
                                                    </logic:notEqual>
                                                </td>
                                                <td width="5%">
                                                    <html:text property="txtPayCode" name="Deduction" styleClass="required" readonly="true" style="width:70%"  alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);"  />
                                                    <logic:equal name="Deduction" property="txtRecFlag" value="" >
                                                            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=String.valueOf(i)%>" name="butPayCode"  onclick="doPopulateLov('txtPayCode',this.alt);">
                                                    </logic:equal>
                                                    <logic:notEqual name="Deduction" property="txtRecFlag" value="" >
                                                            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=String.valueOf(i)%>" name="butPayCode" >
                                                    </logic:notEqual>
                                                </td>
                                                <td width="5%">
                                                    <html:text property="txtDesc" name="Deduction" styleClass="locked" readonly="true" style="width:100%"  alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);" />
                                                </td>
                                                <td width="5%" >
                                                    <logic:equal name="Deduction" property="txtRecFlag" value="" >
                                                            <html:text property="txtAmt" name="Deduction" styleClass="required" style="width:100%;;text-align:right" alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);changeTotal();" />
                                                    </logic:equal>
                                                    <logic:notEqual name="Deduction" property="txtRecFlag" value="" >
                                                            <html:text property="txtAmt" name="Deduction" styleClass="required" readonly="true" style="width:100%;;text-align:right" alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);changeTotal();" />
                                                    </logic:notEqual>
                                                </td>
                                            </logic:notEqual>
                                            </logic:notEqual>
                                        </logic:notEqual>
                                        
                                        
                                        <html:hidden property="txtOutAmt" name="Deduction" />
                                        <html:hidden property="txtRecFlag" name="Deduction" />
                                        <html:hidden property="status" name="Deduction" />    
                                        <html:hidden property="detailId" name="Deduction" value="Default"/>
                                        <html:hidden property="txtTransMastId" name="Deduction" />
                                        <html:hidden property="txtOldNewFlag" name="Deduction" />   
                                        <html:hidden property="itemChecked" name="Deduction" value="Default"/>
                                        <html:hidden property="txtDednAdjFlag" name="Deduction" />
                                        <html:hidden property="chkManDednFlag" name="Deduction" />  <!-- added by prachi for CR-709 -->
                                        </tr>
                                </logic:notEqual>

                                <logic:equal name="Deduction" property="status" value="D" >
                                        <tr>
                                                <html:hidden property="txtSerialNo" name="Deduction" />
                                                <td  width="1%" ><html:hidden property="checked" /></td>
                                                <td  width="5%" ><html:hidden property="txtPayCode" name="Deduction"  /></td>
                                                <td  width="5%" ><html:hidden property="txtDesc" name="Deduction"  /></td>
                                                <td  width="5%" ><html:hidden property="txtAmt" name="Deduction"  /></td>
                                                <html:hidden property="txtRecFlag" name="Deduction" />
                                                <html:hidden property="txtOutAmt" name="Deduction" />
                                                <html:hidden property="status" name="Deduction" />
                                                <html:hidden property="detailId" name="Deduction" value="Default"/>
                                                <html:hidden property="txtTransMastId" name="Deduction" />
                                                <html:hidden property="txtOldNewFlag" name="Deduction" />  
                                                <html:hidden property="itemChecked" name="Deduction" value="Default"/>
                                                <html:hidden property="txtDednAdjFlag" name="Deduction" />
                                                <html:hidden property="chkManDednFlag" name="Deduction" />  <!-- added by prachi for CR-709 -->
                                        </tr>      
                                </logic:equal>                                    
                            </logic:iterate>       

                <table>
              </div>
            </td>
          </tr>                                                                                                  
          <tr height=28></tr>
          <!--</table>-->       
          </TABLE>
          <tr>
            <td colspan=11 height=40>	
              <TABLE border=0>
                <TBODY>
                  <TR>
                    <TD><html:button value='Get Detail'  onclick="doGetDetail()" property="butDetail" styleClass="bottomBarText" />
					<html:button value=' Add Row ' onclick="doBaseAddRow()" property="butInsert" styleClass="bottomBarText" disabled="true" />
					<html:button value='Delete Row' onclick="doBaseDelRow()" property="butDelete" styleClass="bottomBarText" />
					<html:button value='Get IT Detail'  onclick="doGetITDetail()" property="butITDetail" styleClass="bottomBarText" />
					</TD>                                     
                              
                  </TR>
                </TBODY>
              </TABLE>
            </TD>
          </tr>
        </td>
      </tr>

      <TR height="70">                    
        <TD width =38%>
          <TABLE cellSpacing="0" cellPadding="0" border = 0 style="">
            <TR>                                                      
              <td width="30%" class=labelText><bean:message key="pay.ComFinalSet.txtTotOutAmt" /></td>
              <td width="20%"><html:text  property="txtOutDed" styleClass="locked" altKey="pay.ComFinalSet.txtTotDed" maxlength="10" size="10" readonly="true" style="text-align:right" /></td>
              <td width="30%" class=labelText><bean:message key="pay.ComFinalSet.txtTotDed" /></td>
              <td width="20%"><html:text  property="txtTotDed" styleClass="locked" altKey="pay.ComFinalSet.txtTotDed" maxlength="10"  size="10" readonly="true" style="text-align:right" /></td>
              </tr>
              <tr><td >&nbsp;</td></tr>
              <TR>
                  <table border=0 cellspacing = 0 cellpadding = 0 >
                  <tr>                  
                    <td colspan = 4 bgcolor=#4682b4 width="100%" align="center">
                      <button  alt="Adjust (Alt+D)"  onclick="confirmation('NEG_INV')" name="butCreateLiab"  disabled="true" class="bottomBarText">Create Recovery </button>                      
                    </td>                                      
                  </tr>
                </table>             
             </TR>	
              <tr><td >&nbsp;</td></tr>
            </table>                                                 
          </td>
        </tr>
      </TBODY>
    </TABLE>                                                 
  </tr>
<!-- Tab table Row 3 starts -->

</TABLE>
</td>
</tr>  
     <!-- Tab Table Ends -->
          <!-- Bottom Blue Bar -->
             <tr height = 5><td>&nbsp;</td></tr>

             <TR>
                  <table border=0 cellspacing = 0 cellpadding = 0 >
                  <tr>
                   <td colspan = 4 align=center bgcolor=#4682b4 width="35%"></td>
                    <td  bgcolor=#4682b4 width="18%">
                      <button  alt="Adjust (Alt+D)"  onclick="doCompute('DED');butDisable('ADJ')" name="butAdjust" class="bottomBarText">Adjust Deductions </button>
                      <button  alt="Salary (Alt+D)"  onclick="confirmation('SAL');butDisable('Sal')" name="butSalary" class="bottomBarText">Release Salary </button>
					<%
					if(strEmpLbrFlag!=null)
					{
						if(!strEmpLbrFlag.equals("E"))
						{
					%>
                      <button  onclick="confirmation('INCT')" name="butIncentive" class="bottomBarText">Release Incentive </button>
					<%}}%>
                      <button  alt="Gratuity (Alt+G)" onclick="confirmation('GRA');butDisable('GRA')" name="butGratuity" class="bottomBarText">Pay Gratuity </button>
                      <button  alt="Approve (Alt+L)"  onclick="confirmation('LEAVE');butDisable('LEAVE')" name="butLeave" class="bottomBarText">Pay Leave Encashment</button>
                      <button  alt="Approve (Alt+L)"  onclick="confirmation('HPL');butDisable('HPL')" name="butPayLpc" class="bottomBarText">Pay HPL Encashment</button>
                      <%
					if(strEmpLbrFlag!=null)
					{
						if(!strEmpLbrFlag.equals("E"))
						{
					%>
                      <button  alt="Approve (Alt+L)" onclick="confirmation('VRS');butDisable('VRS')" name="butPayVrs" class="bottomBarText">Pay VRS </button>
					<%}}%>
                      <button  alt="Approve (Alt+L)"  onclick="doGetReport()" name="butLpc" class="bottomBarText">Generate LPC</button>
                    </td>    
                   <td align=right bgColor=#4682b4 colspan = 3><img src="../INCLUDES/IMAGES/man.jpg"></td>
                  </tr>
                </table>             
             </TR>
			 
			 <TR>
                 <table border=0 cellspacing = 0 cellpadding = 0 >
		         <td>HPL Encashment Invoice No. <html:text property="txtHPLEncInv" name="frmComFinalSet" readonly="true"  size="15" styleClass="locked" /></td>
				 <td>Gratuity Invoice No. <html:text property="txtGratuityInv" name="frmComFinalSet" size="15" readonly="true" styleClass="locked" /></td>
     			 <td>Leave Encashment Invoice No.<html:text property="txtLeaveEncInv" name="frmComFinalSet" size="15" readonly="true" styleClass="locked" /></td>
   				 <td>Last Salary Invoice No.<html:text property="txtLastSalInv"   name="frmComFinalSet" readonly="true" size="15" styleClass="locked" /></td>
     			 <td>OutStanding Invoice No.<html:text property="txtOutStandInv" name="frmComFinalSet" readonly="true" size="15" styleClass="locked" /></td>
                </table>             
             </TR>
			 <TR>
                 <table border=0 cellspacing = 0 cellpadding = 0 >
                         <td>VRS Invoice No. <html:text property="txtVrsInv" name="frmComFinalSet" readonly="true"  size="15" styleClass="locked" /></td>
                         <!--  <%
							if(strEmpLbrFlag!=null)
							{
								if(!strEmpLbrFlag.equals("E"))
								{
							%>
                           
                          
                          <td> VRS Invoice No. <html:text property="txtVrsInv" name="frmComFinalSet" readonly="true"  size="15" styleClass="locked" /></td>
                            <td width = 27%>
							<html:text property="txtVrsInv" name="frmComFinalSet" readonly="true" size="15" styleClass="locked" />
							<%}else{%>
							<html:hidden property="txtVrsInv" name="frmComFinalSet" />
							</td>  
							<%}
							}%>-->
                           
		         <td>Last Incentive Invoice No. <html:text property="txtIncentiveInv" name="frmComFinalSet" readonly="true"  size="15" styleClass="locked" /></td>
                </table>             
             </TR>

			 <table>
				
				<TR>STEPS TO DO INITIALIZE SEPARATION:</TR>

				<TR>Step 1: Enter Separation date and Separation type and press save button. This should be done before Initialise payroll stage.</TR>

				<TR>STEPS TO DO COMPLETE SEPARATION</TR>

				<TR>Step 2: Query the data and Enter the Deduction Details and save the data.</TR>
				<TR>Step 3: Enter the Leave Encashment,HPL, gratuity ( if available) and again save the data.</TR>
				<TR>Step 4: Again reload the page and press on the get detail button on deduction side and verify all the data.</TR>
				<TR>Step 5: If outstanding amount is pending then please click on the 'Adjust Deduction' Button.</TR>
				<TR>Step 6: Click on the Release salary,Leave encashmnent(If Leave encashment amount is available),HPL Encashment (If           HPL amount is available)  and gratuity (If Gratuity amount is available) button.</TR>
				<TR>Step 7: After completing the Separation ,check the Invoice NOs.</TR>
			 </table>
          </TABLE>
          <!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>

<!-- Container Table Ends -->
<html:hidden name="frmComFinalSet"  property="screenName" value="ComFinalSetScreen" />
<html:hidden name="frmComFinalSet"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmComFinalSet" />
<html:hidden property="buttonFlag" name="frmComFinalSet"  />
<html:hidden property="flag" name="frmComFinalSet"  />
<html:hidden property="totalDetailRecord" name="frmComFinalSet" />
<html:hidden property="headerPrimaryKey" name="frmComFinalSet" />
<html:hidden property="positionRequested" name="frmComFinalSet" />
<html:hidden property="userPositionRequested" name="frmComFinalSet" />
<html:hidden property="pageRequested" name="frmComFinalSet" />
<html:hidden property="userPageRequested" name="frmComFinalSet" />
<html:hidden property="lovKey" name="frmComFinalSet"  />
<html:hidden property="txtFields" name="frmComFinalSet"  />   
<html:hidden property="txtSearchFields" name="frmComFinalSet"  />
<html:hidden property="txtDisplayFields" name="frmComFinalSet"  />
<html:hidden property="txtIndex" name="frmComFinalSet"  />
<html:hidden property="headerDataChanged" name="frmComFinalSet" value="false" />
<html:hidden property="loginLocCode" name="frmComFinalSet" />
<html:hidden property="hdnDayWage" name="frmComFinalSet" />
<html:hidden property="txtDepOrg" name="frmComFinalSet" />
<html:hidden property="txtLien" name="frmComFinalSet" />
<html:hidden property="txtBtnAction" name="frmComFinalSet" />
<html:hidden property="flagITDetail" name="frmComFinalSet"  />
<html:hidden property="txtflagITDetail" name="frmComFinalSet"  />
<html:hidden property="txtflagGetDetail" name="frmComFinalSet"  />
<html:hidden property="txtIfGratuityChng" name="frmComFinalSet" />
<input type="hidden" name="queryParam">
<input type="hidden" id="submitParam" name="submitParam" /> 
<html:hidden property="chkEditSepEntry" name="frmComFinalSet" value='N'/>
</html:form>
</body>
</html:html>
<% ReportReader oReportReader=new ReportReader(); %> 
<% ParamUtil oParamUtil=new ParamUtil(); %> 
<script language="javascript">
function lfnLoad()
{
  mode = document.all.screenMode.value;
  var emptype = document.getElementById("hdnEmpLbrFlag").value;
  //alert("mode" + mode)
  if(mode == '')
  {
    doQueryMode();
  }
  menuHandling(mode); 
  if(mode=='Q')
  {
    document.all.txtNoAccELd.disabled="true";
    document.all.butDetail.disabled="true";
    document.all.butITDetail.disabled="true";
    document.all.butInsert.disabled="true";
    document.all.butDelete.disabled="true";
    
    document.all.butAdjust.disabled="true";
    document.all.butGratuity.disabled="true";
    document.all.butLeave.disabled="true";
    document.all.butLpc.disabled="true";
    document.all.butSalary.disabled="true";
     if (emptype == 'L' || emptype == 'D')
    {
     document.all.butPayVrs.disabled="true";
    }
    document.all.butPayLpc.disabled="true"; // added by sonia on 04-04-2011
    
    document.all.txtTotDed.value="";   
    
  }
  if(mode=='N')
  {      
    document.all.butDetail.disabled="true";
    document.all.butITDetail.disabled="true";
    document.all.butInsert.disabled="true";
    
    document.all.butAdjust.disabled="true";
    document.all.butGratuity.disabled="true";
    document.all.butLeave.disabled="true";
	document.all.butPayLpc.disabled="true"; // added by sonia on 04-04-2011
    document.all.butSalary.disabled="true";
    if (emptype == 'L' || emptype == 'D')
    {
     document.all.butPayVrs.disabled="true";
    }
    document.all.txtSepTyp.disabled="";
    document.all.butLpc.disabled="true";
    
  }
  if(mode=='U')
  {
        document.all.EditDetails.disabled="";
      
		document.all.butDetail.disabled="";
		document.all.butCreateLiab.disabled="";
		document.all.txtEmpNo.disabled="true";
		document.all.buttxtEmpNo.src = "../INCLUDES/IMAGES/lov_dis.jpg";
		document.all.buttxtEmpNo.disabled="true";
		document.all.butLpc.disabled="";   
		if(document.all.flag.value!='G')
		{
		  document.all.butDetail.disabled="";
		  document.all.butInsert.disabled="true";
		  document.all.butDelete.disabled="true";
		}
		if(document.all.flag.value=='G' || document.all.flag.value=='D')
		{ 
			  var oTable = document.getElementById("Detail");
			  if(oTable == null)
			  {
				return;
			  }
			  var amt = 0;
			  var outAmt = 0;
			  if(oTable.rows.length == 2)
			  {
				if(document.all.txtAmt.value=='')
				  amt= parseInt(amt,10) + 0;
				else
				  amt= parseInt(amt,10) + parseInt(document.all.txtAmt.value,10);
				if(document.all.txtOutAmt.value=='')
				  outAmt= parseInt(outAmt,10) + 0;
				else
				  outAmt= parseInt(outAmt,10) + parseInt(document.all.txtOutAmt.value,10);
				if(document.all.status.value=='N')
				  document.all.detailDataChanged.value="true";
			  }
			  else
			  {
				for(i=1; i < oTable.rows.length ; i++)
				{
				  var txtAmt=document.all.txtAmt[i-1].value==""?"0":document.all.txtAmt[i-1].value;
				  var txtOutAmt=document.all.txtOutAmt[i-1].value==""?"0":document.all.txtOutAmt[i-1].value;
				  amt= parseInt(amt,10) + parseInt(txtAmt,10);
				  outAmt= parseInt(outAmt,10) + parseInt(txtOutAmt,10);
				  if(document.all.status[i-1].value=='N')
					document.all.detailDataChanged.value="true";
				}
			  }
			  document.all.txtTotDed.value=amt;
			  document.all.txtOutDed.value=outAmt;
         if (document.all.txtOutStandInv.value !='') 
         {     
              document.all.txtOutDed.value=0;
         }       
			  document.all.butDetail.disabled="";
			  document.all.butInsert.disabled="";
			  document.all.butDelete.disabled="";
		}
        
        
	    ////added by sonia on 14-10-2011
		/*if(document.all.txtLeaveEncaSancAmt.value !=0  && document.all.txtHPLEncaSancAmt.value !=0 ){
		 document.all.butITDetail.disabled="";
		}
		else{
		document.all.butITDetail.disabled="true";
		}
		///end*/

		//disableIncomeAmt();
  }

 /* if(document.all.flag.value=='W')
  {
    document.all.txtLeaveEncaSancAmt.value=Math.round(document.all.hdnDayWage.value*document.all.txtNoAccELd.value);
    document.all.txtHPLEncaSancAmt.value = Math.round(document.all.hdnDayWage.value*(document.all.txtHPLNoAccEld.value)/2);    
    document.all.txtLeave.value=document.all.txtLeaveEncaSancAmt.value;
    document.all.txtHPLNetAmt.value = document.all.txtHPLEncaSancAmt.value;
    document.all.headerDataChanged.value="true";
    document.all.flag.value="";
  }*/


  if(document.all.flag.value=='WEL')
  {
    document.all.txtLeaveEncaSancAmt.value=Math.round(document.all.hdnDayWage.value*document.all.txtNoAccELd.value);
    document.all.txtLeave.value=document.all.txtLeaveEncaSancAmt.value;
    document.all.headerDataChanged.value="true";
    document.all.flag.value="";
  }

  if(document.all.flag.value=='WHPL')
  {
    document.all.txtHPLEncaSancAmt.value = Math.round(document.all.hdnDayWage.value*(document.all.txtHPLNoAccEld.value)/2);    
    document.all.txtHPLNetAmt.value = document.all.txtHPLEncaSancAmt.value;
    document.all.headerDataChanged.value="true";
    document.all.flag.value="";
  }
 
  document.all.butDelete.disabled="true";
  if(document.all.txtflagITDetail.value == 'Y')
  {
    document.all.butInsert.disabled="true";
    document.all.butITDetail.disabled="true";
  }
  else
  {
    document.all.butInsert.disabled="";
    document.all.butITDetail.disabled="";
  } 
 ///added by sonia //////////

if(document.all.txtGratuity.value == ''){
    document.all.txtGratuity.value = 0; 
}
if( document.all.txtGraSancAmt.value == ''){
	document.all.txtGraSancAmt.value = 0;
}
if(document.all.txtLeave.value =='' ){
    document.all.txtLeave.value = 0; 
}

if(document.all.txtNetEarning.value == ''){
    document.all.txtNetEarning.value = 0; 
}

if(document.all.txtHPLNetAmt.value == ''){
    document.all.txtHPLNetAmt.value = 0; 
}


if(document.all.txtVrsGrossAmt.value == ''){
    document.all.txtVrsGrossAmt.value = 0; 
}
if( document.all.txtVrsNetAmt.value == ''){
	document.all.txtVrsNetAmt.value = 0;
}

//alert("HPL" + document.all.txtHPLNetAmt.value)

 /////end///////
 
 document.all.txtTotalNetAmt.value=parseInt(document.all.txtHPLNetAmt.value,10)+parseInt(document.all.txtGratuity.value,10)+parseInt(document.all.txtLeave.value,10)+parseInt(document.all.txtNetEarning.value,10)+parseInt(document.all.txtIncentiveAmt.value,10)+parseInt(document.all.txtVrsNetAmt.value,10);  

  
  if(isNaN(document.all.txtTotalNetAmt.value))
    document.all.txtTotalNetAmt.value = 0;   
    
  
  if(mode =='U')
  { 
    if(document.all.txtTotalNetAmt.value ==0 && document.all.txtOutDed.value > 0)
    {
      document.all.butCreateLiab.disabled = document.all.txtOutStandInv.value != ""?"true":"";
    }
    if(document.all.txtTotalNetAmt.value ==0 && document.all.txtOutDed.value == 0)
    {
      document.all.butCreateLiab.disabled = "true";
    }
  }
  
  chkSepTyp();
  if(document.all.txtOutDed.value==0){	
     document.all.butAdjust.disabled="true";
  }

  chkPymnts();

    ////added by sonia on 14-10-2011
	if(document.all.txtLeaveEncaSancAmt.value !=0  && document.all.txtHPLEncaSancAmt.value !=0 ){
	 document.all.butITDetail.disabled="";
	}
	else{
	document.all.butITDetail.disabled="true";
	}
	///end

	disableIncomeAmt();  // added by swapnendu. income components to be freezed after deduction over particular component is done.
}

function disableIncomeAmt()
{
	var adjOnEL="", adjOnHPL="", adjOnGRAT="" ,adjOnVRS=""
	var lveSancAmtEL = document.all.txtLeaveEncaSancAmt.value;
	var netAmtEL = document.all.txtLeave.value;
	var lveSancAmtHPL = document.all.txtHPLEncaSancAmt.value;
	var netAmtHPL = document.all.txtHPLNetAmt.value;
    var sancAmtGRAT = document.all.txtGraSancAmt.value;
	var	netGratuity = document.all.txtGratuity.value;
        var netAmtVRS = document.all.txtVrsNetAmt.value;
        var sancAmtVRS = document.all.txtVrsGrossAmt.value;
	if (eval(lveSancAmtEL) > eval(netAmtEL)) adjOnEL=1;
	if (eval(lveSancAmtHPL) > eval(netAmtHPL)) adjOnHPL=1;
	if (eval(sancAmtGRAT) > eval(netGratuity)) adjOnGRAT=1;
        if (eval(sancAmtVRS) > eval(netAmtVRS)) adjOnVRS=1;
	if (adjOnEL==1)
	{
		document.all.txtNoAccELd.readOnly="true";
		document.all.txtNoAccELd.style.background="#e0e0e0";
		document.all.txtLeaveEncaSancNo.readOnly="true";
		document.all.txtLeaveEncaSancNo.style.background="#e0e0e0";
		document.all.txtLeaveEncaSancDt.style.background="#e0e0e0";
		if(document.all.txtLeaveEncInv.value == "") document.all.txtdate1.disabled="true";
	}
	if (adjOnHPL==1)
	{
		document.all.txtHPLNoAccEld.readOnly="true";
		document.all.txtHPLNoAccEld.style.background="#e0e0e0";
		document.all.txtHPLEncaSancNo.readOnly="true";
		document.all.txtHPLEncaSancNo.style.background="#e0e0e0";
		document.all.txtHPLEncaSancDt.style.background="#e0e0e0";
		if(document.all.txtHPLEncInv.value == "") document.all.txtdate2.disabled="true";
	}
	if (adjOnGRAT==1)
	{
		document.all.txtGraSancNo.readOnly="true";
		document.getElementById("txtGraSancNo").style.background="#e0e0e0";
		document.all.txtGraSancAmt.readOnly="true";
		document.getElementById("txtGraSancAmt").style.background="#e0e0e0";
		document.all.txtGraSancDt.style.background="#e0e0e0";
		if(document.all.txtGratuityInv.value == "") document.all.txtdate3.disabled="true";
	}
        
        if (adjOnVRS==1)
	{
		document.all.txtVrsSancNo.readOnly="true";
		document.getElementById("txtVrsSancNo").style.background="#e0e0e0";
                document.all.txtVrsGrossAmt.readOnly="true";
                document.getElementById("txtVrsGrossAmt").style.background="#e0e0e0";
		document.all.txtVrsSancDt.style.background="#e0e0e0";
		if(document.all.txtVrsInv.value == "") document.all.txtdate4.disabled="true";
	}
	//added by sonia on 16-02-2012
	if (document.all.txtLastSalInv.value != "")
	{
		document.all.butSalary.disabled="true";
	}
	if(document.all.txtLeaveEncInv.value == "" && lveSancAmtEL > 0)
	{
		document.all.butLeave.disabled = "";
	}
	if(document.all.txtHPLEncInv.value == "" && lveSancAmtHPL > 0)
	{
		document.all.butPayLpc.disabled = "";
	}
	if(document.all.txtGratuityInv.value == "" && sancAmtGRAT > 0)
	{
		document.all.butGratuity.disabled = "";
	}
	if(document.all.txtGratuityInv.value != "")
	{
		document.all.graFlag.disabled="true";
	}
        
       if(document.all.txtVrsInv.value == "" && sancAmtVRS > 0)
	{
		document.all.butPayVrs.disabled = "";
	}
	if(document.all.txtOutDed.value > 0 ) 
	{
		if(document.all.txtGratuityInv.value != "" && document.all.txtHPLEncInv.value != "" && document.all.txtLastSalInv.value != "" && document.all.txtLeaveEncInv.value != "" && document.all.txtVrsInv.value != "")
		{
			document.all.butCreateLiab.disabled = "";
		}
		else
		{
			document.all.butCreateLiab.disabled = "true";
		}
	}
	else
	{
		document.all.butCreateLiab.disabled = "true";
	}

	if(lveSancAmtEL > 0 ||   lveSancAmtHPL > 0)
	{
		document.all.butITDetail.disabled = "";
		if(document.all.txtLeaveEncInv.value != "" && document.all.txtHPLEncInv.value != "")
		{
			document.all.butITDetail.disabled = "true";
		}
	}
	//end
}

function doGetTab(arg)
{    
  document.all.forwardedPage.value=arg;
  document.all.flag.value='';
  document.forms[0].action="../../../ComSetTabAction.do";
  
  document.forms[0].submit();
}

function lfnChange(val,ind)
{  
  frmComFinalSet.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[ind-1].value == 'Q')
    document.getElementsByName("status")[ind-1].value = 'U';
}
function lfnHeaderChange(val)
{  
  frmComFinalSet.headerDataChanged.value = "true";
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  for(i=0; i < iTr2 -1; i++)
  {

    frmComFinalSet.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[i].value == 'Q')
       document.getElementsByName("status")[i].value = 'U';  
  }
  
}
function doBaseAddRow()
{
  if(mandatory_Check("frmComFinalSet"))
  {  

    enableFields();
	if(document.all.txtflagGetDetail.value=='')
	{
	   alert("Please press 'Get Detail' button first.");
	   document.all.butInsert.disabled="true";
	   return;
	}
    document.forms[0].action = "../../../DeductionDtlAddRowAction.do";
    document.all.flag.value='G';
    document.forms[0].submit();  
  }
}
function doBaseDelRow()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var strRecList="";
  var iTr2 = oTable.rows.length;
  var i = 0;
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
    
        if ((document.getElementsByName("txtPayCode")[i].value==61)&&(document.getElementsByName("chkManDednFlag")[i].value=='N' || document.getElementsByName("txtOldNewFlag")[i].value=='N')) //system generated entry found
        {
            strRecList+=document.getElementsByName("txtDesc")[i].value+" ("+document.getElementsByName("txtPayCode")[i].value+")";
        }
        else{
            document.getElementsByName("itemChecked")[i].value = "Y";
            frmComFinalSet.detailDataChanged.value = "true";    
            document.all.buttonFlag.value='D';  
        }
    }
  }
    if(strRecList!='')
    {      
        
      document.all.butDelete.disabled="true";
      alert("Sorry You Don't Have permission to Delete System Generated Entry "+strRecList+" ");
      return false;
    }
    else {
      document.all.butDelete.disabled="";
    }

  document.forms[0].action = "../../../DeductionDtlDelRowAction.do";
  document.all.flag.value='G';  
  document.forms[0].submit();  
}
function doQueryMode()
{
  frmComFinalSet.action="../../../ComFinalSetQueryMode.do";
  document.all.flag.value='';
  frmComFinalSet.submit();
}  
function getHeaderRecord()
{ 
 if(document.all.txtEmpNo.value == '')
 {
    alert('Please Select the Employee from the LOV ');
    return false;
 }
  document.all.butExecute.disabled="true";
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
  frmComFinalSet.action="../../../ComFinalSetGetHeaderAction.do";
  document.all.flag.value='';  
  frmComFinalSet.submit();
}
function doGetDetail()
{    
  document.all.txtflagGetDetail.value='N';
  frmComFinalSet.action="../../../ComFinalSetGetDetail.do";
  document.all.flag.value='G';
  frmComFinalSet.submit();
}  

function changeDelete()
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    var fl = 0;
    for(i=0; i < iTr2 - 1; i++)
    {    
      if(document.getElementsByName("checked")[i].checked)
      {
        document.all.butDelete.disabled="";
        return true;
      }
    }
    if(fl == 0)   
    {      
      document.all.butDelete.disabled="true";
      return false;
    }
}
function changeTotal()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var amt = 0;
  var outAmt = 0;
  if(oTable.rows.length == 2)
  {
    amt = parseInt(amt,10) + parseInt(document.all.txtAmt.value,10);
    if(document.all.txtOutAmt.value=='')
      outAmt= parseInt(outAmt,10) + 0;
    else
      outAmt= parseInt(outAmt,10) + parseInt(document.all.txtOutAmt.value,10);
  }
  else
  {
    for(i=1; i < oTable.rows.length; i++)
    {
      amt = parseInt(amt,10) + parseInt(document.all.txtAmt[i-1].value,10);
      if(document.all.txtOutAmt[i-1].value=='')
        outAmt= parseInt(outAmt,10) + 0;
      else
        outAmt= parseInt(outAmt,10) + parseInt(document.all.txtOutAmt[i-1].value,10);
    }
  }
  document.all.txtTotDed.value=amt;
  document.all.txtOutDed.value=outAmt;

}

function doPopulateLov(popupType, val)
{
  if(popupType == 'txtEmpNo')
  {    
    frmComFinalSet.lovKey.value = "ComFinalSetEmpNo" + frmComFinalSet.screenName.value + frmComFinalSet.screenMode.value;
    if(frmComFinalSet.screenMode.value=='N')
    {
      frmComFinalSet.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode,txtCategDesc,txtEmpStatus,txtDsgn,txtPresentPOPDesc,txtEmpType,txtDOJSite,txtDate";
    }
    else
    {
   /*   if(document.all.txtEmpNo.value == '')
      {
        alert('Please Select the Employee from the LOV');  
      }
     */
     frmComFinalSet.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode";
    }
    frmComFinalSet.txtSearchFields.value = "pay.ComFinalSet.txtEmpNo,pay.ComFinalSet.txtEmpName,pay.ComFinalSet.txtCpfCode";
    frmComFinalSet.queryParam.value="txtSiteID="+frmComFinalSet.loginLocCode.value+",hdnEmpLbrFlag="+frmComFinalSet.hdnEmpLbrFlag.value;
    frmComFinalSet.txtIndex.value ="";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmComFinalSet');
    return true;    
  }
  if(popupType == 'txtPayCode')
  {    
    if(document.getElementsByName("status")[val-1].value=='N')
    {
      frmComFinalSet.lovKey.value = "ComFinalSetPayCode" + frmComFinalSet.screenName.value + frmComFinalSet.screenMode.value;
      frmComFinalSet.queryParam.value = "hdnEmpLbrFlag="+frmComFinalSet.hdnEmpLbrFlag.value+",screenName="+frmComFinalSet.screenName.value+",screenMode="+frmComFinalSet.screenMode.value+",txtSiteID="+frmComFinalSet.loginLocCode.value+",txtEmpNo="+frmComFinalSet.txtEmpNo.value; // added by swapnendu Dt 07 Sep 2012.
      frmComFinalSet.txtDisplayFields.value = "txtPayCode,txtDesc";
      frmComFinalSet.txtSearchFields.value = "pay.ComFinalSet.txtPayCode,pay.ComFinalSet.txtDesc";
      frmComFinalSet.txtIndex.value =val-1;      
      showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmComFinalSet');
      return true; 
    }
    return false;
  }
}

function SaveRecord()
{
  document.all.txtflagGetDetail.value = 'N';
  var emptype = document.getElementById("hdnEmpLbrFlag").value;
 // document.all.txtOldNewFlag.value = 'N';
  if(mandatory_Check("frmComFinalSet"))
  {

    var answer = confirm("Have you verified all the data.Press OK to save the record!!!!")
	if (!answer){
		return false;
	}


  if((parseInt(document.all.txtNoAccELd.value) >=0) && (document.all.txtLeaveEncaSancAmt.value == ''))
  {
        alert("EL Leave Encashment Amount can't be null. Please wait till page loads completely or enter the NO. of EL again!");
        document.all.txtNoAccELd.value="";
        document.all.txtNoAccELd.focus();
        return false;
  }

   if((parseInt(document.all.txtHPLNoAccEld.value) >=0) && (document.all.txtHPLEncaSancAmt.value == ''))
  {
        alert("HPL Leave Encashment Amount can't be null. Please wait till page loads completely or Enter the NO. of HPL again!");
        document.all.txtHPLNoAccEld.value="";
        document.all.txtHPLNoAccEld.focus();
        return false;
  }

  if((parseInt(document.all.txtGraSancAmt.value) >=0) && (document.all.txtGratuity.value == ''))
  {
        alert("Net Gratuity Amount Payable can't be null.");
        document.all.txtGraSancAmt.value="";
        document.all.txtGraSancAmt.focus();
        return false;
  }
  if (emptype == 'L' || emptype == 'D')
    {
       if((parseInt(document.all.txtVrsGrossAmt.value) >=0) && (document.all.txtVrsNetAmt.value == ''))
          {
        alert("Net VRS Amount Payable can't be null.");
        document.all.txtVrsGrossAmt.value="";
        document.all.txtVrsGrossAmt.focus();
        return false;
          }
     }
   /*   if(parseInt(document.all.txtNoAccELd.value,10) + parseInt(document.all.txtHPLNoAccEld.value,10) <=300)
      {
        alert("No of El's + HPL's Cannot be greater than 300");
        document.all.txtNoAccELd.value="";
        document.all.txtNoAccELd.focus();
        return false;
      }
   */   
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;


      for(i=0; i < iTr2 -1; i++)
      {
           if (document.getElementsByName("status")[i].value == 'D')
               frmComFinalSet.detailDataChanged.value = "true";
           if (document.getElementsByName("status")[i].value == 'N')
               frmComFinalSet.detailDataChanged.value = "true";
           if (document.getElementsByName("status")[i].value == 'U')
               frmComFinalSet.detailDataChanged.value = "true";
      }
	  frmComFinalSet.headerDataChanged.value="true";
      frmComFinalSet.headerPrimaryKey.value = document.all.txtEmpNo.value;   
      frmComFinalSet.headerFields.value = "true";
      frmComFinalSet.totalDetailRecord.value = parseInt(iTr2,10)-1; 
      frmComFinalSet.buttonFlag.value='S';
      enableFields();
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmComFinalSet.action = "../../../ComFinalSetSaveAction.do";
      frmComFinalSet.submit();
  }
  else
  {
    return false;
  }
}
function doOnChangeCalendar(buttonName)
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  for(i=0; i < iTr2 -1; i++)
  {

    frmComFinalSet.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[i].value == 'Q')
       document.getElementsByName("status")[i].value = 'U';  
  }
}
function doInsertMode()
{
  document.all.buttonFlag.value='';
  //document.all.flag.value='G';
  frmComFinalSet.action="../../../ComFinalSetNewMode.do";
  frmComFinalSet.submit();
}
function doRefresh()
{  
  document.all.buttonFlag.value='';
  frmComFinalSet.action="../../../ComFinalSetRefresh.do"
  frmComFinalSet.submit();
}
function doGetNextHeader()
{ 
  frmComFinalSet.flag.value = "";
  frmComFinalSet.userPositionRequested.value = 1*(frmComFinalSet.positionRequested.value) + 1;  
  frmComFinalSet.action="../../../ComFinalSetGetNextHeader.do";
  frmComFinalSet.submit();
}
function PrevHeader()
{
  frmComFinalSet.flag.value = "";
  frmComFinalSet.userPositionRequested.value = frmComFinalSet.positionRequested.value - 1;
  frmComFinalSet.action = "../../../ComFinalSetGetNextHeader.do";
  frmComFinalSet.submit();
}
function JumpHeader()
{
  frmComFinalSet.flag.value = "";
  frmComFinalSet.userPositionRequested.value = 1*frmComFinalSet.newPositionRequested.value;
  frmComFinalSet.action = "../../../ComFinalSetGetNextHeader.do";
  frmComFinalSet.submit();
}

function getData(val)
{ 
    if(document.all.txtEmpNo.value!="")
    {      
        if(document.all.txtNoAccELd.value == '')     
        {       
          document.all.txtNoAccELd.value = 0 ;          
        }
        
        if(document.all.txtHPLNoAccEld.value == '')
        {        
          document.all.txtHPLNoAccEld.value =0;
        }
        //alert('Total ' +(parseInt(document.all.txtNoAccELd.value,10) + parseInt(document.all.txtHPLNoAccEld.value,10)));
     
   
      if(parseInt(document.all.txtNoAccELd.value,10) + parseInt(document.all.txtHPLNoAccEld.value,10) <=300)
            
      {
        document.all.buttonFlag.value=''; 
        if (val=='EL') document.all.flag.value='WEL';
		else if(val=='HPL') document.all.flag.value='WHPL';

        document.all.headerDataChanged.value="true"; 
        frmComFinalSet.action="../../../ComFinalLeaveEncashParam.do"
        frmComFinalSet.submit();
      }
      else
      {
        alert("Total no. of El & HPL cannot exceed 300");
		if (val=='EL')
		{
			document.all.txtLeaveEncaSancNo.value="";
			document.all.txtNoAccELd.value="";
			document.all.txtLeaveEncaSancDt.value="";
			document.all.txtLeaveEncaSancAmt.value="";
			document.all.txtLeaveEncaSancNo.focus();
		}
		else //HPL
		{
			document.all.txtHPLEncaSancNo.value="";
			document.all.txtHPLNoAccEld.value ="";
			document.all.txtHPLEncaSancDt.value ="";
			document.all.txtHPLEncaSancAmt.value ="";
			document.all.txtHPLEncaSancNo.focus();
		}
        return false;
      }    
    }else
    {
      alert("Please Select an employee first!!!");
    }
}

function chkSepTyp()
{
	//alert("inside chkSepTyp()")
	var emptype = document.getElementById("hdnEmpLbrFlag").value;
    if(document.all.txtSepTyp.value=='EMPSTATUS$DEPU')
    {
      document.getElementById("org").style.display='';
      document.getElementById("lien").style.display='none';
      document.getElementById("none").style.display='none';
      document.getElementById("txtBox").style.display='';
      document.all.txtValue.value=document.all.txtDepOrg.value;
      
      document.all.txtLeaveEncaSancNo.disabled="";
      document.all.txtNoAccELd.disabled="";
      document.all.txtHPLEncaSancNo.disabled=""; //Added by Avtar on 15 Mar 13
      document.all.txtHPLNoAccEld.disabled=""; //Added by Avtar on 15 Mar 13
     // document.all.txtGraSancNo.disabled="true"; //commented  by davinder on 5 Feb 13
     // document.all.txtGraSancAmt.disabled="true";//commented  by davinder on 5 Feb 13
      document.all.txtGraSancNo.disabled=""; //Add by davinder on 5 Feb 13
      document.all.txtGraSancAmt.disabled=""; //Add by davinder on 5 Feb 13
      if(emptype == 'L' || emptype == 'D') 
     {
      document.all.txtVrsSancNo.disabled="true";
      document.all.txtVrsGrossAmt.disabled="true";
     }
      if(document.all.screenMode.value=='U')
      {
		  //alert("chkSepTyp")
        document.all.butLpc.disabled="";
        document.all.butGratuity.disabled=document.all.txtGratuityInv.value != ""?"true":"";
        document.all.butLeave.disabled=document.all.txtLeaveEncInv.value != ""?"true":"";
        document.all.butAdjust.disabled=""; // added by Davinder 1 feb 2013
		document.all.butPayLpc.disabled=document.all.txtHPLEncInv.value != ""?"true":"";
        document.all.butSalary.disabled = document.all.txtLastSalInv.value != ""?"true":"";
		if(emptype == 'L' || emptype == 'D') 
		{
			document.all.butIncentive.disabled = document.all.txtIncentiveInv.value != ""?"true":""; // added by swapnendu Dt 27 jul 12
                         document.all.butPayVrs.disabled = document.all.txtVrsInv.value != ""?"true":"";
		}
      }
    }
    else if(document.all.txtSepTyp.value=='EMPSTATUS$RESGL')
    {
		//alert("inside")
      document.getElementById("lien").style.display='';
      document.getElementById("org").style.display='none';
      document.getElementById("none").style.display='none';
      document.getElementById("txtBox").style.display='';
      document.all.txtValue.value=document.all.txtLien.value;
      
      document.all.txtLeaveEncaSancNo.disabled="";
      document.all.txtNoAccELd.disabled="";
      document.all.txtGraSancNo.disabled="";
      document.all.txtGraSancAmt.disabled="";
      if(emptype == 'L' || emptype == 'D') 
     {
      document.all.txtVrsSancNo.disabled="true";
      document.all.txtVrsGrossAmt.disabled="true";
     }
      
      if(document.all.screenMode.value=='U')
      { 
		 
        document.all.butLpc.disabled="true";
        document.all.butSalary.disabled = document.all.txtLastSalInv.value != ""?"true":"";
        document.all.butLeave.disabled = document.all.txtLeaveEncInv.value != ""?"true":"";                       
        document.all.butGratuity.disabled = document.all.txtGratuityInv.value != ""?"true":"";
        document.all.butPayLpc.disabled = document.all.txtHPLEncInv.value != ""?"true":""; // added by sonia on 04-04-2011 
		if(emptype == 'L' || emptype == 'D') 
		{
			document.all.butIncentive.disabled = document.all.txtIncentiveInv.value != ""?"true":""; // added by swapnendu Dt 27 jul 12
                        document.all.butPayVrs.disabled = document.all.txtVrsInv.value != ""?"true":"";


		}
        document.all.butAdjust.disabled="";        
      }
     
    }
    
     else if(document.all.txtSepTyp.value=='EMPSTATUS$VOLRET')
    {
		//alert("inside")
              
      document.getElementById("none").style.display='';
      document.getElementById("org").style.display='none';
      document.getElementById("lien").style.display='none';
      document.getElementById("txtBox").style.display='none';
      document.all.txtValue.value="";
      
      document.all.txtLeaveEncaSancNo.disabled="";
      document.all.txtNoAccELd.disabled="";
      document.all.txtGraSancNo.disabled="";
      document.all.txtGraSancAmt.disabled="";
     if(emptype == 'L' || emptype == 'D') 
     {
      document.all.txtVrsSancNo.disabled="";
     
      document.all.txtVrsGrossAmt.disabled="";
     }
      if(document.all.screenMode.value=='U')
      { 
		 
        document.all.butLpc.disabled="true";
        document.all.butSalary.disabled = document.all.txtLastSalInv.value != ""?"true":"";
        document.all.butLeave.disabled = document.all.txtLeaveEncInv.value != ""?"true":"";                       
        document.all.butGratuity.disabled = document.all.txtGratuityInv.value != ""?"true":"";
        
       //document.all.butPayVrs.disabled = document.all.txtVrsInv.value != ""?"true":"";
       
		document.all.butPayLpc.disabled = document.all.txtHPLEncInv.value != ""?"true":""; // added by sonia on 04-04-2011 
		if(emptype == 'L' || emptype == 'D') 
		{

                    document.all.butIncentive.disabled = document.all.txtIncentiveInv.value != ""?"true":"";// added by swapnendu Dt 27 jul 12
                    document.all.butPayVrs.disabled = document.all.txtVrsInv.value != ""?"true":"";


		}
        document.all.butAdjust.disabled="";        
      }
     
    }
    else if(document.all.txtSepTyp.value=='EMPSTATUS$DISMISS')
    
	{
      document.getElementById("none").style.display='';
      document.getElementById("org").style.display='none';
      document.getElementById("lien").style.display='none';
      document.getElementById("txtBox").style.display='none';
      document.all.txtValue.value="";
      
      document.all.txtLeaveEncaSancNo.disabled="";
      document.all.txtNoAccELd.disabled="";
      document.all.txtHPLEncaSancNo.disabled="";
      document.all.txtHPLNoAccEld.disabled="";
      //document.all.txtGraSancNo.disabled="true";//commented  by davinder on 5 Feb 13
      //document.all.txtGraSancAmt.disabled="true";//commented  by davinder on 5 Feb 13
	  document.all.txtGraSancNo.disabled=""; //Add by davinder on 5 Feb 13
	  document.all.txtGraSancAmt.disabled=""; //Add by davinder on 5 Feb 13
          if(emptype == 'L' || emptype == 'D') 
     {
      document.all.txtVrsSancNo.disabled="true";
      document.all.txtVrsGrossAmt.disabled="true";
     }
      
      if(document.all.screenMode.value=='U')
      {
        document.all.butLpc.disabled="true";
        document.all.butGratuity.disabled=document.all.txtGratuityInv.value != ""?"true":"";
        document.all.butLeave.disabled=document.all.txtLeaveEncInv.value != ""?"true":"";
        document.all.butAdjust.disabled="";
		document.all.butPayLpc.disabled=document.all.txtHPLEncInv.value != ""?"true":""; // added by sonia on 04-04-2011
        document.all.butSalary.disabled = document.all.txtLastSalInv.value != ""?"true":"";
		if(emptype == 'L' || emptype == 'D') 
		{
			document.all.butIncentive.disabled = document.all.txtIncentiveInv.value != ""?"true":""; // added by swapnendu Dt 27 jul 12
                        document.all.butPayVrs.disabled = document.all.txtVrsInv.value != ""?"true":"";
			
		}
      }

    }
	else if(document.all.txtSepTyp.value=='EMPSTATUS$RELVD')
    {
      document.getElementById("none").style.display='';
      document.getElementById("org").style.display='none';
      document.getElementById("lien").style.display='none';
      document.getElementById("txtBox").style.display='none';
      document.all.txtValue.value="";
      
      document.all.txtLeaveEncaSancNo.disabled="";
      document.all.txtNoAccELd.disabled="";
      document.all.txtHPLEncaSancNo.disabled=""; //Added by Avtar on 15 Mar 13
      document.all.txtHPLNoAccEld.disabled=""; //Added by Avtar on 15 Mar 13
     // document.all.txtGraSancNo.disabled="true"; //commented by davinder on 5 Feb 13
     //  document.all.txtGraSancAmt.disabled="true"; //commented by davinder on 5 Feb 13
	   document.all.txtGraSancNo.disabled=""; //Add by davinder on 5 Feb 13
      document.all.txtGraSancAmt.disabled=""; //Add by davinder on 5 Feb 13
      if(emptype == 'L' || emptype == 'D') 
     {
      document.all.txtVrsSancNo.disabled="true";
      document.all.txtVrsGrossAmt.disabled="true";
     }
     
      if(document.all.screenMode.value=='U')
      {
        document.all.butLpc.disabled="true";
        document.all.butGratuity.disabled=document.all.txtGratuityInv.value != ""?"true":"";
		document.all.butPayLpc.disabled=document.all.txtHPLEncInv.value != ""?"true":""; // added by sonia on 04-04-2011
        document.all.butLeave.disabled=document.all.txtLeaveEncInv.value != ""?"true":"";
        document.all.butAdjust.disabled="";
        document.all.butSalary.disabled = document.all.txtLastSalInv.value != ""?"true":"";
		if(emptype == 'L' || emptype == 'D') 
		{
			document.all.butIncentive.disabled = document.all.txtIncentiveInv.value != ""?"true":""; // added by swapnendu Dt 27 jul 12
                        document.all.butPayVrs.disabled = document.all.txtVrsInv.value != ""?"true":"";
		}
      }
    }
    else
    {
      document.getElementById("none").style.display='';
      document.getElementById("org").style.display='none';
      document.getElementById("lien").style.display='none';
      document.getElementById("txtBox").style.display='none';
      document.all.txtValue.value="";
      
      document.all.txtLeaveEncaSancNo.disabled="";
      document.all.txtNoAccELd.disabled="";
      document.all.txtGraSancNo.disabled="";
      document.all.txtGraSancAmt.disabled="";
      if(emptype == 'L' || emptype == 'D') 
      {
      document.all.txtVrsSancNo.disabled="true";
      document.all.txtVrsSancNo.readOnly="true";
      
      document.all.txtVrsGrossAmt.disabled="true";
      }
      
      if(document.all.screenMode.value=='U')
      { 
        document.all.butSalary.disabled = document.all.txtLastSalInv.value != ""?"true":"";
        document.all.butLeave.disabled = document.all.txtLeaveEncInv.value != ""?"true":"";                       
        document.all.butGratuity.disabled = document.all.txtGratuityInv.value != ""?"true":"";  
		document.all.butPayLpc.disabled = document.all.txtHPLEncInv.value != ""?"true":""; // added by sonia on 04-04-2011
        document.all.butLpc.disabled="true";        
        document.all.butAdjust.disabled="";        

		if(emptype == 'L' || emptype == 'D') 
		{
		
                	document.all.butIncentive.disabled = document.all.txtIncentiveInv.value != ""?"true":"";
                        document.all.butPayVrs.disabled = document.all.txtVrsInv.value != ""?"true":""; // added by swapnendu Dt 27 jul 12
		}
      }
    }

		if(document.all.txtHPLEncInv.value != "")
		{
			document.all.txtHPLNoAccEld.readOnly="true";
			document.all.txtHPLNoAccEld.style.background="#e0e0e0";
			document.all.txtHPLEncaSancNo.readOnly="true";
			document.all.txtHPLEncaSancNo.style.background="#e0e0e0";
			document.all.txtHPLEncaSancDt.style.background="#e0e0e0";
		}
		if(document.all.txtGratuityInv.value != "")
		{
			document.all.txtGraSancNo.readOnly="true";
			document.getElementById("txtGraSancNo").style.background="#e0e0e0";
			document.all.txtGraSancAmt.readOnly="true";
			document.getElementById("txtGraSancAmt").style.background="#e0e0e0";
			document.all.txtGraSancDt.style.background="#e0e0e0";
		}
		if(document.all.txtLeaveEncInv.value != "")
		{
			document.all.txtNoAccELd.readOnly="true";
			document.all.txtNoAccELd.style.background="#e0e0e0";
			document.all.txtLeaveEncaSancNo.readOnly="true";
			document.all.txtLeaveEncaSancNo.style.background="#e0e0e0";
			document.all.txtLeaveEncaSancDt.style.background="#e0e0e0";
		}
                
                if(document.all.txtVrsInv.value != "")
		{
			document.all.txtVrsSancNo.readOnly="true";
                        document.getElementById("txtVrsSancNo").style.background="#e0e0e0";
                        document.all.txtVrsGrossAmt.readOnly="true";
			document.getElementById("txtVrsGrossAmt").style.background="#e0e0e0";
			document.all.txtVrsSancDt.style.background="#e0e0e0";
		}

}

function setTxtValue()
{
    if(document.all.txtSepTyp.value=='EMPSTATUS$DEPU')
    {
     document.all.txtDepOrg.value=document.all.txtValue.value;
     document.all.txtLien.value="";
    }
    else if(document.all.txtSepTyp.value=='EMPSTATUS$RESGL')
    {
     
     
      document.all.txtLien.value=document.all.txtValue.value;
     document.all.txtDepOrg.value="";
     
    }
    else
    {
     document.all.txtDepOrg.value="";
     document.all.txtLien.value="";
    }
}

function enableFields()
{
     document.all.txtLeaveEncaSancNo.disabled="";
     document.all.txtNoAccELd.disabled="";
     document.all.txtGraSancNo.disabled="";
     document.all.txtGraSancAmt.disabled="";
     document.all.txtVrsGrossAmt.disabled="";
     document.all.graFlag.disabled="";
}

function doGetReport()
{  
    var winurl="last_pay_certificate.rdf&P_EMP_NUM="+frmComFinalSet.txtEmpNo.value;
	document.getElementById('butLpc').value="Please wait. File is being downloaded..";
	document.getElementById('butLpc').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.frmCPFFinalPayForm.action="../../../ReportLinkerAction";
	document.frmCPFFinalPayForm.submit();
}

function doCompute(arg)
{
  if(document.all.txtTotDed.value=='')
  {
    alert("There are no deductions for adjustment.Please press Get Detail(if not pressed)");
    return false;
  }
  if(arg!='DED' )
  {       
    /*if(document.all.txtOutDed.value!=0 && arg!='NEG_INV')
    {
     alert("Please Adjust all the Deduction before releasing the Payment");
      return false;
    }*/
  }else
  {
      if(document.all.txtOutDed.value==0)
      {        
        alert("No amount left for Deductions");
        return false;
      }
      if(document.all.txtOutDed.value!=0 && document.all.txtTotalNetAmt.value ==0)
      {        
        alert("Create Liability to adjust the left amount");
        return false;
      }     
      
      frmComFinalSet.flag.value='D';
  }

  if(arg=='DED') document.getElementById("butAdjust").disabled=true;
  if(arg=='SAL') document.getElementById("butSalary").disabled=true;
  if(arg=='GRA') document.getElementById("butGratuity").disabled=true;
  if(arg=='INCT') document.getElementById("butIncentive").disabled=true;
  if(arg=='LEAVE') document.getElementById("butLeave").disabled=true;
  if(arg=='HPL') document.getElementById("butPayLpc").disabled=true; 
  if(arg=='VRS') document.getElementById("butPayVrs").disabled=true; 
  if (arg=='NEG_INV')  document.getElementById("butCreateLiab").disabled=true;

  frmComFinalSet.txtBtnAction.value=arg;
  frmComFinalSet.headerFields.value = "true";
  frmComFinalSet.action = "../../../ComFinalSetAction.do";
  frmComFinalSet.submit();  
}

function setGraAmt()
{
  document.all.txtGratuity.value=document.all.txtGraSancAmt.value;
}

function setVrsAmt()
{
  document.all.txtVrsNetAmt.value=document.all.txtVrsGrossAmt.value;
}


function doGetITDetail()
{
 // alert('h');
  var count =0;
   count = count + 1;
   document.all.txtflagGetDetail.value='IT';
  document.all.butInsert.disabled="true";
 // frmComFinalSet.action="../../../ComFinalITAction.do";
 frmComFinalSet.action="../../../ComFinalSetGetDetail.do";
 
 // document.all.flag.value='G';
  frmComFinalSet.headerFields.value = "true";
  chkAddRow(count);
  frmComFinalSet.submit();
}  

function chkAddRow(cnt)
{
//  alert('cnt '+cnt);
  document.all.flagITDetail.value = cnt;
//  document.all.txtflagITDetail.value = cnt;
  if(cnt > 0)
  {
    document.all.butInsert.disabled="true";
  }
}

function doDelete(arg)
{
	var type=arg;
	if(type=='L')
	{
		if (!(document.all.txtLeaveEncaSancAmt.value != ""))
		{
			alert("Leave Encashment amount is NULL");
			return;
		}
	}
	if (type=='H')
	{
		if (!(document.all.txtHPLEncaSancAmt.value != ""))
		{
			alert("HPL Encashment amount is empty");
			return;
		}
	}
	if (type=='G')
	{
		if (!(document.all.txtGraSancAmt.value != ""))
		{
		 alert("Gratuity amount is empty");
		 return;
		}
	}


       if(type=='V')
	{
		if (!(document.all.txtVrsGrossAmt.value != ""))
		{
			alert("VRS amount is NULL");
			return;
		}
	}
 	if (type=='A')
	{
		if (!(document.all.txtLeaveEncaSancAmt.value != ""))
		{
			alert("Leave Encashment amount is NULL");
			return;
		}
		if (!(document.all.txtHPLEncaSancAmt.value != ""))
		{
			alert("HPL Encashment amount is empty");
			return;
		}
		if (!(document.all.txtGraSancAmt.value != ""))
		{
			alert("Gratuity amount is empty");
			return;
		}
	}

	if(confirm("Do you want to delete entry"))
	{
		//document.getElementsByName("butGratEdit").disabled="true";
		frmComFinalSet.headerFields.value = "true";
		frmComFinalSet.action = "../../../EditFinalSetAction.do?param1="+arg;
		frmComFinalSet.submit(); 
		
	} 
}

function doEdit(ARG)
{
    frmComFinalSet.chkEditSepEntry.value='E'; 
    alert("Are you sure you want to edit the entry ?");
    frmComFinalSet.headerFields.value = "true";
    document.all.EditDetails.disabled="true";
           document.all.txtSepTyp.disabled="";
           document.all.txtDate.disabled="";
          document.getElementById("manish").onclick = showCalender;
     
	
}
function doDisable()
{
alert("disable");
    document.all.butEdit.disabled="true";
    document.all.butGrat.disabled="true";
    document.all.butHpl.disabled="true";
    document.all.butEl.disabled="true";
    document.all.butAll.disabled="true";
    document.all.butDel.disabled="true";
    document.all.butEdit.disabled="true";
    document.all.butVrs.disabled="true";
}
function showCalender()
{

    showCalendar('txtDate',this);
}
function confirmation(arg) {
	if(arg == "LEAVE")
	{
		if(document.all.txtLeaveEncaSancAmt.value == 0){
		alert("Please check your Leave Encashment Amount");
		return false;
		}
	}

	if(arg == "HPL")
	{
		 if(document.all.txtHPLEncaSancAmt.value == 0){
		alert("Please check your HPL Encashment Amount");
		return false;
		}
	}

	if(arg == "GRA")
	{
		if(document.all.txtGraSancAmt.value == 0){
		alert("Please check your Gratuity Sanction Amount");
		return false;
		}
	}
        
        if(arg == "VRS")
	{
		 if(document.all.txtVrsGrossAmt.value == 0){
		alert("Please check your VRS Amount");
		return false;
		}
	}

	if(document.all.txtOutDed.value>0)
	{
		var answer = confirm("Outstanding amount is still pending.Do you want to continue?")
		if (answer)
		{
			doCompute(arg);
		}
		else
		{
			return false;
		}
	}
	else
	{
		doCompute(arg);
	}

}

 function chkElamt(a,b)
{

  document.getElementById(a).value='';
  document.getElementById(b).value='';
}

function chkPymnts() {	
	
	var emptype = document.getElementById("hdnEmpLbrFlag").value;
	if(document.all.txtLeaveEncaSancAmt.value == 0){	
	document.all.butLeave.disabled="true";
	}
	if(document.all.txtHPLEncaSancAmt.value == 0){		
	document.all.butPayLpc.disabled="true";
	}
	if(document.all.txtGraSancAmt.value == 0){
	document.all.butGratuity.disabled="true";
	}
	if(document.all.txtNetEarning.value == 0){
	 document.all.butSalary.disabled="";
        
        if(document.all.txtVrsGrossAmt.value == 0){
	 document.all.butPayVrs.disabled=""; }
         
	}
	  //added by geetika on 01/07/2014 to allow Send Invoice even if Invoice Amount is 0.
	/*if(emptype != 'E')
	{
		if(document.all.txtIncentiveAmt.value == 0) document.all.butIncentive.disabled="true";
	}*/



   
}
function butDisable(arg)
{
//alert ("hello"+ arg);
document.all.butAdjust.disabled="true";
document.all.butSalary.disabled="true";
document.all.butLeave.disabled="true";
document.all.butGratuity.disabled="true";
document.all.butPayVrs.disabled="true";
document.all.butPayLpc.disabled="true";
}
</script>

