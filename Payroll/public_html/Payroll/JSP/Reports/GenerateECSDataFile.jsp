
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
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
   

</head>

<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="ECSDataFileBaseAction" name="ECSDataFileForm" type="FCIPAY.Payroll.WEBTIER.Form.ECSDataFileForm">
<bean:define id="ParentForm" name="ECSDataFileForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>

<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />


<table>
<TR height=30>
  <TD  colSpan=11 class=mainHeader height=10>ECS/SBI DATA FILE REPORT</TD>
</TR>
<tr height="10"><td class=userText colspan="11"></td></tr>
</TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>

    <TR>
          <TD  colSpan=5  height=10><bean:message key="Payroll.ECSDataFile.Message" /></td>
          </tr>
	
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--General Information Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>Generate ECS/SBI Data File</TD>
        </TR>
       <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR> 
         <tr height="15" >
            <td colspan="6"></td>
            </tr>
        <TR>
                
                     <TD class=labelText width="40%" ><bean:message key="pay.ECSDataFile.txtYYMM" /></td>
                     <td align="left"><html:text  property="txtYYMM" altKey="pay.ECSDataFile.txtYYMM" maxlength="10" size="18" styleClass="required"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="butYYMM" name="butYYMM" onclick="return ShowYYMM();" >&nbsp;&nbsp;</td>
          </tr> 
          
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
              <td bgcolor="#4682B4" nowrap class=actTabText>ECS User Inputs<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0>
                          <TBODY>
                        
                         <TR>                            
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtECSTranCode" /></td>
                              <td ><html:text  property="txtECSTranCode" styleClass = "optional" altKey="pay.ECSDataFile.txtECSTranCode" maxlength="10" size="23" onchange="" readonly="false"  /></td>
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtUserNumber" /></td>
                              <td ><html:text  property="txtUserNumber" altKey="pay.ECSDataFile.txtUserNumber" maxlength="10" size="23" styleClass="optional" onchange="" readonly="false"   /></td>
                          </tr> 
                      
	                       <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtUserName" /></td>
                              <td ><html:text  property="txtUserName" styleClass = "optional" altKey="pay.ECSDataFile.txtUserName" maxlength="10" size="23" onchange=""  readonly="false" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtECSTapeInputNo" /></td>
                              <td ><html:text  property="txtECSTapeInputNo" styleClass = "optional" altKey="pay.ECSDataFile.txtECSTapeInputNo" maxlength="10" size="23" readonly="false"   /></td>
                              
                          </tr> 
                            <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtSponBkBrSortCode" /></td>
                              <td ><html:text  property="txtSponBkBrSortCode" altKey="pay.ECSDataFile.txtSponBkBrSortCode" maxlength="10" size="23" styleClass="optional" onchange="" readonly="false"  /></td>
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtUserBankAccNo" /></td> 
                              <td ><html:text  property="txtUserBankAccNo" altKey="pay.ECSDataFile.txtUserBankAccNo" maxlength="10" size="23" styleClass="optional" onchange=""  readonly="false" /></td>
                              
                          </tr> 
                       
                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtLedgerFolioNo" /></td>
                              <td ><html:text  property="txtLedgerFolioNo" altKey="pay.ECSDataFile.txtLedgerFolioNo" maxlength="10" size="23" styleClass="optional" onchange=""  /></td>
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtUserDefLimit" /></td>
                              <td ><html:text  property="txtUserDefLimit" altKey="pay.ECSDataFile.txtUserDefLimit" maxlength="10" size="23" styleClass="optional" onchange=""  /></td>                              
                          </tr> 

                                  
                          <TR>                            
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtSettlementDate" /></td>
                              <td ><html:text  property="txtSettlementDate" styleClass = "optional" altKey="pay.ECSDataFile.txtSettlementDate" maxlength="15" size="23" readonly = "true"  /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="butTxtSettlementDate" onclick="showCalendar('txtSettlementDate',this)" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtCreditTranCode" /></td>
                              <td ><html:text  property="txtCreditTranCode" altKey="pay.ECSDataFile.txtCreditTranCode" maxlength="10" size="23" styleClass="optional" onchange=""  /></td>                                                            
                          </tr> 
                      
                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.ECSDataFile.txtCreditDestAccType" /></td>
                              <td ><html:text  property="txtCreditDestAccType" altKey="pay.ECSDataFile.txtCreditDestAccType" maxlength="10" size="23" styleClass="optional"/></td>
                      
                          </tr> 
                          <tr height = 20><td></td></tr>
                          
                         </TBODY>
                          </TABLE>
                        </TD>
                        </TR> 
  </TBODY>
		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
              

</TABLE>




        </td>
	</tr>

                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->

      <TR>
               <td align=center bgcolor=#4682b4 width="47%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE ECS DATA FILE' onclick="GenEcsDataFile()" property="btnInsert" styleClass="bottomBarText" /></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE SBI DATA FILE' onclick="GenSBIDataFile()" property="btnInsert" styleClass="bottomBarText" /></td>               
               <td width="35%" bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>


<% ReportReader oReportReader=new ReportReader(); %> 
<% ParamUtil oParamUtil=new ParamUtil(); %> 
<script language="javascript">

function doGetReport()
{
var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","ECSDataFileScreen","ECSDataFileReportkey").trim()%>",'',win_option);
}
</script>

    
</TR>
</TBODY>
</TABLE>

</div>


<!-- Container Table Ends -->
<html:hidden name="ECSDataFileForm"  property="screenName" value="ECSDataFileScreen" />
<html:hidden name="ECSDataFileForm"  property="forwardedPage" />
<html:hidden property="txtYYMM" name="ECSDataFileForm" />
<html:hidden property="hdnDataLoad" name="ECSDataFileForm" />
<html:hidden property="hdnMessage" name="ECSDataFileForm" />
<html:hidden property="hdnOption" name="ECSDataFileForm" />
<html:hidden property="screenMode" name="ECSDataFileForm" />
<html:hidden property="positionRequested" name="ECSDataFileForm" />
<html:hidden property="userPositionRequested" name="ECSDataFileForm" />


<html:hidden property="lovKey" name="ECSDataFileForm"  />
<html:hidden property="txtFields" name="ECSDataFileForm"  />   
<html:hidden property="txtSearchFields" name="ECSDataFileForm"  />
<html:hidden property="txtDisplayFields" name="ECSDataFileForm"  />
<html:hidden property="txtIndex" name="ECSDataFileForm"  />
<html:hidden property="buttonFlag" name="ECSDataFileForm"  />
<html:hidden name="ECSDataFileForm"  property="hdnAction" />    


</html:form>
</body>
</html:html>
                                 
<script language="javascript">



function lfnLoad()
{  
  mode=document.all.screenMode.value;
  disableMenu();
  if(mode=='Q'){
  }
  else
  {
      if(mode != 'U')
    {
      doQueryMode();
      ECSDataFileForm.hdnAction.value='';    
    }
  }

  if (ECSDataFileForm.screenMode.value == 'U') 
  {
    if (ECSDataFileForm.hdnOption.value=='ECSData') 
      {      
         ECSDataFileForm.headerDataChanged.value = "true";  
         ECSDataFileForm.action = "../../../EcsDataSaveAction.do";  
         ECSDataFileForm.submit();
      }     
  }
  

  if (ECSDataFileForm.hdnAction.value=='S') 
  {
      ECSDataFileForm.hdnAction.value='SUB';
      if (ECSDataFileForm.hdnOption.value=='ECSData') 
      {      
        GenEcsDataFile(); 
      }
      else
      {
        GenSBIDataFile();
      }
  }
  
  hedMenuHandling('Q');
  hedMenuHandling('N');
}


function showCalendar(inputId, butId) {  
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


function ShowYYMM()
{
   ECSDataFileForm.lovKey.value = "ECSDataFileYear" + ECSDataFileForm.screenName.value+"Q";
   ECSDataFileForm.txtDisplayFields.value = "txtYYMM";
   ECSDataFileForm.txtSearchFields.value = "pay.ECSDataFile.txtYYMM";
   ECSDataFileForm.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'ECSDataFileForm');
   return true;
}

function doRefresh()
{
  ECSDataFileForm.action="../../../ECSDataFileRefresh.do"
  ECSDataFileForm.submit();
}


function doQueryMode()
{
  ECSDataFileForm.hdnAction.value='Q';
  document.all.screenMode.value='Q'; 
//ECSDataFileForm.action="../../../GenECSQuery.do"
  ECSDataFileForm.action="../../../EcsHeaderAction.do"
  ECSDataFileForm.submit();
}

function getHeaderRecord()
{
  ECSDataFileForm.action="../../../EcsHeaderAction.do"
  ECSDataFileForm.submit();
}


function GenEcsDataFile()
{            
   if(mandatory_Check("ECSDataFileForm"))
  {
      ECSDataFileForm.hdnOption.value = "ECSData";  
    
      if (ECSDataFileForm.hdnAction.value != 'SUB') 
      {
        ECSDataFileForm.hdnAction.value = 'S'; 
        ac="../../../GenECSData.do";
        document.forms[0].action=ac;
        document.forms[0].submit();
      }
      else
      {
        ECSDataFileForm.hdnAction.value='SUB';       
        ac="../../../GenECSData.do";
        document.forms[0].action=ac;
        document.forms[0].submit();
      }       
  }
}


function GenSBIDataFile()
{      
 if(mandatory_Check("ECSDataFileForm"))
  {
      ECSDataFileForm.hdnOption.value = "SBIData";  
    
      if (ECSDataFileForm.hdnAction.value != 'SUB') 
      {
        ECSDataFileForm.hdnAction.value = 'S'; 
        ac="../../../GenECSData.do";
        document.forms[0].action=ac;
        document.forms[0].submit();
      }
      else
      {
        ECSDataFileForm.hdnAction.value='SUB';       
        ac="../../../GenECSData.do";
        document.forms[0].action=ac;
        document.forms[0].submit();
      }   
    }
}


function EcsOptionClick()
{            
      ECSDataFileForm.hdnOption.value = "ECSData";  
}
    

function SBIOptionClick()
{            
      ECSDataFileForm.hdnOption.value = "SBIData";  
}

</script>