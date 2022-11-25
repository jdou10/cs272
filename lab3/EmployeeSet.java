//package CS272program.src;

import java.util.Arrays;

public class EmployeeSet {
	Employee[] data;
	int manyItems;

	/*public IntNode(int initialData, IntNode initialLink) {
		data = initialEntry;
		link = initialLink;
	}*/
	
	// 2. a no-argument constructor
	public static EmployeeSet() {
		final int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = new int[INITIAL_CAPACITY];
	}
	
	
	// 3. a copy constructor
	public EmployeeSet(Object obj) {
		if((obj != null) && (obj instanceof EmployeeSet)) {
			// Creates new instance of Location object
			EmployeeSet loc = (EmployeeSet) obj;
			this.data = loc.data;
			this.manyItems = loc.manyItems;
		}
	}
	
	// 4. returns the actual number of elements in this collection
	public int size() {
		return manyItems;
	}
	
	
	// 5. returns the capacity of this collection instance
	public int capacity() {
		return data.length;
	}
	
	
	// 6. a method add
	public void add(int element) {
		if (manyItems == data.length) {
			ensureCapacity((manyItems + 1) * 2);
		}
		
		data[manyItems] = element;
		manyItems++;
	}
	
	
	// 7. a method to remove from the collection the employee with the given employee no eno
	public boolean remove(int eno) {
		int index;
		for(index = 0; (index < manyItems) && (eno != data[index]); index++);
		
		if(index == manyItems)
			return false;
		else {
			manyItems--;
			data[index] = data[manyItems];
			return true;
		}
	}
	
	
	// 8. guarantees the capacity of the collection
	private void ensureCapacity(int minimumCapacity) {
		int[] biggerArray;
		if (data.length < minimumCapacity){
		  	biggerArray = new int[minimumCapacity];
		  	System.arraycopy(data, 0, biggerArray, 0, manyItems);
		 	data = biggerArray;
		}
	}
	
	
	// 9. check whether the collection contains an employee
	public boolean contains(int eno) {
		
	}
	
	
	// 10. main method to test the code
	public static void main(String[] args) {
		EmployeeSet employee = new Employee();
		employee.setName("Brown Mia");
		employee.setAge(32);
		int[] advisors = new int[1];
		advisors[0] = 1;
		employee.setAdvisors(advisors);
		employee.setNo(1.1E+09);
		employee.setState("MA");
		employee.setZip(1450);
		System.out.println(employee);		
	}

}
