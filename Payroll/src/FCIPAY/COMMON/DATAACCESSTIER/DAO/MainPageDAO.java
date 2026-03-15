/*
 * Program Name : MainPageDAO.java
 * Author       : Jegan.V
 * Date Written : 01/03/2004
 * Description  : This is the DAO method for the MainPage 
 *                     which makes the menu dynamically
 *
*/


package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import FCIPAY.COMMON.UTILITY.*;

import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries;

import java.sql.*;
import java.util.ArrayList;


import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import java.util.Iterator;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.COMMON.UTILITY.DynamicMenuBean;
import FCIPAY.COMMON.UTILITY.BaseDAO;


public class MainPageDAO  extends BaseDAO
{
    public MainPageDAO() 
    {
        super("Common");
    }


    /**
     * This function is to get the Modules assigned to the user.
     * @param empNo which gives the user logged in 
     * @return ArrayList which has the list of the Modules
     * @tables-Accessed are temp_sa_menu
     */
//    public ArrayList getModule(long empNo,long locCode) throws IBAFatalException
      public ArrayList getModule(long empNo,long locCode, String owner) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
/*        ResultSet res=null;
        ArrayList tempLst=new ArrayList();
        try 
        {
            doPrepareStatement(ScreenAcessQueries.SQL_GETMODULENAME);
            setLONGPRIMITIVE(empNo);
            setLONGPRIMITIVE(locCode);
            res=doExecuteQuery(false);
            while(res.next()) 
            {
                tempLst.add(new DynamicMenuBean(res.getString("MODULE")));
            }
		closePreparedStatement();
            closeConnection();
            //tempLst.add(new DynamicMenuBean("Change Password"));
            //tempLst.add(new DynamicMenuBean("Logout"));
        }
        catch(Exception e) 
        {
            closePreparedStatement();
            closeConnection();
            e.printStackTrace();    
        }
        return tempLst;  */

        ArrayList lList = new ArrayList();
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters 
        DBUtilitiesBean oBean = new DBUtilitiesBean();

        try
        {
            //oParameters = new ArrayList();
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(empNo)));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(locCode)));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,new String(owner)));            
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_GETMODULENAME); 
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();
                    lList.add(new DynamicMenuBean(oRow.get("MODULE").getString()));                    
            }
        }

        catch(Exception e)
        {
              throw new EnrgiseSystemException(e);
        }     
        oOutArray = null;
        oParameters = null;
        return lList;
        
    }


    /**
     * This function is to get the Menu dynamically based on the Module selected
     * @param empNo which gives the user logged in 
     * @param module which gives the module clicked
     * @return ArrayList which has the list of the screens
     * @tables-Accessed are temp_sa_menu
     */
//    public ArrayList getDyanmicMenu(long empNo,long locCode,String module) throws IBAFatalException,IBABusinessException  
      public ArrayList getDyanmicMenu(long empNo,long locCode,String module) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
/*        ResultSet rSet=null;
        ArrayList a=new ArrayList();
        ArrayList finalList=new ArrayList();
        try 
        {
            doPrepareStatement(ScreenAcessQueries.SQL_GETSCREENNAMES);
            setLONGPRIMITIVE(empNo);
            setLONGPRIMITIVE(locCode);
            setVARCHAR(module);
            rSet=doExecuteQuery(false);
            while(rSet.next()) 
            {
                a.add(new DynamicMenuBean(rSet.getString(1),rSet.getString(2),rSet.getString(3),rSet.getString(4),rSet.getString(5),rSet.getString(6),rSet.getString(7)));
            }
            rSet=null;
            closePreparedStatement();
            closeConnection();
            
            //Code for making the Dyanmic Menu based on the User
            String level1="";
            String level2="";           
            String level3="";
            int size=a.size();
            int parent=1000;
            int child=0;
            String[] Header=new String[10];
            DynamicMenuBean ap=(DynamicMenuBean)a.get(0);
            Header[0]=ap.getHeader();
            int noHeadings=1;

            //For adding the Header Details into the Menu

            //System.out.println("makemenu("+child+"-"+parent+"-"+ap.getHeader()+")");
            finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + parent +"','','" + ap.getHeader() + "')"));

            for(int i=0;i<size-1;i++) 
            { 
                ap=(DynamicMenuBean)a.get(i);

                DynamicMenuBean ac=(DynamicMenuBean)a.get(i+1);
                if(!(ap.getHeader().equals(ac.getHeader()))) 
                {
                    parent+=1000;
                    Header[noHeadings++]=ac.getHeader();
                    //System.out.println("makemenu("+child+"-"+parent+"-"+ac.getHeader());
                    finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + parent +"','','" + ac.getHeader() + "')"));
                }
            }
            //finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + (parent+1000)  + "','','Change Password','RedirectMap.do?action=frmChangePwd|ChangePassword')"));
            finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + (parent+2000)  + "','','MainPage','RedirectMap.do?action=frmMainPage|MainPage')"));

            //===========================END of Header Creation======================================

            //For Adding the Remaining Levels in the Menu
            int parnt=0;
            child=0;
            int gchild=0;
            int ggchild=0;
            String plevel1="";
            String plevel2="";
            String plevel3="";
            for(int i=0;i<noHeadings;i++) 
            {
                parnt=(i+1)*1000;
                int tchild=parnt;
                for(int j=0;j<size;j++) 
                {
                    DynamicMenuBean c=(DynamicMenuBean)a.get(j);
                    if(Header[i].equals(c.getHeader())) 
                    {
                        level1=c.getlevel1();
                        level2=c.getlevel2();
                        level3=c.getlevel3();
            //==================LEVEL1 NOT EMPTY AND LEVEL2,LEVEL3 EMPTY=================================
                        if(!level1.equals(" ") && level2.equals(" ") && level3.equals(" ")) 
                        {
                            if(!plevel1.equals(level1)) 
                            {
                                child=tchild+1;
                                tchild=child;
                                plevel1=level1;

                                //System.out.println("makemenu("+child+"-"+parnt+"-"+c.getlevel1()+"-"+c.getFormbean()+"-"+c.getAction());
                                if((c.getFormbean().equals(" "))&&(c.getAction().equals(" ")))
                                    finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + child +"','"+parnt +"','" + c.getlevel1() + "','RedirectMap.do?action=" + c.getReprotURL() + "|zzz')"));
                                else
                                    finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + child +"','"+parnt +"','" + c.getlevel1() + "','RedirectMap.do?action="+ c.getFormbean() +"|"+ c.getAction() +"')"));
                            }                            
                            continue;
                        }
            //==================LEVEL1,LEVEL2 NOT EMPTY AND LEVEL3 EMPTY=================================
                        else if(!level1.equals(" ") && !level2.equals(" ") && level3.equals(" ")) 
                        {
                            //if level1 is not equal to previous level1(plevel1). First time it will be empty
                            if(!plevel1.equals(level1)) 
                            {
                                child=tchild+1;
                                tchild=child;
                                plevel1=level1;
                                //System.out.println("makemenu("+child+"-"+parnt+"-"+c.getlevel1());
                                plevel2="";
                                finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + child +"','"+parnt +"','" + c.getlevel1() + "')"));                                
                            }
                            //if level2 is not equal to previous level2(plevel2). First time it will be empty                            
                            if(!plevel2.equals(level2)) 
                            {
                                gchild=tchild+1;
                                tchild=gchild;                                
                                plevel2=level2;

                                //System.out.println("makemenu("+gchild+"-"+child+"-"+c.getlevel2()+"-"+c.getFormbean()+"-"+c.getAction());
                                if((c.getFormbean().equals(" "))&&(c.getAction().equals(" ")))
                                    finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + gchild +"','"+child +"','" + c.getlevel2() + "','RedirectMap.do?action=" + c.getReprotURL() + "|zzz')"));
                                else
                                    finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + gchild +"','"+child +"','" + c.getlevel2() + "','RedirectMap.do?action="+ c.getFormbean() +"|"+ c.getAction() +"')"));
                            }                            
                            continue;
                        }
            //==================LEVEL1,LEVEL2,LEVEL3 NOT EMPTY=================================
                        else if(!level1.equals(" ") && !level2.equals(" ") && !level3.equals(" ")) 
                        {
                            //if level1 is not equal to previous level1(plevel1). First time it will be empty                            
                            if(!plevel1.equals(level1)) 
                            {
                                child=tchild+1;
                                tchild=child;                                
                                plevel1=level1;
                                plevel2="";
                                //System.out.println("makemenu("+child+"-"+parnt+"-"+c.getlevel1());
                                finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + child +"','"+parnt +"','" + c.getlevel1() + "')"));                                
                            }
                            //if level2 is not equal to previous level2(plevel2). First time it will be empty                            
                            if(!plevel2.equals(level2)) 
                            {
                                gchild=tchild+1;
                                tchild=gchild;                                
                                plevel2=level2;
                                //System.out.println("makemenu("+gchild+"-"+child+"-"+c.getlevel2());
                                finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + gchild +"','"+child +"','" + c.getlevel2() + "')"));
                            }
                            ggchild=tchild+1;
                            tchild=ggchild;                                

                            //System.out.println("makemenu("+ggchild+"-"+gchild+"-"+c.getlevel3()+"-"+c.getFormbean()+"-"+c.getAction());
                            //if((c.getFormbean()==null)||(c.getAction().length() <=0))
                            
                            if((c.getFormbean().equals(" "))&&(c.getAction().equals(" ")))
                                finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + ggchild +"','"+gchild +"','" + c.getlevel3() + "','RedirectMap.do?action=" + c.getReprotURL() + "|zzz')"));
                            else
                                finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + ggchild +"','"+gchild +"','" + c.getlevel3() + "','RedirectMap.do?action="+ c.getFormbean() +"|"+ c.getAction() +"')"));

                            continue;
                        }
                    }
                }
            }
            
        }
        catch(SQLException e) 
        {
            rSet=null;
            closePreparedStatement();
            closeConnection();
            e.printStackTrace();
        }
        catch(Exception e) 
        {
            rSet=null;
            closePreparedStatement();
            closeConnection();
            e.printStackTrace();
        }
        return finalList;  */

        ArrayList a=new ArrayList();
        ArrayList finalList = new ArrayList();
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList newMenu=new ArrayList();
        try
        {
            oParameters = new ArrayList();
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(empNo)));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(locCode)));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,module));
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_GETSCREENNAMES); 
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();
                    a.add(new DynamicMenuBean(oRow.get("HEADER_NAME").getString(),oRow.get("level1").getString(),oRow.get("level2").getString(),oRow.get("level3").getString(),oRow.get("FORMBEANNAME").getString(),oRow.get("ACTIONNAME").getString(),oRow.get("REPORT_URL").getString(),oRow.get("ALL_EMP_FLG").getString()));                    
            }

            String level1="";
            String level2="";           
            String level3="";
            int size=a.size();
            int parent=1000;
            int child=0;
            String[] Header=new String[10];
            DynamicMenuBean ap=(DynamicMenuBean)a.get(0);
            Header[0]=ap.getHeader();
            int noHeadings=1;

            //For adding the Header Details into the Menu

            //System.out.println("makemenu("+child+"-"+parent+"-"+ap.getHeader()+")");
            finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + parent +"','','" + ap.getHeader() + "')"));
           
            for(int i=0;i<size-1;i++) 
            { 
                ap=(DynamicMenuBean)a.get(i);

                DynamicMenuBean ac=(DynamicMenuBean)a.get(i + 1);
                if(!(ap.getHeader().equals(ac.getHeader()))) 
                {
                    parent+=1000;
                    Header[noHeadings++]=ac.getHeader();
                    //System.out.println("makemenu("+child+"-"+parent+"-"+ac.getHeader());
                    finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + parent +"','','" + ac.getHeader() + "')"));
                }
            }
            //finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + (parent+1000)  + "','','Change Password','RedirectMap.do?action=frmChangePwd|ChangePassword')"));
            finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + (parent+2000)  + "','','Go To')"));
            finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + (parent+2020)  + "','"+(parent+2000)+"','MainPage','RedirectMap.do?action=frmMainPage|MainPage')"));

            //===========================END of Header Creation======================================

            //For Adding the Remaining Levels in the Menu
            int parnt=0;
            child=0;
            int gchild=0;
            int ggchild=0;
            String plevel1="";
            String plevel2="";
            String plevel3="";
            for(int i=0;i<noHeadings;i++) 
            {
                parnt=(i+1)*1000;
                int tchild=parnt;
                for(int j=0;j<size;j++) 
                {
                    DynamicMenuBean c=(DynamicMenuBean)a.get(j);
                    if(Header[i].equals(c.getHeader())) 
                    {
                        level1=c.getlevel1();
                        level2=c.getlevel2();
                        level3=c.getlevel3();
            //==================LEVEL1 NOT EMPTY AND LEVEL2,LEVEL3 EMPTY=================================
                        if(!level1.equals(" ") && level2.equals(" ") && level3.equals(" ")) 
                        {
                            if(!plevel1.equals(level1)) 
                            {
                                child=tchild+1;
                                tchild=child;
                                plevel1=level1;

                                //System.out.println("makemenu("+child+"-"+parnt+"-"+c.getlevel1()+"-"+c.getFormbean()+"-"+c.getAction());
                                if((c.getFormbean().equals(" "))&&(c.getAction().equals(" ")))
                                    finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + child +"','"+parnt +"','" + c.getlevel1() + "','RedirectMap.do?action=" + c.getReprotURL() + "|zzz|"+c.getHdnEmpLbrFlag()+"')"));
                                else
                                    finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + child +"','"+parnt +"','" + c.getlevel1() + "','RedirectMap.do?action="+ c.getFormbean() +"|"+ c.getAction() +"|"+c.getHdnEmpLbrFlag()+"')"));
                            }                            
                            continue;
                        }
            //==================LEVEL1,LEVEL2 NOT EMPTY AND LEVEL3 EMPTY=================================
                        else if(!level1.equals(" ") && !level2.equals(" ") && level3.equals(" ")) 
                        {
                            //if level1 is not equal to previous level1(plevel1). First time it will be empty
                            if(!plevel1.equals(level1)) 
                            {
                                child=tchild+1;
                                tchild=child;
                                plevel1=level1;
                                //System.out.println("makemenu("+child+"-"+parnt+"-"+c.getlevel1());
                                plevel2="";
                                finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + child +"','"+parnt +"','" + c.getlevel1() + "')"));                                
                            }
                            //if level2 is not equal to previous level2(plevel2). First time it will be empty                            
                            if(!plevel2.equals(level2)) 
                            {
                                gchild=tchild+1;
                                tchild=gchild;                                
                                plevel2=level2;

                                //System.out.println("makemenu("+gchild+"-"+child+"-"+c.getlevel2()+"-"+c.getFormbean()+"-"+c.getAction());
                                if((c.getFormbean().equals(" "))&&(c.getAction().equals(" ")))
                                    finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + gchild +"','"+child +"','" + c.getlevel2() + "','RedirectMap.do?action=" + c.getReprotURL() + "|zzz|"+c.getHdnEmpLbrFlag()+"')"));
                                else
                                    finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + gchild +"','"+child +"','" + c.getlevel2() + "','RedirectMap.do?action="+ c.getFormbean() +"|"+ c.getAction() +"|"+c.getHdnEmpLbrFlag()+"')"));
                            }                            
                            continue;
                        }
            //==================LEVEL1,LEVEL2,LEVEL3 NOT EMPTY=================================
                        else if(!level1.equals(" ") && !level2.equals(" ") && !level3.equals(" ")) 
                        {
                            //if level1 is not equal to previous level1(plevel1). First time it will be empty                            
                            if(!plevel1.equals(level1)) 
                            {
                                child=tchild+1;
                                tchild=child;                                
                                plevel1=level1;
                                plevel2="";
                                //System.out.println("makemenu("+child+"-"+parnt+"-"+c.getlevel1());
                                finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + child +"','"+parnt +"','" + c.getlevel1() + "')"));                                
                            }
                            //if level2 is not equal to previous level2(plevel2). First time it will be empty                            
                            if(!plevel2.equals(level2)) 
                            {
                                gchild=tchild+1;
                                tchild=gchild;                                
                                plevel2=level2;
                                //System.out.println("makemenu("+gchild+"-"+child+"-"+c.getlevel2());
                                finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + gchild +"','"+child +"','" + c.getlevel2() + "')"));
                            }
                            ggchild=tchild+1;
                            tchild=ggchild;                                

                            //System.out.println("makemenu("+ggchild+"-"+gchild+"-"+c.getlevel3()+"-"+c.getFormbean()+"-"+c.getAction());
                            //if((c.getFormbean()==null)||(c.getAction().length() <=0))
                            
                            if((c.getFormbean().equals(" "))&&(c.getAction().equals(" ")))
                                finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + ggchild +"','"+gchild +"','" + c.getlevel3() + "','RedirectMap.do?action=" + c.getReprotURL() + "|zzz|"+c.getHdnEmpLbrFlag()+"')"));
                            else
                                finalList.add(new DynamicMenuBean("MyMenu.makeMenu('" + ggchild +"','"+gchild +"','" + c.getlevel3() + "','RedirectMap.do?action="+ c.getFormbean() +"|"+ c.getAction()+"|"+c.getHdnEmpLbrFlag()+"')"));

                            continue;
                        }
                    }
                }
            }            
        }

        catch(Exception e)
        {
              throw new EnrgiseSystemException(e);
        }             

        return finalList;
        
    }
}