package com.mphasis.main.cui;

class Point{
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
class Printer{
	public void print(int[] values){
		for(int value:values){
			System.out.println(value);
		}
	}
}
public class Main {

    public static void main(String[] args) {
	    int nums[];
	    nums = new int[5];

		nums[0] = 17;
		nums[1] = 51;
		nums[2] = 12;
		nums[3] = 13;

		System.out.println("Printing via for loop");
	    for(int counter=0;counter<nums.length;counter++)
            System.out.println(nums[counter]);

		System.out.println("Printing via method call");
		Printer printer = new Printer();
		printer.print(nums);

		//MULTIDIMENSIONAL ARRAY
//	    int[][] nums;
//	    nums = new int[5][3];
//
//	    nums[2][1] = 1;
//	    nums[4][1] = 8;
//
//	    for(int[] firstDim:nums){
//	    	for(int secDim:firstDim)
//				System.out.print(secDim);
//			System.out.println("");
//		}
		/**
		 * This is a Documentation comment example
		 */
		/*
		This is a multiline comment
		 */

		//REFERENCE TYPE ARRAY (3-stage process)
		Point[] points;
		points = new Point[5];

		points[2] = new Point(2,4);
		points[4] = new Point(3,6);

		for(Point point:points){
			System.out.println(point);
		}
    }
}
