function EmpFinLoad()
{
    mode = document.all.screenMode.value;      
	// added by devendra on 28 sept 2010 start
	document.all.butInsertMode.disabled="true";    
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";   
	// added by devendra on 28 sept 2010 end
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='U')
    {         
        document.all.headerPrimaryKey.disabled = "true";         
    }
    if(mode=='Q')
    {         
        document.all.prefix.disabled = "true";
        document.all.txtEmpMiddleName.disabled = "true";
        document.getElementById("prefix").style.background="#ffffff";
        document.getElementById("prefix").style.className="locked";
        document.all.txtPFType.disabled = "true";
        document.getElementById("txtPFType").style.background="#ffffff";
        document.getElementById("txtPFType").style.className="locked";        
        document.getElementById("txtFpsNo").disabled = "true";        
    }    
    //checkPayMode();  
    //checkEpsFlag(); 
	checkEpsFlagOnLoad();
    hedMenuHandling(mode);    
	
  /* if(document.all.txtEpsFlag.value=='Y')    //added by swapnendu Dt 06 Dec 2012.
		document.getElementById("txtEpsFlag").disabled = "true";
	else
		document.getElementById("txtEpsFlag").disabled = "";*/
}

function updateFPSno(val)
{
	var len=val.length;
	if(len > 0)
	{
		if(isNaN(val))
		{
			if(confirm("do you want to modify FPS/EPS Number?"))
			{
				document.getElementById("txtFpsNo").value = val.substring(2);
			}
		}
	}
}

function checkDepuType()
{
    if (document.all.txtEmpStatus.value=="EMPSTATUS$DEPU")
    {
       document.getElementById("txtDepuType").disabled = "";
       document.getElementById("txtDepuType").style.background="#ffffd3";
       document.getElementById("txtDepuType").style.className="required";           
    }  
    else 
    {
       document.getElementById("txtDepuType").disabled = "true";
       document.getElementById("txtDepuType").value = "";
       document.getElementById("txtDepuType").style.background="#ffffff";
       document.getElementById("txtDepuType").style.className="optional";           
    } 
}

function enableDepuType(val)
{
    if (val=="EMPSTATUS$DEPU")
    {
       document.getElementById("txtDepuType").disabled = "";
       document.getElementById("txtDepuType").style.background="#ffffd3";
       document.getElementById("txtDepuType").style.className="required";           
    }  
    else 
    {
       document.getElementById("txtDepuType").disabled = "true";
       document.getElementById("txtDepuType").value = "";
       document.getElementById("txtDepuType").style.background="#ffffff";
       document.getElementById("txtDepuType").style.className="locked";           
    }  
}

function checkPFType()
{     
    if (document.all.txtPFType.value=='PFTYPE$CPF' || document.all.txtPFType.value=='')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';        
    }
    if (document.all.txtPFType.value=="PFTYPE$GPF")
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';                   
    }    
}  

function onChangePFType(val)
{   
    if (val=='PFTYPE$GPF')
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';
        document.getElementById("txtPayType").disabled = "true";        
        document.getElementById("txtPayType").value = "IDA";
        document.getElementById("txtPayType").style.background="#ffffd3";
        document.getElementById("txtPayType").style.className="required";        
    }
    if (val=='PFTYPE$CPF')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';        
        document.getElementById("txtPayType").disabled = "";        
        document.getElementById("txtPayType").value = "";
        
    } 
}

function checkPayMode()
{
    if (document.all.txtPayMode.value=="O")
    {
        document.getElementById("txtPayModeType").disabled = "";
        document.getElementById("txtPayModeType").style.background="#ffffd3";
        document.getElementById("txtPayModeType").style.className="required";
        
        document.getElementById("txtBankCode").value = "";
        document.getElementById("txtBankDesc").value = "";
        document.getElementById("txtBankDesc").style.background="#ffffff";
        document.getElementById("txtBankDesc").style.className="optional";
        
        document.getElementById("txtBranchCode").value = "";
        document.getElementById("txtBranchDesc").value = "";
        document.getElementById("txtBranchDesc").style.background="#ffffff";
        document.getElementById("txtBranchDesc").style.className="optional";
        
        document.getElementById("txtBankAccNo").value = "";
        document.getElementById("txtBankAccNo").style.background="#ffffff";
        document.getElementById("txtBankAccNo").style.className="optional";
        if(frmDeptLabourInfoForm.txtPayModeType.value=='ESC')
        {            
            document.getElementById("txtBankDesc").style.background="#ffffd3";
            document.getElementById("txtBankDesc").style.className="required";
            
            document.getElementById("txtBranchDesc").style.background="#ffffd3";
            document.getElementById("txtBranchDesc").style.className="required";
            document.getElementById("txtBankAccNo").disabled = "";
            document.getElementById("txtBankAccNo").style.background="#ffffd3";
            document.getElementById("txtBankAccNo").style.className="required";
        }
    }  
    else if (document.all.txtPayMode.value=="B")
    {
        document.getElementById("txtPayModeType").disabled = "true";
        document.getElementById("txtPayModeType").selectedIndex = "0";
        document.getElementById("txtPayModeType").style.background="#ffffff";
        document.getElementById("txtPayModeType").style.className="optional"; 
        
        document.getElementById("txtBankDesc").style.background="#ffffd3";
        document.getElementById("txtBankDesc").style.className="required";
        
        document.getElementById("txtBranchDesc").style.background="#ffffd3";
        document.getElementById("txtBranchDesc").style.className="required";
        document.getElementById("txtBankAccNo").disabled = "";
        document.getElementById("txtBankAccNo").style.background="#ffffd3";
        document.getElementById("txtBankAccNo").style.className="required";
    }
    else 
    {
        document.getElementById("txtPayModeType").disabled = "true";
        document.getElementById("txtPayModeType").selectedIndex = "0";
        document.getElementById("txtPayModeType").style.background="#ffffff";
        document.getElementById("txtPayModeType").style.className="optional"; 
        
        document.getElementById("txtBankCode").value = "";
        document.getElementById("txtBankDesc").value = "";
        document.getElementById("txtBankDesc").style.background="#ffffff";
        document.getElementById("txtBankDesc").style.className="optional";
        
        document.getElementById("txtBranchCode").value = "";
        document.getElementById("txtBranchDesc").value = "";
        document.getElementById("txtBranchDesc").style.background="#ffffff";
        document.getElementById("txtBranchDesc").style.className="optional";
        
        document.getElementById("txtBankAccNo").value = "";
        document.getElementById("txtBankAccNo").style.background="#ffffff";
        document.getElementById("txtBankAccNo").style.className="optional";
    }    
}

function onChangePModeType()
{   
    comboChange();
    if (frmDeptLabourInfoForm.txtPayMode.value == 'O' && frmDeptLabourInfoForm.txtPayModeType.value=='ESC')
    {       
       document.getElementById("txtBankDesc").style.background="#ffffd3";
       document.getElementById("txtBankDesc").style.className="required"; 
       
       document.getElementById("txtBranchDesc").style.background="#ffffd3";
       document.getElementById("txtBranchDesc").style.className="required";
       document.getElementById("txtBankAccNo").disabled = "";
       document.getElementById("txtBankAccNo").style.background="#ffffd3";
       document.getElementById("txtBankAccNo").style.className="required";
    }  
    else 
    {       
       document.getElementById("txtBankCode").value = "";
       document.getElementById("txtBankDesc").value = "";
       document.getElementById("txtBankDesc").style.background="#ffffff";
       document.getElementById("txtBankDesc").style.className="optional";  
       
       document.getElementById("txtBranchCode").value = "";
       document.getElementById("txtBranchDesc").value = "";
       document.getElementById("txtBranchDesc").style.background="#ffffff";
       document.getElementById("txtBranchDesc").style.className="optional";
       
       document.getElementById("txtBankAccNo").value = "";
       document.getElementById("txtBankAccNo").style.background="#ffffff";
       document.getElementById("txtBankAccNo").style.className="optional";
    }    
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmDeptLabourInfoForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
}

function lfnChangeNegNum(val)
{
    if(NegNum_Check(val,1))
    { 
        frmDeptLabourInfoForm.headerDataChanged.value = "true";
        return true;
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function comboChange(val)
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
}

function doOnChangeCalendar(buttonName)
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{    
    document.all.buttonFlag.value='';        
    frmDeptLabourInfoForm.action="../../../DeptLbrAdminGetHeaderAction.do"    
    frmDeptLabourInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.positionRequested.value + 1;
    frmDeptLabourInfoForm.action="../../../DeptLbrAdminGetNextHeader.do";
    frmDeptLabourInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.positionRequested.value - 1;
    frmDeptLabourInfoForm.action = "../../../DeptLbrAdminGetPrevHeader.do";
    frmDeptLabourInfoForm.submit();
}

function JumpHeader()
{   
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.newPositionRequested.value;    
    frmDeptLabourInfoForm.action = "../../../DeptLbrAdminGetNextHeader.do";
    frmDeptLabourInfoForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmDeptLabourInfoForm.action="../../../DeptLbrFinAdminNewMode.do"
    frmDeptLabourInfoForm.submit();
}

function doQueryMode()
{   
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';    
    frmDeptLabourInfoForm.action="../../../DeptLbrAdminQueryMode.do"
    frmDeptLabourInfoForm.submit();
}
function doRefresh()
{   
    document.all.buttonFlag.value=''; 
    frmDeptLabourInfoForm.action="../../../DeptLbrFinAdminRefresh.do"
    frmDeptLabourInfoForm.submit();
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
   
            
    if(mandatory_Check("frmDeptLabourInfoForm"))
    {     
        frmDeptLabourInfoForm.txtEmpNo.value=frmDeptLabourInfoForm.headerPrimaryKey.value; 
        document.getElementById("txtPFType").disabled= "";
        document.getElementById("txtPayType").disabled= "";
        //document.all.hdnCCAFlag.value='Y';         commented by devendra on 21 sept 2010
		document.all.hdnCCAFlag.value='';         //added by devendra on 21 sept 2010
        //document.all.hdnStationCompFlag.value=document.all.txtPayType.value=='IDA'? 'Y' : 'N';  commented by devendra on 21 sept 2010  
		document.all.hdnStationCompFlag.value='';       //added by devendra on 21 sept 2010       
        document.all.hdnPLIFlag.value=frmDeptLabourInfoForm.hdnBoardFlag.value=='N' ? 'Y' : 'N';    
        if (frmDeptLabourInfoForm.txtPayMode.value == "C")
        {
            frmDeptLabourInfoForm.txtPayModeType.value=" ";  
        }
        if (frmDeptLabourInfoForm.txtPayMode.value == "B")    
        {
            frmDeptLabourInfoForm.txtPayModeType.value=" ";  
        }       
        
        frmDeptLabourInfoForm.detailDataChanged.value = "false";  
        if(frmDeptLabourInfoForm.screenMode.value == "N")
            frmDeptLabourInfoForm.headerDataChanged.value = "true";    
        frmDeptLabourInfoForm.headerFields.value = "true";   
        if(frmDeptLabourInfoForm.txtGender.value=="")
        {
            alert("Mandatory Field Gender in HRMS Details is Empty! ");
            return;
        }        
        frmDeptLabourInfoForm.headerDataChanged.value = "true";    //added by swapnendu on 09 Mar 2011
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmDeptLabourInfoForm.action = "../../../DeptLbrFinAdminSaveAction.do";              
        frmDeptLabourInfoForm.submit();
    }
    
    else
    {
        return false;
    }
}

function SavePayrollTabData()
{
    document.all.buttonFlag.value='';

    if (frmDeptLabourInfoForm.txtEmpStatus.value=='EMPSTATUS$DEPU')
    {
        if (document.getElementById("txtDepuType").value ==" " || document.getElementById("txtDepuType").value =='')
        {
            alert("Deputation Type is Mandatory if Employee Status is Deputation");
            frmDeptLabourInfoForm.txtDepuType.focus(); 
            return false;
        }
    }
    else
    {
        document.getElementById("txtDepuType").disabled = "false";
        document.getElementById("txtDepuType").value = "";
    }     
   
    if (frmDeptLabourInfoForm.txtPayMode.value == 'O' && frmDeptLabourInfoForm.txtPayModeType.value=='ESC')
    {
        if (frmDeptLabourInfoForm.txtBankCode.value == '')
        {
            alert("Mandatory Field Bank Code is Empty!");
            frmDeptLabourInfoForm.txtBankDesc.focus(); 
            return false;
        }
        if (frmDeptLabourInfoForm.txtBranchCode.value == '')
        {
            alert("Mandatory Field Branch Code is Empty!");
            frmDeptLabourInfoForm.txtBranchDesc.focus(); 
            return false;
        }    
        if (frmDeptLabourInfoForm.txtBankAccNo.value == '')
        {
            alert("Mandatory Field Bank Account Number is Empty!");
            frmDeptLabourInfoForm.txtBankAccNo.focus(); 
            return false;
        }        
    }
    
    if (frmDeptLabourInfoForm.hdnBoardFlag.value=='N')
    {        
        document.all.hdnPLIFlag.value='Y';         
    }
    else
    {
        document.all.hdnPLIFlag.value='N';         
    }    
    
    if(mandatory_Check("frmDeptLabourInfoForm"))
    {     
        frmDeptLabourInfoForm.txtEmpNo.value=frmDeptLabourInfoForm.headerPrimaryKey.value; 
        if (frmDeptLabourInfoForm.txtPayMode.value == "C")
        {
            frmDeptLabourInfoForm.txtPayModeType.value=" ";  
        }
        if (frmDeptLabourInfoForm.txtPayMode.value == "B")    
        {
            frmDeptLabourInfoForm.txtPayModeType.value=" ";  
        }       
        
        frmDeptLabourInfoForm.detailDataChanged.value = "false";  
        if(frmDeptLabourInfoForm.screenMode.value == "N")
            frmDeptLabourInfoForm.headerDataChanged.value = "false";    
        frmDeptLabourInfoForm.headerFields.value = "true";        
        return true;
    }
    
    else
    {
        return false;
    }
}

function checkCurBasicLimit()
{
    var curBasic;
    var startBasic;
    var endBasic;
    var curBasic;
    curBasic = parseInt(frmDeptLabourInfoForm.txtCurtBasic.value);
    startBasic =parseInt(frmDeptLabourInfoForm.hdnStartBasic.value); 
    endBasic = parseInt(frmDeptLabourInfoForm.hdnEndBasic.value);
    if(curBasic < startBasic || curBasic > endBasic)
    {
        alert("Current Basic Should be In Range "+startBasic+" To "+endBasic);
        frmDeptLabourInfoForm.txtCurtBasic.select();
        frmDeptLabourInfoForm.txtCurtBasic.focus();
        return false;
    }    
    else
        return true;
}

function disable()
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
    if (document.all.selectChEdAl.checked==true)
    {
        document.all.selectChEdAl.value="Y";
        if(document.all.selectChEdAl.value=="Y")
        {
        document.getElementById("txtNoc").disabled = "";
        document.getElementById("txtNoc").style.background="#ffffd3";
        document.getElementById("txtNoc").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtNoc").disabled = "true"; 
        document.getElementById("txtNoc").value = "";     
        document.getElementById("txtNoc").style.background="#e0e0e0";
        document.getElementById("txtNoc").style.className="locked";       
    }
}

function HosDisab()
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
    if (document.all.selectHos.checked==true)
    {
        document.all.selectHos.value="Y";
        if(document.all.selectHos.value=="Y")
        {
        document.getElementById("txtHosChld").disabled = "";
        document.getElementById("txtHosChld").style.background="#ffffd3";
        document.getElementById("txtHosChld").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtHosChld").disabled = "true";
        document.getElementById("txtHosChld").value = "";
        document.getElementById("txtHosChld").style.background="#e0e0e0";
        document.getElementById("txtHosChld").style.className="locked";       
    }
}

function CantDisab()
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
    if (document.all.selectCant.checked==true)
    {
        document.all.selectCant.value="Y";
        if(document.all.selectCant.value=="Y")
        {
        document.getElementById("txtCantRate").disabled = "";
        document.getElementById("txtCantRate").style.background="#ffffd3";
        document.getElementById("txtCantRate").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtCantRate").disabled = "true";
        document.getElementById("txtCantRate").value = "";
        document.getElementById("txtCantRate").style.background="#ffffff";
        document.getElementById("txtCantRate").style.className="optional";       
    }
}

function GisDisab()
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
    if (document.all.selectGisRec.checked==true)
    {
        document.all.selectGisRec.value="Y";
        if(document.all.selectGisRec.value=="Y")
        {
        document.getElementById("txtGisType").disabled = "";
        document.getElementById("txtGisType").style.background="#ffffd3";
        document.getElementById("txtGisType").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtGisType").disabled = "true";
        document.getElementById("txtGisType").value = "";
        document.getElementById("txtGisType").style.background="#ffffff";
        document.getElementById("txtGisType").style.className="optional";       
    }
}

function DepuFlag()
{
    if (document.all.selectDep.checked==true)
        document.getElementById("selectOut").disabled = "";
    else
    {
        document.getElementById("selectOut").disabled = "disabled"; 
        document.getElementById("selectOut").checked="";
    }
}

function showCalendar(inputId, butId) 
{  
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

function doGetTab(arg)
{  
   if(mode == 'N' || mode == 'U')
    {        
       /*  if ((frmDeptLabourInfoForm.txtPayMode.value == 'O' && frmDeptLabourInfoForm.txtPayModeType.value=='ESC') || frmDeptLabourInfoForm.txtPayMode.value == 'B')
        {
            if (frmDeptLabourInfoForm.txtBankDesc.value == '')
            {
                alert("Mandatory Field Bank Name is Empty!");
                frmDeptLabourInfoForm.txtBankDesc.focus(); 
                return false;
            }
            if (frmDeptLabourInfoForm.txtBranchCode.value == '')
            {
                alert("Mandatory Field Branch Name is Empty!");
                frmDeptLabourInfoForm.txtBranchDesc.focus(); 
                return false;
            }    
            if (frmDeptLabourInfoForm.txtBankAccNo.value == '')
            {
                alert("Mandatory Field Bank Account Number is Empty!");
                frmDeptLabourInfoForm.txtBankAccNo.focus(); 
                return false;
            }        
        }   */      

        if(mandatory_Check("frmDeptLabourInfoForm"))
        {
            document.all.hdnPLIFlag.value=frmDeptLabourInfoForm.hdnBoardFlag.value=='N'? 'Y' : 'N';
            document.getElementById("txtPayType").disabled= "";
            document.all.forwardedPage.value=arg;
            document.forms[0].action="../../../DeptLbrPayAdminTabAction.do";
            document.forms[0].submit();
        }
    }
    else
    { 
        document.all.forwardedPage.value=arg;
        document.forms[0].action="../../../DeptLbrPayAdminTabAction.do";
        document.forms[0].submit(); 
    }
}

function setAllowFlag(payCodeArr)
{
  //  var flagArr=['114','122','174','184']; 
 //   var flagHdnArr=["hdnWashFlag","hdnNpaFlag","hdnCantFlag","hdnDustOpAllowFlag"]; 
 //  Added by Balpreet dt 26 May 2008 for Stn Cmp Allow- dt 3 July 2008 for Trnasport allow
 // alert('inside setAllowFlag in deptlabourfinanceinfoadmin.js');
    var flagArr=['114','122','174','184','161','166',109]; 
    var flagHdnArr=["hdnWashFlag","hdnNpaFlag","hdnCantFlag","hdnDustOpAllowFlag","hdnStationCompFlag","hdnConvFlag","hdnCCAFlag"]; 

    var i,j;    
    for(i=0; i < flagArr.length; i++)
    {
        for(j=0; j < payCodeArr.length; j++)
        {          
           if (flagArr[i] == payCodeArr[j]) 
           {
             // alert('setting '+flagHdnArr[i]+' field as  Y')
			  //document.getElementById(flagHdnArr[i]).value='Y'; commented by devendra on 1 oct 2010
              break;
           }
        }
        
        if(j==payCodeArr.length)    
        {        
            document.getElementById(flagHdnArr[i]).value='N';        
        }
    }
    //alert("hdnWashFlag---"+frmDeptLabourInfoForm.hdnWashFlag.value);
    //alert("hdnNpaFlag---"+frmDeptLabourInfoForm.hdnNpaFlag.value);
    //alert("hdnCantFlag---"+frmDeptLabourInfoForm.hdnCantFlag.value);
    //alert("hdnDustOpAllowFlag---"+frmDeptLabourInfoForm.hdnDustOpAllowFlag.value);   
}

function checkDojFci(cdate)
{
    if (trim(cdate) == "")
    {
        return true;
    }    
    firstIndex=cdate.indexOf("-");
    lastIndex=cdate.lastIndexOf("-");
    var dojSite=cdate;
    if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
    {
        var arr=cdate.split("-");
        var cyear= arr[2];
        var lyear=1990;                
        var monIndx=getMonthIndx(arr[1]);
        var lmonthIndx=parseInt(01);
        var ldayIndx=parseInt(01);
        if(monIndx!=-1)
        {
            cdate = arr[0] + "/" + monIndx + "/" + cyear;  		
            udate = ldayIndx + "/" + lmonthIndx + "/" + lyear;  		
        }    
    }
    //cdate = change_DateFormat(cdate);  
    sysDate = getSysDate(); 
    if (dateDiff(udate, cdate) < 0 || dateDiff(sysDate, cdate) >0)
    {
        alert("Date Of Joining FCI Cannot be Less then 1990! or Greater then Current Date");
        frmDeptLabourInfoForm.txtDojFCI.select();
        frmDeptLabourInfoForm.txtDojFCI.focus();
        frmDeptLabourInfoForm.txtDojFCI.value="";
        return false;
    }
    document.all.txtDOJSite.value=dojSite;
    return true;
}

function checkPostDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtDOJSite.value="";     
        return false;
    }    
}

function checkPayStatDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtPayStsChnDate.value="";     
        return false;
    }    
}

function checkStagDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtStagEffDate.value="";     
        return false;
    }    
}

function checkEpsFlag()
{
	var mode = document.all.screenMode.value;  
	if(document.all.txtEpsFlag.value=='Y')
	{
		if (mode=='U')  //added by swapnendu Dt 08 Apr 2013
		{
			document.getElementById("butEpsEntDt").disabled="";
			document.getElementById("txtFpsNo").readOnly="";
			document.getElementById("txtEpsEntDt").style.background="#ffffd3";
			document.getElementById("txtEpsEntDt").className="required";
			document.getElementById("txtFpsNo").style.background="#ffffd3";
			document.getElementById("txtFpsNo").className="required";
			if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
				 document.getElementById("txtFpsNo").className="locked";
				 document.getElementById("txtFpsNo").readOnly="true"; 
				 document.getElementById("txtFpsNo").value = "TEMP";
				 document.getElementById("txtFpsNo").style.background="#e0e0e0";
				}
		}
		if (mode=='N')
		{
			document.getElementById("butEpsEntDt").disabled="";
			document.getElementById("txtEpsEntDt").style.background="#ffffd3";
			document.getElementById("txtEpsEntDt").className="required";
			document.getElementById("txtFpsNo").style.background="#ffffd3";
			document.getElementById("txtFpsNo").className="required";
			document.getElementById("txtFpsNo").disabled="";
			document.getElementById("txtFpsNo").readOnly="";
			if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
				 document.getElementById("txtFpsNo").className="locked";
				 document.getElementById("txtFpsNo").readOnly="true"; 
				 document.getElementById("txtFpsNo").value = "TEMP"; 
				 document.getElementById("txtFpsNo").style.background="#e0e0e0";
				}
		}
	}
	else
	{
		document.getElementById("butEpsEntDt").disabled="true";
		//document.getElementById("txtEpsEntDt").value = "";
		document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
		document.getElementById("txtEpsEntDt").readOnly = "true";
		document.getElementById("txtEpsEntDt").className="locked";
		document.getElementById("txtFpsNo").style.background="#e0e0e0";
		document.getElementById("txtFpsNo").readOnly = "true";
		document.getElementById("txtFpsNo").className="locked";
		document.getElementById("txtFpsNo").onclick="";
		  if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
				 document.getElementById("txtFpsNo").value = "";   // Added by dushyant on 16-May-2013
				}
	}
}

function checkEpsFlagOnLoad()  //added by swapnendu Dt 06 Dec 2012
{
	var mode = document.all.screenMode.value;
	var cdate = document.getElementById("txtDOB").value;
    if (trim(cdate) != "")
    {
		firstIndex=cdate.indexOf("-");
		lastIndex=cdate.lastIndexOf("-");
		
		if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
		{
			var arr=cdate.split("-");
			var cyear= arr[2];
			var uyear=arr[2];
			var lyear;        
			lyear=parseInt(cyear)+18;  
			uyear=parseInt(cyear)+60;    
			var uEpsyear =parseInt(cyear)+58;
			var epsDate;
			var monIndx=getMonthIndx(arr[1]);
			if(arr[0]==01 && arr[1]!='Jan')
			{ 
			  var noDays = daysYearMonth(monIndx-1,uyear);          
			  var rmonth = GetMonth(monIndx-2);          
			  var retDate=noDays + "-" + rmonth + "-" + uyear;  
			}
			else if(arr[0]==01 && arr[1]=='Jan')
			{
			  var retDate=31+ "-" + "Dec" + "-" + parseInt(uyear-1);        
			}
			else
			{
			  var noDays = daysYearMonth(monIndx,uyear);          
			  var retDate=noDays + "-" + arr[1] + "-" + uyear;
			}
			if(monIndx!=-1)
			{
				cdate = arr[0] + "/" + monIndx + "/" + lyear;  		
				udate = arr[0] + "/" + monIndx + "/" + uyear;  	
				epsDate = arr[0] + "/" + monIndx + "/" + uEpsyear;
			}    
		}
		var sysDate = getSysDate();

		if (eval(dateDiff(sysDate, epsDate)) > 0)
		{
			document.getElementById("txtEpsFlag").value = 'Y';
		} 
		if (eval(dateDiff(sysDate, epsDate)) < 0)
		{
			document.getElementById("txtEpsFlag").value= 'N';
		}
    }    

	if(document.all.txtEpsFlag.value=='Y')
	{
		if (mode=='U')
		{
			if (document.getElementById("txtEpsEntDt").value=="")
			{
				document.getElementById("butEpsEntDt").disabled="";
				document.getElementById("txtEpsEntDt").style.background="#ffffd3";
				document.getElementById("txtEpsEntDt").className="required";
			}
			else
			{
				document.getElementById("butEpsEntDt").disabled="true";
				document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
				document.getElementById("txtEpsEntDt").readOnly = "true"; 
				document.getElementById("txtEpsEntDt").className="locked";
			}
			if (document.getElementById("txtFpsNo").value=="")
			{
				document.getElementById("txtFpsNo").style.background="#ffffd3";
				document.getElementById("txtFpsNo").className="required";
				document.getElementById("txtFpsNo").disabled="";
				document.getElementById("txtFpsNo").readOnly="";
			}
			else 
			{
				document.getElementById("txtFpsNo").style.background="#e0e0e0";
				document.getElementById("txtFpsNo").readOnly = "true"; 
				document.getElementById("txtFpsNo").className="locked";
				document.getElementById("txtFpsNo").onclick="";
			}
			 if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
                                
                               /* $('#txtEpsFlag').attr("disabled","disabled");
				 document.getElementById("txtEpsFlag").disabled="true";*/
				 document.getElementById("txtEpsFlag").readOnly="true"; 
				}  

		}
		if (mode=='N')
		{
			document.getElementById("butEpsEntDt").disabled="";
			document.getElementById("txtEpsEntDt").style.background="#ffffd3";
			document.getElementById("txtEpsEntDt").className="required";
			document.getElementById("txtFpsNo").style.background="#ffffd3";
			document.getElementById("txtFpsNo").className="required";
			document.getElementById("txtFpsNo").disabled="";
			document.getElementById("txtFpsNo").readOnly="";
		}
		document.getElementById("txtEpsSepRsn").disabled="";
		document.getElementById("txtEpsSepRsn").style.background="#ffffff";
		document.getElementById("txtEpsSepRsn").style.className="optional";

		document.getElementById("butEpsSepDt").disabled="";
		document.getElementById("txtEpsSepDt").style.background="#ffffff";
		document.getElementById("txtEpsSepDt").style.className="optional";
	}
	else
	{
		document.getElementById("butEpsEntDt").disabled="true";
		document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
		document.getElementById("txtEpsEntDt").readOnly = "true";
		document.getElementById("txtEpsEntDt").className="locked";
		document.getElementById("txtFpsNo").style.background="#e0e0e0";
		document.getElementById("txtFpsNo").readOnly = "true";
		document.getElementById("txtFpsNo").className="locked";
		document.getElementById("txtFpsNo").onclick="";

		document.getElementById("txtEpsSepRsn").disabled="true";
		document.getElementById("txtEpsSepRsn").value = "";
		document.getElementById("txtEpsSepRsn").style.background="#e0e0e0";
		document.getElementById("txtEpsSepRsn").style.className="locked";

		document.getElementById("butEpsSepDt").disabled="true";
		document.getElementById("txtEpsSepDt").value = "";
		document.getElementById("txtEpsSepDt").style.background="#e0e0e0";
		document.getElementById("txtEpsSepDt").style.className="locked";
		 if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
                              /*  $('#txtEpsFlag').attr("disabled","disabled");
				 document.getElementById("txtEpsFlag").disabled="true";*/
				 document.getElementById("txtEpsFlag").readOnly="true"; 
				}  
	}
}

function daysYearMonth(mnth, years )
{
    var intMonth = mnth; //given month
    var intYear = years; //given year        
    if (1 == intMonth || 3 == intMonth || 5 == intMonth || 7 == intMonth || 8 == intMonth ||
    10 == intMonth || 12 == intMonth)
    {
        return 31;
    }
    else if (2 == intMonth)
    {
        // Check for leap year
        if (0 == (intYear % 4))
        {
            // If date is divisible by 400, it's a leap year.
            // Otherwise, if it's divisible by 100 it's not.
            if (0 == (intYear % 400))
            {     
               return 29;
            }
            else if (0 == (intYear % 100))
            {             
                return 28;
            }    
            // Divisible by 4 but not by 100 or 400
            // so it leaps            
            return 29;
        }
        // Not a leap year        
        return 28;
    }
    return 30;     
}

function panNA()
{
	document.getElementById("butNA").disabled="true";
	document.getElementById("txtPanNo").value = "Not Applicable";
	document.getElementById("txtPanNo").readOnly="true";

}
