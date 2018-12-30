package webController.redirectStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import service.AnnotationAndFieldService;
import util.EmptyStringException;
import util.PersonalDataInterface;

import java.nio.file.NoSuchFileException;

@Service
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HalAndDavidRedirectStrategy implements RedirectStrategy {

    @Autowired
    private AnnotationAndFieldService service;

    @Override
    public boolean supports(String name) {
        return "hal".equalsIgnoreCase(name) || "david".equalsIgnoreCase(name);
    }

    @Override
    public void execute(String name, ModelAndView modelAndView, PersonalDataInterface.TYPE type) throws EmptyStringException, IllegalAccessException, NoSuchFieldException {
            modelAndView.setViewName(service.resolveTestAnnotationValueFromField(name, type.get()));
            modelAndView.addObject("responseString", service.resolveNamesFieldValue(name, type.get()));
        }
    }

