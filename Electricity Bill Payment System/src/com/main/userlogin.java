package com.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class userlogin{
	
     
      //Login *       *      *      *
	static void userlogin() throws IOException, ClassNotFoundException {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter Email");
	String Email=sc.next();
	
	System.out.println("Enter Password");
	String Password=sc.next();
	//  write login code *
	
	 List<Signup > studentdata=new ArrayList<>();
     
     FileInputStream fis=new FileInputStream("sudentdtata.p");
     
     ObjectInputStream ois=new ObjectInputStream(fis);
     
     while(fis.available()>0){
    	 Signup  std=(Signup )ois.readObject();
         studentdata.add(std);
     }
     System.out.println("deserialzation");
     fis.close();
     ois.close();


     for(Signup  p:studentdata){
    	 if(Email.equals(p.email)&&Password.equals(p.Password)) {
    		 System.out.println("Login success");
    		 
    	 }else {
    		 System.out.println("User name not exsit, you need to SingUp First.");
    		 userSingUpn(); 
    	 }
         //System.out.println(p.name+" "+p.email+" "+p.Password+" "+p.add+" "+p.ID+" "+p.mobile);
     }
	
	
}
	 //Login *       *      *      *
	
	
    static void userSingUpn() throws IOException, ClassNotFoundException {
    	
    	List<Signup > sing=new ArrayList<>();
    	
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Enter Email");
    	String Email=sc.next();
    	
    	System.out.println("Enter Mobile");
    	String Mobile=sc.next();
    	System.out.println("Enter name");
    	String name=sc.next();
    	
    	System.out.println("Enter add");
    	String add=sc.next();
    	
    	System.out.println("Create your Password");
    	String Password=sc.next();
    	
    	sing.add( new Signup (Email,Mobile,name,add,Password));
    	
    	FileOutputStream fos=new FileOutputStream("sudentdtata.p");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        
        for(Signup  st:sing){
            oos.writeObject(st);
        }

        System.out.println("Now you need to Login");
       
        fos.close();
        oos.close();
        
        userlogin();
    }


	
}