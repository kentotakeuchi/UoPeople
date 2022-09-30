/*
 * Give examples showing how "super" and "this" are useful with inheritance in Java. Include examples of using "super" and "this" both as constructors and as variables.
 */

public class Main {
    // main driver
    public static void main(String[] args) {
        Person ronaldinho = new SoccerPlayer("Ronaldinho", 45, 10, "FW");
        ronaldinho.introduce();

        Person zidan = new SoccerPlayer("zidan", 44, 10, "MF");
        zidan.introduce();

        Person taro = new SoccerPlayer("taro", 17, 4, "DF");
        taro.introduce();
    }
}

/*
 * References
 * Eck, D. J. (2019). Introduction to programming using Java, version 8.1.
 * http://math.hws.edu/javanotes
 */