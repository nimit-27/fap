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
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css"></link>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </head>
  <BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintNWNPLbrASORRateBase" name="frmNWNPLbrASORForm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.NWNPLabourASORInfoForm">
  <bean:define id="ParentForm" name="frmNWNPLbrASORForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>  
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>  
  <% i = 0;j=0; %>       

  <table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>NWNP LABOUR ASOR Details</TD>
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
            <logic:equal property= "screenMode" name= "frmNWNPLbrASORForm" value="U"> 
            <html:text  property="txtRegName" styleClass = "locked" altKey="Payroll.Labour.region" readonly="true" maxlength="100" size="23" onchange=""/>            </logic:equal>                                                                                                 
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrASORForm" value="U">                              
            <html:text  property="txtRegName" styleClass = "locked" altKey="Payroll.Labour.region" readonly="true" maxlength="100" size="23" onchange=""/>            </logic:notEqual>
            </td>
            
           <%--  <td class=labelText width=15%><bean:message key="Payroll.Labour.effDate" /> </td>            
            <td>                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrASORForm" value="Q">
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required" />
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrASORForm" value="Q">                              
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required"/>
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:notEqual>            
            </td>
            --%>

            <td  width="15%" class=labelText><bean:message key="Payroll.Labour.Loc" /></td>
            <td width="25%">                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrASORForm" value="U"> 
            <html:text  property="txtLocation" maxlength="20" size="23" titleKey="Payroll.Labour.Loc" styleClass="required" readonly="true"/>                  
            </logic:equal>                                                                                                 
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrASORForm" value="U">                              
            <html:text  property="txtLocation" maxlength="20" size="23" titleKey="Payroll.Labour.Loc" readonly="true" styleClass="required"  onchange="" /> 
            
            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtSection" onclick="return ShowLovLocation();" readonly="true"></img>
            </logic:notEqual>
            </td>

         </tr>
         <tr>
            
               
       <!--     
            <td class=labelText width=15%><bean:message key="Payroll.Labour.effDate" /> </td>            
            <td>                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrASORForm" value="Q">
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required" />
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrASORForm" value="Q">                              
            <html:text  property="headerPrimaryKey" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="required"/>
            <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" property="headerPrimaryKey" onclick="showCalendar('headerPrimaryKey',this)" />
            </logic:notEqual>            
            </td>
         -->   
           <%-- <td class=labelText width=15%><bean:message key="Payroll.Labour.effEndDate" /> </td>            
            <td>                  
            <logic:equal property= "screenMode" name= "frmNWNPLbrASORForm" value="Q">
            <html:text  property="txtEndDate" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effEndDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked" />            
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmNWNPLbrASORForm" value="Q">                              
            <html:text  property="txtEndDate" altKey="Payroll.Labour.effDate" titleKey="Payroll.Labour.effEndDate" maxlength="15" size="23" onchange="" readonly="true" styleClass="locked"/>      
            </logic:notEqual>
             </td>  --%>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText > NWNP Labour ASOR Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                <TR height="22">
                                    <td class=tableHeader width="3%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                                    <%--<td class=tableHeader width="10%">DEPOT NAME</td>--%>
                                    <td class=tableHeader width="10%">ASOR PERCENTAGE(%)</td>
                                    <td class=tableHeader width="10%">GODOWN TYPE</td>
                                    <td class=tableHeader width="10%">EFF FROM DATE</td>
                                    <td class=tableHeader width="10%">EFF END DATE</td>
                                  <!--  <td class=tableHeader width="10%">ASOR Rate(Bag < 65kg)</td>
                                    <td class=tableHeader width="10%">ASOR Rate(Bag > 65kg)</td> -->

                                </TR> 
                             <logic:iterate id="NWNPLbrASORInfo" name="frmNWNPLbrASORForm" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.NWNPLabourASORDtlBean" indexId="idx" >
                              <% ++i; %>
                               <logic:notEqual name="NWNPLbrASORInfo" property="status" value="D" > 
                                    <logic:equal name="NWNPLbrASORInfo" property="status" value="N" >
                                   <tr>
                                        <td align = "center"  width="3%"><html:checkbox property="checked" onclick="checkRecord();" name="frmNWNPLbrASORForm" /></td>                                        
                                        <%-- <td width="10%">                  
                                         <logic:equal property= "screenMode" name= "frmNWNPLbrASORForm" value="U"> 
                                            <html:text  property="txtLocationInfo" maxlength="20" size="38" titleKey="Payroll.Labour.Loc" styleClass="required" readonly="true"/>                  
                                            </logic:equal>                                                                                                 
                                        <logic:notEqual property= "screenMode" name= "frmNWNPLbrASORForm" value="U">                              
                                            <html:text  property="txtLocationInfo" maxlength="20" size="38" titleKey="Payroll.Labour.Loc" readonly="true" styleClass="required"  onchange="" /> 
            
                                            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtSection" onclick="return ShowLovLocationInfo();" readonly="true"></img>
                                        </logic:notEqual>
                                        </td>--%>
                                        
                                         <td ><html:text property="txtAsorPercent" maxlength="9" name="NWNPLbrASORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                         										
                                    if (!validate_NonNegative_Float(this.value,16,2))
                                       {
                                          this.focus();
                                          return false;
                                       }  
                                    else
                                       {
                                          return changed(this.alt);
                                        }
                                         " />
                                        </td>
                                       
                                         <td>
										<logic:notEqual name="NWNPLbrASORInfo" property="status" value="N" >
											<html:select property="txtGoDownTyp" name="NWNPLbrASORInfo" style="width:100%;" styleClass="required" alt="<%=String.valueOf(i)%>">
											<html:option value="Y" >SIDING</html:option>  
                                                                                        <html:option value="N" >NON SIDING</html:option>  
											</html:select>
										</logic:notEqual>
										<logic:equal name="NWNPLbrASORInfo" property="status" value="N" >
											<html:select property="txtGoDownTyp" name="NWNPLbrASORInfo" style="width:100%;" styleClass="required" alt="<%=String.valueOf(i)%>">
											<html:option value="Y" >SIDING</html:option>  
                                                                                        <html:option value="N" >NON SIDING</html:option>  
											</html:select>
										</logic:equal>
                                    </td>
                                   <td>
										<html:text property="txtFromDate" name="NWNPLbrASORInfo" readonly="true"  styleClass="required" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" />
                                        <logic:equal name="NWNPLbrASORInfo" property="status" value="N">
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" onclick="showCalendar('txtFromDate',this)" />
                                         </logic:equal>                                      
                                        <logic:equal name="NWNPLbrASORInfo" property="status" value="Q">
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" disabled="true"  onclick="showCalendar('txtFromDate',this)" />
                                        </logic:equal>                                      
                                        <logic:equal name="NWNPLbrASORInfo" property="status" value="U">
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" disabled="true"  onclick="showCalendar('txtFromDate',this)" />
                                        </logic:equal>  
                                    </td>         

                                    <td>
										<html:text property="txtToDate" name="NWNPLbrASORInfo" readonly="true"  styleClass="optional" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i)%>" onchange=
										" 										
                                                                                if (!validate_NonNegative_Float(this.value,16,2))
                                                                                 {
                                                                                    this.focus();
                                                                                    return false;
                                                                                 }  
                                                                                 else
                                                                                  {
                                                                                     return changed(this.alt);
                                                                                   }
										" />
										<img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtToDate" alt="<%=(i-1) %>" onclick="showCalendar('txtToDate',this)" />
										                   </td>     
                                                                                                                                                     
                                   </tr>
                                  </logic:equal>
                                
                                       <html:hidden property="itemChecked" name="NWNPLbrASORInfo"  />
                                       <html:hidden property="status" name="NWNPLbrASORInfo" />
                                       <html:hidden property="detailId" name="NWNPLbrASORInfo" />  
                              </logic:notEqual>                               
                                 
                                <logic:notEqual name="NWNPLbrASORInfo" property="status" value="N" >
                                   <tr>
                                        <td align = "center"  width="3%"><html:checkbox property="checked" onclick="checkRecord();" name="frmNWNPLbrASORForm" /></td>                                        
                                        <%-- <td width="10%">                  
                                         <logic:equal property= "screenMode" name= "frmNWNPLbrASORForm" value="U"> 
                                            <html:text  property="txtLocationInfo" maxlength="20" size="38" titleKey="Payroll.Labour.Loc" styleClass="required" readonly="true"/>                  
                                            </logic:equal>                                                                                                 
                                        <logic:notEqual property= "screenMode" name= "frmNWNPLbrASORForm" value="U">                              
                                            <html:text  property="txtLocationInfo" maxlength="20" size="38" titleKey="Payroll.Labour.Loc" readonly="true" styleClass="required"  onchange="" /> 
            
                                            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtSection" onclick="return ShowLovLocationInfo();" readonly="true"></img>
                                        </logic:notEqual>
                                        </td>--%>
                                        
                                         <td ><html:text property="txtAsorPercent" maxlength="9" name="NWNPLbrASORInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                          if (!validate_NonNegative_Float(this.value,16,2))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                        {
                                         return changed(this.alt);
                                        }  " />
                                        </td>
                                       
                                         <td>
										<logic:notEqual name="NWNPLbrASORInfo" property="status" value="N" >
											<html:select property="txtGoDownTyp" name="NWNPLbrASORInfo" style="width:100%;" styleClass="required" alt="<%=String.valueOf(i)%>">
											<html:option value="Y" >SIDING</html:option>  
                                                                                        <html:option value="N" >NON SIDING</html:option>  
											</html:select>
										</logic:notEqual>
										<logic:equal name="NWNPLbrASORInfo" property="status" value="N" >
											<html:select property="txtGoDownTyp" name="NWNPLbrASORInfo" style="width:100%;" styleClass="required" alt="<%=String.valueOf(i)%>">
											<html:option value="Y" >SIDING</html:option>  
                                                                                        <html:option value="N" >NON SIDING</html:option>  
											</html:select>
										</logic:equal>
                                    </td>
                                   <td>
										<html:text property="txtFromDate" name="NWNPLbrASORInfo" readonly="true"  styleClass="required" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" />
                                        <logic:equal name="NWNPLbrASORInfo" property="status" value="N">
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" onclick="showCalendar('txtFromDate',this)" />
                                         </logic:equal>                                      
                                        <logic:equal name="NWNPLbrASORInfo" property="status" value="Q">
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" disabled="true"  onclick="showCalendar('txtFromDate',this)" />
                                        </logic:equal>                                      
                                        <logic:equal name="NWNPLbrASORInfo" property="status" value="U">
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" disabled="true"  onclick="showCalendar('txtFromDate',this)" />
                                        </logic:equal>  
                                    </td>         

                                    <td>
										<html:text property="txtToDate" name="NWNPLbrASORInfo" readonly="true"  styleClass="optional" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i)%>" onchange=
										" if(!(chk_DateRange(parseInt(this.alt)-1)))
											  {
											  this.focus();
											  return false;                         
											  }
											  else
											  return changed(this.alt);     
										" />
										<img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtToDate" alt="<%=(i-1) %>" onclick="showCalendar('txtToDate',this)" />
										                   </td>     
                                                                                                                                                     
                                   </tr>
                                  </logic:notEqual> 
                                <logic:equal name="NWNPLbrASORInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmNWNPLbrASORForm" value="notchecked" /></td>
                                       <td ><html:hidden property="txtAsorPercent" name="NWNPLbrASORInfo" /></td>
                                       <td ><html:hidden property="txtGoDownTyp" name="NWNPLbrASORInfo" /></td>                                                                      
                                       <td ><html:hidden property="txtFromDate" name="NWNPLbrASORInfo" /></td>
                                       <td ><html:hidden property="txtToDate" name="NWNPLbrASORInfo" /></td>
                                       <html:hidden property="itemChecked" name="NWNPLbrASORInfo" />
                                       <html:hidden property="status" name="NWNPLbrASORInfo" />
                                       <html:hidden property="detailId" name="NWNPLbrASORInfo" />
                                       <td >
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
<html:hidden name="frmNWNPLbrASORForm"  property="screenName" value="MaintNWNPLbrASORDtlScreen" />
<html:hidden name="frmNWNPLbrASORForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmNWNPLbrASORForm" />
<html:hidden property="positionRequested" name="frmNWNPLbrASORForm" />
<html:hidden property="userPositionRequested" name="frmNWNPLbrASORForm"/>
<html:hidden property="pageRequested" name="frmNWNPLbrASORForm" />
<html:hidden property="userPageRequested" name="frmNWNPLbrASORForm"/>
<html:hidden property="totalDetailRecord" name="frmNWNPLbrASORForm"  />
<html:hidden property="screenModeASOR" name="frmNWNPLbrASORForm"  />
<html:hidden property="screenModeASOR1" name="frmNWNPLbrASORForm"  />
<html:hidden property="screenModeASOR2" name="frmNWNPLbrASORForm"  />

<html:hidden property="buttonFlag" name="frmNWNPLbrASORForm"  />
<html:hidden property="lovKey" name="frmNWNPLbrASORForm"  />
<html:hidden property="txtFields" name="frmNWNPLbrASORForm"  />   
<html:hidden property="txtSearchFields" name="frmNWNPLbrASORForm"  />
<html:hidden property="txtDisplayFields" name="frmNWNPLbrASORForm" />
<html:hidden property="txtIndex" name="frmNWNPLbrASORForm"  />
<html:hidden property="loginLocCode" name="frmNWNPLbrASORForm" />
<html:hidden property="txtRegCode" name="frmNWNPLbrASORForm" />
<html:hidden property="effStartDate" name="frmNWNPLbrASORForm" />                                         
<html:hidden property="txtLocId" name="frmNWNPLbrASORForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>


<script  language="javascript">

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
    if (frmNWNPLbrASORForm.screenMode.value == "Q")
    {
        frmNWNPLbrASORForm.screenModeASOR.value="Q";
        document.all.butGetDetail.disabled="disabled";  
        document.all.butInsert.disabled="true";
    }
        
    mode = frmNWNPLbrASORForm.screenModeASOR.value;        

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
        frmNWNPLbrASORForm.screenModeASOR2.value="U";
    }
     if (frmNWNPLbrASORForm.screenMode.value == 'U')
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
         //document.getElementById("headerPrimaryKey").disabled="";       
      }  
  mode1 = document.all.screenMode.value;  
  menuHandling(mode1);
 

}




function SaveRecord()
{    
    if(!mandatory_Check("frmNWNPLbrASORForm")){
   
        return false;  
    
    }
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
            frmNWNPLbrASORForm.detailDataChanged.value = "true";
    }
    

    frmNWNPLbrASORForm.screenModeASOR1.value = frmNWNPLbrASORForm.screenModeASOR2.value;
    if (document.all.screenMode.value == "N")
    {
        document.all.screenModeASOR.value = "UG";
        //document.all.screenMode.value = "U";    
    }  
    document.all.buttonFlag.value='';   
   // frmNWNPLbrASORForm.effStartDate.value = frmNWNPLbrASORForm.headerPrimaryKey.value;alert(25);
    frmNWNPLbrASORForm.headerFields.value = "true";    
    frmNWNPLbrASORForm.totalDetailRecord.value = parseInt(iTr2,10) - 1;    
	document.all.butSave.disabled="true"; 
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmNWNPLbrASORForm.action = "../../../NWNPLbrASORSaveAction.do";  
    frmNWNPLbrASORForm.submit();
    
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmNWNPLbrASORForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmNWNPLbrASORForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmNWNPLbrASORForm.action="../../../NWNPLbrASORGetHeaderAction.do"
    frmNWNPLbrASORForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmNWNPLbrASORForm.screenModeASOR.value="Q";
    frmNWNPLbrASORForm.userPositionRequested.value = 1*frmNWNPLbrASORForm.positionRequested.value + 1;    
    frmNWNPLbrASORForm.action="../../../NWNPLbrASORGetNextHeader.do";
    frmNWNPLbrASORForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmNWNPLbrASORForm.screenModeASOR.value="Q";
    frmNWNPLbrASORForm.userPositionRequested.value = 1*frmNWNPLbrASORForm.positionRequested.value - 1;
    frmNWNPLbrASORForm.action = "../../../NWNPLbrASORGetPrevHeader.do";
    frmNWNPLbrASORForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmNWNPLbrASORForm.screenModeASOR.value="Q";
    frmNWNPLbrASORForm.userPositionRequested.value = 1*frmNWNPLbrASORForm.newPositionRequested.value;
    frmNWNPLbrASORForm.action = "../../../NWNPLbrASORGetNextHeader.do";
    frmNWNPLbrASORForm.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmNWNPLbrASORForm.userPageRequested.value = 1*frmNWNPLbrASORForm.newPageRequested.value ;
    frmNWNPLbrASORForm.action = "../../../NWNPLbrASORNextDetailAction.do";
    frmNWNPLbrASORForm.submit();
}

function doInsertMode()
{    
    document.all.screenMode.value = "N";
    document.all.screenModeASOR.value = "N";    
    document.all.screenModeASOR1.value = "N";
    document.all.screenModeASOR2.value = "N";
    document.all.buttonFlag.value='';
    
    frmNWNPLbrASORForm.action="../../../NWNPLbrASORNewMode.do"
    frmNWNPLbrASORForm.submit();
}

function doQueryMode()
{   
    //frmNWNPLbrASORForm.headerPrimaryKey.value="";
    document.all.buttonFlag.value='';
    document.all.screenModeASOR.value = "Q";
    document.all.screenMode.value = "Q";    
    frmNWNPLbrASORForm.action="../../../NWNPLbrASORQueryMode.do"
    frmNWNPLbrASORForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmNWNPLbrASORForm.action="../../../NWNPLbrASORRefresh.do"
    frmNWNPLbrASORForm.submit();
}

function GetDetail()
{
    document.all.buttonFlag.value='';      
    document.all.screenModeASOR.value='UG';
    frmNWNPLbrASORForm.action="../../../NWNPLbrASORGetDetailAction.do"
    frmNWNPLbrASORForm.submit();
}

  function doBaseAddRow()
{ 
//alert(frmNWNPLbrASORForm.screenModeASOR.value);
    document.all.buttonFlag.value='D';    
    if(mandatory_Check("frmNWNPLbrASORForm"))
    {  
        if (frmNWNPLbrASORForm.screenModeASOR.value=="UG")
            frmNWNPLbrASORForm.screenModeASOR2.value=="U";
             
        frmNWNPLbrASORForm.screenModeASOR.value="N1";
        //document.getElementById("headerPrimaryKey").disabled="";
         
        document.forms[0].action = "../../../NWNPLbrASORAddRowAction.do";
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
      //frmDpsLbrASORForm.detailDataChanged.value = "true";
    }
  }
  document.forms[0].action = "../../../NWNPLbrASORDeleteRowAction.do";
  document.forms[0].submit();  
}

function changed(val)
{ 
    frmNWNPLbrASORForm.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
        document.getElementsByName("status")[val-1].value = 'U';
} 

function ShowLovLocation()
{   
    //alert("NWNPDepotList" + frmNWNPLbrASORForm.screenName.value + frmNWNPLbrASORForm.screenMode.value);
   frmNWNPLbrASORForm.lovKey.value = "NWNPDepotList" + frmNWNPLbrASORForm.screenName.value + frmNWNPLbrASORForm.screenMode.value;   
   frmNWNPLbrASORForm.txtDisplayFields.value = "txtLocId,txtLocation";
   frmNWNPLbrASORForm.queryParam.value = "txtSiteID="+frmNWNPLbrASORForm.loginLocCode.value+"";
   frmNWNPLbrASORForm.txtSearchFields.value = "Payroll.Labour.LocId,Payroll.Labour.Loc";
   //frmNWNPLbrASORForm.txtInputField.value =""; 
   //frmNWNPLbrASORForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmNWNPLbrASORForm');
   return true;
}
function ShowLovLocationInfo()
{   
    //alert("NWNPDepotList" + frmNWNPLbrASORForm.screenName.value + frmNWNPLbrASORForm.screenMode.value);
   frmNWNPLbrASORForm.lovKey.value = "NWNPDepotList" + frmNWNPLbrASORForm.screenName.value + frmNWNPLbrASORForm.screenMode.value;   
   frmNWNPLbrASORForm.txtDisplayFields.value = "txtLocId,txtLocation";
   frmNWNPLbrASORForm.queryParam.value = "txtSiteID="+frmNWNPLbrASORForm.loginLocCode.value+"";
   frmNWNPLbrASORForm.txtSearchFields.value = "Payroll.Labour.LocId,Payroll.Labour.Loc";
   //frmNWNPLbrASORForm.txtInputField.value =""; 
   //frmNWNPLbrASORForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmNWNPLbrASORForm');
   return true;
}

function ShowOperations(i)
{

    //frmNWNPLbrASORForm.queryParam.value="txtMou="+ frmMaintWrkSlip.hdnMou.value;    
    frmNWNPLbrASORForm.lovKey.value = "NWNPOpertaionList" + frmNWNPLbrASORForm.screenName.value + frmNWNPLbrASORForm.screenMode.value;
    frmNWNPLbrASORForm.txtDisplayFields.value = "detailId,txtLocation";
    frmNWNPLbrASORForm.txtIndex.value=i-1;
    //frmNWNPLbrASORForm.txtSearchFields.value = "";
    //frmNWNPLbrASORForm.multipleFlag.value = "";
    //frmNWNPLbrASORForm.txtInputField.value = "txtHndlngNorm";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmNWNPLbrASORForm');
    return true;
}


function getRegion_id()
{//alert("call ajax");
	url="../../../GetEmpDtlRetroParZone.do";
    prm="mode=1&txtSiteID="+frmNWNPLbrASORForm.loginLocCode.value+"&screenName="+frmNWNPLbrASORForm.screenName.value;
    //alert(prm);
	xml=getXML(url,prm);
	Tags=xml.getElementsByTagName("record");
        if(Tags.length > 0)
	{ 
        //alert("Tags[0].childNodes[0].nodeValue"+Tags[0].childNodes[0].nodeValue);
		frmNWNPLbrASORForm.txtRegCode.value=Tags[0].childNodes[0].nodeValue;
                frmNWNPLbrASORForm.txtRegName.value=Tags[1].childNodes[0].nodeValue;
              //  alert("value fill");
        }
	else
	{
		alert("Somthing Wrong Please Contact Administrator");
	}

}

</script>

