package FCIPAY.Payroll.common.utility;

// Java utility class
import java.util.Hashtable;
import java.util.HashMap;


// JNDI classes
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import FCIPAY.Payroll.common.utility.ContextProvider;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import javax.ejb.EJBLocalHome;
/**
 * This class is implemented as a singleton class and is a central 
 * place for looking up objects in the JNDI tree.
 */
public class ServiceLocator {
  
  // Cache of objects in JNDI tree
  private HashMap homeCache;
  private final HashMap cacheMap = new HashMap();
  
  // Singleton instance
  private static ServiceLocator serviceLocator = new ServiceLocator();
  
  /**
   * Private constructor which initializes all the tables
   */
  private ServiceLocator() {
    try {

      homeCache = new HashMap();
    } catch(Throwable e)
        {
          e.printStackTrace();
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
     * @param jndiName
     * @return
     * @throws UtilityException Exception this method can throw
     * @throws EnrgiseSystemException
     * @param jndiName The JNDI name
     * @returns Object The object in the JNDI tree for this name.
     */
  public Object getService( String jndiName ) throws EnrgiseSystemException
  {
    try
    {
      // If the service is not in the cache,
      if(!homeCache.containsKey(jndiName))
      {
      
        Context context = FCIPAY.Payroll.common.utility.ContextProvider.getContext();
		System.out.println("Finding " + jndiName);
        homeCache.put( jndiName, context.lookup(jndiName) );
		System.out.println("Found " + jndiName);		
        // Get the object for the supplied jndi name and put it in the cache
        //System.out.println("Context"+ context.getEnvironment());
       // System.out.println("Context security "+ context.SECURITY_CREDENTIALS);
      //System.out.println("Context url is"+ "   "+Context.PROVIDER_URL);
        //System.out.println("jndiName : " +context.lookup(jndiName));        
      }
    }catch( NamingException oNa) 
   {
      System.out.println("Not Foumd");
      throw new EnrgiseSystemException(jndiName,oNa);      
      //throw new EnrgiseSystemException("Payroll.EnqPayImg.txtEmpNo",oNa);      
      //throw new EnrgiseSystemException(oNa);
   }
    // Return object from cache
    return homeCache.get( jndiName );
  }



    public EJBLocalHome getLocalHome(String jndiHomeName)
    throws EnrgiseSystemException {
      EJBLocalHome home = null;
      try { 
       Context context = new InitialContext();
        if (cacheMap.containsKey(jndiHomeName)) {
            home = (EJBLocalHome) cacheMap.get(jndiHomeName);
        } else {         
            home = (EJBLocalHome) context.lookup(jndiHomeName);
            cacheMap.put(jndiHomeName, home);
        }
       } catch (NamingException ne) {
            ne.printStackTrace();
            throw new EnrgiseSystemException(ne); 
       } 
       return home;
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

  /**
     * Method to return an object in the default JNDI context, with
     * the supplied JNDI name.
     * @param jndiName
     * @return
     * @throws UtilityException Exception this method can throw
     * @throws EnrgiseSystemException
     * @param jndiName The JNDI name
     * @returns Object The object in the JNDI tree for this name.
     */
  public Object getDbService( String jndiName ) throws EnrgiseSystemException
  {
    try
    {
      // If the service is not in the cache,
      if(!homeCache.containsKey(jndiName))
      {
      
       // Context context = FCIPAY.Payroll.common.utility.ContextProvider.getContext();
       Context context=new InitialContext();
		//System.out.println("Finding " + jndiName);
        homeCache.put( jndiName, context.lookup(jndiName) );
		//System.out.println("Found " + jndiName);		
        // Get the object for the supplied jndi name and put it in the cache
        //System.out.println("Context"+ context.getEnvironment());
       // System.out.println("Context security "+ context.SECURITY_CREDENTIALS);
      //System.out.println("Context url is"+ "   "+Context.PROVIDER_URL);
        //System.out.println("jndiName : " +context.lookup(jndiName));        
      }
    }catch( NamingException oNa) 
   {
      //throw new EnrgiseSystemException(jndiName,oNa);      
      //throw new EnrgiseSystemException("Payroll.EnqPayImg.txtEmpNo",oNa);      
    //System.out.println("Not Foumd");
     throw new EnrgiseSystemException(oNa);
   }
    // Return object from cache
    return homeCache.get( jndiName );
  }

  
}
