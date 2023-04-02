package com.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
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

boolean t=false;
     for(Signup  p:data ){
    	
    	 if(Email.equals(p.email)&&Password.equals(p.Password)) {
    		 t=true;
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
    		 
    	 }
         
    	 
     }
     if(t==false) {
    	  System.out.println("User name not exsit, you need to SingUp First.");
		 userSingUpn(); 
     }
		
	 
	
}
	
	
	private static void Transaction() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 List<Billgenerate> gen=new ArrayList<>();
	     
	     FileInputStream fis=new FileInputStream("userdata.p");
	     
	     ObjectInputStream ois=new ObjectInputStream(fis);
	     
	     while(fis.available()>0){
	    	 Billgenerate  std=(Billgenerate) ois.readObject();
	    	 gen.add(std);
	     }
	     LocalDateTime now = LocalDateTime.now();
	     for(Billgenerate p:gen) {
	    	System.out.println("******************Bill Deatails*******************************");
	    	System.out.println( "Name"+" "+p.name+" "+"EmailAddress"+" "+p.email+" "+"Mobile no"+" "+p.mobile+" "+"Address" +" "+p.add+" "+p.Unit+"\n"+p.Billamount+"\n"+now); 
	    	
	     }
	     
	     fis.close();
	     ois.close();
	}


	private static void billcheck() throws IOException, ClassNotFoundException {
//		Scanner sc=new Scanner(System.in);
//		String Email;
//		System.out.println("Enter Your Email");
//		Email=sc.next();
// List<Billgenerate> gen=new ArrayList<>();
//	     
//	     FileInputStream fis=new FileInputStream("userdata.p");
//	     
//	     ObjectInputStream ois=new ObjectInputStream(fis);
//	     
//	     while(fis.available()>0){
//	    	 Billgenerate  std=(Billgenerate) ois.readObject();
//	    	 gen.add(std);
//	     }
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		int b=(int) (Math.random()*100);
		System.out.println("Your bill unit is - "+b);
		int c=b*7;
		System.out.println("Your bill unit is - "+c);
		System.out.println();
		System.out.println("For Payment Now press 1");
		int p=sc.nextInt();
		if(p==1) {
			List<Integer > arr=new ArrayList<>();
			arr.add(c);
			
			FileOutputStream fos=new FileOutputStream("Bill.p");
	        ObjectOutputStream oos=new ObjectOutputStream(fos);
	        
	        for(Integer  st:arr){
	            oos.writeObject(st);
	        }
	       
	        fos.close();
	        oos.close();
			System.out.println(" Payment Successful");
			Payment();
		}
	}


	private static void Payment() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("For Check Your Bill Details-1, For Check Your Transaction History-2");
 		Scanner sc=new Scanner(System.in);
 		int b;
		  b=sc.nextInt();
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
    	
    	System.out.println("Create Unique  Password");
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
       
		System.out.println("For User Login Press-1, For User SignUp Press-2,For Admin Login Press-3");
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
    		
    		
    		 againadmin();

    		 
    	}
    	else{
    		System.out.println("Something Went Wrong");
    	}
    }


	private static void againadmin() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stubSystem.out.println("For View all customer press-1, For Update Press-2,For Delete Press-3,For Logout Press-4");
		 System.out.println("For View all customer press-1, For Update Press-2,For Delete Press-3,For Logout Press-4");
		 Scanner sc=new Scanner(System.in);
		 int b=0;
		 b=sc.nextInt();
		 switch(b) {
		 case 1:
			 ViewCuctomer();
			 
			
            break;
//view bill........................................................
		 case 2:
			 bill d=new bill();
			 d.viewbill();
			 break;
		 
		 case 3:
			 DleteCutomer();
			 AdminLogin();
			 break;
		 case 4:
			System.out.println("Log Out Successfully");
			Main p=new Main();
			p.Call();
			 break;
			 default:
				 System.out.println("Invalid Output");
		 }
		 againadmin();
	}


	private static void ViewCuctomer() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
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
        
	}


	private static void DleteCutomer() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Email of Customer to delete");
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
     	 againadmin();
         }else {
        	 System.out.println("Deleted Successfully"); 
        	 againadmin();
         }
		
	}


	private static void CustomerUpdate() {
		// TODO Auto-generated method stub
		
	}


	
}