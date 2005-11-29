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
import org.apache.struts.action.ActionMessages;
import org.mtrainer.database.*;
import org.mtrainer.datamodel.*;
import org.mtrainer.helpers.Constants;
import org.mtrainer.reports.TrainingReport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class TrainingReportAction extends AuthorizedAction {
	private TrainingReport reportData = null;
	/**
	 * Logging output for this plug in instance.
	 */
	private Log log = LogFactory.getLog(this.getClass());
	
	public TrainingReportAction() {
		super();		
	}
	
	public ActionForward executeAuthorized( ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response, ActionMessages errors, User user)
	throws Exception{
		
		
		//TODO: here we should rather get the data from the DB!
		reportData = new TrainingReport();
		
		DataFetcher.monthlyReview(dBase,reportData, "Cycling", user.getLogName());
		DataFetcher.monthlyReview(dBase,reportData, "Jogging", user.getLogName());
		
		
		request.getSession().setAttribute(Constants.REPORT_KEY,reportData);  
		
		
		
		
		return mapping.findForward("success");
	}
	
}
