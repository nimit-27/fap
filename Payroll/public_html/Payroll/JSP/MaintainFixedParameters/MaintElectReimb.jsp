<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

     <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="ElectReimbBase" name="frmMaintElectReimb" type="FCIPAY.Payroll.WEBTIER.Form.MaintElectReimbForm" scope="session">
<bean:define id="ParentForm" name="frmMaintElectReimb" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN ELECTRICITY REIBURSEMENT RATES</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border= 0 >
  <TBODY>
   <TR>
    <TD>


    
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 border = 0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=2>Header For Maintain Electricity Reimbursement</TD>
        </TR>
        <TR>
              <TD colspan=12 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintTransport.date" /></td>
            <td align="left">
            <html:text  property="txtEffectDate" altKey="Payroll.MaintTransport.date" maxlength="10" size="16" styleClass="required" />            <logic:equal property= "screenMode" name= "frmMaintElectReimb" value="Q">            
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov"  property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onclick="showCalendar('txtEffectDate',this)" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'"  />
            </logic:equal>
            <logic:notEqual property= "screenMode" name= "frmMaintElectReimb" value="Q">            
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov"  property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtEffectDate',this)" />
            </logic:notEqual>               
            </td>
        </tr>                   
           <tr height="10">		    
        <TD colspan="2" > </TD>
      </tr>
   	 </table>    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	       <TR height="200">
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >              
                <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>Electricity Rates Detail<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                            <DIV id=divDtlTable style="height:280px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                <TBODY>
                                  <TR height="22">
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>                                             
                                              <TD class=tableHeader width="15%">Amount From</TD>
                                              <TD class=tableHeader width="15%">Amount To</td>
                                              <TD class=tableHeader width="15%">Allowance</td>
                                               </tr> 


                             <logic:iterate id="ElectReimbInfo" name="frmMaintElectReimb" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintElecReimbBean" >
                              <% ++i; %>
                               <logic:notEqual name="ElectReimbInfo" property="status" value="D" >  
                                   <tr>
                                       <td ><html:checkbox property="checked" onclick="checkRecord();" value="" name="frmMaintElectReimb" /></td>

                                       <td ><html:text property="startField" name="ElectReimbInfo" size="5" styleClass="required" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                      if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                     /*   if(!(chk_FromAmount(this.value, this.alt)))
                                        {
                                        }*/
                                        else
                                        {
                                          return changed(this.alt);
                                        }                                                                                                                    
                                      " /></td>
                                  
                                       <td ><html:text property="endField" name="ElectReimbInfo" size="5" styleClass="required" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                        if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       if(!(AmtCheck()))
                                          {
                                          }
                                       else
                                          {
                                            changed(this.alt);
                                          } 
                                       changeDtlStartField('startField','endField', this.alt,'0');
                                                                             
                                       " /></td>
                                       
                                       <td ><html:text property="txtAllow" name="ElectReimbInfo"  styleClass="required" size="6" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                        if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                       " /></td>
                                       <html:hidden property="hdnSrlNo" name="ElectReimbInfo" />                                                                                                                      
                                       <html:hidden property="itemChecked" name="ElectReimbInfo" />
                                       <html:hidden property="status" name="ElectReimbInfo" />
                                       <html:hidden property="detailId" name="ElectReimbInfo" value="Default"/>
                                   
                                </tr>
                                 </logic:notEqual>                               
                                 
                                <logic:equal name="ElectReimbInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintElectReimb" value="notchecked" /></td>
                                       <td ><html:hidden property="txtAllow" name="ElectReimbInfo" /></td>                                       
                                       <td ><html:hidden property="startField" name="ElectReimbInfo" /></td>
                                       <td ><html:hidden property="endField" name="ElectReimbInfo" /></td>                                       
                                       <html:hidden property="hdnSrlNo" name="ElectReimbInfo" />                                                                               
                                       <html:hidden property="itemChecked" name="ElectReimbInfo" />
                                       <html:hidden property="status" name="ElectReimbInfo" />
                                       <html:hidden property="detailId" name="ElectReimbInfo" value="Default"/>
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

<html:hidden name="frmMaintElectReimb"  property="screenMode"  />
<html:hidden property="headerPrimaryKey" name="frmMaintElectReimb" />
<html:hidden property="positionRequested" name="frmMaintElectReimb" />
<html:hidden property="userPositionRequested" name="frmMaintElectReimb" />
<html:hidden name="frmMaintElectReimb"  property="screenModeElecReimb"  />
<html:hidden name="frmMaintElectReimb"  property="screenName" value="ElecReimbScreen" />
<html:hidden name="frmMaintElectReimb"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintElectReimb"  />
<html:hidden property="buttonFlag" name="frmMaintElectReimb"  />
<html:hidden property="userPageRequested" name="frmMaintElectReimb" />
<html:hidden property="pageRequested" name="frmMaintElectReimb" />
</html:form>
</body>
</html:html>

                        
                        
         


<script language="javascript">
  var chkMes =0;
  
 function changed(val)
{
 
  frmMaintElectReimb.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}


 function doBaseAddRows2()
{
    document.all.buttonFlag.value='D';  
    if(!mandatory_Check("frmMaintElectReimb"))
    return false;


    var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      } 
      var iTr2 = oTable.rows.length;
      var i = 0;
       for(i=0; i < iTr2 -1; i++)
         {
            document.getElementsByName("startField")[i].disabled="";
         }
    frmMaintElectReimb.screenModeElecReimb.value = "N1";
    frmMaintElectReimb.detailDataChanged.value = "false";    
    document.getElementById("txtEffectDate").disabled="";
    document.getElementById("headerPrimaryKey").disabled="";

    
    frmMaintElectReimb.action = "../../../ConvAllowALLAddRowAction.do";
    frmMaintElectReimb.submit();
}


  function doBaseAddRow()
  {
    document.all.buttonFlag.value='D';  
    if(!mandatory_Check("frmMaintElectReimb"))
    return false;

    frmMaintElectReimb.screenModeElecReimb.value = "N1";
    frmMaintElectReimb.detailDataChanged.value = "false";    
    document.getElementById("txtEffectDate").disabled="";
    document.getElementById("headerPrimaryKey").disabled="";

    
    frmMaintElectReimb.action = "../../../ElecReimbAddRowAction.do";
    frmMaintElectReimb.submit();
  }



 function doBaseAddRowS()
{
  document.all.buttonFlag.value='D';  
  if(mandatory_Check("frmMaintElectReimb"))
  {
  frmMaintElectReimb.headerPrimaryKey[0].disabled="";
   document.forms[0].action = "../../../ConvAllowALLAddRowAction.do";
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
 
  for(i=0; i < iTr2 -1; i++)
  {

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintElectReimb.detailDataChanged.value = "true";      
    }

  }
   
  
  frmMaintElectReimb.headerPrimaryKey.disabled="";
  document.forms[0].action = "../../../HistEntryDeleteRow.do";
  document.forms[0].submit();  
}



  function GetDetail()
  {
    document.all.buttonFlag.value='';
    document.all.screenModeElecReimb.value='UG';
   document.getElementById("txtEffectDate").disabled="";      
    frmMaintElectReimb.txtEffectDate.value = frmMaintElectReimb.txtEffectDate.value ;  
    frmMaintElectReimb.action="../../../ElecReimbGetDetailAction.do"
    frmMaintElectReimb.submit();
  }


function SaveRecord()
{
document.all.buttonFlag.value='';
document.all.screenMode.value = "U";

   if(!mandatory_Check("frmMaintElectReimb"))
        return false;      

  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }

  var iTr2 = oTable.rows.length;
  var i = 0;
   for(i=0; i < iTr2 -1; i++)
  {
      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintElectReimb.detailDataChanged.value = "true";
        document.getElementsByName("startField")[i].disabled="";           
  }

    document.getElementById("txtEffectDate").disabled="";  
    document.all.butSave.disabled="true";        
    if (document.all.screenMode.value == "N")
    {
       document.all.screenModeElecReimb.value = "UG";
       document.all.screenMode.value = "U";    
    }  

	document.all.butSave.disabled="true";          
	frmMaintElectReimb.headerPrimaryKey.value = frmMaintElectReimb.txtEffectDate.value ;
	frmMaintElectReimb.totalDetailRecord.value = parseInt(iTr2,10) - 1;
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";

	frmMaintElectReimb.action = "../../../ElecReimbSaveAction.do";
	frmMaintElectReimb.submit();
 
}



 
function AmtCheck()
{
            var oTable = document.getElementById("Detail");
            var iTR = oTable.rows.length;
            var flag =0;
            
            for(i=0;i<iTR-1;i++)
            {   
                var m = parseInt(document.getElementsByName("startField")[i].value);
                var n= parseInt(document.getElementsByName("endField")[i].value);               

                if (m >= n)
                {
                   alert("Amount To Should Be Greater Than Amount From");
                   document.getElementsByName("endField")[i].focus(); 
                   return false;
                }                             
                                 
            }             
 
        return true;
}
 



function doGetTab(arg)
  {

   document.all.buttonFlag.value='';  
   /* if(frmMaintElectReimb.detailDataChanged.value == "true")
    {
        alert("Please save the data");
        return false;                        
    }*/
 
    frmMaintElectReimb.headerPrimaryKey[0].disabled="";
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../ConvAllTabAction.do";
    document.forms[0].submit();
  }


function chk_FromAmount(fieldval, rowval)
{
      if(num_Check(fieldval,0))  
      {
        if (chk_PrevAmount(rowval))
        {
          if (chk_FromToAmount(rowval)) 
          {
          changed(rowval);
            chkMes = 0;
            return true;            
          }
          else
          {
            chkMes = 1;
            return false;
          }
        }
        else
        {
          chkMes = 1;        
          return false;        
        }
      }
      else
      {
        chkMes = 1;      
        return false;
      }
}



function chk_ToAmount(fieldval, rowval)
{
      if (chkMes == 0)
      {
          if(num_Check(fieldval,0))  
          {
            if (chk_ToFromAmount(rowval)) 
            {
              changed(rowval);
                return true;
            }
            else
            {
              return false;        
            }
          }
          else
          {
            return false;
          }
          return true;
      }
      return true;
}



function chk_PrevAmount(i)
    {      
           var from = parseInt(document.getElementsByName("txtAmtFrom")[i-1].value);
           if (i>1)
           {
                var p = parseInt(document.getElementsByName("txtAmtTo")[i-2].value);
                if (from != p+1)
                {
                  // alert(" Amount From  Should Be One Greater Than Previous Rows Amount To ");
//                   document.getElementsByName("txtAmtFrom")[i-1].select(); 
                    document.getElementsByName("txtAmtFrom")[i-1].focus(); 
                   chkMes = 1;
                   return false;                      
                }                 
           }
           return true;
   }


function chk_FromToAmount(i)
{        
    var from = parseInt(document.getElementsByName("txtAmtFrom")[i-1].value);          
    var to = parseInt(document.getElementsByName("txtAmtTo")[i-1].value);
   
    if(to <= from )
    {
      alert("Amount To Should be greater than Amount From ");
      document.getElementsByName("txtAmtTo")[i-1].focus();             
      return false;                        
    }
    else
    return true;
}

function chk_ToFromAmount(i)
{              
    var from = parseInt(document.getElementsByName("txtAmtFrom")[i-1].value);          
    var to = parseInt(document.getElementsByName("txtAmtTo")[i-1].value);
   
    if(to <= from )
    {
       alert("Amount To Should be greater than Amount From ");
      document.getElementsByName("txtAmtTo")[i-1].focus();             
      return false;                        
    }
    else
    return true;
}


function doInsertMode()
{
  document.all.buttonFlag.value='';
  document.all.screenMode.value = "N";
  document.all.screenModeElecReimb.value = "N";
  frmMaintElectReimb.action="../../../ElecReimbNewMode.do"
  frmMaintElectReimb.submit();
}

function doQueryMode()
{
   frmMaintElectReimb.headerPrimaryKey.value="";
  document.all.buttonFlag.value='';
  document.all.screenModeElecReimb.value = "Q";
  document.all.screenMode.value = "Q";
  frmMaintElectReimb.action="../../../ElecReimbQueryMode.do"
  frmMaintElectReimb.submit();
}



function lfnLoad()
{  

 mode = frmMaintElectReimb.screenMode.value;

  if(mode == '')
  {
    doQueryMode();
  }


 if (frmMaintElectReimb.screenMode.value == "Q")

     frmMaintElectReimb.screenModeElecReimb.value="Q";

    
  mode = frmMaintElectReimb.screenModeElecReimb.value;
  
  if(mode=='')
   {
     document.all.butGetDetail.disabled="disabled";   
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
   }
  if(mode=='Q')
  {
     document.all.butGetDetail.disabled="disabled";
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";     
  }

 
  if(mode=='U')
  {
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";  
  }

  if(mode=='N')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";      
  }

  if(mode=='UG')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
  }  


 if (frmMaintElectReimb.screenMode.value == 'U')
     { 
        document.getElementById("txtEffectDate").disabled = "true";



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
                }
           }        
     }
  else
      {  
         document.getElementById("txtEffectDate").disabled="";       
      }  
  mode1 = document.all.screenMode.value;
  menuHandling(mode1);      

 
}



function menuHandlings(mode1)
{
  if(mode1=='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
/*      document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";      */  
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg"; 
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
   if(mode1=='')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
/*      document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";    */
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";   
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
/*  if(mode1=='N')
  {
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }*/
  if(mode1=='U')
  {
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";  
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg"; 
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg"; 
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true"; 
          
  }
 
if(document.all.buttonFlag.value=='D')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  
  
  }
}

function doBasePrevDetail()
{
    frmMaintElectReimb.userPageRequested.value = 1*frmMaintElectReimb.pageRequested.value - 1;
    frmMaintElectReimb.action = "../../../ElecReimbNextDetailAction.do";
    frmMaintElectReimb.submit();
}


function doBaseNextDetail()
{

    frmMaintElectReimb.userPageRequested.value = 1*frmMaintElectReimb.pageRequested.value + 1;
    frmMaintElectReimb.action = "../../../ElecReimbNextDetailAction.do";
    frmMaintElectReimb.submit();
}

function JumpDetail()
{
    frmMaintElectReimb.userPageRequested.value = 1*frmMaintElectReimb.newPageRequested.value ;
    frmMaintElectReimb.action = "../../../ElecReimbNextDetailAction.do";
    frmMaintElectReimb.submit();
}

function doRefresh()
  {
   
      frmMaintElectReimb.action = "../../../ElecReimbRefresh.do";
      frmMaintElectReimb.submit();
  }




function getHeaderRecords()
{
	document.all.buttonFlag.value='';
	document.all.screenModeElecReimb.value='U';
	document.all.screenMode.value='U';   
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";

	frmMaintElectReimb.action="../../../ElecReimbGetHeader.do";
	frmMaintElectReimb.submit();
}

  function getHeaderRecord()
  {
    document.all.buttonFlag.value='';  
    document.all.screenModeElecReimb.value='U';
    document.all.screenMode.value='U';      
    frmMaintElectReimb.action="../../../ElecReimbGetHeader.do";
    frmMaintElectReimb.submit();
  }


function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmMaintElectReimb.screenMode.value='U';
    document.all.screenModeElecReimb.value='U';
    frmMaintElectReimb.userPositionRequested.value = 1*frmMaintElectReimb.positionRequested.value + 1;   
    frmMaintElectReimb.action="../../../ElecReimbGetNextHeader.do";
    frmMaintElectReimb.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  document.all.screenModeElecReimb.value='U';  
  frmMaintElectReimb.userPositionRequested.value = frmMaintElectReimb.positionRequested.value - 1;
  frmMaintElectReimb.action = "../../../ElecReimbGetNextHeader.do";
  frmMaintElectReimb.submit();
}  

function JumpHeader()
{
  document.all.buttonFlag.value='';
  document.all.screenModeElecReimb.value='U';
  frmMaintElectReimb.userPositionRequested.value = 1*frmMaintElectReimb.newPositionRequested.value;
  frmMaintElectReimb.action = "../../../ElecReimbGetNextHeader.do";
  frmMaintElectReimb.submit();
}
  
</script>