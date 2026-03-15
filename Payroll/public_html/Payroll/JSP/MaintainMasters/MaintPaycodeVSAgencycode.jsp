
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
         <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>

</head>
<!--<BODY scroll=no onload="lfnLoad();">-->
 <BODY scroll=yes  onload="lfnLoad(); history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false"></BODY>
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>


<html:form  action="MaintPaycodeVSAgencycodeAction" name="frmMaintPaycodeVSAgencycode" type="FCIPAY.Payroll.WEBTIER.Form.MaintPaycodeVSAgencycodeForm" scope="session">
<bean:define id="ParentForm" name="frmMaintPaycodeVSAgencycode" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10> MAINTAIN PAYCODE VS AGENCY CODE MAPPING</TD>
  </TR>

  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
          
   <TR>
    <TD>
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                 <!-- <TD class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();" /></TD>
                    <!--<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>-->
                    <td bgcolor="#4682B4" nowrap class=actTabText>Pay code VS Agency code<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                <TBODY>
                                     <TR height="20">
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"   /></td>
                                              <TD class=tableHeader width="7%">Paycode</td>
                                                <TD class=tableHeader width="9%">Paycode Desc</td>
                                              <TD class=tableHeader width="9%">Agency Code</TD>
                                               <TD class=tableHeader width="9%">Agency Desc</TD>
                                              <TD class=tableHeader width="9%">Agency Site</td>
                                                  <TD class=tableHeader width="11%">Agency Site Desc</td>
                                              
                                               <!--TD class=tableHeader width="9%">Location Code</td>
                                                 <TD class=tableHeader width="11%">Location Desc</td-->
                                              <td class=tableHeader width="9%">Employee No </td>  
                                               <td class=tableHeader width="11%">Employee Name </td> 
                                              
                                      </TR>    
                                                                                 <!--  property="PaycodevsAgency"-->
                          <logic:iterate id="intInfo" name="frmMaintPaycodeVSAgencycode"  property="paycodevsAgency" type="FCIPAY.Payroll.UTILITY.MaintPaycodeVSAgencycodeBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="intInfo" property="status" value="D" >                                
                                   <tr> 
                                   
                                      <td ><html:checkbox property="checked" name="frmMaintPaycodeVSAgencycode" onclick="checkRecord();"  /></td>
                                      
                                      <td ><html:text property="txtPayCode" name="intInfo" styleClass="required" style="width:60%" readonly="true" alt="<%=String.valueOf(i)%>" onchange="checkDuplicacy(this,this.alt);changed(this.alt);"  />
                                      
                                      <logic:equal name="intInfo" property="status" value="N">                                       
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  onclick="ShowPayCode(this.alt);" >
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  onclick="ShowPayCode(this.alt);" disabled="true" >
                                      </logic:equal>                                      
                                       
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  enabled onclick="ShowPayCode(this.alt);" >                                       
                                      </logic:equal>
                                       
                                      <td >   <html:text property="txtPayCodeDesc" name="intInfo"  styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td> 
                                   <td>   <html:text property="txtAgency" name="intInfo" style="width:60%"  styleClass="required" readonly="true" alt="<%=String.valueOf(i)%>"  onchange="checkDuplicacy(this,this.alt);changed(this.alt);"   />                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency" onclick="ShowAgency(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  enabled onclick="ShowAgency(this.alt);" disabled="true" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  onclick="ShowAgency(this.alt);" >                                       
                                      </logic:equal>
                                      </td>
                                      <td >   <html:text property="txtAgencyDesc" name="intInfo" styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td> 
                                       
                                       <td ><html:text property="txtAgencySite" name="intInfo" size="19"   styleClass="required" readonly="true"  alt="<%=String.valueOf(i)%>" style="width:60%" onchange="return changed(this.alt);"  />         
                                        <logic:equal name="intInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite" onclick="ShowAgencySite(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite" onclick="ShowAgencySite(this.alt);" disabled="true" />
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite"  onclick="ShowAgencySite(this.alt);" >                                       
                                      </logic:equal>
                                      <td >   <html:text property="txtAgencySiteDesc" name="intInfo"  styleClass="locked" readonly="true" size="19" style="width:95%" alt="<%=String.valueOf(i)%>"  /></td> 
                                      </td>
                                       <!--td ><html:text property="txtLocation" name="intInfo"    styleClass="optional" readonly="true" style="width:60%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" />
                                       
                                       <logic:equal name="intInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtLocation" onclick="ShowLocation(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtLocation"  enabled onclick="ShowLocation(this.alt);" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtLocation"  onclick="ShowLocation(this.alt);" >                                       
                                      </logic:equal>
                                      </td>
                                      <td >   <html:text property="txtLocationDesc" name="intInfo"  styleClass="locked" readonly="true" size="19" style="width:90%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td--> 
                                       <td ><html:text property="txtEmployeeNo" name="intInfo"     styleClass="optional" readonly="true" style="width:60%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" />        
                                         
                                       <logic:equal name="intInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmployeeNo" onclick="ShowEmployeeNo(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmployeeNo" onclick="ShowEmployeeNo(this.alt);" disabled="true"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmployeeNo"  onclick="ShowEmployeeNo(this.alt);" >                                       
                                      </logic:equal>
                                      <td >   <html:text property="txtEmployeeNoDesc" name="intInfo"  styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td> 
                                      </td>
                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo" />
                                     
										<html:hidden property="txtLocation" name="intInfo" />
										<html:hidden property="txtLocationDesc" name="intInfo" />
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="intInfo" property="status" value="D" >
                                   <tr>
                                         <td ><html:hidden property="checked" name="frmMaintPaycodeVSAgencycode" value="notchecked" /></td>
                                 
                                         <td ><html:hidden property="txtPayCode" name="intInfo" /></td>
                                         <td ><html:hidden property="txtPayCodeDesc" name="intInfo" /></td>
                                      
                                         <td ><html:hidden property="txtAgency" name="intInfo" /></td>
                                         <td ><html:hidden property="txtAgencyDesc" name="intInfo" /></td>
                                          

                                       <td ><html:hidden property="txtAgencySite" name="intInfo" /></td>
                                       <td ><html:hidden property="txtAgencySiteDesc" name="intInfo" /></td>
                                       <td ><html:hidden property="txtLocation" name="intInfo" /></td>
                                       <td ><html:hidden property="txtEmployeeNo" name="intInfo" /></td>
                                       <td ><html:hidden property="txtLocationDesc" name="intInfo" /></td>
                                       <td ><html:hidden property="txtEmployeeNoDesc" name="intInfo" /></td>
                                       
                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo"  />
                                       
                                    </tr>
                                  </logic:equal>                                    
                               </logic:iterate>
                                
                            </TBODY>
                          </TABLE>
                        </DIV>
                      </TD>
                    </TR> 
                                        
                                <td colspan=11>	
                                  <TABLE border=0>
                                    <TBODY>
                                      <TR>
                                        <td colspan=11>	
                                          <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
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
                    </TABLE>
                  </td>
                </tr>
                <!-- Tab Table Ends -->
 
                                        <!-- Bottom Blue Bar -->
                <TR>
                  <td align=center bgcolor=#4682b4 width="40%"></td>
                  <td  bgcolor=#4682b4></td>
                  <td bgColor=#4682b4></td>
                  <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
                </TR>
                  </TBODY>
				<table cellSpacing=0 cellPadding=3 border=0>
					<tr height=50><td>&nbsp;</tr>
					<tr height=20>
						<td style="font-size:12px;font-weight:bold"> Note:</td>
					</tr>
					<tr>
						<td style="font-size:12px">1. If user wants to remit to the same agency and for the same pay code, then after selecting <i>Pay code</i>, please select <i>Employee</i> and then select <i>Agency</i>.</td>
					</tr>
				</tr>
				</table>
              </TABLE>
            <!-- Container Table Ends-->
<html:hidden property="headerPrimaryKey" name="frmMaintPaycodeVSAgencycode"  />

<html:hidden property="screenMode" name="frmMaintPaycodeVSAgencycode"  />
<html:hidden name="frmMaintPaycodeVSAgencycode"  property="screenName" value="MaintPaycodeVSAgencycode" />
<html:hidden name="frmMaintPaycodeVSAgencycode"  property="forwardedPage" />

 
<html:hidden property="lovKey" name="frmMaintPaycodeVSAgencycode"  />
<html:hidden property="txtFields" name="frmMaintPaycodeVSAgencycode"  />
<html:hidden property="txtSearchFields" name="frmMaintPaycodeVSAgencycode"  />
<html:hidden property="txtDisplayFields" name="frmMaintPaycodeVSAgencycode"  />
<html:hidden property="txtIndex" name="frmMaintPaycodeVSAgencycode"  />
<html:hidden property="txtInputField" name="frmMaintPaycodeVSAgencycode"  />
<html:hidden property="buttonFlag" name="frmMaintPaycodeVSAgencycode"  />
<html:hidden property="userPageRequested" name="frmMaintPaycodeVSAgencycode" />
<html:hidden property="pageRequested" name="frmMaintPaycodeVSAgencycode" />
<html:hidden property="loginLocCode" name="frmMaintPaycodeVSAgencycode" />
<input type="hidden" name="queryParam" />
</html:form>
</body>
</html:html>

<script language="javascript">
//int chk_flag=0;
function lfnLoad()
{
   var mode = document.all.screenMode.value;
    
    if(mode=='')
    {
        doQueryMode();
    }    
    if(mode=='Q')
    {
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="true";
    }
    if(mode=='U')
    {
      document.all.butGetDetail.disabled="true";
      document.all.butInsert.disabled="";
    }

     detMenuHandling(mode);
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

function changed(i)
{
  frmMaintPaycodeVSAgencycode.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[i-1].value == 'Q')
     document.getElementsByName("status")[i-1].value = 'U';
}
function doQueryMode()
{
    document.all.buttonFlag.value='';    
    frmMaintPaycodeVSAgencycode.action="../../../PaycodeAgencycodeQueryMode.do"
    frmMaintPaycodeVSAgencycode.submit();
}

function doRefresh()
{
    frmMaintPaycodeVSAgencycode.action="../../../PaycodeAgencycodeRefresh.do"
    frmMaintPaycodeVSAgencycode.submit();
}

function GetDetail()
{
   frmMaintPaycodeVSAgencycode.headerPrimaryKey.value = document.getElementById("loginLocCode").value;
   frmMaintPaycodeVSAgencycode.screenMode.value='U';    
   frmMaintPaycodeVSAgencycode.action="../../../PaycodeAgencycodeGetDetailAction.do"
   frmMaintPaycodeVSAgencycode.submit();
}

function SaveRecord()
{ 
    if(mandatory_Check("frmMaintPaycodeVSAgencycode"))
    {
        //enableAll(); 
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
               frmMaintPaycodeVSAgencycode.detailDataChanged.value = "true";
        }    
        document.all.buttonFlag.value='';
       frmMaintPaycodeVSAgencycode.headerFields.value = "false";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
       frmMaintPaycodeVSAgencycode.action = "../../../PaycodeAgencycodeSaveAction.do";
       frmMaintPaycodeVSAgencycode.submit();
    }
    else
    {
        return false;
    }
    
}

function doBaseAddRow()
{
    if(mandatory_Check("frmMaintPaycodeVSAgencycode"))
    { 
    
        document.all.buttonFlag.value='';
        frmMaintPaycodeVSAgencycode.screenMode.value = "U";  
        document.forms[0].action = "../../../PaycodeAgencycodeAddRowAction.do";
        //enableAll(); 
        
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
            frmMaintPaycodeVSAgencycode.detailDataChanged.value = "true";      
        }
    }    
   // enable(); 
    document.forms[0].action = "../../../PaycodeAgencycodeDeleteRowAction.do";
    document.forms[0].submit();  
}
function ShowPayCode(i)
{
    frmMaintPaycodeVSAgencycode.lovKey.value = "PaycodeAgencycodePayCode" + frmMaintPaycodeVSAgencycode.screenName.value + frmMaintPaycodeVSAgencycode.screenMode.value;
    frmMaintPaycodeVSAgencycode.queryParam.value = "hdnEmpLbrFlag="+frmMaintPaycodeVSAgencycode.hdnEmpLbrFlag.value+",screenName="+frmMaintPaycodeVSAgencycode.screenName.value+",screenMode="+frmMaintPaycodeVSAgencycode.screenMode.value+",txtSiteID="+frmMaintPaycodeVSAgencycode.loginLocCode.value;   // added by swapnendu Dt 07 Sep 2012.
    frmMaintPaycodeVSAgencycode.txtDisplayFields.value = "txtPayCode,txtPayCodeDesc";
    frmMaintPaycodeVSAgencycode.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Paycode,Payroll.PaycodeVSAgencycode.PayDesc";
    frmMaintPaycodeVSAgencycode.txtIndex.value =i;      
    frmMaintPaycodeVSAgencycode.txtInputField.value ="txtPayCode";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPaycodeVSAgencycode');
    return true;
}

function ShowAgency(i)
{
   frmMaintPaycodeVSAgencycode.lovKey.value = "PaycodeAgencycodeAgency" + frmMaintPaycodeVSAgencycode.screenName.value + frmMaintPaycodeVSAgencycode.screenMode.value;
   frmMaintPaycodeVSAgencycode.txtDisplayFields.value = "txtAgency,txtAgencyDesc";
   frmMaintPaycodeVSAgencycode.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Agency,Payroll.Common.Desc";
   frmMaintPaycodeVSAgencycode.txtIndex.value =i; 
   frmMaintPaycodeVSAgencycode.txtInputField.value ="txtAgency"; 
   
   if(document.getElementsByName("txtEmployeeNo")[i].value!="" )
   {
   frmMaintPaycodeVSAgencycode.queryParam.value ="txtSiteID="+frmMaintPaycodeVSAgencycode.loginLocCode.value+",txtEmployeeNo="+document.getElementsByName("txtEmployeeNo")[i].value;
   }
   else
   {
      frmMaintPaycodeVSAgencycode.queryParam.value ="txtSiteID="+frmMaintPaycodeVSAgencycode.loginLocCode.value+",txtEmployeeNo=1";
   }
   
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPaycodeVSAgencycode');
    return true;
}
function ShowAgencySite(i)
{
   frmMaintPaycodeVSAgencycode.lovKey.value = "PaycodeAgencycodeAgencySite" + frmMaintPaycodeVSAgencycode.screenName.value + frmMaintPaycodeVSAgencycode.screenMode.value;
   frmMaintPaycodeVSAgencycode.txtDisplayFields.value = "txtAgencySite,txtAgencySiteDesc";
   frmMaintPaycodeVSAgencycode.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.AgencySite,Payroll.PaycodeVSAgencycode.AgencySiteDesc";
   frmMaintPaycodeVSAgencycode.txtIndex.value =i; 
   frmMaintPaycodeVSAgencycode.txtInputField.value ="txtAgencySite"; 
   if(document.getElementsByName("txtAgency")[i].value!="" )
   {
   frmMaintPaycodeVSAgencycode.queryParam.value ="txtAgency="+document.getElementsByName("txtAgency")[i].value+",txtSiteID="+frmMaintPaycodeVSAgencycode.loginLocCode.value;
   }
   else
   {
   alert("Please Select the Agency first");
   return;
   }
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmMaintPaycodeVSAgencycode');
    return true;
}
function ShowLocation(i)
{
   frmMaintPaycodeVSAgencycode.lovKey.value = "PaycodeAgencycodeLocation" + frmMaintPaycodeVSAgencycode.screenName.value + frmMaintPaycodeVSAgencycode.screenMode.value;
   frmMaintPaycodeVSAgencycode.txtDisplayFields.value = "txtLocation,txtLocationDesc";
   frmMaintPaycodeVSAgencycode.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Location";
   frmMaintPaycodeVSAgencycode.txtIndex.value =i;     
   frmMaintPaycodeVSAgencycode.txtInputField.value ="txtLocation";  
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPaycodeVSAgencycode');
    return true;
}
function ShowEmployeeNo(i)
{
   frmMaintPaycodeVSAgencycode.lovKey.value = "PaycodeAgencycodeEmployeeNo" + frmMaintPaycodeVSAgencycode.screenName.value + frmMaintPaycodeVSAgencycode.screenMode.value;
   frmMaintPaycodeVSAgencycode.queryParam.value = "txtSiteID="+frmMaintPaycodeVSAgencycode.loginLocCode.value;
   frmMaintPaycodeVSAgencycode.txtDisplayFields.value = "txtEmployeeNo,txtEmployeeNoDesc";
   frmMaintPaycodeVSAgencycode.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.PaycodeVSAgencycode.EmployeeName,Payroll.LoanForeclosure.CPFCode";
   frmMaintPaycodeVSAgencycode.txtIndex.value =i;      
   frmMaintPaycodeVSAgencycode.txtInputField.value ="txtEmployeeNo"; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPaycodeVSAgencycode');
    return true;
}

function doBasePrevDetail()
{
    frmMaintPaycodeVSAgencycode.userPageRequested.value = 1*frmMaintPaycodeVSAgencycode.pageRequested.value - 1;
    frmMaintPaycodeVSAgencycode.action = "../../../PaycodeAgencycodePrevAction.do";
     frmMaintPaycodeVSAgencycode.submit();
}


function doBaseNextDetail()
{
   frmMaintPaycodeVSAgencycode.userPageRequested.value = 1*frmMaintPaycodeVSAgencycode.pageRequested.value + 1;
    frmMaintPaycodeVSAgencycode.action = "../../../PaycodeAgencycodeNextAction.do";
    frmMaintPaycodeVSAgencycode.submit();
}

function JumpDetail()
{
    frmMaintPaycodeVSAgencycode.userPageRequested.value = 1*frmMaintPaycodeVSAgencycode.newPageRequested.value ;
    frmMaintPaycodeVSAgencycode.action = "../../../PaycodeAgencycodeJumpAction.do";
    frmMaintPaycodeVSAgencycode.submit();
}


/*function checkDuplicacy(that,rInd)
{
 // alert("inside checkDuplicacy");
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName("txtPayCode")[rInd-1].value;
  newComb = newComb + "-";
  newComb = newComb + document.getElementsByName("txtAgency")[rInd-1].value;

  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(ind != rInd)
    {
      oldComb = document.getElementsByName("txtPayCode")[ind-1].value;
      oldComb = oldComb + "-";
      oldComb = oldComb + document.getElementsByName("txtAgency")[ind-1].value;
      if(oldComb == newComb)
      {
        //chk_flag=1;
        alert("You can\'t enter duplicate value. Record already exists ");
        document.getElementsByName("txtAgency")[rInd-1].value="";
      //  document.getElementsByName("txtPayCode")[rInd-1].focus();
       //  document.getElementsByName("buttxtAgencySite")[rInd-1].disabled="true"  
        //checkDuplicacy(this,this.alt);
        
        return;
      }
    }
  }*/

function checkDuplicacy(that,rInd)
{
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName("txtPayCode")[rInd-1].value;
  newpay=newComb;
  newComb = newComb + "-";
  newComb = newComb + document.getElementsByName("txtAgency")[rInd-1].value + "-" + document.getElementsByName("txtEmployeeNo")[rInd-1].value;
   var newEmp= document.getElementsByName("txtEmployeeNo")[rInd-1].value;
   var newagncy=document.getElementsByName("txtAgency")[rInd-1].value;
  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(ind != rInd && document.getElementsByName("status")[ind-1].value!='D')
    {
      oldComb = document.getElementsByName("txtPayCode")[ind-1].value;
      oldpay=oldComb;
      oldComb = oldComb + "-";
      oldComb = oldComb + document.getElementsByName("txtAgency")[ind-1].value + "-" + document.getElementsByName("txtEmployeeNo")[ind-1].value;
     var oldEmp= document.getElementsByName("txtEmployeeNo")[ind-1].value;
     var oldagncy=document.getElementsByName("txtAgency")[ind-1].value;
      
      if((oldComb == newComb) || ((newpay == oldpay) && (newEmp == oldEmp) && (newagncy != oldagncy)))
      {
        alert("You can't enter duplicate paycode.If you entering for a particular employee.Kindly enter employee number first.");
        document.getElementsByName("txtAgency")[rInd-1].value="";
        document.getElementsByName("txtAgencyDesc")[rInd-1].value="";
        return;
      }
      
   }

  }  
}     

  

</script>