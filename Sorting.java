//********************************************************************
//  Sorting.java                 Author: Ching Wen Chen
//									ID: 102921
//
//  A class contains quick sort, merge sort, insertion sort, bubble
//	sort, and heap sort algorithm. Also contains a counter to count
//	movements and available to reset it.
//********************************************************************

public class Sorting<T extends Comparable>
{
	private long count = 0;

   //  Sorts the specified array of objects using the quick sort
   //  algorithm.
   public void quickSort (T[] data, int min, int max){
      int indexofpartition;
      if (max - min  > 0)
      {
         // Create partitions
         indexofpartition = findPartition(data, min, max);

         // Sort the left side
         quickSort(data, min, indexofpartition - 1);

         // Sort the right side
         quickSort(data, indexofpartition + 1, max);
         count++;
      }
   }

   //  Used by the quick sort algorithm to find the partition.
   private int findPartition (T[] data, int min, int max)
   {
      int left, right;
      T partitionelement;

      partitionelement = data[min]; // use first element as partition
      left = min;
      right = max;

      while (left<right)
      {
         // search for an element that is > the partitionelement
         while (data[left].compareTo(partitionelement) <=0 &&
                            left < right){
            left++;
            count++;
         }

         // search for an element that is < the partitionelement
         while (data[right].compareTo(partitionelement) > 0){
         	right--;
         	count++;
         }
         // swap the elements
         if (left<right)
         	swap(data, left, right);
      }

      // move partition element to partition index
      swap(data, min, right);

      return right;
   }

   // Sorts the specified array of objects using the merge sort
   // algorithm.
   public void mergeSort (T[] data, int min, int max)
   {
      T[] temp;
      int index1, left, right;

      // return on list of length one
      if (min==max)
         return;

      // find the length and the midpoint of the list
      int size = max - min + 1;
      int pivot = (min + max) / 2;
      temp = (T[])(new Comparable[size]);
      mergeSort(data, min, pivot); // sort left half of list
      mergeSort(data, pivot + 1, max); // sort right half of list
      count++;

      // copy sorted data into workspace
      for (index1 = 0; index1 < size; index1++)
         temp[index1] = data[min + index1];

      // merge the two sorted lists
      left = 0;
      right = pivot - min + 1;
      for (index1 = 0; index1 < size; index1++)
      {
         if (right <= max - min)
            if (left <= pivot - min)
               if (temp[left].compareTo(temp[right]) > 0)
                  data[index1 + min] = temp[right++];

               else
                  data[index1 + min] = temp[left++];
            else
               data[index1 + min] = temp[right++];
         else
            data[index1 + min] = temp[left++];
         count++;
      }
   }

   //  Sorts the specified array of objects using a bubble sort
   //  algorithm.
   public void bubbleSort (T[] data)
   {
      int position, scan;

      for (position =  data.length - 1; position >= 0; position--)
      {
         for (scan = 0; scan <= position - 1; scan++)
         {
            if (data[scan].compareTo(data[scan+1]) > 0)
            {
               // Swap the values
               swap(data, scan, scan+1);
               count++;
            }
         }
      }
   }

   //  Sorts the specified array of objects using an insertion
   //  sort algorithm.
   public void insertionSort (T[] data)
   {
      for (int index = 1; index < data.length; index++)
      {
         T key = data[index];
         int position = index;

         // Shift larger values to the right
         while (position > 0 && data[position-1].compareTo(key) > 0)
         {
            data[position] = data[position-1];
            position--;
            count++;
         }

         data[position] = key;
      }
   }

   //  Sorts the specified array of objects using a heap sort
   //  algorithm.
   public void heapSort(T[] data){
   		// Heapify the array.
		for(int i = 1; i < data.length; i++){
			heapify(data, i);
		}
		// Sort the heap.
		for(int i = data.length-1; i>0; i--){
			swap(data, 0, i);// swap the largest value to the end of array.
			sortHeap(data, 0, i);
		}
	}

	// used to heapify an array.
	public void heapify(T data[], int p){
		// if the position is not the root.
		if(p>0){
			// compare to its parent, if child is bigger, swap the value and
			// keep compare to next parent.
			if(data[(p-1)/2].compareTo(data[p])<0){
				swap(data, (p-1)/2, p);
				heapify(data, (p-1)/2);
				count++;
			}
		}
	}

	// used to swap values in an array.
	public void swap(T data[], int x, int y){
		T temp = data[x];
		data[x] = data[y];
		data[y] = temp;
	}

	// used to sort a heap.
	public void sortHeap(T data[], int parent, int n){
		// if n is 2, we only compare to the root's left child because
		// right child is fixed.
		if(n == 2){
			if(data[2*parent+1].compareTo(data[parent])>0)
				swap(data, parent, 2*parent+1);
			count++;
		}
		// if n is 1, this method will do nothing; if n > 2, it will
		// compare to its left and right child to see which one(parent,
		// left child, right child) is biggest, if the biggest is not
		// parent, then choose the biggest child and swap it with parent,
		// and keep compare to next children.
		else if((2*parent+1) < n && (2*parent+2) < n){

			int x= data[2*parent+1].compareTo(data[parent]);
			int y = data[2*parent+2].compareTo(data[parent]);
			int z = data[2*parent+1].compareTo(data[2*parent+2]);
			if(z<0 && y>0){
				swap(data, parent, 2*parent+2);
				sortHeap(data, 2*parent+2, n);
				count++;
			}
			else if(z>=0 && x>0){
				swap(data, parent, 2*parent+1);
				sortHeap(data, 2*parent+1, n);
				count++;
			}
		}
	}

	public long getCount(){
		return count;
	}

	public void resetCount(){
		count = 0;
	}
}
