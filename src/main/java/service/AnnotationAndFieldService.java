package service;

import org.springframework.stereotype.Service;
import util.EmptyStringException;
import util.PersonalDataInterface;
import util.Test;

import java.lang.reflect.Field;

@Service
public class AnnotationAndFieldService {

    public String resolveTestAnnotationValueFromField(String inputName, PersonalDataInterface personalDataInterface) throws EmptyStringException {
        Class<?> clazz = personalDataInterface.getClass(); //obiekt Class
        try {
            if (inputName.equals("")) {
                throw new EmptyStringException("your string is empty");
            }
            Field field = clazz.getDeclaredField(inputName); // pole
            field.setAccessible(true); //bo prywatne
            //wartość adnotacji
//            if (field.isAnnotationPresent(Test.class)) {
//                if (field.getAnnotation(Test.class).value().equals("")) {
//                    throw new EmptyStringException("lol");
//                }
//            }
            return field.getAnnotation(Test.class).value();
//        } catch (EmptyStringException e) {
//            return "string is empty";
        } catch (NoSuchFieldException e) {
            return "class doesn't have a field of a specified name";
        } catch (NullPointerException e) {
            return "not existing field name";
        }
    }

    public String resolveNamesFieldValue(String fieldName, PersonalDataInterface personalDataInterface) throws IllegalAccessException {
        Class<?> clazz = personalDataInterface.getClass(); //obiekt Class
        try {
            Field field = clazz.getDeclaredField(fieldName); // pole
            field.setAccessible(true); //bo prywatne
            return (String) field.get(personalDataInterface);
        } catch (NoSuchFieldException e) {
            return "field doesn't have an annotation of a specified name";
        } catch (NullPointerException e){
            return "not existing field value";
        }
    }
}