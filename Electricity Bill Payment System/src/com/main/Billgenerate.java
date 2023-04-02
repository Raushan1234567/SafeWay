package com.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Billgenerate implements Serializable{
	String email;
	String mobile;
	String name;
	String add;
	int Unit;
	double Billamount;

	Billgenerate(){
		
	}


	Billgenerate (String email,String mobile,String name,String add,int Unit,double Billamount){
		this.email=email;
		this.mobile=mobile;
		this.name=name;
		this.add=add;
		this.Unit=Unit;
		this.Billamount=Billamount;
	
	}
}
