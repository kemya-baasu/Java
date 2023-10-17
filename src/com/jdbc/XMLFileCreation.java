package com.jdbc;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class XMLFileCreation {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder=docFactory.newDocumentBuilder();
        Document document=docBuilder.newDocument();
        Element root=document.createElement("employeedetails");
        document.appendChild(root);
        System.out.print("Enter total number of employee details to be added : ");
        int empCount=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i <empCount ; i++) {
            Element employee= document.createElement("employee");
            root.appendChild(employee);
            employee.setAttribute("id",String.valueOf(i));
            //name
            System.out.print("Name : ");
            Element name=document.createElement("empName");
            name.appendChild(document.createTextNode(sc.nextLine()));
            employee.appendChild(name);
            //email
            System.out.print("Email : ");
            Element email=document.createElement("empEmail");
            email.appendChild(document.createTextNode(sc.nextLine()));
            employee.appendChild(email);
            //salary
            System.out.print("Salary : ");
            Element salary=document.createElement("empSalary");
            salary.appendChild(document.createTextNode(sc.nextLine()));
            employee.appendChild(salary);
            //designation
            System.out.print("Designation : ");
            Element designation=document.createElement("empDesignation");
            designation.appendChild(document.createTextNode(sc.nextLine()));
            employee.appendChild(designation);
            //address
            System.out.print("Address : ");
            Element address=document.createElement("empAddress");
            address.appendChild(document.createTextNode(sc.nextLine()));
            employee.appendChild(address);
        }

        TransformerFactory transformerFactory=TransformerFactory.newInstance();
        Transformer transformer= transformerFactory.newTransformer();
        DOMSource domSource=new DOMSource(document);
        StreamResult result=new StreamResult(new File("D:\\JavaPrograms\\src\\com\\jdbc\\XmlCreation.xml"));
        transformer.transform(domSource,result);
    }
}
