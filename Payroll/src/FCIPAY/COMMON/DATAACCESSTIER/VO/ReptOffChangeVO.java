package FCIPAY.COMMON.DATAACCESSTIER.VO;
import java.util.ArrayList;

public class ReptOffChangeVO 
{
    private String hdnAction="";
    private String hdnValue="";
    private String txtOpeningTime="";
    private String txtHidWhField="";
    private String txtIdLength="";
    private String txt_Id="";
    private String txt_Desc="";
    private String txtTable="";
    private String txt_AddCond="";
    private String hdnFlag="";
    private String txtExisEmployeeNo="";
    private String txtExisEmployeeName="";
    private String txtReptEmployeeNo="";
    private String txtReptEmployeeName="";
    private long LSiteID=0;
    private long LUserID=0;
    private int hdnCount=0;
    private ArrayList menuList=new ArrayList();
    
    public ReptOffChangeVO()
    {
    }

    public String getHdnAction()
    {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction)
    {
        hdnAction = newHdnAction;
    }

    public String getHdnValue()
    {
        return hdnValue;
    }

    public void setHdnValue(String newHdnValue)
    {
        hdnValue = newHdnValue;
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

    public String getHdnFlag()
    {
        return hdnFlag;
    }

    public void setHdnFlag(String newHdnFlag)
    {
        hdnFlag = newHdnFlag;
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

    public long getLSiteID()
    {
        return LSiteID;
    }

    public void setLSiteID(long newLSiteID)
    {
        LSiteID = newLSiteID;
    }

    public long getLUserID()
    {
        return LUserID;
    }

    public void setLUserID(long newLUserID)
    {
        LUserID = newLUserID;
    }

    public int getHdnCount()
    {
        return hdnCount;
    }

    public void setHdnCount(int newHdnCount)
    {
        hdnCount = newHdnCount;
    }

  public ArrayList getMenuList()
  {
    return menuList;
  }

  public void setMenuList(ArrayList newMenuList)
  {
    menuList = newMenuList;
  }
}