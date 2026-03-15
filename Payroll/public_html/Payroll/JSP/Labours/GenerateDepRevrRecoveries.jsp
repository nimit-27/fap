<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>        
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../INCLUDES/ENRGISE.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/Payroll.js"></script>    
<!--    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>  -->  
     


</head>
<BODY onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="GenerateDepRevrRecoveries" name="frmGenerateRevrRecoveries" type="FCIPAY.Payroll.WEBTIER.Form.GenerateRevrRecoveriesForm" scope="session">
<bean:define id="ParentForm" name="frmGenerateRevrRecoveries" toScope="request" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="lovKey" name="frmGenerateRevrRecoveries"  />
<html:hidden property="txtFields" name="frmGenerateRevrRecoveries"  />   
<html:hidden property="txtSearchFields" name="frmGenerateRevrRecoveries"  />
<html:hidden property="txtDisplayFields" name="frmGenerateRevrRecoveries"  />
<html:hidden property="txtIndex" name="frmGenerateRevrRecoveries"  />
<input type="hidden" name="queryParam" >
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
 <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>REVERSAL RECOVERIES</TD>
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
          <TD class=subHeader colspan=6>REVERSAL RECOVERIES(Dept Labours)</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="6"></td>
            </tr>
        <TR>                
                     <TD class=labelText width="45%" ><bean:message key="pay.GenerateBasicArrear.txtpayYYMM" /></td>
                     <td><html:text  property="txtpayYYMM" altKey="pay.GenerateBasicArrear.txtpayYYMM" maxlength="10" size="23" styleClass="required"  />
                        <!--    <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtpayYYMM"  onclick="ShowLovYYMM();">  -->
                 <logic:equal property= "screenModeBasic" name= "frmGenerateRevrRecoveries" value="">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtpayYYMM"  onclick="ShowLovYYMM();">                 
                 </logic:equal>                                      

                 <logic:equal property= "screenModeBasic" name= "frmGenerateRevrRecoveries" value="Q">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtpayYYMM"  onclick="ShowLovYYMM();">                 
                 </logic:equal>                                      

                 <logic:equal property= "screenModeBasic" name= "frmGenerateRevrRecoveries" value="N">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtpayYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal> 
                  <logic:equal property= "screenModeBasic" name= "frmGenerateRevrRecoveries" value="U">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtpayYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>
                  <logic:equal property= "screenModeBasic" name= "frmGenerateRevrRecoveries" value="N1">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtpayYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>      
                 <logic:equal property= "screenModeBasic" name= "frmGenerateRevrRecoveries" value="UG">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtpayYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>

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
                    <td bgcolor="#4682B4" nowrap class=actTabText >Reversal Recoveries <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                    <td class=tableHeader width="24%"><bean:message key="pay.GenerateBasicArrear.empno" /></td>
                                    <td class=tableHeader width="24%"><bean:message key="pay.GenerateBasicArrear.empname" /></td>
                                    <td class=tableHeader width="24%"><bean:message key="pay.GenerateBasicArrear.fromdate" /> </td>
                                    <td class=tableHeader width="24%"><bean:message key="pay.GenerateBasicArrear.uptomnth" /></td>
                                  </tr>                                                      
                          <logic:iterate id="GenBasicArrearInfo" name="frmGenerateRevrRecoveries" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.GenRevrRecoveriesBean" indexId="idx" >
                          <% ++i; %>
                          <logic:notEqual name="GenBasicArrearInfo" property="status" value="D" >                              
                            <tr> <% ++j; %>                                                          
                                   <td ><html:checkbox property="checked" onclick="checkRecord();" name="frmGenerateRevrRecoveries" /></td>
                                   <td ><html:text property="txtEmployeeNo" name="GenBasicArrearInfo"  styleClass="required" size="20" style="width:90%" alt="<%=String.valueOf(i-1) %>" onchange="
                                       if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                        " />
                                 
                                        

                                        <logic:equal name="GenBasicArrearInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmployeeNo"  onclick="ShowLovEmpNo(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="GenBasicArrearInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmployeeNo"  disabled onclick="ShowLovEmpNo(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="GenBasicArrearInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmployeeNo"  disabled onclick="ShowLovEmpNo(this.alt);" >
                                       </logic:equal>                                    
                                     
                                   </td>
                                     
                                     <td ><html:text property="txtEmployeeName" name="GenBasicArrearInfo"  styleClass="locked" readonly="true" size="20" style="width:100%" alt="<%=String.valueOf(i-1) %>" onchange="return changed(this.alt);" /></td>                                  

                                    <td><html:text property="txtFromDate" name="GenBasicArrearInfo"  styleClass="required" size="26" style="width:92%;text-align:center" alt="<%=String.valueOf(i-1) %>" onchange=
                                    "
                                     if(!(checkDate(parseInt(this.alt))))
                                     {
                                          this.focus();
                                          return false;                         
                                     }
                                     else
                                     {
                                          if(!(chk_YearDate(parseInt(this.alt))))
                                          {
                                          return false;                         
                                          }
                                          else
                                          return changed(this.alt);
                                     }                                   
                                    " />
                                       <logic:equal name="GenBasicArrearInfo" property="status" value="N">
                                        <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" onclick="showCalendar('txtFromDate',this)" />
                                       </logic:equal>                                      
                                       <logic:equal name="GenBasicArrearInfo" property="status" value="Q">
                                       <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" disabled onclick="showCalendar('txtFromDate',this)" />
                                       </logic:equal>                                      
                                       <logic:equal name="GenBasicArrearInfo" property="status" value="U">
                                       <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" disabled onclick="showCalendar('txtFromDate',this)" />
                                       </logic:equal>

                                    
                                   <!-- <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtFromDate" alt="<%=(i-1) %>" onclick="showCalendar('txtFromDate',this)" />  -->
                                    </td>                                    
                                    
                                   <td ><html:text property="txtUptoMonth" name="GenBasicArrearInfo"  styleClass="required" style="width:100%;text-align:center" alt="<%=String.valueOf(i-1) %>" onchange="
                                  if(!(Chk_UptoMonth()))
                                        {
                                        return false;
                                        
                                        }
                                  
                                   if(!(chk_YearDate(parseInt(this.alt))))
                                          {
                                          return false;                         
                                          }
                                    else
                                       return changed(this.alt);
                                      
                                    " /></td>
                                  
                                   <html:hidden property="itemChecked" name="GenBasicArrearInfo" />
                                   <html:hidden property="status" name="GenBasicArrearInfo" />
                                   <html:hidden property="detailId" name="GenBasicArrearInfo" value="Default"/>                                   
                               </tr>
                          </logic:notEqual>
                          <logic:equal name="GenBasicArrearInfo" property="status" value="D" >                              
                                   <tr>
                                   <td ><html:hidden property="checked" name="frmGenerateRevrRecoveries" /></td>
                                   <td ><html:hidden property="txtEmployeeNo" name="GenBasicArrearInfo"  styleClass="required" style="width:100%" /></td>
                                   <td ><html:hidden property="txtEmployeeName" name="GenBasicArrearInfo"  styleClass="required" style="width:100%" /></td>
                                   <td><html:hidden property="txtFromDate" name="GenBasicArrearInfo"  styleClass="required" style="width:100%"  /></td>
                                   <td ><html:hidden property="txtUptoMonth" name="GenBasicArrearInfo"  styleClass="required" style="width:100%" /></td>
                                   <html:hidden property="itemChecked" name="GenBasicArrearInfo" />
                                   <html:hidden property="status" name="GenBasicArrearInfo" />
                                   <html:hidden property="detailId" name="GenBasicArrearInfo" value="Default"/>                                  
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

         <TR>
               <td align=center bgcolor=#4682b4 width="40%"></td>
               <td width="12%" bgcolor=#4682b4><input type="button" name="butGenBasicArr" value="Create Promotion Reversal Recovery Transactions" onclick="GenBasicArrear()" class="bottomBarText"><input type="button" name="butUndoBasicArr" value="   Undo Transactions   " onclick="UndoBasicArrear()" class="bottomBarText"></td>
               <td bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>

<!--      <TR>
               <td align=center bgcolor=#4682b4 width="40%"></td>
               <td width="12%" bgcolor=#4682b4><input type="button" name="butGenBasicArr" value="Generate Basic Arrear" onclick="GenBasicArrear()" class="bottomBarText"> 
                <input type="button" name="butUndoBasicArr" value="   Undo Basic Arrear   " onclick="UndoBasicArrear()" class="bottomBarText"></td>
               <td bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>  -->


	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>


<!-- Container Table Ends -->
<html:hidden property="headerPrimaryKey" name="frmGenerateRevrRecoveries" />
<html:hidden property="screenMode" name="frmGenerateRevrRecoveries"  />
<html:hidden property="screenModeBasicArr" name="frmGenerateRevrRecoveries"  />
<html:hidden property="screenModeBasic" name="frmGenerateRevrRecoveries"  />
<html:hidden property="screenModePay1" name="frmGenerateRevrRecoveries"  />
<html:hidden property="screenModePay2" name="frmGenerateRevrRecoveries"  />
<html:hidden name="frmGenerateRevrRecoveries"  property="screenName" value="ReversalRecoveryDepScreen" />
<html:hidden name="frmGenerateRevrRecoveries"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmGenerateRevrRecoveries" />
<html:hidden property="userPositionRequested" name="frmGenerateRevrRecoveries" />
<html:hidden property="totalDetailRecord" name="frmGenerateRevrRecoveries"  />
<html:hidden property="hdnPayrollFlag" name="frmGenerateRevrRecoveries"  />
<html:hidden property="hdnCurYYMM" name="frmGenerateRevrRecoveries"  />
<html:hidden property="hdnPayStatus" name="frmGenerateRevrRecoveries"  />
<html:hidden property="buttonFlag" name="frmGenerateRevrRecoveries"  />
<html:hidden property="userPageRequested" name="frmGenerateRevrRecoveries" />
<html:hidden property="pageRequested" name="frmGenerateRevrRecoveries" />
<html:hidden property="butAction" name="frmGenerateRevrRecoveries" />
<html:hidden property="loginLocCode" name="frmGenerateRevrRecoveries" />

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
         frmGenerateRevrRecoveries.detailDataChanged.value = "true";
         if (document.getElementsByName("status")[val].value == 'Q')
         document.getElementsByName("status")[val].value = 'U';
    }


  function GetDetail()
  {
    document.all.buttonFlag.value='';
 // document.all.screenMode.value='U';
    document.all.screenModeBasic.value='UG';

    document.all.screenModePay1.value = document.all.screenModePay2.value;        
    frmGenerateRevrRecoveries.headerPrimaryKey.value = frmGenerateRevrRecoveries.txtpayYYMM.value ;  
    frmGenerateRevrRecoveries.action="../../../RevrRecoverDepFirstGetDetailAction.do"
    frmGenerateRevrRecoveries.submit();
  }

  function getHeaderRecord()
  {
	document.all.buttonFlag.value='';
	document.all.screenModePay1.value  = "U";
	document.all.screenModePay2.value  = "U";
	document.all.screenModeBasic.value='U';
	document.all.screenModeBasicArr.value = "U1"; 
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmGenerateRevrRecoveries.action="../../../RevrRecoverDepFirstGetHeaderAction.do";
	frmGenerateRevrRecoveries.submit();
  }


function doGetNextHeader()
{ 
  document.all.buttonFlag.value='';
  //  frmGenerateBasicArrear.screenMode.value='U';
 document.all.screenModeBasic.value='U';
  document.all.screenModeBasicArr.value = "U1";    
    frmGenerateRevrRecoveries.userPositionRequested.value = 1*frmGenerateRevrRecoveries.positionRequested.value + 1;  
    frmGenerateRevrRecoveries.action="../../../RevrRecoverDepGetNextHeader.do";
    frmGenerateRevrRecoveries.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  document.all.screenModeBasic.value='U';
  document.all.screenModeBasicArr.value = "U1";    
  frmGenerateRevrRecoveries.userPositionRequested.value = frmGenerateRevrRecoveries.positionRequested.value - 1;
  frmGenerateRevrRecoveries.action = "../../../RevrRecoverDepGetPrevHeader.do";
  frmGenerateRevrRecoveries.submit();
}


function JumpHeader()
{

  document.all.buttonFlag.value='';
  document.all.screenModeBasic.value='UG';
  document.all.screenModeBasic.value='U';
  frmGenerateRevrRecoveries.userPositionRequested.value = 1*frmGenerateRevrRecoveries.newPositionRequested.value;
  frmGenerateRevrRecoveries.action = "../../../RevrRecoverDepGetNextHeader.do";
  frmGenerateRevrRecoveries.submit();
}



  function doBaseAddRow()
  {
   document.all.buttonFlag.value='D';

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
          
                document.getElementsByName("txtEmployeeNo")[i].disabled="";
                document.getElementsByName("txtFromDate")[i].disabled=""; 
              }
         }


  
   if(!mandatory_Check("frmGenerateRevrRecoveries"))
    return false;

    if(!chk_YearMonth())
    {
    document.getElementById("txtpayYYMM").focus();
    return false;
    }

   document.getElementById("txtpayYYMM").disabled="";
 
  //  frmGenerateBasicArrear.screenModeBasic.value = "N1";

  frmGenerateRevrRecoveries.screenModeBasicArr.value = "N1";
    frmGenerateRevrRecoveries.action = "../../../RevrRecoverDepAddRowAction.do";
    frmGenerateRevrRecoveries.submit();
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
       frmGenerateRevrRecoveries.detailDataChanged.value = "true";      
    }
  }


    EnableFields();
  document.forms[0].action = "../../../RevrRecoverDepDeleteRowAction.do";
  document.forms[0].submit();  
}

  


function SaveRecord()
{
document.all.buttonFlag.value='';

document.all.screenModePay1.value = document.all.screenMode.value;  
document.all.screenMode.value = "U";

 
   if(!chk_YearMonth())
      return false;

   if(!Chk_UptoMonth())
       return false;

   if(!DupliCheck())
      return false;


   if(!mandatory_Check("frmGenerateRevrRecoveries"))
        return false;      


   if(!DetailRecordNo_check())
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
        document.getElementsByName("txtEmployeeNo")[i].disabled="";
        document.getElementsByName("txtFromDate")[i].disabled="";
           
  }

 // frmGenerateBasicArrear.screenMode.value = "U";  
  document.getElementById("txtpayYYMM").disabled="";  
    document.all.butSave.disabled="true";        
    if (document.all.screenMode.value == "N")
    {
       document.all.screenModeBasic.value = "UG";
       document.all.screenMode.value = "U";    
       document.all.ScreenModePay1.value = "U";                  
    }  
  
	frmGenerateRevrRecoveries.headerPrimaryKey.value = frmGenerateRevrRecoveries.txtpayYYMM.value ;
	frmGenerateRevrRecoveries.totalDetailRecord.value = parseInt(iTr2,10) - 1;
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	frmGenerateRevrRecoveries.action = "../../../RevrRecoverDepSaveAction.do";
	frmGenerateRevrRecoveries.submit();
}


   function DetailRecordNo_check()
    {

          var oTable = document.getElementById("Detail");
                    var iTr2 = oTable.rows.length;
                    var flag =0;
                  
          frmGenerateRevrRecoveries.totalDetailRecord.value = parseInt(iTr2,10) - 1;
          if( frmGenerateRevrRecoveries.totalDetailRecord.value==0)
          {
          alert("Atleast one Detail Reord is Mandatory");
          return false;
          }
       return true;
    }
   
    
function chk_YearMonth()
{

       var  yearM = document.getElementById("txtpayYYMM").value;          
       var month =  parseInt(yearM.substring(4,6),10);
      
    if (num_Check(yearM,1))
     {                                   
           
        if (yearM.length != 6)
        {
        alert("Payroll Year Month should be a Six digit Number");
//        document.getElementById("txtpayYYMM").focus();                     
/*            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            */
        
        return false;
    
        }

  
       if(month < 1 || month > 12)
       {
       alert("Month should be Within 1 to 12");
   //    document.getElementById("txtpayYYMM").focus();                     
  //          event.srcElement.select();
   //         event.srcElement.focus();
  //          event.returnValue=false;            
        
          return false;
       }
        return true;
     }
     else
     {
     //       event.srcElement.select();
      //      event.srcElement.focus();
     //       event.returnValue=false;     
    return false;
     }
}




function doSaveChange(){
  sSaveFlag*=0;
  return (sSaveFlag==0)?true:false;  
}



function  doInsertMode()
{
  document.all.buttonFlag.value='';
  document.all.screenMode.value = "N";
  document.all.screenModePay1.value  = "N";
  document.all.screenModePay2.value  = "N";
  document.all.screenModeBasicArr.value = "I";
   document.all.screenModeBasic.value = "N";
  frmGenerateRevrRecoveries.action="../../../RevrRecoverDepNewMode.do"
  frmGenerateRevrRecoveries.submit();

}

function doQueryMode()
{
 document.all.buttonFlag.value='';
 document.all.screenModePay1.value  = "Q";
 document.all.screenModePay2.value  = "Q";
 document.all.screenModeBasicArr.value  = "Q";
 document.all.screenModeBasic.value = "Q";
 document.all.screenMode.value = "Q";
  //document.all.screenModePayScale.value = "Q";
  frmGenerateRevrRecoveries.action="../../../RevrRecoverDepQueryMode.do"
  frmGenerateRevrRecoveries.submit();

}



function lfnLoad()
{  
  mode = frmGenerateRevrRecoveries.screenMode.value;

  if(mode == '')
  {
    doQueryMode();
  }


 if (frmGenerateRevrRecoveries.screenMode.value == "Q")
     frmGenerateRevrRecoveries.screenModeBasic.value="Q";

  if (frmGenerateRevrRecoveries.screenModeBasicArr.value=="N1")
    {
         if (frmGenerateRevrRecoveries.screenModeBasic.value == "")
         {
            if (frmGenerateRevrRecoveries.screenMode.value == "U")
            {
                frmGenerateRevrRecoveries.screenModeBasic.value = "U";
            }
            else
            {
              frmGenerateRevrRecoveries.screenModeBasic.value="UG";                
            }            
          }    
          else
          {
            frmGenerateRevrRecoveries.screenModeBasic.value="UG";              
          }
    }
    
    if (frmGenerateRevrRecoveries.screenModeBasicArr.value=="N") 
    {
      if (frmGenerateRevrRecoveries.screenModeBasic.value != "UG")          
       frmGenerateRevrRecoveries.screenModeBasic.value="U";
    }
   
   if (frmGenerateRevrRecoveries.screenModeBasic.value == "")
  {
     if (frmGenerateRevrRecoveries.screenMode.value == "U")
     {
         frmGenerateRevrRecoveries.screenModeBasic.value = "U";
     }
     else
     {
       frmGenerateRevrRecoveries.screenModeBasic.value = "Q";
       frmGenerateRevrRecoveries.screenMode.value = "Q";    
       frmGenerateRevrRecoveries.screenModeBasicArr.value = "Q";         
      }
   }


  if (frmGenerateRevrRecoveries.screenModePay1.value=="N") 
  {
    frmGenerateRevrRecoveries.screenModeBasic.value ="N";
    frmGenerateRevrRecoveries.screenMode.value ="N";
}
    
  mode = frmGenerateRevrRecoveries.screenModeBasic.value;
  
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


 if (frmGenerateRevrRecoveries.screenMode.value == 'U')
     { 
        document.getElementById("txtpayYYMM").disabled = "true";

       var  iCurYYMM = parseInt(frmGenerateRevrRecoveries.hdnCurYYMM.value,10);
       var  iPayYYMM = parseInt(frmGenerateRevrRecoveries.txtpayYYMM.value,10);       
       var  iStatus = parseInt(frmGenerateRevrRecoveries.hdnPayStatus.value,10);       
       
      if (( frmGenerateRevrRecoveries.hdnPayrollFlag.value == 'Y') || ( iCurYYMM > iPayYYMM  )  || ( iCurYYMM == iPayYYMM    &&  iStatus == 2)     )
        {
           document.all.butInsert.disabled="disabled";
           document.all.butDelete.disabled="disabled";

                 var oTable = document.getElementById("Detail");
                if(oTable == null)
                {
                  return;
                }
                var iTr2 = oTable.rows.length;
                var i = 0;

                for(i=0; i < iTr2 -1; i++)
                  {
                    document.getElementsByName("txtEmployeeNo")[i].disabled="disabled";
                    document.getElementsByName("txtFromDate")[i].disabled="disabled"; 
                    document.getElementsByName("txtUptoMonth")[i].disabled="disabled";
                  }  
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
                  document.getElementsByName("txtEmployeeNo")[i].disabled="disabled";
                  document.getElementsByName("txtFromDate")[i].disabled="disabled"; 
                }
           }        
     }
  else
      {  
         document.getElementById("txtpayYYMM").disabled="";       
      }  
  mode1 = document.all.screenMode.value;
  menuHandling(mode1);      
 }


  
function ShowLovYYMM()
{
   frmGenerateRevrRecoveries.lovKey.value = "PayYYMM" + frmGenerateRevrRecoveries.screenName.value + frmGenerateRevrRecoveries.screenMode.value;
   frmGenerateRevrRecoveries.txtDisplayFields.value = "txtpayYYMM";
   frmGenerateRevrRecoveries.queryParam.value="hdnEmpLbrFlag="+ frmGenerateRevrRecoveries.hdnEmpLbrFlag.value ;            
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmGenerateRevrRecoveries');
   return true;
}

function ShowLovEmpNo(i)
{
   frmGenerateRevrRecoveries.lovKey.value = "EmpNo" + frmGenerateRevrRecoveries.screenName.value + "N";
   frmGenerateRevrRecoveries.txtDisplayFields.value = "txtEmployeeNo,txtEmployeeName";
   frmGenerateRevrRecoveries.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
   frmGenerateRevrRecoveries.queryParam.value="txtSiteID="+ frmGenerateRevrRecoveries.loginLocCode.value +",hdnEmpLbrFlag="+frmGenerateRevrRecoveries.hdnEmpLbrFlag.value ;
   frmGenerateRevrRecoveries.txtIndex.value=i;  
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmGenerateRevrRecoveries');
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


   function chk_YearDate(i)
   {
                
                var m = document.getElementsByName("txtFromDate")[i].value;
                var toYear= parseInt(document.getElementsByName("txtUptoMonth")[i].value);  
               if(m != "")
               {                
                  var d=parseDate(m);
                  var fromYear = formatDate(new Date(getDateFromFormat(formatDate(d,'MMM dd, yyyy'),"MMM d, y")),"yyyyMM");      
                  if(fromYear > toYear)
                  {
                  alert("Upto Month should be greater than or equal to From Date");
                  return false;
                  }
                }
             return true;   
  }



  function checkDate(i)
  {
   var m = document.getElementsByName("txtFromDate")[i].value;
     if(m != "")
     {
        if(!isDate(m,"dd-MMM-yyyy"))
      {
      alert("Enter From Date in the Format DD-MMM-YYYY");
      return false;
      }
    }    
    return true;
  }
  


function Chk_UptoMonth()
{
           var oTable = document.getElementById("Detail");
            var iTR = oTable.rows.length;
            var flag =0;

       for(i=0;i<iTR-1;i++)
         {   
                var yearM = document.getElementsByName("txtUptoMonth")[i].value;
                
                var month =  parseInt(yearM.substring(4,6),10);
           
                  if (yearM.length != 6)
                  {
                  alert("Upto Year Month should be a Six digit Number");
                  document.getElementsByName("txtUptoMonth")[i].focus(); 
          /*            event.srcElement.select();
                      event.srcElement.focus();
                      event.returnValue=false;            */
        
                  return false;
    
                  }

                 if(month < 1 || month > 12)
                       {
                       alert("Month should be Within 1 to 12");
                       document.getElementsByName("txtUptoMonth")[i].focus(); 
                 
                  //          event.srcElement.select();
                   //         event.srcElement.focus();
                  //          event.returnValue=false;            
        
                          return false;
                       }
                                                   
            }             
 
        return true;
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
       
                var EmpNo1 = parseInt(document.getElementsByName("txtEmployeeNo")[i].value);
                for(j=i+1;j<iTr2-1;j++)                
                {                       
                      var EmpNo2 = parseInt(document.getElementsByName("txtEmployeeNo")[j].value);
                      if(EmpNo1==EmpNo2)
                      {
                       alert("Duplication of Employee No. is not allowed"); 
                       document.getElementsByName("txtEmployeeNo")[j].focus();
                       return false;
                      }                                               
                 }                              
             }
        return true;
}



function doBasePrevDetail()
{
    frmGenerateRevrRecoveries.userPageRequested.value = 1*frmGenerateRevrRecoveries.pageRequested.value - 1;
    frmGenerateRevrRecoveries.action = "../../../RevrRecoverDepPrevDetailAction.do";
    frmGenerateRevrRecoveries.submit();
}


function doBaseNextDetail()
{
    frmGenerateRevrRecoveries.userPageRequested.value = 1*frmGenerateRevrRecoveries.pageRequested.value + 1;
    frmGenerateRevrRecoveries.action = "../../../RevrRecoverDepNextDetailAction.do";
    frmGenerateRevrRecoveries.submit();
}

function JumpDetail()
{
    frmGenerateRevrRecoveries.userPageRequested.value = 1*frmGenerateRevrRecoveries.newPageRequested.value ;
    frmGenerateRevrRecoveries.action = "../../../RevrRecoverDepNextDetailAction.do";
    frmGenerateRevrRecoveries.submit();
}

  function GenBasicArrear()
  {
        if(!mandatory_Check("frmGenerateRevrRecoveries"))
            return false;
        else{
        frmGenerateRevrRecoveries.butAction.value = "Generate";
        ac="../../../RevrRecoverDepAction.do?param1="+document.all.txtpayYYMM.value;
        document.forms[0].action=ac;
        document.forms[0].submit();
       }

  }

   function UndoBasicArrear()
    {
        if(!mandatory_Check("frmGenerateRevrRecoveries"))
            return false;
        else{
        frmGenerateRevrRecoveries.butAction.value = "Undo";
        ac="../../../RevrRecoverDepAction.do?param1="+document.all.txtpayYYMM.value;
        document.forms[0].action=ac;
        document.forms[0].submit();
       }
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
              document.getElementsByName("txtEmployeeNo")[i].disabled="";
              document.getElementsByName("txtFromDate")[i].disabled=""; 
              document.getElementsByName("txtUptoMonth")[i].disabled=""; 
      }
}

   function doRefresh()
    {
   
        frmGenerateRevrRecoveries.action = "../../../RevrRecoverDepRefresh.do";
        frmGenerateRevrRecoveries.submit();
    }


</script>
