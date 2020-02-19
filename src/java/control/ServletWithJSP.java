/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Time;

/**
 *
 * @author nanajjar
 */
public class ServletWithJSP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //check the request object for parameters needed
        String requestedCity = request.getParameter("city");

        //create a string for a message that can be used to send to the view
        String message = "";

        //create needed objects to get time
        Time timeInfo = new Time();
        String time;
        TimeZone tz = TimeZone.getDefault();
        Calendar c = Calendar.getInstance(tz);

        //create a formatter for the date
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        //create a string to store the URL for the view that will be used to forward requests. Defualt URL is index.jsp
        String url = "/index.jsp";

        if (requestedCity == null || requestedCity.trim().equals("")) {
            //no city parameter was specified or it didn't have a value
            //set the alert message text
            message = "No city was provided with the request,  but I can tell your "
                    + " current time! ";

            //populate data in the JavaBean
            timeInfo.setCity("No valid city was entered");
            time = simpleDateFormat.format(c.getTime());
            timeInfo.setCurrentTime(time);

            //print a debug message to the console to make sure time is displayed correctly
            System.out.println("Time is " + time);

            //since this was not valid we will redirect to the index.jsp 
            //this is the default view and is already set
        } else if (requestedCity.trim().equalsIgnoreCase("charlotte")) {
            //set the timezone and get a calendar instance
            tz = TimeZone.getTimeZone("GMT-4");
            c = Calendar.getInstance(tz);

            //make the time String
            simpleDateFormat.setTimeZone(tz);
            time = simpleDateFormat.format(c.getTime());

            //populate data in the JavaBean
            timeInfo.setCity("Charlotte");
            timeInfo.setCurrentTime(time);

            //since this was a valid request we will redirect to the ShowResponse.jsp
            //tell the servlet where to send this request to show the response
            url = "/ShowResponse.jsp";

        } else if (requestedCity.trim().equalsIgnoreCase("la")) {
            //set the timezone and get a calendar instance
            tz = TimeZone.getTimeZone("GMT-7");
            c = Calendar.getInstance(tz);

            //make the time String
            simpleDateFormat.setTimeZone(tz);
            time = simpleDateFormat.format(c.getTime());

            //populate data in the JavaBean
            timeInfo.setCity("Los Angelos");
            timeInfo.setCurrentTime(time);

            //since this was a valid request we will redirect to the ShowResponse.jsp
            //tell the servlet where to send this request to show the response
            url = "/ShowResponse.jsp";

        } else if (requestedCity.trim().equalsIgnoreCase("denver")) {
            //set the timezone and get a calendar instance
            tz = TimeZone.getTimeZone("GMT-6");
            c = Calendar.getInstance(tz);

            //make the time String
            simpleDateFormat.setTimeZone(tz);
            time = simpleDateFormat.format(c.getTime());

            //populate data in the JavaBean
            timeInfo.setCity("Denver");
            timeInfo.setCurrentTime(time);

            //since this was a valid request we will redirect to the ShowResponse.jsp
            //tell the servlet where to send this request to show the response
            url = "/ShowResponse.jsp";

        } else if (requestedCity.trim().equalsIgnoreCase("sydney")) {
            //set the timezone and get a calendar instance
            tz = TimeZone.getTimeZone("GMT+10");
            c = Calendar.getInstance(tz);

            //make the time String
            simpleDateFormat.setTimeZone(tz);
            time = simpleDateFormat.format(c.getTime());

            //populate data in the JavaBean
            timeInfo.setCity("Sydney");
            timeInfo.setCurrentTime(time);

            //since this was a valid request we will redirect to the ShowResponse.jsp
            //tell the servlet where to send this request to show the response
            url = "/ShowResponse.jsp";

        } else if (requestedCity.trim().equalsIgnoreCase("beijing")) {
            //set the timezone and get a calendar instance
            tz = TimeZone.getTimeZone("GMT+8");
            c = Calendar.getInstance(tz);

            //make the time String
            simpleDateFormat.setTimeZone(tz);
            time = simpleDateFormat.format(c.getTime());

            //populate data in the JavaBean
            timeInfo.setCity("Beijing");
            timeInfo.setCurrentTime(time);

            //since this was a valid request we will redirect to the ShowResponse.jsp
            //tell the servlet where to send this request to show the response
            url = "/ShowResponse.jsp";

        } else {
            //set a default resposnse if none of the other conditions are met
            //make the message String
            message = "Sorry I don't know the time in " + requestedCity
                    + ". But I know that your current time is ";

            //format date
            simpleDateFormat.setTimeZone(tz);

            //Get the time
            time = simpleDateFormat.format(c.getTime());
            //populate data in the JavaBean
            timeInfo.setCity("Charlotte");
            timeInfo.setCurrentTime(time);
            //since this was not valid we will redirect to the index.jsp

        }

        //Now we have the data we need to finalize the response
        //attach the data to the request object
        request.setAttribute("message", message);
        request.setAttribute("time", timeInfo);

        //now forward the request and response objects to this resource to finalize the response
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
