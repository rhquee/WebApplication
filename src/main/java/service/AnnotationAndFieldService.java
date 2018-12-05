package service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class AnnotationAndFieldService {

    private Names names = new Names(); //mój obiekt
    private Class<?> clazz = names.getClass(); //obiekt Class

    public String resolveView(String userName) {
        //wartość pola
        try {
            Field field = clazz.getDeclaredField(userName); // pole
            field.setAccessible(true); //bo prywatne

            //wartość adnotacji
            return field.isAnnotationPresent(Test.class)
                    ? field.getAnnotation(Test.class).value()
                    : "";
        } catch (NoSuchFieldException e) {
            return "";
        }
    }

    public String resolveResponseString(String userName) throws IllegalAccessException {
        try {
            Field field = clazz.getDeclaredField(userName); // pole
            field.setAccessible(true); //bo prywatne
            return (String)field.get(names);
        } catch (NoSuchFieldException e) {
            return "";
        }
    }
}