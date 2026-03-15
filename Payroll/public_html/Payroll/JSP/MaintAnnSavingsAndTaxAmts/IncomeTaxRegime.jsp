<%@ page import="java.util.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
  <HEAD>
    <html:base/>
      <TITLE><bean:message key="Payroll.title" /></TITLE>
      <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
      <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css"/>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
      <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
      <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
   </head>
<BODY onbeforeunload="confWindowClose()" onunload="handleOnClose()" onload="lfnLoad();history.forward(1);" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0; %>
<% i = 0; j=0; %>

<html:form  action="IncomeTaxRegimeBaseAction" name="frmIncomeTaxRegime" type="FCIPAY.Payroll.WEBTIER.Form.IncomeTaxRegimeForm" scope="session">

<bean:define id="ParentForm" name="frmIncomeTaxRegime" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" />
<html:hidden property="headerDataChanged" />
<html:hidden property="headerFields" value="false" />


<table>
  <TR height=30>
    <TD  colSpan=12 class=mainHeader height=10><bean:message key="Payroll.IncomeTaxRegime.head" /></TD>
  </TR>
</TABLE>
<html:errors/>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
    <TR>
      <TD>	
        <!-- Body table Starts -->
        <TABLE cellSpacing=0 cellPadding=0 >
        <!--Account  Header Row Starts -->
          <TR>
            <TD class=subHeader colspan=6><bean:message key="Payroll.IncomeTaxRegime.empDetail" /></TD>
          </TR>
          <TR>
            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></img></TD>
          </TR>
       
          <tr>
          <td class="labelText"  width="20%" ><bean:message key="Payroll.IncomeTaxRegime.empNo" /></td>
          <td width="10%"><html:text  property="txtEmpId" altKey="Payroll.IncomeTaxRegime.empNo" maxlength="10" size="20" styleClass="required"/>&nbsp;
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();"/>&nbsp;
          </td>

          <td><html:text  property="txtEmpName" altKey="Payroll.IncomeTaxRegime.empName" maxlength="50" size="50" styleClass="locked" readonly="true" /></td>

          <td class="labelText"  width="10%" ><bean:message key="Payroll.IncomeTaxRegime.cpfCode" /></td>
          <td><html:text  property="txtCpfCode" altKey="Payroll.IncomeTaxRegime.cpfCode" maxlength="10" size="23" readonly="true" styleClass="required"/></td>

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
    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"/></td>
    <td bgcolor="#4682B4" nowrap class=actTabText><bean:message key="Payroll.IncomeTaxRegime.detail" /><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"/></td>
    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"/></td>
    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"/></td>
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
      <TD class=tableHeader width="1%"><html:checkbox property="selectAll" disabled="true" /></TD>
      <td class=tableHeader><bean:message key="Payroll.IncomeTaxRegime.srno" /></td>
      <td class=tableHeader><bean:message key="Payroll.IncomeTaxRegime.finYear"  /></td>
      <td class=tableHeader><bean:message key="Payroll.IncomeTaxRegime.itRegimeOpted" /></td>                                               
      <td class=tableHeader><bean:message key="Payroll.IncomeTaxRegime.finalF" /></td>
      <td class=tableHeader><bean:message key="Payroll.IncomeTaxRegime.freeze" /></td>
    </TR>

<logic:iterate id="intInfo" name="frmIncomeTaxRegime" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.IncomeTaxRegimeBean">
<% ++i; %>
<logic:notEqual name="intInfo" property="status" value="D" >                             
  
<tr>   
   <!--<td ><html:checkbox property="checked" onclick="" value="false" name="frmIncomeTaxRegime"/></td>-->
   <td></td>
   <% ++j; %>
   <td align=center><html:text property="txtSrlNo" name="intInfo" size="2"  value="<%=String.valueOf(j)%>"  styleClass="locked" alt="<%=String.valueOf(i)%>"/></td>         
   <td align=center><html:text property="txtFinYear" name="intInfo" styleClass="locked" size="15" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
   <td align=center> 
   <logic:equal name="intInfo" property="txtFreeze" value="N" >
        <logic:equal name="intInfo" property="txtFinalFlag" value="N" >
            <html:select property="txtITRegime" name="intInfo" styleClass="required" style="width:35%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
                <html:option value="">-----Please Select-----</html:option>      
                <html:option value="O">Old</html:option>
                <html:option value="N">New</html:option>
            </html:select>
        </logic:equal>
        <logic:equal name="intInfo" property="txtFinalFlag" value="Y" >
        <html:select property="txtITRegime" name="intInfo" styleClass="locked" style="width:35%" readonly="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
            <html:option value="N">New</html:option>
            <html:option value="O">Old</html:option>
        </html:select>
        </logic:equal>
   </logic:equal>
   <logic:equal name="intInfo" property="txtFreeze" value="Y" >
        <logic:equal name="intInfo" property="txtFinalFlag" value="N" >
            <html:select property="txtITRegime" name="intInfo" styleClass="locked" style="width:35%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
                <html:option value="O">Old</html:option>
            </html:select>
        </logic:equal>
        <logic:equal name="intInfo" property="txtFinalFlag" value="Y" >
        <html:select property="txtITRegime" name="intInfo" styleClass="locked" style="width:35%" readonly="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
            <html:option value="N">New</html:option>
        </html:select>
        </logic:equal>
   </logic:equal>
   <logic:equal name="intInfo" property="txtFreeze" value="F" >
        <logic:equal name="intInfo" property="txtFinalFlag" value="N" >
            <html:select property="txtITRegime" name="intInfo" styleClass="locked" style="width:35%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
                <html:option value="O">Old</html:option>
            </html:select>
        </logic:equal>
        <logic:equal name="intInfo" property="txtFinalFlag" value="Y" >
        <html:select property="txtITRegime" name="intInfo" styleClass="locked" style="width:35%" readonly="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" >
            <html:option value="N">New</html:option>
        </html:select>
        </logic:equal>
   </logic:equal>
   </td>
   <td align=center><html:text property="txtFinalFlag" name="intInfo" size="10" styleClass="locked" alt="<%=String.valueOf(i)%>" readonly="true"/></td>
   <td align=center><html:text property="txtFreeze" name="intInfo" size="10" styleClass="locked" alt="<%=String.valueOf(i)%>" readonly="true"/></td>         

  <html:hidden property="itemChecked" name="intInfo" />
  <html:hidden property="status" name="intInfo" />
  <html:hidden property="detailId" name="intInfo" value="Default" />
  <html:hidden property="txtFinalFlag" name="intInfo" />
</tr>
</logic:notEqual>

<logic:equal name="intInfo" property="status" value="D" >
    <td ><html:hidden property="checked" name="frmIncomeTaxRegime" value="notchecked" /></td>
    <td ><html:hidden property="txtSrlNo" name="intInfo" /></td>
    <td ><html:hidden property="txtFinYear" name="intInfo" /></td>
    <td ><html:hidden property="txtITRegime" name="intInfo" /></td>
    <td ><html:hidden property="txtFinalFlag" name="intInfo" /></td>
    <td ><html:hidden property="txtFreeze" name="intInfo" /></td>
    <html:hidden property="itemChecked" name="intInfo" />
    <html:hidden property="detailId" name="intInfo" value="Default" />
    <html:hidden property="status" name="intInfo" />
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
            <jsp:include  page = "../INCLUDES/GenDetailIncomeTaxMenu.jsp" flush="true" />
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
</TABLE>
</td>
</tr>
<!-- Tab Table Ends -->
<!-- Bottom Blue Bar -->

 <!-- Detail Information Row starts -->
 <TR height="50">
    <TD colspan=11>
   <TABLE cellspacing="0" cellPadding="0" >
   <TR>
   <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />

   <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
    <% if(smode.equals(new String("U"))) {%> 
    Update Mode
   <%} else if(smode.equals(new String("N"))) {  %>
    New Mode
   <%} else if(smode.equals(new String("Q"))) {  %>
    Query Mode
   <%}  %>
   </td> 

   <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></img></td>
</table>
</td>
</tr>
</TABLE> 
<!-- Container Table Ending Columns Starts-->
</TD>    
</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden property="headerPrimaryKey" name="frmIncomeTaxRegime"  />
<html:hidden property="screenMode" name="frmIncomeTaxRegime"  />
<html:hidden name="frmIncomeTaxRegime"  property="screenName" value="IncomeTaxRegimeScreen" />
<html:hidden name="frmIncomeTaxRegime"  property="forwardedPage" />
<!--<html:hidden name="frmIncomeTaxRegime"  property="headerFields" />-->
<!--<html:hidden name="frmIncomeTaxRegime"  property="totalDetailRecord" />-->
<html:hidden property="screenInt" name="frmIncomeTaxRegime"  />
<html:hidden property="lovKey" name="frmIncomeTaxRegime"  />
<html:hidden property="txtFields" name="frmIncomeTaxRegime"  />   
<html:hidden property="txtSearchFields" name="frmIncomeTaxRegime"  />
<html:hidden property="txtDisplayFields" name="frmIncomeTaxRegime"  />
<html:hidden property="txtIndex" name="frmIncomeTaxRegime"  />
<html:hidden property="txtInputField" name="frmIncomeTaxRegime"  />
<html:hidden property="buttonFlag" name="frmIncomeTaxRegime"  />
<html:hidden property="userPageRequested" name="frmIncomeTaxRegime" />
<html:hidden property="pageRequested" name="frmIncomeTaxRegime" />
<html:hidden property="loginLocCode" name="frmIncomeTaxRegime" />
<html:hidden property="pageRequested" name="frmIncomeTaxRegime" />
<html:hidden property="txtSiteId" name="frmIncomeTaxRegime" />
<html:hidden property="txtSiteName" name="frmIncomeTaxRegime" />

<input type="hidden" name="queryParam" />
<input type="hidden" name="multipleFlag" />
<input type="hidden" id="submitParam" name="submitParam" /> 

</html:form>
</BODY>
</html:html>        

<script language="javascript">

function lfnLoad()
{
    mode = document.all.screenMode.value;
    frmIncomeTaxRegime.butGetDetail.disabled="true";
    //menuHandling(mode); 
    if(mode=='')
    {
        doQueryMode();
    }
    if(mode=="U"){
        document.all.butExecute.disabled="true";
        document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
        frmIncomeTaxRegime.butGetDetail.disabled="";
    }
    if(mode=="Q"){
        document.all.txtCpfCode.value="";
    }
    if (document.all.screenInt.value == "")
    {
        document.all.screenInt.value = "Q";
        document.all.screenMode.value = "Q";    
    }    
//    screenIntMode = document.all.screenInt.value;    
//    if(screenIntMode=='')
//    {
//        document.all.butGetDetail.disabled="";   
//    }
//    if(screenIntMode=='Q')
//    {
//        document.all.txtCpfCode.value="";
//    }
//    if(screenIntMode=='U')
//    {       
//        document.all.butGetDetail.disabled="";
//        var oTable = document.getElementById("Detail");
//        if(oTable == null)
//        {
//            return;
//        }
//    }
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
  
}

function ShowEmpNum(){
   frmIncomeTaxRegime.lovKey.value = "IncomeTaxRegimeEmpList" + frmIncomeTaxRegime.screenName.value + frmIncomeTaxRegime.screenMode.value;
   frmIncomeTaxRegime.queryParam.value = "txtSiteID="+frmIncomeTaxRegime.loginLocCode.value+",hdnEmpLbrFlag="+frmIncomeTaxRegime.hdnEmpLbrFlag.value;
   frmIncomeTaxRegime.txtDisplayFields.value = "txtEmpId,txtEmpName,txtCpfCode";
   frmIncomeTaxRegime.txtSearchFields.value = "Payroll.IncomeTaxRegime.empNo,Payroll.IncomeTaxRegime.empName,Payroll.IncomeTaxRegime.cpfCode";
   frmIncomeTaxRegime.txtIndex.value ="";      
   frmIncomeTaxRegime.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmIncomeTaxRegime');
   return true;
}

function getHeaderRecord()
 {
   if(checkHeaderMandatory())
   {
    document.all.buttonFlag.value=''; 
    frmIncomeTaxRegime.action="../../../IncomeTaxRegimeGetHeaderAction.do";
    frmIncomeTaxRegime.submit();
   }
 }
 
function checkHeaderMandatory()
 {
    if(document.all.txtEmpId.value=="")
    {
      alert("Please Select/Enter Employee");
      return false;
    }
    return true;
}

function GetDetail()
{
    frmIncomeTaxRegime.screenMode.value='U';
    frmIncomeTaxRegime.headerDataChanged.value = "false";
    frmIncomeTaxRegime.headerPrimaryKey.value=frmIncomeTaxRegime.headerPrimaryKey.value;
    frmIncomeTaxRegime.headerPrimaryKey.disabled="";
    frmIncomeTaxRegime.action="../../../IncomeTaxRegimeGetDetailAction.do"
    frmIncomeTaxRegime.submit();
}

function SaveRecord()
{ 
    if(mandatory_Check("frmIncomeTaxRegime"))
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
                frmIncomeTaxRegime.detailDataChanged.value = "true";
        }
        if(document.getElementsByName("txtFinalFlag")[iTr2 -1].value == 'Y'){
            alert("RECORD NOT UPDATED. PLEASE CHECK THE IT REGIME OPTED AND FIN YEAR FLAG");
        }
        document.all.buttonFlag.value='';
        frmIncomeTaxRegime.headerFields.value = "false";
        document.all.butSave.disabled="true";        
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmIncomeTaxRegime.action = "../../../IncomeTaxRegimeSaveAction.do";
        frmIncomeTaxRegime.submit();
    }
    else
    {
        return false;
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
        //document.getElementsByName("txtEmpNo")[i].disabled="";
    }
}

function doQueryMode()
{
    //document.frmIncomeTaxRegime.hdnAction.value = "";
    document.all.screenInt.value = 'Q';
    document.all.buttonFlag.value='';
    frmIncomeTaxRegime.headerDataChanged.value = "false";
    
    frmIncomeTaxRegime.action="../../../IncomeTaxRegimeQueryMode.do"
    frmIncomeTaxRegime.submit();
}

function doRefresh()
{
    //document.frmIncomeTaxRegime.hdnAction.value = "";
    frmIncomeTaxRegime.action="../../../IncomeTaxRegimeRefresh.do"
    frmIncomeTaxRegime.submit();
}

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';  
    frmIncomeTaxRegime.userPageRequested.value = 1*frmIncomeTaxRegime.pageRequested.value - 1;
    frmIncomeTaxRegime.action = "../../../IncomeTaxRegimeNextDetailAction.do";
    frmIncomeTaxRegime.submit();
}

function doBaseNextDetail()
{
    document.all.buttonFlag.value='';  
    frmIncomeTaxRegime.userPageRequested.value = 1*frmIncomeTaxRegime.pageRequested.value + 1;
    frmIncomeTaxRegime.action = "../../../IncomeTaxRegimeNextDetailAction.do";
    frmIncomeTaxRegime.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';  
    frmIncomeTaxRegime.userPageRequested.value = 1*frmIncomeTaxRegime.newPageRequested.value ;
    frmIncomeTaxRegime.action = "../../../IncomeTaxRegimeNextDetailAction.do";
    frmIncomeTaxRegime.submit();
}

function changed(val)
{
  frmIncomeTaxRegime.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
      document.getElementsByName("status")[val-1].value = 'U';
}



//function doInsertMode()
//{
//    document.frmIncomeTaxRegime.hdnAction.value = "";
//    document.all.screenInt.value = 'N';
//    document.all.buttonFlag.value='';
//    frmIncomeTaxRegime.headerDataChanged.value = "false";
// 
//    frmIncomeTaxRegime.action="../../../IntSavNewMode.do"
//    frmIncomeTaxRegime.submit();
//}


//function enable()
//{
//    var oTable = document.getElementById("Detail");
//    if(oTable == null)
//    {
//        return;
//    }
//    var iTr2 = oTable.rows.length;
//    var i = 0;    
//    for(i=0; i < iTr2 -1; i++)
//    {
//        if (document.getElementsByName("status")[i].value == 'Q')
//        {                
//            document.getElementsByName("txtSavCode")[i].disabled="";
//            document.getElementsByName("txtEmpNo")[i].disabled="";
//        }
//    }
//}



//function showCalendar(inputId, butId) 
//{
//   if(butId.alt)
//   {
//       iIndex=butId.alt;
//   }
//   else
//   {
//       iIndex="-1";
//   }
//   Calendar.setup({inputField	: inputId,
//		   ifFormat	: "%d-%b-%Y",
//		   button	: butId,
//       position: iIndex
//  		  });
//   return false;
//}

//function chk_YearMonth(val)
//{      
//    var  yearM = document.getElementsByName("txtValUpto")[val-1].value;          
//    var month =  parseInt(yearM.substring(4,6),10);
//    if (num_Check(yearM,1))
//    {                                     
//        if (yearM.length != 6)
//        {        
//            alert(" Year Month should be a Six digit Number");
//            document.getElementsByName("txtValUpto")[val-1].focus();                     
//            event.srcElement.select();
//            event.srcElement.focus();
//            event.returnValue=false;                        
//            return false;            
//        }        
//        else if(month < 1 || month > 12)
//        {
//            alert("  Month should be Within 1 to 12");
//            document.getElementsByName("txtValUpto")[val-1].focus();                     
//            event.srcElement.select();
//            event.srcElement.focus();
//            event.returnValue=false;                        
//            return false;
//        }
//        else
//        {
//            return true;
//        }
//    }
//    else
//    {
//        event.srcElement.select();
//        event.srcElement.focus();
//        event.returnValue=false;     
//        return false;
//    }
//}

</script>