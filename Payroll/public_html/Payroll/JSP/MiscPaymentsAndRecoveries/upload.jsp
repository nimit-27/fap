<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html locale="true">
<head><html:base />
    <title>Upload Direct Payroll Transaction</title>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />    
    <link rel="STYLESHEET" type="text/css" href="<html:rewrite page="/COMMON/CSS/Menucss.css" />">
    <link rel="stylesheet" type="text/css" href="<html:rewrite page="/COMMON/CSS/IBA.css" />"> 
    <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />"></script>
    <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />"></script>
    <script type="text/javascript" language="javascript" src="<html:rewrite page="/COMMON/JavaScript/validate.js" />"></script>
</head>
<%
response.setHeader("cache-Control","no-store");  
response.setHeader("cache-Control","max-age=0");
response.setHeader("Pragma","no-cache");
%>
<body onload="lfnLoad();" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<br><br><br>
<html:form name ="frmUploadData" action="/Upload" type="FCIPAY.Payroll.WEBTIER.Form.UploadForm" enctype="multipart/form-data"  method="post" >
    <bean:define id="listAccCode" property="listAccCode" name="frmUploadData" />
    <html:hidden property="uploadAction" />
    <html:hidden property="errLineNo" />
    <table width="100%" border="0">
        <tr>
            <td colspan="2" align="center"><b class="MainHeader">Upload Direct Transaction Details</b></td>
        </tr>
        <tr>
            <td width="50%" align="left"><i><font color="red">*</font>Mandatory Fields</i></td>
            <td width="50%" align="left"><div align="right"><i><font color="blue">#</font>Searchable Fields</i></div></td>
        </tr>
    </table>
    <html:errors />
    <logic:greaterThan name="frmUploadData" property="errLineNo" value="0" >
        <table width="100%">
            <center><td align="center" ><strong><font color="red" >Error in Line No <bean:write name="frmUploadData" property="errLineNo" /></font></strong></td></center>
        </table>
    </logic:greaterThan>

    <table cellspacing="0"  cols="4"  cellpadding="0"  width="100%"  class="bgndTable"  border="0" >
        <caption><div id="sty" ><b class="SubHeader" >Payroll Data Upload</b></div></caption>

      <tr >
           <table border=0 cellpadding=0>
           <TR>               
          <tr height = 10></tr>           
          <td width="20%" class="radioText" ><input type="radio" name="radioMisc" value="E" onclick="DirectTransClick()"   ><bean:message key="Payroll.upload.DirectTrans"  />                
          <td width="20%" class="radioText" ><input type="radio" name="radioMisc" value="E" onclick="NpcSocClick()" ><bean:message  key="Payroll.upload.NPCSoc" />                
          <td width="20%" class="radioText" ><input type="radio" name="radioMisc" value="E" onclick="EmpUpdateClick()" ><bean:message  key="Payroll.upload.EmpMast" />                          
          <tr height = 10></tr>
          </TR>              
            <tr>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>            
          </tr>

          <tr>
          <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.updField"/>
          <td  ><html:select property="txtEmpField" alt="txtEmpField" styleClass="required" style="width:92%" onchange="" >
          <html:option value=" " ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
           <html:option value="MBR" > <bean:message key="Payroll.EmpInfo.MBR" /></html:option>
           <html:option value="NPC" > <bean:message key="Payroll.EmpInfo.NPC" /></html:option>                               
           <html:option value="LFE" > <bean:message key="Payroll.EmpInfo.LFE" /></html:option>
           <html:option value="ALC" > <bean:message key="Payroll.EmpInfo.ALC" /></html:option>
           <html:option value="BRC" > <bean:message key="Payroll.EmpInfo.BRC" /></html:option>                                                              
           </html:select>
           </td>
           </tr>

          <tr height = 20></tr>
        
        <tbody>
            <tr>
               <td width="15%"  class="labelText" >Upload File<font color="red"> * </font></td>
               <td width="35%"><html:file property="theFile"  /></td>
            </tr>

            
            <tr bgcolor = #eff9ff>
                <td colspan="4">
<br>
                   <b><u> Points to be taken Care in the CSV file Provided</u></b><br>
                        <p>    1) For Option 1 & 2 Data will be first loaded into Temporary Table.
                                  Please verify the log and then click Upload into Actual Table to load the data into the Original Table. 
                              </p>                   
                        <p>    2) For Option 3 data will be directly loaded into the Actual Table.
                              </p>                                                 
                        <p>    3) The CSV(Comma seperated) File provided should be in the order mentioned below :
                                    <b>EMP_NUM, PAY CODE, PAY MODE, TOTAL AMT, VALID FROM YYMM (like 200610), AGENCY CODE </b> if Option 1 is selected.</p>
                        <p>    4) The CSV(Comma seperated) File provided should be in the order mentioned below :
                                    <b>EMP_NUM, PAY CODE SRL (like 3171), PAY CODE, TOTAL AMT, INSTALMENT AMT, BALANCE AMT, VALID FROM YYMM (like 200610), AGENCY CODE  </b>    if Option 2 is selected.</p>
                        <p>    5) The CSV(Comma seperated) File provided should be in the order mentioned below :
                                    <b>EMP_NUM, Amount  </b>    if Option 3 is selected.</p>
                                    
                </td>
            </tr>

            <tr height = 20></tr>
            <tr>
              <TD colspan = 4  bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>            
          </tr>
            
        </tbody>
    </table>
    <br>
    <center>

    
    <table cellspacing = "0" cellpadding = "0">    
        <tr>
            <td>     
                <html:button accesskey="U" value="Upload into Temp Table" onclick="setHidden();" styleClass="butto" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butUpload" /></td>
            </td>     
            <td>     
                <html:button accesskey="U" value="Upload into Actual Table" onclick="setActUpload();" styleClass="butto" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butActUpload" /></td>
            </td>                 
            <td>             
                <html:button accesskey="R" value="Reset" onclick="document.frmUploadData.uploadAction.value='reset';document.frmUploadData.submit();" styleClass="butto" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butReset" /></td>
            </td>
        </tr>
    </table>
    </center>
<html:hidden property="optReportType" name="frmUploadData"  />    
</html:form>
</body>
</html:html>
<script>
function lfnLoad()
{
   frmUploadData.txtEmpField.disabled=true;  
   frmUploadData.butActUpload.disabled=true;         
   frmUploadData.butUpload.disabled=true;         
   

    if(document.frmUploadData.uploadAction.value=="")
    {
        document.frmUploadData.uploadAction.value="onLoad";
//        document.frmUploadData.submit();
    }
}

function setHidden()
{
      if((frmUploadData.optReportType.value=="")||  (frmUploadData.optReportType.value==null))
      {
          alert("Please select any One of the 3 Options");
          return false;
      }

  


      if(frmUploadData.optReportType.value=="3")
      {
          if((frmUploadData.optReportType.value=="")||  (frmUploadData.optReportType.value==null))
          {
              alert("Please select any One of the 3 Options");
              return false;
          }
      
         if((frmUploadData.txtEmpField.value=="") || (frmUploadData.txtEmpField.value==null) || (frmUploadData.txtEmpField.value==" "))      
         {
            alert("Please select Employee Table Field Name to be Updated ");
            frmUploadData.txtEmpField.focus();
            return false;
         }
      }
      
      
    if(document.frmUploadData.theFile.value!="")
    {
        document.frmUploadData.uploadAction.value="upload";
        document.frmUploadData.submit();
    }
    else
    {
        alert("Please select the File Name"); 
        return false;
    }
}

function setActUpload()
{
    if (frmUploadData.optReportType.value=="3")
    {
        setHidden();
    }
    else
    {
        document.frmUploadData.uploadAction.value="ActUpload";
        document.frmUploadData.submit();
    }
}


function DirectTransClick()
{
   frmUploadData.optReportType.value="1";
   frmUploadData.butActUpload.disabled=false;         
   frmUploadData.butUpload.disabled=false;         
   frmUploadData.txtEmpField.disabled=true;
}

function NpcSocClick()
{
   frmUploadData.optReportType.value="2";
   frmUploadData.butActUpload.disabled=false;      
   frmUploadData.butUpload.disabled=false;      
  frmUploadData.txtEmpField.disabled=true;
}

function EmpUpdateClick()
{
   frmUploadData.optReportType.value="3";
   frmUploadData.butUpload.disabled=true;   
   frmUploadData.butActUpload.disabled=false;         
   frmUploadData.txtEmpField.disabled=false;   
}


</script>