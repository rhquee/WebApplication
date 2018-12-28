package webController.redirectStrategy;

import org.springframework.web.servlet.ModelAndView;
import util.EmptyStringException;
import util.PersonalDataInterface;

/**
 * Created by kfrak on 18.12.2018.
 */
public interface RedirectStrategy {

    boolean supports(String name);

    void execute(String name, ModelAndView modelAndView, PersonalDataInterface.TYPE type) throws EmptyStringException, IllegalAccessException;
}
