import java.util.Arrays;

/**
Remote Coders
Koki Yamaguchi, Iker Goni, Alex Mariano
Professor Qichao Dong
CS2400
*/

public class ResizableArrayBag<T> implements BagInterface<T>{

    private  T[] bag; //@TODO: Not sure if this should be final or not. If final, doubleCapacity() breaks. - Alex
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    private int numberOfEntries;
    private boolean integrityOK = false; // Defaulted to false until successful initialization.

    public ResizableArrayBag(){
        //default constructor
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[DEFAULT_CAPACITY]; // assuming DEFAULT_CAPACITY is <= MAX_CAPACITY.
        bag = tempBag;
        numberOfEntries = 0;
        integrityOK = true;
    }

    public ResizableArrayBag(int desiredCapacity){
        if (desiredCapacity <= MAX_CAPACITY){
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true;
        } else {
            throw new IllegalStateException("Attempted to create bag whose capacity exceeds allowed maximum");
        }
    }

    /**
     * This is a copy constructor - Alex
     * @param bagToCopy, contents from bagToCpy will be "copied" over to the new ResizableArrayBag.
     */
    public ResizableArrayBag(BagInterface<T> bagToCopy){
        //Assertion: bagToCopy is less than MAX_CAPACITY.

        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[bagToCopy.getCurrentSize()];
        T[] bagToCopyContents = bagToCopy.toArray();
        for (int index = 0; index < bagToCopy.getCurrentSize(); index++){
            //Assertion: bagToCopyContents and tempBag is the same length.
            tempBag[index] = bagToCopyContents[index];
        }
        numberOfEntries = bagToCopy.getCurrentSize();
        bag = tempBag;
        integrityOK = true;
    }

    private void checkIntegrity(){
        if (!integrityOK){
            throw new SecurityException("ArrayBag object is corrupt.");
        }
    }

    public boolean isFull(){
        return numberOfEntries == bag.length;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        checkIntegrity();
        if (isFull()) {
            doubleCapacity();
        }

        bag[numberOfEntries] = newEntry;
        numberOfEntries++;

        return true; //returns very successful. Inner methods would throw exception if not.
    }

    private void checkCapacity(int capacity){ // Very simple check to not go over max capacity
        if (capacity > MAX_CAPACITY){
            throw new IllegalStateException("Attempted to create a bag whose capcaity exceeds allowed maximum of " + MAX_CAPACITY);
        }
    }

    private void doubleCapacity(){
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    /**
     *
     * @return Removed entry, or null if unsuccessful.
     */
    @Override
    public T remove() {
        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }


    /**
     * @param anEntry  The entry to be removed.
     * @return True if removal was successful, false if not
     */
    @Override
    public boolean remove(T anEntry) {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }


    /**
     Removes and returns the entry at given index within array bag.
     No Entry exists = returns null]
     Preconditions: 0 <= givenIndex < numberOfEntries; checkIntegrity has been called.
     */
    private T removeEntry(int givenIndex){
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)){
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1]; // Replace entry with last entry. Saves some time rather than shifting the rest.
            bag[numberOfEntries - 1] = null; // Removes last entry
            numberOfEntries--;
        }

        return result;
    }


    @Override
    public void clear() {
        while (!isEmpty()){
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        checkIntegrity();
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++){
            if (anEntry.equals(bag[index])){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean contains(T anEntry) {
        checkIntegrity();
        return getIndexOf(anEntry) > -1;
    }

    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < numberOfEntries)){
            if (anEntry.equals(bag[index])){
                found = true;
                where = index;
            }
            index++;
        }
        //Assertion: When where > -1, anEntry exists in arrayBag. Otherwise, where = -1 and not in Array.
        return where;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++){
            result[index] = bag[index];
        }
        return result;
    }
    /*
    *    @return A new bag of the union of the bag
     */


    @Override
    public BagInterface<T> union(BagInterface<T> aBag) {
        checkIntegrity();
        @SuppressWarnings("unchecked")
        ResizableArrayBag<T> everything = new ResizableArrayBag(this);
        T[] unionBag = aBag.toArray();
        for (T item : unionBag) {
            everything.add(item);
        }
        everything.checkIntegrity();



        // STUB
        return everything;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> aBag) {
        checkIntegrity(); // Idk if this is needed - Iker
        @SuppressWarnings("unchecked")
        ResizableArrayBag<T> intersectionBag = new ResizableArrayBag(DEFAULT_CAPACITY);
        for (T item : aBag.toArray()) {
            if(this.contains(item)){
                intersectionBag.add(item);
            }
        }
        intersectionBag.checkIntegrity(); // Idk if this is needed - Iker
        return intersectionBag;
    }


    /**
     *
     * @param aBag  An Existing Bag
     * @return A new bag of the difference of the bag receiving the call to the method and the bag that is the method's argument.
     */

    @Override
    public BagInterface<T> difference(BagInterface<T> aBag) {
        checkIntegrity(); // Idk if this is needed - Alex
        @SuppressWarnings("unchecked")
        ResizableArrayBag<T> leftOverBag = new ResizableArrayBag(this);
        T[] differenceBag = aBag.toArray();
        for (T item : differenceBag) {
            leftOverBag.remove(item);
        }
        leftOverBag.checkIntegrity(); // Idk if this is needed - Alex
        return leftOverBag;

    }

}
