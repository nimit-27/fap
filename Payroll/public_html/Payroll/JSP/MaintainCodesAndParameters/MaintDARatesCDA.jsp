<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />


    <link rel="STYLESHEET" type="text/css" href="../../CSS/PayrollMenucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
   <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />



<html:form  action="MaintDaRatesBase" name="frmMaintDaRates" type="FCIPAY.Payroll.WEBTIER.Form.MaintDaRatesForm" scope="session">
<bean:define id="ParentForm" name="frmMaintDaRates" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN DA RATES</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       <!--<div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Da Rate Header</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="2"></td>
         </tr>
        <tr>

            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintDARates.year" /></td>
            <td><html:text  property="txtYYMM" altKey="Payroll.MaintDARates.year" maxlength="10" size="23" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM"  onclick="return ShowLovYYMM();" ><bean:message key="Payroll.MaintDARates.yymm" /></td>
         
            <html:hidden property="txtDAType" alt="lstPayScaleType" value="" />  
        </tr>
      
       
       
           <tr height="10">		    
        <TD colspan="2" > </TD>
      </tr>
   	 </table>
    </div>
    
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("ida")> IDA <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText )> CDA <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>

                    </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="11">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail" >
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintDARates.low" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintDARates.high" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintDARates.rate" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintDARates.min" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintDARates.dp" /></TD>
                            </TR>

                          
                          <logic:iterate id="darate" name="frmMaintDaRates" property="lstInstrDtls1" type="FCIPAY.Payroll.UTILITY.MaintDARateBean" >
                              <% ++i; %>
                                <logic:notEqual name="darate" property="status" value="D" >                                                        
                           <tr>     <% ++j; %>
                              <td  width="1%" align="center"><html:checkbox property="checked" name="frmMaintDaRates" onclick="checkRecord();"  /></td>
                              <td  width="5%" ><html:text property="startField" name="darate" styleClass="required" style="width:100%;text-align:right" maxlength="9" alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);"   /></td>
                              <td  width="5%" ><html:text property="endField" name="darate" styleClass="required" style="width:100%;text-align:right" maxlength="9"  alt="<%=String.valueOf(i)%>" onchange="lfnChangeAmt(this.value,this.alt);  changeDtlStartField('startField','endField',this.alt,'0');" /></td>
                              <td  width="5%" ><html:text property="txtDaRate" name="darate" styleClass="required" maxlength="5"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>
                              <td  width="5%" ><html:text property="txtDaMinimum" name="darate" styleClass="required" maxlength="9" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);" /></td>
                              <td  width="5%" ><html:text property="txtDPRate" name="darate" styleClass="required" maxlength="5" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt);" /></td>
                               <html:hidden property="txtSrlNo" name="darate" />
                               <html:hidden property="itemChecked" name="darate" />
                               <html:hidden property="status" name="darate" />    
                               <html:hidden property="detailId" name="darate" value="Default"/>
                          </tr>
                        </logic:notEqual>
                        <logic:equal name="darate" property="status" value="D" >
                         <tr>
                              <td  width="1%" ><html:hidden property="checked" value="notchecked" /></td>
                              <td  width="5%" ><html:hidden property="startField" name="darate"  /></td>
                              <td  width="5%" ><html:hidden property="endField" name="darate"  /></td>
                              <td  width="5%" ><html:hidden property="txtDaRate" name="darate"  /></td>
                              <td  width="5%" ><html:hidden property="txtDaMinimum" name="darate"  /></td>
                              <td  width="5%" ><html:hidden property="txtDPRate" name="darate"  /></td>
                               <html:hidden property="txtSrlNo" name="darate" />
                               <html:hidden property="itemChecked" name="darate" />
                               <html:hidden property="status" name="darate" />
                               <html:hidden property="detailId" name="darate" value="Default"/>
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
                    <TR><td><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                    </td></TR>

                  </TBODY>
                </TABLE>
                </TD>
               
                  </tr>
  </TBODY>
		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
               <tr>
		<TD background="../INCLUDES/IMAGES/line_r.gif"><IMG src="../INCLUDES/IMAGES/pixel.gif" border=0></TD>
		</TR>
    <TR>
     <TD align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>

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
<html:hidden property="totalDetailRecord" name="frmMaintDaRates" />
<html:hidden property="headerPrimaryKey" name="frmMaintDaRates" />
<html:hidden property="screenMode" name="frmMaintDaRates" />
<html:hidden name="frmMaintDaRates"  property="screenName" value="DaRatesCDAScreen" />
<html:hidden name="frmMaintDaRates"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmMaintDaRates" />
<html:hidden property="userPositionRequested" name="frmMaintDaRates" />
<html:hidden property="screenModeCDA" name="frmMaintDaRates"  />
<html:hidden property="screenModeDARate" name="frmMaintDaRates"  />
<html:hidden property="headerClick" name="frmMaintDaRates"  />
<html:hidden property="headerMode" name="frmMaintDaRates" />
<html:hidden property="headerMode1" name="frmMaintDaRates" />
<html:hidden property="userPageRequested" name="frmMaintDaRates" />
<html:hidden property="pageRequested" name="frmMaintDaRates" />
<html:hidden property="lovKey" name="frmMaintDaRates"  />
<html:hidden property="txtFields" name="frmMaintDaRates"  />   
<html:hidden property="txtSearchFields" name="frmMaintDaRates"  />
<html:hidden property="txtDisplayFields" name="frmMaintDaRates"  />
<html:hidden property="txtIndex" name="frmMaintDaRates"  />
<html:hidden property="buttonFlag" name="frmMaintDaRates"  />

</html:form>
</body>
</html:html>

 
<script language="javascript">
function lfnLoad()
{  
  mode1 = document.all.screenMode.value;
  
if (frmMaintDaRates.screenMode.value == "Q")
     frmMaintDaRates.screenModeCDA.value="Q";

  if (frmMaintDaRates.screenModeDARate.value=="N1")
    {
         if (frmMaintDaRates.screenModeCDA.value == "")
         {
            if (frmMaintDaRates.screenMode.value == "U")
            {
                frmMaintDaRates.screenModeCDA.value = "U";
            }
            else
            {
              frmMaintDaRates.screenModeCDA.value="UG";                
            }            
          }    
          else
          {
            frmMaintDaRates.screenModeCDA.value="UG";              
          }
    }

    
    if (frmMaintDaRates.screenModeDARate.value=="N") 
    {
      if (frmMaintDaRates.screenModeCDA.value != "UG")          
       frmMaintDaRates.screenModeCDA.value="U";
    }
    else if (frmMaintDaRates.screenModeDARate.value=="U1") 
    {
      if (frmMaintDaRates.headerClick.value != "CDA")
      {
       frmMaintDaRates.screenModeDARate.value="U";             
       frmMaintDaRates.screenModeCDA.value="U";
      }
    }
    
   if (frmMaintDaRates.screenModeCDA.value == "")
  {
     if (frmMaintDaRates.screenMode.value == "U")
     {
         frmMaintDaRates.screenModeCDA.value = "U";
     }
     else
     {
       frmMaintDaRates.screenModeCDA.value = "Q";
       frmMaintDaRates.screenMode.value = "Q";    
       frmMaintDaRates.screenModeDARate.value = "Q";         
      }
   }
    
  mode = frmMaintDaRates.screenModeCDA.value;
  
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

     if (frmMaintDaRates.screenMode.value == 'U')
      { 
        document.getElementById("txtYYMM").disabled = "true";
        document.getElementById("txtDAType").disabled = "true";      
      }
      else
      {  
        document.getElementById("txtYYMM").disabled="";
        document.getElementById("txtDAType").disabled="";
      }  

  if(mode=='U')
  {
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";

      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
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
  mode = frmMaintDaRates.screenMode.value;    
  menuHandling(mode);
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


function getHeaderRecord()
{
     document.all.buttonFlag.value='';
     document.all.headerMode.value = "U";
     document.all.headerMode1.value = "U";
     document.all.screenModeCDA.value='U';  
     document.all.screenModeDARate.value = "U1";    
     document.all.headerClick.value = "CDA";  
	 document.all.butExecute.disabled="true";
	 document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
     frmMaintDaRates.action="../../../daRatesCDAFirstGetHeaderAction.do"
     frmMaintDaRates.submit();
}

 function lfnChange(val,ind)
{
   if(num_Check(val,1))
  {
      frmMaintDaRates.detailDataChanged.value = "true";
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}

function lfnChangeAmt(val,ind)
{
    if(num_Check(val,1))
    {
      maxCheck(ind);
      frmMaintDaRates.detailDataChanged.value = "true";
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
    }
    else
    {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
    }
}

function maxCheck(i)
{
     var low = parseInt(document.getElementsByName("startField")[i-1].value);
     var high = parseInt(document.getElementsByName("endField")[i-1].value);

    if(high <= low )
    {
      alert("High Basic Should be greater than Low Basic")
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
      return false;                        
    }
    return true;
}


function lfnChangePer(val,ind)
{
   if(percent_Check(val))
  {
      frmMaintDaRates.detailDataChanged.value = "true";
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}


function doBaseAddRow()
{
 document.all.buttonFlag.value='D';
  if(mandatory_Check("frmMaintDaRates"))
  {
  //   document.all.screenMode.value='U';
    frmMaintDaRates.screenModeDARate.value = "N1";
    
      document.forms[0].action = "../../../daRatesCDAAddRowAction.do";
      document.forms[0].submit();
  }
  else
  {
      return false;
  }
}


function SaveRecord()
{
document.all.buttonFlag.value='';
  if(mandatory_Check("frmMaintDaRates"))
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
                      if (document.getElementsByName("status")[i].value == 'D')
                        frmMaintDaRates.detailDataChanged.value = "true";
                      if (document.getElementsByName("status")[i].value == 'N')
                        frmMaintDaRates.detailDataChanged.value = "true";
                      if (document.getElementsByName("status")[i].value == 'U')
                        frmMaintDaRates.detailDataChanged.value = "true";

            /*       var low = parseInt(document.getElementsByName("startField")[i].value);
                   var high = parseInt(document.getElementsByName("endField")[i].value);
                   var rate = parseInt(document.getElementsByName("txtDaRate")[i].value);
                   var min = parseInt(document.getElementsByName("txtDaMinimum")[i].value);
                   var yymm = parseInt(document.getElementsByName("txtYYMM").value);


                  if(low<0 || high<0 || rate<0 || min<0 || yymm<0)
                  {
                      alert("Values Can't be negative");
                      return false;
                  }
                  if(high <= low )
                  {
                    alert("In "+(i+1)+"th row High Basic Should be greater than Low Basic")
                    document.getElementsByName("endField")[i].focus();
                    return false;                        
                  }
                    if(rate > 100 )
                    {
                      alert("In "+(i+1)+"th row DA Rate Shouldn't be greater than 100%")
                      document.getElementsByName("txtDaRate")[i].focus();
                      return false;                        
                    }
                   if (i>0)
                   {
                        var p = parseInt(document.getElementsByName("txtDaRate")[i-1].value);
                        if (rate <= p)
                        {
                           alert("DA Rate Shouldn't Be  Lesser Than Previous Rows DA Rate");
                           document.getElementsByName("txtDaRate")[i].focus(); 
                           return false;                      
                        }                 
                   }
                     if (i>0)
                     {
                          var p = parseInt(document.getElementsByName("txtDaMinimum")[i-1].value);
                          if (min <= p)
                          {
                             alert("DA Minimum Shouldn't Be  Lesser Than Previous Rows DA Minimum");
                             document.getElementsByName("txtDaMinimum")[i].focus(); 
                             return false;                      
                          }                 
                     }            
                   if (i>0)
                   {
                        var q = parseInt(document.getElementsByName("endField")[i-1].value);
                        if (low != q+1)
                        {
                           alert("Low Basic Should Be One Greater Than Previous Rows High Basic");
                           document.getElementsByName("startField")[i].focus(); 
                           return false;                      
                        }                 
                   }
                  */
            
      }

      document.all.screenMode.value='U';      
      document.all.headerMode.value=document.all.headerMode1.value;
      frmMaintDaRates.headerPrimaryKey.value = frmMaintDaRates.txtYYMM.value + "#" + frmMaintDaRates.txtDAType.value;
      
      frmMaintDaRates.totalDetailRecord.value = parseInt(iTr2)-1;  
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintDaRates.action = "../../../daRatesCDASaveAction.do";
      frmMaintDaRates.submit();
  }
  else
  {
    return false;
  }
}

function doInsertMode()
{
    document.all.buttonFlag.value='';
    document.all.headerMode.value  = "N";
    document.all.headerMode1.value  = "N";
    document.all.screenModeCDA.value  = "N";
    document.all.screenMode.value = "N";
    document.all.screenModeDARate.value = "I";
    
    frmMaintDaRates.action="../../../daRatesCDANewMode.do"
    frmMaintDaRates.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.screenModeCDA.value  = "Q";
    document.all.screenMode.value = "Q";
    document.all.screenModeDARate.value = "Q";
    document.all.headerMode.value  = "Q";
    document.all.headerMode1.value  = "Q";
    
    frmMaintDaRates.action="../../../daRatesCDAQueryMode.do"
    frmMaintDaRates.submit();
}

function doGetTab(arg)
{
    document.all.buttonFlag.value='';
    if (frmMaintDaRates.screenMode.value=="U")
    {
      frmMaintDaRates.headerMode.value = "U";
      frmMaintDaRates.headerMode1.value = "U";
    }
    frmMaintDaRates.forwardedPage.value=arg;
    document.forms[0].action="../../../daCDATabAction.do";
    frmMaintDaRates.submit();
}

function chk_YearMonth(val)
{
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6);
    
    if (num_Check(yearM,1))
    {                                   
      if (yearM.length != 6)
      {
        alert(" Year Month should be a Six digit Number");
        document.getElementById("txtYYMM").focus();                     
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;                    
        return false;      
      }    
      else if(month < 1 || month > 12)
      {
        alert("  Month should be Within 1 to 12");
        document.getElementById("txtYYMM").focus();                     
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;                    
        return false;
      }
      else
      {      
        //return changed(val);
        return true;
      }
    }
    else
    {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;     
      return false;
    }
}

function doGetNextHeader()
{
    document.all.buttonFlag.value='';
    frmMaintDaRates.screenModeCDA.value='U';
    frmMaintDaRates.headerClick.value = "CDA";
    document.all.screenModeDARate.value = "U1"; 
    frmMaintDaRates.userPositionRequested.value = 1*frmMaintDaRates.positionRequested.value + 1;  
    frmMaintDaRates.action="../../../daRatesCDAGetNextHeader.do";
    
    frmMaintDaRates.submit();
}


function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmMaintDaRates.screenModeCDA.value='U';
    document.all.screenModeDARate.value = "U1"; 
    frmMaintDaRates.headerClick.value = "CDA";
    
    frmMaintDaRates.userPositionRequested.value = frmMaintDaRates.positionRequested.value - 1;
    frmMaintDaRates.action = "../../../daRatesCDAGetNextHeader.do";
    frmMaintDaRates.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmMaintDaRates.screenModeCDA.value='U';
    frmMaintDaRates.headerClick.value = "CDA";
    document.all.screenModeDARate.value = "U1"; 
    frmMaintDaRates.userPositionRequested.value = 1*frmMaintDaRates.newPositionRequested.value;
    frmMaintDaRates.action = "../../../daRatesCDAGetNextHeader.do";
    frmMaintDaRates.submit();
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
    
    var strRecList='';
    for(i=0; i < iTr2 -1; i++)
    {
      if(document.getElementsByName("checked")[i].checked)
      {
        if(document.getElementsByName("txtSrlNo")[i].value=="" )
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
    
    document.forms[0].action = "../../../daRatesCDADeleteRowAction.do";
    document.forms[0].submit();  
}


function GetDetail()
{
    document.all.buttonFlag.value='';
    document.all.screenModeCDA.value='UG';
    document.all.headerMode.value = document.all.headerMode1.value;
    frmMaintDaRates.headerPrimaryKey.value = frmMaintDaRates.txtYYMM.value + "#" + frmMaintDaRates.txtDAType.value;
    frmMaintDaRates.action="../../../daRatesCDAFirstGetDetailAction.do"
    frmMaintDaRates.submit();
}

function ShowLovYYMM()
{
   frmMaintDaRates.lovKey.value = "MaintDA" + "frmMaintDaRates" + frmMaintDaRates.screenMode.value;
   frmMaintDaRates.txtDisplayFields.value = "txtYYMM";
      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintDaRates');
   return true;
}

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmMaintDaRates.userPageRequested.value = 1*frmMaintDaRates.pageRequested.value - 1;
    frmMaintDaRates.action = "../../../DACDAPrevDetailAction.do";
    frmMaintDaRates.submit();
}

function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmMaintDaRates.userPageRequested.value = 1*frmMaintDaRates.pageRequested.value + 1;
    frmMaintDaRates.action = "../../../DACdaNextDetailAction.do";
    frmMaintDaRates.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmMaintDaRates.userPageRequested.value = 1*frmMaintDaRates.newPageRequested.value ;
    frmMaintDaRates.action = "../../../DACdaNextDetailAction.do";
    frmMaintDaRates.submit();
}

function doRefresh()
{
    frmMaintDaRates.action = "../../../DARateCDARefresh.do";
    frmMaintDaRates.submit();
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

</script> 