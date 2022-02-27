//aimport javax.swing.text.DefaultStyledDocument.ElementSpec; I don't know who put this here or what it does - Alex
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Assert.*;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LinkedBagTest{

    BagInterface aBag = new ResizableArrayBag<>();
    BagInterface bBag = new ResizableArrayBag<>();

    /**
     * Runs before each test. Sets aBag and bBag to default values.
     * @throws Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        aBag.clear();
        bBag.clear();
        addArrayContents(aBag, new Object[]{'a', 'a', 'b', 'b', 'b', 'c', 'd', 'e'});
        addArrayContents(bBag, new Object[]{'a', 'b', 'b', 'e', 'e'});
    }

    @Ignore
    private static void addArrayContents(BagInterface bagEntry, Object[] arrayEntry){
        for (Object element : arrayEntry){
            bagEntry.add(element);
        }
    }

    /**
     * Tests to see if all initialization elements have been properly added to the bags. This tests teh add() method of the bags.
     */
    @Test
    public void testInitialization(){
        assertEquals(aBag, new Object[]{'a', 'a', 'b', 'b', 'b', 'c', 'd', 'e'});
        assertEquals(bBag, new Object[]{'a', 'b', 'b', 'e', 'e'});
    }

    @Test
    public void testClear(){
        aBag.clear();
        assertEquals(Arrays.toString(aBag.toArray()), "[]");
    }

    @Test
    public void testIsEmpty(){
        aBag.clear();
        assertEquals(aBag.isEmpty(), true);
        assertEquals(bBag.isEmpty(), false);
    }

    @Test
    public void testFrequency(){
        assertEquals(aBag.getFrequencyOf('b'), 3);
        assertEquals(bBag.getFrequencyOf('j'), 0);
    }

    @Test
    public void testContains(){
        assertEquals(aBag.contains('b'), true);
        assertEquals(bBag.contains('k'), false);
    }

    @Test
    public void testRemove(){
        bBag.remove('a');
        //Assertion, bBag is initialized and that testContains() is successful.
        assertEquals(bBag.contains('a'), false);
        aBag.remove('b');
        assertEquals(aBag.contains('b'), true);
    }

}