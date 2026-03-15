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
  <html:form  action="CPFStopAction" name="frmCPFStop" type="FCIPAY.Payroll.WEBTIER.Form.CPFStopForm">
  <bean:define id="ParentForm" name="frmCPFStop" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>CPF RECOVERY</TD>
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
              <TD class=subHeader colspan=6> Employee Header</TD>
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="6"></td>
            </tr>         
                            
            
            <tr></tr>
            <table  cellSpacing=0 cellPadding=0 border=0 > 
            
                <TR>
                  <TD class=labelText width="20%"><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" >
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
					<logic:equal name="frmCPFStop" property="screenMode" value="N" >
						<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" onclick="return ShowEmpNum();">
					</logic:equal>
					<logic:notEqual name="frmCPFStop" property="screenMode" value="N" >
						<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" onclick="return ShowEmpNum();">
					</logic:notEqual>
                  </td>  
                  
                  <td class=labelText  width="20%" >Employee Name </td>
                  <td>                             
                  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                    
              </TR> 
              
              <TR>              
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/></td>                  
                                    
              </tr>
                      
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                  
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" readonly="true" maxlength="7" size="23" styleClass="locked" onkeypress="
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {
                      return false;
                    };                            
                          lfnChanged(this.value);
                     "  style="text-align:right"   /></td>                                                                  
              </tr>                  
      
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td>
                  <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>   
              
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td >
					<html:text property="txtEmpStatus" name="frmCPFStop" readonly="true" size="23" styleClass="locked" alt="<%=String.valueOf(i)%>"  />
					<html:hidden property="cpfFlag" name="frmCPFStop" />
                  </td>             
                  
                  <td width="15%" class=labelText  >CPF Status </td>                            
                  <td >
					<html:text property="txtCPFMsg" name="frmCPFStop" readonly="true"  size="23" onchange="showBtn()"/>
                  </td>             
              </tr>
             
            </table>     
          </tr>                          
  </table>


	<table cellspacing=0 cellpadding=0 border=0 >
         <!-- Detail Information Row starts -->
 	 <TR height="100">
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->

      </td>
    </tr>
                <!-- Tab Table Ends -->
<!-- Bottom Blue Bar -->
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
          
           <td align=center bgcolor=#4682b4 width="35%"></td>
           <td bgcolor=#4682b4>
				<html:button value='Start CPF'  onclick="SaveRecord('N')" property="initCPF" styleClass="bottomBarText" disabled="true" />
				<html:button value='Stop CPF'  onclick="SaveRecord('Y')" property="stopCPF" styleClass="bottomBarText" disabled="true" />
		   </td>
           <td bgColor=#4682b4></td>
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
<html:hidden property="screenMode" name="frmCPFStop"  />
<html:hidden property="headerPrimaryKey" name="frmCPFStop" />
<html:hidden property="loginLocCode" name="frmCPFStop"  />
<html:hidden name="frmCPFStop" property="screenName" value="CPFStopScreen" />
<html:hidden name="frmCPFStop" property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmCPFStop"  />
<html:hidden property="lovKey" name="frmCPFStop"  />
<html:hidden property="txtFields" name="frmCPFStop"  />   
<html:hidden property="txtSearchFields" name="frmCPFStop"  />
<html:hidden property="txtDisplayFields" name="frmCPFStop"  />
<html:hidden property="txtIndex" name="frmCPFStop"  />
<html:hidden property="txtInputField" name="frmCPFStop"  />
<html:hidden property="userPageRequested" name="frmCPFStop"  />
<html:hidden property="pageRequested" name="frmCPFStop"  />
<html:hidden property="positionRequested" name="frmCPFStop" />
<html:hidden property="userPositionRequested" name="frmCPFStop" />
<html:hidden property="totalDetailRecord" name="frmCPFStop"  />


<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">
function lfnLoad()
{   
    mode = document.all.screenMode.value;
	//alert(mode)
    if(mode == '')
    {
        doQueryMode();
    }
    
	hedMenuHandling(mode);
	showBtn();
    //document.all.butInsertMode.disabled="true";    
    //document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    //document.all.butExecute.disabled="true";    
    //document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";

}

function showBtn(){
	var cpfSts = frmCPFStop.cpfFlag.value;
	var emp = frmCPFStop.txtEmpNo.value;
	if(emp != "")
	{
		if(cpfSts == 'Y')
		{
			document.all.initCPF.disabled="";
			document.all.stopCPF.disabled="true";
		}
		else
		{
			document.all.initCPF.disabled="true";
			document.all.stopCPF.disabled="";
		}
	}
	else
	{
		document.all.initCPF.disabled="true";
		document.all.stopCPF.disabled="true";
	}
}

function ShowEmpNum()
{
     frmCPFStop.lovKey.value = "CPFStop" + frmCPFStop.screenName.value + frmCPFStop.screenMode.value;
     frmCPFStop.queryParam.value = "txtSiteID="+frmCPFStop.loginLocCode.value+",hdnEmpLbrFlag="+frmCPFStop.hdnEmpLbrFlag.value;
     frmCPFStop.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOPDesc,txtDOJSite,txtEmpStatus,cpfFlag,txtCPFMsg";
	 frmCPFStop.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
     frmCPFStop.txtInputField.value ="txtCPFMsg";
     frmCPFStop.txtIndex.value = "";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmCPFStop');
	
}    

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmCPFStop.action="../../../CPFStopQueryMode.do";
    frmCPFStop.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value = '';
  frmCPFStop.action="../../../CPFStopNewMode.do";
  frmCPFStop.submit();
}

function SaveRecord(flag)
{

	document.all.cpfFlag.value = flag;
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmCPFStop"))
    {   
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
		frmCPFStop.screenMode.value = 'N';
		frmCPFStop.detailDataChanged.value = "false";
        frmCPFStop.headerDataChanged.value = "true";
        frmCPFStop.headerFields.value = "true";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmCPFStop.action = "../../../CPFStopSaveAction.do";            
        frmCPFStop.submit();
    }
    else
    {
        return false;
    }
    
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmCPFStop.action="../../../CPFStopRefresh.do";
    frmCPFStop.submit();
}

function getHeaderRecord()
{
	if(mandatory_Check("frmCPFStop"))
	{
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
		frmCPFStop.action="../../../CPFStopGetHeaderAction.do"
		frmCPFStop.submit();
	}
    else
    {
        return false;
    }

}


</script>