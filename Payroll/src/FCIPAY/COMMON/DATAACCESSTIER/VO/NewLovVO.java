/*
 * Program Name : NewLovVO.java
 * Author       : Neeraj Gupta
 * Date Written : 05/10/2010
 * Description  : This is the Value Object Class for transfering the values from
 *                  the Action Class to the DAO and back to Action Class.
 *
*/


package FCIPAY.COMMON.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.Properties;

public class NewLovVO  extends Properties implements Serializable
{
  private String searchField1;
  private String searchField2;
  private String searchField3="";
  private String searchField4=""; // added by devendra
  private String searchField5="";//added by neeraj
  private String searchField6="";//added by neeraj
 // private String searchField7="";//added by neeraj
 // private String searchField8="";//added by neeraj

  public NewLovVO()
  {
  }

// added by devendra start
 public String getSearchField4()
  {
    return searchField4;
  }

  public void setSearchField4(String newSearchField4)
  {
    searchField4 = newSearchField4;
  }
// added by devendra end

//added by neeraj starts here

 public String getSearchField5()
  {
    return searchField5;
  }

  public void setSearchField5(String newSearchField5)
  {
    searchField5 = newSearchField5;
  }
   public String getSearchField6()
  {
    return searchField6;
  }

  public void setSearchField6(String newSearchField6)
  {
    searchField6 = newSearchField6;
  }
 /*  public String getSearchField7()
  {
    return searchField7;
  }

  public void setSearchField7(String newSearchField7)
  {
    searchField7 = newSearchField7;
  }
  
    public String getSearchField8()
  {
    return searchField8;
  }

  public void setSearchField8(String newSearchField8)
  {
    searchField8 = newSearchField8;
  }
  */
//added by neeraj ends here

  public String getSearchField1()
  {
  //System.out.println("inside getsearch filed function ()");
    return searchField1;
  }

  public void setSearchField1(String newSearchField1)
  {
    searchField1 = newSearchField1;
  }

  public String getSearchField2()
  {
    return searchField2;
  }

  public void setSearchField2(String newSearchField2)
  {
    searchField2 = newSearchField2;
  }
  
  public String getSearchField3()
  {
    return searchField3;
  }

  public void setSearchField3(String newSearchField3)
  {
    searchField3 = newSearchField3;
  }

}