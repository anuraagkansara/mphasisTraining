package com.mphasis.main.cui;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1l;
    int id;
    String name;
    int age;
    transient int value;       //transient variable is not serializable
                               // its value is not saved into database.
    public Person(int id, String name, int age, int value) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", value=" + value +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {

//        FileOutputStream fos =null;  //.ser denotes file is being used for serializing purposes.
//        ObjectOutputStream oos = null;

        Person person = new Person(1, "Allen", 30, 10);

        try( FileOutputStream fileOutputStream = new FileOutputStream("ObjectStore.ser");  //if you give it inside try() no need to add finally
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream("ObjectStore.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            objectOutputStream.writeObject(person);         //Serialization

            Object object = objectInputStream.readObject(); //Deserialization

            if(object instanceof Person){
                Person person1 = (Person)object;
                System.out.println(person1);
            }

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
