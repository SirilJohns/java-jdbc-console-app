package com.siril.jdbc.crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProfileDAO {
	/* method to insert records */
	public static void insert(Connection con,Scanner sc) {
		System.out.println("Enter Id :");
		int id=sc.nextInt();
		System.out.println("Enter name :");
		String name=sc.next();
		System.out.println("Enter age :");
		int age=sc.nextInt();
		System.out.println("Enter Contact No :");
		long contact=sc.nextLong();
		try {
			String query="INSERT INTO PROFILE(ID,NAME,AGE,CONTACT) VALUES(?,?,?,?)";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setLong(4, contact);
			int count=psmt.executeUpdate();
			if(count!=0) {
				System.out.println("Inserted!!!");
			}else {
				System.out.println("Try Again!!!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/* method to update records */
	public static void update(Connection con,Scanner sc) {
		System.out.println("Enter Name :");
		String name=sc.next();
		System.out.println("Enter Age : ");
		int age=sc.nextInt();
		System.out.println("Enter Contact No : ");
		long contact=sc.nextLong();
		System.out.println("Enter Id to Update records : ");
		int id=sc.nextInt();
		try {
			String query="UPDATE PROFILE SET NAME=?,AGE=?,CONTACT=? WHERE ID=?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1,name);
			psmt.setInt(2, age);
			psmt.setLong(3, contact);
			psmt.setInt(4, id);
			int count=psmt.executeUpdate();
			if(count!=0) {
				System.out.println("Updated!!!");
			}else {
				System.out.println("Try Again!!");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/* method to delete records */
	public static void delete(Connection con,Scanner sc) {
		System.out.println("Enter Id to delete");
		int id=sc.nextInt();
		try {
			String query="DELETE FROM PROFILE WHERE ID=?";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1,id);
			int count=psmt.executeUpdate();
			if(count!=0) {
				System.out.println("Data Deleted");
			}else {
				System.out.println("Try again");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/* method to read all the records */
	public static void getProfiles(Connection con) {
		try {
		String query="SELECT * FROM PROFILE";
		PreparedStatement psmt=con.prepareStatement(query);
		ResultSet rt=psmt.executeQuery(query); 
     	System.out.println("-----------------------------------------------------------------");
		System.out.println("Id\tName\t\t\tAge\t\t\tContact");
    	System.out.println("-----------------------------------------------------------------");
		while(rt.next()) { 
			int id=rt.getInt(1); 
			String name=rt.getString(2); 
			int age=rt.getInt(3); 
			String contact=rt.getString(4); 
			System.out.println(id+"\t"+name+"\t\t\t"+age+"\t\t\t"+contact);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/* method to read specific record */
    public static void getProfile(Connection con,Scanner sc) {
    	System.out.println("Enter Id to view");
    	int id=sc.nextInt();
    	try {
    		String query="SELECT ID,NAME,AGE,CONTACT FROM PROFILE WHERE ID=?";
    		PreparedStatement psmt=con.prepareStatement(query);
    		psmt.setInt(1, id);
    		ResultSet rt=psmt.executeQuery();
    		System.out.println("--------------------------------------------------------------------");
    		System.out.println("ID\tName\t\tAge\t\tContact");
    		System.out.println("--------------------------------------------------------------------");
    		while(rt.next()) { 
    			int dbid=rt.getInt(1);
    			String name=rt.getString(2); 
    			int age=rt.getInt(3); 
    			String contact=rt.getString(4); 
    			System.out.println(dbid+"\t"+name+"\t\t"+age+"\t\t"+contact);
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    /* method to sort records in ascending order */
    public static void sortName(Connection con) {
    	try {
    		String query="SELECT * FROM PROFILE ORDER BY NAME ASC";
    		PreparedStatement psmt=con.prepareStatement(query);
    		ResultSet rt=psmt.executeQuery(); 
    		System.out.println("-----------------------------------------------------------------");
    		System.out.println("ID\tName\t\tAgr\t\tContact");
    		System.out.println("-----------------------------------------------------------------");
    		while(rt.next()) {
    		    int dbid=rt.getInt(1);
    			String name=rt.getString(2); 
    			int age=rt.getInt(3); 
    			String contact=rt.getString(4); 
    			System.out.println(dbid+"\t"+name+"\t\t"+age+"\t\t"+contact);
    		}
    	}                                                                                                                                                                                                                                                                               
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void sortAge(Connection con) {
    	try {
    		String query="SELECT * FROM PROFILE ORDER BY AGE ASC";
    		PreparedStatement psmt=con.prepareStatement(query);
    		ResultSet rt=psmt.executeQuery();
    		System.out.println("--------------------------------------------------------------------");
    		System.out.println("ID\tName\t\tAge\t\tContact");
    		System.out.println("--------------------------------------------------------------------");
    		while(rt.next()) { 
    			int dbid=rt.getInt(1);
    			String name=rt.getString(2); 
    			int age=rt.getInt(3); 
    			String contact=rt.getString(4); 
    			System.out.println(dbid+"\t"+name+"\t\t"+age+"\t\t"+contact);
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void sortContact(Connection con) {
    	try {
    		String query="SELECT * FROM PROFILE ORDER BY CONTACT ASC";
    		PreparedStatement psmt=con.prepareStatement(query);
    		ResultSet rt=psmt.executeQuery();
    		System.out.println("--------------------------------------------------------------------");
    		System.out.println("ID\tName\t\tAge\t\tContact");
    		System.out.println("--------------------------------------------------------------------");
    		while(rt.next()) { 
    			int dbid=rt.getInt(1);
    			String name=rt.getString(2); 
    			int age=rt.getInt(3); 
    			String contact=rt.getString(4); 
    			System.out.println(dbid+"\t"+name+"\t\t"+age+"\t\t"+contact);
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
