package FCIPAY.Payroll.common.utility;


public final class EnrgiseConstants 
{
  public EnrgiseConstants()
  {
  }
  
  // Different types of user actions
  public static final int GET_HEADER = 1;
  public static final int GET_NEXT = 2;
  public static final int GET_PREVIOUS = 3;
  public static final int GET_FIRST = 4;
  public static final int GET_LAST = 5;
  public static final int GET_DETAIL = 6;
  public static final int GET_NEXT_DETAIL = 7;
  public static final int SAVE_DATA = 8;
  public static final int EXIT_APP = 9;
  public static final int NEW_DOCUMENT = 10;
  public static final int GET_DETAIL_PAGE = 11;
  public static final int CLOSE_WINDOW = 12;
  
  //Forward
  public static final String SUCCESS = "success";
  
  //Error type
  public static final String ERROR = "E";
  public static final String MESSAGE = "M";
  public static final String VISIBLE = "V";
  public static final String HIDDEN = "H";
  
  public static final String BASE_HEADER_VO = "BaseHeaderVO";
  public static final String BASE_QUERY_VO = "BaseQueryVO";
  public static final String BASE_DETAIL_VO = "BaseDetailVO";
  public static final String COMPONENTS_MAP = "Components";

  //Header Size
  public static final int HEADER_SIZE = 10;
  
  //Database Name
   public static final String DATABASE_NAME = "jdbc/FCIPAYDS";
 //  public static final String DATABASE_NAME = "jdbc/FCIPAYLDS";
  
  //Screen Mode
  public static final String NEW_MODE = "N";
  public static final String UPDATE_MODE = "U";
  public static final String DELETE_MODE = "D";
  public static final String QUERY_MODE = "Q";
  
  //LOV Action
  public static final String FIRST_LOAD = "LoadingFirst";
  public static final String SEARCH_RECORD = "SearchRecords";

  public static final String DB_DATE_FORMAT = "dd-mon-yyyy";
  public static final String UI_DATE_FORMAT = "dd/mm/yyyy";

  public static final String STATUS = "status";

  public static final int AFTER_DATE = 1;
  public static final int DATE_ERROR = -2;
  public static final int EQUAL_DATE = 0;
  public static final int BEFORE_DATE = -1;

}
