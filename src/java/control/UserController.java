/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import util.UserIO;

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
    protected User findUserId (String uname) throws IOException, ParseException{
        String hardDB = getServletContext().getRealPath("/") + "WEB-INF\\users.txt";
        String hardDB2 = getServletContext().getRealPath("/") + "WEB-INF\\address.txt";
        User user = UserIO.getUser(uname, hardDB, hardDB2);
        System.out.println("UserId: " + user.getUserId());
        System.out.println("Email: " + user.getEmail());
        System.out.println("First Name: " + user.getFName());
        System.out.println("Last Name: " + user.getLName());
        System.out.println("Address: "+ user.getAddress().getAddressField1() + " " + user.getAddress().getAddressField2() + " " + user.getAddress().getCity() + " " + user.getAddress().getState() 
                + " " + user.getAddress().getZip() + " " + user.getAddress().getCountry());
        return user;
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
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("true")){
            HttpSession session = request.getSession(false);
            session.removeAttribute("user");
            session.invalidate();
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
            User user = findUserId(uname);
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
