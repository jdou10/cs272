// Dou Jingru
// CS 272
// Lab 10
// 8 Novemeber 2021

import java.util.*;

public class gcd {
    
   // question 1a and b
   
   // function definiton
   public static int gcd(int a,int b) {
      /* Pre: a>b i b>=0*/
      /* Post: gcd(a,b) = GCD(a,b)*/
      if (b != 0){
         return gcd(b, a % b);
      } else {
         return a;
      }
   }
   
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter first number: ");
      int num1 = scan.nextInt(); 
      System.out.println("Enter second number: ");
      int num2 = scan.nextInt(); 
      System.out.print("GCD of given two numbers is: " + gcd(num1, num2));
   } // end main
} // end class
