<%-- 
    Document   : ShowResponse
    Created on : Feb 6, 2018, 9:39:49 AM
    Author     : nanajjar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Dynamic Response From Servlet</title>
    </head>

    <body>
        <!--Add content for display here -->
        <div id='mainContent'>
            <table>
                <tr>

                    <th>
                        <!-- display user selected city-->
                        The current time in ${time.city} is
                    </th>
                <tr>
                    <td>
                        <!-- display the time for this city-->
                        ${time.currentTime}
                    </td>

                </tr>
            </table>
            <br>
            <a href="time"> &lbarr; Go back to check a different city </a>

        </div>
    </body>
</html>
