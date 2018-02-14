import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Hashtable;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class RootServlet extends HttpServlet {
    private static MBeanServerConnection connection;
    private static JMXConnector connector;
    private static final ObjectName service;
    
    // Initializing the object name for DomainRuntimeServiceMBean
    // so it can be used throughout the class.
    static {
       try {
          service = new ObjectName("com.bea:Name=DomainRuntimeService,Type=weblogic.management.mbeanservers.domainruntime.DomainRuntimeServiceMBean");
       }catch (MalformedObjectNameException e) {
          throw new AssertionError(e.getMessage());
       }
    }

     
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws MalformedObjectNameException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, ReflectionException, IOException {
	       response.sendError(503);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (MalformedObjectNameException | AttributeNotFoundException | InstanceNotFoundException | MBeanException	| ReflectionException e) {
		
			e.printStackTrace();
		}
	}
}