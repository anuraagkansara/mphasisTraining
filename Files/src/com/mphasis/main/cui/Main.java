package com.mphasis.main.cui;

import java.io.*;


public class Main {
    static void p(String s) {
        System.out.println(s);
    }
    public static void main(String[] args) throws IOException {
        File f1 = new File("/java/COPYRIGHT");
        p("File Name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Abs Path: " + f1.getAbsolutePath());
        p("Parent: " + f1.getParent());
        p(f1.exists() ? "exists" : "does not exist");
        p(f1.canWrite() ? "is writeable" : "is not writeable");
        p(f1.canRead() ? "is readable" : "is not readable");
        p("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
        p(f1.isFile() ? "is normal file" : "might be a named pipe");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
        p("File last modified: " + f1.lastModified());
        p("File size: " + f1.length() + " Bytes");

        System.out.println("----------------------------------------------");

        String dirname = "/java";
        File f2 = new File(dirname);

        if (f2.isDirectory()) {
            System.out.println("Directory of " + dirname);
            String s[] = f2.list();

            for (int i=0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " is a directory");
                } else {
                    System.out.println(s[i] + " is a file");
                }
            }
        } else {
            System.out.println(dirname + " is not a directory");
        }

        System.out.println("----------------------------------------------");

//        int size = 0;
//        InputStream f = new FileInputStream("FileInputStreamDemo.java");
//
//        try {
//            System.out.println("Total Available Bytes: " + (size = f.available()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        int n = size/40;
//        System.out.println("First " + n +
//                " bytes of the file one read() at a time");
//        for (int i=0; i < n; i++) {
//            System.out.print((char) f.read());
//        }
//        System.out.println("\nStill Available: " + f.available());
//        System.out.println("Reading the next " + n +
//                " with one read(b[])");
//        byte b[] = new byte[n];
//        if (f.read(b) != n) {
//            System.err.println("couldn't read " + n + " bytes.");
//        }
//        System.out.println(new String(b, 0, n));
//        System.out.println("\nStill Available: " + (size = f.available()));
//        System.out.println("Skipping half of remaining bytes with skip()");
//        f.skip(size/2);
//        System.out.println("Still Available: " + f.available());
//        System.out.println("Reading " + n/2 + " into the end of array");
//        if (f.read(b, n/2, n/2) != n/2) {
//            System.err.println("couldn't read " + n/2 + " bytes.");
//        }
//        System.out.println(new String(b, 0, b.length));
//        System.out.println("\nStill Available: " + f.available());
//        f.close();

        System.out.println("-----------------------------------------------");

        String source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes.";
        byte buf[] = source.getBytes();
        OutputStream f0 = new FileOutputStream("file1.txt");
        for (int i=0; i < buf.length; i += 2) {
            f0.write(buf[i]);
        }
        f0.close();

        OutputStream f3 = new FileOutputStream("file2.txt");
        f3.write(buf);
        f3.close();

        OutputStream f4 = new FileOutputStream("file3.txt");
        f4.write(buf,buf.length-buf.length/4,buf.length/4);
        f4.close();

        System.out.println("---------------------------------------------");

        System.out.println("Here are some numeric values " +
                "in different formats.\n");

        System.out.printf("Various integer formats: ");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);

        System.out.println();

        System.out.printf("Default floating-point format: %f\n",
                1234567.123);
        System.out.printf("Floating-point with commas: %,f\n",
                1234567.123);
        System.out.printf("Negative floating-point default: %,f\n",
                -1234567.123);
        System.out.printf("Negative floating-point option: %,(f\n",
                -1234567.123);

        System.out.println();

        System.out.print("Line-up positive and negative values:\n");
        System.out.printf("% ,.2f\n% ,.2f\n",
                1234567.123, -1234567.123);

        System.out.println("------------------------------------------");

        FileOutputStream fout = new FileOutputStream("Test.dat");
        DataOutputStream out = new DataOutputStream(fout);

        out.writeDouble(98.6);
        out.writeInt(1000);
        out.writeBoolean(true);

        out.close();

        FileInputStream fin = new FileInputStream("Test.dat");
        DataInputStream in = new DataInputStream(fin);

        double d = in.readDouble();
        int i = in.readInt();
        boolean b = in.readBoolean();

        System.out.println("Here are the values:  " +
                d + " " + i + " " + b);

        in.close();

        System.out.println("------------------------------------------");

        String str;
        Console con;

        con = System.console();

        // If no console available, exit.
        if(con == null) return;

        str = con.readLine("Enter a string: ");
        con.printf("Here is your string: %s\n", str);

        System.out.println("------------------------------------------");

        String source1 = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes.";
        char buffer[] = new char[source1.length()];
        source1.getChars(0, source1.length(), buffer, 0);

        FileWriter fileWriter = new FileWriter("file1.txt");
        for (int j=0; j < buffer.length; j += 2) {
            fileWriter.write(buffer[j]);
        }
        fileWriter.close();

        FileWriter fileWriter1 = new FileWriter("file2.txt");
        fileWriter1.write(buffer);
        fileWriter1.close();

        FileWriter fileWriter2 = new FileWriter("file3.txt");

        fileWriter2.write(buffer,buffer.length-buffer.length/4,buffer.length/4);
        fileWriter2.close();

    }

}
