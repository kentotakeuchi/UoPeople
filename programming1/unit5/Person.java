public class Person {

    // instance variables
    // variables which have "protected" modifier can only be accessed in the
    // subclasses
    protected String name;
    protected int age;

    // constructor
    public Person(String name, int age) {
        // "this" refers to the object that contains the variables
        // in this case, "this" refers to Person class
        this.name = name;
        this.age = age;
    }

    // instance method
    public void introduce() {
        System.out.printf("Hi, my name is %s and %d years old.\n", this.name, this.age);
    }
}
