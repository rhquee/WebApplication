package service;

import org.junit.Test;
import util.EmptyStringException;
import util.Names;
import util.Surnames;

import static org.junit.Assert.assertEquals;

/**
 * Created by kfrak on 05.12.2018.
 */
public class AnnotationAndFieldServiceTest {
    private AnnotationAndFieldService service = new AnnotationAndFieldService();
    private Names names = new Names();
    private Surnames surnames = new Surnames();

    @Test(expected = NoSuchFieldException.class)
    public void resolveView_notExistingFieldValue() throws Exception {
        service.resolveTestAnnotationValueFromField("notExistingAnnotationValue", names);
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
        service.resolveNamesFieldValue("notExist", names);
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