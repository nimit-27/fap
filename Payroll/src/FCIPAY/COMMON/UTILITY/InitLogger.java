package FCIPAY.COMMON.UTILITY;
/**
* Module:        InitLogger.java
* Author:        Anand Balasubramanian
* Date Written:  13/03/2004
* Description:  This class is used to initialize log4j
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.*;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitLogger extends HttpServlet 
{
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    private String logConfigFilePath =  null;
    private String rootPath=null;
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        this.rootPath= getServletContext().getRealPath("/");
        if (this.logInit()){
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType(CONTENT_TYPE);
        /*  
            this.logConfigFilePath = getInitParameter("log4j-init-file");
            System.out.println("Log File Path" + rootPath + logConfigFilePath);
        */
    }
     /**
     * This method Initializes  logging set up
     * @return boolean if the configuration succeeded or not
     */
    private boolean logInit(){
        boolean configured = false;
        try{
            this.logConfigFilePath = getInitParameter("log4j-init");
            System.out.println("CONFIGURING  LOGGING WITH " + this.rootPath + logConfigFilePath );
            if(logConfigFilePath != null){
        		PropertyConfigurator.configure(this.rootPath + logConfigFilePath);
                configured = true;
            }
            return configured;            
    	}
        catch(Exception e ){
            System.out.println("EXCEPTION WHILE CONFIGURING LOG4J" + e);
            e.printStackTrace();
        }
        return configured;
    }
}