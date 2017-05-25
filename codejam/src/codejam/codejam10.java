package codejam;
import java.util.Scanner;

public class codejam10 {
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
			String st="";
			String s=sc.next();
				if(is_inc(Long.parseLong(s)))
				{	System.out.println("Case #"+(i+1)+": "+Long.parseLong(s));
				}
				else{
					int drop=0,k=0;
					for(k=0;k<s.length();k++){
						char c=s.charAt(k);
						if(c>s.charAt(k+1)){
							c=s.charAt(k);
							drop=k;
							break;
						}
					}
					//System.out.println(drop+" "+k);
					while(drop>0){
						if(s.charAt(drop-1)==s.charAt(k))
						drop--;
						else break;
					}
					//System.out.println(drop);
				for(int t =0;t<drop;t++)
				st=st+s.charAt(t);
				//System.out.println((char)((s.charAt(drop))-1));
				st=st+(char)((s.charAt(drop))-1);
				for(int t=drop+1;t<s.length();t++)
					st=st+'9';
					System.out.println("Case #"+(i+1)+": "+Long.parseLong(st));
				}
		}
		sc.close();
	}
}