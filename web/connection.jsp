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
                            <button type="submit" class="btn btn-success" formaction="savedConnections.html">Yes</button>
                            <button type="submit" class="btn btn-danger" formaction="savedConnections.html">No</button>
                            <button type="submit" class="btn btn-warning" formaction="savedConnections.html">Maybe</button>
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
