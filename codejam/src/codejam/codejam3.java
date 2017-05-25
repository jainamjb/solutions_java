package codejam;

import java.util.Scanner;

public class codejam3 { 
     
    public static int nextStall(boolean[] stalls) { 
        int longestIndex = -1; 
        int longestRun = 0; 
        int currentIndex = -1; 
        int currentRun = 0; 
        boolean inRun = false;
        for (int i = 0; i < stalls.length; i++) { 
            if (inRun && stalls[i]) { 
                inRun = false; 
                if (currentRun >= longestRun) { 
                    longestRun = currentRun; 
                    longestIndex = currentIndex; 
                } 
                 
            } 
            else if (!inRun && !stalls[i]) { 
                inRun = true; 
                currentIndex = i; 
                currentRun = 1; 
            } 
            else if (inRun && !stalls[i]) { 
                currentRun += 1; 
            } 
        } 
        if (inRun) { 
            if (currentRun >= longestRun) { 
                longestRun = currentRun; 
                longestIndex = currentIndex; 
            } 
        } 
        return (longestRun - 1) / 2 + longestIndex; 
    } 
     
    public static void printStalls(boolean[] stalls) { 
        for (int i = 0; i < stalls.length; i++) { 
            if (stalls[i]) { 
                System.out.print("X "); 
            } 
            else { 
                System.out.print("_ "); 
            } 
        } 
        System.out.println(); 
    } 
     
    public static void main(String[] args) { 
    	Scanner sc =new Scanner(System.in);
    	int n=sc.nextInt();
        for(int l=0;l<n;l++){
        	int snum=sc.nextInt();
        	int k=sc.nextInt();
            boolean[] stalls = new boolean[snum]; 
        	for (int i = 0; i < k; i++) { 
            stalls[nextStall(stalls)] = true; 
            //printStalls(stalls);
            
        }
    
    }
        }
}