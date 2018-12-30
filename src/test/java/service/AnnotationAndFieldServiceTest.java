package service;

import config.SpringRootConfig;
import config.SpringWebConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import util.EmptyStringException;
import util.Names;
import util.Surnames;
import webController.NameController;

import javax.servlet.ServletContext;

import static org.junit.Assert.*;

/**
 * Created by kfrak on 05.12.2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
public class AnnotationAndFieldServiceTest {
    private AnnotationAndFieldService service = new AnnotationAndFieldService();
    private Names names = new Names();
    private Surnames surnames = new Surnames();

    @Test(expected = NoSuchFieldException.class)
    public void resolveView_notExistingFieldValue() throws Exception {
        service.resolveTestAnnotationValueFromField("not existing field", names);
    }

    @Test(expected = EmptyStringException.class)
    public void resolveView_FieldValueEmptyString() throws Exception {
        service.resolveTestAnnotationValueFromField("", names);
    }

    @Test(expected = EmptyStringException.class)
    public void resolveView_FieldValueNull() throws Exception {
        service.resolveTestAnnotationValueFromField(null, names);
    }

    @Test
    public void resolveView_VariousFieldValueFromScope() throws Exception {
        assertEquals("halView", service.resolveTestAnnotationValueFromField("hal", names));
        assertEquals("halView", service.resolveTestAnnotationValueFromField("hal", surnames));
        assertEquals("davidView", service.resolveTestAnnotationValueFromField("david", surnames));
        assertEquals("davidView", service.resolveTestAnnotationValueFromField("david", surnames));
    }

    @Test (expected = NoSuchFieldException.class)
    public void resolveResponseString_NotExistResponseStringValue() throws Exception {
        service.resolveNamesFieldValue("not exist", names);
    }

    @Test (expected = EmptyStringException.class)
    public void resolveResponseString_EmptyResponseStringValue() throws Exception {
        service.resolveNamesFieldValue("", names);
    }

    @Test (expected = EmptyStringException.class)
    public void resolveResponseString_NullResponseStringValue() throws Exception {
        service.resolveNamesFieldValue(null, names);
    }

        @Test
        public void resolveResponseString_VariousResponseStringValueFromScope() throws Exception {
        assertEquals("My mind is going. I can feel it", service.resolveNamesFieldValue("hal", names));
        assertEquals("My Surname is Hal Brave", service.resolveNamesFieldValue("hal", surnames));
        assertEquals("David here", service.resolveNamesFieldValue("david", names));
        assertEquals("David Smith here", service.resolveNamesFieldValue("david", surnames));
    }

}