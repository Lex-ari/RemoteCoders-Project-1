import java.util.Arrays;
public class BagDriver{
    public static void main(String[] args)throws NullPointerException{
        TestSuite.testResizableArrayBag();
        TestSuite.testLinkedBag();

        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();

        bag1.add("a", "a", "b", "b", "b", "c", "d", "e");
        bag2.add("a", "b", "b", "e", "e");





        System.out.println("Union in two bags:  " + Arrays.toString(bag1.union(bag2).toArray()));
        System.out.println("Intercection in two bags: " + Arrays.toString(bag1.intersection(bag2).toArray()));
        System.out.println("Difference in two bag: " + Arrays.toString(bag1.difference(bag2).toArray()));









                int cap = 25;
                int choice1;
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter 1 for ResizableArrayBag or 2 for LinkedBag: ");
                choice1 = keyboard.nextInt();

                if(choice1 == 1){
                    int choice2;
                    BagInterface<String> bag1 = new ResizableArrayBag<>();
                    BagInterface<String> bag2 = new ResizableArrayBag<>();
                    System.out.println("Enter the entries for the first bag.");
                    for (int i = 0; i < cap; i++) {
                        System.out.println("Would you like to add an entry? Enter 1 for Yes or 2 to move to the second bag: ");
                        choice2 = keyboard.nextInt();
                        if (choice2 == 1) {
                            System.out.println("Enter a Letter: ");
                            bag1.add(keyboard.next(), "a", "b", "b", "b", "c", "d", "e");
                        } else if (choice2 == 2) {
                            break;
                        }
                    }
                    System.out.println("Enter the entries for the second bag.");
                    for (int j = 0; j < cap; j++) {
                        System.out.println("Would you like to add an entry? Enter 1 for Yes or 2 to print result: ");
                        choice2 = keyboard.nextInt();
                        if (choice2 == 1) {
                            System.out.println("Enter a Letter: ");
                            bag2.add(keyboard.next(), "a", "b", "b", "b", "c", "d", "e");
                        } else if (choice2 == 2) {
                            break;
                        }
                    }
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));
                }
                else if(choice1 == 2){
                    BagInterface<String> bag3 = new LinkedBag<>();
                    BagInterface<String> bag4 = new LinkedBag<>();
                    int choice2;
                    System.out.println("Enter the entries for the first bag.");
                    for (int i = 0; i < cap; i++) {
                        System.out.println("Would you like to add an entry? Enter 1 for Yes or 2 to move to the second bag: ");
                        choice2 = keyboard.nextInt();
                        if (choice2 == 1) {
                            System.out.println("Enter a Letter: ");
                            bag3.add(keyboard.next(), "a", "b", "b", "b", "c", "d", "e");
                        } else if (choice2 == 2) {
                            break;
                        }
                    }
                    System.out.println("Enter the entries for the second bag.");
                    for (int i2 = 0; i2 < cap; i2++) {
                        System.out.println("Would you like to add an entry? Enter 1 for Yes or 2 to print result: ");
                        choice2 = keyboard.nextInt();
                        if (choice2 == 1) {
                            System.out.println("Enter a Letter: ");
                            bag4.add(keyboard.next(), "a", "b", "b", "b", "c", "d", "e");
                        } else if (choice2 == 2) {
                            break;
                        }
                    }
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));

                }
            }
        }

        BagInterface<String> aBag = new ResizableArrayBag<>();

        /*
        String[] bag1 = {"a", "a", "b", "b", "b", "c", "d", "e"};
        String[] bag2 = {"a", "b", "b", "e", "e"};

        BagInterface<String> everything = bag1.demoUnion(bag2);



    }
    public String demoUnion(String aBag){




        return aBag;

         */
    }


}
