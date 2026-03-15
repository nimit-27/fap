<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Data Status Report
</title>
</head>
<form>
<body>
<h2 align="center">
Data Status Report As on <%=request.getParameter("txtDate")%> for <%=request.getParameter("txtSite")%>
</h2>
<TABLE border="1" align="center" width="100%">
<TR>
	<TD align="center" width="15%">USER</TD>
	<TD align="center" width="">GL JV</TD>
	<TD align="center" width="">AR Invoices</TD>
	<TD align="center" width="">AP Invoices</TD>
	<TD align="center" width="">FA Transactions</TD>
	<TD align="center" width="">CM RCN Status</TD>
</TR>
<TR>
	<TD align="center" width="15%">A</TD>
	<TD align="center" width="">1</TD>
	<TD align="center" width="">1</TD>
	<TD align="center" width="">1</TD>
	<TD align="center" width="">1</TD>
	<TD align="center" width="">1</TD>
</TR>
</TABLE>
</body>
</form>
</html>
