package service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

//@Configuration
//public class CacheForAnnotationAndFieldValues {
//    private String annotationValue = "";
//    private String fieldValue = "";
//
//    public String getAnnotationValue() {return annotationValue; }
//    private void setAnnotationValue(String annotationValue) {
//        this.annotationValue = annotationValue;
//    }
//    public String getFieldValue() {
//        return fieldValue;
//    }
//    private void setFieldValue(String fieldValue) {
//        this.fieldValue = fieldValue;
//    }
//
//    public void readAnnotationValue(String userName) throws NoSuchFieldException, IllegalAccessException {
//        Names names = new Names(); //mój obiekt
//        Class<?> clazz = names.getClass(); //obiekt Class
//
//        //wartość pola
//        Field field = clazz.getDeclaredField(userName); // pole
//        field.setAccessible(true); //bo prywatne
//        setFieldValue((String) field.get(names));
//
//        //wartość adnotacji
//        if (field.isAnnotationPresent(Test.class)) {
//            Test annotation = field.getAnnotation(Test.class);
//            setAnnotationValue(annotation.value());
//        }
//    }
//}

@Service
public class CacheForAnnotationAndFieldValues {

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