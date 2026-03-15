<%@page import="FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean" %>
<%@page import="java.util.ArrayList" %>
<html>

<body bgcolor="#D9EEF9">
    <table width="100%" >
				<tr > 
					<td ></td>
    	</tr>
		</table>
<form name="frm" method="get" action="" >
<%
  ArrayList oParameters = new ArrayList(); //Input Parameters      
  DBUtilitiesBean oBean = new DBUtilitiesBean();
  String userName=request.getParameter("userName");
  String loc=request.getParameter("userLoc");
  String prblm=request.getParameter("prblmDesc");
  String sevr=request.getParameter("severity");
  String insertQry="INSERT INTO FCIFAP_PRBLM_LOG (LOG_NO,USER_NAME,USER_LOC,LOG_DATE,PRBLM_DESC,SEVERITY) VALUES"+ 
                  "(FCIFAP_PRBLM_LOG_SEQ.NEXTVAL,'"+userName+"','"+loc+"',sysdate,'"+prblm+"','"+sevr+"')";
  System.out.println(insertQry);
  try 
  {
    int x = oBean.executeUpsert(insertQry); 
   // alert("Record Saved Successfully");
  }
  catch(Exception e)
  {
    out.println("<center><pre>Error During Insertion "+e+"</pre></center>");
  } 
  out.println("<center><pre style='color:#000000;font-weight:bold;font-size:18'>Record Saved Successfully</pre></center>");
%>   
    <table align="center" cellpadding="1" cellspacing="1" border="0">
				<tr> 
					<td align="center"><input type="button" class="TC1"  name="goBack" value= "Close " onclick= " self.close();"></td>
    	</tr>
		</table>
</form>
</body>
</html>

