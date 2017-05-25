package codejam;
import java.util.*;
public class codejam2 {
public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	for(int i=0 ;i<n;i++){
		String s=sc.next();
		int l=sc.nextInt(),count=0;
		ArrayList<Character> list= new ArrayList<Character>();
		for(int k=0;k<s.length();k++)
			list.add((Character)s.charAt(k));
		while(list!=null ){		
		while(list.get(0)=='+' && list.size()>1)
			list.remove(0);
		if(list.get(0)=='+')list.remove(0);
		if(list.size()==0 || l>list.size())
			break;
		else
			for(int k=0;k<l;k++){
			if(list.get(k)=='+')
				list.set(k,'-');
			else 	list.set(k,'+');
		}
			count++;
	}	 //System.out.println(list);		
	if(list.size()!=0)
System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");	
	else if(list.size()==0)
	 System.out.println("Case #"+(i+1)+": "+count);
	}
	sc.close();
}
}