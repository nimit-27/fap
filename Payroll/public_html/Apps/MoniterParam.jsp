<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Monitor Screen
</title>
</head>
<body>
<h2>
Monitoring Param Screen 
</h2>
<form name="frmRep" action="DataStatus.jsp" method="post">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr>
    <td align="right" width="45%">Select the Date</td>
    <td width="55%"><select  name="txtDate">
<option value="12-Oct-2008" selected>12-Oct-2008</option>
</select></td>
</tr>
<tr>
    <td colspan="2" align="center"><input type="button" value="View Status" onclick="getReport()"></td>
</tr>
</table>
</form>
</body>
</html>
<script language="javascript">

function getReport()
{
	document.all.action="DataStatus.jsp?txtDate="+document.all.txtDate.value;
	document.frmRep.submit();
}

</script>