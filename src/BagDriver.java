import java.awt.*;
import java.util.Arrays;
public class BagDriver{

    public static void main(String[] args){

        TestRunner.testResizableArrayBag();
        TestRunner.testLinkedBag();

        System.out.println("\n == Start of Demo Program== \n");
        BagInterface demoBag1 = new ResizableArrayBag<>();
        BagInterface demoBag2 = new ResizableArrayBag<>();

        char[] contentsOfBag1 = {'a', 'a', 'b', 'b', 'b', 'c', 'd', 'e'};
        addDemo(demoBag1, contentsOfBag1);

        char[] contentsOfBag2 = {'a', 'b', 'b', 'e', 'e'};
        addDemo(demoBag2, contentsOfBag2);


        unionDemo(demoBag1, demoBag2);

        intersectionDemo(demoBag1, demoBag2);

        System.out.println("\nDemo Difference using demoBag1.difference(demoBag2)");
        differenceDemo(demoBag1, demoBag2);
        System.out.println("Demo Difference using demoBag2.difference(demoBag1)");
        differenceDemo(demoBag2, demoBag1);
    }

    /**
     * Demo code to add contents in an array into a bag.
     * @param aBag Baginterface in which contents will be added to.
     * @param content array holding content to be added to the array.
     */
    private static void addDemo(BagInterface<Character> aBag, char[] content){
        System.out.println("Adding to new bag");
        for(int i = 0; i < content.length; i++){
            aBag.add(content[i]);
            System.out.print(content[i] + " ");
    }
        System.out.println();
    }

    /**
     * Demo union() code that prints out the result.
     * @param aBagEntry A Bag Interface to be unioned with another.
     * @param bBagEntry A Bag Interface to be unioned with another.
     */
    private static void unionDemo(BagInterface aBagEntry, BagInterface bBagEntry){

        System.out.println("Union in two bags: " + Arrays.toString(aBagEntry.union(bBagEntry).toArray()));
    }

    /**
     * Demo intersection() code that prints out the result.
     * @param aBagEntry A Bag Interface to be intersectioned with another.
     * @param bBagEntry A Bag Interface to be intersectioned with another.
     */
    private static void intersectionDemo(BagInterface<String> aBagEntry, BagInterface<String> bBagEntry){
        System.out.println("Intersection in two bags: " + Arrays.toString(aBagEntry.intersection(bBagEntry).toArray()));
    }

    /**
     * Demo difference() code that prints out the result.
     * @param aBagEntry A Bag Interface that will have contents taken away if the 2nd entry also exist.
     * @param bBagEntry A Bag Interface that will subtract contents from 1st entry if both exist.
     */
    private static void differenceDemo(BagInterface<String> aBagEntry, BagInterface<String> bBagEntry){
        System.out.println("Difference in two bags: " + Arrays.toString(aBagEntry.difference(bBagEntry).toArray()));
    }
}
