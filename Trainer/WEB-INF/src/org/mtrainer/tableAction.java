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
import org.apache.struts.action.ActionMessages;
import org.mtrainer.datamodel.DataFetcher;
import org.mtrainer.datamodel.User;
import java.util.Collection;
import java.util.Vector;

public class tableAction extends AuthorizedAction {

	public tableAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	  public ActionForward executeAuthorized( ActionMapping mapping,
              ActionForm form,
              HttpServletRequest request,
              HttpServletResponse response ,
              ActionMessages errors,
              User user)
	  throws Exception{
		  
		  System.out.println("got parameter: " + request.getParameter("category"));
		  
		  Collection trainings = DataFetcher.getTrainingEntities(dBase, user.getLogName(), null, null);

		  // put the trainings in the session context to be read by the jsp:
		  request.setAttribute(org.mtrainer.helpers.Constants.TABLE_TRAININGS, trainings);
		  
		  
		  
		  
		  return mapping.findForward("success");

	  }

}
