/*
 * Program Name : GroupMasterVO.java
 * Author       : Jegan.V
 * Date Written : 29/07/2004
 * Description  : This Vo gets all the values to be in the Group Master Creation form
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.VO;

import java.util.ArrayList;

public class UsrLocMastVO 
{
    private String hdnAction="";
    private int hdnRowCount=0;
    private long lstEmpNo=0;
    private String txtEmpName="";
    private long lstLocation=0;
    private String txtLocDesc="";
    private String lstStatus="";
    private String radSelect="";

    private ArrayList empList=new ArrayList();
    private ArrayList locList=new ArrayList();
    private ArrayList assignedList= new ArrayList();
    private long userEmpNo=0;
    private long userLocId=0;
    private long hdnUsrLocId=0;//Id for which the Record is already there in the table
    
    public String getHdnAction()
    {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction)
    {
        hdnAction = newHdnAction;
    }

    public int getHdnRowCount()
    {
        return hdnRowCount;
    }

    public void setHdnRowCount(int newHdnRowCount)
    {
        hdnRowCount = newHdnRowCount;
    }

    public long getLstEmpNo()
    {
        return lstEmpNo;
    }

    public void setLstEmpNo(long newLstEmpNo)
    {
        lstEmpNo = newLstEmpNo;
    }

    public String getTxtEmpName()
    {
        return txtEmpName;
    }

    public void setTxtEmpName(String newTxtEmpName)
    {
        txtEmpName = newTxtEmpName;
    }

    public long getLstLocation()
    {
        return lstLocation;
    }

    public void setLstLocation(long newLstLocation)
    {
        lstLocation = newLstLocation;
    }

    public String getTxtLocDesc()
    {
        return txtLocDesc;
    }

    public void setTxtLocDesc(String newTxtLocDesc)
    {
        txtLocDesc = newTxtLocDesc;
    }

    public String getLstStatus()
    {
        return lstStatus;
    }

    public void setLstStatus(String newLstStatus)
    {
        lstStatus = newLstStatus;
    }

    public ArrayList getAssignedList()
    {
        return assignedList;
    }

    public void setAssignedList(ArrayList newAssignedList)
    {
        assignedList = newAssignedList;
    }

    public ArrayList getEmpList()
    {
        return empList;
    }

    public void setEmpList(ArrayList newEmpList)
    {
        empList = newEmpList;
    }

    public ArrayList getLocList()
    {
        return locList;
    }

    public void setLocList(ArrayList newLocList)
    {
        locList = newLocList;
    }

    public String getRadSelect()
    {
        return radSelect;
    }

    public void setRadSelect(String newRadSelect)
    {
        radSelect = newRadSelect;
    }

    public long getUserEmpNo()
    {
        return userEmpNo;
    }

    public void setUserEmpNo(long newUserEmpNo)
    {
        userEmpNo = newUserEmpNo;
    }

    public long getUserLocId()
    {
        return userLocId;
    }

    public void setUserLocId(long newUserLocId)
    {
        userLocId = newUserLocId;
    }

    public long getHdnUsrLocId()
    {
        return hdnUsrLocId;
    }

    public void setHdnUsrLocId(long newHdnUsrLocId)
    {
        hdnUsrLocId = newHdnUsrLocId;
    }
}