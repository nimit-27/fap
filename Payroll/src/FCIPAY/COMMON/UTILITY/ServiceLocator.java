package FCIPAY.COMMON.UTILITY;

//import wenrgise.sysadmin.ejb.entity.cmp.SysAdminUsersHome;
//import wenrgise.sysadmin.ejb.entity.cmp.SysAdminGroupsHome;
// Java utility class
import java.util.Hashtable;

// JNDI classes
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import FCIPAY.COMMON.UTILITY.ContextProvider;

/**
 * This class is implemented as a singleton class and is a central 
 * place for looking up objects in the JNDI tree.
 */
public class ServiceLocator {
  
  // Cache of objects in JNDI tree
  private Hashtable homeCache;
  
  // Singleton instance
  private static ServiceLocator serviceLocator = new ServiceLocator();
  
  /**
   * Private constructor which initializes all the tables
   */
  private ServiceLocator() {
    try {
      homeCache = new Hashtable();
    } catch(Throwable e)
        {
          e.printStackTrace();;
        }
  }

  /**
   * Method to access the SingleTon instance of the ServiceLocator
   * @return <b>ServiceLocator</b> The instance of this class
   */
  public static ServiceLocator getLocator() {
    return serviceLocator;
  }

  /**
   * Method to return an object in the default JNDI context, with 
   * the supplied JNDI name.
   * @param <b>jndiName</b> The JNDI name
   * @returns <b>Object</b> The object in the JNDI tree for this name.
   * @throws <b>UtilityException</b> Exception this method can throw  
   */
  public Object getService( String jndiName )
                throws Exception {
    try {
      // If the service is not in the cache,
      if( !homeCache.containsKey( jndiName ) ) {
        Context context = FCIPAY.COMMON.UTILITY.ContextProvider.getContext();
        // Get the object for the supplied jndi name and put it in the cache
        System.out.println("Context"+ context.getEnvironment());
       // System.out.println("Context security "+ context.SECURITY_CREDENTIALS);
      System.out.println("Context url is"+ "   "+Context.PROVIDER_URL);
        System.out.println("jndiName : " +context.lookup(jndiName));
        homeCache.put( jndiName, context.lookup(jndiName) );
        
      }
    }catch( Throwable ex ) 
    {
     ex.printStackTrace();
    }
    // Return object from cache
    return homeCache.get( jndiName );
  }

/*private static Context getInitialContext() throws NamingException
  {
    Hashtable env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
    env.put(Context.SECURITY_PRINCIPAL, "admin");
    env.put(Context.SECURITY_CREDENTIALS, "welcome");
    env.put(Context.PROVIDER_URL, "ormi://localhost:23896/current-workspace-app");

    return new InitialContext(env);
  }*/

public static void main(String args[])throws Exception
{
//System.out.println(" i am bfore execution");
//SysAdminGroupsHome home = (SysAdminGroupsHome)ServiceLocator.getLocator().getService("SysAdminGroups");  
//System.out.println(" i am after execution");
}
  
}
