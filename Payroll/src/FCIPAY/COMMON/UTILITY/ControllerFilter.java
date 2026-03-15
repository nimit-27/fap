/*
 * Program      : ControllerFilter.java
 * Author       : Dhruv Ratna Singh
 * Date Written : 15/06/2004
 * Description  : This class is used to take care of the security issues as regards
 *                1) Accessing the application through the History in the Internet Explorer
 *                2) Accessing the application through files stored on the PC & DeskTop
 *                3) Tampering the JSP files including java script validations
 *                4) Accessing the application through files received by mode of msil, ftp
 *                
 *                It also centalizes the caching of the JSPS of the application
 * Revision Log :   Balram has changed the package from com.xport.portal.controller to IBA.COMMON.UTILITY
 *                  and added URLs for the Tarapur,Kakrapar sites on 19/10/2004  
 *-------------------------------------------------------
*/
//package com.xport.portal.controller;
package FCIPAY.COMMON.UTILITY;
import FCIPAY.COMMON.UTILITY.MsgLogger;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;



public class ControllerFilter implements Filter
{
    /**
    * This Method is used to retrieve values for populating the list box
    * @param       : ArrayList oiArrList,String sQuery,String Id,String Name,int Type
    * @exception   : 
    * @return      : return true if success else false.
    */

    private MsgLogger msgLogger;
   
	public ControllerFilter()
	{
		msgLogger = (MsgLogger)FCIPAY.COMMON.UTILITY.MsgLogger.getLogger(this);
	}
   
	public void init(FilterConfig filterconfig)
	{
    
	}

    /**
    * This Method performs the caching of the pages. It checks the session status, URI,
    * hdnAction hidden parameter of the Login Page & appropriately forwards to the Login
    * Page if required.
    * @param       : ServletRequest req, ServletResponse res, FilterChain filterchain
    * @exception   : IOException, ServletException
    * @return      : return true if success else false.
    */
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterchain) throws IOException, ServletException
	{	
        String appURI =  "/Payroll/Login.do";
        
        //for maker towers
        String loginURL = "http://172.17.23.242:7778/Payroll/Login.do";

        //for test server
        //String loginURL = "http://10.10.2.70:7778/NPCIL-IBA-context-root/Login.do";

        //for production server
        //String loginURL = "http://10.10.2.80:7778/NPCIL-IBA-context-root/Login.do";

        //for tarapur
        //String loginURL = "http://10.22.2.22:7778/NPCIL-IBA-context-root/Login.do";

        //for kakrapar
        //String loginURL = "http://10.30.2.20:7778/NPCIL-IBA-context-root/Login.do";
        
        
		((HttpServletResponse)res).setHeader( "Cache-Control", "no-cache, must-revalidate, max-age=0, proxy-revalidate" );
		((HttpServletResponse)res).setDateHeader( "Expires", 0 );
		((HttpServletResponse)res).setHeader( "Pragma", "no-cache");
		
		HttpSession session = ((HttpServletRequest)req).getSession(false);
        msgLogger.logERROR("The value of session is<" + session + ">");
        String token = req.getParameter("hdnAction");
        String currentURI = ((HttpServletRequest)req).getRequestURI();

        msgLogger.logERROR("<The value of token is: >" + token);
        msgLogger.logERROR("<The value of appURI is: >" + appURI);
        msgLogger.logERROR("<The value of loginURL is: >" + loginURL);
        msgLogger.logERROR("<The value of currentURI is: >" + currentURI);
             
        if ( session!=null )
        {           
            if( !( 
                (session.isNew() && (token != null && (!token.equals("GetLocDetails"))))
                
                ||
                
                (token != null && token.equals("GetLocDetails"))   

                ||
                
                (!session.isNew())
                
              ) ) 
            {
                msgLogger.logERROR("The session is not null and sending to Login Page");
                ((HttpServletResponse)res).sendRedirect(loginURL);                                                                                 
            }            
        }
/*        else
        {
            if( !( ((HttpServletRequest)req).getRequestURI().compareTo(appURI) == 0  ) )             
            {      
                msgLogger.logERROR("The session is null and sending to Login Page");
                ((HttpServletResponse)res).sendRedirect(loginURL);                                                        
            }
        }*/
        if(token != null && token.equals("Logout"))
		{
			if(session != null)
			{
                msgLogger.logERROR("Session invalidated");
			    session.invalidate();			    
			}
			((HttpServletResponse)res).sendRedirect(loginURL);                                                        
		}        	        
		filterchain.doFilter(req, res	);
	}
       
	public void destroy()
	{
    
	}
}