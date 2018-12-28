package webController.redirectStrategy;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import service.AnnotationAndFieldService;
import util.EmptyStringException;
import util.PersonalDataInterface;

@Service
public class HalAndDavidRedirectStrategy implements RedirectStrategy {

    private AnnotationAndFieldService service;
    @Override
    public boolean supports(String name) {
        return "hal".equalsIgnoreCase(name) || "david".equalsIgnoreCase(name);
    }

    @Override
    public void execute(String name, ModelAndView modelAndView, PersonalDataInterface.TYPE type) throws EmptyStringException, IllegalAccessException {
        try {
            modelAndView.setViewName(service.resolveTestAnnotationValueFromField(name, type.get()));
            modelAndView.addObject("responseString", service.resolveNamesFieldValue(name, type.get()));
        } catch (NoSuchFieldException e) {
            modelAndView.setViewName("errorView");
        }
    }
}

