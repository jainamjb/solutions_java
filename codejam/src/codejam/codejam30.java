/* package codechef; // don't place package name! */
package codejam;
import java.util.*;
/* Name of the class has to be "Main" only if the class is public. */
class codejam30
{
	public static int min(int a,int b){
		if(a>b)
			return b;
		else return a;
	}
	public static	int max(int a,int b){
		if(a<b)
			return b;
		else return a;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
	    	    int t=sc.nextInt();
	    	    for(int l=0;l<t;l++){
	    	        int n=sc.nextInt();
	    	        int k=sc.nextInt();
		    	    int n1=n,n2=n;
		    	    int x=k,count=0;
		    	    while(x>0){
		    	    	count++;
		    	    	x=x/2;
		    	    }
		    	    //System.out.println(count);
for(int i=0;i<count;i++){
    if(n%2==0)
    {
    n1=(n)/2 -1;
    n2=(n)/2-1;
    n=n/2;
    }
    else{
    n1=(n)/2 +1;
    n2=(n)/2 ;
    n=(n)/2-1;
}
    n1=max(n1,n2);
    n2=min(n1,n2);
}	
if(n1<0)n1=0;
if(n2<0)n2=0;
	    System.out.println("Case #"+(l+1)+": "+n1+" "+n2);
	}
	sc.close();    	    
	}
}
