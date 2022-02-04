
/**
Remote Coders
Koki Yamaguchi, Iker Goni, Alex Mariano
Professor Qichao Dong
CS2400
*/

public class LinkedBag<T> implements BagInterface<T>{


    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(T newEntry) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public T union(T aBag) {
        return null;
    }

    @Override
    public T intersection(T aBag) {
        return null;
    }

    @Override
    public T difference(T aBag) {
        return null;
    }
}
