<%@ page isErrorPage="true" %>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%//@ page import="com.ge.esc.utility.*"%>


<html>
<head>
<title>Error Page</title>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<script language="javascript"  src="../../COMMON/JavaScript/validate.js" ></script>

<link rel="STYLESHEET"  type="text/css"  href="../../COMMON/CSS/Menucss.css" >

<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_func.js" ></script>

<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_addins.js" ></script>

<link rel="stylesheet" href="../../COMMON/CSS/IBA.css" >

<script language="javascript">
</script>

</head>

<%
//Initialize the Handler name 
String strHandlerName = "EscError.jsp";
//Initialize the method name, the value will be set to proper method name inside the method
String strMethod = "Method";

String strMessage = (String)request.getAttribute("strError")==null?"":(String)request.getAttribute("strError");
//EscLogger.log(strHandlerName, strMethod,"DEBUG", "Error Message="+ strMessage);
%>
<body bgcolor="#FFFFFF"  leftmargin=0 marginheight=0 
marginwidth=0 rightmargin=0 topmargin=0>
<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menujs.js" ></script>
<table width="100%%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
<%//@ include file="EscHeaderBanner.htm"%>
    </td>
  </tr>
  <tr>
    <td>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
        <tr  align="center">
          <td width="10">&nbsp;</td>
          <td valign="top">
<!--Your Content will go here-->
		<br><br><br>
		<font face="Arial" color="#FF0000" size="3" >
		<% if (strMessage .equals(""))
		{
		%>
			An internal error occurred in the system
		<%
		}
		else
		{
		%>
			<%=strMessage%>
		<%
		}
		%>
		</font>	
		
<!--Your Content will end here-->
	  </td>
        </tr>
      </table>
    </td>
  </tr>

</table>
<br><br>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr align="center" >

<td align="center" >
<BUTTON class=butto  onmouseover="this.style.color='yellow';" onclick="javascript:history.back();" onmouseout="this.style.color='white';" name="back" value="back"><U>H</U>ome</BUTTON>  
</td>
</tr>  
</table>


<br><br><br><br><br>
<br><br><br><br><br>
<br><br><br><br><br>

<%//@ include file="EscFooter.htm"%>


</body>
</html>
