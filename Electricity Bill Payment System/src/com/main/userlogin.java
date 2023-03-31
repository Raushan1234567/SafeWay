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
	
     
      //Login.....................................................
	static void userlogin() throws IOException, ClassNotFoundException {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter Email");
	String Email=sc.next();
	
	System.out.println("Enter Password");
	String Password=sc.next();
	
	
	
	//Deserialization Start from here.................................................
	 List<Signup > data=new ArrayList<>();
     
     FileInputStream fis=new FileInputStream("data.p");
     
     ObjectInputStream ois=new ObjectInputStream(fis);
     
     while(fis.available()>0){
    	 Signup  std=(Signup )ois.readObject();
    	 data.add(std);
     }

     fis.close();
     ois.close();


     for(Signup  p:data ){
    	 if(Email.equals(p.email)&&Password.equals(p.Password)) {
    		 System.out.println("Login success");
    		 System.out.println("For Check Your Bill Details-1, For Check Your Transaction History-2");
    		
    		 int b=sc.nextInt();
    		 switch(b) {
    		 case 1 :
    		 billcheck();
    		 case 2 :
    			 Transaction();
    			 default :
    				 System.out.println("Invalid Input");
    		 }
    		 
    	 }else {
    		 System.out.println("User name not exsit, you need to SingUp First.");
    		 userSingUpn(); 
    	 }
         
    	 
     }
	
	
}
	
	
	private static void Transaction() {
		// TODO Auto-generated method stub
		
	}


	private static void billcheck() {
		// TODO Auto-generated method stub
		
	}


	//Signup.....................................
    static void userSingUpn() throws IOException, ClassNotFoundException {
    	
    	List<Signup > sing=new ArrayList<>();
    	
    	
    	
    	 FileInputStream fis=new FileInputStream("data.p");
         
         ObjectInputStream ois=new ObjectInputStream(fis);
         
         while(fis.available()>0){
        	 Signup  std=(Signup )ois.readObject();
        	 sing.add(std);
         }
         
         
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
    	
    	
  //  	Serialization start from hare..............................................
    	
    	FileOutputStream fos=new FileOutputStream("data.p");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        
        for(Signup  st:sing){
            oos.writeObject(st);
        }

        System.out.println("Now you need to Login");
       
        fos.close();
        oos.close();
        
userlogin();
       
		System.out.println("For User Login Enter-1, For User SingUp Enter-2,For Admin Login type-3");
		int a=sc.nextInt();
		switch(a){
		case 1:
			userlogin();
			
			break;
		case 2:
			userSingUpn();
			
			break;
		case 3:
			AdminLogin();
			
			break;
		}
	
    }
    
    public static void AdminLogin(){
    	
    	String userid="Admin";
    	String password="123456";
    	System.out.println("Welcome to Safe Way,Made your life easier");
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Enter User Id");
    	String user=sc.next();
    	
    	System.out.println("Enter Password");
    	String Pass=sc.next();
    	
    	if(userid.equals(user)&&password.equals(Pass)) {
    		 System.out.println("Login success");
    	}
    	else{
    		System.out.println("Something Went Wrong");
    	}
    }


	
}