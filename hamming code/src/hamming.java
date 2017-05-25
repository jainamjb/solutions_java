//jainam bagrecha
import java.util.*;
public class hamming {
public static void main(String []args){
Scanner sc=new Scanner(System.in);
int n=0;
System.out.println("Enter the number of bits");
n=sc.nextInt();
int[] input= new int[n];
//int[] output= new int[n];
System.out.println("Enter the input of bits");
for(int i=0;i<n;i++)
input[i]=sc.nextInt();
int count=0,k=0;
for(int j=n;j>0;j/=2)
count++;
if((n+count)%4==0)
    count++;

Double d=Math.floor(Math.log(n)/Math.log(2))+1;
System.out.println(d);

System.out.println(count);
int[] mid=new int[n+count];
int[] mid1=new int[n+count];
int p=0;
for(int i=0;i<n+count;i++)
{
if(i==pow(2,p)-1)
{
mid[i]=9;
p++;
}else
{
mid[i]=input[k];
k++;
}
}
//System.out.println(parity(mid,0));
//System.out.println(parity(mid,1));
//System.out.println(parity(mid,2));
//System.out.println(parity(mid,3));
for(int i=0;i<count;i++){
mid[pow(2,i)-1]=parity(mid,i);
}
for(int i=0;i<n+count;i++)
    if(mid[i]==9)
        mid[i]=0;
for(int i=0;i<n+count;i++)
System.out.print(mid[i]);
System.out.println("\nEnter the "+(n+count)+" received output of bits");
for(int i=0;i<n+count;i++)
mid1[i]=sc.nextInt();
int result=0;
for(int i=0;i<count;i++){
mid1[pow(2,i)-1]=parity(mid1,i);
//System.out.println("parity:"+mid1[pow(2,i)-1]+" ");
if(mid[pow(2,i)-1]!=mid1[pow(2,i)-1])
result+=pow(2,i);
}
System.out.println("The incorrect bit is at position  "+result);

sc.close();
}
static int parity (int[] arr,int y){
int x=0;
for(int i=pow(2,y)-1;i<arr.length;i+=pow(2,y))
{
for(int j=0;j<pow(2,y) && i<arr.length;j++){
if(i!=pow(2,y)-1)
x=x^arr[i];
//    System.out.print(x);
i++;
}
//System.out.println();
}
return x;    
}
static int pow (int a, int b)
{
    if ( b == 0)        return 1;
    if ( b == 1)        return a;
    if (b%2==0)    return     pow ( a * a, b/2); //even a=(a^2)^b/2
    else                return a * pow ( a * a, b/2); //odd  a=a*(a^2)^b/2
}
}