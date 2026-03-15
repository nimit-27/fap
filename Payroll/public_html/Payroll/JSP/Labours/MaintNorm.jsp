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
 
</head>

<BODY scroll=no onload="lfnLoad()" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="MaintNorm" name="frmMaintNorm" type="FCIPAY.Payroll.Labour.WEBTIER.Form.MaintNormForm" scope="session">
<bean:define id="ParentForm" name="frmMaintNorm" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="headerPrimaryKey" />
<html:hidden property="screenMode" name="frmMaintNorm" />
<html:hidden name="frmMaintNorm"  property="screenName" value="NormScreen" />
<html:hidden name="frmMaintNorm"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintNorm"  />
<html:hidden property="pageRequested" name="frmMaintNorm" />
<html:hidden property="userPageRequested" name="frmMaintNorm" />
<html:hidden property="positionRequested" name="frmMaintNorm" />
<html:hidden property="userPositionRequested" name="frmMaintNorm" />
<html:hidden property="buttonFlag" name="frmMaintNorm"  />
<html:hidden property="loginLocCode" name="frmMaintNorm"  />

<html:hidden property="lovKey" name="frmMaintNorm"  />
<html:hidden property="txtFields" name="frmMaintNorm"  />   
<html:hidden property="txtSearchFields" name="frmMaintNorm"  />
<html:hidden property="txtDisplayFields" name="frmMaintNorm"  />
<html:hidden property="txtIndex" name="frmMaintNorm"  />
<html:hidden property="headerDataChanged" name="frmMaintNorm"  />

<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN NORM DETAILS</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
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
          <TD class=subHeader colspan=4>Header For Maintain Norm Details</TD>
        </TR>
        <TR>
              <TD colspan=4 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="4"></td>
         </tr>
         
        <tr>
        
            <td class="labelText"  width="25%" >Norm Type</td>
            <td ><html:select property="txtNormTyp" styleClass="required" >
                <html:option value="" >-----------Please Select-----------</html:option>      
                        <logic:present name="NormCombo">
                          <html:optionsCollection label="label" value="value" property="normTypList" name="NormCombo"/>
                        </logic:present>
                      </html:select>
            </td>
                
                 <td class="labelText"  width="25%" >MOU</td>
                  <td><html:select property="txtMou" styleClass="required" >
                        <html:option value="" >-----------Please Select-----------</html:option>      
                        <logic:present name="NormCombo">
                          <html:optionsCollection label="label" value="value" property="mouList" name="NormCombo"/>
                        </logic:present>
                      </html:select>
                  </td>

        </tr>
                <tr>
                 <td class="labelText"  width="25%" >Effective Date</td>
                  <td align="left">
                  <html:text  property="txtEffDate" altKey="Payroll.MaintTransport.date" readonly="true" size="23" styleClass="required" />
                  <logic:equal property= "screenMode" name= "frmMaintNorm" value="N">            
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=(i-1) %>"  onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtEffDate',this)" />
                  </logic:equal>               
                  </td>        

                  <td class="labelText"  width="25%" >&nbsp;</td>
                  <td>&nbsp;
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Norm Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                <TBODY>
                                  <TR height="22">
                                      <td class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                                      <td class=tableHeader width="3%">Bag Weight</td>
                                      <td class=tableHeader width="4%">From</td>
                                      <td class=tableHeader width="6%">To</td>
                                      <td class=tableHeader width="3%">Rate</td>
                                   </tr> 
                           <logic:iterate id="siteInfo" name="frmMaintNorm" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.MaintNormBean" >
                              <% ++i; %>
                                <logic:notEqual name="siteInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                       <td align=center ><html:checkbox property="checked" value="false" name="frmMaintNorm" onclick="checkRecord();" /></td>
                                       <td ><html:select property="txtBagTyp" name="siteInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" style="WIDTH: 100%" onchange="return changed(this.alt); " >
                                             <html:option value="" >-----------Please Select-----------</html:option>      
                                             <html:option value="A">Above 66 Kg</html:option>
                                             <html:option value="B">Below 66 Kg</html:option>
                                            </html:select>
                                       </td>
                                       <td ><html:text property="startField" name="siteInfo" size="9"    styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                                                  
                                        if(!(chk_FromAmount(this.value, this.alt)))
                                        {
                                          alert(this);
                                         // this.select();
                                        //  this.focus();
                                        }
                                        else
                                        {
                                          return changed(this.alt);
                                        }                                                                                                                    
                                      " /></td>
                                       <td ><html:text property="endField" name="siteInfo" size="15" styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="
                                   if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }
                                         if(!(chk_ToAmount(this.value, this.alt)))
                                        {
                                        }else
                                       return changed(this.alt);
                                   " /></td>
                                        <td ><html:text property="txtRate" name="siteInfo"  styleClass="required" size="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>
                                       
                                        
                                       <html:hidden property="txtNormId" name="siteInfo" />
                                       <html:hidden property="itemChecked" name="siteInfo" />
                                       <html:hidden property="status" name="siteInfo" />
                                       <html:hidden property="detailId" name="siteInfo" value="Default"/>
                                    </tr>
                                  </logic:notEqual>
                                  <logic:equal name="siteInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintNorm" value="notchecked" /></td>
                                       <td ><html:hidden property="txtBagTyp" name="siteInfo" /></td>
                                       <td ><html:hidden property="startField" name="siteInfo" /></td>
                                       <td ><html:hidden property="endField" name="siteInfo" /></td>
                                       <td ><html:hidden property="txtRate" name="siteInfo" /></td>
                                       
                                       <html:hidden property="txtNormId" name="siteInfo" /> 
                                       <html:hidden property="itemChecked" name="siteInfo" />
                                       <html:hidden property="status" name="siteInfo" />
                                       <html:hidden property="detailId" name="siteInfo" value="Default"/>
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
                                  <TR>
                                    <TD><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" /></td>                                 
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


</html:form>
</body>
</html:html>

 <script language="javascript">
     
 function changed(val)
{
  frmMaintNorm.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}
   
function doBaseAddRow()
{
  if(!mandatory_Check("frmMaintNorm"))
        return false;
  else{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {      
     //   document.getElementsByName("txtSiteName")[i].disabled="";
  }
  enable();
  document.forms[0].action = "../../../NormAddRowAction.do";
  document.forms[0].submit();
  }
}

function doBaseDelRow()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  
  var strRecList='';
  var iTr2 = oTable.rows.length;
  var i = 0;
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("txtNormId")[i].value=='')
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
        frmMaintNorm.detailDataChanged.value = "true";  
      }
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }

  enable();
  document.forms[0].action = "../../../NormDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
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
        frmMaintNorm.detailDataChanged.value = "true";
  }
  document.frmMaintNorm.headerPrimaryKey.value="";
  frmMaintNorm.headerFields.value = "false";
  document.all.txtNormTyp.disabled="";
  document.all.txtMou.disabled="";
  document.all.txtEffDate.disabled="";
  enable();
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintNorm.action = "../../../NormSaveAction.do";
  frmMaintNorm.totalDetailRecord.value=parseInt(iTr2)-1;
  frmMaintNorm.submit();
}

function GetDetail()
{
  document.all.screenMode.value='U';
  document.frmMaintNorm.headerPrimaryKey.value="";
  frmMaintNorm.action="../../../NormGetDetailAction.do"
  frmMaintNorm.submit();
}

function checkDuplicacy(that,rInd)
{
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName(that)[rInd-1].value;
  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(rInd != ind)
    {
      oldComb = document.getElementsByName(that)[ind-1].value;
      if(oldComb.toUpperCase()==newComb.toUpperCase())
      {
        alert("You can\'t enter duplicate value");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
        return false;
      }
    }
  }
  return true;
}

function lfnLoad()
{
 // doQueryMode();
  mode = document.all.screenMode.value;
  if(mode=='')
  {
      doQueryMode();
   }
  
if(mode=='Q')
     {
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
     } 


  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }


  if(mode=='U')
  {
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
      
      document.all.txtNormTyp.disabled="true";
      document.all.txtMou.disabled="true";
      document.all.txtEffDate.disabled="";
      
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
            document.getElementsByName("startField")[i].disabled="true";
            document.getElementsByName("endField")[i].disabled="true";
            document.getElementsByName("txtRate")[i].disabled="true";
            document.getElementsByName("txtBagTyp")[i].disabled="true";
         }
      }
    }
    menuHandling(mode);
}
function upper(val)
{
   val.value=val.value.toUpperCase();
}
     
function doBasePrevDetail()
{
    frmMaintNorm.userPageRequested.value = 1*frmMaintNorm.pageRequested.value - 1;
    frmMaintNorm.action = "../../../NormNextDetailAction.do";
    frmMaintNorm.submit();
}

function doBaseNextDetail()
{
    frmMaintNorm.userPageRequested.value = 1*frmMaintNorm.pageRequested.value + 1;
    frmMaintNorm.action = "../../../NormNextDetailAction.do";
    frmMaintNorm.submit();
}

function JumpDetail()
{
    frmMaintNorm.userPageRequested.value = 1*frmMaintNorm.newPageRequested.value ;
    frmMaintNorm.action = "../../../NormNextDetailAction.do";
    frmMaintNorm.submit();
}

function doQueryMode()
{
     frmMaintNorm.action="../../../NormQueryMode.do"
     frmMaintNorm.submit();
}

function doInsertMode()
{
     frmMaintNorm.action="../../../NormInsertMode.do"
     frmMaintNorm.submit();
}

function getHeaderRecord()
{
     if(document.all.txtNormTyp.value=='')
     {
      alert("Please Select the Norm Type ");
      document.all.txtNormTyp.focus();
      return false;
     }
     else
     {
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintNorm.action="../../../NormHeaderAction.do"
      frmMaintNorm.submit();
     }
}

function doGetNextHeader()
{   
    document.all.buttonFlag.value='';
    frmMaintNorm.userPositionRequested.value = 1*frmMaintNorm.positionRequested.value + 1;
    document.forms[0].action="../../../NormGetNextHeader.do";
    document.forms[0].submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmMaintNorm.userPositionRequested.value = 1*frmMaintNorm.positionRequested.value - 1;
    document.forms[0].action="../../../NormGetNextHeader.do";
    document.forms[0].submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmMaintNorm.userPositionRequested.value = 1*frmMaintNorm.newPositionRequested.value;
    document.forms[0].action="../../../NormGetNextHeader.do";
    document.forms[0].submit();
}

function enable()
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
      if(document.getElementsByName("status")[i].value!='D')
      {
        document.getElementsByName("startField")[i].disabled="";
        document.getElementsByName("endField")[i].disabled="";
        document.getElementsByName("txtRate")[i].disabled="";
        document.getElementsByName("txtBagTyp")[i].disabled="";
      }
  }
 }
 
function doRefresh()
{
  frmMaintNorm.action="../../../NormRefresh.do";
  frmMaintNorm.submit();
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
      }
      else
      {
        return false;
      }
}

function chk_ToAmount(fieldval, rowval)
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

function chk_PrevAmount(i)
    {       
          var newCtgry=document.getElementsByName("txtBagTyp")[i-1].value;
          var from = parseInt(document.getElementsByName("startField")[i-1].value);
          if (i>1)
          {
              var j=i-1;
              while(j>=1)
              {
                  var ctgry=document.getElementsByName("txtBagTyp")[j-1].value;
                  if(ctgry!=newCtgry)
                  {
                   j=j-1;
                  }
                  else
                   		break;
              }
              if(j>0)
              {
                var p = parseInt(document.getElementsByName("endField")[j-1].value);
                if (from != p+1)
                {
                  alert(" Start Rate Should Be One Greater Than Previous Rows End Rate ");
                 document.getElementsByName("startField")[i-1].value=""; 
                 document.getElementsByName("startField")[i-1].focus(); 
                  return false;                      
              }
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
            alert("End Rate Should be greater than Start Rate ");
            document.getElementsByName("endField")[i-1].select();
            document.getElementsByName("endField")[i-1].focus();             
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
            alert("End Rate Should be greater than Start Rate ");
            document.getElementsByName("endField")[i-1].value="";
            document.getElementsByName("endField")[i-1].focus();            
            return false;                        
          }
          else
          return true;
   }

 </script>