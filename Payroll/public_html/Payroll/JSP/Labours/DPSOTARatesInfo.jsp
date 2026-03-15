<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
    <TITLE><bean:message key="pay.title" /></TITLE>
    <jsp:include page="../INCLUDES/GenIncludes.jsp" />
</HEAD>


    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>        
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../INCLUDES/ENRGISE.js"></script>    

     
<BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintDPSOTARates" name="frmDPSOTARates" type="FCIPAY.Payroll.Labour.WEBTIER.Form.DPSOTARatesForm" scope="session">
<bean:define id="ParentForm" name="frmDPSOTARates" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />


<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="lovKey" name="frmDPSOTARates"  />
<html:hidden property="txtFields" name="frmDPSOTARates"  />   
<html:hidden property="txtSearchFields" name="frmDPSOTARates"  />
<html:hidden property="txtDisplayFields" name="frmDPSOTARates"  />
<html:hidden property="txtIndex" name="frmDPSOTARates"  />

<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN OTA RATES</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<html:errors/>
 
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
   <TR>
    <TD>
 <!-- <div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--pay Scale Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> OTA Rates Header</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="6"></td>
            </tr>
        <TR>                
          <TD class=labelText width="15%" ><bean:message key="pay.EnqPayImg.txtYtm" /></td>
          <td><html:text  property="txtYYMM" altKey="pay.EnqPayImg.txtYtm" maxlength="10" size="23" styleClass="required"  onchange="
                      
          if(!(chk_YearMonth()))
          {
          }                                    
          " />                          
          
          </td>
          
          <td class=labelText width="15%" ><bean:message key="Payroll.Site.Name" /></td>
          <td>
          <html:text  property="txtLocDesc" altKey="Payroll.Site.Name" maxlength="10" size="23" styleClass="locked"  onchange=" return changed(this.alt);" />
          </td>                                            
        </tr>
        
       <tr height="15" >
        <td colspan="6"></td>
       </tr>                                 
       </table>        
       </div>     
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 > 
              
               <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > OTA Rates Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                            <TR>
                              <td class=tableHeader width="1%"><html:checkbox property="selectAll" value="" onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                              <td class=tableHeader width="19%"><bean:message key="pay.MaintPayScaleIDA.srNo" /></td>                              
                              <td class=tableHeader width="19%"><bean:message key="Payroll.Labour.effDate" /> </td>
                              <td class=tableHeader width="19%"><bean:message key="Payroll.Labour.effEndDate" /></td>
                              <td class=tableHeader width="19%"><bean:message key="Payroll.Labour.Rate" /></td>
                              
                          </tr>                                                      
                          <logic:iterate id="OtaRateInfo" name="frmDPSOTARates" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.DPSOTARatesDtlBean" >
                          <% ++i; %>
                          <logic:notEqual name="OtaRateInfo" property="status" value="D" >                              
                            <tr> <% ++j; %>                                                          
                                   <td ><html:checkbox property="checked" onclick="checkRecord();" name="frmDPSOTARates" /></td>
                                   <td ><html:text property="txtSrNo" name="OtaRateInfo"  value="<%=String.valueOf(j)%>" styleClass="optional" style="width:100%" /></td>
                                    <td ><html:text property="startDate" name="OtaRateInfo"  styleClass="required" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange=" return chkDate('startDate','endDate',this.alt);" readonly="true"/>                                                                                                                        
                                    &nbsp;<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butStartDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>" onclick="showCalendar('startDate',this)"  ></td>                                   
                                   <td ><html:text property="endDate" name="OtaRateInfo"  styleClass="required" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return chkDate('startDate','endDate',this.alt);"                                
                                          
                                     readonly="true" />&nbsp;<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butEndDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>" onclick="showCalendar('endDate',this)"  ></td>                                   
                                    <td><html:text property="txtRate" name="OtaRateInfo"  styleClass="required" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="
                                      if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }
                                     else
                                       return changed(this.alt);
                                   " /></td>                                 
                                   
                                   <html:hidden property="txtSrlNo" name="OtaRateInfo" />   
                                   <html:hidden property="itemChecked" name="OtaRateInfo" />
                                   <html:hidden property="status" name="OtaRateInfo" />
                                   <html:hidden property="detailId" name="OtaRateInfo" value="Default"/>                                   
                               </tr>
                          </logic:notEqual>
                          <logic:equal name="OtaRateInfo" property="status" value="D" >                              
                                   <tr>
                                   <td ><html:hidden property="checked" name="frmDPSOTARates" /></td>
                                   <td ><html:hidden property="txtSrNo" name="OtaRateInfo"  style="width:100%" /></td>
                                   <td ><html:hidden property="startDate" name="OtaRateInfo"  style="width:100%" /></td>
                                   <td><html:hidden property="txtRate" name="OtaRateInfo"  style="width:100%"  /></td>
                                   <td ><html:hidden property="endDate" name="OtaRateInfo"  style="width:100%" /></td>                                   
                                   <html:hidden property="txtSrlNo" name="OtaRateInfo" />                                        
                                  
                                   <html:hidden property="itemChecked" name="OtaRateInfo" />
                                   <html:hidden property="status" name="OtaRateInfo" />
                                   <html:hidden property="detailId" name="OtaRateInfo" value="Default"/>                                  
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
                            <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
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
<html:hidden property="headerPrimaryKey" name="frmDPSOTARates" />
<html:hidden property="screenMode" name="frmDPSOTARates"  />
<html:hidden property="screenModeIDA" name="frmDPSOTARates"  />
<html:hidden property="headerClick" name="frmDPSOTARates"  />
<html:hidden property="screenModePayScale" name="frmDPSOTARates"  />
<html:hidden property="screenModeFlag" name="frmDPSOTARates"  />
<html:hidden property="screenModePay2" name="frmDPSOTARates"  />
<html:hidden name="frmDPSOTARates"  property="screenName" value="DPSOTARates" />
<html:hidden name="frmDPSOTARates"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmDPSOTARates" />
<html:hidden property="userPositionRequested" name="frmDPSOTARates" />
<html:hidden property="userPageRequested" name="frmDPSOTARates" />
<html:hidden property="pageRequested" name="frmDPSOTARates" />
<html:hidden property="totalDetailRecord" name="frmDPSOTARates"  />
<html:hidden property="buttonFlag" name="frmDPSOTARates"  />
<html:hidden property="loginLocCode" name="frmDPSOTARates" />
<html:hidden property="loginEmployeelocation" name="frmDPSOTARates" />
<html:hidden property="txtLocId" name="frmDPSOTARates" />
</html:form>
</body>
</html:html>                
         

<script language="javascript">
var formMode="Q";
var oElemName=new Object();
var sSaveFlag=1;


var chkMes;

function changed(val)
{  
  if ((frmDPSOTARates.screenMode.value == "U") || (frmDPSOTARates.screenMode.value == "N"))
  {     
    frmDPSOTARates.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
    document.getElementsByName("status")[val-1].value = 'U';
  } 
  else
    frmDPSOTARates.detailDataChanged.value = "false";        
}

function GetDetail()
{
  document.all.buttonFlag.value='';  
  document.all.screenModeFlag.value  = "true";       
  frmDPSOTARates.headerPrimaryKey.value = frmDPSOTARates.txtYYMM.value + "," + frmDPSOTARates.txtLocId.value;  
  
  frmDPSOTARates.action="../../../DPSOTARateGetDetailAction.do"
  frmDPSOTARates.submit();
}

function getHeaderRecord()
{
	document.all.buttonFlag.value='';  
	document.all.screenModeFlag.value  = "false";  
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmDPSOTARates.action="../../../DPSOTARateGetHeaderAction.do";
	frmDPSOTARates.submit();
}

function doGetNextHeader()
{ 
  document.all.buttonFlag.value='';
  document.all.screenModeFlag.value  = "false";
  frmDPSOTARates.userPositionRequested.value = 1*frmDPSOTARates.positionRequested.value + 1;   
  
  frmDPSOTARates.action="../../../DPSOTARateGetNextHeader.do";
  frmDPSOTARates.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  document.all.screenModeFlag.value  = "false";
  frmDPSOTARates.userPositionRequested.value = frmDPSOTARates.positionRequested.value - 1;
  
  frmDPSOTARates.action = "../../../DPSOTARateGetNextHeader.do";
  frmDPSOTARates.submit();
}


function doBaseAddRow()
{
  document.all.buttonFlag.value='D';  
  if(!mandatory_Check("frmDPSOTARates"))
    return false;
  
  /*if(!chk_YearMonth())
  {
    document.getElementById("txtYYMM").focus();
    return false;
  }*/
  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  } 
  var iTr2 = oTable.rows.length;
  var i = 0;
  for(i=0; i < iTr2 -1; i++)
  {
    //document.getElementsByName("startField")[i].disabled="";
  }
  
  //frmDPSOTARates.screenModePayScale.value = "N1";
  frmDPSOTARates.detailDataChanged.value = "false";    
  //document.getElementById("txtYYMM").disabled="";
  //document.getElementById("lstPayScale").disabled="";  
  
  frmDPSOTARates.action = "../../../DPSOTARateAddRowAction.do";
  frmDPSOTARates.submit();
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
      //if(document.getElementsByName("txtSrlNo")[i].value=="" )
      //{
        document.getElementsByName("itemChecked")[i].value = "Y";
        document.all.detailDataChanged.value="true";
      //}
     // else
     // {
     //   strRecList=strRecList+(i+1)+",";
     // }
    }
  }
  //if(strRecList!='')
  //{
    //alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  //}
  //EnableFields();
  
  document.forms[0].action = "../../../DPSOTARateDelRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{
  document.all.buttonFlag.value='';
  //document.all.screenModeFlag.value = document.all.screenModePay2.value;    
 
  if(!chk_YearMonth())
    return false;

  if(!mandatory_Check("frmDPSOTARates"))
    return false;      

  //if(!AmtCheck())
    //return false;

  //if(!checkEndBasic())
   // return false;     

  if(!DetailRecordNo_check())
    return false;  

  frmDPSOTARates.screenMode.value = 'U';
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  
	frmDPSOTARates.headerPrimaryKey.value = frmDPSOTARates.txtYYMM.value + "," + frmDPSOTARates.txtLocId.value;
	frmDPSOTARates.totalDetailRecord.value = parseInt(iTr2,10) - 1;  
	frmDPSOTARates.headerFields.value = "true"; 
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	frmDPSOTARates.action = "../../../DPSOTARateSaveAction.do";
	frmDPSOTARates.submit();
}

function DetailRecordNo_check()
{
  var oTable = document.getElementById("Detail");
  var iTr2 = oTable.rows.length;
  var flag =0;
  
  frmDPSOTARates.totalDetailRecord.value = parseInt(iTr2,10) - 1;
  if( frmDPSOTARates.totalDetailRecord.value==0)
  {
    alert("Atleast one Detail Reord is Mandatory");
    return false;
  }
  return true;
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
    if((document.getElementsByName("status")[i].value) != "D")
    {
      if (m >= n)
      {
         alert("End Basic Should Be Greater Than Start Basic");
         document.getElementsByName("endField")[i].focus(); 
         return false;
      }     
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
      //document.getElementById("txtYYMM").focus();                     
      /*event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;*/      
      return false;    
    } 
  
    if(month < 1 || month > 12)
    {
      alert("Revision  Month should be Within 1 to 12");
      //document.getElementById("txtYYMM").focus();                     
      //event.srcElement.select();
      //event.srcElement.focus();
      //event.returnValue=false;                  
      return false;
    }
    return true;
  }
  else
  {
    //event.srcElement.select();
    //event.srcElement.focus();
    //event.returnValue=false;     
    return false;
  }
}

function doSaveChange()
{
  sSaveFlag*=0;
  return (sSaveFlag==0)?true:false;  
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
   var from = parseInt(document.getElementsByName("startField")[i-1].value);
   if (i>1)
   {
        var p = parseInt(document.getElementsByName("endField")[i-2].value);
        if (from != p+1)
        {
           alert(" Start Basic Should Be One Greater Than Previous Rows End Basic ");
//         document.getElementsByName("startField")[i-1].select(); 
           document.getElementsByName("startField")[i-1].focus(); 
           chkMes = 1;
           return false;                      
        }                 
   }
   return true;
}

function chk_FromToAmount(i)
{     
 
  var from = parseInt(document.getElementsByName("startField")[i-1].value);          
  var to = parseInt(document.getElementsByName("endField")[i-1].value);
 
  if(to <= from )
  {
    alert("End Basic Should be greater than Start Basic ");
    document.getElementsByName("endField")[i-1].focus(); 

/*  event.srcElement.select();
    event.srcElement.focus();
    event.returnValue=false;*/
    
    return false;                        
  }
  else
  return true;
}

function chk_ToFromAmount(i)
{              
  var from = parseInt(document.getElementsByName("startField")[i-1].value);          
  var to = parseInt(document.getElementsByName("endField")[i-1].value);
 
  if(to <= from )
  {
     alert("End Basic Should be greater than Start Basic ");
    document.getElementsByName("endField")[i-1].focus();             
    return false;                        
  }
  else
  return true;
}

function  doInsertMode()
{
  document.all.buttonFlag.value='';
  document.all.screenModeFlag.value  = "N";
  document.all.screenModePay2.value  = "N";
  document.all.screenModeIDA.value  = "N";
  document.all.screenMode.value = "N";
  document.all.screenModePayScale.value = "I";
  frmDPSOTARates.action="../../../DPSOTARateNewMode.do"
  frmDPSOTARates.submit();

}

function doQueryMode()
{
  document.all.buttonFlag.value='';
  //document.all.screenModeFlag.value  = "Q";
  //document.all.screenModePay2.value  = "Q";
  //document.all.screenModeIDA.value  = "Q";
  document.all.screenMode.value = "Q";
  //document.all.screenModePayScale.value = "Q";
  
  frmDPSOTARates.action="../../../DPSOTARateQueryMode.do"
  frmDPSOTARates.submit();

}

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
      flag = document.all.screenModeFlag.value;
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
      }          
      if(mode=='N')
      {
          document.all.butGetDetail.disabled="true";
          document.all.butInsert.disabled="";
      }
      if(mode=='Q')
      {
          document.all.butGetDetail.disabled="true";          
          document.all.butDelete.disabled="true";
          document.all.butInsert.disabled="true";
      }     
      mode = frmDPSOTARates.screenMode.value;  
      frmDPSOTARates.txtLocId.value = frmDPSOTARates.loginLocCode.value;  
      frmDPSOTARates.txtLocDesc.value = frmDPSOTARates.loginEmployeelocation.value;  
      menuHandling(mode);  
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg"; 
 
 }

  
function ShowLovYYMM()
{
   frmDPSOTARates.lovKey.value = "MaintPayScaleIDA" + frmDPSOTARates.screenName.value + frmDPSOTARates.screenMode.value;
   frmDPSOTARates.txtDisplayFields.value = "txtYYMM";
      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDPSOTARates');
   return true;
}

function ShowLovPayScale()
{
   frmDPSOTARates.lovKey.value = "MaintPayScaleCodeIDA" + frmDPSOTARates.screenName.value + frmDPSOTARates.screenMode.value;
   frmDPSOTARates.txtDisplayFields.value = "lstPayScale";
      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDPSOTARates');
   return true;
}

function doBasePrevDetail()
{
    frmDPSOTARates.userPageRequested.value = 1*frmDPSOTARates.pageRequested.value - 1;
    frmDPSOTARates.action = "../../../payScaleIDAPrevDetailAction.do";
    frmDPSOTARates.submit();
}

function doBaseNextDetail()
{
    frmDPSOTARates.userPageRequested.value = 1*frmDPSOTARates.pageRequested.value + 1;
    frmDPSOTARates.action = "../../../payScaleIdaNextDetailAction.do";
    frmDPSOTARates.submit();
}

function JumpHeader()
{
   document.all.buttonFlag.value='';
  document.all.screenModeFlag.value  = "false";
  frmDPSOTARates.userPositionRequested.value = 1*frmDPSOTARates.newPositionRequested.value;
  frmDPSOTARates.action = "../../../DPSOTARateGetNextHeader.do";
  frmDPSOTARates.submit();
}

function JumpDetail()
{
    frmDPSOTARates.userPageRequested.value = 1*frmDPSOTARates.newPageRequested.value ;
    frmDPSOTARates.action = "../../../payScaleIdaNextDetailAction.do";
    frmDPSOTARates.submit();
}

function checkEndBasic()
{           
    var oTable = document.getElementById("Detail");
    var iTr2 = oTable.rows.length;
    var flag =0;
    var i = 0;         
    for(i=0;i<iTr2-1;i++)
    {   
        if((document.getElementsByName("status")[i].value) != "D")
        {                
            var tempStartBasic = parseInt(document.getElementsByName("startField")[i].value,10);
            var tempInstAmt = parseInt(document.getElementsByName("txtIncrement")[i].value,10);
            var tempEndBasic = parseInt(document.getElementsByName("endField")[i].value,10);
            var srNo=parseInt(document.getElementsByName("txtSrNo")[i].value,10);
           if(srNo==1)
            var tempTotalAmt=tempEndBasic - tempStartBasic;
          else
             var tempTotalAmt=tempEndBasic - tempStartBasic + 1;
        
            if (isNaN(tempTotalAmt))
            {
                document.getElementsByName("txtIncrement")[i].value= "";
                return false;
            }

            if (isNaN(tempInstAmt))
            {
                document.getElementsByName("txtIncrement")[i].value= "";
                return false;
            }
             if (tempInstAmt == 1)
            {
                document.getElementsByName("txtIncrement")[i].value= "";
                return false;
            } 

            var x=tempTotalAmt/tempInstAmt;
            var y=tempTotalAmt%tempInstAmt;
           // var z=(int)(tempTotalAmt/tempInstAmt);
//         alert(Math.floor(44.84));

  /*       var diff = x - Math.floor(x);
           diff = Math.ceil(diff);
           if (parseInt(diff)  > 0)
           {
             document.getElementsByName("txtNoInst")[i].value=parseInt(Math.floor(x)) + 1;                                             
            }
            else
            {
              document.getElementsByName("txtNoInst")[i].value=Math.floor(x);  
             }*/

            if (y != 0)
            {
               alert("The Difference of End Basic and Start Basic Should be a multiple of Increament Amount");
               document.getElementsByName("endField")[i].focus(); 
               return false;
            }                             
        }
         
    }              
return true;
}


function doRefresh()
{  
    frmDPSOTARates.action = "../../../DPSOTARateRefreshAction.do";
    frmDPSOTARates.submit();
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
          document.getElementsByName("startField")[i].disabled="";
  }
}

function chkDate(fromDate,toDate,indx)
{
  var  yearM = document.getElementById("txtYYMM").value;          
  var month =  parseInt(yearM.substring(4,6),10);
  var yr = parseInt(yearM.substring(0,4),10);      
  
  var frmCdt = change_DateFormatMon(document.getElementsByName(fromDate)[indx-1].value);  
  var toCdt = change_DateFormatMon(document.getElementsByName(toDate)[indx-1].value);  
  var frmdtArr=frmCdt.split("/");
  var todtArr=toCdt.split("/");
  
  var fromDt=document.getElementsByName(fromDate)[indx-1].value;
  var toDt=document.getElementsByName(toDate)[indx-1].value; 
  
  
  if(fromDt != '')
  {
    if(yr!= frmdtArr[2] || month != frmdtArr[1]) 
    {
      alert("Invalid Date for the given Year/Month");
      document.getElementsByName(fromDate)[indx-1].value="";      
      return false;
    }
  }
  
  if(toDt != '')
  {
    if(yr!= todtArr[2] || month != todtArr[1])
    {
      alert("Invalid Date for the given Year/Month");      
      document.getElementsByName(toDate)[indx-1].value="";
      return false;
    }
  }
  

  if(toDt!='')
  {
    if(!cmpDate(fromDt,toDt,0))
    {
      alert("End Date must be greater than to Start Date");
      document.getElementsByName(fromDate)[indx-1].value="";
      return false;                      
    }
  }
}


</script>

