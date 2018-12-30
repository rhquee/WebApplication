package service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import util.EmptyStringException;
import util.PersonalDataInterface;
import util.Test;

import java.lang.reflect.Field;

@Service
public class AnnotationAndFieldService {

    public String resolveTestAnnotationValueFromField(String inputName, PersonalDataInterface personalDataInterface) throws EmptyStringException, NoSuchFieldException {
        Class<?> clazz = personalDataInterface.getClass(); //obiekt Class
        if (StringUtils.isEmpty(inputName)) {
            throw new EmptyStringException();
        }
        Field field = clazz.getDeclaredField(inputName); // pole
        field.setAccessible(true); //bo prywatne
        return field.getAnnotation(Test.class).value();

    }

    public String resolveNamesFieldValue(String fieldName, PersonalDataInterface personalDataInterface) throws IllegalAccessException, NoSuchFieldException, EmptyStringException {
        Class<?> clazz = personalDataInterface.getClass(); //obiekt Class
        if(StringUtils.isEmpty(fieldName)){
            throw new EmptyStringException();
        }
        Field field = clazz.getDeclaredField(fieldName); // pole
            field.setAccessible(true); //bo prywatne
            return (String) field.get(personalDataInterface);
    }
}