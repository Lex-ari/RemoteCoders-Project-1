//aimport javax.swing.text.DefaultStyledDocument.ElementSpec; I don't know who put this here or what it does - Alex
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class LinkedBagTest{
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(JUnitTest1.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Linked bag test cases were successful? = " + result.wasSuccessful());

        System.out.println("Creating an empty bag");
        BagInterface<String> aBag = new ResizableArrayBag<>();
        displayBag(aBag);
        testIsEmpty(aBag, true);
        String[] testStrings1 = {"", "B"};
        testFrequency(aBag, testStrings1);
        testContains(aBag, testStrings1);
        testRemove(aBag, testStrings1);

        String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
        testAdd(aBag, contentsOfBag);

        testIsEmpty(aBag, false);
        String[] testStrings2 = {"A", "B", "C", "D", "Z"};
        testFrequency(aBag, testStrings2);
        testContains(aBag, testStrings2);

        String[] testStrings3 = {"", "B", "A", "C", "Z"};
        testRemove(aBag, testStrings3);

        System.out.println("\nClearing the bag");
        aBag.clear();
        testIsEmpty(aBag, true);
        displayBag(aBag);
    }
    private static void testIsEmpty(BagInterface<String> aBag, boolean result){
        System.out.println("Testing isEmpty method...");
        boolean methodCheck = aBag.isEmpty();
        if(result){
            System.out.println("Bag is empty");
        }
        else{
            System.out.println("Bag is not empty");
        }
        if(methodCheck && !result){
            System.out.println("isEmpty returns true but bag is not empty: ERROR");
        }
        else if(!methodCheck && result){
            System.out.println("isEmpty returns false but bag is empty: ERROR");
        }
        else if(methodCheck && result){
            System.out.println("isEmpty returns true: OK");
        }
        else{
            System.out.println("isEmpty returns false: OK");
        }
    }
    private static void testFrequency(BagInterface<String> aBag, String[] content){
        System.out.println("Testing getFrequencyOf method: ");
        int result = aBag.getFrequencyOf("B");
        System.out.println("Frequency of B: " + result);
    }
    private static void testContains(BagInterface<String> aBag, String[] content){
        System.out.println("Testing contains method: ");
        boolean result = aBag.contains("B");
        System.out.println("Does the bag contain B: " + result);
    }
    private static void testRemove(BagInterface<String> aBag, String[] content){
        System.out.println("removing from the bag: ");
        for(int index = 0; index < content.length; index++){
            System.out.print(content[index] + " ");
            aBag.remove(content[index]);
        }
        System.out.println();
        displayBag(aBag);
        
    }
    private static void testAdd(BagInterface<String> aBag, String[] content){
        System.out.println("adding to the bag: ");
        for(int index = 0; index < content.length; index++){
            aBag.add(content[index]);
            System.out.print(content[index] + " ");
        }
        System.out.println();
        displayBag(aBag);
    }
    private static void displayBag(BagInterface<String> aBag){
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for(int index = 0; index < bagArray.length; index++){
            System.out.print(bagArray[index] + " ");
        }
        System.out.println();
       }
    
}