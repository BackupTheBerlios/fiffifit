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
import org.apache.log4j.Logger;
import org.apache.log4j.Level;


public class LoginAction extends ActionBase {
	private Database dBase = null;
    /**
     * Logging output for this plug in instance.
     */
    //private Log log = LogFactory.getLog(this.getClass());
	private Logger log = Logger.getLogger(this.getClass());
    

	public LoginAction() {
		super();
		log.setLevel(Level.ALL);
	}
	
	  public ActionForward execute( ActionMapping mapping,
              ActionForm form,
              HttpServletRequest request,
              HttpServletResponse response )
	  throws Exception{
		  ActionMessages errors = new ActionMessages();
		  
		  // retrive the database from the Context.
		  ServletContext context = getServlet().getServletContext();
		  dBase = (Database) context.getAttribute(Constants.DATABASE_KEY);		  
		  	  

		  // set parameters due to the input form
		  String login = ((LoginForm)form).getLogin();
		  String password = ((LoginForm)form).getPassword();
		  errors.clear();
		  this.saveErrors(request,errors);

		  // verify the user!
		  User user = dBase.findUser(login);
		  if (user == null) {
			  errors.add("login",new ActionMessage("errors.nosuchuser"));
			  this.saveErrors(request, errors);
			  return mapping.findForward("failure");
		  }
		  if (user.getPassword().equals(password)) {
			  request.getSession().setAttribute(Constants.USER_KEY,user);
			  return mapping.findForward("success");
		  } else {
			  errors.add("password", new ActionMessage("errors.wrongpassword"));
			  this.saveErrors(request, errors);
			  return mapping.findForward("failure");
		  }
		  
	  }

}
