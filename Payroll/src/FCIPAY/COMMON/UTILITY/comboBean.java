/*
 * Module       :   comboBean.java
 * Author       :   V.Jegan
 * Date Written :   26th Sept 2003
 * Description  :   The file for populating all the combo's 
 * Revision Log :   (mm/dd/yy initials description)
 * -----------------------------------------------------------------
 * mm/dd/yy     xxxx    <comments on changes>
 * 06/28/04     Revised by Karthik Murthy.
 *              Added an extra field and two extra constructors to
 *              handle the case of two possible hidden values in
 *              a comboBox.
*/

package FCIPAY.COMMON.UTILITY;

public class comboBean  {
    
    private String code="";
    private int id=0;
    private String idString="";
    private long idLong=0;
    private long secondHiddenID=0; //added field
    private String secondHiddenString = "";//second added field

  
    /**
    * Constructor Method for comboBean which takes 2 parameters
    * @param=tempid which has the id to be added
    * @param=tempcode which has the code to be added
    */
    public comboBean(int tempid,String tempcode)
    {
        this.id=tempid;
        this.code=tempcode;
    }

    /**
    * Constructor Method for comboBean which takes 2 parameters
    * @param=tempid which has the id to be added
    * @param=tempcode which has the code to be added
    */
    public comboBean(String tempid,String tempcode)
    {
        this.idString=tempid;
        this.code=tempcode;
    }

    /**
    * Constructor Method for comboBean which takes 2 parameters
    * @param=tempid which has the id to be added
    * @param=tempcode which has the code to be added
    */
    public comboBean(long tempid,String tempcode)
    {
        this.idLong=tempid;
        this.code=tempcode;
    }

    public comboBean(long tempIdLong, int tempIdInt, String tempcode)
    {
      this.idLong = tempIdLong;
      this.id = tempIdInt;
      this.code = tempcode;
    }

    public comboBean(long tempIdLong, long secondTempIdLong, String tempcode)
    {
      this.idLong = tempIdLong;
      this.secondHiddenID = secondTempIdLong;
      this.code = tempcode;
    }

    public comboBean(long tempIdLong, int tempIdInt, String tempcode, String tempIdString)
    {
      this.idLong = tempIdLong;
      this.id = tempIdInt;
      this.code = tempcode;
      this.idString = tempIdString;
    }

    public comboBean(long tempIdLong, long secondTempIdLong, String tempcode, String tempIdString)
    {
      this.idLong = tempIdLong;
      this.secondHiddenID = secondTempIdLong;
      this.code = tempcode;
      this.idString = tempIdString;
    }

    public comboBean(long tempIdLong, String tempcode, String tempIdString)
    {
      this.idLong = tempIdLong;
      this.code = tempcode;
      this.idString = tempIdString;
    }

    public comboBean(String tempcode, String tempIdString, String tempSecondString)
    {
      this.code = tempcode;
      this.idString = tempIdString;
      this.secondHiddenString = tempSecondString;
    }

    public comboBean(long tempIdLong, String tempcode, String tempIdString, String tempSecondString)
    {
      this.idLong = tempIdLong;
      this.code = tempcode;
      this.idString = tempIdString;
      this.secondHiddenString = tempSecondString;
    }
    public long getSecondHiddenID()
    {
      return secondHiddenID;
    }

    public void setSecondHiddenID(long newSecondHiddenID)
    {
      this.secondHiddenID = newSecondHiddenID;
    }
    
    public String getCode()
    {
        return code;
    }

    public void setCode(String newCode)
    {
        code = newCode;
    }

    public int getId()
    {
        return id;
    }
    
    public String getIdString()
    {
        return idString;
    }
    
    public long getIdLong()
    {
        return idLong;
    }

    public void setId(int newId)
    {
        id = newId;
    }

    public void setId(String newId)
    {
        idString = newId;
    }

    public void setId(long newId)
    {
        idLong = newId;
    }

    public String getSecondHiddenString()
    {
        return secondHiddenString;
    }

    public void setSecondHiddenString(String newSecondHiddenString)
    {
        secondHiddenString = newSecondHiddenString;
    }
}