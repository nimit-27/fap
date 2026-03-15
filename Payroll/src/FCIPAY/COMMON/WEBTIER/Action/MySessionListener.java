package FCIPAY.COMMON.WEBTIER.Action;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;

public class MySessionListener implements HttpSessionListener{
    public MySessionListener() {
        super();
    }
    private static int sessionCount=0;
    
    public void sessionCreated(HttpSessionEvent se){
        sessionCount++;
        //se.getSession().setAttribute("Secure","Yes");
        //se.getSession().setAttribute("HTTP only","Yes");
        System.out.println("The total no of session created are, "+sessionCount);
    }
    
    public void sessionDestroyed(HttpSessionEvent se){
        if (sessionCount>0){
            sessionCount--;
            System.out.println("The total no of session destroyed are, "+sessionCount);
        }
    }
}
