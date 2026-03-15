<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
        <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
   
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0; %>
<% i = 0; j=0; %>

<html:form  action="MaintainExternalSavingsBase" name="frmMaintainExternalSavings" type="FCIPAY.Payroll.WEBTIER.Form.MaintainExternalSavingsForm" scope="session">
<bean:define id="ParentForm" name="frmMaintainExternalSavings" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="optVal" />


<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10><bean:message key="Payroll.MaintExtSavings.head" /></TD>
</TR>
</TABLE>
<html:errors/>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
 
    <tr>
    <TD>

       <!--<div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6><bean:message key="Payroll.MaintExtSavings.hd" /></TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="5" >
            <td colspan="6"></td>
         </tr>

          <tr>
               <TD class=labelText width="20%" ><bean:message key="pay.MaintainAnnualIncome.FinYYMM" /></td>
               <td><html:text  property="txtFinYYMM" altKey="pay.MaintainAnnualIncome.txtFinYYMM" maxlength="10" readonly="" size="23" styleClass="required"  onchange="chk_FinYear(this.value)" />
               <logic:notEqual property="screenMode" name="frmMaintainExternalSavings" value="N" >
               <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  onclick="ShowLovYYMM();">  
               </logic:notEqual>
         </tr> 

         <tr height = 5><td>&nbsp;</td></tr>
         

           <!-- <TR>        

                <td  width="30%" class="radioText" ><html:radio  property="optSavScaleType" value="1" onclick="SavCodeClick()"  /><bean:message key="Payroll.MaintIntSavings.sav"  /></td>
                
                <td width="45%" class="radioText" ><html:radio  property="optSavScaleType"  value="2"  onclick = "EmpNoClick()"  /><bean:message  key="Payroll.MaintIntSavings.empw" /></td>
                
                <td  width="25%" class="radioText"><html:radio   property="optSavScaleType" value="3"  onclick = "MiscelClick()"  /><bean:message  key="Payroll.MaintIntSavings.mis" /></td>
                <td colspan="3"></td>
            </TR>-->

          <TR>                            
                <td width="30%" class="radioText" ><input type="radio" name="radioSave" value="S" onclick="SavCodeClick()"   ><bean:message key="Payroll.MaintIntSavings.sav"  />
                
                <td width="45%" class="radioText" ><input type="radio" name="radioEmp" value="E" onclick="EmpNoClick()" ><bean:message  key="Payroll.MaintIntSavings.empw" />
                
                <td width="25%" class="radioText"><input type="radio" name="radioMisc" value="M" onclick="MiscelClick()" ><bean:message  key="Payroll.MaintIntSavings.mis" />
                <td colspan="3" ></td>          
            </TR>

            

         <tr height="10">	
         <tr>
            <tr height="10">	
             <td></td>
            </tr>          

            <logic:lessThan property= "optVal" name= "frmMaintainExternalSavings" value="1">             
            <td class="labelText"  width="40%" ><bean:message key="Payroll.MaintExtSavings.code" /></td>
            <td><html:text  property="txtSavCode1" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="10" size="23" readonly="true" styleClass="required" onblur="lfnGetPayCodeName(this.value)" />
            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo1"  >&nbsp;&nbsp;<html:text  property="txtSavCodeName"  maxlength="10" size="26" readonly="true" styleClass="locked" /></td>            
            </logic:lessThan>
         
        <TD colspan="4" > </TD>

       <logic:equal property= "optVal" name= "frmMaintainExternalSavings" value="1">
           <tr>
            <td class="labelText"  width="40%" ><bean:message key="Payroll.MaintExtSavings.code" /></td>
            <td><html:text  property="txtSavCode1" altKey="Payroll.MaintElecMtrRdg.code" maxlength="10" size="23" styleClass="required"  readonly="true" onblur="lfnGetPayCodeName(this.value)" />
            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtSavCode1" onclick="return ShowSavCode();" >&nbsp;&nbsp;<html:text  property="txtSavCodeName" readonly="true"   size="26" styleClass="locked" /></td>
           </tr>
        </logic:equal>
        
     <logic:equal property= "optVal" name= "frmMaintainExternalSavings" value="2">
           <tr>
            <td class="labelText"  width="40%" ><bean:message key="Payroll.MaintElecMtrRdg.empno" /></td>
            <td><html:text  property="txtEmpNo1" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="10" size="23" styleClass="required"  readonly="true" onblur="lfnGetEmpName(this.value)" />
            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo1" onclick="return ShowEmpNum();" >&nbsp;&nbsp;<html:text  property="txtEmpName1"  readonly="true" size="26" styleClass="locked" /></td>
           </tr>
        </logic:equal>

  <logic:equal property= "optVal" name= "frmMaintainExternalSavings" value="3">
           <tr height = 30><td width="40%" >&nbsp;</td>    <td>&nbsp; </td>   
           </tr>
        </logic:equal>
      </tr>
   	 </table>
    </div>
   
        <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="130">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText><bean:message key="Payroll.MaintExtSavings.detail" /><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="11">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:280px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail">
                          <TBODY>
                              <TR>
                                    <TD class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();" /></TD>
                                    <td class=tableHeader width="2%"><bean:message key="Payroll.MaintExtSavings.srno" /></td>
                                    <td class=tableHeader width="4%"><bean:message key="Payroll.MaintExtSavings.emp"  /></td>
                                    <td class=tableHeader width="8%"><bean:message key="Payroll.MaintExtSavings.name" /></td>                                               
                                    <td class=tableHeader width="4%"><bean:message key="Payroll.MaintExtSavings.code" /></td>
                                    <td class=tableHeader width="10%"><bean:message key="Payroll.MaintExtSavings.desc" /></td>                                               
                                    <td class=tableHeader width="5%"><bean:message key="Payroll.MaintExtSavings.type" /></td>                                               
                                    <td class=tableHeader width="5%"><bean:message key="Payroll.MaintExtSavings.num" /></td>                                               
                                    <td class=tableHeader width="5%"><bean:message key="Payroll.MaintExtSavings.year" /></td>                                               
                                    <td class=tableHeader width="5%"><bean:message key="Payroll.MaintExtSavings.amt" /></td>                                               
                                    </TR>
                      
                            <logic:iterate id="extInfo" name="frmMaintainExternalSavings" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintainExternalSavingsBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="extInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                       <td ><html:checkbox property="checked" name="frmMaintainExternalSavings" onclick="checkRecord();" /></td>
                                       <td ><html:text property="txtSrlNo" name="extInfo" size="2"  value="<%=String.valueOf(j)%>"  styleClass="optional" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>         

                                        <td ><html:text property="txtEmpNo" readonly="true" name="extInfo" styleClass="required" size="6" style="width:74%" alt="<%=String.valueOf(i)%>" onchange=" if (!num_Check(this.value,1)) { this.focus();
                                                                                                                                                                                                      return false;
                                                                                                                                                                                                    }                                      
                                                                                                                                                                         else
                                                                                                                                                                         return changed(this.alt);
                                                                                                                                                                         " onblur="lfnGetEmpNameDtl(this.alt, this.value)" />
                                    
                                        <logic:equal name="extInfo" property="status" value="N">                                       
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  onclick="ShowDetEmpNum(this.alt);" >
                                        </logic:equal>                                      
                                      
                                       <logic:equal name="extInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowDetEmpNum(this.alt);" >                                     
                                      </logic:equal>                                      
                                       
                                      <logic:equal name="extInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  onclick="ShowDetEmpNum(this.alt);" >                                       
                                      </logic:equal>                                      
                                      </td>                                   


                                       <td ><html:text property="txtEmpName" name="extInfo" size="9"    styleClass="locked" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" readonly="true" /></td>         

                                       <td ><html:text property="txtSavCode" name="extInfo" size="6" readonly="true"   styleClass="required" style="width:74%" alt="<%=String.valueOf(i)%>" onchange=" if (!num_Check(this.value,1)){
                                                                                                                                                                              this.focus();
                                                                                                                                                                              return false;
                                                                                                                                                                            }                                      
                                                                                                                                                                          else
                                                                                                                                                                              return changed(this.alt);
                                                                                                                                                                        " onblur="lfnGetPayCodeNameDtl(this.alt, this.value)" />

                                       
                                        <logic:equal name="extInfo" property="status" value="N">                                        
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode"  onclick="ShowDetSavCode(this.alt);" >                                       
                                        </logic:equal>                                      
                                       
                                        <logic:equal name="extInfo" property="status" value="Q">                                        
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode"  disabled onclick="ShowDetSavCode(this.alt);" >                                       
                                        </logic:equal>                                      
                                       
                                        <logic:equal name="extInfo" property="status" value="U">                                        
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode"   onclick="ShowDetSavCode(this.alt);" >                                       
                                        </logic:equal>
                                       </td>                                     


                                       <td ><html:text property="txtDescription" name="extInfo" size="9"   styleClass="locked" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" readonly="true" /></td>         
                                                                              
                                      <td ><html:select property="txtType" name="extInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="lfnSavTypeChange(this.alt,this.value);"   >
                                        <html:option value="">----------Please select----------</html:option>
                                        <html:option value="P">Proposed</html:option>
                                        <html:option value="A">Actual</html:option>
                                        </html:select></td>  

                                      <td ><html:text property="txtSavingsNumber" name="extInfo" size="9"  maxlength="20"  styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>"   onchange="return changed(this.alt);" /></td>                                                
                                      <td ><html:text property="txtSavingsYear" name="extInfo" size="9" maxlength="6"   styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="if (chk_Year(this.value)) changed(this.alt);" /></td>         
                                      <td ><html:text property="txtAmount" name="extInfo" size="9" maxlength="18"   styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="if (num_Check(this.value,1)) changed(this.alt);" /></td>         

                                       <html:hidden property="hdnSavCodeSrlNo" name="extInfo" />
                                       <html:hidden property="itemChecked" name="extInfo" />
                                       <html:hidden property="status" name="extInfo" />
                                       <html:hidden property="detailId" name="extInfo" value="Default"/>
									   <!--Added by Varalika on 30-Sep-2011-->     
									   <html:hidden property="txtUpdatedSite"  name="extInfo" />             
									   <html:hidden property="txtCreationDate" name="extInfo" />
                                       <html:hidden property="txtCreatedBy"    name="extInfo" />
                                       <html:hidden property="txtCreatedSite"  name="extInfo" />
                                       <html:hidden property="txtUpdationDate" name="extInfo" />
                                       <html:hidden property="txtUpdatedBy"    name="extInfo" />
                                         <!--ended by varalika -->
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="extInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintainExternalSavings" value="notchecked" /></td>
                                       <td ><html:hidden property="txtSrlNo" name="extInfo" /></td>
                                       <td ><html:hidden property="txtEmpNo" name="extInfo" /></td>
                                       <td ><html:hidden property="txtEmpName" name="extInfo" /></td>
                                       <td ><html:hidden property="txtSavCode" name="extInfo" /></td>
                                       <td ><html:hidden property="txtDescription" name="extInfo" /></td>
                                       <td ><html:hidden property="txtType" name="extInfo" /></td>
                                      <td ><html:hidden property="txtSavingsNumber" name="extInfo" /></td>                                       
                                      <td ><html:hidden property="txtSavingsYear" name="extInfo" /></td>                                       
                                      <td ><html:hidden property="txtAmount" name="extInfo" /></td>
                                       <html:hidden property="hdnSavCodeSrlNo" name="extInfo" />
                                       <html:hidden property="itemChecked" name="extInfo" />
                                       <html:hidden property="status" name="extInfo" />
                                       <html:hidden property="detailId" name="extInfo" value="Default"/>
									    <!--Added by Varalika on 30-Sep-2011-->     
									   <html:hidden property="txtUpdatedSite"  name="extInfo" />             
									   <html:hidden property="txtCreationDate" name="extInfo" />
                                       <html:hidden property="txtCreatedBy"    name="extInfo" />
                                       <html:hidden property="txtCreatedSite"  name="extInfo" />
                                       <html:hidden property="txtUpdationDate" name="extInfo" />
                                       <html:hidden property="txtUpdatedBy"    name="extInfo" />
                                         <!--ended by varalika -->
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
                    <TR>
                      <TD>
                       <jsp:include  page = "../INCLUDES/GenDetailRecHistMenu.jsp" flush="true" /> <!-- changed
								GenDetailMenu by varalika on 30-Sep-2011>
                      </TD>
                     </TR>
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
<html:hidden property="headerPrimaryKey" name="frmMaintainExternalSavings"  />
<html:hidden property="hdnFinYYMM" name="frmMaintainExternalSavings"  />
<html:hidden property="screenMode" name="frmMaintainExternalSavings"  />
<html:hidden name="frmMaintainExternalSavings"  property="screenName" value="ExternalScreen" />
<html:hidden name="frmMaintainExternalSavings"  property="forwardedPage" />
<html:hidden property="txtIndex" name="frmMaintainExternalSavings"  />
<html:hidden property="screenExt" name="frmMaintainExternalSavings"  />
<html:hidden property="hdnAction" name="frmMaintainExternalSavings"  />
<html:hidden property="hdnRowVal" name="frmMaintainExternalSavings"  />
<html:hidden property="hdnEmpNo" name="frmMaintainExternalSavings"  />
<html:hidden property="hdnEmpName" name="frmMaintainExternalSavings"  />
<html:hidden property="hdnPayCode" name="frmMaintainExternalSavings"  />
<html:hidden property="hdnPayCodeName" name="frmMaintainExternalSavings"  />
<html:hidden property="hdnLoginUserId" name="frmMaintainExternalSavings"  />
<html:hidden property="hdnPayrollUser" name="frmMaintainExternalSavings"  />
<html:hidden property="loginEmployeeNo" name="frmMaintainExternalSavings"  />
<html:hidden property="loginLocCode" name="frmMaintainExternalSavings" />
<html:hidden property="userPageRequested" name="frmMaintainExternalSavings" />
<html:hidden property="pageRequested" name="frmMaintainExternalSavings" />
<!--Added by Varalika on 30-Sep-2011-->
<html:hidden property="txtUpdatedSite"  name="frmMaintainExternalSavings" />             
<html:hidden property="txtCreationDate" name="frmMaintainExternalSavings" />
<html:hidden property="txtCreatedBy"    name="frmMaintainExternalSavings" />
<html:hidden property="txtCreatedSite"  name="frmMaintainExternalSavings" />
<html:hidden property="txtUpdationDate" name="frmMaintainExternalSavings" />
<html:hidden property="txtUpdatedBy"    name="frmMaintainExternalSavings" />
<!--ended by varalika -->
<input type="hidden" name="queryParam" />

<html:hidden property="lovKey" name="frmMaintainExternalSavings"  />
<html:hidden property="txtFields" name="frmMaintainExternalSavings"  />   
<html:hidden property="txtSearchFields" name="frmMaintainExternalSavings"  />
<html:hidden property="txtDisplayFields" name="frmMaintainExternalSavings"  />
<html:hidden property="buttonFlag" name="frmMaintainExternalSavings"  />
</td>
</tr>
</table>
</html:form>
</body>
</html:html>         

<script language="javascript">

function lfnLoad()
{
    mode = document.all.screenMode.value;
    if (document.all.txtFinYYMM.value == "")
    {
        document.all.txtFinYYMM.value = document.all.hdnFinYYMM.value; 
    }
    if(mode=='')
    {    
        doQueryMode();
    }
    if (document.all.screenExt.value == "")
    {
        document.all.screenExt.value = "Q";
        document.all.screenMode.value = "Q";    
    }    
    mode = document.all.screenExt.value;    
    if(mode=='')
    {
        document.all.butGetDetail.disabled="";   
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";
    }
    if(mode=='Q')
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
        
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
    }

    if(mode=='N')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";      
        menuHandling('N');      
    }
    
    if(mode=='UG')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";
    }  

    if(document.frmMaintainExternalSavings.hdnAction.value == "GetEmpNameDtl")
    {
        var iRowVal = document.frmMaintainExternalSavings.hdnRowVal.value; 
        if (document.frmMaintainExternalSavings.hdnEmpName.value != "") 
        {
            document.getElementsByName("txtEmpName")[iRowVal-1].value = document.frmMaintainExternalSavings.hdnEmpName.value; 
            document.frmMaintainExternalSavings.hdnAction.value = "";
            document.getElementsByName("txtSavCode")[iRowVal-1].focus();      
        }
        else
        {
            alert("Invalid Employee Number"); 
            document.getElementsByName("txtEmpName")[iRowVal-1].value = ""; 
            document.getElementsByName("txtEmpNo")[iRowVal-1].focus();                
        }
    }
    
    if(document.frmMaintainExternalSavings.hdnAction.value == "GetEmpName")
    {
        if (document.frmMaintainExternalSavings.txtEmpName1.value == "")   
        {
            alert("Invalid Employee Number"); 
            document.frmMaintainExternalSavings.txtEmpNo1.focus(); 
        }
    }
  
    if(document.frmMaintainExternalSavings.hdnAction.value == "GetPayCodeName")
    {
        if (document.frmMaintainExternalSavings.txtSavCodeName.value == "")   
        {
            alert("Invalid Savings Code"); 
            document.frmMaintainExternalSavings.txtSavCode1.focus(); 
        }
    }    

    if(document.frmMaintainExternalSavings.hdnAction.value == "GetPayCodeNameDtl")
    {
        var iRowVal = document.frmMaintainExternalSavings.hdnRowVal.value;   
        if (document.frmMaintainExternalSavings.hdnPayCodeName.value != "") 
        {  
            var iRowVal = document.frmMaintainExternalSavings.hdnRowVal.value; 
            document.getElementsByName("txtDescription")[iRowVal-1].value = document.frmMaintainExternalSavings.hdnPayCodeName.value; 
            document.frmMaintainExternalSavings.hdnAction.value = "";
            document.getElementsByName("txtType")[iRowVal-1].focus();            
        }
        else
        {
            alert("Invalid Savings Code"); 
            document.getElementsByName("txtDescription")[iRowVal-1].value = "";           
            document.getElementsByName("txtSavCode")[iRowVal-1].focus();                
        }      
    }    
  
    if(mode == 'UG' || mode == 'UNG')
    {  
        menuHandling('U');
    }
    else
    {
        menuHandling(mode);
    }    
    document.all.butExecute.disabled="true";    
    document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg"; 
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
    if((document.frmMaintainExternalSavings.optVal.value == '')||(document.frmMaintainExternalSavings.optVal.value == '1'))
    {
        document.all.radioSave.checked="true";
        if(document.frmMaintainExternalSavings.optVal.value == '')
        SavCodeClick();
    }
    else if(document.frmMaintainExternalSavings.optVal.value == '2')
    {
        document.all.radioEmp.checked="true";
        return true;
    }
    else if(document.frmMaintainExternalSavings.optVal.value == '3')
    {
        document.all.radioMisc.checked="true";
        return true;
    }
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
            document.getElementsByName("txtSavCode")[i].disabled="disabled";
            document.getElementsByName("txtEmpNo")[i].disabled="disabled";            
        }
    }
}


function ShowEmpNum()
{   
    frmMaintainExternalSavings.lovKey.value = "ExtSav" + frmMaintainExternalSavings.screenName.value + frmMaintainExternalSavings.screenMode.value;
    frmMaintainExternalSavings.txtDisplayFields.value = "txtEmpNo1,txtEmpName1";    
    frmMaintainExternalSavings.queryParam.value = "txtSiteID="+frmMaintainExternalSavings.loginLocCode.value+",hdnEmpLbrFlag="+frmMaintainExternalSavings.hdnEmpLbrFlag.value+",txtYrMnth="+frmMaintainExternalSavings.txtFinYYMM.value+" "; 
    frmMaintainExternalSavings.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";   
    frmMaintainExternalSavings.txtIndex.value ="";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainExternalSavings');
    return true;
}

function ShowSavCode()
{
    frmMaintainExternalSavings.lovKey.value = "ExtSavCode" + frmMaintainExternalSavings.screenName.value + frmMaintainExternalSavings.screenMode.value;
    frmMaintainExternalSavings.queryParam.value = "hdnEmpLbrFlag="+frmMaintainExternalSavings.hdnEmpLbrFlag.value+",screenName="+frmMaintainExternalSavings.screenName.value+",screenMode="+frmMaintainExternalSavings.screenMode.value+",txtSiteID="+frmMaintainExternalSavings.loginLocCode.value;   // added by swapnendu Dt 14 May 2013.
    frmMaintainExternalSavings.txtDisplayFields.value = "txtSavCode1,txtSavCodeName";
    frmMaintainExternalSavings.txtSearchFields.value = "Payroll.MaintExtSavings.code,Payroll.MaintIntSavings.desc";              <!--// added by dushyant for saving desc -->
    frmMaintainExternalSavings.txtIndex.value ="";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainExternalSavings');
    return true;
}

function ShowDetEmpNum(i)
{   
    if(!(document.all.radioEmp.checked) || (document.all.radioSave.checked))
    {
        frmMaintainExternalSavings.lovKey.value = "ExtSav" + frmMaintainExternalSavings.screenName.value + frmMaintainExternalSavings.screenMode.value;
        frmMaintainExternalSavings.queryParam.value = "hdnEmpLbrFlag="+frmMaintainExternalSavings.hdnEmpLbrFlag.value+",screenName="+frmMaintainExternalSavings.screenName.value+",screenMode="+frmMaintainExternalSavings.screenMode.value+",txtSiteID="+frmMaintainExternalSavings.loginLocCode.value;   // added by swapnendu Dt 14 May 2013.
        frmMaintainExternalSavings.txtDisplayFields.value = "txtEmpNo,txtEmpName";
        frmMaintainExternalSavings.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";   <!-- added by dushaynt cpf code-->
        frmMaintainExternalSavings.txtIndex.value =i;             
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainExternalSavings');
        return true;
    }
     else
    {
        return false;
    }
}

function ShowDetSavCode(i)
{
    if(!(document.all.radioSave.checked) || (document.all.radioEmp.checked))
    {
        frmMaintainExternalSavings.lovKey.value = "ExtSavCode" + frmMaintainExternalSavings.screenName.value + frmMaintainExternalSavings.screenMode.value;
        frmMaintainExternalSavings.queryParam.value = "hdnEmpLbrFlag="+frmMaintainExternalSavings.hdnEmpLbrFlag.value+",screenName="+frmMaintainExternalSavings.screenName.value+",screenMode="+frmMaintainExternalSavings.screenMode.value+",txtSiteID="+frmMaintainExternalSavings.loginLocCode.value;   // added by swapnendu Dt 14 May 2013.
        frmMaintainExternalSavings.txtDisplayFields.value = "txtSavCode,txtDescription";
        frmMaintainExternalSavings.txtSearchFields.value = "Payroll.MaintExtSavings.code,Payroll.MaintIntSavings.desc";
        frmMaintainExternalSavings.txtIndex.value =i;      
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainExternalSavings');
        return true;
    }
   else
   {
       return false;
   }
}

function changed(val)
{
    frmMaintainExternalSavings.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
        document.getElementsByName("status")[val-1].value = 'U';
}

function lfnChange(ind,val)
{
    frmMaintainExternalSavings.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[ind-1].value == 'Q')
        document.getElementsByName("status")[ind-1].value = 'U';
    if (val == "A")
    {
        //alert("Please Insert Savings Number");
        document.getElementsByName("txtSavingsNumber")[ind-1].focus();
        document.getElementsByName("txtSavingsNumber")[ind-1].styleClass = "required";
    }  
}

function lfnSavTypeChange(ind,val)
{
    /*if (val == "A")
    {
        if (frmMaintainExternalSavings.hdnPayrollUser.value != 'Y')
        {
            alert("Sorry, You are not authorized to make Savings Type as Actuals");
            document.getElementsByName("txtType")[ind-1].value = 'P'; 
            return false;
        }
    }*/  
     
    frmMaintainExternalSavings.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[ind-1].value == 'Q')
        document.getElementsByName("status")[ind-1].value = 'U';
    if (val == "A" && (document.getElementsByName("txtSavingsNumber")[ind-1].value=="" || document.getElementsByName("txtSavingsNumber")[ind-1].value==''))
    {
        alert("Please Insert Savings Number");
        document.getElementsByName("txtSavingsNumber")[ind-1].focus();
        document.getElementsByName("txtSavingsNumber")[ind-1].styleClass = "required";      
    }  
}

function lfnChange1(ind1,val1)
{
    frmMaintainExternalSavings.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[ind1-1].value == 'Q')
    document.getElementsByName("status")[ind1-1].value = 'U';
    if (val1 == "552")
    {
        alert("Please Insert Savings Year");
        document.getElementsByName("txtSavingsYear")[ind1-1].focus();
        document.getElementsByName("txtSavingsYear")[ind1-1].styleClass = "required";
    }    
}

function doBaseAddRow()
{
   if(mandatory_Check("frmMaintainExternalSavings"))
   {
      document.all.buttonFlag.value='';
      frmMaintainExternalSavings.screenMode.value = "U";  
      document.forms[0].action = "../../../ExtSavAddRowAction.do";
      enable(); 
      document.forms[0].submit();
   }
    else
    {
        return false;
    }   
}

function doBaseDelRow()
{
    document.all.buttonFlag.value='';
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;    
    for(i=0; i < iTr2 -1; i++)
    {    
        if(document.getElementsByName("checked")[i].checked)
        {
            document.getElementsByName("itemChecked")[i].value = "Y";
            frmMaintainExternalSavings.detailDataChanged.value = "true";      
        }
    }    
    enable(); 
    document.forms[0].action = "../../../ExtSavDeleteRowAction.do";
    document.forms[0].submit();  
}

// Added by varalika on 30-Sep-2011
function doBaseShowHistory()
{

      var oTable = document.getElementById("Detail");
    
      if(oTable == null)
      {
       document.all.butHistory.disabled="true";
       return;
      }
    
      var iTr2 = oTable.rows.length;
      var i = 0;
      var f2=0;
	   var noRowSel=0;

      for(i=0; i < iTr2 - 1; i++)
      {
		   if(document.getElementsByName("checked")[i].checked)
          { 
		noRowSel =noRowSel + 1;
		  }
	  }

      for(i=0; i < iTr2 - 1; i++)
      {
           if(document.getElementsByName("checked")[i].checked)
          {          
              f2=f2+1;
		if(noRowSel == 1)
        {
              if(iTr2 <= 2)
              { if(!(frmMaintainExternalSavings.txtCreationDate[i].value&&frmMaintainExternalSavings.txtCreatedBy[i].value&&frmMaintainExternalSavings.txtCreatedSite[i].value))
				  {
				  alert("No history exists for the selected record");
				  }
				  else
				  {
				  alert("Record History "+"\n"
				  +"Creation Date :  "+ frmMaintainExternalSavings.txtCreationDate[i].value
				  +"\n"
				  +"Created By      :  "+frmMaintainExternalSavings.txtCreatedBy[i].value
				  +"\n"
				  +"Created Site    :  "+frmMaintainExternalSavings.txtCreatedSite[i].value
				  +"\n"
				  +"Updation Date:  "+frmMaintainExternalSavings.txtUpdationDate[i].value
				  +"\n"
				  +"Updated By     :  "+frmMaintainExternalSavings.txtUpdatedBy[i].value
				  +"\n"
				  +"Updated Site   :  "+frmMaintainExternalSavings.txtUpdatedSite[i].value
				  );
				}
              }
              else
              {
              if(!(frmMaintainExternalSavings.txtCreationDate[i].value&&frmMaintainExternalSavings.txtCreatedBy[i].value&&frmMaintainExternalSavings.txtCreatedSite[i].value))
              {
              alert("No history exists for the selected record");
              }
              else
              {
              alert("Record History"+"\n"
              +"Creation Date :  "+ frmMaintainExternalSavings.txtCreationDate[i].value+"\n"
              +"Created By      :  "+frmMaintainExternalSavings.txtCreatedBy[i].value
              +"\n"
              +"Created Site    :  "+frmMaintainExternalSavings.txtCreatedSite[i].value
              +"\n"
              +"Updation Date:  "+frmMaintainExternalSavings.txtUpdationDate[i].value
              +"\n"
              +"Updated By     :  "+frmMaintainExternalSavings.txtUpdatedBy[i].value
              +"\n"
              +"Updated Site   :  "+frmMaintainExternalSavings.txtUpdatedSite[i].value
              );
            }
           }
          }
		  }
      }
    
	if(noRowSel == 0 )
	{
	       alert("Select atleast one row for history !");
           document.all.butHistory.disabled="";
           return false;
	}

     if(noRowSel > 1)
        {
           alert("Select only one row for history !");
           document.all.butHistory.disabled="";
           return false;
        }
        
    if(f2 == 1)
      {
          document.all.butHistory.disabled="";
        //  showHistWin('<html:rewrite page="/Payroll/JSP/COMMON/JSP/ShowHistory.jsp" />', 'frmMaintainExternalSavings');
          return true;
      }
    
    if(f2 == 0)
      {
		   document.all.butHistory.disabled="";
       return false;
      }
}
//Added By Varalika Ends here

function SaveRecord()
{ 
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmMaintainExternalSavings"))
    {
        enable();     
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
            frmMaintainExternalSavings.detailDataChanged.value = "true";
            
            var type=document.getElementsByName("txtType")[i].value;
            var num=document.getElementsByName("txtSavingsNumber")[i].value;
            if(type=='A' && num=='')
            {
                alert("Please Enter The Savings Number")
                return false;
            }            
        }    
        if(document.frmMaintainExternalSavings.optVal.value == "2") 
        {
            if (document.all.screenMode.value == "N")
            {
                document.all.screenExt.value = "UG";
                document.all.screenMode.value = "U";    
            }
        }  
        frmMaintainExternalSavings.headerFields.value = "false";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmMaintainExternalSavings.action = "../../../ExtSavSaveAction.do";
        frmMaintainExternalSavings.submit();
    }
    else
    {
        return false;
    }
}

function GetDetail()
{
    document.all.buttonFlag.value='';
    document.all.screenExt.value = 'UG';
    
    frmMaintainExternalSavings.screenMode.value='U';
    frmMaintainExternalSavings.headerDataChanged.value = "false";
    
    if(!mandatory_Check("frmMaintainExternalSavings"))
        return false;    
    
    if(document.frmMaintainExternalSavings.optVal.value == "1") 
        frmMaintainExternalSavings.headerPrimaryKey.value = frmMaintainExternalSavings.txtSavCode1.value ;  
    
    if(document.frmMaintainExternalSavings.optVal.value == "2")  
        frmMaintainExternalSavings.headerPrimaryKey.value = frmMaintainExternalSavings.txtEmpNo1.value ;  
    else 
        frmMaintainExternalSavings.headerPrimaryKey.value = "";  
    
    frmMaintainExternalSavings.action="../../../ExtSavGetDetailAction.do"
    frmMaintainExternalSavings.submit();
}

function SavCodeClick()
{
    document.frmMaintainExternalSavings.hdnAction.value = "";    
    document.all.buttonFlag.value='';
    if (document.all.screenExt.value == 'UG')
        document.all.screenExt.value = 'U';    
    document.frmMaintainExternalSavings.action="../../../ExtSavOptionClickAction.do";
    document.frmMaintainExternalSavings.optVal.value="1";     
    document.frmMaintainExternalSavings.submit();
}

function EmpNoClick() 
{
    document.frmMaintainExternalSavings.hdnAction.value = "";  
    document.all.buttonFlag.value='';
    if(document.all.screenExt.value == 'UG')
        document.all.screenExt.value = 'U';
    
    document.frmMaintainExternalSavings.action="../../../ExtSavOptionClickAction.do";
    document.frmMaintainExternalSavings.optVal.value="2";
    document.frmMaintainExternalSavings.submit(); 
}
  
function MiscelClick() 
{
    document.frmMaintainExternalSavings.hdnAction.value = "";  
    document.all.buttonFlag.value='';
    if (document.all.screenExt.value == 'UG')
        document.all.screenExt.value = 'U';
    
    document.frmMaintainExternalSavings.action="../../../ExtSavOptionClickAction.do";
    document.frmMaintainExternalSavings.optVal.value="3";        
    document.frmMaintainExternalSavings.submit(); 
}

function doInsertMode()
{
    document.frmMaintainExternalSavings.hdnAction.value = "";
    document.all.buttonFlag.value='';
    document.all.screenExt.value = 'N';
    frmMaintainExternalSavings.headerDataChanged.value = "false";
    
    frmMaintainExternalSavings.action="../../../ExtSavNewMode.do"
    frmMaintainExternalSavings.submit();
}

function doQueryMode()
{
    document.frmMaintainExternalSavings.hdnAction.value = "";
    document.all.buttonFlag.value='';
    document.all.screenExt.value = 'Q';
    frmMaintainExternalSavings.headerDataChanged.value = "false";
    
    frmMaintainExternalSavings.action="../../../ExtSavQueryMode.do"
    frmMaintainExternalSavings.submit();
}



function enable()
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
        document.getElementsByName("txtSavCode")[i].disabled="";
        document.getElementsByName("txtEmpNo")[i].disabled="";    
    }
}

function chk_Year(val)
{     
    if (num_Check(val,1))
    {                                   
        if (val.length != 4)
        {
            alert(" Year should be a Four digit Number");    
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                            
            return false;    
        }    
        else
        {
            return true;
        }
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;     
        return false;
    }
}

function doRefresh()
{
    frmMaintainExternalSavings.action="../../../ExternalRefresh.do"
    frmMaintainExternalSavings.submit();
}

function ShowLovYYMM()
{
    frmMaintainExternalSavings.lovKey.value = "ExtSvgFinYYMM" + frmMaintainExternalSavings.screenName.value + frmMaintainExternalSavings.screenMode.value;
    frmMaintainExternalSavings.txtDisplayFields.value = "txtFinYYMM";      
    frmMaintainExternalSavings.txtSearchFields.value = "pay.MaintainAnnualIncome.FinYYMM";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainAnnualIncome');
    return true;
}

function lfnGetEmpName(val) 
{
   /* if (val != "")
   {
         frmMaintainExternalSavings.hdnAction.value="GetEmpName";
         frmMaintainExternalSavings.action="../../../ExtSavGetEmpName.do"     
         frmMaintainExternalSavings.submit();
   }*/
}

function lfnGetEmpNameDtl(val, value) 
{
    /*if (value != "")
    {
      if(frmMaintainExternalSavings.screenExt.value="N") 
      {
         frmMaintainExternalSavings.hdnAction.value="GetEmpNameDtl";
         frmMaintainExternalSavings.hdnRowVal.value=val;
         frmMaintainExternalSavings.hdnEmpNo.value=value;     
         frmMaintainExternalSavings.action="../../../ExtSavGetEmpName.do"     
         frmMaintainExternalSavings.submit();
      }
    }*/
}


function lfnGetPayCodeName(val) 
{
    /*if (val != "")
    {
        frmMaintainExternalSavings.hdnAction.value="GetPayCodeName";
        frmMaintainExternalSavings.action="../../../ExtSavGetEmpName.do"     
        frmMaintainExternalSavings.submit();
    }*/
}

function lfnGetPayCodeNameDtl(val, value) 
{
    /*if (value != "")
    {
        if(frmMaintainExternalSavings.screenExt.value="N") 
        {
            frmMaintainExternalSavings.hdnAction.value="GetPayCodeNameDtl";
            frmMaintainExternalSavings.hdnRowVal.value=val;
            frmMaintainExternalSavings.hdnPayCode.value=value;     
            frmMaintainExternalSavings.action="../../../ExtSavGetEmpName.do"     
            frmMaintainExternalSavings.submit();
        }
    }*/
}

function chk_FinYear(val)
{
    var  yearM = document.getElementById("txtFinYYMM").value;          
    var Year1;
    var Year2;    
    if ( yearM != "") 
    {
        if (num_Check(yearM,1))
        {                                   
            if (yearM.length != 6)
            {
                alert(" Year Month should be a Six digit Number");
                document.getElementById("txtFinYYMM").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                            
                return false;    
            }        
            Year1 =  yearM.substring(2,4);
            Year2 =  yearM.substring(4,6);           
            
            var TempYr1 = parseInt(Year1) + 1; 
            var TempYr2 = parseInt(Year2);              
            
         /*   if (parseInt(TempYr1,10) != parseInt(TempYr2,10))
            {
                alert("Year Range Should be in the format of a Financial Period Eg. 200607");
                document.getElementById("txtFinYYMM").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                   
                return false;       
            }
            */
    
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

function JumpDetail()
{
    frmMaintainExternalSavings.userPageRequested.value = 1*frmMaintainExternalSavings.newPageRequested.value ;
    frmMaintainExternalSavings.action = "../../../ExtSavNextDetailAction.do";
    frmMaintainExternalSavings.submit();
}

function doBasePrevDetail()
{
    frmMaintainExternalSavings.userPageRequested.value = 1*frmMaintainExternalSavings.pageRequested.value - 1;
    frmMaintainExternalSavings.action = "../../../ExtSavNextDetailAction.do";
    frmMaintainExternalSavings.submit();
}


function doBaseNextDetail()
{
    frmMaintainExternalSavings.userPageRequested.value = 1*frmMaintainExternalSavings.pageRequested.value + 1;
    frmMaintainExternalSavings.action = "../../../ExtSavNextDetailAction.do";
    frmMaintainExternalSavings.submit();
}
</script>
