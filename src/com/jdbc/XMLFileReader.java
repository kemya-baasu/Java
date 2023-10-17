package com.jdbc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class XMLFileReader {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("D:\\JavaPrograms\\src\\com\\jdbc\\XmlCreation.xml");
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        updateElementByID(document, root, 1);
        readXmlDataById(root, 1);
//        delete(document,root, 4);
        readAllDataFromXMLFile(root);
        System.out.println(nextId(root));
        insert(root,document);
    }

    public static void readAllDataFromXMLFile(Element root) {
        NodeList nodeList = root.getElementsByTagName("employee");
        System.out.println(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            printElements(node);
        }

    }

    public static void readXmlDataById(Element root, int id) {
        Node node = root.getElementsByTagName("employee").item(id);
        printElements(node);
    }

    public static void updateElementByID(Document document, Element root, int id) throws TransformerException {
        Element node = (Element) root.getElementsByTagName("employee").item(id);
        Node salary = node.getElementsByTagName("empSalary").item(0);
        salary.setTextContent("60000");
        printToXMLFile(document);

    }

    public static void delete(Document document,Element root, int id) throws TransformerException {
        Element childNode = (Element) getElementById(root,id);
        if(childNode==null){
            System.out.println("No Record Present in the Specified ID");
        }
        else {
            Node parentNode = childNode.getParentNode();
            parentNode.removeChild(childNode);
            printToXMLFile(document);
        }
    }

    public static void insert(Element root,Document document) throws TransformerException {
        long i=nextId(root);
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
        printToXMLFile(document);
    }

    public static void printElements(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println("Employee ID          |      " + element.getAttribute("id"));
            System.out.println("Employee Name        |      " + element.getElementsByTagName("empName").item(0).getTextContent());
            System.out.println("Employee Email       |      " + element.getElementsByTagName("empEmail").item(0).getTextContent());
            System.out.println("Employee Designation |      " + element.getElementsByTagName("empDesignation").item(0).getTextContent());
            System.out.println("Employee Salary      |      " + element.getElementsByTagName("empSalary").item(0).getTextContent());
            System.out.println("Employee Address     |      " + element.getElementsByTagName("empAddress").item(0).getTextContent());
            System.out.println("----------------------------x---------------------x-----------------------");
        }
    }

    public static void printToXMLFile(Document document) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult result = new StreamResult(new File("D:\\JavaPrograms\\src\\com\\jdbc\\XmlCreation.xml"));
        transformer.transform(domSource, result);
    }

    public static Node getElementById(Element root, int id) {
        Element element = null;
        NodeList nodeList = root.getElementsByTagName("employee");
        for (int i = 0; i < nodeList.getLength(); i++) {
            element = (Element) nodeList.item(i);
            System.out.println(element.getAttribute("id")+"---"+String.valueOf(id));
            if (String.valueOf(id).equals(element.getAttribute("id"))) {
                return element;
            }
        }
        element=null;
        return element;

    }
    public static long nextId(Element root){
        long newId=1;
        NodeList nodeList = root.getElementsByTagName("employee");
        for (int i = 1; i < nodeList.getLength(); i++) {
           Element element = (Element) nodeList.item(i);
            if(Integer.parseInt(element.getAttribute("id"))>newId)
                newId = Integer.parseInt(element.getAttribute("id"));
        }
        return newId+1;
    }
}
