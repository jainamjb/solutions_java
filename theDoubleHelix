//solution to the problem defined at SPOJ link : http://www.spoj.com/problems/ANARC05B/
//THE DOUBLE HELIX
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		while(true){
		    int n1=0,n2=0;
		    n1=sc.nextInt();
		    if(n1==0) break;
		    int[] a = new int[n1];
		    for(int i=0;i<n1;i++)
		    a[i]=sc.nextInt();
		    n2=sc.nextInt();
		    int[] b = new int[n2];
		    for(int i=0;i<n2;i++)
		    b[i]=sc.nextInt();
		    int h1=0;
		    if(n1 >= n2)  h1 = n1 ;else h1 =n2;
		    int[] h = new int[h1];
		    int i=0,j=0,k=0;
		    //for( i=0;i<n1;i++)System.out.print(a[i]);System.out.println();for(i=0;i<n2;i++)System.out.print(b[i]);
		    while(i<n1 && j <n2){
		        //System.out.println(h[k]+"i:"+i+"j:"+j);
		        if(a[i]==b[j])
		           { h[k]=a[i];k++;}
		        if(a[i]<b[j])
		        i++;
		        else j++;
		    }
		   // for( i=0;i<k;i++)System.out.print(h[i]+" ");System.out.println();
		    int sum1=0,sum2=0,sum=0,p=0;
		    i=0;j=0;
		    while(p<k){
		        sum1=0;sum2=0;
		        while(a[i]!=h[p]){
		            sum1+=a[i];
		            i++;
		        }
		        while(b[j]!=h[p]){
		            sum2+=b[j];
		            j++;
		        }
		        //System.out.print("sum1:"+sum1+" sum2:"+sum2);System.out.println();
		        if(sum1 >= sum2)  sum += sum1 ;else sum +=sum2;
		        p++;
		        //System.out.print("sum1:"+sum1+" sum2:"+sum2+"sum:"+sum);System.out.println();
		    }
		    sum1=0;sum2=0;
		    while(i<n1)
		   { sum1+=a[i];i++;}
		    while(j<n2)
		    {sum2+=b[j];j++;}
		    if(sum1 >= sum2)  sum += sum1 ;else sum +=sum2;
		    System.out.println(sum);
		}
	}
}
