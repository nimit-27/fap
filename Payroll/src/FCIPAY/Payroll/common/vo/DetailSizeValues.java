package FCIPAY.Payroll.common.vo;
import java.io.Serializable;
public class DetailSizeValues implements Serializable
{
  int detailRecordPerPage = 0;
  int maxPages = 0;
  public DetailSizeValues()
  {
  }

  public int getDetailRecordPerPage()
  {
    return detailRecordPerPage;
  }

  public void setDetailRecordPerPage(int newDetailRecordPerPage)
  {
    detailRecordPerPage = newDetailRecordPerPage;
  }

  public int getMaxPages()
  {
    return maxPages;
  }

  public void setMaxPages(int newMaxPages)
  {
    maxPages = newMaxPages;
  }
}