package FCIPAY.HRMS.DATAACCESSTIER.VO;
/*
 * Module:        VenueMastVo.java
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
import java.lang.*;
import java.util.ArrayList;
public class VenueMastVo 
{
   private long txtVenue=0;
   private long txtUnitId=0;
   private String txtNearRailStn=null;
   private String txtBusStop=null;
   private String txtBusFrom=null;
   private int txtBusNo=0;
   private String sAction=null;
    private long lstVenue=0;
     private static ArrayList venueList=null;


private  long lEmpno=0;
    private  long lLocCode=0;

      public long getLEmpno(){return this.lEmpno;}
    public void setLEmpno(long newLEmpno){this.lEmpno = newLEmpno;}

    public long getLLocCode(){return lLocCode;}
    public void setLLocCode(long newLLocCode){lLocCode = newLLocCode;}






   public  VenueMastVo()
   {
   }
   
   


 public long gettxtVenue()
  {System.out.print("VO:"+this.txtVenue);
    return this.txtVenue;
  }
  public void settxtVenue(long pstxtVenue)
  {
     this.txtVenue=pstxtVenue;
    
  }
  public void settxtUnitId(long plUnitID){
    this.txtUnitId=plUnitID;
  }
  public long gettxtUnitId(){
    return this.txtUnitId;
  }

public ArrayList getVenueList()
  {
  return this.venueList;
  }
public void setVenueList(ArrayList oList)
{
  this.venueList=oList;
}

public long getlstVenue()
{
  return this.lstVenue;
   
}

public void setlstVenue(long plstVenue)
{
  this.lstVenue=plstVenue;
}



  public String gettxtNearRailStn()
  {
    return this.txtNearRailStn;
  }
  public void settxtNearRailStn(String pstxtNearRailStn)
  {
      this.txtNearRailStn=pstxtNearRailStn;
  }  



public String gettxtBusStop()
  {
    return this.txtBusStop;
  }
public void settxtBusStop(String pstxtBusStop)
  {
      this.txtBusStop=pstxtBusStop;
  }  


public String gettxtBusFrom()
  {
    return this.txtBusFrom;
  }
  public void settxtBusFrom(String pstxtBusFrom)
  {
      this.txtBusFrom=pstxtBusFrom;
  }  


public int gettxtBusNo()
  {
    return this.txtBusNo;
  }
  public void settxtBusNo(int pstxtBusNo)
  {
      this.txtBusNo=pstxtBusNo;
  }  

  
}