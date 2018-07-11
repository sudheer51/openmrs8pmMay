package org.h2k.util;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		//3 digit random
		int i = 99+rnd.nextInt(100);
		System.out.println(i);
		
		//ASCII
		//random upper case
		
		char ch = (char)(65+rnd.nextInt(26));
		System.out.println(ch);
		
		ch = (char)(97+rnd.nextInt(26));
		System.out.println(ch);
		
	}
}
