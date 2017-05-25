package codejam;
import java.util.Scanner;

public class codejam1 {
	public static boolean is_inc(long n)
	{
	    // Deal with negative inputs...
			if (n < 0)
	        n = -n;
	    long prev = 10; // always greater than any digit
	    long curr;

	    while (n > 0) {
	        curr = n % 10;
	        if (prev < curr)
	            return false;
	        prev = curr;
	        n /= 10;
	    }
	    return true;
	}
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner (System.in);
		long n=sc.nextLong();
		for(int i=0;i<n;i++){
long m=sc.nextLong();
for(long j=m;j>0;j--){
	//System.out.println(j);
if(is_inc(j)){
	System.out.println("Case #"+(i+1)+": "+j);
	break;}
}
		}
		sc.close();
	}
}