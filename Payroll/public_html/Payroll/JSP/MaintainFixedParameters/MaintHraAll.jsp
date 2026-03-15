<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
         <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>

</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>


<html:form  action="MaintHraRate" name="frmMaintHraRate" type="FCIPAY.Payroll.WEBTIER.Form.MaintHraRateForm" scope="session">
<bean:define id="ParentForm" name="frmMaintHraRate" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN HRA RATES</TD>
  </TR>

  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
   <TR>
    <TD>
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText>Hra Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
                 <TR height=10>
                   <!-- Detail table Container starts -->
                    <TD colspan=11>
                      <TABLE cellSpacing=0 cellPadding=0 border=0>
                        <TBODY>
                          <TR>
                           <TD >
                            <DIV id=divDtlTable style="height:320px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                <TBODY>
                                     <TR height="20">
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"   /></td>
                                              <TD class=tableHeader width="3%"><bean:message  key="Payroll.MaintHraAll.type" /></TD>
                                              <TD class=tableHeader width="3%"><bean:message  key="Payroll.MaintHraAll.city" /></TD>
                                              <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintHraAll.amt" /></td>
                                              <td class=tableHeader width="10%">Effective Date</td>                                                                                            
                                      </TR>    

                         <logic:iterate id="hraInfo" name="frmMaintHraRate" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintHraRateBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="hraInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>

                                      <td align=center ><html:checkbox property="checked" name="frmMaintHraRate" onclick="checkRecord();" /></td>
                                  <!--    <td colspan="1"><html:select property="txtType" name="hraInfo" disabled="true" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                      <!--  <html:option value="ALL">ALL</html:option> -->
                                       <!-- <html:option value="CDA">CDA</html:option>
                                        <html:option value="IDA">IDA</html:option>
                                        <html:option value="IDA1">IDA1</html:option>
                                        <html:option value="CDA">CDA1</html:option>
                                        </html:select></td>  -->
                <td>   <html:text property="txtType" name="hraInfo" style="width:60%"  styleClass="required" readonly="true" alt="<%=String.valueOf(i)%>"  onchange="checkDuplicacy(this,this.alt);changed(this.alt);"   />                                      
                                      
                                      <logic:equal name="hraInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency" onclick="ShowType(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="hraInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  enabled onclick="ShowType(this.alt);" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="hraInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  onclick="ShowType(this.alt);" >                                       
                                      </logic:equal>
                                      </td>
                                       <!-- <td colspan="1"><html:select property="txtTypeofCity" name="hraInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                        <html:option value="">-----------Please Select-----------</html:option>
                                        <html:option value="A-1">A1- City</html:option>
                                        <html:option value="A">A City</html:option>
                                        <html:option value="B-1">B1-City</html:option>
                                        <html:option value="B-2">B2-City</html:option>

                                         </html:select></td> --> 
                
           <!--      <td colspan="1"><html:select property="txtTypeofCity" name="hraInfo" disabled="true" styleClass="required" alt="<%=String.valueOf(i)%>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                <html:option value="" >-----------Please Select-----------</html:option>      
                <logic:present name="CCACities">
                  <html:optionsCollection label="label" value="value" property="cityList" name="CCACities"/>
                </logic:present>
              </html:select></td> -->
              
               <td ><html:text property="txtTypeofCity" name="hraInfo" size="19"   styleClass="required" readonly="true"  alt="<%=String.valueOf(i)%>" style="width:60%" onchange="return changed(this.alt);"  />         
                                        <logic:equal name="hraInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite" onclick="ShowTypeofCity(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="hraInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite"  enabled onclick="ShowTypeofCity(this.alt);" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="hraInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite"  onclick="ShowTypeofCity(this.alt);" >                                       
                                      </logic:equal>
  


                                       <td ><html:text property="txtHRAAmt" name="hraInfo" size="9" disabled="true" maxlength = "3" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                       if (!percent_Check(this.value))
                                            return false;
                                       else
                                           changed(this.alt);
                                       " /></td>                                               

                                    <td><html:text property="txtEffDate" name="hraInfo" styleClass="required" readonly="true" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i)%>" onchange="checkDate(this.alt);changed(this.alt); " />       
                                      <logic:equal name="hraInfo" property="status" value="N">
                                        <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>                                      
                                       <logic:equal name="hraInfo" property="status" value="Q">
                                       <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>"  onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>                                      
                                       <logic:equal name="hraInfo" property="status" value="U">
                                       <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>"  onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>
                                    </td>                                    
                                       
                                     
                                       <html:hidden property="itemChecked" name="hraInfo" />
                                       <html:hidden property="status" name="hraInfo" />
                                       <html:hidden property="detailId" name="hraInfo" />
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="hraInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintHraRate" value="notchecked" /></td>
                                       <td ><html:hidden property="txtType" name="hraInfo" /></td>
                                       <td ><html:hidden property="txtTypeofCity" name="hraInfo" /></td>
                                       <td ><html:hidden property="txtHRAAmt" name="hraInfo" /></td>
                                       <td ><html:hidden property="txtEffDate" name="hraInfo" /></td>                                                                                                                    
                                       <html:hidden property="itemChecked" name="hraInfo" />
                                       <html:hidden property="status" name="hraInfo" />
                                       <html:hidden property="detailId" name="hraInfo" />
                                    </tr>
                                  </logic:equal>                                    
                           </logic:iterate>                           
                                 
                                       

                                         
                                 </TBODY>
                                </TABLE>
                              </DIV>
                             </TD>
                            </TR>                     
          
              <!-- Get details starts -->
                            <tr>
                              <td colspan=11>	
                                <TABLE border=0>
                                  <TBODY>
                                  <TR>
                                <td colspan=11>	
                                  <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                              </TD>                                  
                              </TR>
                                </TBODY>
                              </TABLE>
                             </TD>
                            </tr>
                          
                          </TBODY>
                        </TABLE>
                      </td>
                    </tr>
                  </TABLE>
                </td>
	            </tr>
                <!-- Tab Table Ends -->

                <!-- Bottom Blue Bar -->
             <TR>
                     <td align=center bgcolor=#4682b4 width="40%"></td>
                     <td  bgcolor=#4682b4></td>
                     <td bgColor=#4682b4></td>
                     <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
             </TR>
	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>


<!-- Container Table Ends -->
<html:hidden property="headerPrimaryKey" name="frmMaintHraRate" value="Default" />
<html:hidden property="screenMode" name="frmMaintHraRate"  />
<html:hidden name="frmMaintHraRate"  property="screenName" value="HraAllScreen" />
<html:hidden name="frmMaintHraRate"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmMaintHraRate"  />
<html:hidden property="lovKey" name="frmMaintHraRate"  />
<html:hidden property="txtFields" name="frmMaintHraRate"  />
<html:hidden property="txtSearchFields" name="frmMaintHraRate"  />
<html:hidden property="txtDisplayFields" name="frmMaintHraRate"  />
<html:hidden property="txtIndex" name="frmMaintHraRate"  />
<html:hidden property="txtInputField" name="frmMaintHraRate"  />
<input type="hidden" name="queryParam" />
</html:form>
</body>
</html:html>

                        
                        
         


<script language="javascript">

function lfnLoad()
{
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
      doQueryMode();
  }  
 if(screenmode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }
  if(screenmode=='U')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";

  
  }
  if(screenmode=='Q')
     {
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
     } 




  else
  {
     var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;

      for(i=0; i < iTr2 -1; i++)
      {
         if (document.getElementsByName("status")[i].value == 'N')
          {      
          
            document.getElementsByName("txtType")[i].disabled="";
            document.getElementsByName("txtTypeofCity")[i].disabled="";
            document.getElementsByName("txtHRAAmt")[i].disabled="";
            document.getElementsByName("txtEffDate")[i].disabled="";
          }
      }
   }

  detMenuHandling(screenmode);
  if(document.all.hdnEmpLbrFlag.value=='V')
    {
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
    }
 }

function doQueryMode()
{
  frmMaintHraRate.action="../../../HraQueryAction.do"
  frmMaintHraRate.submit();
}


 function changed(val)
{
   frmMaintHraRate.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}


    

function doBaseAddRow()
{
  enable();
  if(mandatory_Check("frmMaintHraRate"))
  {
     var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
     var iTr2 = oTable.rows.length;
      for(i=0; i < iTr2 -1; i++)
      {
            document.getElementsByName("txtType")[i].disabled="";
            document.getElementsByName("txtTypeofCity")[i].disabled="";
            document.getElementsByName("txtHRAAmt")[i].disabled="";
            document.getElementsByName("txtEffDate")[i].disabled="";
      }
      
    document.forms[0].action = "../../../HraAllAddRowAction.do";
    document.forms[0].submit();
  }
  else
  {
      return false;
  }
}




function SaveRecord()
{
 
  if(mandatory_Check("frmMaintHraRate"))
  { 
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;


  
  for(i=0; i < iTr2 -1; i++)
  {
        document.getElementsByName("txtType")[i].disabled="";
        document.getElementsByName("txtTypeofCity")[i].disabled="";
        document.getElementsByName("txtHRAAmt")[i].disabled=""   
        document.getElementsByName("txtEffDate")[i].disabled="";

      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintHraRate.detailDataChanged.value = "true";
  }

  frmMaintHraRate.headerFields.value = "false";
  enable();
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintHraRate.action = "../../../HraAllSaveAction.do";
  // frmMaintHraRate.totalDetailRecord.value=parseInt(iTr2)-1;
  frmMaintHraRate.submit();
}
 else
  {
    return false;
  }
}


function doQueryMode()
{
  
  frmMaintHraRate.action="../../../HraQueryAction.do"
  frmMaintHraRate.submit();
}

function GetDetail()
{
  document.all.screenMode.value='U'; 
  frmMaintHraRate.action="../../../HraAllGetDetailAction.do"
  frmMaintHraRate.submit();
}


function checkDuplicacy(that,rInd)
{
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName("txtType")[rInd-1].value;
  newComb = newComb + "-";
  newComb = newComb + document.getElementsByName("txtTypeofCity")[rInd-1].value;

  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(ind != rInd)
    {
      oldComb = document.getElementsByName("txtType")[ind-1].value;
      oldComb = oldComb + "-";
      oldComb = oldComb + document.getElementsByName("txtTypeofCity")[ind-1].value;
      if(oldComb == newComb)
      {
        alert("You can\'t enter duplicate value");
        document.getElementsByName("txtType")[rInd-1].focus();
        return;
      }
    }
  }
}



function enable()
{
 var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
        document.getElementsByName("txtType")[i].disabled="";
        document.getElementsByName("txtTypeofCity")[i].disabled="";
        document.getElementsByName("txtHRAAmt")[i].disabled=""         
  }
 }
 

function doRefresh()
{
  frmMaintHraRate.action="../../../HraAllRefresh.do"
  frmMaintHraRate.submit();
}
     


function doBaseDelRow()
{
  enable();  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  var strRecList='';
  for(i=0; i < iTr2 -1; i++)
  {
      document.getElementsByName("txtType")[i].disabled="";
      document.getElementsByName("txtTypeofCity")[i].disabled="";
      document.getElementsByName("txtHRAAmt")[i].disabled=""         
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("detailId")[i].value=="" )
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
        document.all.detailDataChanged.value="true";
      }
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
   
  document.forms[0].action = "../../../HraAllDeleteRowAction.do";
  document.forms[0].submit();  
}


 function checkDate(i)
{
   if(document.getElementsByName("status")[i-1].value!='N')
   {
    document.getElementsByName("txtHRAAmt")[i-1].disabled="";
    document.getElementsByName("txtHRAAmt")[i-1].value="";
   }
}

function ShowType(i)
{
   frmMaintHraRate.lovKey.value = "HRATypeLOV" + frmMaintHraRate.screenName.value + frmMaintHraRate.screenMode.value;
   frmMaintHraRate.txtDisplayFields.value = "txtType";
   frmMaintHraRate.txtSearchFields.value = "";
   frmMaintHraRate.txtIndex.value =i; 
   frmMaintHraRate.txtInputField.value ="txtType"; 
   frmMaintHraRate.queryParam.value ="";
   
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintHraRate');
    return true;
}

function ShowTypeofCity(i)
{
   frmMaintHraRate.lovKey.value = "HRATypeofCityLOV" + frmMaintHraRate.screenName.value + frmMaintHraRate.screenMode.value;
   frmMaintHraRate.txtDisplayFields.value = "txtTypeofCity";
   frmMaintHraRate.txtSearchFields.value = "";
   frmMaintHraRate.txtIndex.value =i; 
   frmMaintHraRate.txtInputField.value ="txtTypeofCity"; 
   if(document.getElementsByName("txtType")[i].value!="" )
   {
   frmMaintHraRate.queryParam.value ="txtType="+document.getElementsByName("txtType")[i].value;
   }
   else
   {
   alert("Please Select the Pay Scale Type first");
   return;
   }
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmMaintHraRate');
    return true;
}
</script>

