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
    

</head>

<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="PostSalaryJVToGL" name="frmPostSalaryJVToGL" type="FCIPAY.Payroll.WEBTIER.Form.PostSalaryJVToGLForm">
<bean:define id="ParentForm" name="frmPostSalaryJVToGL" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
<TR height=30>
  <TD  colSpan=11 class=mainHeader height=10>POST SALARY TO JV</TD>
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
          <TD class=subHeader colspan=6>POST SALARY TO JV</TD>


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
                      <TD >

                     </TD>
                     </TR>
 </TBODY>
</TABLE>
</TD>
                     </TR>

        


<TR>
               <td align=center bgcolor=#4682b4 width="35%"></td>
           
               <td  bgcolor=#4682b4 width="25%"><html:button value='PostSalaryJVToGL'  onclick="PostSalJVTransaction()" property="butInsert" styleClass="bottomBarText" /></td>
               <td  bgcolor=#4682b4 width="25%"><html:button value='        Exit        '  onclick="window.close();" property="butInsert" styleClass="bottomBarText" /></td>
               <td  bgcolor=#4682b4 width="25%">
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>







        
        

</TD>
   </TR>
   </TBODY>
   </table>

 <html:hidden name="frmPostSalaryJVToGL"  property="screenName" value="PostSalaryJVToGLScreen" />
<html:hidden name="frmPostSalaryJVToGL"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmPostSalaryJVToGL" />
</html:form>
</body>
</html:html>

<script language="javascript">


function lfnLoad()
{
  
 
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
      doQueryMode();
  }
  batchMenuHandling();
}


function doQueryMode()
{
  frmPostSalaryJVToGL.action="../../../PostSalQueryMode.do";
  frmPostSalaryJVToGL.submit();
}

 function PostSalJVTransaction()
{  
  document.forms[0].action="../../../PostSalaryJVGL.do";
  document.forms[0].submit();
}
  
</script>  