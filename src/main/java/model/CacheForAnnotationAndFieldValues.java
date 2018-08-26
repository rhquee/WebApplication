package model;

import java.lang.reflect.Field;

public class CacheForAnnotationAndFieldValues {
    private String annotationValue = "";
    private String fieldValue = "";

    public String getAnnotationValue() {return annotationValue; }
    private void setAnnotationValue(String annotationValue) {
        this.annotationValue = annotationValue;
    }
    public String getFieldValue() {
        return fieldValue;
    }
    private void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public CacheForAnnotationAndFieldValues(String userName) throws NoSuchFieldException, IllegalAccessException {
        Names names = new Names(); //mój obiekt
        Class<?> clazz = names.getClass(); //obiekt Class
        System.out.println("Klasa: " + clazz.getName());

        //wartość pola
        Field field = clazz.getDeclaredField(userName); // pole
        field.setAccessible(true); //bo prywatne
        setFieldValue((String) field.get(names));
        System.out.println("FieldValue: " + getFieldValue());

        //wartość adnotacji
        if (field.isAnnotationPresent(Test.class)) {
            Test annotation = field.getAnnotation(Test.class);
            setAnnotationValue(annotation.value());
            System.out.println("AnnotationValue: " + getAnnotationValue());
        }
    }
}

