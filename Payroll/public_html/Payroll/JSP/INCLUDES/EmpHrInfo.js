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
    frmEmpFinInfoForm.action="../../../EmpFinHrFirstGetHeaderAction.do"
    frmEmpFinInfoForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpFinInfoForm.action="../../../EmpHrRefresh.do"
    frmEmpFinInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value + 1;
    frmEmpFinInfoForm.action="../../../EmpFinHrGetNextHeader.do";
    frmEmpFinInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value - 1;
    frmEmpFinInfoForm.action = "../../../EmpFinHrGetPrevHeader.do";
    frmEmpFinInfoForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.newPositionRequested.value;
    frmEmpFinInfoForm.action = "../../../EmpFinHrGetNextHeader.do";
    frmEmpFinInfoForm.submit();
}

function ShowLovStateCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastStatecode" + frmEmpFinInfoForm.screenName.value + "Q";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtStateCode";
    frmEmpFinInfoForm.txtSearchFields.value = "";
    frmEmpFinInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    return true;
}

function ShowLovBankCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastBankCode" + frmEmpFinInfoForm.screenName.value + "Q";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtBankCode";
    frmEmpFinInfoForm.txtSearchFields.value = "";
    frmEmpFinInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    return true;
}

function ShowLovBranchCode()
{
    frmEmpFinInfoForm.lovKey.value = "PayrollEmpMastBranchCode" + frmEmpFinInfoForm.screenName.value + "Q";
    frmEmpFinInfoForm.txtDisplayFields.value = "txtBranchCode";
    frmEmpFinInfoForm.txtSearchFields.value = "";
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
        frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtGroup,txtCateg,txtDsgn";
        //frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.Empno";
        frmEmpFinInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
        frmEmpFinInfoForm.txtIndex.value ="";      
    }
    if(frmEmpFinInfoForm.screenMode.value == 'Q')
    {
        frmEmpFinInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
        //frmEmpFinInfoForm.txtSearchFields.value = "Payroll.EmpInfo.Empno";
        frmEmpFinInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
        frmEmpFinInfoForm.txtIndex.value ="";      
    }
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpFinInfoForm');
    return true;
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmEmpFinInfoForm"))
    {     
        frmEmpFinInfoForm.detailDataChanged.value = "false";  
        if(frmEmpFinInfoForm.screenMode.value == "N")
        frmEmpFinInfoForm.headerDataChanged.value = "true";      
        frmEmpFinInfoForm.headerFields.value = "true";
        saveCheckBox();
        frmEmpFinInfoForm.action = "../../../EmpFinHrSaveAction.do";
        document.all.txtGroup.disabled = "";
        document.all.txtCateg.disabled = "";
        document.all.txtDsgn.disabled = "";      
        document.all.txtNoc.disabled = "";
        document.all.txtHosChld.disabled = "";
        document.all.txtCantRate.disabled = "";      
        document.all.selectDep.disabled="";        
        frmEmpFinInfoForm.submit();
    }
    else
    {
        return false;
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

function HandiDisab()
{    
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    var HandFlag = document.all('txtHandi').options[document.all('txtHandi').selectedIndex].value; 
    if (HandFlag=="Y")
    {        
        document.getElementById("txtHandiEffDate").disabled = "";
        document.getElementById("txtHandiEffDate").style.background="#ffffd3";
        document.getElementById("txtHandiEffDate").style.className="required";                   
    }  
    else 
    {
        document.getElementById("txtHandiEffDate").disabled = "true";
        document.getElementById("txtHandiEffDate").value = "";
        document.getElementById("txtHandiEffDate").style.background="#e0e0e0";
        document.getElementById("txtHandiEffDate").style.className="locked";           
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

function perCheck(val)
{
    if(num_Check(val,1))
    {
        var num = parseInt(val);
        if(num>=0 && num<=100)
            frmEmpFinInfoForm.headerDataChanged.value = "true";
        else 
        {
            alert("Value Should be between 0 and 100");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;
        }
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
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


 function doGetTab(arg)
 {
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpInfoHrTabAction.do";
    document.forms[0].submit(); 
 }


 function doGetTabs(arg)
 {
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpInfoFlagTabAction.do";
    document.forms[0].submit(); 
 }

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.action="../../../EmpFinHrQueryMode.do"
    frmEmpFinInfoForm.submit();
}
 

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.action="../../../EmpFinHrSNewMode.do"
    frmEmpFinInfoForm.submit();
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
