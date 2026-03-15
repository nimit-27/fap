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
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
      <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
    </head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0; %>
<% i = 0; j=0; %>

<html:form  action="MaintPayCodeAgencyMap" name="frmMaintPayCodeAgencyMap" type="FCIPAY.Payroll.WEBTIER.Form.MaintPayCodeAgencyMapForm" scope="session">

<bean:define id="ParentForm" name="frmMaintPayCodeAgencyMap" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" />
<html:hidden property="headerDataChanged" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="optVal" />

<table>
  <TR height=30>
    <TD  colSpan=12 class=mainHeader height=10>Pay Code vs Agency Code Mapping</TD>
  </TR>
</TABLE>
<html:errors/>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
    <TR>
      <TD>	
        <!--<div id=divBody>-->
        <!-- Body table Starts -->
        <TABLE cellSpacing=0 cellPadding=0 >
        <!--Account  Header Row Starts -->
          <TR>
            <TD class=subHeader colspan=6>Pay Code vs Agency Code Mapping</TD>
          </TR>
          <TR>
            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
          </TR>

          <tr height="15" >
            <td colspan="2"></td>
          </tr>
       
          <TR>                            
            <td width="30%" class="radioText" ><input type="radio" name="radioMisc" value="P" onclick="PayCodeClick()"   ><bean:message key="Payroll.PayCodeVsAgencyMap.payCode"  />
            
            <td width="45%" class="radioText" ><input type="radio" name="radioMisc" value="L" onclick="LocClick()" ><bean:message  key="Payroll.PayCodeVsAgencyMap.loc" />
            
            <td width="25%" class="radioText"><input type="radio" name="radioMisc" value="A" onclick="MiscelClick()" ><bean:message  key="Payroll.PayCodeVsAgencyMap.all" />
          <td colspan="3" ></td>          
          </TR>
          
          <tr height="10">	
            <td></td>
          </tr>         
        
          <logic:equal property= "optVal" name= "frmMaintPayCodeAgencyMap" value="P">
          <tr>
          <td class="labelText"  width="40%" ><bean:message key="Payroll.PayCodeVsAgencyMap.payCode" /></td>
          <td><html:text  property="txtPayCodeDescHdr" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="10" size="23" styleClass="required"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayCode1" onclick="return ShowPayCode();" >
          <html:hidden  property="txtPayCodeHdr"  /></td>
          </tr>
          </logic:equal>
          
          <logic:equal property= "optVal" name= "frmMaintPayCodeAgencyMap" value="L">
          <tr>
          <td class="labelText"  width="40%" ><bean:message key="Payroll.PayCodeVsAgencyMap.loc" /></td>
          <td><html:text  property="txtLocDescHdr" altKey="Payroll.MaintElecMtrRdg.empno" maxlength="10" size="23" styleClass="required"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo1"  onclick="return ShowLoc();" >
          <html:hidden  property="txtLocHdr"  /></td>
          </tr>
          </logic:equal>
          
          <logic:equal property= "optVal" name= "frmMaintPayCodeAgencyMap" value="A">
          <tr height = 30><td width="40%" >&nbsp;</td>    <td>&nbsp; </td>
          </tr>
          </logic:equal>
        </tr>  
        <TD colspan="6" > </TD>
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
                <td bgcolor="#4682B4" nowrap class=actTabText>PayCode vs Agency Code Mapping<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <td class=tableHeader><bean:message key="Payroll.PayCodeVsAgencyMap.payCode"  /></td>
                              <td class=tableHeader><bean:message key="Payroll.PayCodeVsAgencyMap.agency" /></td>                                               
                              <td class=tableHeader><bean:message key="Payroll.PayCodeVsAgencyMap.agencySite" /></td>
                              <td class=tableHeader><bean:message key="Payroll.PayCodeVsAgencyMap.loc" /></td>                                               
                              <td class=tableHeader><bean:message key="Payroll.PayCodeVsAgencyMap.emp" /></td>                                               
                            </TR>
                            
                            <logic:iterate id="intInfo" name="frmMaintPayCodeAgencyMap" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintPayCodeAgencyMapBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="intInfo" property="status" value="D" >                                
                                   <tr>
                                      <td ><html:checkbox property="checked" name="frmMaintPayCodeAgencyMap" disabled="true"  /></td>
                                      
                                      <td ><html:text property="txtPayCodeDesc" name="intInfo" styleClass="locked" size="11" readonly="true" alt="<%=String.valueOf(i)%>"  />
                                      
                                      <logic:equal name="intInfo" property="status" value="N">                                       
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"   >
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowDetEmpNum(this.alt);" >                                     
                                      </logic:equal>                                      
                                       
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowDetEmpNum(this.alt);" >                                       
                                      </logic:equal>
                                       
                                      </td><html:hidden property="txtPayCode" name="intInfo" />        
                                      <td ><html:text property="txtAgencyCode" name="intInfo" size="10"    styleClass="locked" alt="<%=String.valueOf(i)%>" readonly="true"  />                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode"   >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode"  disabled onclick="ShowDetSavCode(this.alt);" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtSavCode"  onclick="ShowDetSavCode(this.alt);" >                                       
                                      </logic:equal>
                                      </td>
                                       
                                       <td ><html:text property="txtAgencySite" name="intInfo" size="19"   styleClass="locked"  alt="<%=String.valueOf(i)%>"  readonly="true" /></td>         
                                       <td ><html:text property="txtLocDesc" name="intInfo" size="8"    styleClass="locked" readonly="true" style="width:100%" alt="<%=String.valueOf(i)%>"  /></td>         
                                       <html:hidden property="txtLoc" name="intInfo" />
                                       <td ><html:text property="txtEmpNo" name="intInfo" size="5"    styleClass="locked" readonly="true" style="width:100%" alt="<%=String.valueOf(i)%>"  /></td>         
                                         
                                       
                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo" value="Default"/>
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="intInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintPayCodeAgencyMap" value="notchecked" /></td>
                                       <td ><html:hidden property="txtPayCodeDesc" name="intInfo" /></td>
                                       <td ><html:hidden property="txtPayCode" name="intInfo" /></td>
                                       <td ><html:hidden property="txtAgencyCode" name="intInfo" /></td>
                                       <td ><html:hidden property="txtAgencySite" name="intInfo" /></td>
                                       <td ><html:hidden property="txtLocDesc" name="intInfo" /></td>
                                      <td ><html:hidden property="txtEmpNo" name="intInfo" /></td>
                                       <td ><html:hidden property="txtLoc" name="intInfo" /></td>
                                       
                                        <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo" value="Default"/>
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
                                <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                              </td>
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
        <td align=center bgcolor=#4682b4 width="40%"></td>
        <!--<td  bgcolor=#4682b4><html:button value='Approve'  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Reject '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Revise '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /></td>  -->
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
<html:hidden property="headerPrimaryKey" name="frmMaintPayCodeAgencyMap"  />
<html:hidden property="hdnAction" name="frmMaintPayCodeAgencyMap"  />
<html:hidden property="screenMode" name="frmMaintPayCodeAgencyMap"  />
<html:hidden name="frmMaintPayCodeAgencyMap"  property="screenName" value="PayCodeAgencyMapScreen" />
<html:hidden name="frmMaintPayCodeAgencyMap"  property="forwardedPage" />
<!--<html:hidden name="frmMaintainInternalSavings"  property="headerFields" />-->
<!--<html:hidden name="frmMaintainInternalSavings"  property="totalDetailRecord" />-->
<html:hidden property="screenInt" name="frmMaintPayCodeAgencyMap"  />
<html:hidden property="lovKey" name="frmMaintPayCodeAgencyMap"  />
<html:hidden property="txtFields" name="frmMaintPayCodeAgencyMap"  />   
<html:hidden property="txtSearchFields" name="frmMaintPayCodeAgencyMap"  />
<html:hidden property="txtDisplayFields" name="frmMaintPayCodeAgencyMap"  />
<html:hidden property="txtIndex" name="frmMaintPayCodeAgencyMap"  />
<html:hidden property="buttonFlag" name="frmMaintPayCodeAgencyMap"  />
<html:hidden property="userPageRequested" name="frmMaintPayCodeAgencyMap" />
<html:hidden property="pageRequested" name="frmMaintPayCodeAgencyMap" />
<html:hidden property="loginLocCode" name="frmMaintPayCodeAgencyMap" />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>        

<script language="javascript">

function ShowEmpNum()
{
    frmMaintPayCodeAgencyMap.lovKey.value = "IntSav" + frmMaintPayCodeAgencyMap.screenName.value + frmMaintPayCodeAgencyMap.screenMode.value;
    frmMaintPayCodeAgencyMap.txtDisplayFields.value = "txtEmpNo1,txtEmpName1";
    frmMaintPayCodeAgencyMap.queryParam.value = "txtSiteID="+frmMaintPayCodeAgencyMap.loginLocCode.value+" ";
    frmMaintPayCodeAgencyMap.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";   
    frmMaintPayCodeAgencyMap.txtIndex.value ="";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPayCodeAgencyMap');
    return true;
}

function ShowSavCode()
{
    frmMaintPayCodeAgencyMap.lovKey.value = "IntSavCode" + frmMaintPayCodeAgencyMap.screenName.value + frmMaintPayCodeAgencyMap.screenMode.value;
    frmMaintPayCodeAgencyMap.txtDisplayFields.value = "txtSavCode1,txtSavCodeName";
    frmMaintPayCodeAgencyMap.txtSearchFields.value = "Payroll.MaintIntSavings.code";
    frmMaintPayCodeAgencyMap.txtIndex.value ="";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPayCodeAgencyMap');
    return true;
}

function ShowDetEmpNum(i)
{
    if(!(document.all.radioEmp.checked) || (document.all.radioSave.checked))
    {
        frmMaintPayCodeAgencyMap.lovKey.value = "IntSav" + frmMaintPayCodeAgencyMap.screenName.value + frmMaintPayCodeAgencyMap.screenMode.value;
        frmMaintPayCodeAgencyMap.txtDisplayFields.value = "txtEmpNo,txtEmpName";
        frmMaintPayCodeAgencyMap.queryParam.value = "txtSiteID="+frmMaintainInternalSavings.loginLocCode.value+" ";
        frmMaintPayCodeAgencyMap.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";   
        frmMaintPayCodeAgencyMap.txtIndex.value =i;      
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPayCodeAgencyMap');
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
       frmMaintPayCodeAgencyMap.lovKey.value = "IntSavCode" + frmMaintPayCodeAgencyMap.screenName.value + frmMaintPayCodeAgencyMap.screenMode.value;
       frmMaintPayCodeAgencyMap.txtDisplayFields.value = "txtSavCode,txtDescription";
       frmMaintPayCodeAgencyMap.txtSearchFields.value = "Payroll.MaintIntSavings.code";
       frmMaintPayCodeAgencyMap.txtIndex.value =i;      
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPayCodeAgencyMap');
       return true;
   }
   else
   {
       return false;
   }
}

function changed(val)
{
  frmMaintPayCodeAgencyMap.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
  
}
    
function doBaseAddRow()
{
    if(mandatory_Check("frmMaintPayCodeAgencyMap"))
    {
        document.all.buttonFlag.value='';
        frmMaintPayCodeAgencyMap.screenMode.value = "U";  
        document.forms[0].action = "../../../IntSavAddRowAction.do";
        enableAll(); 
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
    for(i=0; i < iTr2 -1; i++)
    {    
        if(document.getElementsByName("checked")[i].checked)
        {
            document.getElementsByName("itemChecked")[i].value = "Y";
            frmMaintPayCodeAgencyMap.detailDataChanged.value = "true";     
            document.all.buttonFlag.value='';
        }    
    }    
    enableAll(); 
    document.forms[0].action = "../../../IntSavDeleteRowAction.do";
    document.forms[0].submit();  
}

function SaveRecord()
{ 
    if(mandatory_Check("frmMaintPayCodeAgencyMap"))
    {
        enableAll(); 
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
                frmMaintPayCodeAgencyMap.detailDataChanged.value = "true";
        }    
        document.all.buttonFlag.value='';
        frmMaintPayCodeAgencyMap.headerFields.value = "false";
        document.all.butSave.disabled="true";        
        if(document.frmMaintainInternalSavings.optVal.value == "2") 
        {
            if (document.all.screenMode.value == "N")
            {
                document.all.screenInt.value = "UG";
                document.all.screenMode.value = "U";    
            }
        }  
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmMaintPayCodeAgencyMap.action = "../../../IntSavSaveAction.do";
        frmMaintPayCodeAgencyMap.submit();
    }
    else
    {
        return false;
    }
}


function GetDetail()
{
    document.all.screenInt.value = 'UG';
    document.all.buttonFlag.value='';
    
    frmMaintPayCodeAgencyMap.screenMode.value='U';
    frmMaintPayCodeAgencyMap.headerDataChanged.value = "false";
    
    if(!mandatory_Check("frmMaintPayCodeAgencyMap"))
        return false;    
    
    if(document.frmMaintPayCodeAgencyMap.optVal.value == "1") 
        frmMaintPayCodeAgencyMap.headerPrimaryKey.value = frmMaintPayCodeAgencyMap.txtSavCode1.value ;  
    
    if(document.frmMaintPayCodeAgencyMap.optVal.value == "2")  
        frmMaintPayCodeAgencyMap.headerPrimaryKey.value = frmMaintPayCodeAgencyMap.txtEmpNo1.value ;  
    else 
        frmMaintPayCodeAgencyMap.headerPrimaryKey.value = "";      
    
    frmMaintPayCodeAgencyMap.action="../../../IntSavGetDetailAction.do"
    frmMaintPayCodeAgencyMap.submit();
}

function SavCodeClick()
{
    document.frmMaintPayCodeAgencyMap.hdnAction.value = "";
    if(document.all.screenInt.value == 'UG')
        document.all.screenInt.value = 'U';
    document.all.buttonFlag.value='';
    document.frmMaintPayCodeAgencyMap.action="../../../IntSavOptionClickAction.do";
    document.frmMaintPayCodeAgencyMap.optVal.value="1";     
    document.frmMaintPayCodeAgencyMap.submit();
}

function EmpNoClick() 
{
    document.frmMaintPayCodeAgencyMap.hdnAction.value = "";
    if(document.all.screenInt.value == 'UG')
        document.all.screenInt.value = 'U';
    document.all.buttonFlag.value='';
    document.frmMaintPayCodeAgencyMap.action="../../../IntSavOptionClickAction.do";
    document.frmMaintPayCodeAgencyMap.optVal.value="2";
    document.frmMaintPayCodeAgencyMap.submit(); 
}
  
function MiscelClick() 
{
    document.frmMaintPayCodeAgencyMap.hdnAction.value = "";
    if(document.all.screenInt.value == 'UG')
        document.all.screenInt.value = 'U';      
    document.all.buttonFlag.value='';
    document.frmMaintPayCodeAgencyMap.action="../../../IntSavOptionClickAction.do";
    document.frmMaintPayCodeAgencyMap.optVal.value="3";        
    document.frmMaintPayCodeAgencyMap.submit(); 
}

function doInsertMode()
{
    document.frmMaintPayCodeAgencyMap.hdnAction.value = "";
    document.all.screenInt.value = 'N';
    document.all.buttonFlag.value='';
    frmMaintPayCodeAgencyMap.headerDataChanged.value = "false";
 
    frmMaintPayCodeAgencyMap.action="../../../IntSavNewMode.do"
    frmMaintPayCodeAgencyMap.submit();
}

function doQueryMode()
{
    document.frmMaintPayCodeAgencyMap.hdnAction.value = "";
    document.all.screenInt.value = 'Q';
    document.all.buttonFlag.value='';
    frmMaintPayCodeAgencyMap.headerDataChanged.value = "false";
    
    frmMaintPayCodeAgencyMap.action="../../../IntSavQueryMode.do"
    frmMaintPayCodeAgencyMap.submit();
}

function chk_Amount(rowval)
{
    var amt = parseInt(document.getElementsByName("txtAmount")[rowval-1].value);
    if(amt>100000)          
    {
        alert(" Monthly Savings Amount Cannot be more than 100000");
        return false;
    }    
    if((amt>10000) && (amt<100000))          
    {
        var Val =confirm("Entered Amount Is Greater Than 10000. Do You Want To Continue?")
        if (!Val)
        return false;
        else                                                   
        return true;                        
    }        
    return true;
}

function lfnLoad()
{
    mode = document.all.screenMode.value;
    //alert("mode------"+mode); 
    if(mode=='')
    {
        doQueryMode();
    }    
    if (document.all.screenInt.value == "")
    {
        document.all.screenInt.value = "Q";
        document.all.screenMode.value = "Q";    
    }    
    mode = document.all.screenInt.value;    
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
    }
    if(mode=='UG')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";
    }
    if(document.frmMaintainInternalSavings.hdnAction.value == "GetEmpNameDtl")
    {
        var iRowVal = document.frmMaintPayCodeAgencyMap.hdnRowVal.value;       
        if (document.frmMaintPayCodeAgencyMap.hdnEmpName.value != "") 
        {
            document.getElementsByName("txtEmpName")[iRowVal-1].value = document.frmMaintPayCodeAgencyMap.hdnEmpName.value; 
            document.frmMaintPayCodeAgencyMap.hdnAction.value = "";
            document.getElementsByName("txtSavCode")[iRowVal-1].focus();      
        }
        else
        {
            alert("Invalid Employee Number"); 
            document.getElementsByName("txtEmpName")[iRowVal-1].value = "";                     
            document.getElementsByName("txtEmpNo")[iRowVal-1].focus();                
        }
    }

    if(document.frmMaintPayCodeAgencyMap.hdnAction.value == "GetEmpName")
    {
        if (document.frmMaintPayCodeAgencyMap.txtEmpName1.value == "")   
        {
            alert("Invalid Employee Number"); 
            document.frmMaintPayCodeAgencyMap.txtEmpNo1.focus(); 
        }
    }  
  
    if(document.frmMaintPayCodeAgencyMap.hdnAction.value == "GetPayCodeName")
    {
        if (document.frmMaintPayCodeAgencyMap.txtSavCodeName.value == "")   
        {
            alert("Invalid Savings Code"); 
            document.frmMaintPayCodeAgencyMap.txtSavCode1.focus(); 
        }
    }    

    if(document.frmMaintPayCodeAgencyMap.hdnAction.value == "GetPayCodeNameDtl")
    {
        var iRowVal = document.frmMaintainInternalSavings.hdnRowVal.value;   
        if (document.frmMaintPayCodeAgencyMap.hdnPayCodeName.value != "") 
        {  
            var iRowVal = document.frmMaintPayCodeAgencyMap.hdnRowVal.value; 
            document.getElementsByName("txtDescription")[iRowVal-1].value = document.frmMaintPayCodeAgencyMap.hdnPayCodeName.value; 
            document.frmMaintPayCodeAgencyMap.hdnAction.value = "";
            document.getElementsByName("txtSavingsNumber")[iRowVal-1].focus();            
        }
        else
        {
            alert("Invalid Savings Code"); 
            document.getElementsByName("txtDescription")[iRowVal-1].value = "";                               
            document.getElementsByName("txtSavCode")[iRowVal-1].focus();                
        }      
    }
    
    if(mode == 'UG' || mode == 'UNG')
    {  menuHandling('U');}
    else
    {  menuHandling(mode);}
    
    document.all.butExecute.disabled="true";    
    document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg"; 
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
    
    if((document.frmMaintPayCodeAgencyMap.optVal.value == '')||(document.frmMaintPayCodeAgencyMap.optVal.value == '1'))
    {
        document.all.radioSave.checked="true";
        if(document.frmMaintPayCodeAgencyMap.optVal.value == '')
        SavCodeClick();
    }
    else if(document.frmMaintPayCodeAgencyMap.optVal.value == '2')
    {
        document.all.radioEmp.checked="true";
        return true;
    }
    else if(document.frmMaintPayCodeAgencyMap.optVal.value == '3')
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
        if (document.getElementsByName("status")[i].value == 'Q')
        {                
            document.getElementsByName("txtSavCode")[i].disabled="";
            document.getElementsByName("txtEmpNo")[i].disabled="";
        }
    }
}

function enableAll()
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

function showCalendar(inputId, butId) 
{
   if(butId.alt)
   {
       iIndex=butId.alt;
   }
   else
   {
       iIndex="-1";
   }
   Calendar.setup({inputField	: inputId,
		   ifFormat	: "%d-%b-%Y",
		   button	: butId,
       position: iIndex
  		  });
   return false;
}

function chk_YearMonth(val)
{      
    var  yearM = document.getElementById("txtValUpto").value;          
    var month =  yearM.substring(4,6);    
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementById("txtValUpto").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("txtValUpto").focus();                     
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
    document.frmMaintPayCodeAgencyMap.hdnAction.value = "";
    frmMaintPayCodeAgencyMap.action="../../../InternalRefresh.do"
    frmMaintPayCodeAgencyMap.submit();
}

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';  
    frmMaintPayCodeAgencyMap.userPageRequested.value = 1*frmMaintPayCodeAgencyMap.pageRequested.value - 1;
    frmMaintPayCodeAgencyMap.action = "../../../IntSavNextDetailAction.do";
    frmMaintPayCodeAgencyMap.submit();
}

function doBaseNextDetail()
{
    document.all.buttonFlag.value='';  
    frmMaintPayCodeAgencyMap.userPageRequested.value = 1*frmMaintPayCodeAgencyMap.pageRequested.value + 1;
    frmMaintPayCodeAgencyMap.action = "../../../IntSavNextDetailAction.do";
    frmMaintPayCodeAgencyMap.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';  
    frmMaintPayCodeAgencyMap.userPageRequested.value = 1*frmMaintPayCodeAgencyMap.newPageRequested.value ;
    frmMaintPayCodeAgencyMap.action = "../../../IntSavNextDetailAction.do";
    frmMaintPayCodeAgencyMap.submit();
}

function lfnGetEmpName(val) 
{
    if (val != "")
    {
        frmMaintPayCodeAgencyMap.hdnAction.value="GetEmpName";
        frmMaintPayCodeAgencyMap.action="../../../IntSavGetEmpName.do"     
        frmMaintPayCodeAgencyMap.submit();
    }
}

function lfnGetEmpNameDtl(val, value) 
{
    if (value != "")
    {
        if(frmMaintPayCodeAgencyMap.screenInt.value="N") 
        {
            frmMaintPayCodeAgencyMap.hdnAction.value="GetEmpNameDtl";
            frmMaintPayCodeAgencyMap.hdnRowVal.value=val;
            frmMaintPayCodeAgencyMap.hdnEmpNo.value=value;     
            frmMaintPayCodeAgencyMap.action="../../../IntSavGetEmpName.do"     
            frmMaintPayCodeAgencyMap.submit();
        }
    }
}

function lfnGetPayCodeName(val) 
{
    if (val != "")
    {
         frmMaintPayCodeAgencyMap.hdnAction.value="GetPayCodeName";
         frmMaintPayCodeAgencyMap.action="../../../IntSavGetEmpName.do"     
         frmMaintPayCodeAgencyMap.submit();
    }
}

function lfnGetPayCodeNameDtl(val, value) 
{
    if (value != "")
    {
        if(frmMaintPayCodeAgencyMap.screenInt.value="N") 
        {
           frmMaintPayCodeAgencyMap.hdnAction.value="GetPayCodeNameDtl";
           frmMaintPayCodeAgencyMap.hdnRowVal.value=val;
           frmMaintPayCodeAgencyMap.hdnPayCode.value=value;     
           frmMaintPayCodeAgencyMap.action="../../../IntSavGetEmpName.do"     
           frmMaintPayCodeAgencyMap.submit();
        }
   }
}
</script>
