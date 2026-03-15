function lfnFlagLoad()
{
    mode = document.all.screenMode.value;      
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='U')
    {        
        document.all.txtCateg.disabled = "true";
        document.all.headerPrimaryKey.disabled = "true";          
    } 
    checkEmpType();
    checkPFType();       
    checkDepuType(); 
    document.all.selectPLI.disabled = "true";  
    document.all.selectNpa.disabled = "true";
    document.all.selectCant.disabled = "true";
    document.all.selectStationComp.disabled = "true";
    document.all.selectCCAFlag.disabled = "true";
    document.all.selectDustOpAllow.disabled = "true";
    hedMenuHandling(mode);    
}
function checkEmpType()
{
   if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DOTHRORG'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DTOORG')
   {
    document.all.parentZone.disabled="true";
    if(document.all.screenMode.value=='N')
      document.all.txtEmpStatus.value="EMPSTATUS$DEPU";
    document.all.txtEmpStatus.disabled="true";
   }
   else
   {
    if(document.all.screenMode.value=='N')
    {
      if(document.all.txtCateg.value!='EMPCTGRY$I')
        document.all.parentZone.disabled="";
      else
      {
        document.all.parentZone.value="0";
        document.all.parentZone.disabled="true";
      }
      document.all.txtEmpStatus.disabled="";
      document.getElementById("txtDepuType").disabled = "true";
    }
  }
}
function checkDepuType()
{
    if (document.all.txtEmpStatus.value=="EMPSTATUS$DEPU")
    {
      // document.getElementById("txtDepuType").disabled = "";
       document.getElementById("txtDepuType").style.background="#ffffd3";
       document.getElementById("txtDepuType").style.className="required";           
    }  
    else 
    {
     //  document.getElementById("txtDepuType").disabled = "true";
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
        frmEmpFinInfoForm.headerDataChanged.value = "true";}
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }    
}

function comboChange(val)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function doOnChangeCalendar(buttonName)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    document.all.txtEmpStatus.disabled='';    
    frmEmpFinInfoForm.action="../../../EmpFinFirstGetHeaderAction.do"
    frmEmpFinInfoForm.submit();
}


function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value + 1;
    frmEmpFinInfoForm.action="../../../EmpFinGetPrevHeader.do";
    frmEmpFinInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value - 1;
    frmEmpFinInfoForm.action = "../../../EmpFinGetNextHeader.do";
    frmEmpFinInfoForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.newPositionRequested.value;
    frmEmpFinInfoForm.action = "../../../EmpFinGetNextHeader.do";
    frmEmpFinInfoForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.action="../../../EmpFinNewMode.do"
    frmEmpFinInfoForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.action="../../../EmpFinQueryMode.do"
    frmEmpFinInfoForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpFinInfoForm.action="../../../EmpFlagRefresh.do"
    frmEmpFinInfoForm.submit();
}

function ShowLovStateCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastStatecode" + frmEmpFinInfoForm.screenName.value + "Q";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtStateCode,txtStateDesc";
    frmEmpFinInfoForm.txtSearchFields.value = "Pay.proftax.statecode,pr.PayCode.description";
    frmEmpFinInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    frmEmpFinInfoForm.headerDataChanged.value = "true";       
    return true;
}

function ShowEmpNum()
{
    frmEmpFinInfoForm.lovKey.value = "EmpFinInfo" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;
    if(frmEmpFinInfoForm.screenMode.value == 'N')
    {
        frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtGroup,txtCateg,txtDsgn,txtHandi,txtCurtBasic,txtlstPromDate, txtInrMon";
        frmEmpFinInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
        frmEmpFinInfoForm.txtIndex.value ="";      
    }
    if(frmEmpFinInfoForm.screenMode.value == 'Q')
    {
        frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
        frmEmpFinInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
        frmEmpFinInfoForm.txtIndex.value ="";      
    }
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    return true;
}

function SaveRecord()
{
    document.all.buttonFlag.value='';            
    saveCheckBox();
    if(flagMandatory_Check())
    {
        if(mandatory_Check("frmEmpFinInfoForm"))
        {           
            frmEmpFinInfoForm.detailDataChanged.value = "false";  
            if(frmEmpFinInfoForm.screenMode.value == "N")
                frmEmpFinInfoForm.headerDataChanged.value = "true";    
            frmEmpFinInfoForm.headerFields.value = "true";           
            //saveCheckBox(); 
            if(frmEmpFinInfoForm.txtGender.value=="")
            {
                alert("Mandatory Field Gender in HRMS Details is Empty! ");
                return;
            }
         /*   if(frmEmpFinInfoForm.txtHRAEffDate.value=="")
            {
              alert("Mandatory Field HRA Eff Date in HRMS Details is Empty! ");
              return;
            }*/
            document.all.txtCateg.disabled = "";
            document.all.txtDsgn.disabled = "";              
            document.all.txtEmpStatus.disabled='';
            document.all.txtDepuType.disabled="";
            document.all.parentZone.disabled='';
            frmEmpFinInfoForm.action = "../../../EmpFinSaveAction.do";            
            frmEmpFinInfoForm.submit();
        }
    }    
    else
    {
        return false;
    }
}

function flagMandatory_Check()
{
    if (frmEmpFinInfoForm.selectDblHraFlag.value=='Y')
    {
        if (document.getElementById("txtDblHraCity").value ==" " || document.getElementById("txtDblHraCity").value =='')
        {
            alert("Double Hra City is Mandatory if Double Hra is Yes");
            frmEmpFinInfoForm.txtDblHraCity.focus(); 
            return false;
        }
    }
    
    if (frmEmpFinInfoForm.selectSplPaySprt.value=='Y')
    {
        if (document.getElementById("txtSplPaySprtAmt").value ==" " || document.getElementById("txtSplPaySprtAmt").value =='')
        {
            alert("Spl. Sport Amount is Mandatory if Spl Sport Pay is Yes");
            document.getElementById("txtSplPaySprtAmt").focus(); 
            return false;
        }
    }
    
    if (frmEmpFinInfoForm.selectSplPayCshAllow.value=='Y')
    {
        if (document.getElementById("txtSplPayCshAllowAmt").value ==" " || document.getElementById("txtSplPayCshAllowAmt").value =='')
        {
            alert("Spl. Pay Cash Amount is Mandatory if Spl. Pay Cash is Yes");
            document.getElementById("txtSplPayCshAllowAmt").focus(); 
            return false;
        }
    }
    
    if (frmEmpFinInfoForm.selectPersPaySFN.value=='Y')
    {
        if (document.getElementById("txtPersPaySFNAmt").value ==" " || document.getElementById("txtPersPaySFNAmt").value =='')
        {
            alert("Personal Pay SFN Amount is Mandatory if Personal Pay SFN is Yes");            
            document.getElementById("txtPersPaySFNAmt").focus(); 
            return false;
        }
    }
    
    if (frmEmpFinInfoForm.selectPersPayHQua.value=='Y')
    {
        if (document.getElementById("txtPersPayHQuaAmt").value ==" " || document.getElementById("txtPersPayHQuaAmt").value =='')
        {
            alert("Personal Pay High Qual. Amount is Mandatory if Personal Pay High Qual. is Yes");
            document.getElementById("txtPersPayHQuaAmt").focus();            
            return false;
        }
    }
    
    if (frmEmpFinInfoForm.selectSplCmpAllow.value=='Y')
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

function saveCheckBox()
{   
    /*if (document.getElementById("selectHraFlag").checked==true)
    {        
        document.all.hdnHraFlag.value="Y";
    }
    else 
    {      
        document.all.hdnHraFlag.value="N";
    }*/
 
    if (document.getElementById("selectNpa").checked==true)
    {        
        document.all.hdnNpaFlag.value="Y";
    }
    else 
    {      
        document.all.hdnNpaFlag.value="N";
    }
 
    if (document.getElementById("selectCant").checked==true)
    {        
        document.all.hdnCantFlag.value="Y";
    }
    else 
    {      
        document.all.hdnCantFlag.value="N";
    }
 
    /*if (document.getElementById("selectDepu").checked==true)
    {        
        document.all.hdnDepuFlag.value="Y";
    }
    else 
    {      
        document.all.hdnDepuFlag.value="N";
    }*/
 
    if (document.getElementById("selectWash").checked==true)
    {        
        document.all.hdnWashFlag.value="Y";
    }
    else 
    {      
        document.all.hdnWashFlag.value="N";
    }
 
    if (document.getElementById("selectCCAFlag").checked==true)
    {        
        document.all.hdnCCAFlag.value="Y";
    }
    else 
    {      
        document.all.hdnCCAFlag.value="N";
    }   
    
    if (document.getElementById("selectPLI").checked==true)
    {        
        document.all.hdnPLIFlag.value="Y";        
    }
    else 
    {      
        document.all.hdnPLIFlag.value="N";
    }    
    
    if (document.getElementById("selectConvFlag").checked==true)
    {        
        document.all.hdnConvFlag.value="Y";
    }
    else 
    {      
        document.all.hdnConvFlag.value="N";
    }
    
    if (document.getElementById("selectDustOpAllow").checked==true)
    {        
        document.all.hdnDustOpAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnDustOpAllowFlag.value="N";
    }
    
    if (document.getElementById("selectStationComp").checked==true)
    {        
        document.all.hdnStationCompFlag.value="Y";
    }
    else 
    {      
        document.all.hdnStationCompFlag.value="N";
    }
    
    if (document.getElementById("selectDblHraFlag").checked==true)
    {        
        document.all.hdnDblHraFlag.value="Y";
    }
    else 
    {      
        document.all.hdnDblHraFlag.value="N";
    }
    
    if (document.getElementById("selectSplPaySprt").checked==true)
    {        
        document.all.hdnSplPaySprtFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplPaySprtFlag.value="N";
    }
    
    if (document.getElementById("selectSplPayCshAllow").checked==true)
    {        
        document.all.hdnSplPayCshAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplPayCshAllowFlag.value="N";
    }
    
    if (document.getElementById("selectPersPaySFN").checked==true)
    {        
        document.all.hdnPersPaySFNFlag.value="Y";
    }
    else 
    {      
        document.all.hdnPersPaySFNFlag.value="N";
    }
    
    if (document.getElementById("selectPersPayHQua").checked==true)
    {        
        document.all.hdnPersPayHQuaFlag.value="Y";
    }
    else 
    {      
        document.all.hdnPersPayHQuaFlag.value="N";
    }
    
    if (document.getElementById("selectSplCmpAllow").checked==true)
    {        
        document.all.hdnSplCmpAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplCmpAllowFlag.value="N";
    }
    
    /*if (document.getElementById("selectAdvIncr").checked==true)
    {        
        document.all.hdnAdvIncrFlag.value="Y";
    }
    else 
    {      
        document.all.hdnAdvIncrFlag.value="N";
    }*/
}

function disable()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
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

//Function to enabled the control box if check box is selected
function cmnFlagTxtDisab(argFlag,argTxt)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";    
    if (document.getElementById(argFlag).checked==true)
    {
        document.getElementById(argFlag).value="Y";        
        if(document.getElementById(argFlag).value=="Y")
        {
            document.getElementById(argTxt).disabled = "";
            document.getElementById(argTxt).style.background="#ffffd3";
            document.getElementById(argTxt).style.className="required";       
        }
    }  
    else 
    {
        document.getElementById(argTxt).disabled = "true";
        document.getElementById(argFlag).value="N";
        document.getElementById(argTxt).value = "";        
        document.getElementById(argTxt).style.background="#e0e0e0";
        document.getElementById(argTxt).style.className="locked"; 
    }
}

//Function to enabled the control box and display LOV Image if check box is selected
function cmnFlagTxtImgDisab(argFlag,argTxt)
{       
    frmEmpFinInfoForm.headerDataChanged.value = "true";    
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
    frmEmpFinInfoForm.headerDataChanged.value = "true";
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
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function doGetTab(arg)
{    
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpInfoPayTabAction.do";
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
            if(mandatory_Check("frmEmpFinInfoForm"))
            {
                document.all.forwardedPage.value=arg;
                document.forms[0].action="../../../EmpInfoPayTabAction.do";
                document.forms[0].submit(); 
            }
        }
    }
    else
    {
        document.all.forwardedPage.value=arg;
        document.forms[0].action="../../../EmpInfoPayTabAction.do";
        document.forms[0].submit(); 
    }
}
