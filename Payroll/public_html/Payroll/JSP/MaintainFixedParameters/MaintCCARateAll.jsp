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

<html:form  action="MaintCCARate" name="frmMaintCCARate" type="FCIPAY.Payroll.WEBTIER.Form.MaintCCARatesForm" scope="session">
<bean:define id="ParentForm" name="frmMaintCCARate" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN CCA RATES</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
   <TR>
    <TD>


    
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0>
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=2>Header For Maintain CCA Rates</TD>
        </TR>
        <TR>
              <TD colspan=2 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>

            <td class="labelText"  width="50%" >Type Of City</td>
            <td><html:select property="headerPrimaryKey" styleClass="required" >
                <html:option value="" >-----------Please Select-----------</html:option>      
                <logic:present name="CCACities">
                  <html:optionsCollection label="label" value="value" property="cityList" name="CCACities"/>
                </logic:present>
              </html:select></td>            

        </tr>
      <tr>
     <td colspan=2><bean:message key="Payroll.Masters.AmtFromToInfo" /></td> 
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
                    <td bgcolor="#4682B4" nowrap class=actTabText > All <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("cda")> CDA <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("ida")> IDA <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>


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
                                              <td class=tableHeader width="15%">Effective Date</td>                                              
                                              
                                               </tr> 
                             <logic:iterate id="ccainfo" name="frmMaintCCARate" property="lstIdaInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintCCARatesBean" >
                              <% ++i; %>
                               <logic:notEqual name="ccainfo" property="status" value="D" >  
                                   <tr>
                                       <td ><html:checkbox property="checked" onclick="checkRecord();" value="" name="frmMaintCCARate" /></td>

                                       <td ><html:text property="startField" name="ccainfo" size="5" styleClass="required" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
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
                                  
                                       <td ><html:text property="endField" name="ccainfo" size="5" styleClass="required" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
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
                               <!--    <td ><html:text property="txtAllow" name="ccainfo"  styleClass="required" size="6" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="if (num_Check(this.value,1)) return changed(this.alt);" /></td> -->
                                       <td ><html:text property="txtAllow" name="ccainfo"  styleClass="required" size="6" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                        if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                       " /></td>
                                    <td><html:text property="txtEffDate" name="ccainfo"  styleClass="required" size="26" style="width:90%;text-align:center" alt="<%=String.valueOf(i)%>" onchange="
                                    if(!(checkDate(parseInt(this.alt)-1)))
                                     {
                                          this.focus();
                                          return false;                         
                                     }
                                   else
                                       return changed(this.alt); 

                                    " />       
                                      <logic:equal name="ccainfo" property="status" value="N">
                                        <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>                                      
                                       <logic:equal name="ccainfo" property="status" value="Q">
                                       <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" disabled onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>                                      
                                       <logic:equal name="ccainfo" property="status" value="U">
                                       <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" disabled onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>
                                    </td>                                    
                                       <html:hidden property="itemChecked" name="ccainfo" />
                                       <html:hidden property="txtSrlNo" name="ccainfo" />                                        
                                       <html:hidden property="status" name="ccainfo" />
                                       <html:hidden property="detailId" name="ccainfo" value="Default"/>                                   
                                </tr>
                                 </logic:notEqual>                                                                
                                <logic:equal name="ccainfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintCCARate" value="notchecked" /></td>                                      
                                       <td ><html:hidden property="startField" name="ccainfo" /></td>
                                       <td ><html:hidden property="endField" name="ccainfo" /></td>
                                       <td ><html:hidden property="txtAllow" name="ccainfo" /></td>
                                       <td ><html:hidden property="txtEffDate" name="ccainfo" /></td>                                       
                                       <html:hidden property="itemChecked" name="ccainfo" />
                                       <html:hidden property="txtSrlNo" name="ccainfo" />                                        
                                       <html:hidden property="status" name="ccainfo" />
                                       <html:hidden property="detailId" name="ccainfo" value="Default"/>
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
                                  <TR> <TD>
                                    <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" /></TD>
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

<html:hidden name="frmMaintCCARate"  property="screenMode"  />
<html:hidden name="frmMaintCCARate"  property="screenModeAll"  />
<html:hidden name="frmMaintCCARate"  property="screenName" value="CCARateALLScreen" />
<html:hidden name="frmMaintCCARate"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintCCARate"  />
<html:hidden property="flagIda" name="frmMaintCCARate"  />
<html:hidden property="flagCda" name="frmMaintCCARate"  />
<html:hidden property="flagAll" name="frmMaintCCARate"  />
<html:hidden property="buttonFlag" name="frmMaintCCARate"  />
<html:hidden property="userPageRequested" name="frmMaintCCARate" />
<html:hidden property="pageRequested" name="frmMaintCCARate" />

</html:form>
</body>
</html:html>

<script language="javascript">
var chkMes =0;
  
function changed(val)
{ 
  frmMaintCCARate.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
    document.getElementsByName("status")[val-1].value = 'U';
}


    function doGetNextHeader()
    {
      alert("Hi");    
      document.all.buttonFlag.value='';
      document.forms[0].action="/enrgise/TEPPurInfoGetNextHeader.do";
      document.forms[0].submit();
    }

function doBaseAddRow()
{
  if(mandatory_Check("frmMaintCCARate"))
  {document.all.buttonFlag.value='D';
  frmMaintCCARate.headerPrimaryKey.disabled="";
   document.forms[0].action = "../../../ccaRateALLAddRowAction.do";
  document.forms[0].submit();
  }
  else
  {
      return false;
  }
}


function doBaseDelRow()
{
  
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
      frmMaintCCARate.detailDataChanged.value = "true";   
      document.all.buttonFlag.value='D';
    }

  }
   
  frmMaintCCARate.headerPrimaryKey.disabled="";
  document.forms[0].action = "../../../ccaRateALLdeleteRowAction.do";
  document.forms[0].submit();  
}



function GetDetail()
{
  if(frmMaintCCARate.headerPrimaryKey.value == '')
  {
    alert("Mandatory Field is empty");
    frmMaintCCARate.headerPrimaryKey.focus();
    return;
  }
  else
  {document.all.buttonFlag.value='';
  frmMaintCCARate.flagAll.value="true";
  frmMaintCCARate.headerPrimaryKey.value=frmMaintCCARate.headerPrimaryKey.value;
  frmMaintCCARate.screenModeAll.value='U';
  document.all.screenMode.value='U';
  frmMaintCCARate.headerPrimaryKey.disabled="";
  frmMaintCCARate.action="../../../ccaRateALLFirstGetDetailAction.do"
  frmMaintCCARate.submit();
  }
}


function SaveRecord()
{

if(!mandatory_Check("frmMaintCCARate"))
        return false;      


  if(!AmtCheck())
      return false;  
  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  
  for(i=0; i < iTr2 -2; i++)
  {
      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintCCARate.detailDataChanged.value = "true";
  }
  document.all.buttonFlag.value='';
  frmMaintCCARate.headerPrimaryKey.value=frmMaintCCARate.headerPrimaryKey.value;
  frmMaintCCARate.headerFields.value = "false";
  frmMaintCCARate.totalDetailRecord.value = parseInt(iTr2,10) - 1;
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintCCARate.action = "../../../ccaRateALLSaveAction.do";
  frmMaintCCARate.submit();
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

             /*    if (i>0)
                 {
                      var p = parseInt(document.getElementsByName("txtAmtTo")[i-1].value);
                      if (m != p+1)
                      {
                        // alert("Amount From Should Be One Greater Than Previous Rows Amount To");
                         document.getElementsByName("startField")[i].focus(); 
                         return false;                      
                      }                 
                 }*/
                                 
            }             
 
        return true;
}
 



function doGetTab(arg)
  {
   /* if(frmMaintCCARate.detailDataChanged.value == "true")
    {
        alert("Please save the data");
        return false;                        
    }*/
 document.all.buttonFlag.value='';
    frmMaintCCARate.headerPrimaryKey[0].disabled="";
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../CCAAllTabAction.do";
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
//  alert("new");
 // frmMaintCCARate.action="../../../CcaRateAllNewMode.do"
  //frmMaintCCARate.submit();

}

function doQueryMode()
{document.all.buttonFlag.value='';
  frmMaintCCARate.flagAll.value="false";
  frmMaintCCARate.flagCda.value="false";
  frmMaintCCARate.flagIda.value="false";
 frmMaintCCARate.headerPrimaryKey.value="";
 frmMaintCCARate.butGetDetail.disabled="";
 frmMaintCCARate.butInsert.disabled="true";
 frmMaintCCARate.butDelete.disabled="true";
 frmMaintCCARate.action="../../../CcaRateAllQueryMode.do"
 frmMaintCCARate.submit();

}

function lfnLoad()
{
  /*
  mode = document.all.screenModeAll.value;
  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
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
 
 
  }

  
  mode = document.all.screenMode.value;
  if(mode=='' || mode=='Q')
   {
 frmMaintCCARate.butGetDetail.disabled="";
 frmMaintCCARate.butInsert.disabled="true";
 frmMaintCCARate.butDelete.disabled="true";
   }*/
   mode=document.all.flagAll.value;
   if(mode=='false')
   {
 frmMaintCCARate.butGetDetail.disabled="";
 frmMaintCCARate.butInsert.disabled="true";
 frmMaintCCARate.butDelete.disabled="true";
   }
  
   if(mode=='true')
   {
 frmMaintCCARate.butGetDetail.disabled="true";
 frmMaintCCARate.butInsert.disabled="";
 frmMaintCCARate.butDelete.disabled="";
   }
  if(mode == 'true' || document.all.flagIda.value == 'true' || document.all.flagCda.value == 'true')
  {
    frmMaintCCARate.headerPrimaryKey.disabled=true;
  }
  mode=document.all.screenMode.value;
  if(mode=='')
  {
    doQueryMode();
  }
  menuHandling(mode);   
  document.all.butExecute.disabled="true";    
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";   
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
}

function doBasePrevDetail()
{
    frmMaintCCARate.userPageRequested.value = 1*frmMaintCCARate.pageRequested.value - 1;
    frmMaintCCARate.action = "../../../ccaRateAllPrevDetailAction.do";
    frmMaintCCARate.submit();
}

function doBaseNextDetail()
{
    frmMaintCCARate.userPageRequested.value = 1*frmMaintCCARate.pageRequested.value + 1;
    frmMaintCCARate.action = "../../../ccaRateAllNextDetailAction.do";
    frmMaintCCARate.submit();
}


 function doRefresh()
    {  
        frmMaintCCARate.action = "../../../ccaRateAllRefresh.do";
        frmMaintCCARate.submit();
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

</script>