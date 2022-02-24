
/**
Remote Coders
Koki Yamaguchi, Iker Goni, Alex Mariano
Professor Qichao Dong
CS2400
*/

public class LinkedBag<T> implements BagInterface<T>{

    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    }

    public LinkedBag(BagInterface<T> bagToCopy){
        for(T thing : bagToCopy.toArray()){
            this.add(thing);
        }
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
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;

        firstNode = newNode;
        numberOfEntries++;

        return true;
    }

    @Override
    public T remove() {
        T result = null;
        if(firstNode != null){
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if(nodeN != null){
            nodeN.setData(firstNode.getData());

            numberOfEntries--;

            result = true;
        }

        return result;
    }

    @Override
    public void clear() {
        while(!isEmpty()){
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int counter = 0;
        Node currentNode = firstNode;

        while((counter < numberOfEntries) && (currentNode != null)){
            if(anEntry.equals(currentNode.getData())){
                frequency++;
            }
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.getData())){
                found = true;
            }
            else{
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while((index < numberOfEntries) && (currentNode != null)){
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }
    public Node getReferenceTo(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.getData())){
                found = true;
            }
            else{
                currentNode = currentNode.getNextNode();
            }
        }
        return currentNode;
    }
    private class Node{
        private T data;
        private Node next;

        private Node(T dataPortion){
            this(dataPortion, null);
        }
        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }
        private T getData(){
            return data;
        }
        private void setData(T newData){
            data = newData;
        }
        private Node getNextNode(){
            return next;
        }
        private void setNextNode(Node nextNode){
            next = nextNode;
        }
    }

    @Override
    public BagInterface<T> union(BagInterface<T> aBag) {
        @SuppressWarnings("unchecked")
        LinkedBag<T> everything = new LinkedBag(this);
        T[] unionBag = aBag.toArray();
        for (T item : unionBag) {
            everything.add(item);
        }
        return everything;
    }



    @Override
    public BagInterface<T> intersection(BagInterface<T> aBag) {
        T[] array1 = this.toArray();
        T[] array2 = aBag.toArray(); 
        @SuppressWarnings("unchecked")
        LinkedBag<T> intersectionBag = new LinkedBag();
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++){
                if(array1[i].equals(array2[j])){
                    intersectionBag.add(array1[i]);
                    array1[i] = null;
                }
            }
        }
        return intersectionBag;
    }

    /**
     * Creates a copy of the bag the method is called upon, and loops through all elements if the parameter bag and calls remove(anEntry) on each element.
     */
    @Override
    public BagInterface<T> difference(BagInterface<T> aBag) {
        @SuppressWarnings("unchecked")
        LinkedBag<T> leftOverBag = new LinkedBag(this);
        T[] differenceBag = aBag.toArray();
        for (T item : differenceBag) {
            leftOverBag.remove(item);
        }
        return leftOverBag;
    }
}
