//package service;
//
//import config.SpringRootConfig;
//import config.SpringWebConfig;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import static org.junit.Assert.*;
//
///**
// * Created by kfrak on 05.12.2018.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = {SpringRootConfig.class, SpringWebConfig.class})
//public class AnnotationAndFieldServiceTest {
//
//    private AnnotationAndFieldService service = new AnnotationAndFieldService();;
//
//    @Test
//    public void resolveView_emptyFieldValue() throws Exception {
//        //assertEquals("dupa", service.resolveTestAnnotationValueFromField(""));
//        assertEquals("xx", service.resolveTestAnnotationValueFromField(""));
//        assertEquals("class doesn't have a field of a specified name", service.resolveTestAnnotationValueFromField("zenek"));
//        assertEquals("not existing field name", service.resolveTestAnnotationValueFromField(null));
//        assertEquals("halView", service.resolveTestAnnotationValueFromField("hal"));
//    }
//
//    @Test
//    public void resolveResponseString() throws Exception {
//        String expected = "My mind is going. I can feel it";
//        String result = new AnnotationAndFieldService().resolveNamesFieldValue("hal");
//        assertEquals(expected, result);
//    }
//
//}