<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    
    <link rel="STYLESHEET" type="text/css" href="../../CSS/PayrollMenucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintPLIPaymentBase" name="frmPLIPaymentForm" type="FCIPAY.Payroll.WEBTIER.Form.PLIPaymentForm" scope="session">
<bean:define id="ParentForm" name="frmPLIPaymentForm" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="optVal" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN PLI PAYMENT</TD>
</TR>
</TABLE>
<!--container table starts -->

<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>	
       <!--<div id=divBody>-->
       <!-- Body table Starts -->
        <TABLE cellSpacing=3 cellPadding=0 border=0>
       <!--Account  Header Row Starts -->
        <TR>
         <TD class=subHeader colspan=6>PLI Payment Header</TD>
        </TR>
        <TR>
          <TD colspan=4 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
        </TR>
        
        <tr>   
          <td width="100%">
            <table width="100%" cellSpacing=3 cellPadding=0 border=0>              
              <tr height="10">
                <td width="20%"></td>  <!--disabled="true"-->
                <td width="30%" class="radioTextCenter" align="center"><input type="radio" name="radioAll"  value="S" disabled="true" onclick="AllEmpClick()" ><bean:message key="Payroll.Compute.all"  />            
                <td width="20%" class="radioTextRight" align="center" ><input type="radio" name="radioEmp"  value="E" onclick="EmpNoClick()" ><bean:message  key="Payroll.Compute.emp" />         
                <td width="30%"></td>  
              </TR>            
              <tr>              
                <td class="labelText"  width="15%" ><bean:message key="Payroll.PLI.PLIYear" /></td>
                <td width="13%" >
                <logic:equal property= "screenMode" name= "frmPLIPaymentForm" value="Q">                              
                <html:text  property="headerPrimaryKey" altKey="Payroll.PLI.PLIYear" maxlength="6" size="23" styleClass="optional"  onchange="chk_FinYear(this.value)"onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;                  
                    };" />
                <bean:message key="Payroll.PLI.yyyy" />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmPLIPaymentForm" value="Q">                              
                <html:text  property="headerPrimaryKey" altKey="Payroll.PLI.PLIYear" maxlength="6" size="23" readonly="true"  onchange="chk_FinYear(this.value)" onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;                  
                    };" />
                <bean:message key="Payroll.PLI.yyyy" />
                </logic:notEqual>                                                      
                </td>
              
                <td class=labelText width="8%" ><bean:message key="Payroll.PLI.PLIType" /></td>
                <td colspan="1" >
                <logic:equal property= "screenMode" name= "frmPLIPaymentForm" value="N">
					<html:select property="txtPLIType" alt="txtPLIType" titleKey="Payroll.PLI.PLIType" onchange="onChangePLIType();" styleClass="required" style="WIDTH: 49%" >
					<html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
					<html:option value="PLIADV" > <bean:message key="Payroll.PLI.PLIAdv" /></html:option>
					<html:option value="PLIPAY" > <bean:message key="Payroll.PLI.PLIFinPay" /></html:option>
					</html:select>
                </logic:equal>
                <logic:notEqual property= "screenMode" name= "frmPLIPaymentForm" value="N">                              
					<html:select property="txtPLIType" alt="txtPLIType" titleKey="Payroll.PLI.PLIType" styleClass="required" style="WIDTH: 49%" >
					<html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
					<html:option value="PLIADV" > <bean:message key="Payroll.PLI.PLIAdv" /></html:option>
					<html:option value="PLIPAY" > <bean:message key="Payroll.PLI.PLIFinPay" /></html:option>
					</html:select>
                </logic:notEqual> 
                </td>    
              </tr>
              
              <tr>
                <td class="labelText"  width="15%"  ><bean:message key="Payroll.PLI.PLIPerc" /> </td>
                <td>
                    <html:text  property="txtPLIPerc" maxlength="3" size="23" titleKey="Payroll.PLI.PLIPerc" styleClass="locked" value="" onchange="" readonly="true"/>                            
                </td> 
                
                <td width="8%" class=labelText  ><bean:message key="Payroll.PLI.PLIAdvAmnt" /> </td>
                <td width="20%">                  
                <logic:equal property= "screenMode" name= "frmPLIPaymentForm" value="N">                              
                <html:text  property="txtPLIAdvAmnt" maxlength="10" size="23" titleKey="Payroll.PLI.PLIAdvAmnt" styleClass="optional"  onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;                  
                    };" />                            
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmPLIPaymentForm" value="N">                              
                <html:text  property="txtPLIAdvAmnt" maxlength="10" size="23" titleKey="Payroll.PLI.PLIAdvAmnt" styleClass="locked"  onchange="" readonly="true"onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;                  
                    };" />                            
                </logic:notEqual>
                </td>                    
              </tr>              
              
              
              <logic:equal property= "optVal" name= "frmPLIPaymentForm" value="2">
              <tr>
                <td width="100%" colspan=4><table cellSpacing=2 cellPadding=0 border=0><tr>
                <td class="labelText"  width="20%" ><bean:message key="Payroll.Compute.emp" /></td>
                <td><html:text  property="txtEmpNo" altKey="Payroll.Compute.emp" maxlength="10" size="14" styleClass="required" readonly="true" />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpLOV"  name="buttxtEmpLOV" onclick="showLOVEmp();">
                &nbsp;&nbsp;<html:text  property="txtEmpName" readonly="true"   size="40" styleClass="locked" /></td>
                </tr></table></td>
              </tr>
              </logic:equal> 
              
            </table>
          </td>
          </tr>
          <tr height="10">		    
        <TD colspan="2" > </TD>
      </tr>
   	 </table>
    </div>
<table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                    
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <logic:equal property= "screenMode" name= "frmPLIPaymentForm" value="N">
                    
                    <td bgcolor="#4682B4" nowrap class=actTabText > Employees to be Excluded<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    
                    </logic:equal>
                    <logic:notEqual property= "screenMode" name= "frmPLIPaymentForm" value="N">
                    <td bgcolor="#4682B4" nowrap class=actTabText > PLI Payment Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    </logic:notEqual>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    
                    
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="8">
                  <TABLE cellSpacing="0" cellPadding="0" border="0" >
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail" border=0>
                          <TBODY>                          
                          <TR height=20>
                            <td class=tableHeader width="1%"></td>
                            <TD class=tableHeader width="8%"><bean:message  key="Payroll.Common.empNo" /></td>
                            <TD class=tableHeader width="24%"><bean:message  key="Payroll.Common.empName" /></td>
                            <TD class=tableHeader width="20%"><bean:message  key="Payroll.EmpInfo.txtDesig" /></td>
                            <TD class=tableHeader width="10%"><bean:message  key="Payroll.PLI.PLIPrevAmnt" /></td>
                            <TD class=tableHeader width="10%"><bean:message  key="Payroll.PLI.PLIAmnt" /></td>
                            <TD class=tableHeader width="10"><bean:message  key="Payroll.PLI.Inctax" /></td>
                            <TD class=tableHeader width="10%"><bean:message  key="Payroll.PLI.LeaveDed" /></td>
                            <TD class=tableHeader width="14%"><bean:message  key="Payroll.PLI.NetAmnt" /></td>
                             
                            </TR>            
                            
                          <logic:iterate id="PLIPayment" name="frmPLIPaymentForm" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.PLIPaymentDetailBean" indexId="idx">
                            <% ++i; %>
                            <logic:notEqual name="PLIPayment" property="status" value="D" >
                             <logic:equal name="PLIPayment" property="status" value="N" >                                                        
                            <tr><% ++j; %>                              
                              <td align = "center"><html:checkbox property="checked"  onclick="checkRecord();" value="false" name="frmPLIPaymentForm" /></td>
                              <td  width="8%" ><html:text property="txtAllEmpNo" name="PLIPayment" styleClass="required" readonly="true" style="width:75%;text-align:left"  alt="<%=String.valueOf(i)%>" />&nbsp;<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpLOV" alt="<%=idx%>" name="buttxtEmpLOV" onclick="showAllLOVEmp(this.alt);"></td>                                                         
                              <td  width="24%" ><html:text property="txtAllEmpName" name="PLIPayment" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" readonly="true" /></td>                                                         
                              <td  width="20%" ><html:text property="txtDesig" name="PLIPayment" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" readonly="true" /></td>                                                         
                              <td  width="10%" ><html:text property="prevPLIPaidAmnt" name="PLIPayment" styleClass="locked" value="0" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" readonly="true" /></td>                                                         
                              <td  width="10%" ><html:text property="txtPLIAmnt" name="PLIPayment" styleClass="locked" value="0" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" readonly="true" /></td>                                                         
                              <td  width="10%" ><html:text property="txtIncomTax" name="PLIPayment" styleClass="locked" value="0" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" readonly="true" /></td>                                                         
                              <td  width="10%" ><html:text property="txtLeaveDed" name="PLIPayment" styleClass="locked" value="0" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9"  /></td>                                                         
                              <td  width="14%" ><html:text property="netAmntPayble" name="PLIPayment" styleClass="locked" value="0" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" readonly="true" /></td>                                                    
                              
                              
                              <html:hidden property="itemChecked" name="PLIPayment" />
                              <html:hidden property="status" name="PLIPayment" />    
                              <html:hidden property="detailId" name="PLIPayment" value="Default"/>
                              
                            </tr>
                        </logic:equal>
                        <logic:notEqual name="PLIPayment" property="status" value="N" >                                                        
                            <tr><% ++j; %>                              
                              <td align = "center"></td>
                              <td  width="8%" ><html:text property="txtAllEmpNo" name="PLIPayment" styleClass="locked" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="" /></td>                                                         
                              <td  width="24%" ><html:text property="txtAllEmpName" name="PLIPayment" styleClass="locked" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="" /></td>                                                         
                              <td  width="20%" ><html:text property="txtDesig" name="PLIPayment" styleClass="locked" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="" /></td>                                                         
                              <td  width="10%" ><html:text property="prevPLIPaidAmnt" name="PLIPayment" styleClass="locked" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="" /></td>                                                         
                              <td  width="10%" ><html:text property="txtPLIAmnt" name="PLIPayment" styleClass="locked" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="lfnChange(alt); " /></td>                                                         
                              <td  width="10%" ><html:text property="txtIncomTax" name="PLIPayment" styleClass="locked" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="lfnChange(alt); " /></td>                                                         
                              <td  width="10%" ><html:text property="txtLeaveDed" name="PLIPayment" styleClass="locked" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="lfnChange(alt); " /></td>                                                         
                              <td  width="14%" ><html:text property="netAmntPayble" name="PLIPayment" styleClass="locked" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="9" onchange="lfnChange(alt); " /></td>                                                    
                              
                                                          
                              <html:hidden property="itemChecked" name="PLIPayment" />
                              <html:hidden property="status" name="PLIPayment" />    
                              <html:hidden property="detailId" name="PLIPayment" value="Default"/>
                              
                            </tr>
                        </logic:notEqual>
                        </logic:notEqual>
                        <logic:equal name="PLIPayment" property="status" value="D" >
                         <tr>
                              <td  width="1%" ></td>
                              <td  width="10%" ><html:hidden property="txtAllEmpNo" name="PLIPayment" styleClass="locked"   /></td>                                                         
                              <td  width="24%" ><html:hidden property="txtAllEmpName" name="PLIPayment" styleClass="locked"  /></td>                                                         
                              <td  width="20%" ><html:hidden property="txtDesig" name="PLIPayment" styleClass="locked" /></td>                                                         
                              <td  width="10%" ><html:hidden property="prevPLIPaidAmnt" name="PLIPayment" styleClass="locked" /></td>                                                         
                              <td  width="10%" ><html:hidden property="txtPLIAmnt" name="PLIPayment" styleClass="locked"  /></td>                                                         
                              <td  width="10%" ><html:hidden property="txtIncomTax" name="PLIPayment" styleClass="locked" /></td>                                                         
                              <td  width="11%" ><html:hidden property="txtLeaveDed" name="PLIPayment" styleClass="locked" /></td>                                                         
                              <td  width="14%" ><html:hidden property="netAmntPayble" name="PLIPayment" styleClass="locked" /></td>                                                    
                              
                               <html:hidden property="itemChecked" name="PLIPayment" />
                               <html:hidden property="status" name="PLIPayment" />
                               <html:hidden property="detailId" name="PLIPayment" value="Default"/>
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
		          <td colspan=8>
                  <TABLE border=0>
                    <TBODY>
                        <TR><td><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                    </td></TR>
                  </TBODY>
                </TABLE>
              </TD>               
            </tr>
          </TBODY>
		    </TABLE>
		  </td>
    </tr>
<!-- Tab table Row 3 starts -->
    <tr>
      <TD background="../INCLUDES/IMAGES/line_r.gif"><IMG src="../INCLUDES/IMAGES/pixel.gif" border=0></TD>
		</TR>
    <TR>
      <TD align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>
  </TABLE>
  </td>
	</tr>
   <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
  <TR>
    <td align=center bgcolor=#4682b4 width="40%"></td>
    <td bgColor=#4682b4></td>
    <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
  </TR>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<!-- These four hidden fields must be present in pages where there is a detail part -->
<html:hidden name="frmPLIPaymentForm"  property="screenName" value="PLIPaymentScreen" />
<html:hidden property="totalDetailRecord" name="frmPLIPaymentForm" />
<html:hidden name="frmPLIPaymentForm"  property="forwardedPage" />
<html:hidden name="frmPLIPaymentForm"  property="butAction" />
<html:hidden name="frmPLIPaymentForm"  property="hdnAction" />    
<html:hidden property="screenMode" name="frmPLIPaymentForm"  />
<html:hidden property="screenModeFlag" name="frmPLIPaymentForm"  />
<html:hidden name="frmPLIPaymentForm"  property="lovKey"  />
<html:hidden name="frmPLIPaymentForm"  property="txtFields" />   
<html:hidden name="frmPLIPaymentForm"  property="txtSearchFields" />
<html:hidden name="frmPLIPaymentForm"  property="txtDisplayFields"  />
<html:hidden name="frmPLIPaymentForm"  property="txtIndex"  />
<html:hidden property="buttonFlag" name="frmPLIPaymentForm"  />
<html:hidden property="userPageRequested" name="frmPLIPaymentForm"  />
<html:hidden property="pageRequested" name="frmPLIPaymentForm"  />
<html:hidden property="positionRequested" name="frmPLIPaymentForm" />
<html:hidden property="userPositionRequested" name="frmPLIPaymentForm" />
<html:hidden name="frmPLIPaymentForm"  property="screenModePLI"  />
<html:hidden name="frmPLIPaymentForm"  property="screenModePLI1"  />
<html:hidden name="frmPLIPaymentForm"  property="screenModePLI2"  />
<html:hidden name="frmPLIPaymentForm"  property="txtPLIYear"  />
<html:hidden name="frmPLIPaymentForm"  property="optSelectAllEmp"  />
<html:hidden name="frmPLIPaymentForm"  property="txtEmpNo"  />
<html:hidden property="loginLocCode" name="frmPLIPaymentForm" />

<input type="hidden" name="queryParam" />

<!-- Hidden fields end -->

</html:form>
</body>
</html:html>

 
<script language="javascript">

function lfnLoad()
{  
  mode1 = document.all.screenMode.value;
  //alert("screenMode.value---"+mode1);  
  //alert(document.frmPLIPaymentForm.optVal.value);
  //alert("screenModePLI.value---"+frmPLIPaymentForm.screenModePLI.value);  
  
  if(mode1 == "")
  {
    doQueryMode();
  }   
  if((document.frmPLIPaymentForm.optVal.value == '')||(document.frmPLIPaymentForm.optVal.value == '1'))
    { //document.all.radioAll.checked="true";
    // Start Code Added By Ravindra Disable ALL option For Employee
     if(document.all.hdnEmpLbrFlag.value=='E'){
       document.getElementById('radioAll').checked = false;
        document.all.radioAll.disabled="disabled";
     }
    else{
    // document.all.radioAll.checked="true";
     document.getElementById('radioAll').checked = false;
    }
    // End Code Added By Ravindra Disable ALL option For Employee
    }
    else if(document.frmPLIPaymentForm.optVal.value == '2')
    {
         var pop=document.all.screenMode.value ;  
	
	if (pop== 'N')
	{

	//alert(" Pro-Ration in 'Employee-wise' option will be overridden against manual entry,Please enter only the applicable pro-rated amount");
	//alert(" Please enter only the applicable pro-rated amount in the PLI final payment.Advance already given for the financial year will be deducted from the entered amount");
  }
        document.all.radioEmp.checked="true";        
    }
    else{}
  //document.all.butInsert.disabled="true";
  document.all.butDelete.disabled="true"; 

  if(frmPLIPaymentForm.screenMode.value=='U')
  {
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
   }   
  
  mode = frmPLIPaymentForm.screenMode.value;  
  
  if(mode=='Q')
  {
     document.all.butGetDetail.disabled="";
     document.all.butInsert.disabled="true";
     document.all.butDelete.disabled="true";     
  }
 if(mode=='N')
  {
     
      
      document.all.butGetDetail.disabled="disabled";
      if(document.frmPLIPaymentForm.optVal.value!=2)
        document.all.butInsert.disabled="";
        else
        document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="disabled";
	 // if(document.all.txtPLIAdvAmnt.value=="") document.all.txtPLIAdvAmnt.value="0";
      menuHandling('N');      
      onChangePLIType();
  }
        
    if(frmPLIPaymentForm.screenModePLI.value=='UI' )
    {
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="true";
        document.all.butDelete.disabled="true";
        document.getElementById("txtEmpNo").disabled="true";
        document.getElementById("txtPLIType").disabled="true";
        document.getElementById("headerPrimaryKey").disabled="";
    }
   //alert(frmPLIPaymentForm.screenModePLI.value);
    if(frmPLIPaymentForm.screenModePLI.value=='UG' )
    {
         
        
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="true";
        document.all.butDelete.disabled="true";
        document.getElementById("txtEmpNo").disabled="true";
        if(frmPLIPaymentForm.screenMode.value == 'Q')
          document.getElementById("txtPLIType").disabled="";
        else
          document.getElementById("txtPLIType").disabled="true";
        
      //  document.getElementById("headerPrimaryKey").disabled="true";
    }
    if(frmPLIPaymentForm.screenModePLI.value=='UGD' )
    {
         
  
        
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="true";
        document.all.butDelete.disabled="true";
        document.getElementById("txtEmpNo").disabled="true";
        document.getElementById("txtPLIType").disabled="true";
        document.getElementById("headerPrimaryKey").disabled="";
    }
  
  menuHandling(mode);
  document.all.butDel.disabled="true";    
  document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";   

}

function showLOVEmp()
{  
   
   mode1 = document.all.screenMode.value;
   //alert('+document.all.screenMode.value '+document.all.screenMode.value);
 if(document.all.txtPLIType.value=="")
 {
        alert("Please Select PLI TYPE First!");
        document.all.txtPLIType.focus();
        return false;
 }
   if((document.all.headerPrimaryKey.value=="" || document.all.txtPLIType.value=="") && mode1 != 'Q') 
   {
    //alert('document.all.txtPLIType.value '+document.all.txtPLIType.value);
        alert("Please Enter Financial Year! ");
        document.all.headerPrimaryKey.focus();
        return false;
    }
    else
    {
     frmPLIPaymentForm.lovKey.value = "PLIPay" + frmPLIPaymentForm.screenName.value + frmPLIPaymentForm.screenMode.value;
     frmPLIPaymentForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
     frmPLIPaymentForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";   
  //   frmPLIPaymentForm.queryParam.value = "txtSiteID="+frmPLIPaymentForm.loginLocCode.value+",txtFinYr="+document.all.headerPrimaryKey.value+" ,hdnEmpLbrFlag="+document.all.hdnEmpLbrFlag.value;
     frmPLIPaymentForm.queryParam.value = "txtSiteID="+frmPLIPaymentForm.loginLocCode.value+",txtFinYr="+document.all.headerPrimaryKey.value+" ,txtType="+document.all.txtPLIType.value+",txtScreenMode="+document.all.screenMode.value+",hdnEmpLbrFlag="+document.all.hdnEmpLbrFlag.value;
     frmPLIPaymentForm.txtIndex.value ="";      
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPLIPaymentForm');
     return true;
    }
}

function showAllLOVEmp(i)
{   
      
   
   frmPLIPaymentForm.lovKey.value = "PLIPay" + frmPLIPaymentForm.screenName.value + frmPLIPaymentForm.screenMode.value;
   frmPLIPaymentForm.txtDisplayFields.value = "txtAllEmpNo,txtAllEmpName";
   frmPLIPaymentForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";   
   frmPLIPaymentForm.queryParam.value = "txtSiteID="+frmPLIPaymentForm.loginLocCode.value+",txtFinYr="+document.all.headerPrimaryKey.value+" ,txtType="+document.all.txtPLIType.value+",txtScreenMode="+document.all.screenMode.value+",hdnEmpLbrFlag="+document.all.hdnEmpLbrFlag.value;
   frmPLIPaymentForm.txtIndex.value =i;      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPLIPaymentForm');
   return true;
}

function onChangePLIType()
{
      

    
    if (document.all.txtPLIType.value=="PLIADV")
    {
     //  alert(" Kindly enter the full amount as per the PLI eligibility, system will automatically pro-rate the PLI amount according to Data of Joining.");
       //alert(" Pro-Ration in 'Employee-wise' option will be overridden against manual entry,Please enter only the applicable pro-rated amount");
	
       document.getElementById("txtPLIAdvAmnt").disabled = "";
       document.getElementById("txtPLIAdvAmnt").style.background="#ffffd3";
       document.getElementById("txtPLIAdvAmnt").style.className="required"; 
       document.getElementById("txtPLIAdvAmnt").className="required"; 
       document.getElementById("txtPLIPerc").disabled = "true";
       document.getElementById("txtPLIPerc").value = "";
       document.getElementById("txtPLIPerc").style.background="#e0e0e0";
       document.getElementById("txtPLIPerc").style.className="locked"; 
       document.all.headerPrimaryKey.readOnly = "true";
       document.getElementById("headerPrimaryKey").style.background="#e0e0e0";
       document.getElementById("headerPrimaryKey").style.className="locked";
       getFinYear();
       
    }  
    else if(document.all.txtPLIType.value=="PLIPAY")
    {  
      alert(" Please enter only the applicable pro-rated amount in the PLI final payment.Advance already given for the financial year will be deducted from the entered amount");
       if (document.frmPLIPaymentForm.optVal.value == '2')
	   {
       document.getElementById("txtPLIAdvAmnt").disabled = "";
       document.getElementById("txtPLIAdvAmnt").style.background="#ffffd3";
       document.getElementById("txtPLIAdvAmnt").style.className="required"; 
       document.getElementById("txtPLIAdvAmnt").className="required"; 
	   }
	   else
	   {
	   document.getElementById("txtPLIAdvAmnt").disabled = "true";
       document.getElementById("txtPLIAdvAmnt").value = "";
       document.getElementById("txtPLIAdvAmnt").style.background="#e0e0e0";
       document.getElementById("txtPLIAdvAmnt").style.className="locked";
	   }
	   
	   document.getElementById("txtPLIPerc").disabled = "";
       document.getElementById("txtPLIPerc").style.background="#e0e0e0";//"#ffffd3";
       document.getElementById("txtPLIPerc").style.className="locked";//"required";  
       document.getElementById("txtPLIPerc").value = "15";
       document.all.headerPrimaryKey.readOnly = "";
       document.all.headerPrimaryKey.value="";
       document.all.headerPrimaryKey.className="required";
       document.all.headerPrimaryKey.style.background="#ffffd3";//"#ffffd3";
    }
    else
    {}
}

function doRefresh()
{  
  frmPLIPaymentForm.action="../../../PLIPaymentRefresh.do";
  frmPLIPaymentForm.submit();                      
}

function doBaseAddRow()
{
   if(mandatory_Check("frmPLIPaymentForm"))
   {
      document.all.buttonFlag.value='';
      //frmPLIPaymentForm.screenMode.value = "U";  
      document.forms[0].action = "../../../PLIPaymentAddRowAction.do";
      
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
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmPLIPaymentForm.detailDataChanged.value = "true";
    }
  }
  document.forms[0].action = "../../../PLIPaymentDeleteRowAction.do";
  document.forms[0].submit();  
}

function doQueryMode()
{
    //frmPLIPaymentForm.hdnAction.value='Q' 
    //document.all.buttonFlag.value='';
    document.all.screenModePLI.value  = "Q";
    document.all.screenMode.value = "Q";
    document.all.screenModePLI1.value = "Q";
    //document.all.headerMode.value  = "Q";
    //document.all.headerMode1.value  = "Q";    
    
    frmPLIPaymentForm.action="../../../PLIPaymentQueryAction.do"
    frmPLIPaymentForm.submit();
}

function getHeaderRecord()
{  
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmPLIPaymentForm"))
    {
        //document.all.headerMode.value = "U";
        //document.all.headerMode1.value = "U";
        if(document.frmPLIPaymentForm.optVal.value == '2')
          document.all.optSelectAllEmp.value='E';
      else
          document.all.optSelectAllEmp.value='L';
          
        document.all.screenModePLI.value='UG';  
        document.all.screenModePLI1.value = "U1";
        document.all.txtEmpNo.disabled = "";        
        
        frmPLIPaymentForm.action="../../../PLIPaymentGetHeaderAction.do"
        frmPLIPaymentForm.submit();
   }
 
} 

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmPLIPaymentForm.userPositionRequested.value = 1*frmPLIPaymentForm.positionRequested.value + 1;
    frmPLIPaymentForm.action="../../../PLIPaymentGetNextHeader.do";
    frmPLIPaymentForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmPLIPaymentForm.userPositionRequested.value = 1*frmPLIPaymentForm.positionRequested.value - 1;
    frmPLIPaymentForm.action = "../../../PLIPaymentGetNextHeader.do";
    frmPLIPaymentForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmPLIPaymentForm.userPositionRequested.value = 1*frmPLIPaymentForm.newPositionRequested.value;
    frmPLIPaymentForm.action = "../../../PLIPaymentGetNextHeader.do";
    frmPLIPaymentForm.submit();
}


function GetDetail()
{

    //alert('document.all.headerPrimaryKey.value '+document.all.headerPrimaryKey.value);
    document.all.buttonFlag.value='';  
    document.getElementById("txtPLIType").disabled="";
    document.getElementById("headerPrimaryKey").disabled="";
    frmPLIPaymentForm.txtPLIYear.value=frmPLIPaymentForm.headerPrimaryKey.value;   
    
    
    document.all.screenMode.value = "U";
    document.all.screenModePLI.value='UGD';
    if(document.frmPLIPaymentForm.optVal.value == '2')
        document.all.optSelectAllEmp.value='E';
    else
        document.all.optSelectAllEmp.value='L';
    frmPLIPaymentForm.action="../../../PLIPaymentDetailAction.do"
    frmPLIPaymentForm.submit(); 
}

function doInsertMode()
{
   
    
    
    
    document.all.buttonFlag.value='';
    //document.all.headerMode.value  = "N";
    //document.all.headerMode1.value  = "N";
    document.all.screenModePLI.value  = "N";
    document.all.screenMode.value = "N";
    //document.all.screenModeDARate.value = "I";
    
    frmPLIPaymentForm.action="../../../PLIPaymentNewMode.do"
    frmPLIPaymentForm.submit();
}

function doBasePrevDetail()
{
    frmPLIPaymentForm.userPageRequested.value = 1*frmPLIPaymentForm.pageRequested.value - 1;
    frmPLIPaymentForm.action = "../../../PLIPaymentNextDetailAction.do";
    frmPLIPaymentForm.submit();
}

function doBaseNextDetail()
{
    frmPLIPaymentForm.userPageRequested.value = 1*frmPLIPaymentForm.pageRequested.value + 1;
    frmPLIPaymentForm.action = "../../../PLIPaymentNextDetailAction.do";
    frmPLIPaymentForm.submit();
}

function JumpDetail()
{
    frmPLIPaymentForm.userPageRequested.value = 1*frmPLIPaymentForm.newPageRequested.value ;
    //alert(frmPLIPaymentForm.userPageRequested.value);
    frmPLIPaymentForm.action = "../../../PLIPaymentNextDetailAction.do";
    frmPLIPaymentForm.submit();
}


function SaveRecord()
{
  document.all.buttonFlag.value=''; 
  document.all.txtPLIPerc.disabled = "";
  document.all.txtPLIAdvAmnt.disabled = "";
  if(mandatory_Check("frmPLIPaymentForm"))
  {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;     
      var i = 0;
      if (iTr2 > 1)      
      {
          for(i=0; i < iTr2 -1; i++)
          {          
              if (document.getElementsByName("status")[i].value == 'D')
                  frmPLIPaymentForm.detailDataChanged.value = "true";
              if (document.getElementsByName("status")[i].value == 'N')
                  frmPLIPaymentForm.detailDataChanged.value = "true";
              if (document.getElementsByName("status")[i].value == 'U')
                  frmPLIPaymentForm.detailDataChanged.value = "true";                 
          }  
      }      
      
      if(document.all.screenModePLI.value=='N')
        document.all.screenModePLI.value='UN';
      
      if(document.frmPLIPaymentForm.optVal.value == '2')
          document.all.optSelectAllEmp.value='E';
      else
          document.all.optSelectAllEmp.value='L';
      
      if(document.all.optSelectAllEmp.value=="E")
      {   
          frmPLIPaymentForm.headerDataChanged.value = "true";   
          frmPLIPaymentForm.headerFields.value="true";
      }      
      else if(document.all.optSelectAllEmp.value=="L" && iTr2 <= 1)
      {
          frmPLIPaymentForm.detailDataChanged.value = "true";   
          frmPLIPaymentForm.headerFields.value="true";          
      }      
      else
      {
          document.all.screenMode.value = "U";    
          frmPLIPaymentForm.headerFields.value="true";
      }
      
      
      //if(document.all.optSelectAllEmp.value=="E" && document.all.txtPLIType.value=="PLIPAY")
        //document.all.screenMode.value = "U";
        
      frmPLIPaymentForm.totalDetailRecord.value = parseInt(iTr2)-1;  
      document.all.screenModeFlag.value=false;         
      
      document.all.screenModePLI.value  = "UI";
      document.getElementById("txtPLIPerc").disabled = "";
      document.getElementById("txtPLIAdvAmnt").disabled = ""; 
      frmPLIPaymentForm.txtPLIYear.value = frmPLIPaymentForm.headerPrimaryKey.value;
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmPLIPaymentForm.action = "../../../PLIPaymentSaveAction.do";
      frmPLIPaymentForm.submit();
  }
  else
  {
    return false;
  }
}


/*function doSetAllEmpFlag(tempFlag)
{
    if(tempFlag == 'L')
    {
        document.all.txtEmpNo.disabled = "true";
        document.all.txtEmpNo.value = "";        
        document.all.txtEmpName.value = "";                
        document.all.txtEmpName.disabled = "true";    
        document.all.buttxtEmpLOV.disabled = "true"; 
        
    }
   else
    {   
        document.all.txtEmpNo.disabled = "";        
        document.all.txtEmpName.disabled = "";            
        document.all.buttxtEmpLOV.disabled = "";          
    }
     
}*/

function lfnChange(ind)
{        
      frmPLIPaymentForm.detailDataChanged.value = "true";      
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
  
}

function AllEmpClick() 
{
// Start Code Added By Ravindra Disable ALL option For Employee
if(document.all.hdnEmpLbrFlag.value=='E')
{
        alert("Bulk PLI Not Applicable for Employee")
        document.all.radioAll.disabled="disabled";
        document.getElementById('radioAll').checked = false;
        return false;
}
// End Code Added By Ravindra Disable ALL option For Employee
    document.frmPLIPaymentForm.hdnAction.value = "";  
    document.all.buttonFlag.value='';
    //if(document.all.screenExt.value == 'UG')
        //document.all.screenExt.value = 'U';
    
    document.frmPLIPaymentForm.action="../../../PLIOptionClickAction.do";
    document.frmPLIPaymentForm.optVal.value="1";
    document.frmPLIPaymentForm.submit(); 
}

function EmpNoClick() 
{
	

    document.frmPLIPaymentForm.hdnAction.value = "";  
    document.all.buttonFlag.value='';   
    
    document.frmPLIPaymentForm.action="../../../PLIOptionClickAction.do";
    document.frmPLIPaymentForm.optVal.value="2";
    document.frmPLIPaymentForm.submit(); 
}

function chk_FinYear(val)
{
    var  yearM = document.getElementById("headerPrimaryKey").value;              
    var Year1;
    var Year2;    
    if ( yearM != "") 
    {
        if (num_Check(yearM,1))
        {                                   
            if (yearM.length != 6)
            {
                alert(" Year Month should be a Six digit Number");
                document.getElementById("headerPrimaryKey").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                            
                return false;    
            }        
            Year1 =  yearM.substring(2,4);
            Year2 =  yearM.substring(4,6);           
            var TempYr1 = parseInt(Year1,10)+1;             
            var TempYr2 = parseInt(Year2,10);                          
            if (TempYr1 != TempYr2)
            {
                alert("Year Range Should be in the format of a Financial Period Eg. 200809");
                document.getElementById("headerPrimaryKey").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                   
                return false;       
            }
    
            return true;                                     
        }      
        else
        {
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;     
            return false;
        }
    }
}
/*
function validateAmt()
{
	var amt = document.getElementById("txtPLIAdvAmnt").value;
	if(amt > 5000 )
	{
		alert("Amount can not exceed Rs. 5000");
		document.getElementById("txtPLIAdvAmnt").value="";
		document.getElementById("txtPLIAdvAmnt").focus();
		return false;
	}
	if(amt==0 || amt=='')
	{
		alert("Please enter the amount");
		document.getElementById("txtPLIAdvAmnt").value="";
		document.getElementById("txtPLIAdvAmnt").focus();
		return false;
	}
}
*/
function getFinYear()
{
   var d = new Date();
   var fromyear,toyear,finyear;
   document.getElementById("headerPrimaryKey").value = "";
   fromyear = d.getMonth() < 2 ? d.getYear() - 1 : d.getYear()
   toyear=fromyear;
   fromyear = fromyear -1;
   
   toyear=toyear.toString();
   finyear=fromyear+toyear.substring(2,4);
   document.getElementById("headerPrimaryKey").value = finyear;
   
   
}

</script>

