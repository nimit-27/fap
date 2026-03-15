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
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
     

  </head>
  
  <BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
    <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

    <html:form  action="MaintMiscellaneousParam" name="frmMaintMiscellaneousParam" type="FCIPAY.Payroll.WEBTIER.Form.MaintMiscellaneousParamForm" scope="session">
      <bean:define id="ParentForm" name="frmMaintMiscellaneousParam" toScope="request" />
      <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
      <html:errors/>

      <html:hidden property="detailDataChanged" value="false" />
      <html:hidden property="headerFields" value="false" />
      <%! int i=0,j=0; %>
      <% i = 0;j=0; %>

      <table>
        <TR height=30>
          <TD  colSpan=11 class=mainHeader height=10>MAINTAIN MEDICAL HEALTH SCHEME DEDUCTION DETAILS</TD>
        </TR>
        <tr height="10"><td class=userText colspan="11"></td></tr>
      </TABLE>
      
<!--container table starts -->
      <TABLE cellSpacing=0 cellPadding=0 border=0 >
        <TBODY>
          <TR>
            <TD>

              <TABLE cellSpacing=0 cellPadding=0 >
       <!--General Information Row Starts -->
                <TR>
                  <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>
                <tr height="15" >
                  <td colspan="6"></td>
                </tr>
              </table>
    
              <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

                <TR height="200">
                  <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
                    <TABLE cellSpacing=0 cellPadding=0 >           
                      <TR>
                        <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#76A2C7" nowrap class=disTabText onclick="doGetTab('misc')" > Miscellaneous Parameters <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                        
                        <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#4682B4" nowrap class=actTabText > Medical Health Scheme Deduction <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0" ></td>
                        <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>

                        <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                        <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                      </tr>
                 <TR height=10>
                   <!-- Detail table Container starts -->
                    <TD colspan=20>
                      <TABLE cellSpacing=0 cellPadding=0 border=0>
                        <TBODY>
                          <TR>
                           <TD >
                            <DIV id=divDtlTable style="height:320px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0  id="Detail" >
                                <TBODY>
                                       <TR height="22">
                                        <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                        <td class=tableHeader width="10%">Category</td>
                                        <TD class=tableHeader width="10%">Deduction</td>
                                        <td class=tableHeader width="15%">Start Date</td>
                                      </tr> 
                                      <logic:iterate id="mhsinfo" name="frmMaintMiscellaneousParam" property="lstMHSDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlMHSDedBean" >
                                        <% ++i; %>
                                        <logic:notEqual name="mhsinfo" property="status" value="D" >
                                          <tr>
                                            <td ><html:checkbox property="checked" onclick="checkRecord();" value="false" name="frmMaintMiscellaneousParam" /></td>
                                            
                                            <logic:notEqual name="mhsinfo" property="status" value="N" >
                                            <td>
                                              <html:select property="txtCtgry" name="mhsinfo" styleClass="required" disabled="true" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="return checkDuplicacy('txtCtgry',this.alt)" >
                                                <html:option value="" >-----------Please Select-----------</html:option>      
                                                <logic:present name="MiscCombo">
                                                  <html:optionsCollection label="label" value="value" property="categList" name="MiscCombo"/>
                                                </logic:present>
                                              </html:select>
                                            </td>
                                            <td ><html:text property="txtAllow" name="mhsinfo" readonly="true"  styleClass="required" size="6" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="
                                                if (!num_Check(this.value,1))
                                                {
                                                  this.focus();
                                                  return false;
                                                }                                      
                                               else
                                                return changed(this.alt);
                                               " />
                                            </td>
                                            <td><html:text property="txtStartDt" name="mhsinfo"  styleClass="required" size="26" style="width:90%;text-align:center" readonly="true" alt="<%=String.valueOf(i)%>" onchange="
                                                   return changed(this.alt);  " />
                                                <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>"  />
                                               </td>
                                              </logic:notEqual>
                                              
                                              <logic:equal name="mhsinfo" property="status" value="N" >
                                              <td>
                                              <html:select property="txtCtgry" name="mhsinfo" styleClass="required" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="return checkDuplicacy('txtCtgry',this.alt)" >
                                                <html:option value="" >-----------Please Select-----------</html:option>      
                                                <logic:present name="MiscCombo">
                                                  <html:optionsCollection label="label" value="value" property="categList" name="MiscCombo"/>
                                                </logic:present>
                                              </html:select>
                                              </td>
                                              <td ><html:text property="txtAllow" name="mhsinfo"  styleClass="required" size="6" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="
                                                  if (!num_Check(this.value,1))
                                                  {
                                                    this.focus();
                                                    return false;
                                                  }                                      
                                                 else
                                                  return changed(this.alt);
                                                 " />
                                              </td>
                                              <td><html:text property="txtStartDt" name="mhsinfo"  styleClass="required" size="26" style="width:90%;text-align:center" readonly="true" alt="<%=String.valueOf(i)%>" onchange="
                                                     return chkFromDt(this.alt); " />
                                                    <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtStartDt',this)" />
                                              </td>
                                              </logic:equal>
                                            <html:hidden property="txtEndDt" name="mhsinfo" />
                                            <html:hidden property="itemChecked" name="mhsinfo" />                                     
                                            <html:hidden property="status" name="mhsinfo" />
                                            <html:hidden property="detailId" name="mhsinfo" />
                                          </tr>
                                        </logic:notEqual>                               
                                        <logic:equal name="mhsinfo" property="status" value="D" >
                                          <tr>
                                            <td ><html:hidden property="checked" name="frmMaintMiscellaneousParam" value="notchecked" /></td>
                                            <td ><html:hidden property="txtCtgry" name="mhsinfo" /></td>
                                            <td ><html:hidden property="txtAllow" name="mhsinfo" /></td>
                                            <td ><html:hidden property="txtStartDt" name="mhsinfo" /></td>
                                            <html:hidden property="txtEndDt" name="mhsinfo" />
                                            <html:hidden property="itemChecked" name="mhsinfo" />                                     
                                            <html:hidden property="status" name="mhsinfo" />
                                            <html:hidden property="detailId" name="mhsinfo" />
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
                              <td colspan=20>	
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

      <html:hidden name="frmMaintMiscellaneousParam"  property="screenMode"  />
      <html:hidden name="frmMaintMiscellaneousParam"  property="screenName" value="MiscMHSDedScreen" />
      <html:hidden name="frmMaintMiscellaneousParam"  property="forwardedPage" />
      <html:hidden property="totalDetailRecord" name="frmMaintMiscellaneousParam"  />
      <html:hidden property="flagMHSDedn" name="frmMaintMiscellaneousParam"  />
      <html:hidden property="buttonFlag" name="frmMaintMiscellaneousParam"  />
      <html:hidden property="headerPrimaryKey" name="frmMaintMiscellaneousParam"  />
      <html:hidden property="userPageRequested" name="frmMaintMiscellaneousParam" />
      <html:hidden property="pageRequested" name="frmMaintMiscellaneousParam" />
    </html:form>
  </body>
</html:html>

<script language="javascript">

function lfnLoad()
{
  mode = document.all.screenMode.value;
  tot = document.all.flagMHSDedn.value;
  if(mode=='')
  {
      doQueryMode();
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
  }
  else
  {
    if(tot == 'true' )
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

  if(tot=='true')
  {
      detMenuHandling('U');
  }
  else
  {
      detMenuHandling('Q');
  }
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

function changed(val)
{
    frmMaintMiscellaneousParam.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
       document.getElementsByName("status")[val-1].value = 'U';
}

function lfnChange(val,ind)
{
    if(num_Check(val,1))
    {
      frmMaintMiscellaneousParam.detailDataChanged.value = "true";
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
  if(mandatory_Check("frmMaintMiscellaneousParam"))
  {
      enable();
      document.forms[0].action = "../../../MHSAddRowAction.do";
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
  fl = 0;
  var strRecList='';
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("detailId")[i].value=='')
        document.getElementsByName("itemChecked")[i].value = "Y";
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }   

  enable();
  document.forms[0].action = "../../../MHSDeleteRowAction.do";
  document.forms[0].submit();  
}

function GetDetail()
{
  frmMaintMiscellaneousParam.headerPrimaryKey.value = "" ;
  frmMaintMiscellaneousParam.flagMHSDedn.value = "true" ;
  frmMaintMiscellaneousParam.screenMode.value = "U" ;
  frmMaintMiscellaneousParam.action="../../../MHSFirstGetDetailAction.do"
  frmMaintMiscellaneousParam.submit();
}

function doInsertMode()
{
  frmMaintMiscellaneousParam.action="../../../MHSNewMode.do"
  frmMaintMiscellaneousParam.submit();
}

function doQueryMode()
{
  frmMaintMiscellaneousParam.action="../../../MHSQueryMode.do"
  frmMaintMiscellaneousParam.submit();
}

function doRefresh()
{
  frmMaintMiscellaneousParam.action="../../../MHSRefresh.do"
  frmMaintMiscellaneousParam.submit();
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintMiscellaneousParam"))
  {
      enable();
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
            frmMaintMiscellaneousParam.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'N')
            frmMaintMiscellaneousParam.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'U')
            frmMaintMiscellaneousParam.detailDataChanged.value = "true";
      }

      frmMaintMiscellaneousParam.headerPrimaryKey.value =  "" ;
      frmMaintMiscellaneousParam.headerFields.value = "false";
      frmMaintMiscellaneousParam.totalDetailRecord.value = parseInt(iTr2)-1;
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintMiscellaneousParam.action = "../../../MHSSaveAction.do";
      frmMaintMiscellaneousParam.submit();
  }
  else
  {
    return false;
  }
}


function doBasePrevDetail()
{
    enable();
    frmMaintMiscellaneousParam.userPageRequested.value = 1*frmMaintMiscellaneousParam.pageRequested.value - 1;
    frmMaintMiscellaneousParam.action = "../../../MHSNextDetailAction.do";
    frmMaintMiscellaneousParam.submit();
}


function doBaseNextDetail()
{
    enable();
    frmMaintMiscellaneousParam.userPageRequested.value = 1*frmMaintMiscellaneousParam.pageRequested.value + 1;
    frmMaintMiscellaneousParam.action = "../../../MHSNextDetailAction.do";
    frmMaintMiscellaneousParam.submit();
}

function JumpDetail()
{
    enable();
    frmMaintMiscellaneousParam.userPageRequested.value = 1*frmMaintMiscellaneousParam.newPageRequested.value ;
    frmMaintMiscellaneousParam.action = "../../../MHSNextDetailAction.do";
    frmMaintMiscellaneousParam.submit();
}

 function doGetTab(arg)
 {
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../MHSTabAction.do";
    document.forms[0].submit();
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
        var response=confirm("There is already a record. Do You still want to continue ?");
          if(response==false)
          {
              document.getElementsByName(that)[rInd-1].value="";
              document.getElementsByName(that)[rInd-1].focus();
          }
          return;
      }
    }
  }
  return true;
}

  function setEndDt(rInd)
  {
    lengthOfTable = document.getElementById("Detail").rows.length;
    newComb = document.getElementsByName("txtCtgry")[rInd-1].value;
    selDt= document.getElementsByName("txtStartDt")[rInd-1].value;
    for(ind = lengthOfTable - 1; ind > 0; ind --)
    {
      if(ind != rInd)
      {
        oldComb = document.getElementsByName("txtCtgry")[ind-1].value;
        startDt= document.getElementsByName("txtStartDt")[ind-1].value;
        if(oldComb == newComb)
        {
          if (!cmpDate(startDt,selDt,0))
          {
            alert("Start Date must be greater than prev start date");
            document.getElementsByName("txtStartDt")[rInd-1].value="";
            return false;                      
          }else
          {               
            document.getElementsByName("txtEndDt")[ind-1].value=selDt;
            frmMaintMiscellaneousParam.detailDataChanged.value = "true";
            if (document.getElementsByName("status")[ind-1].value == 'Q')
              document.getElementsByName("status")[ind-1].value = 'U';
            return;
          }
        }
      }
    }
  }
  
  function chkFromDt(i)
{
  var fromDt=document.getElementsByName("txtStartDt")[i-1].value;
  if(!cmpSysDate(fromDt,0))
    { 
      document.getElementsByName("txtStartDt")[i-1].value="";
      return false;
    }
  setEndDt(i);
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
      for(i=0; i < iTr2-1; i++)
      {
        document.getElementsByName("txtCtgry")[i].disabled="";
      }
}
</script>