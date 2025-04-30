// public class App {
//     public static void main(String[] args) throws Exception {
//         // TODO: Implement an extensive testing main!!!
//         // Note: the print function tests both next and previous links
//         // comment part of the code you will not be testing
//         System.out.println("Testing countlist fucntions.................................");
//         CountList<Integer> countList = new CountList<>();
//         for (int i = 0; i < 10; i++) {
//             countList.insert(i);
//         }
//         System.out.println("Testing insert function with both next and prev links.......:");
//         print(countList);

//         System.out.println("Testing the remove function in all cases......................:");
//         countList.remove(0);
//         print(countList);
//         countList.remove(9);
//         print(countList);
//         countList.remove(5);
//         print(countList);
//         // countList.remove(0);
//         // countList.remove(9);
//         // countList.remove(5);
//         // print(countList);
//         System.out.println("Testing the access method of countlist...........................");
//         countList.access(4);
//         System.out.print("Accesing 4: ");
//         print(countList);
//         countList.access(8);
//         System.out.print("Accesing 8: ");
//         print(countList);
//         countList.access(4);
//         System.out.print("Accesing 4: ");
//         print(countList);
//         countList.access(1);
//         System.out.print("Accesing 1: ");
//         print(countList);
//         countList.access(1);
//         System.out.print("Accesing 1: ");
//         print(countList);
//         countList.access(5);
//         System.out.print("Accesing 5: ");
//         print(countList);
//         System.out.print("Accessing 11: ");
//         countList.access(11);
//         print(countList);
//         System.out.print("Accessing 11: ");
//         countList.access(11);
//         print(countList);
//         System.out.print("Accessing 12: ");
//         countList.access(12);
//         print(countList);

//         System.out.println("Testing Move to front functions.................................");
//         MoveToFrontList<Integer> list = new MoveToFrontList<>();
//         for (int i = 1; i < 11; i++) {
//             list.insert(i);
//         }
//         System.out.println("Testing access..................................................");
//         System.out.print("Before: ");
//         print(list);
//         System.out.println("Acessing 5: ");
//         list.access(5);
//         print(list);
//         System.out.println("Acessing 5: ");
//         list.access(5);
//         print(list);
//         System.out.println("Acessing 10: ");
//         list.access(10);
//         print(list);
//         System.out.println("Acessing 6: ");
//         list.access(6);
//         print(list);
//         System.out.println("Accessing 11");
//         list.access(11);
//         print(list);
//         System.out.print("Access 25: ");
//         list.access(25);
//         print(list);

//         System.out.print("Accessing 25");
//         list.access(25);
//         print(list);

//         for (int i = 1; i < 12; i++) {
//             list.remove(i);
//         }
//         System.out.println("Accessing 10: ");
//         list.access(10);
//         print(list);

//         System.out.println("Testing natural order functions..........................");
//         NaturalOrderList<Integer> orderList = new NaturalOrderList<>();

//         for (int i = 0; i < 10; i++) {
//             orderList.insert(i);
//         }
//         print(orderList);

//         System.out.print("Removing 0: ");
//         orderList.remove(0);
//         print(orderList);

//         System.out.print("Removing 9: ");
//         orderList.remove(9);
//         print(orderList);

//         System.out.print("Removing 3: ");
//         orderList.remove(3);
//         print(orderList);

//         System.out.print("Inserting 6: ");
//         orderList.insert(6);
//         print(orderList);

//         System.out.print("Inserting 0: ");
//         orderList.insert(0);
//         print(orderList);

//         System.out.print("Inserting 20: ");
//         orderList.insert(20);
//         print(orderList);

//         System.out.println("Testing transpose function......................................");
//         TransposeList<Integer> transposeList = new TransposeList<>();
//         for (int i = 0; i < 10; i++) {
//             transposeList.insert(i);
//         }
//         System.out.print("Before trasposing stuff: ");
//         print(transposeList);
//         System.out.println("Transposing 2:");
//         transposeList.access(2);
//         print(transposeList);
//         System.out.println("Transposing 2:");
//         transposeList.access(2);
//         print(transposeList);
//         System.out.println("Transposing 9:");
//         transposeList.access(9);
//         print(transposeList);
//         System.out.println("Transposing 5:");
//         transposeList.access(5);
//         print(transposeList);
//         System.out.println("Transposing 11");
//         transposeList.access(11);
//         print(transposeList);
//         System.out.print("Transpose 11: ");
//         transposeList.access(11);
//         print(transposeList);

//         System.out.println("Testing Iterative traverse functions...........................");
//         IterativeTraverse<Integer> iterative = new IterativeTraverse<>();
//         CountList<Integer> iterativList = new CountList<>();
//         for (int i = 0; i < 11; i++) {
//             iterativList.insert(i);
//         }
//         iterative.setList(iterativList);
//         System.out.println("Testing toString ...............................................");
//         System.out.println(iterative);
//         System.out.println();
//         System.out.println("Testing contains .............................................. ");
//         // if (iterative.contains(20))
//         // System.out.println("list contains 0 ? yes");
//         // if (iterative.contains(17) == false)
//         // System.out.println("list contains 17 ? no");

//         System.out.println();
//         System.out.println("Testing size ...................................................");
//         System.out.println("Size of list is: " + iterative.size());
//         System.out.println();
//         System.out.println("Testing find .................................................... ");
//         Node<Integer> node = iterative.find(2);
//         System.out.println("find 2 in iterative -> " + node.toString());
//         System.out.println();

//         Node<Integer> noderss = iterative.find(0);
//         System.out.println("find 30 in iterative -> " + noderss.toString());

//         System.out.println("Testing get .............................................. ");
//         node = iterative.get(3);
//         System.out.println("Get node in position 3 ->" + node.toString());
//         node = iterative.get(1);
//         System.out.println("Get node in position 0 ->" + node.toString());
//         node = iterative.get(9);
//         System.out.println("Get node in position 9 ->" + node.toString());
//         node = iterative.get(5);
//         System.out.println("Get node in position 5 ->" + node.toString());

//         System.out.println();
//         System.out.println("Testing reverse list .............................................. ");
//         SelfOrderingList<Integer> reverse = new CountList<>();

//         for (int i = 0; i < 7; i++) {
//             reverse.insert(i);
//         }
//         System.out.println("Printing before reverse ");
//         print(reverse);

//         reverse = iterative.reverseList();
//         System.out.println("List reversed:");
//         print(reverse);
//         System.out.println();
//         System.out.println("Testing clone .............................................. ");
//         reverse = iterative.clone(reverse);
//         System.out.println("List cloned:");
//         print(reverse);
//         System.out.println();
//         System.out.println("Testing ToString .............................................. ");
//         System.out.println(iterative);

//         System.out.println("Testing Recursive traverse functions...........................");
//         RecursiveTraverse<Integer> recursive = new RecursiveTraverse<>();
//         CountList<Integer> recursiveList = new CountList<>();
//         for (int i = 0; i < 11; i++) {
//             recursiveList.insert(i);
//         }
//         recursive.setList(recursiveList);
//         System.out.println("Testing toString ...............................................");
//         System.out.println(recursive);
//         System.out.println();
//         System.out.println("Testing contains .............................................. ");
//         if (recursive.contains(0))
//             System.out.println("list contains 0 ? yes");
//         if (recursive.contains(6))
//             System.out.println("yess");

//         if (recursive.contains(30))
//             System.out.println("nooo");

//         System.out.println();
//         System.out.println("Testing size ...................................................");
//         System.out.println("Size of list is: " + recursive.size());
//         System.out.println();
//         System.out.println("Testing find .................................................... ");
//         Node<Integer> noder = recursive.find(2);

//         System.out.println("find 2 in recursive -> " + noder.toString());
//         Node<Integer> noderr = recursive.find(7);
//         System.out.println("find 7 in recursive -> " + noderr.toString());

//         System.out.println();
//         System.out.println("Testing get .............................................. ");
//         noder = recursive.get(3);
//         System.out.println("Get node in position 3 ->" + noder.toString());
//         noder = recursive.get(1);
//         System.out.println("Get node in position 1 ->" + noder.toString());
//         noder = recursive.get(10);
//         System.out.println("Get node in position 10 ->" + noder.toString());

//         System.out.println();
//         System.out.println("Testing reverse list .............................................. ");
//         SelfOrderingList<Integer> reverser = new CountList<>();
//         System.out.println("Reverse before: ");
//         print(reverser);
//         reverser = recursive.reverseList();
//         System.out.println("List reversed:");
//         print(reverser);
//         System.out.println();
//         System.out.println("Testing clone .............................................. ");
//         reverser = recursive.clone(reverser);
//         System.out.println("List cloned:");
//         print(reverser);
//         System.out.println();
//         System.out.println("Testing ToString .............................................. ");
//         System.out.println(recursive);
//     }

//     public static void print(SelfOrderingList<Integer> list) {
//         Node<Integer> node = list.head;
//         while (node != null) {
//             System.out.print(node.toString());
//             node = node.next;
//         }
//         System.out.println();

//         // node = list.tail;
//         while (node != null) {
//             System.out.print(node.toString());
//             node = node.prev;
//         }
//         System.out.println();
//     }

// }
// // Expected output:
// /*
//  * Testing countlist fucntions.................................
//  * Testing insert function with both next and prev links.......:
//  * (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])
//  * (9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
//  * Testing the remove function in all cases......................:
//  * (1[0])(2[0])(3[0])(4[0])(6[0])(7[0])(8[0])
//  * (8[0])(7[0])(6[0])(4[0])(3[0])(2[0])(1[0])
//  * Testing the access method of countlist...........................
//  * Accesing 4: (4[1])(1[0])(2[0])(3[0])(6[0])(7[0])(8[0])
//  * (8[0])(7[0])(6[0])(3[0])(2[0])(1[0])(4[1])
//  * Accesing 8: (4[1])(8[1])(1[0])(2[0])(3[0])(6[0])(7[0])
//  * (7[0])(6[0])(3[0])(2[0])(1[0])(8[1])(4[1])
//  * Accesing 4: (4[2])(8[1])(1[0])(2[0])(3[0])(6[0])(7[0])
//  * (7[0])(6[0])(3[0])(2[0])(1[0])(8[1])(4[2])
//  * Accesing 1: (4[2])(8[1])(1[1])(2[0])(3[0])(6[0])(7[0])
//  * (7[0])(6[0])(3[0])(2[0])(1[1])(8[1])(4[2])
//  * Accesing 1: (4[2])(1[2])(8[1])(2[0])(3[0])(6[0])(7[0])
//  * (7[0])(6[0])(3[0])(2[0])(8[1])(1[2])(4[2])
//  * Accesing 5: (4[2])(1[2])(8[1])(2[0])(3[0])(6[0])(7[0])
//  * (7[0])(6[0])(3[0])(2[0])(8[1])(1[2])(4[2])
//  * Testing Move to front functions.................................
//  * Testing access..................................................
//  * Before: (1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])
//  * (10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])
//  * Acessing 5:
//  * (5[0])(1[0])(2[0])(3[0])(4[0])(6[0])(7[0])(8[0])(9[0])(10[0])
//  * (10[0])(9[0])(8[0])(7[0])(6[0])(4[0])(3[0])(2[0])(1[0])(5[0])
//  * Acessing 5:
//  * (5[0])(1[0])(2[0])(3[0])(4[0])(6[0])(7[0])(8[0])(9[0])(10[0])
//  * (10[0])(9[0])(8[0])(7[0])(6[0])(4[0])(3[0])(2[0])(1[0])(5[0])
//  * Acessing 10:
//  * (10[0])(5[0])(1[0])(2[0])(3[0])(4[0])(6[0])(7[0])(8[0])(9[0])
//  * (9[0])(8[0])(7[0])(6[0])(4[0])(3[0])(2[0])(1[0])(5[0])(10[0])
//  * Acessing 6:
//  * (6[0])(10[0])(5[0])(1[0])(2[0])(3[0])(4[0])(7[0])(8[0])(9[0])
//  * (9[0])(8[0])(7[0])(4[0])(3[0])(2[0])(1[0])(5[0])(10[0])(6[0])
//  * Acessing 10:
//  * 
//  * 
//  * Testing natural order functions..........................
//  * (9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
//  * (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])
//  * (9[0])(8[0])(7[0])(6[0])(5[0])
//  * (5[0])(6[0])(7[0])(8[0])(9[0])
//  * Testing transpose function......................................
//  * Before trasposing stuff:
//  * (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])
//  * (9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
//  * Transposing 2:
//  * (0[0])(2[0])(1[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])
//  * (9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(1[0])(2[0])(0[0])
//  * Transposing 2:
//  * (2[0])(0[0])(1[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])
//  * (9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(1[0])(0[0])(2[0])
//  * Transposing 9:
//  * (2[0])(0[0])(1[0])(3[0])(4[0])(5[0])(6[0])(7[0])(9[0])(8[0])
//  * (8[0])(9[0])(7[0])(6[0])(5[0])(4[0])(3[0])(1[0])(0[0])(2[0])
//  * Transposing 5:
//  * (2[0])(0[0])(1[0])(3[0])(5[0])(4[0])(6[0])(7[0])(9[0])(8[0])
//  * (8[0])(9[0])(7[0])(6[0])(4[0])(5[0])(3[0])(1[0])(0[0])(2[0])
//  * Testing Iterative traverse functions...........................
//  * Testing toString ...............................................
//  * ->(0[0])->(1[0])->(2[0])->(3[0])->(4[0])->(5[0])->(6[0])->(7[0])->(8[0])->(9[
//  * 0])
//  * 
//  * Testing contains ..............................................
//  * list contains 0 ? yes
//  * list contains 17 ? no
//  * 
//  * Testing size ...................................................
//  * Size of list is: 10
//  * 
//  * Testing find ....................................................
//  * find 2 in iterative -> (2[0])
//  * 
//  * Testing get ..............................................
//  * Get node in position 3 ->(3[0])
//  * 
//  * Testing reverse list ..............................................
//  * List reversed:
//  * (9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
//  * (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])
//  * 
//  * Testing clone ..............................................
//  * List cloned:
//  * (9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
//  * (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])
//  * 
//  * Testing ToString ..............................................
//  * ->(0[0])->(1[0])->(2[0])->(3[0])->(4[0])->(5[0])->(6[0])->(7[0])->(8[0])->(9[
//  * 0])
//  * Testing Recursive traverse functions...........................
//  * Testing toString ...............................................
//  * ->(0[0])->(1[0])->(2[0])->(3[0])->(4[0])->(5[0])->(6[0])->(7[0])->(8[0])->(9[
//  * 0])
//  * 
//  * Testing contains ..............................................
//  * list contains 0 ? yes
//  * list contains 17 ? no
//  * 
//  * Testing size ...................................................
//  * Size of list is: 10
//  * 
//  * Testing find ....................................................
//  * find 2 in recursive -> (2[0])
//  * 
//  * Testing get ..............................................
//  * Get node in position 3 ->(3[0])
//  * 
//  * Testing reverse list ..............................................
//  * List reversed:
//  * (9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
//  * (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])
//  * 
//  * Testing clone ..............................................
//  * List cloned:
//  * (9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
//  * (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])
//  * 
//  * Testing ToString ..............................................
//  * ->(0[0])->(1[0])->(2[0])->(3[0])->(4[0])->(5[0])->(6[0])->(7[0])->(8[0])->(9[
//  * 0])
//  */

public class App {
    public static void main(String[] args) throws Exception {
        // TODO: Implement an extensive testing main!!!
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";
        /*
         * Please read
         * To make sure that you can see everything in the terminal for the output go
         * into the setting on visual studio code and change search
         * "terminal" scrollback and change that number to 2000 which should give
         * youenough space to see all the output and still have space left to
         * add more output if you want.
         */
        CountList<Integer> countList = new CountList<>();
        test(countList, "CountList", ANSI_RED);

        MoveToFrontList<Integer> moveList = new MoveToFrontList<>();
        test(moveList, "MoveToFrontList", ANSI_BLUE);

        NaturalOrderList<Integer> naturalList = new NaturalOrderList<>();
        test(naturalList, "NaturalOrderList", ANSI_GREEN);

        TransposeList<Integer> transposeList = new TransposeList<>();
        test(transposeList, "TransposeList", ANSI_PURPLE);
    }

    public static void print(SelfOrderingList<Integer> list) {
        Node<Integer> node = list.head;
        while (node != null) {
            System.out.print(node.toString());
            node = node.next;
        }
        System.out.println();

        // node = list.gotToEnd(list.head);
        while (node != null) {
            System.out.print(node.toString());
            node = node.prev;
        }
        System.out.println();
    }

    public static void test(SelfOrderingList<Integer> list, String listType, String color) {
        listType = color + listType + "\u001B[0m";
        System.out.println("testing: " + listType
                + "......................................................................................");

        for (int i = 0; i < 20; i++) {
            list.insert(i);
        }

        System.out.println("\n" + listType + " After insert: \n");
        print(list);

        for (int i = 0; i < 25; i++) {
            list.access(i);
        }

        System.out.println("\n" + listType + " After access: \n");
        print(list);
        RecursiveTraverse<Integer> recursive = new RecursiveTraverse<Integer>(list);
        testingTraverser(recursive, listType, list, "Recursive");
        IterativeTraverse<Integer> iterative = new IterativeTraverse<Integer>(list);
        testingTraverser(iterative, listType, list, "Iterative");

        for (int i = 25; i >= 0; i--) {
            list.access(i);
        }

        System.out.println("\n" + listType + " After second access: \n");
        print(list);

        System.out.println("\n" + listType + " deleting half the nodes: \n");
        for (int i = 0; i < 25; i += 2) {
            list.remove(i);
        }

        print(list);

        for (int i = 25; i >= 0; i--) {
            list.access(i);
        }

        System.out.println("\n" + listType + " After third access: \n");
        print(list);

        System.out.println("\n" + listType + " deleting the other of half the nodes: \n");
        for (int i = 1; i < 25; i += 2) {
            list.remove(i);
        }

        for (int i = 19; i >= 0; i--) {
            list.insert(i);
        }

        System.out.println("\n" + listType + " After second insert: \n");
        print(list);

    }

    public static void testingTraverser(Traverser<Integer> traverser, String listType, SelfOrderingList<Integer> list,
            String traverserType) {

        System.out.println("\nTesting " + traverserType + " for " + listType + "\n" + traverser + "\n");

        System.out.println("\nTesting " + traverserType + " size for: " + listType + "\n");
        System.out.println("Size: " + traverser.size());

        System.out.println("\nTesting " + traverserType + " reverse for: " + listType + "\n");
        SelfOrderingList<Integer> reverse = traverser.reverseList();
        print(reverse);

        System.out.println("\nTesting " + traverserType + " clone for: " + listType + "\n");
        print(traverser.clone(list));

        System.out.println("\nTesting " + traverserType + " contains for all items plus more for: " + listType + "\n");
        for (int i = 0; i < 25; i++) {
            boolean testIterativecontains = traverser.contains(i);
            if (testIterativecontains)
                System.out.println("list contains " + i + " ? yes");
            if (!testIterativecontains)
                System.out.println("list contains " + i + " ? no");
        }

        System.out.println("\nTesting " + traverserType + " find for: " + listType + "\n");
        for (int i = 0; i < 25; i++) {
            System.out.println("Expecting: " + i + " Found: " + traverser.find(i));
        }

        System.out.println("\nTesting " + traverserType + " get for: " + listType + "\n");
        for (int i = 0; i < 25; i++) {
            System.out.println("Expecting: " + i + " Found: " + traverser.get(i));
        }

    }

}
