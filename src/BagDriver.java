import java.util.Arrays;

public class BagDriver{
    static BagInterface bag1 = new LinkedBag();
    static BagInterface bag2 = new ResizableArrayBag();
    public static void main(String[] args){
        reset();
        System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
        reset();
        System.out.println(Arrays.toString(bag2.union(bag1).toArray()));
        reset();
        System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
        reset();
        System.out.println(Arrays.toString(bag2.intersection(bag1).toArray()));
        reset();
        System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
        reset();
        System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));
    }

    public static void addArrayContents(BagInterface bagEntry, Object[] arrayEntry){
        for (Object element : arrayEntry){
            bagEntry.add(element);
        }
    }

    public static void reset(){
        bag1.clear();
        addArrayContents(bag1, new Object[]{'a', 'a', 'b', 'b', 'b', 'c', 'd', 'e'});
        bag2.clear();
        addArrayContents(bag2, new Object[]{'a', 'b', 'b', 'e', 'e'});
    }
}
