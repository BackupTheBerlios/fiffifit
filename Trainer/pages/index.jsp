<%@ page language="java" %>
<%@ taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<jsp:useBean id="bodyBean" class="java.lang.String" scope="session"/>
<% bodyBean = request.getParameter("navig"); %>

<tiles:definition id="mainTile" page="template.jsp">
	<tiles:put name="body" value="nox"/>
</tiles:definition>

<tiles:insert beanName="mainTile">
  <tiles:put name="body" value='<%=bodyBean%>' />
</tiles:insert>

