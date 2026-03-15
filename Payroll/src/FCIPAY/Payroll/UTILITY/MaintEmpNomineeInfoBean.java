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
public class MaintEmpNomineeInfoBean  extends PayrollBaseDetailBean implements Serializable 
{
    private String txtDepndntName = "";    
    private String txtDepndntAge = "";         
    private String txtDepndntRel = "";
    //private String txtYYMM="";
    //private String lstPayScaleType="";
    //private String txtDPRate="";
    //private String startField="";
    //private String endField="";
 
    //private String txtDAType="";
    public MaintEmpNomineeInfoBean()
    {
    }

    public MaintEmpNomineeInfoBean(String sDepndntName, String sDepndntAge,String sDepndntRel)
    {
        txtDepndntName = sDepndntName;
        txtDepndntAge = sDepndntAge;
        txtDepndntRel = sDepndntRel;       
    }

   
   
    public String gettxtDepndntName()
    {
        return txtDepndntName;
    }

    public void settxtDepndntName(String newtxtDepndntName)
    {
        txtDepndntName = newtxtDepndntName;
    }    

    public String gettxtDepndntAge()
    {
        return txtDepndntAge;
    }

    public void settxtDepndntAge(String newtxtDepndntAge)
    {
        txtDepndntAge = newtxtDepndntAge;
    }      

  public String gettxtDepndntRel()
  {
    return txtDepndntRel;
  }

  public void settxtDepndntRel(String newtxtDepndntRel)
  {
    txtDepndntRel = newtxtDepndntRel;
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

}