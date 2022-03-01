import java.util.Arrays;

/**
Remote Coders
Koki Yamaguchi, Iker Goni, Alex Mariano
Professor Qichao Dong
CS2400
*/

public class ResizableArrayBag<T> implements BagInterface<T>{

    private T[] bag; // Not final since array changes upon resize.
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    private int numberOfEntries;
    private boolean integrityOK = false; // Defaulted to false until successful initialization.

    /**
     * Default constructor.
     * Creates a ResizableArrayBag with DEFAULT_CAPACITY
     */
    public ResizableArrayBag(){ //default constructor
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[DEFAULT_CAPACITY]; // assuming DEFAULT_CAPACITY is <= MAX_CAPACITY.
        bag = tempBag;
        numberOfEntries = 0;
        integrityOK = true;
    }

    /**
     * Default constructor where the capacity can be set.
     * @param desiredCapacity capacity (length) of the bag. Cannot exceed MAX_CAPACITY or otherwise throws exception.
     */
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
     * Copy constructor
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

    /**
     * Simple check if the integrity of the bag is OK. Ensures that the bag is properly initialized with proper space.
     */
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

    /**
     * Checks to see if given capacity does not exceed set MAX_CAPACITY. Throws an exception if it exceeds.
     * @param capacity Capacity to check if less than MAX_CAPACITY. If greater, throws an exception.
     */
    private void checkCapacity(int capacity){ // Very simple check to not go over max capacity
        if (capacity > MAX_CAPACITY){
            throw new IllegalStateException("Attempted to create a bag whose capcaity exceeds allowed maximum of " + MAX_CAPACITY);
        }
    }

    /**
     * Doubles the capacity of the bag. This creates a new array with double the length, and moves over contents.
     */
    private void doubleCapacity(){
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    @Override
    public T remove() {
        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

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

    /**
     * Searches through the contents of the bag and returns the index of anEntry.
     * @param anEntry Entry to search for.
     * @return index of the Entry in the bag. Returns -1 if not found.
     */
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
        return everything;
    }

    /**
        Two bags involved, this bag and parameter aBag
        Instantiate resizableArrayBag intersectionBag with size this.getCurrentSize()
        Convert both bags into arrays using toArray() in order to traverse them
        Use nested for loop to go through each element of the parameter bag for each element in this bag
        If the elements are not null and equal to each other, add the element to intersectionBag and set the arrayValues to null
        return the intersectionBag
         @param aBag An Existing Bag
         @return New bag that contains what this and aBag have.
    */
    @Override
    public BagInterface<T> intersection(BagInterface<T> aBag) {
        T[] array1 = this.toArray();
        T[] array2 = aBag.toArray(); 
        @SuppressWarnings("unchecked")
        ResizableArrayBag<T> intersectionBag = new ResizableArrayBag(this.getCurrentSize());
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++){
                if(array1[i] != null && array2[j] != null && array1[i].equals(array2[j])){
                    intersectionBag.add(array1[i]);
                    array1[i] = null;
                    array2[j] = null;
                }
            }
        }
        return intersectionBag;
    }


    /**
     * The difference of two collections is a new collection of the entries that would be left in one collection after removing those that also occur in the second.
     * Copies the bag the method is called upon, and calls remove(anEntry) on each element of the BagInterface Parameter.
     *
     * @param aBag An Existing Bag
     * @return New bag the difference of the bag receiving the call to the method and the bag that is the method’s one argument.
     */
    @Override
    public BagInterface<T> difference(BagInterface<T> aBag) {
        checkIntegrity();
        @SuppressWarnings("unchecked")
        ResizableArrayBag<T> leftOverBag = new ResizableArrayBag(this);
        T[] differenceBag = aBag.toArray();
        for (T item : differenceBag) {
            leftOverBag.remove(item);
        }
        leftOverBag.checkIntegrity();
        return leftOverBag;
    }

}
