package com.jdbc;

import java.sql.*;

public class JoinUsingEmployeeDetails {
    public static void main(String[] args) throws SQLException {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Statement s = c.createStatement();
//        s.execute("create table copy_of_empdtls as select * from employeedetails");
//        s.execute("alter table employeedetails add constraint const unique(emp_email) ");
        ResultSet rs=s.executeQuery("select employeedetails.emp_id ,emp_name,reporting_id from employeedetails left outer join empmaprel on employeedetails.emp_id=empmaprel.emp_id order by emp_id Desc limit 1");
        while (rs.next()){
            System.out.print(rs.getString("emp_id")+"-------------"+rs.getString("emp_name")+"--------------");
            String query="select emp_name from employeedetails where emp_id="+rs.getString("reporting_id");
            Statement s1=c.createStatement();
            ResultSet r=s1.executeQuery(query);
//            while(r.next()) {
            r.next();
            System.out.println("Reporting to --> "+r.getString("emp_name"));
//            }
        }

        ResultSet r2=s.executeQuery("select emp_id,count(project_id) as total_projects from empprojrel group by emp_id having count(project_id) > 3");
        while (r2.next()) {
            System.out.println(r2.getString("emp_id") + "-------------" + r2.getString("total_projects") + "--------------");
        }

    }
}
