package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class SqlInjection {
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException, SQLException {
        Scanner sc = new Scanner(System.in);
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        SqlInjection obj=new SqlInjection();
        obj.hackableSqlQuery(c);
        obj.nonHackableSqlQuery(c);
        //Callable Statement(used to run stored procedures) --------
        CallableStatement totalFunc = c.prepareCall("{? = call totalRecords() }");
        totalFunc.registerOutParameter(1, Types.INTEGER);
//        upperFunc.setString(2, "lowercase to uppercase");
        totalFunc.execute();
        Integer totalRecords = totalFunc.getInt(1);
        System.out.println(totalRecords);
        totalFunc.close();

        //Statement ---------------
        Statement s=c.createStatement();
        boolean a=s.execute("update employeedetails set emp_salary=25000 where emp_name='Kemya'");// used in DML(boolean return indicates query is DQL cmd)
        System.out.println(a);
        c.close();
        s.close();
    }

    void hackableSqlQuery(Connection c) throws SQLException, InterruptedException {
        Statement s = c.createStatement();
        System.out.println("!!!!!!!!!!!!!!  Trying to Hack Data  ------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //Thread.sleep(3000);
        System.out.println("Need credentials to fetch your salary details ---------");
        String name = "k";
        System.out.println("Enter name : " + name);
        String emp_ID = "1 or 1=1";
        System.out.println("Enter Employee ID : " + emp_ID);
        String stmt = "select emp_salary from employeedetails where emp_name='" + name + "'" + " and emp_id=" + emp_ID;
        System.out.println(stmt);
        ResultSet rs = s.executeQuery(stmt);// used for DQL commands
        while (rs.next()) {
            System.out.println(rs.getString("emp_salary"));
        }
        s.close();
    }
    void nonHackableSqlQuery(Connection c) throws  SQLException {
        System.out.println("!!!!!!!!!!!!!!  Trying to Hack Data while using Prepared Statement ------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
       // Thread.sleep(3000);
        System.out.println("Need credentials to fetch your salary details ---------");
        String name = "k";
        System.out.println("Enter name : " + name);
        String empDesignation = "1 or 1=1";
        System.out.println("Enter Employee ID : " + empDesignation);
        String stmt = "select emp_salary from employeedetails where emp_name= ? and emp_designation=?";
        PreparedStatement s=c.prepareStatement(stmt,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//prepared statement prevents sql injection
        s.setString(1,name);
        s.setString(2,empDesignation);
        System.out.println(s);
        ResultSet rs = s.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("emp_salary"));
        }
    }
}
