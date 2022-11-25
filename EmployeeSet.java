//package CS272program.src;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class EmployeeSet {
    private int index;
    private Employee[] data;


    public EmployeeSet(){
        this.index =0;
        final int INITIAL_CAPACITY=10;
        this.data =new Employee[INITIAL_CAPACITY];
    }

    public EmployeeSet(Object obj){
        if(obj instanceof EmployeeSet){
            EmployeeSet loc=(EmployeeSet) obj;
            this.index =loc.index;
            this.data=new Employee[loc.data.length];
            for(int i=0;i<this.data.length;++i){
                this.data[i]=loc.data[i];
            }
        }
    }

    public int size(){
        return this.index;
    }

    public int capacity(){
        return this.data.length;
    }

    public void add(Employee employee){
        for(int i = 0; i<this.size(); ++i){
            if(this.data[i].equals(employee)){
                return;
            }
        }
        if(this.capacity()<=this.size()){
            int minimum_capacity=2*this.capacity();
            this.ensureCapacity(minimum_capacity);
        }
        this.data[this.index++]=employee;
    }


    private void ensureCapacity(int minimumCapacity){
        int capacity=Math.max(minimumCapacity,this.capacity());
        if(capacity==this.capacity()){
            return;
        }
        Employee[] employees=new Employee[this.size()];
        for(int i=0;i<this.size();++i){
            employees[i]=this.data[i];
        }
        this.data =new Employee[capacity];
        for(int i=0;i<this.size();++i){
            this.data[i]=employees[i];
        }
    }

    public boolean remove(int eno){
        for(int i=0;i<this.size();++i){
            if(this.data[i].getNo()==eno) {
                if (this.size() - 1 - i >= 0) {
                    System.arraycopy(this.data, i + 1, this.data, i, this.size() - 1 - i);
                }
                this.data[this.size() - 1] = null;
                this.index -= 1;
                return true;
            }
        }
        return false;
    }

    public boolean contains(int eno){
        for(int i=0;i<this.size();++i){
            if(this.data[i].getNo()==eno){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        try {
            EmployeeSet employeeSet=new EmployeeSet();
            BufferedReader csv = new BufferedReader(new InputStreamReader(new FileInputStream("core_dataset.csv"), StandardCharsets.UTF_8));
            boolean is_first_row=true;
            while(true){
                String line=csv.readLine();
                if(line==null){
                    break;
                }
                if(is_first_row){
                    //read headers and skip
                    is_first_row=false;
                }else {
                    String[] cols = line.split(",");
                    Employee employee = new Employee();
                    employee.setName(cols[0] + ", " + cols[1]);
                    employee.setNo(Integer.parseInt(cols[2]));
                    employee.setState(cols[3]);
                    employee.setZip_code(Integer.parseInt(cols[4]));
                    employee.setAge(Integer.parseInt(cols[5]));
                    employeeSet.add(employee);
                }
            }
            System.out.println("employee set's size:"+employeeSet.size()+" capacity:"+employeeSet.capacity());
            EmployeeSet copy_set=new EmployeeSet(employeeSet);
            System.out.println("copy employee set' size:"+copy_set.size()+" capacity:"+copy_set.capacity());
            final int check_no=1404066622;
            if(employeeSet.contains(check_no)){
                System.out.println("employee[no:"+check_no+ "] is exist");
            }else{
                System.out.println("employee[no:"+check_no+ "] is not exist");
            }
            if(employeeSet.remove(check_no)){
                System.out.println("remove employee from employee set "+check_no+" success");
                System.out.println("after remove the current employee set's size:"+employeeSet.size()+" capacity:"+employeeSet.capacity());

            }else{
                System.out.println("remove employee from employee set "+check_no+" failed");
            }
            if(employeeSet.contains(check_no)){
                System.out.println("employee[no:"+check_no+ "] is exist");
            }else{
                System.out.println("employee[no:"+check_no+ "] is not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
