/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Connection;
import model.User;
import model.UserConnection;
import util.ConnectionIO;
import util.UserProfile;

/**
 *
 * @author sajid
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //ArrayList<UserConnection> userConnections = new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        String action = request.getParameter("action");

        /**
         * if user is not logged in jump to else for showing error message that
         * he needs to login*
         */
        if (user != null) {
            /**
             * if user wants to logout then invalidate the sessions*
             */
            if (action.equalsIgnoreCase("logout")) {
                session.removeAttribute("user");
                session.removeAttribute("userConnections");
                session.invalidate();
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

            /**
             * *User wants to rsvp**
             */
            if (action.equalsIgnoreCase("rsvp")) {
                String connectionId = request.getParameter("connectionId");
                String responsed = request.getParameter("response");

                /**
                 * need to add this particular connection to the user's saved
                 * connection, so getconnection for details*
                 */
                String HardDB = getServletContext().getRealPath("/") + "WEB-INF\\connections.txt";
                Connection connection = new Connection();
                try {
                    connection = ConnectionIO.getConnection(connectionId, HardDB);
                } catch (ParseException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*add each of these connections to the arraylist*/
                ArrayList<UserConnection> userConnections = new ArrayList<>();

                //if session exists then update the userConnections
                if (session.getAttribute("userConnections") != null) {
                    userConnections = UserProfile.getUserConnections(session);
                }

                /*otherwise session doesn't have anything means for the first time i am adding a connection to the arraylist*/
                /**
                 * *check if it's an update or not, if not not then add**
                 */
                boolean dup = UserProfile.duplicateCheck(userConnections, connectionId);

                /**
                 * if duplicate then update*
                 */
                if (dup) {
                    userConnections = UserProfile.updateConnection(connectionId, responsed, userConnections);
                } else {
                    userConnections = UserProfile.addConnection(connectionId, responsed, connection, userConnections);
                }
                session.setAttribute("userConnections", userConnections);
                request.getRequestDispatcher("/savedConnections.jsp").forward(request, response);
            }
            if (action.equalsIgnoreCase("delete")) {
                String connectionId = request.getParameter("connectionId");

                /*Delete button will not appear if the user doesn't have any connection, which means he must have atleast one connection, therefore
            session must have connection list*/
                ArrayList<UserConnection> userConnections = new ArrayList<>();

                //if session exists then update the userConnections
                if (session.getAttribute("userConnections") != null) {
                    userConnections = UserProfile.getUserConnections(session);
                }

                /*remove the connection from the arraylist and dispatch to savedconnections*/
                userConnections = UserProfile.removeConnection(connectionId, userConnections);
                session.setAttribute("userConnections", userConnections);
                request.getRequestDispatcher("/savedConnections.jsp").forward(request, response);
            }
            
            /*update case*/
            if (action.equalsIgnoreCase("update")) {
                String connectionId = request.getParameter("connectionId");
                String HardDB = getServletContext().getRealPath("/") + "WEB-INF\\connections.txt";
                Connection connection = null;
                
                /*show the connection that the user wants to update*/
                try {
                    connection = ConnectionIO.getConnection(connectionId, HardDB);
                } catch (ParseException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("singleConnection", connection);
                request.getRequestDispatcher("/connection.jsp").forward(request, response);
            }
        } 
        
        /*else the user is not logged in so show the message to login*/
        else {
            String message = "Please login for this functionality";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
        //processRequest(request, response);
        
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        try {
            /*Populate some dummy data for the user such as firstName, lastName, Address etc*/
            User user = UserProfile.getPopulatedUser(uname);
            
            /*Create a session for the logged in user*/
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
