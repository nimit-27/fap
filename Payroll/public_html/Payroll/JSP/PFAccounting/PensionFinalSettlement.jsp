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
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>      
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css"></link>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>      
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form action="PensionFinalSettBaseAction" name="frmPensionFinalSett" type="FCIPAY.Payroll.WEBTIER.Form.PensionFinalSettForm" scope="session">
<bean:define id="ParentForm" name="frmPensionFinalSett" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>PENSION FINAL SETTLEMENT PAYMENT INFORMATION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td>
  </tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
            <!--General Information Row Starts -->
            <TR>
              <TD class=subHeader colspan=6> Detail Employee Information</TD>
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></img></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="6"></td>
            </tr>           
            
            <tr></tr>
            
                <TR>
                  <TD class=labelText><bean:message key="Payroll.PensionFinal.Empno" /></TD>
                  
                  <td align="left" colspan="5">
                  <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="N">                   
                  <html:text  property="txtEmpNo" altKey="Payroll.PensionFinal.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();"></img>
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="N">
                  <html:text  property="txtEmpNo" altKey="Payroll.PensionFinal.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual>                                                                                      
                  <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" onclick="return ShowEmpNum();"></img>
                  </logic:equal>
                  <html:text  property="txtEmpName" altKey="Payroll.PensionFinal.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td> 
              </TR> 
                                
              <TR>              
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="7" size="23" styleClass="locked"  style="text-align:Left"/>
                  </td>
                  
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCateg" styleClass="locked" readonly="true" size="23"/>
                  </td>                                                                        
              </tr>
                      
              <tr> 
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                    
                  </td> 
                  
                  <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>                  
                  </td>                                                          
              </tr>
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td><html:text  property="txtPresentPOP" altKey="pay.EmpInfo.PresentPOP" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   />                  
                  </td>                                                            
                  
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.StaffCode" /> </td>            
                  <td>
                  <html:text  property="txtStaffCode" altKey="Payroll.EmpInfo.StaffCode" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>    
      
              <tr>
                  <td width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text  property="txtEmpStatus" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td> 
                  <td width="23%" class=labelText><bean:message key="Payroll.PensionFinal.PensionId"/></td>                            
                  <td ><html:text  property="txtPensionId" altKey="Payroll.PensionFinal.PensionId" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td> 
              </tr>
              <tr>
                  <td width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.DateOfBirth" /> </td>                            
                  <td ><html:text  property="txtDOB" altKey="Payroll.PensionFinal.DateOfBirth" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td> 
                  
                <td width="23%" class=labelText  ><bean:message key="Payroll.PensionFinal.RetirementDate" /> </td>                            
                  <td ><html:text  property="txtRetirementDt" altKey="Payroll.PensionFinal.RetirementDate" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                </td>     
              </tr>
              <tr>
                <logic:notEqual property= "screenMode" name= "frmPensionFinalSett" value="N">
                    <td width="23%" class=labelText><bean:message key="Payroll.PensionFinal.SystemSanNum"/></td>                            
                    <td ><html:text property="txtSysSantionNum" altKey="Payroll.PensionFinal.SystemSanNum" maxlength="15" size="23" styleClass="locked" readonly="true"/></td> 
        	</logic:notEqual> 
                
                <td width="23%" class=labelText></td>                            
                <td></td>         	  
              </tr>
            </table>     
      <tr height="15" >
      <td colspan="6"></td>
    </tr>                                 
</table>
<table cellspacing=0 cellpadding=0 border=0>
   <!-- Detail Information Row starts -->
<TR height="200">
    <TD colspan=6>
    <!-- Annuity Provider Selection Info Table Starts -->
    <DIV id="AnnuProSel">
        <jsp:include page="PensionFinalSettAnnuProv.jsp" flush="true" />
    </div>
    <!-- Annuity Details Info Table Starts -->
    <div id="AnnuDel">
        <jsp:include page="PensionFinalSettAnnuDet.jsp" flush="true" />
    </div>
    </td>
</tr>
<!-- Tab Table Ends -->
<!-- Bottom Blue Bar -->
 <TR>
    <td bgcolor=#4682b4>
    <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="N">  
      <div align="center"><html:button property="butSanc" value="Generate Sanction Order" onclick="SaveRecord()"/></div>
    </logic:equal>
  
    <logic:equal property= "screenMode" name= "frmPensionFinalSett" value="U">
    
    <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="N">
        <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
            <div id="saveAnnu" align="center"><html:button property="butSaveAnnuity" value="Save Annuity Details" onclick="doSaveAnnuity()" />&nbsp;&nbsp;&nbsp;&nbsp;</div>
        </logic:equal>
        <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
            <div id="saveAnnu" align="center"><html:button property="butSaveAnnuity" value="Save Annuity Details" onclick="doSaveAnnuity()" disabled="true"/>&nbsp;&nbsp;&nbsp;&nbsp;</div>
        </logic:notEqual>
    </logic:equal>
    <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="F">
        <div id="saveAnnu" align="center"><html:button property="butSaveAnnuity" value="Save Annuity Details" onclick="doSaveAnnuity()" disabled="true"/>&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </logic:equal>
   
    <logic:equal property="cancelStatus" name="frmPensionFinalSett" value="">
          <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="N">
            <div id="cancelSanc" align="center"><html:button property="butCancelSanc" value="Cancel Sanction Order" onclick="doCancelSanc()" />&nbsp;&nbsp;&nbsp;&nbsp;</div>
          </logic:equal>
          <logic:equal property= "finAnnuityFlag" name= "frmPensionFinalSett" value="F">
            <div id="cancelSanc" align="center"><html:button property="butCancelSanc" value="Cancel Sanction Order" onclick="doCancelSanc()" disabled="true"/>&nbsp;&nbsp;&nbsp;&nbsp;</div>
          </logic:equal>
    </logic:equal>
    <logic:notEqual property="cancelStatus" name="frmPensionFinalSett" value="">
        <div id="cancelSanc" align="center"><html:button property="butCancelSanc" value="Cancel Sanction Order" onclick="doCancelSanc()" disabled="true" />&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </logic:notEqual>
     
    </logic:equal>

    <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></img></td>
  </TR>
  </TABLE> 
<!-- Container Table Ending Columns Starts-->
  </TD>
</TR>
</TBODY>
</TABLE>
</div>

<!-- Container Table Ends -->
<html:hidden name="frmPensionFinalSett"  property="screenName" value="PensionFinalSettlementScreen" />
<html:hidden name="frmPensionFinalSett"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmPensionFinalSett" />
<html:hidden property="loginLocCode" name="frmPensionFinalSett" />
<html:hidden property="positionRequested" name="frmPensionFinalSett" />
<html:hidden property="userPositionRequested" name="frmPensionFinalSett" />
<html:hidden property="buttonFlag" name="frmPensionFinalSett" />
<html:hidden property="lovKey" name="frmPensionFinalSett" />
<html:hidden property="txtFields" name="frmPensionFinalSett" />   
<html:hidden property="txtSearchFields" name="frmPensionFinalSett" />
<html:hidden property="txtDisplayFields" name="frmPensionFinalSett" />
<html:hidden property="txtIndex" name="frmPensionFinalSett" />
<html:hidden property="txtInputField" name="frmPensionFinalSett" />
<html:hidden property="hdnAction" name="frmPensionFinalSett" />
<html:hidden property="hdnSancType" name="frmPensionFinalSett" value="F" />
<html:hidden property="hdnBoardFlag" name="frmPensionFinalSett" />
<html:hidden property="txtSysSantionNum" name="frmPensionFinalSett"  />
<html:hidden property="headerPrimaryKey" name="frmPensionFinalSett"  />
<html:hidden property="saveAnnuityFlag" name="frmPensionFinalSett" />
<html:hidden property="saveAnnu" name="frmPensionFinalSett" />
<html:hidden property="cancelSanc" name="frmPensionFinalSett" />
<input type="hidden" name="queryParam" />
<input type="hidden" id="submitParam" name="submitParam" /> 

<script language="javascript">

/*function doGetReport()
{  
	var winurl="CPF_final.rdf&sanc_num="+frmPensionFinalSett.headerPrimaryKey.value;
	document.getElementById('reportButton').value="Please wait. File is being downloaded..";
	document.getElementById('reportButton').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.frmPensionFinalSett.action="../../../ReportLinkerAction.do";
	document.frmPensionFinalSett.submit();
}*/

function ShowEmpNum()
{
    frmPensionFinalSett.lovKey.value = "PensionFinalSett" + frmPensionFinalSett.screenName.value + frmPensionFinalSett.screenMode.value;    
    if(document.all.screenMode.value=='N')
    {
      frmPensionFinalSett.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCateg,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtStaffCode,txtDOB,txtPensionId,txtRetirementDt";
    }
    else
    {
      frmPensionFinalSett.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode";
    }
    frmPensionFinalSett.queryParam.value = "txtSiteID="+frmPensionFinalSett.loginLocCode.value+",hdnEmpLbrFlag="+frmPensionFinalSett.hdnEmpLbrFlag.value+",hdnSancType="+frmPensionFinalSett.hdnSancType.value;
    frmPensionFinalSett.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
    frmPensionFinalSett.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPensionFinalSett');
    return true;
}

function lfnLoad()
{
    mode = document.all.screenMode.value;    
    if(mode == '')
    {
        doQueryMode();
    }    
    if(mode=='U')
    {        
        document.all.txtCateg.disabled = "true";
        //document.all.txtDsgn.disabled = "true";      
        //document.all.headerPrimaryKey.disabled = "true";          
        var arg=document.all.forwardedPage.value;
        showDiv(arg);    
    }
    if(mode=='Q'){
        var arg=document.all.forwardedPage.value;
        showDiv(arg);    
    }
    if(mode=='N'){
        showDiv('AnnuProSel');
    }
    document.all.butSave.disabled="true";    
    document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    hedMenuHandling(mode);
}

function doGetTab(arg)
{  
    mode = document.all.screenMode.value;      
    if(mode == 'N' || mode == 'U')
    { 
      if(mode=='N')
      {
      
      }
      //document.all.hdnPLIFlag.value=frmPensionFinalSett.hdnBoardFlag.value=='N'? 'Y' : 'N';
      document.all.forwardedPage.value=arg;
      showDiv(arg);           
      
    }
    else
    {
        document.all.forwardedPage.value=arg;
        showDiv(arg);
    }
}

function showDiv(flag)
{
  if(flag=='AnnuDel')
  { 
    document.getElementById('AnnuDel').style.display='';
    document.getElementById('AnnuProSel').style.display='none';
    document.getElementById('saveAnnu').style.display='';
    document.getElementById('cancelSanc').style.display='none';
  }else{
    document.getElementById('AnnuProSel').style.display='';
    document.getElementById('AnnuDel').style.display='none';
    document.getElementById('saveAnnu').style.display='none';
    document.getElementById('cancelSanc').style.display='';
  }
}

function getFinalDetails()
{
  if(document.all.txtEmpNo.value=='')
  {
    alert("Please Select Employee First!!");
    return false;
  }
  if(document.all.txtAnnuSubDt.value=='')
  {
    alert("Please Select Annuity Submission Date");
    return false;
  }
  document.all.butGetDetail.disabled="true";
  document.all.hdnAction.value="getFinalDtls";
  frmPensionFinalSett.action="../../../PensionFinalPayDtls.do";
  frmPensionFinalSett.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmPensionFinalSett.action="../../../PensionFinalSettQueryMode.do"
    frmPensionFinalSett.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmPensionFinalSett.action="../../../PensionFinalSettRefresh.do"
    frmPensionFinalSett.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
     
    document.all.buttonFlag.value='';
    frmPensionFinalSett.action="../../../PensionFinalSettNewMode.do"
    frmPensionFinalSett.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmPensionFinalSett.action="../../../PensionFinalSettGetHeaderAction.do"
    frmPensionFinalSett.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmPensionFinalSett.userPositionRequested.value = 1*frmPensionFinalSett.positionRequested.value + 1;
    frmPensionFinalSett.action="../../../PensionFinalSettGetNextHeader.do";
    frmPensionFinalSett.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmPensionFinalSett.userPositionRequested.value = 1*frmPensionFinalSett.positionRequested.value - 1;
    frmPensionFinalSett.action = "../../../PensionFinalSettGetPrevHeader.do";
    frmPensionFinalSett.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmPensionFinalSett.userPositionRequested.value = 1*frmPensionFinalSett.newPositionRequested.value;
    frmPensionFinalSett.action = "../../../PensionFinalSettGetNextHeader.do";
    frmPensionFinalSett.submit();
}

function SaveRecord()
{
    document.all.buttonFlag.value=''; 
        if(mandatory_Check("frmPensionFinalSett"))
        {       
			document.all.butSanc.disabled="true";
			document.all.butSave.disabled="true";
            if(document.all.sancAmount.value=='')
            {
              alert("Please get the Payment details first");
            }else
            {
              frmPensionFinalSett.headerDataChanged.value = "true";    
              frmPensionFinalSett.headerFields.value = "true";   
		      document.all.butSave.disabled="true";
			  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
			  frmPensionFinalSett.action = "../../../PensionFinalSettSaveAction.do";            
              frmPensionFinalSett.submit();
            }
        }
    else
    {
        return false;
    }
}

function doCancelSanc()
{
  //if(mandatory_Check("frmPensionFinalSett"))
  //{
    document.all.butSave.disabled="true";
    //document.all.butRel.disabled="true";
    document.all.butCancelSanc.disabled="true";
    frmPensionFinalSett.headerDataChanged.value="true";
    frmPensionFinalSett.action = "../../../PensionFinalSettSaveAction.do";
    frmPensionFinalSett.submit();
  //}
}

function doSaveAnnuity()
{
  if(mandatory_Check("frmPensionFinalSett"))
  {
    document.all.butSave.disabled="true";
    //document.all.butRel.disabled="true";
    document.all.butSaveAnnuity.disabled="true";
    frmPensionFinalSett.headerDataChanged.value="true";
    frmPensionFinalSett.saveAnnuityFlag.value="Y";
    frmPensionFinalSett.action = "../../../PensionFinalSettSaveAction.do";
    frmPensionFinalSett.submit();
  }
}

</script>

</html:form>
</body>
</html:html>