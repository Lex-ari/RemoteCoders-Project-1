import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JUnitTestSuite {


    public void testResizableArrayBag(){
        Result result = JUnitCore.runClasses(ResizableArrayBag.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Resizable Array Bag test cases were successful? = " + result.wasSuccessful());
    }

    public void testLinkedBag(){
        Result result = JUnitCore.runClasses(LinkedBagTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println("Linked bag test cases were successful? = " + result.wasSuccessful());
    }
}
