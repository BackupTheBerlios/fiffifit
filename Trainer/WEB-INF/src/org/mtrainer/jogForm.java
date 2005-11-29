package org.mtrainer;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.*;
import org.mtrainer.datamodel.*;

import javax.servlet.http.*;
/*
 * Created on Oct 23, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class jogForm extends ActionForm {
	private double kilometers;
	private int minutes;
	private String description;
	private Date traindate;
	private SimpleDateFormat dateFormatter;
	private String dateFormat = "dd.MM.yyyy";
    private Log log = LogFactory.getLog(this.getClass());
    private String type;
    private TrainingType [] types ;
    // action: "new" for new , "edit" for editing existing
    private String action;
    
    private long id;
	
	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Returns the kilometers.
	 */
	public double getKilometers() {
		return kilometers;
	}

	/**
	 * @param kilometers The kilometers to set.
	 */
	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}

	/**
	 * @return Returns the minutes.
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes The minutes to set.
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public jogForm() {
		super();
		// init the date with now
		traindate=new Date(new java.util.Date().getTime());
		// init the date format.
		dateFormatter = new SimpleDateFormat(dateFormat);
		// Fill the list of available Training Types:
		types = new TrainingType [2];
		types[0] = new JoggingType();
		types[1] = new RoadCyclingType();
	}
	
	  public void reset(ActionMapping mapping,
              HttpServletRequest request) {
		  this.kilometers = 0;
		  this.minutes = 0;
	  }

	/**
	 * @return Returns the traindate.
	 */
	public Date getTraindate() {
		return traindate;
	}

	/**
	 * @param traindate The traindate to set.
	 */
	public void setTraindate(Date traindate) {
		this.traindate = traindate;
	}
	
	public String getTrainDateString() {
		return this.dateFormatter.format(traindate);
	}
	  
	public void setTrainDateString(String dateString)  {
		try { 
		this.traindate.setTime( this.dateFormatter.parse(dateString).getTime() );
		} catch (Exception e) {
			System.out.println(e);
			log.error(e);
		}
	}

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Returns the types.
	 */
	public TrainingType[] getTypes() {
		return types;
	}

	/**
	 * @param types The types to set.
	 */
	public void setTypes(TrainingType[] types) {
		this.types = types;
	}

	/**
	 * @return Returns the action.
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action The action to set.
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return Returns the id.
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(long id) {
		this.id = id;
	}

	
	

	
	  
}
