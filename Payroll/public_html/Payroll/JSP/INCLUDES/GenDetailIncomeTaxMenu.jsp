<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<bean:define id="pageNo" name="ParentForm" property="pageRequested" toScope="request" />
<bean:define id="maxPage" name="ParentForm" property="totalPageCount" toScope="request" />
<TABLE border=0>
  <tbody>
  <TR height=5 >
    <TD  class=userText height=5 colspan=3></TD>
    <TD  height=5 align="center">Pages</TD>
    <TD  class=userText height=5 colspan=3></TD>
  </TR>  
  <TR>
    <TD ><button  alt="GetDetail (Alt+T)"  onclick="GetDetail()" name="butGetDetail" class="bottomBarText">&nbsp;Get De<u>t</u>ail&nbsp;</button></TD>
    <td width=50%> </td>	
    
    <%if(pageNo.equals(new Long("1"))||pageNo.equals(new Long("0"))){%>
      <TD ><IMG src="../INCLUDES/IMAGES/butn_dtl_prev_dis.jpg"  ></td>
    <%}else{%>
     <TD class="icon"> <IMG src="../INCLUDES/IMAGES/butn_dtl_prev.jpg" onmouseover='this.src="../INCLUDES/IMAGES/butn_dtl_prev_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/butn_dtl_prev.jpg"' alt="Butn_prev (Alt+<)" onclick="doBasePrevDetail()" ></td>
    <%}%>
    <td class=dtlNavText><bean:write name="pageNo" /> of <bean:write name="maxPage" /></td>
    <%if(pageNo.equals(maxPage)){%>
      <td align=right><IMG src="../INCLUDES/IMAGES/butn_dtl_next_dis.jpg" ></td>
    <%}else{%>
      <td class="icon" align=right><IMG src="../INCLUDES/IMAGES/butn_dtl_next.jpg" onmouseover='this.src="../INCLUDES/IMAGES/butn_dtl_next_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/butn_dtl_next.jpg"' alt="Butn_next (Alt+>)" onclick="doBaseNextDetail()"></td>
    <%}%>
    
    <td class="icon" align=right><html:text property="newPageRequested" size="1" onkeypress="isInteger(event)" maxlength="10" /></td>
    <td class="icon"><input type="image" Alt="Go (Alt+G)" src="../INCLUDES/IMAGES/go_dtl.jpg" onclick="JumpDetail()"></td>		     
  </TR>


  </tbody>
</TABLE>
