package FCIPAY.Payroll.common.utility;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

/**
 * This class maintains the JNDI context
 */
public class ContextProvider {
  // Holds the JNDI context
  private Context ctx = null;
  
  // Singleton class
  private static ContextProvider objContextProvider = new ContextProvider();
  
  /**
   * Default private constructor.
   * Instantiates the JNDI context according to the properties stored
   * in UUBaseProperties.xml file
   */
  private ContextProvider() {
    try
    {
      Properties env1=System.getProperties();
   //   env.put(Context.INITIAL_CONTEXT_FACTORY,"com.evermind.server.rmi.RMIInitialContextFactory");
  //    env.put(Context.SECURITY_PRINCIPAL, "admin");
 //    env.put(Context.SECURITY_CREDENTIALS,"welcome");
      
      // FOR DEVELOPMENT PURPOSE(ON JDev)
 //     env.put(Context.PROVIDER_URL, "ormi://192.168.106.69:23891/current-workspace-app");
     
      // FOR DEPLOYMENT PURPOSE(ON 9iAS)
  //  env.put(Context.PROVIDER_URL, "ormi://localhost:3101/Payroll");

      // FOR DEPLOYMENT PURPOSE(ON 10gAS Win)
//   env.put(Context.PROVIDER_URL, "ormi://localhost:12401/Payroll");
         // FOR DEPLOYMENT PURPOSE(ON 10gAS Solaris)
   //   env.put(Context.PROVIDER_URL, "opmn:ormi://localhost:6003/FCIPAY/Payroll");
//   env.put(Context.PROVIDER_URL,"ormis://localhost:12701/default");
    
//       env.put(Context.PROVIDER_URL, "ormi://172.18.16.109:3101/PayrollProd");


/*      env.put(Context.INITIAL_CONTEXT_FACTORY,"com.evermind.server.ApplicationInitialContextFactory");
    //  env.put(Context.SECURITY_PRINCIPAL, "oc4jadmin");
     // env.put(Context.SECURITY_CREDENTIALS, "");
      env.put(Context.PROVIDER_URL,"ormis://localhost:12701/default");
      opmn:ormi://myServer:oc4j_inst1/ejbsamples
*/
      ctx = new InitialContext(env1);
      System.out.println("Inside ContextProvider ::: ctx :::"+ctx);
    }
    catch(Throwable e)
        {
          e.printStackTrace();
        } 
  }  
  
  /**
   * Singleton access method
   * 
   * 
   * @return <b>Context</b> stored in Singleton instance of ContextProvider
   */
  public static Context getContext() {
    return objContextProvider.ctx;
  }
}
