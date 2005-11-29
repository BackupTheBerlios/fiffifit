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

public class LoginForm extends ActionForm {
    private String login;
    private String password;
	

	public LoginForm() {
		super();
	}
	
	  public void reset(ActionMapping mapping,
              HttpServletRequest request) {
		  this.login="";
		  this.password="";
	  }

	/**
	 * @return Returns the login.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login The login to set.
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	
	  
}
