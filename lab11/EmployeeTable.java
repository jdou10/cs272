// Dou Jingru
// CS 272
// Lab 11
// 30 Novemeber 2021

import java.util.ArrayList;

public class EmployeeTable {

   private final ArrayList<Employee> employees;
   private int count;
   public EmployeeTable() {
      this.employees = new ArrayList<>();
      for (int i = 0; i < 32; ++i) {
         this.employees.add(null);
      }
      this.count=0;
   }

   public void put(Employee e) {
      int index = e.getNo() % this.employees.size();
      if(this.count >= this.employees.size()){
         System.out.println("The current table is full");
         return;
      }
      while(true){
         if(this.employees.get(index) != null){
            index = (index + 1) % this.employees.size();
         }else{
            this.employees.set(index, e);
            this.count++;
            break;
         }
      }
   }

   public boolean remove(int emp_no) {
      int index = emp_no % this.employees.size();
      int pos = index;
      while(true){
         if(this.employees.get(index) != null && (this.employees.get(index).getNo() != emp_no)){
            index = (index + 1) % this.employees.size();
         }else{
            break;
         }
         if(pos == index){
                return false;
         }
      }
      if(this.employees.get(index) != null) {
         this.employees.set(index, null);
         for(int i = 0; i < this.employees.size(); ++i){
            if(this.employees.get(i) == null){
               continue;
            }
            int hash_value = this.employees.get(i).getNo() % this.employees.size();
            if(hash_value != i) {
               int j = i;
               while (this.employees.get(j) != null) {
                  j = (j + 1) % this.employees.size();
               }
               this.employees.set(j, this.employees.get(i));
               this.employees.set(i, null);
            }
         }
         return true;
      }else{
         return false;
      }
   } // end remove

   public int search(int emp_no) {
      int index = emp_no % this.employees.size();
      while (this.employees.get(index) != null) {
         if (this.employees.get(index).getNo() == emp_no) {
            return index;
         }
         index = (index + 1) % this.employees.size();
      }
         return -1;
   } // end search

   public static void main(String[] args) {
      Employee e1 = new Employee();
      e1.setNo(1);
      Employee e2 = new Employee();
      e2.setNo(2);
      Employee e3 = new Employee();
      e1.setNo(3);
      Employee e4 = new Employee();
      e2.setNo(4);
      Employee e5 = new Employee();
      e2.setNo(5);
      EmployeeTable table = new EmployeeTable();
      table.put(e1);
      table.put(e2);
      table.put(e3);
      table.put(e4);
      table.put(e5);
      int idx=table.search(3);
      System.out.println("The index employee in the hash table is: " + idx);
      boolean flag = table.remove(3);
      if (flag) {
         System.out.println("Remove succeed");
      }
   } // end main
} //end class
