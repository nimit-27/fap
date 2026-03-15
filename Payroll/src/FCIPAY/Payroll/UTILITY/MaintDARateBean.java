    /*
    * Module:        MaintDARateBean.java
    * Author:        Surajeet Chakraborty
    * Date Written:  December 2004
    * Description:   Bean Class for Maintaining the Pay Codes
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
public class MaintDARateBean  extends PayrollBaseDetailBean implements Serializable 
{
    private String txtDaRate = "";    
    private String txtDaMinimum = "";         
    private String txtSrlNo = "";
    //private String txtYYMM="";
    //private String lstPayScaleType="";
    private String txtDPRate="";
  private String startField="";
  private String endField="";
 
    //private String txtDAType="";
    public MaintDARateBean()
    {
    }

    public MaintDARateBean(String srlno, String sLowBasic,String sHighBasic,String sDaRate,String sDaMinimum,String sDPRate)
    {
        txtSrlNo = srlno;
        startField = sLowBasic;
        endField = sHighBasic;
        txtDaRate = sDaRate;
        txtDaMinimum = sDaMinimum;       
        //txtYYMM=sYYMM;
        //txtDAType=sDAType;
        txtDPRate=sDPRate;
    }

   
   
    public String gettxtDaRate()
    {
        return txtDaRate;
    }

    public void settxtDaRate(String newtxtDaRate)
    {
        txtDaRate = newtxtDaRate;
    }    

    public String gettxtDaMinimum()
    {
        return txtDaMinimum;
    }

    public void settxtDaMinimum(String newtxtDaMinimum)
    {
        txtDaMinimum = newtxtDaMinimum;
    }      

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }
   /*  public String getTxtYYMM()
  {
    return txtYYMM;
  }

public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getLstPayScaleType()
  {
    return lstPayScaleType;
  }

  public void setLstPayScaleType(String newLstPayScaleType)
  {
    lstPayScaleType = newLstPayScaleType;
  }*/    

  public String getTxtDPRate()
  {
    return txtDPRate;
  }

  public void setTxtDPRate(String newTxtDPRate)
  {
    txtDPRate = newTxtDPRate;
  }

  public String getStartField()
  {
    return startField;
  }

  public void setStartField(String newStartField)
  {
    startField = newStartField;
  }

  public String getEndField()
  {
    return endField;
  }

  public void setEndField(String newEndField)
  {
    endField = newEndField;
  }

  
  /*public String getTxtDAType()
  {
    return txtDAType;
  }

  public void setTxtDAType(String newTxtDAType)
  {
    txtDAType = newTxtDAType;
  }*/

}