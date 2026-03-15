<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script> 
    <script type = "text/javascript">
       function enableForm()
        {
            document.forms[0].disabled=true;
        }
        window.onload=enableForm;
    </script> 

</head>

<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="PostDpsWrkDoneInvToAP" name="frmDpsWrkDone" type="FCIPAY.Payroll.Labour.WEBTIER.Form.CalcDpsWrkDoneForm">
<bean:define id="ParentForm" name="frmDpsWrkDone" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
<TR height=30>

  <% String empLbr = (String)(request.getSession().getAttribute("hdnEmpLbrFlag"));
    if(empLbr.equals(new String("L"))) {%> 
    <TD  colSpan=11 class=mainHeader height=10>POST INCENTIVE INVOICES TO AP FOR <bean:write name="frmDpsWrkDone" property="payYYMM" /></TD>
    <%} else {  %>          
    
    <TD  colSpan=11 class=mainHeader height=10>POST WORK DONE INVOICES TO AP FOR <bean:write name="frmDpsWrkDone" property="payYYMM" /></TD>
    <%}  %>
  
</TR>
<tr height="10"><td class=userText colspan="11"></td></tr>
</TABLE>


<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
      <!-- <div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--pay Scale Header Row Starts -->
       <TR>
          <% if(empLbr.equals(new String("L"))) {%> 
          <TD class=subHeader colspan=6>POST INCENTIVE INVOICES TO AP</TD>
          <%} else {  %>          
          
          <TD class=subHeader colspan=6>POST WORK DONE INVOICES TO AP</TD>
          <%}  %>
          
        </TR>
        <TR>
          <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
        </TR>
        
        <TR height=220>
         <!-- Detail table Container starts -->
        <TD colspan=11>
          <TABLE cellSpacing=0 cellPadding=0 border=0>
            <TBODY>
              <TR>
                <TD class="labelText" style="WIDTH: 50%">Select Invoice Pay Group</TD>
                <TD class="labelText" style="WIDTH: 20%">
					<html:select property="txtInvType" name="frmDpsWrkDone" style="WIDTH: 100%" styleClass = "required">
					<html:option value="2">Incentive</html:option>
					<html:option value="1">Salary</html:option>
					</html:select>
				</TD>
              </TR>
            </TBODY>
          </TABLE>
        </TD>
      </TR>
      <TR>
      <td align=center bgcolor=#4682b4 width="45%"></td>
      
      <td  bgcolor=#4682b4 width="25%"><html:button value='Post Invoices to AP'  onclick="PostSalInvTransaction()" disabled="false" property="butInsert" styleClass="bottomBarText" /></td>
      <td  bgcolor=#4682b4 width="25%">
      <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
      </TR>
      </TD>
   </TR>
  </TBODY>
</table>

<html:hidden name="frmDpsWrkDone"  property="screenName" value="PostWrkDoneInvToAPScreen" />
<html:hidden name="frmDpsWrkDone"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDpsWrkDone" />
<html:hidden name="frmDpsWrkDone"  property="hdnAction" />    <!--added by dushyant on 13-may-2011-->
</html:form>
</body>
</html:html>

<script language="javascript">

function lfnLoad()
{ 
  var screenmode = document.all.screenMode.value;
 
  if(screenmode=='Q')
	{
	//    optClick('A');
	}
  else
  {
	  enableForm();
      doQueryMode();
	  frmDpsWrkDone.hdnAction.value='';  // added by dushyant on 13-may-2011
  }
     // added by dushyant on 13-may-2011
  if (frmDpsWrkDone.hdnAction.value=='S') 
  {
     document.all.butInsert.disabled="true";
	 frmDpsWrkDone.hdnAction.value='SUB';
     PostSalInvTransaction(); 
  }
  batchMenuHandling();
}

function doQueryMode()
{
  frmDpsWrkDone.hdnAction.value='Q'
  frmDpsWrkDone.action="../../../PostWrkDoneAPQueryMode.do";
  frmDpsWrkDone.submit();
}

 function PostSalInvTransaction()
{  
//  document.forms[0].action="../../../PostWrkDoneAP.do";  commented by dushyant on 13-may-2011
//  document.forms[0].submit();  commented by devendra on 29th sept 2010
// added by dushyant on 13-may-2011 start
	var invType = frmDpsWrkDone.txtInvType.value;

	 if (frmDpsWrkDone.hdnAction.value != 'SUB') 
     {    
		 if(invType == "1") //prompt for salary posting. 
		 {
			if(confirm("You are currently Posting Incentive Invoices to Salary Pay Group. Are you sure?"))
     		{
				frmDpsWrkDone.hdnAction.value = 'S'; 
				frmDpsWrkDone.action = "../../../PostWrkDoneAP.do";
				frmDpsWrkDone.submit();
		    }
		 }
	 	 else
		 {
			frmDpsWrkDone.hdnAction.value = 'S'; 
			frmDpsWrkDone.action = "../../../PostWrkDoneAP.do";
			frmDpsWrkDone.submit();
		 }
     }
     else
     {
        frmDpsWrkDone.hdnAction.value='SUB';       
        frmDpsWrkDone.action = "../../../PostWrkDoneAP.do";
        frmDpsWrkDone.submit();
     }      
  //added by dushyant on 13-may-2011 end
}
  
</script>  