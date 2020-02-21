/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Connection;
import static org.joda.time.PeriodType.time;
import util.ConnectionIO;

/**
 *
 * @author msajid
 */
public class NewConnectionCreate extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewConnectionCreate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewConnectionCreate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void processNewConnectionCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            Connection connection = new Connection();
            String getId = getServletContext().getRealPath("/") + "WEB-INF\\id.txt";
            connection.setId(ConnectionIO.generateId(getId));
            connection.setName(request.getParameter("name"));
            connection.setTopic(request.getParameter("topic"));
            connection.setDesc(request.getParameter("desc"));
            connection.setLocation(request.getParameter("location"));
            //System.out.println("time: "+request.getParameter("time"));
            connection.setTime(request.getParameter("time"));
            connection.setHost(request.getParameter("host"));
            String HardDB = getServletContext().getRealPath("/") + "WEB-INF\\connections.txt";
            ConnectionIO.addRecord(connection, HardDB);
        } catch (ParseException ex) {
            Logger.getLogger(NewConnectionCreate.class.getName()).log(Level.SEVERE, null, ex);
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
        String HardDB = getServletContext().getRealPath("/") + "WEB-INF\\connections.txt";
        
        //request for all connections
        String action = null;
        action = request.getParameter("connectionId");
        //request for single connection
        if(action == null || action.isEmpty()){
            //System.out.println(action);
            try {
                ArrayList<Connection> connectionsList = ConnectionIO.getConnections(HardDB);
                request.setAttribute("ConList", connectionsList);
                request.getRequestDispatcher("/connections.jsp").forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(NewConnectionCreate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            String id = action;
            try {
                Connection connection = ConnectionIO.getConnection(id, HardDB);
                if(connection == null){
                    String message = "Error: Requested Item not found in DB";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/error.jsp").forward(request, response);  
                }
                else{
                 request.setAttribute("singleConnection", connection);
                request.getRequestDispatcher("/connection.jsp").forward(request, response);   
                }
            } catch (ParseException ex) {
                Logger.getLogger(NewConnectionCreate.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        // create new connection case
        if (request.getParameter("requestType").equalsIgnoreCase("newConnectionCreate")) {
            processNewConnectionCreate(request, response);
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
