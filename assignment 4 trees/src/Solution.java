import java.io.*;
import java.util.*;

public class Solution {

 static void printSubsets(String set[])
 {
     int n = set.length;
      int count=0; 
     for (int i = 0; i < (1<<n); i++)
     { 
         String num=""; 
      for (int j = 0; j < n; j++) 
          if ((i & (1 << j)) > 0)
          num=num+set[j];
          //System.out.println(num);
         if(num!="")
      if((int)(Integer.parseInt(num))%8==0) 
          //System.out.println(num);
      count++; 
     } 
     System.out.println(count%(1000000000+7)); 
 }   
    public static void main(String[] args) {
    	 Scanner sc=new Scanner(System.in);
    	 int n=sc.nextInt();
    	 String[] set = new String[n];
    	 int num=sc.nextInt();
    	 int i=n;
for(i=n-1;i>=0;i--){
	set[i]=String.valueOf(num%10);
	num=num/10;
}
            printSubsets(set);
 }    
}