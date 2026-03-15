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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="HouseRentRcptBase" name="frmHouseRent" type="FCIPAY.Payroll.WEBTIER.Form.MaintHouseRentRcptForm" scope="session">
<bean:define id="ParentForm" name="frmHouseRent" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

<html:hidden property="detailDataChanged"  />
<html:hidden property="headerDataChanged"  />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN HOUSE RENT RECIPT DETAILS</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 border=0>
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>Header For House Rent Reciept</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>

            <td class="labelText"  width="10%" ><bean:message key="Payroll.MaintElecMtrRdg.empno" /></td>
            <td  width="35%"><html:text  property="txtEmpNo" altKey="" maxlength="10" size="14" readonly="true" styleClass="required" onchange="checkEmp(this.value);" />
            <logic:notEqual property="screenMode" name="frmHouseRent" value="U" >
            <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="return ShowEmpNum();" >&nbsp;
            </logic:notEqual>
            <html:text  property="txtEmpName"  size="32" styleClass="locked" readonly="true" /></td>

             <TD class=labelText width="10%" ><bean:message key="pay.MaintainAnnualIncome.FinYYMM" /></td>
             <td><html:text  property="txtFinYYMM" altKey="pay.MaintainAnnualIncome.txtFinYYMM" maxlength="10" size="23" styleClass="required" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  onchange="chk_FinYear(this.value)" />
          
          <logic:equal property="screenMode" name="frmHouseRent" value="N" >
             <TD class=labelText width="10%" >Rent Amount</td>
             <td><html:text  property="txtRentAmt" altKey="pay.MaintainAnnualIncome.txtFinYYMM" maxlength="10" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" styleClass="required"   />
          </logic:equal>
          <logic:notEqual property="screenMode" name="frmHouseRent" value="N" >
             <html:hidden  property="txtRentAmt"  />
          </logic:notEqual>
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
                <td bgcolor="#4682B4" nowrap class=actTabText>House Rent Reciept Detail<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                        <DIV id=divDtlTable style="height:280px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail">
                          <TBODY>

                          <TR>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.houseRent.yymm" /></TD>
                            <TD class=tableHeader width="10%"><bean:message  key="Payroll.houseRent.amt" /></td>
                          </TR>
                          <logic:iterate id="HistoryEntryInfo" name="frmHouseRent" property="lstInstrDtls"  type="FCIPAY.Payroll.UTILITY.HouseRentRcptBean"   indexId="idx">                                 
                              <% ++i; %>
                           <tr>  
                                     <td >
                                        <html:text property="txtMonth" name="HistoryEntryInfo" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" styleClass="optional"  size="20" readonly="true" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>"/>
                                        <html:hidden property="txtYYMM" name="HistoryEntryInfo" />
                                      </td>
                                      <logic:equal property="status" name="HistoryEntryInfo" value="N">
                                     <td ><html:text property="txtMnthRentAmt" name="HistoryEntryInfo" tabindex="<%=String.valueOf(i)%>"  styleClass="optional"  size="20" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                         if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                          {
                                            return changed(this.alt);
                                          }                                             
                                     " />
                                      <html:hidden property="txtAmt" name="HistoryEntryInfo" />
                                     </td>
                                      </logic:equal>
                                      <logic:notEqual property="status" name="HistoryEntryInfo" value="N">
                                     <td ><html:text property="txtMnthRentAmt" name="HistoryEntryInfo" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"  styleClass="optional"  size="20" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                         if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }  
                                       else
                                          {
                                            return changed(this.alt);
                                          }                                             
                                     " />
                                     <html:hidden property="txtAmt" name="HistoryEntryInfo" />
                                     </td>
                                      </logic:notEqual>
                              <html:hidden property="hdnSrlNo" name="HistoryEntryInfo" />
                              <html:hidden property="itemChecked" name="HistoryEntryInfo" />
                              <html:hidden property="status" name="HistoryEntryInfo"/>
                              <html:hidden property="detailId" name="HistoryEntryInfo" />
                          </tr>                                                
                       </logic:iterate>       
                       </TBODY>
                     </TABLE>
                    </DIV>
                   </TD>
                  </TR>                     
                  
  
      



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
<html:hidden property="totalDetailRecord" name="frmHouseRent" />
<html:hidden property="headerPrimaryKey" name="frmHouseRent" />
<html:hidden property="screenMode" name="frmHouseRent" />
<html:hidden property="screenModeHRR" name="frmHouseRent" />
<html:hidden name="frmHouseRent"  property="screenName" value="HouseRentRcptScreen" />
<html:hidden name="frmHouseRent"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmHouseRent" />
<html:hidden property="userPositionRequested" name="frmHouseRent" />
<html:hidden property="pageRequested" name="frmHouseRent" />
<html:hidden property="userPageRequested" name="frmHouseRent" />
<html:hidden property="lovKey" name="frmHouseRent"  />
<html:hidden property="flag" name="frmHouseRent" />
<html:hidden property="screenModeFlag" name="frmHouseRent" />
<html:hidden property="txtFields" name="frmHouseRent"  />   
<html:hidden property="txtSearchFields" name="frmHouseRent"  />
<html:hidden property="txtDisplayFields" name="frmHouseRent"  />
<html:hidden property="txtIndex" name="frmHouseRent"  />
<html:hidden property="buttonFlag" name="frmHouseRent"  />
<html:hidden property="loginLocCode" name="frmHouseRent" />

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
          document.all.txtEmpNo.disabled="true";
          document.all.txtFinYYMM.disabled="true"; 
       /*   if(flag=="true")
            document.all.butGetDetail.disabled="true";
          else*/
            document.all.butGetDetail.disabled="";
          document.all.butInsert.disabled="true";
          document.all.butDelete.disabled="true";

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
                  document.getElementsByName("txtYYMM")[i].disabled="disabled";
                }
           } 

      }
          
      if(mode=='N')
      {
          document.all.butGetDetail.disabled="";
          document.all.butInsert.disabled="true";
          document.all.butDelete.disabled="true";
      }
      if(mode=='Q')
      {
          document.all.butGetDetail.disabled="true";
          document.all.butInsert.disabled="true";
          document.all.butDelete.disabled="true";
      }

    if (frmHouseRent.screenModeHRR.value=="N") 
      {
        frmHouseRent.screenMode.value ="N";
      }
    
      menuHandling(mode);
      if(mode=='N')
      {
        document.all.butSave.disabled="true";
        document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      }
 }


function doRefresh()
{
  frmHouseRent.action="../../../HouseRentRcptRefresh.do"
  frmHouseRent.submit();
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
      maxCheck(ind);
      frmHouseRent.detailDataChanged.value = "true";
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


function getHeaderRecord()
{
  if(document.all.txtEmpNo.value!='')
  {
	document.all.buttonFlag.value='';
	frmHouseRent.flag.value = "false";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmHouseRent.action="../../../HouseRentRcptFirstGetHeaderAction.do"
	frmHouseRent.submit();
  }
  else
  {
    alert("Please Select an Employee");
    return false;
  }
}


function doGetNextHeader()
{
    document.all.buttonFlag.value='';
    frmHouseRent.flag.value = "false";
    frmHouseRent.userPositionRequested.value = 1*frmHouseRent.positionRequested.value + 1;
    frmHouseRent.action="../../../HouseRentRcptPrevHeader.do";
    frmHouseRent.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmHouseRent.flag.value = "false";
  frmHouseRent.userPositionRequested.value = 1*frmHouseRent.positionRequested.value - 1;
  frmHouseRent.action = "../../../HouseRentRcptPrevHeader.do";
  frmHouseRent.submit();
}


function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmHouseRent.flag.value = "false";
  frmHouseRent.userPositionRequested.value = 1*frmHouseRent.newPositionRequested.value;
  frmHouseRent.action = "../../../HouseRentRcptPrevHeader.do";
  frmHouseRent.submit();
}


function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmHouseRent.userPageRequested.value = 1*frmHouseRent.pageRequested.value - 1;
    frmHouseRent.action = "../../../HouseRentRcptNextDetailAction.do";
    frmHouseRent.submit();
}

function doBaseNextDetail()
{ 
    document.all.buttonFlag.value='';
    frmHouseRent.userPageRequested.value = 1*frmHouseRent.pageRequested.value + 1;
    frmHouseRent.action = "../../../HouseRentRcptNextDetailAction.do";
    frmHouseRent.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmHouseRent.userPageRequested.value = 1*frmHouseRent.newPageRequested.value ;
    frmHouseRent.action = "../../../HouseRentRcptNextDetailAction.do";
    frmHouseRent.submit();
}


function doBaseAddRow()
{
  if(mandatory_Check("frmHouseRent"))
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
      document.getElementsByName("txtYYMM")[i].disabled = "";
      document.getElementsByName("checked")[i].disabled = "";
  }
   
  
    document.all.buttonFlag.value='D';
    document.forms[0].action = "../../../HouseRentRcptAddRowAction.do";
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
      document.getElementsByName("txtYYMM")[i].disabled = "";
      document.getElementsByName("checked")[i].disabled = "";

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmHouseRent.detailDataChanged.value = "true";    
      document.all.buttonFlag.value='D';  
    }

  }
   
  
  document.forms[0].action = "../../../HouseRentRcptDeleteRowAction.do";
  document.forms[0].submit();  
}


function SaveRecord()
{
  if(mandatory_Check("frmHouseRent"))
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
      document.getElementsByName("txtYYMM")[i].disabled="";  
      if (document.getElementsByName("status")[i].value == 'D')
        frmHouseRent.detailDataChanged.value = "true";
  }
      document.all.buttonFlag.value=''; 

  frmHouseRent.headerFields.value = "false";
  frmHouseRent.detailDataChanged.value = "true";
  if(document.all.screenMode.value=='N')
    document.all.flag.value="false";
 // frmHouseRent.screenMode.value ="U";   
  frmHouseRent.screenModeHRR.value ="UG";   
  document.all.butSave.disabled="true";      
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmHouseRent.action = "../../../HouseRentRcptSaveAction.do";
  frmHouseRent.submit();
}
 else
  {
    return false;
  }
}


function GetDetail()
{
  if(mandatory_Check("frmHouseRent"))
  {
  document.all.buttonFlag.value='';
  if (document.all.screenMode.value=='N')
    document.all.screenModeFlag.value=true;
  else
    document.all.screenModeFlag.value=false;
  frmHouseRent.flag.value = "true";
  document.all.screenModeHRR.value = 'UG';
  document.all.screenMode.value='U';
  frmHouseRent.action="../../../HouseRentRcptFirstGetDetailAction.do";
  frmHouseRent.submit();
  }
  return false;
}

function doInsertMode()
{
  document.all.buttonFlag.value='';
  document.all.screenModeHRR.value = 'N';  
  document.all.screenMode.value = 'N';    
  frmHouseRent.action="../../../HouseRentRcptNewMode.do"
  frmHouseRent.submit();
}


function doQueryMode()
{
 document.all.screenMode.value = "Q";
 document.all.screenModeHRR.value = "Q";
 
  document.all.buttonFlag.value='';
  frmHouseRent.action="../../../HouseRentRcptQueryMode.do"
  frmHouseRent.submit();
}

function ShowEmpNum()
{
   frmHouseRent.lovKey.value = "HouseRentEmp" + frmHouseRent.screenName.value + frmHouseRent.screenMode.value;
   frmHouseRent.queryParam.value = "txtSiteID="+frmHouseRent.loginLocCode.value+",hdnEmpLbrFlag="+frmHouseRent.hdnEmpLbrFlag.value;
   frmHouseRent.txtDisplayFields.value = "txtEmpNo,txtEmpName";
   frmHouseRent.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
   frmHouseRent.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmHouseRent');
   return true;
}

function chk_YearMonth()
{
            var oTable = document.getElementById("Detail");
            var iTR = oTable.rows.length;
            var flag =0;
            var i ;
       
                               
     for(i=0;i<iTR-1;i++)
     {   
      if (document.getElementsByName("status")[i].value != 'D')
      {
       var  yearM = document.getElementsByName("txtYYMM")[i].value;  
       var month =yearM.substring(4,6);

        if (yearM.length != 6)
        {
      
        alert("From Year should be a Six digit Number");
        document.getElementsByName("txtYYMM")[i].focus();                     
        document.getElementsByName("txtYYMM")[i].select();
            //event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

  
       if(month < 1 || month > 12)
       {
       alert("Month should be Within 1 to 12");
       document.getElementsByName("txtYYMM")[i].focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
          return false;
       }
      }      
  }
    return true;
}



function changed(val)
{
  frmHouseRent.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
  document.getElementsByName("status")[val-1].value = 'U';
}


function DupliCheck()
{
    var oTable = document.getElementById("Detail");
    var iTr2 = oTable.rows.length;
    var flag =0;
     var i = 0;
    var j;
    j = 0;
   
     for(i=0;i<iTr2-2;i++)
    {   
        if (document.getElementsByName("status")[i].value != 'D')                       
      {
        var YearMonth1 = parseInt(document.getElementsByName("txtYYMM")[i].value);
        for(j=i+1;j<iTr2-1;j++)                
        {                       
            if (document.getElementsByName("status")[j].value != 'D')                       
          {                
              var YearMonth2 = parseInt(document.getElementsByName("txtYYMM")[j].value);
              if((YearMonth1==YearMonth2))
              {
               var msg = "Duplication of Year Month in Row Number "  + parseInt(j+1) + " Not Allowed";
               alert(msg); 
               document.getElementsByName("txtYYMM")[j].focus();
               return false;
              }       
            }
         }                              
        }
     }
return true;
}




function YMonthRangeCheck()
{

       var  yearM = document.getElementById("txtFinYYMM").value;          
       var FromYear =  parseInt(yearM.substring(0,4),10);
       var ToYear =  parseInt(yearM.substring(0,2),10) +  yearM.substring(4,6);       

       var oTable = document.getElementById("Detail");
       var StartYYMM = FromYear + "03";
       var EndYYMM =   ToYear + "02";
       var iTr2 = oTable.rows.length;
       
           for(i=0;i<iTr2-1;i++)
           {   

               if (document.getElementsByName("status")[i].value != 'D')
               {               
                    var YearMonth1 = parseInt(document.getElementsByName("txtYYMM")[i].value);                 
                    if(parseInt(YearMonth1,10) < parseInt(StartYYMM,10)) 
                    {
                            var msg = "Entered Year Month not in the range " + StartYYMM +  " - " + EndYYMM  + " in row "   + i;                    
                            alert(msg);
                            document.getElementsByName("txtYYMM")[i].focus();                    
                            return false;
                    }

                    if(parseInt(YearMonth1,10) > parseInt(EndYYMM,10)) 
                    {
                            var msg = "Entered Year Month not in the range " + StartYYMM +  " - " + EndYYMM  + " in row "   + i;                    
                            alert(msg);
                            document.getElementsByName("txtYYMM")[i].focus();                    
                            return false;
                    }                           
                }
           }   
          return true;
}



function chk_FinYear(val)
{
    var  yearM = document.getElementById("txtFinYYMM").value;          
    var Year1;
    var Year2;    
    if ( yearM != "") 
    {
        if (num_Check(yearM,1))
        {                                   
            if (yearM.length != 6)
            {
                alert(" Year Month should be a Six digit Number");
                document.getElementById("txtFinYYMM").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                        
                return false;    
            }    
            Year1 =  yearM.substring(2,4);
            Year2 =  yearM.substring(4,6);       
            var TempYr1 = parseInt(Year1,10) + 1;        
            var TempYr2 = parseInt(Year2,10)+1;                   
            
            if (TempYr1 != Year2)
            {
                alert("  Year Range Should be in the format of a Financial Period Eg. 200607");
                document.getElementById("txtFinYYMM").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                   
                return false;       
            }    
            return true;                                     
        }
        else
        {
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;     
            return false;
        }
    }
}


</script> 
