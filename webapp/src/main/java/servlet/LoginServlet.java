package servlet;

import main.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by billy.witt on 2/13/2017 AD.
 */
public class LoginServlet extends HTTPServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("username");
        String p=request.getParameter("userpass");

        HttpSession session = request.getSession(false);
        if(session!=null)
            session.setAttribute("name", n);

        if(Login.validate(n, p)){
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
            rd.forward(request,response);
        }
        else{
            out.print("<p style=\"color:red\">Sorry username or password error</p>");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }

        out.close();
    }

}
