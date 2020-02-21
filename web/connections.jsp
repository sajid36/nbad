<%-- 
    Document   : newConnection
    Created on : Feb 17, 2020, 2:24:44 PM
    Author     : msajid
--%>

<jsp:include page="header.jsp" />
<jsp:include page="navigation.jsp" />
<%@page import="java.util.ArrayList"%>      <%--Importing all the dependent classes--%>
<%@page import="model.Connection"%>
<%@page import="java.util.Iterator"%> 
<%ArrayList<Connection> connectionList = (ArrayList) request.getAttribute("ConList");
%>
<div id="wrapper">
    <div class="container">
        <div class="row">
            <div class="col-12"><h1 class="category">Connect People Around UNCC Through Sports</h1></div>
            <div class="col-12">
                <div class="row eventpost">
                    <div class="col-12"><h2 class="category">Cricket Events</h2></div>
                    <%for (int i = 0; i < connectionList.size(); i++) 
                    {
                        if(connectionList.get(i).getTopic().equalsIgnoreCase("Cricket"))
                        {
                    %>
                            <div class="col-4"><a href="<%=request.getContextPath()%>/connections?connectionId=<%=connectionList.get(i).getId()%>"><img src="images/cricketPost.jpg" alt="cricket_games" style="width:100%"/><p class="text-center"><%=connectionList.get(i).getName()%></p></a></div>
                      <%}
                    }%>   
                    <div class="col-12"><h2 class="category">Soccer Events</h2></div>
                    <%for (int i = 0; i < connectionList.size(); i++) 
                    {
                        if(connectionList.get(i).getTopic().equalsIgnoreCase("Soccer"))
                        {
                    %>
                            <div class="col-4"><a href="<%=request.getContextPath()%>/connections?connectionId=<%=connectionList.get(i).getId()%>"><img src="images/FIFA-20.jpg" alt="soccer_games" style="width:100%"/><p class="text-center"><%=connectionList.get(i).getName()%></p></a></div>
                      <%}
                    }%> 

                    <!--
                    <div class="col-4"><a href="connection.html"><img src="images/FIFA-20.jpg" alt="FIFA_games" style="width:100%;"/></a><p>WCG FIFA-20 to take place on 20th Jan. Register NOW!!</p></div>
                    <div class="col-4"><a href="connection.html"><img src="images/cricket_Ea.png" alt="cricket_games" style="width:100%;"/></a><p>Become the ultimate "UNCC Ashes Cricket" champoion. Register here!</p>
                    </div>
                    <!--<div class="col-2"><a href="connection.html"><img src="images/NBA-2K20.jpg" alt="NBA_games" style="width:100%;"/></a><p>NBA online?</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/FIFA-20.jpg" alt="FIFA_games" style="width:100%;"/></a><p>FUT online?</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/cricket_Ea.png" alt="cricket_games" style="width:100%;"/></a><p>Looking for a tag teammate for "UNCC Ashes Cricket" tournament</p>
                    </div> -->
                    <!--
                    <div class="col-12"><h2 class="category">Video Games Related Events</h2></div>
                    <div class="col-2"><a href="connection.html"><img src="images/cricketPost.jpg" alt="NBA_games" style="width:100%;"/></a><p>Cricket near UTN at 5pm </p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/cricketPost.jpg" alt="FIFA_games" style="width:100%;"/></a><p>Looking 4/5 players for match against NCS</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/cricketPost.jpg" alt="cricket_games" style="width:100%;"/></a><p>Cricket at backyard; Place: The Lake</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/cricketPost.jpg" alt="NBA_games" style="width:100%;"/></a><p>Cricket Today? at SAC, 4pm</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/cricketPost.jpg" alt="FIFA_games" style="width:100%;"/></a><p>Cricket Today</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/cricketPost.jpg" alt="cricket_games" style="width:100%;"/></a><p>Cricket Today</p>
                    </div>

                    <div class="col-12"><h2 class="category">Soccer Games Events</h2></div>
                    <div class="col-2"><a href="connection.html"><img src="images/soccerPost.jpg" alt="NBA_games" style="width:100%;"/></a><p>Soccer near UTN at 5pm </p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/soccerPost.jpg" alt="FIFA_games" style="width:100%;"/></a><p>Looking 4/5 players for match against NCS</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/soccerPost.jpg" alt="cricket_games" style="width:100%;"/></a><p>Soccer at backyard; Place: The Lake</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/soccerPost.jpg" alt="NBA_games" style="width:100%;"/></a><p>Soccer Today? at SAC, 4pm</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/soccerPost.jpg" alt="FIFA_games" style="width:100%;"/></a><p>Soccer Today</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/soccerPost.jpg" alt="cricket_games" style="width:100%;"/></a><p>Soccer Today</p>
                    </div>

                    <div class="col-12"><h2 class="category">NBA Games Events</h2></div>
                    <div class="col-2"><a href="connection.html"><img src="images/basketPost.jpg" alt="NBA_games" style="width:100%;"/></a><p>Basketball near UTN at 5pm </p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/basketPost.jpg" alt="FIFA_games" style="width:100%;"/></a><p>Looking 4/5 players for match against NCS</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/basketPost.jpg" alt="cricket_games" style="width:100%;"/></a><p>Basketball at backyard; Place: The Lake</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/basketPost.jpg" alt="NBA_games" style="width:100%;"/></a><p>Basketball Today? at SAC, 4pm</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/basketPost.jpg" alt="FIFA_games" style="width:100%;"/></a><p>Basketball Today</p></div>
                    <div class="col-2"><a href="connection.html"><img src="images/basketPost.jpg" alt="cricket_games" style="width:100%;"/></a><p>Basketball Today</p>
                    </div>-->
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="header.jsp" />