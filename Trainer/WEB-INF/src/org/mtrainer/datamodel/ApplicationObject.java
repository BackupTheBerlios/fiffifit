package org.mtrainer.datamodel;

public class ApplicationObject implements  java.io.Serializable {
	/**
	 * returns a session for given id
	 * @param pDbconnector
	 * @param id
	 * @return
	 */

  protected String owner;
  protected long id;
  protected int status;
  protected java.sql.Date creationDate;
  protected java.sql.Date modificationDate;

  /**
   * initialize the Object
   * owner, status, CreationDate and ModificationDate
   * are set during the Creation.
   */
  public ApplicationObject() {
    status = 0;
    owner = "public";
    initCreationDate();
    touchModificationDate();
  };

  public long getId(){
    return id;
  };
  public void setId(int pNewId){
    id = pNewId;
  };
  public String getOwner(){
    return owner;
  };
  public void setOwner(String pNewOwner){
    owner = pNewOwner;
  };

  public int getStatus(){
    return status;
  };
  public void setStatus(int pNewStatus){
    status = pNewStatus;
  };
  
  public java.sql.Date getModificationDate(){
    return modificationDate;
  };
  public void setModificationDate(java.sql.Date pModificationDate){
    modificationDate = pModificationDate;
  };
  
  public java.sql.Date getCreationDate(){
    return creationDate;
  };
  public void setCreationDate(java.sql.Date pCreationDate){
    creationDate = pCreationDate;
  };
  
  public String toString() {
        return "[" + id + "] owner: " + owner + " status: " + status;
  }
 
  public void initCreationDate(){
    creationDate = new java.sql.Date(new java.util.Date().getTime());
    modificationDate = creationDate;
  }

  public void touchModificationDate(){
    modificationDate = new java.sql.Date(new java.util.Date().getTime());
  }
  

};
