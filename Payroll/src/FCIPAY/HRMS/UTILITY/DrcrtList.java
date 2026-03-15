package FCIPAY.HRMS.UTILITY;



 /*
   * Module:        DrcrtList.java
   * Author:        Moon Nag Sarkar
   * Date Written:  05-09-2003
  * Description:  Following method is used to set list object with values
  * Revision Log  (05/09/03 initials description)
  * --------------------------------------------------------
  * mm/dd/yy xxx  What you changed
  */



public class DrcrtList
{
  private String DName=null;
  private long DId=0;
  private long NID=0; 
  private long GId=0;
  
  private String NName=null;
 private String GName=null;
  private String ApStat=null;
    private long lstQual;
    private String occupation=null;
    private String activity;
    private String achievement;

    public DrcrtList(long rad,String Name,String Relation,long GId,long Qual,String Occ,String act,String ach)
    {
        this.DId=rad;
        this.GName=Name;
        this.DName=Relation;
        this.GId=GId;
        this.lstQual=Qual;
        this.occupation=Occ;
        this.activity=act;
        this.achievement=ach;
    }

  public DrcrtList(String plDrcrtid)
  { 
    this.NName=plDrcrtid;
    this.GName=this.NName;
    
  }

 public DrcrtList(String psDrcrtid,String psDrcrtName)
  { 
    this.GName=psDrcrtid;
    this.DName=psDrcrtName;
      
  }
  public DrcrtList(long plDrcrtid,String psDrcrtName)
  { 
    this.DId=plDrcrtid;
    this.DName=psDrcrtName;
      
  }

     public DrcrtList(long plDID,String psDName,long plNID,String psNName)
  { 
    this.DId=plDID;
    this.DName=psDName;
    this.NID=plNID;
    this.NName=psNName;
      
  }

   public DrcrtList(long plDrcrtid,String psDrcrtName,String psLveStatus,String psApStat)
  { 
    this.DId=plDrcrtid;
    this.DName=psDrcrtName;
    this.NName=psLveStatus;
    this.ApStat=psApStat;   
  }

    public DrcrtList(long plDrcrtid,String psDrcrtName,String psType)
  { 
    this.DName=psDrcrtName;//GId
    this.DId=plDrcrtid;
    this.GName=psType;
      
  }



  public void setNID(long plDrcrtId)
  { this.NID=plDrcrtId; }
  
  public long getNID(){ return this.NID;}
  
  public void setNName(String psDrcrtName){ this.NName=psDrcrtName; }

  public String getNName(){return this.NName;}


  public void setDId(long plDrcrtId){ this.DId=plDrcrtId;}
  
  public long getDId(){ return this.DId;}
  
  public void setDName(String psDrcrtName){this.DName=psDrcrtName;}

  public String getDName(){ return this.DName;}



  public void setGId(long plGrcrtId){ this.GId=plGrcrtId;}
  
  public long getGId(){ return this.GId;}
  
  public void setGName(String psGrcrtName){this.GName=psGrcrtName;}

  public String getGName(){ return this.GName;}


  

   public String getApStat()
   {
      return  this.ApStat;
   }

   public void setApStat(String newApStat)
   {
      this.ApStat = newApStat;
   }

    public long getLstQual()
    {
        return lstQual;
    }

    public void setLstQual(long newLstQual)
    {
        lstQual = newLstQual;
    }



    public String getOccupation()
    {
        return occupation;
    }

    public void setOccupation(String newOccupation)
    {
        occupation = newOccupation;
    }

    public String getActivity()
    {
        return activity;
    }

    public void setActivity(String newActivity)
    {
        activity = newActivity;
    }

    public String getAchievement()
    {
        return achievement;
    }

    public void setAchievement(String newAchievement)
    {
        achievement = newAchievement;
    }







  
}