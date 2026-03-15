<%@page import="org.apache.commons.fileupload.*,java.io.*, java.util.Iterator, java.util.List,java.sql.*, java.util.Vector,jxl.*,java.text.SimpleDateFormat" buffer = "none" %>

<%!
//DATABASE PARAMETERS........... Please set these parameters for creating Database Connection.

String strServerName="fcidev.fci.co.in";
String strPort="1525";
String strHostName="uat";
String strUser="apps";
String strPwd="apps";
//String strFilePath="//home//applmgr//crp2comn//html//";


//String strServerName="10.111.109.118";
//String strPort="1521";
//String strHostName="fcidb";
//String strUser="npcilhq";
//String strPwd="npcilhq";
String strFilePath="c://";
// DATABASE PARAMETERS Ending...............

%>

<%  
  
  String pFileType = request.getParameter("fileType")==null?"":request.getParameter("fileType");
  String pUnit = request.getParameter("unit")==null?"":request.getParameter("unit");
  String pNoofCols = request.getParameter("noofCols")==null?"":request.getParameter("noofCols");
  String pFileName = request.getParameter("fileName")==null?"":request.getParameter("fileName");  
  int indx=0;  
  if ((indx = pFileName.lastIndexOf('\\')) > 0) 
  {
    pFileName = pFileName.substring(indx+1, pFileName.length());
  }

%>


<html>
<HEAD><TITLE></TITLE>

<style>
.inv{
	font-family: Arial, Sans , Times New Roman ;
	font-size: 9pt ;
	color: black ;
	background-color: white ;
}

</style>

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
                <TD><img src="/OA_MEDIA/fndpbs.gif" border="0">
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

<table cellpadding="0" cellspacing="0" border="0" width="100%" summary="">
  <tr>
    <td width="100%" class="OraHeader">Output</td>
  </tr>
  <tr>
    <td class="OraBGAccentDark" height=1></td>
  </tr>
</table>

<body>

<FORM name="ExcelReaderOutput" action="" method="post">

<%
int maxMemSize			= 900000;
long maxReqSize			= 1000000000;
String tmpStr			= "";
int num	= 0;

java.sql.Statement stmt  = null;
ResultSet rs	= null;
String sql="";
String insertedFlag="Y";
java.sql.Statement stmtVal  = null;
String sqlVal="";

boolean isMultipart = FileUpload.isMultipartContent(request);
out.println("<p><font face=\"helvetica, arial, sans serif\"><h4>  ");
DiskFileUpload upload = new DiskFileUpload();

// Set upload parameters

upload.setSizeThreshold(maxMemSize);
upload.setSizeMax(maxReqSize);
upload.setRepositoryPath("c:/upload");

// Parse the request (FileItem)

List items = upload.parseRequest(request);
String value	="";
String name		="";

// Process the uploaded items

Iterator iter	= items.iterator();
String fileName = "";
Workbook workbook=null;
Sheet sheet=null;
String tableName = "";
Vector rowData  = new Vector();
Vector rowHeader  = new Vector();
String temp = "";
String tempRowData = "";
String tempFormatData = "";
String stmtNo="";
String rowFlag = "N";
int i;
int noOfColumn = 0;
int noOfRow = 10000;
int sheetCounter = 0;
int columnCounter = 0;
int rowCounter = 0;
String sqlOrgId="";
int stmt_No=0;
int sr_No=0;
String sqlStmtFunction="";

//Excel Reader//

int user_id							= 0; 
Connection conOracle				= null;	
// DaTaBase Connection....... Added by Balpreet dt 7 Jan 2008

%>

<%
//Creating DataBase Connection....... 

	try
  {
		Class.forName("oracle.jdbc.driver.OracleDriver");
    
    String url="jdbc:oracle:thin:@"+strServerName+":"+strPort+":"+strHostName;
    String dbURL=url+","+strUser+","+strPwd;
   // (request.getSession(true)).setAttribute("dbURL",(Object)dbURL);
		conOracle	= DriverManager.getConnection(url,strUser,strPwd);
    conOracle.setAutoCommit(false);
	
  }catch(Exception gExp)
  {
		out.println("<script>alert('Connection is Null')</script>");
		out.println("Exception in getting connection "+gExp);
		return;
	}
%>

<%
//  File Upload.....

  try
  {
    while (iter.hasNext()) 
    {
      FileItem item = (FileItem) iter.next();
        if (item.isFormField())
        {
          name = item.getFieldName();
	        value = item.getString();
	       // out.println(name);
         // out.println(value);
        }
        else if (item != null && (tmpStr = item.getName()) != null && tmpStr.length() > 0) 
        {
          if ((num = tmpStr.lastIndexOf('\\')) > 0) 
          {
	          tmpStr = tmpStr.substring(num+1, tmpStr.length());
          }
           File uploadedFile = new File(strFilePath+tmpStr);
	        item.write(uploadedFile);
       }
    }
    out.println("<font color=blue> File "+tmpStr+" Uploaded Sucessfully </font> <Br></Br>");
    fileName=strFilePath+tmpStr;
    File f=new java.io.File(fileName);
    
//   Code for Reading the excel file uploaded..... 
    try
    {
      workbook=Workbook.getWorkbook(f);
    //  for(sheetCounter=0;sheetCounter<20;sheetCounter++)  Commented by Balpreet dt 12 Jan 2008 -- not required for FCI we are assuming only one sheet is there..
    //  {
        sheet = null;
        tableName = "";        
        try
        {
          sheet=workbook.getSheet(0);
          try
          {
           // tableName="TCS_CE_STMT_LINES_TEMP";
            out.println("Start : Sheet Loading : <Br>");
            noOfColumn = 50;
						try
						{
							stmt = conOracle.createStatement();
							rowFlag="N";
              
              // Code for inserting data in TCS_CE_STMT_HEADER_TEMP
                /*for(rowCounter=0;rowCounter<7;rowCounter++)
								{
									try
									{
										tempRowData = sheet.getCell(1,rowCounter).getContents();
                    if(tempRowData==null)
                    {
                      tempRowData="";
                    }
                    else
                    {
                      tempRowData=tempRowData.trim();
                    }
										rowHeader.add(tempRowData);
									}
									catch(Exception e)
									{
											rowFlag = "Y";
											break;
									}
								}

								if(rowFlag.equals("Y"))
								{
									out.println("Error at "+(rowCounter)+" Header Field Value Please Check the Data <Br> ");						
									if((rowCounter)==0)// Added By Sandeep dwivedi
										out.println("<B> No Rows found in Sheet : <B> ");	
								}

//              This query Fetches org_id from the syatem.. This can vary depending on the Operationg units... 
//               for CRP 1
//                sqlOrgId="select a.organization_id organization_id from hr_all_organization_units a,hr_org_information_types_tl b,hr_organization_information c where a.name like 'FCI%' and a.organization_id=c.organization_id and b.org_information_type ='CLASS' and b.language='US'and c.org_information1='OPERATING_UNIT'";

//               for CRP2
                sqlOrgId="select a.organization_id organization_id from hr_all_organization_units a,hr_org_information_types_tl b,hr_organization_information c where a.name ='FCI_OU' and a.organization_id=c.organization_id and b.org_information_type ='CLASS' and b.language='US'and c.org_information1='OPERATING_UNIT'";
								try
								{
                  rs=stmt.executeQuery(sqlOrgId);
                  if(rs.next())
                  {
                    oID=rs.getString("organization_id");
                  }
								}
								catch(Exception e)
								{
                  insertedFlag="N";
									out.println("<font color=red> DataBase Error "+e+" </font><Br>");
								}

								String acc_No=(String)rowHeader.get(1);
								sqlStmtFunction="Select fci_get_statement_num("+acc_No+") stmt_no from dual";
								//out.println(sql);
								try
								{
									rs=stmt.executeQuery(sqlStmtFunction);
									if(rs.next())
					                {
					                    stmt_No=rs.getInt("stmt_No");
					                }
									sql = "insert into TCS_CE_STMT_HEADERS_TEMP (STATEMENT_NUMBER,S_DATE ,ACC_NO ,ACC_DESC ,BRANCH ,OPENING_BAL ,START_DATE,END_DATE ,ORG_ID) "+
                        					"values ("+stmt_No+",to_date('"+(String)rowHeader.get(0)+"','dd-mon-yy'),'"+acc_No+"','"+(String)rowHeader.get(2)+"','"+(String)rowHeader.get(3)+"','"+((String)rowHeader.get(4)).replaceAll(",","")+"',to_date('"+(String)rowHeader.get(5)+"','dd-mon-yy'),to_date('"+(String)rowHeader.get(6)+"','dd-mon-yy'),'" + oID + "') ";
								
                 stmt.executeUpdate(sql);
								}
								catch(Exception e)
								{
                  insertedFlag="N";
                  conOracle.rollback();
									out.println("<font color=red> DataBase Error "+e+" for Header Field at "+(rowCounter+1)+" Row </font><Br>");
								}*/
						
                
              // Code for reading records to be inserted TCS_CE_STMT_LINES_TEMP table.
							for(rowCounter=0;rowCounter<noOfRow;rowCounter++)
							{
								rowData.clear();
								for(columnCounter=0;columnCounter<noOfColumn;columnCounter++)
								{
									try
									{
										
                    String strformat=sheet.getCell(columnCounter,rowCounter).getType().toString();
                    if(strformat.equals("Date"))
                    {
                      tempRowData=(new SimpleDateFormat("dd-MMM-yyyy")).format(((DateCell)sheet.getCell(columnCounter,rowCounter)).getDate());
                    }else
                    {
                      tempRowData = sheet.getCell(columnCounter,rowCounter).getContents();
                      tempRowData=tempRowData.replaceAll("'","''");
                    }
                    if(tempRowData==null)
                    {
                      if(columnCounter==0)
                      {
                          rowFlag = "Y";
                          break;
                      }
                      else
                      {
                        tempRowData="";
                      }
                    }
                    else
                    {
                      tempRowData=tempRowData.trim();
                    }
                    
										rowData.add(tempRowData);
                    
									}
									catch(Exception e)
									{
										if(columnCounter==0)
										{
											rowFlag = "Y";
											break;
										}
										else
										{
											tempRowData="";
                      rowData.add(tempRowData);
										}
									}
								}

								if(rowFlag.equals("Y"))
								{
									out.println("Scanned "+(rowCounter)+" Data Rows <Br> ");						
									if((rowCounter)==0)
										out.println("<B> No Rows found in Sheet :" + (sheetCounter+1) + "<B> ");	
									break;
								}

                //String refNo=(String)rowData.get(3);
                //refNo=refNo.replaceAll("-","");
                //refNo=refNo.replaceAll("/","");
                //if(uTyp.equals("F"))
                //{
                  sr_No=rowCounter+1;
                  sql = "insert into FCI_EXL_DATA_UPLOAD (SR_NO,FILE_TYPE ,UNIT ,FILE_NAME ,NO_OF_COLS ,ATTRIB_1,ATTRIB_2, ATTRIB_3, ATTRIB_4, ATTRIB_5, ATTRIB_6, ATTRIB_7, ATTRIB_8, ATTRIB_9, ATTRIB_10, ATTRIB_11, ATTRIB_12, ATTRIB_13, ATTRIB_14, ATTRIB_15, ATTRIB_16, ATTRIB_17, ATTRIB_18, ATTRIB_19, ATTRIB_20, ATTRIB_21, ATTRIB_22, "+
                        " ATTRIB_23, ATTRIB_24, ATTRIB_25, ATTRIB_26, ATTRIB_27, ATTRIB_28, ATTRIB_29, ATTRIB_30, ATTRIB_31, ATTRIB_32, ATTRIB_33, ATTRIB_34, ATTRIB_35, ATTRIB_36, ATTRIB_37, ATTRIB_38, ATTRIB_39, ATTRIB_40, ATTRIB_41, ATTRIB_42, ATTRIB_43, ATTRIB_44,ATTRIB_45, ATTRIB_46, ATTRIB_47, ATTRIB_48, ATTRIB_49,ATTRIB_50)"+
                        "values ('"+sr_No+"','" + pFileType + "' ,'" + pUnit + "', '" + pFileName + "','" + pNoofCols +"', '"+(String)rowData.get(0)+"','"+(String)rowData.get(1)+"', '"+(String)rowData.get(2)+"', '"+(String)rowData.get(3)+"' ,'"+(String)rowData.get(4)+"' ,'"+(String)rowData.get(5)+"',"+
                        " '"+(String)rowData.get(6)+"', '" +(String)rowData.get(7) + "', '"+(String)rowData.get(8)+"', '"+(String)rowData.get(9)+"', '" +(String)rowData.get(10) + "', '"+(String)rowData.get(11)+"', '"+(String)rowData.get(12)+"', '" +(String)rowData.get(13) + "', '"+(String)rowData.get(14)+"', "+ 
                        " '"+(String)rowData.get(15)+"', '" +(String)rowData.get(16) + "', '"+(String)rowData.get(17)+"', '"+(String)rowData.get(18)+"', '" +(String)rowData.get(19) + "', '"+(String)rowData.get(20)+"', '"+(String)rowData.get(21)+"', '" +(String)rowData.get(22) + "', '"+(String)rowData.get(23)+"', "+ 
                        " '"+(String)rowData.get(24)+"', '" +(String)rowData.get(25) + "', '"+(String)rowData.get(26)+"', '"+(String)rowData.get(27)+"', '" +(String)rowData.get(28) + "', '"+(String)rowData.get(29)+"', '"+(String)rowData.get(30)+"', '" +(String)rowData.get(31) + "', '"+(String)rowData.get(32)+"', "+ 
                        " '"+(String)rowData.get(33)+"', '" +(String)rowData.get(34) + "', '"+(String)rowData.get(35)+"', '"+(String)rowData.get(36)+"', '" +(String)rowData.get(37) + "', '"+(String)rowData.get(38)+"', '"+(String)rowData.get(39)+"', '" +(String)rowData.get(40) + "', '"+(String)rowData.get(41)+"', "+ 
                        " '"+(String)rowData.get(42)+"', '" +(String)rowData.get(43) + "', '"+(String)rowData.get(44)+"', '"+(String)rowData.get(45)+"', '" +(String)rowData.get(46) + "', '"+(String)rowData.get(47)+"', '"+(String)rowData.get(48)+"', '" +(String)rowData.get(49)+"') ";
                        

				  out.println(sql);
								
               /* }else
                {
                  sql = "insert into TCS_CE_STMT_LINES_TEMP (STATEMENT_NUMBER,LINE_NUMBER ,TRX_DATE ,VALUE_DATE ,DESCRIPTION ,REFERENCE_NO,DEBIT ,CREDIT ,BALANCE ,ORG_ID,ACC_NO,BR_CODE) "+
                       "values ("+stmt_No+","+(rowCounter-7)+",to_date('"+(String)rowData.get(0)+"','dd/mm/yyyy'),to_date('"+(String)rowData.get(1)+"','dd/mm/yyyy'),'"+(String)rowData.get(2)+"','"+refNo.trim()+"','"+(String)rowData.get(4)+"','"+(String)rowData.get(5)+"','"+(String)rowData.get(6)+"','" + oID + "','"+(String)rowHeader.get(1)+"','"+(String)rowData.get(7)+"') ";*/                
               //   sql = "insert into TCS_CE_STMT_LINES_TEMP (STATEMENT_NUMBER ,LINE_NUMBER ,TRX_DATE ,VALUE_DATE ,DESCRIPTION ,REFERENCE_NO,DEBIT ,CREDIT ,BALANCE ,ORG_ID,ACC_NO) "+
                 //        "values ("+ sID + ","+(rowCounter-7)+",to_date('"+(String)rowData.get(0)+"','dd/mm/yyyy'),to_date('"+(String)rowData.get(1)+"','dd/mm/yyyy'),'"+(String)rowData.get(2)+"','"+refNo+"','"+(String)rowData.get(4)+"','"+(String)rowData.get(5)+"','"+(String)rowData.get(6)+"','" + oID + "','"+(String)rowHeader.get(1)+"') ";                

                
                //out.println(sql);
								try
								{
								//	stmt.addBatch(sql);
                  stmt.executeUpdate(sql);
								}
								catch(Exception e)
								{
                  insertedFlag="N";
                  conOracle.rollback();
									out.println("<font color=red> DataBase Error "+e+" for Row Number "+(rowCounter+1)+"</font><Br>");
								}
							}
              
              stmt.close();
						}
						catch(Exception e)
            {
							insertedFlag="N";
              conOracle.rollback();
							out.println("<font color=red>Database Error "+e+"</font><Br>");
						}
          }
          catch(Exception e)
          {
            insertedFlag="N";
            out.println("Could Not Process for "+(sheetCounter+1)+" Worksheet <Br>");
          }
          out.println("Finish : Sheet Loading <Br><Br>");
        }
        catch(Exception e)
        {
         // out.println("No more Worksheet, Processed Successfully for "+sheetCounter+" Worksheet<Br>");
        }
   //   }  End of For Loop
    }
    catch(Exception e)
    {
      insertedFlag="N";   
      out.println("Can not open File "+fileName+" "+e+"<Br>");
    } 
  }
  catch(Exception e)
  {	
    insertedFlag="N";   
    out.println("Exception "+e+"<Br>");
  }
%>
<%

	try
	{
		String commandToRun = "//bin//rm "+fileName;
		Process list		= Runtime.getRuntime().exec(commandToRun);
		int w = list.waitFor();
		InputStream is = list.getErrorStream();
		byte[] b = new byte[5000];
		is.read(b);
		String s = new String(b);
		if((s!=null)||(!s.equals("")))
		{
			out.println(s);
		}
		if((w==0)||(w==2))
		{
		//	out.println("<Br><Br><font color=green> File Sucessfully  gets purged  From Server </font>");
		}
	}
	catch(Exception e)
	{

		//insertedFlag ="N";
		out.println("Error here "+e);
	}

%>

<INPUT TYPE="hidden" size="13" NAME="oID" value =''>
<INPUT TYPE="hidden" size="13" NAME="sID" value =''>
<INPUT TYPE="hidden" size="13" NAME="utype" value =''>
<INPUT TYPE="hidden" size="13" NAME="fileType" value ='<%=pFileType%>'>
<INPUT TYPE="hidden" size="13" NAME="unit" value ='<%=pUnit%>'>
<INPUT TYPE="hidden" size="13" NAME="fileName" value ='<%=pFileName%>'>
<INPUT TYPE="hidden" size="13" NAME="noofCols" value ='<%=pNoofCols%>'>

</body>
<%

if(insertedFlag.equals("N"))
{
       try
        {	
        conOracle.rollback();
        /*  stmt = conOracle.createStatement();
          int recDeleted =stmt.executeUpdate("delete from TCS_CE_STMT_HEADERS_TEMP where STATEMENT_NUMBER=tcs_auto_statement_no.CURRVAL");
          recDeleted =stmt.executeUpdate("delete from TCS_CE_STMT_LINES_TEMP where STATEMENT_NUMBER=tcs_auto_statement_no.CURRVAL");
*/
        }catch(Exception e)
        {
          out.println("Error here "+e);
        }

%>

<script>

alert('Error in inserting data into fci_exl_data_upload table !!!\n Please rectify the Error and retry...');

alert('Please rectify the Error and retry...');

document.ExcelReaderOutput.action = "tcs_excelReaderInput.jsp?oID=" + document.ExcelReaderOutput.oID.value + "&utype=" +  document.ExcelReaderOutput.utype.value+ "&sID=" +  document.ExcelReaderOutput.sID.value;

document.ExcelReaderOutput.submit();

</script>

<%

}

else

{
    conOracle.commit();
	%>
	<script>

		alert('Records got inserted into fci_exl_data_upload table')

	//document.ExcelReaderOutput.action = "tcs_cash_management_validation.jsp?oID=" + document.ExcelReaderOutput.oID.value+ "&utype=" +  document.ExcelReaderOutput.utype.value+ "&sID=" +  document.ExcelReaderOutput.sID.value;
	//document.ExcelReaderOutput.submit();

	</script>

		<%
	//}
 }

%>

</form>

</html>