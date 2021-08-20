package com.mphasis.main.cui;

import sun.dc.pr.PRError;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //Register the Driver
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            //Establish the connection
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-3THRRN6:1521:orcl", "hr", "hrpass");
            System.out.println("Connected...");

            //Query the database
//            preparedStatement = connection.prepareStatement("SELECT FIRST_NAME,LAST_NAME FROM EMPLOYEES WHERE DEPARTMENT_id=?");
//            preparedStatement.setString(1, "50");

//            preparedStatement = connection.prepareStatement("INSERT INTO USERS2 VALUES(?,?,?,?,?) ");
//            preparedStatement.setInt(1, 6);
//            preparedStatement.setString(2, "Alex");
//            preparedStatement.setString(3, "John");
//            preparedStatement.setString(4, "1234");
//            preparedStatement.setString(5, "A");

            preparedStatement = connection.prepareStatement("UPDATE USERS2 SET STATUS = ? WHERE ID=?");
            preparedStatement.setString(1,"I");
            preparedStatement.setInt(2,1);

//            resultSet = preparedStatement.executeQuery();
            int rowsEffected = preparedStatement.executeUpdate();
            System.out.println(rowsEffected);

            connection.commit();// optional, auto-commits happen on program termination.

//            while(resultSet.next()){
//                System.out.println(resultSet.getString(1) + " "+ resultSet.getString(2));
//            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if(resultSet!=null && !resultSet.isClosed()){
                    resultSet.close();
                }
                if(preparedStatement!=null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
                if(connection!=null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
