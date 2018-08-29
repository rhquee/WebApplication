package controler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = "/hello")
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter printWriter = response.getWriter();
//        String userName = request.getParameter("name");
//        String hello = String.format("<style>body{background-color:red;}</style><h1>Hello, %s </h1>", userName);
//        printWriter.print(hello);

        request.setAttribute("name", request.getParameter("name"));
        String redirectURL = "/WEB-INF/view/hello.jsp";
        RequestDispatcher view = request.getRequestDispatcher(redirectURL);
        view.forward(request, response);
    }
}