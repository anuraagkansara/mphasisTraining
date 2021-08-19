package com.mphasis.main.cui;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> result = new LinkedList<String>();

        // Add elements to the collection.
        result.add("B");
        result.add("C");
        result.add("D");
        result.add("X");
        result.add("Y");
        result.addLast("Z");
        result.addFirst("A");

        result.add(1, "A2");

        System.out.println("Original contents of result: " + result);

        // Remove elements from the collection.
        result.remove("F");
        result.remove(2);

        System.out.println("Contents of result after deletion: "
                + result);

        // Remove first and last elements.
        result.removeFirst();
        result.removeLast();

        System.out.println("result after deleting first and last: "
                + result);

        // Get and set a value.
        String val = result.get(2);
        result.set(2, val + " Changed");

        System.out.println("result after change: " + result);
        System.out.println("---------------------------------------------------------------");

        // Create and initialize linked list.
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);

        // Create a reverse order comparator.
        Comparator<Integer> r = Collections.reverseOrder();

        // Sort list by using the comparator.
        Collections.sort(ll, r);

        System.out.print("List sorted in reverse: ");
        for (int i : ll)
            System.out.print(i + " ");

        System.out.println();

        // Shuffle list.
        Collections.shuffle(ll);

        // Display randomized list.
        System.out.print("List shuffled: ");
        for (int i : ll)
            System.out.print(i + " ");

        System.out.println();

        System.out.println("Minimum: " + Collections.min(ll));
        System.out.println("Maximum: " + Collections.max(ll));

        System.out.println("---------------------------------------------------------------");

        ArrayList list = new ArrayList();

        // These lines store strings, but any type of object
        // can be stored.  In old-style code, there is no
        // convenient way restrict the type of objects stored
        // in a collection
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Iterator itr = list.iterator();
        while (itr.hasNext()) {

            // To retrieve an element, an explicit type cast is needed
            // because the collection stores only Object.
            String str = (String) itr.next(); // explicit cast needed here.

            System.out.println(str + " is " + str.length() + " chars long.");
        }

            System.out.println("----------------------------------------------------------------");

//             Create an array list.
        ArrayList<String> al = new ArrayList<String>();

        // Add elements to the array list.
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        // iterate through the list
        System.out.print("Original contents of al: ");

        Iterator<String> iterator = al.listIterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // Modify objects being iterated.
        ListIterator<String> litr = al.listIterator();
        while(litr.hasNext()) {
            String element = litr.next();
            litr.set(element + "+");
        }

        System.out.print("Modified contents of al: ");
        iterator = al.listIterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // Now, display the list backwards.
        System.out.print("Modified list backwards: ");
        while(litr.hasPrevious()) {
            String element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println("-------------------------------------------------");

        // initial size of 3 and increment of 2
        Vector<Integer> v = new Vector<>(3, 2);

        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " +
                v.capacity());

        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);

        System.out.println("Capacity after four additions: " +
                v.capacity());
        v.add(5);
        System.out.println("Current capacity: " +
                v.capacity());
        v.add(6);
        v.add(7);

        System.out.println("Current capacity: " +
                v.capacity());
        v.add(9);
        v.add(10);

        System.out.println("Current capacity: " +
                v.capacity());
        v.add(11);
        v.add(12);


        System.out.println("First element: " + v.firstElement());
        System.out.println("Last element: " + v.lastElement());

        if(v.contains(3))
            System.out.println("Collection contains 3.");

        // traverse through the elements in the collection.
        Iterator vE = v.iterator();

        System.out.println("\nElements in collection:");
        while(vE.hasNext())
            System.out.print(vE.next() + " ");
        System.out.println();
    }
}
