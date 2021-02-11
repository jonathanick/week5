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
import service.AccountService;
import service.User;

/**
 *
 * @author 828200
 */
public class LoginServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logout=request.getParameter("logout");
        HttpSession session = request.getSession();
        if(logout==null)
        {
            session.invalidate();
            request.setAttribute("message", "you have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
            .forward(request,response);
        }
        else
        {
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
            .forward(request,response);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           HttpSession session = request.getSession();
           String username=request.getParameter("username");
           String password=request.getParameter("password");
           String message=request.getParameter("message");
           AccountService as=new AccountService(username,password);
             if(session.getAttribute("username") != null)
        {
             getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
            .forward(request,response);
            return;
        }
           if(password != null && username != null)
           {
               User user=as.login();
               if(user == null)
               {
                   request.setAttribute("username", username);
                   request.setAttribute("password",password);
                   request.setAttribute("message", "either the username or password is invalid!");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                 .forward(request,response);
                    return;
               }
               else
               {
                   session.setAttribute("username", username);
                   session.setAttribute("password",password);
                   response.sendRedirect("/WEB-INF/home.jsp");
                   return;
               }
           }
           else
           {
               request.setAttribute("message", "either the username or password is null");
               getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
            .forward(request,response);
               return;
           }
    }


}
