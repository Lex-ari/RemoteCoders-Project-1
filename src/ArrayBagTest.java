import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ArrayBagTest{

    public static void main(String[] args){
        Result result = JUnitCore.runClasses(JUnitTestSuite.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Linked bag test cases were successful? = " + result.wasSuccessful());

        //tests
        ResizableArrayBag<String> aBag = new ResizableArrayBag<String>();

        testIsFull(aBag, false);

        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag, contentsOfBag1);
        testIsFull(aBag, false);

        aBag = new ResizableArrayBag<String>(7);
        System.out.println("\nA new empty bag;");

        testIsFull(aBag, false);

        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D"};
        testAdd(aBag, contentsOfBag2);
        testIsFull(aBag, true);





    }
    private static void testAdd(BagInterface<String> aBag, String[] content){

        System.out.println("adding to the bag");
        for(int index = 0; index < content.length; index++){
            aBag.add(content[index]);
            System.out.println(content[index] + "");
            System.out.println();
            displayBag(aBag);
        }
    }


    private static void testIsFull(ResizableArrayBag<String> aBag, boolean correctResult) {
        System.out.println("\nTesting the method isFull with");
        if(correctResult)
            System.out.println("a full bag;");
        else
            System.out.println("a bag is not full");

        System.out.println("isFUll finds the bag");
        if(correctResult && aBag.isFull())
            System.out.println("full: ok");
        else if(correctResult)
            System.out.println("not full, but it is full: ERROR");
        else if(aBag.isFull())
            System.out.println("full, but it is not full: ERROR");
        else
            System.out.println("not full: Ok");
    }










    private static void displayBag(BagInterface<String> aBag) {
        System.out.println("The bag contains the following strings:");
        Object[] bagArray = aBag.toArray();
        for(int index = 0; index < bagArray.length; index++){
            System.out.println(bagArray[index] + "");

        }
        System.out.println();
    }

    public <T> void union(T[] contentsOfBag1, T[] contentsOfBag2){

    }
}
