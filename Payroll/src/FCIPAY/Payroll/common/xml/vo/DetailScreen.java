package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;

public class DetailScreen  implements Serializable
{
  private String _DetailScreenName;
  private String _DetailArrayName;
  private String _DetailBD;
  private String _DetailBean;
  private String _BaseDetailInfo;  
  private String _DetailRecordPerPage;
  private String _DetailPagesPerSlot;
  
  public DetailScreen()
  {
  }
  public DetailScreen(String _DetailScreenName, String _DetailArrayName)
  {
    this._DetailScreenName = _DetailScreenName;
    this._DetailArrayName = _DetailArrayName;
  }

  public String get_DetailArrayName()
  {
    return _DetailArrayName;
  }

  public void set_DetailArrayName(String new_DetailArrayName)
  {
    _DetailArrayName = new_DetailArrayName;
  }

  public String get_DetailScreenName()
  {
    return _DetailScreenName;
  }

  public void set_DetailScreenName(String new_DetailScreenName)
  {
    _DetailScreenName = new_DetailScreenName;
  }

  public String get_DetailBD()
  {
    return _DetailBD;
  }

  public void set_DetailBD(String new_DetailBD)
  {
    _DetailBD = new_DetailBD;
  }

  public String get_DetailBean()
  {
    return _DetailBean;
  }

  public void set_DetailBean(String new_DetailBean)
  {
    _DetailBean = new_DetailBean;
  }

  public String get_DetailRecordPerPage()
  {
    return _DetailRecordPerPage;
  }

  public void set_DetailRecordPerPage(String new_DetailRecordPerPage)
  {
    _DetailRecordPerPage = new_DetailRecordPerPage;
  }

  public String get_DetailPagesPerSlot()
  {
    return _DetailPagesPerSlot;
  }

  public void set_DetailPagesPerSlot(String new_DetailPagesPerSlot)
  {
    _DetailPagesPerSlot = new_DetailPagesPerSlot;
  }
  public String get_BaseDetailInfo()
  {
    return _BaseDetailInfo;
  }

  public void set_BaseDetailInfo(String new_BaseDetailInfo)
  {
    _BaseDetailInfo = new_BaseDetailInfo;
  }  
}