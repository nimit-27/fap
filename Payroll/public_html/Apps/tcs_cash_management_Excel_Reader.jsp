<%@page import="" buffer = "none" %>


	<script language="javaScript">	

		function Submission()
		{		

			  document.frm.action="./tcs_cash_management_ExcelReaderOutput.jsp?oID=" + document.frm.oID.value +"&utype=" +  document.frm.utype.value;
			  document.frm.submit();
			  return(true);	
				
		}
	</script>

<%
  String oID = request.getParameter("oID")==null?"":request.getParameter("oID");
  String sID = request.getParameter("sID")==null?"":request.getParameter("sID");
  String uTyp = request.getParameter("utype")==null?"":request.getParameter("utype");
%>


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

<tr><td width="100%" class="OraHeader"> Migration : Upload Excel File</td>
<!--<td align="right"  class="OraHeader">&nbsp;<a href="migration_excel_aboutTheRep.jsp" class="DLnk" target="_new""><b>Help</b></a> </td>-->
</tr>

<tr><td class="OraBGAccentDark" height=1></td></tr>

</table>



<body>

<form name="frm" action="" scope="request" enctype="multipart/form-data"  method="post" >

<INPUT TYPE="hidden" size="13" NAME="oID" value ='<%=oID%>'>
<INPUT TYPE="hidden" size="13" NAME="utype" value ='<%=uTyp%>'>

<table border ="0">

<tr>

<td>

Excel File Name :

</td>

<td>

<!-- <input type="text" name="fileName" > -->

<input type = "file" name = "fileName" accept="text/csv" >

</td>
<td>

&nbsp;

</td>
</tr>

<tr >

<td> </td> <td>


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="Button" name="uploadButton" value="Upload" onClick="javaScript:upload_file()" >

<td/>

</tr>

</table>







</form>





</body>



</html>



<script>

function upload_file()
{

	   if(document.frm.fileName.value=="")
      {
      alert('Please Brows the Excel sheet for uploading');
      return;
     }
 document.frm.uploadButton.disabled=true;
 Submission();
 //document.frm.submit();

}

</script>

