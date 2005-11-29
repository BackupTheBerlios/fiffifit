<%@ page language="java" %>
<%@ taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>

<html:html>
<head>
ok
<br>
<a href="/Trainer/">Home</a>
<form>
<input name = "hugo"> </input>
<t:inputDate id="date1" value="#{date1}" popupCalendar="true"/>
</form>
</body>
</html:html>
