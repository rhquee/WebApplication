package controler;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "NameJohnyFilter", servletNames = "Servlet")
public class NameJohnyFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String userName = servletRequest.getParameter("name");
        if (userName.equalsIgnoreCase("johny")) {
            httpServletResponse.setStatus(418);
            httpServletResponse.sendError(418);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

