<html>

</table>

<HEAD><TITLE></TITLE>
<body bgcolor="#D9EEF9">
<!---  Code for inserting Oracle Logo -->

<table cellpadding="2" cellspacing="2" border="0" width="100%" summary="">
  <tr height="10">
      <td></td>
  </tr>
    <tr ><td width="100%" align="center" ><h3><font face="Verdana"> REPORT PROBLEM</font></h3></td>
    <!--<td align="right"  class="OraHeader">&nbsp;<a href="migration_excel_aboutTheRep.jsp" class="DLnk" target="_new""><b>Help</b></a> </td>-->
    </tr>    
    
</table>


<form name="frm" method="get" action="successpg.jsp" >
  <table border ="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#D9EEF9">
  
    <tr>
    <td width="40%" align="right"><font face="Verdana" size="2">User Name </font></td>
    <td width="1%">&nbsp;</td>
    <td><input type = "text" name = "userName" size="23" style="background-color:'ffffd3'"></td>
    </tr>
    
    <tr>
    <td align="right"><font face="Verdana" size="2">Location</font></td>
    <td width="1%">&nbsp;</td>
    <td><input type = "text" name = "userLoc" size="23" style="background-color:'ffffd3'" ></td>
    </tr>
    
    <tr>
    <td align="right"><font face="Verdana" size="2">Problem Descrption</font></td>
    <td width="1%">&nbsp;</td>
    <td><textarea name = "prblmDesc" rows="3" cols="30" style="background-color:'ffffd3'"></textarea></td>
    </tr>
    
    <tr>
    <td align="right"><font face="Verdana" size="2">Severity</font></td>
    <td width="1%">&nbsp;</td>
    <td><select name="severity" >
      <option value="low">Normal</option>
      <option value="high">High</option>
    </select></td>
    </tr>
    
    <tr height="50" valign="bottom" >
    <td colspan="3" align="center">
    <input type="button" name="save" value="Save" onClick="saverecord()" >
    <td/>
    
    </tr>
    
  </table>
</form>
</body>
</html>

<script>
function saverecord()
{
  if(document.all.userName.value==''|| document.all.prblmDesc.value==''|| document.all.userLoc.value=='')
  {
    alert("Mandatory Fields empty");
    return false;
  }
 document.frm.submit();
 return true;
}

</script>

