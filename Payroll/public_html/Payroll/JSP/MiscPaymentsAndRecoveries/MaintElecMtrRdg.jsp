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
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
   
</head>
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />



<html:form  action="MaintElecMtrRdgBase" name="frmMaintElecMtrRdg" type="FCIPAY.Payroll.WEBTIER.Form.MaintElecMtrRdgForm" scope="session">
<bean:define id="ParentForm" name="frmMaintElecMtrRdg" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN ELECTRICITY METER READING</TD>
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
          <TD class=subHeader colspan=6>Header For Electricty Meter Reading</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>

            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintElecMtrRdg.empno" /></td>
            <td><html:text  property="txtEmpNo" altKey="" maxlength="10" size="16" styleClass="required" onchange="checkEmp(this.value);" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="return ShowEmpNum();" >&nbsp;&nbsp;<html:text  property="txtEmpName"  maxlength="10" size="26" styleClass="locked" readonly="true" /></td>

           <td class=labelText width="20%" ><bean:message key="Payroll.MaintElecMtrRdg.meterno" /></td>
                   <td colspan="1" ><html:text  property="txtMtrNo" altKey="" maxlength="10" size="16" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtMtrNo" name="butMtrNo" onclick="return ShowMtrNum();" ></td>

       <td class=labelText width="20%" ><bean:message key="Payroll.MaintElecMtrRdg.fr" /></td>
                   <td colspan="1" ><html:select property="txtFreq" alt="txtFreq" styleClass="required" >
                   <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                   <html:option value="1" > <bean:message key="Payroll.MaintElecMtrRdg.mon" /></html:option>
                   <html:option value="2" > <bean:message key="Payroll.MaintElecMtrRdg.qua" /></html:option>
                   <html:option value="3" > <bean:message key="Payroll.MaintElecMtrRdg.ha" /></html:option>
                   <html:option value="4" > <bean:message key="Payroll.MaintElecMtrRdg.yea" /></html:option>
                   </html:select></td>
  
            
            

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
                <td bgcolor="#4682B4" nowrap class=actTabText>Electricty Meter Reading Detail<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail">
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"    /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintElecMtrRdg.sr" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintElecMtrRdg.in" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintElecMtrRdg.fl" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintElecMtrRdg.inityear" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintElecMtrRdg.flyear" /></td>
                          </TR>
                       
                          <logic:iterate id="mtrRdg" name="frmMaintElecMtrRdg" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintElecMtrRdgBean" >
                              <% ++i; %>
                                <logic:notEqual name="mtrRdg" property="status" value="D" >                                                        
                          
                           <tr>  <% ++j; %>
                              <td  width="1%" align="center"><html:checkbox property="checked" onclick="checkRecord();" /></td>
                              <td  width="5%" ><html:text property="txtSrlNo" name="mtrRdg" styleClass="required"  value="<%=String.valueOf(j)%>"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  readonly="true"  onchange="lfnChange(this.value,this.alt);"  /></td>
                              <td  width="5%" ><html:text property="txtInitialReading" styleClass="required"  name="mtrRdg" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  onchange="lfnChange(this.value,this.alt);" /></td>
                              <td  width="5%" ><html:text property="txtFinalReading" styleClass="required"  name="mtrRdg" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  onchange="readingCheck(this.alt); lfnChange(this.value,this.alt);"  /></td>
                              <td  width="5%" ><html:text property="txtInitialYearMonth" name="mtrRdg" styleClass="required"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  onchange="lfnChange(this.value,this.alt);"  /></td>
                              <td  width="5%" ><html:text property="txtFinalYearMonth" name="mtrRdg" styleClass="required"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  onchange="yearmthCheck(this.alt); lfnChange(this.value,this.alt);changeDtlStartField('txtInitialYearMonth','txtFinalYearMonth',this.alt,'1');"  /></td>
                              <html:hidden property="itemChecked" name="mtrRdg" />
                              <html:hidden property="status" name="mtrRdg"/>
                              <html:hidden property="detailId" name="mtrRdg" />
                          </tr>  
                        </logic:notEqual>
                        <logic:equal name="mtrRdg" property="status" value="D" >
                           <tr>
                              <td  width="1%" ><html:hidden property="checked" value="notchecked" /></td>
                              <td  width="5%" ><html:hidden property="txtSrlNo" name="mtrRdg" /></td>
                              <td  width="5%" ><html:hidden property="txtInitialReading" name="mtrRdg"  /></td>
                              <td  width="5%" ><html:hidden property="txtFinalReading" name="mtrRdg"  /></td>
                              <td  width="5%" ><html:hidden property="txtInitialYearMonth" name="mtrRdg"  /></td>
                              <td  width="5%" ><html:hidden property="txtFinalYearMonth" name="mtrRdg"  /></td>
                              <html:hidden property="itemChecked" name="mtrRdg" />
                              <html:hidden property="status" name="mtrRdg"/>
                              <html:hidden property="detailId" name="mtrRdg" />
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
<html:hidden property="totalDetailRecord" name="frmMaintElecMtrRdg" />
<html:hidden property="headerPrimaryKey" name="frmMaintElecMtrRdg" />
<html:hidden property="screenMode" name="frmMaintElecMtrRdg" />
<html:hidden name="frmMaintElecMtrRdg"  property="screenName" value="MtrRdgScreen" />
<html:hidden name="frmMaintElecMtrRdg"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmMaintElecMtrRdg" />
<html:hidden property="userPositionRequested" name="frmMaintElecMtrRdg" />
<html:hidden property="pageRequested" name="frmMaintElecMtrRdg" />
<html:hidden property="userPageRequested" name="frmMaintElecMtrRdg" />
<html:hidden property="flag" name="frmMaintElecMtrRdg" />


<html:hidden property="lovKey" name="frmMaintElecMtrRdg"  />
<html:hidden property="txtFields" name="frmMaintElecMtrRdg"  />   
<html:hidden property="txtSearchFields" name="frmMaintElecMtrRdg"  />
<html:hidden property="txtDisplayFields" name="frmMaintElecMtrRdg"  />
<html:hidden property="txtIndex" name="frmMaintElecMtrRdg"  />
<html:hidden property="buttonFlag" name="frmMaintElecMtrRdg"  />

</html:form>
</body>
</html:html>

<script language="javascript">

function lfnLoad()
{
  mode = document.all.screenMode.value;
  if(mode == '')
  {
      doQueryMode();
  }
  flag = document.all.flag.value;
  if(mode=='U')
  {

      document.all.txtEmpNo.disabled="true";
      document.all.txtMtrNo.disabled="true";
      document.all.txtFreq.disabled="true";          
      document.all.butMtrNo.disabled="true";           
      document.all.butEmpNo.disabled="true";           
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
      document.all.txtEmpNo.disabled="";
      document.all.txtMtrNo.disabled="";
      document.all.txtFreq.disabled="";           
      document.all.butMtrNo.disabled="";           
      document.all.butEmpNo.disabled="";           
  }
  if(mode=='Q')
  {
      document.all.butGetDetail.disabled="true";
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
              var iniMonth = parseInt(document.getElementsByName("txtInitialYearMonth")[i].value);
              if(iniMonth % 100 > 12 ) 
              {
                iniMonth = (parseInt(iniMonth / 100, 10) + 1) * 100 + 1;
                document.getElementsByName("txtInitialYearMonth")[i].value = iniMonth;
              } 
              

            sta = document.getElementsByName("status")[i].value;
          
            if(sta == 'N')
            { 
                var pos = parseInt(document.all.pageRequested.value);
                  if((((i+1)*pos) == 0) || (((i+1)*pos) == 1))
                  {
                    document.getElementsByName("txtInitialYearMonth")[i].disabled = "";
                    document.getElementsByName("txtInitialReading")[i].disabled = "";
                  }
                  else
                  {
                    document.getElementsByName("txtInitialYearMonth")[i].disabled = "true";
                    document.getElementsByName("txtInitialReading")[i].disabled = "true";
                  }
              document.getElementsByName("txtFinalReading")[i].disabled = "";
              document.getElementsByName("checked")[i].disabled = "";
            }
            else
            {
              document.getElementsByName("txtInitialYearMonth")[i].disabled = "true";
              document.getElementsByName("txtInitialReading")[i].disabled = "true";
              document.getElementsByName("txtFinalReading")[i].disabled = "true";
              document.getElementsByName("checked")[i].disabled = "true";
            }
          }
  
  menuHandling(mode);
}



function doRefresh()
{
  frmMaintElecMtrRdg.action="../../../MtrRdgRefresh.do"
  frmMaintElecMtrRdg.submit();
}


function readingCheck(i)
{
     var low = parseInt(document.getElementsByName("txtInitialReading")[i-1].value);
     var high = parseInt(document.getElementsByName("txtFinalReading")[i-1].value);

    if(high < low )
    {
      alert("Final Reading Should be greater than Initial Reading")
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
      return false;                        
    }
    return true;
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
      frmMaintElecMtrRdg.detailDataChanged.value = "true";
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
  frmMaintElecMtrRdg.flag.value = "false";
  frmMaintElecMtrRdg.action="../../../MtrRdgFirstGetHeaderAction.do"
  frmMaintElecMtrRdg.submit();
}


function doGetNextHeader()
{
    document.all.buttonFlag.value='';
    frmMaintElecMtrRdg.flag.value = "false";
    frmMaintElecMtrRdg.userPositionRequested.value = 1*frmMaintElecMtrRdg.positionRequested.value + 1;
    frmMaintElecMtrRdg.action="../../../MtrRdgGetNextHeader.do";
    frmMaintElecMtrRdg.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmMaintElecMtrRdg.flag.value = "false";
  frmMaintElecMtrRdg.userPositionRequested.value = 1*frmMaintElecMtrRdg.positionRequested.value - 1;
  frmMaintElecMtrRdg.action = "../../../MtrRdgGetNextHeader.do";
  frmMaintElecMtrRdg.submit();
}


function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmMaintElecMtrRdg.flag.value = "false";
  frmMaintElecMtrRdg.userPositionRequested.value = 1*frmMaintElecMtrRdg.newPositionRequested.value;
  frmMaintElecMtrRdg.action = "../../../MtrRdgGetNextHeader.do";
  frmMaintElecMtrRdg.submit();
}


function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmMaintElecMtrRdg.userPageRequested.value = 1*frmMaintElecMtrRdg.pageRequested.value - 1;
    frmMaintElecMtrRdg.action = "../../../MtrRdgNextDetailAction.do";
    frmMaintElecMtrRdg.submit();
}

function doBaseNextDetail()
{ 
    document.all.buttonFlag.value='';
    frmMaintElecMtrRdg.userPageRequested.value = 1*frmMaintElecMtrRdg.pageRequested.value + 1;
    frmMaintElecMtrRdg.action = "../../../MtrRdgNextDetailAction.do";
    frmMaintElecMtrRdg.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmMaintElecMtrRdg.userPageRequested.value = 1*frmMaintElecMtrRdg.newPageRequested.value ;
    frmMaintElecMtrRdg.action = "../../../MtrRdgNextDetailAction.do";
    frmMaintElecMtrRdg.submit();
}


function doBaseAddRow()
{
  if(mandatory_Check("frmMaintElecMtrRdg"))
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
          document.getElementsByName("txtInitialReading")[i].disabled = "";
          document.getElementsByName("txtFinalReading")[i].disabled = "";
          document.getElementsByName("txtInitialYearMonth")[i].disabled = "";
      }

  
    document.all.buttonFlag.value='D';
    document.forms[0].action = "../../../mtrRdgAddRowAction.do";
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
      document.getElementsByName("txtInitialReading")[i].disabled = "";
      document.getElementsByName("txtFinalReading")[i].disabled = "";
      document.getElementsByName("txtInitialYearMonth")[i].disabled = "";
      document.getElementsByName("checked")[i].disabled = "";

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintElecMtrRdg.detailDataChanged.value = "true";    
      document.all.buttonFlag.value='D';  
    }

  }
   
  
  document.forms[0].action = "../../../mtrRdgDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintElecMtrRdg"))
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

          document.getElementsByName("txtInitialReading")[i].disabled = "";
          document.getElementsByName("txtFinalReading")[i].disabled = "";
          document.getElementsByName("txtInitialYearMonth")[i].disabled = "";
          document.getElementsByName("checked")[i].disabled = "";
/*                   var iniRdg = parseInt(document.getElementsByName("txtInitialReading")[i].value);
                   var fiRdg = parseInt(document.getElementsByName("txtFinalReading")[i].value);
                   var iniYM = parseInt(document.getElementsByName("txtInitialYearMonth")[i].value);
                   var fiYM = parseInt(document.getElementsByName("txtFinalYearMonth")[i].value);


                  if(iniRdg<0 || fiRdg<0 || iniYM<0 || fiYM<0 )
                  {
                      alert("Values Can't be negative");
                      return false;
                  }
                  if(fiRdg <= iniRdg )
                  {
                    alert("In "+(i+1)+"th row Final Meter Reading Should be greater than Initial Meter Reading")
                    document.getElementsByName("txtFinalReading")[i].focus();
                    return false;                        
                  }
                  if(fiYM <= iniYM )
                  {
                    alert("In "+(i+1)+"th row Final YearMonth Should be greater than Initial YearMonth")
                    document.getElementsByName("txtFinalYearMonth")[i].focus();
                    return false;                        
                  }

                   if (i>0)
                   {
                        var p = parseInt(document.getElementsByName("txtFinalReading")[i-1].value);
                        if (iniRdg != p+1)
                        {
                           alert("Initial Meter Reading Should Be One Greater Than Previous Rows Final Meter Reading");
                           document.getElementsByName("txtFinalReading")[i-1].focus(); 
                           return false;                      
                        }                 
                   }
                   if (i>0)
                   {
                        var q = parseInt(document.getElementsByName("txtFinalYearMonth")[i-1].value);
                        if (iniYM != q+1)
                        {
                           alert("Initial YearMonth Should Be One Greater Than Previous Rows Final YearMonth");
                           document.getElementsByName("txtInitialYearMonth")[i].focus(); 
                           return false;                      
                        }                 
                   }

*/
                    if (document.getElementsByName("status")[i].value == 'D')
                      frmMaintElecMtrRdg.detailDataChanged.value = "true";
                    if (document.getElementsByName("status")[i].value == 'N')
                      frmMaintElecMtrRdg.detailDataChanged.value = "true";
                    if (document.getElementsByName("status")[i].value == 'U')
                      frmMaintElecMtrRdg.detailDataChanged.value = "true";
      }

      frmMaintElecMtrRdg.headerPrimaryKey.value = "##";
    //  frmMaintElecMtrRdg.txtYYMM.value + "#" + frmMaintElecMtrRdg.lstPayScaleType.value;
      frmMaintElecMtrRdg.headerFields.value = "true";
      frmMaintElecMtrRdg.totalDetailRecord.value = parseInt(iTr2)-1; 
      
      frmMaintElecMtrRdg.buttonFlag.value='';
      frmMaintElecMtrRdg.screenMode.value='U';
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintElecMtrRdg.action = "../../../MtrRdgSaveAction.do";
      frmMaintElecMtrRdg.submit();
  }
  else
  {
    return false;
  }
}

function GetDetail()
{
  document.all.buttonFlag.value='';
  frmMaintElecMtrRdg.headerPrimaryKey.value = "##";
  frmMaintElecMtrRdg.flag.value = "true";
  //frmMaintElecMtrRdg.txtYYMM.value + "#" + frmMaintElecMtrRdg.lstPayScaleType.value;
  frmMaintElecMtrRdg.action="../../../MtrRdgFirstGetDetailAction.do"
  frmMaintElecMtrRdg.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value='';
  frmMaintElecMtrRdg.action="../../../MtrRdgNewMode.do"
  frmMaintElecMtrRdg.submit();
}


function doQueryMode()
{
  document.all.buttonFlag.value='';
  frmMaintElecMtrRdg.action="../../../MtrRdgQueryMode.do"
  frmMaintElecMtrRdg.submit();
}

function ShowEmpNum()
{
   frmMaintElecMtrRdg.lovKey.value = "MaintMtr" + frmMaintElecMtrRdg.screenName.value + frmMaintElecMtrRdg.screenMode.value;
   frmMaintElecMtrRdg.txtDisplayFields.value = "txtEmpNo,txtEmpName";
//   frmMaintElecMtrRdg.txtSearchFields.value = "Payroll.MaintElecMtrRdg.empno";
    frmMaintElecMtrRdg.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
   frmMaintElecMtrRdg.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintElecMtrRdg');
   return true;
}

function ShowMtrNum()
{
   frmMaintElecMtrRdg.lovKey.value = "MtrNum" + frmMaintElecMtrRdg.screenName.value + frmMaintElecMtrRdg.screenMode.value;
   frmMaintElecMtrRdg.txtDisplayFields.value = "txtMtrNo";
   frmMaintElecMtrRdg.txtSearchFields.value = "Payroll.MaintElecMtrRdg.meterno";
   frmMaintElecMtrRdg.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintElecMtrRdg');
   return true;
}

</script> 