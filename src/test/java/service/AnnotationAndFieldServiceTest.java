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

    @Test
    public void resolveView_VariousFieldValue() throws Exception {
       // assertEquals("class doesn't have a field of a specified name", service.resolveTestAnnotationValueFromField("Zenek", names));
        //assertEquals("error", service.resolveTestAnnotationValueFromField(null, names));
        assertEquals("halView", service.resolveTestAnnotationValueFromField("hal", names));
        assertEquals("halView", service.resolveTestAnnotationValueFromField("hal", surnames));
    }

    @Test (expected = EmptyStringException.class)
    public void resolveView_emptyFieldValue() throws Exception {
        assertEquals("your string is empty", service.resolveTestAnnotationValueFromField("", names));
    }

    @Test (expected = EmptyStringException.class)
    public void resolveView_emptyFieldValue() throws Exception {
        assertEquals("your string is empty", service.resolveTestAnnotationValueFromField("", names));
    }

    @Test (expected = EmptyStringException.class)
    public void resolveView_nullFieldValue() throws Exception {
        assertEquals("your string is empty", service.resolveTestAnnotationValueFromField(null, names));
    }

    @Test (expected = NullPointerException.class)
    public void resolveView_notExistingField() throws Exception {
        assertEquals("your string is empty", service.resolveTestAnnotationValueFromField("not existing field", names));
    }

    @Test
    public void resolveResponseString_VariousResponseStringValue() throws Exception {
        assertEquals("field doesn't have an annotation of a specified name", service.resolveNamesFieldValue("", names));
        assertEquals("not existing field value", service.resolveNamesFieldValue(null, names));
        assertEquals("field doesn't have an annotation of a specified name", service.resolveNamesFieldValue("Zenek", names));
        assertEquals("My mind is going. I can feel it", service.resolveNamesFieldValue("hal", names));
        assertEquals("My Surname is Hal Brave", service.resolveNamesFieldValue("hal", surnames));
        assertEquals("David here", service.resolveNamesFieldValue("david", names));
        assertEquals("David Smith here", service.resolveNamesFieldValue("david", surnames));
    }

}