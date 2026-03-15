<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<table border="0" cellspacing="0" cellpadding="0" >
<tr>
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
     <td  bgcolor=#4682b4 ></td>
     <td bgColor=#4682b4></td>
     <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
</tr>
</table>