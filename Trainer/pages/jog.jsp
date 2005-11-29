<%@ page language="java" %>
<%@ taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:errors/>

<html:form action="/jogSubmit" focus="kilometers">
<table border="0" width="100%">
    <tr>
        <th class="right">
            <bean:message key="jog.kilometers"/>
        </th>
        <td class="left">
            <html:text  property="kilometers" size="16"/>
        </td>
    </tr>
    <tr>
        <th class="right">
            <bean:message key="jog.minutes"/>
        </th>
        <td class="left">
            <html:text property="minutes" size="16"/>
        </td>
    </tr>
    <tr>
        <th class="right">
           <bean:message key="jog.traindate"/>
        </th>
        <td class="left">
            <html:text property="trainDateString" size="16"/>
        </td>
    </tr>
    <tr>
        <th class="right">
           <bean:message key="jog.type"/>
        </th>
        <td class="left">
            <html:select property="type">
                <html:optionsCollection property="types" label="name" value="name" />
            </html:select>
        </td>
    </tr>
    <tr>
        <th class="right">
           <bean:message key="jog.description"/>
        </th>
        <td class="left">
            <html:textarea property="description" rows="3" cols="20"/>
        </td>
    </tr>   
   
    <tr>
        <td class="right">
            <html:reset>
                <bean:message key="jog.reset"/>
            </html:reset>
        </td>
        <td class="right">
            <html:submit>
                <bean:message key="jog.submit"/>
            </html:submit>
        </td>
    </tr>
    <html:hidden property="action"></html:hidden>
    <html:hidden property="id"></html:hidden>
</table>




<!-- display errors if there were any: -->
     <html:errors/>



</html:form>
