/*
 * Created on Nov 9, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.mtrainer.datamodel;

import org.mtrainer.database.Database;
import java.util.Iterator;

import org.mtrainer.reports.TrainingReport;

import java.util.HashMap;
import java.util.Date;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Collection;


public class DataFetcher {

	public DataFetcher() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public static void monthlyReview(Database dbase, TrainingReport report, String type, String owner ){
		HashMap criteria = new HashMap(0);
		// now MYSQL specific!
		criteria.put("TRAINTYPE",type);
		criteria.put("OWNER", owner);
		//String[] colums = {"year(TRAINDATE)", "month(TRAINDATE)","sum(DURATION)"};
		//String[] groupBy = {"year(TRAINDATE)","month(TRAINDATE)"};
		String[] colums = {"date_format(TRAINDATE,'%Y-%m')","sum(DURATION)"};
		String[] groupBy = {"date_format(TRAINDATE,'%Y-%m')"};
		//colums = new String[] {"TRAINDATE","DURATION"};
		//groupBy = null;
	
		Iterator objects = dbase.queryObjects(TrainingEntity.class, criteria, colums, groupBy );
		java.lang.Object[] result = null;
		String xvalue = null;
		float yfloat = 0;
		int yvalue = 0;
		while (objects.hasNext()) {
			result = (java.lang.Object[]) objects.next();
			//xvalue = "D"+result[1].toString() + "-"+ result[0].toString().substring(0,4);
			xvalue = result[0].toString();
			yfloat = Float.parseFloat(result[1].toString());
			yvalue = Math.round(yfloat);
			report.addData(type, xvalue , yvalue);
		}
	}
	
	/**
	 * returns all Training Actions of the user given by Owner.
	 * @param dbase
	 * @param owner
	 * @return
	 */
	public static Collection getTrainingEntities(Database dbase, String owner, java.sql.Date fromDate, java.sql.Date toDate) {
		Collection entities = null;
		HashMap criteria = new HashMap();
		criteria.put("OWNER", owner);
		entities = dbase.getObjects(TrainingEntity.class, criteria );
		System.out.println("got " + entities.size() + "items.");
		return entities;
	}
}
