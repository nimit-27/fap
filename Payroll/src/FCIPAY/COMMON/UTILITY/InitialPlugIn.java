package FCIPAY.COMMON.UTILITY;

import javax.servlet.ServletException;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.PlugInConfig;
import org.apache.struts.config.ModuleConfig;

import java.io.*;
import java.util.*;
import java.sql.*;
import org.apache.log4j.*;
import javax.sql.*;

import oracle.jdbc.driver.*;
import oracle.jdbc.pool.*;
 
import FCIPAY.COMMON.UTILITY.*;



/**
  * Program Name : InitialPlugIn.java
  * Author       : Paresh
  * Date Written : 22/10/2003
  * Description  : This class is used to get the Data Source
  * Revision History:
  * Modified by Dhruv/Salini on 21-12-2003 for handling changes in Transaction screens
  *
**/

public class InitialPlugIn implements PlugIn 
{
    private static DSConnect dsc = null;

    /**
    *  This method is used to instantiate a new Data Source 
    *  @param ActionServlet servlet,ApplicationConfig strutsConfig
    *  @exception ServletException         
    *  @return 
    **/   
    public void init( ActionServlet servlet,ModuleConfig strutsConfig) throws ServletException 
    {        PlugInConfig[] p;
            String rootPath="";
        try 
        {
        
            /**  Changed the following line by Dhruv/Salini on 21-12-2003 for handling changes in Transaction screens **/
            dsc = new DSConnect("DSConnect");
            p=strutsConfig.findPlugInConfigs();
            rootPath=servlet.getServletContext().getRealPath("/");
            System.out.println(servlet.getServletContext().getRealPath("/"));
            System.out.println("No of plug ins" + p.length + p.toString());
            Map prp=p[0].getProperties();
            System.out.println(prp.containsKey("definitions-config"));
            if(prp.containsKey("definitions-config")){
                PropertyConfigurator.configure(rootPath + prp.get("definitions-config"));

            }
                System.out.println(prp.get("definitions-config"));
        } 
        catch(Exception e) 
        { 
		    // Catch SQL errors
        	//System.out.println("Error while instantiating DSConnect in Plugin");
            e.printStackTrace();
        }          
    }

    /**
    *  This method is used to get an Instance of the Data Source 
    *  @param ActionServlet servlet,ApplicationConfig strutsConfig
    *  @exception ServletException         
    *  @return 
    **/
    public static DSConnect getInstance()
    {
        return dsc;
    }

    /**
    *  This method is used to destory the instance 
    *  @param 
    *  @exception 
    *  @return 
    **/
    public void destroy() 
    {
	    try
	    {
            dsc.finalClose();
	    }
	    catch (Exception e) 
	    {			
            //System.out.println("PlugIn : In Exception in Final Close Connection");
            e.printStackTrace();
	    }    
    }
}


/*

-- Code in Struts Config
   <plug-in className="IBAPackage.InitialPlugIn">
   </plug-in>

-- In action class
   DSConnect dsc = InitialPlugIn.getInstance();
   
   -- Pass dsc to DAO classes
   -- No need to instantiate DSConnect in DAO 

*/