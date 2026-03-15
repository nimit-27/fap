<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!doctype html public -//w3c//dtd html 4.0 transitional//en>
<html:html locale="true"><head><html:base />
<title>Employee and Group Mapping</title>
<iframe ID="hiddenFrame" NAME="pri" WIDTH="0" HEIGHT="0"></iframe>
<script language="javascript"  src="../../COMMON/JavaScript/validate.js" ></script>

<link rel="STYLESHEET"  type="text/css"  href="../../COMMON/CSS/Menucss.css" >

<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_func.js" ></script>

<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_addins.js" ></script>

<link rel="stylesheet" href="../../COMMON/CSS/IBA.css" >

<%
response.setHeader("cache-Control","no-store");  
response.setHeader("cache-Control","max-age=0");
response.setHeader("Pragma","no-cache");
%>


<meta content="MSHTML 6.00.2600.0" name="GENERATOR" >
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" >


</head>
<BODY bgcolor="white" topmargin="0" onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
<jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />

<br><br><br> 


<html:form method="post"  name="frmMapEmpGrp"  action="/MapEmpGrp" type="FCIPAY.COMMON.WEBTIER.Form.SysadminEmpGrpForm">
<DIV ID="printReady" class="Print">
<DIV align="center"><b class="MainHeader" > Mapping of Employees to Groups</b></DIV>
<br>
<html:errors />
<center>
<br>

<table cellspacing="0"  cols="3"  cellpadding="0"  width="100%"  class="bgndTable"  border="0" >
<caption><div id="sty" ><b class="SubHeader" >List of Groups and Corresponding Module Description</b></div></caption>
<tbody>
<tr>

<td width="10%" class="labelText" ><td  ><td align ="center"  ><b>Groups</b>
		  </td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <font color="red" ></font></td>
		<td width="30%" ><p><html:select property="lstModuleName"  styleClass="required" onchange="lfnDisplayModule(this.value);" ><html:option value="" >Please Select</html:option>
                            <html:options property="lstMNameValues" labelProperty="lstMNameLabels" />
			</html:select>
		</td></td>       
        

        <td width="15%" class="labelText" ><td align ="center"  ><b>Group Description</b>
		  </td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   &nbsp;&nbsp;&nbsp;&nbsp; <font color="red" ></font></td>
		<td width="30%" ><html:text property="txtGrpDesc" size="30" maxlength="50" styleClass="required" />
		</td></td>

        <td width="15%" class="labelText" ><td align ="center"  ><b>Module</b>
		  </td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   &nbsp;&nbsp;&nbsp;&nbsp; <font color="red" ></font></td>
		<td width="30%" ><html:text property="txtModule" size="30" maxlength="50" styleClass="required" />
		</td></td>
       
</tr>
        </tbody>
</table>

<table cellspacing="0"  cols="3"  cellpadding="0"  width="100%"  class="bgndTable"   border="0" >
 <thead>
	  <tr>
		  <td align ="center"  >List of UnMapped Employees
		  </td>
		  <td align ="center" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		  <td align ="left"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;List of Mapped Employees <font color="red" ></font></td>
	  </tr>
  </thead>

  <tbody>
  <tr>
    <td width ="50%"  rowspan ="4"  align ="center" >
		<p><html:select property ="lstUnMapDesc"  size ="13"   multiple="true" onchange="lfnOnListChange('left');" >
		<html:option value ="0" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html:option>
    <html:options property="lstUnMapValues" labelProperty="lstUnMapLabels" />
		
		</html:select></p>
    </td>
    <td width ="10%"  align ="left" >
		<html:button styleClass="butto" onmouseover="this.style.color='yellow';" accesskey = "" disabled="true"  onclick="lfnDblGT();" onmouseout="this.style.color='white';" property = "butDblGT" value="&nbsp;&nbsp;&nbsp;>>&nbsp;&nbsp;&nbsp;"/>
    </td>
	<td width ="90%"  rowspan="4"  align="left" >
		<p><html:select property="lstMapDesc"  size="13"   multiple="true" onchange = "lfnOnListChange('right');"  >
		<html:option value="0" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html:option>
    <html:options property="lstMapValues" labelProperty="lstMapLabels" />
		</html:select></p>
    </td>
 </tr>

<tr>
    <td align="left" >
		<html:button styleClass="butto" onmouseover="this.style.color='yellow';" accesskey = "" disabled="true" onclick="lfnGT();"  onmouseout="this.style.color='white';" property = "butGT" value="&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;"/>
    </td>
</tr>	

<tr>
    <td align="left" >
		<html:button styleClass="butto" onmouseover="this.style.color='yellow';" accesskey = "" disabled="true" onclick="lfnLT();" 
		 onmouseout="this.style.color='white';" property = "butLT" value="&nbsp;&nbsp;&nbsp;&nbsp;<&nbsp;&nbsp;&nbsp;&nbsp;"/>
    </td>
</tr>


           

<tr>
    <td align="left" >
		<html:button styleClass="butto" onmouseover="this.style.color='yellow';" accesskey = "" disabled="true" onclick="lfnDblLT();"  onmouseout="this.style.color='white';" property = "butDblLT" value="&nbsp;&nbsp;&nbsp;<<&nbsp;&nbsp;&nbsp;"/>
    </td>
</tr>
</tbody>         
</table>


<table cellspacing="0" cellpadding="0">
<tr>
<td>
<html:button styleClass="butto" onmouseover="this.style.color='yellow';" accesskey = "S" onclick="lfnGenerate();" onmouseout="this.style.color='white';" property = "butSave" value="Save"/></td>
<td>
 <html:button  styleClass="butto" onmouseover="this.style.color= 'yellow';" accesskey ="R" onclick="lfnReset()" onmouseout="this.style.color= 'white';" property ="butReset"  value="Reset"  />
</TD>
</tr>
</table>




<html:hidden property="SAction" />
<html:hidden property="SAction1"  value="" />
<br>
<div align="right" >
<hr>
</div></center></html:form></BODY></html:html>

<SCRIPT> 
function lfnLoad()
{
    history.forward(1);
    //alert(document.frmMapEmpGrp.SAction.value);
    if(document.frmMapEmpGrp.SAction.value != "Load")
    {
        document.frmMapEmpGrp.SAction.value ="Load";
        document.frmMapEmpGrp.submit();
    }
    if(document.frmMapEmpGrp.lstModuleName.value=="")
    {
        lfnDisplayModule("");
    }
}            

function lfnDisplayModule(value)
{
    if(value != "")
   {
    document.frmMapEmpGrp.SAction.value="Display";    
    document.frmMapEmpGrp.submit();
   }  
 }


function lfnDisplayScreen(value)
{
    if(value != "")
  {
    document.frmMapEmpGrp.SAction.value="List";
    document.frmMapEmpGrp.submit();
  } 
}


function lfnEnableLT()
{
	document.frmMapLCtoCHC.butLT.disabled = false;
}

function lfnEnableDblLT()
{
	document.frmMapLCtoCHC.butDblLT.disabled = false;
}

function lfnEnableGT()
{
	document.frmMapLCtoCHC.butGT.disabled = false;
}

function lfnEnableDblGT()
{
	document.frmMapLCtoCHC.butDblGT.disabled = false;
}

function lfnDisableLT()
{
	document.frmMapLCtoCHC.butLT.disabled = true;
}

function lfnDisableDblLT()
{
	document.frmMapLCtoCHC.butDblLT.disabled = true;
}

function lfnDisableGT()
{
	document.frmMapLCtoCHC.butGT.disabled = true;
}

function lfnDisableDblGT()
{
	document.frmMapLCtoCHC.butDblGT.disabled = true;
} 

function lfnGenerate()
{	
    //alert(document.frmMapEmpGrp.lstMapDesc.length);
	var d = document.frmMapEmpGrp;
	if(document.frmMapEmpGrp.lstMapDesc.length-1 < 1)
	{	
		alert("Select Employees from list");
		return false;		
	}
	else if(lfnValidateForm())
	{
        lfnGetSelectedValues();
        alert("Your Details are submitted!");
        document.frmMapEmpGrp.SAction.value="Save";
        document.frmMapEmpGrp.submit();
        return true;
	}
}

function lfnValidateForm()
{
	var d = document.frmMapEmpGrp;
	var i;

    for(i = 0; i < d.length; i++)
	{
        if (d.elements[i].className=="required" && (trim(eval(d).elements[i].value)==""))
		{    		
			alert('Mandatory field is empty!');
			d.elements[i].focus();
			return false;
		}
	}
    //alert("lfnValidateForm is Clear");
	return true;
}

function lfnGetSelectedValues()
{
  var a=document.frmMapEmpGrp.lstMapDesc.length;

  if(a > 1)
  {
   for(i=1;i<a-1;i++)
   { 
    document.frmMapEmpGrp.SAction1.value=document.frmMapEmpGrp.SAction1.value+frmMapEmpGrp.lstMapDesc.options[i].value;
    document.frmMapEmpGrp.SAction1.value=document.frmMapEmpGrp.SAction1.value+",";
   }
 document.frmMapEmpGrp.SAction1.value=document.frmMapEmpGrp.SAction1.value+frmMapEmpGrp.lstMapDesc.options[i].value;

  }
}

function lfnOnListChange(direct)
{
		var p;
		var len;
		var noOfItemsSelected;
		var i;

		len = event.srcElement.length;
		noOfItemsSelected = 0;		

		for (i = 1; i < len; i++)
		{
			if (event.srcElement.options[i].selected == true)
			{
				++noOfItemsSelected;
			}
		}
		
		if(noOfItemsSelected == 0)
		{
			lfnDisableGT();
			lfnDisableLT();
			lfnDisableDblGT();
			lfnDisableDblLT();
		}
		else
		{
			if (noOfItemsSelected > 1)
			{
				if (direct == 'left')
				{
					lfnEnableDblGT();
					lfnDisableGT();
					lfnDisableLT();
					lfnDisableDblLT();
				}
					
				else
				{
					lfnEnableDblLT();
					lfnDisableGT();
					lfnDisableLT();
					lfnDisableDblGT();
				}
			}
			else
			{
				if (direct == "left")
				{
					lfnEnableGT();	
					lfnDisableLT();
					lfnDisableDblGT();
					lfnDisableDblLT();
				}
				else
				{
					lfnEnableLT();
					lfnDisableGT();
					lfnDisableDblGT();
					lfnDisableDblLT();
				}
			}
		}
		return true;
}

function lfnEnableLT()
{
	document.frmMapEmpGrp.butLT.disabled = false;
}

function lfnEnableDblLT()
{
	document.frmMapEmpGrp.butDblLT.disabled = false;
}

function lfnEnableGT()
{
	document.frmMapEmpGrp.butGT.disabled = false;
}

function lfnEnableDblGT()
{
	document.frmMapEmpGrp.butDblGT.disabled = false;
}

function lfnDisableLT()
{
	document.frmMapEmpGrp.butLT.disabled = true;
}

function lfnDisableDblLT()
{
	document.frmMapEmpGrp.butDblLT.disabled = true;
}

function lfnDisableGT()
{
	document.frmMapEmpGrp.butGT.disabled = true;
}

function lfnDisableDblGT()
{
	document.frmMapEmpGrp.butDblGT.disabled = true;
} 

function lfnReset()
{
    for(i=0; i < document.frmMapEmpGrp.length ; i++)
    {
        document.frmMapEmpGrp.elements[i].disabled = false;
    }
    document.frmMapEmpGrp.SAction.value ="Reset";
    document.frmMapEmpGrp.submit();
    return true;
}


function lfnDblGT()
{	
	len=frmMapEmpGrp.lstUnMapDesc.length;
	for(i=1;i<len;i++)
	{
		len=frmMapEmpGrp.lstUnMapDesc.length;
		if(len != 1)
		{
			if(frmMapEmpGrp.lstUnMapDesc.options[i].selected == true)
			{
					var optText=frmMapEmpGrp.lstUnMapDesc.options[i].text;
					var optValue=frmMapEmpGrp.lstUnMapDesc.options[i].value;
					var opt = new Option(optText, optValue);
					var selRight = document.frmMapEmpGrp.lstMapDesc;
					selRight.options[selRight.options.length] = opt;
					var selLeft = document.frmMapEmpGrp.lstUnMapDesc;
					selLeft.options[i] = null;
					i=0;
					
					if (navigator.appName == 'Netscape' && (navigator.appVersion.indexOf('Win') != -1 || navigator.appVersion.indexOf('Mac') != -1))
						history.go(0);					
			}
		}
	}
	lfnDisableDblGT();
}

function lfnGT()
{
	len=document.frmMapEmpGrp.lstUnMapDesc.length;
	for(i=1;i<len;i++)
	{					
		if(len != 1)
		{
			if(document.frmMapEmpGrp.lstUnMapDesc.options[i].selected == true)
			{
					var optText=document.frmMapEmpGrp.lstUnMapDesc.options[i].text;
					var optValue=document.frmMapEmpGrp.lstUnMapDesc.options[i].value;
                 	var opt = new Option(optText, optValue);
					var selRight = document.frmMapEmpGrp.lstMapDesc;
					selRight.options[selRight.options.length] = opt;
					var selLeft = document.frmMapEmpGrp.lstUnMapDesc;
                	selLeft.options[i] = null;					
					
					if (navigator.appName == 'Netscape' && (navigator.appVersion.indexOf('Win') != -1 || navigator.appVersion.indexOf('Mac') != -1))
							history.go(0);
					break;				
			}
		}
	}
	lfnDisableGT();
}
	
function lfnLT()
{
	len=frmMapEmpGrp.lstMapDesc.length;
	for(i=1;i<len;i++)
	{					
		if(len != 1)
		{
			if(frmMapEmpGrp.lstMapDesc.options[i].selected == true)
			{
					var optText=frmMapEmpGrp.lstMapDesc.options[i].text;
					var optValue=frmMapEmpGrp.lstMapDesc.options[i].value;
					var opt = new Option(optText, optValue);
					var selLeft = document.frmMapEmpGrp.lstUnMapDesc;
					selLeft.options[selLeft.options.length] = opt;
					var selRight = document.frmMapEmpGrp.lstMapDesc;
					selRight.options[i] = null;
					
					
					if (navigator.appName == 'Netscape' && (navigator.appVersion.indexOf('Win') != -1 || navigator.appVersion.indexOf('Mac') != -1))
							history.go(0);
					break;			
			}
		}
	}
	lfnDisableLT();
}

function lfnDblLT()
{
	len=frmMapEmpGrp.lstMapDesc.length;
	for(i=1;i<len;i++)
	{
	len=frmMapEmpGrp.lstMapDesc.length;
		if(len != 1)
		{
			if(frmMapEmpGrp.lstMapDesc.options[i].selected == true)
			{
					var optText=frmMapEmpGrp.lstMapDesc.options[i].text;
					var optValue=frmMapEmpGrp.lstMapDesc.options[i].value;
					var opt = new Option(optText, optValue);
					var selLeft = document.frmMapEmpGrp.lstUnMapDesc;
					selLeft.options[selLeft.options.length] = opt;
					var selRight = document.frmMapEmpGrp.lstMapDesc;
					selRight.options[i] = null;
					
					if (navigator.appName == 'Netscape' && (navigator.appVersion.indexOf('Win') != -1 || navigator.appVersion.indexOf('Mac') != -1))
							history.go(0);
					i=0;				
			}
		}
	}
	lfnDisableDblLT();
}

function lfnPrintMandatoryMark()
{
	document.write("<font class = 'mandatory'>");
	document.write("*");
	document.write("</font>");
}


  
</SCRIPT> 
