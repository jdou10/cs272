package CS272program.src;

// Dou Jingru
// CS 272
// Lab 1
// 01 september 2021

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class Welcome2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Java");
		
		System.out.println(System.currentTimeMillis());
		
		try {
			sum();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//test sum()
		
	}

	public static void sum() throws IOException {
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int lineno = 1;
		
		String s = br.readLine();
		//int number = Integer.parseInt(s);
		System.out.println(s);
	}
	
	public static void readTestCase(String s) throws IOException { BufferedReader inputStream = new BufferedReader(new FileReader(s));
		String line;
	
		int lineno = 1;
		while((line = inputStream.readLine()) != null) {
			String[] numbers = line.split(" ");
			System.out.println("Line " + (lineno++) + " parameters:");
			for(int i = 0; i < numbers.length; i++)
				System.out.print(numbers[i] + " ");
			System.out.println();
		}
		inputStream.close();
	}
}
