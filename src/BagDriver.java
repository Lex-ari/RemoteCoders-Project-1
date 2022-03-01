import java.util.Arrays;
public class BagDriver{


    public static void main(String[] args){

        TestRunner.testResizableArrayBag();
        TestRunner.testLinkedBag();

        BagInterface<String> aBag = new ResizableArrayBag<>();

        char[] Bag1 = {'a', 'a', 'b', 'b', 'b', 'c', 'd', 'e'};
        add(aBag, Bag1);

        char[] Bag2 = {'a', 'b', 'b', 'e', 'e'};
        add(aBag, Bag2);


        System.out.println("Union in two bag: " + Arrays.toString(Bag1.union(Bag2).toArray()));

        System.out.println("Intersection in two bag: " + Arrays.toString(Bag1.intersection(Bag2).toArray()));

        System.out.println("Difference in two bags: " + Arrays.toString(Bag1.difference(Bag2).toArray()));
    }
    private static void add(BagInterface<String> aBag, char[] content){
        for(int i = 0; i < content.length; i++){
            aBag.add(String.valueOf(content[i]));
            System.out.println(content[i] + " ");
    }
        System.out.println();
    }


}
