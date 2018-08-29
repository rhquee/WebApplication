package controler;

import model.CacheForAnnotationAndFieldValues;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class JSPDispatcher {

    public static void dispatchToDestinyURL(ServletRequest servletRequest, ServletResponse servletResponse, CacheForAnnotationAndFieldValues cacheForAnnotationAndFieldValues) {
        String redirectURL = "/WEB-INF/view/" + cacheForAnnotationAndFieldValues.getAnnotationValue() + ".jsp";
        RequestDispatcher view = servletRequest.getRequestDispatcher(redirectURL);
        try {
            view.forward(servletRequest, servletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
