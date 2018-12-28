package webController;

import org.springframework.beans.factory.annotation.Autowired;
import service.AnnotationAndFieldService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.TeapotService;
import util.EmptyStringException;
import util.PersonalDataInterface;
import webController.redirectStrategy.RedirectStrategy;

import java.util.List;

/**
 * Created by kfrak on 04.12.2018.
 */
@Controller
public class NameController {

    private final AnnotationAndFieldService annotationAndFieldValues;
    private final TeapotService teapotService;
    @Autowired
    private List<RedirectStrategy> strategies;

    @Autowired
    public NameController(AnnotationAndFieldService annotationAndFieldValues, TeapotService teapotService) {
        this.annotationAndFieldValues = annotationAndFieldValues;
        this.teapotService = teapotService;
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public ModelAndView resolveIndexView()
            throws IllegalAccessException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public ModelAndView resolveNameView(
            @RequestParam String name,
            @RequestParam PersonalDataInterface.TYPE type)
            throws IllegalAccessException, EmptyStringException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);

        RedirectStrategy strategy = strategies.stream().filter(s -> s.supports(name)).findFirst().get();
        try {
            strategy.execute(name, modelAndView, type);
        } catch (EmptyStringException e) {
           modelAndView.setViewName("errorView");
        } catch (IllegalAccessException e) {
            modelAndView.setViewName("errorView");
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