function lfnLoad()
{
    mode = document.all.screenMode.value;
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='U')
    {
        document.all.txtGroup.disabled = "true";
        document.all.txtCateg.disabled = "true";
        document.all.txtDsgn.disabled = "true";      
        document.all.headerPrimaryKey.disabled = "true";          
    }
    checkPayMode();   
    hedMenuHandling(mode);
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmEmpFinInfoForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function lfnChangeNegNum(val)
{
    if(NegNum_Check(val,1))
    { 
        frmEmpFinInfoForm.headerDataChanged.value = "true";
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
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function doOnChangeCalendar(buttonName)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.action="../../../EmpFinFirstGetHeaderAction.do"
    frmEmpFinInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value + 1;
    frmEmpFinInfoForm.action="../../../EmpFinGetNextHeader.do";
    frmEmpFinInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value - 1;
    frmEmpFinInfoForm.action = "../../../EmpFinGetPrevHeader.do";
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
    frmEmpFinInfoForm.action="../../../EmpFinNewMode.do"
    frmEmpFinInfoForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.action="../../../EmpFinQueryMode.do"
    frmEmpFinInfoForm.submit();
}
function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpFinInfoForm.action="/EmpFinRefresh.do"
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

function ShowLovBankCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastBankCode" + frmEmpFinInfoForm.screenName.value + "Q";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtBankCode";
    frmEmpFinInfoForm.txtSearchFields.value = "";
    frmEmpFinInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    return true;
}

function ShowLovBranchCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastBranchCode" + frmEmpFinInfoForm.screenName.value + "Q";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtBranchCode";
    frmEmpFinInfoForm.txtSearchFields.value = "";
    frmEmpFinInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
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
    if (frmEmpFinInfoForm.txtPayMode.value == 'B')
    {
        if (frmEmpFinInfoForm.txtBankCode.value == '')
        {
            alert("Bank Code is Mandatory if Payment Mode is Bank");
            frmEmpFinInfoForm.txtBankCode.focus(); 
            return false;
        }
        if (frmEmpFinInfoForm.txtBranchCode.value == '')
        {
            alert("Branch Code is Mandatory if Payment Mode is Bank");
            frmEmpFinInfoForm.txtBranchCode.focus(); 
            return false;
        }    
        if (frmEmpFinInfoForm.txtBank.value == '')
        {
            alert("Bank Account Number is Mandatory if Payment Mode is Bank");
            frmEmpFinInfoForm.txtBank.focus(); 
            return false;
        }        
    }
    
    if(mandatory_Check("frmEmpFinInfoForm"))
    {     
        frmEmpFinInfoForm.txtEmpNo.value=frmEmpFinInfoForm.headerPrimaryKey.value; 
        if (frmEmpFinInfoForm.txtPayMode.value == "C")
        {
            frmEmpFinInfoForm.txtPayModeType.value=" ";  
        }
        if (frmEmpFinInfoForm.txtPayMode.value == "B")    
        {
            frmEmpFinInfoForm.txtPayModeType.value=" ";  
        }       
        
        frmEmpFinInfoForm.detailDataChanged.value = "false";  
        if(frmEmpFinInfoForm.screenMode.value == "N")
        frmEmpFinInfoForm.headerDataChanged.value = "true";    
        frmEmpFinInfoForm.headerFields.value = "true";
        saveCheckBox();
        frmEmpFinInfoForm.action = "../../../EmpFinSaveAction.do";
        document.all.txtGroup.disabled = "";
        document.all.txtCateg.disabled = "";
        document.all.txtDsgn.disabled = "";      
        document.all.txtNoc.disabled = "";
        document.all.txtHosChld.disabled = "";
        document.all.txtCantRate.disabled = "";      
        document.all.txtGisType.disabled = "";          
        document.all.selectDep.disabled="";
        frmEmpFinInfoForm.submit();
    }
    else
    {
        return false;
    }
}

function saveCheckBox()
{ 
    if (document.all.selectHrr.value == "true")
    {
        document.all.hdnHrrFlag.value="Y";
    }
    else 
    {
        document.all.hdnHrrFlag.value="N";
    }
    
    if (document.all.selectVeh.value == "true")
    {
        document.all.hdnBoardFlag.value="Y";
    }
    else 
    {
        document.all.hdnBoardFlag.value="N";
    }

    if (document.all.selectIT.value == "true")
    {
        document.all.hdnITFlag.value="Y";
    }
    else 
    {
        document.all.hdnITFlag.value="N";
    }

    if (document.all.selectOut.value == "true")
    {
        document.all.hdnOutFlag.value="Y";
    }
    else 
    {
        document.all.hdnOutFlag.value="N";
    }

    if (document.all.selectDep.value == "true")
    {
        document.all.hdnDepuFlag.value="Y";
    }
    else 
    {
        document.all.hdnDepuFlag.value="N";
    }

    if (document.all.selectProj.value == "true")
    {
        document.all.hdnProjFalg.value="Y";
    }
    else 
    {
        document.all.hdnProjFalg.value="N";
    }
    
    if (document.all.selectUp.value == "true")
    {
        document.all.hdnUpGradeFlag.value="Y";
    }
    else 
    {
        document.all.hdnUpGradeFlag.value="N";
    }

    if (document.all.selectCycle.value == "true")
    {
        document.all.hdnCycleFlag.value="Y";
    }
    else 
    {
        document.all.hdnCycleFlag.value="N";
    }

    if (document.all.selectCharge.value == "true")
    {
        document.all.hdnChargeFlag.value="Y";
    }
    else 
    {
        document.all.hdnChargeFlag.value="N";
    }

    if (document.all.selectNurse.value == "true")
    {
        document.all.hdnNurseFalg.value="Y";
    }
    else 
    {
    document.all.hdnNurseFalg.value="N";
    }

    if (document.all.selectSpl.value == "true")
    {
        document.all.hdnSplFlag.value="Y";
    }
    else 
    {
        document.all.hdnSplFlag.value="N";
    }

    if (document.all.selectWash.value == "true")
    {
        document.all.hdnWashFlag.value="Y";
    }
    else 
    {
        document.all.hdnWashFlag.value="N";
    }

    if (document.all.selectCant.value == "true")
    {
        document.all.hdnCantFlag.value="Y";
    }
    else 
    {
        document.all.hdnCantFlag.value="N";
    }

    if (document.all.selectChEdAl.value == "true")
    {
        document.all.hdnChEduFlag.value="Y";
    }
    else 
    {
        document.all.hdnChEduFlag.value="N";
    }

    if (document.all.selectHos.value == "true")
    {
        document.all.hdnHosFlag.value="Y";
    }
    else 
    {
        document.all.hdnHosFlag.value="N";
    }

    if (document.all.selectQualIncentFlag.value == "true")
    {
        document.all.hdnQualIncentFlag.value="Y";
    }
    else 
    {
        document.all.hdnQualIncentFlag.value="N";
    }

    if (document.all.selectCableTVFlag.value == "true")
    {
        document.all.hdnCableTVFlag.value="Y";
    }
    else 
    {
        document.all.hdnCableTVFlag.value="N";
    }

    if (document.all.selectCCAFlag.value == "true")
    {
        document.all.hdnCCAFlag.value="Y";
    }
    else 
    {
        document.all.hdnCCAFlag.value="N";
    }

    if (document.all.selectGisRec.checked)
    {
        document.all.hdnGisRec.value="Y";
    }
    else 
    {
        document.all.hdnGisRec.value="N";
    }

    if (document.all.selectUni.value == "true")
    {
        document.all.hdnUniFlag.value="Y";
    }
    else 
    {
        document.all.hdnUniFlag.value="N";
    }

    if (document.all.selectNpa.value == "true")
    {
        document.all.hdnNpaFlag.value="Y";
    }
    else 
    {
        document.all.hdnNpaFlag.value="N";
    }

    if (document.all.selectConvFlag.value == "true")
    {
        document.all.hdnConvFlag.value="Y";
    }
    else 
    {
        document.all.hdnConvFlag.value="N";
    }


    if (document.all.selectDblConvFlag.value == "true")
    {
        document.all.hdnDblConvFlag.value="Y";
    }
    else 
    {
        document.all.hdnDblConvFlag.value="N";
    }

    if (document.all.selectNewspaperFlag.value == "true")
    {
        document.all.hdnNewspaperFlag.value="Y";
    }
    else 
    {
        document.all.hdnNewspaperFlag.value="N";
    }  

    if (document.all.selectElectReimbFlag.value == "true")
    {
        document.all.hdnElecReimbFlag.value="Y";
    }
    else 
    {
        document.all.hdnElecReimbFlag.value="N";
    }

    if (document.all.selectHraFlag.value == "true")
    {
        document.all.hdnHraFlag.value="Y";
    }
    else 
    {
        document.all.hdnHraFlag.value="N";
    }
    
    if (document.all.selectChssFlag.value == "true")
    {
        document.all.hdnChssFlag.value="Y";
    }
    else 
    {
        document.all.hdnChssFlag.value="N";
    }

    if (document.all.selectStfClbRecFlag.value == "true")
    {
        document.all.hdnStfClbRecFlag.value="Y";
    }
    else 
    {
        document.all.hdnStfClbRecFlag.value="N";
    }
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
        document.getElementById("txtNoc").disabled = "true"; 
        document.getElementById("txtNoc").value = "";     
        document.getElementById("txtNoc").style.background="#e0e0e0";
        document.getElementById("txtNoc").style.className="locked";       
    }
}

function HosDisab()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
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
    frmEmpFinInfoForm.headerDataChanged.value = "true";
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
    frmEmpFinInfoForm.headerDataChanged.value = "true";
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

function ShowLovDsgn()
{
    frmEmpFinInfoForm.lovKey.value = "EmpInfoDsgn" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;
    frmEmpFinInfoForm.txtDisplayFields.value = "txtDsgn";
    frmEmpFinInfoForm.txtSearchFields.value = "";
    frmEmpFinInfoForm.txtIndex.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    return true;
}

function checkPayMode()
{
    if (document.all.txtPayMode.value=="O")
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

function doGetTab(arg)
{  
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpInfoPayTabAction.do";
    document.forms[0].submit(); 
}


function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpInfoFlagTabAction.do";
    document.forms[0].submit(); 
}

function ShowLovPayScaleCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastPayScaleCode" + frmEmpFinInfoForm.screenName.value + "Q";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtGroupPayScale";
    frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.pcode";
    frmEmpFinInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    frmEmpFinInfoForm.headerDataChanged.value = "true";       
    return true;
} 
// Added on 17 Aug 2007 by Aqeel

function ShowLovPayScaleCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastPayScaleCode" + frmEmpFinInfoForm.screenName.value + "Q";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtGroupPayScale";
    frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.pcode";
    frmEmpFinInfoForm.txtIndex.value="";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    frmEmpFinInfoForm.headerDataChanged.value = "true";       
    return true;
} 
function ShowLovDsgn()
{
   frmEmpFinInfoForm.lovKey.value = "EmpInfoDsgn" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;
   frmEmpFinInfoForm.txtDisplayFields.value = "txtDsgn";
   frmEmpFinInfoForm.txtSearchFields.value = "";
   frmEmpFinInfoForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   return true;
}

function ShowLovEmpType()
{
   frmEmpFinInfoForm.lovKey.value = "EmpInfoEmpType" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;
   frmEmpFinInfoForm.txtDisplayFields.value = "txtEmpType";
   frmEmpFinInfoForm.txtSearchFields.value = "";
   frmEmpFinInfoForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   return true;
}

function ShowLovEmpLoc()
{
   frmEmpFinInfoForm.lovKey.value = "EmpInfoEmpLoc" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value;
   frmEmpFinInfoForm.txtDisplayFields.value = "txtPresentPOP";
   frmEmpFinInfoForm.txtSearchFields.value = "";
   frmEmpFinInfoForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
   return true;
}

function ShowEmpNum()
{
   frmEmpFinInfoForm.lovKey.value = "EmpFinInfo" + frmEmpFinInfoForm.screenName.value + frmEmpFinInfoForm.screenMode.value; 
   if(frmEmpFinInfoForm.screenMode.value == 'N')
   {
//     frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,lstGroup,lstCateg,txtDsgn,txtHandi,txtCurtBasic,txtlstPromDate, txtInrMon";
       frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
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

    function ShowLovStateCode()
    {
       frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastStatecode" + frmEmpFinInfoForm.screenName.value + "Q";
       frmEmpFinInfoForm.txtDisplayFields.value = "txtStateCode,txtStateCodeDesc";
       frmEmpFinInfoForm.txtSearchFields.value = "Pay.proftax.statecode,pr.PayCode.description";
       frmEmpFinInfoForm.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
       frmEmpFinInfoForm.headerDataChanged.value = "true";       
       return true;
    }

    function ShowLovCityCode()
    {
       frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastCityCode" + frmEmpFinInfoForm.screenName.value + "U";
       frmEmpFinInfoForm.txtDisplayFields.value = "txtCityType";
       frmEmpFinInfoForm.txtSearchFields.value = "";
       frmEmpFinInfoForm.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
       frmEmpFinInfoForm.headerDataChanged.value = "true";       
       return true;
    }

    function ShowLovHraCityCode()
    {
       frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastHraCityCode" + frmEmpFinInfoForm.screenName.value + "U";
       frmEmpFinInfoForm.txtDisplayFields.value = "txtCityTypeHra";
       frmEmpFinInfoForm.txtSearchFields.value = "";
       frmEmpFinInfoForm.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
       frmEmpFinInfoForm.headerDataChanged.value = "true";       
       return true;
    }    
    
function checkPayMode()
{
    if (document.all.txtPayMode.value=="O")
    {
       document.getElementById("txtPayModeType").disabled = "";
       document.getElementById("txtPayModeType").style.background="#ffffd3";
       document.getElementById("txtPayModeType").style.className="required";           
    }  
    else 
    {
       document.getElementById("txtPayModeType").disabled = "true";
       document.getElementById("txtPayModeType").value = "";
       document.getElementById("txtPayModeType").style.background="#ffffff";
       document.getElementById("txtPayModeType").style.className="optional";           
    }
}
    function ShowLovBankCode()
    {
       frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastBankCode" + frmEmpFinInfoForm.screenName.value + "Q";
       frmEmpFinInfoForm.txtDisplayFields.value = "txtBankCode,hdnBankDesc";
       frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.BankCode,Payroll.Common.desc";
       frmEmpFinInfoForm.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
       frmEmpFinInfoForm.headerDataChanged.value = "true";
       return true;
    }

    function ShowLovBranchCode()
    {
       frmEmpFinInfoForm.queryParam.value="txtBankCode="+ frmEmpFinInfoForm.txtBankCode.value +" " ;    
       frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastBranchCode" + frmEmpFinInfoForm.screenName.value + "Q";
       frmEmpFinInfoForm.txtDisplayFields.value = "txtBranchCode,hdnBranchDesc";
       frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.BranchCode,Payroll.Common.desc";
       frmEmpFinInfoForm.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
       frmEmpFinInfoForm.headerDataChanged.value = "true";
       return true;
    }    
