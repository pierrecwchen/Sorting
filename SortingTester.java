//********************************************************************
//  SortingTester.java                 Author: Ching Wen Chen
//										ID: 102921
//
//  A driver class to test Sorting class and shows first 300 sorted
//	integers for each sorting algorithm. Insertion sort and bubble
//	sort will take lots of time for sorting 530,000 numbers.
//	If it takes too long, please use the WriteBin class to write
//	the other Integers.bin which contains less integers in it.
//********************************************************************

import java.io.*;
import java.lang.*;

public class SortingTester
{
	public static void main (String[] args) throws Exception
	{
		FileInputStream fis;
		DataInputStream dis;
		File afile = new File("Integers.bin");
		fis = new FileInputStream (afile);
		dis = new DataInputStream (fis);

		// check how many integers in the file.
		int howManyData = 0;
		System.out.println("Check the amount of elements....");
		try
		{
			while (true)
			{
				// Check how many data.
				int id = dis.readInt();
				howManyData++;
			}
		}
		catch (EOFException eof)
		{
			System.out.println("\nEnd-of-File >> Contains "+howManyData+" items\n");
		}

		// create arrays for store integers for each sorting algorithm.
		Integer[] binDataInsertion = new Integer[howManyData];
		Integer[] binDataMerge = new Integer[howManyData];
		Integer[] binDataQuick = new Integer[howManyData];
		Integer[] binDataBubble = new Integer[howManyData];
		Integer[] binDataHeap = new Integer[howManyData];

		fis = new FileInputStream (afile);
		dis = new DataInputStream (fis);

		// read binary file into an array
		int howManyS = 0;
		System.out.println("Reading data, Wait please......");
		try
		{
			while (true)
			{
				// read test data to 5 different arrays.
				int id = dis.readInt();
				binDataInsertion[howManyS] = new Integer(id);
				binDataMerge[howManyS] = new Integer(id);
				binDataQuick[howManyS] = new Integer(id);
				binDataBubble[howManyS] = new Integer(id);
				binDataHeap[howManyS] = new Integer(id);
				howManyS++;
			}
		}
		catch (EOFException eof)
		{
			System.out.println("\nEnd-of-File >> Contains "+howManyS+" items\n");
		}

		Sorting<Integer> sorting = new Sorting<Integer>();
		long startTime, stopTime;

		// Sorting the data by quick sort.
		System.out.println("Quick sort:");
		System.out.println();
		System.out.println("Quick sort has been started! Wait please.");
		System.gc( ); // do a garbage collection
		startTime = System.currentTimeMillis( ); // milliseconds
		sorting.quickSort(binDataQuick, 0 , binDataQuick.length-1);
		stopTime = System.currentTimeMillis( );
		System.out.println("Time used for quick sort (ms): " +
							(stopTime - startTime)); // Time used.
		System.out.println("The number of movements used to sort it by " +
			"quick sort:\t" + sorting.getCount() + " movements."); // Movements.
		System.out.println("Fisrt 300 sorted number:");
		for(int x = 0; x < 30; x++) // Display first 300 results.
		{
			for(int y = 0; y < 10; y++)
				System.out.print(binDataQuick[10*x+y] + "\t");
			System.out.println();
		}

		sorting.resetCount(); // reset counter.

		// Sorting the data by merge sort.
		System.out.println("\n\nMerge sort:");
		System.out.println();
		System.out.println("Merge sort has been started! Wait please.");
		System.gc( ); // do a garbage collection
		startTime = System.currentTimeMillis( ); // milliseconds
		sorting.mergeSort(binDataMerge, 0 , binDataMerge.length-1);
		stopTime = System.currentTimeMillis( );
		System.out.println("Time used for merge sort (ms): " +
							(stopTime - startTime)); // Time used.
		System.out.println("The number of movements used to sort it by " +
			"merge sort:\t" + sorting.getCount() + " movements."); // Movements.
		System.out.println("Fisrt 300 sorted number:");
		for(int x = 0; x < 30; x++) // Display first 300 results.
		{
			for(int y = 0; y < 10; y++)
				System.out.print(binDataMerge[10*x+y] + "\t");
			System.out.println();
		}

		sorting.resetCount(); // reset counter.

		// Sorting the data by heap sort.
		System.out.println("\n\nHeap sort:");
		System.out.println();
		System.out.println("Heap sort has been started! Wait please.");
		System.gc( ); // do a garbage collection
		startTime = System.currentTimeMillis( ); // milliseconds
		sorting.heapSort(binDataHeap);
		stopTime = System.currentTimeMillis( );
		System.out.println("Time used for heap sort (ms): " +
							(stopTime - startTime)); // Time used.
		System.out.println("The number of movements used to sort it by " +
			"heap sort:\t" + sorting.getCount() + " movements."); // Movements.
		System.out.println("Fisrt 300 sorted number:");
		for(int x = 0; x < 30; x++) // Display first 300 results.
		{
			for(int y = 0; y < 10; y++)
				System.out.print(binDataHeap[10*x+y] + "\t");
			System.out.println();
		}

		sorting.resetCount(); // reset counter.

		// Sorting the data by insertion sort.
		System.out.println("\n\nInsertion sort:");
		System.out.println();
		System.out.println("Insertion sort has been started! It will take a long period of time, wait please.");
		System.gc( ); // do a garbage collection
		startTime = System.currentTimeMillis( ); // milliseconds
		sorting.insertionSort(binDataInsertion);
		stopTime = System.currentTimeMillis( );
		System.out.println("Time used for insertion sort (ms): " +
							(stopTime - startTime)); // Time used.
		System.out.println("The number of movements used to sort it by" +
			"insertion sort:\t" + sorting.getCount() + " movements."); // Movements.
		System.out.println("Fisrt 300 sorted number:");
		for(int x = 0; x < 30; x++) // Display first 300 results.
		{
			for(int y = 0; y < 10; y++)
				System.out.print(binDataInsertion[10*x+y] + "\t");
			System.out.println();
		}

		sorting.resetCount(); // reset counter.

		// Sorting the data by bubble sort.
		System.out.println("\n\nBubble sort:");
		System.out.println();
		System.out.println("Bubble sort has been started! It will take a long period of time, wait please.");
		System.gc( ); // do a garbage collection
		startTime = System.currentTimeMillis( ); // milliseconds
		sorting.bubbleSort(binDataBubble);
		stopTime = System.currentTimeMillis( );
		System.out.println("Time used for bubble sort (ms): " +
							(stopTime - startTime)); // Time used.
		System.out.println("The number of movements used to sort it by " +
			"bubble sort:\t" + sorting.getCount() + " movements."); // Movements.
		System.out.println("Fisrt 300 sorted number:");
		for(int x = 0; x < 30; x++) // Display first 300 results.
		{
			for(int y = 0; y < 10; y++)
				System.out.print(binDataBubble[10*x+y] + "\t");
			System.out.println();
		}
	}
}