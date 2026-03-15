<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Holiday Master
</title>
<html:base />
<iframe ID="hiddenFrame" NAME="pri" WIDTH="0" HEIGHT="0"></iframe>
<script language="javascript"  src="../../COMMON/JavaScript/validate.js" ></script>
<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_func.js" ></script>
<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_addins.js" ></script>
<script language="JavaScript"  src="../../COMMON/JavaScript/calendar1.js" ></script>
<link rel="STYLESHEET"  type="text/css"  href="../../COMMON/CSS/Menucss.css" >
<link rel ="stylesheet" href ="../../COMMON/CSS/IBA.css" >
<%
response.setHeader("cache-Control","max-age=0"); 
response.setHeader("cache-Control","no-store");
response.setHeader("Pragma","no-cache");
%>
<head>
<script> 

if (document.all)
{
    document.onkeydown = function ()
	{
        var key_f5 = 116;
		if (event.keyCode == key_f5)
		{
			event.keyCode = 0;
            return false;
		}
		return true;
	}    
}

function showMode()
{
   if(frmHolidayMaster.saction.value == "PreLoad_Check")
   {
      frmHolidayMaster.butEdit.disabled = true; 
      frmHolidayMaster.lstUnitName.focus();
   }
   if(frmHolidayMaster.saction.value == "Query") 
   {
      if(frmHolidayMaster.queryFlag.value == "true")
      {
         frmHolidayMaster.lstUnitName.disabled=true;
         frmHolidayMaster.weekly_Off_1.disabled=true;
         frmHolidayMaster.weekly_Off_2.disabled=true;
         frmHolidayMaster.butEdit.disabled = true;
         frmHolidayMaster.queryFlag.value = false;
         var oTable=document.getElementById("idTable");
         var rowLength=oTable.rows.length;
         for(i=0; i<eval(rowLength)-1; i++)
         {
             document.getElementsByName("holiday_Name")[i].disabled=true;
             document.getElementsByName("holiday_Date")[i].disabled=true;
             document.getElementsByName("chkDeleteRow")[i].disabled=true;
         }
      }
      else
        frmHolidayMaster.butEdit.disabled = false;
        
      frmHolidayMaster.butInsert.disabled = true;
   }
   if(frmHolidayMaster.saction.value == "Reset")
   {
      frmHolidayMaster.butEdit.disabled=true;
      frmHolidayMaster.butInsert.disabled=false;
   }
   if(frmHolidayMaster.saction.value == "Insert")
   {
      frmHolidayMaster.lstUnitName.disabled=true;
      frmHolidayMaster.weekly_Off_1.disabled=true;
      frmHolidayMaster.weekly_Off_2.disabled=true;
      frmHolidayMaster.lstYear.disabled=true;
      var oTable=document.getElementById("idTable");
      var rowLength=oTable.rows.length;
      for(i=0; i<eval(rowLength)-1; i++)
      {
         document.getElementsByName("holiday_Name")[i].disabled=true;
         document.getElementsByName("holiday_Date")[i].disabled=true;
         document.getElementsByName("chkDeleteRow")[i].disabled=true;
      }
      frmHolidayMaster.butAddRow.disabled=true;   
      frmHolidayMaster.butEdit.disabled=true;
   }
   return;
}

function lfnHolidayNameCheck(tempHolidayName, tempTitle)
{
  var flag = 0;
  var oTable=document.getElementById("idTable");
  var rowLength=oTable.rows.length;
  if(rowLength > 2)
  {
    for(i=0; i<eval(rowLength)-1; i++)
    {
      if(i != tempTitle)
      {
        if((tempHolidayName != "") && (tempHolidayName == document.getElementsByName("holiday_Name")[i].value))
        {
          alert("Holiday Name already exist");
          document.getElementsByName("holiday_Name")[tempTitle].focus();
          flag = 1;
        }
      }
    if(flag == 1)
      break;
    }
  }
}

function checkYear(tempDate, tempTitle)
{  
  var oTable=document.getElementById("idTable");
  var rowLength=oTable.rows.length;
  if(frmHolidayMaster.smode.value == "")
  {
    if((tempDate != "") && (frmHolidayMaster.lstYear.value != ""))
    {
       index = tempDate.lastIndexOf("/");
       tempYear = tempDate.substr(eval(index+1),4);
       if(tempYear != frmHolidayMaster.lstYear.value)
       {
          alert("The 'year' of the Holiday Date field should match to the 'year' in the Year field");
          document.getElementsByName("holiday_Date")[tempTitle].focus();
       }
    }
  }
  if(frmHolidayMaster.smode.value == "getRecord")
  {
    tempDate1 = frmHolidayMaster.lstYear.options[frmHolidayMaster.lstYear.selectedIndex].text;
    index1 = tempDate1.lastIndexOf("-");
    tempYear1 = tempDate1.substr(eval(index1+1),4);
    if((tempDate != "") && (frmHolidayMaster.lstYear.value != ""))
    {
      index0 = tempDate.lastIndexOf("/");
      tempYear0 = tempDate.substr(eval(index0+1),4);
      if(tempYear0 != tempYear1)
      {
         alert("The 'year' of the Holiday Date field should match to the 'year' in the Year field");
         document.getElementsByName("holiday_Date")[tempTitle].focus();
      }
    }
  }
}

function lfnCheckDate(tempHolidayDate, tempTitle)
{
  var flag = 0;
  var oTable=document.getElementById("idTable");
  var rowLength=oTable.rows.length;
  if(rowLength > 2)
  {
    for(i=0; i<eval(rowLength)-1; i++)
    {
      if(i != tempTitle)
      {
        if(dateDiff(tempHolidayDate, document.getElementsByName("holiday_Date")[i].value) == 0)
        {
          alert("Holiday Date already exist");
          document.getElementsByName("holiday_Date")[tempTitle].focus();
          flag = 1;
        }
      }
    if(flag == 1)
      break;
    }
  }
}

function getRecord()
{ 
   if((frmHolidayMaster.saction.value == "Query") || (frmHolidayMaster.saction.value == "Edit"))
   {
      frmHolidayMaster.saction.value = "getRecord";
      frmHolidayMaster.submit();
   }
   return;
}

function clickQuery()
{
   frmHolidayMaster.saction.value="Query";
   frmHolidayMaster.submit();
   return;
}

function clickInsert()
{
   var flag = 0;
   var tempWeeklyOff1, tempWeeklyOff2;
   frmHolidayMaster.saction.value="Insert";
   frmHolidayMaster.tempYear.value=frmHolidayMaster.lstYear.value;
   tempWeeklyOff1=frmHolidayMaster.weekly_Off_1.value;
   tempWeeklyOff2=frmHolidayMaster.weekly_Off_2.value;
   if((tempWeeklyOff2 == tempWeeklyOff1)&&(tempWeeklyOff1 != ""))
   {
      alert("Please select Weekly Off 2 different from Weekly Off 1");
      return;
   }
   if(mandatory_Check(frmHolidayMaster))
   {
      var oTable=document.getElementById("idTable");
      var rowLength=oTable.rows.length;
      for(i=0; i<eval(rowLength)-1; i++)
      {      
        tempDate = change_DateFormat(document.getElementsByName("holiday_Date")[i].value);
        index = tempDate.lastIndexOf("/");
        tempYear = tempDate.substr(eval(index+1),4);
        if(tempYear != frmHolidayMaster.lstYear.value)
        {
          alert("The 'year' of the Holiday Date field should match to the 'year' in the Year field");
          document.getElementsByName("holiday_Date")[i].focus();
          flag = 1;
          break;
        }
      }
      if(flag == 0)
      frmHolidayMaster.submit();
   }
   return;
}

function clickReset()
{
   frmHolidayMaster.saction.value = "Reset";
   frmHolidayMaster.submit();
   return;
}

function clickEdit()
{
   var flag = 0;
   frmHolidayMaster.saction.value = "Edit";
   tempWeeklyOff1=frmHolidayMaster.weekly_Off_1.value;
   tempWeeklyOff2=frmHolidayMaster.weekly_Off_2.value;   
   if((tempWeeklyOff2 == tempWeeklyOff1)&&(tempWeeklyOff1 != ""))
   {
      alert("Please select Weekly Off 2 different from Weekly Off 1");
      return;
   }   
   if(mandatory_Check(frmHolidayMaster))
   {
      tempDate1 = frmHolidayMaster.lstYear.options[frmHolidayMaster.lstYear.selectedIndex].text;
      index1 = tempDate1.lastIndexOf("-");
      tempYear1 = tempDate1.substr(eval(index1+1),4);    
      var oTable=document.getElementById("idTable");
      var rowLength=oTable.rows.length;
      for(i=0; i<eval(rowLength)-1; i++)
      {
        tempDate = change_DateFormat(document.getElementsByName("holiday_Date")[i].value);
        index = tempDate.lastIndexOf("/");
        tempYear = tempDate.substr(eval(index+1),4);
        if(tempYear != tempYear1)
        {
          alert("The 'year' of the Holiday Date field should match to the 'year' in the Year field");
          document.getElementsByName("holiday_Date")[i].focus();
          flag = 1;
          break;
        }
      }
      if(flag == 0)
        frmHolidayMaster.submit();
    }  
    return;
}

function lfnLoad()
{  
   if (frmHolidayMaster.sload.value != "Loaded")
   {  
      frmHolidayMaster.saction.value = "PreLoad_Check";
      frmHolidayMaster.submit();
   }
} 

function chkDeletion(value)
{
   var oTable = document.getElementById("idTable");
   var oTR = document.createElement("TR");
   var iTR = oTable.rows.length;
   if (value==true)
    alert('This Row  has been marked for deletion');
    
   for(i=0; i<iTR-1; i++)
   {
      if(document.getElementsByName("chkDeleteRow")[i].checked)
          document.getElementsByName("scheck")[i].value="D";
      else
          document.getElementsByName("scheck")[i].value="A";  
   }
}
        
function popYear()
{
   var j=-3, index, len, current_date, current_year;
   current_date = getSysDate();
   len = current_date.length;
   index = current_date.lastIndexOf("/");
   current_year = current_date.substr(eval(index+1),4);
   if((frmHolidayMaster.saction.value == "Query") || (frmHolidayMaster.saction.value == "getRecord") || (frmHolidayMaster.saction.value == "Edit"))
      return;
   frmHolidayMaster.lstYear.options[0]=new Option("Please Select","",false,false);   
   for(i=1;i<8;i++)
   {
     frmHolidayMaster.lstYear.options[i]=new Option(eval(current_year)+j,eval(current_year)+j,false,false);
     j++;
   }
   if (frmHolidayMaster.tempYear.value!="" && frmHolidayMaster.saction.value == "Insert")
   {
     frmHolidayMaster.lstYear.value=frmHolidayMaster.tempYear.value;
   }
   return;
}

function deleteLastEmptyRow()
{
    var oTable = document.getElementById("idTable");
    var rowLength = oTable.rows.length;

    if((frmHolidayMaster.iaddRowLen.value != 0) && (document.getElementsByName("holiday_Name")[rowLength-2].value == "") && (document.getElementsByName("holiday_Date")[rowLength-2].value == ""))
    {
        frmHolidayMaster.iaddRowLen.value--;
        oTable.deleteRow(eval(rowLength)-1);
    }
    else
        alert("No added 'last empty row' for deletion");

/*    if(rowLength == 1)
        alert("No rows for removal");
    else if((frmHolidayMaster.saction.value == "PreLoad_Check") && (rowLength == 2) && (document.getElementsByName("holiday_Name")[rowLength-2].value == "") && (document.getElementsByName("holiday_Date")[rowLength-2].value == ""))
        alert("Removal of this row is not allowed");
    else if((((frmHolidayMaster.saction.value == "Query") || (frmHolidayMaster.saction.value == "Edit"))&& (document.getElementsByName("holiday_Name")[rowLength-2].value == "") && (document.getElementsByName("holiday_Date")[rowLength-2].value == "")) || ((rowLength > 2) && (document.getElementsByName("holiday_Name")[rowLength-2].value == "") && (document.getElementsByName("holiday_Date")[rowLength-2].value == "")))
        oTable.deleteRow(eval(rowLength)-1);
    else
        alert("No last empty row for deletion");*/
}

function addRow()
{  
  var flag=0;
  var oTable=document.getElementById("idTable");
  var oTR=document.createElement("TR");
  var rowLength=oTable.rows.length;
  var noOfColumns=4;
  var noOfElements=(rowLength-2)*noOfColumns+4;
  var iTR = oTable.rows.length;

  if((rowLength == 1) && (frmHolidayMaster.lstYear.value == ""))
  {
    alert("Please select from the 'Year' field for the rows to be added");
    flag = 1;
  }  
  else if(rowLength > 1)
  {
      for(i=noOfElements; i<eval(noOfElements+noOfColumns); i++)
      {
         if ((document.frmHolidayMaster.elements[i].className=="required") && (document.frmHolidayMaster.elements[i].value=="")) 
            {
                 alert("Additon of row is not allowed until the previous row is filled");
                 document.frmHolidayMaster.elements[i].focus();
                 flag=1;
                 break;
            }
      }
  }

  if(flag==0)
  {
    if(rowLength == 1)
    {
        frmHolidayMaster.iaddRowLen.value++;
        frmHolidayMaster.saction.value = "addZerothRow";
        frmHolidayMaster.submit();        
    }
    if(rowLength > 1)
    {
      if(document.getElementsByName("holiday_Name")[0].length == (rowLength))
      {
        alert("All the Holiday Names have been added to the Holiday Details");
      }
      else
      {
        frmHolidayMaster.iaddRowLen.value++;
        
        var oTD = oTR.appendChild(document.createElement("TD"));
        oTD.innerHTML="<select align='center' name='holiday_Name'  onblur='lfnHolidayNameCheck(this.value, this.title);' class='required'></select>";

        var oTD = oTR.appendChild(document.createElement("TD"));
        oTD.innerHTML="<center> <input name='holiday_Date' size='20' maxlength='20' onblur='if(date_Check(this.value)) {checkYear(change_DateFormat(this.value), this.title); lfnCheckDate(this.value, this.title);}' class='required'/>&nbsp;<img name='img1"+ iTR +"' src='../../COMMON/Images/cal.gif' width='16' height='16' border='1' alt='Click Here' onClick='OpenCalender(holiday_Date[" + eval(iTR-1)+ "])' class='required'> </center>";
     
        var oTD = oTR.appendChild(document.createElement("TD"));
        oTD.innerHTML="<center> <input type='checkbox' align='center' name='chkDeleteRow' onclick='chkDeletion(this.checked);' /> <input type='hidden' name='scheck' value='A'/> </center>";
        oTable.tBodies[0].appendChild(oTR);

        for(i=0;i<document.getElementsByName("holiday_Name")[0].length;i++)
           {
              document.getElementsByName("holiday_Name")[rowLength-1].options[i] = new Option(document.getElementsByName("holiday_Name")[0].options[i].text, document.getElementsByName("holiday_Name")[0].options[i].value, false, false);
           }
        document.getElementsByName("holiday_Name")[rowLength-1].title=rowLength-1;   
        document.getElementsByName("holiday_Date")[rowLength-1].title=rowLength-1;
        document.getElementsByName("chkDeleteRow")[rowLength-1].title=rowLength-1;
        document.getElementsByName("holiday_Name")[rowLength-1].focus();
      }
    }
  }
  return;
}
</script>
</head>
<body bgcolor="white" onload="lfnLoad(); showMode(); popYear();">
   <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
   <html:form name="frmHolidayMaster" method="post" action="/HolidayMaster" type="FCIPAY.HRMS.WEBTIER.Form.HolidayMasterForm" >

      <bean:define id="unitListId" property="unitList" name="frmHolidayMaster" ></bean:define>
      <bean:define id="txtYearAndLocationId" property="txtYearAndLocation" name="frmHolidayMaster" ></bean:define>
      <bean:define id="lstHolidayNameId" property="lstHolidayName" name="frmHolidayMaster"></bean:define>
      <bean:define id="lstDetailPane" property="lstDetailPane" name="frmHolidayMaster"></bean:define>
      
      <logic:empty name="frmHolidayMaster" property="sload" >
            <center><font color="red" size="3">Initializing Form Values...</font></center>
      </logic:empty>  

      <table  border="0" align="center" width="100%"> 
         <tr>
            <td class="MainHeader"> <center> <b> Holiday Master </b> </center> </td>
         </tr>
      </table>
      <html:errors />
      <table>
         <tr>
            <td class="LabelText" width="88%"> <font color="red"> * </font>  <i>Mandatory Fields </i>  </td> 
            <td class="LabelText" > <font color="blue"> # </font>  <i>Searchable Fields </i>  </td>
         </tr>
      </table> 
      <table  border="0" align="center" width="100%"> 
         <tr>
            <td class="SubHeader"> <center> Master Pane </center> </td>
         </tr>      
      </table>      
      <table cellspacing="0" cellpadding="0" width="100%" class="bgndTable" border="1">
        <tr> 
            <td class="labelText"  width="10%" > Location <font color="red">*</font> </td>
            <td width="50%">
              <html:select property="lstUnitName"  styleClass="required">
                <html:option value="">Please Select</html:option>
                <html:options collection="unitListId" property="UId" labelProperty="UCode"/>   
              </html:select>
            </td>            
            <td class="labelText"  width="10%" > Weekly Off 1 <font color="red">*</font> </td>            
            <td width="50%">
                <html:select property="weekly_Off_1" styleClass="required">
                <html:option value="">Please Select</html:option>
                <html:option value="MONDAY">Monday</html:option>
                <html:option value="TUESDAY">Tuesday</html:option>
                <html:option value="WEDNESDAY">Wednesday</html:option>
                <html:option value="THURSDAY">Thursday</html:option>
                <html:option value="FRIDAY">Friday</html:option>
                <html:option value="SATURDAY">Saturday</html:option>
                <html:option value="SECOND SATURDAY">Second Saturday</html:option>                 
                <html:option value="SUNDAY">Sunday</html:option>                   
            	 </html:select>
		      </td>
         </tr>            
         <tr>             
            <td class="labelText"  width="10%" > Weekly Off 2 </td>
            <td width="50%">
                <html:select property="weekly_Off_2">
                <html:option value="">Please Select</html:option>
                <html:option value="MONDAY">Monday</html:option>
                <html:option value="TUESDAY">Tuesday</html:option>
                <html:option value="WEDNESDAY">Wednesday</html:option>
                <html:option value="THURSDAY">Thursday</html:option>
                <html:option value="FRIDAY">Friday</html:option>
                <html:option value="SATURDAY">Saturday</html:option>
                <html:option value="SECOND SATURDAY">Second Saturday</html:option>                
                <html:option value="SUNDAY">Sunday</html:option>                
            	 </html:select>
		      </td>            
            <td class="labelText"  width="10%" > Year <font color="red">*</font>&nbsp;<font color="blue">#</font> </td>
            <td width="50%">
                <html:select property="lstYear" styleClass="required" onchange="getRecord();">
                <html:option value="" >Please Select</html:option>
                <html:options collection="txtYearAndLocationId" property="holidayId" labelProperty="txtYearAndLocation" />
            	 </html:select>
		      </td>                        
         </tr>                  
      </table>
      <table  border="0" align="center" width="100%"> 
         <tr>
            <td class="SubHeader"> <center> <b> Detail Pane </b> </center> </td>
         </tr>      
      </table>

<!---    Table to Add Optional holidays -->
      <table cellspacing="0" cellpadding="0" width="100%" class="bgndTable" border="1" id="idTable">
         <tr align="center">
            <th class="labelText"> <center> Holiday Name <font color="red">*</font> </center> </th>
            <th class="labelText"> <center> Holiday Date <font color="red">*</font> </center> </th>
            <th class="labelText"> <center> Type of Holiday <font color="red">*</font> </center> </th>
            <th class="labelText"> <center> Delete </center> </th>
         </tr>
         <logic:match name="frmHolidayMaster" property="irecordCount" value="0">
            <tr> 
               <td  width="40%" align="center">
                   <html:select title='0' property="holiday_Name" onblur="lfnHolidayNameCheck(this.value, this.title);" styleClass="required">
                     <html:option value="" >Please Select</html:option>
                     <html:options collection="lstHolidayNameId" property="QCode" labelProperty="QType"/>
                   </html:select>
               </td>
               <td  width="40%" align="center">
                    <html:text title='0' property="holiday_Date" size="20" maxlength="20" value="" onblur="if(date_Check(this.value)) {checkYear(change_DateFormat(this.value), this.title); lfnCheckDate(this.value, this.title);}" styleClass="required" />
                    <img src="../../COMMON/Images/cal.gif" 	width="16" height="16" border="1" alt="Click Here"  onclick="OpenCalender(document.getElementsByName('holiday_Date')[0])" />                        
                   
               </td>
               <td  width="40%" align="center">
                   <html:select title='0' property="holiday_type"  styleClass="required">
                     <html:option value="" >Please Select</html:option>
                     <html:option value="C" >Compulsary</html:option>
                     <html:option value="O" >Optional</html:option>
                     <html:option value="S" >Special</html:option>
                   </html:select>
               </td>

               <td width="20%" align="center">
                  <html:checkbox title='0' property="chkDeleteRow" value="U" onclick="chkDeletion(this.checked);"/> <html:hidden property="scheck" value="A"/>
               </td>
            </tr>
         </logic:match>
         <logic:iterate name="frmHolidayMaster" property="lstDetailPane" id="Index" indexId="Counter">
            <tr> 
               <td width="40%" align="center">
                   <html:select title='<%=String.valueOf(Counter)%>' property="holiday_Name" onblur="lfnHolidayNameCheck(this.value, this.title);" styleClass="required" name="Index">
                     <html:option value="" >Please Select</html:option>
                     <html:options collection="lstHolidayNameId" property="QCode" labelProperty="QType"/>
                   </html:select>
               </td>
               <td width="40%" align="center">
                   <html:text title='<%=String.valueOf(Counter)%>' property="holiday_Date"  size="20" maxlength="20" name="Index" onblur="if(date_Check(this.value)) {checkYear(change_DateFormat(this.value), this.title); lfnCheckDate(this.value, this.title);}" styleClass="required" />
                   <img src="../../COMMON/Images/cal.gif" width="16" height="16" border="1" alt="Click Here"  onclick="OpenCalender(document.getElementsByName('holiday_Date')[<%=String.valueOf(Counter)%>]);">                        
                   
               </td>
               <td  width="40%" align="center">
                   <html:select title='<%=String.valueOf(Counter)%>' property="holiday_type"  styleClass="required">
                     <html:option value="" >Please Select</html:option>
                     <html:option value="C" >Compulsary</html:option>
                     <html:option value="O" >Optional</html:option>
                     <html:option value="S" >Special</html:option>
                   </html:select>
               </td>

               <td width="20%" align="center">
                  <html:checkbox title='<%=String.valueOf(Counter)%>' property="chkDeleteRow" value="U" onclick="chkDeletion(this.checked);"/> <html:hidden property="scheck" value="A"/>
               </td>
            </tr>
         </logic:iterate>
      </table>
      <table cellspacing="0"  cellpadding="0" width="100%"   class="bgndTable" border="1" >
         <tr align="right">
            <td >
                  <html:button accesskey="D" value="Remove Last Empty Row" styleClass="butto" onclick="deleteLastEmptyRow();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butDeleteRow"/>          
                  <html:button accesskey="A" value="Add New Row" styleClass="butto" onclick="addRow();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butAddRow"/>          
            </td>
         </tr>
      </table>


      <br> <br>
       <table cellspacing="0" cellpadding="0" width="100%">
         <tr>
            <td>
               <center>  
                  <html:button accesskey="Q" value="Query" styleClass="butto" onclick="clickQuery();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butQuery"/>
                  <html:button accesskey="I" value="Save" styleClass="butto" onclick="clickInsert();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butInsert"/>
                  <html:button accesskey="E" value="Edit" styleClass="butto" onclick="clickEdit();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butEdit"/>
                  <html:button accesskey="R" value="Reset" styleClass="butto" onclick="clickReset();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butReset"/>               
              </center>
            </td>
         </tr>
       </table>
      <html:hidden property="sload" />        
      <html:hidden property="saction" />  
      <html:hidden property="tempYear" />        
      <html:hidden property="smode" />
      <html:hidden property="irecordCount" />
      <html:hidden property="queryFlag" />
      <html:hidden property="iaddRowLen" />
   </html:form>
</body>
</html:html>