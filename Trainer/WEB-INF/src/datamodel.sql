-- MySQL dump 8.22
--
-- Host: calvin    Database: quoxit
---------------------------------------------------------
-- Server version	3.23.55-log
drop table OJB_DLIST         ;
drop table OJB_DLIST_ENTRIES ;
drop table OJB_DMAP          ;
drop table OJB_DMAP_ENTRIES  ;
drop table OJB_DSET          ;
drop table OJB_DSET_ENTRIES  ;
drop table OJB_HL_SEQ        ;
drop table OJB_LOCKENTRY     ;
drop table OJB_NRM           ;
drop table MTUSER            ;


--
-- Table structure for table 'OJB_DLIST'
--

CREATE TABLE OJB_DLIST (
  ID int(11) NOT NULL default '0',
  SIZE_ int(11) default NULL,
  PRIMARY KEY  (ID)
) TYPE=MyISAM;

--
-- Dumping data for table 'OJB_DLIST'
--



--
-- Table structure for table 'OJB_DLIST_ENTRIES'
--

CREATE TABLE OJB_DLIST_ENTRIES (
  ID int(11) NOT NULL default '0',
  DLIST_ID int(11) NOT NULL default '0',
  POSITION_ int(11) default NULL,
  OID_ longblob,
  PRIMARY KEY  (ID)
) TYPE=MyISAM;

--
-- Dumping data for table 'OJB_DLIST_ENTRIES'
--



--
-- Table structure for table 'OJB_DMAP'
--

CREATE TABLE OJB_DMAP (
  ID int(11) NOT NULL default '0',
  SIZE_ int(11) default NULL,
  PRIMARY KEY  (ID)
) TYPE=MyISAM;

--
-- Dumping data for table 'OJB_DMAP'
--



--
-- Table structure for table 'OJB_DMAP_ENTRIES'
--

CREATE TABLE OJB_DMAP_ENTRIES (
  ID int(11) NOT NULL default '0',
  DMAP_ID int(11) NOT NULL default '0',
  KEY_OID mediumblob,
  VALUE_OID mediumblob,
  PRIMARY KEY  (ID)
) TYPE=MyISAM;

--
-- Dumping data for table 'OJB_DMAP_ENTRIES'
--



--
-- Table structure for table 'OJB_DSET'
--

CREATE TABLE OJB_DSET (
  ID int(11) NOT NULL default '0',
  SIZE_ int(11) default NULL,
  PRIMARY KEY  (ID)
) TYPE=MyISAM;

--
-- Dumping data for table 'OJB_DSET'
--



--
-- Table structure for table 'OJB_DSET_ENTRIES'
--

CREATE TABLE OJB_DSET_ENTRIES (
  ID int(11) NOT NULL default '0',
  DLIST_ID int(11) NOT NULL default '0',
  POSITION_ int(11) default NULL,
  OID_ longblob,
  PRIMARY KEY  (ID)
) TYPE=MyISAM;

--
-- Dumping data for table 'OJB_DSET_ENTRIES'
--



--
-- Table structure for table 'OJB_HL_SEQ'
--

CREATE TABLE OJB_HL_SEQ (
  TABLENAME varchar(175) NOT NULL default '',
  FIELDNAME varchar(70) NOT NULL default '',
  MAX_KEY bigint(20) default NULL,
  GRAB_SIZE int(11) default NULL,
  VERSION int(11) default NULL,
  PRIMARY KEY  (TABLENAME,FIELDNAME)
) TYPE=MyISAM;

--
-- Dumping data for table 'OJB_HL_SEQ'
--


INSERT INTO OJB_HL_SEQ VALUES ('SEQ_MTUSER','deprecatedColumn',160,20,8);

--
-- Table structure for table 'OJB_LOCKENTRY'
--

CREATE TABLE OJB_LOCKENTRY (
  OID_ varchar(250) NOT NULL default '',
  TX_ID varchar(50) NOT NULL default '',
  TIMESTAMP_ timestamp(14) NOT NULL,
  ISOLATIONLEVEL int(11) default NULL,
  LOCKTYPE int(11) default NULL,
  PRIMARY KEY  (OID_,TX_ID)
) TYPE=MyISAM;

--
-- Dumping data for table 'OJB_LOCKENTRY'
--



--
-- Table structure for table 'OJB_NRM'
--

CREATE TABLE OJB_NRM (
  NAME varchar(250) NOT NULL default '',
  OID_ longblob,
  PRIMARY KEY  (NAME)
) TYPE=MyISAM;

--
-- Dumping data for table 'OJB_NRM'
--



--
-- Table structure for table 'MTUSER'
--

CREATE TABLE MTUSER (
  ID int(11) NOT NULL default '0',
  LOGNAME varchar(20) NOT NULL default '',
  PASSWORD varchar(20) default NULL,
  CREATION date default NULL,
  MODIFICATION date default NULL,
  LASTLOGIN date default NULL,
  FIRSTNAME varchar(60) default NULL,
  LASTNAME varchar(60) default NULL,
  STATUS int(11) default NULL,
  PRIMARY KEY  (ID),
  UNIQUE KEY MTUSER_LOGNAME (LOGNAME)
) TYPE=MyISAM;

--
-- Dumping data for table 'MTUSER'
--


INSERT INTO MTUSER VALUES (1,'rmark','test',NULL,NULL,NULL,NULL,NULL,0);

--
-- Table structure for table 'MTTRAIN'
--

CREATE TABLE MTTRAIN (
  ID int(11) NOT NULL default '0',
  CREATION date default NULL,
  MODIFICATION date default NULL,
  TRAINDATE date default NULL,
  TRAINTYPE varchar(60) default NULL,
  DURATION int(11) default NULL,
  LENGTHKM float(11) default NULL,
  REMARK varchar(255) default NULL,
  STATUS int(11) default NULL,
  OWNER varchar(60) default NULL,
  PRIMARY KEY  (ID)
) TYPE=MyISAM;

