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
  <html:form  action="MaintEmpRlsSal" name="frmEmpTrnsfrForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpTrnsfrForm">
  <bean:define id="ParentForm" name="frmEmpTrnsfrForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
  <%
	String strEmpLbrFlag = (String)(request.getSession().getAttribute("hdnEmpLbrFlag"));
  %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>RELEASE INCENTIVE</TD>
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
            <table  cellSpacing=0 cellPadding=0 border=0> 
            
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" >
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" onchange="loadYrMonthLov(this.value);" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </td>  
                  
                  <td class=labelText  >Employee Name </td>
                  <td>                             
                  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                    
                  <td  >&nbsp;</td>
                  <td >&nbsp;</td>
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
                     "  style="text-align:left"   /></td>                                                                  
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
                  <td ><html:text property="txtEmpStatus" name="frmEmpTrnsfrForm" readonly="true" size="23" styleClass="locked" alt="<%=String.valueOf(i)%>"  onchange="return changed(this.alt)" />
                  </td>             
                  
				  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Incentive" /></TD>
				  <td align="left">
				  <html:text  property="txtIncentive" altKey="Payroll.EmpInfo.Incentive" maxlength="10" size="23" styleClass="locked" readonly="true"/>
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
            <TABLE cellSpacing=0 cellPadding=0 border = 0 >
               <TR>          
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=disTabText onclick="doGetTab('rlsSalary')"> Release Salary<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                
				<!--added by swapnendu-->
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=actTabText > Release Incentive <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
				<!--added by swapnendu-->

			   <!--added by sonia-->
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=disTabText onclick=doGetInvDtlsTab("TrnInvDtlsDet")>Invoice Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
               <!--end by sonia-->

                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    
              </tr> 
            <tr height="10"><td class=userText colspan="17"></td></tr>            
            <TR height=10>
       <!-- Detail table Container starts -->
                <TD colspan=17>
                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                        <TD>
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0>
                          <TBODY>                                
                            <tr height = 3><td></td></tr>                          
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
    <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellSpacing=0 cellPadding=0 >
        <TR>
          <TD class=subHeader colspan=11>  </TD>
        </TR>

        <TR height=40>
 <!-- Detail table Container starts -->
                <TD >
                  <TABLE cellSpacing=0 cellPadding=0 border=0 >
                    <TBODY>
                      <TR>
                        <TD >
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0 border=0>
                          <TBODY>    
                          
                            <tr width="100%">                           
                              
                              <td width="45%" class=labelText><bean:message key="Payroll.EmpInfo.YYMM" /></td>
                              <td >
								  <html:select property="txtYYMM" titleKey="Payroll.EmpInfo.YYMM" styleClass="required"  >
								  <html:option value="" >---------Please Select---------</html:option>      
								  <logic:present name="SalaryYrMonth">
								  <html:optionsCollection label="label" value="value" property="incentiveRlsYrMnthList" name="SalaryYrMonth"/>
								  </logic:present>
								  </html:select>                            
							 </td>   

                            </tr>                            
                         
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
        <td align=center bgcolor=#4682b4 width="40%"></td>
        <td  bgcolor=#4682b4>
		<html:button property="butCancel" value="Release Incentive" onclick="rlsIncentive()" />
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
<html:hidden name="frmEmpTrnsfrForm"  property="screenName" value="RlsSalScreen" />
<html:hidden property="txtTrnsfrFrom" name="frmEmpTrnsfrForm"  />
<html:hidden property="loginLocCode" name="frmEmpTrnsfrForm"  />
<html:hidden name="frmEmpTrnsfrForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpTrnsfrForm" />
<html:hidden property="positionRequested" name="frmEmpTrnsfrForm" />
<html:hidden property="userPositionRequested" name="frmEmpTrnsfrForm" />
<html:hidden property="newPositionRequested" name="frmEmpTrnsfrForm"  />
<html:hidden property="buttonFlag" name="frmEmpTrnsfrForm"  />
<html:hidden property="lovKey" name="frmEmpTrnsfrForm"  />
<html:hidden property="txtFields" name="frmEmpTrnsfrForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpTrnsfrForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpTrnsfrForm"  />
<html:hidden property="txtIndex" name="frmEmpTrnsfrForm"  />
<html:hidden property="txtInputField" name="frmEmpTrnsfrForm"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">
function ShowEmpNum()
{
   if(frmEmpTrnsfrForm.screenMode.value=='Q')
   {
     frmEmpTrnsfrForm.lovKey.value = "EmpRlsSal" + frmEmpTrnsfrForm.screenName.value + frmEmpTrnsfrForm.screenMode.value;
     frmEmpTrnsfrForm.queryParam.value = "txtSiteID="+frmEmpTrnsfrForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpTrnsfrForm.hdnEmpLbrFlag.value;
	 if  (frmEmpTrnsfrForm.hdnEmpLbrFlag.value == 'D')
	 {
		frmEmpTrnsfrForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOPDesc,txtDOJSite,txtEmpStatus,txtIncentive";
	 }
	 else
	 {
		frmEmpTrnsfrForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOPDesc,txtDOJSite,txtEmpStatus";
	 }

     frmEmpTrnsfrForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
     frmEmpTrnsfrForm.txtInputField.value ="txtEmpNo"; 
     frmEmpTrnsfrForm.txtIndex.value ="";     
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpTrnsfrForm');
   }
   return true;
}    

function upper(val)
{
   val.value=val.value.toUpperCase();
}

function lfnLoad()
{   
    mode = document.all.screenMode.value;
    if(mode == '')
    {
        doQueryMode();
    }
    hedMenuHandling(mode);
    document.all.butInsertMode.disabled="true";    
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butExecute.disabled="true";    
    document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";

}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpTrnsfrForm.action="../../../EmpRlsSalQueryMode.do"
    frmEmpTrnsfrForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpTrnsfrForm.action="../../../EmpTrnsfrInRefresh.do"
    frmEmpTrnsfrForm.submit();
}

function rlsSal()
{
    if(mandatory_Check("frmEmpTrnsfrForm"))
    {  
        var resp=confirm("Are you sure you want to release the Employee Salary?");
        if(resp)
        {
            document.all.buttonFlag.value='SAL'; 
            frmEmpTrnsfrForm.action="../../../EmpRlsSalaryAction.do"
            frmEmpTrnsfrForm.submit();
        }
        else
        {
          return false;
        }
    }
    else
    {
       // alert("Please Select an employee First !!!");
        return false;
    }

}

function rlsIncentive()
{
    if(mandatory_Check("frmEmpTrnsfrForm"))
    {  
        var resp=confirm("Are you sure you want to release the Labour Incentive?");
        if(resp)
        {
            document.all.buttonFlag.value='INC'; 
            frmEmpTrnsfrForm.action="../../../EmpRlsIncentiveAction.do"
            frmEmpTrnsfrForm.submit();
        }
        else
        {
          return false;
        }
    }
    else
    {
       // alert("Please Select an employee First !!!");
        return false;
    }

}

function loadYrMonthLov(val)
{    
    ac="../../../trnsfrSalRlsYrMnthAction.do?empNo="+val;
    document.forms[0].action=ac;
    document.forms[0].submit(); 
}
function doGetTab(arg)
{   
    mode = document.all.screenMode.value;
    if(mode == 'N' )
    {
        return false;
    }
    else
    {
      document.all.forwardedPage.value=arg;
      document.forms[0].action="../../../RlsIncentiveTabAction.do";
      document.forms[0].submit(); 

	  
    }  
}

function doGetInvDtlsTab(arg)
{   
    var emp_no = document.getElementById("txtEmpNo").value;
	if(emp_no != "")
	{
		mode = document.all.screenMode.value;
		if(mode == 'N' )
		{
			return false;
		}
		else
		{
		  document.all.forwardedPage.value=arg;
		  document.forms[0].action="../../../EmpTrnsfrInvDtlsAction.do";
		  document.forms[0].submit(); 
		}  
	}
	else
	{
		alert("Please select an employee");
		return;
	}
}

</script>