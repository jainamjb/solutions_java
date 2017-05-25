package hashing;
import java.util.*;
public class hash_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	    Hashtable<Integer,String> phone_list = new Hashtable<Integer,String>();
		Scanner sc=new Scanner(System.in);
		Double n=new Double(sc.nextDouble());
		while(n>=0){
			String fun=sc.next();
			if(fun.equals("add"))
			{
				phone_list.put(sc.nextInt(), sc.next());
			}
			if(fun.equals("del"))
			{
				phone_list.remove(sc.nextInt());
			}
			if(fun.equals("find"))
			{
				Integer key=new Integer(sc.nextInt());
				if(phone_list.containsKey(key)){
					System.out.println(phone_list.get(key));
				}
				else
					System.out.println("not found");
			}
			n--;
		}
		sc.close();
	}

}
