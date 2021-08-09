package com.mphasis.main.cui;

class Box{
    double width;
    double height;
    double depth;

    //construct clone of an object
    Box(Box ob){
        //pass object to the constructor
        this.depth = ob.depth;
        this.height = ob.height;
        this.width = ob.width;
    }
    //constructor used when all dimensions specified
    Box(double width, double depth, double height){
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

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
    double volume(){
        return width*height*depth;
    }
}

class BoxWeight extends Box{
    double weight;
    //constructor for BoxWeight
    public BoxWeight(double width, double depth, double height, double weight) {
        super(width, depth, height);
        this.weight = weight;
    }

    BoxWeight(){
        super();
        weight = -1;
    }
    //constructor when cube is created
    BoxWeight(double len, double weight){
        super(len);
        this.weight = weight;
    }


    public BoxWeight(BoxWeight mybox1) {
        super(mybox1);
        this.weight = mybox1.weight;

    }
}

public class DemoBoxWeight {
    public static void main(String[] args){
        BoxWeight mybox1 = new BoxWeight(10,20,15,34.3);
        BoxWeight mybox2 = new BoxWeight(2,3,4,0076);
        double vol;

        vol = mybox1.volume();
        System.out.println("Volume of mybox1 is" + vol);
        System.out.println("Weight of mybox1 is" + mybox1.weight);
        System.out.println();

        vol = mybox2.volume();
        System.out.println("Volume of mybox2 is" + vol);
        System.out.println("Weight of mybox2 is" + mybox2.weight);
    }
}
