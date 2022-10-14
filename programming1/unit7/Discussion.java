package programming1.unit7;

// What are wrapper classes and why are they useful for ArrayLists? In your answer, include examples of autoboxing and unboxing.

// What are wrapper classes?
// Wrapper classes are classes that contain primitive data types such as int, boolean, byte, short, char, double, long, and float. These classes encompass useful static methods. For instance, if you want to convert a string into a numerical value, you can use Integer.parseInteger() method. The Integer is the wrapper class. Wrapper classes are used not only for useful methods but also for representing primitive type values as objects.

// Why are they useful for ArrayLists?
// First of all, ArrayList is a class that is defined in the package java.util and a parameterized type. Although the parameterized type takes a type parameter, it cannot be primitive types such as int and boolean. It must be an object type and the primitive types are not objects. Therefore, the wrapper classes are useful because they are objects which represent the primitive type values as I mentioned before.

// Autoboxing
// When you want to store primitive type values in an ArrayList, you need to wrap the primitive type values in the wrapper classes because the parameter of ArrayList does not allow the primitive types. For example, if you want to store int values in an ArrayList, you need to use the method Integer.valueOf(). However, it is a bit more cumbersome that the primitive type int. Fortunately, Java automatically converts primitive types into corresponding wrapper classes without converting them manually. It is called autoboxing.

// Unboxing
// Unboxing means that it converts the wrapper classes into primitive types. That is, It is the opposite of autoboxing.

public class Discussion {
    public static void main(String[] args) {
        // The example of autoboxing
        Integer value1 = 10; // this is equivalent to "Integer value = Integer.valueOf(10)";

        // The example of unboxing
        Integer object = new Integer(10);
        int value2 = object; // this is equivalent to "int value2 = object.intValue();"

        // The output
        System.out.println("Output:");
        System.out.println(value1 instanceof Integer);
        // System.out.println(value2 instanceof Integer);
    }
}

// Output:
// true
// Exception in thread "main" java.lang.Error: Unresolved compilation problem:
// Incompatible conditional operand types int and Integer

// References
// Eck, D. J. (2019). Introduction to programming using Java, version 8.1.
// http://math.hws.edu/javanotes