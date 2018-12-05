package webController;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import service.AnnotationAndFieldService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.TeapotService;

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

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public ModelAndView resolveView(@RequestParam String name)
            throws IllegalAccessException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);

        if ("hal".equalsIgnoreCase(name) || "david".equalsIgnoreCase(name)) {
            modelAndView.setViewName(annotationAndFieldValues.resolveView(name));
            modelAndView.addObject("responseString", annotationAndFieldValues.resolveResponseString(name));
        }
        if ("johny".equalsIgnoreCase(name)) {
            modelAndView.setStatus(HttpStatus.I_AM_A_TEAPOT);
            modelAndView.setViewName("error-418");
            modelAndView.addObject("msg", teapotService.getMessage());
        }
        if (StringUtils.isEmpty(modelAndView.getViewName())) {
            modelAndView.setViewName("hello");
        }
        return modelAndView;
    }
}