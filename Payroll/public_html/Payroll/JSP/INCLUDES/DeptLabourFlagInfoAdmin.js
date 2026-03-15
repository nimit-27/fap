function lfnFlagLoad()
{
    mode = document.all.screenMode.value;      
	// added by devendra on 28 sept 2010 start
	document.all.butInsertMode.disabled="true";    
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";   
	var payRevFlag = document.all.payRevFlag.value;
	//alert('pay rev flag :::'+payRevFlag+',  mode:'+mode);
	// added by devendra on 28 sept 2010 end
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='U')
    {
        document.all.headerPrimaryKey.disabled = "true";          
    }
	/* commented by devendra on 29 sept 2010
    document.all.selectPLI.disabled = "true";
    document.all.selectWash.disabled = "true";    
    document.all.selectCant.disabled = "true";
	document.all.selectConvFlag.disabled= "true";
	*/
	// added by devendra on 29 sept 2010 start
	document.all.selectPLI.disabled = "";
    document.all.selectWash.disabled = "";    
    document.all.selectCant.disabled = "";
	document.all.selectConvFlag.disabled= "";
	// added by devendra on 29 sept 2010 end
	
	 //document.all.selectCCAFlag.disabled = "true";  commented by devendra on 28 sept 2010
    //document.all.selectStationComp.disabled = "true";  commented by devendra on 28 sept 2010
	// added by devendra on 28 sept 2010 start
	if(payRevFlag!=null && payRevFlag =='6')
	{
		document.all.selectCCAFlag.disabled = "true";  
		document.all.selectStationComp.disabled = "true";  
	}
	if(payRevFlag!=null && payRevFlag =='5')
	{
		document.all.selectCCAFlag.disabled = "";  
		document.all.selectStationComp.disabled = "";  
	}
	// added by devendra on 28 sept 2010 end
    
    
    hedMenuHandling(mode);    
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
       document.getElementById("txtDepuType").style.className="locked";           
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
    if (document.all.txtPFType.value=='PFTYPE$CPF' || document.all.txtPFType.value=="" || document.all.txtPFType.value=='')
    {        
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';
        //document.getElementById("vcpf").style.display='';
        //document.getElementById("vgpf").style.display='none';        
    }
    if (document.all.txtPFType.value=="PFTYPE$GPF")
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';           
        //document.getElementById("vgpf").style.display='';
        //document.getElementById("vcpf").style.display='none';           
    } 
}  

function onChangePFType(val)
{
    if (val=='PFTYPE$GPF')
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';
        document.getElementById("vgpf").style.display='';
        document.getElementById("vcpf").style.display='none';    
    }
    if (val=='PFTYPE$CPF')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';
        document.getElementById("vcpf").style.display='';
        document.getElementById("vgpf").style.display='none';
    } 
}


function lfnChange(val)
{
    if(num_Check(val,1)){
        frmDeptLabourInfoForm.headerDataChanged.value = "true";}
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
    frmDeptLabourInfoForm.action="../../../DeptLbrFlagAdminGetHeaderAction.do"
    frmDeptLabourInfoForm.submit();
}


function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.positionRequested.value + 1;
    frmDeptLabourInfoForm.action="../../../DeptLbrFlagAdminGetNextHeader.do";
    frmDeptLabourInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.positionRequested.value - 1;
    frmDeptLabourInfoForm.action = "../../../DeptLbrFlagAdminGetPrevHeader.do";
    frmDeptLabourInfoForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.newPositionRequested.value;
    frmDeptLabourInfoForm.action = "../../../DeptLbrFlagAdminGetNextHeader.do";
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
    frmDeptLabourInfoForm.action="../../../DeptLbrFlagAdminRefresh.do"
    frmDeptLabourInfoForm.submit();
}

function ShowLovStateCode()
{
    frmDeptLabourInfoForm.lovKey.value = "PayrollEmpMastStatecode" + frmDeptLabourInfoForm.screenName.value + "Q";
    frmDeptLabourInfoForm.txtDisplayFields.value = "txtStateCode,txtStateDesc";
    frmDeptLabourInfoForm.txtSearchFields.value = "Pay.proftax.statecode,pr.PayCode.description";
    frmDeptLabourInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
    frmDeptLabourInfoForm.headerDataChanged.value = "true";       
    return true;
}

function ShowEmpNum()
{
    frmDeptLabourInfoForm.lovKey.value = "EmpFinInfo" + frmDeptLabourInfoForm.screenName.value + frmDeptLabourInfoForm.screenMode.value;
    if(frmDeptLabourInfoForm.screenMode.value == 'N')
    {
        frmDeptLabourInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtGroup,txtCateg,txtDsgn,txtHandi,txtCurtBasic,txtlstPromDate, txtInrMon";
        frmDeptLabourInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
        frmDeptLabourInfoForm.txtIndex.value ="";      
    }
    if(frmDeptLabourInfoForm.screenMode.value == 'Q')
    {
        frmDeptLabourInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
        frmDeptLabourInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
        frmDeptLabourInfoForm.txtIndex.value ="";      
    }
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
    return true;
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
    saveCheckBox();
    if(flagMandatory_Check())
    {
      if(checkCurBasicLimit())
      {
        if(mandatory_Check("frmDeptLabourInfoForm"))
        {           
            frmDeptLabourInfoForm.detailDataChanged.value = "false";  
            if(frmDeptLabourInfoForm.screenMode.value == "N")
                frmDeptLabourInfoForm.headerDataChanged.value = "true";    
            frmDeptLabourInfoForm.headerFields.value = "true";           
            //saveCheckBox();
			//added by devendra on 28 sept 2010 start
			if(frmDeptLabourInfoForm.txtCurtBasic.value=="")
            {
                alert("Mandatory Field Current Basic in Payroll Details is Empty! ");
                return;
            }
			if(frmDeptLabourInfoForm.txtPayStatus.value=="")
            {
                alert("Mandatory Field Pay Status in Payroll Details is Empty! ");
                return;
            }
			if(frmDeptLabourInfoForm.txtPayMode.value=="")
            {
                alert("Mandatory Field Pay Mode in Payroll Details is Empty! ");
                return;
            }
			if(frmDeptLabourInfoForm.txtPayStsChnDate.value=="")
            {
                alert("Mandatory Field Pay Status Changed Date in Payroll Details is Empty! ");
                return;
            }
			if(frmDeptLabourInfoForm.txtInrSt.value=="")
            {
                alert("Mandatory Field Increment Status in Payroll Details is Empty! ");
                return;
            }
			if(frmDeptLabourInfoForm.txtMHSTyp.value=="")
            {
                alert("Mandatory Field MHS Member in Payroll Details is Empty! ");
                return;
            }
			// added by devendra on 28 sept 2010 end
            if(frmDeptLabourInfoForm.txtGender.value=="")
            {
                alert("Mandatory Field Gender in HRMS Details is Empty! ");
                return;
            }
            document.getElementById("txtPFType").disabled= "";
            //document.all.hdnCCAFlag.value='Y';         commented by devendra on 28 sept 2010
           document.all.hdnCCAFlag.value='';         //added by devendra on 21 sept 2010
			//document.all.hdnStationCompFlag.value=document.all.txtPayType.value=='IDA'? 'Y' : 'N';  commented by devendra on 21 sept 2010  
			document.all.hdnStationCompFlag.value='';       //added by devendra on 21 sept 2010     
            document.all.hdnPLIFlag.value=frmDeptLabourInfoForm.hdnBoardFlag.value=='N' ? 'Y' : 'N'; 
            
            document.all.txtCateg.disabled = "";
            document.all.txtDsgn.disabled = "";              
            document.all.txtEmpStatus.disabled='';
            document.all.parentZone.disabled='';
            //frmDeptLabourInfoForm.action = "../../../DeptLbrFlagSaveAction.do";             commented by devendra on 29 sept 2010
            frmDeptLabourInfoForm.action = "../../../DeptLbrFlagAdminSaveAction.do";             //added by devendra on 29 sept 2010
			frmDeptLabourInfoForm.submit();
        }
      }
    }
    else
    {
        return false;
    }
}

function flagMandatory_Check()
{
   
    if (frmDeptLabourInfoForm.selectPersPaySFN.value=='Y')
    {
        if (document.getElementById("txtPersPaySFNAmt").value ==" " || document.getElementById("txtPersPaySFNAmt").value =='')
        {
            alert("Personal Pay SFN Amount is Mandatory if Personal Pay SFN is Yes");            
            document.getElementById("txtPersPaySFNAmt").focus(); 
            return false;
        }
    }    
   
    if (frmDeptLabourInfoForm.selectSplCmpAllow.value=='Y')
    {
        if (document.getElementById("txtSplCmpAllowAmt").value ==" " || document.getElementById("txtSplCmpAllowAmt").value =='')
        {
            alert("Spl. Comp. Amount is Mandatory if Spl Comp. Allow. is Yes");            
            document.getElementById("txtSplCmpAllowAmt").focus();            
            return false;
        }
    }
    return true;
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

function saveCheckBox()
{ 
    document.all.hdnCantFlag.value=(document.getElementById("selectCant").checked==true ? 'Y' : 'N');
    document.all.hdnWashFlag.value=(document.getElementById("selectWash").checked==true ? 'Y' : 'N');
    document.all.hdnCCAFlag.value=(document.getElementById("selectCCAFlag").checked==true ? 'Y' : 'N');
    document.all.hdnPLIFlag.value=(document.getElementById("selectPLI").checked==true ? 'Y' : 'N');
    document.all.hdnConvFlag.value=(document.getElementById("selectConvFlag").checked==true ? 'Y' : 'N');
    document.all.hdnPersPaySFNFlag.value=(document.getElementById("selectPersPaySFN").checked==true ? 'Y' : 'N');
    document.all.hdnSplCmpAllowFlag.value=(document.getElementById("selectSplCmpAllow").checked==true ? 'Y' : 'N');
    //Added by Balpreet dt 27 May 08 for Stn Cmp Allow
    document.all.hdnStationCompFlag.value=(document.getElementById("selectStationComp").checked==true ? 'Y' : 'N');
    document.all.hdnSplDtyAllowFlag.value=(document.getElementById("selectSplDtyAllow").checked==true ? 'Y' : 'N');
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
        //document.getElementById("txtNoc").disabled = "true"; 
        document.getElementById("txtNoc").value = "";     
        document.getElementById("txtNoc").style.background="#e0e0e0";
        document.getElementById("txtNoc").style.className="locked";       
    }
}

String.prototype.endsWith = function(str) 
{return (this.match(str+"$")==str)}

//Function to enabled the control box if check box is selected
function cmnFlagTxtDisab(argFlag,argTxt)
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";    
    var arrArgTxt=argTxt.split(",");
    if (document.getElementById(argFlag).checked==true)
    {
        document.getElementById(argFlag).value="Y";        
        if(document.getElementById(argFlag).value=="Y")
        {
            for(i=0;i<arrArgTxt.length;i++)
            {
              if(arrArgTxt[i].endsWith('Till'))
              {
                document.getElementById(arrArgTxt[i]).disabled = "";
                document.getElementById(arrArgTxt[i]).style.background="#ffffff";
                document.getElementById(arrArgTxt[i]).style.className="optional"
              }else
              {
                document.getElementById(arrArgTxt[i]).disabled = "";
                document.getElementById(arrArgTxt[i]).style.background="#ffffd3";
                document.getElementById(arrArgTxt[i]).style.className="required"; 
              }
             }
        }
    }  
    else 
    {
        alert('object value is bieng set as N for :::'+document.getElementById(argFlag));
        document.getElementById(argFlag).value="N";
        for(i=0;i<arrArgTxt.length;i++)
        {
          alert('element is :::'+document.getElementById(arrArgTxt[i]));
		  document.getElementById(arrArgTxt[i]).disabled = "true";
          document.getElementById(arrArgTxt[i]).value = "";        
          document.getElementById(arrArgTxt[i]).style.background="#e0e0e0";
          document.getElementById(arrArgTxt[i]).style.className="locked"; 
        }
    }
}

//Function to enabled the control box and display LOV Image if check box is selected
function cmnFlagTxtImgDisab(argFlag,argTxt)
{       
    frmDeptLabourInfoForm.headerDataChanged.value = "true";    
    if (document.getElementById(argFlag).checked==true)
    {
        document.getElementById(argFlag).value="Y";        
        if(document.getElementById(argFlag).value=="Y")
        {
            document.getElementById(argTxt).disabled = "";
            document.getElementById("buttxtDblHraCity").disabled = "";            
            document.getElementById(argTxt).style.background="#ffffd3";
            document.getElementById(argTxt).style.className="required";       
        }
    }  
    else 
    {
        document.getElementById(argTxt).disabled = "true";
        document.getElementById("buttxtDblHraCity").disabled = "true";
        document.getElementById(argFlag).value="N";
        document.getElementById(argTxt).value = "";        
        document.getElementById(argTxt).style.background="#e0e0e0";
        document.getElementById(argTxt).style.className="locked"; 
    }
}

//Function to enabled the control box and date field if check box is selected
function advIncFlagTxtDisab(argFlag,argTxt,argDate)
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
    if (document.getElementById(argFlag).checked==true)
    {
        document.getElementById(argFlag).value="Y";        
        if(document.getElementById(argFlag).value=="Y")
        {
            document.getElementById(argTxt).disabled = "";
            document.getElementById(argTxt).style.background="#ffffd3";
            document.getElementById(argTxt).style.className="required";       
            document.getElementById(argDate).disabled = "";
            document.getElementById(argDate).style.background="#ffffd3";
            document.getElementById(argDate).style.className="required";
        }
    }  
    else 
    {
        document.getElementById(argFlag).value="N";        
        document.getElementById(argTxt).disabled = "true";
        document.getElementById(argTxt).value = "";
        document.getElementById(argTxt).style.background="#e0e0e0";
        document.getElementById(argTxt).style.className="locked";       
        document.getElementById(argDate).disabled = "true";
        document.getElementById(argDate).value = "";
        document.getElementById(argDate).style.background="#e0e0e0";
        document.getElementById(argDate).style.className="locked";
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

function checkPayMode()
{
    if (document.all.txtPayMode.value=="Q")
    {
        document.getElementById("txtPayModeType").disabled = "";
        document.getElementById("txtPayModeType").style.background="#ffffd3";
        document.getElementById("txtPayModeType").style.className="required";           
    }  
    else 
    {
        document.getElementById("txtPayModeType").disabled = "true";
        document.getElementById("txtPayModeType").style.background="#ffffff";
        document.getElementById("txtPayModeType").style.className="optional";           
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

function disAdvIncrCal(inputId, butId)
{  
 if(document.getElementById("selectAdvIncr").checked= "true");  
    showCalendar(inputId, butId);
 
}

function lfnChanged(val)
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
}

function doGetTab(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../DeptLbrFlagAdminTabAction.do";
    document.forms[0].submit(); 
}

function doGetTabs(arg)
{
    mode = document.all.screenMode.value;      
    if(mode == 'N' || mode == 'U')
    {
        saveCheckBox();
        if(flagMandatory_Check())
        {
           // if(mandatory_Check("frmDeptLabourInfoForm")) commented by devendra on 28 sept 2010
            {
                document.all.forwardedPage.value=arg;
                document.forms[0].action="../../../DeptLbrFlagAdminTabAction.do";
                document.forms[0].submit(); 
            }
        }
    }
    else
    {
      document.all.forwardedPage.value=arg;
      document.forms[0].action="../../../DeptLbrFlagAdminTabAction.do";
      document.forms[0].submit(); 
    }
}
