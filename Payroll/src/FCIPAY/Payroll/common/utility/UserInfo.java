package FCIPAY.Payroll.common.utility;
import java.io.Serializable;


public class UserInfo implements Serializable
{
String  sUser_system_id;
String  sUser_id;
String  sPassword;
String  sSite_id;
String  sUser_id_created;
String  sCreated_site_id;
String  sCreated_time_stamp;
String  sUser_id_modified;
String  sModified_site_id;
String  sModified_time_stamp;
String  sArc_flag;
String  sUser_type;
String  sUser_type_id;
String  sPassword_changed;
String  sUser_locked;
String  sUser_active_flag;




public String  getUser_system_id() 
{
  return sUser_system_id;
}

public void setUser_system_id(String newUser_system_id) 
{
  sUser_system_id=newUser_system_id;
}

public String  getUser_id()
{
  return sUser_id;
}

public void setUser_id(String newUser_id) 
  {
  sUser_id=newUser_id;
}

public String   getPassword() 
{
  return sPassword;
}

public void setPassword(String newPassword) 
  {
  sPassword=newPassword;
  }

public  String getSite_id() 
{
  return sSite_id;
}

public void setSite_id(String newSite_id) 
  {
  sSite_id=newSite_id;
  }

public String getUser_id_created() 
{
  return sUser_id_created;
}

public void setUser_id_created(String newUser_id_created) 
{
  sUser_id_created=newUser_id_created;
}

public String getCreated_site_id() 
{
  return sCreated_site_id;
}

public void setCreated_site_id(String newCreated_site_id) 
{
 sCreated_site_id=newCreated_site_id; 
}

public String getCreated_time_stamp() 
 {
  return sCreated_time_stamp;
 }

public void setCreated_time_stamp(String newCreated_time_stamp) 
{
  sCreated_time_stamp=newCreated_time_stamp;
}

public String getUser_id_modified() 
{
  return sUser_id_modified;
}

public void setUser_id_modified(String newUser_id_modified) 
{
  sUser_id_modified=newUser_id_modified;
}
  
public String getModified_site_id()
{
  return sModified_site_id;
}
 
public void setModified_site_id(String newModified_site_id) 
{
  sModified_site_id=newModified_site_id;
}

public String getModified_time_stamp() 
{
  return sModified_time_stamp;
}

public  void setModified_time_stamp(String newModified_time_stamp) 
{
  sModified_time_stamp=newModified_time_stamp;
}

public String getArc_flag() 
{
 return sArc_flag;
}

public void setArc_flag(String newArc_flag) 
{
  sArc_flag= newArc_flag;
}

public String getUser_type() 
{
 return sUser_type;
}

public  void setUser_type(String newUser_type) 
{
  sUser_type=newUser_type;
}

public String getUser_type_id() 
{
 return sUser_type_id;
}

public void setUser_type_id(String newUser_type_id) 
{
  sUser_type_id= newUser_type_id;
}

public String getPassword_changed() 
{
  return sPassword_changed;
}

public void setPassword_changed(String newPassword_changed) 
{
   sPassword_changed=newPassword_changed;
}

public String getUser_locked() 
{
  return sUser_locked;
}

public void setUser_locked(String newUser_locked) 
{
  sUser_locked=newUser_locked;
}

public String getUser_active_flag() 
{
  return sUser_active_flag;
}
 public void setUser_active_flag(String newUser_active_flag) 
 {
    sUser_active_flag=newUser_active_flag;
 }

  public static void main(String[] args)
  {
    UserInfo usrInfo = new UserInfo();
  }
 
}