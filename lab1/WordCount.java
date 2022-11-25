package CS272program.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class WordCount {

	public static String[] read(String fname) {
		String text = "";
		String line = "";
		String[] words = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fname);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int l = 0;
			while ((line = bufferedReader.readLine()) != null) {
				text = text + " " + line;
				System.out.println("line number: " + l);
				System.out.println(line);
				l++;
			}
			// Tokenize the text
			StringTokenizer tokenizer = new StringTokenizer(text, " !\"#$%&'()*+,-./:;?@[\\]^_`{|}~");
			
			int num_tokens = tokenizer.countTokens();
			System.out.println("Total number of tokens found : " + num_tokens);
			words = new String[num_tokens];
			int c = 0;
			while (tokenizer.hasMoreTokens())
			{
				String word = tokenizer.nextToken();
				words[c] = word.toLowerCase();
				System.out.println(word);
				c++;
			}
			bufferedReader.close(); // Always close files.
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fname + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fname + "'");
		}
		return words;
	} // end read function
	
	public static void write(String fname, String[] words) {
		try {
			File file = new File(fname);

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("Total number of words: " + words.length + "\n");
			for (int i = 0; i < words.length; i++) {
				bw.write(words[i] + "\n");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Finish writing words to file " + fname);
	} // end write function
	
	public static void main(String[] args) {
		String[] words = read("test_doc.txt"); // read a text file
		write("words.txt", words); // write the words to a file
	}
}
