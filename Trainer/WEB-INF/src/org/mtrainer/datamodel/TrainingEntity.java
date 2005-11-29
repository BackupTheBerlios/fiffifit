/*
 * Created on Oct 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.mtrainer.datamodel;

import org.mtrainer.datamodel.*;

public class TrainingEntity extends ApplicationObject {
	   // properties for this object:
	   // duration of the training session in minutes
	   private int durationMinutes;
	   // length of the training course:
	   private double lengthKilometers;
	   // link to a training type:
	   private TrainingType trainingType;
	   // string to save the training type:
	   private String trainingTypeString;
	   // special remarks about this training:
	   private String remark;
	   // date of the training:
	   private java.sql.Date date;
	   

	public TrainingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return Returns the durationMinutes.
	 */
	public int getDurationMinutes() {
		return durationMinutes;
	}

	/**
	 * @param durationMinutes The durationMinutes to set.
	 */
	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	/**
	 * @return Returns the lengthKilometers.
	 */
	public double getLengthKilometers() {
		return lengthKilometers;
	}

	/**
	 * @param lengthKilometers The lengthKilometers to set.
	 */
	public void setLengthKilometers(double lengthKilometers) {
		this.lengthKilometers = lengthKilometers;
	}

	/**
	 * @return Returns the remark.
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark The remark to set.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return Returns the trainingType.
	 */
	public TrainingType getTrainingType() {
		return trainingType;
	}

	/**
	 * @param trainingType The trainingType to set.
	 */
	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
		this.trainingTypeString = trainingType.getName();
	}

	/**
	 * @return Returns the date.
	 */
	public java.sql.Date getDate() {
		return date;
	}

	/**
	 * @param date The date to set.
	 */
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
	/**
	 * unused Method!!! one could use constructs like this to 
	 * get a more dynamic (configurable) datamodel...
	 * @param name
	 * @param value
	 * @throws Exception
	 */
	public void setProperty(String name, ApplicationObject value) throws Exception {
		Class[] args  = new Class[1];
		args[0]=value.getClass();
		ApplicationObject[] argValue = new ApplicationObject[1];
		argValue[0] = value;
		this.getClass().getMethod(name, args).invoke(this,argValue);
	}

	/**
	 * @return Returns the trainingTypeString.
	 */
	public String getTrainingTypeString() {
		return trainingTypeString;
	}

	/**
	 * @param trainingTypeString The trainingTypeString to set.
	 */
	public void setTrainingTypeString(String trainingTypeString) {
		this.trainingTypeString = trainingTypeString;
	}



}
