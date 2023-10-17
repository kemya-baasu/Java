package com.jdbc;

import java.sql.*;

public class Transactions {
    public static void main(String[] args) throws SQLException {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Statement s=c.createStatement();
        c.setAutoCommit(false);
        s.execute("update employeedetails set emp_designation='MTS' where emp_id=17372");
        Savepoint savePoint1=c.setSavepoint();
        s.addBatch("update employeedetails set emp_designation='PT' where emp_id=17368");
        s.addBatch("delete from employeedetails where emp_id=17368");
        int[] res= s.executeBatch();
        ResultSet rs= s.executeQuery("select * from employeedetails");
        while(rs.next()){
            System.out.println(rs.getString("emp_id")+"-----"+rs.getString("emp_designation"));
        }
        System.out.println("--------------");
        for (int r:res) {
            System.out.println("Result : "+r);
        }
//        c.commit();
        c.rollback(savePoint1);
        ResultSet result= s.executeQuery("select * from employeedetails");
        System.out.println("-------------------------");
        while(result.next()){
            System.out.println(result.getString("emp_id")+"-----"+result.getString("emp_designation"));
        }

    }
}
