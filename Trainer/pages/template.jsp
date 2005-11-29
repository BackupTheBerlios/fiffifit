<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:html>
<head>
<link rel="stylesheet" type="text/css" href="/Trainer/pages/default.css">
<title>
    <bean:message key="jog.title"/>
</title>
</head>

<body bgcolor="white">
<!-- header -->
<div id="kopf">
  <h1>Trainer application</h1>
</div>


<!-- navigation -->
<div id="Navigation">
  <ul id="NavigationBar">
    <li><a href="/Trainer/table.do">View</a></li>
    <li><a href="/Trainer/jog.do">Enter</a></li>
    <li><a href="/Trainer/report.do">Report</a></li>
    <li><a href="/Trainer/login.do">Login</a></li>
    <li><a href="/Trainer/logout.do">Logout</a></li>  
  </ul>
</div>
<!-- main -->
<div id="main">
  <tiles:insert attribute="body" />
</div>
<br>
<!-- footer -->
<div id="footer">
  This is the footer.
</div>


</body>
</html:html>
