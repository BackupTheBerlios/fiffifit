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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;


public class jogAction extends AuthorizedAction {
    /**
     * Logging output for this plug in instance.
     */
    //private Log log = LogFactory.getLog(this.getClass());
	private Logger log = Logger.getLogger(this.getClass());
    

	public jogAction() {
		super();
		log.setLevel(Level.ALL);
	}
	
	  public ActionForward executeAuthorized( ActionMapping mapping,
              ActionForm form,
              HttpServletRequest request,
              HttpServletResponse response ,
              ActionMessages errors,
              User user)
	  throws Exception{
		  
		  
		  
		  jogForm trainingInput = (jogForm)form;
		  TrainingEntity te = null;
		  
		  
		  // check if we are working on an existing entity:
		  if ( Constants.TRAIN_ACTION_MODIFY.equals ( trainingInput.getAction() ) ) {
			  log.info("existing jog form!");
			  System.out.println("jogAction: existing!");
			  long id = trainingInput.getId();
			  te = (TrainingEntity) dBase.getById(TrainingEntity.class,id);
		  } else {
			  // create a new TrainingEntity to save to the database.
			  System.out.println("jogAction: new!!");
			  te = new TrainingEntity();
			  te.setOwner(user.getLogName());

		  }
		  

		  // set parameters due to the input form
		  te.setLengthKilometers(trainingInput.getKilometers());
		  te.setDurationMinutes(trainingInput.getMinutes());
		  te.setDate(trainingInput.getTraindate());
		  te.setTrainingTypeString(trainingInput.getType());
		  te.setRemark(trainingInput.getDescription());
		  // save it to the database.
		  dBase.save(te);
		  log.info("training object saved successfully");
		  // return to the GUI.
		  trainingInput.setId(te.getId());
		  trainingInput.setAction(Constants.TRAIN_ACTION_MODIFY);
		  return mapping.findForward("success");
	  }

}
