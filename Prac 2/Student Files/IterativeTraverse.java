
public class IterativeTraverse<T extends Comparable<T>> extends Traverser<T> {
    public IterativeTraverse() {
        // TODO: Implement the

        list = null;
    };

    public IterativeTraverse(SelfOrderingList<T> list) {
        // TODO: Implement the function

        Node<T> current = list.head;
        this.list = list.getBlankList();

        while (current != null) {
            this.list.insert(current.data);
            current = current.next;
        }

    }

    @Override
    public SelfOrderingList<T> reverseList() {
        // TODO: Implement the function

        SelfOrderingList<T> Listynew = list.getBlankList();
        Node<T> ptr = list.head;

        if (ptr == null)
            return null;

        while (ptr.next != null) {
            ptr = ptr.next;

        }

        while (ptr != null) {
            Listynew.insert(ptr.data);
            ptr = ptr.prev;
        }

        return Listynew;

    }

    @Override
    public boolean contains(T data) {
        // TODO: Implement the function
        Node<T> ptr = list.head;
        while (data != ptr.data) {
            ptr = ptr.next;
        }

        if (ptr == null)
            return false;

        else {
            return true;
        }
    }

    @Override
    public String toString() {
        // TODO: Implement the function
        Node<T> ptr = list.head;
        String result = "- >";

        while (ptr.next != null) {
            result = result + ptr.toString();
            ptr = ptr.next;
        }

        return result;

    }

    @Override
    public Node<T> get(int pos) {
        // TODO: Implement the function

    }

    @Override
    public Node<T> find(T data) {
        // TODO: Implement the function

        Node<T> ptr = list.head;

        while (ptr.data != data) {
            ptr = ptr.next;
        }

        if (ptr == null)
            return null;

        return ptr;

    }

    @Override
    public int size() {
        // TODO: Implement the function
        Node<T> ptr = list.head;
        int count = 0;
        if (ptr == null)
            return 0;

        while (ptr != null) {
            count = count + 1;
            ptr = ptr.next;

        }

        return count;

    }

    @Override
    public SelfOrderingList<T> clone(SelfOrderingList<T> otherList) {
        // TODO: Implement the function
        SelfOrderingList<T> newList = list.getBlankList();

        // if (otherList == null)
        // return null;

        // else if (otherList.head == null)
        // return newList;
        // else {

        Node<T> checker = otherList.head;

        while (checker != null) {
            newList.insert(checker.data);
            checker = checker.next;

        }

        return newList;

    }

}

// testing:
// CountList......................................................................................

// CountList After insert:

// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])

// CountList After access:

// (0[1])(1[1])(2[1])(3[1])(4[1])(5[1])(6[1])(7[1])(8[1])(9[1])(10[1])(11[1])(12[1])(13[1])(14[1])(15[1])(16[1])(17[1])(18[1])(19[1])
// (19[1])(18[1])(17[1])(16[1])(15[1])(14[1])(13[1])(12[1])(11[1])(10[1])(9[1])(8[1])(7[1])(6[1])(5[1])(4[1])(3[1])(2[1])(1[1])(0[1])

// Testing Recursive for CountList
// ->(0[0])->(1[0])->(2[0])->(3[0])->(4[0])->(5[0])->(6[0])->(7[0])->(8[0])->(9[0])->(10[0])->(11[0])->(12[0])->(13[0])->(14[0])->(15[0])->(16[0])->(17[0])->(18[0])->(19[0])

// Testing Recursive size for: CountList

// Size: 20

// Testing Recursive reverse for: CountList

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// Testing Recursive clone for: CountList

// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])

// Testing Recursive contains for all items plus more for: CountList

// list contains 0 ? yes
// list contains 1 ? yes
// list contains 2 ? yes
// list contains 3 ? yes
// list contains 4 ? yes
// list contains 5 ? yes
// list contains 6 ? yes
// list contains 7 ? yes
// list contains 8 ? yes
// list contains 9 ? yes
// list contains 10 ? yes
// list contains 11 ? yes
// list contains 12 ? yes
// list contains 13 ? yes
// list contains 14 ? yes
// list contains 15 ? yes
// list contains 16 ? yes
// list contains 17 ? yes
// list contains 18 ? yes
// list contains 19 ? yes
// list contains 20 ? no
// list contains 21 ? no
// list contains 22 ? no
// list contains 23 ? no
// list contains 24 ? no

// Testing Recursive find for: CountList

// Expecting: 0 Found: (0[0])
// Expecting: 1 Found: (1[0])
// Expecting: 2 Found: (2[0])
// Expecting: 3 Found: (3[0])
// Expecting: 4 Found: (4[0])
// Expecting: 5 Found: (5[0])
// Expecting: 6 Found: (6[0])
// Expecting: 7 Found: (7[0])
// Expecting: 8 Found: (8[0])
// Expecting: 9 Found: (9[0])
// Expecting: 10 Found: (10[0])
// Expecting: 11 Found: (11[0])
// Expecting: 12 Found: (12[0])
// Expecting: 13 Found: (13[0])
// Expecting: 14 Found: (14[0])
// Expecting: 15 Found: (15[0])
// Expecting: 16 Found: (16[0])
// Expecting: 17 Found: (17[0])
// Expecting: 18 Found: (18[0])
// Expecting: 19 Found: (19[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Recursive get for: CountList

// Expecting: 0 Found: (0[0])
// Expecting: 1 Found: (1[0])
// Expecting: 2 Found: (2[0])
// Expecting: 3 Found: (3[0])
// Expecting: 4 Found: (4[0])
// Expecting: 5 Found: (5[0])
// Expecting: 6 Found: (6[0])
// Expecting: 7 Found: (7[0])
// Expecting: 8 Found: (8[0])
// Expecting: 9 Found: (9[0])
// Expecting: 10 Found: (10[0])
// Expecting: 11 Found: (11[0])
// Expecting: 12 Found: (12[0])
// Expecting: 13 Found: (13[0])
// Expecting: 14 Found: (14[0])
// Expecting: 15 Found: (15[0])
// Expecting: 16 Found: (16[0])
// Expecting: 17 Found: (17[0])
// Expecting: 18 Found: (18[0])
// Expecting: 19 Found: (19[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Iterative for CountList
// ->(0[0])->(1[0])->(2[0])->(3[0])->(4[0])->(5[0])->(6[0])->(7[0])->(8[0])->(9[0])->(10[0])->(11[0])->(12[0])->(13[0])->(14[0])->(15[0])->(16[0])->(17[0])->(18[0])->(19[0])

// Testing Iterative size for: CountList

// Size: 20

// Testing Iterative reverse for: CountList

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// Testing Iterative clone for: CountList

// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])

// Testing Iterative contains for all items plus more for: CountList

// list contains 0 ? yes
// list contains 1 ? yes
// list contains 2 ? yes
// list contains 3 ? yes
// list contains 4 ? yes
// list contains 5 ? yes
// list contains 6 ? yes
// list contains 7 ? yes
// list contains 8 ? yes
// list contains 9 ? yes
// list contains 10 ? yes
// list contains 11 ? yes
// list contains 12 ? yes
// list contains 13 ? yes
// list contains 14 ? yes
// list contains 15 ? yes
// list contains 16 ? yes
// list contains 17 ? yes
// list contains 18 ? yes
// list contains 19 ? yes
// list contains 20 ? no
// list contains 21 ? no
// list contains 22 ? no
// list contains 23 ? no
// list contains 24 ? no

// Testing Iterative find for: CountList

// Expecting: 0 Found: (0[0])
// Expecting: 1 Found: (1[0])
// Expecting: 2 Found: (2[0])
// Expecting: 3 Found: (3[0])
// Expecting: 4 Found: (4[0])
// Expecting: 5 Found: (5[0])
// Expecting: 6 Found: (6[0])
// Expecting: 7 Found: (7[0])
// Expecting: 8 Found: (8[0])
// Expecting: 9 Found: (9[0])
// Expecting: 10 Found: (10[0])
// Expecting: 11 Found: (11[0])
// Expecting: 12 Found: (12[0])
// Expecting: 13 Found: (13[0])
// Expecting: 14 Found: (14[0])
// Expecting: 15 Found: (15[0])
// Expecting: 16 Found: (16[0])
// Expecting: 17 Found: (17[0])
// Expecting: 18 Found: (18[0])
// Expecting: 19 Found: (19[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Iterative get for: CountList

// Expecting: 0 Found: (0[0])
// Expecting: 1 Found: (1[0])
// Expecting: 2 Found: (2[0])
// Expecting: 3 Found: (3[0])
// Expecting: 4 Found: (4[0])
// Expecting: 5 Found: (5[0])
// Expecting: 6 Found: (6[0])
// Expecting: 7 Found: (7[0])
// Expecting: 8 Found: (8[0])
// Expecting: 9 Found: (9[0])
// Expecting: 10 Found: (10[0])
// Expecting: 11 Found: (11[0])
// Expecting: 12 Found: (12[0])
// Expecting: 13 Found: (13[0])
// Expecting: 14 Found: (14[0])
// Expecting: 15 Found: (15[0])
// Expecting: 16 Found: (16[0])
// Expecting: 17 Found: (17[0])
// Expecting: 18 Found: (18[0])
// Expecting: 19 Found: (19[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// CountList After second access:

// (19[2])(18[2])(17[2])(16[2])(15[2])(14[2])(13[2])(12[2])(11[2])(10[2])(9[2])(8[2])(7[2])(6[2])(5[2])(4[2])(3[2])(2[2])(1[2])(0[2])
// (0[2])(1[2])(2[2])(3[2])(4[2])(5[2])(6[2])(7[2])(8[2])(9[2])(10[2])(11[2])(12[2])(13[2])(14[2])(15[2])(16[2])(17[2])(18[2])(19[2])

// CountList deleting half the nodes:

// (19[2])(17[2])(15[2])(13[2])(11[2])(9[2])(7[2])(5[2])(3[2])(1[2])
// (1[2])(3[2])(5[2])(7[2])(9[2])(11[2])(13[2])(15[2])(17[2])(19[2])

// CountList After third access:

// (19[3])(17[3])(15[3])(13[3])(11[3])(9[3])(7[3])(5[3])(3[3])(1[3])
// (1[3])(3[3])(5[3])(7[3])(9[3])(11[3])(13[3])(15[3])(17[3])(19[3])

// CountList deleting the other of half the nodes:

// CountList After second insert:

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// testing:
// MoveToFrontList......................................................................................

// MoveToFrontList After insert:

// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])

// MoveToFrontList After access:

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// Testing Recursive for MoveToFrontList
// ->(19[0])->(18[0])->(17[0])->(16[0])->(15[0])->(14[0])->(13[0])->(12[0])->(11[0])->(10[0])->(9[0])->(8[0])->(7[0])->(6[0])->(5[0])->(4[0])->(3[0])->(2[0])->(1[0])->(0[0])

// Testing Recursive size for: MoveToFrontList

// Size: 20

// Testing Recursive reverse for: MoveToFrontList

// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])

// Testing Recursive clone for: MoveToFrontList

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// Testing Recursive contains for all items plus more for: MoveToFrontList

// list contains 0 ? yes
// list contains 1 ? yes
// list contains 2 ? yes
// list contains 3 ? yes
// list contains 4 ? yes
// list contains 5 ? yes
// list contains 6 ? yes
// list contains 7 ? yes
// list contains 8 ? yes
// list contains 9 ? yes
// list contains 10 ? yes
// list contains 11 ? yes
// list contains 12 ? yes
// list contains 13 ? yes
// list contains 14 ? yes
// list contains 15 ? yes
// list contains 16 ? yes
// list contains 17 ? yes
// list contains 18 ? yes
// list contains 19 ? yes
// list contains 20 ? no
// list contains 21 ? no
// list contains 22 ? no
// list contains 23 ? no
// list contains 24 ? no

// Testing Recursive find for: MoveToFrontList

// Expecting: 0 Found: (0[0])
// Expecting: 1 Found: (1[0])
// Expecting: 2 Found: (2[0])
// Expecting: 3 Found: (3[0])
// Expecting: 4 Found: (4[0])
// Expecting: 5 Found: (5[0])
// Expecting: 6 Found: (6[0])
// Expecting: 7 Found: (7[0])
// Expecting: 8 Found: (8[0])
// Expecting: 9 Found: (9[0])
// Expecting: 10 Found: (10[0])
// Expecting: 11 Found: (11[0])
// Expecting: 12 Found: (12[0])
// Expecting: 13 Found: (13[0])
// Expecting: 14 Found: (14[0])
// Expecting: 15 Found: (15[0])
// Expecting: 16 Found: (16[0])
// Expecting: 17 Found: (17[0])
// Expecting: 18 Found: (18[0])
// Expecting: 19 Found: (19[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Recursive get for: MoveToFrontList

// Expecting: 0 Found: (19[0])
// Expecting: 1 Found: (18[0])
// Expecting: 2 Found: (17[0])
// Expecting: 3 Found: (16[0])
// Expecting: 4 Found: (15[0])
// Expecting: 5 Found: (14[0])
// Expecting: 6 Found: (13[0])
// Expecting: 7 Found: (12[0])
// Expecting: 8 Found: (11[0])
// Expecting: 9 Found: (10[0])
// Expecting: 10 Found: (9[0])
// Expecting: 11 Found: (8[0])
// Expecting: 12 Found: (7[0])
// Expecting: 13 Found: (6[0])
// Expecting: 14 Found: (5[0])
// Expecting: 15 Found: (4[0])
// Expecting: 16 Found: (3[0])
// Expecting: 17 Found: (2[0])
// Expecting: 18 Found: (1[0])
// Expecting: 19 Found: (0[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Iterative for MoveToFrontList
// ->(19[0])->(18[0])->(17[0])->(16[0])->(15[0])->(14[0])->(13[0])->(12[0])->(11[0])->(10[0])->(9[0])->(8[0])->(7[0])->(6[0])->(5[0])->(4[0])->(3[0])->(2[0])->(1[0])->(0[0])

// Testing Iterative size for: MoveToFrontList

// Size: 20

// Testing Iterative reverse for: MoveToFrontList

// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])

// Testing Iterative clone for: MoveToFrontList

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// Testing Iterative contains for all items plus more for: MoveToFrontList

// list contains 0 ? yes
// list contains 1 ? yes
// list contains 2 ? yes
// list contains 3 ? yes
// list contains 4 ? yes
// list contains 5 ? yes
// list contains 6 ? yes
// list contains 7 ? yes
// list contains 8 ? yes
// list contains 9 ? yes
// list contains 10 ? yes
// list contains 11 ? yes
// list contains 12 ? yes
// list contains 13 ? yes
// list contains 14 ? yes
// list contains 15 ? yes
// list contains 16 ? yes
// list contains 17 ? yes
// list contains 18 ? yes
// list contains 19 ? yes
// list contains 20 ? no
// list contains 21 ? no
// list contains 22 ? no
// list contains 23 ? no
// list contains 24 ? no

// Testing Iterative find for: MoveToFrontList

// Expecting: 0 Found: (0[0])
// Expecting: 1 Found: (1[0])
// Expecting: 2 Found: (2[0])
// Expecting: 3 Found: (3[0])
// Expecting: 4 Found: (4[0])
// Expecting: 5 Found: (5[0])
// Expecting: 6 Found: (6[0])
// Expecting: 7 Found: (7[0])
// Expecting: 8 Found: (8[0])
// Expecting: 9 Found: (9[0])
// Expecting: 10 Found: (10[0])
// Expecting: 11 Found: (11[0])
// Expecting: 12 Found: (12[0])
// Expecting: 13 Found: (13[0])
// Expecting: 14 Found: (14[0])
// Expecting: 15 Found: (15[0])
// Expecting: 16 Found: (16[0])
// Expecting: 17 Found: (17[0])
// Expecting: 18 Found: (18[0])
// Expecting: 19 Found: (19[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Iterative get for: MoveToFrontList

// Expecting: 0 Found: (19[0])
// Expecting: 1 Found: (18[0])
// Expecting: 2 Found: (17[0])
// Expecting: 3 Found: (16[0])
// Expecting: 4 Found: (15[0])
// Expecting: 5 Found: (14[0])
// Expecting: 6 Found: (13[0])
// Expecting: 7 Found: (12[0])
// Expecting: 8 Found: (11[0])
// Expecting: 9 Found: (10[0])
// Expecting: 10 Found: (9[0])
// Expecting: 11 Found: (8[0])
// Expecting: 12 Found: (7[0])
// Expecting: 13 Found: (6[0])
// Expecting: 14 Found: (5[0])
// Expecting: 15 Found: (4[0])
// Expecting: 16 Found: (3[0])
// Expecting: 17 Found: (2[0])
// Expecting: 18 Found: (1[0])
// Expecting: 19 Found: (0[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// MoveToFrontList After second access:

// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])

// MoveToFrontList deleting half the nodes:

// (1[0])(3[0])(5[0])(7[0])(9[0])(11[0])(13[0])(15[0])(17[0])(19[0])
// (19[0])(17[0])(15[0])(13[0])(11[0])(9[0])(7[0])(5[0])(3[0])(1[0])

// MoveToFrontList After third access:

// (1[0])(3[0])(5[0])(7[0])(9[0])(11[0])(13[0])(15[0])(17[0])(19[0])
// (19[0])(17[0])(15[0])(13[0])(11[0])(9[0])(7[0])(5[0])(3[0])(1[0])

// MoveToFrontList deleting the other of half the nodes:

// MoveToFrontList After second insert:

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// testing:
// NaturalOrderList......................................................................................

// NaturalOrderList After insert:

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// NaturalOrderList After access:

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// Testing Recursive for NaturalOrderList
// ->(19[0])->(18[0])->(17[0])->(16[0])->(15[0])->(14[0])->(13[0])->(12[0])->(11[0])->(10[0])->(9[0])->(8[0])->(7[0])->(6[0])->(5[0])->(4[0])->(3[0])->(2[0])->(1[0])->(0[0])

// Testing Recursive size for: NaturalOrderList

// Size: 20

// Testing Recursive reverse for: NaturalOrderList

// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])

// Testing Recursive clone for: NaturalOrderList

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// Testing Recursive contains for all items plus more for: NaturalOrderList

// list contains 0 ? yes
// list contains 1 ? yes
// list contains 2 ? yes
// list contains 3 ? yes
// list contains 4 ? yes
// list contains 5 ? yes
// list contains 6 ? yes
// list contains 7 ? yes
// list contains 8 ? yes
// list contains 9 ? yes
// list contains 10 ? yes
// list contains 11 ? yes
// list contains 12 ? yes
// list contains 13 ? yes
// list contains 14 ? yes
// list contains 15 ? yes
// list contains 16 ? yes
// list contains 17 ? yes
// list contains 18 ? yes
// list contains 19 ? yes
// list contains 20 ? no
// list contains 21 ? no
// list contains 22 ? no
// list contains 23 ? no
// list contains 24 ? no

// Testing Recursive find for: NaturalOrderList

// Expecting: 0 Found: (0[0])
// Expecting: 1 Found: (1[0])
// Expecting: 2 Found: (2[0])
// Expecting: 3 Found: (3[0])
// Expecting: 4 Found: (4[0])
// Expecting: 5 Found: (5[0])
// Expecting: 6 Found: (6[0])
// Expecting: 7 Found: (7[0])
// Expecting: 8 Found: (8[0])
// Expecting: 9 Found: (9[0])
// Expecting: 10 Found: (10[0])
// Expecting: 11 Found: (11[0])
// Expecting: 12 Found: (12[0])
// Expecting: 13 Found: (13[0])
// Expecting: 14 Found: (14[0])
// Expecting: 15 Found: (15[0])
// Expecting: 16 Found: (16[0])
// Expecting: 17 Found: (17[0])
// Expecting: 18 Found: (18[0])
// Expecting: 19 Found: (19[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Recursive get for: NaturalOrderList

// Expecting: 0 Found: (19[0])
// Expecting: 1 Found: (18[0])
// Expecting: 2 Found: (17[0])
// Expecting: 3 Found: (16[0])
// Expecting: 4 Found: (15[0])
// Expecting: 5 Found: (14[0])
// Expecting: 6 Found: (13[0])
// Expecting: 7 Found: (12[0])
// Expecting: 8 Found: (11[0])
// Expecting: 9 Found: (10[0])
// Expecting: 10 Found: (9[0])
// Expecting: 11 Found: (8[0])
// Expecting: 12 Found: (7[0])
// Expecting: 13 Found: (6[0])
// Expecting: 14 Found: (5[0])
// Expecting: 15 Found: (4[0])
// Expecting: 16 Found: (3[0])
// Expecting: 17 Found: (2[0])
// Expecting: 18 Found: (1[0])
// Expecting: 19 Found: (0[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Iterative for NaturalOrderList
// ->(19[0])->(18[0])->(17[0])->(16[0])->(15[0])->(14[0])->(13[0])->(12[0])->(11[0])->(10[0])->(9[0])->(8[0])->(7[0])->(6[0])->(5[0])->(4[0])->(3[0])->(2[0])->(1[0])->(0[0])

// Testing Iterative size for: NaturalOrderList

// Size: 20

// Testing Iterative reverse for: NaturalOrderList

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// Testing Iterative clone for: NaturalOrderList

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// Testing Iterative contains for all items plus more for: NaturalOrderList

// list contains 0 ? yes
// list contains 1 ? yes
// list contains 2 ? yes
// list contains 3 ? yes
// list contains 4 ? yes
// list contains 5 ? yes
// list contains 6 ? yes
// list contains 7 ? yes
// list contains 8 ? yes
// list contains 9 ? yes
// list contains 10 ? yes
// list contains 11 ? yes
// list contains 12 ? yes
// list contains 13 ? yes
// list contains 14 ? yes
// list contains 15 ? yes
// list contains 16 ? yes
// list contains 17 ? yes
// list contains 18 ? yes
// list contains 19 ? yes
// list contains 20 ? no
// list contains 21 ? no
// list contains 22 ? no
// list contains 23 ? no
// list contains 24 ? no

// Testing Iterative find for: NaturalOrderList

// Expecting: 0 Found: (0[0])
// Expecting: 1 Found: (1[0])
// Expecting: 2 Found: (2[0])
// Expecting: 3 Found: (3[0])
// Expecting: 4 Found: (4[0])
// Expecting: 5 Found: (5[0])
// Expecting: 6 Found: (6[0])
// Expecting: 7 Found: (7[0])
// Expecting: 8 Found: (8[0])
// Expecting: 9 Found: (9[0])
// Expecting: 10 Found: (10[0])
// Expecting: 11 Found: (11[0])
// Expecting: 12 Found: (12[0])
// Expecting: 13 Found: (13[0])
// Expecting: 14 Found: (14[0])
// Expecting: 15 Found: (15[0])
// Expecting: 16 Found: (16[0])
// Expecting: 17 Found: (17[0])
// Expecting: 18 Found: (18[0])
// Expecting: 19 Found: (19[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Iterative get for: NaturalOrderList

// Expecting: 0 Found: (19[0])
// Expecting: 1 Found: (18[0])
// Expecting: 2 Found: (17[0])
// Expecting: 3 Found: (16[0])
// Expecting: 4 Found: (15[0])
// Expecting: 5 Found: (14[0])
// Expecting: 6 Found: (13[0])
// Expecting: 7 Found: (12[0])
// Expecting: 8 Found: (11[0])
// Expecting: 9 Found: (10[0])
// Expecting: 10 Found: (9[0])
// Expecting: 11 Found: (8[0])
// Expecting: 12 Found: (7[0])
// Expecting: 13 Found: (6[0])
// Expecting: 14 Found: (5[0])
// Expecting: 15 Found: (4[0])
// Expecting: 16 Found: (3[0])
// Expecting: 17 Found: (2[0])
// Expecting: 18 Found: (1[0])
// Expecting: 19 Found: (0[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// NaturalOrderList After second access:

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])

// NaturalOrderList deleting half the nodes:

// (19[0])(17[0])(15[0])(13[0])(11[0])(9[0])(7[0])(5[0])(3[0])(1[0])
// (1[0])(3[0])(5[0])(7[0])(9[0])(11[0])(13[0])(15[0])(17[0])(19[0])

// NaturalOrderList After third access:

// (19[0])(17[0])(15[0])(13[0])(11[0])(9[0])(7[0])(5[0])(3[0])(1[0])
// (1[0])(3[0])(5[0])(7[0])(9[0])(11[0])(13[0])(15[0])(17[0])(19[0])

// NaturalOrderList deleting the other of half the nodes:

// NaturalOrderList After second insert:

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// testing:
// TransposeList......................................................................................

// TransposeList After insert:

// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])

// TransposeList After access:

// (1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])(0[0])
// (0[0])(19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])

// Testing Recursive for TransposeList
// ->(1[0])->(2[0])->(3[0])->(4[0])->(5[0])->(6[0])->(7[0])->(8[0])->(9[0])->(10[0])->(11[0])->(12[0])->(13[0])->(14[0])->(15[0])->(16[0])->(17[0])->(18[0])->(19[0])->(0[0])

// Testing Recursive size for: TransposeList

// Size: 20

// Testing Recursive reverse for: TransposeList

// (0[0])(19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])
// (1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])(0[0])

// Testing Recursive clone for: TransposeList

// (1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])(0[0])
// (0[0])(19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])

// Testing Recursive contains for all items plus more for: TransposeList

// list contains 0 ? yes
// list contains 1 ? yes
// list contains 2 ? yes
// list contains 3 ? yes
// list contains 4 ? yes
// list contains 5 ? yes
// list contains 6 ? yes
// list contains 7 ? yes
// list contains 8 ? yes
// list contains 9 ? yes
// list contains 10 ? yes
// list contains 11 ? yes
// list contains 12 ? yes
// list contains 13 ? yes
// list contains 14 ? yes
// list contains 15 ? yes
// list contains 16 ? yes
// list contains 17 ? yes
// list contains 18 ? yes
// list contains 19 ? yes
// list contains 20 ? no
// list contains 21 ? no
// list contains 22 ? no
// list contains 23 ? no
// list contains 24 ? no

// Testing Recursive find for: TransposeList

// Expecting: 0 Found: (0[0])
// Expecting: 1 Found: (1[0])
// Expecting: 2 Found: (2[0])
// Expecting: 3 Found: (3[0])
// Expecting: 4 Found: (4[0])
// Expecting: 5 Found: (5[0])
// Expecting: 6 Found: (6[0])
// Expecting: 7 Found: (7[0])
// Expecting: 8 Found: (8[0])
// Expecting: 9 Found: (9[0])
// Expecting: 10 Found: (10[0])
// Expecting: 11 Found: (11[0])
// Expecting: 12 Found: (12[0])
// Expecting: 13 Found: (13[0])
// Expecting: 14 Found: (14[0])
// Expecting: 15 Found: (15[0])
// Expecting: 16 Found: (16[0])
// Expecting: 17 Found: (17[0])
// Expecting: 18 Found: (18[0])
// Expecting: 19 Found: (19[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Recursive get for: TransposeList

// Expecting: 0 Found: (1[0])
// Expecting: 1 Found: (2[0])
// Expecting: 2 Found: (3[0])
// Expecting: 3 Found: (4[0])
// Expecting: 4 Found: (5[0])
// Expecting: 5 Found: (6[0])
// Expecting: 6 Found: (7[0])
// Expecting: 7 Found: (8[0])
// Expecting: 8 Found: (9[0])
// Expecting: 9 Found: (10[0])
// Expecting: 10 Found: (11[0])
// Expecting: 11 Found: (12[0])
// Expecting: 12 Found: (13[0])
// Expecting: 13 Found: (14[0])
// Expecting: 14 Found: (15[0])
// Expecting: 15 Found: (16[0])
// Expecting: 16 Found: (17[0])
// Expecting: 17 Found: (18[0])
// Expecting: 18 Found: (19[0])
// Expecting: 19 Found: (0[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Iterative for TransposeList
// ->(1[0])->(2[0])->(3[0])->(4[0])->(5[0])->(6[0])->(7[0])->(8[0])->(9[0])->(10[0])->(11[0])->(12[0])->(13[0])->(14[0])->(15[0])->(16[0])->(17[0])->(18[0])->(19[0])->(0[0])

// Testing Iterative size for: TransposeList

// Size: 20

// Testing Iterative reverse for: TransposeList

// (0[0])(19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])
// (1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])(0[0])

// Testing Iterative clone for: TransposeList

// (1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])(0[0])
// (0[0])(19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])

// Testing Iterative contains for all items plus more for: TransposeList

// list contains 0 ? yes
// list contains 1 ? yes
// list contains 2 ? yes
// list contains 3 ? yes
// list contains 4 ? yes
// list contains 5 ? yes
// list contains 6 ? yes
// list contains 7 ? yes
// list contains 8 ? yes
// list contains 9 ? yes
// list contains 10 ? yes
// list contains 11 ? yes
// list contains 12 ? yes
// list contains 13 ? yes
// list contains 14 ? yes
// list contains 15 ? yes
// list contains 16 ? yes
// list contains 17 ? yes
// list contains 18 ? yes
// list contains 19 ? yes
// list contains 20 ? no
// list contains 21 ? no
// list contains 22 ? no
// list contains 23 ? no
// list contains 24 ? no

// Testing Iterative find for: TransposeList

// Expecting: 0 Found: (0[0])
// Expecting: 1 Found: (1[0])
// Expecting: 2 Found: (2[0])
// Expecting: 3 Found: (3[0])
// Expecting: 4 Found: (4[0])
// Expecting: 5 Found: (5[0])
// Expecting: 6 Found: (6[0])
// Expecting: 7 Found: (7[0])
// Expecting: 8 Found: (8[0])
// Expecting: 9 Found: (9[0])
// Expecting: 10 Found: (10[0])
// Expecting: 11 Found: (11[0])
// Expecting: 12 Found: (12[0])
// Expecting: 13 Found: (13[0])
// Expecting: 14 Found: (14[0])
// Expecting: 15 Found: (15[0])
// Expecting: 16 Found: (16[0])
// Expecting: 17 Found: (17[0])
// Expecting: 18 Found: (18[0])
// Expecting: 19 Found: (19[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// Testing Iterative get for: TransposeList

// Expecting: 0 Found: (1[0])
// Expecting: 1 Found: (2[0])
// Expecting: 2 Found: (3[0])
// Expecting: 3 Found: (4[0])
// Expecting: 4 Found: (5[0])
// Expecting: 5 Found: (6[0])
// Expecting: 6 Found: (7[0])
// Expecting: 7 Found: (8[0])
// Expecting: 8 Found: (9[0])
// Expecting: 9 Found: (10[0])
// Expecting: 10 Found: (11[0])
// Expecting: 11 Found: (12[0])
// Expecting: 12 Found: (13[0])
// Expecting: 13 Found: (14[0])
// Expecting: 14 Found: (15[0])
// Expecting: 15 Found: (16[0])
// Expecting: 16 Found: (17[0])
// Expecting: 17 Found: (18[0])
// Expecting: 18 Found: (19[0])
// Expecting: 19 Found: (0[0])
// Expecting: 20 Found: null
// Expecting: 21 Found: null
// Expecting: 22 Found: null
// Expecting: 23 Found: null
// Expecting: 24 Found: null

// TransposeList After second access:

// (1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(0[0])(19[0])
// (19[0])(0[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])

// TransposeList deleting half the nodes:

// (1[0])(3[0])(5[0])(7[0])(9[0])(11[0])(13[0])(15[0])(17[0])(19[0])
// (19[0])(17[0])(15[0])(13[0])(11[0])(9[0])(7[0])(5[0])(3[0])(1[0])

// TransposeList After third access:

// (1[0])(3[0])(5[0])(7[0])(9[0])(11[0])(13[0])(15[0])(17[0])(19[0])
// (19[0])(17[0])(15[0])(13[0])(11[0])(9[0])(7[0])(5[0])(3[0])(1[0])

// TransposeList deleting the other of half the nodes:

// TransposeList After second insert:

// (19[0])(18[0])(17[0])(16[0])(15[0])(14[0])(13[0])(12[0])(11[0])(10[0])(9[0])(8[0])(7[0])(6[0])(5[0])(4[0])(3[0])(2[0])(1[0])(0[0])
// (0[0])(1[0])(2[0])(3[0])(4[0])(5[0])(6[0])(7[0])(8[0])(9[0])(10[0])(11[0])(12[0])(13[0])(14[0])(15[0])(16[0])(17[0])(18[0])(19[0])
