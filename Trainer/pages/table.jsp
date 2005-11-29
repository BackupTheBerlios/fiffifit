<%@ taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt" %>


<jsp:useBean id="table_trainings" class="java.util.Vector"  scope="request"/>

<script type="text/javascript">

function set_hover(the_row) {
	the_row.style.backgroundColor = 'gray';
}

function remove_hover(the_row) {
	the_row.style.backgroundColor = 'white';
}

function editRow(id) {
  this.location.href = '/Trainer/loadTrainingEntity.do?id=' + id;
}


</script>


<table class="trnOverView" id="id03" border="0" width="100%">
<tr class="trnOverView">
<th class="trnOverView">Training</th>
<th class="trnOverView">Date</th>
<th class="trnOverView">Kilometers</th>
<th class="trnOverView">Minutes</th>
<th class="trnOverView">Remark</th>
</tr>
<c:forEach var="item" items="${table_trainings}">
  <tr class="trnOverView" id="id01" onmouseover="set_hover(this);" onmouseout="remove_hover(this);" onclick="editRow(<c:out value="${item.id}"/> );">
  	<td class="trnOverView" id="id02"><jsp:getProperty name="item" property="trainingTypeString"/>
  	</td>
  	<td class="trnOverView" id="id04"><jsp:getProperty name="item" property="date"/>
  	</td>
  	<td class="trnOverView" id="id05"><jsp:getProperty name="item" property="lengthKilometers"/>
  	</td>
  	<td class="trnOverView" id="id06"><jsp:getProperty name="item" property="durationMinutes"/>
  	</td>
  	<td class="trnOverView" id="id07"><jsp:getProperty name="item" property="remark"/>
  	</td>
  </tr>
  
</c:forEach>
</table>

<html:link action="/jog.do">new</html:link>

<!-- display errors if there were any: -->
<html:errors/>



