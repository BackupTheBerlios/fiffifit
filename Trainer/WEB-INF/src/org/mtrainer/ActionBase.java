/*
 * Created on Oct 23, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.mtrainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;
import org.mtrainer.database.*;
import org.mtrainer.datamodel.*;
import org.mtrainer.helpers.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;


public class ActionBase extends Action {
	protected Database dBase = null;
//	protected User user; 
    /**
     * Logging output for this plug in instance.
     */
    //private Log log = LogFactory.getLog(this.getClass());
	protected Logger log = Logger.getLogger(this.getClass());
    

	public ActionBase() {
		super();
		log.setLevel(Level.ALL);
	}
	
	/**
	 * checks if the http context contains a valid user object
	 * @param request
	 * @param response
	 * @return
	 * @throws Throwable
	 */
	public User checkLogin(HttpServletRequest request,
            HttpServletResponse response ) throws Exception {
		  // retrive the database from the Context.
		  ServletContext context = getServlet().getServletContext();
		  ActionMessages errors = new ActionMessages();

		  User user = (User)request.getSession().getAttribute(Constants.USER_KEY);
		  if (user == null) { 
			  log.error("no user object found in context");
			  return null;
		  } else {
			  log.info("found user " + user.getLogName() + " in the context.");
			  return user;
		  }

	}
	
	
	/**
	 * fetches the database and stores it in the database object.
	 * @param request
	 * @param response
	 * @throws Throwable
	 */
	public void getDataBase(HttpServletRequest request,
            HttpServletResponse response ) throws Exception {
		  // retrive the database from the Context.
		  ServletContext context = getServlet().getServletContext();
		  dBase = (Database) context.getAttribute(Constants.DATABASE_KEY);		  
	}
	
	

}
