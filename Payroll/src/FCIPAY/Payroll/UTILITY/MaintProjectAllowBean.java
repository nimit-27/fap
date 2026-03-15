package FCIPAY.Payroll.UTILITY;

public class MaintProjectAllowBean extends PayrollBaseDetailBean
{

  private String txtBasicFrom;
  private String txtCtgry;
  private String txtBasicTo;
  private String txtAllow;
  private String txtStartDt;
  private String txtEndDt;


  public MaintProjectAllowBean()
  {
  }

  public MaintProjectAllowBean(String sBasicFrom,String sBasicTo,String sCtgry,String sAllow,String sStartDt,String sEndDt)
  {
    txtBasicFrom=sBasicFrom;
    txtCtgry =sCtgry;
    txtBasicTo=sBasicTo;
    txtAllow=sAllow;
    txtStartDt=sStartDt;
    txtEndDt=sEndDt;
  }

    public String getTxtBasicFrom()
  {
    return txtBasicFrom;
  }

  public void setTxtBasicFrom(String newTxtBasicFrom)
  {
    txtBasicFrom = newTxtBasicFrom;
  }

   public String getTxtBasicTo()
  {
    return txtBasicTo;
  }

  public void setTxtBasicTo(String newTxtBasicTo)
  {
    txtBasicTo = newTxtBasicTo;
  }
   public String getTxtAllow()
  {
    return txtAllow;
  }

  public void setTxtAllow(String newTxtAllow)
  {
    txtAllow = newTxtAllow;
  }
   public String getTxtStartDt()
  {
    return txtStartDt;
  }

  public void setTxtStartDt(String newTxtStartDt)
  {
    txtStartDt = newTxtStartDt;
  }

   public String getTxtCtgry()
  {
    return txtCtgry;
  }

  public void setTxtCtgry(String newTxtCtgry)
  {
    txtCtgry = newTxtCtgry;
  }

     public String getTxtEndDt()
  {
    return txtEndDt;
  }

  public void setTxtEndDt(String newTxtEndDt)
  {
    txtEndDt = newTxtEndDt;
  }
}