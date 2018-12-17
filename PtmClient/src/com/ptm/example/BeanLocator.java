package com.ptm.example;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BeanLocator 
{
	private static final String WILDFLY_CTX_CLASS_NAME = "org.wildfly.naming.client.WildFlyInitialContextFactory";
	private static final String EAR_NAME = "SolverEAR";
	private static final String EJB_JAR_NAME = "PtmEJB";
	
	private static final String SERVER_IP = "localhost";
	private static final int SERVER_PORT = 8080;
	private static final String SERVER_FULL_IP = SERVER_IP + ":" + SERVER_PORT;
	
	
	@SuppressWarnings("unchecked")
	public static <T> T lookupStatelessBean(Class<T> clz, String beanName) throws NamingException 
	{
		final Context context = createContext();
        return (T) context.lookup("ejb:"+EAR_NAME+"/"+EJB_JAR_NAME+"/"+beanName+"!"
                + clz.getName());
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T lookupStatefulBean(Class<T> clz, String beanName) throws NamingException {
		final Context context = createContext();
        return (T) context.lookup("ejb:"+EAR_NAME+"/"+EJB_JAR_NAME+"/"+beanName+"!"
                + clz.getName() + "?stateful");
	}

	private static Context createContext() throws NamingException 
	{
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, WILDFLY_CTX_CLASS_NAME);
        if(Boolean.getBoolean("http")) {
            //use HTTP based invocation. Each invocation will be a HTTP request
            jndiProperties.put(Context.PROVIDER_URL,"http://"+SERVER_FULL_IP+"/wildfly-services");
        } else {
            //use HTTP upgrade, an initial upgrade request is sent to upgrade to the remoting protocol
            jndiProperties.put(Context.PROVIDER_URL,"remote+http://"+ SERVER_FULL_IP);
        }
        final Context context = new InitialContext(jndiProperties);
		return context;
	}
}
