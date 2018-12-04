package webController;

import service.CacheForAnnotationAndFieldValues;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kfrak on 04.12.2018.
 */
//public class NameController {
//
////    private final NameService nameService;
////
////    @Autowired
////    public NameController(NameService nameService) {
////        this.nameService = nameService;
////    }
//
//    @Autowired
//    public CacheForAnnotationAndFieldValues cacheForAnnotationAndFieldValues;
//
//
//    @RequestMapping(value = "/hello", method = RequestMethod.POST)
//    public ModelAndView getInputFromUserAndShowHelloPage(
//            @RequestParam("name") String name) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("halView");
//        modelAndView.addObject("responseString", cacheForAnnotationAndFieldValues.getAnnotationValue());
//
//        return modelAndView;
//    }
//}


@Controller
public class NameController {

    private final CacheForAnnotationAndFieldValues annotationAndFieldValues;

    public NameController(CacheForAnnotationAndFieldValues annotationAndFieldValues) {
        this.annotationAndFieldValues = annotationAndFieldValues;
    }

//    @GetMapping("/")
//    public String index() {
//        System.out.println("In index");
//        return "index";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public ModelAndView resolveView(@RequestParam String name)
            throws IllegalAccessException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.setViewName(annotationAndFieldValues.resolveView(name));
        modelAndView.addObject("responseString", annotationAndFieldValues.resolveResponseString(name));

        if ("johny".equals(name)) {
            modelAndView.setStatus(HttpStatus.I_AM_A_TEAPOT);
            modelAndView.setViewName("error-418");
        }
        if (StringUtils.isEmpty(modelAndView.getViewName())) {
            modelAndView.setViewName("hello");
        }

        return modelAndView;
    }
}