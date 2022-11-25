// Lab9 - Jingru Dou - 4 November 2021 - recursive method practices

import java.util.ArrayList;
import java.util.Arrays;

class Towers {
   private int rings;
   private int[] pegs;
   public Towers(int rings){
      this.rings=rings;
      this.pegs=new int[3];
      for(int i=0;i<pegs.length;++i){
         this.pegs[i]=0;
      }
      this.pegs[0]=rings;
   } 


   public int countRings(int pegNumber){
      return this.pegs[pegNumber-1];
   }

   public void setTopDiameter(int pegNumber,int rings){
      this.pegs[pegNumber-1]=rings;
   }

   public int getTopDiameter(int pegNumber){
      return this.pegs[pegNumber-1];
   }

   public void move(int start,int end){
      System.out.println("move [ring "+this.getTopDiameter(start) +"] from "+start+" to "+end);
   }

   public static void Hanoi(int topN, int from, int to,int inter) {
      if (topN == 1) {
         System.out.println("Disk 1 from " + from + " to " + to);
      } else {
         Hanoi(topN - 1, from, inter,to);
         System.out.println("Disk " + topN + " from " + from + " to " + to);
         Hanoi(topN - 1, inter, to,from);
      }
   }
   
   public static void Hanoi(Towers t,int n,int start,int target,int spare) {
      if(n==1){
         t.setTopDiameter(start,n);
         t.move(start,target);
      } else {
         Hanoi(t,n-1,start,spare,target);
         t.setTopDiameter(start,n);
         t.move(start,target);
         Hanoi(t,n-1,spare,target,start);
      }
   }
} // end class tower

public class RecursiveQuestion {
   public static Integer convert(String str) {
      if (str.isEmpty()) {
         return 0;
      } else {
         Integer ans = (int) ((str.charAt(0) - '0') * Math.pow(10, str.length() - 1));
         return ans + convert(str.substring(1));
      }
   } // end convert method

   public static int FibBinaryRecursive(int k){
      if(k<=0){
         return 0;
      }else if(k==1){
         return 1;
      }
      return FibBinaryRecursive(k-1)+FibBinaryRecursive(k-2);
   }// end FibBinaryRecursive
   
   public static void permutation(int[] buf,int start,int end) {
      if (start == end) {
         for (int c : buf) {
            System.out.print(c+" ");
         }
         System.out.println();
      } else {
         for (int i = start; i <= end; i++) {
            int temp = buf[start];
            buf[start] = buf[i];
            buf[i] = temp;
            permutation(buf, start + 1, end);
            temp = buf[start];
            buf[start] = buf[i];
            buf[i] = temp;
          }
      }
   }// end permutation


   public static void main(String[] args) {
      // test Q1 convert
      System.out.println("convert(\"1234\"): " + convert("1234"));
      System.out.println("convert(\"1234566\"): " + convert("1234566"));
        
      // test Q2 Fibonacci
      System.out.println("Fib(12) = " + FibBinaryRecursive(12));
      System.out.println("Fib(13) = " + FibBinaryRecursive(13));
        
      // test Q6 pow
      System.out.println("pow(2,5) = "+pow(2,5));
      System.out.println("pow(2,6) = "+pow(2,6));
        
      // test Q5 reverse
      {
         char[] arr = new char[]{'A', 'B', 'C', 'D', 'E'};
         System.out.println("before reverse array:" + Arrays.toString(arr));
         reverse(arr, 1, 4);
         System.out.println("reversed array:" + Arrays.toString(arr));
      }// end test Q5
        
      // test Q3 HanoiTower
      Towers t=new Towers(3);
      Towers.Hanoi(t,3,1,3,2);
        
      // test Q4 permutation
      {
         ArrayList<Integer> arr = new ArrayList<>();
         arr.add(1);
         arr.add(2);
         arr.add(5);
         //arr.add(10); // if uncomment this will go infinte
         for (Integer length : arr) {
            System.out.println("detect the length of " + length);
            int[] nums = new int[length];
            for (int i = 0; i < nums.length; ++i) {
               nums[i] = i + 1;
            }
            permutation(nums, 0, nums.length - 1);
            System.out.println("detect the length of " + length + "   finished");

          }
       } // end test Q4
    } // end main

    public static double pow(double x,int n) {
        if (x == 0 && n <= 0) {
            throw new IllegalArgumentException("x is zero and n=" + n);
        } else if (x == 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            if (n > 0) {
                double ans = pow(x, n / 2);
                if (n % 2 == 0) {
                    return ans * ans;
                } else {
                    return x * ans * ans;
                }
            } else {
                return 1.0 / pow(x, -n);
            }
        }
    } // end pow

    public static void reverse(char[] arr, int left, int right) {
        if (left < right) {
            char ch = arr[left];
            arr[left] = arr[right];
            arr[right] = ch;
            reverse(arr, left + 1, right - 1);
        }
    } // end reverse

} // end class
