//********************************************************************
//  WriteBin.java                 Author: Ching Wen Chen
//										ID: 102921
//
//  A class to generate a binary file which contains the amount of
//	integers user decided.
//********************************************************************

import java.io.*;
import java.util.*;

public class WriteBin{

	public static void main(String args[]) throws FileNotFoundException, IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many integers you want to create?"); // Ask how many integers in .bin
		int x = scan.nextInt();

		// Write binary file with given amount.
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("Integers.bin"));
 		Random generator = new Random();
		System.out.println("Writing....");
        for (int i = 0; i < x; i++) {
            //Randomly write an integer
            dos.writeInt(generator.nextInt(x*5));
        }

        dos.close();
    }
}