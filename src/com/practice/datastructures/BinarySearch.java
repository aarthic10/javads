package com.practice.datastructures;

class BinarySearch {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// -----------------------------------------------------------

	public BinarySearch(int max) // constructor
	{
		a = new long[max]; // create array
		nElems = 0;
	}

	// -----------------------------------------------------------
	public int size() {
		return nElems;
	}

	// -----------------------------------------------------------
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int mid;
		while (true) {
			mid = (lowerBound + upperBound) / 2;
			if (a[mid] == searchKey)
				return mid; // found it
			else if (lowerBound > upperBound)
				return nElems; // can’t find it
			else // divide range
			{
				if (a[mid] < searchKey)
					lowerBound = mid + 1; // it’s in upper half
				else
					upperBound = mid - 1; // it’s in lower half
			} // end else divide range
		} // end while
	} // end find()
		// -----------------------------------------------------------

	public void insert(long value) // put element into array
	{
		int j;
		for (j = 0; j < nElems; j++) // find where it goes
			if (a[j] > value){
				break;
			}
		for (int k = nElems; k > j; k--){
			a[k] = a[k - 1];
		}
			
		a[j] = value;
		nElems++;
	}
		// -----------------------------------------------------------

	public boolean delete(long value) {
		int j = find(value);
		if (j == nElems) // can’t find it
			return false;
		else // found it
		{
			for (int k = j; k < nElems; k++) // move bigger ones down
				a[k] = a[k + 1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()
		// -----------------------------------------------------------

	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}
	// -----------------------------------------------------------
}
