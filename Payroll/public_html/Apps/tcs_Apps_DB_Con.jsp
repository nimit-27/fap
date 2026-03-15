<%@page import="java.util.List,java.sql.*" buffer = "none" %>

<%!
//DATABASE PARAMETERS........... Please set these parameters for creating Database Connection.

 String strServerName="fcidev.fci.co.in";
 String strPort="1524";
 String strHostName="CRP2";
 String strUser="apps";
 String strPwd="secure";
//String strFilePath="//home//applmgr//crp2comn//html//";
 String strFilePath="c://";
// DATABASE PARAMETERS Ending...............

%>




<%!
public Connection getAppsConn()
{

 Connection conOracle				= null;		
	try
  {
		Class.forName("oracle.jdbc.driver.OracleDriver");
    
    String url="jdbc:oracle:thin:@"+strServerName+":"+strPort+":"+strHostName;
		conOracle	= DriverManager.getConnection(url,strUser,strPwd);
    conOracle.setAutoCommit(true);
    return conOracle;
	
  }catch(Exception gExp)
  {
		return null;
	}
  
  }
%>
