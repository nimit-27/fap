package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EnqPayImageQueryVO extends PayrollBaseQueryVO implements Serializable
{   
  private String lstGroup;
  private String txtDesig;
  private String lstCateg;
  private String txtEmpNo;
  private String txtrs1;
  private String txtrs2;
  private String txtYtm;
  private ArrayList valueGroupArrayList;
  private ArrayList valueCategArrayList;
  private String txtGang;
  private String txtGangId;
  private String txtUptoYYMM;
  
  public EnqPayImageQueryVO()
  {
  }  



  public String getLstGroup()
  {
    return lstGroup;
  }

  public void setLstGroup(String newLstGroup)
  {
    lstGroup = newLstGroup;
  }

  public String getTxtDesig()
  {
    return txtDesig;
  }

  public void setTxtDesig(String newTxtDesig)
  {
    txtDesig = newTxtDesig;
  }

  public String getLstCateg()
  {
    return lstCateg;
  }

  public void setLstCateg(String newLstCateg)
  {
    lstCateg = newLstCateg;
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtrs1()
  {
    return txtrs1;
  }

  public void setTxtrs1(String newTxtrs1)
  {
    txtrs1 = newTxtrs1;
  }

  public String getTxtrs2()
  {
    return txtrs2;
  }

  public void setTxtrs2(String newTxtrs2)
  {
    txtrs2 = newTxtrs2;
  }

  public String getTxtYtm()
  {
    return txtYtm;
  }

  public void setTxtYtm(String newTxtYtm)
  {
    txtYtm = newTxtYtm;
  }



  public ArrayList getValueGroupArrayList()
  {
    return valueGroupArrayList;
  }

  public void setValueGroupArrayList(ArrayList newValueGroupArrayList)
  {
    valueGroupArrayList = newValueGroupArrayList;
  }



  public ArrayList getValueCategArrayList()
  {
    return valueCategArrayList;
  }

  public void setValueCategArrayList(ArrayList newValueCategArrayList)
  {
    valueCategArrayList = newValueCategArrayList;
  }

  public String getTxtGang()
  {
    return txtGang;
  }

  public void setTxtGang(String newTxtGang)
  {
    txtGang = newTxtGang;
  }
    
  public String getTxtGangId()
  {
    return txtGangId;
  }

  public void setTxtGangId(String newTxtGangId)
  {
    txtGangId = newTxtGangId;
  }

    public void setTxtUptoYYMM(String txtUptoYYMM) {
        this.txtUptoYYMM = txtUptoYYMM;
    }

    public String getTxtUptoYYMM() {
        return txtUptoYYMM;
    }
}
