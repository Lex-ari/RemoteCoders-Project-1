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

    BagInterface aBag = new LinkedBag();
    BagInterface bBag = new LinkedBag();

    /**
     * Runs before each test. Sets aBag and bBag to default values.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        aBag.clear();
        bBag.clear();
        addArrayContents(aBag, new Object[]{'e', 'd', 'c', 'b', 'b', 'b', 'a', 'a'});
        addArrayContents(bBag, new Object[]{'e', 'e', 'b', 'b', 'a'});
    }

    /**
     * Adds each element of an array into a given bag.
     * @param bagEntry a BagInterface for an array of objects to be added to.
     * @param arrayEntry an array of Objects in which each element is added to bagEntry
     */
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
        assertEquals(Arrays.toString(new Object[]{'a', 'a', 'b', 'b', 'b', 'c', 'd', 'e'}), Arrays.toString(aBag.toArray()));
        assertEquals(Arrays.toString(new Object[]{'a', 'b', 'b', 'e', 'e'}),  Arrays.toString(bBag.toArray()));
    }

    /**
     * Tests to see if clear() is functioning properly
     */
    @Test
    public void testClear(){
        aBag.clear();
        assertEquals("[]", Arrays.toString(aBag.toArray()));
    }

    /**
     * Tests to see if isEmpty() is functioning properly
     */
    @Test
    public void testIsEmpty(){
        aBag.clear();
        assertEquals(true, aBag.isEmpty());
        assertEquals(false, bBag.isEmpty());
    }

    /**
     * Tests to see if getFrequencyOf() is working properly
     */
    @Test
    public void testFrequency(){
        assertEquals(3, aBag.getFrequencyOf('b'));
        assertEquals(0, bBag.getFrequencyOf('j'));
    }

    /**
     * Tests to see if contains() is working properly
     */
    @Test
    public void testContains(){
        assertEquals(true, aBag.contains('b'));
        assertEquals(false, bBag.contains('k'));
    }

    /**
     * Tests to see if remove() is working properly
     */
    @Test
    public void testRemove(){
        bBag.remove('a');
        //Assertion, bBag is initialized and that testContains() is successful.
        assertEquals(false, bBag.contains('a'));
        aBag.remove('b');
        assertEquals(true, aBag.contains('b'));
    }

    @Test
    public void testUnion(){
        assertEquals(true, checkIfSame(aBag.union(bBag), new Object[]{'a', 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'c', 'd', 'e', 'e', 'e'}));
        assertEquals(true, checkIfSame(bBag.union(aBag), new Object[]{'a', 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'c', 'd', 'e', 'e', 'e'}));
    }

    @Test
    public void testIntersection(){
        assertEquals(true, checkIfSame(aBag.intersection(bBag), new Object[]{'a', 'b', 'b', 'e'}));
        assertEquals(true, checkIfSame(bBag.intersection(aBag), new Object[]{'a', 'b', 'b', 'e'}));
    }

    @Test
    public void testDifference(){
        assertEquals(true, checkIfSame(aBag.difference(bBag), new Object[]{'a', 'b', 'c', 'd'}));
        assertEquals(true, checkIfSame(bBag.difference(aBag), new Object[]{'e'}));
    }


    @Ignore
    private boolean checkIfSame(BagInterface aBag, Object[] anArray){
        boolean isSame = true;
        Object[] bagArray = aBag.toArray();
        for (int i = 0; i < bagArray.length; i++){
            for (int j = 0; j < anArray.length; j++){
                if (bagArray[i] != null && anArray[j] != null && bagArray[i].equals(anArray[j])){
                    bagArray[i] = null;
                    anArray[j] = null;
                }
            }
        }
        for (int i = 0; i < bagArray.length; i++){
            if(bagArray[i] != null){
                isSame = false;
            }
        }
        for (int j = 0; j < anArray.length; j++){
            if(anArray[j] != null){
                isSame = false;
            }
        }
        //At the end of the loops, both arrays should be null on all values.
        return isSame;
    }
}