<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
   <script language="JavaScript1.2" src="../INCLUDES/Payroll.js"></script>
   <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintGISRates" name="frmMaintGISRates" type="FCIPAY.Payroll.WEBTIER.Form.MaintGISRatesForm" scope="session">
<bean:define id="ParentForm" name="frmMaintGISRates" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="txtIndex" name="frmMaintGISRates"  />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>



<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN GIS RATES</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
 <html:errors/>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>

   <TR>
    <TD>    

       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0>
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=2>Header For Maintain GIS Rates</TD>
        </TR>
        <TR>
              <TD colspan=2 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>

            <td class="labelText"  width="50%" >Type Of GIS</td>
            <td><html:select property="headerPrimaryKey" styleClass="required" >
                <html:option value="" >-----------Please Select-----------</html:option> 
                <html:option value="CGIS" >CGIS </html:option>                                                                                  
                                   </html:select></td>            
        </tr>

           <tr height="10">		    
        <TD colspan="2" > </TD>
      </tr>
   	 </table>
    
 	       <TR height="200">
            <TD colspan=6>
    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > GIS Rates Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                <TBODY>
                                <TR height="22">
                                      <td class=tableHeader width="2%"><html:checkbox property="selectAll" value="" onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                      <td class=tableHeader width="20%">Category</td>
                                      <td class=tableHeader width="24%">Rate</td>
                                      <td class=tableHeader width="30%">Effective Date</td>
                                      </tr> 
                             <logic:iterate id="GISRatesInfo" name="frmMaintGISRates" property="lstIdaInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintGISRatesBean" indexId="idx" >
                              <% ++i; %>
                               <logic:notEqual name="GISRatesInfo" property="status" value="D" >  
                                   <tr>
                                        <td align = "center"><html:checkbox property="checked" onclick="checkRecord();"   name="frmMaintGISRates" /></td>
                                      <!--  <td><html:select property="txtGroup" name="GISRatesInfo"  styleClass="required" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt)"   >
                                        <html:option value=" ">--------------------------------Please Select--------------------------------</html:option>
                                        <html:option value="1">A</html:option>
                                        <html:option value="2">B</html:option>
                                        <html:option value="3">C</html:option>
                                        <html:option value="4">D</html:option>
                                        </html:select></td>  -->
                                      <td>
                                      <logic:notEqual name="GISRatesInfo" property="status" value="N" >
                                      <html:select property="txtGroup"  styleClass="required" name="GISRatesInfo" style="width:100%" disabled="true"  alt="<%=String.valueOf(i) %>" onchange="DupliCheck(this.alt); changed(this.alt);"  >
                                          <html:option value="" >-----------Please Select-----------</html:option>      
                                          <logic:present name="GISCombo">
                                            <html:optionsCollection label="label" value="value" property="ctgryArr" name="GISCombo"/>
                                          </logic:present>
                                        </html:select>
                                      </logic:notEqual>
                                      <logic:equal name="GISRatesInfo" property="status" value="N" >
                                      <html:select property="txtGroup"  styleClass="required" name="GISRatesInfo" style="width:100%" disabled=""  alt="<%=String.valueOf(i) %>" onchange="DupliCheck(this.alt); changed(this.alt);"  >
                                          <html:option value="" >-----------Please Select-----------</html:option>      
                                          <logic:present name="GISCombo">
                                            <html:optionsCollection label="label" value="value" property="ctgryArr" name="GISCombo"/>
                                          </logic:present>
                                        </html:select>
                                      </logic:equal>
                                      </td>

                                      <td >
                                      <logic:notEqual name="GISRatesInfo" property="status" value="N" >
                                      <html:text property="txtRate" maxlength="9" name="GISRatesInfo" disabled="true"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i) %>" onchange="
                                        if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                        " />
                                        </logic:notEqual>
                                       <logic:equal name="GISRatesInfo" property="status" value="N" >
                                       <html:text property="txtRate" maxlength="9" name="GISRatesInfo" disabled=""  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i) %>" onchange="
                                        if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                        " />
                                        </logic:equal>
                                        </td>
                                   <!--     <td><html:text property="txtEffDate" name="GISRatesInfo"  styleClass="required" size="26" style="width:95%;text-align:center" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt)" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtEffDate',this)" /></td>   -->
                                    <td><html:text property="txtEffDate" name="GISRatesInfo" readonly="true"  styleClass="required" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt); " />
                               <!--     <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtEffDate',this)" />  -->
                                      <logic:equal name="GISRatesInfo" property="status" value="N">
                                        <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>                                      
                                       <logic:equal name="GISRatesInfo" property="status" value="Q">
                                       <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" disabled onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>                                      
                                       <logic:equal name="GISRatesInfo" property="status" value="U">
                                       <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" disabled onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>


                                    </td>
                                       <html:hidden property="itemChecked" name="GISRatesInfo" />
                                       <html:hidden property="status" name="GISRatesInfo" />
                                       <html:hidden property="detailId" name="GISRatesInfo" value="Default"/>
                                   
                                </tr>
                                 </logic:notEqual>                               
                                 
                                <logic:equal name="GISRatesInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintGISRates" value="notchecked" /></td>
                                       <td ><html:hidden property="txtGroup" name="GISRatesInfo" /></td>
                                       <td ><html:hidden property="txtRate" name="GISRatesInfo" /></td>
                                       <td ><html:hidden property="txtEffDate" name="GISRatesInfo" /></td>
                                       <html:hidden property="itemChecked" name="GISRatesInfo" />
                                       <html:hidden property="status" name="GISRatesInfo" />
                                       <html:hidden property="detailId" name="GISRatesInfo" value="Default"/>
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
                                <!--  <TR>
                                    <TD><html:button value='Get Detail '  onclick="GetDetail()" property="butGetDetail" styleClass="bottomBarText" /> <html:button value='  Add Row '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /> <html:button value='Delete Row'  onclick="deleteRow()" property="butDelete" styleClass="bottomBarText" /></TD>
                                    <td width=46%> </td>	
                                    <TD ><IMG src="../INCLUDES/IMAGES/butn_dtl_prev.jpg" onmouseover='this.src="../INCLUDES/IMAGES/butn_dtl_prev_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/butn_dtl_prev.jpg"' alt=Butn_prev src="../INCLUDES/butn_dtl_prev.jpg"></td>
                                    <td class=dtlNavText>1 of 10</td>
                                    <td align=right><IMG src="../INCLUDES/IMAGES/butn_dtl_next.jpg" onmouseover='this.src="../INCLUDES/IMAGES/butn_dtl_next_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/butn_dtl_next.jpg"' alt=Butn_next src="../INCLUDES/butn_dtl_next_act.jpg"></td>
                                    <td align=right><input type="text" name="hdrGoto" size="1"></td>
                                    <td><input type="image" src="..\INCLUDES\IMAGES\go_dtl.jpg"></td>		     
                                  </TR> -->
                                 <tr>
                                  <td colspan=11>	
                                  <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                                 </TD>
                                 </tr>
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
<html:hidden name="frmMaintGISRates"  property="screenMode"  />
<html:hidden name="frmMaintGISRates"  property="screenName" value="MaintGISRatesScreen" />
<html:hidden name="frmMaintGISRates"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintGISRates"  />
<html:hidden property="buttonFlag" name="frmMaintGISRates"  />
<html:hidden property="userPageRequested" name="frmMaintGISRates" />
<html:hidden property="pageRequested" name="frmMaintGISRates" />


</html:form>
</body>
</html:html>

                        
                        
         


<script language="javascript">


var chkMes =0;
    
 function changed(val)
{
 
  frmMaintGISRates.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}


  

function doBaseAddRow()
{
  document.all.buttonFlag.value='D';  
  EnableFields();

  if(mandatory_Check("frmMaintGISRates"))
  {
   document.forms[0].action = "../../../GISRatesAddRowAction.do";
  document.forms[0].submit();
  }
  else
  {
      return false;
  }
}

function doBaseDelRow()
{
  document.all.buttonFlag.value='D';  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

   var flag = 0;
   for(i=0; i < iTr2 -1; i++)
    {
        if(document.getElementsByName("checked")[i].checked)
        {
            flag=flag+1;
        }
    }  
    if ( flag == 0)
    {
        alert("Please check the rows to be deleted");
        return false;
    }

  var strRecList='';
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("txtGroup")[i].value=="" )
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
        document.all.detailDataChanged.value="true";
      }
      else
      {
        strRecList=strRecList+(i+1)+",";
      }
    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
   
  EnableFields();
  document.forms[0].action = "../../../GISRatesdeleteRowAction.do";
  document.forms[0].submit();  
}


function GetDetail()
{
  if(frmMaintGISRates.headerPrimaryKey.value == '')
  {
    alert("Mandatory Field is empty");
    frmMaintGISRates.headerPrimaryKey.focus();
    return;
  }
  else
  {document.all.buttonFlag.value='';
  frmMaintGISRates.headerPrimaryKey.value=frmMaintGISRates.headerPrimaryKey.value;
  document.all.screenMode.value='U';
  frmMaintGISRates.headerPrimaryKey.disabled="";
  frmMaintGISRates.action="../../../GISRatesFirstGetDetailAction.do"
  frmMaintGISRates.submit();
  }


/*  document.all.buttonFlag.value='';  
  document.all.screenMode.value='U';
  frmMaintGISRates.action="../../../GISRatesFirstGetDetailAction.do"
  frmMaintGISRates.submit();  */
}




function SaveRecord()
{
 document.all.buttonFlag.value='';  
 if(!mandatory_Check("frmMaintGISRates"))
        return false;      

 /*if(!DupliCheck())
      return false;*/


  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  
  for(i=0; i < iTr2 -1; i++)
  {
        document.getElementsByName("txtGroup")[i].disabled="";
        document.getElementsByName("txtRate")[i].disabled="";
        document.getElementsByName("txtEffDate")[i].disabled=""   

      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintGISRates.detailDataChanged.value = "true";
  }

  frmMaintGISRates.headerPrimaryKey.value=frmMaintGISRates.headerPrimaryKey.value;
  frmMaintGISRates.headerFields.value = "false";
  frmMaintGISRates.totalDetailRecord.value = parseInt(iTr2,10) - 1;
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintGISRates.action = "../../../GISRatesSaveAction.do";
  frmMaintGISRates.submit();
}
 

function DupliCheck(i)
{
            var oTable = document.getElementById("Detail");
            var iTr2 = oTable.rows.length;
            var flag =0;
            var j;
            j = 0;
            var Group1 = document.getElementsByName("txtGroup")[i-1].value;
            for(j=0;j<iTr2-1;j++)                
            {                       
              if((i-1)!=j)
              {
                var Group2 = document.getElementsByName("txtGroup")[j].value;
                if(Group1==Group2)
                {
                  var resp=confirm("Are You sure you want to end the previous Record???");
                  if(resp==false)
                  {
                    document.getElementsByName("txtGroup")[i-1].value="";
                    return false;
                  }else
                  {
                    return true;
                  }
                }
              }
            }  
        return true;
}




function doInsertMode()
{
//  alert("new");
 // frmMaintGISRates.action="../../../GISRatesNewMode.do"
//  frmMaintGISRates.submit();

}

function doQueryMode()
{
  document.all.buttonFlag.value='';  
  frmMaintGISRates.action="../../../GISRatesQueryMode.do"
  frmMaintGISRates.submit();

}



function lfnLoad()

{

/*
  mode = document.all.screenMode.value;
  if(mode=='')
   {
     doQueryMode();
     document.all.butInsert.disabled="disabled"
     document.all.butDelete.disabled="disabled"
   }
  if(mode=='Q')
   {
     document.all.butInsert.disabled="disabled"
     document.all.butDelete.disabled="disabled"
   }
  
  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
    //  EnableFields();
  }
  if(mode=='U')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";

      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
 
         var oTable = document.getElementById("Detail");
          if(oTable == null)
          {
            return;
          }
          var iTr2 = oTable.rows.length;
          var i = 0;

        for(i=0; i < iTr2 -1; i++)
        {
           if (document.getElementsByName("status")[i].value == 'Q')
            {      
          
              document.getElementsByName("txtGroup")[i].disabled="disabled";
              document.getElementsByName("txtEffDate")[i].disabled="disabled"; 
            }
        }
   } 

  mode1 = frmMaintGISRates.screenMode.value; 
  detMenuHandling(mode1); */

 var mode;
 mode=document.all.screenMode.value;

 
  
  mode=document.all.screenMode.value;
  if(mode=='')
  {
    doQueryMode();
  }
  menuHandling(mode);   

  if (mode == "N")
 {
 frmMaintGISRates.butGetDetail.disabled="true";
 frmMaintGISRates.butInsert.disabled="";
 frmMaintGISRates.butDelete.disabled="";
 }
  else if(mode=="U" )
  {
  frmMaintGISRates.butGetDetail.disabled="true";
  frmMaintGISRates.butInsert.disabled="";
  frmMaintGISRates.butDelete.disabled="";
  frmMaintGISRates.headerPrimaryKey.disabled="true";  
  }
  else if(mode=="Q" )
  {
  frmMaintGISRates.butGetDetail.disabled="";
  frmMaintGISRates.butInsert.disabled="true";
  frmMaintGISRates.butDelete.disabled="true";
  }
  
  document.all.butExecute.disabled="true"; 
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
  document.all.butInsertMode.disabled="true";
  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
  document.all.butDel.disabled="true";
  document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
  
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
        document.getElementsByName("txtGroup")[i].disabled="";
        document.getElementsByName("txtRate")[i].disabled="";
         document.getElementsByName("txtEffDate")[i].disabled="";
             
  }
 }

function showCalendar(inputId, butId) {
   if(butId.alt)
   {
    iIndex=butId.alt;
   }
   else
   {
    iIndex="-1";
   }
   Calendar.setup({inputField	: inputId,
		   ifFormat	: "%d-%b-%Y",
		   button	: butId,
       position: iIndex
  		  });
   return false;
}




function doBasePrevDetail()
{
    frmMaintGISRates.userPageRequested.value = 1*frmMaintGISRates.pageRequested.value - 1;
    frmMaintGISRates.action = "../../../GISRatesPrevDetailAction.do";
    frmMaintGISRates.submit();
}


function doBaseNextDetail()
{
    frmMaintGISRates.userPageRequested.value = 1*frmMaintGISRates.pageRequested.value + 1;
    frmMaintGISRates.action = "../../../GISRatesNextDetailAction.do";
    frmMaintGISRates.submit();
}

function JumpDetail()
{
    frmMaintGISRates.userPageRequested.value = 1*frmMaintGISRates.newPageRequested.value ;
    frmMaintGISRates.action = "../../../GISRatesNextDetailAction.do";
    frmMaintGISRates.submit();
}


function EnableFields()
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
              document.getElementsByName("txtGroup")[i].disabled="";
              document.getElementsByName("txtRAte")[i].disabled="";
              document.getElementsByName("txtEffDate")[i].disabled=""; 
      }
}



 function checkDate(i)
  {
   var m = document.getElementsByName("txtEffDate")[i].value;
     if(m != "")
     {
        if(!isDate(m,"dd-MMM-yyyy"))
      {
      alert("Enter Proper Effective Date  in the Format DD-MMM-YYYY");
      return false;
      }
    }    
    return true;
  }
 
function doRefresh()
{
    frmMaintGISRates.action = "../../../GISRatesRefresh.do";
    frmMaintGISRates.submit();
}


</script>
