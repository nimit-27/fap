package FCIPAY.Payroll.com.Parser.webcontainer.common.cache;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URL;
import java.util.ArrayList;
import FCIPAY.Payroll.com.Parser.util.common.FWXMLUtility;
import FCIPAY.Payroll.com.Parser.util.common.vo.CacheObjects;
import FCIPAY.Payroll.com.Parser.util.common.vo.CacheObject;
import FCIPAY.Payroll.com.Parser.util.common.CacheManager;
/**
 * @version 	1.0
 * @author
 */
public class PULCacheInitiator extends HttpServlet implements Servlet {

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

	}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

	}

	/**
	* @see javax.servlet.GenericServlet#void ()
	*/
	public void init() throws ServletException {

		super.init();
		try {
		
			URL uRL = getServletConfig().getServletContext().getResource("/WEB-INF");
			String defaultConfigLocation = (null != uRL)?uRL.toString () : null;

			defaultConfigLocation = (null != defaultConfigLocation) ? defaultConfigLocation
				.substring (defaultConfigLocation.indexOf (":") + 1) 
				+ "config" : "";		
				
			String fileName = getServletConfig().getInitParameter("InitFileName");	
			String initFileWithLocation = defaultConfigLocation + "/" + fileName;
			System.out.println("Hello: " + initFileWithLocation);
			populateCachedObjects(initFileWithLocation);
			
		}
		catch (Throwable e) {
			e.printStackTrace();
			throw new javax.servlet.ServletException(e);
		}

	}
	
	private void populateCachedObjects(String initFileWithLocation) throws Exception {
		
		//File aFile = new File(initFileWithLocation);
		CacheObjects aCacheObjects = 
			(CacheObjects)FCIPAY.Payroll.com.Parser.util.common.FWXMLUtility.xmlToObject("com.tcs.wenrgise.util.common.vo.CacheObjects", initFileWithLocation);
		
		FCIPAY.Payroll.com.Parser.util.common.CacheManager.getInstance().init(aCacheObjects);
	}

}
