<%@ page import="java.util.Locale" %>

<LINK href="../INCLUDES/ENRGISE.css" rel=stylesheet>

<SCRIPT language=javascript src="../INCLUDES/ENRGISE.js"></SCRIPT>

<SCRIPT language=javascript src="../INCLUDES/Menu_func.js"></SCRIPT>
<SCRIPT language=javascript src="../INCLUDES/Menu_addins.js"></SCRIPT>
<LINK href="../INCLUDES/Menucss.css" rel=stylesheet>

<LINK href="../INCLUDES/calendar-blue.css" rel=stylesheet>
<script type="text/javascript" src="../INCLUDES/calendar.js"></script>
<script type="text/javascript" src="../INCLUDES/calendar-setup.js"></script>	
<% 
  Locale oLoc = request.getLocale();
  String sLang=oLoc.getLanguage();  
%>
<script type="text/javascript" src='../INCLUDES/calendar-<%=sLang%>.js'></script>