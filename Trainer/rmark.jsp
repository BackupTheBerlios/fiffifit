<%@page contentType="text/html"%>
<%@taglib uri='/WEB-INF/cewolf.tld' prefix='cewolf' %>
<HTML>
<BODY>
<H1>Training efforts</H1>

<jsp:useBean id="training" class="org.mtrainer.reports.RTest"/>
<jsp:useBean id="labelRotation" class="de.laures.cewolf.cpp.RotatedAxisLabels" scope="page"/>
<cewolf:chart 
    id="line" 
    title="Training" 
    type="stackedverticalbar3d" 
    xaxislabel="Date" 
    yaxislabel="Minutes">
    <cewolf:data>
        <cewolf:producer id="training"/>
    </cewolf:data>
    <cewolf:chartpostprocessor id="labelRotation">
       <cewolf:param name="rotate_at" value='<%= new Integer(1) %>'/>
    </cewolf:chartpostprocessor>
    
</cewolf:chart>
<p>
<cewolf:img chartid="line" renderer="cewolf" width="400" height="300"/>
<P>
</BODY>
</HTML>