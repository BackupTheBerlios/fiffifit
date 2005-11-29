<%@ page language="java" %>
<%@ taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:form action="/loginSubmit" focus="login">
<table border="0" width="100%">
    <tr>
        <th class="right">
            <bean:message key="login.login"/>
        </th>
        <td class="left">
            <html:text  property="login" size="16"/>
        </td>
    </tr>
    <tr>
        <th class="right">
            <bean:message key="login.password"/>
        </th>
        <td class="left">
            <html:password property="password" size="16"/>
        </td>
    </tr>
   
   
    <tr>
        <td class="right">
            <html:reset styleClass="mtbutton">
                <bean:message key="login.reset"/>
            </html:reset>
        </td>
        <td class="right">
            <html:submit styleClass="mtbutton">
                <bean:message key="login.submit"/>
            </html:submit>
        </td>
    </tr>
</table>

<!-- display errors if there were any: -->
<html:errors/>



</html:form>
