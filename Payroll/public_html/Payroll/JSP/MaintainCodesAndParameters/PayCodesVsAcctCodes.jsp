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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
 
</head>
<BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="PayCodesVsAcctCodes" name="frmPayCodesVsAcctCodes"  type="FCIPAY.Payroll.WEBTIER.Form.PayCodesVsAcctCodesForm" scope="session">
<bean:define id="ParentForm" name="frmPayCodesVsAcctCodes" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="lovKey" name="frmPayCodesVsAcctCodes"  />
<html:hidden property="txtFields" name="frmPayCodesVsAcctCodes"  />   
<html:hidden property="txtSearchFields" name="frmPayCodesVsAcctCodes"  />
<html:hidden property="txtDisplayFields" name="frmPayCodesVsAcctCodes"  />
<html:hidden property="txtIndex" name="frmPayCodesVsAcctCodes"  />


<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN PAY CODES VS NATURAL ACCOUNTS</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
 <html:errors/>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
   <TR>
    <TD>
    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > PayCodes Vs NaturalAccount Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                              <TD class=tableHeader width="15%"><bean:message key="pay.PayCodesVsAcctCodesDetails.paycode" /></TD>
                                              <TD class=tableHeader width="15%"><bean:message key="pay.PayCodesVsAcctCodesDetails.desc" /></TD>
                                              <!-- Commented by Balpreet Dt 3 March 2008.
                                              <TD class=tableHeader width="10%"><bean:message key="pay.PayCodesVsAcctCodesDetails.agcode" /></td>
                                              <TD class=tableHeader width="10%"><bean:message key="pay.PayCodesVsAcctCodesDetails.drcr" /></td> 
                                              <TD class=tableHeader width="15%"><bean:message key="pay.PayCodesVsAcctCodesDetails.acctcode" /></td>-->
                                              <TD class=tableHeader width="15%"><bean:message key="pay.PayCodesVsAcctCodesDetails.ntrlAcc" /></td>
                                              <TD class=tableHeader width="15%"><bean:message key="pay.PayCodesVsAcctCodesDetails.ntrlAccDesc" /></td>
                                               </tr> 
                             <logic:iterate id="PayAcctInfo" name="frmPayCodesVsAcctCodes" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.PayCodesVsAcctCodesBean" indexId="idx" >
                              <% ++i; %>
                               <logic:notEqual name="PayAcctInfo" property="status" value="D" >  
                                   <tr>
                                       <td ><html:checkbox property="checked" onclick="checkRecord();"  value="" name="frmPayCodesVsAcctCodes" /></td>
                                    
                                      <td ><html:text property="txtPayCode" name="PayAcctInfo"  styleClass="required" readonly="true" size="20" style="width:80%" alt="<%=String.valueOf(i)%>" onchange="
                                       if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                        " />
                                        
                                       <logic:equal name="PayAcctInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>"  onclick="ShowLovPayCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="PayAcctInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" disabled onclick="ShowLovPayCode(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="PayAcctInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>"  disabled onclick="ShowLovPayCode(this.alt);" >
                                       </logic:equal>                                      
                                                                              
                                        
                                        </td> 
                                        <td ><html:text property="txtPayCodeDesc" name="PayAcctInfo"  styleClass="locked" readonly="true" size="20" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td> 
                                       <!-- Added these fields as hidden fields-->
                                        <html:hidden property="txtAgencyCode" name="PayAcctInfo" />
                                        <html:hidden property="txtDRCR" name="PayAcctInfo" />
                                        <td ><html:text property="txtAcctCode" name="PayAcctInfo"  styleClass="required" readonly="true" size="20" style="width:85%" alt="<%=String.valueOf(i)%>" onchange="
                                        if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                        " /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAcctCode" onclick="ShowLovAcctCode(this.alt);"></td> 
                                       <td ><html:text property="hdnAcctDesc" name="PayAcctInfo" styleClass="locked" readonly="true" size="20" style="width:100%" alt="<%=String.valueOf(i)%>" /></td>                                       
                                       <td ><html:hidden property="hdnAgencyName" name="PayAcctInfo" /></td>                                                                              
                                       <html:hidden property="itemChecked" name="PayAcctInfo" />
                                       <html:hidden property="status" name="PayAcctInfo" />
                                       <html:hidden property="detailId" name="PayAcctInfo" value="Default"/>
                                   
                                </tr>
                                 </logic:notEqual>                               
                                 
                                <logic:equal name="PayAcctInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmPayCodesVsAcctCodes" value="notchecked" /></td>
                                       <td ><html:hidden property="txtPayCode" name="PayAcctInfo" /></td>
                                       <td ><html:hidden property="txtPayCodeDesc" name="PayAcctInfo" /></td>
                                       <td ><html:hidden property="txtAgencyCode" name="PayAcctInfo" /></td>
                                       <td ><html:hidden property="hdnAgencyName" name="PayAcctInfo" /></td>                                       
                                       <td ><html:hidden property="txtDRCR" name="PayAcctInfo" /></td>
                                       <td ><html:hidden property="txtAcctCode" name="PayAcctInfo" /></td> 
                                       <html:hidden property="itemChecked" name="PayAcctInfo" />
                                       <td ><html:hidden property="hdnAcctDesc" name="PayAcctInfo" /></td>                                                                              
                                       <html:hidden property="status" name="PayAcctInfo" />
                                       <html:hidden property="detailId" name="PayAcctInfo" value="Default"/>
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
<html:hidden name="frmPayCodesVsAcctCodes"  property="headerPrimaryKey" value="Default" />
<html:hidden name="frmPayCodesVsAcctCodes"  property="screenMode"  />
<html:hidden name="frmPayCodesVsAcctCodes"  property="screenName" value="PayAcctCodeScreen" />
<html:hidden name="frmPayCodesVsAcctCodes"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmPayCodesVsAcctCodes"  />
<html:hidden property="buttonFlag" name="frmPayCodesVsAcctCodes"  />
<html:hidden property="userPageRequested" name="frmPayCodesVsAcctCodes" />
<html:hidden property="pageRequested" name="frmPayCodesVsAcctCodes" />


</html:form>
</body>
</html:html>

                        
                        
         


<script language="javascript">
  var chkMes =0;
  
 function changed(val)
{
  frmPayCodesVsAcctCodes.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}

function doBaseAddRow()
{
////added by sonia on 17-02-2011/////////
if(!checkPaycodes()) 
		return false;
//// end added by sonia on 17-02-2011/////////

  if(!mandatory_Check("frmPayCodesVsAcctCodes"))
  return false;
  document.all.buttonFlag.value='D';           
  frmPayCodesVsAcctCodes.screenMode.value = "U"; 
  EnableFields();
  document.forms[0].action = "../../../PayAcctAddRowAction.do";
  document.forms[0].submit();
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
      if(document.getElementsByName("txtPayCode")[i].value=="" )
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
        document.all.detailDataChanged.value="true";
      }
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
  document.forms[0].action = "../../../PayAcctDeleteRowAction.do";
  document.forms[0].submit();  
}



function GetDetail()
{
  document.all.buttonFlag.value='';  
  document.all.screenMode.value='U';
  frmPayCodesVsAcctCodes.action="../../../PayAcctFirstGetDetailAction.do"
  frmPayCodesVsAcctCodes.submit();
}


function SaveRecord()
{

////added by sonia on 17-02-2011/////////
if(!checkPaycodes()) 
		return false;
//// end added by sonia on 17-02-2011/////////
document.all.buttonFlag.value='';  
if(!mandatory_Check("frmPayCodesVsAcctCodes"))
    return false;      

/*if(!DupliCheck())
      return false;*/

/*if(!checkPayCode())
      return false;*/

  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
                 
  
  for(i=0; i < iTr2 -1; i++)
  {
        document.getElementsByName("txtPayCode")[i].disabled="";
       // document.getElementsByName("txtAgencyCode")[i].disabled="";
       // document.getElementsByName("txtDRCR")[i].disabled="";
        document.getElementsByName("txtAcctCode")[i].disabled=""   

        if (document.getElementsByName("status")[i].value == 'D')
        frmPayCodesVsAcctCodes.detailDataChanged.value = "true";
  }           

    frmPayCodesVsAcctCodes.headerFields.value = "false";
    frmPayCodesVsAcctCodes.totalDetailRecord.value = parseInt(iTr2,10) - 1;
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmPayCodesVsAcctCodes.action = "../../../PayAcctSaveAction.do";
    frmPayCodesVsAcctCodes.submit();
}


/*function DupliCheck()
{
            var oTable = document.getElementById("Detail");
            var iTr2 = oTable.rows.length;
            var flag =0;
             var i = 0;
            var j;
            j = 0;
           

             for(i=0;i<iTr2-2;i++)
            {   
       
                var PayCode1 = parseInt(document.getElementsByName("txtPayCode")[i].value);
                var AgencyCode1 = document.getElementsByName("txtAgencyCode")[i].value;
                var DRCR1= document.getElementsByName("txtDRCR")[i].value;               
                for(j=i+1;j<iTr2-1;j++)                
                {                       
                      var PayCode2 = parseInt(document.getElementsByName("txtPayCode")[j].value);
                      var AgencyCode2 = document.getElementsByName("txtAgencyCode")[j].value;
                      var DRCR2= document.getElementsByName("txtDRCR")[j].value;               
                      if((PayCode1==PayCode2)&&(AgencyCode1==AgencyCode2)&&(DRCR1==DRCR2))
                      {
                       alert("Duplication of record is not allowed"); 
                       document.getElementsByName("txtPayCode")[j].focus();
                       return false;
                      }                                               
                 }                              
             }
        return true;
}
*/
function checkPayCode()
{
             var oTable = document.getElementById("Detail");
            var iTr2 = oTable.rows.length;
            var flag =0;
            var i = 0;
         
            for(i=0;i<iTr2-1;i++)
            {   
                var tempPayCode = document.getElementsByName("txtPayCode")[i].value;
                 if ((parseInt(tempPayCode,10) < 100) ||  (parseInt(tempPayCode,10) > 999))
                {
                   alert("Pay Code should always be a 3 digit no.");            
                   document.getElementsByName("txtPayCode")[i].focus(); 
                   return false;
                }                             

                else if((parseInt(tempPayCode.substring(0,1),10) > 5) && (parseInt(tempPayCode.substring(0,1),10) < 9)) 
                {
                    alert("Pay Code should always start with 1,2,3,4,5 or 9");            
                    document.getElementsByName("txtPayCode")[i].focus(); 
                   return false;            
                }
       
                                 
            }             
 
        return true;
}
 


 
function doInsertMode()
{
//  alert("new");
  //frmPayCodesVsAcctCodes.action="../../../PayAcctNewMode.do"
//  frmPayCodesVsAcctCodes.submit();

}

function doQueryMode()
{
  
    frmPayCodesVsAcctCodes.action="../../../PayAcctQueryMode.do"
    frmPayCodesVsAcctCodes.submit();

}

function lfnLoad()
{
  mode = document.all.screenMode.value;
  if(mode=='')
   {
     doQueryMode();
     document.all.butInsert.disabled="disabled"
     document.all.butDelete.disabled="disabled"
   }

   if(mode=='Q')
   {
     document.all.butGetDetail.disabled="";
     document.all.butInsert.disabled="disabled"
     document.all.butDelete.disabled="disabled"
   }
 
  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }
  if(mode=='U')
  {
    document.all.butGetDetail.disabled="disabled";
    document.all.butInsert.disabled="";
    document.all.butDelete.disabled="";

    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
          var iTr2 = oTable.rows.length;
          var i = 0;
   }

  mode1 = frmPayCodesVsAcctCodes.screenMode.value;  
  detMenuHandling(mode1);
     
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
        document.getElementsByName("txtPayCode")[i].disabled="";
     //   document.getElementsByName("txtAgencyCode")[i].disabled="";
     //    document.getElementsByName("txtDRCR")[i].disabled="";
        document.getElementsByName("txtAcctCode")[i].disabled=""   
      
  }
 }


function ShowLovPayCode(i)
{
   frmPayCodesVsAcctCodes.lovKey.value = "PayAcctCodePayCode" + frmPayCodesVsAcctCodes.screenName.value + "N";
   frmPayCodesVsAcctCodes.txtDisplayFields.value = "txtPayCode,txtPayCodeDesc";
   frmPayCodesVsAcctCodes.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";
   frmPayCodesVsAcctCodes.txtIndex.value=i;  
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPayCodesVsAcctCodes');
   return true;
}

function ShowLovAgencyCode(i)
{
   frmPayCodesVsAcctCodes.lovKey.value = "AgencyCode" + frmPayCodesVsAcctCodes.screenName.value + "N";
   frmPayCodesVsAcctCodes.txtDisplayFields.value = "txtAgencyCode,hdnAgencyName";
   frmPayCodesVsAcctCodes.txtSearchFields.value = "pay.PayCodesVsAcctCodesDetails.agcode,Payroll.Common.desc";
   frmPayCodesVsAcctCodes.txtIndex.value=i;  
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPayCodesVsAcctCodes');
   return true;
}

function ShowLovAcctCode(i)
{
   frmPayCodesVsAcctCodes.lovKey.value = "AcctCode" + frmPayCodesVsAcctCodes.screenName.value + "N";
   frmPayCodesVsAcctCodes.txtDisplayFields.value = "txtAcctCode,hdnAcctDesc";
   frmPayCodesVsAcctCodes.txtSearchFields.value = "pay.PayCodesVsAcctCodesDetails.acctcode,pay.PayCodesVsAcctCodesDetails.desc";
   frmPayCodesVsAcctCodes.txtIndex.value=i;
  if(!(document.getElementsByName("status")[i].value == "N"))
   document.getElementsByName("status")[i].value = "U";
  // document.getElementsByName("status")[i].value = "N";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPayCodesVsAcctCodes');
   return true;
}



function doBasePrevDetail()
{
    frmPayCodesVsAcctCodes.userPageRequested.value = 1*frmPayCodesVsAcctCodes.pageRequested.value - 1;
    frmPayCodesVsAcctCodes.action = "../../../PayAcctPrevDetailAction.do";
    frmPayCodesVsAcctCodes.submit();
}


function doBaseNextDetail()
{
    frmPayCodesVsAcctCodes.userPageRequested.value = 1*frmPayCodesVsAcctCodes.pageRequested.value + 1;
    frmPayCodesVsAcctCodes.action = "../../../PayAcctNextDetailAction.do";
    frmPayCodesVsAcctCodes.submit();
}

function JumpDetail()
{
    frmPayCodesVsAcctCodes.userPageRequested.value = 1*frmPayCodesVsAcctCodes.newPageRequested.value ;
    frmPayCodesVsAcctCodes.action = "../../../PayAcctNextDetailAction.do";
    frmPayCodesVsAcctCodes.submit();
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
                 document.getElementsByName("txtPayCode")[i].disabled="";
                // document.getElementsByName("txtAgencyCode")[i].disabled="";
              //   document.getElementsByName("txtDRCR")[i].disabled="";
      }
}


function doRefresh()
{
    frmPayCodesVsAcctCodes.action = "../../../PayAcctRefresh.do";
    frmPayCodesVsAcctCodes.submit();
}
////added by sonia on 17-02-2011/////////
function checkPaycodes()
{
var flag = 0;
//alert("inside")
 var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      } 
      var iTr2 = oTable.rows.length;
      var i = 0;
      for(i=0; i < iTr2 -1; i++)
      {      
      var paycode=document.getElementsByName("txtPayCode")[i].value
      var iTr3 = oTable.rows.length;
          for(m=0; m < iTr3 -1; m++)
          {
         // alert("mode--"+document.getElementsByName("status")[m].value)
            if(document.getElementsByName("status")[m].value=='N'){
             // alert("txtPayCode--"+document.getElementsByName("txtPayCode")[m].value  +"paycode"+ paycode)
              if(document.getElementsByName("txtPayCode")[m].value==paycode)
              {
              alert("Paycode "+document.getElementsByName("txtPayCode")[m].value+"  already exists.Cannot enter duplicate paycode!!!" );
              document.getElementsByName("txtPayCode")[m].value="";
              document.getElementsByName("txtPayCodeDesc")[m].value="";
             
              document.getElementsByName("txtAcctCode")[m].value="";
              document.getElementsByName("hdnAcctDesc")[m].value="";
              
              ///alert("paycode--"+document.getElementsByName("txtPayCode")[m].value)
              flag=flag+1;
              return false;   
              }
            }
          }      
       }
        if(flag > 0){			
			//alert("flag" +flag)
			return false;
			}	
return true; 
}
//// end added by sonia on 17-02-2011/////////

</script>
