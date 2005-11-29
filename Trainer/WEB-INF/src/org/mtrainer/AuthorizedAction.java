/*
 * Created on Nov 26, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.mtrainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.mtrainer.datamodel.User;
import org.mtrainer.helpers.Constants;

public abstract class AuthorizedAction extends ActionBase {

	public AuthorizedAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	  public ActionForward execute( ActionMapping mapping,
              ActionForm form,
              HttpServletRequest request,
              HttpServletResponse response )
	  throws Exception{
		  ActionMessages errors = new ActionMessages();

		  
		  // retrive the database from the Context.
		  getDataBase(request, response);
		  
		  // check for user:
		  org.mtrainer.datamodel.User user = checkLogin(request, response);
		  if ( user == null ) {
			  errors.add("", new ActionMessage("errors.notloggedin"));
			  this.saveErrors(request, errors);
			  return mapping.findForward("login");
		  }
	  
		  ActionForward target =  executeAuthorized(mapping,
               form,
               request,
               response,
               errors, user);
		  // save errors which may be returned from executeAuthorized()
		  this.saveErrors(request, errors);
		  // forward to the target given by executeAuthorized()
		  return target;
		  
		  
		  
	  }
	  
	  /**
	   * this method has to be overwritten by subclasses
	   * @param mapping
	   * @param form
	   * @param request
	   * @param response
	   * @param errors
	   * @return
	   * @throws Exception
	   */
	  public abstract ActionForward executeAuthorized( ActionMapping mapping,
              ActionForm form,
              HttpServletRequest request,
              HttpServletResponse response,
              ActionMessages errors,
              User user)
	  throws Exception;


	

}
