package com.training;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDetailsJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        EmployeeDetailsJDBC empDetailsObj = new EmployeeDetailsJDBC();
        Connection c = empDetailsObj.connectionObj();
        Statement s = c.createStatement();
        empDetailsObj.createTable(s, sc);
    }

    Connection connectionObj() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedetails", "postgres", "postgres");
    }

    void createTable(Statement s, Scanner sc) throws SQLException, InterruptedException {
        System.out.print("Enter table name : ");
        String tableName = sc.nextLine();
        String checkTableQuery = "SELECT to_regclass('" + tableName + "')";
        ResultSet resultSet = s.executeQuery(checkTableQuery);
        resultSet.next();
        String existingTable = resultSet.getString(1);
        if (existingTable == null) {
            String sqlQuery = "CREATE TABLE " + tableName;
            s.execute(sqlQuery);
            System.out.println("Table Created Successfully!");
            Thread.sleep(2000);
        }
    }
}
