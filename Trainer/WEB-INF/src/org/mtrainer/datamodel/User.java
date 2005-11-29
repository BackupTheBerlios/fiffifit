package org.mtrainer.datamodel;

import java.sql.Date;




public class User extends ApplicationObject {
  private String logName;
  private String password;
  private java.sql.Date lastLogin;
  private String firstName;
  private String lastName;
//  private Date creationDate;
//  private Date modificationDate;
  

  public String getLogName(){
    return logName;
  }
  public void setLogName(String pName) {
    logName = pName;
  }

  public String getPassword(){
    return password;
  }
  public void setPassword(String pPassword) {
    password = pPassword;
  }

  public void setLastLogin(java.util.Date pDate) {
    lastLogin = (java.sql.Date)pDate;
  }
  


/**
 * @return
 */
public String getFirstName() {
	return firstName;
}

/**
 * @return
 */
public String getLastName() {
	return lastName;
}

/**
 * @param string
 */
public void setFirstName(String string) {
	firstName = string;
}

/**
 * @param string
 */
public void setLastName(String string) {
	lastName = string;
}

}
