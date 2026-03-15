	<script language="javaScript">	

		function Submission()
		{		

			  document.frm.action="./tcs_cash_management_ExcelReaderOutput.jsp?oID=" + document.frm.oID.value + "&sID=" +  document.frm.sID.value;
			  document.frm.submit();
			  return(true);	
				
		}
	</script>

<%
  String oID = request.getParameter("oID")==null?"":request.getParameter("oID");
  String sID = request.getParameter("sID")==null?"":request.getParameter("sID");
 // DBConnection dbcon=new DBConnection();
 // dbcon.getConnection();
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



<table cellpadding="0" cellspacing="0" border="0" width="100%" summary="">

<tr>

<td rowspan="2"><img src="/OA_HTML/cabo/images/cache/c-ghss.gif" alt="" width="9" height="35"></td>

<td rowspan="2" style="background-image:url(/OA_HTML/cabo/images/cache/c-ghsc.gif);">&nbsp;</td>

<td rowspan="2"><img src="/OA_HTML/cabo/images/cache/c-ghse.gif" alt="" width="33" height="35"></td>

<td rowspan="2" width="100%" style="background-image:url(/OA_HTML/cabo/images/cache/c-ghc.gif);">&nbsp;</td>

<td valign=top><img src="/OA_HTML/cabo/images/cache/c-ghe.gif" alt="" width="5" height="15"></td>

</tr>

</table>



<table cellpadding="0" cellspacing="0" border="0" width="100%" summary="">

<tr><td width="100%" class="OraHeader"> Migration : Upload Excel File</td>
<td align="right"  class="OraHeader">&nbsp;<a href="migration_excel_aboutTheRep.jsp" class="DLnk" target="_new""><b>Help</b></a> </td>
</tr>

<tr><td class="OraBGAccentDark" height=1></td></tr>

</table>



<body>

<form name="frm" action="" scope="request" enctype="multipart/form-data"  method="post" >

<INPUT TYPE="hidden" size="13" NAME="oID" value ='<%=oID%>'>
<INPUT TYPE="hidden" size="13" NAME="sID" value ='<%=sID%>'>

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

