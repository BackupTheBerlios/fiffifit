/*
 * Created on Nov 28, 2005
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
import org.mtrainer.datamodel.User;
import org.mtrainer.datamodel.TrainingEntity;
import org.mtrainer.helpers.Constants;

public class LoadTrainingEntity extends AuthorizedAction {

	public LoadTrainingEntity() {
		super();
		
	}

	public ActionForward executeAuthorized(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMessages errors, User user)
			throws Exception {
		// TODO Auto-generated method stub
		long id = Integer.parseInt(request.getParameter("id"));
		
		TrainingEntity training = (TrainingEntity) dBase.getById(TrainingEntity.class, id);
		jogForm trainingForm = (jogForm) form;
		trainingForm.setDescription(training.getRemark());
		trainingForm.setKilometers(training.getLengthKilometers());
		trainingForm.setMinutes(training.getDurationMinutes());
		trainingForm.setTraindate(training.getDate());
		trainingForm.setId(id);
		trainingForm.setType(training.getTrainingTypeString());
		trainingForm.setDescription(training.getRemark());
		trainingForm.setAction(Constants.TRAIN_ACTION_MODIFY);
		
		return mapping.findForward("success");
	}

}
