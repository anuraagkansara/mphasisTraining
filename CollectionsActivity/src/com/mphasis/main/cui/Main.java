package com.mphasis.main.cui;

public class Main {

    public static void main(String[] args) {

        xxxxx<String> result = new xxxxx<String>();

        // Add elements to the collection.
        result.xxxxxx("B");
        result.xxxxxx("C");
        result.xxxxxx("D");
        result.xxxxxx("X");
        result.xxxxxx("Y");
        result.xxxxxxxxx("Z");
        result.xxxXxxxxxx("A");

        result.xxxxxxxx(1, "A2");

        System.out.println("Original contents of result: " + result);

        // Remove elements from the collection.
        result.xxxxxxxxxx("F");
        result.xxxxxxxxxx(2);

        System.out.println("Contents of result after deletion: "
                + result);

        // Remove first and last elements.
        result.xxxxxxxxxxxxx();
        result.xxxxxxxxxxxxx();

        System.out.println("result after deleting first and last: "
                + result);

        // Get and set a value.
        String val = result.xxxxxxxx(2);
        result.xxxxxxx(2, val + " Changed");

        System.out.println("result after change: " + result);
    }
}
