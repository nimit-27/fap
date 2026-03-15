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
<html:form  action="MaintPayScale" name="frmMaintPayScale" type="FCIPAY.Payroll.WEBTIER.Form.MaintPayScaleForm" scope="session">
<bean:define id="ParentForm" name="frmMaintPayScale" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />


<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="lovKey" name="frmMaintPayScale"  />
<html:hidden property="txtFields" name="frmMaintPayScale"  />   
<html:hidden property="txtSearchFields" name="frmMaintPayScale"  />
<html:hidden property="txtDisplayFields" name="frmMaintPayScale"  />
<html:hidden property="txtIndex" name="frmMaintPayScale"  />


<%! int i=0,j=0; %>
<% i = 0;j=0; %>
 


<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN PAY SCALE</TD>
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
          <TD class=subHeader colspan=6> Pay Scale Header</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="6"></td>
            </tr>
        <TR>                
                     <TD class=labelText width="15%" ><bean:message key="pay.MaintPayScaleIDA.txtRevYYMM" /></td>
                     <td><html:text  property="txtRevYYMM" altKey="pay.MaintPayScaleIDA.txtRevYYMM" maxlength="10" size="23" styleClass="required"  onchange="
                                                  
                       if(!(chk_YearMonth()))
                          {
                          }                                    
                     " />

              <logic:equal property= "screenMode" name= "frmMaintPayScale" value="">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  onclick="ShowLovYYMM();">                 
                 </logic:equal>                                      

                 <logic:equal property= "screenMode" name= "frmMaintPayScale" value="Q">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  onclick="ShowLovYYMM();">                 
                 </logic:equal>                                      

                 <logic:equal property= "screenMode" name= "frmMaintPayScale" value="I">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>      
                 <logic:equal property= "screenMode" name= "frmMaintPayScale" value="N">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>      
                 <logic:equal property= "screenMode" name= "frmMaintPayScale" value="U1">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>
                  <logic:equal property= "screenMode" name= "frmMaintPayScale" value="U">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>                
                 
                 
                     </td>
               
                     <td class=labelText width="15%" ><bean:message key="pay.MaintPayScaleIDA.payscalecode" /></td>
                  <td>
                  <html:text  property="lstPayScale" altKey="pay.MaintPayScaleIDA.payscalecode" maxlength="10" size="23" styleClass="required"  onchange=" return changed(this.alt);" />
                  <logic:equal property= "screenMode" name= "frmMaintPayScale" value="">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butlstPayScale"  onclick="ShowLovPayScale();">                 
                 </logic:equal>                                      

                 <logic:equal property= "screenMode" name= "frmMaintPayScale" value="Q">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butlstPayScale"  onclick="ShowLovPayScale();">                 
                 </logic:equal>                                      

                 <logic:equal property= "screenMode" name= "frmMaintPayScale" value="I">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butlstPayScale"   onclick="ShowLovPayScale();">                                  
                 </logic:equal>      
                 <logic:equal property= "screenMode" name= "frmMaintPayScale" value="N">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butlstPayScale"  disabled onclick="ShowLovPayScale();">                                  
                 </logic:equal>      
                 <logic:equal property= "screenMode" name= "frmMaintPayScale" value="U1">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butlstPayScale"  disabled onclick="ShowLovPayScale();">                                  
                 </logic:equal>
                  <logic:equal property= "screenMode" name= "frmMaintPayScale" value="U">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butlstPayScale"  disabled onclick="ShowLovPayScale();">                                  
                 </logic:equal> </td>
                            
                            
             </tr><tr></tr><td class=labelText width="15">PayScaleType</td>
                                        <td colspan="1"><html:select property="txtPayScaleType" styleClass="required" alt="<%=String.valueOf(i)%>"  style="WIDTH: 50%"  >
                   <html:option value="" >-----------Please Select-----------</html:option>      
                   <logic:present name="PayScaleVO">
                  <html:optionsCollection label="label" value="value" property="payScaleList" name="PayScaleVO"/>
                </logic:present> 
                </html:select></td>           
                     </tr>  
                      
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
                    <td bgcolor="#4682B4" nowrap class=actTabText > Pay Scale Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <td class=tableHeader width="8%"><bean:message key="pay.MaintPayScaleIDA.srNo" /></td>
                              <td class=tableHeader width="8%"><bean:message key="pay.MaintPayScaleIDA.startbasic" /></td>
                              <td class=tableHeader width="8%"><bean:message key="pay.MaintPayScaleIDA.gradepay" /> </td>
                              <td class=tableHeader width="8%"><bean:message key="pay.MaintPayScaleIDA.endbasic" /></td>
                              <td class=tableHeader width="8%"><bean:message key="pay.MaintPayScaleIDA.startdate" /></td>
                              <td class=tableHeader width="8%"><bean:message key="pay.MaintPayScaleIDA.enddate" /></td>

                              
                   </tr>                                                      
                          <logic:iterate id="payScaleInfo" name="frmMaintPayScale" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintPayScaleDtlIDABean" >
                          <% ++i; %>
                          <logic:notEqual name="payScaleInfo" property="status" value="D" >                              
                            <tr> <% ++j; %>                                                          
                                   <td ><html:checkbox property="checked" onclick="checkRecord1();" name="frmMaintPayScale" /></td>
                                   <td ><html:text property="txtSrNo" name="payScaleInfo"  value="<%=String.valueOf(j)%>" styleClass="optional" style="width:100%" /></td>
                                    <td ><html:text property="startField" name="payScaleInfo"  styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                    if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                        if(!(chk_FromAmount(this.value, this.alt)))
                                        {
                                        }
                                        else
                                        {
                                          return changed(this.alt);
                                        }                                                                                                                    
                                      " /></td>
                                   <td><html:text property="txtGradePay" name="payScaleInfo"  styleClass="required" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="
                                     if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }
                                     else
                                       return changed(this.alt);
                                   " /></td>
                                   <td ><html:text property="endField" name="payScaleInfo"  styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                   if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                 /*       if(!(chk_ToAmount(this.value, this.alt)))
                                        {
                                        }
                                        else
                                        {
                                          return changed(this.alt);
                                        }  */ 

                                        
                                        changeDtlStartField('startField', 'endField', this.alt, '0');
                                        return changed(this.alt);                                          
                                        
                                        /*if(!(AmtCheck()))
                                          {
                                          }
                                       else
                                          {
                                            return changed(this.alt);
                                          } */
                                          
                                    " /></td>
                                <td><html:text property="txtStartDate" name="payScaleInfo" styleClass="required"  readonly="true" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return chk_PrevDt(this.alt)" />
                                 <img src="..\INCLUDES\IMAGES\cal.gif" id="my_image1" width=15 height=19 align="top" styleClass="lov"   alt="<%=(i-1) %>"  onclick="showCalendar('txtStartDate',this)"  />
                                 </td>
                               <!--  property="buttxtEffDate"  -->
                                 <td><html:text property="txtEndDate" name="payScaleInfo" styleClass="optional"  readonly="true" style="width:90%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="return chkFromDt(this.alt)" />
                                  <img src="..\INCLUDES\IMAGES\cal.gif" id="my_image2" width=15 height=19 align="top" styleClass="lov"  alt="<%=(i-1) %>" onclick="showCalendar('txtEndDate',this)"   />
                                  </td>
                                   <html:hidden property="hdnEBCheck" name="payScaleInfo" />                                                                                                         
                                   <html:hidden property="txtSrlNo" name="payScaleInfo" />   
                                   <html:hidden property="itemChecked" name="payScaleInfo" />
                                   <html:hidden property="status" name="payScaleInfo" />
                                   <html:hidden property="detailId" name="payScaleInfo" value="Default"/>
                                   <html:hidden property="txtIncrement" name="payScaleInfo" />  
                               </tr>
                          </logic:notEqual>
                          <logic:equal name="payScaleInfo" property="status" value="D" >                              
                                   <tr>
                                   <td ><html:hidden property="checked" name="frmMaintPayScale" /></td>
                                   <td ><html:hidden property="txtSrNo" name="payScaleInfo"  style="width:100%" /></td>
                                   <td ><html:hidden property="startField" name="payScaleInfo"  style="width:100%" /></td>
                                   <td><html:hidden property="txtGradePay" name="payScaleInfo"  style="width:100%"  /></td>
                                   <td ><html:hidden property="endField" name="payScaleInfo"  style="width:100%" /></td>
                                    <td ><html:hidden property="txtStartDate" name="payScaleInfo"  style="width:100%" /></td>
                                    <td ><html:hidden property="txtEndDate" name="payScaleInfo"  style="width:100%" /></td> 
                                    <td ><html:hidden property="buttxtEffDate" name="payScaleInfo"  style="width:100%" /></td> 
                                    
                                   <html:hidden property="hdnEBCheck" name="payScaleInfo" />                                                                                                                                                                           
                                   <html:hidden property="txtSrlNo" name="payScaleInfo" />    
                                   <html:hidden property="txtIncrement" name="payScaleInfo" />  
                                  
                                   <html:hidden property="itemChecked" name="payScaleInfo" />
                                   <html:hidden property="status" name="payScaleInfo" />
                                   <html:hidden property="detailId" name="payScaleInfo" value="Default"/>                                  
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
<html:hidden property="headerPrimaryKey" name="frmMaintPayScale" />
<html:hidden property="screenMode" name="frmMaintPayScale"  />
<html:hidden property="screenModeIDA" name="frmMaintPayScale"  />
<html:hidden property="headerClick" name="frmMaintPayScale"  />
<html:hidden property="screenModePayScale" name="frmMaintPayScale"  />
<html:hidden property="screenModePay1" name="frmMaintPayScale"  />
<html:hidden property="screenModePay2" name="frmMaintPayScale"  />
<html:hidden name="frmMaintPayScale"  property="screenName" value="PayScaleIDA" />
<html:hidden name="frmMaintPayScale"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmMaintPayScale" />
<html:hidden property="userPositionRequested" name="frmMaintPayScale" />
<html:hidden property="userPageRequested" name="frmMaintPayScale" />
<html:hidden property="pageRequested" name="frmMaintPayScale" />
<html:hidden property="totalDetailRecord" name="frmMaintPayScale"  />
<html:hidden property="buttonFlag" name="frmMaintPayScale"  />
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
        if ((frmMaintPayScale.screenMode.value == "U") || (frmMaintPayScale.screenMode.value == "N"))
        {     
         frmMaintPayScale.detailDataChanged.value = "true";
         if (document.getElementsByName("status")[val-1].value == 'Q')
         document.getElementsByName("status")[val-1].value = 'U';
        } 
        else
         frmMaintPayScale.detailDataChanged.value = "false";        
    }


  function GetDetail()
  {
   document.all.buttonFlag.value='';  
    document.all.screenModeIDA.value='UG';
    document.all.screenModePay1.value = document.all.screenModePay2.value;        
    frmMaintPayScale.headerPrimaryKey.value = frmMaintPayScale.txtRevYYMM.value + "," + frmMaintPayScale.lstPayScale.value;  
    frmMaintPayScale.action="../../../payScaleFirstGetDetailAction.do"
    frmMaintPayScale.submit();
  }

  function getHeaderRecord()
  {
    document.all.buttonFlag.value='';  
    document.all.screenModePay1.value  = "U";
    document.all.screenModePay2.value  = "U";
    //  document.all.screenMode.value = "U";
  
    document.all.screenModeIDA.value='U'; 
    
    document.all.screenModePay1.value = "U";
    document.all.screenModePayScale.value = "U1";    
    document.all.headerClick.value = "IDA";   
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmMaintPayScale.action="../../../payScaleFirstGetHeaderAction.do";
    frmMaintPayScale.submit();
  }


function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmMaintPayScale.screenModeIDA.value='U';
    frmMaintPayScale.headerClick.value = "IDA";
    document.all.screenModePayScale.value = "U1"; 
    frmMaintPayScale.userPositionRequested.value = 1*frmMaintPayScale.positionRequested.value + 1;   
    frmMaintPayScale.action="../../../PayIdaGetNextHeader.do";
    frmMaintPayScale.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmMaintPayScale.screenModeIDA.value='U';
  document.all.screenModePayScale.value = "U1"; 
  frmMaintPayScale.headerClick.value = "IDA";
  frmMaintPayScale.userPositionRequested.value = frmMaintPayScale.positionRequested.value - 1;
  frmMaintPayScale.action = "../../../PayIdaGetPrevHeader.do";
  frmMaintPayScale.submit();
}


  function doBaseAddRow()
  {
    document.all.buttonFlag.value='D';  
    if(!mandatory_Check("frmMaintPayScale"))
    return false;

    if(!chk_YearMonth())
    {
    document.getElementById("txtRevYYMM").focus();
    return false;
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
		    document.getElementsByName("startField")[i].disabled="false";
			if ( document.getElementsByName("txtEndDate")[i].value=="")
			{
				   alert('First end date the active pay scale');
				   return false;
			}      
         }




//    frmMaintPayScale.screenMode.value = "U";
    frmMaintPayScale.screenModePayScale.value = "N1";
    frmMaintPayScale.detailDataChanged.value = "false";    
    document.getElementById("txtRevYYMM").disabled="";
    document.getElementById("lstPayScale").disabled="";

    
    frmMaintPayScale.action = "../../../payScaleAddRowAction.do";
    frmMaintPayScale.submit();
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

  EnableFields();
  document.forms[0].action = "../../../payScaleFirstDeleteRowAction.do";
  document.forms[0].submit();  
}

  


function SaveRecord()
{

 document.all.buttonFlag.value='';
 document.all.screenModePay1.value = document.all.screenModePay2.value;    

 
  if(!chk_YearMonth())
  return false;
if(!mandatory_Check("frmMaintPayScale"))
        return false;      
if(!AmtCheck())
      return false;


  if(!checkEndBasic())
  return false;
      

 if(!DetailRecordNo_check())
      return false;  

 frmMaintPayScale.screenMode.value = 'U';
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  for(i=0; i < iTr2 -1; i++)
  {
     // document.getElementsByName("txtRevYYMM1")[i].value = document.getElementById("txtRevYYMM").value;
    //  document.getElementsByName("txtPayScaleCode")[i].value = document.getElementById("lstPayScale").value;      
     // if(document.getElementsByName("txtEfficiencyBar")[i].checked)
       //   document.getElementsByName("hdnEBCheck")[i].value = "1";
     // else
     //     document.getElementsByName("hdnEBCheck")[i].value = "0";  

           document.getElementsByName("startField")[i].disabled="";
  }
  
  document.all.screenModePay1.value=document.all.screenModePay2.value;
  frmMaintPayScale.headerPrimaryKey.value = frmMaintPayScale.txtRevYYMM.value + "," + frmMaintPayScale.lstPayScale.value;
  frmMaintPayScale.totalDetailRecord.value = parseInt(iTr2,10) - 1;  
  frmMaintPayScale.headerFields.value = "true";
  frmMaintPayScale.detailDataChanged.value="true";
  document.all.screenModePay2.value = "U";    
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintPayScale.action = "../../../PayScaleIDASaveAction.do";
  frmMaintPayScale.submit();
}


   function DetailRecordNo_check()
    {

          var oTable = document.getElementById("Detail");
                    var iTr2 = oTable.rows.length;
                    var flag =0;
                  
          frmMaintPayScale.totalDetailRecord.value = parseInt(iTr2,10) - 1;
          if( frmMaintPayScale.totalDetailRecord.value==0)
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

       var  yearM = document.getElementById("txtRevYYMM").value;          
       var month =  parseInt(yearM.substring(4,6),10);
      
    if (num_Check(yearM,1))
     {                                   
           
        if (yearM.length != 6)
        {
        alert("Revision Year Month should be a Six digit Number");
//        document.getElementById("txtRevYYMM").focus();                     
/*            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            */
        
        return false;
    
        }

  
       if(month < 1 || month > 12)
       {
       alert("Revision  Month should be Within 1 to 12");
   //    document.getElementById("txtRevYYMM").focus();                     
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


 function doGetTab(arg)
 {
   document.all.buttonFlag.value=''; 
/*    if ((frmMaintPayScale.screenMode.value=="U") && (frmMaintPayScale.screenMode.value=="U") && (frmMaintPayScale.screenModeIDA.value != "UG"))
    {
      frmMaintPayScale.screenModeIDA.value=frmMaintPayScale.screenMode.value;
    } */

 document.all.screenModePay1.value = document.all.screenModePay2.value;    

if (frmMaintPayScale.screenMode.value=="U")
 {
     frmMaintPayScale.screenModePay1.value = "U";
     frmMaintPayScale.screenModePay2.value = "U";
 }
  
/* if(frmMaintPayScale.detailDataChanged.value == "true")
    {
        alert("Please save the data");
        return false;                        
    }*/
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../IDATabAction.do";
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
           var from = parseInt(document.getElementsByName("startField")[i-1].value);
           if (i>1)
           {
                var p = parseInt(document.getElementsByName("endField")[i-2].value);
                if (from != p+1)
                {
                   alert(" Start Basic Should Be One Greater Than Previous Rows End Basic ");
//                   document.getElementsByName("startField")[i-1].select(); 
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

/*            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            */
            
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
//  alert("new");
  document.all.buttonFlag.value='';
  document.all.screenModePay1.value  = "N";
  document.all.screenModePay2.value  = "N";
  document.all.screenModeIDA.value  = "N";
  document.all.screenMode.value = "N";
 // document.all.screenModePayScale.value = "N";
// alert(frmMaintPayScale.buttxtRevYYMM);
//  frmMaintPayScale.buttxtRevYYMM.disabled="disabled";
  document.all.screenModePayScale.value = "I";
  frmMaintPayScale.action="../../../PayScaleIdaNewMode.do"
  frmMaintPayScale.submit();

}

function doQueryMode()
{
  document.all.buttonFlag.value='';
  document.all.screenModePay1.value  = "Q";
  document.all.screenModePay2.value  = "Q";
  document.all.screenModeIDA.value  = "Q";
  document.all.screenMode.value = "Q";
  document.all.screenModePayScale.value = "Q";
  frmMaintPayScale.action="../../../PayScaleIdaQueryMode.do"
  frmMaintPayScale.submit();

}


function lfnLoad()
{  

  var sMode  = frmMaintPayScale.screenMode.value;
  if(sMode == "")
  {
    doQueryMode();
  }

 if (frmMaintPayScale.screenMode.value == "Q")
 {
     frmMaintPayScale.screenModeIDA.value='Q';
     frmMaintPayScale.screenModePayScale.value='Q';     
 }

    if (frmMaintPayScale.screenModePayScale.value=="N1")
      {
           if (frmMaintPayScale.screenModeIDA.value == "")
           {
              if (frmMaintPayScale.screenMode.value == "U")
              {
                  frmMaintPayScale.screenModeIDA.value = "U";
              }
              else
              {
                frmMaintPayScale.screenModeIDA.value="UG";                
              }            
            }    
            else
            {
              frmMaintPayScale.screenModeIDA.value="UG";              
            }
      }



    
    if (frmMaintPayScale.screenModePayScale.value=="N") 
    {
      if (frmMaintPayScale.screenModeIDA.value != "UG")          
       frmMaintPayScale.screenModeIDA.value="U";
    }
    else if (frmMaintPayScale.screenModePayScale.value=="U1") 
    {
      if ((frmMaintPayScale.headerClick.value != "IDA") &&  (frmMaintPayScale.screenMode.value != "Q"))
      {
       frmMaintPayScale.screenModePayScale.value="U";             
       frmMaintPayScale.screenModeIDA.value="U";
      }
    }


    
   if (frmMaintPayScale.screenModeIDA.value == "")
  {
     if (frmMaintPayScale.screenMode.value == "U")
     {
         frmMaintPayScale.screenModeIDA.value = "U";
     }
     else
     {
       frmMaintPayScale.screenModeIDA.value = "Q";
       frmMaintPayScale.screenMode.value = "Q";    
       frmMaintPayScale.screenModePayScale.value = "Q";         
      }
   }
    
  mode = frmMaintPayScale.screenModeIDA.value;
  
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

     if (frmMaintPayScale.screenMode.value == 'U')
      { 
        document.getElementById("txtRevYYMM").disabled = "true";
        document.getElementById("lstPayScale").disabled = "true";      
      }
      else
      {  
         document.getElementById("txtRevYYMM").disabled="";
        document.getElementById("lstPayScale").disabled="";
      
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
     // document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
  }  
//added by geetika on 19-11-2014
//alert('frmMaintPayScale.screenMode.value'+frmMaintPayScale.screenMode.value);
if( mode=='UG' && frmMaintPayScale.screenMode.value == 'U')
//mode=='UG' 
{   
  
 //  document.all.butInsert.disabled="disabled";
   var oTable = document.getElementById("Detail");
   if(oTable == null)
   {
        return;
   } 
   var iTr2 = oTable.rows.length;
   var i = 0;
   for(i=0; i < iTr2 -1; i++)
   {
   
     	if ((document.getElementsByName("txtStartDate")[i].value!='' || document.getElementsByName("txtEndDate")[i].value!='') && document.getElementsByName("status")[i].value!='N')
   {
			// alert( document.getElementsByName("startField")[i].value);
    // alert(document.getElementsByName("txtStartDate")[i].value);
			document.getElementsByName("checked")[i].disabled="true";
			document.getElementsByName("checked")[i].className="locked";
			document.getElementsByName("txtSrNo")[i].readOnly="true";
			document.getElementsByName("txtSrNo")[i].className="locked";
			document.getElementsByName("startField")[i].readOnly="true";
			document.getElementsByName("startField")[i].className="locked";
			document.getElementsByName("txtGradePay")[i].readOnly="true";
			document.getElementsByName("txtGradePay")[i].className="locked";
			document.getElementsByName("endField")[i].readOnly="true";
			document.getElementsByName("endField")[i].className="locked";
			document.getElementsByName("txtStartDate")[i].readOnly="true";
			document.getElementsByName("txtStartDate")[i].className="locked";
			}
			if (document.getElementsByName("txtEndDate")[i].value!='')
			{
			document.getElementsByName("txtEndDate")[i].readOnly="true";
			document.getElementsByName("txtEndDate")[i].className="locked";
			document.getElementsByName("my_image1")[i].disabled="true";
			document.getElementsByName("my_image2")[i].disabled="true";
			
		}
  }
}

  mode = frmMaintPayScale.screenMode.value;  
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

  
function ShowLovYYMM()
{
   frmMaintPayScale.lovKey.value = "MaintPayScaleIDA" + frmMaintPayScale.screenName.value + frmMaintPayScale.screenMode.value;
   frmMaintPayScale.txtDisplayFields.value = "txtRevYYMM";
      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPayScale');
   return true;
}

function ShowLovPayScale()
{
   frmMaintPayScale.lovKey.value = "MaintPayScaleCodeIDA" + frmMaintPayScale.screenName.value + frmMaintPayScale.screenMode.value;
   frmMaintPayScale.txtDisplayFields.value = "lstPayScale";
      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintPayScale');
   return true;
}



function doBasePrevDetail()
{
    frmMaintPayScale.userPageRequested.value = 1*frmMaintPayScale.pageRequested.value - 1;
    frmMaintPayScale.action = "../../../payScaleIDAPrevDetailAction.do";
    frmMaintPayScale.submit();
}


function doBaseNextDetail()
{
    frmMaintPayScale.userPageRequested.value = 1*frmMaintPayScale.pageRequested.value + 1;
    frmMaintPayScale.action = "../../../payScaleIdaNextDetailAction.do";
    frmMaintPayScale.submit();
}


function JumpHeader()
{
   document.all.buttonFlag.value='';
 // document.all.screenModeIDA.value='Q';
  frmMaintPayScale.userPositionRequested.value = 1*frmMaintPayScale.newPositionRequested.value;
  frmMaintPayScale.action = "../../../PayIdaGetNextHeader.do";
  frmMaintPayScale.submit();
}

function JumpDetail()
{
    frmMaintPayScale.userPageRequested.value = 1*frmMaintPayScale.newPageRequested.value ;
    frmMaintPayScale.action = "../../../payScaleIdaNextDetailAction.do";
    frmMaintPayScale.submit();
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
                    var tempInstAmt = parseInt(document.getElementsByName("txtGradePay")[i].value,10);
                    var tempEndBasic = parseInt(document.getElementsByName("endField")[i].value,10);
                    var srNo=parseInt(document.getElementsByName("txtSrNo")[i].value,10);
                   if(srNo==1)
                    var tempTotalAmt=tempEndBasic - tempStartBasic;
                  else
                     var tempTotalAmt=tempEndBasic - tempStartBasic + 1;
                
                    if (isNaN(tempTotalAmt))
                    {
                        document.getElementsByName("txtGradePay")[i].value= "";
                        return false;
                    }

                    if (isNaN(tempInstAmt))
                    {
                        document.getElementsByName("txtGradePay")[i].value= "";
                        return false;
                    }
                     if (tempInstAmt == 1)
                    {
                        document.getElementsByName("txtGradePay")[i].value= "";
                        return false;
                    } 

                    var x=tempTotalAmt/tempInstAmt;
                    var y=tempTotalAmt%tempInstAmt;
                   // var z=(int)(tempTotalAmt/tempInstAmt);
    //               alert(Math.floor(44.84));

          /*            var diff = x - Math.floor(x);
                      diff = Math.ceil(diff);
                   if (parseInt(diff)  > 0)
                   {
                     document.getElementsByName("txtNoInst")[i].value=parseInt(Math.floor(x)) + 1;                                             
                    }
                    else
                    {
                      document.getElementsByName("txtNoInst")[i].value=Math.floor(x);  
                     }*/

                    /*if (y != 0)
                    {
                       alert("The Difference of End Basic and Start Basic Should be a multiple of Increament Amount");
                       document.getElementsByName("endField")[i].focus(); 
                       return false;
                    }   */                          
                }
                 
            }              
        return true;
}



function doRefresh()
{
   
    frmMaintPayScale.action = "../../../PayscaleIDARefresh.do";
    frmMaintPayScale.submit();
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
function chk_PrevDt(i)
{
  if(document.getElementsByName("txtEndDate")[i-1].value!='')
    {    
	  alert(document.getElementsByName("txtStartDate")[i-1].value);
      return chkFromDt(i);
    }
      setEndDt(i);
}

function chkFromDt(i)
{
    //alert('chkFromDt');
  var fromDt=document.getElementsByName("txtStartDate")[i-1].value;
  var toDt=document.getElementsByName("txtEndDate")[i-1].value; 
  if (!cmpDate(fromDt,toDt,0))
  {
    alert("To Date cannot be less than From Date");
    document.getElementsByName("txtEndDate")[i-1].value="";
    return false;                      
  }
  changed(i);

}
 function setEndDt(rInd)
 {

  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  if(iTr2 > 2){
	//	var btnFlg = document.getElementById("addBtnFlag").value;
		var temp = <%=j%>;
		var temp1 = <%=i%>;  
		//alert(temp+"=="+temp1)
		var frmDt = document.getElementsByName("txtStartDate")[rInd-1].value;
		if(temp < temp1) rInd = <%=j%>;
		var prvToDt = document.getElementsByName("txtEndDate")[rInd-2].value;
		if (prvToDt == frmDt) {
			alert("Current Effective From Must Be Greater Than Previous Effective To .");
			document.getElementsByName("txtStartDate")[temp1-1].value = "";
			return false;
		} else {
			if (!cmpDate(prvToDt,frmDt,0)){
				alert("Current Effective From Must Be Greater Than Previous Effective To .");
				document.getElementsByName("txtFrom")[temp1-1].value = "";
				return false;
			}
		}
  }
  else  return ;
}
 function checkRecord1()
  {
	 
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
      var fl = 0;
      for(i=0; i < iTr2 - 1; i++)
      {
       
        if(document.getElementsByName("checked")[i].checked)
        {  
            document.all.butDelete.disabled="true";
            return true;
        }
      }
      if(fl == 0)   
      {     
          document.all.butDelete.disabled="true";
          return false;
      }
  } 
</script>

