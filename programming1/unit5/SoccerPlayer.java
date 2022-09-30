// SoccerPlayer is a subclass of Person, which is a superclass
public class SoccerPlayer extends Person {

    // instance variables
    protected int number;
    protected String position;

    // constructor1
    public SoccerPlayer(String name, int age, int number, String position) {
        // "this" which has 2 arguments calls the constructor2
        this(name, age);
        // initialize the instance variables
        this.number = number;
        this.position = position;
    }

    // constructor2
    public SoccerPlayer(String name, int age) {
        // call the constructor from the Person class
        super(name, age);
    }

    // instance method
    // "When a subclass contains an instance method that has the same signature as a
    // method in its superclass, the method from the superclass is hidden in the
    // same way. We say that the method in the subclass overrides the method from
    // the superclass" (Eck, D. J, 2019).
    public void introduce() {
        // call the introduce method from the Person class
        super.introduce();
        System.out.printf("My number is %d and my position is %s.\n", this.number,
                this.position);
        System.out.println("I'll do my best.\n");
    }

}