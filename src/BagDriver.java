import java.awt.*;
import java.util.Arrays;
public class BagDriver{

    public static void main(String[] args){

        TestRunner.testResizableArrayBag();
        TestRunner.testLinkedBag();

        BagInterface<String> Bag1 = new ResizableArrayBag<>();
        BagInterface<String> Bag2 = new ResizableArrayBag<>();

        char[] contentsOfBag1 = {'a', 'a', 'b', 'b', 'b', 'c', 'd', 'e'};
        addDemo(Bag1, contentsOfBag1);

        char[] contentsOfBag2 = {'a', 'b', 'b', 'e', 'e'};
        addDemo(Bag2, contentsOfBag2);


        System.out.println(Bag.unionDemo());

        System.out.println(aBag.intersectionDemo());

        System.out.println(aBag.differenceDemo());
    }
    private static void addDemo(BagInterface<String> aBag, char[] content){
        for(int i = 0; i < content.length; i++){
            aBag.add(String.valueOf(content[i]));
            System.out.println(content[i] + " ");
    }
        System.out.println();
    }
    private static void unionDemo(BagInterface<String> aBag){

        BagInterface<String> everything = bag1.union(bag2);
        System.out.println("Union in two bag: " + everything);
    }
    private static void intersectionDemo(){
        System.out.println("Intersection in two bag: " + Arrays.toString(aBag.intersection().toArray()));
    }
    private static void differenceDemo(){
        System.out.println("Difference in two bags: " + Arrays.toString(Bag1.difference(Bag2).toArray()));
    }
}
