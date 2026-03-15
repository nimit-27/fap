package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EmpFinanceComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valueCategArrayList;
  private ArrayList valueCadreArrayList;
  private ArrayList valuePFTypeArrayList;
  private ArrayList valueEmpStatArrayList;
  private ArrayList valueSplCompArrayList;
  private ArrayList valueParentZoneArrayList;
  private ArrayList valueAccomTypeArrayList;
  private ArrayList valuePayScale;
  private ArrayList cityList;
  private ArrayList cityHraList;
  private ArrayList valueEmpStatAllArrayList;
  private ArrayList mhsTypList;
  private ArrayList epsSepTypList;
  private ArrayList splDtyAreaList;
  private ArrayList classificationList;
    private ArrayList valueHandiTypeList;
  private ArrayList valueCasteCategList;
  private ArrayList valueReligionList;
  private ArrayList valuePenFlagArrayList;

  public EmpFinanceComboVO()
  {
  }
  public ArrayList getValueHandiTypeList()
  {
    return valueHandiTypeList;
  }

  public void setValueHandiTypeList(ArrayList newValueHandiTypeList)
  {
    valueHandiTypeList = newValueHandiTypeList;
  }
  public ArrayList getValueCasteCategList()
  {
    return valueCasteCategList;
  }

  public void setValueCasteCategList(ArrayList newValueCasteCategList)
  {
    valueCasteCategList = newValueCasteCategList;
  }
  public ArrayList getValueReligionList()
  {
    return valueReligionList;
  }

  public void setValueReligionList(ArrayList newValueReligionList)
  {
    valueReligionList = newValueReligionList;
  }
  public ArrayList getValuePFTypeArrayList()
  {
    return valuePFTypeArrayList;
  }

  public void setValuePFTypeArrayList(ArrayList newValuePFTypeArrayList)
  {
    valuePFTypeArrayList = newValuePFTypeArrayList;
  }

  public ArrayList getValueCategArrayList()
  {
    return valueCategArrayList;
  }

  public void setValueCategArrayList(ArrayList newValueCategArrayList)
  {
    valueCategArrayList = newValueCategArrayList;
  }
  
  public ArrayList getValueCadreArrayList()
  {
    return valueCadreArrayList;
  }

  public void setValueCadreArrayList(ArrayList newValueCadreArrayList)
  {
    valueCadreArrayList = newValueCadreArrayList;
  }

  public ArrayList getValueEmpStatArrayList()
  {
    return valueEmpStatArrayList;
  }

  public void setValueEmpStatArrayList(ArrayList newValueEmpStatArrayList)
  {
    valueEmpStatArrayList = newValueEmpStatArrayList;
  }

  public ArrayList getValueEmpStatAllArrayList()
  {
    return valueEmpStatAllArrayList;
  }

  public void setValueEmpStatAllArrayList(ArrayList newValueEmpStatAllArrayList)
  {
    valueEmpStatAllArrayList = newValueEmpStatAllArrayList;
  }
  
  public ArrayList getValueSplCompArrayList()
  {
    return valueSplCompArrayList;
  }

  public void setValueSplCompArrayList(ArrayList newValueSplCompArrayList)
  {
    valueSplCompArrayList = newValueSplCompArrayList;
  }
  
  public ArrayList getValueParentZoneArrayList()
  {
    return valueParentZoneArrayList;
  }

  public void setValueParentZoneArrayList(ArrayList newValueParentZoneArrayList)
  {
    valueParentZoneArrayList = newValueParentZoneArrayList;
  }
  
  public ArrayList getValueAccomTypeArrayList()
  {
    return valueAccomTypeArrayList;
  }

  public void setValueAccomTypeArrayList(ArrayList newValueAccomTypeArrayList)
  {
    valueAccomTypeArrayList = newValueAccomTypeArrayList;
  }

  public ArrayList getValuePayScale()
  {
    return valuePayScale;
  }

  public void setValuePayScale(ArrayList newValuePayScale)
  {
    valuePayScale = newValuePayScale;
  }

  public ArrayList getCityList()
  {
    return cityList;
  }

  public void setCityList(ArrayList newCityList)
  {
    cityList = newCityList;
  }

  public ArrayList getCityHraList()
  {
    return cityHraList;
  }

  public void setCityHraList(ArrayList newCityHraList)
  {
    cityHraList = newCityHraList;
  }
  
  public ArrayList getMhsTypList()
  {
    return mhsTypList;
  }

  public void setMhsTypList(ArrayList newMhsTypList)
  {
    mhsTypList = newMhsTypList;
  }

  public ArrayList getEpsSepTypList()
  {
    return epsSepTypList;
  }

  public void setEpsSepTypList(ArrayList newEpsSepTypList)
  {
    epsSepTypList = newEpsSepTypList;
  }

  public ArrayList getSplDtyAreaList()
  {
    return splDtyAreaList;
  }

  public void setSplDtyAreaList(ArrayList newSplDtyAreaList)
  {
    splDtyAreaList = newSplDtyAreaList;
  }
  
   public ArrayList getClassificationList()
  {
    return classificationList;
  }

  public void setClassificationList(ArrayList newClassificationList)
  {
    classificationList = newClassificationList;
  }

    public void setValuePenFlagArrayList(ArrayList valuePenFlagArrayList) {
        this.valuePenFlagArrayList = valuePenFlagArrayList;
    }

    public ArrayList getValuePenFlagArrayList() {
        return valuePenFlagArrayList;
    }


   
}
