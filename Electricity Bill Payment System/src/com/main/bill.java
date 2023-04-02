//package com.main;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class bill implements Serializable{
//
//    	public static void viewbill() throws IOException, ClassNotFoundException{
//        List<Billgenerate> gen=new ArrayList<>();
//        FileInputStream fis=new FileInputStream("data.p");
//        
//        ObjectInputStream ois=new ObjectInputStream(fis);
//        
//        while(fis.available()>0){
//        	Billgenerate  std=(Billgenerate )ois.readObject();
//       	 gen.add(std);
//        }
//Scanner sc=new Scanner(System.in);
//    	
//    	System.out.println("Enter Email");
//    	String Email=sc.next();
//    	
//    	if(Email.length()<4)
//    	{
//    	  System.out.println("Not valid");
//    	  System.out.println("Enter again");
//    	  Email=sc.next();
//    	}
//    	
//    	System.out.println("Enter Mobile");
//    	String Mobile=sc.next();
//    	
//    	if(Mobile.length()<10)
//    	{
//    	  System.out.println("Not valid");
//    	  System.out.println("Enter again");
//    	  Mobile=sc.next();
//    	}
//    	System.out.println("Enter name");
//    	String name=sc.next();
//    	
//    	System.out.println("Enter add");
//    	String address=sc.next();
//    	
//    	
//    	
//    	
//        
//       System.out.println("Enter unit");
//       int unit=sc.nextInt();
//       System.out.println("Enter Amount");
//       double amount=sc.nextInt();
//       
//       System.out.println("Enter last date to payment");
//       String date=sc.next();
//        
//       
//       gen.add( new Billgenerate (Email,Mobile,name,address,unit,amount));
//
//        FileOutputStream fos=new FileOutputStream("sudentdtata.p");
//        ObjectOutputStream oos=new ObjectOutputStream(fos);
//        for(Billgenerate st:gen){
//            oos.writeObject(st);
//        }
//
//        System.out.println("serialized");
//       
//        fos.close();
//        oos.close();
//        
//    }
//    
//
//	
//}
