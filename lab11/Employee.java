// Dou Jingru
// CS 272
// Lab 11
// 30 Novemeber 2021

import java.util.Arrays;
import java.util.LinkedHashSet;

// 1. implement the class that contains the following instance variables
public class Employee implements Cloneable{
   private String name;
	private int no;
	private int age;
	private String state;
	private int zip_code;
	private int[] advisors;

	// (1) no-argument constructor
	public Employee() {
		this.name = null;
		this.no = 0;
		this.age = 0;
		this.state = null;
		this.zip_code = 0;
		this.advisors = null;
	}
	
	// (2) one copy constructor
	public Employee(Object obj) {
		Employee employee = (Employee) obj;
		this.name = employee.name;
		this.no = employee.no;
		this.age = employee.age;
		this.state = employee.state;
		this.zip_code = employee.zip_code;
		
		if(employee.advisors != null) {
			this.advisors = new int[employee.advisors.length];
			System.arraycopy(employee.advisors, 0, this.advisors, 0, employee.advisors.length);
		} else {
			this.advisors = null;
		}
	}
	
	// (3) the clone method
	public Employee clone() {   
		// Clone employee.
		Employee employee;
		try {
    		employee = (Employee)super.clone();		
    		employee.name = this.name;
    		employee.no = this.no;
    		employee.age = this.age;
    		employee.state = this.state;
    		employee.zip_code = this.zip_code;
    		if(this.advisors != null) {
    			employee.advisors = new int[this.advisors.length];
    			for(int i = 0;i < this.advisors.length; ++i) {
    				employee.advisors[i] = this.advisors[i];
    			}
    		}else {
    			employee.advisors = null;
    		}
		} catch (CloneNotSupportedException e){ 
			System.out.println(e.getMessage());
         throw new RuntimeException
			("This class does not implement Cloneable");
		}
		return employee;
	}
	
	// (4) the get method
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public int getNo() {
		return no;
	}
	public int getZip_code() {
		return zip_code;
	}
	public int[] getAdvisors() {
		return advisors;
	}
	public String getState() {
		return state;
	}
	
	// (4) the set method
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public void setAdvisors(int[] nums) {
		this.advisors = new int[nums.length];
		System.arraycopy(nums, 0, this.advisors, 0, nums.length);
	}
	public void setState(String state) {
		this.state = state;
	}
	
	// (5) the toString method
	public String toString() {
		return "Employee {" + "name = '" + name + "\'" + ", no = " 
				+ no +", age = " + age + ", state = '" 
				+ state + "\'" + ", zip_code = " + zip_code + ", advisors = " 
				+ Arrays.toString(advisors) + '}';
	}
	
	// (6) the equals method
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee employee = (Employee)obj;
			return(employee.no == no);
		}
		else
			return false;
	}
	
	// (7) the static method to all the distinct advisors
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		LinkedHashSet<Integer> advisors = new LinkedHashSet<Integer>();
		if(e1 != null && (e1.advisors != null)) {
			for (int i = 0; i < e2.advisors.length; ++i) {
				advisors.add(e2.advisors[i]);
			}
		}
		int[] res = new int[advisors.size()];
				int i = 0;
		for(Integer num:advisors) {
			res[i++] = num;
		}
		return res;
	}
	
	// (8) the main method to test the entire code
	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setName("Alpha");
		employee.setAge(12);
		int[] advisors = new int[2];
		advisors[0] = 1;
		advisors[1] = 2;
		employee.setAdvisors(advisors);
		employee.setNo(6);
		employee.setState("Las Cruces");
		employee.setZip_code(88011);
		System.out.println(employee + "\n");
      
      // test the clone methods
      try {
            Employee copy = employee.clone();
            copy.setName("Bravo");
            System.out.println("This is the test of clone methods.");
            System.out.println(copy);
            System.out.println(employee);
      } catch (RuntimeException cloneNotSupportedException) {
            System.out.println(cloneNotSupportedException.getMessage());
        }
       Employee person = new Employee(employee);
       
       System.out.println(" ");
       
        // test the equal methods
        System.out.println("This is test of the equal methods.");
        if(person.equals(employee)) {
            System.out.println("The person is equal to employees.");
        }
        person.setNo(123);
        if(person.equals(employee)) {
            System.out.println("The person is equal to employees.");
        } else {
            System.out.println("The person is not equal to employees.");
        }
        
        
        // test the employees
        int[] adv = new int[3];
        adv[0] = 2;
        adv[1] = 3;
        adv[2] = 4;
        person.setAdvisors(adv); 
        {
            System.out.println("---------------------------------------------------");
            System.out.println(person);
            System.out.print(employee);
        }
	} //end main
} // end class
