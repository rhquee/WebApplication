package webController;

import org.springframework.beans.factory.annotation.Autowired;
import service.AnnotationAndFieldService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.TeapotService;
import util.EmptyStringException;
import util.Names;
import util.PersonalDataInterface;
import util.Surnames;

/**
 * Created by kfrak on 04.12.2018.
 */
@Controller
public class NameController {

    private final AnnotationAndFieldService annotationAndFieldValues;
    private final TeapotService teapotService;

    @Autowired
    public NameController(AnnotationAndFieldService annotationAndFieldValues, TeapotService teapotService) {
        this.annotationAndFieldValues = annotationAndFieldValues;
        this.teapotService = teapotService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView resolveIndexView()
            throws IllegalAccessException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public ModelAndView resolveNameView(
            @RequestParam String name,
            @RequestParam String type)
            throws IllegalAccessException, EmptyStringException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);

        if ("hal".equalsIgnoreCase(name) || "david".equalsIgnoreCase(name)) {
            PersonalDataInterface typeOfData = type.equals("name") ? new Names() : new Surnames();
            modelAndView.setViewName(annotationAndFieldValues.resolveTestAnnotationValueFromField(name, typeOfData));
            modelAndView.addObject("responseString", annotationAndFieldValues.resolveNamesFieldValue(name, typeOfData));
        }

        if ("johny".equalsIgnoreCase(name)) {
            modelAndView.setStatus(HttpStatus.I_AM_A_TEAPOT);
            modelAndView.setViewName("error-418");
            modelAndView.addObject("responseString", teapotService.getMessage());
//            request.setAttribute("responseString", teapotService.getMessage());
        }

        return modelAndView;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView resolveNameView()
            throws IllegalAccessException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "nieznajomy");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}