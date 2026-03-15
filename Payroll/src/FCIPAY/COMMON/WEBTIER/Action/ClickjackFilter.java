package FCIPAY.COMMON.WEBTIER.Action;

import FCIPAY.Payroll.common.exception.BaseException;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.RequestDispatcher;


public class ClickjackFilter implements Filter 
{

    private static final long serialVersionUID = 1L;
    private String mode = "SAMEORIGIN";
    	
    /**
     * Add X-FRAME-OPTIONS response header to tell IE8 (and any other browsers who
     * decide to implement) not to display this content in a frame. For details, please
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse)response;
        res.addHeader("X-FRAME-OPTIONS", mode );
        HttpServletRequest req = (HttpServletRequest)request;
        try{
            validateHostHeader(req,res);
        }catch(Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("../../../ErrorPage.do");
            rd.forward(req, res);
            return;
        }
        
        String sessionid = req.getSession().getId();
        res.setHeader("SET-COOKIE", "JSESSIONID=" + sessionid + "; HttpOnly; Secure");
        chain.doFilter(request, response);
    }
    
    public void destroy() {
    }
    
    public void init(FilterConfig filterConfig) {
        String configMode = filterConfig.getInitParameter("mode");
        if ( configMode != null ) {
            mode = configMode;
        }
    }
    
    private boolean validateHostHeader(HttpServletRequest request1,HttpServletResponse response1) throws Exception {
        String[] valid_hosts=new String[28];
        valid_hosts[0]="localhost";
        /* 
         * Commented Due to Migration to Cloud
            valid_hosts[1]="10.248.225.76";
            valid_hosts[2]="10.248.225.82";
            valid_hosts[3]="164.100.78.188"; //public URL for SIT
            valid_hosts[4]="10.248.225.42";  //server ip of PROD n-1
            valid_hosts[5]="10.248.225.43";  //server ip of PROD n-2
            valid_hosts[7]="10.106.0.219";  //server ip of TEST Server
            valid_hosts[15]="fcifapdr-apps01.nic.in"; //dr host node-1
            valid_hosts[16]="fcifapdr-apps02.nic.in"; //dr host node-2
            valid_hosts[17]="10.160.0.223";           //dr private ip node-1   
            valid_hosts[18]="10.160.0.227";           //dr private ip node-2
            valid_hosts[19]="10.248.225.50";  // load balancer interface
            valid_hosts[20]="10.248.225.51";  // load balancer interface
        */
        //Domains
        valid_hosts[1]="fcitest.in";  //server ip of TEST Server
        valid_hosts[2]="fcidev.in";
        valid_hosts[3]="fcisit.nic.in";
        valid_hosts[6]="fcilekha.in";
        valid_hosts[7]="fcilekha1.in";
        valid_hosts[8]="fcilekha2.in";
        valid_hosts[9]="fcilekha.com";

/*   UAT CLOUD
 *
        valid_hosts[21]="140.238.224.132"; //Cloud 
        valid_hosts[22]="10.0.0.35";//Cloud 
        valid_hosts[23]="fciuat-apps01";//Cloud
*/
  //PROD CLOUD 1
        valid_hosts[10]="155.248.242.193"; //Cloud 
        valid_hosts[11]="10.0.0.219";//Cloud 
        valid_hosts[12]="fciapp1";//Cloud 
 //PROD CLOUD 2
        valid_hosts[13]="144.24.112.55"; //Cloud 
        valid_hosts[14]="10.0.0.220";//Cloud 
        valid_hosts[15]="fciapp2";//Cloud 

        String[] reqheader_Host=(request1.getHeader("Host")).split(":");
        String host_url=reqheader_Host[0];
        int marked=0;
        for (int i=0; i<valid_hosts.length; i++){
            if(host_url.equals(valid_hosts[i])){
                marked=1;
            }
        }
        if (marked==0){
            throw new Exception();
        }
        return true;
    }
}
