package com.test.exp4j.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.objecthunter.exp4j.function.Function;

/**
 * @author Leo Gutierrez R. <leogutierrezramirez@gmail.com>
 */
public class SetCustomFunctionExp4JServlet extends HttpServlet {

    /**
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Function fiboFunc = new Function("fibonacci", 1) {
            @Override
            public double apply(double ... args) {
                double i = 1.0;
                double j = 0.0;
                for (int k = 1; k <= args[0]; k++) {
                    j = i + j;
                    i = j - i;
                }
                return j;
            }
        };
        
        request.setAttribute("fibo", fiboFunc);
        request.getRequestDispatcher("result.jsp").forward(request, response);
        
    }

    /**
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Sets a custom function display in the result.jsp jsp using exp4j jsp tags";
    }

}
