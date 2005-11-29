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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.mtrainer.database.*;
import org.mtrainer.datamodel.*;
import org.mtrainer.helpers.Constants;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;


public class LogoutAction extends ActionBase {

	/**
	 * errors used to be displayed in the appl
	 */
	private ActionErrors errors = new ActionErrors();
    

	public LogoutAction() {
		super();
		log.setLevel(Level.ALL);
		ActionErrors errors = new ActionErrors();
	}
	
	  public ActionForward execute( ActionMapping mapping,
              ActionForm form,
              HttpServletRequest request,
              HttpServletResponse response )
	  throws Exception{
		  
		  // retrive the database from the Context.
		  ServletContext context = getServlet().getServletContext();
		  request.getSession().removeAttribute(Constants.USER_KEY);
		  request.getSession().invalidate();
		  return mapping.findForward("success");
	  }

}
