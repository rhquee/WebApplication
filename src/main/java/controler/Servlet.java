package controler;

import model.CacheForAnnotationAndFieldValues;

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
        String destinyUrl;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();

        String userName = request.getParameter("name");
        if (userName.equalsIgnoreCase("david") || userName.equalsIgnoreCase("hal")) {
            try {
                CacheForAnnotationAndFieldValues cacheForAnnotationAndFieldValues = new CacheForAnnotationAndFieldValues(userName);
                request.setAttribute("responseString", cacheForAnnotationAndFieldValues.getFieldValue());

                destinyUrl = "/WEB-INF/view/" + cacheForAnnotationAndFieldValues.getAnnotationValue() + ".jsp";
                RequestDispatcher view = request.getRequestDispatcher(destinyUrl);
                view.forward(request, response);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        String hello = String.format("<h1>Hello, %s </h1>", userName);
        printWriter.print(hello);
    }
}