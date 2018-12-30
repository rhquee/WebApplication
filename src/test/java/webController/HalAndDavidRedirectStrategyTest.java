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
import util.EmptyStringException;
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
    //AnnotationAndFieldService service = new AnnotationAndFieldService();

    @Test
    public void supportsHalOrDavid() {
        assertTrue(strategy.supports("hal"));
        assertTrue(strategy.supports("david"));
        assertFalse(strategy.supports(null));
        assertFalse(strategy.supports("not"));
        assertFalse(strategy.supports(""));
    }


//    @Test
//    public void executeHalOrDavid() throws Exception {
//        assertEquals("My mind is going. I can feel it", service.resolveNamesFieldValue("hal", PersonalDataInterface.TYPE.name.get()));
//        assertEquals("My Surname is Hal Brave", service.resolveNamesFieldValue("hal", PersonalDataInterface.TYPE.surname.get()));
//        assertEquals("David here", service.resolveNamesFieldValue("david", PersonalDataInterface.TYPE.surname.get()));
//        assertEquals("David Smith here", service.resolveNamesFieldValue("david", PersonalDataInterface.TYPE.surname.get()));
//    }
//
//    @Test(expected = NoSuchFieldException.class)
//    public void executeHalOrDavid_notExistFieldValue() throws Exception {
//        service.resolveNamesFieldValue("notExist", PersonalDataInterface.TYPE.name.get());
//    }
//
//    @Test(expected = EmptyStringException.class)
//    public void executeHalOrDavid_emptyString() throws Exception {
//        service.resolveNamesFieldValue("", PersonalDataInterface.TYPE.name.get());
//    }
//
//    @Test(expected = EmptyStringException.class)
//    public void executeHalOrDavid_null() throws Exception {
//        service.resolveNamesFieldValue(null, PersonalDataInterface.TYPE.name.get());
//    }

}