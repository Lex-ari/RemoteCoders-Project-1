import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTest1 {

    private String correctSimilarity; //This string is modified for different tests
    private String implementationResult;
    private static char[] bag1TestingArray;
    private String[] bag2TestingArray;

    /**
     * Runs before each test.
     * @throws Exception
     */
    @Before
    public static void setUp() throws Exception{

    }

    @Test
    public void testAdd(){

    }

    @Test
    public void unionTest(){

    }

    /**
     * Runs after each test
     * @throws Exception
     */
    @After
    public static void tearDown() throws Exception{

    }

    @Test
    public void testPrintMessage(){
        assertEquals(correctSimilarity, implementationResult);
    }


}
