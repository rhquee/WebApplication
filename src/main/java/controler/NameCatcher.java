package controler;

import model.CacheForAnnotationAndFieldValues;

import javax.servlet.*;
import java.io.IOException;


public class NameCatcher {

    public void doFilterForGivenName(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, String userName) throws IOException, ServletException {
            try {
                CacheForAnnotationAndFieldValues cacheForAnnotationAndFieldValues = new CacheForAnnotationAndFieldValues(userName);
                servletRequest.setAttribute("responseString", cacheForAnnotationAndFieldValues.getFieldValue());

                JSPDispatcher.dispatchToDestinyURL(servletRequest, servletResponse, cacheForAnnotationAndFieldValues);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
