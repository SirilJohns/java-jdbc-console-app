package com.siril.jdbc.crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class App{
	public static void main(String[] args) {
		try {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Loading Successfull!!");
		String dburl="jdbc:mysql://localhost:3306/add_m14?user=root&password=mysqldb@1003";
		Connection con=DriverManager.getConnection(dburl);
		if(con!=null) {
			System.out.println("Connection created!!");
		}else {
			System.out.println("Try Again!!");
		}
		while(true) {
		System.out.println();
		System.out.println("1.Insert\n2.Update\n3.Delete\n4.View All records\n5.View profile\n6.Sort\n7.Exit");
		System.out.println();
		System.out.println("Please make a choice!!!");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:ProfileDAO.insert(con, sc);
		       break;
		case 2:ProfileDAO.update(con, sc);
		       break;
		case 3:ProfileDAO.delete(con, sc);
		       break;
		case 4:ProfileDAO.getProfiles(con);
		       break;
		case 5:ProfileDAO.getProfile(con,sc);
		       break;
		case 6:System.out.println("1.Name\n2.Id\n3.Contact\n4.Exit");
		       System.out.println("Please make a choice!!");
		       int choice1=sc.nextInt();
		          switch(choice1) {
		          case 1:ProfileDAO.sortName(con);
			               break;
		          case 2:ProfileDAO.sortAge(con);
			               break;
		          case 3:ProfileDAO.sortContact(con);
			               break;
		          case 4:System.out.println("Thank You!!");
		                 System.exit(0);
		        }
		case 7:System.out.println("Thank You!!");
               System.exit(0);      
		default:System.out.println("Invalid choice of Id!!");
		     }
           }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

