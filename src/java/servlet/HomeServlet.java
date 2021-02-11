/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 828200
 */
public class HomeServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        if(session.getAttribute("username") == null)
        {
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
            .forward(request,response);
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
            .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        request.setAttribute("username",session.getAttribute("username"));
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
            .forward(request,response);
    }


}
