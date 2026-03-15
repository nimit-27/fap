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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>        
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../INCLUDES/ENRGISE.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/Payroll.js"></script>    
</head>
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />



<html:form  action="HistoryEntryBase" name="frmHistoryEntry" type="FCIPAY.Payroll.WEBTIER.Form.HistoryEntryForm" scope="session">
<bean:define id="ParentForm" name="frmHistoryEntry" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>HISTORY DATA ENTRY</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>Header For History Data Entry</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>

            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintElecMtrRdg.empno" /></td>
            <logic:equal property= "screenMode" name= "frmHistoryEntry" value="U">            
            <td><html:text  property="txtEmpNo" altKey="" maxlength="10" size="16" disabled="true" styleClass="required" onchange="checkEmp(this.value);" />
            </logic:equal>                        
            <logic:notEqual property= "screenMode" name= "frmHistoryEntry" value="U">            
            <td><html:text  property="txtEmpNo" altKey="" maxlength="10" size="16"  styleClass="required" onchange="checkEmp(this.value);" />
            </logic:notEqual>                        
            
            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="return ShowEmpNum();" >&nbsp;&nbsp;<html:text  property="txtEmpName"  maxlength="40" size="30" styleClass="locked" readonly="true" /></td>

           <td class=labelText width="20%" ><bean:message key="Payroll.HistoryEntry.YYMM" /></td>
           <td colspan="1" >
           <logic:equal property= "screenMode" name= "frmHistoryEntry" value="U">            
            <html:text  property="txtYYMM" altKey="" disabled ="true" maxlength="10" size="16" styleClass="required" />
           </logic:equal>

           <logic:notEqual property= "screenMode" name= "frmHistoryEntry" value="U">                       
           <html:text  property="txtYYMM" altKey="" maxlength="10" size="16" styleClass="required" onchange="                                                  
                       if(!(chk_YearMonth()))
                          { 
                              this.focus();
                              return false;                                                    
                          }
                          
                          "   />        
           </logic:notEqual>                          
                <logic:equal property= "screenMode" name= "frmHistoryEntry" value="Q">
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtMtrNo" name="butMtrNo" onclick="return ShowYYMM();" >
                 </logic:equal>                                      
                 <logic:equal property= "screenMode" name= "frmHistoryEntry" value="N">
                  <img src="../INCLUDES/IMAGES/lov_dis.jpg" height="16" align="center" property="buttxtMtrNo" name="butMtrNo" onclick="" >
                 </logic:equal>      
                  <logic:equal property= "screenMode" name= "frmHistoryEntry" value="U">
                    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtMtrNo" name="butMtrNo" onclick="" >
                 </logic:equal>                    
                </td
        </tr>
      
       
       
           <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>

    
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>History Data Entry Detail<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                        <DIV id=divDtlTable style="height:220px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail">
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"    /></td>
                            <TD class=tableHeader width="15%"><bean:message  key="Payroll.HistoryEntry.payCode" /></TD>
                            <TD class=tableHeader width="30%"><bean:message  key="Payroll.HistoryEntry.Desc" /></td>
                            <TD class=tableHeader width="17%"><bean:message  key="Payroll.HistoryEntry.PayMode" /></TD>
                            <TD class=tableHeader width="17%"><bean:message  key="Payroll.HistoryEntry.Amount" /></td>
                            <!--<TD class=tableHeader width="15%"><bean:message  key="Payroll.HistoryEntry.unitId" /></td>-->
                            <TD class=tableHeader width="20%"><bean:message  key="Payroll.HistoryEntry.PayDate" /></td>                            
                          </TR>
                          <logic:iterate id="HistoryEntryInfo" name="frmHistoryEntry" property="lstInstrDtls"  type="FCIPAY.Payroll.UTILITY.HistoryEntryBean"   indexId="idx">                                 
                              <% ++i; %>
                                <logic:notEqual name="HistoryEntryInfo" property="status" value="D" >                                                        
                          
                           <tr>  
                           <% ++j; %>
                                      <td  width="1%" align="center"><html:checkbox property="checked" name="frmHistoryEntry" onclick="checkRecord();" /></td>
                                      <td ><html:text property="txtPayCode" name="HistoryEntryInfo" size="6"    styleClass="optional" style="width:80%" alt="<%=String.valueOf(i) %>" onchange="
                                       if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                       "   onblur="lfnGetPayCodeNameDtl(this.alt, this.value)"    />

                                       <logic:equal name="HistoryEntryInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  onclick="ShowPayCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="HistoryEntryInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowPayCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="HistoryEntryInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowPayCode(this.alt);" >
                                       </logic:equal>
                                       </td>
                                     
                                       <td ><html:text property="txtDescription" name="HistoryEntryInfo"  styleClass="locked" readonly="true" size="25" style="width:100%" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt);" /></td>
                                       <td ><html:select property="txtPayMode" name="HistoryEntryInfo"  styleClass="optional" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt)"   style="width:100%" >
                                        <html:option value=" ">------Please select------</html:option>
                                        <html:option value="1">1 - Current Payment</html:option>
                                        <html:option value="2">2 - Current Recovery</html:option>
                                        <html:option value="4">4 - Arrear Payment</html:option>
                                        <html:option value="5">5 - Arrear Recovery</html:option>
                                       </html:select></td>                                                                            
                                       <td ><html:text property="txtAmount" name="HistoryEntryInfo"  styleClass="optional" style="width:100%;text-align:right" alt="<%=String.valueOf(i) %>" onchange="
                                          if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                        else
                                        {
                                          return changed(this.alt); 
                                        }
                                       " /></td>                                                       
                                      <td><html:text property="txtPaymentDate" name="HistoryEntryInfo"  styleClass="optional" size="26"  style="width:80%;text-align:center" alt="<%=String.valueOf(i) %>" onchange="
                                    if(!(checkDate(this.alt)))
                                     {
                                          this.focus();
                                          return false;                         
                                     }
                                   else
                                       return changed(this.alt); 

                                    " />               
                                        <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtPaymentDate',this)" />
                                    
                              <td  width="5%" ><html:hidden property="hdnSrlNo" name="HistoryEntryInfo" /></td>                                    
                              <html:hidden property="txtUnitID" name="HistoryEntryInfo" />
                              <html:hidden property="itemChecked" name="HistoryEntryInfo" />
                              <html:hidden property="status" name="HistoryEntryInfo"/>
                              <html:hidden property="detailId" name="HistoryEntryInfo" />
                          </tr>  
                        </logic:notEqual>
                        <logic:equal name="HistoryEntryInfo" property="status" value="D" >
                           <tr>
                              <td  width="1%" ><html:hidden property="checked" value="notchecked" /></td>
                              <td  width="5%" ><html:hidden property="hdnSrlNo" name="HistoryEntryInfo" /></td>
                              <td  width="5%" ><html:hidden property="txtPayCode" name="HistoryEntryInfo"  /></td>
                              <td  width="5%" ><html:hidden property="txtDescription" name="HistoryEntryInfo"  /></td>
                              <td  width="5%" ><html:hidden property="txtPayMode" name="HistoryEntryInfo"  /></td>
                              <td  width="5%" ><html:hidden property="txtAmount" name="HistoryEntryInfo"  /></td>
                              <td  width="5%" ><html:hidden property="txtUnitID" name="HistoryEntryInfo"  /></td>
                              <td  width="5%" ><html:hidden property="txtPaymentDate" name="HistoryEntryInfo"  /></td>
                              <html:hidden property="itemChecked" name="HistoryEntryInfo" />
                              <html:hidden property="status" name="HistoryEntryInfo"/>
                              <html:hidden property="detailId" name="HistoryEntryInfo" />
                          </tr>  
                        </logic:equal>         
                       </logic:iterate>       
                       </TBODY>
                     </TABLE>
                    </DIV>
                   </TD>
                  </TR>                     
                  
   <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
                                        
   	 </table>      



   <!-- Get details starts -->
	          <tr>
		          <td colspan=11>	
                    <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                </TD>
               
                  </tr>
  </TBODY>
		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
              

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
             <td>
                  <jsp:include  page = "../INCLUDES/BottomBlueBar.jsp" flush="true" />
             </td>
	     </TR>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
</TBODY>
</TABLE>


<!-- Container Table Ends -->
<html:hidden property="totalDetailRecord" name="frmHistoryEntry" />
<html:hidden property="headerPrimaryKey" name="frmHistoryEntry" />
<html:hidden property="screenMode" name="frmHistoryEntry" />
<html:hidden property="hdnAction" name="frmHistoryEntry" />
<html:hidden property="hdnRowVal" name="frmHistoryEntry"  />
<html:hidden property="screenModeHist" name="frmHistoryEntry" />
<html:hidden name="frmHistoryEntry"  property="screenName" value="HistoryEntryScreen" />
<html:hidden name="frmHistoryEntry"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmHistoryEntry" />
<html:hidden property="userPositionRequested" name="frmHistoryEntry" />
<html:hidden property="pageRequested" name="frmHistoryEntry" />
<html:hidden property="userPageRequested" name="frmHistoryEntry" />
<html:hidden property="flag" name="frmHistoryEntry" />
<html:hidden property="screenModePay1" name="frmHistoryEntry" />
<html:hidden property="hdnPayCode" name="frmHistoryEntry"  />
<html:hidden property="hdnPayCodeName" name="frmHistoryEntry"  />

<html:hidden property="lovKey" name="frmHistoryEntry"  />
<html:hidden property="txtFields" name="frmHistoryEntry"  />   
<html:hidden property="txtSearchFields" name="frmHistoryEntry"  />
<html:hidden property="txtDisplayFields" name="frmHistoryEntry"  />
<html:hidden property="txtIndex" name="frmHistoryEntry"  />
<html:hidden property="buttonFlag" name="frmHistoryEntry"  />
<html:hidden property="loginLocCode" name="frmHistoryEntry" />

<input type="hidden" name="queryParam" />


</html:form>
</body>
</html:html>

<script language="javascript">


function lfnLoad()
{

      mode = document.all.screenMode.value;
      var  mode1;
      mode1 = mode;
      if (mode == 'UG')
       mode1 = 'U';
      
      if(mode == '')
      {
          doQueryMode();
      }
      flag = document.all.flag.value;
      if(mode=='U')
      {
          
          if(flag == 'true')
          {
            document.all.butGetDetail.disabled="true";
            document.all.butInsert.disabled="";
            document.all.butDelete.disabled="";
          }
          else
          {
            document.all.butGetDetail.disabled="";
            document.all.butInsert.disabled="true";
            document.all.butDelete.disabled="true";
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
                  document.getElementsByName("txtPayCode")[i].disabled="disabled";
                }
           } 
      }


   mode1 = document.all.screenModeHist.value;

     if(mode1=='')
  {
     document.all.butGetDetail.disabled="";   
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
  }

  if(mode1=='Q')
  {
     document.all.butGetDetail.disabled="";
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";     
  }

  if(mode1=='U')
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

  if(mode1=='N')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";      
  }

  if(mode1=='UG')
  {
      document.all.butGetDetail.disabled="disabled";
     document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
  }  

 

       if(document.frmHistoryEntry.hdnAction.value == "GetPayCodeNameDtl")
        {
            var iRowVal = document.frmHistoryEntry.hdnRowVal.value;   
            if (document.frmHistoryEntry.hdnPayCodeName.value != "") 
            {  
            var iRowVal = document.frmHistoryEntry.hdnRowVal.value; 
            document.getElementsByName("txtDescription")[iRowVal-1].value = document.frmHistoryEntry.hdnPayCodeName.value; 
            document.frmHistoryEntry.hdnAction.value = "";
            document.getElementsByName("txtPayMode")[iRowVal-1].focus();            
            }
            else
            {
                alert("Invalid Pay Code"); 
                document.getElementsByName("txtDescription")[iRowVal-1].value = "";                                    
                document.getElementsByName("txtPayCode")[iRowVal-1].focus();                
            }      
        }      
          
      if(mode=='N')
      {
          document.all.butGetDetail.disabled="true";
      }
      if(mode=='Q')
      {
          document.all.butGetDetail.disabled="true";
          document.all.butInsert.disabled="true";
          document.all.butDelete.disabled="true";
      }

    if (frmHistoryEntry.screenModePay1.value=="N") 
      {
        frmHistoryEntry.screenMode.value ="N";
      }
      
    
      menuHandling(mode);
 }

function doRefresh()
{
  frmHistoryEntry.action="../../../HistoryEntryRefresh.do"
  frmHistoryEntry.submit();
}

function changed(val)
{
    frmHistoryEntry.detailDataChanged.value = "true";
     if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}



function yearmthCheck(i)
{
     var low = parseInt(document.getElementsByName("txtInitialYearMonth")[i-1].value);
     var high = parseInt(document.getElementsByName("txtFinalYearMonth")[i-1].value);

    if(high > 999999)
    {
        alert("You Must Enter A Six Digit Number");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
        return false;                        
    }
    else if((high % 100) > 12)
    {
        alert("You Must Enter A Valid Month");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
        return false;                        
    }
    if(high < low )
    {
      alert("Final YearMonth Should be greater than Initial YearMonth")
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
      return false;                        
    }
    return true;
}

function checkEmp(val)
{
  if(num_Check(val,1))
  {
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}

 function lfnChange(val,ind)
{
  if(num_Check(val,1))
  {
      frmHistoryEntry.detailDataChanged.value = "true";
      if (document.getElementsByName("status")[ind-1].value == "Q")
         document.getElementsByName("status")[ind-1].value = "U";
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}

function getHeaderRecord()
{
	document.all.buttonFlag.value='';
	frmHistoryEntry.flag.value = "false";
	document.all.screenModeHist.value='U';
	document.all.screenMode.value='U';    
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmHistoryEntry.action="../../../HstEntryGetHeaderAction.do"
	frmHistoryEntry.submit();
}


function doGetNextHeader()
{
    document.all.buttonFlag.value='';
    frmHistoryEntry.flag.value = "false";
    document.all.screenModeHist.value='U';
    document.all.screenMode.value='U';      
    frmHistoryEntry.userPositionRequested.value = 1*frmHistoryEntry.positionRequested.value + 1;
    frmHistoryEntry.action="../../../HstEntryGetNextHeader.do";
    frmHistoryEntry.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmHistoryEntry.flag.value = "false";
    document.all.screenModeHist.value='U';
  document.all.screenMode.value='U';      
  frmHistoryEntry.userPositionRequested.value = 1*frmHistoryEntry.positionRequested.value - 1;
  frmHistoryEntry.action = "../../../HstEntryGetNextHeader.do";
  frmHistoryEntry.submit();
}


function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmHistoryEntry.flag.value = "false";
    document.all.screenModeHist.value='U';
    document.all.screenMode.value='U';        
  frmHistoryEntry.userPositionRequested.value = 1*frmHistoryEntry.newPositionRequested.value;
  frmHistoryEntry.action = "../../../HstEntryGetNextHeader.do";
  frmHistoryEntry.submit();
}


function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmHistoryEntry.userPageRequested.value = 1*frmHistoryEntry.pageRequested.value - 1;
    frmHistoryEntry.action = "../../../HstEntryNextDetailAction.do";
    frmHistoryEntry.submit();
}

function doBaseNextDetail()
{ 
    document.all.buttonFlag.value='';
    frmHistoryEntry.userPageRequested.value = 1*frmHistoryEntry.pageRequested.value + 1;
    frmHistoryEntry.action = "../../../HstEntryNextDetailAction.do";
    frmHistoryEntry.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmHistoryEntry.userPageRequested.value = 1*frmHistoryEntry.newPageRequested.value ;
    frmHistoryEntry.action = "../../../HstEntryNextDetailAction.do";
    frmHistoryEntry.submit();
}


function doBaseAddRow()
{
  if(mandatory_Check("frmHistoryEntry"))
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
          document.getElementsByName("checked")[i].disabled = "";
          document.getElementsByName("txtPayCode")[i].disabled = "";
          document.getElementsByName("txtDescription")[i].disabled = "";
      }

  
    document.all.buttonFlag.value='D';
    document.forms[0].action = "../../../HstEntryAddRowAction.do";
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


  for(i=0; i < iTr2 -1; i++)
  {
      document.getElementsByName("txtPayCode")[i].disabled = "";
      document.getElementsByName("txtDescription")[i].disabled = "";
      document.getElementsByName("checked")[i].disabled = "";

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmHistoryEntry.detailDataChanged.value = "true";    
      document.all.buttonFlag.value='D';  
    }

  }
  
  document.forms[0].action = "../../../HstEntryDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{
  if(mandatory_Check("frmHistoryEntry"))
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
          document.getElementsByName("checked")[i].disabled = "";
          if (document.getElementsByName("status")[i].value == 'D')
            frmHistoryEntry.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'N')
            frmHistoryEntry.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'U')
            frmHistoryEntry.detailDataChanged.value = "true";

      document.getElementsByName("txtPayCode")[i].disabled = "";
      document.getElementsByName("txtDescription")[i].disabled = "";
            
      }

       document.all.screenModePay1.value = document.all.screenMode.value;     
      if(frmHistoryEntry.screenMode.value == "N")
      {
      frmHistoryEntry.headerDataChanged.value = "true"; 
      frmHistoryEntry.detailDataChanged.value = "true";
      }
       if(frmHistoryEntry.screenMode.value == "U")
       {
      frmHistoryEntry.headerDataChanged.value = "true"; 
      }  
  
      frmHistoryEntry.headerFields.value = "true";
      frmHistoryEntry.screenMode.value ="U";                    
      frmHistoryEntry.screenModeHist.value ="UG";                          

      frmHistoryEntry.headerPrimaryKey.value = "##";
      frmHistoryEntry.headerFields.value = "true";
      frmHistoryEntry.totalDetailRecord.value = parseInt(iTr2)-1;       
      frmHistoryEntry.buttonFlag.value='';
      document.all.butSave.disabled="true";              
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmHistoryEntry.action = "../../../HstEntrySaveAction.do";
      frmHistoryEntry.submit();
  }
  else
  {
    return false;
  }
}

function GetDetail()
{
  document.all.buttonFlag.value='';
 document.all.screenModeHist.value = 'UG';  
  frmHistoryEntry.headerPrimaryKey.value = "##";
  frmHistoryEntry.flag.value = "true";

  frmHistoryEntry.action="../../../HstEntryGetDetailAction.do"
  frmHistoryEntry.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value='';
  document.all.screenModeHist.value = 'N';  
  frmHistoryEntry.action="../../../HstEntryNewMode.do"
  frmHistoryEntry.submit();
}


function doQueryMode()
{
  document.all.buttonFlag.value='';
  document.all.screenModeHist.value = 'Q';  
  frmHistoryEntry.action="../../../HistryEntryQueryMode.do"
  frmHistoryEntry.submit();
}

function ShowEmpNum()
{
   frmHistoryEntry.lovKey.value = "HistEmp" + frmHistoryEntry.screenName.value + frmHistoryEntry.screenMode.value;
   frmHistoryEntry.queryParam.value = "txtSiteID="+frmHistoryEntry.loginLocCode.value+" ";
   frmHistoryEntry.txtDisplayFields.value = "txtEmpNo,txtEmpName";
    frmHistoryEntry.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
   frmHistoryEntry.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmHistoryEntry');
   return true;
}


function ShowYYMM()
{
   frmHistoryEntry.lovKey.value = "YYMMLov" + frmHistoryEntry.screenName.value + frmHistoryEntry.screenMode.value;
   frmHistoryEntry.txtDisplayFields.value = "txtYYMM";
   frmHistoryEntry.txtSearchFields.value = "Payroll.HistoryEntry.YYMM";
   frmHistoryEntry.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmHistoryEntry');
   return true;
}

function ShowPayCode(i)
{
   frmHistoryEntry.lovKey.value = "HistPayCode" + frmHistoryEntry.screenName.value + "N";
   frmHistoryEntry.txtDisplayFields.value = "txtPayCode,txtDescription";
   frmHistoryEntry.txtSearchFields.value = "Payroll.HistoryEntry.payCode,Payroll.HistoryEntry.Desc";
   frmHistoryEntry.txtIndex.value=i;  
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmHistoryEntry');
   return true;
}

 function checkDate(i)
  {
  var k = parseInt(i,10) - 1;
  var m = document.getElementsByName("txtPaymentDate")[0].value;
     if(m != "")
     {
      if(!isDate(m,"dd-MMM-yyyy"))
      {
      alert("Enter Proper Payment Date  in the Format DD-MMM-YYYY");
      return false;
      }
     }  
  return true;
  }


function chk_YearMonth()
{
     var  yearM = document.getElementById("txtYYMM").value;          
     var month =  parseInt(yearM.substring(4,6),10);
      
    if (num_Check(yearM,1))
     {                                   
           
        if (yearM.length != 6)
        {
        alert("Revision Year Month should be a Six digit Number");        
        return false;    
        }
  
       if(month < 1 || month > 12)
       {
       alert("Revision  Month should be Within 1 to 12");        
          return false;
       }
        return true;
     }
     else
     {
    return false;
     }
}


function lfnGetPayCodeNameDtl(val, value) 
{    
    if (value != "")
    {
        if(frmHistoryEntry.screenModeHist.value="N") 
        {
           EnableField();        
           frmHistoryEntry.hdnAction.value="GetPayCodeNameDtl";
           frmHistoryEntry.hdnRowVal.value=val;
           frmHistoryEntry.hdnPayCode.value=value;     
           frmHistoryEntry.action="../../../HistGetPayCodeName.do"     
           frmHistoryEntry.submit();
        }
   }
}


function EnableField()
{
  var oTable = document.getElementById("Detail");
  var iTr2 = oTable.rows.length;
  var i = 0;
  
  for(i=0; i < iTr2 -1; i++)
  {
      document.getElementsByName("txtPayCode")[i].disabled="";        
      if (document.getElementsByName("status")[i].value == 'D')
        frmHistoryEntry.detailDataChanged.value = "true";
  }

}   



</script> 