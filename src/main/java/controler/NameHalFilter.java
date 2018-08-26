package controler;

import model.CacheForAnnotationAndFieldValues;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter (filterName = "NameHalFilter", servletNames = "Servlet")
public class NameHalFilter extends NameCatcher implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userName = servletRequest.getParameter("name");

        if (userName.equalsIgnoreCase("hal")) {
            doFilterForGivenName(servletRequest, servletResponse, filterChain, userName);
        }
    }
}
