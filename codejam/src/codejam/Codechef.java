 package codejam; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) 
	{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int m=1;
Set<Integer> set = new HashSet<Integer>();
for(int l=0;l<10;l++)
{
	set.add(l);
}
Set<Integer> set1 = new HashSet<Integer>();
for(int i=0;i<n;i++){
int x=sc.nextInt();
int p=x;
m=1;
set1.removeAll(set1);
while(!set1.containsAll(set) && x!=0){
	
	if(p/10==0){
		set1.add(p);
		//System.out.println(set1);

	}
	else{
		while(p!=0){
			set1.add(p%10);
			//System.out.println(set1);
			p=p/10;
		}
	}
	m++;
	p=x*m;
	//System.out.println(p);
}
m--;
p=x*m;
if(x==0)
System.out.println("Case #"+(i+1)+": "+"INSOMNIA");
else
System.out.println("Case #"+(i+1)+": "+p);

}
	    
	}
}
