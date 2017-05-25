import java.util.*;

  public class  major {
      public int majorityElement(int[] num) {
          int n = num.length;
          int candidate = num[0], counter = 0;
          for (int i : num) {
              if (counter == 0) {
                  candidate = i;
                  counter = 1;
             } else if (candidate == i) {
                 counter++;
             } else {
                 counter--;
             }
         }
 
         counter = 0;
         for (int i : num) {
             if (i == candidate) counter++;
         }
         if (counter <= n / 2) return 0;
         return 1;
 
     }
     public static void main(String[] args) {
         major s = new major();
         int n;
         Scanner sc= new Scanner(System.in);
         n=sc.nextInt();
         int[] arr = new int[n];
         for(int i=0;i<n;i++)
        	 arr[i]=sc.nextInt();
         System.out.format("%d\n", s.majorityElement(arr));
     }
 }