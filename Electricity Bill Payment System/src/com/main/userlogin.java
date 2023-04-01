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
    		 break;
    		 case 2 :
    			 Transaction();
    			 break;
    			 default :
    				 System.out.println("Invalid Input");
    				 break;
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
    	
    	if(Email.length()<4)
    	{
    	  System.out.println("Not valid");
    	  System.out.println("Enter again");
    	  Email=sc.next();
    	}
    	
    	System.out.println("Enter Mobile");
    	String Mobile=sc.next();
    	
    	if(Mobile.length()<10)
    	{
    	  System.out.println("Not valid");
    	  System.out.println("Enter again");
    	  Mobile=sc.next();
    	}
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
    
    public static void AdminLogin() throws IOException, ClassNotFoundException{
    	
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
    		 System.out.println("For View all customer press-1, For Update Press-2,For Delete-3");
    		 
    		 int b=0;
    		 b=sc.nextInt();
    		 switch(b) {
    		 case 1:
    			 List<Signup > sing=new ArrayList<>();
     	    	
     	    	
     	    	
            	 FileInputStream fis=new FileInputStream("data.p");
                 
                 ObjectInputStream ois=new ObjectInputStream(fis);
                 
                 while(fis.available()>0){
                	 Signup  std=(Signup )ois.readObject();
                	 sing.add(std);
                 }
                 for(Signup  p:sing){
                     System.out.println("Name"+" " +p.name+" "+"EmailAddress"+" "+p.email+" "+"Mobile no"+" "+p.mobile+" "+"Address" +" "+p.add);
                 }
                 break;
                 
    		 case 2:
    			 CustomerUpdate();
    			 break;
    		 
    		 case 3:
    			 DleteCutomer();
    			 
    		 }
    		
    	}
    	else{
    		System.out.println("Something Went Wrong");
    	}
    }


	private static void DleteCutomer() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Entter Email of Customer to delete");
		 String EmailDelete=sc.next(); 
		 List<Signup > sing=new ArrayList<>();
	    	
	    	
	    	 FileInputStream fis=new FileInputStream("data.p");
       
       ObjectInputStream ois=new ObjectInputStream(fis);
         
         while(fis.available()>0){
        	 Signup  std=(Signup )ois.readObject();
        	 sing.add(std);
         }
        

         
         FileOutputStream fos=new FileOutputStream("data.p");
         ObjectOutputStream oos=new ObjectOutputStream(fos);
         boolean s=false;
         for(Signup  st:sing){
        	
        	 if(st.email.equals(EmailDelete)){
                s=true;
        	 }else{
             oos.writeObject(st);
             
         }
        	 
         }
         if(!s) {
        	 System.out.println("Customer not exist");
        	 DleteCutomer() ;
         }else {
        	 System.out.println("Deleted Successfully"); 
         }
		
	}


	private static void CustomerUpdate() {
		// TODO Auto-generated method stub
		
	}


	
}