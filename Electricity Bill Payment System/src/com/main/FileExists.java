//package com.main;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.*;
//
//public class FileExists {
//	public static List<Signup> transactionFile() {
//
//		List<Signup> tFile = new ArrayList<>();
//
//		File f = new File("Transactions.p");
//		boolean flag = false;
//		try {
//			if (!f.exists()) {
//				f.createNewFile();
//				flag = true;
//			}
//
//			if (flag) {
//				tFile =  new ArrayList<>();
//				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
//				oos.writeObject(tFile);
//
//				return tFile;
//
//			} else {
//
//				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
//				tFile = (List<Signup>) ois.readObject();
//				return tFile;
//
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//
//		return tFile;
//
//	}
//
//}
