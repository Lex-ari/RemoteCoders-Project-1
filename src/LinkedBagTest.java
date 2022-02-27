//aimport javax.swing.text.DefaultStyledDocument.ElementSpec; I don't know who put this here or what it does - Alex
import org.junit.Assert;
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
        System.out.println("\nTesting initialization");
        assertEquals(Arrays.toString(new Object[]{'a', 'a', 'b', 'b', 'b', 'c', 'd', 'e'}), Arrays.toString(aBag.toArray()));
        assertEquals(Arrays.toString(new Object[]{'a', 'b', 'b', 'e', 'e'}),  Arrays.toString(bBag.toArray()));
        System.out.println("Initialization Successful");
    }

    /**
     * Tests to see if clear() is functioning properly
     */
    @Test
    public void testClear(){
        System.out.println("\nTesting clear");
        aBag.clear();
        assertEquals("[]", Arrays.toString(aBag.toArray()));
        System.out.println("Clear successful");
    }

    /**
     * Tests to see if isEmpty() is functioning properly
     */
    @Test
    public void testIsEmpty(){
        System.out.println("\nTesting isEmpty");
        aBag.clear();
        assertEquals(true, aBag.isEmpty());
        assertEquals(false, bBag.isEmpty());
        System.out.println("isEmpty successful");
    }

    /**
     * Tests to see if getFrequencyOf() is working properly
     */
    @Test
    public void testFrequency(){
        System.out.println("\nTesting frequency");
        assertEquals(3, aBag.getFrequencyOf('b'));
        assertEquals(0, bBag.getFrequencyOf('j'));
        System.out.println("frequency successful");
    }

    /**
     * Tests to see if contains() is working properly
     */
    @Test
    public void testContains(){
        System.out.println("\nTesting contains");
        assertEquals(true, aBag.contains('b'));
        assertEquals(false, bBag.contains('k'));
        System.out.println("contains successful");
    }

    /**
     * Tests to see if remove() is working properly
     */
    @Test
    public void testRemove(){
        System.out.println("\nTesting remove");
        bBag.remove('a');
        //Assertion, bBag is initialized and that testContains() is successful.
        assertEquals(false, bBag.contains('a'));
        aBag.remove('b');
        assertEquals(true, aBag.contains('b'));
        System.out.println("remove successful");
    }

    /**
     * Test to see if union() is working properly
     */
    @Test
    public void testUnion(){
        System.out.println("\nTesting union");
        BagInterface atoBResult = aBag.union(bBag);
        BagInterface btoAResult = bBag.union(aBag);
        Object[] expectedContents = new Object[]{'a', 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'c', 'd', 'e', 'e', 'e'};
        if (!checkIfSame(atoBResult, expectedContents)){
            Assert.fail("expected:<" + Arrays.toString(expectedContents) + "> but was:<" + Arrays.toString(atoBResult.toArray()) + "> (unsorted)");
        }
        if (!checkIfSame(btoAResult, expectedContents)){
            Assert.fail("expected:<" + Arrays.toString(expectedContents) + "> but was:<" + Arrays.toString(btoAResult.toArray()) + "> (unsorted)");
        }
        System.out.println("union successful");
    }

    /**
     * Test to see if intersection() is working properly
     */
    @Test
    public void testIntersection(){
        System.out.println("\nTesting intersection");
        BagInterface atoBResult = aBag.intersection(bBag);
        BagInterface btoAResult = bBag.intersection(aBag);
        Object[] expectedContents = new Object[]{'a', 'b', 'b', 'e'};
        if (!checkIfSame(atoBResult, expectedContents)){
            Assert.fail("expected:<" + Arrays.toString(expectedContents) + "> but was:<" + Arrays.toString(atoBResult.toArray()) + "> (unsorted)");
        }
        if (!checkIfSame(btoAResult, expectedContents)){
            Assert.fail("expected:<" + Arrays.toString(expectedContents) + "> but was:<" + Arrays.toString(btoAResult.toArray()) + "> (unsorted)");
        }
        System.out.println("intersection successful");
    }

    /**
     * Test to see if difference() is working properly
     */
    @Test
    public void testDifference(){
        System.out.println("\nTesting difference");
        BagInterface atoBResult = aBag.difference(bBag);
        BagInterface btoAResult = bBag.difference(aBag);
        Object[] expectedContentsAtoB = new Object[]{'a', 'b', 'c', 'd'};
        Object[] expectedContentsBtoA = new Object[]{'e'};
        if (!checkIfSame(atoBResult, expectedContentsAtoB)){
            Assert.fail("expected:<" + Arrays.toString(expectedContentsAtoB) + "> but was:<" + Arrays.toString(atoBResult.toArray()) + "> (unsorted)");
        }
        if (!checkIfSame(btoAResult, expectedContentsBtoA)){
            Assert.fail("expected:<" + Arrays.toString(expectedContentsBtoA) + "> but was:<" + Arrays.toString(btoAResult.toArray()) + "> (unsorted)");
        }
        System.out.println("difference successful");
    }

    /**
     * A method to check if a given BagInterface has the same contents as an Array, with no attention to order.
     * @param aBag bag with contents.
     * @param anArray an array with contents
     * @return true if bag and array are the same contents, false otherwise.
     */
    @Ignore
    private boolean checkIfSame(BagInterface aBag, Object[] anArray){
        boolean isSame = true;
        Object[] bagArray = aBag.toArray();
        Object[] copiedAnArray = Arrays.copyOf(anArray,anArray.length);
        for (int i = 0; i < bagArray.length; i++){
            for (int j = 0; j < copiedAnArray.length; j++){
                if (bagArray[i] != null && anArray[j] != null && bagArray[i].equals(copiedAnArray[j])){
                    bagArray[i] = null;
                    copiedAnArray[j] = null;
                }
            }
        }
        for (int i = 0; i < bagArray.length; i++){
            if(bagArray[i] != null){
                isSame = false;
            }
        }
        for (int j = 0; j < anArray.length; j++){
            if(copiedAnArray[j] != null){
                isSame = false;
            }
        }
        //At the end of the loops, both arrays should be null on all values.
        return isSame;
    }
}