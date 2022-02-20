import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class LinkedBagTest{
    public static void main(String[] args){
        System.out.println("Creating an empty bag");
        BagInterface<String> aBag = new LinkedBag<>();
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
        if(methodCheck == result){
            System.out.println("Valid method");
        }
        else{
            System.out.println("Invalid method");
        }
    }
    private static void testFrequency(BagInterface<String> aBag, String[] array){
        int methodCheck = aBag.getFrequencyOf("B");
        if(methodCheck == 1){
            System.out.println("Valid method");
        }
        else{
            System.out.println("Invalid method");
        }
    }
    private static void testContains(BagInterface<String> aBag, String[] array){
        boolean methodCheck = aBag.contains("B");
        if(methodCheck){
            System.out.println("Valid method");
        }
        else{
            System.out.println("Invalid method");
        }
    }
    private static void testRemove(BagInterface<String> aBag, String[] array){
        System.out.println(aBag);
        aBag.remove();
        System.out.println(aBag);
        
    }
    private static void testAdd(BagInterface<String> aBag, String[] array){
        System.out.println(aBag);
        aBag.add("A");
        System.out.println(aBag);
    }
    
}