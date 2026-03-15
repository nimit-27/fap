package FCIPAY.HRMS.WEBTIER.Form;

   /*
        * Module:        LeaveMastForm.java
        * Author:        Moon Nag Sarkar
        * Date Written:  3-12-2003
        * Description:  Following method is used to set Value object with form values
        * Revision Log  (3-12-2003 initials description)
        * --------------------------------------------------------
        * mm/dd/yy xxx  What you changed
    */

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.lang.*;

import FCIPAY.HRMS.DATAACCESSTIER.VO.LeaveMastVO;
import FCIPAY.HRMS.BUSINESSTIER.BusinessDelegates.LeaveMastBD;
import FCIPAY.HRMS.WEBTIER.Action.LeaveMastAction;
import FCIPAY.HRMS.UTILITY.DrcrtList;

public class LeaveMastForm extends ActionForm 
{
    private String txtID=null;
    private String txtSdesc=null;
    private String lstSdesc=null;
    private String txtLdesc=null;
    private String txtMax_Limit_1=null;
    private String txtMax_Limit_2=null;
    private String txtMax_Limit_3=null;
    private String lstDisplay=null;
    
    private String sAction=null;
    private String sMode=null;
   // private static ArrayList drcrtList=new ArrayList();
    private  ArrayList drcrtList=new ArrayList();
    private String txtMin_Exp_Req=null;
    private String lstMax_Limit_Freq=null;
    private String lstApply;
    
    
 /*   public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }
*/
  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
/*
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }
*/

  public String getsAction()
  {
    return this.sAction;
  }
  public void setsAction(String sAction)
  {
    this.sAction=sAction;
  }
  public String getsMode()
  {
    return this.sMode;
  }
  public void setsMode(String sMode)
  {
    this.sMode=sMode;
  }
    public String getTxtID()
    {
        return txtID;
    }

    public void setTxtID(String newTxtID)
    {
        txtID = newTxtID;
    }

    public String getTxtSdesc()
    {
        return txtSdesc;
    }

    public void setTxtSdesc(String newTxtSdesc)
    {
        txtSdesc = newTxtSdesc;
    }

     public ArrayList getDrcrtList()
      {
          return this.drcrtList;
      }
      public void setDrcrtList(ArrayList oList)
      {
         this.drcrtList=oList;
      }



    
    public String getLstSdesc()
    {
        return lstSdesc;
    }

    public void setLstSdesc(String newLstSdesc)
    {
        lstSdesc = newLstSdesc;
    }

    public String getTxtLdesc()
    {
        return txtLdesc;
    }

    public void setTxtLdesc(String newTxtLdesc)
    {
        txtLdesc = newTxtLdesc;
    }

    public String getTxtMax_Limit_1()
    {
        return txtMax_Limit_1;
    }

    public void setTxtMax_Limit_1(String newTxtMax_Limit_1)
    {
        txtMax_Limit_1 = newTxtMax_Limit_1;
    }

    public String getTxtMax_Limit_2()
    {
        return txtMax_Limit_2;
    }

    public void setTxtMax_Limit_2(String newTxtMax_Limit_2)
    {
        txtMax_Limit_2 = newTxtMax_Limit_2;
    }

    public String getTxtMax_Limit_3()
    {
        return txtMax_Limit_3;
    }

    public void setTxtMax_Limit_3(String newTxtMax_Limit_3)
    {
        txtMax_Limit_3 = newTxtMax_Limit_3;
    }

    public String getLstDisplay()
    {
        return lstDisplay;
    }

    public void setLstDisplay(String newLstDisplay)
    {
        lstDisplay = newLstDisplay;
    }

    
    public String getTxtMin_Exp_Req()
    {
        return txtMin_Exp_Req;
    }

    public void setTxtMin_Exp_Req(String newTxtMin_Exp_Req)
    {
        txtMin_Exp_Req = newTxtMin_Exp_Req;
    }

    public String getLstMax_Limit_Freq()
    {
        return lstMax_Limit_Freq;
    }

    public void setLstMax_Limit_Freq(String newLstMax_Limit_Freq)
    {
        lstMax_Limit_Freq = newLstMax_Limit_Freq;
    }


    public LeaveMastVO createVO()
    {
        LeaveMastVO oLeaveMastVO = new LeaveMastVO();
        try
        {
             if(this.lstSdesc.equals(""))
                oLeaveMastVO.setSLEAVE_ID(0);
            else
                oLeaveMastVO.setSLEAVE_ID(Long.parseLong(this.lstSdesc));


            oLeaveMastVO.setMAX_LIMIT_FREQ(this.getLstMax_Limit_Freq());
            oLeaveMastVO.setSLEAVE_LDESC(this.txtLdesc);
            oLeaveMastVO.setSLEAVE_SDESC(this.txtSdesc);
            if(this.txtMax_Limit_1.equals(""))
                oLeaveMastVO.setSMAX_LIMIT_1(0);
            else
                oLeaveMastVO.setSMAX_LIMIT_1(Long.parseLong(this.txtMax_Limit_1));


             if(this.txtMax_Limit_2.equals(""))
                oLeaveMastVO.setSMAX_LIMIT_2(0);
            else
                oLeaveMastVO.setSMAX_LIMIT_2(Long.parseLong(this.txtMax_Limit_2));


             if(this.txtMax_Limit_3.equals(""))
                oLeaveMastVO.setSMAX_LIMIT_3(0);
            else
                oLeaveMastVO.setSMAX_LIMIT_3(Long.parseLong(this.txtMax_Limit_3));

             if(this.txtMin_Exp_Req.equals(""))
                oLeaveMastVO.setSMIN_EXP_REQ(0);
            else
               oLeaveMastVO.setSMIN_EXP_REQ(Long.parseLong(this.txtMin_Exp_Req));
            oLeaveMastVO.setSDISPLAY_FLG(this.lstDisplay);
            oLeaveMastVO.setlstApply(this.lstApply);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
        return oLeaveMastVO;
    }

     public LeaveMastForm()
     {
        drcrtList=new ArrayList();
        drcrtList.add(new DrcrtList(0,"Please Select"));
     }

    public String getlstApply()
    {
        return lstApply;
    }

    public void setlstApply(String newLstApply)
    {
        lstApply = newLstApply;
    }

    
}