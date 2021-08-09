package com.mphasis.main.cui;

class Box{
    double width;
    double height;
    double depth;

    //construct clone of an object
    Box(Box ob){
        //pass object to the constructor
    }
    //constructor used when all dimensions specified

    //constructor used when no dimensions specified
    Box(){
        width = -1;
        height = -1;
        depth = -1;
    }

    //constructor used when a cube is created
    Box(double len)
    {
        width=height=depth=len;
    }

    //compute and return volume

}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
