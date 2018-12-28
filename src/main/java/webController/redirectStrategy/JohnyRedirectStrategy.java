package webController.redirectStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import service.TeapotService;
import util.EmptyStringException;
import util.PersonalDataInterface;

@Service
public class JohnyRedirectStrategy implements RedirectStrategy {

    @Autowired
    private TeapotService service;
    @Override
    public boolean supports(String name) {
        return "johny".equalsIgnoreCase(name);
    }

    @Override
    public void execute(String name, ModelAndView modelAndView, PersonalDataInterface.TYPE type) throws EmptyStringException, IllegalAccessException {
        modelAndView.setStatus(HttpStatus.I_AM_A_TEAPOT);
        modelAndView.setViewName("error-418");
        modelAndView.addObject("responseString", service.getMessage());
    }
}
