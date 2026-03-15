package FCIPAY.HRMS.UTILITY;


 /*
   * Module:        UnitList.java
   * Author:        Moon Nag Sarkar
   * Date Written:  05-09-2003
  * Description:  Following method is used to set list object with values
  * Revision Log  (05/09/03 initials description)
  * --------------------------------------------------------
  * mm/dd/yy xxx  What you changed
  */


public class UnitList
{
    private String UCode=null;
    private long UId=0;
    private String UType=null;
    private String GCode=null; //Global Code
    private String GType=null; //Global Type
    private String CDesc=null ; //Code Desc
    public UnitList(long plUnitid,String psUnitCode)
    { 
        this.UId=plUnitid;
        this.UCode=psUnitCode;
    }
    public UnitList(long plUnitid,String psUnitCode,String psUnitType)
    { 
        this.UId=plUnitid;
        this.UCode=psUnitCode;
        this.UType=psUnitType;
    }

    public UnitList(String plGCode,String plGType,String plCDesc)
    {
        this.GCode=plGCode;
        this.GType=plGType;
        this.CDesc=plCDesc;
        System.out.println(plCDesc);
    }

    public UnitList(String plGCode,String plGType,String psUnitType,String plCDesc,String psUnitCode)
    {
        this.GCode=plGCode;
        this.GType=plGType;
        this.UType=psUnitType;
        this.CDesc=plCDesc;
        this.UCode=psUnitCode;
        System.out.println(plCDesc);
    }
  
    public void setUId(long plUnitId){this.UId=plUnitId;}
    public long getUId(){return this.UId;}

    public void setUCode(String psUnitCode){this.UCode=psUnitCode;}
    public String getUCode(){return this.UCode;}
    
    public void setUType(String psUnitType){this.UType=psUnitType;}
    public String getUType(){return this.UType;}  
    
  
    public void setGCode(String psGCode){this.GCode=psGCode;}
    public String getGCode(){return this.GCode;}
    
    public void setGType(String psGType){this.GType=psGType;}
    public String getGType(){return this.GType;}

    public void setCDesc(String psCDesc){this.CDesc=psCDesc;}
    public String getCDesc(){return this.CDesc;}
    
}