/*
 * Created on Nov 27, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.mtrainer.database;

import java.util.Collection;
import java.util.Iterator;

import org.apache.ojb.broker.PersistenceBroker;
import org.apache.ojb.broker.PersistenceBrokerFactory;
import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.Query;
import org.apache.ojb.broker.query.QueryByCriteria;
import org.apache.ojb.broker.query.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.HashMap;
import java.util.Vector;

import org.mtrainer.datamodel.User;


/**
 * @author rmark
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class OJBDatabase implements Database {

    // private Log log = LogFactory.getLog(this.getClass());
	private class Log extends Object {
		public Log() {
		}
		
		public void info(Object o) {
			System.out.println(o);
		}
	};
	public Log log = new Log();

	protected PersistenceBroker broker;
	
	/**
	 * 
	 */
	public OJBDatabase() {
		try {
			broker = PersistenceBrokerFactory.
			defaultPersistenceBroker();
			System.out.println("got the broker for trainer");
		}
        catch (Throwable t)  {
        		t.printStackTrace();
        }
		
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see quoxit.database.Database#createUser(java.lang.String)
	 */
	public User createUser(String username) {
		User tUser = new User();
		tUser.setLogName(username);
		broker.store(tUser);
		return tUser;
	}

	/* (non-Javadoc)
	 * @see quoxit.database.Database#close()
	 */
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see quoxit.database.Database#findUser(java.lang.String)
	 */
	public User findUser(String username) {
		  Collection tUsers = null;
		  User tUser = null;
	      Criteria crit = new Criteria();
	      crit.addEqualTo("LOGNAME",username);
	      Query tQuery = new QueryByCriteria(User.class, crit);
	      try {
	        tUsers = broker.getCollectionByQuery(tQuery);
	        java.util.Iterator iter = tUsers.iterator();
	        if (iter.hasNext())
	        {
	            tUser = (User)iter.next();
	            System.out.println(tUser);
	        }
	      } catch (Throwable t)  {
        		t.printStackTrace();
        }
	    // log.info("found user:" + tUser.getLogName() + " with pw " + tUser.getPassword() );
	    return tUser;

	}

	/* (non-Javadoc)
	 * @see quoxit.database.Database#findUsers()
	 */
	public User[] findUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see quoxit.database.Database#open()
	 */
	public void open() throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see quoxit.database.Database#removeUser(quoxit.datamodel.User)
	 */
	public void removeUser(User user) {
		// TODO Auto-generated method stub

	}

	public void save(org.mtrainer.datamodel.ApplicationObject object){
		broker.store(object);
	}

	
	public org.mtrainer.datamodel.ApplicationObject getById(java.lang.Class queriedClass, long id) {
		Collection objects = null;
		org.mtrainer.datamodel.ApplicationObject object = null;
		Criteria tCrit = new Criteria();
		tCrit.addEqualTo("ID", new Long(id) );
		Query tQuery = new QueryByCriteria(queriedClass, tCrit);
		try {
		  objects = broker.getCollectionByQuery(tQuery);
		  System.out.println("getById: got objects: " + objects.size());
		  java.util.Iterator iter = objects.iterator();
	              object = (org.mtrainer.datamodel.ApplicationObject) iter.next();
		} catch (Exception e) {
			System.out.println("getById: could not get object " + queriedClass + " with id " + id);
		}
		return object;
	}
	
	public PersistenceBroker getBroker() {
		return broker;
	}

	/**
	 * queries the class with the given criteria and returns an iterator over the 
	 * a Object[number of columns] over all found objects matching the criteria.
	 * Within the attributes you can also give SQL expressions like sum(column).
	 * Be careful about group by, which is not supported by this query.
	 * @param classToQuery
	 * @param criteria
	 * @param columns
	 * @return
	 */
	public Iterator queryObjects(Class classToQuery, HashMap criteria, String[] columns, String[] groupBy) {
		Iterator foundObjects = null;
		Criteria crit = new Criteria();
		Collection results = new Vector();
		log.info(new Integer(criteria.size()));
        crit = toCriteria(criteria);
		ReportQueryByCriteria q = QueryFactory.newReportQuery(classToQuery, crit);
		q.setAttributes(columns);
		if (groupBy != null) {
			q.addGroupBy(groupBy);
		}
		foundObjects = broker.getReportQueryIteratorByQuery(q);
		return foundObjects;
	}
	
	public Collection getObjects(Class classToQuery, HashMap criteria) {
		Collection foundObjects = null;
		QueryByCriteria query = QueryFactory.newQuery(classToQuery, toCriteria(criteria));
		foundObjects = broker.getCollectionByQuery(query);
		return foundObjects;
	}
	
	/**
	 * converts a HashMap into OJB conform Criteria.
	 * @param criteria
	 * @return
	 */
	protected Criteria toCriteria(HashMap criteria) {
		Criteria crit = new Criteria();
		Iterator entry = criteria.keySet().iterator();
		log.info(new Integer(criteria.size()));
		while (entry.hasNext()) {
			String critColumnName = (String) entry.next();
			String critValue = (String) criteria.get(critColumnName);
			log.info("queryObjects" + critColumnName + " " + critValue);
			crit.addLike(critColumnName, critValue);
		}
		return crit;
	}
}
