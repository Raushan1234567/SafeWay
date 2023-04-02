package com.main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main extends userlogin{
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		Scanner sc=new Scanner(System.in);
		 System.out.println("For User Login Press-1, For User SingUp Press-2,For Admin Login Press-3");
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
			
			default :
				System.out.println("Invalid Input");
			Call();
	
		
	}

	

}
	
	public static void Call() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		 System.out.println("For User Login Press-1, For User SingUp Press-2,For Admin Login Press-3");
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
				default:
					System.out.println("Invalid Input");
					Call();
					break;
		
}
	}

	
}
