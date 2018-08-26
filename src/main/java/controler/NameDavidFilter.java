package controler;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Osobny filtr dla każdego imienia:
 * [S]olid -> SRP, Single Responsibility Principle - klasa powinna mieć tylko jedną odpowiedzialność (nigdy nie powinien istnieć więcej niż jeden powód do modyfikacji klasy).
 * s[O]lid -> OCP, Open/Closed Principle - kod powinien być otwarty na rozszerzenia, a zamknięty na modyfikację
 */

@WebFilter(filterName = "NameDavidFilter", servletNames = "Servlet")
public class NameDavidFilter extends NameCatcher implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userName = servletRequest.getParameter("name");

        if (userName.equalsIgnoreCase("david")) {
          doFilterForGivenName(servletRequest, servletResponse, filterChain, userName);
        }
    }
}