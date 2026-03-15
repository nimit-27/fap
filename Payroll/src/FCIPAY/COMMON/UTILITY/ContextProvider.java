package FCIPAY.COMMON.UTILITY;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;

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
      Hashtable env = new Hashtable();
      env.put(Context.INITIAL_CONTEXT_FACTORY,"com.evermind.server.rmi.RMIInitialContextFactory");
      env.put(Context.SECURITY_PRINCIPAL, "admin");
      env.put(Context.SECURITY_CREDENTIALS,"welcome");
      env.put(Context.PROVIDER_URL, "ormi://localhost:23891/current-workspace-app");
      ctx = new InitialContext(env);
    }
    catch(Throwable e)
        {
          e.printStackTrace();
        } 
  }

  
  
  /**
   * Singleton access method
   * @return <b>Context</b> stored in Singleton instance of ContextProvider
   */
  public static Context getContext() {
    return objContextProvider.ctx;
  }
}
