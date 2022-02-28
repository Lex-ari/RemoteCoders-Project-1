import java.util.Arrays;
public class BagDriver {
    public static void main(String[] args) throws NullPointerException {
        TestSuite.testResizableArrayBag();
        TestSuite.testLinkedBag();



        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();


        System.out.println("Union in two bags:  " + Arrays.toString(bag1.union(bag2).toArray()));
        System.out.println("Intercection in two bags: " + Arrays.toString(bag1.intersection(bag2).toArray()));
        System.out.println("Difference in two bag: " + Arrays.toString(bag1.difference(bag2).toArray()));


    }
    private String add(String bag1, String bag2) {






        return null;
    }
}