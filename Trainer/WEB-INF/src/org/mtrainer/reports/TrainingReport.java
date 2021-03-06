//package de.laures.cewolf.example;#
package org.mtrainer.reports;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import de.laures.cewolf.DatasetProduceException;
import de.laures.cewolf.DatasetProducer;
import de.laures.cewolf.links.CategoryItemLinkGenerator;
import de.laures.cewolf.tooltips.CategoryToolTipGenerator;

import org.mtrainer.helpers.Constants;

/**
 * An example data producer.
 * @author  Guido Laures
 */
public class TrainingReport implements DatasetProducer, CategoryToolTipGenerator, CategoryItemLinkGenerator, Serializable {

    //private static final Log log = LogFactory.getLog(PageViewCountData.class);

    // These values would normally not be hard coded but produced by
    // some kind of data source like a database or a file
    public DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	/**
	 *  Produces some random data.
	 */
    public Object produceDataset(Map params) throws DatasetProduceException {
    	//log.debug("producing data.");

        return dataset;
    }
    
    public void addData(String series, String category, int yValue) {
    	dataset.addValue(yValue, series, category);
    }
    
    public void addData(String series, String category, float yValue) {
    	dataset.addValue(yValue, series, category);
    }

    /**
     * This producer's data is invalidated after 5 seconds. By this method the
     * producer can influence Cewolf's caching behaviour the way it wants to.
     */
	public boolean hasExpired(Map params, Date since) {
        //log.debug(getClass().getName() + "hasExpired()");
		return (System.currentTimeMillis() - since.getTime())  > 5000;
	}

	/**
	 * Returns a unique ID for this DatasetProducer
	 */
	public String getProducerId() {
		return "PageViewCountData DatasetProducer";
	}

    /**
     * Returns a link target for a special data item.
     */
    public String generateLink(Object data, int series, Object category) {
        // create the url as DRILLDOWN_BASEURL?series=0&category=2005-24
     	return Constants.DRILLDOWN_BASEURL+"?"+ Constants.DRILLDOWN_SERIES_PARAM + "=" 
     	  + series + "&" + Constants.DRILLDOWN_CATEGORY_PARAM + "=" + category;
    }

	/**
	 * @see java.lang.Object#finalize()
	 */
	protected void finalize() throws Throwable {
		super.finalize();
		//log.debug(this + " finalized.");
	}

	/**
	 * @see org.jfree.chart.tooltips.CategoryToolTipGenerator#generateToolTip(CategoryDataset, int, int)
	 */
	public String generateToolTip(CategoryDataset arg0, int series, int arg2) {
		//return seriesNames[series];
		return "ToolTip";
	}

}