package FCIPAY.HRMS.DATAACCESSTIER.VO;

/*
 * Module:        DrcrtMastVo.java
 * Author:        Moon Nag Sarkar
 * Date Written:  03/09/2003
* Description:  This class is used to hold the values from the screen and also to
* populate values to the screen.This object will be passed across different classes 
* predominantly
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public class DrcrtMastVo 
{
   
     private long txtDrcrtID=0;
     private String txtDrcrt=null;
     private long txtDrcrtHead=0;
     private String lstDrcrt=null;
     private static ArrayList drcrtList=null;
     private String sAction=null;
     private  long lEmpno=0;
     private  long lLocCode=0;
    private long lstUnitId;
     public long getLEmpno(){return this.lEmpno;}
     public void setLEmpno(long newLEmpno){this.lEmpno = newLEmpno;}
     public long getLLocCode(){return lLocCode;}
     public void setLLocCode(long newLLocCode){lLocCode = newLLocCode;}
  public DrcrtMastVo()
  {
  }
  public long gettxtDrcrtID()
  {
    return this.txtDrcrtID;
  }
  public void settxtDrcrtID(long pltxtDrcrtID)
  {
      this.txtDrcrtID=pltxtDrcrtID ;
  }
  public ArrayList getDrcrtList()
  {
  return this.drcrtList;
  }
public void setDrcrtList(ArrayList oList)
  {
  this.drcrtList=oList;
  }
public String getlstDrcrt()
{
  return this.lstDrcrt;
}

public void setlstDrcrt(String plstDrcrt)
{
  this.lstDrcrt=plstDrcrt;
}

public String gettxtDrcrt()
{
    return this.txtDrcrt;
}
public void settxtDrcrt(String pstxtDrcrt)
{
      this.txtDrcrt=pstxtDrcrt;
}
 public long gettxtDrcrtHead()
{
    return this.txtDrcrtHead;
}
public void settxtDrcrtHead(long pltxtDrcrtHead)
{
    this.txtDrcrtHead=pltxtDrcrtHead ;
}

    public long getLstUnitId()
    {
        return lstUnitId;
    }

    public void setLstUnitId(long newLstUnitId)
    {
        lstUnitId = newLstUnitId;
    }

}