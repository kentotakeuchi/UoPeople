package programming1;

public class test {
    // test is the class.
    String x = "Mubarack";
    int y = 56;
    String z = "Education"; // all these are variables

    public static void main(String[] args) {
        test name = new test(); // this is the first object
        test age = new test(); // second object
        test service = new test(); // third object
        System.out.println(name.x);
        System.out.println(age.y);
        System.out.println(service.z);
    }
}
