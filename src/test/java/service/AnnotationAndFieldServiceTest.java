package service;

import config.SpringRootConfig;
import config.SpringWebConfig;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by kfrak on 05.12.2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
public class AnnotationAndFieldServiceTest {
    @org.junit.Test
    public void resolveView() throws Exception {

        String expected = "halView;";

        String result = new AnnotationAndFieldService().resolveView("hal");

        assertEquals(expected, result);

    }

    @Test
    public void resolveResponseString() throws Exception {

        String expected = "My mind is going. I can feel it";
        String result = new AnnotationAndFieldService().resolveResponseString("hal");
        assertEquals(expected, result);
    }

}