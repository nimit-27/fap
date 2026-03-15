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
<html:form  action="WrkDoneMonthUpdateBase" name="frmDpsWrkDone" type="FCIPAY.Payroll.Labour.WEBTIER.Form.CalcDpsWrkDoneForm">
<bean:define id="ParentForm" name="frmDpsWrkDone" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
<TR height=30>

    <% String empLbr = (String)(request.getSession().getAttribute("hdnEmpLbrFlag"));
    if(empLbr.equals(new String("L"))) {%> 
    <TD  colSpan=11 class=mainHeader height=10>PERFORM MONTH END(INCENTIVE) FOR <bean:write name="frmDpsWrkDone" property="payYYMM" /></TD>
    <%} else {  %>          
    
    <TD  colSpan=11 class=mainHeader height=10>PERFORM MONTH END(ACTUAL WORK DONE) FOR <bean:write name="frmDpsWrkDone" property="payYYMM" /></TD>
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
          <TD class=subHeader colspan=6>Month End</TD>


        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

        
<TR height=100>
 <!-- Detail table Container starts -->
<TD colspan=11>
</TD>
                     </TR>


<TR>
               <td align=center bgcolor=#4682b4 width="40%"></td>
           
               <td  bgcolor=#4682b4 width="25%"><html:button value='Perform Month End'  onclick="MonthEnd()" disabled="false" property="butInsert" styleClass="bottomBarText" /></td>
               <td  bgcolor=#4682b4 width="25%">
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>

</TD>
   </TR>
   </TBODY>
   </table>

 <html:hidden name="frmDpsWrkDone"  property="screenName" value="WrkDoneMonthUpdateScreen" />
<html:hidden name="frmDpsWrkDone"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDpsWrkDone" />
<html:hidden property="txtLbrTyp" name="frmDpsWrkDone" />
</html:form>
</body>
</html:html>

<script language="javascript">


function lfnLoad()
{
  
 
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
	  enableForm();
      doQueryMode();
  }
  batchMenuHandling();
        if(document.all.hdnEmpLbrFlag.value=='D')
        document.all.txtLbrTyp.value='DPS';
      else
        document.all.txtLbrTyp.value='DEP';
}


function doQueryMode()
{
  frmDpsWrkDone.action="../../../WrkDoneMonthUpdateQueryMode.do";
  frmDpsWrkDone.submit();
}

 function MonthEnd()
{  
  frmDpsWrkDone.butInsert.disabled="true";
  document.forms[0].action="../../../WrkDoneMonthUpdate.do";
  document.forms[0].submit();
}
  
</script>  