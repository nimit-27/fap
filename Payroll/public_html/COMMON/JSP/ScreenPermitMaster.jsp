<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!doctype html public -//w3c//dtd html 4.0 transitional//en>
<html:html locale="true"><head><html:base />
<title>Location Code and Charge Code Mapping</title>
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
<style>
        #divTable 
        {
            overflow: auto;
            left: 22.5%;
            top: 150px;
            width: 100%;
            height:114px;
        }
    </style>

</head>
<BODY bgcolor="white" topmargin="0" onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
<jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />

<br><br><br> 


<html:form method="post"  name="frmMapEmp"  action="/MapEmp" type="FCIPAY.COMMON.WEBTIER.Form.ScreenPermitMasterForm">
<DIV ID="printReady" class="Print">
<DIV align="center"><b class="MainHeader" > Mapping of Employees</b></DIV>
<br>
<html:errors />
<center>
<br>
             <bean:define name="frmMapEmp" id="empList" property="empList" />
            <bean:define name="frmMapEmp" id="moduleList" property="moduleList" />
            <bean:define name="frmMapEmp" id="headerList" property="headerList" />
            <html:hidden name="frmMapEmp" property="hdnCount"/>
            <html:hidden name="frmMapEmp" property="hdnID"/>
            

<table cellspacing="0" cols="3"  cellpadding="0"  width="100%"  class="bgndTable"  border="0" >
<caption><div id="sty" ><b class="SubHeader" >List of Modules and screens</b></div></caption>
<tbody>


          <tr >
                    <td width="20%" class="labelText" ><b>Module Name :</b> <i><font color="red">*</font></i></td>
                    <td width="30%" >
                        <html:select property="lstModule" styleClass="required" onchange="lfnDisplayModule(this.value);">
                            <html:option value="">Please Select </html:option>
                            <html:options collection="moduleList" labelProperty="code" property="idString" />
                        </html:select>
                    </td>

                    <td width="20%" class="labelText" ><b>Header Name :</b> <i><font color="red">*</font></i></td>
                    <td width="35%" >
                        <html:select property="lstHeader" styleClass="required" onchange="if(this.value!=''){setHidden('GetLevels');}">
                            <html:option value="">Please Select </html:option>
                            <html:options collection="headerList" labelProperty="code" property="idString" />
                        </html:select>
                    </td>
                </tr>
            </table>

            <div id="sty">
                <b class="SubHeader"><center>Screen Details</center></b>
            </div>
            <logic:greaterThan name="frmMapEmp" property="descTable" value="0">
            <table border="1" cols="4" cellspacing="0" cellpadding="0" width="100%" class="bgndTable" bordercolor="white">
                <tr>
                    <th width="6%">Select</th>
                    <th width="32%">Level 1/Screen Name</th>
                    <th width="32%">Level 2/Screen Name</th>
                    <th width="30%">Level 3/Screen Name</th>
                </tr>
            </table>
            
            <div name ="divTable" id ="divTable" >
                <table border="1" cols="4" cellspacing="0" cellpadding="0" width="100%"  class ="bgndTable" id="tblScreenDtls" bordercolor="white" >
                    <% int i=0; %>
                    <logic:iterate name="frmMapEmp" id="DynamicMenuBean" property="menuList" >
                    <% int j=++i; %>
                    <tr>
                        <td width="6%"><html:radio property="chkSelect" name="frmMapEmp" onclick="Check_F(this.value)" value="<%=String.valueOf(j)%>" /><%=String.valueOf(j)%></td>
                        <td width="32%"><bean:write name="DynamicMenuBean" property="level1" /></td>
                        <td width="32%"><bean:write name="DynamicMenuBean" property="level2" />&nbsp;&nbsp;</td>
                        <td width="28%"><bean:write name="DynamicMenuBean" property="level3" />&nbsp;&nbsp;</td>
                        <html:hidden property="hdnCheck" name="DynamicMenuBean"  />
                        <html:hidden property="hdnScreenId" name="DynamicMenuBean" />
                    </tr>
                    </logic:iterate>
                </table>
            </div>
            </logic:greaterThan>
            
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
<TD><!-- Commented By Balpreet Dt 16 Nov 2007. (Print Not required for this screen.)
<html:button styleClass="butto" onmouseover="this.style.color='yellow';" accesskey="P" onclick="onPrint('printReady');"  onmouseout="this.style.color='white';" property="butPrint" value="Print" /> --></TD>
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
    frmMapEmp.hdnCount.value=0;
    if(document.frmMapEmp.SAction.value != "Load")
    {
        document.frmMapEmp.SAction.value ="Load";
        document.frmMapEmp.submit();
    }
    /*if(document.frmMapEmp.lstModuleName.value=="")
    {
        lfnDisplayModule("");
    }*/
}            

function lfnDisplayModule(value)
{
    if(value != "")
   {
    document.frmMapEmp.SAction.value="Display";
    document.frmMapEmp.submit();
   }  
 }

function setHidden(value)
{
    frmMapEmp.SAction.value=value;
    frmMapEmp.submit();  
}
function lfnDisplayScreen(value)
{
    if(value != "")
  {
    document.frmMapEmp.SAction.value="List";
    document.frmMapEmp.submit();
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
	var d = document.frmMapEmp;
	if(document.frmMapEmp.lstMapDesc.length < 1)
	{	
		alert("Select Employees from list");
		return false;		
	}
	else if(lfnValidateForm())
	{
        lfnGetSelectedValues();
        alert("Your Details are submitted!");
        document.frmMapEmp.SAction.value="Save";
        document.frmMapEmp.butSave.disabled=true;
        document.frmMapEmp.submit();
        return true;
	}
}

function lfnValidateForm()
{
	var d = document.frmMapEmp;
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
	return true;
}

function lfnGetSelectedValues()
{
  var a=document.frmMapEmp.lstMapDesc.length;

  if(a > 1)
  {
   for(i=1;i<a-1;i++)
   { 
    document.frmMapEmp.SAction1.value=document.frmMapEmp.SAction1.value+frmMapEmp.lstMapDesc.options[i].value;
    document.frmMapEmp.SAction1.value=document.frmMapEmp.SAction1.value+",";
   }
 document.frmMapEmp.SAction1.value=document.frmMapEmp.SAction1.value+frmMapEmp.lstMapDesc.options[i].value;

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
	document.frmMapEmp.butLT.disabled = false;
}

function lfnEnableDblLT()
{
	document.frmMapEmp.butDblLT.disabled = false;
}

function lfnEnableGT()
{
	document.frmMapEmp.butGT.disabled = false;
}

function lfnEnableDblGT()
{
	document.frmMapEmp.butDblGT.disabled = false;
}

function lfnDisableLT()
{
	document.frmMapEmp.butLT.disabled = true;
}

function lfnDisableDblLT()
{
	document.frmMapEmp.butDblLT.disabled = true;
}

function lfnDisableGT()
{
	document.frmMapEmp.butGT.disabled = true;
}

function lfnDisableDblGT()
{
	document.frmMapEmp.butDblGT.disabled = true;
} 

function lfnReset()
{
    for(i=0; i < document.frmMapEmp.length ; i++)
    {
        document.frmMapEmp.elements[i].disabled = false;
    }
    document.frmMapEmp.SAction.value ="Reset";
    document.frmMapEmp.submit();
    return true;
}


function lfnDblGT()
{	
	len=frmMapEmp.lstUnMapDesc.length;
	for(i=1;i<len;i++)
	{
		len=frmMapEmp.lstUnMapDesc.length;
		if(len != 1)
		{
			if(frmMapEmp.lstUnMapDesc.options[i].selected == true)
			{
					var optText=frmMapEmp.lstUnMapDesc.options[i].text;
					var optValue=frmMapEmp.lstUnMapDesc.options[i].value;
					var opt = new Option(optText, optValue);
					var selRight = document.frmMapEmp.lstMapDesc;
					selRight.options[selRight.options.length] = opt;
					var selLeft = document.frmMapEmp.lstUnMapDesc;
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
	len=document.frmMapEmp.lstUnMapDesc.length;
	for(i=1;i<len;i++)
	{					
		if(len != 1)
		{
			if(document.frmMapEmp.lstUnMapDesc.options[i].selected == true)
			{
					var optText=document.frmMapEmp.lstUnMapDesc.options[i].text;
					var optValue=document.frmMapEmp.lstUnMapDesc.options[i].value;
                 	var opt = new Option(optText, optValue);
					var selRight = document.frmMapEmp.lstMapDesc;
					selRight.options[selRight.options.length] = opt;
					var selLeft = document.frmMapEmp.lstUnMapDesc;
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
	len=frmMapEmp.lstMapDesc.length;
	for(i=1;i<len;i++)
	{					
		if(len != 1)
		{
			if(frmMapEmp.lstMapDesc.options[i].selected == true)
			{
					var optText=frmMapEmp.lstMapDesc.options[i].text;
					var optValue=frmMapEmp.lstMapDesc.options[i].value;
					var opt = new Option(optText, optValue);
					var selLeft = document.frmMapEmp.lstUnMapDesc;
					selLeft.options[selLeft.options.length] = opt;
					var selRight = document.frmMapEmp.lstMapDesc;
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
	len=frmMapEmp.lstMapDesc.length;
	for(i=1;i<len;i++)
	{
	len=frmMapEmp.lstMapDesc.length;
		if(len != 1)
		{
			if(frmMapEmp.lstMapDesc.options[i].selected == true)
			{
					var optText=frmMapEmp.lstMapDesc.options[i].text;
					var optValue=frmMapEmp.lstMapDesc.options[i].value;
					var opt = new Option(optText, optValue);
					var selLeft = document.frmMapEmp.lstUnMapDesc;
					selLeft.options[selLeft.options.length] = opt;
					var selRight = document.frmMapEmp.lstMapDesc;
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


function Check_F(val)
{
    var flag=true;
    var count=0;
    var oTable = document.getElementById("tblScreenDtls");
    var iTR = eval(oTable.rows.length-1);
    var i;
    var k;
    
    
    document.frmMapEmp.hdnID.value=document.getElementsByName("hdnScreenId")[val-1].value
    //alert("A is"+document.getElementsByName("hdnScreenId")[1].value);
    document.frmMapEmp.SAction.value="List";
    document.frmMapEmp.submit();
    
   /* for(i=0;i<=iTR;i++)
    {
        if(document.getElementsByName("chkSelect")[i].select)
        {
            flag=true;
            count=eval(frmMapEmp.hdnCount.value);
            count++;
            k=i;
            
            frmMapEmp.hdnCount.value=count;
        }
        
    }

    if(flag==true&&eval(frmMapEmp.hdnCount.value)==1)
    {
        document.frmMapEmp.SAction.value="List";
        document.frmMapEmp.hdnID.value=document.getElementsByName("hdnScreenId")[k].value
        document.frmMapEmp.submit();
    }
    else if(flag==true&&eval(frmMapEmp.hdnCount.value)>=1)
    {
        alert("Please Check one screen");
        frmMapEmp.hdnCount.value=0;
        for(i=0;i<iTR;i++)
        {
            document.getElementsByName("chkSelect")[i].checked=false;
        }        
        return false;
    }*/
    
        
}

  
</SCRIPT> 
