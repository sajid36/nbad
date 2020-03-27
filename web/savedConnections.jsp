<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<jsp:include page="navigation.jsp" />
<div id="wrapper">
    <div class="container">
        <div class="row" >
            <div class="col-12"><h1 class="category">My Events</h1></div>
            <div class="col-12">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Events</th>
                            <th scope="col">Category</th>
                            <th scope="col">Going</th>
                            <th scope="col">Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.userConnections}" var="userConnection">
                        <tr>
                            <th scope="row"><c:out value="${userConnection.eventName}"/></th>
                            <td><c:out value="${userConnection.category}"/></td>
                            <td><c:out value="${userConnection.rsvp}"/></td>
                            <td>
                                <form>
                                    <a class="btn btn-secondary" href="<%=request.getContextPath()%>/task?action=update&connectionId=${userConnection.connectionId}">
                                    Update
                                    </a>
                                    <a class="btn btn-danger" href="<%=request.getContextPath()%>/task?action=delete&connectionId=${userConnection.connectionId}">
                                    Delete
                                    </a>
                                </form>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />