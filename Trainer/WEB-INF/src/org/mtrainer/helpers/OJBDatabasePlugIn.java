/*
 * $Header: /home/xubuntu/berlios_backup/github/tmp-cvs/fiffifit/Repository/Trainer/WEB-INF/src/org/mtrainer/helpers/OJBDatabasePlugIn.java,v 1.1 2005/11/29 22:24:19 rmark Exp $
 * $Revision: 1.1 $
 * $Date: 2005/11/29 22:24:19 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999-2002 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Struts", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


package org.mtrainer.helpers;



import javax.servlet.ServletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
// TODO: configurable, which database implementation to use.
import org.mtrainer.database.OJBDatabase; 
import org.mtrainer.helpers.Constants;

/**
 * <p><strong>MemoryDatabasePlugIn</strong> initializes and finalizes the
 * persistent storage of User and Subscription information for the Struts
 * Demonstration Application, using an in-memory database backed by an
 * XML file.</p>
 *
 * <p><strong>IMPLEMENTATION WARNING</strong> - If this web application is run
 * from a WAR file, or in another environment where reading and writing of the
 * web application resource is impossible, the initial contents will be copied
 * to a file in the web application temporary directory provided by the
 * container.  This is for demonstration purposes only - you should
 * <strong>NOT</strong> assume that files written here will survive a restart
 * of your servlet container.</p>
 *
 * @author Craig R. McClanahan
 * @version $Revision: 1.1 $ $Date: 2005/11/29 22:24:19 $
 */

public final class OJBDatabasePlugIn implements PlugIn {


    // ----------------------------------------------------- Instance Variables


    /**
     * The application configuration for our owning module.
     */
    private ModuleConfig config = null;


    /**
     * The {@link MemoryUserDatabase} object we construct and make available.
     */
    private org.mtrainer.database.Database database = null;


    /**
     * Logging output for this plug in instance.
     */
    private Log log = LogFactory.getLog(this.getClass());


    /**
     * The {@link ActionServlet} owning this application.
     */
    private ActionServlet servlet = null;


    // ------------------------------------------------------------- Properties





    // --------------------------------------------------------- PlugIn Methods


    /**
     * Gracefully shut down this database, releasing any resources
     * that were allocated at initialization.
     */
    public void destroy() {

        log.info("Finalizing memory database plug in");

        if (database != null) {
            try {
                database.close();
            } catch (Exception e) {
                log.error("Closing memory database", e);
            }
        }

	servlet.getServletContext().removeAttribute(Constants.DATABASE_KEY);
        database = null;
        servlet = null;
        database = null;
        config = null;

    }


    /**
     * Initialize and load our initial database from persistent storage.
     *
     * @param servlet The ActionServlet for this web application
     * @param config The ApplicationConfig for our owning module
     *
     * @exception ServletException if we cannot configure ourselves correctly
     */
    public void init(ActionServlet servlet, ModuleConfig config)
        throws ServletException {

        log.info("Initializing OJB database plug in for Trainer");

        // Remember our associated configuration and servlet
        this.config = config;
        this.servlet = servlet;

        // Construct a new database and make it available
        database = new OJBDatabase();
        // Make the initialized database available
        servlet.getServletContext().setAttribute(Constants.DATABASE_KEY,
                                                 database);
        log.info("OJB initialization done for Trainer.");


    }

    /**
     * The web application resource path of our persistent database
     * storage file.
     */
    private String pathname = "/WEB-INF/database.xml";

    public String getPathname() {
        return (this.pathname);
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }


}
