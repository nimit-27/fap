<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %><head><html:base />
<title>Leave Master</title>
</head>
<script language="javascript"  src="../../COMMON/JavaScript/validate.js" ></script>
<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_func.js" ></script>
<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_addins.js" ></script>
<script language="JavaScript"  src="../../COMMON/JavaScript/calendar1.js" ></script>
<link rel="STYLESHEET"  type="text/css"  href="../../COMMON/CSS/Menucss.css" >
<link rel ="stylesheet" href ="../../COMMON/CSS/IBA.css" >
<html:html locale="true"> 
<script>
function onInsert()
{
      frmLeaveMaster.lstSdesc.className="";
     
      if(mandatory_Check(frmLeaveMaster))
      {
        setHidden();
      }
}
function onEdit()
{
      frmLeaveMaster.lstSdesc.className="required";
      
      if(mandatory_Check(frmLeaveMaster))
      {
        setHidden();
      }
}
function setHidden()
{
      if(event.srcElement.name =="btnInsert")
      {
          frmLeaveMaster.sAction.value="Insert";
          if (frmLeaveMaster.txtMax_Limit_1.value==""){
            frmLeaveMaster.txtMax_Limit_1.value=999;
          }              
          if (frmLeaveMaster.txtMin_Exp_Req.value==""){
            frmLeaveMaster.txtMin_Exp_Req.value=0;
          }              
          
          frmLeaveMaster.sMode.value="Insert";
      }
      else if(event.srcElement.name =="btnQuery")
      {
          frmLeaveMaster.sAction.value="Query";
          frmLeaveMaster.btnEdit.disabled=false;
          frmLeaveMaster.sMode.value="Query"; showMode();
      }
      else if(event.srcElement.name =="btnEdit")
      {
          frmLeaveMaster.sAction.value="Edit";
          if (frmLeaveMaster.txtMax_Limit_1.value==""){
            frmLeaveMaster.txtMax_Limit_1.value=999;
          }              
          if (frmLeaveMaster.txtMin_Exp_Req.value==""){
            frmLeaveMaster.txtMin_Exp_Req.value=0;
          }              
      }  
      else if(event.srcElement.name =="btnReset")
      {
          frmLeaveMaster.btnEdit.disabled=true;
          frmLeaveMaster.sAction.value="Reset";
        }
      else if (event.srcElement.name="lstSdesc")
      {
        frmLeaveMaster.sAction.value="Retrieve";  
      }
      frmLeaveMaster.submit();
}      
function showMode()
{
    if (frmLeaveMaster.sMode.value=="Query")
        {
            frmLeaveMaster.btnEdit.disabled=false;
            frmLeaveMaster.btnInsert.disabled=true;
            test.style.display='block';
            test1.style.display='block';
              test2.style.display='none';
                test3.style.display='none';
        }
    else
        { 
            if (frmLeaveMaster.sMode.value=="Insert")
            { 
                frmLeaveMaster.btnEdit.disabled=true;
                frmLeaveMaster.btnInsert.disabled=false;
                test.style.display='none';
                test1.style.display='none';
                test2.style.display='block';
                test3.style.display='block';
            } 
       
       }
}

function CheckDesc(value){
	if(value=="") 
		return true;
	value=trim(value);
	//var alphaPattern = /^[a-zA-Z0-9]{1}+[.a-zA-Z0-9\s]*$/; 
	var alphaPattern = /^[\.&_()\-\/a-zA-Z0-9\s]+$/; 
	if (alphaPattern.test(value))
		return(true);
	else 
	{
		alert("Invalid Entry!");
		event.srcElement.select();
		event.srcElement.focus();
		return(false);
	}

}
</script>
<body bgcolor="white" onload="showMode();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<!--script language="JavaScript1.2" src='<html:rewrite page="/COMMON/JavaScript/Menujs.js" />'></script-->
<jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />

<html:form name="frmLeaveMaster"  method="post"  action="/LeaveMastAction" type = "FCIPAY.HRMS.WEBTIER.Form.LeaveMastForm">
<bean:define id="drcrtList" property="drcrtList" name="frmLeaveMaster"></bean:define>
<html:hidden property="sAction" /><html:hidden property="sMode" />
<br><br>
<b class="MainHeader" ><center>LEAVE MASTER</center></b>
<table width="85%" align="center" border="0"  cellspacing="5"  cellpadding="5"  align="center"  >
            <tr>
                <td  width="60%" class = "labeltext">
                    <font color="red" >*</font>&nbsp;&nbsp;<i>Mandatory Fields
                </td>
                <td class = "labeltext">
                    <font color="red">#</font>&nbsp;&nbsp;Searchable Fields
                </td>
</table>

<html:errors />
<table width="90%"  border="2"  cellspacing="0"  cellpadding="1" align ="center"  class="bgndTable" >
 
   <tr><td><table width="85%"  border="0"  cellspacing="2"  cellpadding="3" align ="center"  class="bgndTable" >
 <tr>
         <td><br></td>
    </tr>
   <tr>
         <td width="20%"  class="labelText" ><div id="test" style="display:none"> Leave <font color="red" >#</font></div></td>
            <td width="30%" >
                 <div id="test1" style="display:none">        
                
                      <html:select property="lstSdesc"  onchange="setHidden();">
                          <html:option value="" >Please Select</html:option>
                          <html:options collection="drcrtList"  property="DId" labelProperty="DName"/>
                      </html:select>
                </div>

            </td>
            
        </tr>
         
        <tr>
             <td width="20%" class="labelText" nowrap="true" >Leave Long Description <font color="red" >*</font></td>
            <td width="30%" >
                <html:text  property="txtLdesc"   size="30" maxlength="50"    onblur="CheckDesc(this.value);"  styleClass="required" />
            </td>
            
  			<td width="20%" class="labelText" nowrap="true"><div id="test2" style="display:block"> Leave Short Description<font color="red" >*</font></div></td>
            <td width="30%" >
             <div id="test3" style="display:block"> 
                <html:text  property="txtSdesc"  size="30" maxlength="50" onblur="CheckDesc(this.value);" styleClass="required" />    
             </div>
            </td>
    
        </tr>
       
        
         <tr>
            <td width="20%" class="labelText" >Maximum Limit(Days)</td>
            <td width="30%" >
                <html:text  property="txtMax_Limit_1"   size="20" maxlength="3"    onblur="num_Check(this.value,0);"   />
            </td>
            
    
           <td width="20%" class="labelText" nowrap="true">Minimum Service Required(Years)</td>
            <td width="30%" >
                <html:text  property="txtMin_Exp_Req"   size="20" maxlength="2"    onblur="num_Check(this.value,0);"   />
            </td>

        
         <tr>
         <td width="20%" class="labelText" >Display Flag<font color="red" >*</font></td>
            <td width="30%" >
                <html:select property="lstDisplay"  size="1"  styleClass="required" >
					<html:option value="" >Please Select</html:option>
                    <html:option  value="Y" >Yes</html:option>
					<html:option  value="N" >No</html:option>
				</html:select>
            </td>
            
            <td width="20%" class="labelText" >Frequency</td>
            <td width="30%" >
                <html:select property="lstMax_Limit_Freq"  size="1" >
                    <html:option value="" >Please Select</html:option>
					<html:option  value="O" >At a Time</html:option>
					<html:option  value="Y" >Yearly</html:option>
                    <html:option  value="S" >Entire Service</html:option>
				</html:select>
            </td>
           
    </tr>
    
    <tr>
         <td width="20%" class="labelText" >Applicable To</td>
            <td width="30%" >
                <html:select property="lstApply"  size="1"  >
					<html:option value="" >Please Select</html:option>
                    <html:option  value="M" >Male</html:option>
					<html:option  value="F" >Female</html:option>
				</html:select>
            </td>
            <td>
                <html:hidden  property="txtMax_Limit_3"      />
                <html:hidden  property="txtMax_Limit_2"      />
            </td>
    </tr>
    
</table>
</td>
</tr>
</table>
<br>
<br>
    <table align="center" width="20%" >
        <tr>
            <td >
                    <html:button  accesskey="Q"  value="Query"  
                     styleClass="butto" onclick="setHidden();"  onmouseover="this.style.color='yellow';" 
                     onmouseout="this.style.color='white';" property="btnQuery" /><html:button  accesskey="I" 
                     value="Insert"  styleClass="butto" 
                     onclick="onInsert();" 
                     onmouseover="this.style.color='yellow';" 
                     onmouseout="this.style.color='white';" property="btnInsert"  /><html:button  accesskey="E" 
                     value="Edit"  styleClass="butto" disabled="true"
                      onclick="onEdit();"   onmouseover="this.style.color='yellow';" 
                     onmouseout="this.style.color='white';" property="btnEdit"   /><html:button  accesskey="R"  
                     value="Reset"  styleClass="butto" onclick="setHidden();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnReset" />
                </td>
            </tr>
        </table>
        <br>
      </html:form>
   </body>
</html:html>
