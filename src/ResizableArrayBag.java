
/**
Remote Coders
Koki Yamaguchi, Iker Goni, Alex Mariano
Professor Qichao Dong
CS2400
*/

public class ResizableArrayBag<T> implements BagInterface<T>{

    private final T[] bag;
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
        } else {
            throw new IllegalStateException("Attempted to create bag whose capacity exceeds allowed maximum");
        }
    }

    private void checkIntegrity(){
        if (!integrityOK){
            throw new SecurityException("ArrayBag object is corrupt.");
        }
    }

    private boolean isFull(){
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
        boolean result = true;
        if (isFull()) {
            result = false;
        } else {
            //Assertion: result is true
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result; //returns true if successful
    }

    @Override
    public T remove() {
        return null; // STUB
    }

    @Override
    public boolean remove(T anEntry) {
        return false; // STUB
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

    @Override
    public BagInterface<T> union(T aBag) {
        return null; // STUB
    }

    @Override
    public BagInterface<T> intersection(T aBag) {
        return null; // STUB
    }

    @Override
    public BagInterface<T> difference(T aBag) {
        return null; // STUB
    }
}
