<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
	<HEAD>
    <html:base/>
	<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />  
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>      
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </head>
  <BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintNWNPLbrSORDetailBase" name="frmNWNPLbrSORForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.NWNPLabourSORInfoForm">
  <bean:define id="ParentForm" name="frmNWNPLbrSORForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>  
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>  
  <% i = 0;j=0; %>       

  <table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>NWNP LABOUR SOR INFORMATION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
   <TR>
    <TD>
    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
       
             <tr>
              <td  width="15%" class=labelText><bean:message key="Payroll.Labour.region" /></td>
            <td width="25%">                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrSORForm" value="U"> 
            <html:text  property="txtRegName" styleClass = "locked" altKey="Payroll.Labour.region" readonly="true" maxlength="100" size="23" onchange=""/>            </logic:equal>                                                                                                 
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrSORForm" value="U">                              
            <html:text  property="txtRegName" styleClass = "locked" altKey="Payroll.Labour.region" readonly="true" maxlength="100" size="23" onchange=""/>            </logic:notEqual>
            </td>
            
             <td class=labelText width=15%><bean:message key="Payroll.Labour.effDate" /> </td>            
            <td>                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrSORForm" value="Q">
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" />
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrSORForm" value="Q">                              
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required"/>
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:notEqual>            
            </td>
            
         </tr>
         <tr>
            <td  width="15%" class=labelText><bean:message key="Payroll.Labour.Loc" /></td>
            <td width="25%">                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrSORForm" value="U"> 
            <html:text  property="txtLocation" maxlength="20" size="23" titleKey="Payroll.Labour.Loc" styleClass="required" readonly="true"/>                  
            </logic:equal>                                                                                                 
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrSORForm" value="U">                              
            <html:text  property="txtLocation" maxlength="20" size="23" titleKey="Payroll.Labour.Loc" readonly="true" styleClass="required"  onchange="" /> 
            
            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtSection" onclick="return ShowLovLocation();" readonly="true">
            </logic:notEqual>
            </td>
               
       <!--     
            <td class=labelText width=15%><bean:message key="Payroll.Labour.effDate" /> </td>            
            <td>                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrSORForm" value="Q">
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required" />
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrSORForm" value="Q">                              
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required"/>
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:notEqual>            
            </td>
         -->   
            <td class=labelText width=15%><bean:message key="Payroll.Labour.effEndDate" /> </td>            
            <td>                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrSORForm" value="Q">
            <html:text  property="txtEndDate" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effEndDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked" />            
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrSORForm" value="Q">                              
            <html:text  property="txtEndDate" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effEndDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked"/>      
            </logic:notEqual>
             </td>  
             </tr>
            
        <tr height=5>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
	 
	 <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >               
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > NWNP Labour SOR Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
                 <TR height=10>
                   <!-- Detail table Container starts -->
                    <TD colspan=11>
                      <TABLE cellSpacing=0 cellPadding=0 border=0>
                        <TBODY>
                          <TR>
                           <TD >
                            <DIV id=divDtlTable style="height:320px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                <TBODY>
                            <!--    <TR height="22">
                                    <td class=tableHeader width="3%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                                    <td class=tableHeader width="30%">Kind of Service/Operation</td>
                                    <td class=tableHeader width="10%">Base Year</td>
                                    <td class=tableHeader width="10%">SOR Rate(Bag <= 50kg)</td>
                                    <td class=tableHeader width="10%">SOR Rate(Bag <= 65kg)</td>
                                    <td class=tableHeader width="10%">SOR Rate(Bag > 75kg)</td>
                                    <td class=tableHeader width="10%">SOR Rate(Bag < 65kg)</td>
                                    <td class=tableHeader width="10%">SOR Rate(Bag > 65kg)</td>

                                </TR> -->
                                <TR height="22">
                                    <td class=tableHeader width="3%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                                    <td class=tableHeader width="30%">Kind of Service/Operation</td>
                                    <td class=tableHeader width="10%">Base Year</td>
                                    <td class=tableHeader width="10%">SOR Rate(Bag <= 50kg)</td>
                                    <td class=tableHeader width="10%">SOR Rate(Bag <= 75kg)</td>
                                    <td class=tableHeader width="10%">SOR Rate(Bag > 75kg)</td>
                                    <td class=tableHeader width="10%">SOR Rate(Bag < 65kg)</td>
                                    <td class=tableHeader width="10%">SOR Rate(Bag > 65kg)</td>
                                    <td class=tableHeader width="30%">Piece Wise Rates</td>

                                    
                                </TR>
                             <logic:iterate id="NWNPLbrSORInfo" name="frmNWNPLbrSORForm" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.NWNPLabourSORDtlBean" indexId="idx" >
                              <% ++i; %>
                               <logic:notEqual name="NWNPLbrSORInfo" property="status" value="D" > 
                                    <logic:equal name="NWNPLbrSORInfo" property="status" value="N" >
                                   <tr>
                                        <td align = "center"><html:checkbox property="checked" onclick="checkRecord();" name="frmNWNPLbrSORForm" /></td>                                        
                                         <td>
                                         <html:textarea cols="40" rows="1"  property="txtOperation"  name="NWNPLbrSORInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 95%"  readonly="true"/>
                                     <!--    <html:text property="txtOperation" name="NWNPLbrSORInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 95%"  /> -->
                                        <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="middle" name="buttxtoperation" alt="<%=String.valueOf(i)%>" onclick="return ShowOperations(this.alt);">
                                        </td>
                                        
                                         <td ><html:text property="txtBaseYr" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        }  " />
                                        </td>
                                        <td ><html:text property="txtSorRateUpto50" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>
                                         <td ><html:text property="txtSorRateUpto75" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>
                                         <td ><html:text property="txtSorRateabove75" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>
                                        <td ><html:text property="txtBagRateBlw65" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>
                                        
                                        <td ><html:text property="txtBagRateAbv65" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                         if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td> 
                                       <td ><html:text property="txtPieceWiseRate" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                         if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>                                       
                                   </tr>
                                  </logic:equal>
                                  <logic:notEqual name="NWNPLbrSORInfo" property="status" value="N" >
                                   <tr>
                                       <td align = "center"><html:checkbox property="checked" onclick="checkRecord();" name="frmNWNPLbrSORForm" /></td>                                        
                                         <td>
                                         <html:textarea cols="40" rows="1"  property="txtOperation"  name="NWNPLbrSORInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 95%"  readonly="true" />
                                       <!--  <html:text property="txtOperation"  name="NWNPLbrSORInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 95%"  /> -->
                                        <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="middle" name="buttxtoperation" alt="<%=String.valueOf(i)%>" onclick="return ShowOperations(this.alt);">
                                        </td>
                                        
                                         <td ><html:text property="txtBaseYr" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>
                                        <td ><html:text property="txtSorRateUpto50" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>
                                         <td ><html:text property="txtSorRateUpto75" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>
                                         <td ><html:text property="txtSorRateabove75" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>
                                        <td ><html:text property="txtBagRateBlw65" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>
                                        
                                        <td ><html:text property="txtBagRateAbv65" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                         if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td> 
                                         <td ><html:text property="txtPieceWiseRate" maxlength="9" name="NWNPLbrSORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                         if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        } " />
                                        </td>     
                                </tr>
                                  </logic:notEqual>
                                       <html:hidden property="itemChecked" name="NWNPLbrSORInfo"  />
                                       <html:hidden property="status" name="NWNPLbrSORInfo" />
                                       <html:hidden property="detailId" name="NWNPLbrSORInfo" />  
                              </logic:notEqual>                               
                                 
                                <logic:equal name="NWNPLbrSORInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmNWNPLbrSORForm" value="notchecked" /></td>
                                       <td ><html:hidden property="txtOperation" name="NWNPLbrSORInfo" /></td>
                                       <td ><html:hidden property="txtBaseYr" name="NWNPLbrSORInfo" /></td>
                                       <td ><html:hidden property="txtSorRateUpto50" name="NWNPLbrSORInfo" /></td>                                                                        
                                       <td ><html:hidden property="txtSorRateUpto75" name="NWNPLbrSORInfo" /></td>
                                       <td ><html:hidden property="txtSorRateabove75" name="NWNPLbrSORInfo" /></td>
                                       <td ><html:hidden property="txtBagRateAbv65" name="NWNPLbrSORInfo" /></td>
                                       <td ><html:hidden property="txtBagRateBlw65" name="NWNPLbrSORInfo" /></td>
                                       <td ><html:hidden property="txtPieceWiseRate" name="NWNPLbrSORInfo" /></td>
                                       <html:hidden property="itemChecked" name="NWNPLbrSORInfo" />
                                       <html:hidden property="status" name="NWNPLbrSORInfo" />
                                       <html:hidden property="detailId" name="NWNPLbrSORInfo" />
                                    </tr>
                                  </logic:equal>                                                                                                 
                                  </logic:iterate>
                                </TBODY>
                                </TABLE>
                              </DIV>
                             </TD>
			</TR>
              <!-- Get details starts -->
              
                            <tr>
                              <td colspan=11>	
                                <TABLE border=0>
                                  <TBODY>
                                 <tr>
                                  <td colspan=11>	
                                  <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                                  </TD>
                                </tr>
                              </TBODY>
                            </TABLE>
                          </TD>
                        </tr>                        
                      </TBODY>
                    </TABLE>
                  </td>
                </tr>
              </TABLE>
            </td>
          </tr>
	 
	 
	    <TR>
            <td colspan=11>
              <jsp:include  page = "../INCLUDES/BottomBlueBar.jsp" flush="true" />
            </td>
          </TR>
		  
	 </TABLE>
	</TD>
 	 </TR> 

</TBODY>
</TABLE>
</div>
<!-- Container Table Ends -->
<html:hidden name="frmNWNPLbrSORForm"  property="screenName" value="MaintNWNPLbrSORDtlScreen" />
<html:hidden name="frmNWNPLbrSORForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmNWNPLbrSORForm" />
<html:hidden property="positionRequested" name="frmNWNPLbrSORForm" />
<html:hidden property="userPositionRequested" name="frmNWNPLbrSORForm"/>
<html:hidden property="pageRequested" name="frmNWNPLbrSORForm" />
<html:hidden property="userPageRequested" name="frmNWNPLbrSORForm"/>
<html:hidden property="totalDetailRecord" name="frmNWNPLbrSORForm"  />
<html:hidden property="screenModeSOR" name="frmNWNPLbrSORForm"  />
<html:hidden property="screenModeSOR1" name="frmNWNPLbrSORForm"  />
<html:hidden property="screenModeSOR2" name="frmNWNPLbrSORForm"  />

<html:hidden property="buttonFlag" name="frmNWNPLbrSORForm"  />
<html:hidden property="lovKey" name="frmNWNPLbrSORForm"  />
<html:hidden property="txtFields" name="frmNWNPLbrSORForm"  />   
<html:hidden property="txtSearchFields" name="frmNWNPLbrSORForm"  />
<html:hidden property="txtDisplayFields" name="frmNWNPLbrSORForm" />
<html:hidden property="txtIndex" name="frmNWNPLbrSORForm"  />
<html:hidden property="loginLocCode" name="frmNWNPLbrSORForm" />
<html:hidden property="txtRegCode" name="frmNWNPLbrSORForm" />
<html:hidden property="effStartDate" name="frmNWNPLbrSORForm" />                                         
<html:hidden property="txtLocId" name="frmNWNPLbrSORForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>


<script language="javascript">

function lfnLoad()
{   
    
    mode = document.all.screenMode.value; 
    if (mode != '')
    {
      getRegion_id();
    }  
    if(mode == '')
    {
        doQueryMode();
    }
    if (frmNWNPLbrSORForm.screenMode.value == "Q")
    {
        frmNWNPLbrSORForm.screenModeSOR.value="Q";
        document.all.butGetDetail.disabled="disabled";  
        document.all.butInsert.disabled="true";
    }
        
    mode = frmNWNPLbrSORForm.screenModeSOR.value;        

    if(mode=='')
   {
     document.all.butGetDetail.disabled="disabled";   
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
   }
    if(mode=='Q' && document.all.screenMode.value=='U')
    {
       document.all.butGetDetail.disabled="";
       document.all.butInsert.disabled="disabled";
       document.all.butDelete.disabled="disabled";     
    } 
   
    if(mode=='U')
    {
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";
    }
  
    if(mode=='N')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="true";
    }
    if(mode=='N1')
    {
        document.all.butGetDetail.disabled="true";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="true";
    }
  
    if(mode=='UG')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="true";
        frmNWNPLbrSORForm.screenModeSOR2.value="U";
    }
     if (frmNWNPLbrSORForm.screenMode.value == 'U')
     { 
          document.getElementById("headerPrimaryKey").disabled = "true";
          var oTable = document.getElementById("Detail");
          if(oTable == null)
          {
              return;
          }
          var iTr2 = oTable.rows.length;
          var i = 0;
          
          for(i=0; i < iTr2 -1; i++)
          {
              if (document.getElementsByName("status")[i].value == 'Q')
              {              
              }
          }        
      }
      else
      {  
         document.getElementById("headerPrimaryKey").disabled="";       
      }  
  mode1 = document.all.screenMode.value;  
  menuHandling(mode1);
 

}


function checkDuplicacy(that,rInd)
{
    lengthOfTable = document.getElementById("Detail").rows.length;
    newComb = document.getElementsByName("txtOperation")[rInd-1].value;
    
    for(ind = lengthOfTable - 1; ind > 0; ind --)
    {
        if(ind != rInd)
        {
            oldComb = document.getElementsByName("txtOperation")[ind-1].value;
            
            if(oldComb == newComb)
            {
                alert("You can\'t enter duplicate value");
               // document.getElementsByName("txtOperation")[rInd-1].focus();                
                return;
            }
        }
    }
}

function SaveRecord()
{    
    if(!mandatory_Check("frmNWNPLbrSORForm"))
        return false;  
  //if(!AmtCheck())
      //return false;  
  
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
            frmNWNPLbrSORForm.detailDataChanged.value = "true";
    }
    
    
    frmNWNPLbrSORForm.screenModeSOR1.value = frmNWNPLbrSORForm.screenModeSOR2.value;
    if (document.all.screenMode.value == "N")
    {
        document.all.screenModeSOR.value = "UG";
        document.all.screenMode.value = "U";    
    }  
    document.all.buttonFlag.value='';    
    frmNWNPLbrSORForm.effStartDate.value = frmNWNPLbrSORForm.headerPrimaryKey.value;
    frmNWNPLbrSORForm.headerFields.value = "true";       
    frmNWNPLbrSORForm.totalDetailRecord.value = parseInt(iTr2,10) - 1;    
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmNWNPLbrSORForm.action = "../../../NWNPLbrSORSaveAction.do";  
    frmNWNPLbrSORForm.submit();
    
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmNWNPLbrSORForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmNWNPLbrSORForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmNWNPLbrSORForm.action="../../../NWNPLbrSORGetHeaderAction.do"
    frmNWNPLbrSORForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmNWNPLbrSORForm.screenModeSOR.value="Q";
    frmNWNPLbrSORForm.userPositionRequested.value = 1*frmNWNPLbrSORForm.positionRequested.value + 1;    
    frmNWNPLbrSORForm.action="../../../NWNPLbrSORGetNextHeader.do";
    frmNWNPLbrSORForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmNWNPLbrSORForm.screenModeSOR.value="Q";
    frmNWNPLbrSORForm.userPositionRequested.value = 1*frmNWNPLbrSORForm.positionRequested.value - 1;
    frmNWNPLbrSORForm.action = "../../../NWNPLbrSORGetPrevHeader.do";
    frmNWNPLbrSORForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmNWNPLbrSORForm.screenModeSOR.value="Q";
    frmNWNPLbrSORForm.userPositionRequested.value = 1*frmNWNPLbrSORForm.newPositionRequested.value;
    frmNWNPLbrSORForm.action = "../../../NWNPLbrSORGetNextHeader.do";
    frmNWNPLbrSORForm.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmNWNPLbrSORForm.userPageRequested.value = 1*frmNWNPLbrSORForm.newPageRequested.value ;
    frmNWNPLbrSORForm.action = "../../../NWNPLbrSORNextDetailAction.do";
    frmNWNPLbrSORForm.submit();
}

function doInsertMode()
{    
    document.all.screenMode.value = "N";
    document.all.screenModeSOR.value = "N";    
    document.all.screenModeSOR1.value = "N";
    document.all.screenModeSOR2.value = "N";
    document.all.buttonFlag.value='';
    
    frmNWNPLbrSORForm.action="../../../NWNPLbrSORNewMode.do"
    frmNWNPLbrSORForm.submit();
}

function doQueryMode()
{   
    frmNWNPLbrSORForm.headerPrimaryKey.value="";
    document.all.buttonFlag.value='';
    document.all.screenModeSOR.value = "Q";
    document.all.screenMode.value = "Q";    
    frmNWNPLbrSORForm.action="../../../NWNPLbrSORQueryMode.do"
    frmNWNPLbrSORForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmNWNPLbrSORForm.action="../../../NWNPLbrSORRefresh.do"
    frmNWNPLbrSORForm.submit();
}

function GetDetail()
{
    document.all.buttonFlag.value='';      
    document.all.screenModeSOR.value='UG';
    frmNWNPLbrSORForm.action="../../../NWNPLbrSORGetDetailAction.do"
    frmNWNPLbrSORForm.submit();
}

  function doBaseAddRow()
{
    document.all.buttonFlag.value='D';    
    if(mandatory_Check("frmNWNPLbrSORForm"))
    { 
        if (frmNWNPLbrSORForm.screenModeSOR.value=="UG")
            frmNWNPLbrSORForm.screenModeSOR2.value=="U";
        frmNWNPLbrSORForm.screenModeSOR.value="N1";
        document.getElementById("headerPrimaryKey").disabled="";
        document.forms[0].action = "../../../NWNPLbrSORAddRowAction.do";
        document.forms[0].submit();
    }
    else
    {
        return false;
    }
}

function doBaseDelRow()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  var strRecList='';
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
	  //alert(document.getElementsByName("itemChecked")[i].value)
      document.getElementsByName("itemChecked")[i].value = "Y";
      //frmDpsLbrSORForm.detailDataChanged.value = "true";
    }
  }
  document.forms[0].action = "../../../NWNPLbrSORDeleteRowAction.do";
  document.forms[0].submit();  
}

function changed(val)
{ 
    frmNWNPLbrSORForm.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
        document.getElementsByName("status")[val-1].value = 'U';
} 

function ShowLovLocation()
{   
    //alert("NWNPDepotList" + frmNWNPLbrSORForm.screenName.value + frmNWNPLbrSORForm.screenMode.value);
   frmNWNPLbrSORForm.lovKey.value = "NWNPDepotList" + frmNWNPLbrSORForm.screenName.value + frmNWNPLbrSORForm.screenMode.value;   
   frmNWNPLbrSORForm.txtDisplayFields.value = "txtLocId,txtLocation";
   frmNWNPLbrSORForm.queryParam.value = "txtSiteID="+frmNWNPLbrSORForm.loginLocCode.value+"";
   frmNWNPLbrSORForm.txtSearchFields.value = "Payroll.Labour.LocId,Payroll.Labour.Loc";
   //frmNWNPLbrSORForm.txtInputField.value =""; 
   //frmNWNPLbrSORForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmNWNPLbrSORForm');
   return true;
}

function ShowOperations(i)
{

    //frmNWNPLbrSORForm.queryParam.value="txtMou="+ frmMaintWrkSlip.hdnMou.value;    
    frmNWNPLbrSORForm.lovKey.value = "NWNPOpertaionList" + frmNWNPLbrSORForm.screenName.value + frmNWNPLbrSORForm.screenMode.value;
    frmNWNPLbrSORForm.txtDisplayFields.value = "detailId,txtOperation";
    frmNWNPLbrSORForm.txtIndex.value=i-1;
    frmNWNPLbrSORForm.txtSearchFields.value = "";
    //frmNWNPLbrSORForm.multipleFlag.value = "";
    //frmNWNPLbrSORForm.txtInputField.value = "txtHndlngNorm";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmNWNPLbrSORForm');
    return true;
}
function getRegion_id()
{//alert("call ajax");
	url="../../../GetEmpDtlRetroParZone.do";
    prm="mode=1&txtSiteID="+frmNWNPLbrSORForm.loginLocCode.value+"&screenName="+frmNWNPLbrSORForm.screenName.value;
    //alert(prm);
	xml=getXML(url,prm);
	Tags=xml.getElementsByTagName("record");
        if(Tags.length > 0)
	{ 
        //alert("Tags[0].childNodes[0].nodeValue"+Tags[0].childNodes[0].nodeValue);
		frmNWNPLbrSORForm.txtRegCode.value=Tags[0].childNodes[0].nodeValue;
                frmNWNPLbrSORForm.txtRegName.value=Tags[1].childNodes[0].nodeValue;
              //  alert("value fill");
        }
	else
	{
		alert("Somthing Wrong Please Contact Administrator");
	}

}

</script>

