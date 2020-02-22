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
                    <%for (int i = 0; i < connectionList.size(); i++) {
                            if (connectionList.get(i).getTopic().equalsIgnoreCase("Cricket")) {
                    %>
                    <div class="col-4"><a href="<%=request.getContextPath()%>/connections?connectionId=<%=connectionList.get(i).getId()%>"><img src="images/cricketPost.jpg" alt="cricket_games" style="width:100%"/><p class="text-center"><%=connectionList.get(i).getName()%></p></a></div>
                            <%}
                          }%>   
                    <div class="col-12"><h2 class="category">Soccer Events</h2></div>
                    <%for (int i = 0; i < connectionList.size(); i++) {
                            if (connectionList.get(i).getTopic().equalsIgnoreCase("Soccer")) {
                    %>
                    <div class="col-4"><a href="<%=request.getContextPath()%>/connections?connectionId=<%=connectionList.get(i).getId()%>"><img src="images/FIFA-20.jpg" alt="soccer_games" style="width:100%"/><p class="text-center"><%=connectionList.get(i).getName()%></p></a></div>
                            <%}
                          }%> 
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />