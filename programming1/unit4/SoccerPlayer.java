package programming1.unit4;

/*
 What is a class?
 A class is a blueprint, which contains variables and methods, for creating actual entities. That is, a class in Java rules how an entity behaves. In addition, a class can be a type such as int, double, and boolean. Therefore, a class name can be used to type variables, formal parameters, or return values. A class is a fundamental concept of Object Oriented Programming.
 */

/*
 What is an object?
 An object is an instance of a class, which contains variables and methods, for coping with a specific type of arguments. Since an object is created and gotten rid of when the program runs, “there can be many objects with the same structure, if they are created using the same class” (Eck, D. J, 2019).
 */

/*
 How are they related?
 An object belongs to a class. A class instantiates an object. For example, if you purchase a chair in Ikea and assemble it by yourself, you should have the instruction. The instruction is sort of a class in Object Oriented Programming. The actual chair is an object. Although the color or size of the actual chair might be different, the fundamental structure is always same since the structure was defined in the instruction.
 */

// My example
// a class
public class SoccerPlayer {
    public String name;
    public String position;
    public int number;

    // constructor
    public SoccerPlayer(String name, String position, int number) {
        this.name = name;
        this.position = position;
        this.number = number;
    }

    // main driver
    public static void main(String[] args) {
        // the variable "bob" is the object from the class called "SoccerPlayer"
        // the type of the variable is "SoccerPlayer"
        SoccerPlayer bob = new SoccerPlayer("bob", "cdm", 8);
        System.out.printf("%s %s %d\n", bob.name, bob.position, bob.number);

        // the variable "ronaldinho" is the object from the class called "SoccerPlayer"
        // the type of the variable is "SoccerPlayer"
        SoccerPlayer ronaldinho = new SoccerPlayer("ronaldinho", "cam", 10);
        System.out.printf("%s %s %d\n", ronaldinho.name, ronaldinho.position, ronaldinho.number);

        // the variable "zidan" is the object from the class called "SoccerPlayer"
        // the type of the variable is "SoccerPlayer"
        SoccerPlayer zidan = new SoccerPlayer("zidan", "cam", 10);
        System.out.printf("%s %s %d", zidan.name, zidan.position, zidan.number);
    }
}

/*
 * References
 * Eck, D. J. (2019). Introduction to programming using Java, version 8.1.
 * http://math.hws.edu/javanotes
 */