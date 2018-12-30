package webController.redirectStrategy;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import util.EmptyStringException;
import util.PersonalDataInterface;

/**
 * Created by kfrak on 18.12.2018.
 */
@Service
public class DefaultStrategy implements RedirectStrategy {
    @Override
    public boolean supports(String name) {
        return true;
    }

    @Override
    public void execute(String name, ModelAndView modelAndView, PersonalDataInterface.TYPE type) throws IllegalAccessException, EmptyStringException {
        if (StringUtils.isEmpty(name)) {
            throw new EmptyStringException();
        }
        modelAndView.setViewName("hello");
        modelAndView.addObject("responseString", name);
    }
}