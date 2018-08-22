package model;

class Names implements AnnotatedClass {
    @Test(value = "halView")
    private String hal = "My mind is going. I can feel it";

    @Test(value = "davidView")
    private String david = "David here";
}