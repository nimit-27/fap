<%@page import="" buffer = "none" %>


	<script language="javaScript">	

		function Submission()
		{		

			  document.frm.action="./tcs_excelReaderOutput.jsp?fileType=" + document.frm.fileType.value +"&unit=" + document.frm.unit.value+"&noofCols="+document.frm.noofCols.value+ "&fileName="+ document.frm.fileName.value;
			  document.frm.submit();
			  return(true);	
				
		}
	</script>




<html>

</table>

<HEAD><TITLE></TITLE>

<style>

.inv{

	font-family: Arial, Sans , Times New Roman ;

	font-size: 10pt ;

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

<table cellpadding="0" cellspacing="0" border="0" width="100%" summary="">
	<tr height="50">
		<td width="100%" class="OraHeader" align="center"> <b><h3> Migration : Upload Excel File</h1></b></td>
		<!--<td align="right"  class="OraHeader">&nbsp;<a href="migration_excel_aboutTheRep.jsp" class="DLnk" target="_new""><b>Help</b></a> </td>-->
	</tr>
	<tr>
		<td class="OraBGAccentDark" height=1></td>
	</tr>
</table>

<body>

<form name="frm" action="" scope="request" enctype="multipart/form-data"  method="post" >

<INPUT TYPE="hidden" size="13" NAME="oID" value =''>
<INPUT TYPE="hidden" size="13" NAME="utype" value =''>

<table width="100%" border ="0" colspan=1 cellpadding=2 >	
	<tr>
		<td align="right">Select the file type:</td>	
		<td>
		<select name="fileType" style="background-color:#FFFFCC;" size="1">
		<option value="">----Please Select-----</option>
		<option value="ASSETS">Assets</option>
		<option value="BANKS">Banks</option>
		<option value="CUSTOMER">Customer</option>
		<option value="CUSTOMER INVOICES">Customer Invoices</option>
		<option value="SUPPLIER">Supplier</option>
		<option value="SUPPLIER INVOICES">Supplier Invoices</option>		
		<option value="TRIAL BALANCE">Trial Balance</option>		
		</select>
		</td>
	</tr>
	<tr>
		<td align="right">Unit:</td>
		<td>
		<input type="text" style="background-color:#FFFFCC;" name="unit" size="10" value=""> 
		</td>
	</tr>
	<tr>
		<td align="right">No of Columns:</td>
		<td>
		<input type="text" name="noofCols" size="10" value=""> 
		</td>
	</tr>
	<tr>
		<td align="right">Excel File Name :</td>
		<!-- <input type="text" name="fileName" > -->
		<td><input type = "file" style="background-color:#FFFFCC;" name = "fileName" size="30" accept="text/csv" >
		</td>
		
	</tr>

	
	<tr height="50">
		<td>&nbsp;</td>
		<td align="left"><input type="Button" name="uploadButton" value="Upload" onClick="javaScript:upload_file()" >
		<td/>		
	</tr>
</table>
</form>
</body>
</html>
<script>

function upload_file()
{
    if(document.frm.fileType.value=="")
    {
      alert('File Type is Mandatory');
      document.frm.fileType.focus();
      return;
    }
    
    if(document.frm.unit.value=="")
    {
      alert('Unit is Mandatory');
      document.frm.unit.focus();
      return;
    }
    
    if(document.frm.fileName.value=="")
    {
      alert('Please Browse the Excel sheet for uploading');
      return;
    }
    
    
    document.frm.uploadButton.disabled=true;
    Submission();
    //document.frm.submit();

}

</script>

 