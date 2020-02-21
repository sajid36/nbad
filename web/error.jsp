<%-- 
    Document   : newConnection
    Created on : Feb 17, 2020, 2:24:44 PM
    Author     : msajid
--%>
<jsp:include page="header.jsp" />
<jsp:include page="navigation.jsp" />
<%String message = (String) request.getAttribute("message");
%>
<div id="wrapper">
    <div class="container">
        <div class="row">
            <div class="col-12"><p class="description text-center btn-danger"><%=message%></p></div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />
