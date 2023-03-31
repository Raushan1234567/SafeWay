package com.main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main extends userlogin{
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		Scanner sc=new Scanner(System.in);
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

	

}
