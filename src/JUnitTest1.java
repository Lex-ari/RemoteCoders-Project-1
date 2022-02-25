import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTest1 {

    private String correctSimilarity; //This string is modified for different tests
    private String implementationResult;

    @Before
    public static void setUp() throws Exception{

    }

    @Test
    public void testAdd(){

    }

    @After
    public static void tearDown() throws Exception{

    }

    @Test
    public void testPrintMessage(){
        assertEquals(correctSimilarity, implementationResult);
    }


}
