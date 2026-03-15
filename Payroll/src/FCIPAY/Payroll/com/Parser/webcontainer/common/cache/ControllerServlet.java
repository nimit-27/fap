package FCIPAY.Payroll.com.Parser.webcontainer.common.cache;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.com.Parser.util.common.CacheManager;
import FCIPAY.Payroll.com.Parser.util.common.CachedObject;
import FCIPAY.Payroll.com.Parser.util.dan.cache.cacheobject.DANExampleAllCachedObject;

/**
 * @version 	1.0
 * @author
 */
public class ControllerServlet extends HttpServlet implements Servlet {

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
		{

			doPost(req , resp);
		}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

			CachedObject aCachedObject = 
			FCIPAY.Payroll.com.Parser.util.common.CacheManager.getInstance().getCachedObject("category");
			ArrayList aList = ((DANExampleAllCachedObject)aCachedObject).getArrayListValue();
			String sTot = "";			
			for ( int i=0; i < aList.size(); i++ ) {
				sTot += (String)aList.get(i) + "...\n";
			}		
			resp.getWriter().print(sTot);
	}

	/**
	* @see javax.servlet.GenericServlet#void ()
	*/
	public void init() throws ServletException {

		super.init();

	}

}
