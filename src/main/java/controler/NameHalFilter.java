package controler;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@WebFilter (filterName = "NameHalFilter", servletNames = "Servlet")
public class NameHalFilter extends NameCatcher implements Filter {

    protected String getName() {
        return "hal";
    }
}
