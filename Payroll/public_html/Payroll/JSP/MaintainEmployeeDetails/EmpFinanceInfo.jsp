<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.ArrayList,FCIPAY.Payroll.UTILITY.EmpFinVldnBean" %>
<html:html>
	<HEAD>
    <html:base/>
	<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />  
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>  
    <script language="JavaScript1.2" src="../INCLUDES/EmpFinanceInfo.js"></script>          
    <script language="JavaScript1.2" src="../INCLUDES/pohw.js"></script> 
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </head>
  <BODY  onload="EmpFinLoad();history.forward(1);mhsmember();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintainEmpFinDetailBase" name="frmEmpFinInfoForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpFinInfoForm">
  <bean:define id="ParentForm" name="frmEmpFinInfoForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0;
      String sPayStatus="";
  %>  
  <% i = 0;j=0; %>
        <%
              ArrayList arEmpVld=new ArrayList();
              if(session.getAttribute("arEmpVld")!=null)
              {
                arEmpVld=(ArrayList)session.getAttribute("arEmpVld");
              }
        %>

  <jsp:include page="EmpHeaderInc.jsp" flush="true" />
  <table cellspacing=0 cellpadding=0 border=0 >
         <!-- Detail Information Row starts -->
 	 <TR height="200">
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
              <DIV id="payDet">
                <jsp:include page="EmpPayDet.jsp" flush="true" />
              </DIV>
              <DIV id="flgDet">
                <jsp:include page="EmpFinFlagInfo.jsp" flush="true" />
              </DIV>
              <DIV id="hrDet">
                <jsp:include page="EmpHrInfo.jsp" flush="true" />
              </DIV>
              <DIV id="otrDet">
                <jsp:include page="EmpFinOthrFlagInfo.jsp" flush="true" />
              </DIV>
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
</div>
<!-- Container Table Ends -->
<html:hidden name="frmEmpFinInfoForm"  property="screenName" value="MaintainEmpFinDetailScreen" />
<html:hidden name="frmEmpFinInfoForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpFinInfoForm" />
<html:hidden property="positionRequested" name="frmEmpFinInfoForm" />
<html:hidden property="userPositionRequested" name="frmEmpFinInfoForm"/>

<html:hidden property="buttonFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="lovKey" name="frmEmpFinInfoForm"  />
<html:hidden property="txtFields" name="frmEmpFinInfoForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpFinInfoForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpFinInfoForm" />
<html:hidden property="txtIndex" name="frmEmpFinInfoForm"  />
<html:hidden property="loginLocCode" name="frmEmpFinInfoForm" />
<html:hidden property="loginEmployeelocation" name="frmEmpFinInfoForm" />
<html:hidden property="hdnStartBasic" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnEndBasic" name="frmEmpFinInfoForm"  />
<html:hidden property="txtInputField" name="frmEmpFinInfoForm"  />
<html:hidden property="txtSubsAmt" name="frmEmpFinInfoForm"  />

<html:hidden property="hdnHraFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnNpaFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnCantFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnWashFlag" name="frmEmpFinInfoForm"  />   
<html:hidden property="hdnStationCompFlag" name="frmEmpFinInfoForm"  />  
<html:hidden property="hdnCCAFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnPLIFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnConvFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnDustOpAllowFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnDepuFlag" name="frmEmpFinInfoForm"  /> 
<html:hidden property="hdnDblHraFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnAdvIncrFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="txtAdvIncrType" name="frmEmpFinInfoForm"  />
<html:hidden property="txtAdvIncrEffDate" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnSplCmpAllowFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnSplPaySprtFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnSplPayCshAllowFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnPersPaySFNFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnPersPayHQuaFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnPersPayHndQuaFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnBoardFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnOpAllowFlag" name="frmEmpFinInfoForm"  />
<html:hidden property="hdnSplDtyAllowFlag" name="frmEmpFinInfoForm"  />
<!--<html:hidden property="selectCarAvail" name="frmEmpFinInfoForm"  />--> <!--added by gagan  -->
<html:hidden property="txtDivision" name="frmEmpFinInfoForm"  />
<html:hidden property="txtEmpNo" name="frmEmpFinInfoForm"  />

<html:hidden property="txtPerPayHighQual" name="frmEmpFinInfoForm"  />
<html:hidden property="txtLicFeeDEM" name="frmEmpFinInfoForm"  />
<html:hidden property="txtLeaseAmt" name="frmEmpFinInfoForm"  />
<html:hidden property="lstAccomType" name="frmEmpFinInfoForm"  />
<html:hidden property="resetFlag" name="frmEmpFinInfoForm" />
<html:hidden property="tmpCpfFlg" name="frmEmpFinInfoForm" />

<!--added by devendra start-->
<html:hidden name="frmEmpFinInfoForm"  property="hdnTmpPayScaleCode" />
<html:hidden name="frmEmpFinInfoForm"  property="hdnTmpGradePay"  />
<!--added by devendra end-->
<!--added by Neeraj Gupta start-->
<html:hidden property="txtCreationDate" name="frmEmpFinInfoForm" />
<html:hidden property="txtCreatedBy"    name="frmEmpFinInfoForm" />
<html:hidden property="txtCreatedSite"  name="frmEmpFinInfoForm" />
<html:hidden property="txtUpdationDate" name="frmEmpFinInfoForm" />
<html:hidden property="txtUpdatedBy"    name="frmEmpFinInfoForm" />
<html:hidden property="txtUpdatedSite"  name="frmEmpFinInfoForm" />
<html:hidden property="txtFathHusflag" name="frmEmpFinInfoForm"  />

<!--added by Neeraj Gupta end-->
<html:hidden name="frmEmpFinInfoForm"  property="screenFlag" value="MaintainEmpFinDetailScreen" />

<input type="hidden" name="queryParam" />
<input type="hidden" name="tmpPayScaleCode" />
<input type="hidden" name="tmpPayBand" />
<input type="hidden" name="tmpGradePay" />

<script language="javascript">
//added by Neeraj Start//
function doShowHistory()
{
//alert("Inside History Details");
//alert("Screen Mode:::"+document.all.screenMode.value);
if(!(frmEmpFinInfoForm.txtCreationDate.value&&frmEmpFinInfoForm.txtCreatedBy.value&&frmEmpFinInfoForm.txtCreatedSite.value))
              {
              alert("No history exists !!!");
              }
              else
              {
alert("Record History"+"\n"
              +"Creation Date :  "+ frmEmpFinInfoForm.txtCreationDate.value+"\n"
              +"Created By      :  "+frmEmpFinInfoForm.txtCreatedBy.value
              +"\n"
              +"Created Site    :  "+frmEmpFinInfoForm.txtCreatedSite.value
              +"\n"
              +"Updation Date:  "+frmEmpFinInfoForm.txtUpdationDate.value
              +"\n"
              +"Updated By     :  "+frmEmpFinInfoForm.txtUpdatedBy.value
              +"\n"
              +"Updated Site   :  "+frmEmpFinInfoForm.txtUpdatedSite.value
              );
}
}
//added by Neeraj Ends Here//


// added by devendra start
function fnChkPayTYpe()
{
	var payScaleType = document.forms[0].txtPayType.value;
	//alert('inside fnChkPayTYpe , screen mode ::::'+document.forms[0].screenMode.value);
	if(payScaleType ==null || payScaleType=="")
	{
		alert("Please select Pay Scale Type First !!!");
		return false;
	}
}


function fnHandleChkBox()
{
	//alert('inside fnHandleChkBox() function');
	return;
}
// added by devendra end 


function ShowLovHraCityCode()
{
   frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastHraCityCode" + frmEmpFinInfoForm.screenName.value + "U";
   frmEmpFinInfoForm.txtDisplayFields.value = "txtCityTypeHra";
   frmEmpFinInfoForm.txtSearchFields.value = "";
   frmEmpFinInfoForm.txtIndex.value="";  
   frmEmpFinInfoForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   frmEmpFinInfoForm.headerDataChanged.value = "true";       
   return true;
}     

function ShowLovBankCode()
{
   frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastBankCode" + frmEmpFinInfoForm.screenName.value + "Q";
   frmEmpFinInfoForm.txtDisplayFields.value = "txtBankDesc";
   frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.BankName";
   frmEmpFinInfoForm.txtIndex.value="";  
   frmEmpFinInfoForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   frmEmpFinInfoForm.headerDataChanged.value = "true";
   return true;
}

function ShowLovBranchCode()
{
   frmEmpFinInfoForm.queryParam.value="txtBankCode="+ frmEmpFinInfoForm.txtBankDesc.value +" " ;    
   frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastBranchCode" + frmEmpFinInfoForm.screenName.value + "Q";
   frmEmpFinInfoForm.txtDisplayFields.value = "txtBranchCode,txtBranchDesc";
   frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.BranchCode,Payroll.Common.desc";
   frmEmpFinInfoForm.txtIndex.value="";  
   frmEmpFinInfoForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   frmEmpFinInfoForm.headerDataChanged.value = "true";
   return true;
}
    
function ShowLovPayScaleCode()
{   
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastPayScaleCode" + frmEmpFinInfoForm.screenName.value + "Q";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtGroupPayScale";
    frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.pcode";
    frmEmpFinInfoForm.txtIndex.value="";    
    frmEmpFinInfoForm.txtInputField.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    frmEmpFinInfoForm.headerDataChanged.value = "true";       
    return true;
}

function ShowLovCityCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastCityCode" + frmEmpFinInfoForm.screenName.value + "U";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtCityType";
    frmEmpFinInfoForm.txtSearchFields.value = "";
    frmEmpFinInfoForm.txtInputField.value =""; 
    frmEmpFinInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    frmEmpFinInfoForm.headerDataChanged.value = "true";       
    return true;
}

function ShowLovDblHraCityCode()
{   
    if(frmEmpFinInfoForm.selectDblHraFlag.checked)
    {
        ////////ADDED BY MILAN
           if(document.getElementById("txtDblHraEffFrom").value!='')
              {  
                if(document.getElementById("txtDblHraEffTill").value=='')
                   {
                      alert('First enter the Effective Till date of current City Type and then change the data');
                      return false; 
                   }
              }
   //////////////////////////
        frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastHraCityCode" + frmEmpFinInfoForm.screenName.value + "U";
        frmEmpFinInfoForm.txtDisplayFields.value = "txtDblHraCity";
        frmEmpFinInfoForm.txtSearchFields.value = "";
        frmEmpFinInfoForm.txtIndex.value=""; 
        frmEmpFinInfoForm.txtInputField.value =""; 
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
        frmEmpFinInfoForm.headerDataChanged.value = "true";       
        return true;
    }
    else
    {
       return false;
    }   
} 

function fillPayStatusChdDate()
{    
    var resFlag;
	var empSts = document.getElementById("txtEmpStatus").value;
	
	if (empSts != 'EMPSTATUS$TRANS')
	{
		if(document.all.screenMode.value!='N')
		{
		  resFlag=confirm("This will change the pay staus change date. Are you sure you want to continue?");
		}
		else
		{
		  resFlag=true;
		}
		if(resFlag==true)
		{
		  var d=new Date();        
		  var curdate=d.getDate()+"/"+eval(d.getMonth()+1)+"/"+d.getYear();
		  var strMon=eval(d.getMonth());
		  var arrCal=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
		  for(var i=0;i<arrCal.length;i++)
		  {
			if(i==strMon)
			{        
			  break;
			}
		  }
		  curdate=(d.getDate() < 10 ? '0' : '') + d.getDate()+"-"+arrCal[i]+"-"+d.getYear();        
		  frmEmpFinInfoForm.txtPayStsChnDate.value=curdate;
		}
		else
		{
		  if(frmEmpFinInfoForm.txtPayStatus.value=='A')
		  {
			frmEmpFinInfoForm.txtPayStatus.value='I';
		  }
		  else
		  {
			frmEmpFinInfoForm.txtPayStatus.value='A';
		  }
		  return false;
		}
	}
	else
	{
		var paySts = document.getElementById("txtPayStatus").value;
		alert("The employee is transferred. So the status can not be changed now.");
		if(paySts == 'A')
			document.getElementById("txtPayStatus").selectedIndex=1;
		else 
			document.getElementById("txtPayStatus").selectedIndex=0;
		return false;
	}

}

function chkVldn()
{
    //alert('inside chkVldn')
	var selPayScaleTyp=frmEmpFinInfoForm.txtPayType.value;
    var selCtgry=frmEmpFinInfoForm.txtCateg.value;
    var selDsgnId=frmEmpFinInfoForm.txtDsgnDesc.value;
    var selEmpStatus=frmEmpFinInfoForm.txtEmpStatus.value;
    var payCodeArr = new Array();
    var payCodeFlagArr=new Array();
    
<%
    for(int i=0;i<arEmpVld.size();i++)
    {
      EmpFinVldnBean vdln=(EmpFinVldnBean)arEmpVld.get(i);
%>
      var payScaleTyp="<%=vdln.getStrPayScaleTyp()%>";
      var payCode=<%=vdln.getStrPayCode()%>;
      var ctgry="<%=vdln.getStrCtgry()%>";
      var dsgnId="<%=vdln.getStrDsgnId()%>";
      var payCodeDesc="<%=vdln.getStrAllow()%>";
      var empStatus="<%=vdln.getStrEmpStatus()%>";
      var val="<%=vdln.getStrFlag()%>";
      
     if((payScaleTyp=="All") || (payScaleTyp==selPayScaleTyp))
     {
         if((dsgnId=="All") || (dsgnId==selDsgnId))
         {
            if((ctgry=="All") || (ctgry==selCtgry))
            {
              if((empStatus=="All") || (empStatus==selEmpStatus))
              {              
                payCodeArr.push(payCode);
                payCodeFlagArr.push(val);
				//alert('inside chkVldn function ........pushing payCode:'+payCode+'   and val::: '+val);
              }
            }
         }
     }
    
<%
    }
%>
 //alert("array--"+payCodeArr);
 setAllowFlag(payCodeArr,payCodeFlagArr);
}

function loadchkVldn()
{
       // alert('loadchkVldn function')
	var selPayScaleTyp=frmEmpFinInfoForm.txtPayType.value;
    var selCtgry=frmEmpFinInfoForm.txtCateg.value;
    var selDsgnId=frmEmpFinInfoForm.txtDsgnDesc.value;
    var selEmpStatus=frmEmpFinInfoForm.txtEmpStatus.value;
    var payCodeArr = new Array();
    var payCodeFlagArr=new Array();
    
<%
    for(int i=0;i<arEmpVld.size();i++)
    {
      EmpFinVldnBean vdln=(EmpFinVldnBean)arEmpVld.get(i);
%>
      var payScaleTyp="<%=vdln.getStrPayScaleTyp()%>";
      var payCode=<%=vdln.getStrPayCode()%>;
      var ctgry="<%=vdln.getStrCtgry()%>";
      var dsgnId="<%=vdln.getStrDsgnId()%>";
      var payCodeDesc="<%=vdln.getStrAllow()%>";
      var empStatus="<%=vdln.getStrEmpStatus()%>";
      var val="<%=vdln.getStrFlag()%>";
      
     if((payScaleTyp=="All") || (payScaleTyp==selPayScaleTyp))
     {
         if((dsgnId=="All") || (dsgnId==selDsgnId))
         {
            if((ctgry=="All") || (ctgry==selCtgry))
            {
              if((empStatus=="All") || (empStatus==selEmpStatus))
              {              
                payCodeArr.push(payCode);
                payCodeFlagArr.push(val);
				//alert('inside loadchkVldn function ........pushing payCode:'+payCode+'   and val::: '+val);
              }
            }
         }
     }
    
<%
    }
%>
 //alert("array--"+payCodeArr);
 loadAllowFlag(payCodeArr,payCodeFlagArr);
}

function setAllowFlag(payCodeArr,payCodeFlagArr)
{
    //alert('setAllowFlag function')
	var flagArr=['122','174','184','114','105','161','109']; 
    var flagHdnArr=["hdnNpaFlag","hdnCantFlag","hdnDustOpAllowFlag","hdnWashFlag","hdnSplPayCshAllowFlag","hdnStationCompFlag","hdnCCAFlag"]; 
    var ctrlArr=["selectNpa","selectCant","selectDustOpAllow","selectWash","selectSplPayCshAllow","selectStationComp","selectCCAFlag"]; 
    var i,j;    
    for(i=0; i < flagArr.length; i++)
    {
        for(j=0; j < payCodeArr.length; j++)
        {          
           if (flagArr[i] == payCodeArr[j]) 
           {
              if(payCodeFlagArr[j]=='S')
              {
                document.getElementById(ctrlArr[i]).disabled="";
              }else
              {
                document.getElementById(flagHdnArr[i]).value='Y';                            
                document.getElementById(ctrlArr[i]).checked="true";
                document.getElementById(ctrlArr[i]).disabled="true";
              }
              break;
           }
        }
        
        if(j==payCodeArr.length)    
        {        
            document.getElementById(flagHdnArr[i]).value='N';            
            document.getElementById(ctrlArr[i]).checked="";
            document.getElementById(ctrlArr[i]).disabled="true";
        }
    }
    if(document.all.txtCateg.value =='EMPCTGRY$II' && document.all.txtCadre.value =='EMPCADR$ENGG')
    {
      document.getElementById("hdnWashFlag").value='N';            
      document.getElementById("selectWash").checked="";
      document.getElementById("selectWash").disabled="";
      
    }    

	 if(document.all.txtCateg.value =='EMPCTGRY$III' || document.all.txtCateg.value =='EMPCTGRY$IV' )
    {
      document.getElementById("hdnCantFlag").value='N';            
      document.getElementById("selectCant").checked="true";
      document.getElementById("selectCant").disabled="";
      
    }    
	
		//alert(document.all.txtCateg.value);
		if(document.all.txtCateg.value =='EMPTYPE$REG')
    {
      
      
    } 


	
    //alert("hdnWashFlag---"+frmEmpFinInfoForm.hdnWashFlag.value);
    //alert("hdnNpaFlag---"+frmEmpFinInfoForm.hdnNpaFlag.value);
    //alert("hdnCantFlag---"+frmEmpFinInfoForm.hdnCantFlag.value);
    //alert("hdnDustOpAllowFlag---"+frmEmpFinInfoForm.hdnDustOpAllowFlag.value);   
}

function loadAllowFlag(payCodeArr,payCodeFlagArr)
{
       // alert('loadAllowFlag function')
	var flagArr=['122','174','184','114','105','161','109']; 
    var flagHdnArr=["hdnNpaFlag","hdnCantFlag","hdnDustOpAllowFlag","hdnWashFlag","hdnSplPayCshAllowFlag","hdnStationCompFlag","hdnCCAFlag"]; 
    var ctrlArr=["selectNpa","selectCant","selectDustOpAllow","selectWash","selectSplPayCshAllow","selectStationComp","selectCCAFlag"]; 
    var i,j;    
    for(i=0; i < flagArr.length; i++)
    {
        for(j=0; j < payCodeArr.length; j++)
        {          
           if (flagArr[i] == payCodeArr[j]) 
           {
              if(payCodeFlagArr[j]=='S')
              {
                document.getElementById(ctrlArr[i]).disabled="";
              }else
              {
               // document.getElementById(flagHdnArr[i]).value='Y';                            
               // document.getElementById(ctrlArr[i]).checked="true";
                document.getElementById(ctrlArr[i]).disabled="true";
              }
              break;
           }
        }
        
        if(j==payCodeArr.length)    
        {        
           // document.getElementById(flagHdnArr[i]).value='N';            
           // document.getElementById(ctrlArr[i]).checked="";
            document.getElementById(ctrlArr[i]).disabled="true";
        }
    }
    
    if(document.all.txtCateg.value =='EMPCTGRY$II' && document.all.txtCadre.value =='EMPCADR$ENGG')
    {      
      //document.getElementById("selectWash").checked="";
      document.getElementById("selectWash").disabled="";
    }    
}
</script>

</html:form>
</body>
</html:html>