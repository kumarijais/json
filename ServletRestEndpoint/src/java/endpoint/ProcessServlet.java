/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baishali
 */
@WebServlet(name = "ProcessServlet", urlPatterns = {"/ProcessServlet"})
public class ProcessServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     * @throws org.json.simple.parser.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, org.json.simple.parser.ParseException {
        //response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String UserDateTime=request.getParameter("d1");
            //String country=request.getParameter("country");
            //out.println("user input"+UserDateTime);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
              Date date = formatter.parse(UserDateTime);
               long unixTime = date.getTime() / 1000;
               //out.println("unix"+unixTime);
               String timeZoneNewYork = "America/New_York";
               String timeZoneLondon = "Europe/London";
               String timeZoneSanFrancisco = "America/Los_Angeles";
              JavaURLConnection urlNewYork = new JavaURLConnection();
               String dateNewYork = urlNewYork.getDateAndTime(timeZoneNewYork, unixTime);
               JavaURLConnection urlLondon = new JavaURLConnection();
               String dateLondon = urlLondon.getDateAndTime(timeZoneLondon, unixTime);
               JavaURLConnection urlSanFrancisco=new JavaURLConnection();
               String dateSanFrancisco=urlSanFrancisco.getDateAndTime(timeZoneSanFrancisco,unixTime);
               
               //request.setAttribute("dateNewYork", dateNewYork);
            //request.setAttribute("dateLondon", dateLondon);
            //request.setAttribute("dateSanFrancisco", dateSanFrancisco);
              // request.getRequestDispatcher("newjsp.jsp").forward(request, response);
            
               out.println(dateNewYork);
               out.println(dateLondon);
               out.println(dateSanFrancisco);
            //String s1=request.getParameter("d1");
            //out.println("<!DOCTYPE html>");
           // out.println("<html>");
            //out.println("<head>");
           // out.println("<title>Servlet ProcessServlet</title>");            
           // out.println("</head>");
           // out.println("<body>");
           // out.println("<h1>Servlet ProcessServlet at " + request.getContextPath() + "</h1>");
            //out.println("Hello "+s1);
            //out.println("</body>");
            //out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (ParseException | org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ProcessServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException | org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ProcessServlet.class.getName()).log(Level.SEVERE, null, ex);
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
