package webController;

import config.SpringRootConfig;
import config.SpringWebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import service.AnnotationAndFieldService;
import util.PersonalDataInterface;
import webController.redirectStrategy.HalAndDavidRedirectStrategy;
import webController.redirectStrategy.RedirectStrategy;

import static org.junit.Assert.*;
import static util.PersonalDataInterface.TYPE.name;
import static util.PersonalDataInterface.TYPE.surname;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
public class HalAndDavidRedirectStrategyTest {

    RedirectStrategy strategy = new HalAndDavidRedirectStrategy();
    AnnotationAndFieldService service = new AnnotationAndFieldService();

    @Test
    public void supportsHalOrDavid() {
        assertTrue(strategy.supports("hal"));
        assertTrue(strategy.supports("david"));
        assertFalse(strategy.supports(null));
        assertFalse(strategy.supports("not"));
        assertFalse(strategy.supports(""));
    }

//    modelAndView.setViewName(service.resolveTestAnnotationValueFromField(name, type.get()));
//            modelAndView.addObject("responseString", service.resolveNamesFieldValue(name, type.get()));

//    @Test
//    public void executeHalOrDavid(){
//        assertEquals("My mind is going. I can feel it", service.resolveNamesFieldValue("hal", name));
//        assertEquals("My Surname is Hal Brave", service.resolveNamesFieldValue("hal", surname));
//        assertEquals("David here", service.resolveNamesFieldValue("david", name));
//        assertEquals("David Smith here", service.resolveNamesFieldValue("david", surname));
//    }
}