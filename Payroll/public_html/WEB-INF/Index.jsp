<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html>
<html:base />
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8" >
<%
  java.util.Date systemDate = new java.util.Date();
  java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("d-MMM-yyyy");
  String strSystemDate = dateFormat.format(systemDate);    
  StringBuffer requestString = request.getRequestURL();  
%>
<title>
FCI-Payroll Management System
</title>
<script language="javascript"  src='<html:rewrite page="/COMMON/JavaScript/validate.js" />'></script>
</head>
<body onload="displayDate()">
</body> 
<html:hidden property="hdnDate" value="<%=strSystemDate%>" />
</html:html>

<script lanuguage="javascript">
function displayDate()
{  
  var sysdt=document.getElementById("hdnDate").value;
  var d=new Date();  
  var curdate=d.getDate()+"/"+eval(d.getMonth()+1)+"/"+d.getYear();  
  var dt=change_DateFormatMon(sysdt);
  if(curdate==dt)
  {
  	openNew();
  }
  else
  	alert("Please Change your Date settings as server Date is "+sysdt);
}
</script>
