package com.mphasis.main.cui;


import java.util.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

class Process{
    public Collection<String> getElements(){                        //Polymorphic return type Collection<String>
        LinkedList<String> data = new LinkedList<String>();

        data.add("A");
        data.add("B");
        data.add("C");
        data.add("D");
        data.add("E");

        data.set(2,"T");  //modifies
        data.add(3, "Z");  //Inserts

        return data;
    }
}

class Point{
    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Process process = new Process();
//        Collection<String> result = process.getElements();
//
////        for(String string:result){
////            System.out.println(string);
////        }
//        Iterator<String> iterator = result.iterator();
//
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        System.out.println("----------------------------------------");
//        if(result instanceof List){
//            List<String> list =(List)result;
//            ListIterator<String> listIterator = list.listIterator();
//
//            while(listIterator.hasNext()){
//                System.out.println((listIterator.next()));
//            }
//            System.out.println("-------------------------------------");
//            while(listIterator.hasPrevious()){
//                System.out.println((listIterator.previous()));
//            }
//        }
//        HashSet<Point> hashSet = new HashSet<Point>();
//
//        hashSet.add(new Point(2,4));  // We need to override the hashcode and equals method.
//        hashSet.add(new Point(2,4));
//
//        System.out.println(hashSet);

        HashMap<String,Integer> paymentDetails = new HashMap<String,Integer>();
        paymentDetails.put("David",10000);
        paymentDetails.put("Mathew",15000);
        paymentDetails.put("Allen",12000);
        paymentDetails.put("Tom",13000);
        paymentDetails.put("Joe",11000);

        Integer salary = paymentDetails.get("Tom");
        System.out.println(salary);

        Set<Map.Entry<String,Integer>> allPaymentDetails =  paymentDetails.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator =  allPaymentDetails.iterator();

//        while(iterator.hasNext()){
//            Map.Entry keyValue = iterator.next();
//            System.out.println("key: "+ keyValue.getKey()+ " , value: "+ keyValue.getValue());
//        }
        for(Map.Entry<String,Integer> entrySet:allPaymentDetails){
            System.out.println(entrySet.getKey()+" >>> "+entrySet.getValue());
        }

        Set<String> keys = paymentDetails.keySet();
        Iterator keyIterator = keys.iterator();

        while(keyIterator.hasNext()){
            String key = (String) keyIterator.next();
            System.out.println("key: "+key+", value: " +paymentDetails.get(key));
        }

    }
}
