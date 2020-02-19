<%-- 
    Document   : index.jsp
    Author     : nanajjar
--%>
<%@page import="model.Time" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">

        <title>CityTime Application Home page</title>
    </head>
    <body>
        <div id='mainContent'>
            <h2> Using JSPs to create HTML responses with embedded code to create dynamic views.  </h2>
            <hr>
            <%-- If the application wants to send data to the client the servlet can set attributes to the request objects and store the data under those attributes. 
                The JSP in turn can read data in those objects and embbed it in the HTML response--%>

            <%
                String message = (String) request.getAttribute("message");
                if (message != null && message != "") {
            %>
            <h4> <%= message%>

                <% }
                %>
            </h4>
            <table>
                <tr>
                    <th colspan="2"> 
                        <label>Your current time is </label>
                    </th>
                </tr>
                <tr>
                    <td>
                        <label> 
                            This is displayed using Scriptlets </label>



                    </td>
                    <td>

                        <label>
                            This is displayed using Expression Language </label>


                    </td>

                </tr>
                <tr>

                    <td>
                        <!-- using scriptlet -->
                        <% Time time = (Time) request.getAttribute("time");
                            String currentTime = time.getCurrentTime();
                        %>
                        <%= currentTime%>
                    </td>
                    <td>
                        <!-- using EL -->
                        ${time.currentTime}
                    </td>
                </tr>

            </table>
            <br>
            <br>
            <div >
                <form action="time" method="post">

                    Select a city to find out what time it is over there<br>
                    <label>City</label>

                    <select name="city">
                        <option value="Charlotte">Charlotte, North Carolina</option>
                        <option value="LA">Los Angeles, California</option>
                        <option value="Denver">Denver, Colorado</option>
                        <option value="Sydney">Sydney, Australia</option>
                        <option value="Beijing">Beijing, China</option>
                    </select>
                    <input type="submit" value="Get Time" />

                </form>
            </div>
        </div>
    </body>
</html>
