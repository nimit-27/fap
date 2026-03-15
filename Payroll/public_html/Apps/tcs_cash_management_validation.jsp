
<%@ page language="java" import="java.sql.*,java.util.HashMap" %>

<%!
//DATABASE PARAMETERS........... Please set these parameters for creating Database Connection.

String strServerName="fcidev.fci.co.in";
String strPort="1524";
String strHostName="CRP2";
String strUser="apps";
String strPwd="secure";
String strFilePath="//home//applmgr//crp2comn//html//";
//String strFilePath="c://";
// DATABASE PARAMETERS Ending...............

%>

<html>
<head>
</head>
<title>
Cash Management
</title>

<style>

		.inv{
		font-family: Courier, Comic Sans MS, Arial, Sans , Times New Roman ;
		font-size: 6pt ;
		color: black ;
		background-color: white ;
		}

    .TC1 {
			FONT-WEIGHT: bold; FONT-SIZE: x-small; VERTICAL-ALIGN: bottom; COLOR: #336699; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif; 
      BACKGROUND-COLOR:#cccc99; TEXT-ALIGN: centerbackground-color: #999966 ;      
		}

    .TC2 {
			FONT-SIZE: x-small; COLOR: #000000; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif;
			border-left:1px solid #cccc99;border-bottom:1px solid #cccc99;border-right:1px solid #cccc99;
      background-color: #f7f7e7 ;      
		}
    
    .TC3 {
			FONT-SIZE: 75%; COLOR: #000000; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif;
			border-left:1px solid #cccc99;border-bottom:1px solid #cccc99;border-right:1px solid #cccc99;
      background-color: #f7f7e7 ;      
		}

	 .TC4 {
			FONT-SIZE: 75%; COLOR: #000000; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif;
			border-bottom:1px solid #cccc99;
      background-color: #f7f7e7 ;      
		}

	.RectifyErrorHeader {
			FONT-WEIGHT: bold; FONT-SIZE: 100%; COLOR: #FF0000; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif
		}

	.ValidationErrorHeader {
			FONT-WEIGHT: bold; FONT-SIZE: 115%; COLOR: #1E90FF; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif
		}
	.EventCompletedText {
			FONT-WEIGHT: bold; FONT-SIZE: 90%; COLOR: #336699; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif
		}
	.ErrorText {
			FONT-WEIGHT: bold; FONT-SIZE: 90%; COLOR: #FF0000; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif
		}
	</style>

  <script>
	function GoBack()
	{
		document.frm.action="tcs_cash_management_Excel_Reader.jsp?oID=" + document.frm.oID.value;
    	document.frm.submit();	
	}

	function Submission()
	{	
		document.frm.hdnSubmitted.value = 'Y';
		document.frm.action="tcs_cash_management_validation.jsp?oID=" + document.frm.oID.value;
    	document.frm.submit();	
	}
</script>

<body  text="#000000" bottommargin="0" leftmargin="0" marginheight="0" marginwidth="0" rightmargin="0" topmargin="0">
<!--<img src="pageHeader_files/tcs.gif" alt="" width="300" height="35">-->

<!---  Code for inserting Oracle Logo -->

<TABLE cellSpacing=0 cellPadding=0 width="100%" summary="" border=0>
  <TBODY>
  <TR>
    <TD vAlign=top noWrap>
      <TABLE cellSpacing=2 cellPadding=0 width="1%" summary="" border=0>
        <TBODY>
        <TR>
          <TD noWrap>
            <TABLE cellSpacing=0 cellPadding=0 summary="" border=0>
              <TBODY>
              <TR>
                <TD vAlign=top><img src="/OA_MEDIA/FNDSSCORP.gif" alt="Oracle Logo" border="0"></TD>
                <TD vAlign=bottom noWrap><SPAN class=x3w>E-Business 
                  Suite</SPAN></TD>
                <TD>
				<img src="/OA_MEDIA/fndpbs.gif" border="0">
				</TD>
			  </TR>
			  </TBODY>
		 	</TABLE>
	  	  </TD>
		</TR>
    	<TR>
          <TD vAlign=top noWrap></TD>
		</TR>
		</TBODY>
	</TABLE>
 </TD></TR>
  <TR>
    <TD width="100%">
      <TABLE cellSpacing=0 cellPadding=0 width="100%" summary="" border=0>
        <TBODY>
        <TR>
          <TD><IMG height=8 alt="" src="/OA_HTML/cabo/images/cache/cghes-1.gif" width=34></TD>
          <TD 
          style="BACKGROUND-IMAGE: url(/OA_HTML/cabo/images/cache/cghec-1.gif)" 
          width="100%">
          </TD>
          <TD><IMG height=8 alt="" src="/OA_HTML/cabo/images/cache/cghee-1.gif" 
        width=5></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
        
        
<form name="frm" method="post">
<%

Connection conOracle=null;

java.sql.Statement stmt=null;

java.sql.Statement StmtCheckError=null;

    
ResultSet rsmt= null;

ResultSet fetchRSChkError=null;


CallableStatement cstmt = null;

int tempcount					= -1;
int tempcount1				= -1; 
int tmpCount          = 0;
  
int totalRecords = 0;
int recordsInserted = 0;

int rsCount = 0;
int rsCount1 = 0;

int msgCount = 1;

String proc ="";
String procString = "";

String sql = "";


String inserted="N";
String validated = "N"; 


String sid = "";

int recordsDeleted = 0;

String oID = request.getParameter("oID")==null?"":request.getParameter("oID");
String sID = request.getParameter("sID")==null?"":request.getParameter("sID");
String submitted = request.getParameter("hdnSubmitted")==null?"N":request.getParameter("hdnSubmitted");
String uTyp=request.getParameter("utype")==null?"":request.getParameter("utype");

//out.println("oID : " + oID);
    
%>

<INPUT TYPE="hidden" size="13" NAME="oID" value ='<%=oID%>'>
<INPUT TYPE="hidden" size="13" NAME="sID" value ='<%=sID%>'>
<INPUT TYPE="hidden" size="13" NAME="hdnSubmitted" value ='<%=submitted%>'>

<%
//Creating DataBase Connection....... 

	try
  {
		Class.forName("oracle.jdbc.driver.OracleDriver");
  //  String dbURL=(String)request.getSession(false).getAttribute("dbURL");
  //  String [] arrUrl=dbURL.split(",");
    String url="jdbc:oracle:thin:@"+strServerName+":"+strPort+":"+strHostName;
    String dbURL=url+","+strUser+","+strPwd;
		conOracle	= DriverManager.getConnection(url,strUser,strPwd);
	
  }catch(Exception gExp)
  {
		out.println("<script>alert('Connection is Null')</script>");
		out.println("Exception in getting connection "+gExp);
		return;
	}
%>


<%
    if(submitted.equals("Y"))
    {
         if(uTyp.equals("F"))
         {
          procString = "{ call TCS_CE_STMT_fast_col.TCS_CE_STMT_INSERT(?) }";
         }else{
          procString = "{ call TCS_CE_STMT_RECONCILIATION.TCS_CE_STMT_INSERT(?) }";
         }
		 //conOracle=(Connection)request.getAttribute("conOracle");
     StmtCheckError = conOracle.createStatement();	

        try
        {	
          cstmt = conOracle.prepareCall(procString);
		  cstmt.setString(1,oID);
          cstmt.execute();

		  int recDeleted =StmtCheckError.executeUpdate("delete from TCS_CE_STMT_HEADERS_TEMP");
		  recDeleted =StmtCheckError.executeUpdate("delete from TCS_CE_STMT_LINES_TEMP");

        }catch(Exception e)
        {
          out.println("<center><pre class=\"ErrorText\"> Error in Inserting Records in Interface: " + e + "</pre></center>");
              if(conOracle==null)      
                conOracle.close();
          return;
        }

		out.println("<center><pre class=\"EventCompletedText\">Records Successfully Loaded into Interface  Table</pre></center>");
%>
		<table align="center" style="border-collapse:collapse" cellpadding="1" cellspacing="1" border="2">
  
				<tr bgcolor="#f7f7e7" > 
					<td align="center"><input type="button" class="TC1"  name="goBack" value= "OK " onclick= " self.close();"></td>
    	</tr>

		</table>



<%
          if(conOracle==null)      
            conOracle.close();
            
          return;

    }



%>



<%
  
      //out.println("Only call procedure");
      if(uTyp.equals("F"))
        procString = "{ call TCS_CE_STMT_fast_col.VALIDATE_STMT_HEADERS(?) }";
      else
        procString = "{ call TCS_CE_STMT_RECONCILIATION.VALIDATE_STMT_HEADERS(?) }";
        try
        {		

          cstmt = conOracle.prepareCall(procString);
		  cstmt.setString(1,oID);
          cstmt.execute();
        }catch(Exception e)
        {
          out.println("<center><pre class=\"ErrorText\"> Error in validating Header Records : " + e + "</pre></center>");
		  if(conOracle==null)      
			 conOracle.close();
		  return;
        }

    StmtCheckError = conOracle.createStatement();	 
       
     fetchRSChkError	 = StmtCheckError.executeQuery("select STATEMENT_NUMBER,ACC_NO,BRANCH, error_msg  from TCS_CE_STMT_HEADERS_TEMP where error_msg is not null");


	while(fetchRSChkError.next())
		{        
         rsCount++;
%>

<%
        if (rsCount == 1){ %>          
<center> <pre class="ValidationErrorHeader"> Error in Header Sheet!</pre></center>
<u><center><pre class="RectifyErrorHeader">Please Rectify The Following Errors</pre></Center></u>
<table align="center" style="border-collapse:collapse" cellpadding="1" cellspacing="0" border="0" width="80%">
 <tr bgcolor="#999966"> 
<th class="TC1" scope="col" style="border:1px outset #f7f7e7" align="center"  nowrap>Srl No</th>
<th class="TC1" scope="col" style="border:1px outset #f7f7e7" align="center"  nowrap>Statement Number</th>
<th class="TC1" scope="col" style="border:1px outset #f7f7e7" align="center"  nowrap>Account No</th>
<th class="TC1" scope="col" style="border:1px outset #f7f7e7" align="center"  nowrap>Bank Branch Name</th>
<th class="TC1" scope="col" style="border:1px outset #f7f7e7" align="center"  nowrap>Error Message</th>
</tr>
 
<%      }     %>

<tr id="tr_<%=rsCount%>" bgcolor="#f7f7e7">	
	<td class="TC2" scope="col"   nowrap align="center"><%=rsCount %></td>
	<td  class="TC2"  scope="col"  nowrap align="center"> <%=fetchRSChkError.getString("statement_number")%></td>
	  <td  class="TC2"  scope="col" nowrap > <%=fetchRSChkError.getString("ACC_NO")%></td>
  <td   class="TC2" scope="col" nowrap align="left"> <%=fetchRSChkError.getString("BRANCH")%></td>
	<td   class="TC2" scope="col"  align="left" ><%=fetchRSChkError.getString("error_msg")%></td>	 	
</tr>

<%        
     }

if(rsCount > 0)
	{  
		out.println("</table>");

		out.println("<center><pre class=\"EventCompletedText\">Records validated for Headers with Errors</pre></center><hr></hr>");		

		out.println("<pre class=\"EventCompletedText\"> Records with Error in Headers Temp Table : " + rsCount + " </pre>");

		try{
    
          int recDeleted =StmtCheckError.executeUpdate("delete from TCS_CE_STMT_HEADERS_TEMP where org_id = " + oID);
		  recDeleted =StmtCheckError.executeUpdate("delete from TCS_CE_STMT_LINES_TEMP where org_id = " + oID);
		}
		catch(Exception e)
		{
        out.println("<pre class=\"EventCompletedText\"> Deletion error : " + e + "</pre>");        
		}

		if(conOracle==null)     
		   conOracle.close();
	
	%>
		<table align="center" style="border-collapse:collapse" cellpadding="1" cellspacing="1" border="2">
  
				<tr bgcolor="#f7f7e7" > 
					<td align="center"><input type="button" class="TC1"  name="goBack" value= "Go Back " onclick= " GoBack();"></td>
    	</tr>

		</table>
		</form>
	<%	
		return;
		
	}
else
  out.println("<center><pre class=\"EventCompletedText\">Records validated Successfully for Headers</pre></center>");

%>


<%
  
      //out.println("Only call procedure");
      if(uTyp.equals("F"))
        procString = "{ call TCS_CE_STMT_fast_col.VALIDATE_STMT_LINES }";
      else
        procString = "{ call TCS_CE_STMT_RECONCILIATION.VALIDATE_STMT_LINES }";
        try
        {		

          cstmt = conOracle.prepareCall(procString);
          cstmt.execute();
        }catch(Exception e)
        {
          out.println("<center><pre class=\"ErrorText\"> Error in validating Records : " + e + "</pre></center>");
		  if(conOracle==null)      
			 conOracle.close();
		  return;
        }

    StmtCheckError = conOracle.createStatement();	 
       
     fetchRSChkError	 = StmtCheckError.executeQuery("select statement_number,ACC_NO, BALANCE,error_msg  from TCS_CE_STMT_LINES_TEMP where error_msg is not null");


	while(fetchRSChkError.next())
		{        
         rsCount++;
%>

<%
        if (rsCount == 1){ %>          
<center> <pre class="ValidationErrorHeader">Error in Lines Sheet</pre></center>
<u><center><pre class="RectifyErrorHeader">Please Rectify The Following Errors</pre></Center></u>
<table align="center" style="border-collapse:collapse" cellpadding="1" cellspacing="0" border="0" width="80%">
 <tr bgcolor="#999966"> 
<th class="TC1" scope="col" style="border:1px outset #f7f7e7" align="center"  nowrap>Srl No</th>
<th class="TC1" scope="col" style="border:1px outset #f7f7e7" align="center"  nowrap>Statement Number</th>
<th class="TC1" scope="col" style="border:1px outset #f7f7e7" align="center"  nowrap>Bank Account No</th>
<th class="TC1" scope="col" style="border:1px outset #f7f7e7" align="center"  nowrap>Amount</th>
<th class="TC1" scope="col" style="border:1px outset #f7f7e7" align="center"  nowrap>Error Message</th>
</tr>
 
<%      }     %>

<tr id="tr_<%=rsCount%>" bgcolor="#f7f7e7">	
	<td  class="TC2"  scope="col"  nowrap align="center"><%=rsCount %></td>
	<td  class="TC2"  scope="col"  nowrap align="center"> <%=fetchRSChkError.getString("statement_number")%></td>
	  <td  class="TC2"  scope="col"  align="center" nowrap > <%=fetchRSChkError.getString("ACC_NO")%></td>
  <td  class="TC2"  scope="col"  nowrap align="right"> <%=fetchRSChkError.getString("BALANCE")%></td>
	<td  class="TC2"  scope="col"  align="left" ><%=fetchRSChkError.getString("error_msg")%></td>	 	
</tr>

<%        
     }

if(rsCount > 0)
	{  
		out.println("</table>");

		out.println("<center><pre class=\"EventCompletedText\">Records validated for Lines with Errors</pre></center><hr></hr>");		

		out.println("<pre class=\"EventCompletedText\"> Records with Error in Lines Temp Table : " + rsCount + " </pre>");

		try{
    
          int recDeleted =StmtCheckError.executeUpdate("delete from TCS_CE_STMT_HEADERS_TEMP where org_id  = " + oID);
		  recDeleted =StmtCheckError.executeUpdate("delete from TCS_CE_STMT_LINES_TEMP where org_id = " + oID);
		}
		catch(Exception e)
		{
        out.println("<pre class=\"EventCompletedText\"> Deletion error : " + e + "</pre>");        
		}
		
	%>
		<table align="center" style="border-collapse:collapse" cellpadding="1" cellspacing="1" border="2">
  
				<tr bgcolor="#f7f7e7" > 
					<td align="center"><input type="button" class="TC1"  name="goBack" value= "Go Back " onclick= " GoBack();"></td>
    	</tr>

		</table>
	<%

	}
else
{
  out.println("<center><pre class=\"EventCompletedText\">Records validated Successfully for Lines</pre></center>");
%>

  <table align="center" style="border-collapse:collapse" cellpadding="1" cellspacing="1" border="2">
  
				<tr bgcolor="#f7f7e7" > 
					<td align="center"><input type="button" class="TC1"  name="submission" value= "Click Ok To Go Ahead" onclick= " Submission();"></td>
    	</tr>

	</table>

<%
}
%>

<%

if(conOracle==null)     
      conOracle.close();
      

  // out.println("<h3>"  + procString + "</h3>");
%>
</form>
</body>
</html>

