package com.rent.car.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.rent.car.helper.Debug;
//import com.rent.car.helper.RentCarException;

@WebListener
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
	private static Connection dbConnection = null;
	private static Debug debug = null; 
	
	public static Connection createConnection(String dbName, String port, String userName, String password)	{
		try	{
			String timeZoneCorrection = "?serverTimezone=" + TimeZone.getDefault().getID();
			
			debug.printMessage("createConnection", "opening the database connection at port: " + port);
			Class.forName("com.mysql.jdbc.Driver");
			ContextListener.dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + dbName + timeZoneCorrection, userName, password);
			return ContextListener.dbConnection;
		}
		catch(ClassNotFoundException | SQLException e)	{
			debug.printMessage("createConnection", "unable to open database connection");
			return null;
		}
	}
	
	public static void closeConnection(ServletContextEvent arg0)	{
		
		//Closing the dbConnection
        try {
        	debug.printMessage("closeConnection", "connection is being destroyed.");
			ContextListener.dbConnection.close();
			arg0.getServletContext().setAttribute("dbConnection", null);
		}
        catch (SQLException e) {
			debug.printMessage("closeConnection", "unable to close database connection.");
			e.printStackTrace();
		}
	}

    public ContextListener() {
    	debug = new Debug();
    	
    	//Setting the debug status
    	debug.setPrintLog(true);
    }

    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
    }

    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
    }
    
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
    }
    
    public void contextInitialized(ServletContextEvent arg0)  {
    	arg0.getServletContext().setAttribute("dbConnection", ContextListener.createConnection("car_rent", "3306", "root", ""));
    }

    public void contextDestroyed(ServletContextEvent arg0)  {
    	
    	//Closing the dbConnection
    	ContextListener.closeConnection(arg0);
    }

//    public static Connection useContextConnection() throws RentCarException	{
//    	if(ContextListener.dbConnection == null)	{
//    		debug.printMessage("useContextConnection", "connection is not established yet by ContextListener");
//    		throw new RentCarException("connection is not yet made you can't use this connection");
//    	}
//    	else	{
//    		debug.printMessage("useContextConnection", "connection active and passed");
//    		return ContextListener.dbConnection;
//    	}
//    }
}
