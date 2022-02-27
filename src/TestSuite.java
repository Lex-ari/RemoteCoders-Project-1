import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuite {


    public static void testResizableArrayBag(){
        Result result = JUnitCore.runClasses(ArrayBagTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Resizable Array Bag test cases were successful? = " + result.wasSuccessful());
    }

    public static void testLinkedBag(){
        Result result = JUnitCore.runClasses(LinkedBagTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Linked bag test cases were successful? = " + result.wasSuccessful());
    }
}
