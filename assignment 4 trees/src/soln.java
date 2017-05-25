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
          System.out.println(num);
      //if((int)(Integer.valueOf(num))%8==0) 
          //System.out.println(num);
      count++; 
     } 
     System.out.println(count); 
 }   
    public static void main(String[] args) {
     String set[] = {"9","6","8"}; 
        printSubsets(set);
 }    
}