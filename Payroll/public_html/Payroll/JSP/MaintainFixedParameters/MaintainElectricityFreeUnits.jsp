ad<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
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
<BODY onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0; %>
<% i = 0; j=0; %>
<html:form  action="MaintainElecFreeUnits" name="frmMaintElecFreeUnits" type="FCIPAY.Payroll.WEBTIER.Form.ElecFreeUnitsForm" scope="session">
<bean:define id="ParentForm" name="frmMaintElecFreeUnits" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="screenTypeElecFreeUnits" name="frmMaintElecFreeUnits" />
<html:hidden property="screenModeElecFreeUnits" name="frmMaintElecFreeUnits" />
<html:hidden property="screenModeElecFreeUnits1" name="frmMaintElecFreeUnits" />
<html:hidden property="screenType" name="frmMaintElecFreeUnits" />
<html:hidden property="lovKey" name="frmMaintElecFreeUnits"  />
<html:hidden property="txtFields" name="frmMaintElecFreeUnits"  />   
<html:hidden property="txtSearchFields" name="frmMaintElecFreeUnits"  />
<html:hidden property="txtDisplayFields" name="frmMaintElecFreeUnits"  />
<html:hidden property="txtIndex" name="frmMaintElecFreeUnits"  />
<html:hidden property="totalDetailRecord" name="frmMaintElecFreeUnits"  />
<html:hidden property="buttonFlag" name="frmMaintElecFreeUnits"  />

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN ELECTRICITY FREE UNITS</TD>
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
          <TD class=subHeader colspan=6></TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="20" >
            <td colspan="2"></td>
         </tr>
        <tr>
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
           
         <tr height="20" >
            <td colspan="14"></td>
         </tr>

        <tr>

            <td class="labelText"  width="15%" ><bean:message key="Pay.ElecFreeUnits.yymm" /></td>
            <td>
           <html:hidden  property="txtRevYYMM" styleClass="optional" onchange="chk_YearMonth(this);" />       
          <html:text  property="txtRevYear" altKey="pay.MaintPayScaleIDA.txtRevYYMM" maxlength="10" size="23" styleClass="required"  onchange="                                                  
                       if(!(chk_YearMonth()))
                          {
                          }                                    
                     " /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtYYMM" onclick="ShowLovRevYYMM();">  
            </td>
   

            <td class=labelText width="20%" ><bean:message key="Pay.ElecFreeUnits.gradecode" /></td>
            <td>
            <html:text  property="txtGradeCode" maxlength="10" size="16"  styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtAcctCodeType" onclick="ShowLovGradeCode();" >&nbsp;&nbsp;<html:text  property="txtGradeDesc"  maxlength="10" size="26" styleClass="locked" readonly="true"/>            
            </td>
                   
  
        </tr>

         
         <tr height="20" >
            <td colspan="14"></td>
         </tr>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="14">
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > Electricity Free Unit Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>              
              </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="8">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail" >
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Pay.ElecFreeUnits.AmtFrom" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Pay.ElecFreeUnits.AmtTo" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Pay.ElecFreeUnits.ElecFreeUnits" /></TD>
                            </TR>

                    <logic:iterate id="payElecFreeUnitsInfo" name="frmMaintElecFreeUnits" property="lstElecFreeUnits" type="FCIPAY.Payroll.UTILITY.ElecFreeUnitsBean" >
                           <% ++i; %>

                          <logic:notEqual name="payElecFreeUnitsInfo" property="status" value="D" >                              
                           <tr>
                           <% ++j; %>                                                                           
                              <td align="center" ><html:checkbox property="checked" name="frmMaintElecFreeUnits" onclick="checkRecord();"  /></td> 
                                                           
                              <td  width="5%" ><html:text property="startField" readonly="true" name="payElecFreeUnitsInfo" style="width:100% ; text-align=right" styleClass="required" alt="<%=String.valueOf(i) %>" onchange=
                              "
                                if(!(chk_FromAmount(this.value, this.alt)))
                                {
                                }
                                else
                                {
                                  return changed(this.alt);
                                }                                                                                                                    

                              " /></td>
                              <td  width="5%" ><html:text property="endField" name="payElecFreeUnitsInfo" style="width:100% ; text-align=right" styleClass="required" alt="<%=String.valueOf(i) %>" onchange=
                              "
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
                              <td  width="5%" ><html:text property="txtElecFreeUnits" name="payElecFreeUnitsInfo" style="width:100% ; text-align=right" styleClass="required" alt="<%=String.valueOf(i) %>" onchange="
                                if (!num_Check(this.value,1))
                                {
                                  this.focus();
                                  return false;
                                }              
                                else
                                {
                                  return changed(this.alt);
                                }                                                                                                                                                    
                              "  /></td>
                              <html:hidden property="status" name="payElecFreeUnitsInfo"/>
                              <html:hidden property="itemChecked" name="payElecFreeUnitsInfo" />
                              <html:hidden property="detailId" name="payElecFreeUnitsInfo" value="Default"/>                              
                              <html:hidden property="hdnElecFreeUnitsSrlNo" name="payElecFreeUnitsInfo" />                                                                                                                                                                
                          </tr>      
                          </logic:notEqual>


                          <logic:equal name="payElecFreeUnitsInfo" property="status" value="D" >                              
                           <tr>                                               
                              <td  width="1%" ><html:hidden property="checked" name="frmMaintElecFreeUnits" value="notchecked"  /></td>
                              <td  width="5%" ><html:hidden property="startField" name="payElecFreeUnitsInfo" /></td>
                              <td  width="5%" ><html:hidden property="endField" name="payElecFreeUnitsInfo" /></td>
                              <td  width="5%" ><html:hidden property="txtElecFreeUnits" name="payElecFreeUnitsInfo"  /></td>
                              <html:hidden property="hdnElecFreeUnitsSrlNo" name="payElecFreeUnitsInfo" />                                                                                                                                                                                              
                             <html:hidden property="status" name="payElecFreeUnitsInfo"/>
                              <html:hidden property="itemChecked" name="payElecFreeUnitsInfo" />
                              <html:hidden property="detailId" name="payElecFreeUnitsInfo" value="Default"/>
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
		          <td colspan=14>	
                    <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />                </TD>
              
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
               <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />

               <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
                <% if(smode.equals(new String("U"))) {%> 
                Update Mode
               <%} else if(smode.equals(new String("N"))) {  %>
                New Mode
               <%} else if(smode.equals(new String("Q"))) {  %>
                Query Mode
               <%}  %>
               </td> 
               <td align=center bgcolor=#4682b4 width="20%"></td>
               <td  bgcolor=#4682b4> </td>
               <td bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
</TBODY>
</TABLE>

<!-- Container Table En\ds -->
<!-- These four hidden fields must be present in pages where there is a detail part -->
<html:hidden name="frmMaintElecFreeUnits"  property="screenName" value="ElecFreeUnitScreen" />
<html:hidden name="frmMaintElecFreeUnits"  property="forwardedPage" />
<html:hidden property="headerPrimaryKey" name="frmMaintElecFreeUnits" value="Default" />
<html:hidden property="screenMode" name="frmMaintElecFreeUnits" />
<html:hidden property="positionRequested" name="frmMaintElecFreeUnits" />
<html:hidden property="pageRequested" name="frmMaintElecFreeUnits" />
<html:hidden property="userPageRequested" name="frmMaintElecFreeUnits" />
<html:hidden property="userPositionRequested" name="frmMaintElecFreeUnits" />

<!-- Hidden fields end -->


</html:form>
</body>
</html:html>

 <script language="javascript">
var formMode="A";
var oElemName=new Object();
var sSaveFlag=1;

var chkMes = 0;

function menuHandling(mode)
{
  //alert("in menu ");
  if(document.all.buttonFlag.value!='D')    
    document.all.buttonFlag.value='ND';  
  if(mode=='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
/*      document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";    
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";     */
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
  if(mode=='N')
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
  }
  if(mode=='U')
  {
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";        
  }
  if(document.all.buttonFlag.value=='D')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  
  }
}


function lfnLoad()
{
 mode1 = document.all.screenMode.value;
 mode = document.all.screenTypeElecFreeUnits.value;
 //alert(mode);
 //alert(mode1); 
 
 if(mode == '')
  {
      doQueryMode();
  }

  if(mode=='' || mode == 'Q')
   {
     document.all.butGetDetail.disabled="disabled";   
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
   }
   if(mode == 'U')
   {
    
    document.all.txtGradeCode.disabled="disabled";  
    document.all.txtRevYear.disabled="disabled";      
   
    document.all.txtGradeDesc.disabled="disabled";          
    
   }
  
  if(mode=='N')
  {
     document.all.buttxtYYMM.disabled="disabled";
//     document.all.buttxtAcctCodeType.disabled="disabled";     
     document.all.butGetDetail.disabled="true";
     document.all.butInsert.disabled="";
     document.all.butDelete.disabled="";      
  }

    if(mode=='UG')
  {
     document.all.butGetDetail.disabled="true";
     document.all.butInsert.disabled="";
     document.all.butDelete.disabled=""; 
     document.all.txtRevYYMM.disabled="disabled"; 
     document.all.txtRevYear.disabled="disabled"; 
     document.all.txtGradeCode.disabled="disabled"; 
     document.all.txtGradeDesc.disabled="disabled"; 
     
  }

  if(mode=='UNG')
  {   

      document.all.buttxtYYMM.disabled="disabled";
<!--      document.all.buttxtAcctCodeType.disabled="disabled";     -->
      document.all.txtGradeCode.disabled="disabled";
      document.all.txtGradeDesc.disabled="disabled";       
      document.all.txtRevYYMM.disabled="disabled";
      document.all.txtRevYear.disabled="disabled";      
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";


      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
  }
  if(mode=='UNG' || mode=='UG')
  {
    menuHandling('U');
  }
  else
  { 
    //alert("mode= " + mode);
    menuHandling(mode);
  }

}


  function getHeaderRecord()
  {
    document.all.buttonFlag.value='';
    frmMaintElecFreeUnits.screenTypeElecFreeUnits.value= "UNG";    
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmMaintElecFreeUnits.action="../../../ElecFreeUnitsFirstGetHeaderAction.do";
    frmMaintElecFreeUnits.submit();
  }

  function GetDetail()
  {
    document.all.buttonFlag.value='';
    frmMaintElecFreeUnits.screenTypeElecFreeUnits.value= "UG";      
//    frmMaintElecFreeUnits.headerPrimaryKey.value = frmMaintElecFreeUnits.txtGradeCode.value ;  
    frmMaintElecFreeUnits.headerPrimaryKey.value = frmMaintElecFreeUnits.txtRevYear.value + frmMaintElecFreeUnits.txtGradeCode.value;  
    document.all.txtGradeCode.disabled="disabled";     
    document.all.txtGradeDesc.disabled="disabled";          
    document.all.txtRevYear.disabled="disabled";         
    
    frmMaintElecFreeUnits.action="../../../ElecFreeUnitsFirstGetDetailAction.do"
    frmMaintElecFreeUnits.submit();
  }


  


function doInsertMode()
{
  document.all.buttonFlag.value='';
  frmMaintElecFreeUnits.screenTypeElecFreeUnits.value= "N";
  frmMaintElecFreeUnits.screenModeElecFreeUnits.value= "N";  
  frmMaintElecFreeUnits.screenModeElecFreeUnits1.value= "N"; 
  
  frmMaintElecFreeUnits.action="../../../ElecFreeUnitsNewMode.do"
  frmMaintElecFreeUnits.submit();
}

function doQueryMode()
{ 
  document.all.buttonFlag.value='';
  frmMaintElecFreeUnits.screenTypeElecFreeUnits.value= "Q";
  frmMaintElecFreeUnits.screenMode.value= "Q";  
  frmMaintElecFreeUnits.action="../../../ElecFreeUnitsQueryMode.do"
  frmMaintElecFreeUnits.submit();
}

 function doGetNextHeader()
    {   
      document.all.buttonFlag.value='';
      document.all.screenTypeElecFreeUnits.value  = "UNG";
      document.forms[0].userPositionRequested.value = 1*frmMaintElecFreeUnits.positionRequested.value + 1;      
      document.forms[0].action="../../../getElecFreeUnitsNextHeaderInfo.do";
      document.forms[0].submit();
    }

 function PrevHeader()
    {
      document.all.buttonFlag.value='';
      document.all.screenTypeElecFreeUnits.value  = "UNG";    
      document.forms[0].userPositionRequested.value = frmMaintElecFreeUnits.positionRequested.value - 1;
      document.forms[0].action = "../../../getElecFreeUnitsNextHeaderInfo.do";
      document.forms[0].submit();
    }

  
function doBaseAddRow()
{


  if(!mandatory_Check("frmMaintElecFreeUnits"))
  return false;

//  frmMaintElecFreeUnits.screenMode.value = "U";

  document.all.buttonFlag.value='D';

    frmMaintElecFreeUnits.detailDataChanged.value = "false";      
    document.all.txtGradeCode.disabled="";  
   
    document.all.txtGradeDesc.disabled="";          
  
  document.forms[0].action = "../../../ElecFreeUnitsAddRowAction.do";
  document.forms[0].submit();
}

function SaveRecord()
{
 if(!mandatory_Check("frmMaintElecFreeUnits"))
        return false; 

  if(!AmtCheck())
      return false;

  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }

  document.all.txtGradeCode.disabled="";            
  document.all.txtRevYear.disabled="";              

  var iTr2 = oTable.rows.length;  
  frmMaintElecFreeUnits.screenModeElecFreeUnits.value  = frmMaintElecFreeUnits.screenModeElecFreeUnits1.value; 
  frmMaintElecFreeUnits.totalDetailRecord.value = parseInt(iTr2,10) - 1;    
  document.all.buttonFlag.value='';
  frmMaintElecFreeUnits.headerFields.value = "true";
  frmMaintElecFreeUnits.headerPrimaryKey.value = frmMaintElecFreeUnits.txtRevYear.value + frmMaintElecFreeUnits.txtGradeCode.value;
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintElecFreeUnits.action = "../../../ElecFreeUnitsSaveAction.do";
  frmMaintElecFreeUnits.submit();
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


/*function AmtCheck()
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

                 if (i>0)
                 {
                      var p = parseInt(document.getElementsByName("endField")[i-1].value);
                      if (m != p+1)
                      {
                         alert("Amount From Should Be One Greater Than Previous Rows Amount To");
                         document.getElementsByName("startField")[i].focus(); 
                         return false;                      
                      }                 
                 }                                 
            }             
        return true;
}*/

   function changed(val)
  {
    //alert("changed");
    frmMaintElecFreeUnits.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
       document.getElementsByName("status")[val-1].value = 'U';
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
    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintElecFreeUnits.detailDataChanged.value = "true";
      document.all.buttonFlag.value='D';
    }
  }
  document.forms[0].action = "../../../ElecFreeUnitsDeleteRowAction.do";
  document.forms[0].submit();
}

     function doGetTab(arg)
    {
    document.all.forwardedPage.value=arg;
    //document.all.buttonFlag.value='';    
    document.forms[0].action="../../../ElecFreeUnitsTabAction.do";
    document.forms[0].submit();
    } 


    
    function ShowLovGradeCode()
    {
       frmMaintElecFreeUnits.lovKey.value = "MaintElecFreeUnits" + frmMaintElecFreeUnits.screenName.value + frmMaintElecFreeUnits.screenMode.value;
       frmMaintElecFreeUnits.txtDisplayFields.value = "txtGradeCode,txtGradeDesc";
       frmMaintElecFreeUnits.txtSearchFields.value = "";
       frmMaintElecFreeUnits.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintElecFreeUnits');
       return true;
    }

    function ShowLovRevYYMM()
    {
       frmMaintElecFreeUnits.lovKey.value = "MaintElecFreeUnitsYYMM" + frmMaintElecFreeUnits.screenName.value + "Q";
       frmMaintElecFreeUnits.txtDisplayFields.value = "txtRevYear";
       frmMaintElecFreeUnits.txtSearchFields.value = "";
       frmMaintElecFreeUnits.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintElecFreeUnits');
       return true;
    }
    
 function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmMaintElecFreeUnits.userPositionRequested.value = 1*frmMaintElecFreeUnits.newPositionRequested.value;
  frmMaintElecFreeUnits.action = "../../../getElecFreeUnitsNextHeaderInfo.do";
  frmMaintElecFreeUnits.submit();
}
function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmMaintElecFreeUnits.userPageRequested.value = 1*frmMaintElecFreeUnits.newPageRequested.value ;
    frmMaintElecFreeUnits.action = "../../../getElecFreeUnitsNextDetailInfo.do";
    frmMaintElecFreeUnits.submit();
}    

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmMaintElecFreeUnits.userPageRequested.value = 1*frmMaintElecFreeUnits.pageRequested.value - 1;
    frmMaintElecFreeUnits.action = "../../../ElecFreeUnitsPrevDetailAction.do";
    frmMaintElecFreeUnits.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmMaintElecFreeUnits.userPageRequested.value = 1*frmMaintElecFreeUnits.pageRequested.value + 1;
    frmMaintElecFreeUnits.action = "../../../ElecFreeUnitsNextDetailAction.do";
    frmMaintElecFreeUnits.submit();
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
                   alert(" Amount From Should Be One Greater Than Previous Rows Amount To ");
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
            alert("Amount To Should be greater than Amount From");
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
             alert("Amount To Should be greater than Amount From");
            document.getElementsByName("endField")[i-1].focus();             
            return false;                        
          }
          else
          return true;
   }

   

function chk_YearMonth()
{

       var  yearM = document.getElementById("txtRevYear").value;          
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
    
    
</script>