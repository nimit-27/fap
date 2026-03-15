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
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintEmpSuspensionDetailBase" name="frmEmpSuspensionForm" type="FCIPAY.Payroll.WEBTIER.Form.MaintEmpSuspensionForm">
<bean:define id="ParentForm" name="frmEmpSuspensionForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE INVOICE INFORMATION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
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
              <TD class=subHeader colspan=6> Detail Information Of Employee</TD>
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="4"></td>
            </tr>           
            
            <tr></tr>
            <table  cellSpacing=0 cellPadding=0 border=0> 
            
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" colspan="3">
                  <logic:equal property= "screenMode" name= "frmEmpSuspensionForm" value="N">                   
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>
                  <logic:notEqual property= "screenMode" name= "frmEmpSuspensionForm" value="N">
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual> 
                  
                  <logic:equal property= "screenMode" name= "frmEmpSuspensionForm" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>                  
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td>               
                  
              </TR> 
                                
              <TR>              
                  <TD width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                                             
                  </td>
                  
                  <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/><html:hidden property="txtCateg"  styleClass="locked" /></td>                  
                  
              </tr>
                      
              <tr>  
              
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                    
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   /></td>                                                                  
               </tr>
               
               <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td><html:text  property="txtPresentPOP" altKey="pay.EmpInfo.PresentPOP" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   />                  
                  </td>                                                            
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>    
      
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text  property="txtEmpStatus" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>  
              </tr>                
   
            </table>     
          </tr>            
      <tr height="15" >
      <td colspan="6"></td>
    </tr>                                 
  </table>
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	 <TR height="100">
      <TD colspan=6>
      <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellspacing="0" cellPadding="0" >
              <TR>   
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("SuspDet")> Suspension Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("RevokDet")> Revocation Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetSlrRlsTab("SalRlsDet") >Salary Release<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <!--added by sonia-->

               <!--added by sonia-->
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText >Invoice Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
               <!--end by sonia-->

                <!--end by sonia-->

                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
           
          <tr height="10"><td class=userText colspan="14"></td></tr>            
          <TR height=10>
 <!-- Detail table Container starts -->
            <TD colspan=14>
              <TABLE cellSpacing=0 cellPadding=0 border=0>
                <TBODY>
                  <TR>
                    <TD >
  			<!-- Detail table starts -->
                     <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR width="100%">                        
                          <td width="45%" class=labelText>Invoice Detail</td>
                          <td ><html:select property="txtInvNum" name="frmEmpSuspensionForm"  titleKey="Payroll.EmpInfo.Inv" styleClass="optional"  >
                          <html:option value="" >---------Please Select---------</html:option>      
                          <logic:present name="InvoiceDtls">
                          <html:optionsCollection label="label" value="value" property="valueInvDtlsList" name="InvoiceDtls"/>
                          </logic:present>
                          </html:select>                            
                        </td>                                                                                                                         
                    </tr>                      
                                      
                    <tr height = 3><td>&nbsp;</td></tr>                    
                    <tr height = 3><td>&nbsp;</td></tr>                    
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
        <td align=center bgcolor=#4682b4 width="53%"></td>
        
        <td width="45%" bgColor=#4682b4></td>
        <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
      </TR>	
  </TABLE> 
<!-- Container Table Ending Columns Starts-->
  </TD>
    
</TR>
</TBODY>
</TABLE>

</div>


<!-- Container Table Ends -->
<html:hidden name="frmEmpSuspensionForm"  property="screenName" value="EmpSuspensionScreen" />
<html:hidden name="frmEmpSuspensionForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpSuspensionForm" />
<html:hidden property="loginLocCode" name="frmEmpSuspensionForm" />
<html:hidden property="positionRequested" name="frmEmpSuspensionForm" />
<html:hidden property="userPositionRequested" name="frmEmpSuspensionForm" />
<html:hidden property="buttonFlag" name="frmEmpSuspensionForm"  />
<html:hidden property="lovKey" name="frmEmpSuspensionForm"  />
<html:hidden property="txtFields" name="frmEmpSuspensionForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpSuspensionForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpSuspensionForm"  />
<html:hidden property="txtIndex" name="frmEmpSuspensionForm"  />
<html:hidden property="txtEmpNo" name="frmEmpSuspensionForm"  />

<html:hidden property="suspId" name="frmEmpSuspensionForm"  />
<html:hidden property="suspEffDate" name="frmEmpSuspensionForm"  />
<html:hidden property="suspReason" name="frmEmpSuspensionForm"  />

<html:hidden property="revokeType" name="frmEmpSuspensionForm"  />
<html:hidden property="revokeDate" name="frmEmpSuspensionForm"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function ShowEmpNum()
{
   frmEmpSuspensionForm.lovKey.value = "EmpSusp" + frmEmpSuspensionForm.screenName.value + frmEmpSuspensionForm.screenMode.value; 
   
       //frmEmpSuspensionForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,lstCateg,txtDsgn";
       frmEmpSuspensionForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtDOJSite";
       frmEmpSuspensionForm.queryParam.value = "txtSiteID="+frmEmpSuspensionForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpSuspensionForm.hdnEmpLbrFlag.value;
       frmEmpSuspensionForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName";
       frmEmpSuspensionForm.txtIndex.value ="";      
   
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpSuspensionForm');
   return true;
}

function lfnLoad()
{    
    batchMenuHandling();    
    mode = document.all.screenMode.value;   
    
    if(mode == '')
    {
        doQueryMode();
    }
    
}

function doQueryMode()
{
    return false;
    /*document.all.buttonFlag.value='';
    frmEmpSuspensionForm.action="../../../EmpRevocationQueryMode.do"
    frmEmpSuspensionForm.submit();*/
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpSuspensionForm.action="../../../EmpSuspRlsSalRef.do"
    frmEmpSuspensionForm.submit();
}

function doInsertMode()
{
    return false;
    /*if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.action="../../../EmpRevocationNewMode.do"
    frmEmpSuspensionForm.submit();*/
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

    frmEmpSuspensionForm.action="../../../EmpRevoFirstGetHeaderAction.do"
    frmEmpSuspensionForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.userPositionRequested.value = 1*frmEmpSuspensionForm.positionRequested.value + 1;
    frmEmpSuspensionForm.action="../../../EmpRevoGetNextHeader.do";
    frmEmpSuspensionForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.userPositionRequested.value = 1*frmEmpSuspensionForm.positionRequested.value - 1;
    frmEmpSuspensionForm.action = "../../../EmpRevoGetPrevHeader.do";
    frmEmpSuspensionForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpSuspensionForm.userPositionRequested.value = 1*frmEmpSuspensionForm.newPositionRequested.value;
    frmEmpSuspensionForm.action = "../../../EmpRevoGetNextHeader.do";
    frmEmpSuspensionForm.submit();
}

function releaseSalary()
{  
    if(mandatory_Check('frmEmpSuspensionForm'))
    {      
        document.all.screenMode.value='U';
        frmEmpSuspensionForm.action = "../../../EmpSuspRlsSalary.do";
        frmEmpSuspensionForm.submit();
    }   
    else
    {
        return false;
    }
}


function cancelSuspension()
{
    alert("Cancel Suspension");
}

function SaveRecord()
{
    document.all.buttonFlag.value='';   
    if (document.all.revokeType.value=="EMPREVOC$SUBALWREV")
    {
        if (document.all.subsAllow.value=='')
        {
            alert("Subsistance Allowance is Mandatory ");
            frmEmpFinInfoForm.subsAllow.focus(); 
            return false;
        }
        if (document.all.subsEffDate.value=='')
        {
            alert("Subsistance Effective Date is Mandatory ");
            frmEmpFinInfoForm.subsEffDate.focus(); 
            return false;
        }
    }
    
    var sEffdate=document.all.suspEffDate.value;
    var revDate=document.all.revokeDate.value;
    var subEffdate=document.all.subsEffDate.value;   
    
    if(mandatory_Check("frmEmpSuspensionForm"))
    {     
        frmEmpSuspensionForm.txtEmpNo.value=frmEmpSuspensionForm.headerPrimaryKey.value;         
        if (cmpRevokDate(revDate,sEffdate, 0) && cmpSuspDate(sEffdate, subEffdate, 0))
        {
            frmEmpSuspensionForm.detailDataChanged.value = "false";          
            frmEmpSuspensionForm.headerDataChanged.value = "true";    
            frmEmpSuspensionForm.headerFields.value = "true";              
			document.all.butSave.disabled="true";
			document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
            frmEmpSuspensionForm.action = "../../../EmpRevoSaveAction.do";
            
            frmEmpSuspensionForm.submit();
        }    
    }
    else
    {
        return false;
    }
}

function cmpRevokDate(date1,date2, flag)
{
	if (trim(date1) == "")
	{
		return true;
	}

	date1 = change_DateFormatMon(date1);
	sysDate = change_DateFormatMon(date2);
	if (flag == 0)
	{
		if (dateDiff(sysDate, date1) < 0)
		{
			alert("Revocation Date cannot be Less than the Suspension date!");
      document.all.revokeDate.select();
      document.all.revokeDate.focus();
		//	event.srcElement.select();
		//	event.srcElement.focus();
			return false;
		}
	}
	return true;
}

function cmpSuspDate(date1,date2, flag)
{
	if (trim(date1) == "")
	{
		return true;
	}

	date1 = change_DateFormatMon(date1);
	sysDate = change_DateFormatMon(date2);
	
	if (flag == 0)
	{
		if (dateDiff(sysDate, date1) > 0)
		{
			alert("Subsistence Date cannot be Less than the Suspension date!");
      document.all.subsEffDate.select();
      document.all.subsEffDate.focus();
		//	event.srcElement.select();
		//	event.srcElement.focus();
			return false;
		}
	}
	return true;
}

function lfnChanged(val)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function Chk_Char(name)
{
    that=document.getElementsByName(name)[0];    
    str=that.value; 
    for(i=0; i<str.length; i++)
    {
        var txtVal =str.charAt(i);
        if((txtVal >= 'A' && txtVal <= 'Z') ||(txtVal >= 'a' && txtVal <= 'z') || (txtVal == ',') || (txtVal == ' '))
        {}
        else
        {
            alert("Invalid Input");               
            that.select(); 
            alert(that.value);
            return true;
        }
    }
}

function doGetTab(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpInfoHrTabAction.do";
    document.forms[0].submit(); 
}


function doGetTabs(arg)
{
    document.all.screenMode.value='U';
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpSalRlsTabAction.do";
    document.forms[0].submit(); 
}

function doGetSlrRlsTab(arg)
{   
     mode = document.all.screenMode.value;
    if(mode == 'N' || mode == 'Q')
    {
        return false;
    }
    else
    {
      document.all.forwardedPage.value=arg;
      document.forms[0].action="../../../EmpSuspYrMonthAction.do";
      document.forms[0].submit(); 
    }  
}

function chk_YearMonth()
{      
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6);    
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("txtYYMM").focus();                     
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
    
</script>