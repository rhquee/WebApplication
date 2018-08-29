package controler;

import model.CacheForAnnotationAndFieldValues;

import javax.servlet.*;
import java.io.IOException;


public abstract class NameCatcher {

    protected abstract String getName();

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userName = servletRequest.getParameter("name");

        if (userName.equalsIgnoreCase(getName())) {
            doFilterForGivenName(servletRequest, servletResponse, userName);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void doFilterForGivenName(ServletRequest servletRequest, ServletResponse servletResponse, String userName) {
        try {
            CacheForAnnotationAndFieldValues cacheForAnnotationAndFieldValues = new CacheForAnnotationAndFieldValues(userName);
            servletRequest.setAttribute("responseString", cacheForAnnotationAndFieldValues.getFieldValue());

            JSPDispatcher.dispatchToDestinyURL(servletRequest, servletResponse, cacheForAnnotationAndFieldValues);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
