// Dou Jingru
// CS 272
// Lab 11
// 30 Novemeber 2021

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class hash_map {
   public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader("example_words.txt"));
      String line = "";
      HashMap<String, String> words = new HashMap<>();
      do {
         line = reader.readLine();
         if (line != null) {
            String[] splits = line.split("\t");
            words.put(splits[0], splits[1]);
         }
      } while (line != null);
         System.out.print("Please enter the word: ");
         Scanner scanner = new Scanner(System.in);
         String word = scanner.next();
         if (words.containsKey(word)) {
            System.out.println("The explanation is: " + words.get(word));
         } else {
            System.out.println("The word " + word + " is not exist");
         }
   } //end main
} // end class
