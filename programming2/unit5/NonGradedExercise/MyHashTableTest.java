// package programming2.unit5.NonGradedExercise;

public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable table = new MyHashTable();
        table.put("messi", "psg");
        table.put("neymar", "psg");
        table.put("kubo", "real sociedad");
        table.put("haaland", "manchester city");
        System.out.println("Size: " + table.size());
        System.out.println("Contains key 'messi': " + table.containsKey("messi"));
        System.out.println("Contains key 'iniesta': " + table.containsKey("iniesta"));
        System.out.println("Value for key 'kubo': " + table.get("kubo"));
        System.out.println("Value for key 'haaland': " + table.get("haaland"));
        table.remove("messi");
        table.remove("haaland");
        System.out.println("Size: " + table.size());
    }
}
