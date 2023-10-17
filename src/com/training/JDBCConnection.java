package com.training;
import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) throws SQLException {
        Connection c = null;
        Statement s=null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");

        } catch (Exception e) {
            System.out.println("Exception thrown while connecting DB : "+e);
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        s=c.createStatement();
        String showDBQuery = "SELECT * FROM pg_database";
        ResultSet rs=s.executeQuery(showDBQuery);
        while (rs.next()){
            String dB=rs.getString("datname");
            System.out.println(dB);
        }
//        String sqlQuery="Insert into EmployeeDetails(ID,Name,Salary) values(17372,'Kemya',5),(17368,Dinesh,6),(17717,Abarna,7)";
        try {
            s.execute("DROP DATABASE Training");
            System.out.println("Database 'Training' dropped successfully");
        } catch (SQLException e) {
            System.out.println("Error dropping database: " + e.getMessage());
        } catch(Exception e) {
        System.out.println("Exception thrown while connecting DB : " + e);
    }
//        s.execute("SHOW DATABASES");


//        p=c.prepareStatement();
    }
}
