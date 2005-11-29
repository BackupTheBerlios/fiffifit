<%@page contentType="text/html"%>
<%@taglib uri='/WEB-INF/cewolf.tld' prefix='cewolf' %>
<HTML>
<BODY>
<H1>Training efforts</H1>
<!-- this page places a graphic with data from TrainingReport 
     The TrainingReport data should already be a session bean with 
     data filled by the TrainingReportAction     
  -->
<jsp:useBean id="nReport" class="org.mtrainer.reports.TrainingReport" scope="session"/>
<jsp:useBean id="labelRotation" class="de.laures.cewolf.cpp.RotatedAxisLabels" scope="page"/>
<cewolf:chart 
    id="barView" 
    title="Training" 
    type="stackedverticalbar3d" 
    xaxislabel="Date" 
    yaxislabel="Minutes">
    <cewolf:colorpaint color="#FFFFFF"/>
    <cewolf:data>
        <cewolf:producer id="nReport"/>
    </cewolf:data>
    <cewolf:chartpostprocessor id="labelRotation">
       <cewolf:param name="rotate_at" value='<%= new Integer(1) %>'/>
    </cewolf:chartpostprocessor>
    
</cewolf:chart>
<p>
<cewolf:img chartid="barView" renderer="cewolf" width="600" height="300">
  <cewolf:map linkgeneratorid="nReport"/>
</cewolf:img>
<P>
<br>

</BODY>
</HTML>