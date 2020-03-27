<%-- 
    Document   : newConnection
    Created on : Feb 17, 2020, 2:24:44 PM
    Author     : msajid
--%>
<jsp:include page="header.jsp" />
<jsp:include page="navigation.jsp" />
<%@page import="model.Connection"%> 
<%Connection connection = (Connection) request.getAttribute("singleConnection");
%>
<div id="wrapper">
    <div class="container">
        <div class="row eventDetails" >
            <div class="col-12"><h1 class="category"><%=connection.getTopic()%></h1></div>
            <div class="col-12">
                <div class="row">
                    <div class="col-12"><h3 class="category"><%=connection.getName()%></h3></div>
                    <div class="col-6">
                        <a href="#"><img src="images/cricketPost.jpg" alt="NBA_games" style="width:25%;"/></a>
                        <p class = "float-right">
                            <b>Hosted by:</b> <%=connection.getHost()%><br>
                            <b>Time:</b> <%=connection.getTime()%><br>
                            <b>Place:</b> <%=connection.getLocation()%><br>
                        </p>
                    </div>
                    <div class="col-6 float-right">
                        <b>20 people going. Want to join us?</b><br>
                        <form>
                            <a class="btn btn-success" href="<%=request.getContextPath()%>/task?action=rsvp&connectionId=<%=connection.getId()%>&response=Yes">
                            Yes    
                            </a>
                            <a class="btn btn-danger" href="<%=request.getContextPath()%>/task?action=rsvp&connectionId=<%=connection.getId()%>&response=No">
                             No
                            </a>
                            <a class="btn btn-warning" href="<%=request.getContextPath()%>/task?action=rsvp&connectionId=<%=connection.getId()%>&response=Maybe">
                             Maybe  
                            </a>
                        </form>
                    </div>
                    <br><br>
                    <div class="col-6"> <h4>Details</h4>
                        <p><%=connection.getDesc()%></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />
