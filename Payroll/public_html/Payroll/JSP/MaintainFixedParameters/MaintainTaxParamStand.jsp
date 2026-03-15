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
    <!-- <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>  -->
      
   
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0; %>
<% i = 0; j=0; %>

  <html:form  action="MaintainStdTaxParam" name="frmTaxStdParam" type="FCIPAY.Payroll.WEBTIER.Form.StdTaxParamForm" scope="session">
   <bean:define id="ParentForm" name="frmTaxStdParam" toScope="request" />
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
  <html:errors/>
      <html:hidden property="detailDataChanged" />
      <html:hidden property="headerFields" value="false" />
      <html:hidden property="screenTypeStd" name="frmTaxStdParam" />
      <html:hidden property="screenModeStd" name="frmTaxStdParam" />
      <html:hidden property="screenModeStd1" name="frmTaxStdParam" />
      <html:hidden property="lovKey" name="frmTaxStdParam"  />
      <html:hidden property="txtFields" name="frmTaxStdParam"  />   
      <html:hidden property="txtSearchFields" name="frmTaxStdParam"  />
      <html:hidden property="txtDisplayFields" name="frmTaxStdParam"  />
      <html:hidden property="txtIndex" name="frmTaxStdParam"  />


<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN INCOME TAX RATES</TD>
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
              <TR>
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("incTax")>Income Tax Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>Standard Deduction Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("profTax")>Professional Tax Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("othDet")>Other Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
         <tr height="20" >
            <td colspan="14"></td>
         </tr>
          <tr>
            <td colspan="9" class="labelText"  width="50%"><bean:message key="Pay.TaxParam.yymm" /></td>
            <td colspan="5" width="50%">
<!--            <html:select property="txtStdDednYYMM" styleClass="required">
                   <html:option value="--Please Select--" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                   </html:select>  -->
                  <html:text  property="txtStdDednYYMM" maxlength="10" size="23" styleClass="required" onchange="chk_YearMonth(this);" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtYYMM"  onclick="ShowLovYYMM();">                                     
            </td>
          </tr>
         <tr height="20" >
            <td colspan="14"></td>
         </tr>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="14">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:280px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail">
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll')"  /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Pay.Stand.AmtFrom" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Pay.Stand.AmtTo" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Pay.Stand.MaleAmt" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Pay.Stand.FemAmt" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Pay.Stand.Income" /></TD>
                            </TR>


                   <logic:iterate id="stdincomeTax" name="frmTaxStdParam" property="lstStdDedn" type="FCIPAY.Payroll.UTILITY.StdDednBean" >
                           <% ++i; %>

                          <logic:notEqual name="stdincomeTax" property="status" value="D" >                              
                           <tr>
                           <% ++j; %>                                                                           
                              <td align="center" ><html:checkbox property="checked" name="frmTaxStdParam" /></td> 
                                                           
                              <td  width="5%" ><html:text property="startField" name="stdincomeTax" readonly="true" style="width:100% ; text-align=right" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>
                              <td  width="5%" ><html:text property="endField" name="stdincomeTax" style="width:100% ; text-align=right" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="
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
                              <td  width="5%" ><html:text property="txtStdMaleAmt" name="stdincomeTax" style="width:100% ; text-align=right" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="
                              if (!num_Check(this.value,1))
                              {
                                this.focus();
                                return false;
                              }                                      
                              if(!(chk_ToAmount(this.value, this.alt)))
                              {
                              }
                              else
                              {
                                return changed(this.alt);
                              }                                                                             
                              "  /></td>
                              <td  width="5%" ><html:text property="txtStdFemaleAmt" name="stdincomeTax" style="width:100% ; text-align=right" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="
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
                              <td  width="5%" ><html:text property="txtStdIncPer" name="stdincomeTax" style="width:100% ; text-align=right" maxlength="2" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="
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
                              <html:hidden property="hdnStdDednSrlNo" name="stdincomeTax" />                                                                                                                                  
                              <html:hidden property="status" name="stdincomeTax"/>
                              <html:hidden property="itemChecked" name="stdincomeTax" />
                              <html:hidden property="detailId" name="incomeTax" value="Default"/>                              
                          </tr>      
                          </logic:notEqual>


                          <logic:equal name="stdincomeTax" property="status" value="D" >                              
                           <tr>                                               
                              <td  width="1%" ><html:hidden property="checked" name="frmTaxStdParam" value="notchecked"  /></td>
                              <td  width="5%" ><html:hidden property="startField" name="stdincomeTax" /></td>
                              <td  width="5%" ><html:hidden property="endField" name="stdincomeTax" /></td>
                              <td  width="5%" ><html:hidden property="txtStdMaleAmt" name="stdincomeTax"  /></td>
                              <td  width="5%" ><html:hidden property="txtStdFemaleAmt" name="stdincomeTax" /></td>
                              <td  width="5%" ><html:hidden property="txtStdIncPer" name="stdincomeTax"/></td>
                              <html:hidden property="hdnStdDednSrlNo" name="stdincomeTax" />                                                                                                                                  
                              <html:hidden property="status" name="stdincomeTax"/>
                              <html:hidden property="itemChecked" name="stdincomeTax" />
                              <html:hidden property="detailId" name="incomeTax" value="Default"/>
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

<!-- Container Table Ends -->
<!-- These four hidden fields must be present in pages where there is a detail part -->
<html:hidden name="frmTaxStdParam"  property="screenName" value="IncomeTaxStdScreen" />
<html:hidden name="frmTaxStdParam"  property="forwardedPage" />
<html:hidden property="headerPrimaryKey" name="frmTaxStdParam"  />
<html:hidden property="totalDetailRecord" name="frmTaxStdParam"  />
<html:hidden property="screenMode" name="frmTaxStdParam" value="U" />
<html:hidden property="positionRequested" name="frmTaxStdParam" />
<html:hidden property="userPositionRequested" name="frmTaxStdParam" />
<html:hidden property="pageRequested" name="frmTaxStdParam" />
<html:hidden property="userPageRequested" name="frmTaxStdParam" />
<html:hidden property="buttonFlag" name="frmTaxStdParam"  />


<!-- Hidden fields end -->


</html:form>
</body>
</html:html>

 
<script language="javascript">
var formMode="A";
var oElemName=new Object();
var sSaveFlag=1;

var chkMes= 0;

function menuHandling(mode)
{
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


  function GetDetail()
  {
    frmTaxStdParam.screenTypeStd.value= "UG";      
    frmTaxStdParam.headerPrimaryKey.value = frmTaxStdParam.txtStdDednYYMM.value ;
    document.all.buttonFlag.value='';
    frmTaxStdParam.action="../../../stdDednFirstGetDetailAction.do"
    frmTaxStdParam.submit();
  }


function doInsertMode()
{
  frmTaxStdParam.screenTypeStd.value= "N";
  frmTaxStdParam.screenModeStd.value= "N";  
  frmTaxStdParam.screenModeStd1.value= "N";  
  document.all.buttonFlag.value='';
  frmTaxStdParam.action="../../../TaxParamStdDednNewMode.do"
  frmTaxStdParam.submit();
  
}

function doQueryMode()
{
  frmTaxStdParam.screenTypeStd.value= "Q";
  document.all.buttonFlag.value='';
  frmTaxStdParam.action="../../../TaxParamStdDednQueryMode.do"
  frmTaxStdParam.submit();
}

 function doGetNextHeader()
    {      
      document.all.screenTypeStd.value  = "UNG";
      document.all.buttonFlag.value='';
      document.forms[0].userPositionRequested.value = 1*frmTaxStdParam.positionRequested.value + 1;      
      document.forms[0].action="../../../getTaxStdNextHeaderInfo.do";
      document.forms[0].submit();
    }

 function PrevHeader()
    {
      document.all.screenTypeStd.value  = "UNG";    
      document.all.buttonFlag.value='';
      document.forms[0].userPositionRequested.value = frmTaxStdParam.positionRequested.value - 1;
      document.forms[0].action = "../../../getTaxStdNextHeaderInfo.do";
      document.forms[0].submit();
    }


function getHeaderRecord()
{
	frmTaxStdParam.screenTypeStd.value= "UNG";
	frmTaxStdParam.screenModeStd.value= "U";   
	document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmTaxStdParam.action="../../../taxParamStandFirstGetHeaderAction.do";
	frmTaxStdParam.submit();
}

   function changed(val)
  {
 
    frmTaxStdParam.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
       document.getElementsByName("status")[val-1].value = 'U';
  }


function lfnLoad()
{
 mode1 = document.all.screenMode.value;
 mode = document.all.screenTypeStd.value;
  
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

  if(mode=='N')
  {
     document.all.buttxtYYMM.disabled="disabled";   
     document.all.butGetDetail.disabled="true";
     document.all.butInsert.disabled="";
     document.all.butDelete.disabled="";      
  }

    if(mode=='UG')
  {
     document.all.buttxtYYMM.disabled="disabled"; 
     document.all.butGetDetail.disabled="true";
     document.all.butInsert.disabled="";
     document.all.butDelete.disabled=""; 
     document.all.txtStdDednYYMM.disabled = "disabled";     
  }

  if(mode=='UNG')
  {
      document.all.buttxtYYMM.disabled="disabled";
      document.all.txtStdDednYYMM.disabled="disabled";
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
    menuHandling(mode);
  }
}
  

function SaveRecord()
{
 if(!mandatory_Check("frmTaxStdParam"))
        return false;      

  if(!AmtCheck())
      return false;

  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }

  var iTr2 = oTable.rows.length;  
  frmTaxStdParam.screenModeStd.value  = frmTaxStdParam.screenModeStd1.value; 
  frmTaxStdParam.headerPrimaryKey.value = frmTaxStdParam.txtStdDednYYMM.value;  
  frmTaxStdParam.totalDetailRecord.value = parseInt(iTr2,10) - 1;    
  document.all.buttonFlag.value='';
  frmTaxStdParam.headerFields.value = "true";
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmTaxStdParam.action = "../../../stdDednSaveAction.do";
  frmTaxStdParam.submit();
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


function chk_YearMonth(that)
{
       var yearM = that.value;
       var month =  yearM.substring(4,6);
      
    if (num_Check(yearM,1))
     {                                   
        if (yearM.length != 6)
        {
        alert(" Year Month should be a Six digit Number");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

      else if(month != 4 )
       {
           alert("  Month should be April ( 04 )");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
          return false;
       }
       else
       {          
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




function doBaseAddRow()
{
  if(!mandatory_Check("frmTaxStdParam"))
  return false;

  frmTaxStdParam.screenMode.value = "U";
  document.all.buttonFlag.value='D';
  document.forms[0].action = "../../../StdTaxAddRowAction.do";
  document.forms[0].submit();
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
  
 
  var strRecList='';
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("hdnStdDednSrlNo")[i].value=="" )
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
        document.all.detailDataChanged.value="true";
        document.all.buttonFlag='D';
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
  
  document.forms[0].action = "../../../StdTaxDeleteRowAction.do";
  document.forms[0].submit();  
}
  
    function doGetTab(arg)
    {
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value=arg;   
    document.forms[0].action="../../../taxParamStanTabAction.do";
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


    function ShowLovYYMM()
    {
       frmTaxStdParam.lovKey.value = "MaintStdDedn" + frmTaxStdParam.screenName.value + "Q";
       frmTaxStdParam.txtDisplayFields.value = "txtStdDednYYMM";
       frmTaxStdParam.txtSearchFields.value = "Pay.TaxParam.yymm";
       frmTaxStdParam.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmTaxStdParam');
       return true;
    }   

 function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmTaxStdParam.userPositionRequested.value = 1*frmTaxStdParam.newPositionRequested.value;
  frmTaxStdParam.action = "../../../getTaxStdNextHeaderInfo.do";
  frmTaxStdParam.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmTaxStdParam.userPageRequested.value = 1*frmTaxStdParam.newPageRequested.value ;
    frmProfTax.action = "../../../getTaxStdNextDetailInfo.do";
    frmProfTax.submit();
}    

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmTaxStdParam.userPageRequested.value = 1*frmTaxStdParam.pageRequested.value - 1;
    frmTaxStdParam.action = "../../../TaxStdPrevDetailAction.do";
    frmTaxStdParam.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmTaxStdParam.userPageRequested.value = 1*frmTaxStdParam.pageRequested.value + 1;
    frmTaxStdParam.action = "../../../TaxStdNextDetailAction.do";
    frmTaxStdParam.submit();
}   

  function doRefresh()
  {
    frmTaxStdParam.action="../../../TaxParamStdRefresh.do"
    frmTaxStdParam.submit();
  }

</script>
