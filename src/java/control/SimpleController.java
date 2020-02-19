/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nanajjar
 */
public class SimpleController extends HttpServlet {

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

        String requestedCity = request.getParameter("city");

        String time = "";

        if (requestedCity == null || requestedCity.equalsIgnoreCase("sydney")) {
            
            //utilize java libraries for time/date
            TimeZone tz = java.util.TimeZone.getTimeZone("GMT+11");
            Calendar c = java.util.Calendar.getInstance(tz);

            //create a formatter for the date
            SimpleDateFormat simpleDateFormat
                    = new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            //make the time String
            simpleDateFormat.setTimeZone(tz);
            time = simpleDateFormat.format(c.getTime());
        }
        
        //the controller will respond back with an HTML document
        //set response type to HTML
        response.setContentType("text/html;charset=UTF-8");
        
        //create the reponse output
        try (PrintWriter out = response.getWriter()) {
            /* output the response here. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SimpleController</title>");
            out.println("</head>");
            out.println("<body>");
            
            //if time is empty then something went wrong
            //display appropriete message and action
            if (time == "") {
                out.println("<h1>Welcome to the Time app!</h1>");
                out.println("<h2>Sorry, you did not enter a city I know.</h2>");
                out.println("<h3><a href=\"time\">Click here to check out what cities I know</a></h3>");

            } 
            //time has a value so dispaly 
            else {
                out.println("<h1>The current time in Sydney, Australia is " + time + "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
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

        String requestedCity = request.getParameter("city");
        String time = "";
        
        //utilize java libraries for time/date
        TimeZone tz = java.util.TimeZone.getTimeZone("GMT+11");
        Calendar c = java.util.Calendar.getInstance(tz);

        //create a formatter for the date
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        simpleDateFormat.setTimeZone(tz);
        
        //make  time String
        time = simpleDateFormat.format(c.getTime());
    
        //if time is null/empty then something went wrong
        //display appropriete message and action    
        if (requestedCity == null || requestedCity.trim().equals("")) {

            time = "You did not enter a valid city name. But I can tell you "
                    + "that the current time in Sydney, Australia is "
                    + time;
        } 
        //if requested city is sydney display time
        else if (requestedCity.trim().equalsIgnoreCase("sydney")) {

            time = "The current time in Sydney, Australia is " + time;
        } 
        //a city we don't know how to handle was requested
        //display appropriete message and action
        else {
            time = "Sorry I don't know the time in " + requestedCity
                    + ". But I know that the current time in Sydney, Australia is "
                    + time;
        }

        //the controller will respond back with an HTML document
        //set response type to HTML
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* output the response here. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> " + time + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "A sample web application demo";
    }// </editor-fold>

}
