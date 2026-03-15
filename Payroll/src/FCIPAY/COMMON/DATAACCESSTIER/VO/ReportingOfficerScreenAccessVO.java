package FCIPAY.COMMON.DATAACCESSTIER.VO;
import java.util.ArrayList;

public class ReportingOfficerScreenAccessVO 
{
    private String txtExisEmployeeNo="";
    private String txtExisEmployeeName="";
    private String txtReptEmployeeNo="";
    private String txtReptEmployeeName="";
    private ArrayList empList=new ArrayList();
    private ArrayList moduleList=new ArrayList();
    private ArrayList headerList=new ArrayList();
    private String chkSelect="";
    private String hdnScreenId="";
    private String hdnCheck[]=null;
    private String lstModule="";
    private String lstHeader="";
    private ArrayList menuList= new ArrayList();
    private String hdnCount="0";
    private String hdnID="";
    private String descTable="0";
    private String SAction="";
    private String txtOpeningTime="";
    private String txtHidWhField="";
    private String txtIdLength="";
    private String txt_Id="";
    private String txt_Desc="";
    private String txtTable="";
    private String txt_AddCond="";
    private long LSiteID=0;
    private long newLSiteID=0;
    private long LUserID=0;
    private String hdnValue="";
    public ReportingOfficerScreenAccessVO()
    {
    }

    public String getTxtExisEmployeeNo()
    {
        return txtExisEmployeeNo;
    }

    public void setTxtExisEmployeeNo(String newTxtExisEmployeeNo)
    {
        txtExisEmployeeNo = newTxtExisEmployeeNo;
    }

    public String getTxtExisEmployeeName()
    {
        return txtExisEmployeeName;
    }

    public void setTxtExisEmployeeName(String newTxtExisEmployeeName)
    {
        txtExisEmployeeName = newTxtExisEmployeeName;
    }

    public String getTxtReptEmployeeNo()
    {
        return txtReptEmployeeNo;
    }

    public void setTxtReptEmployeeNo(String newTxtReptEmployeeNo)
    {
        txtReptEmployeeNo = newTxtReptEmployeeNo;
    }

    public String getTxtReptEmployeeName()
    {
        return txtReptEmployeeName;
    }

    public void setTxtReptEmployeeName(String newTxtReptEmployeeName)
    {
        txtReptEmployeeName = newTxtReptEmployeeName;
    }

     public ArrayList getEmpList()
    {
        return empList;
    }

    public void setEmpList(ArrayList newEmpList)
    {
        empList = newEmpList;
    }

    public ArrayList getModuleList()
    {
        return moduleList;
    }

    public void setModuleList(ArrayList newModuleList)
    {
        moduleList = newModuleList;
    }

    public ArrayList getHeaderList()
    {
        return headerList;
    }

    public void setHeaderList(ArrayList newHeaderList)
    {
        headerList = newHeaderList;
    }

    public String getChkSelect()
    {
        return chkSelect;
    }

    public void setChkSelect(String newChkSelect)
    {
        chkSelect = newChkSelect;
    }

    public String getHdnScreenId()
    {
        return hdnScreenId;
    }

    public void setHdnScreenId(String newHdnScreenId)
    {
        hdnScreenId = newHdnScreenId;
    }

    public String[] getHdnCheck()
    {
        return hdnCheck;
    }

    public void setHdnCheck(String[] newHdnCheck)
    {
        hdnCheck = newHdnCheck;
    }

    public String getLstModule()
    {
        return lstModule;
    }

    public void setLstModule(String newLstModule)
    {
        lstModule = newLstModule;
    }

    public String getLstHeader()
    {
        return lstHeader;
    }

    public void setLstHeader(String newLstHeader)
    {
        lstHeader = newLstHeader;
    }

    public ArrayList getMenuList()
    {
        return menuList;
    }

    public void setMenuList(ArrayList newMenuList)
    {
        menuList = newMenuList;
    }

    public String getHdnCount()
    {
        return hdnCount;
    }

    public void setHdnCount(String newHdnCount)
    {
        hdnCount = newHdnCount;
    }

    public String getHdnID()
    {
        return hdnID;
    }

    public void setHdnID(String newHdnID)
    {
        hdnID = newHdnID;
    }

    public String getDescTable()
    {
        return descTable;
    }

    public void setDescTable(String newDescTable)
    {
        descTable = newDescTable;
    }

    public String getSAction()
    {
        return SAction;
    }

    public void setSAction(String newSAction)
    {
        SAction = newSAction;
    }

    public String getTxtOpeningTime()
    {
        return txtOpeningTime;
    }

    public void setTxtOpeningTime(String newTxtOpeningTime)
    {
        txtOpeningTime = newTxtOpeningTime;
    }

    public String getTxtHidWhField()
    {
        return txtHidWhField;
    }

    public void setTxtHidWhField(String newTxtHidWhField)
    {
        txtHidWhField = newTxtHidWhField;
    }

    public String getTxtIdLength()
    {
        return txtIdLength;
    }

    public void setTxtIdLength(String newTxtIdLength)
    {
        txtIdLength = newTxtIdLength;
    }

    public String getTxt_Id()
    {
        return txt_Id;
    }

    public void setTxt_Id(String newTxt_Id)
    {
        txt_Id = newTxt_Id;
    }

    public String getTxt_Desc()
    {
        return txt_Desc;
    }

    public void setTxt_Desc(String newTxt_Desc)
    {
        txt_Desc = newTxt_Desc;
    }

    public String getTxtTable()
    {
        return txtTable;
    }

    public void setTxtTable(String newTxtTable)
    {
        txtTable = newTxtTable;
    }

    public String getTxt_AddCond()
    {
        return txt_AddCond;
    }

    public void setTxt_AddCond(String newTxt_AddCond)
    {
        txt_AddCond = newTxt_AddCond;
    }

    public long getLSiteID()
    {
        return LSiteID;
    }

    public void setLSiteID(long newLSiteID)
    {
        LSiteID = newLSiteID;
    }

    public long getNewLSiteID()
    {
        return newLSiteID;
    }

    public void setNewLSiteID(long newNewLSiteID)
    {
        newLSiteID = newNewLSiteID;
    }

    public long getLUserID()
    {
        return LUserID;
    }

    public void setLUserID(long newLUserID)
    {
        LUserID = newLUserID;
    }

    public String getHdnValue()
    {
        return hdnValue;
    }

    public void setHdnValue(String newHdnValue)
    {
        hdnValue = newHdnValue;
    }
}